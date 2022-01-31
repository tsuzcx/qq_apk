package com.tencent.mobileqq.pluginsdk;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;

public class QZoneLiveClassLoader
  extends DexClassLoader
{
  private ClassLoader a;
  private final String[] b = { "com.tencent.av", "com.tencent.xplatform", "com.tencent.kapalaiadapter", "NS_QQRADIO_PROTOCOL", "com.tencent.component.animation.rebound", "com.tencent.component.hdasync", "com.tencent.component.app", "com.qzonex.app.internal", "com.tencent.sharp.jni", "com.microrapid", "com.tencent.algo", "com.tencent.common", "com.tencent.faceBeauty", "com.tencent.filter", "com.tencent.oscarcamera.particlesystem", "com.tencent.ptualgo", "com.tencent.ttpic", "com.tencent.util", "com.tencent.view", "com.tencent.vtool", "com.tencent.youtufacetrack", "com.tencent.ytcommon", "com.tencent.youtu.android.segmenter", "com.tentent.youtu.android.segementer", "me.lake.gleslab" };
  
  public QZoneLiveClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.a = paramClassLoader.getParent().getParent();
  }
  
  protected Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    int j = 0;
    int i = paramString.lastIndexOf('.');
    if (i != -1) {}
    Object localObject2;
    for (Object localObject1 = paramString.substring(0, i);; localObject1 = "")
    {
      localObject2 = this.b;
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        if (((String)localObject1).startsWith(localObject2[i]))
        {
          QLog.d("rays", 1, "intercept class=" + paramString);
          j = 1;
        }
        i += 1;
      }
    }
    if (j == 0) {
      localObject1 = super.loadClass(paramString, paramBoolean);
    }
    Throwable localThrowable;
    label142:
    do
    {
      do
      {
        return localObject1;
        localObject2 = findLoadedClass(paramString);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localThrowable = null;
      try
      {
        localObject1 = findClass(paramString);
        localObject2 = localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        break label142;
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    try
    {
      paramString = this.a.loadClass(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramString.addSuppressed(localThrowable);
      }
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.QZoneLiveClassLoader
 * JD-Core Version:    0.7.0.1
 */