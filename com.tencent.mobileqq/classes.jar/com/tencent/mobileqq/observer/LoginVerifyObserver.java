package com.tencent.mobileqq.observer;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.qphone.base.util.QLog;
import face.FaceForeignIp.AvailableResponse;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LoginVerifyObserver
  implements BusinessObserver
{
  private static final int CODE_IP_CANNOT_USE_FACE = 1;
  private static final String TAG = "LoginVerifyObserver";
  
  public void checkSecureResponse(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse) {}
  
  public void deleteFaceDataSuccess() {}
  
  public void getAccountIdentitySuccess(cmd0x9ae.RspBody paramRspBody) {}
  
  public void getAppConfigSuccess(byte[] paramArrayOfByte) {}
  
  public void getFaceStateSuccess(oidb_0x5e1.RspBody paramRspBody) {}
  
  public void getPhoneUnitySuccess(cmd0x9ae.RspBody paramRspBody) {}
  
  public void getSecurePhoneSuccess(oidb_0xe96.RspBody paramRspBody) {}
  
  public void getTmpKeySuccess(String paramString1, String paramString2) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("cmd");
    if (!paramBoolean)
    {
      localObject2 = paramBundle.getString("dataErrorMsg", "");
      paramInt = paramBundle.getInt("dataErrorCode");
      paramBundle = new StringBuilder();
      paramBundle.append("LoginVerifyObserver onReceive error, code is : ");
      paramBundle.append(paramInt);
      paramBundle.append(", error msg is : ");
      paramBundle.append((String)localObject2);
      paramBundle.append(" cmd is : ");
      paramBundle.append((String)localObject1);
      QLog.e("LoginVerifyObserver", 1, paramBundle.toString());
      onFailedResponse((String)localObject1, paramInt, (String)localObject2);
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("LoginVerifyObserver success, cmd is : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null)
    {
      QLog.e("LoginVerifyObserver", 1, "LoginVerifyObserver onReceive success but data is null");
      onFailedResponse((String)localObject1, -1, "data is null");
      return;
    }
    if ("getTmpkey".equals(localObject1)) {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle));
        paramInt = paramBundle.optInt("ret", -1);
        if (paramInt == 0)
        {
          getTmpKeySuccess(paramBundle.optString("openid"), paramBundle.optString("tmpkey"));
          return;
        }
        paramBundle = paramBundle.optString("errmsg");
        onFailedResponse((String)localObject1, paramInt, paramBundle);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTmpError, ret : ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("  error : ");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTmpKey error : JSONException ");
        ((StringBuilder)localObject2).append(paramBundle.getMessage());
        QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
        onFailedResponse((String)localObject1, -1, paramBundle.getMessage());
        return;
      }
    }
    if ("getAppConfig".equals(localObject1)) {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle));
        paramInt = paramBundle.optInt("ret", -1);
        if (paramInt == 0)
        {
          getAppConfigSuccess(Base64.decode(paramBundle.optString("appconf_rsp"), 11));
          return;
        }
        paramBundle = paramBundle.optString("errmsg");
        onFailedResponse((String)localObject1, paramInt, paramBundle);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAppconf, ret : ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("  error : ");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAppconf error : JSONException ");
        ((StringBuilder)localObject2).append(paramBundle.getMessage());
        QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
        onFailedResponse((String)localObject1, -1, paramBundle.getMessage());
        return;
      }
    }
    if ("isIpForeign".equals(localObject1)) {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle));
        paramInt = paramBundle.optInt("ret", -1);
        if (paramInt == 0)
        {
          paramBundle = Base64.decode(paramBundle.optString("available_rsp"), 11);
          localObject2 = new FaceForeignIp.AvailableResponse();
          ((FaceForeignIp.AvailableResponse)localObject2).mergeFrom(paramBundle);
          paramInt = ((FaceForeignIp.AvailableResponse)localObject2).ret.get();
          paramBundle = ((FaceForeignIp.AvailableResponse)localObject2).msg.get();
          if (paramInt == 1) {
            break label1295;
          }
          paramBoolean = true;
          ipJudgeSuccess(paramBoolean, paramBundle);
          return;
        }
        paramBundle = paramBundle.optString("errmsg");
        QLog.e("LoginVerifyObserver", 1, new Object[] { "IP_IS_FOREIGN_HTTPS, ret : ", Integer.valueOf(paramInt), " error : ", paramBundle });
        onFailedResponse((String)localObject1, paramInt, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("LoginVerifyObserver", 1, new Object[] { "IP_IS_FOREIGN_HTTPS error : ", paramBundle.getMessage() });
        onFailedResponse((String)localObject1, -1, paramBundle.getMessage());
        return;
      }
    } else if ("FaceRecognition.Available".equals(localObject1)) {
      localObject2 = new FaceForeignIp.AvailableResponse();
    }
    for (;;)
    {
      try
      {
        ((FaceForeignIp.AvailableResponse)localObject2).mergeFrom(paramBundle);
        paramInt = ((FaceForeignIp.AvailableResponse)localObject2).ret.get();
        paramBundle = ((FaceForeignIp.AvailableResponse)localObject2).msg.get();
        if (paramInt == 1) {
          break label1300;
        }
        paramBoolean = true;
        ipJudgeSuccess(paramBoolean, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        QLog.e("LoginVerifyObserver", 1, new Object[] { "AvailableResponse merge from data error : ", paramBundle.getMessage() });
        onFailedResponse((String)localObject1, -1, paramBundle.getMessage());
        return;
      }
      if ("FaceRecognition.SecureCheck".equals(localObject1))
      {
        localObject2 = new FaceSecureCheck.SecureCheckResponse();
        try
        {
          ((FaceSecureCheck.SecureCheckResponse)localObject2).mergeFrom(paramBundle);
          paramInt = ((FaceSecureCheck.SecureCheckResponse)localObject2).uint32_errcode.get();
          if (paramInt != 0)
          {
            paramBundle = ((FaceSecureCheck.SecureCheckResponse)localObject2).str_err_msg.get();
            onFailedResponse((String)localObject1, paramInt, paramBundle);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sso result error, ret : ");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("  error : ");
            ((StringBuilder)localObject1).append(paramBundle);
            QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject1).toString());
            return;
          }
          checkSecureResponse((FaceSecureCheck.SecureCheckResponse)localObject2);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          QLog.e("LoginVerifyObserver", 1, new Object[] { "SecureCheckResponse merge from data error : ", paramBundle.getMessage() });
          return;
        }
      }
      try
      {
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramBundle);
        paramInt = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (paramInt != 0)
        {
          paramBundle = ((oidb_sso.OIDBSSOPkg)localObject2).str_error_msg.get();
          onFailedResponse((String)localObject1, paramInt, paramBundle);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sso result error, ret : ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("  error : ");
          ((StringBuilder)localObject2).append(paramBundle);
          QLog.e("LoginVerifyObserver", 1, ((StringBuilder)localObject2).toString());
          return;
        }
        paramBundle = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
        if ("OidbSvc.0x5e1_295".equals(localObject1))
        {
          localObject2 = new oidb_0x5e1.RspBody();
          ((oidb_0x5e1.RspBody)localObject2).mergeFrom(paramBundle);
          getFaceStateSuccess((oidb_0x5e1.RspBody)localObject2);
          return;
        }
        if ("OidbSvc.0x87c_108".equals(localObject1))
        {
          localObject2 = new oidb_0x87c.RspBody();
          ((oidb_0x87c.RspBody)localObject2).mergeFrom(paramBundle);
          verifySmsCodeSuccess((oidb_0x87c.RspBody)localObject2);
          return;
        }
        if ("OidbSvc.0x87a_108".equals(localObject1))
        {
          localObject2 = new oidb_0x87a.RspBody();
          ((oidb_0x87a.RspBody)localObject2).mergeFrom(paramBundle);
          sendSmsCodeSuccess((oidb_0x87a.RspBody)localObject2);
          return;
        }
        if ("OidbSvc.0x587_63".equals(localObject1))
        {
          deleteFaceDataSuccess();
          return;
        }
        if ("OidbSvc.0xe96_0".equals(localObject1))
        {
          localObject2 = new oidb_0xe96.RspBody();
          ((oidb_0xe96.RspBody)localObject2).mergeFrom(paramBundle);
          getSecurePhoneSuccess((oidb_0xe96.RspBody)localObject2);
          return;
        }
        if ("OidbSvc.0xe9a_0".equals(localObject1))
        {
          refreshPhoneSuccess();
          return;
        }
        if ((!"OidbSvc.0x9ae_13".equals(localObject1)) && (!"OidbSvc.0x9ae_14".equals(localObject1)))
        {
          if ("OidbSvc.0x9ae_15".equals(localObject1))
          {
            localObject2 = new cmd0x9ae.RspBody();
            ((cmd0x9ae.RspBody)localObject2).mergeFrom(paramBundle);
            getPhoneUnitySuccess((cmd0x9ae.RspBody)localObject2);
          }
        }
        else
        {
          localObject2 = new cmd0x9ae.RspBody();
          ((cmd0x9ae.RspBody)localObject2).mergeFrom(paramBundle);
          getAccountIdentitySuccess((cmd0x9ae.RspBody)localObject2);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        onFailedResponse((String)localObject1, -1, paramBundle.getMessage());
      }
      return;
      label1295:
      paramBoolean = false;
      break;
      label1300:
      paramBoolean = false;
    }
  }
  
  public void refreshPhoneSuccess() {}
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody) {}
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.observer.LoginVerifyObserver
 * JD-Core Version:    0.7.0.1
 */