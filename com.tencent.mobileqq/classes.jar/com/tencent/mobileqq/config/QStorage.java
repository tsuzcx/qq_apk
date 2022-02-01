package com.tencent.mobileqq.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class QStorage
{
  public static ConcurrentHashMap<String, QStorage> e = new ConcurrentHashMap();
  private static final String[] f = { "flashchat" };
  String a;
  Context b;
  String c;
  File d;
  
  private QStorage(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramContext;
    this.c = paramString2;
    paramContext = new StringBuilder();
    paramContext.append(this.b.getFilesDir().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append(this.c);
    paramContext.append(File.separator);
    paramContext.append("qstorage");
    paramContext.append(File.separator);
    paramContext.append("objs");
    paramContext = new File(paramContext.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.d = paramContext;
  }
  
  public static <T extends IQStorageSafable<Y>, Y> T a(Y paramY, Class<T> paramClass)
  {
    IQStorageSafable localIQStorageSafable = (IQStorageSafable)QConfigHelper.a(paramClass);
    try
    {
      localIQStorageSafable.a(paramY);
      return localIQStorageSafable;
    }
    catch (Exception paramY)
    {
      QConfigWatchDog.a().a(paramClass, paramY);
      throw new QStorageInstantiateException("readJsonOrXml exception too much", paramY);
    }
  }
  
  public static QStorage a(String paramString)
  {
    if (!b(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildQStorage notRegister ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QStorage", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QStorage)e.get(paramString);
    if (localObject == null) {
      synchronized (e)
      {
        QStorage localQStorage = (QStorage)e.get(paramString);
        localObject = localQStorage;
        if (localQStorage == null)
        {
          localObject = new QStorage(BaseApplication.getContext(), paramString, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
          e.put(paramString, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private static boolean b(String paramString)
  {
    String[] arrayOfString = f;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public File a(String paramString1, String paramString2)
  {
    File localFile = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return new File(localFile, localStringBuilder.toString());
  }
  
  public <T extends Serializable> T a(String paramString, Class<T> paramClass, int paramInt)
  {
    File localFile = a(paramString, ".serial");
    return (Serializable)a(localFile, "", paramClass, paramInt, new QStorage.2(this, localFile, paramString));
  }
  
  public <JavaBean, Param> JavaBean a(File paramFile, Param paramParam, Class<JavaBean> paramClass, int paramInt, IQStorageIOProcessor<JavaBean, Param> paramIQStorageIOProcessor)
  {
    Object localObject = null;
    if (paramFile != null) {}
    try
    {
      str = paramFile.getCanonicalPath();
    }
    catch (IOException localIOException)
    {
      String str;
      label16:
      break label16;
    }
    str = null;
    if ((paramInt != 1) && (str != null) && (QConfigJourney.a().b(this.a, this.c, str)) && (!paramFile.exists())) {
      throw new QStorageSafeDeleteException();
    }
    try
    {
      paramParam = paramIQStorageIOProcessor.a(paramFile, paramParam);
      paramFile = paramParam;
    }
    catch (Exception paramParam)
    {
      QConfigWatchDog.a().a(paramIQStorageIOProcessor, paramFile, paramParam);
      paramIQStorageIOProcessor = new StringBuilder();
      paramIQStorageIOProcessor.append("readFile ");
      paramIQStorageIOProcessor.append(paramFile.getAbsolutePath());
      QLog.d("QStorage", 1, paramIQStorageIOProcessor.toString(), paramParam);
      paramFile = localObject;
    }
    if (paramFile == null)
    {
      paramParam = QConfigHelper.a(paramClass);
    }
    else
    {
      paramParam = paramFile;
      if (str != null)
      {
        QConfigJourney.a().a(this.a, this.c, str);
        paramParam = paramFile;
      }
    }
    if (paramParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QStorage", 2, "readFile ");
      }
      throw new QStorageInstantiateException("readSerializable exception too much", new NullPointerException());
    }
    return paramParam;
  }
  
  public <DATA> void a(File paramFile, DATA paramDATA, IQStorageIOProcessor<String, DATA> paramIQStorageIOProcessor)
  {
    try
    {
      paramIQStorageIOProcessor.a(paramFile, paramDATA);
      if (paramFile != null)
      {
        boolean bool = paramFile.exists();
        if (!bool) {}
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception paramDATA)
    {
      try
      {
        paramDATA = paramFile.getCanonicalPath();
        QConfigJourney.a().c(this.a, this.c, paramDATA);
        QConfigJourney.a().a(this.a, this.c, paramDATA);
        return;
      }
      catch (IOException paramFile) {}
      paramDATA = paramDATA;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeFile ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      QLog.d("QStorage", 1, localStringBuilder.toString(), paramDATA);
      QConfigWatchDog.a().a(paramIQStorageIOProcessor, paramFile, paramDATA);
    }
  }
  
  public <T extends Serializable> void a(String paramString, T paramT)
  {
    a(a(paramString, ".serial"), paramT, new QStorage.1(this, paramString, paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QStorage
 * JD-Core Version:    0.7.0.1
 */