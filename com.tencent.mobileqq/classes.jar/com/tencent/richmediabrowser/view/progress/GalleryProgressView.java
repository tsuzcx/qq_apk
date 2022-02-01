package com.tencent.richmediabrowser.view.progress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

public class GalleryProgressView
  implements AbstractProgressView
{
  private static final String TAG = "GalleryProgressView";
  Rect bounds;
  boolean isShow = false;
  boolean isStarted = false;
  PhotoProgressDrawable mPhotoProgressDrawable;
  int progress = 0;
  ImageView progressBar;
  
  private void initDrawable(Context paramContext)
  {
    Object localObject1;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130842518);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDrawable exception = ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      ((IBrowserLog)localObject2).e("GalleryProgressView", 4, localStringBuilder.toString());
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    }
    this.mPhotoProgressDrawable = new PhotoProgressDrawable((Bitmap)localObject2, (int)(paramContext.getResources().getDisplayMetrics().density * 12.0F));
    this.mPhotoProgressDrawable.setLevel(0);
    this.bounds = new Rect(0, 0, 0, 0);
  }
  
  public void hide()
  {
    this.isShow = false;
    if (this.progressBar.getVisibility() == 0) {
      this.progressBar.setVisibility(4);
    }
  }
  
  public void init(Context paramContext, ImageView paramImageView)
  {
    this.progressBar = paramImageView;
    initDrawable(paramContext);
  }
  
  public void init(Context paramContext, BrowserBaseScene paramBrowserBaseScene)
  {
    this.progressBar = ((ImageView)paramBrowserBaseScene.getRootView().findViewById(2131440773));
    initDrawable(paramContext);
  }
  
  public boolean isShow()
  {
    return this.isShow;
  }
  
  public boolean isStarted()
  {
    return this.isStarted;
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      this.mPhotoProgressDrawable.setLevel(paramInt * 100);
      this.mPhotoProgressDrawable.invalidateSelf();
    }
  }
  
  public void show()
  {
    this.isShow = true;
    if ((this.isStarted) && (this.progressBar.getVisibility() == 4))
    {
      if ((this.bounds.width() == 0) || (this.bounds.height() == 0))
      {
        this.bounds.set(0, 0, this.progressBar.getWidth(), this.progressBar.getHeight());
        this.mPhotoProgressDrawable.setBounds(this.bounds);
        this.progressBar.setImageDrawable(this.mPhotoProgressDrawable);
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public void start(int paramInt)
  {
    this.progress = paramInt;
    this.isStarted = true;
    if (this.isShow)
    {
      if ((this.bounds.width() == 0) || (this.bounds.height() == 0))
      {
        this.bounds.set(0, 0, this.progressBar.getWidth(), this.progressBar.getHeight());
        this.mPhotoProgressDrawable.setBounds(this.bounds);
        this.progressBar.setImageDrawable(this.mPhotoProgressDrawable);
      }
      this.progressBar.setVisibility(0);
    }
    if ((paramInt >= 0) && (paramInt < 100))
    {
      this.mPhotoProgressDrawable.setLevel(paramInt * 100);
      this.mPhotoProgressDrawable.invalidateSelf();
      return;
    }
    this.mPhotoProgressDrawable.disableDrawText();
  }
  
  public void stop()
  {
    this.progress = 0;
    this.isStarted = false;
    if (this.progressBar.getVisibility() == 0) {
      this.progressBar.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.progress.GalleryProgressView
 * JD-Core Version:    0.7.0.1
 */