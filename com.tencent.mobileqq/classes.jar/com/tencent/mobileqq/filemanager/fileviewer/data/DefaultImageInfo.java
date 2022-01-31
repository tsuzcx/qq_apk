package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class DefaultImageInfo
  implements FileBrowserModelBase.ImageFileInfo
{
  protected int a;
  protected IFileViewerAdapter a;
  protected String a;
  protected int b;
  protected String b;
  
  public DefaultImageInfo(IFileViewerAdapter paramIFileViewerAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = paramIFileViewerAdapter;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public IFileViewerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  }
  
  public URL a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f();
    if (TextUtils.isEmpty(str))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.h();
      if (str == null)
      {
        a(1);
        return null;
      }
    }
    for (this.jdField_a_of_type_Int = 2; FileUtil.b(str); this.jdField_a_of_type_Int = 1) {
      return AsyncImageView.a(str, -1, -1, new File(str), false, false, false);
    }
    a(1);
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(paramString);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    } while (localFileManagerEntity == null);
    if (localFileManagerEntity.isZipInnerFile)
    {
      if (localFileManagerEntity.status == 2) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if (this.jdField_b_of_type_Int == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isZipInnerFile) {
      return paramString.equalsIgnoreCase(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    }
    return (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) || (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e()));
  }
  
  public void b(String paramString)
  {
    if (FileUtil.b(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("DefaultImageInfo", 2, "setImageOriginPath error  : can not find origin file [path] =  " + paramString);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() < FMConfig.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo
 * JD-Core Version:    0.7.0.1
 */