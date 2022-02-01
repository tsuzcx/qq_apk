package com.tencent.mobileqq.pluginsdk;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;

public class QZoneLiveClassLoader
  extends DexClassLoader
{
  private ClassLoader mGrandParent;
  private final String[] mInterceptPackageNames = { "com.tencent.av", "com.tencent.xplatform", "com.tencent.kapalaiadapter", "NS_QQRADIO_PROTOCOL", "com.qzone.widget", "com.tencent.component.animation.rebound", "com.tencent.component.hdasync", "com.tencent.component.app", "com.qzonex.app.internal", "com.tencent.sharp.jni", "com.microrapid", "com.tencent.algo", "com.tencent.common", "com.tencent.faceBeauty", "com.tencent.filter", "com.tencent.oscarcamera.particlesystem", "com.tencent.ptualgo", "com.tencent.ttpic", "com.tencent.util", "com.tencent.view", "com.tencent.vtool", "com.tencent.youtufacetrack", "com.tencent.ytcommon", "com.tencent.youtu.android.segmenter", "com.tentent.youtu.android.segementer", "me.lake.gleslab" };
  
  public QZoneLiveClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.mGrandParent = paramClassLoader.getParent().getParent();
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    int j = paramString.lastIndexOf('.');
    int i = 0;
    if (j != -1) {
      localObject1 = paramString.substring(0, j);
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.mInterceptPackageNames;
    int k = localObject2.length;
    j = 0;
    while (i < k)
    {
      if (((String)localObject1).startsWith(localObject2[i]))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("intercept class=");
        localStringBuilder.append(paramString);
        QLog.d("rays", 1, localStringBuilder.toString());
        j = 1;
      }
      i += 1;
    }
    if (j == 0) {
      return super.loadClass(paramString, paramBoolean);
    }
    Object localObject1 = findLoadedClass(paramString);
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = findClass(paramString);
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label148:
      break label148;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        paramString = this.mGrandParent.loadClass(paramString);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        i = Build.VERSION.SDK_INT;
        throw paramString;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.QZoneLiveClassLoader
 * JD-Core Version:    0.7.0.1
 */