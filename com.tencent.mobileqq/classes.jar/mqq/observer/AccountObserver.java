package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Action;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class AccountObserver
  implements Constants.Action, BusinessObserver
{
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onDeleteAccount(boolean paramBoolean) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3) {}
  
  public void onGetKeyResp(String paramString) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onLoginSuccess(String paramString1, String paramString2) {}
  
  protected void onLoginTimeout(String paramString) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4) {}
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    String str;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return;
    case 2205: 
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      onVerifyPasswd((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, paramBundle.getInt("ret"), paramBundle.getString("notice"), paramBundle.getByteArray("image"));
      return;
    case 2206: 
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      str = paramBundle.getString("userAccount");
      localObject2 = paramBundle.getString("errorMsg");
      int i = paramBundle.getInt("ret");
      ErrMsg localErrMsg = (ErrMsg)paramBundle.getParcelable("lastError");
      onVerifyPasswdImage((String)localObject1, paramBoolean, (String)localObject2, paramInt, str, paramBundle.getByteArray("userInput"), i, localErrMsg, paramBundle.getByteArray("image"));
      return;
    case 2207: 
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      str = paramBundle.getString("userAccount");
      onVerifyPasswdRefreshImage((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, str, paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"), paramBundle.getByteArray("pictureData"));
      return;
    case 1001: 
      paramInt = paramBundle.getInt("code");
      str = paramBundle.getString("alias");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onRV  action login code = ").append(paramInt).append("; alias = ");
        if (str != null) {
          break label439;
        }
      }
      for (localObject1 = "is null";; localObject1 = str)
      {
        QLog.d("AccountObserver", 2, (String)localObject1);
        if (!paramBoolean) {
          break;
        }
        onLoginSuccess(paramBundle.getString("uin"), str);
        return;
      }
      if ((paramInt == 1002) || (paramInt == 1013))
      {
        onLoginTimeout(str);
        return;
      }
      if (paramInt == 2006)
      {
        onUserCancel(str);
        return;
      }
      localObject1 = paramBundle.getString("errorurl");
      paramInt = paramBundle.getInt("loginret");
      localObject2 = paramBundle.getByteArray("lhsig");
      onLoginFailed(str, paramBundle.getString("error"), (String)localObject1, paramInt, (byte[])localObject2);
      return;
    case 1040: 
      onRegisterCmdCallback(paramBoolean);
      return;
    case 1002: 
      localObject1 = (AppRuntime.Status)paramBundle.getSerializable("onlineStatus");
      boolean bool1 = paramBundle.getBoolean("isChanged");
      long l = paramBundle.getLong("timeStamp");
      boolean bool2 = paramBundle.getBoolean("isLargeChanged");
      onOnlineStatusChanged(paramBoolean, (AppRuntime.Status)localObject1, paramBundle.getBoolean("isUserSet", false), bool1, l, bool2);
      return;
    case 2211: 
      onOnlineStatusPush((AppRuntime.Status)paramBundle.getSerializable("onlineStatus"), paramBundle.getLong("extOnlineStatus"));
      return;
    case 1041: 
      onRegQueryAccountResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"));
      return;
    case 1003: 
      onRegisterCommitMobileResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("mobile"), paramBundle.getString("inviteCode"));
      return;
    case 1004: 
      onRegisterCommitSmsCodeResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("bind_qq_uin"), paramBundle.getString("bind_qq_nick"), paramBundle.getString("bind_qq_face_url"), paramBundle.getByteArray("promptInfo"));
      return;
    case 1020: 
      onRegisterSendResendSmsreqResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"));
      return;
    case 1022: 
      onRegisterQuerySmsStatResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"), paramBundle.getString("uin"), paramBundle.getString("nick"), paramBundle.getString("faceUrl"), paramBundle.getString("errmsg"));
      return;
    case 1005: 
      if (paramBundle.getBoolean("reg_Lianghao", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassRespWithLhSig");
        }
        onRegisterCommitPassRespWithLhSig(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"), paramBundle.getByteArray("lhsig"));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassResp");
      }
      onRegisterCommitPassResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"));
      return;
    case 1008: 
      onCheckQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo_error"));
      return;
    case 1009: 
      onGetQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getString("phone"), paramBundle.getByteArray("promptInfo_error"));
      return;
    case 1007: 
      onDeleteAccount(paramBoolean);
      return;
    case 1030: 
      onGetKeyResp(paramBundle.getString("key"));
      return;
    case 1032: 
      label439:
      onChangeToken(paramBoolean, (HashMap)paramBundle.getSerializable("map"));
      return;
    }
    onRefreshDA2(paramBoolean, paramBundle.getString("account"), paramBundle.getString("da2"));
  }
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onRegisterCmdCallback(boolean paramBoolean) {}
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString) {}
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {}
  
  public void onUpdateSKey(String paramString1, String paramString2) {}
  
  public void onUpdateSTwxWeb(String paramString) {}
  
  protected void onUserCancel(String paramString) {}
  
  public void onVerifyPasswd(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void onVerifyPasswdImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, byte[] paramArrayOfByte1, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte2) {}
  
  public void onVerifyPasswdRefreshImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.observer.AccountObserver
 * JD-Core Version:    0.7.0.1
 */