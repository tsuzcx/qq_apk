package com.tencent.mobileqq.richmediabrowser.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import java.io.File;

public class AIOFileVideoModel
  implements IDecoratorModel
{
  private void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    paramAIOFileVideoData = new AIOFileVideoModel.1(this, paramContext, paramAIOFileVideoData, paramAIOFileVideoView);
    FMDialogUtil.a(paramContext, paramContext.getString(2131718247), paramContext.getString(2131718248), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (a(paramAIOFileVideoData)) {
      return false;
    }
    if (paramAIOFileVideoData != null)
    {
      if (paramAIOFileVideoData.g) {
        return false;
      }
      if (!AppNetConnInfo.isMobileConn()) {
        return false;
      }
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.e)) {
        return true;
      }
      if (paramAIOFileVideoData.jdField_c_of_type_Long > 1048576L) {
        return true;
      }
    }
    return false;
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((localFile != null) && (GlobalImageCache.a.get(a(paramAIOFileVideoData)) != null)) {
      return URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      paramAIOFileVideoData = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
      paramAIOFileVideoData.downloadImediatly();
      return paramAIOFileVideoData;
    }
    return null;
  }
  
  public VideoPlayMedioInfo a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.jdField_d_of_type_JavaLangString };
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList = paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList;
    localVideoPlayMedioInfo.jdField_a_of_type_Boolean = (a(paramAIOFileVideoData) ^ true);
    String str;
    if (localVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
      str = "";
    } else {
      str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString;
    }
    localVideoPlayMedioInfo.jdField_a_of_type_JavaLangString = str;
    localVideoPlayMedioInfo.jdField_c_of_type_Long = paramAIOFileVideoData.progress;
    localVideoPlayMedioInfo.jdField_b_of_type_Boolean = true;
    localVideoPlayMedioInfo.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
    localVideoPlayMedioInfo.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
    localVideoPlayMedioInfo.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
    localVideoPlayMedioInfo.e = paramBoolean;
    localVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle;
    return localVideoPlayMedioInfo;
  }
  
  public File a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (FileUtils.fileExistsAndNotEmpty(paramAIOFileVideoData.b))) {
      return new File(paramAIOFileVideoData.b);
    }
    return null;
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (!TextUtils.isEmpty(paramAIOFileVideoData.b)))
    {
      if (!paramAIOFileVideoData.b.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(paramAIOFileVideoData.b);
        return localStringBuilder.toString();
      }
      if (paramAIOFileVideoData.b.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(paramAIOFileVideoData.b);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramAIOFileVideoData.b);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    if (c(paramAIOFileVideoData))
    {
      if (((IFileDepend)QRoute.api(IFileDepend.class)).doWithWifiChecked(paramContext, false, new AIOFileVideoModel.2(this, paramAIOFileVideoView))) {
        b(paramAIOFileVideoData, paramContext, paramAIOFileVideoView);
      }
    }
    else {
      paramAIOFileVideoView.m();
    }
  }
  
  public void a(IBaseModelBuilder paramIBaseModelBuilder) {}
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if (paramAIOFileVideoData != null)
    {
      if ((TextUtils.isEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle != null)) {
        paramAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle.getString("savepath");
      }
      if (FileUtils.fileExistsAndNotEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString))
      {
        paramAIOFileVideoData.jdField_d_of_type_Boolean = true;
        return true;
      }
    }
    if ((paramAIOFileVideoData != null) && (paramAIOFileVideoData.jdField_d_of_type_JavaLangString == null)) {
      paramAIOFileVideoData.jdField_d_of_type_Boolean = false;
    }
    return false;
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, IBrowserProvider paramIBrowserProvider)
  {
    if ((paramAIOFileVideoData != null) && (!a(paramAIOFileVideoData)))
    {
      if (!(paramIBrowserProvider instanceof IProvider)) {
        return false;
      }
      if ((paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramAIOFileVideoData.jdField_d_of_type_JavaLangString))) {
        return false;
      }
      ((IProvider)paramIBrowserProvider).a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
      return true;
    }
    return false;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return TextUtils.isEmpty(paramAIOFileVideoData.f) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel
 * JD-Core Version:    0.7.0.1
 */