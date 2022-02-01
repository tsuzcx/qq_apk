package com.tencent.tavsticker.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class TAVStickerContentView
  extends FrameLayout
{
  private static final String TAG = TAVStickerContentView.class.getSimpleName();
  private TAVStickerContentView.DispatchTouchEventListener dispatchTouchEventListener = null;
  private TAVStickerEditView stickerEditView = null;
  
  public TAVStickerContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TAVStickerContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TAVStickerContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    if ((paramView instanceof TAVStickerEditView)) {
      this.stickerEditView = ((TAVStickerEditView)paramView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.dispatchTouchEventListener != null) {
      return this.dispatchTouchEventListener.onDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.stickerEditView != null) && (this.stickerEditView.isNeedInitLocation())) {
      this.stickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  void setDispatchTouchEventListener(TAVStickerContentView.DispatchTouchEventListener paramDispatchTouchEventListener)
  {
    this.dispatchTouchEventListener = paramDispatchTouchEventListener;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
    if (this.stickerEditView != null) {
      this.stickerEditView.needInitLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContentView
 * JD-Core Version:    0.7.0.1
 */