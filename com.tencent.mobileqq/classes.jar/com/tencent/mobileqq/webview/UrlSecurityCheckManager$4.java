package com.tencent.mobileqq.webview;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.video.aio_video.ErrInfo;
import tencent.aio.video.aio_video.RspGetUinByOpenId;

class UrlSecurityCheckManager$4
  extends ProtoUtils.TroopProtocolObserver
{
  UrlSecurityCheckManager$4(UrlSecurityCheckManager paramUrlSecurityCheckManager, UrlSecurityCheckManager.OnCheckResult paramOnCheckResult) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receive getUinWithOpenID code=");
      paramBundle.append(paramInt);
      QLog.i("urlSecMgr", 2, paramBundle.toString());
    }
    int i = -1;
    int k = 1;
    String str = "";
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      aio_video.RspGetUinByOpenId localRspGetUinByOpenId = new aio_video.RspGetUinByOpenId();
      try
      {
        localRspGetUinByOpenId.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = String.valueOf(localRspGetUinByOpenId.uin.get());
        j = k;
        paramBundle = str;
        localObject = paramArrayOfByte;
        paramInt = i;
        try
        {
          if (!QLog.isColorLevel()) {
            break label366;
          }
          QLog.d("urlSecMgr", 2, new Object[] { "getUinWithOpenID uin:", Long.valueOf(localRspGetUinByOpenId.uin.get()) });
          j = k;
          paramBundle = str;
          localObject = paramArrayOfByte;
          paramInt = i;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2) {}
        paramBundle = str;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
      {
        paramArrayOfByte = "";
      }
      localObject = paramArrayOfByte;
      paramInt = i;
      if (QLog.isColorLevel())
      {
        QLog.i("urlSecMgr", 2, "parse error", localInvalidProtocolBufferMicroException3);
        paramBundle = str;
        localObject = paramArrayOfByte;
        paramInt = i;
      }
    }
    else if (paramArrayOfByte == null) {}
    try
    {
      localObject = new aio_video.RspGetUinByOpenId();
      ((aio_video.RspGetUinByOpenId)localObject).mergeFrom(paramArrayOfByte);
      paramBundle = ((aio_video.RspGetUinByOpenId)localObject).err_info.err_msg.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label252:
      break label255;
    }
    try
    {
      j = ((aio_video.RspGetUinByOpenId)localObject).err_info.err_code.get();
      i = j;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      break label252;
    }
    break label258;
    label255:
    paramBundle = "";
    label258:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUinWithOpenID error code=");
      ((StringBuilder)localObject).append(paramInt);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = ", data=null";
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(", msg=");
        paramArrayOfByte.append(paramBundle);
        paramArrayOfByte.append(", errCode=");
        paramArrayOfByte.append(i);
        paramArrayOfByte = paramArrayOfByte.toString();
      }
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.i("urlSecMgr", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = "";
    paramInt = i;
    int j = 0;
    label366:
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult != null)
    {
      paramArrayOfByte = new Bundle();
      if (j != 0) {
        paramInt = 0;
      }
      paramArrayOfByte.putInt("result", paramInt);
      paramArrayOfByte.putString("errMsg", paramBundle);
      paramArrayOfByte.putString("retUin", (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.4
 * JD-Core Version:    0.7.0.1
 */