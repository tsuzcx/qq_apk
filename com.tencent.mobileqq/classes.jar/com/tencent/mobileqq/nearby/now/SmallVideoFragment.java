package com.tencent.mobileqq.nearby.now;

import aerw;
import aerx;
import aery;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.utils.StorageCenter;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import java.util.List;
import mqq.os.MqqHandler;

public class SmallVideoFragment
  extends PublicBaseFragment
  implements DragFrameLayout.OnDraggingListener, ActCallBack
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected View a;
  protected RelativeLayout a;
  protected DragFrameLayout a;
  protected QQStoryLoadingView a;
  public CustomViewPager a;
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
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aery(this);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, SmallVideoFragment.class);
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
    PublicTransFragmentActivity.b(paramContext, localIntent, SmallVideoFragment.class);
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
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)a(2131365572));
    this.jdField_a_of_type_AndroidViewView = a(2131370595);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370597));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)a(2131363634));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370596));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    int i = this.jdField_c_of_type_Int;
    if (this.jdField_c_of_type_Int > this.d) {
      i = this.jdField_c_of_type_Int / 2;
    }
    return i;
  }
  
  private void b(Bundle paramBundle) {}
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setOnCloseListener(new aerw(this));
  }
  
  private boolean e()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      return ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).a();
    }
    return false;
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.b();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("imageUri"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("imageUri");
    }
    for (;;)
    {
      if (getActivity().getIntent() != null)
      {
        int i = getActivity().getIntent().getIntExtra("system_msg_type", 0);
        boolean bool = getActivity().getIntent().getBooleanExtra("scroll_to_comment", false);
        this.e = getActivity().getIntent().getIntExtra("feedType", -1);
        if ((i == 2) || (bool)) {
          ThreadManager.getUIHandler().postDelayed(new aerx(this), 1000L);
        }
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("cover_url"))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("cover_url");
      }
    }
  }
  
  protected int a()
  {
    return 2130970454;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_c_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 0.0F;
    float f2 = 1.0F - (paramInt3 - paramInt5) / UITools.a(getActivity(), 60.0F);
    if (f2 < 0.0F) {}
    for (;;)
    {
      ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, f1);
      return;
      f1 = f2;
    }
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(128);
    paramActivity.getWindow().setSoftInputMode(18);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > UITools.a(getActivity(), 60.0F))
    {
      new NowVideoReporter().h("video").i("slide_quit").b().a(getActivity().app);
      if (this.jdField_a_of_type_Boolean) {
        d();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.e();
        return;
        getActivity().finish();
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(250);
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.jdField_a_of_type_AndroidViewView), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getActivity().getApplicationContext().getSystemService("audio"));
    }
    try
    {
      int j = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
      }
      if (i == 0) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-1));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    new NowVideoReporter().h("video").i("clk_quit").b().a(getActivity().app);
    if (!this.jdField_a_of_type_Boolean)
    {
      getActivity().finish();
      return;
    }
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, 0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean f_()
  {
    return e();
  }
  
  public boolean g_()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      int i = ((VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter()).a.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter().getCount() == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= i - 1)) {
        return e();
      }
    }
    return false;
  }
  
  public boolean h_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() == 0) {
      return e();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a(paramInt1, paramInt2, paramIntent);
    Object localObject = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((((VideoPlayerPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).a(paramInt1, paramInt1, paramIntent);
    }
    if ((paramInt2 == -1) && (paramInt1 == 123))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramIntent);
      paramIntent = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
      if (paramIntent != null) {}
    }
    while (paramInt1 <= 1000)
    {
      return;
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt2 = ((Intent)localObject).getIntExtra("uintype", -1);
      ShareMsgHelper.a(getActivity().app, str, paramInt2, paramIntent, null);
      new NowVideoReporter().h("video").i("playpage_fw_suc").a().a(getActivity().app);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StorageCenter.a(getActivity(), "shortVideo");
    QualityReporter.a(0);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), null);
    this.jdField_c_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    getActivity().getIntent().putExtra("fling_action_key", 0);
    this.jdField_a_of_type_AndroidOsBundle = super.getActivity().getIntent().getExtras();
    NowVideoReporter.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("_from", "");
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = ((StuffContainerView)a(2131370599));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setApp(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCallBack(this);
    a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager;
    this.jdField_b_of_type_AndroidViewView = a(2131370598);
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
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("video").i("playpage_time").g(l1 - l2 + "").b();
    if (getActivity() != null) {}
    for (QQAppInterface localQQAppInterface = getActivity().app;; localQQAppInterface = null)
    {
      localNowVideoReporter.a(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.c();
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
      }
      AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
      AnimatorProxy.wrap(this.jdField_a_of_type_AndroidWidgetRelativeLayout).reset();
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a();
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void onResume()
  {
    this.jdField_b_of_type_Boolean = true;
    super.onResume();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.getWindowToken(), 0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.b();
    }
  }
  
  public void u_()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).j();
    }
    super.u_();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2131034167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment
 * JD-Core Version:    0.7.0.1
 */