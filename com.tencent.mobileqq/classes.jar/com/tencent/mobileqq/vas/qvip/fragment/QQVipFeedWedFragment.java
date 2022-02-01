package com.tencent.mobileqq.vas.qvip.fragment;

import agej;
import alhw;
import anbd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antf;
import aqet;
import avnb;
import bdgb;
import bicw;
import bicx;
import bicy;
import bicz;
import bidb;
import bidi;
import binb;
import bmzn;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.view.QQVipHeadLayout;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQVipFeedWedFragment
  extends PublicBaseFragment
  implements View.OnClickListener, avnb
{
  private int jdField_a_of_type_Int = Color.parseColor("#FF74430E");
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bicy jdField_a_of_type_Bicy;
  private bidi jdField_a_of_type_Bidi;
  public NavBarQQGamePub a;
  private QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private QQVipHeadLayout jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout;
  private QQVipWebview jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview;
  private ArrayList<QQVipMsgInfo> jdField_a_of_type_JavaUtilArrayList;
  public List<bidb> a;
  private int jdField_b_of_type_Int;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public long c;
  private View c;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  long e;
  
  static
  {
    aqet.a(true);
    aqet.a();
  }
  
  public QQVipFeedWedFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).getBoolean(bicz.a().getCurrentAccountUin(), true);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout = ((QQVipHeadLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374737));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = ((QQVipWebview)this.jdField_a_of_type_AndroidViewView.findViewById(2131374740));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    d();
    f();
    g();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370633));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if (a())
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).edit().putBoolean(bicz.a().getCurrentAccountUin(), false).commit();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131366583));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131372241));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131364048));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131367926));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131379179);
    Object localObject = getResources().getDrawable(2130849765);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 1))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQVipMsgInfo localQQVipMsgInfo = (QQVipMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQVipMsgInfo.arkAppName))
        {
          alhw.a().a(localQQVipMsgInfo.arkAppName);
          this.jdField_b_of_type_JavaUtilList.add(localQQVipMsgInfo.arkAppName);
        }
      }
      alhw.a().a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Bicy = new bicy(this, null);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Bicy);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131374736);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/backgroup_image@2x.png");
      this.jdField_b_of_type_AndroidViewView.setBackground((Drawable)localObject);
    }
    for (;;)
    {
      bmzn.a().a("QQVipAccount", "1", "1", "", "", "", 111, 1);
      bmzn.a().a("QQVipAccount", "1", "1", "1", "", "1", 101, 1);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = new QQVipWebview(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setAlpha(0.0F);
    this.jdField_a_of_type_Bidi = new bicw(this, this.jdField_a_of_type_AndroidViewView.getContext(), getActivity(), bicz.a(), this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview);
    this.jdField_a_of_type_Bidi.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new binb(this.jdField_a_of_type_Bidi).a(null, anbd.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = ((QQVipWebview)this.jdField_a_of_type_Bidi.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setDrawingCacheEnabled(true);
    a();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559200, null, false);
    ((ImageView)localView.findViewById(2131366030)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public QQVipMsgInfo a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_b_of_type_Int)) {
      return (QQVipMsgInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.post(new QQVipFeedWedFragment.3(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bicy != null) && (paramInt == this.jdField_a_of_type_Bicy.getCount() - 1)) {
      b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setCurrentIndex(paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    bmzn.a().a("QQVipAccount", "1", "1", paramInt + 1 + "", "", "1", 101, 1);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131376731));
    this.c = paramView.findViewById(2131369775);
    paramView = getResources().getDrawable(2130850140);
    paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.getLeftBackIcon().getBackground();
    if (paramView != null) {
      paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694668);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    paramView = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/navigationbar@2x.png");
    this.c.setBackground(paramView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new bicx(this));
  }
  
  public void b()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = agej.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", antf.aX);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131694668));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      continue;
      b();
      bmzn.a().a("QQVipAccount", "1", "1", "5", "", "4", 102, 1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561991, paramViewGroup, false);
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)getActivity().getIntent().getSerializableExtra("qqvip_pubaccount_msg_list"));
    a(this.jdField_a_of_type_AndroidViewView);
    if (!bdgb.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    c();
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    bmzn.a().a("QQVipAccount", "1", "", "", "", "", 100, 1);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (!(this.jdField_a_of_type_JavaUtilList.get(i) instanceof ArkHeaderView)) {
            break label196;
          }
          ((ArkHeaderView)this.jdField_a_of_type_JavaUtilList.get(i)).c();
          break label196;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (Throwable localThrowable)
      {
        Iterator localIterator;
        String str;
        QLog.e("QQVipFeedWedFragment", 1, "header destroy error=" + localThrowable.toString());
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setDrawingCacheEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.destroy();
        if (this.jdField_a_of_type_Bidi == null) {
          continue;
        }
        this.jdField_a_of_type_Bidi.a();
        alhw.a().a(new String[0]);
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          alhw.a().b(str);
          continue;
        }
      }
      label196:
      i += 1;
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      alhw.a().b(this.jdField_b_of_type_JavaUtilList);
    }
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Bicy != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() == this.jdField_a_of_type_Bicy.getCount() - 1) && (this.jdField_a_of_type_Bicy.getCount() >= 2)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_Bicy.getCount() - 2);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.e = SystemClock.elapsedRealtime();
    bmzn.a().a("QQVipAccount", "1", "", "", "", "", 102, (int)(this.e - this.jdField_d_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment
 * JD-Core Version:    0.7.0.1
 */