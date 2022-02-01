package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.auth.ISelectPermissionContract.Presenter;
import com.tencent.open.agent.auth.ISelectPermissionContract.View;
import com.tencent.open.agent.auth.model.ILocalDataSource;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SelectPermissionPresenter
  implements ISelectPermissionContract.Presenter
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ISelectPermissionContract.View jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$View;
  private ILocalDataSource jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource;
  private AuthCallback jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = new SelectPermissionPresenter.3(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Permission> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public SelectPermissionPresenter(ISelectPermissionContract.View paramView, ILocalDataSource paramILocalDataSource)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$View = paramView;
    this.jdField_a_of_type_AndroidAppActivity = paramView.a();
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource = paramILocalDataSource;
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private void a(int paramInt)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(b());
    AccountManage.a().a(localAccountInfo.jdField_a_of_type_JavaLangString, b(), paramInt, new SelectPermissionPresenter.4(this));
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = AuthMemoryCache.a().a(b());
    AuthReporter.a(paramInt, (AccountInfo)localObject);
    String str = b();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((AccountInfo)localObject).jdField_a_of_type_JavaLangString;
    }
    AuthReporter.a(paramInt, str, (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_cancel_auth", 0);
    ((Intent)localObject).putExtra("key_error_code", paramInt);
    ((Intent)localObject).putExtra("key_error_msg", paramString2);
    ((Intent)localObject).putExtra("key_error_detail", paramString3);
    ((Intent)localObject).putExtra("key_response", paramString1);
    SSOLog.a("SelectPermissionPresenter", new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
    this.jdField_a_of_type_AndroidAppActivity.setResult(102, (Intent)localObject);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$View.b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(paramString2);
    if (localAccountInfo != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource.a(paramString1, paramString2, localAccountInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    return (localActivity == null) || (localActivity.isFinishing());
  }
  
  private String b()
  {
    long l2 = this.b;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.jdField_a_of_type_Long;
    }
    return String.valueOf(l1);
  }
  
  private void b()
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(b());
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$View.a();
    ThreadManager.executeOnNetWorkThread(new SelectPermissionPresenter.2(this));
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource.a(paramString1, paramString2);
  }
  
  private void b(boolean paramBoolean)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(b());
    AuthReporter.a("KEY_AUTHORIZE_REQUEST", localAccountInfo, paramBoolean);
    if ((localAccountInfo != null) && (localAccountInfo.jdField_a_of_type_JavaLangString != null))
    {
      String str;
      if (paramBoolean) {
        str = "0X800B65E";
      } else {
        str = "0X800B65F";
      }
      AuthReporter.a(localAccountInfo.jdField_a_of_type_JavaLangString, str);
    }
    if (paramBoolean) {
      AuthorityUtil.a("0X800BA80");
    }
  }
  
  private String c()
  {
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  private void c()
  {
    AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131707855), false);
    if (a())
    {
      SSOLog.a("SelectPermissionPresenter", new Object[] { "finishAndToLogin but Activity isFinishing" });
      return;
    }
    SSOLog.a("SelectPermissionPresenter", new Object[] { "finishAndToLogin" });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_need_login", 1);
    this.jdField_a_of_type_AndroidAppActivity.setResult(102, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Permission)localIterator.next()).jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString();
  }
  
  public List<Permission> a()
  {
    Object localObject = AuthMemoryCache.a().a(b());
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Permission localPermission1 = (Permission)((Iterator)localObject).next();
      Permission localPermission2 = new Permission();
      localPermission2.jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
      if ((localPermission2.jdField_a_of_type_Int == 2) || (localPermission2.jdField_a_of_type_Int == 3))
      {
        localPermission2.jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
        localPermission2.jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
        localPermission2.jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
        localPermission2.jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
        boolean bool;
        if (localPermission2.jdField_a_of_type_Int == 2) {
          bool = true;
        } else {
          bool = false;
        }
        localPermission2.jdField_b_of_type_Boolean = bool;
        this.jdField_a_of_type_JavaUtilList.add(localPermission2);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    SSOLog.a("SelectPermissionPresenter", new Object[] { "doAuth" });
    this.jdField_a_of_type_Int = 0;
    b();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pkg_name");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_from_qr_login", false);
    this.f = paramIntent.getLongExtra("vid", 0L);
    this.jdField_a_of_type_Long = ParseUtil.a(paramIntent.getStringExtra("appId"));
    this.b = ParseUtil.a(paramIntent.getStringExtra("key_proxy_appid"));
    this.e = paramIntent.getLongExtra("login_cost", 0L);
    this.d = paramIntent.getLongExtra("authListCostTime", 0L);
    this.c = paramIntent.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    SSOLog.a("SelectPermissionPresenter", new Object[] { "onCreateView3 mCurrentAppId=", Long.valueOf(this.jdField_a_of_type_Long), ", mProxyCurrentAppId=", Long.valueOf(this.b), ", mIsFromQrLogin=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ThreadManager.executeOnFileThread(new SelectPermissionPresenter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter
 * JD-Core Version:    0.7.0.1
 */