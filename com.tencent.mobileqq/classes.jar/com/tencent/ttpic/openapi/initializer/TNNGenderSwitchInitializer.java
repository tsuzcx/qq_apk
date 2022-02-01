package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNGenderSwitch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNGenderSwitchInitializer
  extends Feature
{
  private static final String TAG = "RapidNetGenderSwitchInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_genderswitch") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNGenderSwitch rapidnetGPUGenderSwitch = new TNNGenderSwitch();
  
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
    LogUtils.i("RapidNetGenderSwitchInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 1) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        paramInt1 = this.rapidnetGPUGenderSwitch.deinit();
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
    if (FeatureManager.Features.RAPID_NET_GENDER_SWITCH.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUGenderSwitch)
    {
      this.rapidnetGPUGenderSwitch.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 0)) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(0))
        {
          AEProfiler.getInstance().start("GenderSwitch");
          paramBitmap = this.rapidnetGPUGenderSwitch.forwardWithAngle(paramBitmap, paramInt2);
          long l = AEProfiler.getInstance().end("GenderSwitch");
          AEProfiler.getInstance().add(1, "GenderSwitch", l);
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
    return "RapidNetGenderSwitchInitializer";
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
    //   7: ldc 134
    //   9: invokestatic 62	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 76	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:isFunctionReady	()Z
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
    //   37: invokespecial 136	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 138	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 145
    //   57: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 73	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_GENDER_SWITCH	Lcom/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer;
    //   66: invokevirtual 151	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 155	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 138	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 157
    //   88: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 73	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_GENDER_SWITCH	Lcom/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer;
    //   97: invokevirtual 151	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 155	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: new 159	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: pop
    //   114: new 159	java/io/File
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: pop
    //   123: iload 4
    //   125: istore_3
    //   126: aload 8
    //   128: invokestatic 166	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   131: ifeq -107 -> 24
    //   134: iload 4
    //   136: istore_3
    //   137: aload_2
    //   138: invokestatic 166	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   141: ifeq -117 -> 24
    //   144: aload_0
    //   145: getfield 42	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:rapidnetGPUGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNGenderSwitch;
    //   148: astore_1
    //   149: aload_1
    //   150: monitorenter
    //   151: aload_0
    //   152: getfield 42	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:rapidnetGPUGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNGenderSwitch;
    //   155: aload_2
    //   156: aload 8
    //   158: ldc 168
    //   160: invokevirtual 172	com/tencent/youtu/rapidnet/library/TNNGenderSwitch:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   163: istore 5
    //   165: aload_1
    //   166: monitorexit
    //   167: iload 5
    //   169: ifeq +44 -> 213
    //   172: ldc 8
    //   174: new 138	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   181: ldc 174
    //   183: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload 5
    //   188: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 180	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: iload 4
    //   199: istore_3
    //   200: goto -176 -> 24
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    //   208: astore_2
    //   209: aload_1
    //   210: monitorexit
    //   211: aload_2
    //   212: athrow
    //   213: ldc 8
    //   215: new 138	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   222: ldc 182
    //   224: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload 5
    //   229: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 180	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: getfield 47	com/tencent/ttpic/openapi/initializer/TNNGenderSwitchInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   242: iload 7
    //   244: iconst_1
    //   245: invokevirtual 186	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   248: iconst_1
    //   249: istore_3
    //   250: goto -226 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	TNNGenderSwitchInitializer
    //   0	253	2	paramString2	String
    //   0	253	3	paramBoolean1	boolean
    //   0	253	4	paramBoolean2	boolean
    //   0	253	5	paramInt1	int
    //   0	253	6	paramInt2	int
    //   0	253	7	paramInt3	int
    //   72	85	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	203	finally
    //   31	123	203	finally
    //   126	134	203	finally
    //   137	151	203	finally
    //   172	197	203	finally
    //   211	213	203	finally
    //   213	248	203	finally
    //   151	167	208	finally
    //   209	211	208	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer
 * JD-Core Version:    0.7.0.1
 */