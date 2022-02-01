package com.tencent.rtmp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.liteav.k;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;

public class TXCloudVideoView
  extends FrameLayout
  implements View.OnTouchListener
{
  private static final int FOCUS_AREA_SIZE_DP = 70;
  private static final String TAG = "TXCloudVideoView";
  private float mBottom = 0.0F;
  private k mCapture;
  private int mCaptureHeight = 0;
  private int mCaptureWidth = 0;
  private int mCurrentScale = 1;
  protected TXDashBoard mDashBoard;
  private boolean mFocus = false;
  private int mFocusAreaSize = 0;
  protected TXCFocusIndicatorView mFocusIndicatorView;
  protected TXCGLSurfaceView mGLSurfaceView;
  private float mLeft = 0.0F;
  private float mRight = 0.0F;
  private ScaleGestureDetector mScaleGestureDetector = null;
  private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new TXCloudVideoView.2(this);
  protected SurfaceView mSurfaceView;
  private float mTop = 0.0F;
  private TXCloudVideoView.a mTouchFocusRunnable = new TXCloudVideoView.a(this, null);
  private String mUserId = "";
  protected TextureView mVideoView;
  private boolean mZoom = false;
  
  public TXCloudVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXCloudVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mDashBoard = new TXDashBoard(paramContext);
    this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, this.mScaleGestureListener);
  }
  
  public TXCloudVideoView(SurfaceView paramSurfaceView)
  {
    this(paramSurfaceView.getContext(), null);
    this.mSurfaceView = paramSurfaceView;
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect getTouchRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if (this.mFocusAreaSize == 0)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.mGLSurfaceView;
      if (localTXCGLSurfaceView != null) {
        this.mFocusAreaSize = ((int)(localTXCGLSurfaceView.getResources().getDisplayMetrics().density * 70.0F + 0.5F));
      }
    }
    int i = Float.valueOf(this.mFocusAreaSize * paramFloat).intValue();
    int j = i / 2;
    paramInt1 = clamp(paramInt1 - j, 0, paramInt3 - i);
    paramInt2 = clamp(paramInt2 - j, 0, paramInt4 - i);
    return new Rect(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void updateDbMargin()
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a((int)this.mLeft, (int)this.mTop, (int)this.mRight, (int)this.mBottom);
    }
  }
  
  public void addVideoView(TextureView paramTextureView)
  {
    TextureView localTextureView = this.mVideoView;
    if (localTextureView != null) {
      removeView(localTextureView);
    }
    this.mVideoView = paramTextureView;
    addView(this.mVideoView);
    resetLogView();
  }
  
  public void addVideoView(TXCGLSurfaceView paramTXCGLSurfaceView)
  {
    TXCGLSurfaceView localTXCGLSurfaceView = this.mGLSurfaceView;
    if (localTXCGLSurfaceView != null) {
      removeView(localTXCGLSurfaceView);
    }
    this.mGLSurfaceView = paramTXCGLSurfaceView;
    addView(this.mGLSurfaceView);
    resetLogView();
  }
  
  public void appendEventInfo(String paramString)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a(paramString);
    }
  }
  
  public void clearLastFrame(boolean paramBoolean)
  {
    if (paramBoolean) {
      setVisibility(8);
    }
  }
  
  public void clearLog()
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a();
    }
  }
  
  public void disableLog(boolean paramBoolean)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a(paramBoolean);
    }
  }
  
  public TXCGLSurfaceView getGLSurfaceView()
  {
    return this.mGLSurfaceView;
  }
  
  public TextureView getHWVideoView()
  {
    return this.mVideoView;
  }
  
  public SurfaceView getSurfaceView()
  {
    return this.mSurfaceView;
  }
  
  public String getUserId()
  {
    return this.mUserId;
  }
  
  public TextureView getVideoView()
  {
    return this.mVideoView;
  }
  
  public void onDestroy() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    updateDbMargin();
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null)
    {
      double d = px2dip(getContext(), getWidth());
      Double.isNaN(d);
      localTXDashBoard.setStatusTextSize((float)(d / 30.0D));
      localTXDashBoard = this.mDashBoard;
      d = px2dip(getContext(), getWidth());
      Double.isNaN(d);
      localTXDashBoard.setEventTextSize((float)(d / 25.0D));
    }
    paramInt1 = this.mCaptureWidth;
    if (paramInt1 != 0)
    {
      paramInt2 = this.mCaptureHeight;
      if (paramInt2 != 0) {
        updateVideoViewSize(paramInt1, paramInt2);
      }
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getPointerCount() == 1) && (paramMotionEvent.getAction() == 0))
    {
      this.mTouchFocusRunnable.a(paramView);
      this.mTouchFocusRunnable.a(paramMotionEvent);
      postDelayed(this.mTouchFocusRunnable, 100L);
    }
    else if ((paramMotionEvent.getPointerCount() > 1) && (paramMotionEvent.getAction() == 2))
    {
      removeCallbacks(this.mTouchFocusRunnable);
      onTouchFocus(-1, -1);
      paramView = this.mScaleGestureDetector;
      if ((paramView != null) && (this.mZoom)) {
        paramView.onTouchEvent(paramMotionEvent);
      }
    }
    if ((this.mZoom) && (paramMotionEvent.getAction() == 0)) {
      performClick();
    }
    return this.mZoom;
  }
  
  public void onTouchFocus(int paramInt1, int paramInt2)
  {
    if (this.mGLSurfaceView == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      localObject = this.mFocusIndicatorView;
      if (localObject == null)
      {
        this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
        this.mFocusIndicatorView.setVisibility(0);
        addView(this.mFocusIndicatorView);
      }
      else if (indexOfChild((View)localObject) != getChildCount() - 1)
      {
        removeView(this.mFocusIndicatorView);
        addView(this.mFocusIndicatorView);
      }
      localObject = getTouchRect(paramInt1, paramInt2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0F);
      this.mFocusIndicatorView.show(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right - ((Rect)localObject).left);
      return;
    }
    Object localObject = this.mFocusIndicatorView;
    if (localObject != null) {
      ((TXCFocusIndicatorView)localObject).setVisibility(8);
    }
  }
  
  public void removeFocusIndicatorView()
  {
    TXCFocusIndicatorView localTXCFocusIndicatorView = this.mFocusIndicatorView;
    if (localTXCFocusIndicatorView != null)
    {
      removeView(localTXCFocusIndicatorView);
      this.mFocusIndicatorView = null;
    }
  }
  
  public void removeVideoView()
  {
    Object localObject = this.mVideoView;
    if (localObject != null)
    {
      removeView((View)localObject);
      this.mVideoView = null;
    }
    localObject = this.mGLSurfaceView;
    if (localObject != null)
    {
      removeView((View)localObject);
      this.mGLSurfaceView = null;
    }
    this.mSurfaceView = null;
  }
  
  protected void resetLogView()
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null)
    {
      removeView(localTXDashBoard);
      addView(this.mDashBoard);
    }
  }
  
  public void setDashBoardStatusInfo(CharSequence paramCharSequence)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a(paramCharSequence);
    }
  }
  
  public void setLogMargin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mLeft = paramFloat1;
    this.mRight = paramFloat2;
    this.mTop = paramFloat3;
    this.mBottom = paramFloat4;
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a((int)this.mLeft, (int)this.mTop, (int)this.mRight, (int)this.mBottom);
    }
  }
  
  public void setLogMarginRatio(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    getWidth();
    getHeight();
    postDelayed(new TXCloudVideoView.1(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4), 100L);
  }
  
  public void setLogText(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.a(paramBundle1, paramBundle2, paramInt);
    }
  }
  
  public void setMirror(boolean paramBoolean) {}
  
  public void setRenderMode(int paramInt) {}
  
  public void setRenderRotation(int paramInt) {}
  
  public void setUserId(String paramString)
  {
    this.mUserId = paramString;
  }
  
  public void showLog(boolean paramBoolean)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null)
    {
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 0;
      }
      localTXDashBoard.setShowLevel(i);
    }
  }
  
  public void showVideoDebugLog(int paramInt)
  {
    TXDashBoard localTXDashBoard = this.mDashBoard;
    if (localTXDashBoard != null) {
      localTXDashBoard.setShowLevel(paramInt);
    }
  }
  
  public void start(boolean paramBoolean1, boolean paramBoolean2, k paramk)
  {
    this.mFocus = paramBoolean1;
    this.mZoom = paramBoolean2;
    if ((this.mFocus) || (this.mZoom))
    {
      setOnTouchListener(this);
      this.mCapture = paramk;
    }
    paramk = this.mGLSurfaceView;
    if (paramk != null) {
      paramk.setVisibility(0);
    }
  }
  
  public void stop(boolean paramBoolean)
  {
    if ((this.mFocus) || (this.mZoom)) {
      setOnTouchListener(null);
    }
    this.mCapture = null;
    if (paramBoolean)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.mGLSurfaceView;
      if (localTXCGLSurfaceView != null) {
        localTXCGLSurfaceView.setVisibility(8);
      }
    }
  }
  
  public void updateVideoViewSize(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mGLSurfaceView;
    if (localObject1 == null)
    {
      localObject1 = this.mVideoView;
      if (localObject1 == null) {}
    }
    else
    {
      int i = getWidth();
      int k = getHeight();
      if (paramInt2 != 0)
      {
        if (k == 0) {
          return;
        }
        this.mCaptureWidth = paramInt1;
        this.mCaptureHeight = paramInt2;
        float f1 = paramInt1 * 1.0F / paramInt2;
        float f2 = i;
        float f3 = k;
        float f4 = 1.0F * f2 / f3;
        paramInt2 = 0;
        int j;
        if (f1 > f4)
        {
          paramInt2 = (int)(f2 / f1);
          k = (getHeight() - paramInt2) / 2;
          j = 0;
          paramInt1 = i;
          i = k;
        }
        else
        {
          paramInt1 = (int)(f3 * f1);
          j = (getWidth() - paramInt1) / 2;
          i = paramInt2;
          paramInt2 = k;
        }
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          if ((((FrameLayout.LayoutParams)localObject2).width == paramInt1) && (((FrameLayout.LayoutParams)localObject2).height == paramInt2)) {
            return;
          }
          ((FrameLayout.LayoutParams)localObject2).width = paramInt1;
          ((FrameLayout.LayoutParams)localObject2).height = paramInt2;
        }
        else
        {
          localObject2 = new FrameLayout.LayoutParams(paramInt1, paramInt2);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject2).topMargin = i;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView
 * JD-Core Version:    0.7.0.1
 */