package com.tencent.mobileqq.richmediabrowser.model;

import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class AIOVideoModel
  extends BrowserBaseModel
{
  public Drawable a(AIOVideoData paramAIOVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOVideoData, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((localFile != null) && (GlobalImageCache.a.get(a(paramAIOVideoData, 0)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOVideoData = URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
    paramAIOVideoData.downloadImediatly();
    return paramAIOVideoData;
  }
  
  public File a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOVideoData = null;
    }
    while ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      paramAIOVideoData = new File(paramAIOVideoData);
      if (!paramAIOVideoData.exists()) {
        break;
      }
      return paramAIOVideoData;
      paramAIOVideoData = paramAIOVideoData.a;
      continue;
      paramAIOVideoData = paramAIOVideoData.b;
    }
  }
  
  public String a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOVideoData = null;
    }
    while ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      if (paramAIOVideoData.startsWith("/")) {
        break label88;
      }
      return "file:/" + paramAIOVideoData;
      paramAIOVideoData = paramAIOVideoData.a;
      continue;
      paramAIOVideoData = paramAIOVideoData.b;
    }
    label88:
    if (paramAIOVideoData.startsWith("//")) {
      return "file:" + paramAIOVideoData;
    }
    return "file:" + paramAIOVideoData;
  }
  
  public void a(AIOVideoData paramAIOVideoData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOVideoData.d = true;
        return;
      }
      paramAIOVideoData.e = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOVideoData.a = paramString;
      return;
    }
    paramAIOVideoData.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel
 * JD-Core Version:    0.7.0.1
 */