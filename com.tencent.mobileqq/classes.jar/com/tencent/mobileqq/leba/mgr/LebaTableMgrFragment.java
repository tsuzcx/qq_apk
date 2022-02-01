package com.tencent.mobileqq.leba.mgr;

import ajej;
import ajek;
import amvb;
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
import aneg;
import apub;
import apye;
import aqhi;
import aqhj;
import auxv;
import auye;
import auyf;
import auyg;
import azvi;
import bcef;
import bcoo;
import bfpm;
import bjwf;
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
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;

public class LebaTableMgrFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private ajej jdField_a_of_type_Ajej;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private auxv jdField_a_of_type_Auxv;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    ((azvi)localQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131369089));
    }
    aqhi localaqhi = aqhj.c();
    boolean bool = bcoo.a();
    if ((!localaqhi.a()) || (bool))
    {
      QLog.d("leba_sort_LebaTableMgrFragment", 1, "hide mRightIcon isShowIconEntry=" + localaqhi.a() + ",isStudyMode=" + bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850139);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    c();
    if (AppSetting.c) {
      bfpm.a(this.jdField_a_of_type_AndroidWidgetImageView, getResources().getString(2131718938), Button.class.getName());
    }
    MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 101, 1, System.currentTimeMillis());
  }
  
  private void c()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((azvi)((QQAppInterface)localObject).getManager(36)).a("150000.150100");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a().a((BusinessInfoCheckUpdate.AppInfo)localObject);
    a((BusinessInfoCheckUpdate.AppInfo)localObject);
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
    String str2 = aqhj.c().a();
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
      List localList = ajek.a().a();
      int i = amvb.d((QQAppInterface)localObject);
      localObject = new LebaTableMgrFragment.1(this, localList, amvb.a((QQAppInterface)localObject, i), i);
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
    this.jdField_a_of_type_Ajej = new ajej();
    this.jdField_a_of_type_Ajej.a(paramBoolean);
    this.jdField_a_of_type_Auxv = new auxv(getActivity(), this.jdField_a_of_type_Ajej, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Auxv.a(paramBoolean);
    Object localObject = new GridLayoutManager(getActivity(), 3);
    ((GridLayoutManager)localObject).setSpanSizeLookup(new auyf(this.jdField_a_of_type_Auxv));
    this.jdField_a_of_type_Auxv.a((GridLayoutManager)localObject);
    bjwf localbjwf = new bjwf(new auyg(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, this.jdField_a_of_type_Ajej, this.jdField_a_of_type_Auxv));
    localbjwf.attachToRecyclerView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView);
    this.jdField_a_of_type_Auxv.a(localbjwf);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addItemDecoration(new auye(getActivity(), this.jdField_a_of_type_Auxv, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Auxv);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        apye localapye = (apye)apub.a().a(614);
        if (localapye == null)
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "configBean == null");
          return false;
        }
        int i = localapye.b;
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
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(null, false, null);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreateView mIsNight=" + this.jdField_a_of_type_Boolean);
    setTitle(getString(2131693305));
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.initLebaHelper();
    }
    paramLayoutInflater = this.mContentView.findViewById(2131369641);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.mContentView.findViewById(2131376174));
    if (this.jdField_a_of_type_Boolean) {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165760));
    }
    for (;;)
    {
      a(a());
      b();
      return;
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165759));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561143;
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
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", ((String)localObject).replace("[uid]", "").replace("[lType]", "1"));
        startActivity(localIntent);
        localObject = a();
        bcef.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AE51", "0X800AE51", aneg.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentUin(), false), 0, "0", "0", "", "");
        ((azvi)((QQAppInterface)localObject).getManager(36)).b("150000.150100");
        MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 102, 1, System.currentTimeMillis());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreate");
    ajek.a |= 0x1;
    paramBundle = a();
    if (paramBundle != null) {
      bcef.b(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnDestroy");
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = null;
    this.jdField_a_of_type_Auxv = null;
    if (this.jdField_a_of_type_Ajej != null)
    {
      this.jdField_a_of_type_Ajej.a(a());
      this.jdField_a_of_type_Ajej = null;
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