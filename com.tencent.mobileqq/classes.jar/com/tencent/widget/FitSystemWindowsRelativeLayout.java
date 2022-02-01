package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;

public class FitSystemWindowsRelativeLayout
  extends RelativeLayout
  implements Handler.Callback
{
  DiniFlyAnimationView a = null;
  HeartCombolEffectView b = null;
  ZanCombolEffectView c = null;
  GreatMoveCombolEffectView d = null;
  HeartBreakCombolEffectView e = null;
  SixCombolEffectView f = null;
  View g = new View(getContext());
  View.OnTouchListener h = new FitSystemWindowsRelativeLayout.1(this);
  boolean i;
  private int[] j = new int[4];
  private FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener k;
  private FitSystemWindowsRelativeLayout.DispatchTouchEventListener l;
  
  public FitSystemWindowsRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(11)
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView)
  {
    boolean bool = paramView instanceof ViewGroup;
    int m = 0;
    if (bool) {
      while (m < getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(m));
        m += 1;
      }
    }
    if ((paramView instanceof ImageView))
    {
      Object localObject2 = ((ImageView)paramView).getDrawable();
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = null;
      if ((localObject2 instanceof DrawableContainer))
      {
        localObject2 = ((Drawable)localObject2).getCurrent();
        if ((localObject2 instanceof BitmapDrawable)) {
          localObject1 = ((BitmapDrawable)localObject2).getBitmap();
        }
      }
      else if ((localObject2 instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      if (localObject1 == null) {
        return;
      }
      if (((Bitmap)localObject1).isRecycled())
      {
        localObject1 = new StringBuilder("catch bitmap recycled:");
        localObject2 = a(paramView, 0);
        if (localObject2[0] != 0)
        {
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(paramView.getResources().getResourceEntryName(localObject2[0]));
          ((StringBuilder)localObject1).append(" id = ");
          ((StringBuilder)localObject1).append(localObject2[0]);
          ((StringBuilder)localObject1).append(" level = ");
          ((StringBuilder)localObject1).append(localObject2[1]);
          ((StringBuilder)localObject1).append(" isRecycled");
          paramView = new StringBuilder();
          paramView.append("BITMAP_RECYCLED ");
          paramView.append(localObject1);
          CaughtExceptionReport.a(new Throwable(paramView.toString()));
          QLog.d("placeholder", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  private int[] a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return new int[] { 0, paramInt };
    }
    if (paramInt >= 3) {
      return new int[] { 0, paramInt };
    }
    if ((paramView.getId() != 0) && (paramView.getId() != -1)) {
      return new int[] { paramView.getId(), paramInt };
    }
    return a((View)paramView.getParent(), paramInt + 1);
  }
  
  private QQAppInterface getQQAppInterface()
  {
    Object localObject = getContext();
    if ((localObject instanceof BaseActivity)) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseActivity.sTopActivity;
    if (localObject != null) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      return (QQAppInterface)localObject;
    }
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (RuntimeException paramCanvas)
    {
      try
      {
        a(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("placeholder", 1, localThrowable, new Object[0]);
      }
      throw paramCanvas;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = false;
    Object localObject = this.l;
    if (localObject != null) {
      bool = ((FitSystemWindowsRelativeLayout.DispatchTouchEventListener)localObject).a(paramMotionEvent);
    }
    if (bool) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.j[0] = paramRect.left;
      this.j[1] = paramRect.top;
      this.j[2] = paramRect.right;
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = 0;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public GreatMoveCombolEffectView getGreatMoveCombolEffectView()
  {
    if (this.d == null)
    {
      this.d = new GreatMoveCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.d, localLayoutParams);
    }
    return this.d;
  }
  
  public final int[] getInsets()
  {
    return this.j;
  }
  
  public SixCombolEffectView getSixCombolEffectView()
  {
    if (this.f == null)
    {
      this.f = new SixCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = ScreenUtil.dip2px(50.0F);
      localLayoutParams.addRule(8, 2131437281);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131430542);
      localViewGroup.removeView(this.f);
      localViewGroup.addView(this.f, localLayoutParams);
    }
    return this.f;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    case 8: 
    case 11: 
    default: 
      return false;
    case 21: 
      clearAnimation();
      return false;
    case 20: 
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "HIDE_PLACEHOLDER");
      }
      removeView(this.g);
      return false;
    case 19: 
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "SHOW_PLACEHOLDER");
      }
      this.g.setOnTouchListener(this.h);
      removeView(this.g);
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.g, paramMessage);
      return false;
    case 18: 
      if (this.f != null)
      {
        ((ViewGroup)findViewById(2131430542)).removeView(this.f);
        this.f.c();
        this.f = null;
        return false;
      }
      break;
    case 16: 
      if (this.f == null)
      {
        this.f = new SixCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        paramMessage.addRule(8, 2131437281);
        paramMessage.topMargin = ScreenUtil.dip2px(50.0F);
        ((ViewGroup)findViewById(2131430542)).addView(this.f, paramMessage);
        return false;
      }
      break;
    case 15: 
      paramMessage = this.e;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.e.b();
        this.e = null;
        return false;
      }
      break;
    case 14: 
      paramMessage = this.e;
      if (paramMessage != null)
      {
        paramMessage.a();
        return false;
      }
      break;
    case 13: 
      if (this.e == null)
      {
        this.e = new HeartBreakCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.e, paramMessage);
        return false;
      }
      break;
    case 12: 
      paramMessage = this.d;
      if (paramMessage != null)
      {
        paramMessage.b();
        removeView(this.d);
        this.d = null;
        return false;
      }
      break;
    case 10: 
      if (this.d == null)
      {
        this.d = new GreatMoveCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.d, paramMessage);
        return false;
      }
      break;
    case 9: 
      paramMessage = this.a;
      if ((paramMessage != null) && (this.i))
      {
        this.i = false;
        removeView(paramMessage);
        this.a = null;
        return false;
      }
      break;
    case 7: 
      localObject = this.a;
      if (localObject == null)
      {
        this.a = new DiniFlyAnimationView(getContext());
        this.a.setFitFullScreenXY();
        this.a.addAnimatorListener(new FitSystemWindowsRelativeLayout.2(this));
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if (((DiniFlyAnimationView)localObject).isAnimating())
      {
        this.a.endAnimation();
      }
      if (1 == paramMessage.arg2) {
        this.a.setScaleX(1.0F);
      } else {
        this.a.setScaleX(-1.0F);
      }
      if (!this.i)
      {
        this.i = true;
        addView(this.a);
      }
      PokeItemHelper.a(getQQAppInterface(), getContext(), this.a, null, paramMessage.arg1, "fullscreen");
      return false;
    case 6: 
      paramMessage = this.c;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.c = null;
        return false;
      }
      break;
    case 5: 
      paramMessage = this.c;
      if (paramMessage != null)
      {
        paramMessage.a(new Integer[] { Integer.valueOf(2130839255), Integer.valueOf(2130839256), Integer.valueOf(2130839257), Integer.valueOf(2130839258), Integer.valueOf(2130839259), Integer.valueOf(2130839260) });
        return false;
      }
      break;
    case 4: 
      if (this.c == null)
      {
        this.c = new ZanCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        this.c.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.b(40.0F, getResources()), 0.0F, 150.0F, AIOUtils.b(100.0F, getResources()), AIOUtils.b(3.0F, getResources()), AIOUtils.b(800.0F, getResources()), getResources().getDisplayMetrics().heightPixels, PokeItemHelper.c(getQQAppInterface()));
        addView(this.c, paramMessage);
        return false;
      }
      break;
    case 3: 
      paramMessage = this.b;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.b = null;
        return false;
      }
      break;
    case 2: 
      localObject = this.b;
      if (localObject != null)
      {
        ((HeartCombolEffectView)localObject).a(((Boolean)paramMessage.obj).booleanValue());
        return false;
      }
      break;
    case 1: 
      if (this.b == null)
      {
        this.b = new HeartCombolEffectView(getContext(), PokeItemHelper.c(getQQAppInterface()));
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.b, paramMessage);
      }
      break;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener localOnInterceptTouchEventListener = this.k;
    boolean bool;
    if (localOnInterceptTouchEventListener != null) {
      bool = localOnInterceptTouchEventListener.a(paramMotionEvent);
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDispatchTouchEventListener(FitSystemWindowsRelativeLayout.DispatchTouchEventListener paramDispatchTouchEventListener)
  {
    this.l = paramDispatchTouchEventListener;
  }
  
  public void setOnInterceptTouchEventListener(FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.k = paramOnInterceptTouchEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout
 * JD-Core Version:    0.7.0.1
 */