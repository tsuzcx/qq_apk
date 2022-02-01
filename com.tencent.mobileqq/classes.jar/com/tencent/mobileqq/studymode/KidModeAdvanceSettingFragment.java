package com.tencent.mobileqq.studymode;

import amtj;
import amux;
import amvb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import bcnh;
import bcni;
import bcnj;
import bcnk;
import bcnl;
import bcnm;
import bcnn;
import bcno;
import bcnp;
import bcnq;
import bcnr;
import bcns;
import bcnt;
import bcnu;
import bcnv;
import bcoo;
import bfur;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class KidModeAdvanceSettingFragment
  extends IphoneTitleBarFragment
{
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new bcnn(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcnu jdField_a_of_type_Bcnu = new bcnh(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new bcnp(this);
  private FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new bcnk(this);
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new bcnl(this);
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener d = new bcnm(this);
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369561));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369562));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369563));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131369559));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131369560);
    b();
    f();
    g();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      bcnv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      return;
    }
    int i = bcoo.b();
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 1, new Object[] { "isBindPhoneStatus: ", Integer.valueOf(i), ", setUrl: ", bcoo.b() });
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label109;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.a()) {
        break;
      }
      c(paramInt);
      return;
    }
    b(paramInt);
    return;
    label109:
    h();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener = null;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, "updateAdvanceSettingSwitch mask: " + paramInt + ", isChecked: " + paramBoolean);
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((FormSwitchItem)localObject).setEnabled(true);
        if (((FormSwitchItem)localObject).a() != paramBoolean) {
          a((FormSwitchItem)localObject, paramBoolean, localOnCheckedChangeListener);
        }
      }
      return;
      localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localOnCheckedChangeListener = this.d;
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localOnCheckedChangeListener = this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
      continue;
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localOnCheckedChangeListener = this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      localOnCheckedChangeListener = this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.a(paramContext, localIntent, KidModeAdvanceSettingFragment.class);
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
  }
  
  private void b()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374314)).setText(amtj.a(2131693261));
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131374315);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131374316)).inflate();
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131377583));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimensionPixelSize(2131296772));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT);
    c();
  }
  
  private void b(int paramInt)
  {
    bcoo.a(-1);
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.a()) {}
    for (int i = 1;; i = 0)
    {
      bcnv.a(localQQAppInterface, paramInt, i);
      return;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    FormSwitchItem localFormSwitchItem;
    switch (paramInt)
    {
    default: 
      localObject = null;
      localFormSwitchItem = null;
      if ((localFormSwitchItem != null) && (localObject != null))
      {
        if (NetworkUtil.isNetSupport(getActivity())) {
          break label153;
        }
        QLog.d("IphoneTitleBarFragment", 1, "network error");
        if (paramBoolean) {
          break label148;
        }
      }
      break;
    }
    label148:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(localFormSwitchItem, paramBoolean, (CompoundButton.OnCheckedChangeListener)localObject);
      QQToast.a(getActivity(), 1, 2131693961, 0).a();
      return;
      localFormSwitchItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localObject = this.d;
      break;
      localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localObject = this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
      break;
      localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      localObject = this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
      break;
    }
    label153:
    Object localObject = getActivity().app;
    if (paramBoolean) {}
    for (;;)
    {
      bcnv.a((QQAppInterface)localObject, paramInt, i);
      return;
      i = 0;
    }
  }
  
  private void c()
  {
    int i = amvb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(amtj.a(2131693260), new Object[] { String.valueOf(i) }));
    }
  }
  
  private void c(int paramInt)
  {
    QQCustomDialog localQQCustomDialog = bfur.a(getActivity(), 230).setTitle(amtj.a(2131693252)).setMessage(getString(2131693251, new Object[] { bcoo.a() })).setNegativeButton(amtj.a(2131693274), new bcni(this)).setPositiveButton(amtj.a(2131693265), new bcnt(this, paramInt));
    localQQCustomDialog.setOnCancelListener(new bcnj(this));
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().c();
    }
    if ((QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowSwitchButton()))
    {
      QCircleGetCircleSwitchRequest localQCircleGetCircleSwitchRequest = new QCircleGetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable");
      VSNetworkHelper.getInstance().sendRequest(localQCircleGetCircleSwitchRequest, new bcno(this));
    }
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new KidModeAdvanceSettingFragment.4(this));
      return;
    }
    c();
  }
  
  private void f()
  {
    b();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bcnq(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.d);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    QQCustomDialog localQQCustomDialog = bfur.a(getActivity(), 230).setTitle(amtj.a(2131694336)).setMessage(amtj.a(2131693255)).setNegativeButton(amtj.a(2131690600), new bcns(this)).setPositiveButton(amtj.a(2131693254), new bcnr(this));
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void i()
  {
    boolean bool1 = true;
    boolean bool2 = bcoo.b(16);
    boolean bool3 = bcoo.b(32);
    boolean bool4 = bcoo.b(8);
    a(16, bool2);
    a(32, bool3);
    a(8, bool4);
    if ((bcoo.a() == 1) && (bcoo.b() == 0)) {}
    for (;;)
    {
      a(4, bool1);
      return;
      bool1 = false;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((getActivity().getAppRuntime() instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      a();
      bcnv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561122;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Bcnu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    if (bcoo.b() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131693249));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Bcnu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    bcnv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "86", "", 0, null);
  }
  
  public void onResume()
  {
    super.onResume();
    d();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment
 * JD-Core Version:    0.7.0.1
 */