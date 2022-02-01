package com.tencent.mobileqq.leba.mgr;

import ajvh;
import ajvi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anoy;
import anyj;
import aqlk;
import aqpg;
import aqxv;
import aqxw;
import avsa;
import avsg;
import avsh;
import avsi;
import baif;
import bcst;
import bgfz;
import bkrd;
import blyl;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LebaTableMgrFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private ajvh jdField_a_of_type_Ajvh;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private avsa jdField_a_of_type_Avsa;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((baif)a().getManager(36)).a(paramAppInfo);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131368969));
    }
    if (!aqxw.c().a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850206);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    c();
    if (AppSetting.c) {
      bgfz.a(this.jdField_a_of_type_AndroidWidgetImageView, getResources().getString(2131718554), Button.class.getName());
    }
    blyl.a().a("Theme", "4", "platform898", "1", null, 101, 1, System.currentTimeMillis());
  }
  
  private void c()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)a().getManager(36)).a("150000.150100");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  public QQAppInterface a()
  {
    if (getActivity() == null) {
      return null;
    }
    return (QQAppInterface)getActivity().getAppInterface();
  }
  
  public String a()
  {
    String str2 = aqxw.c().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "updateDate appInterface == null");
    }
    do
    {
      return;
      List localList = ajvi.a().a();
      int i = anoy.b((QQAppInterface)localObject);
      localObject = new LebaTableMgrFragment.1(this, localList, anoy.a((QQAppInterface)localObject, i), i);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
    } while (getActivity() == null);
    getActivity().runOnUiThread((Runnable)localObject);
    return;
    ((Runnable)localObject).run();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajvh = new ajvh();
    this.jdField_a_of_type_Ajvh.a(paramBoolean);
    this.jdField_a_of_type_Avsa = new avsa(getActivity(), this.jdField_a_of_type_Ajvh);
    this.jdField_a_of_type_Avsa.a(paramBoolean);
    Object localObject = new GridLayoutManager(getActivity(), 3);
    ((GridLayoutManager)localObject).setSpanSizeLookup(new avsh(this.jdField_a_of_type_Avsa));
    this.jdField_a_of_type_Avsa.a((GridLayoutManager)localObject);
    bkrd localbkrd = new bkrd(new avsi(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, this.jdField_a_of_type_Ajvh, this.jdField_a_of_type_Avsa));
    localbkrd.attachToRecyclerView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView);
    this.jdField_a_of_type_Avsa.a(localbkrd);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addItemDecoration(new avsg(getActivity(), this.jdField_a_of_type_Avsa));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Avsa);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        aqpg localaqpg = (aqpg)aqlk.a().a(614);
        if (localaqpg == null)
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "configBean == null");
          return false;
        }
        int i = localaqpg.b;
        if (i != 1) {
          continue;
        }
        bool = true;
        try
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort " + bool);
          return bool;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        boolean bool = false;
        continue;
      }
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort", localException1);
      return bool;
      bool = false;
    }
  }
  
  @Nullable
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreateView");
    setTitle(getString(2131693204));
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.n();
    }
    paramLayoutInflater = this.mContentView.findViewById(2131369556);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.mContentView.findViewById(2131376267));
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165750));
    }
    for (;;)
    {
      a(a());
      b();
      return;
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165749));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561231;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = a();
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", ((String)localObject).replace("[uid]", "").replace("[lType]", "1"));
      startActivity(localIntent);
      localObject = a();
      bcst.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AE51", "0X800AE51", anyj.a((QQAppInterface)localObject, ((QQAppInterface)localObject).c(), false), 0, "0", "0", "", "");
      ((baif)((QQAppInterface)localObject).getManager(36)).b("150000.150100");
      blyl.a().a("Theme", "4", "platform898", "1", null, 102, 1, System.currentTimeMillis());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreate");
    ajvi.a |= 0x1;
    paramBundle = a();
    if (paramBundle != null) {
      bcst.b(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnDestroy");
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = null;
    this.jdField_a_of_type_Avsa = null;
    if (this.jdField_a_of_type_Ajvh != null)
    {
      this.jdField_a_of_type_Ajvh.a(a());
      this.jdField_a_of_type_Ajvh = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnResume");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment
 * JD-Core Version:    0.7.0.1
 */