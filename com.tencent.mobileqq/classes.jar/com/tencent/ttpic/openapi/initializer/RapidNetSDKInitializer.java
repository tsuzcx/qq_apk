package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.util.Coffee;
import com.tencent.youtu.rapidnet.library.RapidnetCPULib;
import com.tencent.youtu.rapidnet.library.RapidnetLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RapidNetSDKInitializer
  extends Feature
{
  public static int RAPID_NET_TYPE_CPU_LIB = 0;
  public static int RAPID_NET_TYPE_GPU_LIB = 1;
  private static final String TAG = "RapidNetSDK";
  private static final Object rapidnetLock = new Object();
  private static final Object rapidnetLockGesture = new Object();
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("Rapidnet"), new SharedLibraryInfo("rapidnet_wrapper"), new SharedLibraryInfo("rapidnet_cpu_wrapper") };
  private boolean isUseCpuLib = false;
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetCPULib rapidnetCPULib = new RapidnetCPULib();
  private final RapidnetCPULib rapidnetCPULibGesture = new RapidnetCPULib();
  private final RapidnetLib rapidnetLib = new RapidnetLib();
  
  private static String copyIfInAssets(String paramString1, String paramString2)
  {
    if (paramString1.startsWith("assets://"))
    {
      Object localObject = new File(FeatureManager.Features.RAPID_NET.getFinalResourcesDir(), "tmp_" + paramString2);
      ((File)localObject).deleteOnExit();
      localObject = ((File)localObject).getPath();
      FileUtils.delete((String)localObject);
      paramString1 = FileUtils.getRealPath(FileUtils.genSeperateFileDir(paramString1) + paramString2);
      FileUtils.copyAssets(AEModule.getContext(), paramString1, (String)localObject);
      return localObject;
    }
    return FileUtils.genSeperateFileDir(paramString1) + paramString2;
  }
  
  private static String decryptRapidNetFile(String paramString1, String paramString2)
  {
    Object localObject = FileUtils.genSeperateFileDir(paramString1) + paramString2;
    paramString1 = FileUtils.genSeperateFileDir(paramString1) + "decrypt_" + paramString2;
    paramString2 = new File((String)localObject);
    localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      FileUtils.delete((File)localObject);
    }
    try
    {
      if ((paramString2.isFile()) && (paramString2.exists()))
      {
        localObject = new FileInputStream(paramString2);
        paramString2 = Coffee.drinkACupOfCoffee((InputStream)localObject, false);
        IOUtils.closeQuietly((InputStream)localObject);
        localObject = new FileOutputStream(paramString1);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramString2.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
        }
      }
      return paramString1;
    }
    catch (FileNotFoundException paramString2)
    {
      paramString2.printStackTrace();
      LogUtils.e("RapidNetSDK", "protoFile Not found: " + paramString2.getMessage());
      return paramString1;
      IOUtils.closeQuietly(paramString2);
      IOUtils.closeQuietly((OutputStream)localObject);
      return paramString1;
    }
    catch (IOException paramString2)
    {
      paramString2.printStackTrace();
      LogUtils.e("RapidNetSDK", "drinkACupOfCoffee IOException : " + paramString2.getMessage());
    }
  }
  
  private boolean isHairSkyGenderModelLoaded()
  {
    boolean bool = false;
    if ((this.modelManager.isModelLoaded(0)) || (this.modelManager.isModelLoaded(1)) || (this.modelManager.isModelLoaded(2))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    LogUtils.i("RapidNetSDK", "unloadRapidNetModelImpl");
    if (paramInt1 != 2)
    {
      if (this.modelManager.isModelLoaded(paramInt2))
      {
        ??? = rapidnetLock;
        if (paramBoolean) {}
        for (;;)
        {
          try
          {
            paramInt1 = this.rapidnetCPULib.deinit();
            this.modelManager.toggleRapidModel(paramInt2, false);
          }
          finally {}
          paramInt1 = this.rapidnetLib.deinit();
        }
      }
    }
    else if (this.modelManager.isModelLoaded(paramInt2)) {
      synchronized (rapidnetLockGesture)
      {
        paramInt1 = this.rapidnetCPULibGesture.gestureAllDeinit();
        this.modelManager.toggleRapidModel(paramInt2, false);
      }
    }
    paramInt1 = 0;
    paramBoolean = bool;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET.isFunctionReady())
    {
      if (this.modelManager.isModelLoaded(3)) {}
      synchronized (rapidnetLockGesture)
      {
        this.rapidnetCPULibGesture.gestureAllDeinit();
        if ((!this.modelManager.isModelLoaded(0)) && (!this.modelManager.isModelLoaded(2))) {
          if (!this.modelManager.isModelLoaded(1)) {
            break label93;
          }
        }
      }
    }
    synchronized (rapidnetLock)
    {
      this.rapidnetCPULib.deinit();
      this.rapidnetLib.deinit();
      label93:
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  protected boolean destroyImpl()
  {
    this.rapidnetLib.deinit();
    this.rapidnetCPULib.deinit();
    this.rapidnetCPULibGesture.gestureAllDeinit();
    return true;
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, this.isUseCpuLib, this.isUseCpuLib, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (isHairSkyGenderModelLoaded()) {
      synchronized (rapidnetLock)
      {
        if (isHairSkyGenderModelLoaded())
        {
          if (paramBoolean1)
          {
            paramBitmap = this.rapidnetCPULib.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          paramBitmap = this.rapidnetLib.forwardWithAngle(paramBitmap, paramInt2);
          return paramBitmap;
        }
      }
    }
    return paramBitmap;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "RapidNetSDK";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    return this.modelManager.isModelLoaded(paramInt);
  }
  
  public boolean loadRapidModelFrom(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool3 = false;
    for (;;)
    {
      boolean bool2;
      try
      {
        LogUtils.i("RapidNetSDK", "loadRapidNetModelImpl");
        bool1 = isFunctionReady();
        if (bool1) {
          continue;
        }
        bool1 = bool3;
      }
      finally
      {
        try
        {
          File localFile1;
          File localFile2;
          this.isUseCpuLib = true;
          paramInt1 = this.rapidnetCPULib.init(paramString2, paramString1);
          FileUtils.delete(paramString2);
          if (paramInt1 == 0) {
            break label327;
          }
          LogUtils.d("RapidNetSDK", "RapidnetLib init failed ret =" + paramInt1);
          bool1 = bool3;
          continue;
        }
        finally {}
        paramString1 = finally;
      }
      return bool1;
      Object localObject;
      if (paramInt2 == RAPID_NET_TYPE_CPU_LIB)
      {
        bool2 = true;
        bool1 = bool3;
        if (!unloadRapidNetModelImpl(bool2, paramInt1, paramInt3)) {
          continue;
        }
        localObject = copyIfInAssets(paramString1, paramString2 + ".rapidmodel");
        paramString2 = copyIfInAssets(paramString1, paramString2 + ".rapidproto");
        localFile1 = new File((String)localObject);
        localFile2 = new File(paramString2);
        paramString1 = (String)localObject;
        if (paramBoolean1)
        {
          paramString1 = decryptRapidNetFile(localFile1.getParent(), localFile1.getName());
          bool1 = bool3;
          if (paramString1 == null) {
            continue;
          }
        }
        if (paramBoolean2)
        {
          paramString2 = decryptRapidNetFile(localFile1.getParent(), localFile2.getName());
          bool1 = bool3;
          if (paramString2 == null) {
            continue;
          }
        }
        bool1 = bool3;
        if (!FileUtils.isFileExist(paramString1)) {
          continue;
        }
        bool1 = bool3;
        if (!FileUtils.isFileExist(paramString2)) {
          continue;
        }
        localObject = rapidnetLock;
        if (!bool2) {}
      }
      else
      {
        bool2 = false;
        continue;
      }
      this.isUseCpuLib = false;
      paramInt1 = this.rapidnetLib.init(paramString2, paramString1, paramInt1);
      FileUtils.delete(paramString2);
      continue;
      label327:
      LogUtils.d("RapidNetSDK", "RapidnetLib init success. ret =" + paramInt1);
      this.modelManager.toggleRapidModel(paramInt3, true);
      boolean bool1 = true;
    }
  }
  
  public boolean loadRapidModelFrom(String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        LogUtils.i("RapidNetSDK", "loadRapidNetModelImpl");
        bool = isFunctionReady();
        if (!bool)
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        if (paramInt2 != RAPID_NET_TYPE_CPU_LIB) {
          break label541;
        }
        bool = true;
        if (!unloadRapidNetModelImpl(bool, paramInt1, paramInt3))
        {
          paramBoolean1 = false;
          continue;
        }
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          paramList = copyIfInAssets(paramString, str1 + ".rapidmodel");
          str1 = copyIfInAssets(paramString, str1 + ".rapidproto");
          File localFile1 = new File(paramList);
          File localFile2 = new File(str1);
          if (paramBoolean1)
          {
            String str2 = decryptRapidNetFile(localFile1.getParent(), localFile1.getName());
            paramList = str2;
            if (str2 == null)
            {
              paramBoolean1 = false;
              continue;
            }
          }
          localArrayList1.add(paramList);
          paramList = str1;
          if (paramBoolean2)
          {
            str1 = decryptRapidNetFile(localFile1.getParent(), localFile2.getName());
            paramList = str1;
            if (str1 == null)
            {
              paramBoolean1 = false;
              continue;
            }
          }
          localArrayList2.add(paramList);
          continue;
        }
        paramInt2 = -1;
      }
      finally {}
      paramString = rapidnetLockGesture;
      if (paramInt1 == 2) {}
      try
      {
        paramInt2 = this.rapidnetCPULibGesture.gestureAllInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2), (String)localArrayList2.get(3), (String)localArrayList1.get(3));
        this.rapidnetCPULibGesture.gestureClassifySetPrevNumOfFrame(4);
        this.rapidnetCPULibGesture.gestureSetKeypointsPreFrame(0);
        FileUtils.delete((String)localArrayList2.get(0));
        FileUtils.delete((String)localArrayList2.get(1));
        FileUtils.delete((String)localArrayList2.get(2));
        FileUtils.delete((String)localArrayList2.get(3));
        if (paramInt2 != 0)
        {
          LogUtils.d("RapidNetSDK", "RapidnetLib init failed ret =" + paramInt2);
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      LogUtils.d("RapidNetSDK", "RapidnetLib init success. ret =" + paramInt2);
      this.modelManager.toggleRapidModel(paramInt3, true);
      paramBoolean1 = true;
      continue;
      label541:
      boolean bool = false;
    }
  }
  
  public float[] retrieveGestureBoxAndType(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.modelManager.isModelLoaded(3)) {
      label161:
      for (;;)
      {
        synchronized (rapidnetLockGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.rapidnetCPULibGesture.gestureKeypointResult(paramBitmap, 1);
            float[] arrayOfFloat1 = arrayOfFloat2;
            if (arrayOfFloat2 != null)
            {
              arrayOfFloat1 = arrayOfFloat2;
              if (arrayOfFloat2.length == 5)
              {
                arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 2);
                if (!paramBoolean) {
                  break label161;
                }
                paramBitmap = this.rapidnetCPULibGesture.gestureClassifyResultWithBox(paramBitmap, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3]);
                if ((paramBitmap == null) || (paramBitmap.length != 2)) {
                  break label161;
                }
                float f1 = paramBitmap[0];
                float f2 = paramBitmap[1];
                arrayOfFloat1[(arrayOfFloat1.length - 2)] = f1;
                arrayOfFloat1[(arrayOfFloat1.length - 1)] = f2;
                break label161;
              }
            }
            return arrayOfFloat1;
          }
        }
      }
    }
    return null;
  }
  
  public float[] retrieveGestureInfo(Bitmap paramBitmap)
  {
    if (this.modelManager.isModelLoaded(3)) {
      synchronized (rapidnetLockGesture)
      {
        if (this.modelManager.isModelLoaded(3))
        {
          paramBitmap = this.rapidnetCPULibGesture.gestureKeyPointsAndClassifyResult(paramBitmap);
          return paramBitmap;
        }
      }
    }
    return null;
  }
  
  public float[] retrieveGestureInfo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.modelManager.isModelLoaded(3)) {
      label190:
      for (;;)
      {
        synchronized (rapidnetLockGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.rapidnetCPULibGesture.gestureKeypointResult(paramBitmap, 0);
            float[] arrayOfFloat1 = arrayOfFloat2;
            if (arrayOfFloat2 != null)
            {
              arrayOfFloat1 = arrayOfFloat2;
              if (arrayOfFloat2.length == 47)
              {
                arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 1);
                if (!paramBoolean) {
                  break label190;
                }
                float f1 = arrayOfFloat1[21];
                float f2 = arrayOfFloat1[44];
                float f3 = arrayOfFloat1[22];
                float f4 = arrayOfFloat1[21];
                float f5 = arrayOfFloat1[45];
                float f6 = arrayOfFloat1[44];
                paramBitmap = this.rapidnetCPULibGesture.gestureClassifyResultWithBox(paramBitmap, f1, f2, f3 - f4, f5 - f6);
                f1 = paramBitmap[0];
                f2 = paramBitmap[1];
                arrayOfFloat1[(arrayOfFloat1.length - 2)] = f1;
                arrayOfFloat1[(arrayOfFloat1.length - 1)] = f2;
                break label190;
              }
            }
            return arrayOfFloat1;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer
 * JD-Core Version:    0.7.0.1
 */