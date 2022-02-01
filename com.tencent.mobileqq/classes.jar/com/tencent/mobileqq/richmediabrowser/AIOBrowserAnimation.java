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
  public Rect a;
  private RichMediaBaseData a;
  Rect b;
  
  public AIOBrowserAnimation() {}
  
  public AIOBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData = paramRichMediaBaseData;
    this.isImgCenterCropMode = true;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable;
        if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOPictureData))
        {
          localDrawable = new AIOPictureModel().a((AIOPictureData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
        }
        else if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOVideoData))
        {
          localDrawable = new AIOVideoModel().a((AIOVideoData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
        }
        else if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOFilePictureData))
        {
          localDrawable = new AIOFilePictureModel().a((AIOFilePictureData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
        }
        else
        {
          if (!(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOFileVideoData)) {
            break label223;
          }
          localDrawable = new AIOFileVideoModel().a((AIOFileVideoData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
        }
        Rect localRect = getThumbRect();
        if ((localDrawable != null) && ((localDrawable.getIntrinsicHeight() * 3 < localDrawable.getIntrinsicWidth()) || (localDrawable.getIntrinsicWidth() * 3 < localDrawable.getIntrinsicHeight()))) {
          this.isImgCenterCropMode = false;
        }
        if ((localDrawable != null) && (localRect != null))
        {
          this.jdField_a_of_type_Int = getCutValue(localRect, localDrawable);
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
    paramRichMediaBaseData.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_AndroidGraphicsRect;
    return paramRichMediaBaseData;
  }
  
  public int getCutValue()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect getStartSrcRect()
  {
    return this.b;
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
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localRect != null) {
      return localRect;
    }
    return super.getThumbRect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserAnimation
 * JD-Core Version:    0.7.0.1
 */