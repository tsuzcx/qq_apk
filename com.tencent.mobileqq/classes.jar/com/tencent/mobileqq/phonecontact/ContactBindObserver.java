package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  public static final String KEY_AUTO_BIND = "k_buto_bind";
  public static final String KEY_RESULT = "k_result";
  public static final String KEY_UIN = "k_uin";
  public static final int REASON_ALL_TIMEOUT = 2;
  public static final int REASON_NOBIND_HASBIND = 4;
  public static final int REASON_NOBIND_NODATA = 5;
  public static final int REASON_NONE = 0;
  public static final int REASON_NO_BIND = 1;
  public static final int REASON_PART_TIMEOUT = 3;
  
  private void onUploadAndQueryContact(boolean paramBoolean, int paramInt)
  {
    onUploadContact(paramBoolean, paramInt);
    if (paramBoolean) {
      onQueryContactList(true, 7);
    }
  }
  
  protected String getBindErrorMessage(int paramInt)
  {
    if (paramInt == 217) {
      return HardCodeUtil.a(2131702496);
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return HardCodeUtil.a(2131702501);
    }
    if (paramInt == 224) {
      return HardCodeUtil.a(2131702493);
    }
    if (paramInt == 223) {
      return HardCodeUtil.a(2131702494);
    }
    return HardCodeUtil.a(2131702497);
  }
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onCancelBind(boolean paramBoolean) {}
  
  protected void onDisableMobileMatch(boolean paramBoolean) {}
  
  protected void onGetBindUinWithPhone(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  protected void onHideContact(boolean paramBoolean) {}
  
  protected void onPushRecommendUpdate(boolean paramBoolean) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt) {}
  
  protected void onQueryLastLoginInfo(boolean paramBoolean) {}
  
  protected void onReBindMblWTLogin(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onRebindMobile(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          onQueryBindState(true, true);
          return;
        }
        onQueryBindState(true, false);
        return;
      }
      onQueryBindState(false, false);
      return;
    case 35: 
      onBindMobile(paramBoolean, paramBundle);
      return;
    case 14: 
      paramInt = j;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      onUploadContact(paramBoolean, paramInt);
      return;
    case 15: 
      paramInt = k;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      onUpdateContact(paramBoolean, paramInt);
      return;
    case 28: 
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        if (paramBundle.getBoolean("hasUpdate")) {
          paramInt = 1;
        }
      }
      onQueryContactList(paramBoolean, paramInt);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        onVerifyBindSms(paramBoolean, paramInt);
        return;
      }
    case 17: 
      onResendSms(paramBoolean);
      return;
    case 19: 
      onRebindMobile(paramBoolean, paramBundle);
      return;
    case 20: 
      onCancelBind(paramBoolean);
      return;
    case 23: 
      onPushRecommendUpdate(paramBoolean);
      return;
    case 26: 
      onGetBindUinWithPhone(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    case 27: 
      onReBindMblWTLogin(paramBoolean, paramBundle.getBoolean("bind_state", false));
      return;
    case 31: 
      paramInt = m;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      onUploadAndQueryContact(paramBoolean, paramInt);
      return;
    case 30: 
      paramInt = n;
      if (paramBoolean) {
        paramInt = paramBundle.getInt("param_update_flag");
      }
      onQueryContactList(paramBoolean, paramInt);
      return;
    case 100: 
      onUploadProgressUpdated(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
      return;
    case 32: 
      onQueryLastLoginInfo(paramBoolean);
      return;
    case 33: 
      onDisableMobileMatch(paramBoolean);
      return;
    case 34: 
      onHideContact(paramBoolean);
      return;
    case 38: 
      paramInt = i1;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      onUpdateContactNotBind(paramBoolean, paramInt);
      return;
    }
    paramInt = i2;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("param_fail_reason", 0);
    }
    onUploadContactNotBind(paramBoolean, paramInt);
  }
  
  protected void onResendSms(boolean paramBoolean) {}
  
  protected void onUpdateContact(boolean paramBoolean, int paramInt) {}
  
  protected void onUpdateContactNotBind(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadContact(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadContactNotBind(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadProgressUpdated(int paramInt1, int paramInt2) {}
  
  protected void onVerifyBindSms(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */