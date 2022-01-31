package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LoadStickerItemManager3D
  implements LoadItemManager
{
  private static final int CAPACITY = 5;
  public static final Comparator<String> mPngComperator = new LoadStickerItemManager3D.2();
  private String dataPath;
  private StickerItem3D item;
  private LoadItemManager.LOAD_TYPE loadType;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private PreLoader mPreLoader;
  private String realItemId;
  
  public LoadStickerItemManager3D(String paramString1, StickerItem3D paramStickerItem3D, String paramString2, LoadItemManager.LOAD_TYPE paramLOAD_TYPE)
  {
    this.dataPath = paramString1;
    this.item = paramStickerItem3D;
    this.realItemId = paramString2;
    if (paramStickerItem3D.markMode != 0)
    {
      this.loadType = LoadItemManager.LOAD_TYPE.LOAD_ALL;
      return;
    }
    this.loadType = paramLOAD_TYPE;
  }
  
  private String getImageFileExtension(String paramString)
  {
    paramString = new File(paramString).listFiles(new LoadStickerItemManager3D.1(this));
    if ((paramString != null) && (paramString.length >= 1))
    {
      paramString = paramString[0].getName().split("\\.");
      if ((paramString != null) && (paramString.length == 2)) {
        return paramString[1];
      }
    }
    return "png";
  }
  
  public void clear()
  {
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    if (this.mPreLoader != null) {
      this.mPreLoader.clear();
    }
    GamePlaySDK.getInstance().clearItemImage();
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    return null;
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
    if ((this.loadType == LoadItemManager.LOAD_TYPE.LOAD_ALL) && (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE))
    {
      ArrayList localArrayList = new ArrayList(this.item.frames);
      if (TextUtils.isEmpty(this.item.extension)) {
        this.item.extension = getImageFileExtension(this.dataPath + File.separator + this.realItemId);
      }
      int i = 0;
      while (i < this.item.frames)
      {
        localArrayList.add(this.realItemId + File.separator + this.realItemId + "_" + i + "." + this.item.extension);
        i += 1;
      }
      Collections.sort(localArrayList, mPngComperator);
      this.mImageTask = new LoadImageTask3D(this.dataPath, localArrayList);
      this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public void reset()
  {
    if (this.mPreLoader != null) {
      this.mPreLoader.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager3D
 * JD-Core Version:    0.7.0.1
 */