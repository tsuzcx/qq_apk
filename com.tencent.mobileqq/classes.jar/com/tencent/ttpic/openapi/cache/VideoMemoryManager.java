package com.tencent.ttpic.openapi.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.cache.CompatibleList;
import com.tencent.ttpic.cache.LoadETCItemManager;
import com.tencent.ttpic.cache.LoadFaceItemManager;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.cache.LoadStickerItemManager;
import com.tencent.ttpic.cache.PreLoader;
import com.tencent.ttpic.filter.juyoujinggame.UKYOGameSetting;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public final class VideoMemoryManager
{
  private static String IMAGE_MEMORY_BLACE_LIST = "HUAWEI;HUAWEI MT7-CL00;19|HUAWEI;HUAWEI MT7-CL00;23|Samsung;SM-A8000;22|Samsung;SM-A8000;23|Xiaomi;MI 3;19|Xiaomi;Redmi Note 3;21|vivo;vivo X5V;19|vivo;vivo X5Max V;19|Xiaomi;Redmi 3;22|vivo;vivo Y75A;25|samsung;SM-C5000;23|HUAWEI;CAM-TL00;23";
  private static final String TAG = "VideoMemoryManager";
  public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 30720;
  public static final int VIDEO_CACHE_MEM_CACHE_REMAIN_SIZE = 10240;
  private static boolean forceLoadFromSdCard;
  private static final VideoMemoryManager mInstance = new VideoMemoryManager();
  private final Map<String, Bitmap> mBeautyFaceCache = new ConcurrentHashMap();
  private final List<String> mBeautyFaceCacheKeys = new CopyOnWriteArrayList();
  private final Map<String, Bitmap> mCache = new ConcurrentHashMap();
  private double mCurMaterialSizeInMB;
  private final Map<String, ETC1Util.ETC1Texture> mETCCache = new ConcurrentHashMap();
  private final Map<FaceOffUtil.FeatureType, Bitmap> mGrayCache = new ConcurrentHashMap();
  private final Handler mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.VIDEO_MEMORY_MANAGER).getLooper());
  private int mMaxPreloadSizeInKB;
  private int mSampleSize;
  private final Map<String, LoadItemManager> mStickerManagers = new ConcurrentHashMap();
  private String mVideoPath = null;
  private final Map<String, Bitmap> mWM260Cache = new ConcurrentHashMap();
  private final Map<String, LoadItemManager> mWM260Managers = new ConcurrentHashMap();
  
  private void addExtraStickerParser(VideoMaterial paramVideoMaterial, List<StickerItem> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        if ((!VideoMaterial.isEmptyItem(localStickerItem)) && (!this.mStickerManagers.containsKey(localStickerItem.id))) {
          if (ExtraStickerParserAgent.getInstance().isInExtraParser(localStickerItem.stickerType)) {
            this.mStickerManagers.put(localStickerItem.id, new LoadExtraStickerParserManager(paramVideoMaterial.getDataPath(), localStickerItem));
          } else if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            this.mStickerManagers.put(localStickerItem.id, new LoadPagItemManager(paramVideoMaterial.getDataPath(), localStickerItem));
          }
        }
      }
    }
  }
  
  public static VideoMemoryManager getInstance()
  {
    return mInstance;
  }
  
  private long getMaterialImageSizeInKB(VideoMaterial paramVideoMaterial)
  {
    long l2 = 0L;
    if (paramVideoMaterial == null) {
      return 0L;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    if (paramVideoMaterial.getItemList() != null)
    {
      localObject2 = paramVideoMaterial.getItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type != VideoFilterFactory.POSITION_TYPE.SKYBOX.type) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
        if (((FabbyMvPart)localObject3).bgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
        }
        if (((FabbyMvPart)localObject3).fgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
        }
        if (((FabbyMvPart)localObject3).coverItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
        }
        if (((FabbyMvPart)localObject3).transitionItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getStickerItems() != null)) {
          ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StickerItem)((Iterator)localObject1).next();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramVideoMaterial.getDataPath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(((StickerItem)localObject2).subFolder);
      l2 += VideoMaterial.getAllImageSize(((StringBuilder)localObject3).toString()) / 1024;
    }
    long l1 = l2;
    if (paramVideoMaterial.getFaceOffItemList() != null)
    {
      localObject1 = paramVideoMaterial.getFaceOffItemList().iterator();
      for (;;)
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FaceItem)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(((FaceItem)localObject2).id))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramVideoMaterial.getDataPath());
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(((FaceItem)localObject2).id);
          l2 += VideoMaterial.getAllImageSize(((StringBuilder)localObject3).toString()) / 1024;
        }
      }
    }
    l2 = l1;
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject1 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      do
      {
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FaceFeatureItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((FaceFeatureItem)localObject2).getFaceOffItemList() == null));
      localObject2 = ((FaceFeatureItem)localObject2).getFaceOffItemList().iterator();
      l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (FaceItem)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((FaceItem)localObject3).id))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramVideoMaterial.getDataPath());
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((FaceItem)localObject3).id);
          l2 += VideoMaterial.getAllImageSize(localStringBuilder.toString()) / 1024;
        }
      }
    }
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
    l1 = l2;
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      for (;;)
      {
        l1 = l2;
        if (!paramVideoMaterial.hasNext()) {
          break;
        }
        localObject1 = (MultiViewerItem)paramVideoMaterial.next();
        if (localObject1 != null) {
          l2 += getMaterialImageSizeInKB(((MultiViewerItem)localObject1).videoMaterial);
        }
      }
    }
    return l1;
  }
  
  public static boolean isInBlackList()
  {
    return CompatibleList.isFoundProductFeature(IMAGE_MEMORY_BLACE_LIST);
  }
  
  private ArrayList<StickerItem> loadAllItems(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      localArrayList.addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      localArrayList.addAll(paramVideoMaterial.getHeadCropItemList());
    }
    Iterator localIterator;
    Object localObject;
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localIterator = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (localIterator.hasNext())
      {
        localObject = (FabbyMvPart)localIterator.next();
        if (((FabbyMvPart)localObject).bgItem != null) {
          localArrayList.add(((FabbyMvPart)localObject).bgItem);
        }
        if (((FabbyMvPart)localObject).fgItem != null) {
          localArrayList.add(((FabbyMvPart)localObject).fgItem);
        }
        if (((FabbyMvPart)localObject).coverItem != null) {
          localArrayList.add(((FabbyMvPart)localObject).coverItem);
        }
        if (((FabbyMvPart)localObject).transitionItem != null) {
          localArrayList.add(((FabbyMvPart)localObject).transitionItem);
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localIterator = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceFeatureItem)localIterator.next();
        if ((localObject != null) && (((FaceFeatureItem)localObject).getStickerItems() != null)) {
          localArrayList.addAll(((FaceFeatureItem)localObject).getStickerItems());
        }
      }
    }
    if (paramVideoMaterial.getUkyoGameSetting() != null) {
      localArrayList.addAll(paramVideoMaterial.getUkyoGameSetting().getItems());
    }
    return localArrayList;
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt)
  {
    loadAllItemsAppend(paramVideoMaterial, paramInt, loadAllItems(paramVideoMaterial));
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt, List<StickerItem> paramList)
  {
    if (paramVideoMaterial == null) {
      return;
    }
    Iterator localIterator1;
    Object localObject2;
    Object localObject1;
    if (paramVideoMaterial.getFaceOffItemList() != null)
    {
      localIterator1 = paramVideoMaterial.getFaceOffItemList().iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (FaceItem)localIterator1.next();
        if (!VideoMaterial.isEmptyItem((FaceItem)localObject2))
        {
          if (TextUtils.isEmpty(((FaceItem)localObject2).id)) {
            localObject1 = ((FaceItem)localObject2).faceExchangeImage;
          } else {
            localObject1 = ((FaceItem)localObject2).id;
          }
          this.mStickerManagers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, paramVideoMaterial.getDataPath(), (FaceItem)localObject2, paramInt));
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localIterator1 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (FaceFeatureItem)localIterator1.next();
        if ((localObject2 != null) && (((FaceFeatureItem)localObject2).getFaceOffItemList() != null))
        {
          Iterator localIterator2 = ((FaceFeatureItem)localObject2).getFaceOffItemList().iterator();
          while (localIterator2.hasNext())
          {
            FaceItem localFaceItem = (FaceItem)localIterator2.next();
            if (!VideoMaterial.isEmptyItem(localFaceItem))
            {
              if (TextUtils.isEmpty(localFaceItem.id)) {
                localObject1 = localFaceItem.faceExchangeImage;
              } else {
                localObject1 = localFaceItem.id;
              }
              this.mStickerManagers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, ((FaceFeatureItem)localObject2).getDataPath(), localFaceItem, paramInt));
            }
          }
        }
      }
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (StickerItem)paramList.next();
        if ((!VideoMaterial.isEmptyItem((StickerItem)localObject1)) && (!this.mStickerManagers.containsKey(((StickerItem)localObject1).id)) && (((StickerItem)localObject1).type != VideoFilterFactory.POSITION_TYPE.SKYBOX.type)) {
          if (ExtraStickerParserAgent.getInstance().isInExtraParser(((StickerItem)localObject1).stickerType)) {
            this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadExtraStickerParserManager(paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
          } else if (((StickerItem)localObject1).stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type) {
            this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadETCItemManager(this.mETCCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
          } else if (((StickerItem)localObject1).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadPagItemManager(paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
          } else {
            this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadStickerItemManager(this.mCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject1, LoadItemManager.LOAD_TYPE.LOAD_ALL, paramInt));
          }
        }
      }
    }
  }
  
  private void loadImportMaterial(VideoMaterial paramVideoMaterial, int paramInt)
  {
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
      if (localMultiViewerItem != null) {
        loadAllItemsAppend(localMultiViewerItem.videoMaterial, paramInt);
      }
    }
  }
  
  public void clear()
  {
    ??? = this.mStickerManagers.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((LoadItemManager)((Iterator)???).next()).clear();
    }
    this.mStickerManagers.clear();
    synchronized (PreLoader.LOCK_IMAGE_PRE_LOADER)
    {
      Iterator localIterator = this.mCache.values().iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      localIterator = this.mGrayCache.values().iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      this.mCache.clear();
      this.mGrayCache.clear();
      this.mCurMaterialSizeInMB = 0.0D;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void clearBeautyCache()
  {
    this.mBeautyFaceCacheKeys.clear();
    Iterator localIterator = this.mBeautyFaceCache.values().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    this.mBeautyFaceCache.clear();
  }
  
  public void clearWM260()
  {
    Iterator localIterator = this.mWM260Managers.values().iterator();
    while (localIterator.hasNext()) {
      ((LoadItemManager)localIterator.next()).clear();
    }
    this.mWM260Managers.clear();
    localIterator = this.mWM260Cache.values().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    this.mWM260Cache.clear();
  }
  
  public Bitmap getBeautyCacheBitmap(String paramString)
  {
    if (this.mBeautyFaceCacheKeys.contains(paramString)) {
      return (Bitmap)this.mBeautyFaceCache.get(paramString);
    }
    Bitmap localBitmap = FeatureManager.Features.MASK_IMAGES.getBitmap(paramString);
    if (BitmapUtils.isLegal(localBitmap)) {
      if ((this.mBeautyFaceCache.containsKey(paramString)) && (BitmapUtils.isLegal((Bitmap)this.mBeautyFaceCache.get(paramString))))
      {
        localBitmap.recycle();
      }
      else
      {
        this.mBeautyFaceCache.put(paramString, localBitmap);
        this.mBeautyFaceCacheKeys.add(paramString);
      }
    }
    return (Bitmap)this.mBeautyFaceCache.get(paramString);
  }
  
  public double getMaterialSizeInMB()
  {
    return this.mCurMaterialSizeInMB;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public String getVideoPath()
  {
    return this.mVideoPath;
  }
  
  public void initInGLThread(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadExtraStickerParserManager))) {
      ((LoadExtraStickerParserManager)paramString).initInGLThread(paramInt);
    }
  }
  
  public boolean isExtraStickerBitmap(String paramString)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadExtraStickerParserManager))) {
      return ((LoadExtraStickerParserManager)paramString).isBitmap();
    }
    return false;
  }
  
  public boolean isForceLoadFromSdCard()
  {
    return forceLoadFromSdCard;
  }
  
  public void loadAllImages(VideoMaterial paramVideoMaterial)
  {
    clear();
    ArrayList localArrayList = loadAllItems(paramVideoMaterial);
    addExtraStickerParser(paramVideoMaterial, localArrayList);
    this.mHandler.post(new VideoMemoryManager.1(this, paramVideoMaterial, localArrayList));
  }
  
  public void loadBeautyCacheBitmap(String paramString1, String paramString2, Set<String> paramSet, boolean paramBoolean)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!TextUtils.isEmpty(str)) {
        this.mBeautyFaceCacheKeys.add(str);
      }
      if ((!this.mBeautyFaceCache.containsKey(str)) || (!BitmapUtils.isLegal((Bitmap)this.mBeautyFaceCache.get(str)))) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new VideoMemoryManager.2(this, paramString1, paramString2, str, paramBoolean));
      }
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadETCAlphaTexture(paramInt);
    }
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadETCRGBTexture(paramInt);
    }
    return null;
  }
  
  public int loadExtraStickerTxt(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadImage(paramInt2, paramInt1);
    }
    return -1;
  }
  
  public Bitmap loadImage(FaceOffUtil.FeatureType paramFeatureType)
  {
    return (Bitmap)this.mGrayCache.get(paramFeatureType);
  }
  
  public Bitmap loadImage(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadImage(paramInt);
    }
    return null;
  }
  
  public Bitmap loadImage(String paramString1, String paramString2)
  {
    paramString1 = (LoadItemManager)this.mStickerManagers.get(paramString1);
    if (paramString1 != null) {
      return paramString1.loadImage(paramString2);
    }
    return null;
  }
  
  public Bitmap loadWM260Image(String paramString1, String paramString2)
  {
    paramString1 = (LoadItemManager)this.mWM260Managers.get(paramString1);
    if (paramString1 != null) {
      return paramString1.loadImage(paramString2);
    }
    return null;
  }
  
  public void recycleBitmap(String paramString, Bitmap paramBitmap)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadStickerItemManager))) {
      ((LoadStickerItemManager)paramString).recycleBitmap(paramBitmap);
    }
  }
  
  public void reset(String paramString)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      paramString.reset();
    }
  }
  
  public void setForceLoadFromSdCard(boolean paramBoolean)
  {
    forceLoadFromSdCard = paramBoolean;
  }
  
  public void setMaxPreloadMemorySizeInKB(int paramInt)
  {
    this.mMaxPreloadSizeInKB = paramInt;
  }
  
  public void setVideoPath(String paramString)
  {
    this.mVideoPath = paramString;
  }
  
  public void updateCache(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      Map localMap = this.mStickerManagers;
      if (localMap == null) {
        return;
      }
      paramString1 = (LoadItemManager)localMap.get(paramString1);
      if ((paramString1 != null) && ((paramString1 instanceof LoadStickerItemManager))) {
        ((LoadStickerItemManager)paramString1).updateCache(paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager
 * JD-Core Version:    0.7.0.1
 */