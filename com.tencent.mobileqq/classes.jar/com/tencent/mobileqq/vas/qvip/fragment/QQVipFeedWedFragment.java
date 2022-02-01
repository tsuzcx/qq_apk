package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.config.business.qvip.QVipPubAccountConfig;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vas.qvip.view.IHeaderView;
import com.tencent.mobileqq.vas.qvip.view.QQVipHeadLayout;
import com.tencent.mobileqq.vas.qvip.view.QQVipIndicator;
import com.tencent.mobileqq.vas.qvip.view.QQVipIndicator.IPageListener;
import com.tencent.mobileqq.vas.qvip.view.QQVipPubNavBar;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;
import com.tencent.mobileqq.vas.qvip.web.QQVipWebViewBuilder;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQVipFeedWedFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQVipIndicator.IPageListener
{
  private int jdField_a_of_type_Int = Color.parseColor("#FF74430E");
  long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private QQVipFeedWedFragment.HeadPageAdapter jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter;
  private QQVipHeadLayout jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout;
  private QQVipIndicator jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator;
  public QQVipPubNavBar a;
  private QQVipWebview jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview;
  private QQVipWebViewBuilder jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder;
  private ArrayList<QQVipMsgInfo> jdField_a_of_type_JavaUtilArrayList;
  List<IHeaderView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  long d;
  long e;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).getBoolean(QQVipHelper.a().getCurrentAccountUin(), true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout = ((QQVipHeadLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375114));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = ((QQVipWebview)this.jdField_a_of_type_AndroidViewView.findViewById(2131375117));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    c();
    e();
    f();
    g();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371065));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if (a())
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).edit().putBoolean(QQVipHelper.a().getCurrentAccountUin(), false).commit();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131366897));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator = ((QQVipIndicator)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131372707));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131377212));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131377213));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131364254));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131364255));
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131368315));
    Object localObject = getResources().getDrawable(2130847300);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 1))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQVipMsgInfo localQQVipMsgInfo = (QQVipMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQVipMsgInfo.arkAppName))
        {
          ArkPubicEventWrap.a().a(localQQVipMsgInfo.arkAppName);
          this.jdField_b_of_type_JavaUtilList.add(localQQVipMsgInfo.arkAppName);
        }
      }
      ArkPubicEventWrap.a().a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter = new QQVipFeedWedFragment.HeadPageAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.a();
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.setPageListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131375113);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/backgroup_image@2x.png");
      this.jdField_b_of_type_AndroidViewView.setBackground((Drawable)localObject);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "", "", "", 111, 1);
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "1", "", "1", 101, 1);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject = this.jdField_b_of_type_AndroidWidgetButton.getCompoundDrawables();
      if (localObject.length > 2)
      {
        localObject = localObject[2];
        ((Drawable)localObject).mutate();
        if (localObject != null) {
          ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, -16777216));
        }
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = new QQVipWebview(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder = new QQVipFeedWedFragment.1(this, this.jdField_a_of_type_AndroidViewView.getContext(), getActivity(), QQVipHelper.a(), this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder).a(null, CmGameUtil.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = ((QQVipWebview)this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setDrawingCacheEnabled(true);
    a();
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 400 });
    localValueAnimator.addUpdateListener(new QQVipFeedWedFragment.3(this));
    localValueAnimator.setDuration(300L);
    RadioButton localRadioButton = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.a(1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if ((localRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() > 2))
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localRadioButton, "scaleX", new float[] { 1.0F, 1.2F, 1.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localRadioButton, "scaleY", new float[] { 1.0F, 1.2F, 1.0F });
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.addListener(new QQVipFeedWedFragment.4(this, localRadioButton));
    }
    localValueAnimator.addListener(new QQVipFeedWedFragment.5(this));
    int i = QVipPubAccountConfig.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() > 2) && (i >= 0)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.postDelayed(new QQVipFeedWedFragment.6(this, localValueAnimator, localAnimatorSet), i);
    }
  }
  
  private void h()
  {
    SpringAnimation localSpringAnimation = new SpringAnimation(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager, SpringAnimation.m, 0.0F);
    localSpringAnimation.a().a(50.0F);
    localSpringAnimation.a().b(0.5F);
    localSpringAnimation.a();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559275, null, false);
    ((ImageView)localView.findViewById(2131366332)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
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
    this.jdField_a_of_type_AndroidViewView.post(new QQVipFeedWedFragment.7(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter != null) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() - 1)) {
      QQVipHelper.a(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.setCurrentIndex(paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", paramInt + 1 + "", "", "1", 101, 1);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar = ((QQVipPubNavBar)paramView.findViewById(2131377159));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370202);
    paramView = getResources().getDrawable(2130850548);
    paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setRightImage(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.getLeftBackIcon().getBackground();
    if (paramView != null) {
      paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695231);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    paramView = QVipPubAccountConfig.b();
    String str = "vip_icon";
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null) && (((QQVipMsgInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).isGameArk))
    {
      paramView = QVipPubAccountConfig.c();
      str = "game_icon";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.a(paramView);
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "4", "", str, "", 101, 1);
      paramView = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/navigationbar@2x.png");
      this.jdField_c_of_type_AndroidViewView.setBackground(paramView);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setOnItemSelectListener(new QQVipFeedWedFragment.2(this));
      return;
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
      QQVipHelper.a(getActivity());
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "5", "", "4", 102, 1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131562072, paramViewGroup, false);
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)getActivity().getIntent().getSerializableExtra("qqvip_pubaccount_msg_list"));
    a(this.jdField_a_of_type_AndroidViewView);
    if (!SimpleUIUtil.a())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    b();
    this.d = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 100, 1);
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
          ((ArkHeaderView)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
        if (this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder.a();
        ArkPubicEventWrap.a().a(new String[0]);
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          ArkPubicEventWrap.a().b(str);
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
      ArkPubicEventWrap.a().b(this.jdField_b_of_type_JavaUtilList);
    }
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() == this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() - 1) && (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() >= 2)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() - 2);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.e = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 102, (int)(this.e - this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment
 * JD-Core Version:    0.7.0.1
 */