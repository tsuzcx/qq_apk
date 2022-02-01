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
  private static final String TAG = "TAVStickerContentView";
  protected TAVStickerContentView.DispatchTouchEventListener dispatchTouchEventListener = null;
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
    TAVStickerContentView.DispatchTouchEventListener localDispatchTouchEventListener = this.dispatchTouchEventListener;
    if (localDispatchTouchEventListener != null) {
      return localDispatchTouchEventListener.onDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void initStickerView()
  {
    TAVStickerEditView localTAVStickerEditView = this.stickerEditView;
    if ((localTAVStickerEditView != null) && (localTAVStickerEditView.isNeedInitLocation())) {
      this.stickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    initStickerView();
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
    setNeedInitLocation();
  }
  
  protected void setNeedInitLocation()
  {
    TAVStickerEditView localTAVStickerEditView = this.stickerEditView;
    if (localTAVStickerEditView != null) {
      localTAVStickerEditView.needInitLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContentView
 * JD-Core Version:    0.7.0.1
 */