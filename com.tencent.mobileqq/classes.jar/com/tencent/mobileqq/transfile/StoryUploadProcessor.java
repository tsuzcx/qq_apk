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
import com.tencent.mobileqq.highway.api.ITransactionCallback;
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
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
    paramBaseTransFileController = new StringBuilder();
    paramBaseTransFileController.append(this.mTag);
    paramBaseTransFileController.append(".StoryUploadProcessor");
    TAG = paramBaseTransFileController.toString();
  }
  
  public static void checkUploadSessionKey()
  {
    Bosses.get().postLightWeightJob(new StoryUploadProcessor.2(), 0);
  }
  
  private String getSdcardInfo()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.b()), Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.fileExists(QQStoryConstant.g)) });
  }
  
  public static int makeStoryErrorCoder(int paramInt)
  {
    return paramInt + 95000000;
  }
  
  private int thisFileRemoveByOtherSoftWareErrorCode(String paramString)
  {
    String str = com.tencent.biz.qqstory.utils.FileUtils.f(paramString);
    long l1;
    try
    {
      l1 = Long.valueOf(str.substring(0, str.indexOf("_"))).longValue();
    }
    catch (Exception localException)
    {
      SLog.c(TAG, "exception", localException);
      l1 = 0L;
    }
    long l2 = com.tencent.biz.qqstory.utils.FileUtils.h(QQStoryConstant.g);
    SLog.e(TAG, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 != 0L) && ((l1 <= 0L) || (l2 <= l1)))
    {
      if (l1 > 0L)
      {
        l2 = (System.currentTimeMillis() - l1) / 24L / 60L / 60L / 1000L;
        l1 = l2;
        if (l2 > 30L) {
          l1 = 30L;
        }
        return (int)(l1 + 999000L);
      }
      return 9071;
    }
    SLog.e(TAG, "your file delete by software %s", new Object[] { paramString });
    return 940017;
  }
  
  public void cancelTask()
  {
    if (this.trans != null) {
      this.app.getHwEngine().cancelTransactionTask(this.trans);
    }
  }
  
  public int checkParam()
  {
    Object localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = new File((String)localObject1);
    int i;
    StringBuilder localStringBuilder;
    if (!((File)localObject2).exists())
    {
      localObject2 = this.mProcessorReport;
      i = thisFileRemoveByOtherSoftWareErrorCode((String)localObject1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getSdcardInfo());
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(i, localStringBuilder.toString(), null, null);
      onError();
      return -1;
    }
    if (!((File)localObject2).canRead())
    {
      localObject1 = this.mProcessorReport;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendFile not readable ");
      ((StringBuilder)localObject2).append(this.file.filePath);
      ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
      onError();
      return -1;
    }
    long l = ((File)localObject2).length();
    this.file.fileSize = l;
    this.mFileSize = l;
    SLog.a(TAG, "upload file size %d, file %s", Long.valueOf(this.mFileSize), localObject1);
    if (l <= 0L)
    {
      localObject2 = this.mProcessorReport;
      i = thisFileRemoveByOtherSoftWareErrorCode((String)localObject1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getSdcardInfo());
      localStringBuilder.append("sendFile size empty ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(i, localStringBuilder.toString(), null, null);
      onError();
      return -1;
    }
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject).mReportedFlag = (j | i);
      if (this.file.fileType == 196610) {}
      for (localObject = "actStoryPicUpload";; localObject = "actStoryVideoUpload")
      {
        break;
        if (this.file.fileType != 196609) {
          return;
        }
      }
      this.mProcessorReport.mEndTime = System.currentTimeMillis();
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      this.mProcessorReport.mReportInfo.put("param_sessionKey", "null");
      if (paramBoolean)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        if (this.file.fileType == 196609) {
          StoryReportor.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mProcessorReport.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.mVideoUrl });
        } else {
          StoryReportor.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mProcessorReport.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()) });
        }
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        if (this.file.fileType == 196609) {
          StoryReportor.b("publish_story", "publish_video", 0, makeStoryErrorCoder(this.mProcessorReport.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mProcessorReport.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.mProcessorReport.errDesc });
        } else {
          StoryReportor.b("publish_story", "publish_thumbnail", 0, makeStoryErrorCoder(this.mProcessorReport.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mProcessorReport.mEndTime - this.mStartUploadTime), StoryReportor.a(BaseApplication.getContext()), this.mProcessorReport.errDesc });
        }
      }
      setReportFlag();
    }
  }
  
  protected long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {
      paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
    } else {
      paramLong = Math.min(paramLong, 14600L);
    }
    return Math.min(paramLong, 131072L);
  }
  
  byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return super.getStreamData(paramInt1, paramInt2);
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    SLog.d(TAG, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.mProcessorReport.errCode), this.mProcessorReport.errDesc, this.mUiRequest.mLocalPath });
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      localSendResult.b = makeStoryErrorCoder(this.mProcessorReport.errCode);
      localSendResult.c = this.mProcessorReport.errDesc;
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
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = 0;
      if (this.file.fileType == 196610)
      {
        localSendResult.d = this.mPhotoUrl;
      }
      else
      {
        localSendResult.f = this.mVid;
        localSendResult.d = this.mVideoUrl;
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
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
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject1 = new StoryUploadProcessor.1(this, SystemClock.uptimeMillis());
    int i;
    Object localObject3;
    if (this.file.fileType == 196610)
    {
      i = 34;
      localObject3 = new qqstory_bhd_upload_pic.ReqStoryPic();
      ((qqstory_bhd_upload_pic.ReqStoryPic)localObject3).platform.set(2);
      ((qqstory_bhd_upload_pic.ReqStoryPic)localObject3).tojpg.set(0);
      ((qqstory_bhd_upload_pic.ReqStoryPic)localObject3).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
      this.file.bdhExtendInfo = ((qqstory_bhd_upload_pic.ReqStoryPic)localObject3).toByteArray();
    }
    else if (this.file.fileType == 196609)
    {
      i = 37;
    }
    else if (this.file.fileType == 327681)
    {
      i = 57;
    }
    else
    {
      i = -1;
    }
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
      localObject3 = this.mSigSession;
      if ((localObject3 != null) && (localObject3.length != 0))
      {
        localObject3 = this.mSessionKey;
        if ((localObject3 != null) && (localObject3.length != 0)) {}
      }
      else
      {
        HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
      }
      this.trans = new Transaction(this.app.getCurrentAccountUin(), i, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject1, this.file.bdhExtendInfo, false);
      this.trans.setVideoSegmentMode(true);
      int j = this.app.getHwEngine().submitTransactionTask(this.trans);
      localObject1 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Transaction submit RetCode:");
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(" T_ID:");
      ((StringBuilder)localObject3).append(this.trans.getTransationId());
      ((StringBuilder)localObject3).append(" UniSeq:");
      ((StringBuilder)localObject3).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject3).append(" MD5:");
      ((StringBuilder)localObject3).append(this.mMd5Str);
      ((StringBuilder)localObject3).append(" uuid:");
      ((StringBuilder)localObject3).append(this.mUuid);
      ((StringBuilder)localObject3).append(" Path:");
      ((StringBuilder)localObject3).append(this.trans.filePath);
      ((StringBuilder)localObject3).append(" Cmd:");
      ((StringBuilder)localObject3).append(i);
      SLog.c((String)localObject1, ((StringBuilder)localObject3).toString());
      if (j != 0)
      {
        this.mProcessorReport.setError(j, "SubmitError.", "", this.mProcessorReport.mStepTrans);
        onError();
      }
      return;
    }
    finally {}
  }
  
  public void start()
  {
    super.start();
    SLog.d(TAG, "start upload %s", new Object[] { this.mUiRequest.mLocalPath });
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      this.mProcessorReport.setError(940006, "make md5 fail", null, null);
      onError();
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().c()))
    {
      this.mProcessorReport.setError(880001, "no network", null, null);
      onError();
      return;
    }
    sendFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StoryUploadProcessor
 * JD-Core Version:    0.7.0.1
 */