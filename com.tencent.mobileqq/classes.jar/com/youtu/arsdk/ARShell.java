package com.youtu.arsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArFeatureSwepNativeSoLoader;
import com.tencent.mobileqq.ar.ArSDK2NativeSoLoader;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ARShell
{
  public static final int ERROR_LOST_TARGET = 3;
  public static final int ERROR_OK = 0;
  public static final int ERROR_TARGET_EMPTY = 4;
  public static final int ERROR_TARGET_RECOGNIZED = 1;
  public static final int ERROR_TARGET_TRACKED = 2;
  public static final int ERROR_TRAINING_DATA_LOAD_FAILED = -1001;
  private static volatile boolean loadARCoreSoSuccess = false;
  private static volatile boolean loadARFeatureSoSuccess = false;
  private static boolean loadSoSuccess = false;
  private static boolean soLoaded = false;
  
  public static boolean getARCoreSoHasLoadSuccess()
  {
    return loadARCoreSoSuccess;
  }
  
  public static String getCommonSoFilename()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzippedPackageDir(AEResInfo.AE_RES_BASE_PACKAGE));
    localStringBuilder.append("libYTCommon.so");
    return localStringBuilder.toString();
  }
  
  public static native int getMarkerCount();
  
  public static native int getMarkerInfo(long paramLong, ARPatternInfo paramARPatternInfo);
  
  public static native void getPatternSizeById(int paramInt, float[] paramArrayOfFloat);
  
  public static native void getProjectionMatrix(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public static native String getSDKVersion();
  
  public static boolean loadARFeatureNativeLibrary()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary");
        }
        boolean bool2 = loadARFeatureSoSuccess;
        bool1 = true;
        if (bool2) {
          return true;
        }
        if (!ArFeatureSwepNativeSoLoader.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "native so is not exist!");
          }
          return false;
        }
        StringBuilder localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("isArEnable, loadARFeatureNativeLibrary soLoaded=");
          localStringBuilder1.append(soLoaded);
          QLog.d("ARShell", 2, localStringBuilder1.toString());
        }
        loadARFeatureSoSuccess = true;
        try
        {
          int i = ArFeatureSwepNativeSoLoader.a("libARFeature");
          if (i != 0) {
            break label231;
          }
          loadARFeatureSoSuccess = bool1;
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("isArEnable, loadARFeatureNativeLibrary ret1=");
            localStringBuilder1.append(i);
            QLog.d("ARShell", 2, localStringBuilder1.toString());
          }
        }
        catch (Throwable localThrowable)
        {
          loadARFeatureSoSuccess = false;
          if (QLog.isColorLevel()) {
            QLog.e("ARShell", 2, "loadARFeatureNativeLibrary", localThrowable);
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("isArEnable, loadARFeatureNativeLibrary loadSoSuccess=");
          localStringBuilder2.append(loadARFeatureSoSuccess);
          QLog.d("ARShell", 2, localStringBuilder2.toString());
        }
        bool1 = loadARFeatureSoSuccess;
        return bool1;
      }
      finally {}
      label231:
      boolean bool1 = false;
    }
  }
  
  public static boolean loadArCoreNativeLibrary()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isArCoreEnable, loadArCoreNativeLibrary ");
        ((StringBuilder)localObject1).append(loadARCoreSoSuccess);
        QLog.d("ARShell", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool = loadARCoreSoSuccess;
      if (bool) {
        return true;
      }
      Object localObject1 = ArCoreNativeSoManager.a();
      if (localObject1 == null)
      {
        loadARCoreSoSuccess = false;
        bool = loadARCoreSoSuccess;
        return bool;
      }
      if (ArCoreNativeSoManager.a((IArCoreNativeSoLoader)localObject1))
      {
        Object localObject3 = ((IArCoreNativeSoLoader)localObject1).a();
        if (localObject3 != null)
        {
          int i = ((List)localObject3).size();
          if (i != 0) {
            try
            {
              Iterator localIterator = ((List)localObject3).iterator();
              while (localIterator.hasNext())
              {
                localObject3 = (String)localIterator.next();
                i = ArCoreNativeSoManager.a((IArCoreNativeSoLoader)localObject1, (String)localObject3);
                if (i != 0)
                {
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("isArCoreEnable, loadNativeLibrary faild result=");
                    ((StringBuilder)localObject1).append(i);
                    ((StringBuilder)localObject1).append(", name=");
                    ((StringBuilder)localObject1).append((String)localObject3);
                    QLog.d("ARShell", 2, ((StringBuilder)localObject1).toString());
                  }
                  loadARCoreSoSuccess = false;
                  bool = loadARCoreSoSuccess;
                  return bool;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              loadARCoreSoSuccess = false;
              if (QLog.isColorLevel()) {
                QLog.e("ARShell", 2, "loadArCoreNativeLibrary", localThrowable);
              }
              loadARCoreSoSuccess = true;
              bool = loadARCoreSoSuccess;
              return bool;
            }
          }
        }
        loadARCoreSoSuccess = false;
        bool = loadARCoreSoSuccess;
        return bool;
      }
      loadARCoreSoSuccess = false;
      bool = loadARCoreSoSuccess;
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static boolean loadNativeLibrary()
  {
    for (;;)
    {
      try
      {
        if (!ArSDK2NativeSoLoader.a("libAlphaAR"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "loadNativeLibrary failed. native so is not exist!");
          }
          return false;
        }
        StringBuilder localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("loadNativeLibrary soLoaded=");
          localStringBuilder1.append(soLoaded);
          QLog.d("ARShell", 2, localStringBuilder1.toString());
        }
        bool = true;
        soLoaded = true;
        try
        {
          System.loadLibrary("YTCommon");
          int i = ArSDK2NativeSoLoader.a("libAlphaAR");
          if (i != 0) {
            break label211;
          }
          loadSoSuccess = bool;
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("loadNativeLibrary ret1=");
            localStringBuilder1.append(i);
            QLog.d("ARShell", 2, localStringBuilder1.toString());
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          loadSoSuccess = false;
          if (QLog.isColorLevel()) {
            QLog.e("ARShell", 2, "loadNativeLibrary", localUnsatisfiedLinkError);
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("loadNativeLibrary loadSoSuccess=");
          localStringBuilder2.append(loadSoSuccess);
          QLog.d("ARShell", 2, localStringBuilder2.toString());
        }
        bool = loadSoSuccess;
        return bool;
      }
      finally {}
      label211:
      boolean bool = false;
    }
  }
  
  private static boolean loadSo()
  {
    soLoaded = true;
    Object localObject4 = BaseApplicationImpl.sApplication;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject4).getApplicationInfo().nativeLibraryDir);
      ((StringBuilder)localObject1).append("/");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject4).getApplicationInfo().dataDir);
      ((StringBuilder)localObject1).append("/lib/");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("libAlphaAR.so");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((Context)localObject4).getFilesDir());
    ((StringBuilder)localObject3).append("libAlphaAR.so");
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!new File((String)localObject1).exists()) {
      if (new File((String)localObject3).exists()) {
        localObject1 = localObject3;
      } else {
        localObject1 = "";
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("libYTCommon.so");
    Object localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((Context)localObject4).getFilesDir());
    ((StringBuilder)localObject3).append("libYTCommon.so");
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!new File((String)localObject2).exists()) {
      if (new File((String)localObject3).exists()) {
        localObject2 = localObject3;
      } else {
        localObject2 = "";
      }
    }
    if ((!((String)localObject1).equals("")) && (!((String)localObject2).equals(""))) {
      try
      {
        System.load((String)localObject2);
        System.load((String)localObject1);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("load ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" successfully!");
        QLog.i("ARShell", 1, ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("load ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" successfully!");
        QLog.i("ARShell", 1, ((StringBuilder)localObject3).toString());
        loadSoSuccess = true;
        boolean bool = loadSoSuccess;
        return bool;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("load ");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(" failed!");
        ((StringBuilder)localObject4).append(localUnsatisfiedLinkError.getMessage());
        QLog.i("ARShell", 1, ((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("load ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(" failed!");
        ((StringBuilder)localObject4).append(localUnsatisfiedLinkError.getMessage());
        QLog.i("ARShell", 1, ((StringBuilder)localObject4).toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" failed!");
    QLog.i("ARShell", 1, localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("load ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" failed!");
    QLog.i("ARShell", 1, ((StringBuilder)localObject1).toString());
    loadSoSuccess = false;
    return loadSoSuccess;
  }
  
  public static native int nativeAddMarker(String paramString1, String paramString2);
  
  public static native int nativeAddMarkers(String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public static native boolean nativeCreate(Context paramContext);
  
  public static native boolean nativeDestroy();
  
  public static native long[] nativeGetMarkerIndice();
  
  public static native int nativeGetScore(byte[] paramArrayOfByte);
  
  public static native int nativeInitialize(AROption paramAROption);
  
  public static native int nativeRecognize(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native boolean nativeStart();
  
  public static native boolean nativeStop();
  
  public static native int nativeTrack(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native int removeAllMarkers();
  
  public static native int removeMarker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.youtu.arsdk.ARShell
 * JD-Core Version:    0.7.0.1
 */