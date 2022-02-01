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
      if ((paramAIOPictureData.a != null) && (paramString.contains(paramAIOPictureData.a))) {
        return 1;
      }
      if ((paramAIOPictureData.b != null) && (paramString.contains(paramAIOPictureData.b))) {
        return 2;
      }
      i = j;
      if (paramAIOPictureData.jdField_c_of_type_JavaLangString != null)
      {
        i = j;
        if (paramString.contains(paramAIOPictureData.jdField_c_of_type_JavaLangString)) {
          i = 4;
        }
      }
    }
    return i;
  }
  
  public Drawable a(AIOPictureData paramAIOPictureData)
  {
    File localFile1 = a(paramAIOPictureData, 2);
    File localFile2 = a(paramAIOPictureData, 4);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((localFile1 != null) && (GlobalImageCache.a.get(a(paramAIOPictureData, 2)) != null)) {
      return URLDrawable.getDrawable(a(paramAIOPictureData, 2), localURLDrawableOptions);
    }
    if ((localFile2 != null) && (GlobalImageCache.a.get(a(paramAIOPictureData, 4)) != null)) {
      return URLDrawable.getDrawable(a(paramAIOPictureData, 4), localURLDrawableOptions);
    }
    if (a(paramAIOPictureData, 1) != null)
    {
      paramAIOPictureData = URLDrawable.getDrawable(a(paramAIOPictureData, 1), localURLDrawableOptions);
      paramAIOPictureData.downloadImediatly();
      return paramAIOPictureData;
    }
    return null;
  }
  
  public File a(AIOPictureData paramAIOPictureData, int paramInt)
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
            paramAIOPictureData = paramAIOPictureData.jdField_d_of_type_JavaLangString;
          }
        }
        else {
          paramAIOPictureData = paramAIOPictureData.jdField_c_of_type_JavaLangString;
        }
      }
      else {
        paramAIOPictureData = paramAIOPictureData.b;
      }
    }
    else {
      paramAIOPictureData = paramAIOPictureData.a;
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
  
  public String a(AIOPictureData paramAIOPictureData, int paramInt)
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
            str = paramAIOPictureData.jdField_d_of_type_JavaLangString;
          }
        }
        else {
          str = paramAIOPictureData.jdField_c_of_type_JavaLangString;
        }
      }
      else {
        str = paramAIOPictureData.b;
      }
    }
    else {
      str = paramAIOPictureData.a;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (paramAIOPictureData.jdField_c_of_type_Int == 3)
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
          paramAIOPictureData.f = true;
          return;
        }
        paramAIOPictureData.e = true;
        return;
      }
      paramAIOPictureData.jdField_d_of_type_Boolean = true;
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
          paramAIOPictureData.jdField_d_of_type_JavaLangString = paramString;
          return;
        }
        paramAIOPictureData.jdField_c_of_type_JavaLangString = paramString;
        return;
      }
      paramAIOPictureData.b = paramString;
      if (!paramAIOPictureData.h)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOPictureData.a);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOPictureData.a);
          paramString.append("_hd");
          paramAIOPictureData.a = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOPictureData.a = paramString;
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
        if (paramAIOPictureData.jdField_c_of_type_Int == 3) {
          return true;
        }
        return paramAIOPictureData.jdField_c_of_type_JavaLangString.equals("I:N") ^ true;
      }
      return paramAIOPictureData.b.equals("I:N") ^ true;
    }
    return paramAIOPictureData.a.equals("I:N") ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel
 * JD-Core Version:    0.7.0.1
 */