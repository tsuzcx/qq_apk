package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetCPUSegmentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RapidNetSegCpuInitializer
  extends Feature
{
  private static final String TAG = "RapidNetSegCpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("rapidnet_cpu_common"), new SharedLibraryInfo("rapidnet_cpu_segmentation") };
  private boolean isUseCpuLib = false;
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetCPUSegmentation rapidnetCPUSegmentationHair = new RapidnetCPUSegmentation();
  private final RapidnetCPUSegmentation rapidnetCPUSegmentationSky = new RapidnetCPUSegmentation();
  
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
    LogUtils.i("RapidNetSegCpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 0)
    {
      if (paramInt2 == 1) {
        synchronized (this.rapidnetCPUSegmentationHair)
        {
          paramInt1 = this.rapidnetCPUSegmentationHair.deinit();
        }
      }
      if (paramInt2 == 2) {
        synchronized (this.rapidnetCPUSegmentationSky)
        {
          paramInt1 = this.rapidnetCPUSegmentationSky.deinit();
        }
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
    if (FeatureManager.Features.RAPID_NET_SEG_CPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetCPUSegmentationHair)
    {
      this.rapidnetCPUSegmentationHair.deinit();
    }
    synchronized (this.rapidnetCPUSegmentationSky)
    {
      this.rapidnetCPUSegmentationSky.deinit();
      return true;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, this.isUseCpuLib, this.isUseCpuLib, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (isHairSkyGenderModelLoaded())
    {
      if (paramInt1 == 1) {
        synchronized (this.rapidnetCPUSegmentationHair)
        {
          if (this.modelManager.isModelLoaded(1))
          {
            paramBitmap = this.rapidnetCPUSegmentationHair.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          return paramBitmap;
        }
      }
      if (paramInt1 == 2) {
        synchronized (this.rapidnetCPUSegmentationSky)
        {
          if (this.modelManager.isModelLoaded(2))
          {
            paramBitmap = this.rapidnetCPUSegmentationSky.forwardWithAngle(paramBitmap, paramInt2);
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
    return "RapidNetSegCpuInitializer";
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
    //   7: ldc 120
    //   9: invokestatic 67	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 81	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:isFunctionReady	()Z
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
    //   37: iconst_1
    //   38: iload 5
    //   40: iload 7
    //   42: invokespecial 122	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: new 124	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 131
    //   62: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: getstatic 78	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer;
    //   71: invokevirtual 137	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 141	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 124	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 143
    //   93: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 78	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer;
    //   102: invokevirtual 137	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 141	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 145	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 145	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 149	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 151	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 155	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 149	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 151	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 155	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 161	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 161	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield 47	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:isUseCpuLib	Z
    //   213: iload 7
    //   215: iconst_1
    //   216: if_icmpne +78 -> 294
    //   219: aload_0
    //   220: getfield 43	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:rapidnetCPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation;
    //   223: astore 10
    //   225: aload 10
    //   227: monitorenter
    //   228: aload_0
    //   229: getfield 43	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:rapidnetCPUSegmentationHair	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation;
    //   232: aload_2
    //   233: aload_1
    //   234: invokevirtual 165	com/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation:init	(Ljava/lang/String;Ljava/lang/String;)I
    //   237: istore 5
    //   239: aload 10
    //   241: monitorexit
    //   242: aload_2
    //   243: invokestatic 168	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   246: iload 5
    //   248: ifeq +84 -> 332
    //   251: ldc 8
    //   253: new 124	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   260: ldc 170
    //   262: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 5
    //   267: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 176	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iload 9
    //   278: istore 8
    //   280: goto -253 -> 27
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: aload 10
    //   291: monitorexit
    //   292: aload_1
    //   293: athrow
    //   294: iload 7
    //   296: iconst_2
    //   297: if_icmpne +76 -> 373
    //   300: aload_0
    //   301: getfield 45	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:rapidnetCPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation;
    //   304: astore 10
    //   306: aload 10
    //   308: monitorenter
    //   309: aload_0
    //   310: getfield 45	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:rapidnetCPUSegmentationSky	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation;
    //   313: aload_2
    //   314: aload_1
    //   315: invokevirtual 165	com/tencent/youtu/rapidnet/library/RapidnetCPUSegmentation:init	(Ljava/lang/String;Ljava/lang/String;)I
    //   318: istore 5
    //   320: aload 10
    //   322: monitorexit
    //   323: goto -81 -> 242
    //   326: astore_1
    //   327: aload 10
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    //   332: ldc 8
    //   334: new 124	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   341: ldc 178
    //   343: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 5
    //   348: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 176	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 52	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   361: iload 7
    //   363: iconst_1
    //   364: invokevirtual 182	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   367: iconst_1
    //   368: istore 8
    //   370: goto -343 -> 27
    //   373: iconst_m1
    //   374: istore 5
    //   376: goto -134 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	RapidNetSegCpuInitializer
    //   0	379	1	paramString1	String
    //   0	379	2	paramString2	String
    //   0	379	3	paramBoolean1	boolean
    //   0	379	4	paramBoolean2	boolean
    //   0	379	5	paramInt1	int
    //   0	379	6	paramInt2	int
    //   0	379	7	paramInt3	int
    //   16	353	8	bool1	boolean
    //   1	276	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	283	finally
    //   36	130	283	finally
    //   137	151	283	finally
    //   164	178	283	finally
    //   190	197	283	finally
    //   201	213	283	finally
    //   219	228	283	finally
    //   242	246	283	finally
    //   251	276	283	finally
    //   292	294	283	finally
    //   300	309	283	finally
    //   330	332	283	finally
    //   332	367	283	finally
    //   228	242	288	finally
    //   289	292	288	finally
    //   309	323	326	finally
    //   327	330	326	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetSegCpuInitializer
 * JD-Core Version:    0.7.0.1
 */