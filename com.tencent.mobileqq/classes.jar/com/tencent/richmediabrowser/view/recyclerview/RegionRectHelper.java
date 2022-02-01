package com.tencent.richmediabrowser.view.recyclerview;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

public class RegionRectHelper
{
  private static final String TAG = "RegionRectHelper";
  protected static Rect tmp = new Rect();
  private static RectF tmp2 = new RectF();
  private MainBrowserPresenter mMainBrowserPresenter;
  private Matrix tempMatrix = new Matrix();
  
  public RegionRectHelper(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mMainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  protected boolean canUpdateRegionRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 * paramInt2 >= paramInt3 * paramInt4 << 2;
  }
  
  protected Rect getChildBounds(Drawable paramDrawable, Matrix paramMatrix, Rect paramRect, View paramView)
  {
    if ((paramDrawable != null) && (paramMatrix != null) && (paramView != null))
    {
      tmp2.set(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(tmp2);
      tmp2.offset(paramView.getLeft(), paramView.getTop());
      tmp2.round(paramRect);
      return paramRect;
    }
    return new Rect();
  }
  
  protected void onShowAreaChanged(View paramView, RegionDrawableData paramRegionDrawableData)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onShowAreaChanged(paramView, paramRegionDrawableData);
    }
  }
  
  public void updateShowArea(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean, int paramInt)
  {
    updateShowArea(paramDrawable, paramMatrix, paramFloat1, paramFloat2, paramView, paramBoolean, 0, paramInt);
  }
  
  protected void updateShowArea(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      if (paramMatrix == null) {
        return;
      }
      int i = ScreenUtils.getScreenWidth(paramView.getContext());
      int j = ScreenUtils.getScreenHeight(paramView.getContext());
      if (i != 0)
      {
        if (j == 0) {
          return;
        }
        Rect localRect = new Rect();
        getChildBounds(paramDrawable, paramMatrix, localRect, paramView);
        if (!localRect.intersect(0, 0, i, j)) {
          return;
        }
        localRect.offset(-paramView.getLeft(), -paramView.getTop());
        paramMatrix.invert(this.tempMatrix);
        paramMatrix = new RectF(localRect);
        this.tempMatrix.mapRect(paramMatrix);
        paramMatrix.round(localRect);
        tmp.set(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        localRect.intersect(tmp);
        paramDrawable = new RegionDrawableData();
        paramDrawable.mImageArea = tmp;
        paramDrawable.mShowArea = localRect;
        paramDrawable.mScale = paramFloat2;
        paramDrawable.mState = paramInt1;
        paramDrawable.mShowRegion = paramBoolean;
        paramDrawable.mScrollDirection = paramInt2;
        paramDrawable.mDefaultScale = paramFloat1;
        onShowAreaChanged(paramView, paramDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.RegionRectHelper
 * JD-Core Version:    0.7.0.1
 */