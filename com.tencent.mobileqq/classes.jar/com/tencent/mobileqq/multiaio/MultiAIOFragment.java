package com.tencent.mobileqq.multiaio;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MultiAIOUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.OnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.mobileqq.multiaio.widget.TouchEventConsumer;
import com.tencent.mobileqq.multiaio.widget.ZoomOutPageTransformer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;

public class MultiAIOFragment
  extends PublicBaseFragment
  implements MultiAioContainer, TouchEventConsumer, BusinessObserver
{
  private QQAppInterface a;
  private List<RecentBaseData> b;
  private MultiAIOViewPager c;
  private MultiAIOPagerAdapter d;
  private TabPageIndicator e;
  private Handler f = new Handler(Looper.getMainLooper());
  private MultiAIOFragment.UpdateMsgReadTimer g = new MultiAIOFragment.UpdateMsgReadTimer(this, null);
  private MultiAIOFragment.MiniAIOScrollToNewMsg h = new MultiAIOFragment.MiniAIOScrollToNewMsg(this, null);
  private String i;
  private String j;
  private String k;
  private int l;
  private ValueAnimator m;
  private ValueAnimator n;
  private boolean o;
  private boolean p;
  private int q;
  private int[] r;
  private View s;
  private int[] t = new int[2];
  private View u;
  private boolean v;
  private View w;
  private boolean x;
  private MultiAIOUnreadListener y = new MultiAIOFragment.17(this);
  
  public MultiAIOFragment()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.identityHashCode(this));
      localStringBuilder.append(" MultiAIOFragment() called");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
  }
  
  private int a(View paramView)
  {
    paramView = ((ChatXListView)paramView.findViewById(2131437281)).getAdapter();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < paramView.getCount(); i2 = i3)
    {
      Object localObject = paramView.getItem(i1);
      if (localObject == null)
      {
        i3 = i2;
      }
      else
      {
        i3 = i2;
        if ((localObject instanceof ChatMessage)) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  private void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      this.i = paramActivity.getStringExtra("conversation_tab_flag");
      this.j = paramActivity.getStringExtra("uin");
      this.l = paramActivity.getIntExtra("uintype", -1);
      this.k = paramActivity.getStringExtra("uinname");
      this.q = paramActivity.getIntExtra("OPEN_MULTI_AIO_CONTEXT", 0);
      this.r = paramActivity.getIntArrayExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM");
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt1, RecentBaseData paramRecentBaseData, boolean paramBoolean, Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openAIO() called with: recentBaseData = [");
      paramContext.append(paramRecentBaseData);
      paramContext.append("], showKeyBoard = [");
      paramContext.append(paramBoolean);
      paramContext.append("]");
      QLog.d("MultiAioFragment", 2, paramContext.toString());
    }
    paramContext = getBaseActivity();
    if (paramContext == null)
    {
      QLog.e("MultiAioFragment", 1, "openAIO: activity == null 1");
      return;
    }
    paramView = paramContext.getIntent();
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUser localRecentUser = ((RecentUserBaseData)paramRecentBaseData).e();
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
      localBundle.putBoolean("open_chatfragment_withanim", false);
      localBundle.putInt("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", this.q);
      localBundle.putBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", true);
      if (SplashActivity.sWeakInstance != null) {
        paramContext = (Activity)SplashActivity.sWeakInstance.get();
      }
      paramView = paramView.getStringExtra("OPEN_MULTI_FROM_ACTIVITY");
      paramBoolean = ChatActivity.class.getSimpleName().equals(paramView);
      if (paramBoolean)
      {
        localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        paramContext = null;
      }
      paramView = paramContext;
      if (paramContext == null) {
        paramView = getBaseActivity();
      }
      if (paramView == null)
      {
        QLog.e("MultiAioFragment", 1, "openAIO: activity == null 2");
        return;
      }
      paramContext = b();
      paramContext.a(true);
      paramContext.c(paramInt2);
      if (!paramBoolean)
      {
        RecentUtil.a(paramView, this.a, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, null);
        a(paramBitmap, paramArrayOfInt);
        return;
      }
      Intent[] arrayOfIntent = new Intent[1];
      RecentUtil.a(paramView, this.a, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, arrayOfIntent);
      paramContext.a(arrayOfIntent[0]);
      a(paramBitmap, paramArrayOfInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData is wrong type");
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.o) {
        return;
      }
      this.o = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryToPlayEnterAnimation() called with: decorViewBitmap = [");
        localStringBuilder.append(paramBitmap);
        localStringBuilder.append("]");
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
      if ("open_from_aio".equals(this.i)) {
        b(paramBitmap);
      }
    }
  }
  
  private void a(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    ViewGroup localViewGroup = (ViewGroup)getView();
    ImageView localImageView = new ImageView(localViewGroup.getContext());
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(i1, i2);
    localMarginLayoutParams.leftMargin = paramArrayOfInt[0];
    localMarginLayoutParams.topMargin = paramArrayOfInt[1];
    int i3 = localMarginLayoutParams.topMargin;
    int i4 = localMarginLayoutParams.leftMargin;
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).addView(localImageView);
    int i5 = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    int i6 = this.c.getWidth();
    int i7 = localViewGroup.getHeight();
    this.m = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramBitmap = this.m;
    long l1 = 400;
    paramBitmap.setDuration(l1);
    this.m.addUpdateListener(new MultiAIOFragment.14(this, localImageView, i4, i3, i5, i1, i6, i2, i7 - i5));
    this.m.addListener(new MultiAIOFragment.15(this));
    this.m.start();
    this.c.setVisibility(0);
    this.e.setVisibility(0);
    paramBitmap = new AlphaAnimation(1.0F, 0.0F);
    paramBitmap.setDuration(l1);
    this.c.startAnimation(paramBitmap);
    this.e.startAnimation(paramBitmap);
  }
  
  private void a(View paramView, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryToSetBlurBackground() called with: root = [");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append("], blurBitmap = [");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.p) {
      return;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = getView();
    }
    if (localObject == null) {
      return;
    }
    if (paramBitmap == null)
    {
      ((View)localObject).setBackgroundColor(Color.parseColor("#7F000000"));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() setBackgroundColor");
      }
      return;
    }
    this.p = true;
    paramView = getBaseActivity();
    if ((paramView != null) && (!paramView.isFinishing()))
    {
      paramView = new BitmapDrawable(paramBitmap);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryToSetBlurBackground() called with: root = [");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], blurBitmap = [");
        localStringBuilder.append(paramBitmap);
        localStringBuilder.append("]");
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
      ((View)localObject).setBackgroundDrawable(paramView);
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.e = ((TabPageIndicator)paramView.findViewById(2131435686));
    this.e.a(this.a, getBaseActivity());
    this.c = ((MultiAIOViewPager)paramView.findViewById(2131449793));
    this.c.setOffscreenPageLimit(2);
    paramBundle = getResources();
    int i1 = (int)((paramBundle.getDisplayMetrics().widthPixels - AIOUtils.b(42.0F, paramBundle) * 2) * (1.0F - ZoomOutPageTransformer.a) * 0.5F);
    int i2 = AIOUtils.b(2.0F, paramBundle);
    this.c.setPageMargin(-(i1 + i2));
    this.c.setPageTransformer(false, new ZoomOutPageTransformer());
    this.c.setOnClickListener(new MultiAIOFragment.2(this));
    this.c.setTouchEventConsumer(this);
    this.e.setOnClickListener(new MultiAIOFragment.3(this));
    this.e.setTouchEventConsumer(this);
    this.d = new MultiAIOPagerAdapter(getChildFragmentManager());
    this.d.a(this.b);
    paramBundle = b();
    i2 = this.b.size();
    i1 = i2;
    if (i2 > 0) {
      i1 = 0;
    }
    paramBundle.a(getBaseActivity().getLayoutInflater(), this.c, i1);
    this.c.setAdapter(this.d);
    this.e.setViewPager(this.c);
    this.c.setActTAG("MultiWindowAIOFPS");
    this.c.setIdleListener(new MultiAIOFragment.4(this));
    this.c.setFlingListener(new MultiAIOFragment.5(this));
    Object localObject = new MultiAIOFragment.6(this);
    this.e.setOnPageChangeListener((MultiAIOBaseViewPager.OnPageChangeListener)localObject);
    this.e.setOnTabClickListener(new MultiAIOFragment.7(this));
    ((MultiAIOBaseViewPager.SimpleOnPageChangeListener)localObject).b(0);
    this.e.a(new MultiAIOFragment.8(this));
    this.e.setOnActionUpNotFling(new MultiAIOFragment.9(this));
    this.e.setOverScrollMode(2);
    localObject = b(getBaseActivity());
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptScrollLRFlag(false);
    }
    localObject = paramBundle.f();
    paramBundle.b(null);
    a((Bitmap)localObject);
    a(paramView, paramBundle.g());
    paramBundle.c(null);
  }
  
  private void a(ImageView paramImageView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramImageView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramImageView);
    }
    this.n = null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], fromType = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private TopGestureLayout b(Activity paramActivity)
  {
    paramActivity = (FrameLayout)paramActivity.getWindow().getDecorView();
    int i1 = 0;
    while (i1 < paramActivity.getChildCount())
    {
      View localView = paramActivity.getChildAt(i1);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleUpdateMsgReadState() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    k();
    this.g.a(paramInt);
    this.h.a(paramInt);
    this.f.postDelayed(this.g, 1000L);
    this.f.postDelayed(this.h, 100L);
  }
  
  private void b(Bitmap paramBitmap)
  {
    FrameLayout localFrameLayout = (FrameLayout)getBaseActivity().getWindow().getDecorView();
    int i1 = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    ImageView localImageView = new ImageView(getBaseActivity());
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight());
    localMarginLayoutParams.leftMargin = 0;
    localMarginLayoutParams.topMargin = i1;
    i1 = localMarginLayoutParams.leftMargin;
    int i2 = localMarginLayoutParams.topMargin;
    int i3 = localMarginLayoutParams.width;
    int i4 = localMarginLayoutParams.height;
    int i5 = getResources().getDimensionPixelSize(2131296649);
    int i7 = getResources().getDimensionPixelSize(2131296649);
    int i6 = getResources().getDimensionPixelOffset(2131296650);
    i7 = getResources().getDisplayMetrics().widthPixels - i5 - i7;
    int i8 = getResources().getDisplayMetrics().heightPixels - i6;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterAnimation() called with: destinationWidth = [");
      localStringBuilder.append(i7);
      localStringBuilder.append("], destinationHeight = [");
      localStringBuilder.append(i8);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localFrameLayout.addView(localImageView);
    this.n = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramBitmap = this.n;
    long l1 = 400;
    paramBitmap.setDuration(l1);
    this.n.addUpdateListener(new MultiAIOFragment.12(this, localImageView, i1, i5, i2, i6, i3, i7, i8, i4));
    this.n.addListener(new MultiAIOFragment.13(this, localImageView));
    this.n.start();
    this.c.setVisibility(0);
    this.e.setVisibility(0);
    paramBitmap = new AlphaAnimation(0.0F, 1.0F);
    paramBitmap.setDuration(l1);
    this.c.startAnimation(paramBitmap);
    this.e.startAnimation(paramBitmap);
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.findViewById(2131435808);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  private void g()
  {
    this.a.setMultiAIOUnreadListener(this.y);
  }
  
  private void h()
  {
    j();
    Object localObject = getBaseActivity();
    ViewGroup localViewGroup = (ViewGroup)((BaseActivity)localObject).getWindow().getDecorView();
    this.w = ((BaseActivity)localObject).getLayoutInflater().inflate(2131627281, localViewGroup, false);
    this.w.findViewById(2131429929).setOnClickListener(new MultiAIOFragment.10(this));
    this.w.findViewById(2131429788).setOnClickListener(new MultiAIOFragment.11(this));
    localObject = (TextView)this.w.findViewById(2131448861);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131904867));
    localStringBuilder.append(VelocityUtil.a);
    ((TextView)localObject).setText(localStringBuilder.toString());
    i();
    localViewGroup.addView(this.w);
  }
  
  private void i()
  {
    float f1 = VelocityUtil.a * 1.0F / 20.0F;
    this.c.c(f1);
    this.e.a(f1);
  }
  
  private void j()
  {
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).removeView(this.w);
  }
  
  private void k()
  {
    this.f.removeCallbacks(this.g);
    this.f.removeCallbacks(this.h);
    this.e.d();
  }
  
  private void l()
  {
    if (this.v) {
      return;
    }
    this.f.postDelayed(new MultiAIOFragment.16(this), 500L);
    this.v = true;
  }
  
  private void m()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localBaseActivity.finish();
    }
  }
  
  public RecentBaseData a(int paramInt)
  {
    try
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.b.get(paramInt);
      return localRecentBaseData;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAioFragment", 1, "getData: ", localException);
      m();
    }
    return null;
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.t;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
  }
  
  /* Error */
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 115
    //   6: iconst_1
    //   7: ldc_w 860
    //   10: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 863	android/view/View:getTag	()Ljava/lang/Object;
    //   18: checkcast 865	java/lang/Integer
    //   21: invokevirtual 868	java/lang/Integer:intValue	()I
    //   24: istore_3
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 870	com/tencent/mobileqq/multiaio/MultiAIOFragment:c	(Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   31: istore 5
    //   33: aload_1
    //   34: ldc_w 871
    //   37: invokevirtual 131	android/view/View:findViewById	(I)Landroid/view/View;
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 874	android/view/View:destroyDrawingCache	()V
    //   45: aload_1
    //   46: iconst_1
    //   47: invokevirtual 877	android/view/View:setDrawingCacheEnabled	(Z)V
    //   50: aload_2
    //   51: ifnull +9 -> 60
    //   54: aload_2
    //   55: bipush 8
    //   57: invokevirtual 878	android/view/View:setVisibility	(I)V
    //   60: aload_1
    //   61: invokevirtual 881	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   64: astore 6
    //   66: aload 6
    //   68: aload 6
    //   70: invokevirtual 337	android/graphics/Bitmap:getWidth	()I
    //   73: i2f
    //   74: aload_1
    //   75: invokevirtual 884	android/view/View:getScaleX	()F
    //   78: fmul
    //   79: f2i
    //   80: aload 6
    //   82: invokevirtual 340	android/graphics/Bitmap:getHeight	()I
    //   85: i2f
    //   86: aload_1
    //   87: invokevirtual 887	android/view/View:getScaleY	()F
    //   90: fmul
    //   91: f2i
    //   92: iconst_1
    //   93: invokestatic 891	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   96: astore 6
    //   98: iconst_2
    //   99: newarray int
    //   101: astore 7
    //   103: aload_1
    //   104: aload 7
    //   106: invokevirtual 745	android/view/View:getLocationOnScreen	([I)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 893	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/view/View;)I
    //   114: istore 4
    //   116: aload_0
    //   117: aload_1
    //   118: putfield 895	com/tencent/mobileqq/multiaio/MultiAIOFragment:u	Landroid/view/View;
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 896	android/view/View:getContext	()Landroid/content/Context;
    //   126: aload_1
    //   127: iload_3
    //   128: aload_0
    //   129: getfield 553	com/tencent/mobileqq/multiaio/MultiAIOFragment:b	Ljava/util/List;
    //   132: iload_3
    //   133: invokeinterface 849 2 0
    //   138: checkcast 292	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   141: iload 5
    //   143: aload 6
    //   145: aload 7
    //   147: iload 4
    //   149: invokespecial 898	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mobileqq/activity/recent/RecentBaseData;ZLandroid/graphics/Bitmap;[II)V
    //   152: iload 5
    //   154: ifeq +83 -> 237
    //   157: iconst_2
    //   158: istore_3
    //   159: goto +3 -> 162
    //   162: ldc_w 900
    //   165: iload_3
    //   166: invokestatic 902	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Ljava/lang/String;I)V
    //   169: aload_2
    //   170: ifnull +36 -> 206
    //   173: goto +28 -> 201
    //   176: astore 6
    //   178: goto +38 -> 216
    //   181: astore 6
    //   183: ldc 115
    //   185: iconst_1
    //   186: ldc_w 904
    //   189: aload 6
    //   191: invokestatic 854	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: invokestatic 908	com/tencent/mobileqq/multiaio/utils/GC:a	()V
    //   197: aload_2
    //   198: ifnull +8 -> 206
    //   201: aload_2
    //   202: iconst_0
    //   203: invokevirtual 878	android/view/View:setVisibility	(I)V
    //   206: aload_1
    //   207: iconst_0
    //   208: invokevirtual 877	android/view/View:setDrawingCacheEnabled	(Z)V
    //   211: aload_1
    //   212: invokevirtual 874	android/view/View:destroyDrawingCache	()V
    //   215: return
    //   216: aload_2
    //   217: ifnull +8 -> 225
    //   220: aload_2
    //   221: iconst_0
    //   222: invokevirtual 878	android/view/View:setVisibility	(I)V
    //   225: aload_1
    //   226: iconst_0
    //   227: invokevirtual 877	android/view/View:setDrawingCacheEnabled	(Z)V
    //   230: aload_1
    //   231: invokevirtual 874	android/view/View:destroyDrawingCache	()V
    //   234: aload 6
    //   236: athrow
    //   237: iconst_1
    //   238: istore_3
    //   239: goto -77 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	MultiAIOFragment
    //   0	242	1	paramView	View
    //   0	242	2	paramMotionEvent	MotionEvent
    //   24	215	3	i1	int
    //   114	34	4	i2	int
    //   31	122	5	bool	boolean
    //   64	80	6	localBitmap	Bitmap
    //   176	1	6	localObject	Object
    //   181	54	6	localThrowable	Throwable
    //   101	45	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   41	50	176	finally
    //   54	60	176	finally
    //   60	152	176	finally
    //   162	169	176	finally
    //   183	197	176	finally
    //   41	50	181	java/lang/Throwable
    //   54	60	181	java/lang/Throwable
    //   60	152	181	java/lang/Throwable
    //   162	169	181	java/lang/Throwable
  }
  
  public MultiAioContext b()
  {
    return ((MultiAIOManager)getBaseActivity().app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).b(this.q);
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() != 0) {
      return;
    }
    this.s = paramView;
    if ((this.e.equals(paramView)) && (!this.c.k())) {
      this.c.l();
    }
  }
  
  public int[] c()
  {
    return this.r;
  }
  
  public int[] d()
  {
    return this.t;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.n;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    localValueAnimator = this.m;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    m();
  }
  
  public ListView f()
  {
    View localView = this.u;
    if (localView != null) {
      return (ListView)localView.findViewById(2131437281);
    }
    return null;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    a(paramActivity);
    int i1;
    if (!"open_from_aio".equals(this.i)) {
      i1 = 2130772011;
    } else {
      i1 = 0;
    }
    paramActivity.overridePendingTransition(i1, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAttach() called with: activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
    this.a.registObserver(this);
    MultiAioContext localMultiAioContext = b();
    int i2 = 2;
    Object localObject = localMultiAioContext;
    if (localMultiAioContext == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCreate() called with: savedInstanceState = [");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append("], multiAioContext == null");
        QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
      }
      localObject = MultiAioContext.a(this.a);
      this.q = ((MultiAioContext)localObject).c();
    }
    ((MultiAioContext)localObject).a(this);
    this.b = ((MultiAioContext)localObject).b(this.a, getBaseActivity(), this.i, this.l, this.j, this.k);
    localObject = this.b;
    int i1;
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState != null finish Activity");
      }
      i1 = 1;
    }
    if (i1 != 0) {
      m();
    }
    if ("open_from_aio".equals(this.i)) {
      i1 = 1;
    } else if ("conversation_tab_bottom".equals(this.i)) {
      i1 = i2;
    } else if ("conversation_tab_list".equals(this.i)) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    a("0X8009F7D", i1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    Object localObject2;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131627282, paramViewGroup, false);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MultiAioFragment", 1, "onCreateView: ", localThrowable);
        GC.a();
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
    } while (localObject2 == null);
    a(localObject2, paramBundle);
    g();
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append(System.identityHashCode(this));
      paramLayoutInflater.append(" onCreateView() cost = ");
      paramLayoutInflater.append(SystemClock.elapsedRealtime() - l1);
      paramLayoutInflater.append(" ms");
      QLog.d("MultiAioFragment", 2, paramLayoutInflater.toString());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localObject2);
    return localObject2;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.f.removeCallbacksAndMessages(null);
    Object localObject = getBaseActivity();
    if ((localObject != null) && (((BaseActivity)localObject).isFinishing()))
    {
      MultiAIOHelper.b();
      ((MultiAIOManager)this.a.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a(this.q);
    }
    localObject = this.m;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.m.cancel();
      this.m = null;
    }
    localObject = this.n;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.n.cancel();
      this.n = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).setMultiAIOUnreadListener(null);
      this.a.unRegistObserver(this);
    }
    MultiAIOStarter.a = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = b(getBaseActivity());
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollLRFlag(true);
    }
    j();
    this.e.e();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      m();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.c.m();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive() called with: type = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isSuccess = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP_BLURED");
        localObject = getView();
        paramBundle = (Bundle)localObject;
        if (localObject != null) {
          paramBundle = ((View)localObject).findViewById(2131438990);
        }
        a(paramBundle, localBitmap);
      }
    }
    else if (paramBoolean)
    {
      a((Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP"));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SystemBarCompact localSystemBarCompact = getBaseActivity().mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    boolean bool = VelocityUtil.b;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment
 * JD-Core Version:    0.7.0.1
 */