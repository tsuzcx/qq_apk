package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class AsynLoadDrawable
  extends Drawable
{
  public static final int STATE_LOADING = 0;
  public static final int STATE_LOAD_FAILURE = 2;
  public static final int STATE_LOAD_SUCCESS = 1;
  protected int mAlpha = -1;
  protected boolean mCancelled = false;
  protected ColorFilter mColorFilter = null;
  protected int mCurState = 0;
  protected Drawable mFailureDrawable = null;
  protected Drawable mLoadedDrawable = null;
  protected Drawable mLoadingDrawable = null;
  
  protected AsynLoadDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.mLoadingDrawable = paramDrawable1;
    this.mFailureDrawable = paramDrawable2;
  }
  
  public void cancel()
  {
    this.mCancelled = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public Drawable getCurrDrawable()
  {
    switch (this.mCurState)
    {
    default: 
      return null;
    case 0: 
      return this.mLoadingDrawable;
    case 1: 
      return this.mLoadedDrawable;
    }
    return this.mFailureDrawable;
  }
  
  public abstract Drawable getDefaultDrawable();
  
  public int getIntrinsicHeight()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicWidth();
    }
    return i;
  }
  
  public Bitmap getLoadedBitmap()
  {
    if ((this.mLoadedDrawable != null) && ((this.mLoadedDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)this.mLoadedDrawable).getBitmap();
    }
    return null;
  }
  
  public int getMinimumHeight()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getMinimumHeight();
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getMinimumWidth();
    }
    return i;
  }
  
  public int getOpacity()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getOpacity();
    }
    return i;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mCurState == 1)
    {
      this.mLoadedDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDrawableBitmap(this.mLoadedDrawable));
      this.mLoadedDrawable.setBounds(paramRect);
      if (this.mAlpha != -1) {
        this.mLoadedDrawable.setAlpha(this.mAlpha);
      }
      invalidateSelf();
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getCurrDrawable();
    } while (localDrawable == null);
    localDrawable.setBounds(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mColorFilter = paramColorFilter;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.AsynLoadDrawable
 * JD-Core Version:    0.7.0.1
 */