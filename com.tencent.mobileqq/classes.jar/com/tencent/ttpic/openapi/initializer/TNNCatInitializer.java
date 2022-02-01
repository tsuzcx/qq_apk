package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNCat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TNNCatInitializer
  extends Feature
{
  private static final String TAG = "TNNCatInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_cat") };
  private final TNNCat TNNCat = new TNNCat();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean)
  {
    LogUtils.i("TNNCatInitializer", "unloadRapidNetModelImpl");
    synchronized (this.TNNCat)
    {
      int i = this.TNNCat.catKeypointsDeinit();
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.TNNCat)
    {
      this.TNNCat.catKeypointsDeinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "TNNCatInitializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public boolean loadRapidModelFrom(String arg1, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      LogUtils.i("TNNCatInitializer", "loadRapidNetModelImpl");
      paramBoolean1 = isFunctionReady();
      if (!paramBoolean1) {
        return false;
      }
      paramBoolean1 = unloadRapidNetModelImpl(true);
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
        localObject = RapidnetModelManager.copyIfInAssets(???, ((StringBuilder)localObject).toString(), FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(".rapidproto.wmc");
        str = RapidnetModelManager.copyIfInAssets(???, localStringBuilder.toString(), FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
        new File((String)localObject);
        new File(str);
        localArrayList1.add(localObject);
        localArrayList2.add(str);
      }
      synchronized (this.TNNCat)
      {
        paramInt = this.TNNCat.catKeypointsInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2));
        if (paramInt != 0)
        {
          ??? = new StringBuilder();
          ???.append("RapidnetLib init failed ret =");
          ???.append(paramInt);
          LogUtils.d("TNNCatInitializer", ???.toString());
          return false;
        }
        ??? = new StringBuilder();
        ???.append("RapidnetLib init success. ret =");
        ???.append(paramInt);
        LogUtils.d("TNNCatInitializer", ???.toString());
        return true;
      }
      throw ???;
    }
    finally {}
    for (;;) {}
  }
  
  public float[] retrieveCatKeyPoints(Bitmap paramBitmap)
  {
    synchronized (this.TNNCat)
    {
      paramBitmap = this.TNNCat.catKeypointResult(paramBitmap, 0);
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNCatInitializer
 * JD-Core Version:    0.7.0.1
 */