package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.os.AsyncTask;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;

final class AIOGalleryUtils$3
  extends AsyncTask<Void, Void, Boolean>
{
  AIOGalleryUtils$3(File paramFile1, Activity paramActivity, File paramFile2, AIOGalleryUtils.OnSavePhoto paramOnSavePhoto) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        ImageUtil.b(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_JavaIoFile);
        ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      }
      if (FileUtil.a(this.b, this.jdField_a_of_type_JavaIoFile))
      {
        ImageUtil.a(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_JavaIoFile);
        ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("savePhoto exception = ");
      localStringBuilder.append(paramVarArgs.getMessage());
      localIBrowserLog.d("AIOGalleryUtils", 4, localStringBuilder.toString());
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    if ((localObject instanceof BaseActivity)) {
      i = ((BaseActivity)localObject).getTitleBarHeight();
    } else {
      i = 0;
    }
    if (paramBoolean.booleanValue()) {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131694891);
    } else {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131694911);
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, (CharSequence)localObject, 0).b(i);
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserUtilsAIOGalleryUtils$OnSavePhoto;
    if (localObject != null) {
      ((AIOGalleryUtils.OnSavePhoto)localObject).c(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.3
 * JD-Core Version:    0.7.0.1
 */