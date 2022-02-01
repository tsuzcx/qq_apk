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
    try
    {
      LogUtils.i("TNNGenderDetectInitializer", "loadRapidNetModelImpl");
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
      paramString = this.TNNGenderDetect;
      if (paramInt1 == 5) {}
      try
      {
        paramInt2 = this.TNNGenderDetect.init((String)localArrayList2.get(0), (String)localArrayList1.get(0), "ARM");
        if (paramInt2 != 0)
        {
          paramString = new StringBuilder();
          paramString.append("RapidnetLib init failed ret =");
          paramString.append(paramInt2);
          LogUtils.d("TNNGenderDetectInitializer", paramString.toString());
          return false;
        }
        paramString = new StringBuilder();
        paramString.append("RapidnetLib init success. ret =");
        paramString.append(paramInt2);
        LogUtils.d("TNNGenderDetectInitializer", paramString.toString());
        this.modelManager.toggleRapidModel(paramInt3, true);
        return true;
      }
      finally {}
      throw paramString;
    }
    finally {}
    for (;;) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer
 * JD-Core Version:    0.7.0.1
 */