package com.tencent.mobileqq.richmediabrowser.model;

import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOPictureModel
  implements IDecoratorModel
{
  private PictureModel a;
  
  public int a(AIOPictureData paramAIOPictureData, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramAIOPictureData == null) {
        return 0;
      }
      if ((paramAIOPictureData.j != null) && (paramString.contains(paramAIOPictureData.j))) {
        return 1;
      }
      if ((paramAIOPictureData.k != null) && (paramString.contains(paramAIOPictureData.k))) {
        return 2;
      }
      i = j;
      if (paramAIOPictureData.l != null)
      {
        i = j;
        if (paramString.contains(paramAIOPictureData.l)) {
          i = 4;
        }
      }
    }
    return i;
  }
  
  public Drawable a(AIOPictureData paramAIOPictureData)
  {
    File localFile1 = c(paramAIOPictureData, 2);
    File localFile2 = c(paramAIOPictureData, 4);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((localFile1 != null) && (GlobalImageCache.a.get(b(paramAIOPictureData, 2)) != null)) {
      return URLDrawable.getDrawable(b(paramAIOPictureData, 2), localURLDrawableOptions);
    }
    if ((localFile2 != null) && (GlobalImageCache.a.get(b(paramAIOPictureData, 4)) != null)) {
      return URLDrawable.getDrawable(b(paramAIOPictureData, 4), localURLDrawableOptions);
    }
    if (c(paramAIOPictureData, 1) != null)
    {
      paramAIOPictureData = URLDrawable.getDrawable(b(paramAIOPictureData, 1), localURLDrawableOptions);
      paramAIOPictureData.downloadImediatly();
      return paramAIOPictureData;
    }
    return null;
  }
  
  public void a(AIOPictureData paramAIOPictureData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return;
          }
          paramAIOPictureData.p = true;
          return;
        }
        paramAIOPictureData.o = true;
        return;
      }
      paramAIOPictureData.n = true;
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            return;
          }
          paramAIOPictureData.m = paramString;
          return;
        }
        paramAIOPictureData.l = paramString;
        return;
      }
      paramAIOPictureData.k = paramString;
      if (!paramAIOPictureData.w)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOPictureData.j);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOPictureData.j);
          paramString.append("_hd");
          paramAIOPictureData.j = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOPictureData.j = paramString;
    }
  }
  
  public void a(IBaseModelBuilder paramIBaseModelBuilder)
  {
    if ((paramIBaseModelBuilder instanceof PictureModel)) {
      this.a = ((PictureModel)paramIBaseModelBuilder);
    }
  }
  
  public boolean a(AIOPictureData paramAIOPictureData, int paramInt)
  {
    if (paramAIOPictureData == null) {
      return false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return false;
        }
        if (paramAIOPictureData.v == 3) {
          return true;
        }
        return paramAIOPictureData.l.equals("I:N") ^ true;
      }
      return paramAIOPictureData.k.equals("I:N") ^ true;
    }
    return paramAIOPictureData.j.equals("I:N") ^ true;
  }
  
  public String b(AIOPictureData paramAIOPictureData, int paramInt)
  {
    if (paramAIOPictureData == null) {
      return "";
    }
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            str = null;
          } else {
            str = paramAIOPictureData.m;
          }
        }
        else {
          str = paramAIOPictureData.l;
        }
      }
      else {
        str = paramAIOPictureData.k;
      }
    }
    else {
      str = paramAIOPictureData.j;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (paramAIOPictureData.v == 3)
      {
        paramAIOPictureData = new File(str);
        try
        {
          paramAIOPictureData = paramAIOPictureData.toURI().toURL().toString();
          return paramAIOPictureData;
        }
        catch (MalformedURLException paramAIOPictureData)
        {
          paramAIOPictureData.printStackTrace();
          return null;
        }
      }
      if (!str.startsWith("/"))
      {
        paramAIOPictureData = new StringBuilder();
        paramAIOPictureData.append("file:/");
        paramAIOPictureData.append(str);
        return paramAIOPictureData.toString();
      }
      if (str.startsWith("//"))
      {
        paramAIOPictureData = new StringBuilder();
        paramAIOPictureData.append("file:");
        paramAIOPictureData.append(str);
        return paramAIOPictureData.toString();
      }
      paramAIOPictureData = new StringBuilder();
      paramAIOPictureData.append("file:");
      paramAIOPictureData.append(str);
      return paramAIOPictureData.toString();
    }
    return null;
  }
  
  public File c(AIOPictureData paramAIOPictureData, int paramInt)
  {
    if (paramAIOPictureData == null) {
      return null;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            paramAIOPictureData = null;
          } else {
            paramAIOPictureData = paramAIOPictureData.m;
          }
        }
        else {
          paramAIOPictureData = paramAIOPictureData.l;
        }
      }
      else {
        paramAIOPictureData = paramAIOPictureData.k;
      }
    }
    else {
      paramAIOPictureData = paramAIOPictureData.j;
    }
    if ((paramAIOPictureData != null) && (!paramAIOPictureData.equals("I:N")))
    {
      paramAIOPictureData = new File(paramAIOPictureData);
      if (paramAIOPictureData.exists()) {
        return paramAIOPictureData;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel
 * JD-Core Version:    0.7.0.1
 */