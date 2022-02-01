package com.tencent.mobileqq.phonecontact.processor;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class PhoneContactProcessor
  implements IPhoneContactProcessor
{
  private AppInterface a;
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    LoginUserGuideHelper.a(paramString, paramJSONObject);
  }
  
  public void a(List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "updateAddContactList");
    }
    MqqHandler localMqqHandler = this.a.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(4);
      Message localMessage = localMqqHandler.obtainMessage(4);
      localMessage.obj = paramList;
      localMqqHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((PhoneUnityManager)this.a.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a = true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (UserguideActivity.a(this.a.getApp(), this.a.getCurrentAccountUin()))
      {
        QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| showUserGuideThisTime");
        return false;
      }
      if (PhoneNumLoginImpl.a().a())
      {
        QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| isPhoneNumLogin");
        return false;
      }
      if (PortalManager.b())
      {
        QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| forbid alert");
        return false;
      }
    }
    boolean bool2 = ((LoginWelcomeManager)this.a.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1;
    if ((localBaseActivity != null) && (localBaseActivity.isFinishing())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowBindPhonePage| isBound: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", showNewUserGuide: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", sIsUserGuiderShowed: ");
      localStringBuilder.append(UserguideActivity.b);
      localStringBuilder.append(", topActivity: ");
      localStringBuilder.append(localBaseActivity);
      localStringBuilder.append(", isFinishing: ");
      localStringBuilder.append(bool1);
      QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, localStringBuilder.toString());
    }
    if ((localBaseActivity != null) && (!bool1) && (localBaseActivity.getAppRuntime() == this.a)) {
      return (!(localBaseActivity instanceof UserguideActivity)) && (!bool2) && (!UserguideActivity.b);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, RespondQueryQQBindingStat paramRespondQueryQQBindingStat, boolean paramBoolean4, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      long l = paramRespondQueryQQBindingStat.lastUsedFlag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBindPhonePage| fromNotBind: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", isFirstRun: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", needToJumpBind: ");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append(", isAutoUpload: ");
      ((StringBuilder)localObject).append(paramBoolean4);
      ((StringBuilder)localObject).append(", unbindGap: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", lastUsedFlag: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if ((!(BaseActivity.sTopActivity instanceof BindNumberActivity)) && (!(BaseActivity.sTopActivity instanceof BindVerifyActivity)))
    {
      if (paramBoolean1)
      {
        if ((paramInt == 3) && (paramRespondQueryQQBindingStat != null) && (paramRespondQueryQQBindingStat.lastUsedFlag == 3L))
        {
          paramRespondQueryQQBindingStat = new Intent(this.a.getApplicationContext(), PhoneMatchActivity.class);
          paramRespondQueryQQBindingStat.putExtra("kSrouce", 16);
          paramBoolean4 = false;
          break label341;
        }
      }
      else if (paramInt != 6)
      {
        if ((paramInt == 7) && (!paramBoolean4) && (paramRespondQueryQQBindingStat != null) && (!paramRespondQueryQQBindingStat.isStopFindMatch))
        {
          localObject = new Intent(this.a.getApplicationContext(), PhoneMatchActivity.class);
          paramRespondQueryQQBindingStat = (RespondQueryQQBindingStat)localObject;
          paramBoolean4 = paramBoolean3;
          if (!paramBoolean2) {
            break label341;
          }
          ((Intent)localObject).putExtra("key_from_contact_first", true);
          paramRespondQueryQQBindingStat = (RespondQueryQQBindingStat)localObject;
          paramBoolean4 = paramBoolean3;
          break label341;
        }
      }
      else if ((paramRespondQueryQQBindingStat != null) && (paramRespondQueryQQBindingStat.lastUsedFlag == 3L))
      {
        paramRespondQueryQQBindingStat = new Intent(this.a.getApplicationContext(), PhoneMatchActivity.class);
        paramBoolean4 = paramBoolean3;
        break label341;
      }
      paramRespondQueryQQBindingStat = null;
      paramBoolean4 = paramBoolean3;
      label341:
      if (paramRespondQueryQQBindingStat != null)
      {
        if (paramLong < 3600000L)
        {
          paramRespondQueryQQBindingStat = new StringBuilder();
          paramRespondQueryQQBindingStat.append("showBindPhonePage| < minGap, unbindGap: ");
          paramRespondQueryQQBindingStat.append(paramLong);
          QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, paramRespondQueryQQBindingStat.toString());
          return false;
        }
        localObject = paramRespondQueryQQBindingStat.getComponent().getClassName();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).equals(BindNumberActivity.class.getName()))
          {
            localObject = "0X80095EB";
            break label455;
          }
          if (((String)localObject).equals(PhoneMatchActivity.class.getName()))
          {
            localObject = "0X80095EA";
            break label455;
          }
        }
        localObject = "";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ReportController.b(this.a, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        }
        localObject = BaseActivity.sTopActivity;
        if ((localObject != null) && (!((AppActivity)localObject).isFinishing()) && (((AppActivity)localObject).getAppRuntime() == this.a))
        {
          ((AppActivity)localObject).startActivity(paramRespondQueryQQBindingStat);
          ((AppActivity)localObject).overridePendingTransition(2130772342, 2130772004);
          paramRespondQueryQQBindingStat = new StringBuilder();
          paramRespondQueryQQBindingStat.append("contact_bind_info");
          paramRespondQueryQQBindingStat.append(this.a.getAccount());
          paramRespondQueryQQBindingStat = paramRespondQueryQQBindingStat.toString();
          paramRespondQueryQQBindingStat = this.a.getApp().getSharedPreferences(paramRespondQueryQQBindingStat, 0);
          if ((paramBoolean1) && (paramBoolean4))
          {
            paramRespondQueryQQBindingStat.edit().putString("last_phone_version_popped_notbind", "8.7.0").apply();
            return true;
          }
          if ((!paramBoolean1) && (paramBoolean2))
          {
            paramRespondQueryQQBindingStat.edit().putString("last_phone_version_popped", "8.7.0").apply();
            return true;
          }
          paramRespondQueryQQBindingStat.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).apply();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "showBindPhonePage topActivity invalid");
        }
      }
      label455:
      return false;
    }
    paramRespondQueryQQBindingStat = new StringBuilder();
    paramRespondQueryQQBindingStat.append("showBindPhonePage ");
    paramRespondQueryQQBindingStat.append(BaseActivity.sTopActivity);
    QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, paramRespondQueryQQBindingStat.toString());
    return false;
  }
  
  public void b()
  {
    BannerManager.a().a(MobileUnityBannerProcessor.a, 0, null);
  }
  
  public void c()
  {
    this.a.getPreferences().edit().putInt("system_msg_list_showcount", 0).putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "updateContactList");
    }
    MqqHandler localMqqHandler = this.a.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(1);
      localMqqHandler.sendEmptyMessageDelayed(1, 100L);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "reloadContactList");
    }
    MqqHandler localMqqHandler = (MqqHandler)((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getContactsInnerFrameHandler(this.a);
    if (localMqqHandler != null)
    {
      int i = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getContactsInnerFrame_RELOAD_CONTACTS_Value();
      localMqqHandler.removeMessages(i);
      localMqqHandler.sendEmptyMessageDelayed(i, 100L);
    }
  }
  
  public void f()
  {
    AppInterface localAppInterface = this.a;
    if (((localAppInterface instanceof QQAppInterface)) && (localAppInterface.isLogin()))
    {
      localAppInterface = this.a;
      QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
      ((IAppBadgeService)localAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.processor.PhoneContactProcessor
 * JD-Core Version:    0.7.0.1
 */