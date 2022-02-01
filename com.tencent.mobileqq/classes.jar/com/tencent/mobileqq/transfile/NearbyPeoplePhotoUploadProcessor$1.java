package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

class NearbyPeoplePhotoUploadProcessor$1
  implements ITransactionCallback
{
  NearbyPeoplePhotoUploadProcessor$1(NearbyPeoplePhotoUploadProcessor paramNearbyPeoplePhotoUploadProcessor, long paramLong) {}
  
  private void handleTransFileBaseStaticAvatarOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      i = localByteBuffer.get() & 0xFF;
      this.this$0.mPhotoUrl = new String(paramArrayOfByte, 2, i);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileBaseStaticAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.this$0.mPhotoUrl }));
      }
      this.this$0.onSuccess();
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
    this.this$0.file.errorCode = i;
    this.this$0.errCode = i;
    this.this$0.errDesc = paramArrayOfByte;
    this.this$0.onError();
  }
  
  private void handleTransFileFriendAvatarOnSuccess(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    byte b = paramArrayOfByte.get();
    if (b == 0)
    {
      i = paramArrayOfByte.get();
      paramArrayOfByte = new byte[i];
      this.this$0.mPhotoUrl = new String(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileFriendAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.this$0.mPhotoUrl }));
      }
      this.this$0.onSuccess();
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
    this.this$0.file.errorCode = i;
    this.this$0.errCode = i;
    this.this$0.errDesc = paramArrayOfByte;
    this.this$0.onError();
  }
  
  private void handleTransFileProfileCoverOnSuccess(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      this.this$0.file.bdhExtendInfo = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileProfileCoverOnSuccess success, result=%s", new Object[] { Byte.valueOf(b) }));
      }
      this.this$0.onSuccess();
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
    this.this$0.file.errorCode = i;
    this.this$0.errCode = i;
    this.this$0.errDesc = paramArrayOfByte;
    this.this$0.onError();
  }
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms");
    }
    this.this$0.mReportInfo.put("X-piccachetime", paramArrayOfByte);
    this.this$0.mReportInfo.put("param_BdhTrans", str1);
    this.this$0.mReportInfo.put("param_segspercnt", str2);
    this.this$0.mReportInfo.put("param_conf_segSize", str3);
    this.this$0.mReportInfo.put("param_conf_segNum", str4);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.reportDataFlow(l2, l3, l4, l5);
    this.this$0.setError(paramInt, "OnFailed.", "", this.this$0.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l5 = SystemClock.uptimeMillis();
    long l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    Object localObject = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l5 - this.val$startTime) + "ms ,fileSize:" + this.this$0.file.fileSize + " transInfo:" + str1);
    }
    this.this$0.mReportInfo.put("X-piccachetime", localObject);
    this.this$0.mReportInfo.put("param_BdhTrans", str1);
    this.this$0.mReportInfo.put("param_segspercnt", str2);
    this.this$0.mReportInfo.put("param_conf_segSize", str3);
    this.this$0.mReportInfo.put("param_conf_segNum", str4);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.mStepTrans.logFinishTime();
    this.this$0.mStepTrans.result = 1;
    this.this$0.mTransferedSize = this.this$0.mFileSize;
    if ((this.this$0.file.fileType == 50) || (this.this$0.file.fileType == 51)) {
      paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    }
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.this$0.uuid = paramHashMap.bytes_file_resid.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.this$0.uuid))
        {
          this.this$0.onSuccess();
          this.this$0.reportDataFlow(l1, l2, l3, l4);
          this.this$0.file.closeInputStream();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        this.this$0.onError();
        continue;
      }
      int i;
      if (this.this$0.file.fileType == 23)
      {
        paramHashMap = new Bdh_extinfo.CommFileExtRsp();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = this.this$0;
          if (paramHashMap.bytes_download_url.has())
          {
            paramArrayOfByte = paramHashMap.bytes_download_url.get().toStringUtf8();
            ((NearbyPeoplePhotoUploadProcessor)localObject).mUrl = paramArrayOfByte;
            if (!paramHashMap.int32_retcode.has()) {
              break label614;
            }
            i = paramHashMap.int32_retcode.get();
            if (QLog.isColorLevel()) {
              QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i + " url : " + this.this$0.mUrl);
            }
            if (i != 0) {
              break label619;
            }
            this.this$0.onSuccess();
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
            label614:
            i = -1;
          }
          label619:
          this.this$0.onError();
        }
      }
      else if (this.this$0.file.fileType == 22)
      {
        handleTransFileFriendAvatarOnSuccess(paramArrayOfByte);
      }
      else if (this.this$0.file.fileType == 48)
      {
        handleTransFileBaseStaticAvatarOnSuccess(paramArrayOfByte);
      }
      else if (this.this$0.file.fileType == 35)
      {
        handleTransFileProfileCoverOnSuccess(paramArrayOfByte);
      }
      else
      {
        paramHashMap = ByteBuffer.wrap(paramArrayOfByte);
        i = paramHashMap.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
        }
        if (i == 0)
        {
          if ((this.this$0.file.fileType == 8) || (this.this$0.file.fileType == 64)) {
            NearbyPeoplePhotoUploadProcessor.mPhotoId = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
          }
          for (;;)
          {
            this.this$0.onSuccess();
            break;
            if (this.this$0.file.fileType == 21)
            {
              i = paramHashMap.get();
              this.this$0.mPhotoUrl = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if ((this.this$0.file.fileType == 36) || (this.this$0.file.fileType == 37) || (this.this$0.file.fileType == 38) || (this.this$0.file.fileType == 39) || (this.this$0.file.fileType == 40) || (this.this$0.file.fileType == 41))
            {
              i = paramHashMap.get();
              int j = paramHashMap.get();
              int k = paramHashMap.get();
              int m = paramHashMap.get();
              this.this$0.mVideoId = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
            }
            else if (this.this$0.file.fileType == 56)
            {
              try
              {
                paramHashMap.getInt();
                l5 = paramHashMap.getLong();
                i = paramHashMap.getInt();
                this.this$0.mPhotoUrl = new String(paramArrayOfByte, paramHashMap.position(), i);
                if (QLog.isColorLevel()) {
                  QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l5 + " url:" + this.this$0.mPhotoUrl);
                }
                this.this$0.file.thumbPath = this.this$0.mUiRequest.mThumbPath;
                this.this$0.file.fileID = l5;
                this.this$0.file.fileUrl = this.this$0.mPhotoUrl;
                if (TextUtils.isEmpty(this.this$0.file.fileUrl)) {
                  this.this$0.file.fileUrl = this.this$0.mUiRequest.mLocalPath;
                }
              }
              catch (Exception paramArrayOfByte) {}
            }
          }
        }
        if (this.this$0.file.fileType == 34)
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.this$0.mPhotoUrl = paramArrayOfByte;
          this.this$0.onSuccess();
        }
        else
        {
          this.this$0.sendMessageToUpdate(1005);
          this.this$0.onError();
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localNearbyPeoplePhotoUploadProcessor.mTransferedSize = l;
    if ((paramInt <= this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */