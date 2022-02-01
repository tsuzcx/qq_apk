package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TabPageIndicator
  extends HorizontalScrollView
  implements DecodeTaskCompletionListener, PageIndicator
{
  private static float M = 1.0F;
  private static float N = 1.333F;
  private boolean A;
  private boolean B;
  private View.OnClickListener C;
  private TouchEventConsumer D;
  private int[] E = new int[2];
  private MultiAioOverScroller F;
  private int G;
  private TabPageIndicator.OnActionUpNotFling H;
  private float I;
  private int J = 2147483647;
  private long K;
  private final View.OnClickListener L = new TabPageIndicator.2(this);
  protected RecentFaceDecoder a;
  private GestureDetector b;
  private Hashtable<String, Bitmap> c = new Hashtable();
  private final int d = 99;
  private Runnable e;
  private LayoutInflater f;
  private int g;
  private List<RecentBaseData> h;
  private QQAppInterface i;
  private BaseActivity j;
  private int k = -1;
  private long l = 0L;
  private IcsLinearLayout m;
  private MultiAIOBaseViewPager n;
  private MultiAIOBaseViewPager.OnPageChangeListener o;
  private int p;
  private TabPageIndicator.OnTabReselectedListener q;
  private Handler r = new Handler(Looper.getMainLooper());
  private TabPageIndicator.OnTabClickListener s;
  private int t;
  private int u;
  private int v;
  private List<TabPageIndicator.OnPageChangeListener> w;
  private int x = 0;
  private int y = 0;
  private boolean z;
  
  public TabPageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.f = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.m = new IcsLinearLayout(paramContext, paramInt);
    this.b = new GestureDetector(getContext(), new TabPageIndicator.3(this), new Handler(Looper.getMainLooper()));
    addView(this.m, new ViewGroup.LayoutParams(-2, -1));
    i();
    this.F.a(new TabPageIndicator.4(this));
    j();
  }
  
  private void a(View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(this.L);
    this.m.removeView(paramView);
    this.m.addView(paramView, new LinearLayout.LayoutParams(-2, -1));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof TabPageIndicator.MultiAIOHolder)) {
      paramView = (TabPageIndicator.MultiAIOHolder)paramView;
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      paramView = paramView.a;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      paramView.setVisibility(i1);
    }
  }
  
  private void a(TabPageIndicator.MultiAIOHolder paramMultiAIOHolder, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if (paramMultiAIOHolder != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        int i2 = paramRecentBaseData.getRecentUserType();
        int i1 = i2;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          i1 = i2;
          if (((RecentCallItem)paramRecentBaseData).a()) {
            i1 = 3002;
          }
        }
        localDrawable = this.a.a(i1, paramRecentBaseData.getRecentUserUin());
      }
      b(paramMultiAIOHolder, paramRecentBaseData, localDrawable);
    }
  }
  
  private void b(TabPageIndicator.MultiAIOHolder paramMultiAIOHolder, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramMultiAIOHolder != null) && (paramRecentBaseData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "getView position: ");
      }
      int i1;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindview user:");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          QLog.i("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
        }
        i1 = ((Integer)RecentFaceDecoder.a(this.i, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
        if (i1 == 103) {
          i1 = 1;
        }
        Object localObject = paramMultiAIOHolder.d;
        QQAppInterface localQQAppInterface = this.i;
        String str = paramRecentBaseData.getRecentUserUin();
        boolean bool;
        if (this.i.mAutomator.f() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((RecentDynamicAvatarView)localObject).setFaceDrawable(localQQAppInterface, paramDrawable, i1, str, 100, false, bool, 0);
      }
      else
      {
        paramMultiAIOHolder.d.setImageDrawable(paramDrawable);
      }
      paramMultiAIOHolder.a.setVisibility(4);
      int i2 = paramRecentBaseData.mUnreadNum;
      if (i2 > 99) {
        paramMultiAIOHolder.c = "99+";
      } else {
        paramMultiAIOHolder.c = String.valueOf(i2);
      }
      if (i2 > 0)
      {
        if (paramRecentBaseData.mUnreadFlag == 3)
        {
          paramMultiAIOHolder.e.setDragViewType(1, null);
          paramMultiAIOHolder.e.setTextColor(this.j.getResources().getColor(2131166577));
          i1 = 2130846241;
        }
        else
        {
          paramMultiAIOHolder.e.setDragViewType(0, null);
          paramMultiAIOHolder.e.setTextColor(this.j.getResources().getColor(2131168174));
          i1 = 2130852592;
        }
        CustomWidgetUtil.a(paramMultiAIOHolder.e, 3, i2, i1, 99, null);
      }
      else
      {
        paramMultiAIOHolder.e.setVisibility(4);
      }
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        paramMultiAIOHolder.a.setImageResource(2130838089);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TabPageIndicator", 2, "holder|param invalidate");
    }
  }
  
  private void d(int paramInt)
  {
    View localView = this.m.getChildAt(paramInt);
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "animateToTab error, tabView is null!");
      }
      return;
    }
    Runnable localRunnable = this.e;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    this.e = new TabPageIndicator.5(this, localView);
    post(this.e);
  }
  
  private void e(int paramInt)
  {
    a(this.m.getChildAt(paramInt), false);
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (TabPageIndicator.OnPageChangeListener)this.w.get(i1);
        if (localObject != null) {
          ((TabPageIndicator.OnPageChangeListener)localObject).a(paramInt);
        }
        i1 += 1;
      }
    }
    g(paramInt);
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChangedInternal() called with: state = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    if (paramInt != 0) {}
  }
  
  private void h()
  {
    try
    {
      Object localObject = HorizontalScrollView.class.getDeclaredField("mVelocityTracker");
      ((Field)localObject).setAccessible(true);
      localObject = (VelocityTracker)((Field)localObject).get(this);
      if (localObject != null)
      {
        this.I = ((VelocityTracker)localObject).getXVelocity();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "readLastInitVelocity: ", localException);
    }
  }
  
  private void i()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      MultiAioOverScroller localMultiAioOverScroller = new MultiAioOverScroller(getContext());
      localField.set(this, localMultiAioOverScroller);
      this.F = ((MultiAioOverScroller)localMultiAioOverScroller);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "replaceOverScroller: ", localException);
    }
  }
  
  private void j()
  {
    try
    {
      Field localField = (Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(HorizontalScrollView.class, new Object[] { "mMaximumVelocity" });
      localField.setAccessible(true);
      int i1 = localField.getInt(this);
      this.G = VelocityUtil.a(getContext(), i1);
      localField.set(this, Integer.valueOf(this.G));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "setMaxVelocity: ", localException);
    }
  }
  
  private boolean k()
  {
    int i1 = this.x;
    return ((i1 == 1) || (i1 == 2)) && (this.y == 0);
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onFinishScroll() called");
    }
    this.J = 2147483647;
    this.B = false;
    setScrollState(0);
    if (this.n.g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() isFakeDragging");
      }
      this.n.f();
    }
    int i2 = this.n.getCurrentItem();
    this.p = i2;
    int i3 = this.m.getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      View localView = this.m.getChildAt(i1);
      boolean bool;
      if (i1 == i2) {
        bool = true;
      } else {
        bool = false;
      }
      localView.setSelected(bool);
      i1 += 1;
    }
    this.k = i2;
  }
  
  private boolean m()
  {
    try
    {
      if (this.B)
      {
        Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        boolean bool = ((OverScroller)localField.get(this)).isFinished();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isFinishScroll: ", localException);
    }
    return true;
  }
  
  public void a(float paramFloat)
  {
    try
    {
      Field localField = (Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(HorizontalScrollView.class, new Object[] { "mMaximumVelocity" });
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf((int)(this.G * paramFloat)));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "updateMaxVelocity: ", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected() called with: position = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    setCurrentItem(paramInt);
    Object localObject = this.o;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    MultiAIOBaseViewPager.OnPageChangeListener localOnPageChangeListener = this.o;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
    }
    paramInt1 = (int)((paramInt1 + paramFloat) * this.v);
    if (f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onPageScrolled() scrollFromViewPager ");
      }
      smoothScrollTo(paramInt1, 0);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.i = paramQQAppInterface;
    this.j = paramBaseActivity;
    this.u = this.j.getResources().getDimensionPixelSize(2131299076);
    paramBaseActivity = this.m;
    int i1 = this.u;
    paramBaseActivity.setPadding(i1, 0, i1, 0);
    this.t = getResources().getDisplayMetrics().widthPixels;
    this.a = new RecentFaceDecoder(paramQQAppInterface, this, false);
  }
  
  public void a(TabPageIndicator.MultiAIOHolder paramMultiAIOHolder, RecentBaseData paramRecentBaseData)
  {
    if ((paramMultiAIOHolder != null) && (paramRecentBaseData != null))
    {
      int i2 = paramRecentBaseData.mUnreadNum;
      if (i2 > 99) {
        paramMultiAIOHolder.c = "99+";
      } else {
        paramMultiAIOHolder.c = String.valueOf(i2);
      }
      if (i2 > 0)
      {
        int i1;
        if (paramRecentBaseData.getRecentUserType() == 1)
        {
          i1 = this.i.getTroopMask(paramRecentBaseData.getRecentUserUin());
          if (i1 == 1) {
            paramRecentBaseData.mUnreadFlag = 1;
          } else if ((i1 == 2) || (i1 == 3) || (i1 == 4)) {
            paramRecentBaseData.mUnreadFlag = 3;
          }
        }
        else if (paramRecentBaseData.getRecentUserType() == 3000)
        {
          if (DiscussionManager.a(this.i, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType())) {
            paramRecentBaseData.mUnreadFlag = 3;
          } else {
            paramRecentBaseData.mUnreadFlag = 1;
          }
        }
        else if (paramRecentBaseData.getRecentUserType() == 0)
        {
          if (FriendsStatusUtil.a(paramRecentBaseData.getRecentUserUin(), this.i)) {
            paramRecentBaseData.mUnreadFlag = 3;
          } else {
            paramRecentBaseData.mUnreadFlag = 1;
          }
        }
        if (paramRecentBaseData.mUnreadFlag == 3)
        {
          paramMultiAIOHolder.e.setDragViewType(1, null);
          paramMultiAIOHolder.e.setTextColor(this.j.getResources().getColor(2131166577));
          i1 = 2130846241;
        }
        else
        {
          paramMultiAIOHolder.e.setDragViewType(0, null);
          paramMultiAIOHolder.e.setTextColor(this.j.getResources().getColor(2131168174));
          i1 = 2130852592;
        }
        CustomWidgetUtil.a(paramMultiAIOHolder.e, 3, i2, i1, 99, null);
        return;
      }
      paramMultiAIOHolder.e.setVisibility(4);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TabPageIndicator", 2, "updateItem|invalidate error");
    }
  }
  
  public void a(TabPageIndicator.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.w == null) {
      this.w = new ArrayList();
    }
    this.w.add(paramOnPageChangeListener);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "updateUnReadMsgState called with:");
    }
    int i1 = 0;
    while (i1 < this.h.size() - 1)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.h.get(i1);
      if ((TextUtils.equals(paramString, localRecentBaseData.getRecentUserUin())) && (paramInt == localRecentBaseData.getRecentUserType()))
      {
        Object localObject = this.i.getConversationFacade();
        if (localObject != null) {
          localRecentBaseData.mUnreadNum = ((ConversationFacade)localObject).a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        } else {
          localRecentBaseData.mUnreadNum = 0;
        }
        if ((this.n.getCurrentItem() != i1) || (localRecentBaseData.mUnreadNum <= 0))
        {
          localObject = this.m.getChildAt(i1).getTag();
          if ((localObject instanceof TabPageIndicator.MultiAIOHolder))
          {
            localObject = (TabPageIndicator.MultiAIOHolder)localObject;
            this.r.post(new TabPageIndicator.1(this, (TabPageIndicator.MultiAIOHolder)localObject, localRecentBaseData));
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("TabPageIndicator", 2, "updateUnReadMsgState() called with: MultiAIOHolder is null!");
          }
        }
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      boolean bool = ((OverScroller)localField.get(this)).isFinished();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isScrollerFinished: ", localException);
    }
    return false;
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    return (i1 == 0) || (i1 == 1000) || (i1 == 1004) || (i1 == 1003) || (i1 == 10004) || (i1 == 1021) || (i1 == 1022) || (i1 == 1023) || (i1 == 10008);
  }
  
  public void b()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      ((OverScroller)localField.get(this)).abortAnimation();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "abortAnimation: ", localException);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onPageScrollStateChanged  state = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.m.getChildAt(this.p).getTag();
    if ((localObject instanceof TabPageIndicator.MultiAIOHolder))
    {
      localObject = (TabPageIndicator.MultiAIOHolder)localObject;
      if (paramInt != 0)
      {
        if ((paramInt != 1) && (paramInt != 2)) {
          return;
        }
        ((TabPageIndicator.MultiAIOHolder)localObject).a.setVisibility(4);
        return;
      }
      ((TabPageIndicator.MultiAIOHolder)localObject).a.setVisibility(0);
    }
  }
  
  public View c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView position: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject1).toString());
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.h.get(paramInt);
    TabPageIndicator.MultiAIOHolder localMultiAIOHolder = new TabPageIndicator.MultiAIOHolder();
    Object localObject2 = this.f;
    Object localObject1 = null;
    localObject2 = ((LayoutInflater)localObject2).inflate(2131624115, null);
    localMultiAIOHolder.d = ((RecentDynamicAvatarView)((View)localObject2).findViewById(2131446751));
    localMultiAIOHolder.e = ((DragTextView)((View)localObject2).findViewById(2131449076));
    localMultiAIOHolder.a = ((ImageView)((View)localObject2).findViewById(2131428774));
    localMultiAIOHolder.b = paramInt;
    ((View)localObject2).setTag(localMultiAIOHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    RecentFaceDecoder localRecentFaceDecoder = this.a;
    if (localRecentFaceDecoder != null) {
      localObject1 = localRecentFaceDecoder.a(localRecentBaseData);
    }
    b(localMultiAIOHolder, localRecentBaseData, (Drawable)localObject1);
    localStringBuilder.append(localRecentBaseData.getTitleName());
    if (AppSetting.e) {
      ((View)localObject2).setContentDescription(localStringBuilder.toString());
    }
    return localObject2;
  }
  
  public void c()
  {
    int i2 = this.n.getCurrentItem();
    int i1 = 0;
    while (i1 < this.m.getChildCount())
    {
      View localView = this.m.getChildAt(i1);
      if (localView != null)
      {
        boolean bool;
        if (i2 == i1) {
          bool = true;
        } else {
          bool = false;
        }
        a(localView, bool);
      }
      i1 += 1;
    }
  }
  
  public void computeScroll()
  {
    this.z = false;
    int i1 = this.F.getFinalX();
    super.computeScroll();
    if ((this.F.getFinalX() < i1) && (QLog.isColorLevel())) {
      QLog.d("TabPageIndicator", 2, "computeScroll() called afterComputeFinalX < beforeComputeFinalX");
    }
    requestLayout();
    if (this.x == 2)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("computeScroll() ScrollX = ");
        localStringBuilder.append(getScrollX());
        localStringBuilder.append(", Scroller.FinialX = ");
        localStringBuilder.append(this.F.getFinalX());
        QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
      }
      if (!this.z)
      {
        if (m())
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("computeScroll() mCallOnScrollChanged = false, I'm not scrolling ? Build.MANUFACTURER = ");
            localStringBuilder.append(Build.MANUFACTURER);
            localStringBuilder.append(", Build.MODEL = ");
            localStringBuilder.append(Build.MODEL);
            QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
          }
          l();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "computeScroll() isFinishScroll = false");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = true");
      }
    }
  }
  
  public void d()
  {
    int i1 = 0;
    while (i1 < this.m.getChildCount())
    {
      View localView = this.m.getChildAt(i1);
      if (localView != null) {
        a(localView, false);
      }
      i1 += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], handled = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = this.D;
      if (localObject != null) {
        ((TouchEventConsumer)localObject).b(this, paramMotionEvent);
      }
      int i1 = paramMotionEvent.getActionMasked();
      if (i1 != 0)
      {
        if ((i1 != 1) && (i1 != 3)) {
          return bool;
        }
        if ((this.A) && (!this.B))
        {
          this.F.forceFinished(true);
          paramMotionEvent = this.H;
          if (paramMotionEvent != null) {
            paramMotionEvent.a((int)this.I);
          }
        }
        this.A = false;
        setScrollState(2);
        invalidate();
        return bool;
      }
      this.A = true;
      this.B = false;
      setScrollState(1);
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("dispatchTouchEvent()  ACTION_DOWN called with: mScrollState = ");
        paramMotionEvent.append(this.x);
        QLog.d("TabPageIndicator", 2, paramMotionEvent.toString());
      }
    }
    return bool;
  }
  
  public void e()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.a;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  public boolean f()
  {
    return (this.y == 1) && (this.x == 0);
  }
  
  public void fling(int paramInt)
  {
    int i1 = paramInt;
    long l1 = SystemClock.uptimeMillis();
    this.B = true;
    boolean bool;
    if (i1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i4 = getWidth() - getPaddingRight() - getPaddingLeft();
    int i5 = getChildAt(0).getWidth();
    Object localObject = this.F;
    int i2 = getScrollX();
    int i3 = getScrollY();
    i5 -= i4;
    int i7 = Math.max(0, i5);
    int i6 = i4 / 2;
    ((MultiAioOverScroller)localObject).fling(i2, i3, paramInt, 0, 0, i7, 0, 0, i6, 0);
    paramInt = this.F.getFinalX();
    i3 = this.v;
    i2 = paramInt / i3;
    float f1 = paramInt * 1.0F / i3;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fling() called with: getScrollX() = ");
      ((StringBuilder)localObject).append(getScrollX());
      ((StringBuilder)localObject).append(", velocityX = [");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], pageFloat = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", pageInt = ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(", flingFromRight2Left = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", flingDistance = ");
      ((StringBuilder)localObject).append(paramInt - getScrollX());
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      paramInt = i2;
      if (f1 - i2 >= 0.5F)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() 手向左滑 增加滑动一点到下一页");
        }
        paramInt = i2 + 1;
        break label360;
      }
    }
    for (;;)
    {
      i2 = 0;
      break label363;
      paramInt = i2;
      if (f1 - i2 < 0.5F) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() 手向右滑 增加滑动一点到下一页");
      }
      paramInt = i2 + 1;
    }
    label360:
    i2 = 1;
    label363:
    i3 = paramInt;
    if (paramInt < 0) {
      i3 = 0;
    }
    this.J = (this.v * i3);
    i3 = 2147483647;
    i4 = 0;
    paramInt = i1;
    i1 = i4;
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called mPendingFinalX = [");
        ((StringBuilder)localObject).append(this.J);
        ((StringBuilder)localObject).append("], currentFinalX = [");
        ((StringBuilder)localObject).append(this.F.getFinalX());
        ((StringBuilder)localObject).append("]");
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      i4 = Math.abs(this.F.getFinalX() - this.J);
      if ((i3 != 2147483647) && (i4 > i3 + 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling: error state deltaDistance ");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append(", lastDeltaDistance = ");
        ((StringBuilder)localObject).append(i3);
        QLog.e("TabPageIndicator", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        if (i4 != 0) {
          break label683;
        }
      }
      this.F.forceFinished(true);
      setScrollState(2);
      super.fling(paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called with: velocityX = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], final ScrollX = ");
        ((StringBuilder)localObject).append(this.F.getFinalX());
        ((StringBuilder)localObject).append(", exec time = ");
        ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l1);
        ((StringBuilder)localObject).append(" ms");
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      return;
      label683:
      while (!this.F.isFinished()) {
        this.F.forceFinished(true);
      }
      if (bool ? i2 == 0 : i2 != 0) {
        paramInt -= i4;
      } else {
        paramInt += i4;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called with: try ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", velocityX = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], deltaVelocity = ");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append(", deltaDistance = ");
        ((StringBuilder)localObject).append(i4);
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      i1 += 1;
      this.F.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i5), 0, 0, i6, 0);
      i3 = i4;
    }
  }
  
  public void g()
  {
    this.m.removeAllViews();
    Object localObject = this.n.getAdapter();
    this.g = ((PagerAdapter)localObject).getCount();
    if ((localObject instanceof MultiAIOPagerAdapter))
    {
      this.h = ((MultiAIOPagerAdapter)localObject).a();
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = this.g;
        if (i1 >= i2) {
          break;
        }
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
        long l1 = SystemClock.elapsedRealtime();
        localObject = c(i1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createView() cost ");
          localStringBuilder.append(SystemClock.elapsedRealtime() - l1);
          localStringBuilder.append(" ms");
          QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
        }
        a((View)localObject);
        i1 += 1;
      }
      if (this.p > i2) {
        this.p = (i2 - 1);
      }
      setCurrentItem(this.p);
      requestLayout();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.e;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramBitmap != null) {
      try
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(???);
        ((Hashtable)localObject1).put(((StringBuilder)localObject2).toString(), paramBitmap);
      }
      catch (OutOfMemoryError ???)
      {
        System.gc();
        ???.printStackTrace();
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted error:");
        paramBitmap.append(???.getMessage());
        QLog.i("TabPageIndicator", 1, paramBitmap.toString());
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.l;
    int i1 = 0;
    if ((l2 > 0L) && (l1 - l2 > 300L)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      return;
    }
    boolean bool1;
    boolean bool2;
    synchronized (this.c)
    {
      if (this.c.size() == 0) {
        return;
      }
      if (paramInt1 == 0) {
        this.l = 0L;
      } else {
        this.l = l1;
      }
      paramInt2 = this.m.getChildCount();
      bool1 = false;
      paramInt1 = i1;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = (RecentBaseData)this.h.get(paramInt1);
        if (paramBitmap == null)
        {
          bool2 = bool1;
        }
        else
        {
          localObject1 = this.m.getChildAt(paramInt1).getTag();
          bool2 = bool1;
          if ((localObject1 instanceof TabPageIndicator.MultiAIOHolder))
          {
            localObject1 = (TabPageIndicator.MultiAIOHolder)localObject1;
            i1 = paramBitmap.getRecentUserType();
            i1 = ((Integer)RecentFaceDecoder.a(this.i, i1, paramBitmap.getRecentUserUin()).first).intValue();
            bool2 = bool1;
            if (i1 != -2147483648)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(i1);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(paramBitmap.getRecentUserUin());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = (Bitmap)this.c.get(localObject2);
              bool2 = bool1;
              if (localObject2 != null)
              {
                a((TabPageIndicator.MultiAIOHolder)localObject1, paramBitmap, new BitmapDrawable(this.j.getResources(), (Bitmap)localObject2));
                bool2 = true;
              }
            }
          }
        }
      }
      else
      {
        if (QLog.isDevelopLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("decodecomplete|faceCache size = ");
          paramBitmap.append(this.c.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("TabPageIndicator", 4, paramBitmap.toString());
        }
        this.c.clear();
        return;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = this.e;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.m.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.m.getChildAt(paramInt1);
      ((View)localObject).getLocationOnScreen(this.E);
      paramInt3 = Math.abs(this.E[0] - this.u);
      float f1 = paramInt3;
      paramInt4 = this.v;
      f1 /= paramInt4;
      if (paramInt3 <= paramInt4)
      {
        double d1 = M;
        double d2 = f1;
        Double.isNaN(d2);
        d2 = Math.cos(d2 * 1.570796326794897D);
        f1 = N;
        double d3 = f1 - M;
        Double.isNaN(d3);
        Double.isNaN(d1);
        f1 = Math.min((float)(d1 + d2 * d3), f1);
      }
      else
      {
        f1 = M;
      }
      localObject = ((View)localObject).getTag();
      if ((localObject instanceof TabPageIndicator.MultiAIOHolder))
      {
        localObject = (TabPageIndicator.MultiAIOHolder)localObject;
        ((TabPageIndicator.MultiAIOHolder)localObject).d.setScaleX(f1);
        ((TabPageIndicator.MultiAIOHolder)localObject).d.setScaleY(f1);
      }
      paramInt1 += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int i1 = getMeasuredWidth();
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if (this.m.getChildCount() > 0)
    {
      this.v = this.m.getChildAt(0).getMeasuredWidth();
      paramInt2 = this.t;
      int i2 = this.v;
      int i3 = this.u;
      IcsLinearLayout localIcsLinearLayout = this.m;
      localIcsLinearLayout.setPadding(localIcsLinearLayout.getPaddingLeft(), this.m.getPaddingTop(), paramInt2 - i2 - i3, this.m.getPaddingBottom());
    }
    if ((bool) && (i1 != paramInt1)) {
      setCurrentItem(this.p);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.z = true;
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (k())
    {
      paramInt3 = this.n.getWidth() - this.n.getPaddingLeft() - this.n.getPaddingRight() + this.n.getPageMargin();
      paramInt4 = this.v;
      paramInt2 = paramInt1 / paramInt4;
      float f1 = paramInt1 % paramInt4 * 1.0F / paramInt4;
      paramInt1 = (int)(paramInt2 * paramInt3 + f1 * paramInt3);
      if ((this.n.g()) || (this.n.e()))
      {
        f1 = this.n.getScrollX() - paramInt1;
        paramInt1 = Math.abs(paramInt2 - this.n.getCurrentItem());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onScrollChanged() CurrentItem = [");
          localStringBuilder.append(this.n.getCurrentItem());
          localStringBuilder.append("], position = [");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], deltaPosition = ");
          localStringBuilder.append(paramInt1);
          QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
        }
        if (paramInt1 != 0) {
          this.n.a(paramInt2);
        }
        this.n.b(f1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    if ((this.K > 0L) && (SystemClock.uptimeMillis() - this.K < 250L)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (!a()) {
      i1 = 0;
    }
    if (i1 != 0) {
      this.b.onTouchEvent(paramMotionEvent);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent() called with: ev = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("]");
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent() called with: ev = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("], handled = ");
      localStringBuilder.append(bool);
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentItem() called with: item = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mSelectedTabIndex = [");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (this.n != null)
    {
      if (this.k == paramInt)
      {
        d(paramInt);
        return;
      }
      this.p = paramInt;
      int i2 = this.m.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.m.getChildAt(i1);
        boolean bool;
        if (i1 == paramInt) {
          bool = true;
        } else {
          bool = false;
        }
        ((View)localObject).setSelected(bool);
        if (bool) {
          d(paramInt);
        }
        int i3 = this.k;
        if (i3 == i1) {
          e(i3);
        }
        i1 += 1;
      }
      this.k = paramInt;
      return;
    }
    Object localObject = new IllegalStateException("ViewPager has not been bound.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setOnActionUpNotFling(TabPageIndicator.OnActionUpNotFling paramOnActionUpNotFling)
  {
    this.H = paramOnActionUpNotFling;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.C = paramOnClickListener;
  }
  
  public void setOnPageChangeListener(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.o = paramOnPageChangeListener;
  }
  
  public void setOnTabClickListener(TabPageIndicator.OnTabClickListener paramOnTabClickListener)
  {
    this.s = paramOnTabClickListener;
  }
  
  public void setOnTabReselectedListener(TabPageIndicator.OnTabReselectedListener paramOnTabReselectedListener)
  {
    this.q = paramOnTabReselectedListener;
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.x == paramInt) {
      return;
    }
    this.x = paramInt;
    f(paramInt);
  }
  
  public void setTouchEventConsumer(TouchEventConsumer paramTouchEventConsumer)
  {
    this.D = paramTouchEventConsumer;
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = this.n;
    if (localMultiAIOBaseViewPager == paramMultiAIOBaseViewPager) {
      return;
    }
    if (localMultiAIOBaseViewPager != null) {
      localMultiAIOBaseViewPager.setOnPageChangeListener(null);
    }
    if (paramMultiAIOBaseViewPager.getAdapter() != null)
    {
      this.n = paramMultiAIOBaseViewPager;
      paramMultiAIOBaseViewPager.setOnPageChangeListener(this);
      g();
      return;
    }
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager, int paramInt)
  {
    setViewPager(paramMultiAIOBaseViewPager);
    setCurrentItem(paramInt);
  }
  
  public void setViewPagerBusy(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator
 * JD-Core Version:    0.7.0.1
 */