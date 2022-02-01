package com.tencent.mobileqq.kandian.biz.pts.loaders;

import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PTSAppLoader
{
  private static volatile PTSAppLoader jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSAppLoader;
  private static String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PTSAppLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSAppLoader == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSAppLoader == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSAppLoader = new PTSAppLoader();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSAppLoader;
  }
  
  private void a(String paramString)
  {
    ThreadManager.excute(new PTSAppLoader.2(this, paramString), 128, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = a(paramString);
    boolean bool2 = FileUtils.fileExists(str1);
    boolean bool3 = PTSOfflineUtil.a(str1, paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("pts_app_config.json");
    localObject1 = ((StringBuilder)localObject1).toString();
    boolean bool4 = PTSOfflineUtil.a((String)localObject1);
    int j = 0;
    boolean bool1;
    if ((bool2) && (bool3) && (bool4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    jdField_a_of_type_JavaLangString = PTSOfflineUtil.b((String)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("pages");
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = new File((String)localObject2);
      int i;
      StringBuilder localStringBuilder2;
      if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
      {
        localObject2 = ((File)localObject2).listFiles();
        int k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localStringBuilder2 = localObject2[i];
          String str2 = localStringBuilder2.getName();
          if ((localStringBuilder2.isDirectory()) && (!TextUtils.isEmpty(str2))) {
            this.jdField_a_of_type_JavaUtilList.add(str2);
          }
          i += 1;
        }
      }
      StringBuilder localStringBuilder1;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[checkPTSApp], e = ");
      localStringBuilder2.append(localException);
      QLog.e("PTSAppLoader", 1, localStringBuilder2.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[checkPTSApp], bid = ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", appPath = ");
      localStringBuilder1.append(str1);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", ptsAppVersion = ");
      localStringBuilder1.append(jdField_a_of_type_JavaLangString);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", isAppExists = ");
      localStringBuilder1.append(bool2);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", isAppValid = ");
      localStringBuilder1.append(bool3);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", configPath = ");
      localStringBuilder1.append((String)localObject1);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", isAppVersionValid = ");
      localStringBuilder1.append(bool4);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", isAppOfflineDirValid = ");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", appNameList = ");
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localStringBuilder1.append("[");
        localStringBuilder1.append(i);
        localStringBuilder1.append("]: ");
        localStringBuilder1.append((String)this.jdField_a_of_type_JavaUtilList.get(i));
        localStringBuilder1.append("\n");
        i += 1;
      }
      QLog.i("PTSAppLoader", 1, localStringBuilder1.toString());
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.a(paramString));
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getPTSAppDownloadPath], bid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", path = ");
    localStringBuilder.append((String)localObject);
    QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public void a()
  {
    b();
    PTSAppLoader.1 local1 = new PTSAppLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.contains(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isPTSAppReady], appName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isAppExists = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", isAppOfflineDirValid = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
    return (this.jdField_a_of_type_Boolean) && (bool);
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      b("3978");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader
 * JD-Core Version:    0.7.0.1
 */