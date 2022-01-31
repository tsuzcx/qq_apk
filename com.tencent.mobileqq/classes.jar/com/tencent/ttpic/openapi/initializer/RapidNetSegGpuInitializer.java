package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetGPUSegmentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RapidNetSegGpuInitializer
  extends Feature
{
  private static final String TAG = "RapidNetSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("Rapidnet"), new SharedLibraryInfo("rapidnet_gpu_segmentation") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetGPUSegmentation rapidnetGPUSegmentationHair = new RapidnetGPUSegmentation();
  private final RapidnetGPUSegmentation rapidnetGPUSegmentationSky = new RapidnetGPUSegmentation();
  
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
    LogUtils.i("RapidNetSegGpuInitializer", "unloadRapidNetModelImpl");
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
    return "RapidNetSegGpuInitializer";
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
  public boolean loadRapidModelFrom(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 116
    //   9: invokestatic 63	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 77	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:isFunctionReady	()Z
    //   16: istore 8
    //   18: iload 8
    //   20: ifne +12 -> 32
    //   23: iload 9
    //   25: istore 8
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 8
    //   31: ireturn
    //   32: iload 9
    //   34: istore 8
    //   36: aload_0
    //   37: iconst_0
    //   38: iload 5
    //   40: iload 7
    //   42: invokespecial 118	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: new 120	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 127
    //   62: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: getstatic 74	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer;
    //   71: invokevirtual 133	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 137	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 120	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 139
    //   93: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 74	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer;
    //   102: invokevirtual 133	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 137	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 141	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 141	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 145	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 147	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 151	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 145	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 147	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 151	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 157	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 157	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: iload 7
    //   210: iconst_1
    //   211: if_icmpne +81 -> 292
    //   214: aload_0
    //   215: getfield 41	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:rapidnetGPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation;
    //   218: astore 10
    //   220: aload 10
    //   222: monitorenter
    //   223: aload_0
    //   224: getfield 41	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:rapidnetGPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation;
    //   227: aload_2
    //   228: aload_1
    //   229: getstatic 161	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation:HAIR_SEG_MODEL	I
    //   232: invokevirtual 165	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation:init	(Ljava/lang/String;Ljava/lang/String;I)I
    //   235: istore 5
    //   237: aload 10
    //   239: monitorexit
    //   240: aload_2
    //   241: invokestatic 168	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   244: iload 5
    //   246: ifeq +87 -> 333
    //   249: ldc 8
    //   251: new 120	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   258: ldc 170
    //   260: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 5
    //   265: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 176	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: iload 9
    //   276: istore 8
    //   278: goto -251 -> 27
    //   281: astore_1
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: aload 10
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: iload 7
    //   294: iconst_2
    //   295: if_icmpne +79 -> 374
    //   298: aload_0
    //   299: getfield 43	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:rapidnetGPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation;
    //   302: astore 10
    //   304: aload 10
    //   306: monitorenter
    //   307: aload_0
    //   308: getfield 43	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:rapidnetGPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation;
    //   311: aload_2
    //   312: aload_1
    //   313: getstatic 161	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation:HAIR_SEG_MODEL	I
    //   316: invokevirtual 165	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation:init	(Ljava/lang/String;Ljava/lang/String;I)I
    //   319: istore 5
    //   321: aload 10
    //   323: monitorexit
    //   324: goto -84 -> 240
    //   327: astore_1
    //   328: aload 10
    //   330: monitorexit
    //   331: aload_1
    //   332: athrow
    //   333: ldc 8
    //   335: new 120	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   342: ldc 178
    //   344: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 5
    //   349: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 176	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload_0
    //   359: getfield 48	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   362: iload 7
    //   364: iconst_1
    //   365: invokevirtual 182	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   368: iconst_1
    //   369: istore 8
    //   371: goto -344 -> 27
    //   374: iconst_m1
    //   375: istore 5
    //   377: goto -137 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	RapidNetSegGpuInitializer
    //   0	380	1	paramString1	String
    //   0	380	2	paramString2	String
    //   0	380	3	paramBoolean1	boolean
    //   0	380	4	paramBoolean2	boolean
    //   0	380	5	paramInt1	int
    //   0	380	6	paramInt2	int
    //   0	380	7	paramInt3	int
    //   16	354	8	bool1	boolean
    //   1	274	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	281	finally
    //   36	130	281	finally
    //   137	151	281	finally
    //   164	178	281	finally
    //   190	197	281	finally
    //   201	208	281	finally
    //   214	223	281	finally
    //   240	244	281	finally
    //   249	274	281	finally
    //   290	292	281	finally
    //   298	307	281	finally
    //   331	333	281	finally
    //   333	368	281	finally
    //   223	240	286	finally
    //   287	290	286	finally
    //   307	324	327	finally
    //   328	331	327	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */