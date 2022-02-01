package com.tencent.mobileqq.webview;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.PasswdUrlReport.RspBody;
import tencent.im.PasswdUrlReport.UploadRespItem;

class UrlSecurityCheckManager$3
  extends ProtoUtils.TroopProtocolObserver
{
  UrlSecurityCheckManager$3(UrlSecurityCheckManager paramUrlSecurityCheckManager) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receive PasswdUrlReport code=");
      paramBundle.append(paramInt);
      QLog.i("urlSecMgr", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new PasswdUrlReport.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!QLog.isColorLevel()) {
          break label253;
        }
        QLog.d("urlSecMgr", 2, new Object[] { "parse PasswdUrlReport result res=", Integer.valueOf(paramBundle.result.get()), " retCode=", Integer.valueOf(paramBundle.upload_rsp_item.ret_code.get()) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          break label253;
        }
      }
      QLog.i("urlSecMgr", 2, "parse error", paramArrayOfByte);
    }
    else if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {}
    try
    {
      paramBundle = ((PasswdUrlReport.RspBody)new PasswdUrlReport.RspBody().mergeFrom(paramArrayOfByte)).upload_rsp_item.ret_msg.get();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label172:
      StringBuilder localStringBuilder;
      break label172;
    }
    paramBundle = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PasswdUrlReport error code=");
    localStringBuilder.append(paramInt);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = ", data=null";
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(paramBundle);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    localStringBuilder.append(paramArrayOfByte);
    QLog.i("urlSecMgr", 2, localStringBuilder.toString());
    label253:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.3
 * JD-Core Version:    0.7.0.1
 */