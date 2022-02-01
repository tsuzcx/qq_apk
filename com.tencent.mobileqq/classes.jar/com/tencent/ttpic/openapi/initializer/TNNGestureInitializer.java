package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNGesture;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TNNGestureInitializer
  extends Feature
{
  private static final String TAG = "TNNGestureInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_gesture") };
  private final TNNGesture TNNGesture = new TNNGesture();
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNGestureInitializer", "unloadRapidNetModelImpl");
    synchronized (this.TNNGesture)
    {
      paramInt1 = this.TNNGesture.gestureAllDeinit();
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
    synchronized (this.TNNGesture)
    {
      this.TNNGesture.gestureAllDeinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "TNNGestureInitializer";
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
        LogUtils.i("TNNGestureInitializer", "loadRapidNetModelImpl");
        paramBoolean1 = isFunctionReady();
        if (!paramBoolean1)
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
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str2 = (String)paramList.next();
          String str1 = RapidnetModelManager.copyIfInAssets(paramString, str2 + ".rapidmodel.wmc", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          str2 = RapidnetModelManager.copyIfInAssets(paramString, str2 + ".rapidproto.wmc", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          new File(str1);
          new File(str2);
          localArrayList1.add(str1);
          localArrayList2.add(str2);
          continue;
        }
        paramInt2 = -1;
      }
      finally {}
      paramString = this.TNNGesture;
      if (paramInt1 == 2) {}
      try
      {
        paramInt2 = this.TNNGesture.gestureAllInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2), (String)localArrayList2.get(3), (String)localArrayList1.get(3), (String)localArrayList2.get(4), (String)localArrayList1.get(4));
        this.TNNGesture.gestureClassifySetPrevNumOfFrame(4);
        this.TNNGesture.gestureSetKeypointsPreFrame(0);
        if (paramInt2 != 0)
        {
          LogUtils.d("TNNGestureInitializer", "RapidnetLib init failed ret =" + paramInt2);
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      LogUtils.d("TNNGestureInitializer", "RapidnetLib init success. ret =" + paramInt2);
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
        synchronized (this.TNNGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.TNNGesture.gestureKeypointResult(paramBitmap, 1);
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
                paramBitmap = this.TNNGesture.gestureClassifyResultWithBox(paramBitmap, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3]);
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
      synchronized (this.TNNGesture)
      {
        if (this.modelManager.isModelLoaded(3))
        {
          paramBitmap = this.TNNGesture.gestureKeyPointsAndClassifyResult(paramBitmap);
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
        synchronized (this.TNNGesture)
        {
          if (this.modelManager.isModelLoaded(3))
          {
            float[] arrayOfFloat2 = this.TNNGesture.gestureKeypointResult(paramBitmap, 0);
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
                paramBitmap = this.TNNGesture.gestureClassifyResultWithBox(paramBitmap, f1, f2, f3 - f4, f5 - f6);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNGestureInitializer
 * JD-Core Version:    0.7.0.1
 */