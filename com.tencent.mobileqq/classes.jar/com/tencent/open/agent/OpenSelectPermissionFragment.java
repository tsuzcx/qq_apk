package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.SSOAccountObserver;

public class OpenSelectPermissionFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected SharedPreferences a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected QQProgressDialog a;
  private OpenSelectPermissionFragment.PermissionAdapter jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter;
  private AuthCallback jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = new OpenSelectPermissionFragment.4(this);
  private OpenSdkVirtualManager jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private SSOAccountObserver jdField_a_of_type_MqqObserverSSOAccountObserver;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  protected SharedPreferences b;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  private String a()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      return String.valueOf(this.jdField_a_of_type_Long);
    }
    return String.valueOf(this.jdField_b_of_type_Long);
  }
  
  private String a(List<CardContainer.Permission> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList == null) {
      return localStringBuilder.toString();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((CardContainer.Permission)paramList.next()).jdField_a_of_type_JavaLangString).append(" ");
    }
    return localStringBuilder.toString();
  }
  
  private List<CardContainer.Permission> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(a());
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CardContainer.Permission localPermission1 = (CardContainer.Permission)((Iterator)localObject).next();
      CardContainer.Permission localPermission2 = new CardContainer.Permission();
      localPermission2.jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
      if ((localPermission2.jdField_a_of_type_Int == 2) || (localPermission2.jdField_a_of_type_Int == 3))
      {
        localPermission2.jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
        localPermission2.jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
        localPermission2.jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
        localPermission2.jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
        if (localPermission2.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localPermission2.jdField_b_of_type_Boolean = bool;
          localArrayList.add(localPermission2);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    Object localObject = a();
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a((String)localObject);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((AccountInfo)localObject).jdField_a_of_type_JavaLangString, a(), paramInt, new OpenSelectPermissionFragment.5(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ThreadManager.executeOnFileThread(new OpenSelectPermissionFragment.1(this));
  }
  
  private boolean a()
  {
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      AuthorityUtil.a(getActivity(), HardCodeUtil.a(2131694678), new OpenSelectPermissionFragment.2(this));
      return false;
    }
    return true;
  }
  
  private String b()
  {
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  private void b()
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "doAuth");
    this.jdField_a_of_type_Int = 0;
    c();
  }
  
  private void b(boolean paramBoolean)
  {
    AccountInfo localAccountInfo = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a());
    ForwardStatisticsReporter.a("KEY_AUTHORIZE_REQUEST", localAccountInfo, paramBoolean);
    if ((localAccountInfo != null) && (localAccountInfo.jdField_a_of_type_JavaLangString != null)) {
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (String str = "0X800B65E";; str = "0X800B65F")
    {
      AuthReporter.a(localAccountInfo.jdField_a_of_type_JavaLangString, str);
      return;
    }
  }
  
  private boolean b()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private void c()
  {
    AccountInfo localAccountInfo = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a());
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localAccountInfo);
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localAccountInfo);
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
    d();
    ThreadManager.executeOnNetWorkThread(new OpenSelectPermissionFragment.3(this));
  }
  
  private void d()
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "showLoading");
    if (b()) {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "showLoading getActivity() == null || getActivity().isFinishing()");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561557, 17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void e()
  {
    AuthorityUtil.a(getActivity(), HardCodeUtil.a(2131707832), false);
    if (b())
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "finishAndToLogin but Activity isFinishing");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "finishAndToLogin");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_need_login", 1);
    getActivity().setResult(102, localIntent);
    getActivity().finish();
  }
  
  protected void a()
  {
    if (b()) {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "dismissDialogProgress activity isFinishing");
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "dismissDialogProgress Exception", localException);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a());
    ForwardUtils.a(paramInt, (AccountInfo)localObject);
    String str = a();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AccountInfo)localObject).jdField_a_of_type_JavaLangString)
    {
      ForwardUtils.a(paramInt, str, (String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_cancel_auth", 0);
      ((Intent)localObject).putExtra("key_error_code", paramInt);
      ((Intent)localObject).putExtra("key_error_msg", paramString2);
      ((Intent)localObject).putExtra("key_error_detail", paramString3);
      ((Intent)localObject).putExtra("key_response", paramString1);
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
      getActivity().setResult(102, (Intent)localObject);
      getActivity().finish();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
  }
  
  protected void a(String paramString)
  {
    String str = a();
    AccountInfo localAccountInfo = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(str);
    SharedPreferences.Editor localEditor;
    if (localAccountInfo != null)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString, localAccountInfo.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(localAccountInfo.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    localEditor.putString(str + ":" + localAccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_c_of_type_AndroidViewView)
      {
        if (a()) {
          b();
        }
      }
      else if (paramView == this.jdField_b_of_type_AndroidViewView)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_cancel_auth", 1);
        getActivity().setResult(102, localIntent);
        getActivity().finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559799, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363408);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131364364);
    paramLayoutInflater.findViewById(2131379533).setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362895));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131365207);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561557, 17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter = new OpenSelectPermissionFragment.PermissionAdapter(this, null);
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_Long = Long.parseLong(paramBundle.getStringExtra("appId"));
    this.jdField_b_of_type_Long = ForwardUtils.a(paramBundle.getStringExtra("key_proxy_appid"));
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("pkg_name");
    this.jdField_c_of_type_Long = paramBundle.getLongExtra("vid", 0L);
    this.f = paramBundle.getLongExtra("login_cost", 0L);
    this.e = paramBundle.getLongExtra("authListCostTime", 0L);
    this.d = paramBundle.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_from_qr_login", false);
    ((ListView)paramLayoutInflater.findViewById(2131372874)).setAdapter(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter);
    paramViewGroup = a();
    this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter.a(paramViewGroup);
    a(paramBundle.getBooleanExtra("hasIcon", false));
    paramBundle = paramBundle.getStringExtra("appName");
    if (!TextUtils.isEmpty(paramBundle)) {
      ((TextView)paramLayoutInflater.findViewById(2131362897)).setText(paramBundle);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(getActivity(), "uin_openid_store");
    this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(getActivity(), "openid_encrytoken");
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "onCreateView mCurrentAppId=", Long.valueOf(this.jdField_a_of_type_Long), ", mProxyCurrentAppId=", Long.valueOf(this.jdField_b_of_type_Long), ", appName=", paramBundle });
    AuthorityUtil.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, "0X800B935", new String[] { "", "", paramBundle, a(paramViewGroup) });
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = null;
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = null;
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = null;
  }
  
  public void onResume()
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "-->onResume--isSetStatusColor=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    super.onResume();
    if (!this.jdField_b_of_type_Boolean)
    {
      AuthorityUtil.a(getActivity());
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */