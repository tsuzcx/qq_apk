package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSeg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNSegGpuInitializer
  extends Feature
{
  private static final String TAG = "TNNSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNSeg rapidnetGPUSegmentationHair = new TNNSeg();
  private final TNNSeg rapidnetGPUSegmentationSky = new TNNSeg();
  
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
    LogUtils.i("TNNSegGpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 1) {
      synchronized (this.rapidnetGPUSegmentationHair)
      {
        paramInt1 = this.rapidnetGPUSegmentationHair.deinit();
      }
    }
    if (paramInt2 == 2) {
      synchronized (this.rapidnetGPUSegmentationSky)
      {
        paramInt1 = this.rapidnetGPUSegmentationSky.deinit();
      }
    }
    while (paramInt1 != 0)
    {
      return false;
      paramInt1 = 0;
    }
    return true;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_SEG_GPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUSegmentationHair)
    {
      this.rapidnetGPUSegmentationHair.deinit();
    }
    synchronized (this.rapidnetGPUSegmentationSky)
    {
      this.rapidnetGPUSegmentationSky.deinit();
      return true;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (isHairSkyGenderModelLoaded())
    {
      if (paramInt1 == 1) {
        synchronized (this.rapidnetGPUSegmentationHair)
        {
          if (this.modelManager.isModelLoaded(1))
          {
            paramBitmap = this.rapidnetGPUSegmentationHair.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          return paramBitmap;
        }
      }
      if (paramInt1 == 2) {
        synchronized (this.rapidnetGPUSegmentationSky)
        {
          if (this.modelManager.isModelLoaded(2))
          {
            paramBitmap = this.rapidnetGPUSegmentationSky.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
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
    return "TNNSegGpuInitializer";
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
  
  /* Error */
  public boolean loadRapidModelFrom(String paramString1, String arg2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 118
    //   9: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 79	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:isFunctionReady	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +10 -> 28
    //   21: iload 4
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: iload 4
    //   30: istore_3
    //   31: aload_0
    //   32: iconst_0
    //   33: iload 5
    //   35: iload 7
    //   37: invokespecial 120	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 122	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 129
    //   57: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 76	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer;
    //   66: invokevirtual 135	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 139	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 122	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 141
    //   88: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 76	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer;
    //   97: invokevirtual 135	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 139	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_1
    //   104: new 143	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: pop
    //   114: new 143	java/io/File
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: pop
    //   123: iload 4
    //   125: istore_3
    //   126: aload 8
    //   128: invokestatic 150	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   131: ifeq -107 -> 24
    //   134: iload 4
    //   136: istore_3
    //   137: aload_1
    //   138: invokestatic 150	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   141: ifeq -117 -> 24
    //   144: iload 7
    //   146: iconst_1
    //   147: if_icmpne +72 -> 219
    //   150: aload_0
    //   151: getfield 43	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:rapidnetGPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   154: astore_2
    //   155: aload_2
    //   156: monitorenter
    //   157: aload_0
    //   158: getfield 43	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:rapidnetGPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   161: aload_1
    //   162: aload 8
    //   164: ldc 152
    //   166: invokevirtual 156	com/tencent/youtu/rapidnet/library/TNNSeg:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   169: istore 5
    //   171: aload_2
    //   172: monitorexit
    //   173: iload 5
    //   175: ifeq +81 -> 256
    //   178: ldc 8
    //   180: new 122	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   187: ldc 158
    //   189: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 5
    //   194: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 164	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload 4
    //   205: istore_3
    //   206: goto -182 -> 24
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload_2
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: iload 7
    //   221: iconst_2
    //   222: if_icmpne +74 -> 296
    //   225: aload_0
    //   226: getfield 45	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:rapidnetGPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   229: astore_2
    //   230: aload_2
    //   231: monitorenter
    //   232: aload_0
    //   233: getfield 45	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:rapidnetGPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   236: aload_1
    //   237: aload 8
    //   239: ldc 152
    //   241: invokevirtual 156	com/tencent/youtu/rapidnet/library/TNNSeg:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   244: istore 5
    //   246: aload_2
    //   247: monitorexit
    //   248: goto -75 -> 173
    //   251: astore_1
    //   252: aload_2
    //   253: monitorexit
    //   254: aload_1
    //   255: athrow
    //   256: ldc 8
    //   258: new 122	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   265: ldc 166
    //   267: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload 5
    //   272: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 164	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 50	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   285: iload 7
    //   287: iconst_1
    //   288: invokevirtual 170	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   291: iconst_1
    //   292: istore_3
    //   293: goto -269 -> 24
    //   296: iconst_m1
    //   297: istore 5
    //   299: goto -126 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	TNNSegGpuInitializer
    //   0	302	1	paramString1	String
    //   0	302	3	paramBoolean1	boolean
    //   0	302	4	paramBoolean2	boolean
    //   0	302	5	paramInt1	int
    //   0	302	6	paramInt2	int
    //   0	302	7	paramInt3	int
    //   72	166	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	209	finally
    //   31	123	209	finally
    //   126	134	209	finally
    //   137	144	209	finally
    //   150	157	209	finally
    //   178	203	209	finally
    //   217	219	209	finally
    //   225	232	209	finally
    //   254	256	209	finally
    //   256	291	209	finally
    //   157	173	214	finally
    //   215	217	214	finally
    //   232	248	251	finally
    //   252	254	251	finally
  }
  
  public void setMode(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (this.rapidnetGPUSegmentationHair)
      {
        if (this.modelManager.isModelLoaded(1)) {
          this.rapidnetGPUSegmentationHair.setMode(paramInt2);
        }
        return;
      }
    }
    if (paramInt1 == 2) {
      synchronized (this.rapidnetGPUSegmentationSky)
      {
        if (this.modelManager.isModelLoaded(2)) {
          this.rapidnetGPUSegmentationSky.setMode(paramInt2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */