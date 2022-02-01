package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSeg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNSegCpuInitializer
  extends Feature
{
  private static final String TAG = "RapidNetSegCpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg") };
  private final TNNSeg TNNSegHair = new TNNSeg();
  private final TNNSeg TNNSegSky = new TNNSeg();
  private boolean isUseCpuLib = false;
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  
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
        synchronized (this.TNNSegHair)
        {
          paramInt1 = this.TNNSegHair.deinit();
        }
      }
      if (paramInt2 == 2) {
        synchronized (this.TNNSegSky)
        {
          paramInt1 = this.TNNSegSky.deinit();
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
    synchronized (this.TNNSegHair)
    {
      this.TNNSegHair.deinit();
    }
    synchronized (this.TNNSegSky)
    {
      this.TNNSegSky.deinit();
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
        synchronized (this.TNNSegHair)
        {
          if (this.modelManager.isModelLoaded(1))
          {
            paramBitmap = this.TNNSegHair.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          return paramBitmap;
        }
      }
      if (paramInt1 == 2) {
        synchronized (this.TNNSegSky)
        {
          if (this.modelManager.isModelLoaded(2))
          {
            paramBitmap = this.TNNSegSky.forwardWithAngle(paramBitmap, paramInt2);
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
  public boolean loadRapidModelFrom(String paramString1, String arg2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 122
    //   9: invokestatic 69	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 83	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:isFunctionReady	()Z
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
    //   32: iconst_1
    //   33: iload 5
    //   35: iload 7
    //   37: invokespecial 124	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 126	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 133
    //   57: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 80	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer;
    //   66: invokevirtual 139	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 143	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 126	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 145
    //   88: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 80	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer;
    //   97: invokevirtual 139	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 143	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_1
    //   104: new 147	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: pop
    //   114: new 147	java/io/File
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: pop
    //   123: iload 4
    //   125: istore_3
    //   126: aload 8
    //   128: invokestatic 154	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   131: ifeq -107 -> 24
    //   134: iload 4
    //   136: istore_3
    //   137: aload_1
    //   138: invokestatic 154	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   141: ifeq -117 -> 24
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 49	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:isUseCpuLib	Z
    //   149: iload 7
    //   151: iconst_1
    //   152: if_icmpne +72 -> 224
    //   155: aload_0
    //   156: getfield 45	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:TNNSegHair	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   159: astore_2
    //   160: aload_2
    //   161: monitorenter
    //   162: aload_0
    //   163: getfield 45	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:TNNSegHair	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   166: aload_1
    //   167: aload 8
    //   169: ldc 156
    //   171: invokevirtual 160	com/tencent/youtu/rapidnet/library/TNNSeg:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   174: istore 5
    //   176: aload_2
    //   177: monitorexit
    //   178: iload 5
    //   180: ifeq +81 -> 261
    //   183: ldc 8
    //   185: new 126	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   192: ldc 162
    //   194: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload 5
    //   199: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iload 4
    //   210: istore_3
    //   211: goto -187 -> 24
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: aload_2
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    //   224: iload 7
    //   226: iconst_2
    //   227: if_icmpne +74 -> 301
    //   230: aload_0
    //   231: getfield 47	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:TNNSegSky	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   234: astore_2
    //   235: aload_2
    //   236: monitorenter
    //   237: aload_0
    //   238: getfield 47	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:TNNSegSky	Lcom/tencent/youtu/rapidnet/library/TNNSeg;
    //   241: aload_1
    //   242: aload 8
    //   244: ldc 156
    //   246: invokevirtual 160	com/tencent/youtu/rapidnet/library/TNNSeg:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   249: istore 5
    //   251: aload_2
    //   252: monitorexit
    //   253: goto -75 -> 178
    //   256: astore_1
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    //   261: ldc 8
    //   263: new 126	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   270: ldc 170
    //   272: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 5
    //   277: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_0
    //   287: getfield 54	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   290: iload 7
    //   292: iconst_1
    //   293: invokevirtual 174	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   296: iconst_1
    //   297: istore_3
    //   298: goto -274 -> 24
    //   301: iconst_m1
    //   302: istore 5
    //   304: goto -126 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	TNNSegCpuInitializer
    //   0	307	1	paramString1	String
    //   0	307	3	paramBoolean1	boolean
    //   0	307	4	paramBoolean2	boolean
    //   0	307	5	paramInt1	int
    //   0	307	6	paramInt2	int
    //   0	307	7	paramInt3	int
    //   72	171	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	214	finally
    //   31	123	214	finally
    //   126	134	214	finally
    //   137	149	214	finally
    //   155	162	214	finally
    //   183	208	214	finally
    //   222	224	214	finally
    //   230	237	214	finally
    //   259	261	214	finally
    //   261	296	214	finally
    //   162	178	219	finally
    //   220	222	219	finally
    //   237	253	256	finally
    //   257	259	256	finally
  }
  
  public void setMode(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (this.TNNSegHair)
      {
        if (this.modelManager.isModelLoaded(1)) {
          this.TNNSegHair.setMode(paramInt2);
        }
        return;
      }
    }
    if (paramInt1 == 2) {
      synchronized (this.TNNSegSky)
      {
        if (this.modelManager.isModelLoaded(2)) {
          this.TNNSegSky.setMode(paramInt2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNSegCpuInitializer
 * JD-Core Version:    0.7.0.1
 */