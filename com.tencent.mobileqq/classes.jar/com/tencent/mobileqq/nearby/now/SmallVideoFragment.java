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
  public StuffContainerView a;
  protected DragFrameLayout b;
  protected RelativeLayout c;
  protected CustomViewPager d;
  protected RelativeLayout e;
  protected QQStoryLoadingView f;
  protected View g;
  protected View h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected AudioManager m;
  protected boolean n = false;
  public View o;
  protected AudioManager.OnAudioFocusChangeListener p = new SmallVideoFragment.6(this);
  private boolean q;
  private boolean r = true;
  private BaseActivity s;
  private String t;
  private Bundle u;
  private int v = -1;
  private long w = 0L;
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, QQNearbyManager.n());
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
    PublicTransFragmentActivity.b(paramContext, localIntent, QQNearbyManager.n());
  }
  
  private void a(Bundle paramBundle)
  {
    if ("2".equals(paramBundle.getString("play_mode")))
    {
      this.a.a(false);
      return;
    }
    this.a.a(true);
  }
  
  private void b(Bundle paramBundle) {}
  
  private void i()
  {
    this.a.setOnCloseListener(new SmallVideoFragment.1(this));
  }
  
  private void j()
  {
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.f.b();
    if (!TextUtils.isEmpty(this.u.getString("imageUri"))) {
      this.t = this.u.getString("imageUri");
    } else if (!TextUtils.isEmpty(this.u.getString("cover_url"))) {
      this.t = this.u.getString("cover_url");
    }
    if (getBaseActivity().getIntent() != null)
    {
      int i1 = getBaseActivity().getIntent().getIntExtra("system_msg_type", 0);
      boolean bool = getBaseActivity().getIntent().getBooleanExtra("scroll_to_comment", false);
      this.v = getBaseActivity().getIntent().getIntExtra("feedType", -1);
      if ((i1 == 2) || (bool)) {
        ThreadManager.getUIHandler().postDelayed(new SmallVideoFragment.2(this), 1000L);
      }
    }
  }
  
  private int k()
  {
    this.b = ((DragFrameLayout)a(2131432141));
    this.g = a(2131428285);
    this.e = ((RelativeLayout)a(2131440583));
    this.f = ((QQStoryLoadingView)a(2131449632));
    this.c = ((RelativeLayout)a(2131432163));
    this.b.setDraggableView(this.c);
    this.b.setOnDraggingListener(this);
    this.i = 0;
    this.j = 0;
    this.k = -1;
    this.l = -1;
    DragFrameLayout localDragFrameLayout = this.b;
    int i2 = this.k;
    localDragFrameLayout.a = i2;
    int i1 = i2;
    if (i2 > this.l) {
      i1 = i2 / 2;
    }
    return i1;
  }
  
  private boolean l()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.d.getAdapter();
    if ((localVideoPlayerPagerAdapter.d(this.d.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      return ((IShortVideoCommentsView)localVideoPlayerPagerAdapter.d(this.d.getCurrentItem())).isScrollTop();
    }
    return false;
  }
  
  public View a(int paramInt)
  {
    return this.o.findViewById(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 1.0F - (paramInt3 - paramInt5) / UITools.a(getBaseActivity(), 60.0F);
    float f2 = 0.0F;
    if (f1 < 0.0F) {
      f1 = f2;
    }
    ViewHelper.setAlpha(this.g, f1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > UITools.a(getBaseActivity(), 60.0F))
    {
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("slide_quit").genderInd1().reportByVideo(getBaseActivity().app);
      if (this.n) {
        h();
      } else {
        getBaseActivity().finish();
      }
      this.a.e();
      return;
    }
    this.b.a(250);
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.g), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.g.startAnimation(paramView);
  }
  
  public boolean a()
  {
    return l();
  }
  
  public boolean b()
  {
    if ((this.d.getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      int i1 = ((VideoPlayerPagerAdapter)this.d.getAdapter()).d.size();
      if ((this.d.getAdapter().getCount() == 0) || (this.d.getCurrentItem() >= i1 - 1)) {
        return l();
      }
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.d.getCurrentItem() == 0) {
      return l();
    }
    return false;
  }
  
  public void d()
  {
    if (this.m == null) {
      this.m = ((AudioManager)getBaseActivity().getApplicationContext().getSystemService("audio"));
    }
    try
    {
      int i2 = this.m.requestAudioFocus(this.p, 3, 2);
      int i1 = i2;
      if (i2 == 0) {
        i1 = this.m.requestAudioFocus(this.p, 3, 1);
      }
      if (i1 == 0)
      {
        this.m.requestAudioFocus(this.p, 3, 3);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.e.getVisibility() != 8)
    {
      this.c.setBackgroundDrawable(new ColorDrawable(-1));
      this.e.setVisibility(8);
      this.e.setBackgroundColor(0);
      localObject = this.f;
      if (localObject != null)
      {
        ((QQStoryLoadingView)localObject).a();
        this.f.setVisibility(8);
      }
    }
  }
  
  public void f()
  {
    QQStoryLoadingView localQQStoryLoadingView = this.f;
    if (localQQStoryLoadingView != null)
    {
      localQQStoryLoadingView.a();
      this.f.setVisibility(8);
    }
  }
  
  protected int g()
  {
    return 2131627557;
  }
  
  protected void h()
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("clk_quit").genderInd1().reportByVideo(getBaseActivity().app);
    if (!this.n)
    {
      getBaseActivity().finish();
      return;
    }
    ViewHelper.setAlpha(this.g, 0.0F);
    this.g.setVisibility(8);
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
    this.a.a(paramInt1, paramInt2, paramIntent);
    Object localObject = (VideoPlayerPagerAdapter)this.d.getAdapter();
    if ((((VideoPlayerPagerAdapter)localObject).d(this.d.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      ((IShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).d(this.d.getCurrentItem())).onActivityResult(paramInt1, paramInt2, paramIntent);
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
        ThreadManagerV2.excute(new SmallVideoFragment.4(this, (INearbyCardManager)this.s.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
        return;
      }
      if (paramInt1 == 124) {
        ThreadManagerV2.excute(new SmallVideoFragment.5(this, (INearbyCardManager)this.s.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.s = ((BaseActivity)paramActivity);
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
    this.o = paramLayoutInflater.inflate(g(), null);
    this.o.setFitsSystemWindows(true);
    this.w = System.currentTimeMillis();
    getBaseActivity().getIntent().putExtra("fling_action_key", 0);
    this.u = super.getBaseActivity().getIntent().getExtras();
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFrom(this.u.getString("_from", ""));
    this.a = ((StuffContainerView)a(2131449660));
    this.a.setApp(getBaseActivity().app);
    this.a.setCallBack(this);
    a(this.u);
    this.d = this.a.c;
    this.h = a(2131437650);
    int i1 = k();
    j();
    b(this.u);
    this.b.a = i1;
    this.a.a(this.u);
    this.a.b(this.u);
    i();
    QualityReporter.c();
    return this.o;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    long l1 = System.currentTimeMillis() - this.w;
    Object localObject1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_time");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((INowVideoReporter)localObject1).d4(((StringBuilder)localObject2).toString()).genderInd1();
    if (getActivity() != null) {
      localObject1 = getBaseActivity().app;
    } else {
      localObject1 = null;
    }
    ((INowVideoReporter)localObject2).reportByVideo((AppInterface)localObject1);
    ThreadManagerV2.excute(new SmallVideoFragment.3(this, l1, (INearbyCardManager)this.s.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    this.a.c();
    localObject1 = this.b;
    if (localObject1 != null) {
      ((DragFrameLayout)localObject1).a();
    }
    localObject1 = this.m;
    if (localObject1 != null) {
      ((AudioManager)localObject1).abandonAudioFocus(this.p);
    }
    AnimatorProxy.wrap(this.g).reset();
    AnimatorProxy.wrap(this.c).reset();
  }
  
  public void onFinish()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.d.getAdapter();
    if ((localVideoPlayerPagerAdapter.d(this.d.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      ((CommentsView)localVideoPlayerPagerAdapter.d(this.d.getCurrentItem())).hideInputKeyboard();
    }
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 2130772092);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.q = false;
    this.a.a();
    AudioManager localAudioManager = this.m;
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(this.p);
    }
  }
  
  public void onResume()
  {
    this.q = true;
    super.onResume();
    if (this.r) {
      this.r = false;
    } else {
      this.a.b();
    }
    ((InputMethodManager)getBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment
 * JD-Core Version:    0.7.0.1
 */