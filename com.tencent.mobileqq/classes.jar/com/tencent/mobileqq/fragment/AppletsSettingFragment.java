package com.tencent.mobileqq.fragment;

import ajfv;
import akgz;
import amru;
import amrv;
import amsd;
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
import asfb;
import asfc;
import asfd;
import asfe;
import asff;
import bdgf;
import bdgm;
import bdjz;
import bety;
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
  public ajfv a;
  private akgz jdField_a_of_type_Akgz;
  private amrv jdField_a_of_type_Amrv = new asfc(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new asfb(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asff jdField_a_of_type_Asff = new asfd(this);
  private bdgf jdField_a_of_type_Bdgf;
  public bdjz a;
  private bety jdField_a_of_type_Bety;
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
    if (this.jdField_a_of_type_Akgz != null) {
      this.jdField_a_of_type_Akgz.a(paramList);
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
    Object localObject = new amsd();
    ((amsd)localObject).a(1L);
    String str = this.jdField_a_of_type_Ajfv.c();
    int i;
    label69:
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      ((amsd)localObject).a(str);
      ((amsd)localObject).b(null);
      ((amsd)localObject).a(0);
      if (!this.jdField_a_of_type_Ajfv.a()) {
        break label247;
      }
      i = 1;
      ((amsd)localObject).b(i);
      this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((amsd)localObject).a();
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
      localObject = this.jdField_a_of_type_Ajfv.a();
      str = this.jdField_a_of_type_Ajfv.b();
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
      ((amru)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148)).a();
      a(new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values()));
      return;
      ((amsd)localObject).a(getActivity().getString(2131690202));
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
      this.b.setText(getActivity().getString(2131690206));
      break label177;
      label281:
      this.c.setText(getActivity().getString(2131690200));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    amru localamru = (amru)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148);
    ArrayList localArrayList = new ArrayList();
    AppletItem localAppletItem = this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localAppletItem.a(i);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem);
      localamru.a(localArrayList);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bdgf = new bdgf(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131362726));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131362725));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839254);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131362720));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131362719));
    this.b = ((TextView)this.mContentView.findViewById(2131362718));
    this.c = ((TextView)this.mContentView.findViewById(2131362717));
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_Akgz == null)
    {
      this.jdField_a_of_type_Akgz = new akgz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Asff);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akgz);
    }
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bety.c(2131690201);
      this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(true);
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
    if (this.jdField_a_of_type_Bdjz != null)
    {
      if (!this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.show();
      }
      return;
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(getActivity(), 230);
    Object localObject = this.jdField_a_of_type_Ajfv.a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_Bdjz.setMessage((CharSequence)localObject);
    }
    for (;;)
    {
      localObject = new asfe(this);
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131691089, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.show();
      return;
      this.jdField_a_of_type_Bdjz.setMessage(2131690206);
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bety != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bety.isShowing())) {
        break label44;
      }
      this.jdField_a_of_type_Bety.show();
      this.jdField_a_of_type_Bdgf.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    label44:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bety.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bety.dismiss();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrv);
    this.jdField_a_of_type_Ajfv = ((ajfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315));
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561269;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690205));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bdgf != null) {
      this.jdField_a_of_type_Bdgf.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrv);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */