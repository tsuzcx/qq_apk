package com.tencent.mobileqq.richmediabrowser;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class AIOBrowserAnimation
  extends BrowserAnimation
  implements IBrowserAnimationListener
{
  public int a;
  public Rect b;
  Rect c;
  private RichMediaBaseData d;
  
  public AIOBrowserAnimation() {}
  
  public AIOBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    this.d = paramRichMediaBaseData;
    this.isImgCenterCropMode = true;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable;
        if ((this.d instanceof AIOPictureData))
        {
          localDrawable = new AIOPictureModel().a((AIOPictureData)this.d);
        }
        else if ((this.d instanceof AIOVideoData))
        {
          localDrawable = new AIOVideoModel().a((AIOVideoData)this.d);
        }
        else if ((this.d instanceof AIOFilePictureData))
        {
          localDrawable = new AIOFilePictureModel().a((AIOFilePictureData)this.d);
        }
        else
        {
          if (!(this.d instanceof AIOFileVideoData)) {
            break label223;
          }
          localDrawable = new AIOFileVideoModel().e((AIOFileVideoData)this.d);
        }
        Rect localRect = getThumbRect();
        if ((localDrawable != null) && ((localDrawable.getIntrinsicHeight() * 3 < localDrawable.getIntrinsicWidth()) || (localDrawable.getIntrinsicWidth() * 3 < localDrawable.getIntrinsicHeight()))) {
          this.isImgCenterCropMode = false;
        }
        if ((localDrawable != null) && (localRect != null))
        {
          this.a = getCutValue(localRect, localDrawable);
          if (localDrawable.getIntrinsicHeight() != -1)
          {
            int i = localDrawable.getIntrinsicWidth();
            if (i == -1) {
              return null;
            }
            return localDrawable;
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        }
        return null;
      }
      label223:
      Object localObject = null;
    }
  }
  
  public BrowserAnimation getBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    paramRichMediaBaseData = new AIOBrowserAnimation(paramRichMediaBaseData);
    paramRichMediaBaseData.b = this.b;
    return paramRichMediaBaseData;
  }
  
  public int getCutValue()
  {
    return this.a;
  }
  
  public Rect getStartSrcRect()
  {
    return this.c;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    Rect localRect = this.b;
    if (localRect != null) {
      return localRect;
    }
    return super.getThumbRect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserAnimation
 * JD-Core Version:    0.7.0.1
 */