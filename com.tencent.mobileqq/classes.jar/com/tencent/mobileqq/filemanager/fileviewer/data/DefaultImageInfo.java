package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
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
  protected int c;
  
  public DefaultImageInfo(IFileViewerAdapter paramIFileViewerAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = paramIFileViewerAdapter;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public IFileViewerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
      this.jdField_a_of_type_Int = 2;
    }
    else
    {
      this.jdField_a_of_type_Int = 1;
    }
    if (FileUtil.a(str))
    {
      if (this.jdField_a_of_type_Int == 1) {
        return AsyncImageView.a(str);
      }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((IFileViewerAdapter)localObject).a();
    if (localObject == null) {
      return false;
    }
    if (((FileManagerEntity)localObject).isZipInnerFile)
    {
      if (((FileManagerEntity)localObject).status == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.jdField_b_of_type_Int == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isZipInnerFile)) {
      return paramString.equalsIgnoreCase(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    }
    return (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) || (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e()));
  }
  
  public int b()
  {
    if (this.c == -1) {}
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f();
      if (FileUtil.a(str))
      {
        this.c = JpegExifReader.readOrientation(str);
        break label43;
      }
      return 1;
    }
    catch (Exception localException)
    {
      label38:
      label43:
      break label38;
    }
    this.c = 0;
    return this.c;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.h();
      if (str1 == null) {
        return "";
      }
      this.jdField_a_of_type_Int = 2;
    }
    return str1;
  }
  
  public void b(String paramString)
  {
    if (FileUtil.a(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImageOriginPath error  : can not find origin file [path] =  ");
      localStringBuilder.append(paramString);
      QLog.i("DefaultImageInfo", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() < ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo
 * JD-Core Version:    0.7.0.1
 */