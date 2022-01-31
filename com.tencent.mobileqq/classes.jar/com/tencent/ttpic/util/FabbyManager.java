package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.youtu.android.segmenter.SegmenterLib;
import java.io.File;

public class FabbyManager
{
  private static final String RAPID_MODE = "model.rapidnetmodel";
  private static final String RAPID_PROTO = "deploy.rapidnetproto";
  private static FabbyManager instance = null;
  private static String modelPath = "";
  private boolean gpuSupportOpenCL;
  public SegmenterLib lib;
  
  private FabbyManager()
  {
    initSegmentLib();
  }
  
  /* Error */
  public static FabbyManager getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 22	com/tencent/ttpic/util/FabbyManager:instance	Lcom/tencent/ttpic/util/FabbyManager;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 22	com/tencent/ttpic/util/FabbyManager:instance	Lcom/tencent/ttpic/util/FabbyManager;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/ttpic/util/FabbyManager
    //   21: dup
    //   22: invokespecial 36	com/tencent/ttpic/util/FabbyManager:<init>	()V
    //   25: putstatic 22	com/tencent/ttpic/util/FabbyManager:instance	Lcom/tencent/ttpic/util/FabbyManager;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 22	com/tencent/ttpic/util/FabbyManager:instance	Lcom/tencent/ttpic/util/FabbyManager;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localFabbyManager	FabbyManager
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public static void init()
  {
    getInstance();
  }
  
  private void initSegmentLib()
  {
    File localFile2 = VideoGlobalContext.getContext().getFilesDir();
    File localFile1 = new File(localFile2, "model.rapidnetmodel");
    localFile2 = new File(localFile2, "deploy.rapidnetproto");
    if (!TextUtils.isEmpty(modelPath))
    {
      VideoFileUtil.copyFile(modelPath + "model.rapidnetmodel", localFile1.getAbsolutePath());
      VideoFileUtil.copyFile(modelPath + "deploy.rapidnetproto", localFile2.getAbsolutePath());
      if ((!localFile1.exists()) || (!localFile2.exists())) {
        Log.e("initSegmentLib", "rapid error!");
      }
    }
    for (;;)
    {
      this.lib = new SegmenterLib(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
      this.lib.setNativePtr(this.lib.getNativePtr());
      this.gpuSupportOpenCL = this.lib.isGPUSupportOpenCL();
      return;
      VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "model.rapidnetmodel", localFile1.getAbsolutePath());
      VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "deploy.rapidnetproto", localFile2.getAbsolutePath());
    }
  }
  
  public static void setModelPath(String paramString)
  {
    modelPath = paramString;
  }
  
  public void clearSegmentBuffer()
  {
    this.lib.clearSegmentBuffer();
  }
  
  public void compileKernel()
  {
    this.lib.compileKernel();
  }
  
  public int copyBufferToTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.lib.copyBufferToTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public int copyTextureToBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.lib.copyTextureToBuffer(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean isGPUSupportOpenCL()
  {
    boolean bool2 = false;
    boolean bool3 = VideoPrefsUtil.getDefaultPrefs().getBoolean("prefs_key_segment_on_cpu", false);
    boolean bool1 = bool2;
    if (this.gpuSupportOpenCL)
    {
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Bitmap segment(Bitmap paramBitmap)
  {
    return this.lib.segment(paramBitmap);
  }
  
  public void segmentOnBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.lib.segmentOnBitmap(paramBitmap1, paramBitmap2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int segmentOnTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    return this.lib.segmentOnTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, paramInt6);
  }
  
  public int segmentOnTextureV2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.lib.segmentOnTextureV2(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.FabbyManager
 * JD-Core Version:    0.7.0.1
 */