package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
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
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    String str = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format(new StringBuilder().append("%0").append(FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(paramInt) }) + "_alpha.pkm";
    return (ETC1Util.ETC1Texture)this.mCache.get(str);
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    String str = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format(new StringBuilder().append("%0").append(FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(paramInt) }) + ".pkm";
    return (ETC1Util.ETC1Texture)this.mCache.get(str);
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
    this.mImageTask = new LoadETCTextureTask(this.mCache, this.item.id, this.item.frames, this.dataPath + File.separator + this.item.subFolder + ".zip", VideoMaterialUtil.getMaterialId(this.dataPath));
    this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadETCItemManager
 * JD-Core Version:    0.7.0.1
 */