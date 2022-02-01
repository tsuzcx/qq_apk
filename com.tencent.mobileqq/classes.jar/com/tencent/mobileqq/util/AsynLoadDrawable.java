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
    int i = this.mCurState;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return this.mFailureDrawable;
      }
      return this.mLoadedDrawable;
    }
    return this.mLoadingDrawable;
  }
  
  public abstract Drawable getDefaultDrawable();
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return 0;
  }
  
  public Bitmap getLoadedBitmap()
  {
    Drawable localDrawable = this.mLoadedDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)localDrawable).getBitmap();
    }
    return null;
  }
  
  public int getMinimumHeight()
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mCurState == 1)
    {
      this.mLoadedDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDrawableBitmap(this.mLoadedDrawable));
      this.mLoadedDrawable.setBounds(paramRect);
      int i = this.mAlpha;
      if (i != -1) {
        this.mLoadedDrawable.setAlpha(i);
      }
      invalidateSelf();
      return;
    }
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.AsynLoadDrawable
 * JD-Core Version:    0.7.0.1
 */