package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.filter.CopyFilter;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavsticker.model.TAVSourceImage;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;

class PagAutomaticRenderContext
  extends TAVStickerRenderContext
{
  private Map<String, List<TAVStickerImageItem>> a = new ConcurrentHashMap();
  private CopyFilter b = new CopyFilter();
  private TextureInfo c;
  private long d = -1L;
  private List<TAVSourceImage> e = null;
  
  private long a(long paramLong, TAVStickerProvider paramTAVStickerProvider)
  {
    paramLong = TimeUtil.milli2Us(paramLong);
    long l1 = this.rootComposition.duration();
    float f = this.rootComposition.frameRate();
    long l2 = ((float)l1 * f / 1000000.0F) - ((float)paramLong * f / 1000000.0F);
    l1 = b(paramLong, paramTAVStickerProvider);
    paramLong = l1;
    if (l2 >= 0L)
    {
      paramLong = l1;
      if (l2 <= 4L) {
        paramLong = Math.abs(l1 - l1 % 1000000L);
      }
    }
    return paramLong;
  }
  
  private boolean a(long paramLong, List<TAVSourceImage> paramList, TAVSticker paramTAVSticker)
  {
    if ((!CollectionUtil.isEmptyList(paramList)) && (paramTAVSticker != null))
    {
      Object localObject1 = (List)this.a.get(paramTAVSticker.getUniqueId());
      int i;
      if (!CollectionUtil.isEmptyList((List)localObject1)) {
        i = ((List)localObject1).size();
      } else {
        i = 0;
      }
      int k = paramList.size();
      int j = 0;
      while ((j < i) && (j < k))
      {
        localObject2 = (TAVSourceImage)paramList.get(j);
        if ((localObject2 != null) && (((List)localObject1).get(j) != null)) {
          ((TAVSourceImage)localObject2).setIndex(((TAVStickerImageItem)((List)localObject1).get(j)).getLayerIndex());
        }
        j += 1;
      }
      localObject1 = new ArrayList();
      Object localObject2 = paramTAVSticker.getStickerLayerInfos().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TAVStickerLayerInfo localTAVStickerLayerInfo = (TAVStickerLayerInfo)((Iterator)localObject2).next();
        if (a(localTAVStickerLayerInfo)) {
          ((List)localObject1).add(localTAVStickerLayerInfo);
        }
      }
      boolean bool = "sticker_video_transition".equals(paramTAVSticker.getExtraBundle().getString("key_extra_sticker_type"));
      if ((CollectionUtil.isEmptyList((List)localObject1)) && (bool))
      {
        localObject2 = paramTAVSticker.getStickerImageItems();
        if (((ArrayList)localObject2).size() == 2)
        {
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            ((List)localObject1).add(((TAVStickerImageItem)((ArrayList)localObject2).get(i)).getLayerInfo());
            i += 1;
          }
        }
        return false;
      }
      Collections.sort((List)localObject1, new PagAutomaticRenderContext.1(this));
      float f = paramTAVSticker.getExtraBundle().getFloat("key_extra_sticker_speed", 1.0F);
      if ((bool) && (k == 1) && (((List)localObject1).size() == 2))
      {
        localObject2 = new CMTime(paramLong, 1000).sub(paramTAVSticker.getTimeRange().getStart()).multi(f);
        if ((((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd().bigThan(((TAVStickerLayerInfo)((List)localObject1).get(1)).getTimeRange().getStart())) && (((CMTime)localObject2).bigThan(((TAVStickerLayerInfo)((List)localObject1).get(1)).getTimeRange().getStart())) && (((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd().bigThan((CMTime)localObject2))) {
          return false;
        }
        if (((CMTime)localObject2).sub(((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd()).getTimeUs() >= 0L) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          ((TAVSourceImage)paramList.get(0)).setIndex(1);
        } else {
          ((TAVSourceImage)paramList.get(0)).setIndex(0);
        }
        paramList = new StringBuilder();
        paramList.append("updateIndexForImages: presentationTimeMs = ");
        paramList.append(paramLong);
        paramList.append(", sticker start = ");
        paramList.append(paramTAVSticker.getTimeRange().getStart().getTimeUs() / 1000L);
        paramList.append(",isNextLayer = ");
        paramList.append(bool);
        Log.i("PagAutomaticRenderConte", paramList.toString());
      }
    }
    return true;
  }
  
  public static boolean a(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    boolean bool2 = false;
    if (paramTAVStickerLayerInfo == null) {
      return false;
    }
    paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getUserDataList();
    boolean bool1 = bool2;
    if (paramTAVStickerLayerInfo != null)
    {
      if (paramTAVStickerLayerInfo.isEmpty()) {
        return false;
      }
      Iterator localIterator = paramTAVStickerLayerInfo.iterator();
      do
      {
        Object localObject;
        do
        {
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            paramTAVStickerLayerInfo = (TAVStickerLayerInfo.TAVStickerUserData)localIterator.next();
          } while (paramTAVStickerLayerInfo == null);
          localObject = paramTAVStickerLayerInfo.getData();
        } while (TextUtils.isEmpty((CharSequence)localObject));
        paramTAVStickerLayerInfo = null;
        try
        {
          localObject = new JSONObject((String)localObject);
          paramTAVStickerLayerInfo = (TAVStickerLayerInfo)localObject;
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isLayerFillAble JSONException ");
          localStringBuilder.append(localJSONException.getMessage());
          Logger.e("TAVAutomaticRenderContext", localStringBuilder.toString());
          localJSONException.printStackTrace();
        }
      } while (paramTAVStickerLayerInfo == null);
      bool1 = bool2;
      if (paramTAVStickerLayerInfo.optInt("videoTrack", 0) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long b(long paramLong, TAVStickerProvider paramTAVStickerProvider)
  {
    paramTAVStickerProvider = paramTAVStickerProvider.getSticker();
    if (paramTAVStickerProvider == null) {
      return paramLong;
    }
    paramTAVStickerProvider = paramTAVStickerProvider.getPagFile();
    if (paramTAVStickerProvider == null) {
      return paramLong;
    }
    long l2 = paramTAVStickerProvider.startTime();
    long l1 = paramTAVStickerProvider.duration();
    paramTAVStickerProvider = new StringBuilder();
    paramTAVStickerProvider.append("fixToProviderTimeRange: curUs = ");
    paramTAVStickerProvider.append(paramLong);
    paramTAVStickerProvider.append(", startUs = ");
    paramTAVStickerProvider.append(l2);
    paramTAVStickerProvider.append(", endUs = ");
    paramTAVStickerProvider.append(l1 + l2);
    Log.v("PagAutomaticRenderConte", paramTAVStickerProvider.toString());
    l1 = paramLong;
    if (paramLong - l2 < 10000L) {
      l1 = paramLong + 1000L;
    }
    return l1;
  }
  
  private void d()
  {
    if (this.pagPlayer == null)
    {
      this.pagPlayer = new PAGPlayer();
      this.pagPlayer.setSurface(this.pagSurface);
      if (this.rootComposition != null) {
        this.pagPlayer.setComposition(this.rootComposition);
      }
      resetRenderConfigs();
    }
    if ((this.rootComposition == null) || (this.rootComposition.width() != this.renderSize.width) || (this.rootComposition.height() != this.renderSize.height))
    {
      createCompositionRenderTree();
      this.pagPlayer.setComposition(this.rootComposition);
    }
  }
  
  @Deprecated
  public PagAutomaticRenderContext a()
  {
    PagAutomaticRenderContext localPagAutomaticRenderContext = new PagAutomaticRenderContext();
    localPagAutomaticRenderContext.checkStickerList();
    if (this.stickers != null) {
      localPagAutomaticRenderContext.stickers = this.stickers;
    }
    localPagAutomaticRenderContext.setRenderSize(this.renderSize);
    localPagAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localPagAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
    localPagAutomaticRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localPagAutomaticRenderContext);
    return localPagAutomaticRenderContext;
  }
  
  public CMSampleBuffer a(long paramLong, List<TAVSourceImage> paramList)
  {
    System.currentTimeMillis();
    this.d = Thread.currentThread().getId();
    this.presentationTimeMs = paramLong;
    boolean bool = TAVStickerUtil.isValidCGSize(this.renderSize);
    Object localObject1 = null;
    TAVStickerProvider localTAVStickerProvider = null;
    if (!bool)
    {
      TLog.e("PagAutomaticRenderConte", "renderSticker -> mRenderSize is invalid!");
      return null;
    }
    checkStickerList();
    checkStickerProviderList();
    if (this.stickers.isEmpty()) {
      return null;
    }
    createTavStickerTexture();
    if (this.stickerTexture == null)
    {
      TLog.e("PagAutomaticRenderConte", "renderSticker -> mStickerTexture is null!");
      return null;
    }
    checkStickerList();
    checkStickerProviderList();
    createPagSurface();
    if (this.pagSurface == null) {
      return null;
    }
    d();
    Object localObject2 = this.e;
    if (localObject2 != null) {
      releaseCacheImages((List)localObject2);
    }
    if (this.stickers.size() != this.providers.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    if (!CollectionUtil.isEmptyList(paramList)) {
      this.e = new ArrayList(paramList);
    } else {
      this.e = new ArrayList();
    }
    localObject2 = new ArrayList(paramList);
    if (!CollectionUtil.isEmptyList(this.providers))
    {
      Iterator localIterator = this.providers.iterator();
      int j = 0;
      paramList = localTAVStickerProvider;
      while (localIterator.hasNext())
      {
        localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        if (localTAVStickerProvider != null)
        {
          localObject1 = localTAVStickerProvider.getSticker();
          if (shouldRenderSticker((TAVSticker)localObject1, paramLong))
          {
            bool = "sticker_video_transition".equals(((TAVSticker)localObject1).getExtraBundle().getString("key_extra_sticker_type"));
            if ((j == 0) || (!bool))
            {
              int i = j;
              if (bool) {
                i = 1;
              }
              localObject1 = paramList;
              if (paramList == null) {
                localObject1 = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), false);
              }
              if (!a(paramLong, (List)localObject2, localTAVStickerProvider.getSticker()))
              {
                paramList = (List<TAVSourceImage>)localObject1;
                j = i;
              }
              else
              {
                j = 0;
                while (j < this.rootComposition.numLayers())
                {
                  this.rootComposition.getLayerAt(j).setVisible(false);
                  j += 1;
                }
                localTAVStickerProvider.setRenderSize(this.renderSize);
                localTAVStickerProvider.setPagPlayer(this.pagPlayer);
                localTAVStickerProvider.replaceSourceImages((List)localObject2);
                long l = a(paramLong, localTAVStickerProvider);
                this.rootComposition.setCurrentTime(l);
                paramList = (List<TAVSourceImage>)localObject1;
                j = i;
                if (this.pagPlayer.flush())
                {
                  ((ArrayList)localObject2).clear();
                  paramList = new TAVSourceImage(c(), true, 0);
                  ((ArrayList)localObject2).add(paramList);
                  this.e.add(paramList);
                  paramList = (List<TAVSourceImage>)localObject1;
                  j = i;
                }
              }
            }
          }
        }
      }
      localObject1 = paramList;
      if (paramList != null)
      {
        paramList.setNewFrame(true);
        localObject1 = paramList;
      }
    }
    return localObject1;
  }
  
  public PagAutomaticRenderContext b()
  {
    PagAutomaticRenderContext localPagAutomaticRenderContext = new PagAutomaticRenderContext();
    localPagAutomaticRenderContext.checkStickerList();
    if (this.stickers != null) {
      localPagAutomaticRenderContext.stickers = this.stickers;
    }
    localPagAutomaticRenderContext.setRenderSize(this.renderSize);
    localPagAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localPagAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
    localPagAutomaticRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localPagAutomaticRenderContext);
    localPagAutomaticRenderContext.a = this.a;
    return localPagAutomaticRenderContext;
  }
  
  public TextureInfo c()
  {
    long l = System.nanoTime();
    if (this.c == null) {
      this.c = CIContext.newTextureInfo(this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height);
    }
    this.b.setRenderForScreen(false);
    this.b.setRendererWidth(this.stickerTexture.getTextureInfo().width);
    this.b.setRendererHeight(this.stickerTexture.getTextureInfo().height);
    this.b.setDesTextureInfo(this.c);
    this.b.clearBufferBuffer(-16777216);
    this.b.applyFilter(this.stickerTexture.getTextureInfo());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCopyTextureInfo const time : ");
    localStringBuilder.append(System.nanoTime() - l);
    localStringBuilder.append(" 纳秒");
    TLog.d("PagAutomaticRenderConte", localStringBuilder.toString());
    return this.c;
  }
  
  public void release()
  {
    try
    {
      if (this.d != -1L)
      {
        long l1 = this.d;
        long l2 = Thread.currentThread().getId();
        if (l1 != l2) {
          return;
        }
      }
      super.release();
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
      return;
    }
    finally {}
  }
  
  protected boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    if (this.renderContextDataSource != null) {
      return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
    }
    CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
    if (localCMTimeRange == null) {}
    CMTime localCMTime;
    do
    {
      i = 1;
      break;
      localCMTime = new CMTime(paramLong, 1000);
    } while (((localCMTimeRange.getStart().smallThan(localCMTime)) || (localCMTimeRange.getStart().equalsTo(localCMTime))) && ((localCMTimeRange.getEnd().bigThan(localCMTime)) || (localCMTimeRange.getEnd().equalsTo(localCMTime))));
    int i = 0;
    return (i != 0) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagAutomaticRenderContext
 * JD-Core Version:    0.7.0.1
 */