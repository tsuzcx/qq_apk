package com.tencent.mobileqq.richmediabrowser.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.richmediabrowser.PeakProcessProvider;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class AIOFileVideoModel
  extends BrowserBaseModel
{
  private void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    paramAIOFileVideoData = new AIOFileVideoModel.1(this, paramContext, paramAIOFileVideoData, paramAIOFileVideoView);
    FMDialogUtil.a(paramContext, paramContext.getString(2131692609), paramContext.getString(2131692611), paramAIOFileVideoData);
  }
  
  private boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (a(paramAIOFileVideoData)) {}
    do
    {
      do
      {
        return false;
      } while ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.g) || (!FileManagerUtil.a()));
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_a_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_c_of_type_Long > 0L) && (paramAIOFileVideoData.jdField_c_of_type_Long > paramAIOFileVideoData.e)) {
        return true;
      }
    } while (paramAIOFileVideoData.jdField_c_of_type_Long <= 1048576L);
    return true;
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((localFile != null) && (GlobalImageCache.a.get(a(paramAIOFileVideoData)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOFileVideoData = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    paramAIOFileVideoData.downloadImediatly();
    return paramAIOFileVideoData;
  }
  
  public VideoPlayMedioInfo a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramAIOFileVideoData.jdField_d_of_type_JavaLangString };
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList = paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localVideoPlayMedioInfo.jdField_a_of_type_Boolean = bool;
    if (localVideoPlayMedioInfo.jdField_a_of_type_Boolean) {}
    for (String str = "";; str = paramAIOFileVideoData.jdField_c_of_type_JavaLangString)
    {
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
  }
  
  public File a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (!FileUtil.b(paramAIOFileVideoData.b))) {
      return null;
    }
    return new File(paramAIOFileVideoData.b);
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (TextUtils.isEmpty(paramAIOFileVideoData.b))) {
      return "";
    }
    if (!paramAIOFileVideoData.b.startsWith("/")) {
      return "file:/" + paramAIOFileVideoData.b;
    }
    if (paramAIOFileVideoData.b.startsWith("//")) {
      return "file:" + paramAIOFileVideoData.b;
    }
    return "file:" + paramAIOFileVideoData.b;
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    if (c(paramAIOFileVideoData))
    {
      if (QFileUtils.a(paramContext, false, new AIOFileVideoModel.2(this, paramAIOFileVideoView))) {
        b(paramAIOFileVideoData, paramContext, paramAIOFileVideoView);
      }
      return;
    }
    paramAIOFileVideoView.i();
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if (paramAIOFileVideoData != null)
    {
      if ((TextUtils.isEmpty(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle != null)) {
        paramAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle.getString("savepath");
      }
      if (FileUtils.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString))
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
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, PeakProcessProvider paramPeakProcessProvider)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (paramPeakProcessProvider == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.jdField_d_of_type_JavaLangString)) && (paramAIOFileVideoData.jdField_a_of_type_JavaUtilArrayList != null)) {
      return false;
    }
    paramPeakProcessProvider.downloadMedia(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel
 * JD-Core Version:    0.7.0.1
 */