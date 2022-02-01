package com.tencent.mobileqq.richmediabrowser.model;

import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import java.io.File;

public class AIOVideoModel
  implements IDecoratorModel
{
  public Drawable a(AIOVideoData paramAIOVideoData)
  {
    File localFile = a(paramAIOVideoData, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((localFile != null) && (GlobalImageCache.a.get(a(paramAIOVideoData, 0)) != null)) {
      return URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      paramAIOVideoData = URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
      paramAIOVideoData.downloadImediatly();
      return paramAIOVideoData;
    }
    return null;
  }
  
  public File a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        paramAIOVideoData = null;
      } else {
        paramAIOVideoData = paramAIOVideoData.b;
      }
    }
    else {
      paramAIOVideoData = paramAIOVideoData.a;
    }
    if ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      paramAIOVideoData = new File(paramAIOVideoData);
      if (paramAIOVideoData.exists()) {
        return paramAIOVideoData;
      }
    }
    return null;
  }
  
  public String a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        paramAIOVideoData = null;
      } else {
        paramAIOVideoData = paramAIOVideoData.b;
      }
    }
    else {
      paramAIOVideoData = paramAIOVideoData.a;
    }
    if ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      if (!paramAIOVideoData.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(paramAIOVideoData);
        return localStringBuilder.toString();
      }
      if (paramAIOVideoData.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(paramAIOVideoData);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramAIOVideoData);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a(AIOVideoData paramAIOVideoData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        paramAIOVideoData.e = true;
        return;
      }
      paramAIOVideoData.d = true;
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramAIOVideoData.b = paramString;
      return;
    }
    paramAIOVideoData.a = paramString;
  }
  
  public void a(IBaseModelBuilder paramIBaseModelBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel
 * JD-Core Version:    0.7.0.1
 */