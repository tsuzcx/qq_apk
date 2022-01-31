package com.tencent.mobileqq.flutter.container;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apzv;
import apzw;
import apzx;
import aqae;
import aqag;
import aqan;
import aqao;
import bcpw;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.qflutter.qflutter_skin_engine.QFlutterSkinEngine;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QFlutterContainerFragment
  extends PublicBaseFragment
  implements apzx, aqae
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    Object localObject1 = new FrameLayout(getActivity());
    ((FrameLayout)localObject1).setId(2131366662);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = getArguments();
    String str = ((Bundle)localObject2).getString("url");
    localObject1 = null;
    if (((Bundle)localObject2).getSerializable("params") != null) {
      localObject1 = ((BoostFlutterActivity.SerializableMap)((Bundle)localObject2).getSerializable("params")).getMap();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new HashMap();
    }
    localObject1 = new apzv().a(str).a((Map)localObject2).a();
    ((QFlutterFragment)localObject1).a(new apzw(this));
    getChildFragmentManager().beginTransaction().add(2131366662, (Fragment)localObject1).commitAllowingStateLoss();
  }
  
  public void a()
  {
    boolean bool1 = true;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    long l3 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    long l4 = System.currentTimeMillis();
    long l5 = this.jdField_d_of_type_Long;
    QLog.d("QFlutter.fragment", 1, "onTransitionToFlutter, totalCost = " + l3);
    boolean bool2;
    if (this.f)
    {
      this.f = false;
      bool2 = this.jdField_d_of_type_Boolean;
      if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
        break label121;
      }
    }
    for (;;)
    {
      aqao.a(l1 - l2, l3, l4 - l5, bool2, bool1, this.jdField_a_of_type_Boolean);
      aqan.a().a(this.jdField_d_of_type_Boolean);
      return;
      label121:
      bool1 = false;
    }
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    QLog.d("QFlutter.fragment", 1, "onResult, " + paramInt + ", cost: " + l);
    this.e = true;
    if (paramInt == 0) {
      b();
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean) {
        aqao.a(paramInt, l, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      }
      return;
      bcpw.a(getActivity(), 1, 2131693973, 1).a();
      getActivity().finish();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
    QLog.d("QFlutter.fragment", 1, String.format("onLaunchFinish, isSuccess: %s, cost: %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l) }));
    if (this.jdField_d_of_type_Boolean) {
      aqao.a(paramBoolean, l);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    QLog.d("QFlutter.fragment", 1, String.format("onInstallFinish, isSuccess: %s, cost: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), Long.valueOf(l), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_Boolean = paramBoolean3;
      aqao.a(paramBoolean1, l, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      paramBundle.remove("android:support:fragments");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QFlutterSkinEngine.get().setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    this.jdField_a_of_type_AndroidViewViewGroup = new RelativeLayout(getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838514);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131560515, null);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, paramLayoutInflater);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aqag.b(this);
    aqan.a().a(this.jdField_d_of_type_Boolean, this.e);
  }
  
  public void onPause()
  {
    super.onPause();
    aqan.a().b();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    QFlutterSkinEngine.get().onPostThemeChanged(ThemeUtil.getCurrentThemeId());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity().getIntent();
    this.jdField_a_of_type_Long = paramView.getLongExtra("click_millis", 0L);
    this.jdField_a_of_type_Boolean = paramView.getBooleanExtra("process_exist", false);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (aqag.a == 0) {
      this.jdField_d_of_type_Boolean = true;
    }
    aqan.a().a();
    aqag.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */