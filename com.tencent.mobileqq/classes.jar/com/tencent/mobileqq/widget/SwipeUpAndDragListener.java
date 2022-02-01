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
  public static int a = -1;
  public static int b = 300;
  private static int jdField_g_of_type_Int = 60;
  public float a;
  public long a;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  PhotoListPanel.SwipeUpAndDragCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  SwipeUpAndDragListener.GestureHandler jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  public float b;
  SwipeUpAndDragListener.GestureHandler b;
  public AtomicBoolean b;
  public float c;
  int jdField_c_of_type_Int;
  SwipeUpAndDragListener.GestureHandler jdField_c_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
  public float d;
  int d;
  float e;
  public int e;
  float jdField_f_of_type_Float = 0.7F;
  int jdField_f_of_type_Int;
  float jdField_g_of_type_Float;
  float h;
  
  public SwipeUpAndDragListener(AIOContext paramAIOContext, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack = paramSwipeUpAndDragCallBack;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = paramPhotoListPanel;
    a(paramAIOContext, paramSwipeUpAndDragCallBack, paramPhotoListPanel);
  }
  
  public static int a()
  {
    int i = jdField_a_of_type_Int;
    if ((i != 0) && (i != 1)) {
      jdField_a_of_type_Int = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).getInt("SP_KEY_DRAG_MODE", 1);
    }
    return jdField_a_of_type_Int;
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
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ACTION_DOWN,x = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(",y = ");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    Logger.a("PhotoListPanel", "onTouch", localStringBuilder.toString());
    a(paramMotionEvent);
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_MOVE,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    ((StringBuilder)localObject).append(",mGestureHandler = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    if ((this.jdField_c_of_type_Float == f1) && (this.jdField_d_of_type_Float == f2)) {
      return false;
    }
    float f3 = this.jdField_a_of_type_Float;
    float f4 = this.jdField_b_of_type_Float;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    localObject = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(this.jdField_e_of_type_Int);
    if (localObject == null) {
      return false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = a(paramMotionEvent, f1 - f3, f2 - f4);
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
      if (paramMotionEvent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.j = false;
        return paramMotionEvent.a((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject, this.jdField_e_of_type_Int);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
      if (localObject != null) {
        return ((SwipeUpAndDragListener.GestureHandler)localObject).a(paramMotionEvent);
      }
    }
    return false;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_UP,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setMotionEventSplittingEnabled(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
    if (localObject != null)
    {
      boolean bool = ((SwipeUpAndDragListener.GestureHandler)localObject).b(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.j = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = null;
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      return bool;
    }
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) && (Math.abs(f2 - this.jdField_b_of_type_Float) > Math.abs(f1 - this.jdField_a_of_type_Float)) && ((l > 200L) || (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_d_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_d_of_type_Int)))
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append(" ACTION_UP,eat up event.dx = ");
      paramMotionEvent.append(Math.abs(f1 - this.jdField_a_of_type_Float));
      paramMotionEvent.append(",dy = ");
      paramMotionEvent.append(Math.abs(f2 - this.jdField_b_of_type_Float));
      paramMotionEvent.append(",duration = ");
      paramMotionEvent.append(l);
      Logger.a("PhotoListPanel", "onTouch", paramMotionEvent.toString());
      return true;
    }
    return false;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ACTION_CANCEL,x = ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",y = ");
    ((StringBuilder)localObject).append(f2);
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setMotionEventSplittingEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.j = true;
    ThreadManagerV2.getUIHandlerV2().post(new SwipeUpAndDragListener.1(this));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
    if (localObject != null) {
      return ((SwipeUpAndDragListener.GestureHandler)localObject).c(paramMotionEvent);
    }
    return false;
  }
  
  float a(int paramInt1, int paramInt2, int paramInt3)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = this.jdField_e_of_type_Float * 160.0F;
    }
    for (paramInt2 = Math.max(paramInt2, paramInt3);; paramInt2 = Math.max(paramInt2, paramInt3))
    {
      f1 /= paramInt2;
      break;
      if ((localLocalMediaInfo.mediaWidth <= 100) && (localLocalMediaInfo.mediaHeight <= 100))
      {
        f1 = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
        break;
      }
      f1 = this.jdField_e_of_type_Float * 135.0F;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",scale = ");
    localStringBuilder.append(f1);
    localStringBuilder.append(",mediaType = ");
    localStringBuilder.append(i);
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
    if (-paramFloat2 > this.jdField_d_of_type_Int) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i;
    float f1;
    boolean bool2;
    boolean bool3;
    float f2;
    boolean bool4;
    boolean bool5;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      i = paramMotionEvent.findPointerIndex(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Xvelocity=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i));
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
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))));
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler);
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mActivePointerId x = ");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(",mActivePointerId y = ");
      localStringBuilder.append(paramMotionEvent.getY());
      Logger.a("PhotoListPanel", "detectGesture", localStringBuilder.toString());
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler == null) && (bool3) && (bool4) && (bool1) && (bool5))
      {
        Logger.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.jdField_c_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
      }
    }
    else
    {
      i = paramMotionEvent.findPointerIndex(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
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
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l;
      boolean bool6 = true;
      bool1 = bool6;
      if (j != 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0) {
          bool1 = bool6;
        } else {
          bool1 = false;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("2 Xvelocity=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i));
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
      localStringBuilder.append(Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))));
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler == null) && (bool3) && (bool4) && (bool1) && (bool2) && (bool5))
      {
        Logger.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
        return this.jdField_b_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
      }
    }
    return null;
  }
  
  void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
    if (localObject != null)
    {
      ((SwipeUpAndDragListener.GestureHandler)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = null;
    }
    localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findChildViewUnder(f1, f2);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition((View)localObject);
    localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_f_of_type_Int = paramMotionEvent.getPointerId(0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" touchFirstActtion,mActivePointerId x = ");
    ((StringBuilder)localObject).append(paramMotionEvent.getX());
    ((StringBuilder)localObject).append(",mActivePointerId y = ");
    ((StringBuilder)localObject).append(paramMotionEvent.getY());
    Logger.a("PhotoListPanel", "onTouch", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    ThreadManager.getUIHandler().postDelayed(new SwipeUpAndDragListener.2(this), 50L);
  }
  
  public void a(AIOContext paramAIOContext, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    paramSwipeUpAndDragCallBack = this.jdField_a_of_type_ArrayOfInt;
    paramSwipeUpAndDragCallBack[0] += this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getWidth();
    paramAIOContext = paramAIOContext.a().a().a();
    paramSwipeUpAndDragCallBack = this.jdField_a_of_type_ArrayOfInt;
    paramSwipeUpAndDragCallBack[1] -= paramAIOContext.a() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getHeight();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b();
    this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()).getScaledTouchSlop();
    paramAIOContext = new StringBuilder();
    paramAIOContext.append("SwipeUpAndDragListener.mTouchSlop = ");
    paramAIOContext.append(this.jdField_d_of_type_Int);
    Logger.a("PhotoListPanel", "detectGesture", paramAIOContext.toString());
    g = (int)(this.jdField_e_of_type_Float * 30.0F);
    this.jdField_b_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = new SwipeUpAndDragListener.FlingHandler(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    this.jdField_c_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler = new SwipeUpAndDragListener.DragHandler(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
  }
  
  public void b()
  {
    SwipeUpAndDragListener.GestureHandler localGestureHandler = this.jdField_c_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
    if ((localGestureHandler != null) && (localGestureHandler.a()))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.b();
      return;
    }
    localGestureHandler = this.jdField_b_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler;
    if ((localGestureHandler != null) && (localGestureHandler.a())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.b();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
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
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean);
    Logger.a("PhotoListPanel", "onTouch", paramView.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      return true;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          return d(paramMotionEvent);
        }
        return b(paramMotionEvent);
      }
      return c(paramMotionEvent);
    }
    return a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener
 * JD-Core Version:    0.7.0.1
 */