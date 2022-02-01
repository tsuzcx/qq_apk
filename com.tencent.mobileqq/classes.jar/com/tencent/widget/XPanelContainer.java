package com.tencent.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.api.IFitSystemWindowsUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static int a = 0;
  public static int b = 0;
  public static int c = 0;
  public static volatile int d = 0;
  public static boolean h = false;
  private static int p = 0;
  private static boolean q = ;
  private boolean A;
  private boolean B;
  private boolean C;
  private int D;
  private boolean E;
  private int F;
  private boolean G;
  private XPanelContainer.ReadyToShowChangeListener H;
  private boolean I;
  private int J;
  private long K;
  protected int e;
  protected int f;
  boolean g;
  public boolean i;
  protected int j;
  protected boolean k;
  protected boolean l;
  public XPanelContainer.OnChangeMultiScreenListener m;
  public WeakReference<XPanelContainer.OnGoingToShowPanelListener> n;
  private List<IKeyboardHiddenCallback> o;
  private int r;
  private int s;
  private View t;
  private XPanelContainer.PanelCallback u;
  private View v;
  private SparseArray<View> w;
  private int x;
  private int y;
  private int z;
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @TargetApi(11)
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 0;
    this.e = 0;
    this.f = -1;
    this.s = -1;
    this.g = false;
    this.w = new SparseArray(4);
    this.x = -1;
    this.y = -1;
    this.z = -1;
    this.i = true;
    this.j = 0;
    this.G = true;
    this.l = false;
    this.I = true;
    this.J = 0;
    this.K = -1L;
    p();
    if (a == 0)
    {
      b = (int)(getDefaultExternalPanelHeighy() * paramContext.getResources().getDisplayMetrics().density);
      a = getExternalPanelInitHeight();
      double d1;
      if (SystemBarTintManager.hasNavBar(paramContext))
      {
        i1 = SystemBarTintManager.getNavigationBarHeight(paramContext);
        d1 = paramContext.getResources().getDisplayMetrics().heightPixels + i1;
        Double.isNaN(d1);
        c = (int)(d1 * 0.5D);
      }
      else
      {
        d1 = paramContext.getResources().getDisplayMetrics().heightPixels;
        Double.isNaN(d1);
        c = (int)(d1 * 0.5D);
      }
      if (QLog.isColorLevel())
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append(" mMAXExternalPanelheight = ");
        paramAttributeSet.append(c);
        paramAttributeSet.append("mExternalPanelheight=");
        paramAttributeSet.append(a);
        QLog.d("Q.aio.XPanelContainer", 2, paramAttributeSet.toString());
      }
      if (QLog.isColorLevel())
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append(" mDefaultExternalPanelheight = ");
        paramAttributeSet.append(b);
        paramAttributeSet.append("mMAXExternalPanelheight=");
        paramAttributeSet.append(c);
        paramAttributeSet.append("density=");
        paramAttributeSet.append(paramContext.getResources().getDisplayMetrics().density);
        paramAttributeSet.append("mNavigationBarHeight=");
        paramAttributeSet.append(i1);
        QLog.d("XPanelContainer", 2, paramAttributeSet.toString());
      }
    }
    this.D = ImmersiveUtils.getStatusBarHeight(getContext());
    if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 24) && (!DeviceInfoUtil2.a())) {
      setOnSystemUiVisibilityChangeListener(new XPanelContainer.1(this));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.n;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (XPanelContainer.OnGoingToShowPanelListener)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((XPanelContainer.OnGoingToShowPanelListener)localObject).b(paramInt1, paramInt2);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if (this.i)
    {
      localObject = this.m;
      if (localObject != null) {
        ((XPanelContainer.OnChangeMultiScreenListener)localObject).k(h);
      }
      this.i = false;
    }
    if (this.E)
    {
      this.E = false;
      localObject = this.m;
      if (localObject != null) {
        ((XPanelContainer.OnChangeMultiScreenListener)localObject).k(h);
      }
      if (this.v != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
        }
        this.v.setVisibility(8);
        this.v = null;
      }
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      e();
      setStatus(0);
      this.j = 0;
      this.f = -1;
      b = (int)(getDefaultExternalPanelHeighy() * getContext().getResources().getDisplayMetrics().density);
      a = b;
      d = 0;
      try
      {
        paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
        paramInt3 = getPaddingLeft();
        paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
        paramInt4 = getPaddingTop();
        localObject = getChildAt(0);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
        ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  error = ");
          localStringBuilder.append(localException);
          QLog.d("Q.aio.XPanelContainer", 2, localStringBuilder.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (h)
    {
      b = (int)(getDefaultExternalPanelHeighy() * getContext().getResources().getDisplayMetrics().density);
      a = getPanelHeight();
      d = 0;
      int i1 = this.j;
      if (i1 == 1)
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (i1 == 0)
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        View localView = this.v;
        if ((localView == null) || (localView.getVisibility() != 0)) {
          break label258;
        }
        localView = this.v;
        i1 = paramInt3 - paramInt1;
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(a, 1073741824));
        this.v.layout(paramInt1, paramInt4 - a, paramInt3, paramInt4);
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - a, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - a);
      }
      setStatus(this.j);
      this.f = 0;
      return true;
      label258:
      this.j = 0;
      this.f = -1;
      setStatus(this.j);
      requestLayout();
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((this.s < 0) && (paramBoolean) && (paramInt1 > 0))
    {
      localObject = getResources().getConfiguration();
      this.x = ((Configuration)localObject).orientation;
      if (VersionUtils.f())
      {
        this.y = ((Configuration)localObject).screenWidthDp;
        this.z = ((Configuration)localObject).screenHeightDp;
      }
      this.s = paramInt1;
    }
    else if (paramInt1 > this.s)
    {
      this.s = paramInt1;
    }
    float f1;
    if (getResources().getConfiguration().orientation == 2) {
      f1 = 0.3F;
    } else {
      f1 = 0.2F;
    }
    int i1 = (int)(this.s * f1);
    int i2 = this.s;
    boolean bool1;
    if ((i2 > paramInt1) && (i2 - paramInt1 > i1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (bool1 != this.k) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.l = bool2;
    this.k = bool1;
    if (QLog.isColorLevel())
    {
      i2 = this.e;
      int i3 = this.f;
      bool2 = h;
      int i4 = this.F;
      int i5 = this.j;
      int i6 = this.s;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" dHeight = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" mSoftInputChange=");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " setStatus onLayout before finalStatus = ", Integer.valueOf(paramInt2), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(i2), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(i3), " mIsMultiScreen = ", Boolean.valueOf(bool2), " mTopInset = ", Integer.valueOf(i4), " mClickStatus = ", Integer.valueOf(i5), "mNormalSize = ", Integer.valueOf(i6), " height = ", Integer.valueOf(paramInt1), ((StringBuilder)localObject).toString() });
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    int i1 = this.J;
    if ((i1 != 0) && (i1 != a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, new Object[] { "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.J), " mExternalPanelheight = ", Integer.valueOf(a) });
      }
      this.J = a;
      this.K = AnimationUtils.currentAnimationTimeMillis();
    }
    this.f = paramInt;
    a();
    if ((this.J == 0) && (!this.k) && (this.s > 0) && (getHeight() >= this.s))
    {
      if (QLog.isColorLevel()) {
        QLog.w("XPanelContainer", 2, "soft input status error, reset");
      }
      d();
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showExternalPanel mAnimationPosition= ");
      ((StringBuilder)localObject).append(this.J);
      ((StringBuilder)localObject).append("mExternalPanelheight=");
      ((StringBuilder)localObject).append(a);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    if (this.J > 0) {
      return;
    }
    this.f = paramInt;
    URLDrawable.pause();
    ApngImage.pauseByTag(0);
    this.C = paramBoolean;
    if ((q) && (paramBoolean))
    {
      this.A = true;
      paramInt = getHeight();
      localObject = ValueAnimator.ofInt(new int[] { paramInt, paramInt - a });
      ((ValueAnimator)localObject).setDuration(150L);
      ((ValueAnimator)localObject).addUpdateListener(new XPanelContainer.3(this, paramInt));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.J = a;
    this.K = AnimationUtils.currentAnimationTimeMillis();
    requestLayout();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = this.o;
    if (localObject1 != null)
    {
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (IKeyboardHiddenCallback)((Iterator)localObject2).next();
        if (!((IKeyboardHiddenCallback)localObject1).a(paramBoolean))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("don't hide keyboard, it intercepted by ");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("XPanelContainer", 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
      }
    }
    a();
  }
  
  private void c(boolean paramBoolean)
  {
    XPanelContainer.ReadyToShowChangeListener localReadyToShowChangeListener = this.H;
    if (localReadyToShowChangeListener != null) {
      localReadyToShowChangeListener.a(paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel mannule layout  =  softInputShowing ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(" changed = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean2) && (paramBoolean1))
    {
      requestLayout();
      return;
    }
    n();
    int i1;
    if ((q) && (this.C))
    {
      if (this.A) {
        i1 = this.J;
      } else {
        i1 = a;
      }
    }
    else
    {
      if (!this.C) {
        this.C = true;
      }
      i1 = a - this.J;
    }
    Object localObject = this.v;
    if (localObject == null)
    {
      QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
      setStatus(0);
      this.f = -1;
      requestLayout();
      return;
    }
    int i2;
    if ((localObject instanceof BaseVoicetoTextView))
    {
      localObject = (BaseVoicetoTextView)localObject;
      i2 = paramInt4 - i1;
      ((BaseVoicetoTextView)localObject).a(paramInt1, i2, paramInt3, i2 + a, paramBoolean2);
    }
    else
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(a, 1073741824));
      localObject = this.v;
      i2 = paramInt4 - i1;
      ((View)localObject).layout(paramInt1, i2, paramInt3, a + i2);
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel mannule layout calcposition d= ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.J);
      ((StringBuilder)localObject).append("isOpenAnim=");
      ((StringBuilder)localObject).append(this.A);
      ((StringBuilder)localObject).append("mExternalPanelheight=");
      ((StringBuilder)localObject).append(a);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - i1, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - i1);
    if ((!this.A) && ((this.J == 0) || (this.f > 1)))
    {
      setStatus(this.f);
      this.f = -1;
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim ");
        paramView.append(this.A);
        paramView.append(" mAnimationPosition = ");
        paramView.append(this.J);
        QLog.d("Q.aio.XPanelContainer", 4, paramView.toString());
      }
    }
    else
    {
      if (q) {
        return;
      }
      postDelayed(this, 1L);
    }
  }
  
  private boolean c(int paramInt)
  {
    if (h)
    {
      Object localObject1;
      if (paramInt == 1)
      {
        if (this.t.requestFocusFromTouch())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
        }
        BaseAIOUtils.c(this.t);
        localObject1 = this.v;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      else if (paramInt > 1)
      {
        a();
        if (this.e == 1) {
          this.e = 0;
        }
        Object localObject2 = (View)this.w.get(paramInt);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.u.c(paramInt))
          {
            this.w.remove(paramInt);
            removeView((View)localObject2);
            localObject1 = null;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          try
          {
            localObject2 = this.u.b(paramInt);
          }
          catch (Exception localException)
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("XPanelContainer", 2, localException, new Object[0]);
              localObject2 = localObject1;
            }
          }
          if (localObject2 == null) {
            return true;
          }
          addView((View)localObject2);
          this.w.put(paramInt, localObject2);
        }
        localObject1 = this.v;
        if (localObject2 != localObject1)
        {
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          ((View)localObject2).setVisibility(0);
          this.v = ((View)localObject2);
        }
      }
      else
      {
        b();
      }
      requestLayout();
      return true;
    }
    return false;
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    int i1;
    if (QLog.isDevelopLevel())
    {
      localObject = this.v;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = ((View)localObject).getVisibility();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel ,confirm it mExternalPanelheight= ");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(" bottom = ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("  mCurPanel.getVisibility() ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.v;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      if (QLog.isDevelopLevel())
      {
        localObject = this.v.getParent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onLayout bom panel ,confirm it vp.ViewParent = ");
        localStringBuilder.append(localObject.getClass().getName());
        QLog.d("Q.aio.XPanelContainer", 4, localStringBuilder.toString());
      }
      i1 = paramInt3 - paramInt1;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - a, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - a);
      paramView = this.v;
      if (!(paramView instanceof BaseVoicetoTextView))
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(a, 1073741824));
        this.v.layout(paramInt1, paramInt4 - a, paramInt3, paramInt4);
        return false;
      }
      ((BaseVoicetoTextView)paramView).a(paramInt1, paramInt4 - a, paramInt3, paramInt4, paramBoolean);
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
    }
    setStatus(0);
    this.f = -1;
    requestLayout();
    return true;
  }
  
  public static int getDefaultExternalPanelHeighy()
  {
    return 196;
  }
  
  private static int getExternalPanelInitHeight()
  {
    int i1 = p;
    if (i1 > 0) {
      return i1;
    }
    return ViewUtils.dip2px(196.0F);
  }
  
  private int getPanelHeight()
  {
    View localView = this.v;
    if ((localView != null) && ((localView instanceof ResetPanelInterface))) {
      return ((ResetPanelInterface)localView).getDefaultExternalPanelheight();
    }
    return b;
  }
  
  public static int getSpaceHeight()
  {
    return a - ViewUtils.dip2px(103.0F);
  }
  
  private boolean h()
  {
    boolean bool2 = i();
    boolean bool1 = true;
    if (bool2)
    {
      if (this.e <= 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean i()
  {
    return (DeviceInfoUtil.V()) && (Build.VERSION.SDK_INT >= 30);
  }
  
  private void j()
  {
    if ((getContext() instanceof AppActivity))
    {
      int i1 = ((Activity)getContext()).getWindow().getAttributes().softInputMode;
      if ((i1 & 0xFF) != 18)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("illegal soft input mode: ");
        localStringBuilder.append(i1);
        QLog.e("XPanelContainer", 1, localStringBuilder.toString());
        k();
        ((Activity)getContext()).getWindow().setSoftInputMode(i1 & 0xFFFFFF00 | 0x12);
        requestLayout();
      }
    }
  }
  
  private void k()
  {
    postDelayed(new XPanelContainer.5(this), 200L);
  }
  
  private void l()
  {
    boolean bool;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (h)
      {
        long l1 = System.currentTimeMillis();
        if ((getContext() instanceof Activity))
        {
          bool = ((Activity)getContext()).isInMultiWindowMode();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("targetSdk > 24 tmpIsMultiScreen= ");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(",calltime = ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
          QLog.d("XPanelContainer", 1, ((StringBuilder)localObject).toString());
          if (h != bool)
          {
            this.E = true;
            h = bool;
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 21) && (getSystemUiVisibility() == 0) && (m()))
    {
      if (getParent() != null)
      {
        localObject = (View)getParent();
        if (((View)localObject).getParent() != null) {
          this.F = ((IFitSystemWindowsUtil)QRoute.api(IFitSystemWindowsUtil.class)).getTopInset((View)((View)localObject).getParent());
        }
      }
      if (this.F < this.D - 5) {
        bool = true;
      } else {
        bool = false;
      }
      if (h != bool)
      {
        this.E = true;
        h = bool;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tmpIsMultiScreen= ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", mTopInset ");
      ((StringBuilder)localObject).append(this.F);
      ((StringBuilder)localObject).append(", default top ");
      ((StringBuilder)localObject).append(this.D);
      ((StringBuilder)localObject).append(",mIsNeedHandleMultiScreenSdkBelow24 ");
      ((StringBuilder)localObject).append(this.I);
      ((StringBuilder)localObject).append(",mIsMultiChange");
      ((StringBuilder)localObject).append(this.E);
      QLog.d("XPanelContainer", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean m()
  {
    return this.I;
  }
  
  @TargetApi(11)
  private void n()
  {
    if ((q) && (this.C))
    {
      if (this.A)
      {
        if (this.J >= a)
        {
          this.J = 0;
          this.A = false;
        }
        return;
      }
      if (this.B) {
        if (this.J <= 0)
        {
          this.J = 0;
          this.B = false;
        }
      }
    }
    else
    {
      if (AnimationUtils.currentAnimationTimeMillis() >= this.K + 0L)
      {
        this.J = 0;
        return;
      }
      float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.K) / 0.0F;
      this.J = ((int)(a - AnimateUtils.a(f1) * a));
    }
  }
  
  private void o()
  {
    int i1 = p;
    if (i1 > 0)
    {
      BaseSharedPreUtil.a(BaseApplication.getContext(), "", true, "sp_key_input_height", Integer.valueOf(i1));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveInputMethodPanelHeight.height = ");
        localStringBuilder.append(i1);
        QLog.i("XPanelContainer", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void p()
  {
    if (p == 0) {
      p = ((Integer)BaseSharedPreUtil.a(getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initInputMethodPanelHeight.height = ");
      localStringBuilder.append(p);
      QLog.i("XPanelContainer", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout reget =  mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.J);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    n();
    Object localObject = this.v;
    if (localObject == null)
    {
      QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
      setStatus(0);
      this.f = -1;
      requestLayout();
      return;
    }
    int i1;
    if ((localObject instanceof BaseVoicetoTextView))
    {
      localObject = (BaseVoicetoTextView)localObject;
      i1 = this.J;
      ((BaseVoicetoTextView)localObject).a(paramInt1, paramInt4 - i1, paramInt3, paramInt4 - i1 + a, paramBoolean);
    }
    else
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(a, 1073741824));
      localObject = this.v;
      i1 = this.J;
      ((View)localObject).layout(paramInt1, paramInt4 - i1, paramInt3, paramInt4 - i1 + a);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - this.J, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - this.J);
    if (this.J == 0)
    {
      setStatus(this.f);
      this.f = -1;
      return;
    }
    if (q) {
      return;
    }
    postDelayed(this, 1L);
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" showExternalPanel panelId = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" mStatus = ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" ready = ");
      ((StringBuilder)localObject1).append(this.G);
      QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.G) {
      return;
    }
    this.j = paramInt;
    a(this.e, paramInt);
    if (c(paramInt)) {
      return;
    }
    if (paramInt == 1)
    {
      BaseAIOUtils.c(this.t);
      return;
    }
    if (paramInt > 1)
    {
      this.g = false;
      Object localObject2 = (View)this.w.get(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (this.u.c(paramInt))
        {
          this.w.remove(paramInt);
          removeView((View)localObject2);
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        try
        {
          localObject2 = this.u.b(paramInt);
        }
        catch (Exception localException)
        {
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("XPanelContainer", 2, localException, new Object[0]);
            localObject2 = localObject1;
          }
        }
        if (localObject2 == null) {
          return;
        }
        addView((View)localObject2);
        this.w.put(paramInt, localObject2);
      }
      localObject1 = this.v;
      if (localObject2 != localObject1)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        ((View)localObject2).setVisibility(0);
        this.v = ((View)localObject2);
      }
      int i1 = this.e;
      if (i1 == 0)
      {
        b(paramInt, paramBoolean);
        return;
      }
      if (i1 == 1)
      {
        b(paramInt);
        return;
      }
      if (i1 != paramInt) {
        setStatus(paramInt);
      }
      return;
    }
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(View paramView)
  {
    a(paramView, true);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.t = paramView;
    if (paramView.getOnFocusChangeListener() == null) {
      paramView.setOnFocusChangeListener(new XPanelContainer.2(this));
    }
    if ((paramBoolean) && (paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView.getParent();
      paramView.setDescendantFocusability(131072);
      paramView.setFocusableInTouchMode(true);
    }
  }
  
  public void a(IKeyboardHiddenCallback paramIKeyboardHiddenCallback)
  {
    if (this.o == null) {
      this.o = new ArrayList();
    }
    this.o.add(paramIKeyboardHiddenCallback);
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  protected boolean a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    if ((!paramBoolean2) && (this.e != 1) && (this.r == 0))
    {
      this.r = paramInt4;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init mDefaultBottom: ");
      localStringBuilder.append(paramInt4);
      QLog.i("XPanelContainer", 1, localStringBuilder.toString());
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (d != 0) {
        e();
      }
      d = 0;
      b = (int)(getDefaultExternalPanelHeighy() * getContext().getResources().getDisplayMetrics().density);
      a = getPanelHeight();
    }
    if ((paramBoolean2) && (this.e != 1))
    {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return false;
    }
    if ((this.f > 1) && ((!paramBoolean2) || (paramBoolean1)))
    {
      c(paramBoolean1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return true;
    }
    if ((this.f == 0) && (this.e > 1))
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return true;
    }
    if ((this.e > 1) && (!paramBoolean2))
    {
      if (c(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView)) {
        return true;
      }
    }
    else {
      b(paramBoolean1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    XPanelContainer.PanelCallback localPanelCallback = this.u;
    if (localPanelCallback != null) {
      localPanelCallback.v();
    }
    boolean bool;
    if (this.e > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (h)
    {
      if (this.e == 1) {
        b(paramBoolean2);
      }
      this.j = 0;
      requestLayout();
      return bool;
    }
    int i1 = this.e;
    if (i1 == 1) {
      try
      {
        b(paramBoolean2);
        return bool;
      }
      catch (Exception localException)
      {
        QLog.e("XPanelContainer", 1, localException, new Object[0]);
        return bool;
      }
    }
    if (i1 > 1)
    {
      Object localObject;
      if (this.J > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("  hideAllPanel return  mAnimationPosition = ");
          ((StringBuilder)localObject).append(this.J);
          QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      this.j = 0;
      this.f = 0;
      if (paramBoolean1) {
        i1 = a;
      } else {
        i1 = 0;
      }
      this.J = i1;
      this.K = AnimationUtils.currentAnimationTimeMillis();
      if ((q) && (paramBoolean1))
      {
        this.B = true;
        i1 = getHeight();
        localObject = ValueAnimator.ofInt(new int[] { i1 - a, i1 });
        ((ValueAnimator)localObject).setDuration(150L);
        ((ValueAnimator)localObject).addUpdateListener(new XPanelContainer.4(this, i1));
        ((ValueAnimator)localObject).start();
        return bool;
      }
      requestLayout();
    }
    return bool;
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    View localView = this.v;
    if ((localView instanceof BaseVoicetoTextView))
    {
      ((BaseVoicetoTextView)localView).a(true);
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - a, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - a);
      ((BaseVoicetoTextView)this.v).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
    else
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    paramInt1 = this.r - paramInt4;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(a), " mDefaultExternalPanelheight = ", Integer.valueOf(b), " mAddedHeight = ", Integer.valueOf(d) });
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      b = (int)(getDefaultExternalPanelHeighy() * getContext().getResources().getDisplayMetrics().density);
      if (a != paramInt1)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append(" mExternalPanelheight=");
          paramView.append(a);
          paramView.append(" inputHeight=");
          paramView.append(paramInt1);
          paramView.append(" mDefaultExternalPanelheight=");
          paramView.append(b);
          paramView.append(" mMAXHExternalPanelheight=");
          paramView.append(c);
          paramView.append(" mAnimationPosition=");
          paramView.append(this.J);
          paramView.append(" mDefaultBottom=");
          paramView.append(this.r);
          QLog.d("Q.aio.XPanelContainer", 2, paramView.toString());
        }
        if (this.J == 0)
        {
          paramInt2 = b;
          if (paramInt1 > paramInt2)
          {
            paramInt3 = c;
            if (paramInt1 > paramInt3)
            {
              if (paramInt3 > paramInt2) {
                a = paramInt3;
              } else {
                a = paramInt2;
              }
            }
            else
            {
              a = paramInt1;
              p = paramInt1;
              o();
            }
          }
          else
          {
            a = paramInt2;
            if (paramInt1 < paramInt2 / 2)
            {
              this.r = 0;
              QLog.i("XPanelContainer", 1, "reset mDefaultBottom");
            }
          }
          d = a - b;
        }
        e();
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("mExternalPanelheight=");
          paramView.append(a);
          paramView.append("mAddedHeight=");
          paramView.append(d);
          QLog.d("XPanelContainer", 2, paramView.toString());
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
    }
    if ((this.v instanceof BaseVoicetoTextView))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - a, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - a);
      ((BaseVoicetoTextView)this.v).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2);
      return;
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @TargetApi(11)
  public boolean b()
  {
    return a(true);
  }
  
  @TargetApi(11)
  public boolean c()
  {
    return a(true, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
    }
    this.f = -1;
    setStatus(0);
    this.g = true;
    this.A = false;
    this.B = false;
    this.J = 0;
    requestLayout();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
    }
    if ((this.v instanceof BaseVoicetoTextView)) {
      return;
    }
    int i1 = 0;
    try
    {
      while (i1 < this.w.size())
      {
        View localView = (View)this.w.get(this.w.keyAt(i1));
        if (localView.getParent() != null) {
          removeView(localView);
        }
        i1 += 1;
      }
    }
    catch (Exception localException)
    {
      label77:
      break label77;
    }
    this.w.clear();
    this.v = null;
    EmoticonPanelViewBinder.destroyViewPool();
  }
  
  public void f()
  {
    if (h)
    {
      Object localObject = this.u;
      this.e = 1;
      this.j = 1;
      this.f = 0;
      localObject = this.v;
      if (localObject != null)
      {
        if (((View)localObject).getVisibility() == 0)
        {
          this.v.setVisibility(8);
          this.v = null;
          return;
        }
        this.v = null;
      }
    }
  }
  
  public boolean g()
  {
    return this.G;
  }
  
  public int getCurrentPanel()
  {
    return this.e;
  }
  
  public View getCurrentPanelView()
  {
    return this.v;
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.f())
    {
      if ((paramConfiguration.orientation != this.x) && ((this.y != paramConfiguration.screenWidthDp) || (this.z != paramConfiguration.screenHeightDp)))
      {
        this.x = -1;
        this.z = -1;
        this.z = -1;
        this.s = -1;
        b();
      }
    }
    else if (paramConfiguration.orientation != this.x)
    {
      this.x = -1;
      this.s = -1;
      b();
    }
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  changed = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("top=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("bottom=");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.J);
      QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
    j();
    int i4 = getPaddingRight();
    int i1 = getPaddingLeft();
    int i3 = getPaddingBottom();
    int i2 = getPaddingTop();
    l();
    if (a(paramInt1, paramInt2, paramInt3, paramInt4)) {
      return;
    }
    paramInt4 -= paramInt2;
    paramInt2 = this.e;
    boolean bool1 = a(paramBoolean, paramInt4, paramInt2);
    paramInt1 = paramInt3 - paramInt1 - i4;
    paramInt3 = paramInt4 - i3;
    Object localObject = getChildAt(0);
    try
    {
      if (a(i1, i2, paramInt1, paramInt3, (View)localObject)) {
        return;
      }
      boolean bool2 = a(paramBoolean, i1, i2, paramInt1, paramInt3, bool1, (View)localObject);
      if (bool2) {
        return;
      }
      if ((paramBoolean) && (bool1))
      {
        this.f = -1;
        paramInt1 = 1;
      }
      else if (this.f != 0)
      {
        paramInt1 = paramInt2;
        if (h())
        {
          paramInt1 = paramInt2;
          if (paramBoolean)
          {
            paramInt1 = paramInt2;
            if (bool1) {}
          }
        }
      }
      else
      {
        if (paramBoolean)
        {
          paramInt1 = paramInt2;
          if (paramInt2 == 28) {
            break label297;
          }
          if (paramInt2 == 35)
          {
            paramInt1 = paramInt2;
            break label297;
          }
        }
        paramInt1 = 0;
        label297:
        this.f = -1;
      }
      setStatus(paramInt1);
      this.j = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(this.e), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.f) });
      }
      localObject = this.v;
      if ((localObject instanceof BaseVoicetoTextView)) {
        ((BaseVoicetoTextView)localObject).a();
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("main.getContext: ");
      localStringBuilder.append(((View)localObject).getContext());
      localStringBuilder.append(" \n ");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(" crash happen restore init status");
      QLog.e("Q.aio.XPanelContainer", 1, localStringBuilder.toString(), localException);
      localObject = this.v;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      setStatus(0);
      this.f = -1;
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setIsInMultiScreen(boolean paramBoolean)
  {
    if (h != paramBoolean)
    {
      this.E = true;
      h = paramBoolean;
    }
  }
  
  public void setIsNeedHandleMultiScreenSdkBelow24(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setOnChangeMultiScreenListener(XPanelContainer.OnChangeMultiScreenListener paramOnChangeMultiScreenListener)
  {
    this.m = paramOnChangeMultiScreenListener;
  }
  
  public void setOnGoingToShowPanelListener(XPanelContainer.OnGoingToShowPanelListener paramOnGoingToShowPanelListener)
  {
    this.n = new WeakReference(paramOnGoingToShowPanelListener);
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.u = paramPanelCallback;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReadyToShow() called with: readyToShow = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d("XPanelContainer", 2, localStringBuilder.toString());
    }
    if (this.G != paramBoolean)
    {
      this.G = paramBoolean;
      c(paramBoolean);
    }
  }
  
  public void setReadyToShowChangeListener(XPanelContainer.ReadyToShowChangeListener paramReadyToShowChangeListener)
  {
    this.H = paramReadyToShowChangeListener;
  }
  
  protected void setStatus(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatus status=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mStatus=");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" mSoftInputChange=");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(" mSoftInputShowing=");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("XPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = this.e;
    if (paramInt != i1)
    {
      this.e = paramInt;
      localObject = this.u;
      if (localObject != null) {
        ((XPanelContainer.PanelCallback)localObject).a(i1, this.e);
      }
      URLDrawable.resume();
      ApngImage.playByTag(0);
      localObject = this.v;
      if ((localObject != null) && (paramInt <= 1) && ((!(localObject instanceof BaseVoicetoTextView)) || (paramInt != 1)))
      {
        if ((this.l) && (!this.k))
        {
          if ((this.v instanceof BaseVoicetoTextView)) {
            this.e = 36;
          }
          return;
        }
        if (this.v.getVisibility() == 0)
        {
          this.v.setVisibility(8);
          this.v = null;
          postDelayed(this, 1L);
          return;
        }
        this.v = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */