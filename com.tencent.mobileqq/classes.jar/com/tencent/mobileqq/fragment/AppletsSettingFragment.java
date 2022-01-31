package com.tencent.mobileqq.fragment;

import agxk;
import ahyj;
import akie;
import akif;
import akin;
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
import apnn;
import apno;
import apnp;
import apnq;
import apnr;
import babk;
import babr;
import bafb;
import bbms;
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
  public agxk a;
  private ahyj jdField_a_of_type_Ahyj;
  private akif jdField_a_of_type_Akif = new apno(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apnn(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apnr jdField_a_of_type_Apnr = new apnp(this);
  private babk jdField_a_of_type_Babk;
  public bafb a;
  private bbms jdField_a_of_type_Bbms;
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
    if (this.jdField_a_of_type_Ahyj != null) {
      this.jdField_a_of_type_Ahyj.a(paramList);
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
    Object localObject = new akin();
    ((akin)localObject).a(1L);
    String str = this.jdField_a_of_type_Agxk.c();
    int i;
    label69:
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      ((akin)localObject).a(str);
      ((akin)localObject).b(null);
      ((akin)localObject).a(0);
      if (!this.jdField_a_of_type_Agxk.a()) {
        break label247;
      }
      i = 1;
      ((akin)localObject).b(i);
      this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((akin)localObject).a();
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
      localObject = this.jdField_a_of_type_Agxk.a();
      str = this.jdField_a_of_type_Agxk.b();
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
      ((akie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148)).a();
      a(new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values()));
      return;
      ((akin)localObject).a(getActivity().getString(2131624601));
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
      this.b.setText(getActivity().getString(2131624605));
      break label177;
      label281:
      this.c.setText(getActivity().getString(2131624599));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    akie localakie = (akie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148);
    ArrayList localArrayList = new ArrayList();
    AppletItem localAppletItem = this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localAppletItem.a(i);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem);
      localakie.a(localArrayList);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Babk = new babk(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131297158));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131297157));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839144);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131297152));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131297151));
    this.b = ((TextView)this.mContentView.findViewById(2131297150));
    this.c = ((TextView)this.mContentView.findViewById(2131297149));
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_Ahyj == null)
    {
      this.jdField_a_of_type_Ahyj = new ahyj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Apnr);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahyj);
    }
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bbms.c(2131624600);
      this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(true);
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
    if (this.jdField_a_of_type_Bafb != null)
    {
      if (!this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.show();
      }
      return;
    }
    this.jdField_a_of_type_Bafb = babr.a(getActivity(), 230);
    Object localObject = this.jdField_a_of_type_Agxk.a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_Bafb.setMessage((CharSequence)localObject);
    }
    for (;;)
    {
      localObject = new apnq(this);
      this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131625463, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bafb.show();
      return;
      this.jdField_a_of_type_Bafb.setMessage(2131624605);
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbms != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bbms.isShowing())) {
        break label44;
      }
      this.jdField_a_of_type_Bbms.show();
      this.jdField_a_of_type_Babk.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    label44:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bbms.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bbms.dismiss();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akif);
    this.jdField_a_of_type_Agxk = ((agxk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315));
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131495478;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131624604));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Babk != null) {
      this.jdField_a_of_type_Babk.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akif);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */