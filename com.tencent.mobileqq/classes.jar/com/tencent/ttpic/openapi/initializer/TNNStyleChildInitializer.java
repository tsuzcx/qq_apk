package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNStyleChild;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNStyleChildInitializer
  extends Feature
{
  private static final String TAG = "TNNStyleChildInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_stylechild") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private String modelMd5;
  private String protoMd5;
  private final TNNStyleChild tnnGenderSwitch = new TNNStyleChild();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    return this.modelManager.isModelLoaded(6);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("TNNStyleChildInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 6) {
      synchronized (this.tnnGenderSwitch)
      {
        this.modelManager.clear();
        paramInt1 = this.tnnGenderSwitch.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public int addInitMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addInitMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPostMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPostMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPreMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPreMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public float[] averageFaceColorUsingFacePoints(Bitmap paramBitmap, List<PointF> paramList)
  {
    float[] arrayOfFloat1 = new float[paramList.size()];
    float[] arrayOfFloat2 = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat1[i] = ((PointF)paramList.get(i)).x;
      arrayOfFloat2[i] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return this.tnnGenderSwitch.averageFaceColorUsingFacePoints(paramBitmap, arrayOfFloat1, arrayOfFloat2);
  }
  
  public float[] computeFaceCropTransform(List<PointF> paramList, int paramInt1, float paramFloat, float[] paramArrayOfFloat1, int paramInt2, int paramInt3, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1 = new float[paramList.size()];
    float[] arrayOfFloat2 = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat1[i] = ((PointF)paramList.get(i)).x;
      arrayOfFloat2[i] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return this.tnnGenderSwitch.computeFaceCropTransform(arrayOfFloat1, arrayOfFloat2, paramInt1, paramFloat, paramArrayOfFloat1, paramInt2, paramInt3, paramArrayOfFloat2);
  }
  
  public int convertBitmapToFloat(int paramInt, Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.convertBitmapToFloat(paramBitmap, paramArrayOfFloat);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public Bitmap convertFloatToBitmap(int paramInt, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramArrayOfFloat = this.tnnGenderSwitch.convertFloatToBitmap(paramArrayOfFloat);
          return paramArrayOfFloat;
        }
      }
    }
    return null;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.tnnGenderSwitch)
    {
      this.modelManager.clear();
      this.tnnGenderSwitch.deinit();
      return true;
    }
  }
  
  public int forward(int paramInt1, int paramInt2)
  {
    return forward(paramInt1, false, false, paramInt2);
  }
  
  public int forward(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.forwardTwoOutput();
          return paramInt1;
        }
      }
    }
    return -1;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getModelMd5()
  {
    return this.modelMd5;
  }
  
  public String getName()
  {
    return "TNNStyleChildInitializer";
  }
  
  public String getProtoMd5()
  {
    return this.protoMd5;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public int initProcess(int paramInt)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.initProcess();
          return paramInt;
        }
      }
    }
    return -1;
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
    //   7: ldc 180
    //   9: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 135	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:isFunctionReady	()Z
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
    //   37: invokespecial 182	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: new 184	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 191
    //   57: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: getstatic 132	com/tencent/ttpic/openapi/manager/FeatureManager$Features:TNN_STYLE_CHILD_INITIALIZER	Lcom/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer;
    //   66: invokevirtual 197	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   69: invokestatic 201	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_1
    //   75: new 184	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   82: aload_2
    //   83: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 203
    //   88: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: getstatic 132	com/tencent/ttpic/openapi/manager/FeatureManager$Features:TNN_STYLE_CHILD_INITIALIZER	Lcom/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer;
    //   97: invokevirtual 197	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   100: invokestatic 201	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_1
    //   104: new 205	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore_2
    //   114: aload_0
    //   115: new 205	java/io/File
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 212	com/tencent/ttpic/baseutils/encrypt/MD5Util:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   126: putfield 160	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:protoMd5	Ljava/lang/String;
    //   129: aload_0
    //   130: aload_2
    //   131: invokestatic 212	com/tencent/ttpic/baseutils/encrypt/MD5Util:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   134: putfield 156	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:modelMd5	Ljava/lang/String;
    //   137: iload 4
    //   139: istore_3
    //   140: aload 8
    //   142: invokestatic 218	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   145: ifeq -121 -> 24
    //   148: iload 4
    //   150: istore_3
    //   151: aload_1
    //   152: invokestatic 218	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   155: ifeq -131 -> 24
    //   158: aload_0
    //   159: getfield 44	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:tnnGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNStyleChild;
    //   162: astore_2
    //   163: aload_2
    //   164: monitorenter
    //   165: aload_0
    //   166: getfield 44	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:tnnGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNStyleChild;
    //   169: aload_1
    //   170: aload 8
    //   172: ldc 220
    //   174: invokevirtual 224	com/tencent/youtu/rapidnet/library/TNNStyleChild:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   177: istore 5
    //   179: aload_2
    //   180: monitorexit
    //   181: iload 5
    //   183: ifeq +44 -> 227
    //   186: ldc 8
    //   188: new 184	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   195: ldc 226
    //   197: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 5
    //   202: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 232	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: iload 4
    //   213: istore_3
    //   214: goto -190 -> 24
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aload_2
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    //   227: ldc 8
    //   229: new 184	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   236: ldc 234
    //   238: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: iload 5
    //   243: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 232	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: getfield 49	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   256: iload 7
    //   258: iconst_1
    //   259: invokevirtual 238	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   262: iconst_1
    //   263: istore_3
    //   264: goto -240 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	TNNStyleChildInitializer
    //   0	267	1	paramString1	String
    //   0	267	3	paramBoolean1	boolean
    //   0	267	4	paramBoolean2	boolean
    //   0	267	5	paramInt1	int
    //   0	267	6	paramInt2	int
    //   0	267	7	paramInt3	int
    //   72	99	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	17	217	finally
    //   31	137	217	finally
    //   140	148	217	finally
    //   151	165	217	finally
    //   186	211	217	finally
    //   225	227	217	finally
    //   227	262	217	finally
    //   165	181	222	finally
    //   223	225	222	finally
  }
  
  public float[] pixelLUT(Bitmap paramBitmap, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean)
  {
    return this.tnnGenderSwitch.pixelLUT(paramBitmap, paramArrayOfFloat, paramFloat, paramBoolean);
  }
  
  public int setParams(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.setParams(paramString1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramArrayOfFloat6);
          return paramInt1;
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer
 * JD-Core Version:    0.7.0.1
 */