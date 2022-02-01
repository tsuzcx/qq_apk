package com.tencent.mobileqq.widget;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class SwipeUpAndDragListener
  implements View.OnTouchListener
{
  private static int A = 60;
  public static int a = -1;
  public static int b = 300;
  SwipeUpAndDragListener.GestureHandler c;
  SwipeUpAndDragListener.GestureHandler d;
  SwipeUpAndDragListener.GestureHandler e;
  public boolean f;
  int[] g;
  int h;
  PhotoListPanel i;
  public float j;
  public float k;
  public float l;
  public float m;
  AtomicBoolean n = new AtomicBoolean(false);
  public AtomicBoolean o = new AtomicBoolean(false);
  public long p;
  int q;
  public int r;
  int s;
  VelocityTracker t;
  float u;
  float v = 0.7F;
  PhotoListPanel.SwipeUpAndDragCallBack w;
  float x;
  float y;
  AIOContext z;
  
  public SwipeUpAndDragListener(AIOContext paramAIOContext, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.z = paramAIOContext;
    this.w = paramSwipeUpAndDragCallBack;
    this.i = paramPhotoListPanel;
    a(paramAIOContext, paramSwipeUpAndDragCallBack, paramPhotoListPanel);
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).edit();
      localEditor.putInt("SP_KEY_DRAG_MODE", paramInt);
      localEditor.commit();
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    this.j = paramMotionEvent.getX();
    this.k = paramMotionEvent.getY();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ACTION_DOWN,x = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",y = ");
    localStringBuilder.append(this.k);
    Logger.a("PhotoListPanel", "onTouch", localStringBuilder.toString());
    a(paramMotionEvent);
    return false;
  }
  
  public static int c()
  {
    int i1 = a;
    if ((i1 != 0) && (i1 != 1)) {
      a = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).getInt("SP_KEY_DRAG_MODE", 1);
    }
    return a;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_MOVE,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    ((StringBuilder)localObject).append(",mGestureHandler = ");
    ((StringBuilder)localObject).append(this.c);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    if ((this.l == f1) && (this.m == f2)) {
      return false;
    }
    float f3 = this.j;
    float f4 = this.k;
    if (this.t == null) {
      this.t = VelocityTracker.obtain();
    }
    localObject = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.i.F.findViewHolderForAdapterPosition(this.r);
    if (localObject == null) {
      return false;
    }
    if (!this.f)
    {
      this.c = a(paramMotionEvent, f1 - f3, f2 - f4);
      paramMotionEvent = this.c;
      if (paramMotionEvent != null)
      {
        this.i.H = false;
        return paramMotionEvent.a((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject, this.r);
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        return ((SwipeUpAndDragListener.GestureHandler)localObject).a(paramMotionEvent);
      }
    }
    return false;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_UP,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.z.r().setMotionEventSplittingEnabled(true);
    localObject = this.c;
    if (localObject != null)
    {
      boolean bool = ((SwipeUpAndDragListener.GestureHandler)localObject).b(paramMotionEvent);
      this.i.H = true;
      this.c = null;
      paramMotionEvent = this.t;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.t = null;
      }
      return bool;
    }
    long l1 = SystemClock.elapsedRealtime() - this.p;
    paramMotionEvent = this.t;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.t = null;
    }
    if (((this.i.ao == 1) || (this.i.ao == 0)) && (Math.abs(f2 - this.k) > Math.abs(f1 - this.j)) && ((l1 > 200L) || (Math.abs(f2 - this.k) > this.q) || (Math.abs(f1 - this.j) > this.q)))
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append(" ACTION_UP,eat up event.dx = ");
      paramMotionEvent.append(Math.abs(f1 - this.j));
      paramMotionEvent.append(",dy = ");
      paramMotionEvent.append(Math.abs(f2 - this.k));
      paramMotionEvent.append(",duration = ");
      paramMotionEvent.append(l1);
      Logger.a("PhotoListPanel", "onTouch", paramMotionEvent.toString());
      return true;
    }
    return false;
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_CANCEL,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.z.r().setMotionEventSplittingEnabled(true);
    this.i.H = true;
    ThreadManagerV2.getUIHandlerV2().post(new SwipeUpAndDragListener.1(this));
    localObject = this.c;
    if (localObject != null) {
      return ((SwipeUpAndDragListener.GestureHandler)localObject).c(paramMotionEvent);
    }
    return false;
  }
  
  float a(int paramInt1, int paramInt2, int paramInt3)
  {
    LocalMediaInfo localLocalMediaInfo = this.i.f.a(paramInt1);
    int i1 = this.i.f.getItemViewType(paramInt1);
    float f1;
    if (i1 == 1) {
      f1 = this.u * 160.0F;
    }
    for (paramInt2 = Math.max(paramInt2, paramInt3);; paramInt2 = Math.max(paramInt2, paramInt3))
    {
      f1 /= paramInt2;
      break;
      if ((localLocalMediaInfo.mediaWidth <= 100) && (localLocalMediaInfo.mediaHeight <= 100))
      {
        f1 = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.u / Math.max(paramInt2, paramInt3);
        break;
      }
      f1 = this.u * 135.0F;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",scale = ");
    localStringBuilder.append(f1);
    localStringBuilder.append(",mediaType = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(",info.mediaWidth = ");
    localStringBuilder.append(localLocalMediaInfo.mediaWidth);
    localStringBuilder.append(",info.mediaHeight = ");
    localStringBuilder.append(localLocalMediaInfo.mediaHeight);
    Logger.a("PhotoListPanel", "calcuEndScale", localStringBuilder.toString());
    return f1;
  }
  
  SwipeUpAndDragListener.GestureHandler a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    boolean bool1;
    if (-paramFloat2 > this.q) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i1;
    float f1;
    boolean bool2;
    boolean bool3;
    float f2;
    boolean bool4;
    boolean bool5;
    StringBuilder localStringBuilder;
    if (this.n.get())
    {
      i1 = paramMotionEvent.findPointerIndex(this.s);
      this.t.addMovement(paramMotionEvent);
      this.t.computeCurrentVelocity(1000);
      f1 = this.t.getYVelocity(i1);
      if (-f1 > 1500.0F) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramFloat2 < 0.0F) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      f2 = paramFloat1 / paramFloat2;
      if (Math.abs(f2) < 1.0F) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      bool5 = bool1;
      if ((this.i.ao != 1) && (this.i.ao != 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Xvelocity=");
      localStringBuilder.append(this.t.getXVelocity(i1));
      localStringBuilder.append("Yvelocity=");
      localStringBuilder.append(f1);
      localStringBuilder.append(",delX = ");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", delY = ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("tanA = ");
      localStringBuilder.append(Math.abs(f2));
      localStringBuilder.append(",Angle A = ");
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(f2))));
      localStringBuilder.append(",Velocity Angle = ");
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(this.t.getXVelocity(i1) / f1))));
      localStringBuilder.append(" vThresh = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",direction = ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(",anc = ");
      localStringBuilder.append(bool4);
      localStringBuilder.append(",satate = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",isSlop = ");
      localStringBuilder.append(bool5);
      localStringBuilder.append(",mGestureHandler = ");
      localStringBuilder.append(this.c);
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mActivePointerId x = ");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(",mActivePointerId y = ");
      localStringBuilder.append(paramMotionEvent.getY());
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      if ((this.c == null) && (bool3) && (bool4) && (bool1) && (bool5))
      {
        Logger.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.e;
      }
    }
    else
    {
      i1 = paramMotionEvent.findPointerIndex(this.s);
      this.t.addMovement(paramMotionEvent);
      this.t.computeCurrentVelocity(1000);
      f1 = this.t.getYVelocity(i1);
      if (-f1 > 6000.0F) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramFloat2 < 0.0F) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      f2 = paramFloat1 / paramFloat2;
      if (Math.abs(f2) < 1.0F) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      bool5 = bool1;
      int i2 = this.i.ao;
      boolean bool6 = true;
      bool1 = bool6;
      if (i2 != 1) {
        if (this.i.ao == 0) {
          bool1 = bool6;
        } else {
          bool1 = false;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("2 Xvelocity=");
      localStringBuilder.append(this.t.getXVelocity(i1));
      localStringBuilder.append("Yvelocity=");
      localStringBuilder.append(f1);
      localStringBuilder.append(",delX = ");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", delY = ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("tanA = ");
      localStringBuilder.append(Math.abs(f2));
      localStringBuilder.append(",Angle A = ");
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(f2))));
      localStringBuilder.append(",Velocity Angle = ");
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(this.t.getXVelocity(i1) / f1))));
      localStringBuilder.append(" vThresh = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",direction = ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(",anc = ");
      localStringBuilder.append(bool4);
      localStringBuilder.append(",satate = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",isSlop = ");
      localStringBuilder.append(bool5);
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("2 mActivePointerId x = ");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(",mActivePointerId y = ");
      localStringBuilder.append(paramMotionEvent.getY());
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      if ((this.c == null) && (bool3) && (bool4) && (bool1) && (bool2) && (bool5))
      {
        Logger.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
        return this.d;
      }
    }
    return null;
  }
  
  void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((SwipeUpAndDragListener.GestureHandler)localObject).c();
      this.c = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.t = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.p = SystemClock.elapsedRealtime();
    Object localObject = this.i.F.findChildViewUnder(f1, f2);
    this.r = this.i.F.getChildAdapterPosition((View)localObject);
    localObject = this.t;
    if (localObject == null) {
      this.t = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    this.t.addMovement(paramMotionEvent);
    this.s = paramMotionEvent.getPointerId(0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" touchFirstActtion,mActivePointerId x = ");
    ((StringBuilder)localObject).append(paramMotionEvent.getX());
    ((StringBuilder)localObject).append(",mActivePointerId y = ");
    ((StringBuilder)localObject).append(paramMotionEvent.getY());
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.c = null;
    this.f = false;
    this.n.set(false);
    ThreadManager.getUIHandler().postDelayed(new SwipeUpAndDragListener.2(this), 50L);
  }
  
  public void a(AIOContext paramAIOContext, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.g = new int[2];
    this.z.r().getLocationInWindow(this.g);
    paramSwipeUpAndDragCallBack = this.g;
    paramSwipeUpAndDragCallBack[0] += this.z.r().getWidth();
    paramAIOContext = paramAIOContext.p().d().e();
    paramSwipeUpAndDragCallBack = this.g;
    paramSwipeUpAndDragCallBack[1] -= paramAIOContext.c() + this.z.C().getHeight();
    this.h = this.z.v();
    this.u = this.z.b().getResources().getDisplayMetrics().density;
    this.q = ViewConfiguration.get(this.z.b()).getScaledTouchSlop();
    paramAIOContext = new StringBuilder();
    paramAIOContext.append("SwipeUpAndDragListener.mTouchSlop = ");
    paramAIOContext.append(this.q);
    Logger.a("PhotoListPanel", "detectGesture", paramAIOContext.toString());
    A = (int)(this.u * 30.0F);
    this.d = new SwipeUpAndDragListener.FlingHandler(this, this.z.b(), this.z.r());
    this.e = new SwipeUpAndDragListener.DragHandler(this, this.z.b(), this.z.r());
  }
  
  public void b()
  {
    SwipeUpAndDragListener.GestureHandler localGestureHandler = this.e;
    if ((localGestureHandler != null) && (localGestureHandler.d()))
    {
      this.e.c();
      return;
    }
    localGestureHandler = this.d;
    if ((localGestureHandler != null) && (localGestureHandler.d())) {
      this.d.c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramView = new StringBuilder();
    paramView.append("x = ");
    paramView.append(f1);
    paramView.append(",y = ");
    paramView.append(f2);
    paramView.append(",event = ");
    paramView.append(paramMotionEvent);
    paramView.append(", mPanel.mDisableGuestrueSend = ");
    paramView.append(this.i.e);
    Logger.a("PhotoListPanel", "onTouch", paramView.toString());
    if (this.i.e) {
      return true;
    }
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          return e(paramMotionEvent);
        }
        return c(paramMotionEvent);
      }
      return d(paramMotionEvent);
    }
    return b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener
 * JD-Core Version:    0.7.0.1
 */