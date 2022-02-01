package com.tencent.mobileqq.nearby.now;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import java.util.List;
import mqq.os.MqqHandler;

public class SmallVideoFragment
  extends PublicBaseFragment
  implements DragFrameLayout.OnDraggingListener, ActCallBack
{
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected View a;
  protected RelativeLayout a;
  protected DragFrameLayout a;
  protected QQStoryLoadingView a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  protected CustomViewPager a;
  public StuffContainerView a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  protected int b;
  protected View b;
  protected RelativeLayout b;
  private boolean b;
  protected int c;
  public View c;
  private boolean c;
  protected int d;
  private int e = -1;
  
  public SmallVideoFragment()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new SmallVideoFragment.6(this);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, QQNearbyManager.m());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("raw_url", paramString);
    paramString = Uri.parse(paramString);
    String str1 = paramString.getQueryParameter("scroll_to_comment");
    String str2 = paramString.getQueryParameter("_from");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("1"))) {
      localIntent.putExtra("scroll_to_comment", true);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("_from", str2);
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    paramString = paramString.getQueryParameter("play_mode");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("play_mode", paramString);
    }
    PublicTransFragmentActivity.b(paramContext, localIntent, QQNearbyManager.m());
  }
  
  private void a(Bundle paramBundle)
  {
    if ("2".equals(paramBundle.getString("play_mode")))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a(true);
  }
  
  private int b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)a(2131365880));
    this.jdField_a_of_type_AndroidViewView = a(2131362662);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373012));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)a(2131380672));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365895));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.d = -1;
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
    int j = this.jdField_c_of_type_Int;
    localDragFrameLayout.jdField_a_of_type_Int = j;
    int i = j;
    if (j > this.d) {
      i = j / 2;
    }
    return i;
  }
  
  private void b(Bundle paramBundle) {}
  
  private boolean d()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      return ((IShortVideoCommentsView)localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).isScrollTop();
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setOnCloseListener(new SmallVideoFragment.1(this));
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.b();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("imageUri"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("imageUri");
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("cover_url"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("cover_url");
    }
    if (getBaseActivity().getIntent() != null)
    {
      int i = getBaseActivity().getIntent().getIntExtra("system_msg_type", 0);
      boolean bool = getBaseActivity().getIntent().getBooleanExtra("scroll_to_comment", false);
      this.e = getBaseActivity().getIntent().getIntExtra("feedType", -1);
      if ((i == 2) || (bool)) {
        ThreadManager.getUIHandler().postDelayed(new SmallVideoFragment.2(this), 1000L);
      }
    }
  }
  
  protected int a()
  {
    return 2131561205;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_c_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getBaseActivity().getApplicationContext().getSystemService("audio"));
    }
    try
    {
      int j = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
      }
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 1.0F - (paramInt3 - paramInt5) / UITools.a(getBaseActivity(), 60.0F);
    float f2 = 0.0F;
    if (f1 < 0.0F) {
      f1 = f2;
    }
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, f1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > UITools.a(getBaseActivity(), 60.0F))
    {
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("slide_quit").genderInd1().reportByVideo(getBaseActivity().app);
      if (this.jdField_a_of_type_Boolean) {
        d();
      } else {
        getBaseActivity().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.e();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(250);
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.jdField_a_of_type_AndroidViewView), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
  
  public boolean a()
  {
    return d();
  }
  
  public void b()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-1));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
      if (localObject != null)
      {
        ((QQStoryLoadingView)localObject).a();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      }
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      int i = ((VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter()).a.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter().getCount() == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= i - 1)) {
        return d();
      }
    }
    return false;
  }
  
  public void c()
  {
    QQStoryLoadingView localQQStoryLoadingView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
    if (localQQStoryLoadingView != null)
    {
      localQQStoryLoadingView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() == 0) {
      return d();
    }
    return false;
  }
  
  protected void d()
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("clk_quit").genderInd1().reportByVideo(getBaseActivity().app);
    if (!this.jdField_a_of_type_Boolean)
    {
      getBaseActivity().finish();
      return;
    }
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, 0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(128);
    paramActivity.getWindow().setSoftInputMode(18);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a(paramInt1, paramInt2, paramIntent);
    Object localObject = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((((VideoPlayerPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      ((IShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 == 123)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramIntent);
        paramIntent = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
        if (paramIntent == null) {
          return;
        }
        String str = ((Intent)localObject).getStringExtra("uin");
        paramInt1 = ((Intent)localObject).getIntExtra("uintype", -1);
        ShareMsgHelper.a(getBaseActivity().app, str, paramInt1, paramIntent, null);
        ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_suc").LvInd1().reportByVideo(getBaseActivity().app);
        ThreadManagerV2.excute(new SmallVideoFragment.4(this, (INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
        return;
      }
      if (paramInt1 == 124) {
        ThreadManagerV2.excute(new SmallVideoFragment.5(this, (INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ((IStorageCenter)QRoute.api(IStorageCenter.class)).init(getBaseActivity(), "shortVideo");
    QualityReporter.a(0);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), null);
    this.jdField_c_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    getBaseActivity().getIntent().putExtra("fling_action_key", 0);
    this.jdField_a_of_type_AndroidOsBundle = super.getBaseActivity().getIntent().getExtras();
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFrom(this.jdField_a_of_type_AndroidOsBundle.getString("_from", ""));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = ((StuffContainerView)a(2131380700));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setApp(getBaseActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCallBack(this);
    a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager;
    this.jdField_b_of_type_AndroidViewView = a(2131370383);
    int i = b();
    f();
    b(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.b(this.jdField_a_of_type_AndroidOsBundle);
    e();
    QualityReporter.c();
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_time");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((INowVideoReporter)localObject1).d4(((StringBuilder)localObject2).toString()).genderInd1();
    if (getActivity() != null) {
      localObject1 = getBaseActivity().app;
    } else {
      localObject1 = null;
    }
    ((INowVideoReporter)localObject2).reportByVideo((AppInterface)localObject1);
    ThreadManagerV2.excute(new SmallVideoFragment.3(this, l, (INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.c();
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
    if (localObject1 != null) {
      ((DragFrameLayout)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject1 != null) {
      ((AudioManager)localObject1).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidWidgetRelativeLayout).reset();
  }
  
  public void onFinish()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      ((CommentsView)localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).hideInputKeyboard();
    }
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 2130772067);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a();
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void onResume()
  {
    this.jdField_b_of_type_Boolean = true;
    super.onResume();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    } else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.b();
    }
    ((InputMethodManager)getBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment
 * JD-Core Version:    0.7.0.1
 */