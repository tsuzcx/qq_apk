package com.tencent.richmediabrowser.view.pic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import java.util.concurrent.ConcurrentHashMap;

public class PictureView
  extends BrowserBaseView
{
  private static final String TAG = "PictureView";
  public PicturePresenter picPresenter;
  
  public PictureView(Activity paramActivity, PicturePresenter paramPicturePresenter)
  {
    super(paramActivity, paramPicturePresenter);
    this.picPresenter = paramPicturePresenter;
  }
  
  public boolean back()
  {
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearTheOuchCache()
  {
    this.picPresenter.mActiveDrawable.clear();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      paramView = ((PictureView.GalleryPictureViewHolder)paramView.getTag()).urlImageView;
    }
    for (;;)
    {
      this.picPresenter.getItem(paramInt);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mRequestWidth = this.mScreenWidthPx;
      paramViewGroup.mRequestHeight = this.mScreenHeightPx;
      paramViewGroup.mLoadingDrawable = Constants.TRANSPARENT;
      paramViewGroup.mPlayGifImage = true;
      paramViewGroup.mUseExifOrientation = false;
      paramViewGroup.mDecodeFileStrategy = 2;
      paramViewGroup = this.mContext.getResources().getDrawable(2130850136);
      paramView.setTag(Integer.valueOf(1));
      paramView.setIgnoreLayout(false);
      paramView.setImageDrawable(paramViewGroup);
      paramViewGroup = new PictureView.GalleryPictureViewHolder(this);
      paramViewGroup.urlImageView = paramView;
      this.galleryView.setTag(paramViewGroup);
      return this.galleryView;
      this.galleryView = new RelativeLayout(this.mContext);
      this.galleryView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView = new GalleryUrlImageView(this.mContext);
      paramView.setId(2131367921);
      paramView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      this.galleryView.addView(paramView, paramViewGroup);
    }
  }
  
  public void notifyImageModelDataChanged()
  {
    super.notifyImageModelDataChanged();
    clearTheOuchCache();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    clearTheOuchCache();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearTheOuchCache();
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.picPresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.picPresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
  }
  
  public void onEnterAnimationStart()
  {
    super.onEnterAnimationStart();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.picPresenter.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      paramView = ((PictureView.GalleryPictureViewHolder)paramView.getTag()).urlImageView.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onscaleBegin(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      paramView = ((PictureView.GalleryPictureViewHolder)paramView.getTag()).urlImageView;
      paramViewGroup = paramView.getDrawable();
      URLDrawable localURLDrawable = paramView.mDecoding;
      if (((paramViewGroup instanceof URLDrawable)) && (((URLDrawable)paramViewGroup).isFakeSize()) && (localURLDrawable == null)) {
        onscaleBegin(paramInt, paramViewGroup, localURLDrawable, paramView);
      }
    }
  }
  
  public void updateCache(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.picPresenter.mActiveDrawable.get(Integer.valueOf(paramInt)) != null) {
      this.picPresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void updateUI()
  {
    super.updateUI();
  }
  
  public void updateView(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.pic.PictureView
 * JD-Core Version:    0.7.0.1
 */