package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BindGroupFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new BindGroupFragment.5(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private BindGroupAdapter jdField_a_of_type_ComTencentOpenAgentBindGroupAdapter;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  
  private int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  private List<TroopInfo> a()
  {
    Object localObject2 = new ArrayList(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b());
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(localObject1)))) {
        localArrayList.add(localTroopInfo);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCreateTroopList list size: ");
    ((StringBuilder)localObject1).append(localArrayList.size());
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  private void a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString, 0).b(a());
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterAIO, troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" action: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
    localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", 1);
    ((Intent)localObject).putExtra("fromThirdAppByOpenSDK", true);
    ((Intent)localObject).putExtra("action", paramInt);
    ((Intent)localObject).putExtra("appid", this.jdField_d_of_type_JavaLangString);
    ((Intent)localObject).putExtra("app_name", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("pkg_name", this.e);
    startActivity((Intent)localObject);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
    paramString2 = new BindGroupFragment.4(this, paramString2);
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131701340), paramString2);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131701330), paramString2);
    localQQCustomDialog.show();
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBundleExtra("key_params");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject == null)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, "doOnCreate params is null.");
      return false;
    }
    this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("appid");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("organization_name");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("organization_id");
    this.e = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {}
    try
    {
      Integer.valueOf(this.jdField_d_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", openId: ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", return.");
    QLog.d("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
    return false;
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369204));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369233));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369249));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370516));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new BindGroupFragment.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690652));
    Object localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((TextView)localObject).setText(HardCodeUtil.a(2131701334));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setTextColor(getResources().getColor(2131167142));
    ((TextView)localObject).setPadding(AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()), 0, AIOUtils.b(8.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    localObject = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559951, null);
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupAdapter = new BindGroupAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetListView, 4, true);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentBindGroupAdapter);
    this.jdField_a_of_type_JavaUtilList.addAll(a());
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupAdapter.a(this.jdField_a_of_type_JavaUtilList);
    ((View)localObject).setOnClickListener(new BindGroupFragment.2(this));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new BindGroupFragment.3(this));
  }
  
  private void b(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, paramString, 0).b(a());
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void e()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject = new ArrayList();
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      int k = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = k;
      if ((k >= j) || (i > 100)) {
        break;
      }
      ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
      i += 1;
    }
    if (this.jdField_a_of_type_Int == j) {
      bool = true;
    }
    ((ITroopTokenHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a((List)localObject, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTroopProfilePageByPage isLastPage: ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onCreateView.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559949, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    if (!a())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    else
    {
      b();
      c();
      c(HardCodeUtil.a(2131701337));
      e();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnNewIntent intent is null: ");
    boolean bool;
    if (paramIntent == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, localStringBuilder.toString());
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("action", 0);
      paramIntent = paramIntent.getStringExtra("troop_uin");
      if (i == 2)
      {
        a(paramIntent, 2);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment
 * JD-Core Version:    0.7.0.1
 */