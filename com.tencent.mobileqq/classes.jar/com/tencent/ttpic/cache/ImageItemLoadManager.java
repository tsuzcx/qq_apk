package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageItemLoadManager
{
  private static final int capacity = 5;
  public static final Comparator<String> mPngComperator = new Comparator()
  {
    private int getFrameIndex(String paramAnonymousString)
    {
      return Integer.parseInt(paramAnonymousString.substring(paramAnonymousString.lastIndexOf('_') + 1, paramAnonymousString.lastIndexOf('.')));
    }
    
    private String getImageName(String paramAnonymousString)
    {
      return paramAnonymousString.substring(0, paramAnonymousString.lastIndexOf('_'));
    }
    
    public int compare(String paramAnonymousString1, String paramAnonymousString2)
    {
      try
      {
        String str1 = getImageName(paramAnonymousString1);
        String str2 = getImageName(paramAnonymousString2);
        if (str1.equals(str2)) {
          return getFrameIndex(paramAnonymousString1) - getFrameIndex(paramAnonymousString2);
        }
        int i = str1.compareTo(str2);
        return i;
      }
      catch (Exception paramAnonymousString1) {}
      return 0;
    }
  };
  private String dataPath;
  private StickerItem item;
  private LOAD_TYPE loadType;
  private ImageMemoryCache<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  public ImageItemLoader mItemLoader;
  private String materialId;
  
  public ImageItemLoadManager(ImageMemoryCache<String, Bitmap> paramImageMemoryCache, String paramString1, String paramString2, StickerItem paramStickerItem, LOAD_TYPE paramLOAD_TYPE)
  {
    this.mCache = paramImageMemoryCache;
    this.materialId = paramString1;
    this.dataPath = paramString2;
    this.item = paramStickerItem;
    if (paramStickerItem.markMode != 0)
    {
      this.loadType = LOAD_TYPE.LOAD_ALL;
      return;
    }
    this.loadType = paramLOAD_TYPE;
  }
  
  public void clear()
  {
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
  }
  
  public Bitmap loadImage(int paramInt)
  {
    if (this.mItemLoader != null) {
      return this.mItemLoader.loadImage(paramInt);
    }
    return null;
  }
  
  public Bitmap loadImage(String paramString)
  {
    paramString = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + paramString;
    return (Bitmap)this.mCache.get(paramString);
  }
  
  public void prepareImages()
  {
    if (this.loadType == LOAD_TYPE.LOAD_ALL) {
      if (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
      {
        i = VideoMaterialUtil.getAllImageSize(this.dataPath, this.item);
        if (i > 0)
        {
          i /= 1024;
          k = VideoMaterialUtil.calSampleSize(this.mCache.getMaxSize() / 2L / 1024L, i);
          localHashSet = new HashSet();
          localArrayList = new ArrayList(this.item.frames);
          if (this.item.markMode != 0)
          {
            i = 0;
            while (i <= 10)
            {
              j = 0;
              while (j < this.item.frames)
              {
                localArrayList.add(this.item.id + "_" + j + "_" + i + ".png");
                j += 1;
              }
              i += 1;
            }
            i = 0;
            while (i < this.item.frames)
            {
              localArrayList.add(this.item.id + "_" + i + "_x.png");
              i += 1;
            }
          }
          localHashSet.addAll(VideoFileUtil.getAllPngFileNames(this.dataPath + File.separator + this.item.subFolder));
          i = 0;
          while (i < this.item.frames)
          {
            localHashSet.add(this.item.id + "_" + i + ".png");
            i += 1;
          }
          localArrayList.addAll(localHashSet);
          Collections.sort(localArrayList, mPngComperator);
          this.mImageTask = new ImageItemLoadTask(this.mCache, localArrayList, this.dataPath + File.separator + this.item.subFolder, VideoMaterialUtil.getMaterialId(this.dataPath), k);
          this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        }
      }
    }
    while (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
    {
      int i;
      int k;
      HashSet localHashSet;
      ArrayList localArrayList;
      int j;
      return;
    }
    this.mItemLoader = new ImageItemLoader(this.mCache, this.materialId, this.dataPath, this.item, 5);
    this.mItemLoader.prepare();
  }
  
  public void reset()
  {
    if (this.mItemLoader != null) {
      this.mItemLoader.reset();
    }
  }
  
  public static enum LOAD_TYPE
  {
    LOAD_ALL,  LOAD_PRE;
    
    private LOAD_TYPE() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageItemLoadManager
 * JD-Core Version:    0.7.0.1
 */