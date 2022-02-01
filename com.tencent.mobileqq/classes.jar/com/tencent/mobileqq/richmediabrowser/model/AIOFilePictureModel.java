package com.tencent.mobileqq.richmediabrowser.model;

import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.richmediabrowser.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import java.io.File;
import org.json.JSONObject;

public class AIOFilePictureModel
  implements IDecoratorModel
{
  public Drawable a(AIOFilePictureData paramAIOFilePictureData)
  {
    File localFile1 = a(paramAIOFilePictureData, 18);
    File localFile2 = a(paramAIOFilePictureData, 20);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    URLDrawable localURLDrawable = null;
    if ((localFile1 != null) && (GlobalImageCache.a.get(a(paramAIOFilePictureData, 18)) != null))
    {
      if (URLDrawableHelper.a(localFile1.getAbsolutePath()) != 0) {
        return null;
      }
      return URLDrawable.getDrawable(a(paramAIOFilePictureData, 18), localURLDrawableOptions);
    }
    if ((localFile2 != null) && (GlobalImageCache.a.get(a(paramAIOFilePictureData, 20)) != null))
    {
      if (URLDrawableHelper.a(localFile2.getAbsolutePath()) != 0) {
        return null;
      }
      return URLDrawable.getDrawable(a(paramAIOFilePictureData, 20), localURLDrawableOptions);
    }
    if (a(paramAIOFilePictureData, 16) != null) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOFilePictureData, 16), localURLDrawableOptions);
    }
    return localURLDrawable;
  }
  
  public File a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    if (paramAIOFilePictureData == null) {
      return null;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          paramAIOFilePictureData = null;
        } else {
          paramAIOFilePictureData = paramAIOFilePictureData.c;
        }
      }
      else {
        paramAIOFilePictureData = paramAIOFilePictureData.b;
      }
    }
    else {
      paramAIOFilePictureData = paramAIOFilePictureData.a;
    }
    if ((paramAIOFilePictureData != null) && (!paramAIOFilePictureData.equals("I:N")))
    {
      paramAIOFilePictureData = new File(paramAIOFilePictureData);
      if (paramAIOFilePictureData.exists()) {
        return paramAIOFilePictureData;
      }
    }
    return null;
  }
  
  public String a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    if (paramAIOFilePictureData == null) {
      return null;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          paramAIOFilePictureData = null;
        } else {
          paramAIOFilePictureData = paramAIOFilePictureData.c;
        }
      }
      else {
        paramAIOFilePictureData = paramAIOFilePictureData.b;
      }
    }
    else {
      paramAIOFilePictureData = paramAIOFilePictureData.a;
    }
    if ((paramAIOFilePictureData != null) && (!paramAIOFilePictureData.equals("I:N")))
    {
      if (!paramAIOFilePictureData.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(paramAIOFilePictureData);
        return localStringBuilder.toString();
      }
      if (paramAIOFilePictureData.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(paramAIOFilePictureData);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramAIOFilePictureData);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, int paramInt, String paramString)
  {
    if (paramAIOFilePictureData != null)
    {
      if (paramString == null) {
        return;
      }
      if ("I:E".equals(paramString))
      {
        if (paramInt != 16)
        {
          if (paramInt != 18)
          {
            if (paramInt != 20) {
              return;
            }
            paramAIOFilePictureData.e = true;
            return;
          }
          paramAIOFilePictureData.d = true;
          return;
        }
        paramAIOFilePictureData.f = true;
        return;
      }
      if (paramInt != 16)
      {
        if (paramInt != 18)
        {
          if (paramInt != 20) {
            return;
          }
          paramAIOFilePictureData.c = paramString;
          return;
        }
        paramAIOFilePictureData.b = paramString;
        return;
      }
      paramAIOFilePictureData.a = paramString;
    }
  }
  
  public void a(IBaseModelBuilder paramIBaseModelBuilder) {}
  
  public boolean a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    if (paramAIOFilePictureData == null) {
      return false;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18) {
        return paramInt == 20;
      }
      return paramAIOFilePictureData.b.equals("I:N") ^ true;
    }
    return paramAIOFilePictureData.a.equals("I:N") ^ true;
  }
  
  public void b(AIOFilePictureData paramAIOFilePictureData, int paramInt, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str2 = "";
    j = 0;
    localObject = str2;
    i = j;
    if (!bool) {
      str1 = str2;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = str2;
      str1 = str2;
      if (localJSONObject.has("errorType"))
      {
        str1 = str2;
        paramString = localJSONObject.getString("errorType");
      }
      localObject = paramString;
      i = j;
      str1 = paramString;
      if (localJSONObject.has("errorCode"))
      {
        str1 = paramString;
        i = localJSONObject.getInt("errorCode");
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject = str1;
        i = j;
      }
    }
    if (paramInt == 18)
    {
      if ((localObject != null) && (((String)localObject).equals("thumb_download"))) {
        paramAIOFilePictureData.g = i;
      }
    }
    else if ((paramInt == 16) && (localObject != null) && (((String)localObject).equals("thumb_download"))) {
      paramAIOFilePictureData.g = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel
 * JD-Core Version:    0.7.0.1
 */