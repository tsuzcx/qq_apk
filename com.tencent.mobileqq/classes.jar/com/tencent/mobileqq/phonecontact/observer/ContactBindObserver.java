package com.tencent.mobileqq.phonecontact.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import java.util.List;
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
      return HardCodeUtil.a(2131900620);
    }
    if ((paramInt != 219) && (paramInt != 216))
    {
      if (paramInt == 224) {
        return HardCodeUtil.a(2131900618);
      }
      if (paramInt == 223) {
        return HardCodeUtil.a(2131900619);
      }
      return HardCodeUtil.a(2131900621);
    }
    return HardCodeUtil.a(2131900624);
  }
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onCancelBind(boolean paramBoolean) {}
  
  protected void onDisableMobileMatch(boolean paramBoolean) {}
  
  protected void onGetBindUinWithPhone(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  protected void onGetNewerGuideRecommended(List<RecommendContactInfo> paramList) {}
  
  protected void onGetNewerGuideRecommendedNotBind(List<RecommendContactInfo> paramList) {}
  
  protected void onHideContact(boolean paramBoolean) {}
  
  protected void onPushRecommendUpdate(boolean paramBoolean) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt) {}
  
  protected void onQueryLastLoginInfo(boolean paramBoolean) {}
  
  protected void onReBindMblWTLogin(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onRebindMobile(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    if (paramInt != 12)
    {
      if (paramInt != 23)
      {
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramInt != 40)
        {
          if (paramInt != 100)
          {
            if (paramInt != 19)
            {
              if (paramInt != 20)
              {
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 38: 
                      paramInt = j;
                      if (paramBundle != null) {
                        paramInt = paramBundle.getInt("param_fail_reason", 0);
                      }
                      onUpdateContactNotBind(paramBoolean, paramInt);
                      return;
                    case 37: 
                      paramInt = k;
                      if (paramBundle != null) {
                        paramInt = paramBundle.getInt("param_fail_reason", 0);
                      }
                      onUploadContactNotBind(paramBoolean, paramInt);
                      return;
                    case 36: 
                      if (paramBundle != null) {
                        localObject1 = paramBundle.getParcelableArrayList(RecommendContactInfo.class.getSimpleName());
                      }
                      onGetNewerGuideRecommended((List)localObject1);
                      return;
                    case 35: 
                      onBindMobile(paramBoolean, paramBundle);
                      return;
                    case 34: 
                      onHideContact(paramBoolean);
                      return;
                    case 33: 
                      onDisableMobileMatch(paramBoolean);
                      return;
                    case 32: 
                      onQueryLastLoginInfo(paramBoolean);
                      return;
                    case 31: 
                      paramInt = m;
                      if (paramBundle != null) {
                        paramInt = paramBundle.getInt("param_fail_reason", 0);
                      }
                      onUploadAndQueryContact(paramBoolean, paramInt);
                      return;
                    }
                    paramInt = n;
                    if (paramBoolean) {
                      paramInt = paramBundle.getInt("param_update_flag");
                    }
                    onQueryContactList(paramBoolean, paramInt);
                    return;
                  case 28: 
                    if ((paramBundle != null) && (paramBundle.getBoolean("hasUpdate"))) {
                      paramInt = i;
                    } else {
                      paramInt = 0;
                    }
                    onQueryContactList(paramBoolean, paramInt);
                    return;
                  case 27: 
                    onReBindMblWTLogin(paramBoolean, paramBundle.getBoolean("bind_state", false));
                    return;
                  }
                  onGetBindUinWithPhone(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
                  return;
                case 17: 
                  onResendSms(paramBoolean);
                  return;
                case 16: 
                  if (paramBundle != null) {
                    paramInt = paramBundle.getInt("k_result");
                  } else {
                    paramInt = -1;
                  }
                  onVerifyBindSms(paramBoolean, paramInt);
                  return;
                case 15: 
                  paramInt = i1;
                  if (paramBundle != null) {
                    paramInt = paramBundle.getInt("param_fail_reason", 0);
                  }
                  onUpdateContact(paramBoolean, paramInt);
                  return;
                }
                paramInt = i2;
                if (paramBundle != null) {
                  paramInt = paramBundle.getInt("param_fail_reason", 0);
                }
                onUploadContact(paramBoolean, paramInt);
                return;
              }
              onCancelBind(paramBoolean);
              return;
            }
            onRebindMobile(paramBoolean, paramBundle);
            return;
          }
          onUploadProgressUpdated(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
          return;
        }
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = paramBundle.getParcelableArrayList(RecommendContactInfo.class.getSimpleName());
        }
        onGetNewerGuideRecommendedNotBind((List)localObject1);
        return;
      }
      onPushRecommendUpdate(paramBoolean);
      return;
    }
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
  }
  
  protected void onResendSms(boolean paramBoolean) {}
  
  protected void onUpdateContact(boolean paramBoolean, int paramInt) {}
  
  protected void onUpdateContactNotBind(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadContact(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadContactNotBind(boolean paramBoolean, int paramInt) {}
  
  protected void onUploadProgressUpdated(int paramInt1, int paramInt2) {}
  
  protected void onVerifyBindSms(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.observer.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */