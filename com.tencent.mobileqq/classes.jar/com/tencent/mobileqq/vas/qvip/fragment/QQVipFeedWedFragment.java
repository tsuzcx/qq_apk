package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.Animator;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQVipFeedWedFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQVipIndicator.IPageListener
{
  private int jdField_a_of_type_Int = Color.parseColor("#FF74430E");
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
  private QQVipFeedWedFragment.HeadPageAdapter jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter;
  private QQVipHeadLayout jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout;
  private QQVipIndicator jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator;
  public QQVipPubNavBar a;
  private QQVipWebview jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview;
  private QQVipWebViewBuilder jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder;
  private ArrayList<QQVipMsgInfo> jdField_a_of_type_JavaUtilArrayList;
  List<IHeaderView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private long d;
  private long e;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, IHeaderView paramIHeaderView, QQVipMsgInfo paramQQVipMsgInfo, RelativeLayout paramRelativeLayout, RelativeLayout.LayoutParams paramLayoutParams)
  {
    TextView localTextView = null;
    RelativeLayout.LayoutParams localLayoutParams1;
    if (paramQQVipMsgInfo != null)
    {
      localTextView = new TextView(getBaseActivity());
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 10.0F);
      localTextView.setBackgroundColor(Color.parseColor("#FFD69D5A"));
      localTextView.setText(TimeFormatterUtils.a(getBaseActivity(), 3, paramQQVipMsgInfo.mMsgTime * 1000L));
      localTextView.setPadding(12, 0, 12, 0);
      localTextView.setId(2131378695);
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, AIOUtils.b(14.0F, getResources()));
      }
      localTextView.setGravity(17);
      localLayoutParams1.topMargin = 25;
      localLayoutParams1.addRule(14);
      localLayoutParams1.addRule(10);
      localTextView.bringToFront();
    }
    else
    {
      localLayoutParams1 = null;
    }
    paramRelativeLayout.addView((View)paramIHeaderView, paramLayoutParams);
    if ((localTextView != null) && (localLayoutParams1 != null)) {
      paramRelativeLayout.addView(localTextView, localLayoutParams1);
    }
    paramViewGroup.addView(paramRelativeLayout, paramLayoutParams);
    if ((paramIHeaderView != null) && (paramQQVipMsgInfo != null)) {
      paramIHeaderView.a(paramQQVipMsgInfo, getBaseActivity(), paramInt);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).getBoolean(QQVipHelper.a().getCurrentAccountUin(), true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout = ((QQVipHeadLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374630));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = ((QQVipWebview)this.jdField_a_of_type_AndroidViewView.findViewById(2131374633));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    c();
    e();
    f();
    g();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370699));
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
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131366759));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator = ((QQVipIndicator)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131372285));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131376673));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131376674));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131364172));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131364173));
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131368067));
    Object localObject = getResources().getDrawable(2130847169);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() >= 1))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQVipMsgInfo localQQVipMsgInfo = (QQVipMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQVipMsgInfo.mArkAppName))
        {
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQVipMsgInfo.mArkAppName);
          this.jdField_b_of_type_JavaUtilList.add(localQQVipMsgInfo.mArkAppName);
        }
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).registVolumnReceiver(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter = new QQVipFeedWedFragment.HeadPageAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setOffscreenPageLimit(1);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager);
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.a();
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.setPageListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout.findViewById(2131374629);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/backgroup_image@2x.png");
      this.jdField_b_of_type_AndroidViewView.setBackground((Drawable)localObject);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else
    {
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
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "", "", "", 111, 1);
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "1", "", "1", 101, 1);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview = new QQVipWebview(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipHeadLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder = new QQVipFeedWedFragment.1(this, this.jdField_a_of_type_AndroidViewView.getContext(), getBaseActivity(), QQVipHelper.a(), this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder).a(null, ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), null);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator.a(1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter;
      if ((localObject2 != null) && (((QQVipFeedWedFragment.HeadPageAdapter)localObject2).getCount() > 2))
      {
        localObject2 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { 1.0F, 1.2F, 1.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject1, "scaleY", new float[] { 1.0F, 1.2F, 1.0F });
        localAnimatorSet.play((Animator)localObject2).with(localObjectAnimator);
        localAnimatorSet.setDuration(1000L);
        localAnimatorSet.addListener(new QQVipFeedWedFragment.4(this, (RadioButton)localObject1));
      }
    }
    localValueAnimator.addListener(new QQVipFeedWedFragment.5(this));
    int i = QVipPubAccountConfig.a();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter;
    if ((localObject1 != null) && (((QQVipFeedWedFragment.HeadPageAdapter)localObject1).getCount() > 2) && (i >= 0)) {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.postDelayed(new QQVipFeedWedFragment.6(this, localValueAnimator, localAnimatorSet), i);
    }
  }
  
  private void h()
  {
    SpringAnimation localSpringAnimation = new SpringAnimation(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager, SpringAnimation.SCROLL_X, 0.0F);
    localSpringAnimation.getSpring().setStiffness(50.0F);
    localSpringAnimation.getSpring().setDampingRatio(0.5F);
    localSpringAnimation.start();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getBaseActivity()).inflate(2131559147, null, false);
    ((ImageView)localView.findViewById(2131366220)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public QQVipMsgInfo a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      int j = this.jdField_b_of_type_Int;
      if (i > j) {
        return (QQVipMsgInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.post(new QQVipFeedWedFragment.7(this));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter;
    if ((localObject != null) && (paramInt == ((QQVipFeedWedFragment.HeadPageAdapter)localObject).getCount() - 1)) {
      QQVipHelper.a(getBaseActivity());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator;
    if (localObject != null) {
      ((QQVipIndicator)localObject).setCurrentIndex(paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    localObject = MobileReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append("");
    ((MobileReportManager)localObject).reportAction("QQVipAccount", "1", "1", localStringBuilder.toString(), "", "1", 101, 1);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar = ((QQVipPubNavBar)paramView.findViewById(2131376636));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131369871);
    paramView = getResources().getDrawable(2130850474);
    paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setRightImage(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.getLeftBackIcon().getBackground();
    if (paramView != null) {
      paramView.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695227);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    String str = QVipPubAccountConfig.b();
    paramView = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramView != null) && (paramView.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null) && (((QQVipMsgInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mIsGameArk))
    {
      str = QVipPubAccountConfig.c();
      paramView = "game_icon";
    }
    else
    {
      paramView = "vip_icon";
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.a(str);
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "4", "", paramView, "", 101, 1);
    paramView = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/navigationbar@2x.png");
    this.jdField_c_of_type_AndroidViewView.setBackground(paramView);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipPubNavBar.setOnItemSelectListener(new QQVipFeedWedFragment.2(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131370699: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
    case 2131364172: 
    case 2131364173: 
      QQVipHelper.a(getBaseActivity());
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "5", "", "4", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561907, paramViewGroup, false);
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)getBaseActivity().getIntent().getSerializableExtra("qqvip_pubaccount_msg_list"));
    a(this.jdField_a_of_type_AndroidViewView);
    if (!SimpleUIUtil.a())
    {
      getBaseActivity().mSystemBarComp = null;
      getBaseActivity().setImmersiveStatus(0);
    }
    b();
    this.d = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 100, 1);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
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
      Object localObject2;
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (!(this.jdField_a_of_type_JavaUtilList.get(i) instanceof ArkHeaderView)) {
            break label215;
          }
          ((ArkHeaderView)this.jdField_a_of_type_JavaUtilList.get(i)).d();
          break label215;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("header destroy error=");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        QLog.e("QQVipFeedWedFragment", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.jdField_b_of_type_JavaUtilList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify((String)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview;
      if (localObject1 != null)
      {
        ((QQVipWebview)localObject1).setDrawingCacheEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipWebview.destroy();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasQvipWebQQVipWebViewBuilder;
      if (localObject1 != null) {
        ((QQVipWebViewBuilder)localObject1).a();
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(new String[0]);
      return;
      label215:
      i += 1;
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.jdField_b_of_type_JavaUtilList);
    }
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter != null)
    {
      QQGamePubViewpager localQQGamePubViewpager = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
      if ((localQQGamePubViewpager != null) && (localQQGamePubViewpager.getCurrentItem() == this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() - 1) && (this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() >= 2)) {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqVasQvipFragmentQQVipFeedWedFragment$HeadPageAdapter.getCount() - 2);
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.e = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 102, (int)(this.e - this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment
 * JD-Core Version:    0.7.0.1
 */