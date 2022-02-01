package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNRGBDepth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNRGBDepthInitializer
  extends Feature
{
  private static final String TAG = "TNNRGBDepthInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_rgb_depth") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNRGBDepth rapidnetRGBDepth = new TNNRGBDepth();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    return this.modelManager.isModelLoaded(7);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("TNNRGBDepthInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 7) {
      synchronized (this.rapidnetRGBDepth)
      {
        paramInt1 = this.rapidnetRGBDepth.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_RGB_DEPTH.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetRGBDepth)
    {
      this.rapidnetRGBDepth.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 7)) {
      synchronized (this.rapidnetRGBDepth)
      {
        if (this.modelManager.isModelLoaded(7))
        {
          paramBitmap = this.rapidnetRGBDepth.forwardWithAngle(paramBitmap, paramInt2);
          return paramBitmap;
        }
        return paramBitmap;
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
    return "TNNRGBDepthInitializer";
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
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 115
    //   9: invokestatic 62	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 76	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:isFunctionReady	()Z
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
    //   37: invokespecial 117	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 119	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 126
    //   57: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 73	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_RGB_DEPTH	Lcom/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer;
    //   66: invokevirtual 132	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 136	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 119	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 138
    //   88: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 73	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_RGB_DEPTH	Lcom/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer;
    //   97: invokevirtual 132	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 136	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: iload 4
    //   106: istore_3
    //   107: aload 8
    //   109: invokestatic 144	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   112: ifeq -88 -> 24
    //   115: iload 4
    //   117: istore_3
    //   118: aload_2
    //   119: invokestatic 144	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   122: ifeq -98 -> 24
    //   125: iload 7
    //   127: bipush 7
    //   129: if_icmpne +129 -> 258
    //   132: iload 6
    //   134: ifne +72 -> 206
    //   137: ldc 146
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 42	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:rapidnetRGBDepth	Lcom/tencent/youtu/rapidnet/library/TNNRGBDepth;
    //   144: astore 9
    //   146: aload 9
    //   148: monitorenter
    //   149: aload_0
    //   150: getfield 42	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:rapidnetRGBDepth	Lcom/tencent/youtu/rapidnet/library/TNNRGBDepth;
    //   153: aload_2
    //   154: aload 8
    //   156: aload_1
    //   157: invokevirtual 150	com/tencent/youtu/rapidnet/library/TNNRGBDepth:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   160: istore 5
    //   162: aload 9
    //   164: monitorexit
    //   165: iload 5
    //   167: ifeq +51 -> 218
    //   170: ldc 8
    //   172: new 119	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   179: ldc 152
    //   181: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: iload 5
    //   186: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 158	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: iload 4
    //   197: istore_3
    //   198: goto -174 -> 24
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: ldc 160
    //   208: astore_1
    //   209: goto -69 -> 140
    //   212: astore_1
    //   213: aload 9
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    //   218: ldc 8
    //   220: new 119	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   227: ldc 162
    //   229: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 5
    //   234: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 158	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 47	com/tencent/ttpic/openapi/initializer/TNNRGBDepthInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   247: iload 7
    //   249: iconst_1
    //   250: invokevirtual 166	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   253: iconst_1
    //   254: istore_3
    //   255: goto -231 -> 24
    //   258: iconst_m1
    //   259: istore 5
    //   261: goto -96 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	TNNRGBDepthInitializer
    //   0	264	1	paramString1	String
    //   0	264	2	paramString2	String
    //   0	264	3	paramBoolean1	boolean
    //   0	264	4	paramBoolean2	boolean
    //   0	264	5	paramInt1	int
    //   0	264	6	paramInt2	int
    //   0	264	7	paramInt3	int
    //   72	83	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	201	finally
    //   31	104	201	finally
    //   107	115	201	finally
    //   118	125	201	finally
    //   140	149	201	finally
    //   170	195	201	finally
    //   216	218	201	finally
    //   218	253	201	finally
    //   149	165	212	finally
    //   213	216	212	finally
  }
  
  public void setMode(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 7) {
      synchronized (this.rapidnetRGBDepth)
      {
        if (this.modelManager.isModelLoaded(7)) {
          this.rapidnetRGBDepth.setMode(paramInt2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNRGBDepthInitializer
 * JD-Core Version:    0.7.0.1
 */