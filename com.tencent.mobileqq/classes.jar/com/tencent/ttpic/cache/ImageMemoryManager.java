package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import com.tencent.ttpic.QQLogUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoDeviceUtil;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ImageMemoryManager
{
  private static String IMAGE_MEMORY_BLACE_LIST = "HUAWEI;HUAWEI MT7-CL00;19|HUAWEI;HUAWEI MT7-CL00;23|Samsung;SM-A8000;22|Samsung;SM-A8000;23|Xiaomi;MI 3;19|Xiaomi;Redmi Note 3;21";
  private static final int REMAIN_LIMIT_MEMORY = 30;
  private static final String TAG = ImageMemoryManager.class.getSimpleName();
  private static boolean inBlackList;
  private static final ImageMemoryManager mInstance = new ImageMemoryManager();
  public float decodeTime = 0.0F;
  private ImageMemoryCache<String, Bitmap> mCache;
  public int mHitCount = 0;
  public Map<String, String> mIdList = new HashMap();
  private long mLastAllocate = 0L;
  private Map<String, ImageItemLoadManager> mLoadManagers = new ConcurrentHashMap();
  public int mUnHitCount = 0;
  
  static
  {
    inBlackList = false;
  }
  
  public ImageMemoryManager()
  {
    isInBlackList();
  }
  
  private long getImageMemoryCacheSize()
  {
    long l2 = VideoDeviceUtil.getRuntimeRemainSize(0) + this.mLastAllocate;
    long l3 = Runtime.getRuntime().maxMemory();
    long l1 = l2;
    if (l2 > l3) {
      l1 = l3;
    }
    l1 = l1 / 1024L / 1024L;
    float f = 0.3333333F;
    if (l1 <= 128L) {}
    for (;;)
    {
      l2 = ((float)l1 * f * 1024.0F * 1024.0F);
      QQLogUtils.i(TAG, "getImageMemoryCacheSize  memory:" + l1 + ", percent:" + f + ", userMemory:" + l2 / 1024L / 1024L + ", lastAllocate:" + this.mLastAllocate / 1024L / 1024L);
      return l2;
      if ((l1 > 128L) && (l1 <= 256L)) {
        f = 0.4F;
      } else if ((l1 > 256L) && (l1 <= 512L)) {
        f = 0.4F;
      } else if (l1 > 512L) {
        f = 0.4F;
      }
    }
  }
  
  public static ImageMemoryManager getInstance()
  {
    return mInstance;
  }
  
  public static boolean isImageFrameItem(String paramString, StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (!paramString.startsWith("assets://")) {
              break;
            }
            paramString = paramString + File.separator + paramStickerItem.subFolder;
          } while (paramStickerItem.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE);
          paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
        } while ((paramString == null) || (paramString.length <= 0));
        return true;
        paramString = paramString + File.separator + paramStickerItem.subFolder;
      } while (paramStickerItem.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE);
      paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  public static boolean isInBlackList()
  {
    inBlackList = CompatibleList.isFoundProductFeature(IMAGE_MEMORY_BLACE_LIST);
    if (inBlackList) {
      QQLogUtils.i(TAG, "hit black list!");
    }
    return inBlackList;
  }
  
  private void removeCacheValue()
  {
    if ((this.mLoadManagers == null) || (this.mCache == null)) {}
    int i;
    label307:
    do
    {
      return;
      i = this.mCache.elementSize();
      if (i < 1)
      {
        QQLogUtils.i(TAG, "removeCacheValue size error!");
        return;
      }
      PriorityQueue localPriorityQueue = new PriorityQueue(i, new Comparator()
      {
        public int compare(ImageItemDeleteInfo paramAnonymousImageItemDeleteInfo1, ImageItemDeleteInfo paramAnonymousImageItemDeleteInfo2)
        {
          return (int)(paramAnonymousImageItemDeleteInfo2.time - paramAnonymousImageItemDeleteInfo1.time);
        }
      });
      localObject1 = null;
      if (this.mCache != null) {
        localObject1 = this.mCache.keySet();
      }
      if (localObject1 == null)
      {
        QQLogUtils.i(TAG, "removeCacheValue keySet empty!");
        return;
      }
      localObject2 = ((Set)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject1 = (String)this.mIdList.get(localObject3);
        if (localObject1 != null)
        {
          localObject1 = (ImageItemLoadManager)this.mLoadManagers.get(localObject1);
          if (localObject1 != null)
          {
            ImageItemLoader localImageItemLoader = ((ImageItemLoadManager)localObject1).mItemLoader;
            if (localImageItemLoader != null)
            {
              j = ImageItemLoader.getImageIndex(ImageItemLoader.getImageName((String)localObject3));
              if (j >= 0)
              {
                if (j >= localImageItemLoader.mCurrentIndex) {}
                for (i = j - localImageItemLoader.mCurrentIndex;; i = localImageItemLoader.item.frames + j - localImageItemLoader.mCurrentIndex)
                {
                  localObject1 = null;
                  if (i >= 0)
                  {
                    localObject1 = new ImageItemDeleteInfo();
                    ((ImageItemDeleteInfo)localObject1).key = ((String)localObject3);
                    ((ImageItemDeleteInfo)localObject1).id = localImageItemLoader.item.id;
                    ((ImageItemDeleteInfo)localObject1).currentIndex = localImageItemLoader.mCurrentIndex;
                    ((ImageItemDeleteInfo)localObject1).time = (i * localImageItemLoader.item.frameDuration);
                    ((ImageItemDeleteInfo)localObject1).index = j;
                  }
                  if (localObject1 == null) {
                    break;
                  }
                  localPriorityQueue.add(localObject1);
                  break;
                }
              }
            }
          }
        }
      }
      i = 0;
      if (this.mCache != null) {
        i = this.mCache.elementSize() / 5;
      }
      if ((i <= 0) || (localPriorityQueue.isEmpty())) {
        break label413;
      }
      localObject1 = (ImageItemDeleteInfo)localPriorityQueue.poll();
      j = i;
      if (localObject1 == null) {
        break;
      }
    } while (this.mCache == null);
    this.mCache.remove(((ImageItemDeleteInfo)localObject1).key);
    int j = i - 1;
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder().append("delete ");
    if (localObject1 != null) {}
    for (Object localObject1 = ((ImageItemDeleteInfo)localObject1).toString();; localObject1 = "")
    {
      QQLogUtils.i((String)localObject2, (String)localObject1 + ", Count:" + j);
      i = j;
      break label307;
      label413:
      break;
    }
  }
  
  private void resetReport()
  {
    QQLogUtils.i(TAG, "hitCount:" + this.mHitCount + ", unHitCount:" + this.mUnHitCount + ", decodeTime:" + this.decodeTime + ", cacheSize:" + getCacheSize() + ", maxSize:" + Runtime.getRuntime().maxMemory() / 1024L / 1024L);
    this.decodeTime = 0.0F;
    this.mHitCount = 0;
    this.mUnHitCount = 0;
  }
  
  public void clear()
  {
    Iterator localIterator = this.mLoadManagers.values().iterator();
    while (localIterator.hasNext()) {
      ((ImageItemLoadManager)localIterator.next()).clear();
    }
    this.mLoadManagers.clear();
    resetReport();
    if (this.mCache != null)
    {
      this.mLastAllocate = this.mCache.getAllocateSize();
      this.mCache.evictAll();
    }
    this.mIdList.clear();
  }
  
  public void evictAll()
  {
    if (this.mCache != null) {
      this.mCache.evictAll();
    }
  }
  
  public long getCacheSize()
  {
    if (this.mCache != null) {
      return this.mCache.getAllocateSize() / 1024L / 1024L;
    }
    return 0L;
  }
  
  public void initCache()
  {
    long l = getImageMemoryCacheSize();
    if (this.mCache == null) {
      this.mCache = new ImageMemoryCache(l)
      {
        public void clearValue()
        {
          ImageMemoryManager.this.removeCacheValue();
        }
        
        public long sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          return paramAnonymousBitmap.getByteCount();
        }
      };
    }
    this.mCache.resize(l);
  }
  
  public void loadAllImages(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    for (;;)
    {
      return;
      clear();
      if ((VideoDeviceUtil.getRuntimeRemainSize(2) < 30L) || (inBlackList))
      {
        QQLogUtils.i(TAG, "memory limit or inBlackList!");
        return;
      }
      initCache();
      Object localObject3 = new ArrayList();
      if (paramVideoMaterial.getItemList() != null) {
        ((List)localObject3).addAll(paramVideoMaterial.getItemList());
      }
      if (paramVideoMaterial.getHeadCropItemList() != null) {
        ((List)localObject3).addAll(paramVideoMaterial.getHeadCropItemList());
      }
      if (paramVideoMaterial.getFabbyMvParts() != null)
      {
        localObject1 = paramVideoMaterial.getFabbyMvParts().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FabbyMvPart)((Iterator)localObject1).next();
          if (((FabbyMvPart)localObject2).bgItem != null) {
            ((List)localObject3).add(((FabbyMvPart)localObject2).bgItem);
          }
          if (((FabbyMvPart)localObject2).fgItem != null) {
            ((List)localObject3).add(((FabbyMvPart)localObject2).fgItem);
          }
          if (((FabbyMvPart)localObject2).coverItem != null) {
            ((List)localObject3).add(((FabbyMvPart)localObject2).coverItem);
          }
          if (((FabbyMvPart)localObject2).transitionItem != null) {
            ((List)localObject3).add(((FabbyMvPart)localObject2).transitionItem);
          }
        }
      }
      Object localObject1 = VideoMaterialUtil.getMaterialId(paramVideoMaterial.getDataPath());
      Object localObject2 = paramVideoMaterial.getDataPath();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        StickerItem localStickerItem = (StickerItem)((Iterator)localObject3).next();
        if (isImageFrameItem((String)localObject2, localStickerItem))
        {
          paramVideoMaterial = ImageItemLoadManager.LOAD_TYPE.LOAD_PRE;
          if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.WATERMARK.type)
          {
            paramVideoMaterial = ImageItemLoadManager.LOAD_TYPE.LOAD_ALL;
            QQLogUtils.i(TAG, "load all:" + localStickerItem.id + ", stickerType:" + localStickerItem.stickerType + ", markMode:" + localStickerItem.markMode);
          }
          this.mLoadManagers.put(localStickerItem.id, new ImageItemLoadManager(this.mCache, (String)localObject1, (String)localObject2, localStickerItem, paramVideoMaterial));
        }
      }
      paramVideoMaterial = this.mLoadManagers.values().iterator();
      while (paramVideoMaterial.hasNext()) {
        ((ImageItemLoadManager)paramVideoMaterial.next()).prepareImages();
      }
    }
  }
  
  public void loadAllItemsAppend(VideoMaterial paramVideoMaterial, List<StickerItem> paramList)
  {
    if ((paramVideoMaterial == null) || (paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      clear();
      if ((VideoDeviceUtil.getRuntimeRemainSize(2) < 30L) || (inBlackList))
      {
        QQLogUtils.i(TAG, "memory limit or inBlackList!");
        return;
      }
      initCache();
      String str = VideoMaterialUtil.getMaterialId(paramVideoMaterial.getDataPath());
      paramVideoMaterial = paramVideoMaterial.getDataPath();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        if (isImageFrameItem(paramVideoMaterial, localStickerItem)) {
          this.mLoadManagers.put(localStickerItem.id, new ImageItemLoadManager(this.mCache, str, paramVideoMaterial, localStickerItem, ImageItemLoadManager.LOAD_TYPE.LOAD_PRE));
        }
      }
      paramVideoMaterial = this.mLoadManagers.values().iterator();
      while (paramVideoMaterial.hasNext()) {
        ((ImageItemLoadManager)paramVideoMaterial.next()).prepareImages();
      }
    }
  }
  
  public Bitmap loadImage(String paramString, int paramInt)
  {
    if (this.mLoadManagers == null) {}
    do
    {
      return null;
      paramString = (ImageItemLoadManager)this.mLoadManagers.get(paramString);
    } while (paramString == null);
    return paramString.loadImage(paramInt);
  }
  
  public Bitmap loadImage(String paramString1, String paramString2)
  {
    if (this.mLoadManagers == null) {}
    do
    {
      return null;
      paramString1 = (ImageItemLoadManager)this.mLoadManagers.get(paramString1);
    } while (paramString1 == null);
    return paramString1.loadImage(paramString2);
  }
  
  public void reset(String paramString)
  {
    if (this.mLoadManagers == null) {}
    do
    {
      return;
      paramString = (ImageItemLoadManager)this.mLoadManagers.get(paramString);
    } while (paramString == null);
    paramString.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageMemoryManager
 * JD-Core Version:    0.7.0.1
 */