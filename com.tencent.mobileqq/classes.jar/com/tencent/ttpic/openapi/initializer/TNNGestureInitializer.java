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
    try
    {
      LogUtils.i("TNNGestureInitializer", "loadRapidNetModelImpl");
      paramBoolean1 = isFunctionReady();
      if (!paramBoolean1) {
        return false;
      }
      paramBoolean1 = unloadRapidNetModelImpl(true, paramInt1, paramInt3);
      if (!paramBoolean1) {
        return false;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".rapidmodel.wmc");
        localObject = RapidnetModelManager.copyIfInAssets(paramString, ((StringBuilder)localObject).toString(), FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(".rapidproto.wmc");
        str = RapidnetModelManager.copyIfInAssets(paramString, localStringBuilder.toString(), FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
        new File((String)localObject);
        new File(str);
        localArrayList1.add(localObject);
        localArrayList2.add(str);
      }
      paramInt2 = -1;
      paramString = this.TNNGesture;
      if (paramInt1 == 2) {}
      try
      {
        paramInt2 = this.TNNGesture.gestureAllInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2), (String)localArrayList2.get(3), (String)localArrayList1.get(3), (String)localArrayList2.get(4), (String)localArrayList1.get(4));
        this.TNNGesture.gestureClassifySetPrevNumOfFrame(4);
        this.TNNGesture.gestureSetKeypointsPreFrame(0);
        if (paramInt2 != 0)
        {
          paramString = new StringBuilder();
          paramString.append("RapidnetLib init failed ret =");
          paramString.append(paramInt2);
          LogUtils.d("TNNGestureInitializer", paramString.toString());
          return false;
        }
        paramString = new StringBuilder();
        paramString.append("RapidnetLib init success. ret =");
        paramString.append(paramInt2);
        LogUtils.d("TNNGestureInitializer", paramString.toString());
        this.modelManager.toggleRapidModel(paramInt3, true);
        return true;
      }
      finally {}
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public float[] retrieveGestureBoxAndType(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.modelManager.isModelLoaded(3)) {
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
              arrayOfFloat2 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 2);
              arrayOfFloat1 = arrayOfFloat2;
              if (paramBoolean)
              {
                paramBitmap = this.TNNGesture.gestureClassifyResultWithBox(paramBitmap, arrayOfFloat2[0], arrayOfFloat2[1], arrayOfFloat2[2], arrayOfFloat2[3]);
                arrayOfFloat1 = arrayOfFloat2;
                if (paramBitmap != null)
                {
                  arrayOfFloat1 = arrayOfFloat2;
                  if (paramBitmap.length == 2)
                  {
                    float f1 = paramBitmap[0];
                    float f2 = paramBitmap[1];
                    arrayOfFloat2[(arrayOfFloat2.length - 2)] = f1;
                    arrayOfFloat2[(arrayOfFloat2.length - 1)] = f2;
                    arrayOfFloat1 = arrayOfFloat2;
                  }
                }
              }
            }
          }
          return arrayOfFloat1;
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
              arrayOfFloat2 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat2.length + 1);
              arrayOfFloat1 = arrayOfFloat2;
              if (paramBoolean)
              {
                float f1 = arrayOfFloat2[21];
                float f2 = arrayOfFloat2[44];
                float f3 = arrayOfFloat2[22];
                float f4 = arrayOfFloat2[21];
                float f5 = arrayOfFloat2[45];
                float f6 = arrayOfFloat2[44];
                paramBitmap = this.TNNGesture.gestureClassifyResultWithBox(paramBitmap, f1, f2, f3 - f4, f5 - f6);
                f1 = paramBitmap[0];
                f2 = paramBitmap[1];
                arrayOfFloat2[(arrayOfFloat2.length - 2)] = f1;
                arrayOfFloat2[(arrayOfFloat2.length - 1)] = f2;
                arrayOfFloat1 = arrayOfFloat2;
              }
            }
          }
          return arrayOfFloat1;
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