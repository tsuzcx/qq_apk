package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSegHuman;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNHumanSegCpuInitializer
  extends Feature
{
  private static final String TAG = "TNNHumanSegCpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg_human") };
  private final TNNSegHuman TNNSegHuman = new TNNSegHuman();
  private boolean isUseCpuLib = false;
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  
  private boolean isHumanSegModelLoaded()
  {
    return this.modelManager.isModelLoaded(4);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("TNNHumanSegCpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 4) {
      synchronized (this.TNNSegHuman)
      {
        paramInt1 = this.TNNSegHuman.deinit();
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
    if (FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.TNNSegHuman)
    {
      this.TNNSegHuman.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, this.isUseCpuLib, this.isUseCpuLib, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHumanSegModelLoaded()) && (paramInt1 == 4)) {
      synchronized (this.TNNSegHuman)
      {
        if (isHumanSegModelLoaded())
        {
          paramBitmap = this.TNNSegHuman.forwardWithAngle(paramBitmap, 0);
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
    return "TNNHumanSegCpuInitializer";
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
    //   7: ldc 119
    //   9: invokestatic 66	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 80	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:isFunctionReady	()Z
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
    //   37: invokespecial 121	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 123	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 130
    //   57: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 137	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer;
    //   66: invokevirtual 142	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 146	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 123	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 148
    //   88: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 137	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer;
    //   97: invokevirtual 142	com/tencent/ttpic/openapi/initializer/TNNSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 146	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: new 150	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: pop
    //   114: new 150	java/io/File
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: pop
    //   123: iload 4
    //   125: istore_3
    //   126: aload 8
    //   128: invokestatic 157	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   131: ifeq -107 -> 24
    //   134: iload 4
    //   136: istore_3
    //   137: aload_2
    //   138: invokestatic 157	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   141: ifeq -117 -> 24
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 46	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:isUseCpuLib	Z
    //   149: iload 7
    //   151: iconst_4
    //   152: if_icmpne +112 -> 264
    //   155: aload_0
    //   156: getfield 44	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:TNNSegHuman	Lcom/tencent/youtu/rapidnet/library/TNNSegHuman;
    //   159: astore_1
    //   160: aload_1
    //   161: monitorenter
    //   162: aload_0
    //   163: getfield 44	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:TNNSegHuman	Lcom/tencent/youtu/rapidnet/library/TNNSegHuman;
    //   166: aload_2
    //   167: aload 8
    //   169: ldc 159
    //   171: invokevirtual 163	com/tencent/youtu/rapidnet/library/TNNSegHuman:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   174: istore 5
    //   176: aload_1
    //   177: monitorexit
    //   178: iload 5
    //   180: ifeq +44 -> 224
    //   183: ldc 8
    //   185: new 123	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   192: ldc 165
    //   194: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload 5
    //   199: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 171	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iload 4
    //   210: istore_3
    //   211: goto -187 -> 24
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore_2
    //   220: aload_1
    //   221: monitorexit
    //   222: aload_2
    //   223: athrow
    //   224: ldc 8
    //   226: new 123	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   233: ldc 173
    //   235: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload 5
    //   240: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 171	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_0
    //   250: getfield 51	com/tencent/ttpic/openapi/initializer/TNNHumanSegCpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   253: iload 7
    //   255: iconst_1
    //   256: invokevirtual 177	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   259: iconst_1
    //   260: istore_3
    //   261: goto -237 -> 24
    //   264: iconst_m1
    //   265: istore 5
    //   267: goto -89 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	TNNHumanSegCpuInitializer
    //   0	270	2	paramString2	String
    //   0	270	3	paramBoolean1	boolean
    //   0	270	4	paramBoolean2	boolean
    //   0	270	5	paramInt1	int
    //   0	270	6	paramInt2	int
    //   0	270	7	paramInt3	int
    //   72	96	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	214	finally
    //   31	123	214	finally
    //   126	134	214	finally
    //   137	149	214	finally
    //   155	162	214	finally
    //   183	208	214	finally
    //   222	224	214	finally
    //   224	259	214	finally
    //   162	178	219	finally
    //   220	222	219	finally
  }
  
  public void setMode(int paramInt)
  {
    if (isHumanSegModelLoaded()) {
      synchronized (this.TNNSegHuman)
      {
        if (isHumanSegModelLoaded()) {
          this.TNNSegHuman.setMode(paramInt);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNHumanSegCpuInitializer
 * JD-Core Version:    0.7.0.1
 */