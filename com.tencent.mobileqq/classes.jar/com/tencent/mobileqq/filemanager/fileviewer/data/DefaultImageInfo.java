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
  protected IFileViewerAdapter a;
  protected int b;
  protected int c;
  protected String d;
  protected String e;
  protected int f;
  
  public DefaultImageInfo(IFileViewerAdapter paramIFileViewerAdapter)
  {
    this.a = paramIFileViewerAdapter;
    this.b = 0;
    this.c = 0;
    this.f = -1;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = paramString;
      this.a.a(paramString);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((IFileViewerAdapter)localObject).r();
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
    if (this.c == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public URL b()
  {
    String str = this.a.l();
    if (TextUtils.isEmpty(str))
    {
      str = this.a.p();
      if (str == null)
      {
        a(1);
        return null;
      }
      this.b = 2;
    }
    else
    {
      this.b = 1;
    }
    if (FileUtil.b(str))
    {
      if (this.b == 1) {
        return AsyncImageView.a(str);
      }
      return AsyncImageView.a(str, -1, -1, new File(str), false, false, false);
    }
    a(1);
    return null;
  }
  
  public void b(String paramString)
  {
    if (FileUtil.b(paramString))
    {
      this.e = paramString;
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
  
  public String c()
  {
    return this.e;
  }
  
  public boolean c(String paramString)
  {
    if ((this.a.r() != null) && (this.a.r().isZipInnerFile)) {
      return paramString.equalsIgnoreCase(String.valueOf(this.a.a()));
    }
    return (paramString.equalsIgnoreCase(this.a.h())) || (paramString.equalsIgnoreCase(this.a.j()));
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    if (this.f == -1) {}
    try
    {
      String str = this.a.l();
      if (FileUtil.b(str))
      {
        this.f = JpegExifReader.readOrientation(str);
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
    this.f = 0;
    return this.f;
  }
  
  public boolean f()
  {
    return this.a.c() < ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize();
  }
  
  public String g()
  {
    String str2 = this.a.l();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = this.a.p();
      if (str1 == null) {
        return "";
      }
      this.b = 2;
    }
    return str1;
  }
  
  public IFileViewerAdapter h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo
 * JD-Core Version:    0.7.0.1
 */