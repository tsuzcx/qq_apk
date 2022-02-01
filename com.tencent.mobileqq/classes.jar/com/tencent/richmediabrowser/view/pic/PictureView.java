package com.tencent.richmediabrowser.view.pic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.android.volley.VolleyError;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.download.HttpDownloadManager;
import com.tencent.richmediabrowser.download.IImageDownloadListener;
import com.tencent.richmediabrowser.listener.IBrowserItemEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import java.util.concurrent.ConcurrentHashMap;

public class PictureView
  extends BrowserBaseView
  implements Handler.Callback, View.OnClickListener, IImageDownloadListener, IBrowserItemEventListener
{
  private static final int REFRESH_IMAGE = 1;
  private static final String TAG = "PictureView";
  private BrowserScaleView imageView;
  Handler mHandler;
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
  
  public void bindView(int paramInt)
  {
    Object localObject = this.picPresenter.getItem(paramInt);
    HttpDownloadManager.getInstance().addImageDownloadListener(((RichMediaBrowserInfo)localObject).baseData.url, this);
    if (Integer.parseInt(((RichMediaBrowserInfo)localObject).baseData.id) % 2 == 0) {}
    for (localObject = this.mContext.getResources().getDrawable(2130850749);; localObject = this.mContext.getResources().getDrawable(2130850749))
    {
      this.imageView.setOnItemEventListener(this);
      this.imageView.setImageDrawable((Drawable)localObject);
      this.imageView.setMainBrowserPresenter(this.picPresenter.mainBrowserPresenter);
      this.imageView.initDrawable((Drawable)localObject, ScreenUtils.getScreenWidth(this.mContext), ScreenUtils.getScreenHeight(this.mContext), 0);
      localObject = new PictureView.GalleryPictureViewHolder(this);
      ((PictureView.GalleryPictureViewHolder)localObject).urlImageView = this.imageView;
      this.mBrowserItemView.setTag(localObject);
      return;
    }
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
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559580, paramViewGroup, false));
      this.imageView = ((BrowserScaleView)this.mBrowserItemView.findViewById(2131368343));
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
    paramMessage = this.mContext.getResources().getDrawable(2130850749);
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
  
  public void onError(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null) {}
    for (paramVolleyError = paramVolleyError.getMessage();; paramVolleyError = "")
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("PictureView", 4, "onError: " + paramVolleyError);
      return;
    }
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
  
  public void onSuccess(String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("PictureView", 4, "onSuccess");
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.picPresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (!TextUtils.isEmpty(localRichMediaBrowserInfo.baseData.url)) && (paramString.equals(localRichMediaBrowserInfo.baseData.url)) && (this.mBrowserItemView != null) && ((this.mBrowserItemView.getTag() instanceof PictureView.GalleryPictureViewHolder))) {
        ((PictureView.GalleryPictureViewHolder)this.mBrowserItemView.getTag()).urlImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("PictureView", 4, "onSuccess bitmap is null, url = " + paramString);
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