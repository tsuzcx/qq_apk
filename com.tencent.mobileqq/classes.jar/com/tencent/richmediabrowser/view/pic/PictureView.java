package com.tencent.richmediabrowser.view.pic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class PictureView
  extends BrowserBaseView
  implements IBrowserItemClickEvent
{
  private static final String TAG = "AIOPictureView";
  public RelativeLayout controlViewContainer;
  public BrowserScaleView imageView;
  private Context mContext;
  private PicturePresenter picturePresenter;
  
  public PictureView(Context paramContext, PicturePresenter paramPicturePresenter)
  {
    super(paramContext, paramPicturePresenter);
    this.mContext = paramContext;
    this.picturePresenter = paramPicturePresenter;
  }
  
  private void dealCacheImage(RichMediaBrowserInfo paramRichMediaBrowserInfo, URLDrawable paramURLDrawable)
  {
    this.imageView.setImageDrawable(paramURLDrawable);
    paramRichMediaBrowserInfo = paramURLDrawable.getURL().toString();
    int i;
    try
    {
      i = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("read exif error");
      localStringBuilder2.append(localException.getMessage());
      localIBrowserLog.d("AIOPictureView", 4, localStringBuilder2.toString());
      i = 0;
    }
    this.imageView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, BrowserUtils.a(i));
    paramURLDrawable = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("getView(): cache url is ");
    localStringBuilder1.append(paramRichMediaBrowserInfo);
    paramURLDrawable.d("AIOPictureView", 4, localStringBuilder1.toString());
  }
  
  private boolean dealDefaultImage()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
    this.imageView.setImageDrawable(Constants.TRANSPARENT);
    return true;
  }
  
  private boolean dealErrorImage()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    Object localObject = this.mContext.getResources().getDrawable(2130841247);
    this.imageView.setImageDrawable((Drawable)localObject);
    this.imageView.initDrawable((Drawable)localObject, this.mScreenWidthPx, this.mScreenHeightPx, 0);
    localObject = this.picturePresenter;
    ((PicturePresenter)localObject).onLoadFinish(((PicturePresenter)localObject).getSelectedIndex(), false);
    return true;
  }
  
  private URLDrawable dealLocalImage(RichMediaBrowserInfo paramRichMediaBrowserInfo, PictureData paramPictureData, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealLocalImage");
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.mScreenWidthPx;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.mScreenHeightPx;
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = Constants.TRANSPARENT;
    Object localObject2 = Integer.valueOf(1);
    ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject3).mDecodeFileStrategy = 2;
    File localFile = new File(paramPictureData.filePath);
    Object localObject1 = null;
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(localFile.toURI().toURL().toString(), (URLDrawable.URLDrawableOptions)localObject3);
      localObject1 = localURLDrawable1;
      localURLDrawable1.setTag(localObject2);
      localObject1 = localURLDrawable1;
      localURLDrawable1.downloadImediatly();
      localObject1 = localURLDrawable1;
    }
    catch (Throwable localThrowable1)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealLocalImage URLDrawable.getDrawable failed, exception = ");
      localStringBuilder.append(localThrowable1.getMessage());
      localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
    }
    if ((localObject1 != null) && (localObject1.getStatus() == 1))
    {
      updateOriginalData(paramRichMediaBrowserInfo, paramPictureData.filePath, localObject1, paramInt);
      return localObject1;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealLocalImage error");
    try
    {
      URLDrawable localURLDrawable2 = URLDrawable.getDrawable(localFile.toURI().toURL().toString(), (URLDrawable.URLDrawableOptions)localObject3);
      localObject1 = localURLDrawable2;
      localURLDrawable2.setTag(localObject2);
      localObject1 = localURLDrawable2;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("dealLocalImage getDrawable failed, exception = ");
      ((StringBuilder)localObject3).append(localThrowable2.getMessage());
      ((IBrowserLog)localObject2).d("AIOPictureView", 4, ((StringBuilder)localObject3).toString());
    }
    PicturePresenter localPicturePresenter = this.picturePresenter;
    localPicturePresenter.onLoadStart(localPicturePresenter.getSelectedIndex(), paramPictureData.progress);
    paramPictureData = localFile.getAbsolutePath();
    this.imageView.setGalleryImageListener(new PictureView.1(this, paramRichMediaBrowserInfo, paramPictureData, localObject1));
    return localObject1;
  }
  
  private void downLoadImage(String paramString1, String paramString2)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadImage url = ");
    localStringBuilder.append(paramString2);
    localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
    if ((this.picturePresenter.mainBrowserPresenter != null) && (this.picturePresenter.mainBrowserPresenter.getParamsBuilder().a() != null)) {
      this.picturePresenter.mainBrowserPresenter.getParamsBuilder().a().a(paramString2);
    }
    this.picturePresenter.updateItemStatus(paramString1, 1);
  }
  
  private void updateOriginalData(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    int i;
    try
    {
      i = JpegExifReader.readOrientation(paramString);
    }
    catch (Exception paramRichMediaBrowserInfo)
    {
      paramString = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read exif error");
      localStringBuilder.append(paramRichMediaBrowserInfo.getMessage());
      paramString.d("AIOPictureView", 4, localStringBuilder.toString());
      i = 0;
    }
    paramURLDrawable.setTag(Integer.valueOf(1));
    this.picturePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    this.imageView.setImageDrawable(paramURLDrawable);
    this.imageView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, BrowserUtils.a(i));
    this.picturePresenter.onLoadFinish(paramInt, true);
  }
  
  public void bindView(int paramInt)
  {
    Object localObject = this.picturePresenter.getItem(paramInt);
    if (localObject != null)
    {
      if (((RichMediaBrowserInfo)localObject).baseData == null) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 1)
      {
        PictureData localPictureData = (PictureData)((RichMediaBrowserInfo)localObject).baseData;
        PictureModel localPictureModel = new PictureModel(this.picturePresenter);
        this.imageView.setPosition(paramInt);
        this.imageView.setImageInfo((RichMediaBrowserInfo)localObject);
        this.imageView.setIgnoreLayout(false);
        this.imageView.setContentDescription(this.mContext.getString(2131892631));
        URLDrawable localURLDrawable = (URLDrawable)this.picturePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
        if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1))
        {
          dealCacheImage((RichMediaBrowserInfo)localObject, localURLDrawable);
        }
        else if (localPictureModel.isPictureExisit(localPictureData))
        {
          dealLocalImage((RichMediaBrowserInfo)localObject, localPictureData, paramInt);
        }
        else
        {
          dealDefaultImage();
          downLoadImage(localPictureData.id, localPictureData.url);
        }
        this.imageView.setMainBrowserPresenter(this.picturePresenter.mainBrowserPresenter);
        localObject = new PictureView.GalleryPictureViewHolder(this);
        ((PictureView.GalleryPictureViewHolder)localObject).urlImageView = this.imageView;
        this.mBrowserItemView.setTag(localObject);
      }
      super.bindView(paramInt);
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView()
  {
    super.buildView();
  }
  
  public void clearTheOuchCache()
  {
    this.picturePresenter.mActiveDrawable.clear();
  }
  
  public void dealImageScale(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, BrowserScaleView paramBrowserScaleView)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = (URLDrawable)paramDrawable;
      if ((paramDrawable.isFakeSize()) && (paramURLDrawable == null))
      {
        paramDrawable = paramDrawable.getURL();
        if (("file".equals(paramDrawable.getProtocol())) && (paramDrawable.getRef() == null))
        {
          paramDrawable = paramDrawable.toString();
          paramURLDrawable = URLDrawable.URLDrawableOptions.obtain();
          paramURLDrawable.mUseExifOrientation = false;
          paramURLDrawable.mUseMemoryCache = false;
          paramDrawable = URLDrawable.getDrawable(paramDrawable, paramURLDrawable);
          paramDrawable.setTag(Integer.valueOf(2));
          paramURLDrawable = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("create rawDrawable, position:");
          localStringBuilder.append(paramInt);
          paramURLDrawable.d("AIOPictureView", 4, localStringBuilder.toString());
          if (paramDrawable.getStatus() == 1)
          {
            paramBrowserScaleView.setIgnoreLayout(true);
            paramBrowserScaleView.setImageDrawable(paramDrawable);
            paramBrowserScaleView.setIgnoreLayout(false);
          }
        }
      }
    }
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.imageView = ((PictureView.GalleryPictureViewHolder)paramView.getTag()).urlImageView;
    }
    else
    {
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131625592, paramViewGroup, false));
      initContentView();
    }
    super.getView(paramView, paramViewGroup);
    return this.mBrowserItemView;
  }
  
  public void initContentView()
  {
    if (this.mBrowserItemView != null)
    {
      this.controlViewContainer = ((RelativeLayout)this.mBrowserItemView.findViewById(2131431391));
      this.imageView = ((BrowserScaleView)this.mBrowserItemView.findViewById(2131435357));
      this.imageView.setOnItemEventListener(this);
      this.imageView.setOnLongClickListener(this);
      if (this.picturePresenter.mainBrowserPresenter != null)
      {
        this.imageView.setDoubleTapEnable(this.picturePresenter.mainBrowserPresenter.getParamsBuilder().d);
        this.imageView.setScaleEnable(this.picturePresenter.mainBrowserPresenter.getParamsBuilder().e);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    clearTheOuchCache();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BrowserScaleView localBrowserScaleView = this.imageView;
    if (localBrowserScaleView != null) {
      localBrowserScaleView.setOnItemEventListener(null);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    Object localObject = (URLDrawable)this.picturePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (((URLDrawable)localObject).getStatus() == 0) {
        ((URLDrawable)localObject).cancelDownload(true);
      }
      this.picturePresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
    localObject = this.picturePresenter.getCurrentPictureData();
    if ((localObject != null) && (((PictureData)localObject).status == 1) && (!TextUtils.isEmpty(((PictureData)localObject).url)) && (this.picturePresenter.mainBrowserPresenter != null) && (this.picturePresenter.mainBrowserPresenter.getParamsBuilder().a() != null)) {
      this.picturePresenter.mainBrowserPresenter.getParamsBuilder().a().b(((PictureData)localObject).url);
    }
    super.onDestroyView(paramInt, paramView);
  }
  
  public void onItemSelected(int paramInt)
  {
    bindView(paramInt);
    updateUI();
    super.onItemSelected(paramInt);
  }
  
  public void onLongClickEvent() {}
  
  public void onScaleBegin()
  {
    if ((this.mBrowserItemView != null) && ((this.mBrowserItemView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      BrowserScaleView localBrowserScaleView = ((PictureView.GalleryPictureViewHolder)this.mBrowserItemView.getTag()).urlImageView;
      Drawable localDrawable = localBrowserScaleView.getDrawable();
      URLDrawable localURLDrawable = localBrowserScaleView.mDecoding;
      if (((localDrawable instanceof URLDrawable)) && (((URLDrawable)localDrawable).isFakeSize()) && (localURLDrawable == null)) {
        dealImageScale(this.picturePresenter.getCurrentPosition(), localDrawable, localURLDrawable, localBrowserScaleView);
      }
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = this.imageView.getDrawable();
    if (!URLDrawable.class.isInstance(paramView)) {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void updateUI()
  {
    Object localObject1 = this.picturePresenter.getCurrentPictureData();
    if (localObject1 != null)
    {
      int i = ((PictureData)localObject1).status;
      if (i != 0)
      {
        Object localObject2;
        if (i != 1)
        {
          localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateUI status is error, status = ");
          localStringBuilder.append(((PictureData)localObject1).status);
          ((IBrowserLog)localObject2).d("AIOPictureView", 4, localStringBuilder.toString());
        }
        else
        {
          localObject2 = this.picturePresenter;
          ((PicturePresenter)localObject2).onLoadStart(((PicturePresenter)localObject2).getSelectedIndex(), ((PictureData)localObject1).progress);
        }
      }
      else
      {
        localObject1 = this.picturePresenter;
        ((PicturePresenter)localObject1).onLoadFinish(((PicturePresenter)localObject1).getSelectedIndex(), true);
      }
    }
    super.updateUI();
  }
  
  public void updateView(int paramInt)
  {
    Object localObject1 = this.picturePresenter.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 1) && (this.mBrowserItemView != null) && ((this.mBrowserItemView.getTag() instanceof PictureView.GalleryPictureViewHolder)))
    {
      localObject1 = (PictureData)((RichMediaBrowserInfo)localObject1).baseData;
      Object localObject2 = new PictureModel(this.picturePresenter);
      if (!((PictureData)localObject1).isDownloadSuccess)
      {
        dealErrorImage();
        return;
      }
      if (((PictureModel)localObject2).isPictureExisit((PictureData)localObject1))
      {
        bindView(paramInt);
        return;
      }
      localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView() errorCode = ");
      localStringBuilder.append(((PictureData)localObject1).errorCode);
      localStringBuilder.append(", filePath = ");
      localStringBuilder.append(((PictureData)localObject1).filePath);
      ((IBrowserLog)localObject2).d("AIOPictureView", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.pic.PictureView
 * JD-Core Version:    0.7.0.1
 */