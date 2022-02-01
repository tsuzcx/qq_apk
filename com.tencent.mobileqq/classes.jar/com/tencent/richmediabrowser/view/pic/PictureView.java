package com.tencent.richmediabrowser.view.pic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.richmediabrowser.download.HttpDownloadManager;
import com.tencent.richmediabrowser.listener.IBrowserItemEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class PictureView
  extends BrowserBaseView
  implements Handler.Callback, View.OnClickListener, IBrowserItemEventListener
{
  private static final int REFRESH_IMAGE = 1;
  private static final String TAG = "PictureView";
  public static final Drawable TRANSPARENT = new ColorDrawable(0);
  private BrowserScaleView imageView;
  Handler mHandler;
  public PicturePresenter picPresenter;
  
  public PictureView(Activity paramActivity, PicturePresenter paramPicturePresenter)
  {
    super(paramActivity, paramPicturePresenter);
    this.picPresenter = paramPicturePresenter;
  }
  
  private void updateOriginalData(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      paramURLDrawable.setTag(Integer.valueOf(1));
      this.picPresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      this.imageView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, this.picPresenter.getRotation(paramRichMediaBrowserInfo.orientation));
      this.picPresenter.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("PictureView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  public boolean back()
  {
    return super.back();
  }
  
  public void bindView(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.picPresenter.getItem(paramInt);
    PictureData localPictureData;
    Object localObject2;
    File localFile;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 1))
    {
      localPictureData = (PictureData)localRichMediaBrowserInfo.baseData;
      localObject1 = null;
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = TRANSPARENT;
      if (!localPictureData.isLocal) {
        break label130;
      }
      localFile = new File(localPictureData.filePath);
    }
    for (;;)
    {
      try
      {
        localObject2 = URLDrawable.getDrawable(localFile.toURI().toURL().toString(), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        continue;
      }
      if (localObject1 != null) {
        break;
      }
      return;
      label130:
      localObject1 = URLDrawable.getDrawable(localPictureData.url);
    }
    this.imageView.setOnItemEventListener(this);
    this.imageView.setMainBrowserPresenter(this.picPresenter.mainBrowserPresenter);
    this.imageView.setImageDrawable((Drawable)localObject1);
    this.imageView.setOriginalImage(true);
    this.imageView.setGalleryImageListener(new PictureView.1(this, localRichMediaBrowserInfo, localPictureData, (URLDrawable)localObject1));
    this.imageView.initDrawable((Drawable)localObject1, ScreenUtils.getScreenWidth(this.mContext), ScreenUtils.getScreenHeight(this.mContext), 0);
    Object localObject1 = new PictureView.GalleryPictureViewHolder(this);
    ((PictureView.GalleryPictureViewHolder)localObject1).urlImageView = this.imageView;
    this.mBrowserItemView.setTag(localObject1);
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
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
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.imageView = ((PictureView.GalleryPictureViewHolder)paramView.getTag()).urlImageView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559582, paramViewGroup, false));
      this.imageView = ((BrowserScaleView)this.mBrowserItemView.findViewById(2131368367));
      this.imageView.setOnClickListener(this);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = this.mContext.getResources().getDrawable(2130850678);
    this.imageView.initDrawable(paramMessage, ScreenUtils.getScreenWidth(this.mContext), ScreenUtils.getScreenHeight(this.mContext), 0);
    this.imageView.setImageDrawable(paramMessage);
    return false;
  }
  
  public void notifyImageModelDataChanged()
  {
    super.notifyImageModelDataChanged();
    clearTheOuchCache();
  }
  
  public void onClick(View paramView) {}
  
  public void onClickEvent()
  {
    Toast.makeText(this.mContext, "点击到图片", 1).show();
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
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
  }
  
  public void onLongClickEvent()
  {
    Toast.makeText(this.mContext, "图片长按", 1).show();
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
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    paramView = this.picPresenter.getItem(paramInt);
    if ((paramView != null) && (paramView.baseData != null) && (!TextUtils.isEmpty(paramView.baseData.url))) {
      HttpDownloadManager.getInstance().removeImageDownloadListener(paramView.baseData.url);
    }
  }
  
  public void reset()
  {
    if (this.imageView != null) {
      this.imageView.reset();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.pic.PictureView
 * JD-Core Version:    0.7.0.1
 */