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
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("personality_label start uniseq:");
      ((StringBuilder)localObject1).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject1).append(" src:");
      ((StringBuilder)localObject1).append(this.mUiRequest.mLocalPath);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new CompressInfo(this.mUiRequest.mLocalPath, 0);
    ((CompressInfo)localObject1).o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
    if (TextUtils.isEmpty(((CompressInfo)localObject1).l))
    {
      onError();
      return true;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("personality_label start compress dst:");
      ((StringBuilder)localObject2).append(((CompressInfo)localObject1).l);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.equals(((CompressInfo)localObject1).l, ((CompressInfo)localObject1).h))
    {
      localObject2 = this.file;
      TransferRequest localTransferRequest = this.mUiRequest;
      localObject1 = ((CompressInfo)localObject1).l;
      localTransferRequest.mLocalPath = ((String)localObject1);
      ((FileMsg)localObject2).filePath = ((String)localObject1);
      if (checkParam() != 0) {
        return true;
      }
    }
    return false;
  }
  
  private ITransactionCallback getCb(long paramLong)
  {
    return new NearbyPeoplePhotoUploadProcessor.1(this, paramLong);
  }
  
  private int getCommandId()
  {
    if ((this.file.fileType != 8) && (this.file.fileType != 64))
    {
      if (this.file.fileType == 21) {
        return 6;
      }
      if (this.file.fileType == 22) {
        return 5;
      }
      if (this.file.fileType == 34) {
        return 13;
      }
      if (this.file.fileType == 35) {
        return 21;
      }
      if ((this.file.fileType != 36) && (this.file.fileType != 37) && (this.file.fileType != 38))
      {
        if ((this.file.fileType != 39) && (this.file.fileType != 40) && (this.file.fileType != 41))
        {
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
          if ((this.file.fileType != 50) && (this.file.fileType != 51))
          {
            if (this.file.fileType == 56) {
              return 39;
            }
            if (this.file.fileType == 67) {
              return 84;
            }
            if (this.file.fileType == 68) {
              return 85;
            }
            return -1;
          }
          return 35;
        }
        return 22;
      }
      return 23;
    }
    return 3;
  }
  
  private String getRichTag(String paramString)
  {
    if ((this.file.fileType != 8) && (this.file.fileType != 64))
    {
      if (this.file.fileType == 21) {
        return "actFreshNewsPicUpload";
      }
      if (this.file.fileType == 22) {
        return "actFriendAvatarUpload";
      }
      if (this.file.fileType == 34) {
        return "C2BUploadFile";
      }
      if (this.file.fileType == 35) {
        return "actProfileCoverPicUpload";
      }
      if ((this.file.fileType != 36) && (this.file.fileType != 37) && (this.file.fileType != 38) && (this.file.fileType != 48))
      {
        if ((this.file.fileType != 39) && (this.file.fileType != 40) && (this.file.fileType != 41))
        {
          if ((this.file.fileType != 50) && (this.file.fileType != 51))
          {
            if (this.file.fileType == 56) {
              return "actPersonalityLabelPhotoUpload";
            }
            if (this.file.fileType == 23) {
              return "actExtendFriendSoundUpload";
            }
          }
          else
          {
            return "actHongbaoStarPhotoUpload";
          }
        }
        else {
          return "actNearbyDynamicAvatarUpload";
        }
      }
      else {
        return "actBaseDynamicAvatarUpload";
      }
    }
    else
    {
      paramString = "actNearbyPeoplePicUpload";
    }
    return paramString;
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
    this.mProcessorReport.errCode = i;
    this.mProcessorReport.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileExtendFriendOnSuccess(byte[] paramArrayOfByte)
  {
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
    try
    {
      localCommFileExtRsp.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if (localCommFileExtRsp.bytes_download_url.has()) {
      paramArrayOfByte = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
    } else {
      paramArrayOfByte = "";
    }
    this.mUrl = paramArrayOfByte;
    int i;
    if (localCommFileExtRsp.int32_retcode.has()) {
      i = localCommFileExtRsp.int32_retcode.get();
    } else {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = ");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append(" url : ");
      paramArrayOfByte.append(this.mUrl);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramArrayOfByte.toString());
    }
    if (i == 0)
    {
      onSuccess();
      return;
    }
    onError();
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
    this.mProcessorReport.errCode = i;
    this.mProcessorReport.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileOtherConditionOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    int i = localByteBuffer.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = ");
      localStringBuilder.append(i);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, localStringBuilder.toString());
    }
    if (i == 0) {
      if ((this.file.fileType != 8) && (this.file.fileType != 64))
      {
        if (this.file.fileType == 21)
        {
          this.mPhotoUrl = new String(paramArrayOfByte, 2, localByteBuffer.get() & 0xFF);
          break label475;
        }
        if ((this.file.fileType != 36) && (this.file.fileType != 37) && (this.file.fileType != 38) && (this.file.fileType != 39) && (this.file.fileType != 40) && (this.file.fileType != 41) && (this.file.fileType != 56)) {
          break label475;
        }
      }
    }
    try
    {
      localByteBuffer.getInt();
      long l = localByteBuffer.getLong();
      i = localByteBuffer.getInt();
      this.mPhotoUrl = new String(paramArrayOfByte, localByteBuffer.position(), i);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:");
        paramArrayOfByte.append(l);
        paramArrayOfByte.append(" url:");
        paramArrayOfByte.append(this.mPhotoUrl);
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramArrayOfByte.toString());
      }
      this.file.thumbPath = this.mUiRequest.mThumbPath;
      this.file.fileID = l;
      this.file.fileUrl = this.mPhotoUrl;
      if (!TextUtils.isEmpty(this.file.fileUrl)) {
        break label475;
      }
      this.file.fileUrl = this.mUiRequest.mLocalPath;
    }
    catch (Exception paramArrayOfByte)
    {
      int j;
      int k;
      break label475;
    }
    i = localByteBuffer.get();
    j = localByteBuffer.get();
    k = localByteBuffer.get();
    this.mVideoId = new String(paramArrayOfByte, 5, (localByteBuffer.get() & 0xFF) << 24 | i | 0x0 | (j & 0xFF) << 8 | (k & 0xFF) << 16);
    break label475;
    mPhotoId = Integer.parseInt(new String(paramArrayOfByte, 2, localByteBuffer.get() & 0xFF));
    NearbyManagerHelper.a(this.app).c(mPhotoId);
    label475:
    onSuccess();
    return;
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
    this.mProcessorReport.errCode = i;
    this.mProcessorReport.errDesc = paramArrayOfByte;
    onError();
  }
  
  private void handleTransFileStarPhotoOnSuccess(byte[] paramArrayOfByte)
  {
    Bdh_extinfo.UploadPicExtInfo localUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      localUploadPicExtInfo.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    this.uuid = localUploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
    if (!TextUtils.isEmpty(this.uuid))
    {
      onSuccess();
      return;
    }
    onError();
  }
  
  private void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (!canDoNextStep()) {
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
    Object localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = new File((String)localObject1);
    StringBuilder localStringBuilder;
    if (!((File)localObject2).exists())
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
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
    if (l <= 0L)
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file size 0 ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
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
    if (!this.mProcessorReport.mIsOldDbRec)
    {
      int i = 2;
      if ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0))
      {
        if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
          return;
        }
        Object localObject = this.mProcessorReport;
        int j = this.mProcessorReport.mReportedFlag;
        if (!paramBoolean) {
          i = 1;
        }
        ((ProcessorReport)localObject).mReportedFlag = (i | j);
        String str = getRichTag("");
        this.mProcessorReport.mEndTime = System.currentTimeMillis();
        long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
        HashMap localHashMap = this.mProcessorReport.mReportInfo;
        if (this.mSessionKey == null) {
          localObject = "null";
        } else {
          localObject = PkgTools.toHexStr(this.mSessionKey);
        }
        localHashMap.put("param_sessionKey", localObject);
        if (paramBoolean)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        else
        {
          if (this.mProcessorReport.errCode != -9527) {
            this.mProcessorReport.mReportInfo.remove("param_rspHeader");
          }
          this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
          this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
          this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
      }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError()---- errCode: ");
      ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
      ((StringBuilder)localObject).append(", errDesc:");
      ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).a = -1;
      ((UpCallBack.SendResult)localObject).b = this.mProcessorReport.errCode;
      ((UpCallBack.SendResult)localObject).c = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
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
      localSendResult.a = 0;
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
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject1 = getCb(SystemClock.uptimeMillis());
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
      this.trans = new Transaction(this.app.getCurrentAccountUin(), i, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject1, this.file.bdhExtendInfo, false);
      int j = this.app.getHwEngine().submitTransactionTask(this.trans);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<BDH_LOG> Transaction submit RetCode:");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" T_ID:");
        ((StringBuilder)localObject1).append(this.trans.getTransationId());
        ((StringBuilder)localObject1).append(" UniSeq:");
        ((StringBuilder)localObject1).append(this.mUiRequest.mUniseq);
        ((StringBuilder)localObject1).append(" MD5:");
        ((StringBuilder)localObject1).append(this.mMd5Str);
        ((StringBuilder)localObject1).append(" uuid:");
        ((StringBuilder)localObject1).append(this.mUuid);
        ((StringBuilder)localObject1).append(" Path:");
        ((StringBuilder)localObject1).append(this.trans.filePath);
        ((StringBuilder)localObject1).append(" Cmd:");
        ((StringBuilder)localObject1).append(i);
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, ((StringBuilder)localObject1).toString());
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */