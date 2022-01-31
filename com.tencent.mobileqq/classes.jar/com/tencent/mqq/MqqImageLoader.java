package com.tencent.mqq;

import akzj;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.plato.sdk.IImageLoader;
import com.tencent.plato.sdk.IImageLoader.Listener;
import com.tencent.plato.sdk.IImageLoader.Option;

public class MqqImageLoader
  implements IImageLoader
{
  private static String a = "GlideImageLoader";
  
  private boolean a(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,"));
  }
  
  public void loadDrawable(String paramString, Context paramContext, IImageLoader.Listener paramListener)
  {
    if (a(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setURLDrawableListener(new akzj(this, paramListener));
    paramString.startDownload();
  }
  
  public void loadImage(String paramString, ImageView paramImageView, IImageLoader.Option paramOption)
  {
    if (a(paramString))
    {
      paramOption = null;
      try
      {
        paramString = Base64.decode(paramString.split(",")[1], 0);
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        paramImageView.setImageBitmap(paramString);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e(a, 0, paramString.getMessage());
          paramString = paramOption;
        }
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramOption.width;
    localURLDrawableOptions.mRequestHeight = paramOption.height;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mGifRoundCorner = paramOption.roundRadius;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramImageView.setImageDrawable(paramString);
    paramString.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mqq.MqqImageLoader
 * JD-Core Version:    0.7.0.1
 */