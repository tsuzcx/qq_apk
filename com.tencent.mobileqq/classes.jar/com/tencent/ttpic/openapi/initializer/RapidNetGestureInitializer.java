package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetCPUGesture;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RapidNetGestureInitializer
  extends Feature
{
  private static final String TAG = "RapidNetGestureInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("rapidnet_cpu_common"), new SharedLibraryInfo("rapidnet_cpu_gesture") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetCPUGesture rapidnetCPUGesture = new RapidnetCPUGesture();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("RapidNetGestureInitializer", "unloadRapidNetModelImpl");
    synchronized (this.rapidnetCPUGesture)
    {
      paramInt1 = this.rapidnetCPUGesture.gestureAllDeinit();
      if (paramInt1 == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_GESTURE.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetCPUGesture)
    {
      this.rapidnetCPUGesture.gestureAllDeinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "RapidNetGestureInitializer";
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
  
  public boolean loadRapidModelFrom(String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        LogUtils.i("RapidNetGestureInitializer", "loadRapidNetModelImpl");
        boolean bool = isFunctionReady();
        if (!bool)
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        if (!unloadRapidNetModelImpl(true, paramInt1, paramInt3))
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
          paramList = RapidnetModelManager.copyIfInAssets(paramString, str1 + ".rapidmodel", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          str1 = RapidnetModelManager.copyIfInAssets(paramString, str1 + ".rapidproto", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          File localFile1 = new File(paramList);
          File localFile2 = new File(str1);
          if (paramBoolean1)
          {
            String str2 = RapidnetModelManager.decryptRapidNetFile(localFile1.getParent(), localFile1.getName());
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
            str1 = RapidnetModelManager.decryptRapidNetFile(localFile1.getParent(), localFile2.getName());
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
      paramString = this.rapidnetCPUGesture;
      if (paramInt1 == 2) {}
      try
      {
        paramInt2 = this.rapidnetCPUGesture.gestureAllInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2), (String)localArrayList2.get(3), (String)localArrayList1.get(3), (String)localArrayList2.get(4), (String)localArrayList1.get(4));
        this.rapidnetCPUGesture.gestureClassifySetPrevNumOfFrame(4);
        this.rapidnetCPUGesture.gestureSetKeypointsPreFrame(0);
        FileUtils.delete((String)localArrayList2.get(0));
        FileUtils.delete((String)localArrayList2.get(1));
        FileUtils.delete((String)localArrayList2.get(2));
        FileUtils.delete((String)localArrayList2.get(3));
        FileUtils.delete((String)localArrayList2.get(4));
        if (paramInt2 != 0)
        {
          LogUtils.d("RapidNetGestureInitializer", "RapidnetLib init failed ret =" + paramInt2);
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      LogUtils.d("RapidNetGestureInitializer", "RapidnetLib init success. ret =" + paramInt2);
      this.modelManager.toggleRapidModel(paramInt3, true);
      paramBoolean1 = true;
    }
  }
  
  public float[] retrieveGestureBoxAndType(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.modelManager.isModelLoaded(3)) {
      label162:
      for (;;)
      {
        synchronized (this.rapidnetCPUGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.rapidnetCPUGesture.gestureKeypointResult(paramBitmap, 1);
            float[] arrayOfFloat1 = arrayOfFloat2;
            if (arrayOfFloat2 != null)
            {
              arrayOfFloat1 = arrayOfFloat2;
              if (arrayOfFloat2.length == 5)
              {
                arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 2);
                if (!paramBoolean) {
                  break label162;
                }
                paramBitmap = this.rapidnetCPUGesture.gestureClassifyResultWithBox(paramBitmap, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3]);
                if ((paramBitmap == null) || (paramBitmap.length != 2)) {
                  break label162;
                }
                float f1 = paramBitmap[0];
                float f2 = paramBitmap[1];
                arrayOfFloat1[(arrayOfFloat1.length - 2)] = f1;
                arrayOfFloat1[(arrayOfFloat1.length - 1)] = f2;
                break label162;
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
      synchronized (this.rapidnetCPUGesture)
      {
        if (this.modelManager.isModelLoaded(3))
        {
          paramBitmap = this.rapidnetCPUGesture.gestureKeyPointsAndClassifyResult(paramBitmap);
          return paramBitmap;
        }
      }
    }
    return null;
  }
  
  public float[] retrieveGestureInfo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.modelManager.isModelLoaded(3)) {
      label191:
      for (;;)
      {
        synchronized (this.rapidnetCPUGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.rapidnetCPUGesture.gestureKeypointResult(paramBitmap, 0);
            float[] arrayOfFloat1 = arrayOfFloat2;
            if (arrayOfFloat2 != null)
            {
              arrayOfFloat1 = arrayOfFloat2;
              if (arrayOfFloat2.length == 47)
              {
                arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 1);
                if (!paramBoolean) {
                  break label191;
                }
                float f1 = arrayOfFloat1[21];
                float f2 = arrayOfFloat1[44];
                float f3 = arrayOfFloat1[22];
                float f4 = arrayOfFloat1[21];
                float f5 = arrayOfFloat1[45];
                float f6 = arrayOfFloat1[44];
                paramBitmap = this.rapidnetCPUGesture.gestureClassifyResultWithBox(paramBitmap, f1, f2, f3 - f4, f5 - f6);
                f1 = paramBitmap[0];
                f2 = paramBitmap[1];
                arrayOfFloat1[(arrayOfFloat1.length - 2)] = f1;
                arrayOfFloat1[(arrayOfFloat1.length - 1)] = f2;
                break label191;
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
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetGestureInitializer
 * JD-Core Version:    0.7.0.1
 */