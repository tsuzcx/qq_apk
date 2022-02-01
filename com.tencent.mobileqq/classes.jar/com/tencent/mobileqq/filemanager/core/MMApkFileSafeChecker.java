package com.tencent.mobileqq.filemanager.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.util.TuringSdkManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class MMApkFileSafeChecker
{
  static int a = 1;
  QQAppInterface b;
  Map<String, MMApkFileSafeChecker.CheckTask> c = new HashMap();
  private Executor d;
  private Map<String, MMApkFileSafeChecker.FileDigestInfo> e = new HashMap();
  private MMApkFileSafeChecker.ISafeCheckerProxy f = new MMApkFileSafeChecker.1(this);
  private boolean g = true;
  private boolean h = true;
  
  public MMApkFileSafeChecker(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private MMApkFileSafeChecker.CheckTask a(String paramString1, String paramString2, Signature[] paramArrayOfSignature, long paramLong, MMApkFileSafeChecker.FileBusiInfo paramFileBusiInfo, MMApkFileSafeChecker.ISafeCheckerProxy paramISafeCheckerProxy)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. filePath is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. pkgName is null");
      return null;
    }
    if (paramLong == 0L)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileSize is 0");
      return null;
    }
    if (paramFileBusiInfo == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileBusiInfo is null");
      return null;
    }
    if (paramISafeCheckerProxy == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. safeCheckerProxy is null");
      return null;
    }
    return new MMApkFileSafeChecker.CheckTask(this, paramString1, paramString2, paramArrayOfSignature, paramLong, paramFileBusiInfo, paramISafeCheckerProxy);
  }
  
  private void a(String paramString, MMApkFileSafeChecker.CheckTask paramCheckTask)
  {
    if (this.c.containsKey(paramString)) {
      return;
    }
    this.c.put(paramString, paramCheckTask);
    paramCheckTask = new StringBuilder();
    paramCheckTask.append("[MMApkCheck] addTask size:");
    paramCheckTask.append(this.c.size());
    paramCheckTask.append(" filePath:");
    paramCheckTask.append(paramString);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, paramCheckTask.toString());
  }
  
  private void a(String paramString, MMApkFileSafeChecker.FileDigestInfo paramFileDigestInfo)
  {
    try
    {
      if (this.e.size() > 50)
      {
        long l = 9223372036854775807L;
        String str = "";
        Iterator localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((MMApkFileSafeChecker.FileDigestInfo)localEntry.getValue()).d < l)
          {
            l = ((MMApkFileSafeChecker.FileDigestInfo)localEntry.getValue()).d;
            str = (String)localEntry.getKey();
          }
        }
        if (!TextUtils.isEmpty(str)) {
          this.e.remove(str);
        }
      }
      this.e.put(paramString, paramFileDigestInfo);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, MMApkFileSafeChecker.ICheckResult paramICheckResult)
  {
    paramString = (MMApkFileSafeChecker.CheckTask)this.c.get(paramString);
    if (paramString != null) {
      paramString.a(paramICheckResult);
    }
  }
  
  private boolean a(String paramString)
  {
    return this.c.containsKey(paramString);
  }
  
  private boolean a(String paramString, MMApkFileSafeChecker.FileBusiInfo paramFileBusiInfo, MMApkFileSafeChecker.ICheckResult paramICheckResult)
  {
    if (5 != FileManagerUtil.c(paramString)) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[MMApkCheck] startCheckLocalApk. filePath=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" binfo:");
    ((StringBuilder)localObject1).append(paramFileBusiInfo.toString());
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    if (a(paramString))
    {
      QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. is checking");
      a(paramString, paramICheckResult);
      return true;
    }
    if (!FileUtil.d(paramString))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. file not exists");
      return false;
    }
    long l = FileManagerUtil.h(paramString);
    localObject1 = null;
    try
    {
      Object localObject2 = BaseApplicationImpl.getContext().getBaseContext().getPackageManager().getPackageArchiveInfo(paramString, 64);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).signatures;
      }
      if (localObject2 != null) {
        localObject2 = ((PackageInfo)localObject2).packageName;
      } else {
        localObject2 = "";
      }
      paramFileBusiInfo = a(paramString, (String)localObject2, (Signature[])localObject1, l, paramFileBusiInfo, this.f);
      if (paramFileBusiInfo == null) {
        return false;
      }
      paramFileBusiInfo.a(paramICheckResult);
      a(paramString, paramFileBusiInfo);
      paramFileBusiInfo.a();
      return true;
    }
    catch (Exception paramString)
    {
      paramFileBusiInfo = new StringBuilder();
      paramFileBusiInfo.append("[MMApkCheck] startCheckLocalApk. exception:");
      paramFileBusiInfo.append(paramString.toString());
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, paramFileBusiInfo.toString());
    }
    return false;
  }
  
  private boolean a(String paramString, MMApkFileSafeChecker.IGetDigestResult paramIGetDigestResult)
  {
    MMApkFileSafeChecker.FileDigestInfo localFileDigestInfo = d(paramString);
    if ((localFileDigestInfo != null) && (localFileDigestInfo.a != null) && (localFileDigestInfo.b != null))
    {
      if (FileUtil.f(paramString) == localFileDigestInfo.c)
      {
        paramIGetDigestResult.a(true, localFileDigestInfo);
        return true;
      }
      c(paramString);
    }
    f();
    this.d.execute(new MMApkFileSafeChecker.6(this, paramString, paramIGetDigestResult));
    return true;
  }
  
  private void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    MMApkFileSafeChecker.FileBusiInfo localFileBusiInfo = new MMApkFileSafeChecker.FileBusiInfo(this, null);
    localFileBusiInfo.b = this.b.getCurrentAccountUin();
    localFileBusiInfo.a = 2;
    localFileBusiInfo.d = String.valueOf(paramLong);
    localFileBusiInfo.f = paramItem.FilePath;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] checkLocalApk. Item.Id=");
    localStringBuilder.append(paramItem.getId());
    localStringBuilder.append(" binfo:");
    localStringBuilder.append(localFileBusiInfo.toString());
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    a(paramItem.LocalFile, localFileBusiInfo, new MMApkFileSafeChecker.5(this, paramItem, paramLong));
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    MMApkFileSafeChecker.FileBusiInfo localFileBusiInfo = new MMApkFileSafeChecker.FileBusiInfo(this, null);
    localFileBusiInfo.b = this.b.getCurrentAccountUin();
    localFileBusiInfo.a = 1;
    if ((paramFileManagerEntity.peerType != 0) && (paramFileManagerEntity.peerType != 3) && (paramFileManagerEntity.peerType != 1000))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk err. is no buddy apk");
      return;
    }
    localFileBusiInfo.c = paramFileManagerEntity.peerUin;
    localFileBusiInfo.e = paramFileManagerEntity.Uuid;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] interCheckLocalApk. nSessionId=");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append(" binfo:");
    localStringBuilder.append(localFileBusiInfo.toString());
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    a(paramFileManagerEntity.strFilePath, localFileBusiInfo, new MMApkFileSafeChecker.3(this, paramFileManagerEntity));
  }
  
  private void b(String paramString)
  {
    this.c.remove(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] remTask size:");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(" filePath:");
    localStringBuilder.append(paramString);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private void c(String paramString)
  {
    try
    {
      this.e.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private MMApkFileSafeChecker.FileDigestInfo d(String paramString)
  {
    try
    {
      paramString = (MMApkFileSafeChecker.FileDigestInfo)this.e.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean e()
  {
    return ((IQFileConfigManager)this.b.getRuntimeService(IQFileConfigManager.class, "")).isMMApkFileCheckEnable();
  }
  
  private void f()
  {
    if (this.d == null)
    {
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] start DigestGet pool");
      try
      {
        ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
        localThreadPoolParams.priority = 5;
        localThreadPoolParams.poolThreadName = "FileDigestGetPool";
        this.d = ThreadManager.newFreeThreadPool(localThreadPoolParams);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MMApkCheck] start DigestGet pool exception:");
        localStringBuilder.append(localException.toString());
        QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void g()
  {
    if (this.d != null)
    {
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] close DigestGet pool");
      try
      {
        if ((this.d instanceof ExecutorService)) {
          ((ExecutorService)this.d).shutdown();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MMApkCheck] close DigestGet pool exception:");
        localStringBuilder.append(localException.toString());
        QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
      }
      this.d = null;
    }
  }
  
  private void h()
  {
    try
    {
      this.e.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] init.");
    ((TuringSdkManager)this.b.getManager(QQManagerFactory.TURINGSDK_MANAGER)).a(PrivacyPolicyHelper.d(), false);
  }
  
  public void a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (!e()) {
      return;
    }
    if (paramItem == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. troopFileItem=null");
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new MMApkFileSafeChecker.4(this, paramLong, paramItem));
      return;
    }
    b(paramLong, paramItem);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!e()) {
      return;
    }
    if (paramFileManagerEntity == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. entity=null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] checkLocalApk. entity.nSessionId=");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new MMApkFileSafeChecker.2(this, paramFileManagerEntity));
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] release.");
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      ((MMApkFileSafeChecker.CheckTask)localIterator.next()).c();
    }
    g();
    this.c.clear();
    h();
    this.b = null;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker
 * JD-Core Version:    0.7.0.1
 */