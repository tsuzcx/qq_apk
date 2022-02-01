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
import anvx;
import auuv;
import bisl;
import bjcg;
import bjfb;
import bjfc;
import bjfe;
import bjff;
import bjgg;
import bjhg;
import bjhh;
import bjpl;
import bjpy;
import bjqa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  protected bisl a;
  private bjff jdField_a_of_type_Bjff;
  private bjgg jdField_a_of_type_Bjgg = new bjfc(this);
  private bjqa jdField_a_of_type_Bjqa;
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
  private long d;
  private long e;
  private long f;
  
  private String a()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      return String.valueOf(this.jdField_a_of_type_Long);
    }
    return String.valueOf(this.jdField_b_of_type_Long);
  }
  
  private List<bjcg> a()
  {
    Object localObject = this.jdField_a_of_type_Bjqa.a(a());
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bjcg localbjcg1 = (bjcg)((Iterator)localObject).next();
      bjcg localbjcg2 = new bjcg();
      localbjcg2.jdField_a_of_type_Int = localbjcg1.jdField_a_of_type_Int;
      if ((localbjcg2.jdField_a_of_type_Int == 2) || (localbjcg2.jdField_a_of_type_Int == 3))
      {
        localbjcg2.jdField_b_of_type_JavaLangString = localbjcg1.jdField_b_of_type_JavaLangString;
        localbjcg2.jdField_b_of_type_Int = localbjcg1.jdField_b_of_type_Int;
        localbjcg2.jdField_a_of_type_Boolean = localbjcg1.jdField_a_of_type_Boolean;
        localbjcg2.jdField_a_of_type_JavaLangString = localbjcg1.jdField_a_of_type_JavaLangString;
        if (localbjcg2.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localbjcg2.jdField_b_of_type_Boolean = bool;
          localArrayList.add(localbjcg2);
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
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = this.jdField_a_of_type_Bjqa.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((bjpl)localObject).jdField_a_of_type_JavaLangString, a(), paramInt, new bjfe(this));
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
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      bjhh.a(getActivity(), anvx.a(2131694461), new bjfb(this));
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
    bjpl localbjpl = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a());
    auuv.a("KEY_AUTHORIZE_REQUEST", localbjpl, paramBoolean);
    if ((localbjpl != null) && (localbjpl.jdField_a_of_type_JavaLangString != null)) {
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (String str = "0X800B65E";; str = "0X800B65F")
    {
      bjhg.a(localbjpl.jdField_a_of_type_JavaLangString, str);
      return;
    }
  }
  
  private boolean b()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private void c()
  {
    bjpl localbjpl = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a());
    auuv.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localbjpl);
    auuv.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localbjpl);
    auuv.a("KEY_LOGIN_STAGE_3_TOTAL");
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
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getActivity(), 0, 2131561449, 17);
        this.jdField_a_of_type_Bisl.a(-1);
        this.jdField_a_of_type_Bisl.show();
        return;
      }
    } while (this.jdField_a_of_type_Bisl.isShowing());
    this.jdField_a_of_type_Bisl.show();
  }
  
  private void e()
  {
    bjhh.a(getActivity(), anvx.a(2131707307), false);
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
    while ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
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
    ForwardUtils.reportAuthorityTotal(paramInt, (bjpl)localObject);
    String str = a();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((bjpl)localObject).jdField_a_of_type_JavaLangString)
    {
      ForwardUtils.reportLoginResult(paramInt, str, (String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_cancel_auth", 0);
      ((Intent)localObject).putExtra("key_error_code", paramInt);
      ((Intent)localObject).putExtra("key_error_msg", paramString2);
      ((Intent)localObject).putExtra("key_error_detail", paramString3);
      ((Intent)localObject).putExtra("key_response", paramString1);
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
      getActivity().setResult(102, (Intent)localObject);
      getActivity().finish();
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
  }
  
  protected void a(String paramString)
  {
    String str = a();
    bjpl localbjpl = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(str);
    SharedPreferences.Editor localEditor;
    if (localbjpl != null)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString, localbjpl.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(localbjpl.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    localEditor.putString(str + ":" + localbjpl.jdField_a_of_type_JavaLangString, paramString);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559723, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_Bjqa = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363329);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131364257);
    paramLayoutInflater.findViewById(2131379099).setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362854));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131365072);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bisl = new bisl(getActivity(), 0, 2131561449, 17);
    this.jdField_a_of_type_Bisl.a(-1);
    this.jdField_a_of_type_Bjff = new bjff(this, null);
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Long = Long.parseLong(paramViewGroup.getStringExtra("appId"));
    this.jdField_b_of_type_Long = ForwardUtils.parseLong(paramViewGroup.getStringExtra("key_proxy_appid"));
    this.jdField_a_of_type_JavaLangString = paramViewGroup.getStringExtra("pkg_name");
    this.jdField_c_of_type_Long = paramViewGroup.getLongExtra("vid", 0L);
    this.f = paramViewGroup.getLongExtra("login_cost", 0L);
    this.e = paramViewGroup.getLongExtra("authListCostTime", 0L);
    this.d = paramViewGroup.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    this.jdField_a_of_type_Boolean = paramViewGroup.getBooleanExtra("is_from_qr_login", false);
    ((ListView)paramLayoutInflater.findViewById(2131372563)).setAdapter(this.jdField_a_of_type_Bjff);
    this.jdField_a_of_type_Bjff.a(a());
    a(paramViewGroup.getBooleanExtra("hasIcon", false));
    paramViewGroup = paramViewGroup.getStringExtra("appName");
    if (!TextUtils.isEmpty(paramViewGroup)) {
      ((TextView)paramLayoutInflater.findViewById(2131362856)).setText(paramViewGroup);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = bjpy.a(getActivity(), "uin_openid_store");
    this.jdField_b_of_type_AndroidContentSharedPreferences = bjpy.a(getActivity(), "openid_encrytoken");
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "onCreateView mCurrentAppId=", Long.valueOf(this.jdField_a_of_type_Long), ", mProxyCurrentAppId=", Long.valueOf(this.jdField_b_of_type_Long), ", appName=", paramViewGroup });
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = null;
    this.jdField_a_of_type_Bjgg = null;
    this.jdField_a_of_type_Bjqa = null;
  }
  
  public void onResume()
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "-->onResume--isSetStatusColor=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    super.onResume();
    if (!this.jdField_b_of_type_Boolean)
    {
      bjhh.a(getActivity());
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */