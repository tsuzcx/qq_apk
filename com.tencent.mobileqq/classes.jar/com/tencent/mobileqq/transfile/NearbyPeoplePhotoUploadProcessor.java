package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import ayeo;
import ayep;
import ayeu;
import bjyw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class NearbyPeoplePhotoUploadProcessor
  extends BaseUploadProcessor
{
  public static final int ERROR_CODE_SYSTEM_UNAVAILABLE = 1503;
  public static final String TAG = "NearbyPeoplePhotoUploadProcessor";
  public static int mPhotoId;
  public String mPhotoUrl;
  public String mThumbPhotoUrl;
  public String mUrl;
  public String mVideoId;
  private Transaction trans;
  public String uuid;
  
  public NearbyPeoplePhotoUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.processor = this;
    this.file.bdhExtendInfo = paramTransferRequest.mExtentionInfo;
    this.file.fileKey = paramTransferRequest.getKeyForTransfer();
  }
  
  private boolean doCompress()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start uniseq:" + this.mUiRequest.mUniseq + " src:" + this.mUiRequest.mLocalPath);
    }
    Object localObject = new CompressInfo(this.mUiRequest.mLocalPath, 0);
    ((CompressInfo)localObject).f = 0;
    ayeu.a((CompressInfo)localObject);
    if (TextUtils.isEmpty(((CompressInfo)localObject).e)) {
      onError();
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start compress dst:" + ((CompressInfo)localObject).e);
      }
      if (TextUtils.equals(((CompressInfo)localObject).e, ((CompressInfo)localObject).c)) {
        break;
      }
      FileMsg localFileMsg = this.file;
      TransferRequest localTransferRequest = this.mUiRequest;
      localObject = ((CompressInfo)localObject).e;
      localTransferRequest.mLocalPath = ((String)localObject);
      localFileMsg.filePath = ((String)localObject);
    } while (checkParam() != 0);
    return false;
  }
  
  private void sendRequest()
  {
    this.mStepUrl.logStartTime();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    while (!canDoNextStep()) {
      return;
    }
    sendFile();
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
      setError(9042, getExpStackString(new Exception("sendFile not exist " + str)));
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
    if (l <= 0L)
    {
      setError(9071, getExpStackString(new Exception("file size 0 " + str)));
      onError();
      return -1;
    }
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {}
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    String str1;
    label98:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      str1 = "";
      if ((this.file.fileType != 8) && (this.file.fileType != 64)) {
        break label187;
      }
      str1 = "actNearbyPeoplePicUpload";
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mReportInfo;
      if (this.mSessionKey != null) {
        break label439;
      }
      str2 = "null";
      label137:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label451;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label187:
      if (this.file.fileType == 21)
      {
        str1 = "actFreshNewsPicUpload";
        break label98;
      }
      if (this.file.fileType == 22)
      {
        str1 = "actFriendAvatarUpload";
        break label98;
      }
      if (this.file.fileType == 34)
      {
        str1 = "C2BUploadFile";
        break label98;
      }
      if (this.file.fileType == 35)
      {
        str1 = "actProfileCoverPicUpload";
        break label98;
      }
      if ((this.file.fileType == 36) || (this.file.fileType == 37) || (this.file.fileType == 38) || (this.file.fileType == 48))
      {
        str1 = "actBaseDynamicAvatarUpload";
        break label98;
      }
      if ((this.file.fileType == 39) || (this.file.fileType == 40) || (this.file.fileType == 41))
      {
        str1 = "actNearbyDynamicAvatarUpload";
        break label98;
      }
      if ((this.file.fileType == 50) || (this.file.fileType == 51))
      {
        str1 = "actHongbaoStarPhotoUpload";
        break label98;
      }
      if (this.file.fileType == 56)
      {
        str1 = "actPersonalityLabelPhotoUpload";
        break label98;
      }
      if (this.file.fileType != 23) {
        break label98;
      }
      str1 = "actExtendFriendSoundUpload";
      break label98;
      label439:
      str2 = PkgTools.toHexStr(this.mSessionKey);
      break label137;
      label451:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, false, l, this.mFileSize, this.mReportInfo, "");
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
  
  protected void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramString);
    }
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onError()---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Int = -1;
      localayep.b = this.errCode;
      localayep.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.onSend(localayep);
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
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Int = 0;
      this.mUiRequest.mUpCallBack.onSend(localayep);
    }
  }
  
  protected void reportDataFlow(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.app.countFlow(true, 1, this.file.fileType, this.mUiRequest.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.app.countFlow(true, 1, this.file.fileType, this.mUiRequest.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.app.countFlow(true, 0, this.file.fileType, this.mUiRequest.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.app.countFlow(true, 0, this.file.fileType, this.mUiRequest.mUinType, paramLong4);
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.resume()");
    }
    cancelTask();
    sendRequest();
    return 0;
  }
  
  public void sendFile()
  {
    int i = 21;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.mStepTrans.logStartTime();
    NearbyPeoplePhotoUploadProcessor.1 local1 = new NearbyPeoplePhotoUploadProcessor.1(this, SystemClock.uptimeMillis());
    if ((this.file.fileType == 8) || (this.file.fileType == 64)) {
      i = 3;
    }
    for (;;)
    {
      this.file.commandId = i;
      try
      {
        if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session().length;
          this.mSigSession = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session(), 0, this.mSigSession, 0, j);
        }
        if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey().length;
          this.mSessionKey = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey(), 0, this.mSessionKey, 0, j);
        }
        if (((this.mSigSession == null) || (this.mSigSession.length == 0) || (this.mSessionKey == null) || (this.mSessionKey.length == 0)) && (!TextUtils.isEmpty(this.app.getCurrentAccountUin()))) {
          HwServlet.getConfig(this.app, this.app.getCurrentAccountUin());
        }
        this.trans = new Transaction(this.app.getCurrentAccountUin(), i, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, this.file.bdhExtendInfo, false);
        int j = this.app.getHwEngine().submitTransactionTask(this.trans);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + j + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + i);
        }
        if (j != 0)
        {
          setError(j, "SubmitError.", "", this.mStepTrans);
          onError();
        }
        return;
      }
      finally {}
      if (this.file.fileType == 21) {
        i = 6;
      } else if (this.file.fileType == 22) {
        i = 5;
      } else if (this.file.fileType == 34) {
        i = 13;
      } else if (this.file.fileType != 35) {
        if ((this.file.fileType == 36) || (this.file.fileType == 37) || (this.file.fileType == 38))
        {
          i = 23;
        }
        else if ((this.file.fileType == 39) || (this.file.fileType == 40) || (this.file.fileType == 41))
        {
          i = 22;
        }
        else if (this.file.fileType == 48)
        {
          i = 24;
        }
        else if (this.file.fileType == 23)
        {
          i = 59;
          Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
          localCommFileExtReq.uint32_action_type.set(0);
          localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.app.getCurrentAccountUin()));
          this.file.bdhExtendInfo = localCommFileExtReq.toByteArray();
        }
        else if ((this.file.fileType == 50) || (this.file.fileType == 51))
        {
          i = 35;
        }
        else if (this.file.fileType == 56)
        {
          i = 39;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
  
  public void start()
  {
    super.start();
    sendMessageToUpdate(1001);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.start()");
    }
    if ((this.file.fileType == 56) && (doCompress())) {
      return;
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */