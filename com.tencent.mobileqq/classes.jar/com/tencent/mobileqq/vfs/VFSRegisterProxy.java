package com.tencent.mobileqq.vfs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mm.vfs.FileSchemeResolver;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.Editor;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class VFSRegisterProxy
{
  private String a;
  private String b;
  @Nullable
  private VFSReportCallback c;
  
  public static VFSRegisterProxy a()
  {
    return VFSRegisterProxy.SingletonHolder.a;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("publishOnEditorCommit() is called. isMainProcess = ");
      localStringBuilder.append(paramBoolean1);
      QLog.d("VFSRegisterProxy", 1, localStringBuilder.toString());
      FileSystemManager.instance().publishOnEditorCommit(paramBoolean1);
    }
  }
  
  private void b(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.isDirectory())
    {
      paramString = new File(VFSAssistantUtils.getSDKPrivatePath(paramString));
      Object localObject = paramString.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists())) {
        ((File)localObject).mkdirs();
      }
      if ((localFile.renameTo(paramString)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("executeLightMigrate Fast moved '");
        ((StringBuilder)localObject).append(localFile);
        ((StringBuilder)localObject).append("' -> '");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("'");
        QLog.i("VFSRegisterProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private List<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localArrayList.add(localStringBuilder.toString());
    return localArrayList;
  }
  
  private void c(Context paramContext, VFSReportCallback paramVFSReportCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramContext, paramVFSReportCallback, paramBoolean1, paramBoolean2);
    FileSystemManager.Editor localEditor = FileSystemManager.instance().edit();
    localEditor.scheme("", FileSchemeResolver.instance());
    localEditor.scheme("file", FileSchemeResolver.instance());
    localEditor.scheme(null, FileSchemeResolver.instance());
    Iterator localIterator = VFSSourcePathConfig.a.iterator();
    while (localIterator.hasNext())
    {
      paramVFSReportCallback = (String)localIterator.next();
      if (!TextUtils.isEmpty(paramVFSReportCallback))
      {
        if ((!paramVFSReportCallback.startsWith("/")) && (paramVFSReportCallback.indexOf(":") <= 0))
        {
          paramContext = new StringBuilder();
          paramContext.append(c());
          paramContext.append(File.separator);
          paramContext.append(paramVFSReportCallback);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = paramVFSReportCallback;
        }
        String str = VFSAssistantUtils.getSDKPrivatePath(paramVFSReportCallback);
        Object localObject = new File(str).getParentFile();
        if ((localObject != null) && (!((File)localObject).exists())) {
          ((File)localObject).mkdirs();
        }
        localObject = new MigrationFileSystem(true, new NativeFileSystem(str, false), new FileSystem[] { new NativeFileSystem(paramContext, false) });
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initConfig filesystem key is ");
          localStringBuilder.append(paramVFSReportCallback);
          QLog.d("VFSRegisterProxy", 2, localStringBuilder.toString());
        }
        localEditor.install(paramVFSReportCallback, (FileSystem)localObject).mount(str, paramVFSReportCallback).mount(paramContext, paramVFSReportCallback);
      }
    }
    localEditor.commit();
  }
  
  private boolean e()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("StepUpdate", 4);
    boolean bool = false;
    if (((SharedPreferences)localObject).getInt("vfs_version", 0) < 10) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initConfig checkSP is called, return val = ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("VFSRegisterProxy", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void f()
  {
    BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).edit().putInt("vfs_version", 10).apply();
    QLog.d("VFSRegisterProxy", 1, "initConfig updateSP is called, version = 10");
  }
  
  private boolean g()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("VFS_Config_Register_Proxy", 4).getBoolean("state_account_registered", true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFirstRegisterAccount is called, return val = ");
      localStringBuilder.append(bool);
      QLog.d("VFSRegisterProxy", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void h()
  {
    BaseApplication.getContext().getSharedPreferences("VFS_Config_Register_Proxy", 4).edit().putBoolean("state_account_registered", false).apply();
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        File[] arrayOfFile = new File(AppConstants.SDCARD_PATH).listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = arrayOfFile.length;
        i = 0;
        if (i < j)
        {
          localFile = arrayOfFile[i];
          str = localFile.getName().trim();
          int k = str.length();
          if (k >= 5) {
            if (k <= 15) {}
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        File localFile;
        String str;
        localException.printStackTrace();
      }
      try
      {
        Long.parseLong(str);
        localFile = new File(localFile, "ppt");
        if (localFile.exists()) {
          b(localFile.getAbsolutePath());
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        continue;
      }
      i += 1;
    }
  }
  
  public void a(Context paramContext, VFSReportCallback paramVFSReportCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) || (!paramBoolean1)) {
      b(paramContext, paramVFSReportCallback, paramBoolean1, paramBoolean2);
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig start!");
    try
    {
      if (e())
      {
        c(paramContext, paramVFSReportCallback, paramBoolean1, paramBoolean2);
        if (!FileSystemManager.instance().isValidConfigFile(paramContext)) {
          c(paramContext, paramVFSReportCallback, paramBoolean1, paramBoolean2);
        }
        if (FileSystemManager.instance().isValidConfigFile(paramContext)) {
          f();
        }
        d();
        i();
      }
    }
    catch (Throwable paramContext)
    {
      paramVFSReportCallback = this.c;
      if (paramVFSReportCallback != null) {
        paramVFSReportCallback.reportError(new Throwable("FileSystemManager proxy", paramContext));
      }
      QLog.e("VFSRegisterProxy", 1, paramContext, new Object[0]);
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig end!");
  }
  
  public void a(String paramString)
  {
    if (g())
    {
      Object localObject = c(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("registerAccountPath is called later! account relate length = ");
        paramString.append(((List)localObject).size());
        QLog.d("VFSRegisterProxy", 2, paramString.toString());
      }
      paramString = FileSystemManager.instance().edit();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = VFSAssistantUtils.getSDKPrivatePath(str1);
        File localFile = new File(str2).getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        paramString.install(str1, new MigrationFileSystem(true, new NativeFileSystem(str2, false), new FileSystem[] { new NativeFileSystem(str1, false) })).mount(str2, str1).mount(str1, str1);
      }
      paramString.commit();
      h();
    }
    paramString = this.c;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  @Nullable
  public final String b()
  {
    if (this.a == null)
    {
      File localFile = BaseApplication.getContext().getExternalCacheDir();
      if (localFile != null) {
        this.a = localFile.getParent();
      }
    }
    return this.a;
  }
  
  public void b(Context paramContext, VFSReportCallback paramVFSReportCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramVFSReportCallback;
    FileSystemManager.setContext(paramContext);
    if (paramBoolean1) {
      FileSystemManager.setStatisticsCallback(this.c);
    }
    a(paramBoolean1, paramBoolean2);
  }
  
  public final String c()
  {
    if (this.b == null) {
      this.b = Environment.getExternalStorageDirectory().getPath();
    }
    return this.b;
  }
  
  public final void d()
  {
    Iterator localIterator = VFSSourcePathConfig.b.iterator();
    while (localIterator.hasNext()) {
      b((String)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.VFSRegisterProxy
 * JD-Core Version:    0.7.0.1
 */