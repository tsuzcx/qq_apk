package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNGenderDetect;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TNNGenderDetectInitializer
  extends Feature
{
  private static final String TAG = "TNNGenderDetectInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_genderdetect") };
  private final TNNGenderDetect TNNGenderDetect = new TNNGenderDetect();
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNGenderDetectInitializer", "unloadRapidNetModelImpl");
    synchronized (this.TNNGenderDetect)
    {
      paramInt1 = this.TNNGenderDetect.deinit();
      if (paramInt1 == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.TNNGenderDetect)
    {
      this.TNNGenderDetect.deinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "TNNGenderDetectInitializer";
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
        LogUtils.i("TNNGenderDetectInitializer", "loadRapidNetModelImpl");
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
      paramString = this.TNNGenderDetect;
      if (paramInt1 == 5) {}
      try
      {
        paramInt2 = this.TNNGenderDetect.init((String)localArrayList2.get(0), (String)localArrayList1.get(0), "ARM");
        if (paramInt2 != 0)
        {
          LogUtils.d("TNNGenderDetectInitializer", "RapidnetLib init failed ret =" + paramInt2);
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      LogUtils.d("TNNGenderDetectInitializer", "RapidnetLib init success. ret =" + paramInt2);
      this.modelManager.toggleRapidModel(paramInt3, true);
      paramBoolean1 = true;
    }
  }
  
  public float[] retrieveGenderInfo(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.modelManager.isModelLoaded(5)) {
      synchronized (this.TNNGenderDetect)
      {
        if (this.modelManager.isModelLoaded(5))
        {
          paramBitmap = this.TNNGenderDetect.forwardWithBox(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
          return paramBitmap;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer
 * JD-Core Version:    0.7.0.1
 */