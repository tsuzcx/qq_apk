package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.nio.ByteBuffer;
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
  private Transaction trans = null;
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
    CompressOperator.a((CompressInfo)localObject);
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
  
  private ITransactionCallback getCb(long paramLong)
  {
    return new NearbyPeoplePhotoUploadProcessor.1(this, paramLong);
  }
  
  private int getCommandId()
  {
    int i = 21;
    if ((this.file.fileType == 8) || (this.file.fileType == 64)) {
      i = 3;
    }
    do
    {
      return i;
      if (this.file.fileType == 21) {
        return 6;
      }
      if (this.file.fileType == 22) {
        return 5;
      }
      if (this.file.fileType == 34) {
        return 13;
      }
    } while (this.file.fileType == 35);
    if ((this.file.fileType == 36) || (this.file.fileType == 37) || (this.file.fileType == 38)) {
      return 23;
    }
    if ((this.file.fileType == 39) || (this.file.fileType == 40) || (this.file.fileType == 41)) {
      return 22;
    }
    if (this.file.fileType == 48) {
      return 24;
    }
    if (this.file.fileType == 23)
    {
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.app.getCurrentAccountUin()));
      this.file.bdhExtendInfo = localCommFileExtReq.toByteArray();
      return 59;
    }
    if ((this.file.fileType == 50) || (this.file.fileType == 51)) {
      return 35;
    }
    if (this.file.fileType == 56) {
      return 39;
    }
    return -1;
  }
  
  private void handleTransFileBaseStaticAvatarOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      i = localByteBuffer.get() & 0xFF;
      this.mPhotoUrl = new String(paramArrayOfByte, 2, i);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileBaseStaticAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.mPhotoUrl }));
      }
      onSuccess();
      return;
    }
    int i = localByteBuffer.getInt();
    short s = localByteBuffer.getShort();
    paramArrayOfByte = new byte[s];
    localByteBuffer.get(paramArrayOfByte);
    paramArrayOfByte = new String(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileBaseStaticAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.file.errorCode = i;
    this.errCode = i;
    this.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileExtendFriendSoundOnSuccess(byte[] paramArrayOfByte)
  {
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
    try
    {
      localCommFileExtRsp.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (localCommFileExtRsp.bytes_download_url.has())
      {
        paramArrayOfByte = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
        this.mUrl = paramArrayOfByte;
        if (!localCommFileExtRsp.int32_retcode.has()) {
          break label130;
        }
        i = localCommFileExtRsp.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i + " url : " + this.mUrl);
        }
        if (i != 0) {
          break label135;
        }
        onSuccess();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        paramArrayOfByte = "";
        continue;
        label130:
        int i = -1;
      }
      label135:
      onError();
    }
  }
  
  private void handleTransFileFriendAvatarOnSuccess(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    byte b = paramArrayOfByte.get();
    if (b == 0)
    {
      i = paramArrayOfByte.get();
      this.mPhotoUrl = new String(new byte[i]);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileFriendAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.mPhotoUrl }));
      }
      onSuccess();
      return;
    }
    int i = paramArrayOfByte.getInt();
    short s = paramArrayOfByte.getShort();
    byte[] arrayOfByte = new byte[s];
    paramArrayOfByte.get(arrayOfByte);
    paramArrayOfByte = new String(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileFriendAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.file.errorCode = i;
    this.errCode = i;
    this.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileOtherConditionOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    int i = localByteBuffer.get();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
    }
    if (i == 0)
    {
      if ((this.file.fileType == 8) || (this.file.fileType == 64)) {
        mPhotoId = Integer.parseInt(new String(paramArrayOfByte, 2, localByteBuffer.get() & 0xFF));
      }
      for (;;)
      {
        onSuccess();
        return;
        if (this.file.fileType == 21)
        {
          this.mPhotoUrl = new String(paramArrayOfByte, 2, localByteBuffer.get() & 0xFF);
        }
        else if ((this.file.fileType == 36) || (this.file.fileType == 37) || (this.file.fileType == 38) || (this.file.fileType == 39) || (this.file.fileType == 40) || (this.file.fileType == 41))
        {
          i = localByteBuffer.get();
          int j = localByteBuffer.get();
          int k = localByteBuffer.get();
          this.mVideoId = new String(paramArrayOfByte, 5, (localByteBuffer.get() & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
        }
        else if (this.file.fileType == 56)
        {
          try
          {
            localByteBuffer.getInt();
            long l = localByteBuffer.getLong();
            i = localByteBuffer.getInt();
            this.mPhotoUrl = new String(paramArrayOfByte, localByteBuffer.position(), i);
            if (QLog.isColorLevel()) {
              QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l + " url:" + this.mPhotoUrl);
            }
            this.file.thumbPath = this.mUiRequest.mThumbPath;
            this.file.fileID = l;
            this.file.fileUrl = this.mPhotoUrl;
            if (TextUtils.isEmpty(this.file.fileUrl)) {
              this.file.fileUrl = this.mUiRequest.mLocalPath;
            }
          }
          catch (Exception paramArrayOfByte) {}
        }
      }
    }
    if (this.file.fileType == 34)
    {
      this.mPhotoUrl = new String(paramArrayOfByte);
      onSuccess();
      return;
    }
    sendMessageToUpdate(1005);
    onError();
  }
  
  private void handleTransFileProfileCoverOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      this.file.bdhExtendInfo = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileProfileCoverOnSuccess success, result=%s", new Object[] { Byte.valueOf(b) }));
      }
      onSuccess();
      return;
    }
    int i = localByteBuffer.getInt();
    short s = localByteBuffer.getShort();
    paramArrayOfByte = new byte[s];
    localByteBuffer.get(paramArrayOfByte);
    paramArrayOfByte = new String(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileProfileCoverOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.file.errorCode = i;
    this.errCode = i;
    this.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileStarPhotoOnSuccess(byte[] paramArrayOfByte)
  {
    Bdh_extinfo.UploadPicExtInfo localUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      localUploadPicExtInfo.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      this.uuid = localUploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
      if (!TextUtils.isEmpty(this.uuid))
      {
        onSuccess();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      onError();
    }
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
    label100:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      str1 = "";
      if ((this.file.fileType != 8) && (this.file.fileType != 64)) {
        break label190;
      }
      str1 = "actNearbyPeoplePicUpload";
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mReportInfo;
      if (this.mSessionKey != null) {
        break label442;
      }
      str2 = "null";
      label139:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label454;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label190:
      if (this.file.fileType == 21)
      {
        str1 = "actFreshNewsPicUpload";
        break label100;
      }
      if (this.file.fileType == 22)
      {
        str1 = "actFriendAvatarUpload";
        break label100;
      }
      if (this.file.fileType == 34)
      {
        str1 = "C2BUploadFile";
        break label100;
      }
      if (this.file.fileType == 35)
      {
        str1 = "actProfileCoverPicUpload";
        break label100;
      }
      if ((this.file.fileType == 36) || (this.file.fileType == 37) || (this.file.fileType == 38) || (this.file.fileType == 48))
      {
        str1 = "actBaseDynamicAvatarUpload";
        break label100;
      }
      if ((this.file.fileType == 39) || (this.file.fileType == 40) || (this.file.fileType == 41))
      {
        str1 = "actNearbyDynamicAvatarUpload";
        break label100;
      }
      if ((this.file.fileType == 50) || (this.file.fileType == 51))
      {
        str1 = "actHongbaoStarPhotoUpload";
        break label100;
      }
      if (this.file.fileType == 56)
      {
        str1 = "actPersonalityLabelPhotoUpload";
        break label100;
      }
      if (this.file.fileType != 23) {
        break label100;
      }
      str1 = "actExtendFriendSoundUpload";
      break label100;
      label442:
      str2 = PkgTools.toHexStr(this.mSessionKey);
      break label139;
      label454:
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
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.errCode;
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
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      this.mUiRequest.mUpCallBack.b(localSendResult);
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
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.mStepTrans.logStartTime();
    ITransactionCallback localITransactionCallback = getCb(SystemClock.uptimeMillis());
    int i = getCommandId();
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
      this.trans = new Transaction(this.app.getCurrentAccountUin(), i, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, localITransactionCallback, this.file.bdhExtendInfo, false);
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