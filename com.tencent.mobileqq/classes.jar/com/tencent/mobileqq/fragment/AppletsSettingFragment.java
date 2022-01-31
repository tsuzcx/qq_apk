package com.tencent.mobileqq.fragment;

import ahjx;
import aila;
import akwp;
import akwq;
import akwy;
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
import aqhd;
import aqhe;
import aqhf;
import aqhg;
import aqhh;
import bbdc;
import bbdj;
import bbgu;
import bcqf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
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
  public ahjx a;
  private aila jdField_a_of_type_Aila;
  private akwq jdField_a_of_type_Akwq = new aqhe(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aqhd(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqhh jdField_a_of_type_Aqhh = new aqhf(this);
  private bbdc jdField_a_of_type_Bbdc;
  public bbgu a;
  private bcqf jdField_a_of_type_Bcqf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppletItem jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AppletsSettingFragment.2(this);
  private HashMap<String, AppletItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  private String a(AppletItem paramAppletItem)
  {
    return paramAppletItem.a() + "&" + paramAppletItem.a();
  }
  
  private void a(List<AppletItem> paramList)
  {
    if (this.jdField_a_of_type_Aila != null) {
      this.jdField_a_of_type_Aila.a(paramList);
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
    Object localObject = new akwy();
    ((akwy)localObject).a(1L);
    String str = this.jdField_a_of_type_Ahjx.c();
    int i;
    label69:
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      ((akwy)localObject).a(str);
      ((akwy)localObject).b(null);
      ((akwy)localObject).a(0);
      if (!this.jdField_a_of_type_Ahjx.a()) {
        break label247;
      }
      i = 1;
      ((akwy)localObject).b(i);
      this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((akwy)localObject).a();
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
      localObject = this.jdField_a_of_type_Ahjx.a();
      str = this.jdField_a_of_type_Ahjx.b();
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
      ((akwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148)).a();
      a(new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values()));
      return;
      ((akwy)localObject).a(getActivity().getString(2131690155));
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
      this.b.setText(getActivity().getString(2131690159));
      break label177;
      label281:
      this.c.setText(getActivity().getString(2131690153));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    akwp localakwp = (akwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148);
    ArrayList localArrayList = new ArrayList();
    AppletItem localAppletItem = this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localAppletItem.a(i);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem);
      localakwp.a(localArrayList);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bbdc = new bbdc(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131362697));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131362696));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839169);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131362691));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131362690));
    this.b = ((TextView)this.mContentView.findViewById(2131362689));
    this.c = ((TextView)this.mContentView.findViewById(2131362688));
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_Aila == null)
    {
      this.jdField_a_of_type_Aila = new aila(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Aqhh);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aila);
    }
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.c(2131690154);
      this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
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
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbgu != null)
    {
      if (!this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.show();
      }
      return;
    }
    this.jdField_a_of_type_Bbgu = bbdj.a(getActivity(), 230);
    Object localObject = this.jdField_a_of_type_Ahjx.a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_Bbgu.setMessage((CharSequence)localObject);
    }
    for (;;)
    {
      localObject = new aqhg(this);
      this.jdField_a_of_type_Bbgu.setNegativeButton(2131690596, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bbgu.setPositiveButton(2131691035, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bbgu.show();
      return;
      this.jdField_a_of_type_Bbgu.setMessage(2131690159);
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bcqf.isShowing())) {
        break label44;
      }
      this.jdField_a_of_type_Bcqf.show();
      this.jdField_a_of_type_Bbdc.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    label44:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bcqf.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bcqf.dismiss();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akwq);
    this.jdField_a_of_type_Ahjx = ((ahjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315));
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561064;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690158));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bbdc != null) {
      this.jdField_a_of_type_Bbdc.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akwq);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */