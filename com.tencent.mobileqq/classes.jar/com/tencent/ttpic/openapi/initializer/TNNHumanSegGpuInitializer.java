package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSegHuman;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNHumanSegGpuInitializer
  extends Feature
{
  private static final String TAG = "TNNHumanSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg_human") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNSegHuman rapidnetGPUSegmentationHuman = new TNNSegHuman();
  
  private boolean isHumanSegModelLoaded()
  {
    return this.modelManager.isModelLoaded(4);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("TNNHumanSegGpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 4) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        paramInt1 = this.rapidnetGPUSegmentationHuman.deinit();
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
    if (FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUSegmentationHuman)
    {
      this.rapidnetGPUSegmentationHuman.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHumanSegModelLoaded()) && (paramInt1 == 4)) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded())
        {
          paramBitmap = this.rapidnetGPUSegmentationHuman.forwardWithAngle(paramBitmap, 0);
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
    return "TNNHumanSegGpuInitializer";
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
  public boolean loadRapidModelFrom(String arg1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
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
    //   13: invokevirtual 76	com/tencent/ttpic/openapi/initializer/TNNHumanSegGpuInitializer:isFunctionReady	()Z
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
    //   37: invokespecial 117	com/tencent/ttpic/openapi/initializer/TNNHumanSegGpuInitializer:unloadRapidNetModelImpl	(ZII)Z
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
    //   63: getstatic 133	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer;
    //   66: invokevirtual 138	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 142	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 119	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 144
    //   88: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 133	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer;
    //   97: invokevirtual 138	com/tencent/ttpic/openapi/initializer/TNNSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 142	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: new 146	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: pop
    //   114: new 146	java/io/File
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: pop
    //   123: iload 4
    //   125: istore_3
    //   126: aload 8
    //   128: invokestatic 153	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   131: ifeq -107 -> 24
    //   134: iload 4
    //   136: istore_3
    //   137: aload_2
    //   138: invokestatic 153	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   141: ifeq -117 -> 24
    //   144: iload 7
    //   146: iconst_4
    //   147: if_icmpne +112 -> 259
    //   150: aload_0
    //   151: getfield 42	com/tencent/ttpic/openapi/initializer/TNNHumanSegGpuInitializer:rapidnetGPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/TNNSegHuman;
    //   154: astore_1
    //   155: aload_1
    //   156: monitorenter
    //   157: aload_0
    //   158: getfield 42	com/tencent/ttpic/openapi/initializer/TNNHumanSegGpuInitializer:rapidnetGPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/TNNSegHuman;
    //   161: aload_2
    //   162: aload 8
    //   164: ldc 155
    //   166: invokevirtual 159	com/tencent/youtu/rapidnet/library/TNNSegHuman:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   169: istore 5
    //   171: aload_1
    //   172: monitorexit
    //   173: iload 5
    //   175: ifeq +44 -> 219
    //   178: ldc 8
    //   180: new 119	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   187: ldc 161
    //   189: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 5
    //   194: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload 4
    //   205: istore_3
    //   206: goto -182 -> 24
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: monitorexit
    //   217: aload_2
    //   218: athrow
    //   219: ldc 8
    //   221: new 119	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   228: ldc 169
    //   230: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 5
    //   235: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield 47	com/tencent/ttpic/openapi/initializer/TNNHumanSegGpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   248: iload 7
    //   250: iconst_1
    //   251: invokevirtual 173	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   254: iconst_1
    //   255: istore_3
    //   256: goto -232 -> 24
    //   259: iconst_m1
    //   260: istore 5
    //   262: goto -89 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	TNNHumanSegGpuInitializer
    //   0	265	2	paramString2	String
    //   0	265	3	paramBoolean1	boolean
    //   0	265	4	paramBoolean2	boolean
    //   0	265	5	paramInt1	int
    //   0	265	6	paramInt2	int
    //   0	265	7	paramInt3	int
    //   72	91	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	209	finally
    //   31	123	209	finally
    //   126	134	209	finally
    //   137	144	209	finally
    //   150	157	209	finally
    //   178	203	209	finally
    //   217	219	209	finally
    //   219	254	209	finally
    //   157	173	214	finally
    //   215	217	214	finally
  }
  
  public void setMode(int paramInt)
  {
    if (isHumanSegModelLoaded()) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded()) {
          this.rapidnetGPUSegmentationHuman.setMode(paramInt);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNHumanSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */