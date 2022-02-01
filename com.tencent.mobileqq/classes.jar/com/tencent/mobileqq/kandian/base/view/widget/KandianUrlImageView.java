package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;

public class KandianUrlImageView
  extends ResizeURLImageView
{
  private boolean mIsRecyclerView;
  private KandianUrlImageView.OnVisibilityChangedListener mVisibilityChangedListener;
  
  public KandianUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    if (!this.mIsRecyclerView) {
      super.onDetachedFromWindow();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    KandianUrlImageView.OnVisibilityChangedListener localOnVisibilityChangedListener = this.mVisibilityChangedListener;
    if (localOnVisibilityChangedListener != null) {
      localOnVisibilityChangedListener.a(paramView, paramInt);
    }
  }
  
  public void release()
  {
    if (this.mController != null) {
      this.mController.a("onKandianUrlImageView release");
    }
  }
  
  public void setIsRecyclerView(boolean paramBoolean)
  {
    this.mIsRecyclerView = paramBoolean;
  }
  
  public void setVisibilityChangedListener(KandianUrlImageView.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.mVisibilityChangedListener = paramOnVisibilityChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView
 * JD-Core Version:    0.7.0.1
 */