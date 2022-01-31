package com.tencent.mobileqq.mini.appbrand.ui;

import amgm;
import amgo;
import amgv;
import amjh;
import amkr;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import axqy;
import baww;
import bbdh;
import bbgu;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final String TAG = "SwipeBackLayout";
  private boolean allowedSliding;
  protected boolean isInternalApp;
  private int lastX;
  private int lastY;
  private WeakReference<Activity> mActivityRef;
  private SwipeBackLayout.Callback mCallback;
  private View mCapturedView;
  protected View mChildView;
  private amgo mColorNoteCurd;
  private amjh mColorNoteStateNotice;
  private int mContentHeight;
  private int mContentWidth;
  private bbgu mDialog;
  private boolean mEnable = true;
  private boolean mFirstShow = true;
  private boolean mIsClose;
  private int mLeftMoveDistance;
  private PostTable mPostTable;
  private boolean mPostTableVisible;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private float mScrollPercent;
  private amgv mServiceInfo;
  private Drawable mShadowDrawable;
  private int mTouchSlop;
  private amkr mTouchStateDetector;
  private Vibrator mVibrator;
  private ViewDragHelper mViewDragHelper;
  private boolean mhasVibrator;
  
  public SwipeBackLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initColorNote(paramContext);
  }
  
  private void bringToBackground()
  {
    if (this.mCallback != null)
    {
      this.mCallback.onMoveAppBrandToBack();
      resetCaptureViewState();
    }
  }
  
  private void drawScrim(Canvas paramCanvas, View paramView)
  {
    int i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
    int j = this.mScrimColor;
    if (this.mViewDragHelper != null)
    {
      if (this.mViewDragHelper.getScrollDirction() != 2) {
        break label72;
      }
      paramCanvas.clipRect(0, 0, paramView.getWidth(), paramView.getTop());
    }
    for (;;)
    {
      paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
      return;
      label72:
      paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    }
  }
  
  private void drawShadow(Canvas paramCanvas, View paramView)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    this.mShadowDrawable.setBounds(localRect.left - this.mShadowDrawable.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
    this.mShadowDrawable.draw(paramCanvas);
  }
  
  private void fullDialog()
  {
    if (this.mActivityRef == null) {}
    Object localObject;
    do
    {
      return;
      if (this.mDialog != null) {
        break;
      }
      localObject = (Activity)this.mActivityRef.get();
    } while (localObject == null);
    this.mDialog = new bbgu((Context)localObject, 2131755791);
    this.mDialog.setContentView(2131558906);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setTitle(getContext().getString(2131690864));
    this.mDialog.setNegativeButton(getContext().getString(2131690863), new SwipeBackLayout.5(this, (Activity)localObject));
    for (;;)
    {
      this.mDialog.show();
      localObject = this.mDialog.getTitleTextView();
      ((View)localObject).setClickable(true);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
      baww.a((View)localObject, true);
      return;
      if (this.mDialog.isShowing()) {
        this.mDialog.dismiss();
      }
    }
  }
  
  private ColorNote generateColorNote()
  {
    if (this.mServiceInfo != null) {
      return this.mServiceInfo.getColorNote();
    }
    return null;
  }
  
  private void initColorNote(Context paramContext)
  {
    ThreadManager.getUIHandler().post(new SwipeBackLayout.2(this, paramContext));
  }
  
  private void setColorNoteStateNotice()
  {
    if (this.mColorNoteStateNotice == null)
    {
      this.mColorNoteCurd = new amgo();
      this.mColorNoteCurd.a(new SwipeBackLayout.3(this));
      this.mColorNoteStateNotice = new amjh();
      this.mColorNoteStateNotice.a(this.mColorNoteCurd);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.mScrimOpacity = (1.0F - this.mScrollPercent);
    if ((this.mViewDragHelper != null) && (this.mViewDragHelper.continueSettling(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((paramView == this.mChildView) && (this.mViewDragHelper.getViewDragState() != 0)) {}
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() == 1)
    {
      this.mChildView = getChildAt(0);
      return;
    }
    throw new IllegalStateException("SwipeBackLayout can host only one direct child");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!this.mEnable) {
      return false;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      this.lastX = i;
      this.lastY = j;
      if (!bool1) {
        break;
      }
      if (this.mViewDragHelper == null) {
        break label170;
      }
      return this.mViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
      if (Math.abs(i) < bbdh.a() * 30.0F) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.allowedSliding = bool1;
        break;
      }
      int k = this.lastX;
      int m = this.lastY;
      if (Math.abs(i - k) <= Math.abs(j - m))
      {
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
    label170:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mContentWidth = this.mChildView.getMeasuredWidth();
    this.mContentHeight = this.mChildView.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    if ((this.mColorNoteCurd == null) || (!this.mColorNoteCurd.b()))
    {
      QLog.e("SwipeBackLayout", 2, "SwipeBackLayout, color note not ready. mColorNoteCurd: " + this.mColorNoteCurd);
      return false;
    }
    double d = this.mTouchStateDetector.a(paramMotionEvent);
    this.mColorNoteCurd.a();
    ColorNote localColorNote = this.mServiceInfo.getColorNote();
    boolean bool;
    if (localColorNote != null)
    {
      bool = this.mColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType());
      if ((d <= 0.0D) || (bool) || (!this.allowedSliding) || (this.isInternalApp)) {
        break label369;
      }
      if (!this.mPostTableVisible)
      {
        this.mPostTable.setVisibility(0);
        this.mPostTableVisible = true;
      }
      if (!this.mColorNoteCurd.a()) {
        break label359;
      }
      if (!this.mTouchStateDetector.a(paramMotionEvent, getContext())) {
        break label344;
      }
      this.mPostTable.b();
      if ((!this.mhasVibrator) && (this.mVibrator != null))
      {
        this.mVibrator.vibrate(20L);
        this.mhasVibrator = true;
      }
      label215:
      this.mPostTable.a(d);
      if (this.mFirstShow)
      {
        axqy.b(null, "dc00898", "", "", "0X800A741", "0X800A741", amgm.a(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
        this.mFirstShow = false;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getActionMasked() == 1) && (this.mPostTable != null))
      {
        this.mPostTable.setVisibility(4);
        this.mPostTableVisible = false;
      }
      if ((this.mViewDragHelper == null) || (!this.allowedSliding)) {
        break label398;
      }
      this.mViewDragHelper.processTouchEvent(paramMotionEvent);
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
      bool = false;
      break;
      label344:
      this.mPostTable.a();
      this.mhasVibrator = false;
      break label215;
      label359:
      this.mPostTable.c();
      break label215;
      label369:
      if ((d < 1.0E-008D) || (bool))
      {
        this.mPostTable.setVisibility(4);
        this.mPostTableVisible = false;
      }
    }
    label398:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetCaptureViewState()
  {
    ThreadManager.getUIHandler().postDelayed(new SwipeBackLayout.4(this), 200L);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
  }
  
  public void setCallback(SwipeBackLayout.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setPostTab(PostTable paramPostTable)
  {
    this.mPostTable = paramPostTable;
    this.mPostTable.setVisibility(4);
    this.mPostTableVisible = false;
  }
  
  public void setScrollDirection(int paramInt)
  {
    if (this.mViewDragHelper != null) {
      this.mViewDragHelper.setScrollDirection(paramInt);
    }
  }
  
  public void setServiceInfo(amgv paramamgv)
  {
    this.mServiceInfo = paramamgv;
    setColorNoteStateNotice();
    this.mColorNoteStateNotice.a(paramamgv);
  }
  
  public void setViewDragHelper(ViewGroup paramViewGroup, View paramView)
  {
    this.mChildView = paramView;
    this.mViewDragHelper = ViewDragHelper.create(paramViewGroup, 1.0F, new SwipeBackLayout.1(this));
    this.mViewDragHelper.setEdgeTrackingEnabled(1);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mShadowDrawable = getResources().getDrawable(2130842141);
    this.mVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */