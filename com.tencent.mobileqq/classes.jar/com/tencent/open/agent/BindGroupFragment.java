package com.tencent.open.agent;

import aciy;
import ajjy;
import ajtg;
import ajuc;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import babr;
import bafb;
import bbms;
import bbmy;
import bbva;
import bbvh;
import bbvi;
import bbvj;
import bbvk;
import bbvl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BindGroupFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private ajuc jdField_a_of_type_Ajuc = new bbvl(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  private bbva jdField_a_of_type_Bbva;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  private List<TroopInfo> a()
  {
    Object localObject = new ArrayList(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a());
    ArrayList localArrayList = new ArrayList();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(str)))) {
        localArrayList.add(localTroopInfo);
      }
    }
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "getCreateTroopList list size: " + localArrayList.size());
    return localArrayList;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString, 0).b(a());
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "enterAIO, troopUin: " + paramString + " action: " + paramInt);
    Intent localIntent = aciy.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("fromThirdAppByOpenSDK", true);
    localIntent.putExtra("action", paramInt);
    localIntent.putExtra("appid", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("app_name", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pkg_name", this.e);
    startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2)
  {
    bafb localbafb = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    paramString2 = new bbvk(this, paramString2);
    localbafb.setMessage(paramString1);
    localbafb.setNegativeButton(ajjy.a(2131635328), paramString2);
    localbafb.setPositiveButton(ajjy.a(2131635318), paramString2);
    localbafb.show();
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, "doOnCreate params is null.");
      return false;
    }
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("organization_name");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("organization_id");
    this.e = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      QLog.d("TroopAbility.BindGroup.Fragment", 1, "appId: " + this.jdField_d_of_type_JavaLangString + ", openId: " + this.jdField_c_of_type_JavaLangString + ", return.");
      return false;
    }
    try
    {
      Integer.valueOf(this.jdField_d_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302804));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302806));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302832));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302847));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303941));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bbvh(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131624921));
    Object localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    ((TextView)localObject).setText(ajjy.a(2131635322));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setTextColor(getResources().getColor(2131101336));
    ((TextView)localObject).setPadding(aciy.a(16.0F, getResources()), aciy.a(16.0F, getResources()), 0, aciy.a(8.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131494181, null);
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Bbva = new bbva(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetListView, 4, true);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bbva);
    this.jdField_a_of_type_JavaUtilList.addAll(a());
    this.jdField_a_of_type_Bbva.a(this.jdField_a_of_type_JavaUtilList);
    ((View)localObject).setOnClickListener(new bbvi(this));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new bbvj(this));
  }
  
  private void b(String paramString)
  {
    bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramString, 0).b(a());
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, a());
    }
    a();
    this.jdField_a_of_type_Bbms.a(paramString);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) {
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
  }
  
  private void e()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      int k = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = k;
      if ((k >= j) || (i > 100)) {
        break;
      }
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
      i += 1;
    }
    if (this.jdField_a_of_type_Int == j) {
      bool = true;
    }
    ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(localArrayList, bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "getTroopProfilePageByPage isLastPage: " + bool);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onCreateView.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494179, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    if (!a())
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return this.jdField_a_of_type_AndroidViewView;
    }
    b();
    c();
    c(ajjy.a(2131635325));
    e();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("doOnNewIntent intent is null: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, bool);
      super.onNewIntent(paramIntent);
      if (paramIntent != null)
      {
        int i = paramIntent.getIntExtra("action", 0);
        paramIntent = paramIntent.getStringExtra("troop_uin");
        if (i == 2)
        {
          a(paramIntent, 2);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment
 * JD-Core Version:    0.7.0.1
 */