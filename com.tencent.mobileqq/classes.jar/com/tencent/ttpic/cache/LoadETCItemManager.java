package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.Map;

public class LoadETCItemManager
  implements LoadItemManager
{
  public static int FORMAT_COUNT = 3;
  private String dataPath;
  private StickerItem item;
  private Map<String, ETC1Util.ETC1Texture> mCache;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  
  public LoadETCItemManager(Map<String, ETC1Util.ETC1Texture> paramMap, String paramString, StickerItem paramStickerItem)
  {
    this.dataPath = paramString;
    this.item = paramStickerItem;
    this.mCache = paramMap;
  }
  
  public void clear()
  {
    AsyncTask localAsyncTask = this.mImageTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VideoMaterial.getMaterialId(this.dataPath));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.item.id);
    ((StringBuilder)localObject).append("_");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%0");
    localStringBuilder.append(FORMAT_COUNT);
    localStringBuilder.append("d");
    ((StringBuilder)localObject).append(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(paramInt) }));
    ((StringBuilder)localObject).append("_alpha.pkm");
    localObject = ((StringBuilder)localObject).toString();
    return (ETC1Util.ETC1Texture)this.mCache.get(localObject);
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VideoMaterial.getMaterialId(this.dataPath));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.item.id);
    ((StringBuilder)localObject).append("_");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%0");
    localStringBuilder.append(FORMAT_COUNT);
    localStringBuilder.append("d");
    ((StringBuilder)localObject).append(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(paramInt) }));
    ((StringBuilder)localObject).append(".pkm");
    localObject = ((StringBuilder)localObject).toString();
    return (ETC1Util.ETC1Texture)this.mCache.get(localObject);
  }
  
  public int loadImage(int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return -1;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    return null;
  }
  
  public Bitmap loadImage(String paramString)
  {
    return null;
  }
  
  public void prepareImages()
  {
    Map localMap = this.mCache;
    String str = this.item.id;
    int i = this.item.frames;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dataPath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.item.subFolder);
    localStringBuilder.append(".zip");
    this.mImageTask = new LoadETCTextureTask(localMap, str, i, localStringBuilder.toString(), VideoMaterial.getMaterialId(this.dataPath));
    this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadETCItemManager
 * JD-Core Version:    0.7.0.1
 */