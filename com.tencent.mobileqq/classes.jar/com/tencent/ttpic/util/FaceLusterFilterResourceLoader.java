package com.tencent.ttpic.util;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.JsonArray;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.FaceLusterData;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class FaceLusterFilterResourceLoader
{
  public static boolean async = false;
  private static FaceLusterData faceLusterData;
  private static CountDownLatch lock = new CountDownLatch(6);
  
  static
  {
    faceLusterData = new FaceLusterData();
  }
  
  public static FaceLusterData getFaceLusterData()
  {
    if (async)
    {
      try
      {
        lock.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    else
    {
      loadIndices(AEModule.getContext(), "assets://realtimeBeauty", "model_indices");
      loadTexCoords(AEModule.getContext(), "assets://realtimeBeauty", "model_texes");
      loadNormals(AEModule.getContext(), "assets://realtimeBeauty", "model_normals");
      loadMask1();
    }
    return faceLusterData;
  }
  
  public static void load()
  {
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceLusterFilterResourceLoader.1());
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceLusterFilterResourceLoader.2());
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceLusterFilterResourceLoader.3());
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceLusterFilterResourceLoader.4());
  }
  
  private static void loadIndices(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, VideoTemplateParser.decryptListener);
    if (paramContext == null) {
      return;
    }
    paramContext = GsonUtils.optJsonArray(paramContext, "indices");
    if (paramContext != null)
    {
      if (paramContext.size() == 0) {
        return;
      }
      int i = 0;
      while (i < paramContext.size())
      {
        faceLusterData.indices[i] = GsonUtils.optInt(paramContext, i, 0);
        i += 1;
      }
    }
  }
  
  private static void loadMask1()
  {
    faceLusterData.mask1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile("assets://realtimeBeauty/light_mask_2.jpg");
  }
  
  private static void loadNormals(Context paramContext, String paramString1, String paramString2)
  {
    BenchUtil.benchStart("loadNormals");
    paramContext = VideoTemplateParser.decryptListener;
    int i = 0;
    paramContext = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, paramContext);
    if (paramContext == null) {
      return;
    }
    paramContext = GsonUtils.optJsonArray(paramContext, "normals");
    if (paramContext != null)
    {
      if (paramContext.size() == 0) {
        return;
      }
      while (i < paramContext.size())
      {
        faceLusterData.normals[i] = ((float)GsonUtils.optDouble(paramContext, i, 0.0D));
        i += 1;
      }
      BenchUtil.benchEnd("loadNormals");
    }
  }
  
  private static void loadTexCoords(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = VideoTemplateParser.decryptListener;
    int i = 0;
    paramContext = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, paramContext);
    if (paramContext == null) {
      return;
    }
    paramContext = GsonUtils.optJsonArray(paramContext, "texes");
    if (paramContext != null)
    {
      if (paramContext.size() == 0) {
        return;
      }
      while (i < paramContext.size())
      {
        faceLusterData.texCoord[i] = ((float)GsonUtils.optDouble(paramContext, i, 0.0D));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceLusterFilterResourceLoader
 * JD-Core Version:    0.7.0.1
 */