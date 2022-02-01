package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.ReqStoryPic;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.wstt.SSCM.SSCM;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;

public class StoryUploadProcessor
  extends BaseUploadProcessor
{
  public static String TAG = "Q.qqstory.publish.upload.StoryUploadProcessor";
  private Runnable mDelayRunnable;
  private Handler mHandler;
  public String mPhotoUrl;
  private byte[] mSessionKey;
  private byte[] mSigSession;
  private long mStartUploadTime;
  private long mStartWaitTime;
  private String mTag = "Q.qqstory.publish.upload";
  public String mVid;
  public String mVideoUrl;
  private Transaction trans = null;
  
  public StoryUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.processor = this;
    this.file.bdhExtendInfo = paramTransferRequest.mExtentionInfo;
    this.mStartWaitTime = System.currentTimeMillis();
    TAG = this.mTag + ".StoryUploadProcessor";
  }
  
  public static void checkUploadSessionKey()
  {
    Bosses.get().postLightWeightJob(new StoryUploadProcessor.2(), 0);
  }
  
  private String getSdcardInfo()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a()), Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.a(QQStoryConstant.e)) });
  }
  
  public static int makeStoryErrorCoder(int paramInt)
  {
    return 95000000 + paramInt;
  }
  
  private int thisFileRemoveByOtherSoftWareErrorCode(String paramString)
  {
    String str = com.tencent.biz.qqstory.utils.FileUtils.a(paramString);
    long l1 = 0L;
    try
    {
      l2 = Long.valueOf(str.substring(0, str.indexOf("_"))).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.c(TAG, "exception", localException);
      }
      if (l1 <= 0L) {
        break label173;
      }
      long l2 = (System.currentTimeMillis() - l1) / 24L / 60L / 60L / 1000L;
      l1 = l2;
      if (l2 <= 30L) {
        break label166;
      }
      l1 = 30L;
      return (int)(l1 + 999000L);
    }
    l2 = com.tencent.biz.qqstory.utils.FileUtils.b(QQStoryConstant.e);
    SLog.e(TAG, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 == 0L) || ((l1 > 0L) && (l2 > l1)))
    {
      SLog.e(TAG, "your file delete by software %s", new Object[] { paramString });
      return 940017;
    }
    label166:
    label173:
    return 9071;
  }
  
  public void cancelTask()
  {
    if (this.trans != null) {
      this.app.getHwEngine().cancelTransactionTask(this.trans);
    }
  }
  
  public int checkParam()
  {
    String str = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty(str))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      setError(thisFileRemoveByOtherSoftWareErrorCode(str), getSdcardInfo() + "sendFile not exist " + str);
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.file.fileSize = l;
    this.mFileSize = l;
    SLog.a(TAG, "upload file size %d, file %s", Long.valueOf(this.mFileSize), str);
    if (l <= 0L)
    {
      setError(thisFileRemoveByOtherSoftWareErrorCode(str), getSdcardInfo() + "sendFile size empty " + str);
      onError();
      return -1;
    }
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {
      break label14;
    }
    label14:
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    label59:
    String str;
    label84:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      if (this.file.fileType != 196610) {
        break label228;
      }
      str = "actStoryPicUpload";
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mReportInfo.put("param_sessionKey", "null");
      if (!paramBoolean) {
        break label301;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, l, this.mFileSize, this.mReportInfo, "");
      if (this.file.fileType != 196609) {
        break label249;
      }
      StoryReportor.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.mVideoUrl });
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break label59;
      label228:
      if (this.file.fileType != 196609) {
        break;
      }
      str = "actStoryVideoUpload";
      break label84;
      label249:
      StoryReportor.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()) });
      continue;
      label301:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, false, l, this.mFileSize, this.mReportInfo, "");
      if (this.file.fileType == 196609) {
        StoryReportor.b("publish_story", "publish_video", 0, makeStoryErrorCoder(this.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.errDesc });
      } else {
        StoryReportor.b("publish_story", "publish_thumbnail", 0, makeStoryErrorCoder(this.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.errDesc });
      }
    }
  }
  
  protected long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {}
    for (paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return super.getStreamData(paramInt1, paramInt2);
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    SLog.d(TAG, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.errCode), this.errDesc, this.mUiRequest.mLocalPath });
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = makeStoryErrorCoder(this.errCode);
      localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
  }
  
  void onSuccess()
  {
    super.onSuccess();
    sendMessageToUpdate(1003);
    SLog.d(TAG, "success path:%s", new Object[] { this.mUiRequest.mLocalPath });
    UpCallBack.SendResult localSendResult;
    if (this.mUiRequest.mUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      if (this.file.fileType != 196610) {
        break label92;
      }
    }
    for (localSendResult.jdField_b_of_type_JavaLangString = this.mPhotoUrl;; localSendResult.jdField_b_of_type_JavaLangString = this.mVideoUrl)
    {
      this.mUiRequest.mUpCallBack.b(localSendResult);
      return;
      label92:
      localSendResult.c = this.mVid;
    }
  }
  
  public int resume()
  {
    cancelTask();
    return 0;
  }
  
  public void sendFile()
  {
    SLog.d(TAG, "send file %s", new Object[] { this.mUiRequest.mLocalPath });
    this.mStepTrans.logStartTime();
    StoryUploadProcessor.1 local1 = new StoryUploadProcessor.1(this, SystemClock.uptimeMillis());
    int i = -1;
    if (this.file.fileType == 196610)
    {
      i = 34;
      qqstory_bhd_upload_pic.ReqStoryPic localReqStoryPic = new qqstory_bhd_upload_pic.ReqStoryPic();
      localReqStoryPic.platform.set(2);
      localReqStoryPic.tojpg.set(0);
      localReqStoryPic.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
      this.file.bdhExtendInfo = localReqStoryPic.toByteArray();
    }
    for (;;)
    {
      this.file.commandId = i;
      try
      {
        if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
          this.mSigSession = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSigSession, 0, j);
        }
        if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey().length;
          this.mSessionKey = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey(), 0, this.mSessionKey, 0, j);
        }
        if ((this.mSigSession == null) || (this.mSigSession.length == 0) || (this.mSessionKey == null) || (this.mSessionKey.length == 0)) {
          HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
        }
        this.trans = new Transaction(this.app.getCurrentAccountUin(), i, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, this.file.bdhExtendInfo, false);
        this.trans.setVideoSegmentMode(true);
        int j = this.app.getHwEngine().submitTransactionTask(this.trans);
        SLog.c(TAG, "Transaction submit RetCode:" + j + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + i);
        if (j != 0)
        {
          setError(j, "SubmitError.", "", this.mStepTrans);
          onError();
        }
        return;
      }
      finally {}
      if (this.file.fileType == 196609) {
        i = 37;
      } else if (this.file.fileType == 327681) {
        i = 57;
      }
    }
  }
  
  public void start()
  {
    super.start();
    SLog.d(TAG, "start upload %s", new Object[] { this.mUiRequest.mLocalPath });
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      setError(940006, "make md5 fail");
      onError();
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().a()))
    {
      setError(880001, "no network");
      onError();
      return;
    }
    sendFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StoryUploadProcessor
 * JD-Core Version:    0.7.0.1
 */