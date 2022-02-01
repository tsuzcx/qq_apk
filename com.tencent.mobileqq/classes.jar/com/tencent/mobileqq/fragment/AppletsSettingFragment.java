package com.tencent.mobileqq.fragment;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.adapter.AppletsListAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletItem.Builder;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AppletsSettingFragment
  extends IphoneTitleBarFragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AppletsSettingFragment.1(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  AppletsFolderManager jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager;
  private AppletsListAdapter jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppletsObserver jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver = new AppletsSettingFragment.3(this);
  private AppletItem jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
  private AppletsSettingFragment.OnChangeSwitchListener jdField_a_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$OnChangeSwitchListener = new AppletsSettingFragment.4(this);
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AppletsSettingFragment.2(this);
  private HashMap<String, AppletItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  public AppletsSettingFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private String a(AppletItem paramAppletItem)
  {
    return paramAppletItem.a() + "&" + paramAppletItem.a();
  }
  
  private void a(List<AppletItem> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter.a(paramList);
    }
    if (this.c != null)
    {
      if ((paramList == null) || (paramList.size() < 1)) {
        this.c.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    boolean bool2 = true;
    Object localObject = new AppletItem.Builder();
    ((AppletItem.Builder)localObject).a(1L);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager.c();
    int i;
    label69:
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      ((AppletItem.Builder)localObject).a(str);
      ((AppletItem.Builder)localObject).b(null);
      ((AppletItem.Builder)localObject).a(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager.a()) {
        break label247;
      }
      i = 1;
      ((AppletItem.Builder)localObject).b(i);
      this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((AppletItem.Builder)localObject).a();
      if (this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem.b() != 1) {
        break label252;
      }
      bool1 = true;
      label98:
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem.a());
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem.b() != 1) {
        break label257;
      }
      bool1 = bool2;
      label136:
      ((Switch)localObject).setChecked(bool1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager.a();
      str = this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager.b();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label262;
      }
      this.b.setText((CharSequence)localObject);
      label177:
      if (TextUtils.isEmpty(str)) {
        break label281;
      }
      this.c.setText(str);
    }
    for (;;)
    {
      ((AppletsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)).a();
      a(new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values()));
      return;
      ((AppletItem.Builder)localObject).a(getActivity().getString(2131690186));
      break;
      label247:
      i = 0;
      break label69;
      label252:
      bool1 = false;
      break label98;
      label257:
      bool1 = false;
      break label136;
      label262:
      this.b.setText(getActivity().getString(2131690190));
      break label177;
      label281:
      this.c.setText(getActivity().getString(2131690184));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    AppletsHandler localAppletsHandler = (AppletsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    ArrayList localArrayList = new ArrayList();
    AppletItem localAppletItem = this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localAppletItem.a(i);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem);
      localAppletsHandler.a(localArrayList);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131362922));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131362921));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839575);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131362916));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131362915));
    this.b = ((TextView)this.mContentView.findViewById(2131362914));
    this.c = ((TextView)this.mContentView.findViewById(2131362913));
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter = new AppletsListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$OnChangeSwitchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAppletsListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690185);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppletItem localAppletItem = (AppletItem)((Map.Entry)localIterator.next()).getValue();
      if ((localAppletItem != null) && (localAppletItem.b() == 1)) {
        localIterator.remove();
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager.a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject);
    }
    for (;;)
    {
      localObject = new AppletsSettingFragment.5(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131691144, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131690190);
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break label44;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    label44:
    while ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentAppletsFolderManager = ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER));
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561590;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690189));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */