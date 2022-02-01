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
  private static volatile PTSAppLoader a;
  private static String b;
  private boolean c = false;
  private List<String> d = new ArrayList();
  
  public static PTSAppLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PTSAppLoader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c(String paramString)
  {
    ThreadManager.excute(new PTSAppLoader.2(this, paramString), 128, null, true);
  }
  
  private void d(String paramString)
  {
    this.d.clear();
    String str1 = b(paramString);
    boolean bool2 = FileUtils.fileExists(str1);
    boolean bool3 = PTSOfflineUtil.a(str1, paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("pts_app_config.json");
    localObject1 = ((StringBuilder)localObject1).toString();
    boolean bool4 = PTSOfflineUtil.b((String)localObject1);
    int j = 0;
    boolean bool1;
    if ((bool2) && (bool3) && (bool4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    b = PTSOfflineUtil.c((String)localObject1);
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
            this.d.add(str2);
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
      localStringBuilder1.append(b);
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
      localStringBuilder1.append(this.c);
      localStringBuilder1.append("\n");
      localStringBuilder1.append(", appNameList = ");
      i = j;
      while (i < this.d.size())
      {
        localStringBuilder1.append("[");
        localStringBuilder1.append(i);
        localStringBuilder1.append("]: ");
        localStringBuilder1.append((String)this.d.get(i));
        localStringBuilder1.append("\n");
        i += 1;
      }
      QLog.i("PTSAppLoader", 1, localStringBuilder1.toString());
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = this.d.contains(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isPTSAppReady], appName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isAppExists = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", isAppOfflineDirValid = ");
    localStringBuilder.append(this.c);
    QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
    return (this.c) && (bool);
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.b(paramString));
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
  
  public void b()
  {
    c();
    PTSAppLoader.1 local1 = new PTSAppLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public void c()
  {
    try
    {
      this.c = false;
      d("3978");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String d()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader
 * JD-Core Version:    0.7.0.1
 */