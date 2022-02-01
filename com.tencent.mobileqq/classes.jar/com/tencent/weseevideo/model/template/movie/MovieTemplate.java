package com.tencent.weseevideo.model.template.movie;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.TAVTemplate;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.base.TAVSegmentImageEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVResourceType;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import com.tencent.tavsticker.core.TAVStickerResourceExporter;
import com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import com.tencent.weseevideo.model.utils.FileUtils;
import com.tencent.weseevideo.model.utils.Utils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavmovie.base.TAVMovieClip;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTemplate
  implements TAVTemplate, Serializable
{
  private static final String AUDIO_NAME = "audio";
  private static final String TAG = "MovieTemplate";
  private static final float US_SCALE = 1000000.0F;
  private List<MovieSegment> mCorrectSegments;
  private HashMap<String, String> mDownloadImageMap = new HashMap();
  private String mFilePath;
  private boolean mFirstFill = true;
  private boolean mHasImageLayerSet = false;
  private boolean mHasTextLayerSet = false;
  private boolean mIsAsset;
  private List<TAVStickerResourceExporter.IStickerResourceExportListener> mLoadDataListeners = new ArrayList();
  private volatile boolean mLoadingData = false;
  private boolean mNeedCycleFill = false;
  private List<TAVMovieClip> mOriginClips;
  private String mPackagePath;
  private String mPagAudioPath;
  private List<MovieSegment> mSegments;
  private List<TAVMovieSticker> mStickers;
  private TAVMovieSticker mTemplateSticker;
  private CGSize renderSize = new CGSize(720.0F, 1280.0F);
  
  public MovieTemplate(@NonNull String paramString)
  {
    this(paramString, false);
  }
  
  public MovieTemplate(@NonNull String paramString, boolean paramBoolean)
  {
    this.mFilePath = paramString;
    this.mIsAsset = paramBoolean;
    initData();
  }
  
  private void correctSegments()
  {
    this.mCorrectSegments = new ArrayList(this.mSegments);
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < this.mCorrectSegments.size())
    {
      localObject2 = (MovieSegment)this.mCorrectSegments.get(i);
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject3 = ((MovieSegment)localObject2).getUseTavClips();
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject1 = CMTime.CMTimeZero;
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localObject1 = ((CMTime)localObject1).add(((TAVClip)((Iterator)localObject3).next()).getResource().getScaledDuration());
          }
          localObject1 = new CMTimeRange(((MovieSegment)localObject2).getTimeRange().getStart(), (CMTime)localObject1);
          if ((i == this.mCorrectSegments.size() - 1) && (isSampleTimeRange(CMTimeRange.fromSeconds((float)((CMTimeRange)localObject1).getStartUs(), (float)((CMTimeRange)localObject1).getDurationUs()), CMTimeRange.fromSeconds((float)((MovieSegment)localObject2).getTimeRange().getStartUs(), (float)((MovieSegment)localObject2).getTimeRange().getDurationUs()))))
          {
            localObject3 = new CMTime(this.mTemplateSticker.getSticker().durationTime() / 1000L, 1000).sub(((MovieSegment)localObject2).getTimeRange().getEnd());
            Logger.i("MovieTemplate", "correctSegments endingTime is " + localObject3);
            if (((CMTime)localObject3).bigThan(CMTime.CMTimeZero)) {
              ((MovieSegment)localObject2).setEndingTime((CMTime)localObject3);
            }
          }
          ((MovieSegment)localObject2).setTimeRange((CMTimeRange)localObject1);
        }
      }
    }
    i = 0;
    if (i < this.mCorrectSegments.size())
    {
      localObject3 = (MovieSegment)this.mCorrectSegments.get(i);
      ((MovieSegment)localObject3).setIndex(i);
      if (i != this.mCorrectSegments.size() - 1) {}
    }
    else
    {
      if (!this.mCorrectSegments.isEmpty()) {
        break label478;
      }
    }
    label410:
    label478:
    do
    {
      return;
      MovieSegment localMovieSegment = (MovieSegment)this.mCorrectSegments.get(i + 1);
      CMTimeRange localCMTimeRange = ((MovieSegment)localObject3).getTimeRange();
      localObject1 = localCMTimeRange.getEnd();
      localObject2 = localMovieSegment.getTimeRange();
      CMTime localCMTime = ((CMTimeRange)localObject2).getStart();
      localObject2 = ((CMTimeRange)localObject2).getEnd();
      if (localCMTimeRange.containsTime(localCMTime)) {
        if (((CMTime)localObject1).bigThan((CMTime)localObject2))
        {
          localObject1 = localObject2;
          localMovieSegment.setOverlapTimeRange(new CMTimeRange(localCMTime, ((CMTime)localObject1).sub(localCMTime)));
          localObject1 = localCMTime.add(((CMTime)localObject1).sub(localCMTime).divide(2.0F));
          localMovieSegment.setCorrectStartTime((CMTime)localObject1);
          ((MovieSegment)localObject3).setCorrectEndTime((CMTime)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        break label410;
        localMovieSegment.setCorrectStartTime(localCMTime);
      }
      localObject1 = (MovieSegment)this.mCorrectSegments.get(0);
    } while (localObject1 == null);
    ((MovieSegment)localObject1).setCorrectStartTime(CMTime.CMTimeZero);
    Object localObject1 = this.mCorrectSegments.iterator();
    label513:
    label616:
    label619:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MovieSegment)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((MovieSegment)localObject2).getTavMovieClips() != null) && (!((MovieSegment)localObject2).getTavMovieClips().isEmpty()) && (((MovieSegment)localObject2).getTavClips() != null) && (!((MovieSegment)localObject2).getTavClips().isEmpty()) && ((((MovieSegment)localObject2).getOverlapTimeRange() == null) || (!((MovieSegment)localObject2).getTimeRange().getEnd().smallThan(((MovieSegment)localObject2).getOverlapTimeRange().getEnd())))) {
          break label616;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label619;
        }
        ((Iterator)localObject1).remove();
        break label513;
        break;
      }
    }
  }
  
  private void fillClipsPhoto(@NonNull TAVMovieClip paramTAVMovieClip, @NonNull MovieSegment paramMovieSegment, @NonNull List<TAVClip> paramList)
  {
    TAVMovieImageResource localTAVMovieImageResource = (TAVMovieImageResource)paramTAVMovieClip.getResource();
    Logger.d("MovieTemplate", "begin--fillClipsPhoto photo path: " + localTAVMovieImageResource.getFilePath());
    CMTime localCMTime = paramMovieSegment.getTimeRange().getDuration().clone();
    paramTAVMovieClip.getResource().setDuration(localCMTime);
    paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(CMTime.CMTimeZero, localCMTime));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTAVMovieClip);
    paramMovieSegment.setTavMovieClips(localArrayList);
    paramTAVMovieClip = paramTAVMovieClip.convertToClip();
    paramTAVMovieClip.getResource().setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, localCMTime));
    paramTAVMovieClip.putExtraTrackInfo("pag_layer_index", String.valueOf(paramMovieSegment.getLayerIndex()));
    paramList.add(paramTAVMovieClip);
    Logger.d("MovieTemplate", "end--fillClipsPhoto photo path: " + localTAVMovieImageResource.getFilePath());
  }
  
  private void fillClipsVideo(@NonNull TAVMovieClip paramTAVMovieClip, @NonNull MovieSegment paramMovieSegment, @NonNull List<TAVClip> paramList, @NonNull List<TAVMovieClip> paramList1, List<TAVMovieTimeEffect> paramList2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CMTime localCMTime = paramMovieSegment.getMinOriginDuration().clone();
    TAVMovieClip localTAVMovieClip1 = paramTAVMovieClip;
    label266:
    label272:
    label357:
    label370:
    for (;;)
    {
      CMTimeRange localCMTimeRange;
      Object localObject;
      int i;
      TAVMovieClip localTAVMovieClip2;
      if (localCMTime.getTimeUs() > 0L)
      {
        localCMTimeRange = localTAVMovieClip1.getResource().getTimeRange().clone();
        paramTAVMovieClip = localCMTimeRange.getDuration();
        localObject = localTAVMovieClip1.getResource().getType();
        if ((!localArrayList2.isEmpty()) || (localObject != TAVMovieResource.TAVResourceType.TAVResourceTypeVideo) || (!paramTAVMovieClip.bigThan(localCMTime))) {
          break label266;
        }
        i = 1;
        if (i == 0) {
          break label272;
        }
        localObject = paramTAVMovieClip.sub(localCMTime).divide(2.0F);
        localObject = new CMTimeRange(localCMTimeRange.getStart().add((CMTime)localObject), localCMTime.clone());
        localTAVMovieClip2 = paramTAVMovieClip;
      }
      for (;;)
      {
        localTAVMovieClip1.getResource().setTimeRange((CMTimeRange)localObject);
        paramTAVMovieClip = localTAVMovieClip1.convertToClip();
        paramTAVMovieClip.getResource().setSourceTimeRange((CMTimeRange)localObject);
        paramTAVMovieClip.putExtraTrackInfo("pag_layer_index", String.valueOf(paramMovieSegment.getLayerIndex()));
        localArrayList1.add(paramTAVMovieClip);
        localArrayList2.add(localTAVMovieClip1);
        localCMTime = localCMTime.sub(localTAVMovieClip2);
        if (localCMTime.getTimeUs() <= 0L) {
          break label370;
        }
        if (paramList1.size() != 0) {
          break label357;
        }
        paramMovieSegment.setTavMovieClips(localArrayList2);
        if ((paramList2 == null) || (localArrayList1.isEmpty())) {
          break label373;
        }
        paramList.addAll(TAVMovieTimeEffectUtil.applyTimeEffectsNew(localArrayList1, paramList2));
        return;
        i = 0;
        break;
        if (localObject == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto)
        {
          paramTAVMovieClip = localCMTime.clone();
          localTAVMovieClip1.getResource().setDuration(localCMTime.clone());
          localCMTimeRange = new CMTimeRange(CMTime.CMTimeZero, localCMTime.clone());
        }
        localTAVMovieClip2 = paramTAVMovieClip;
        localObject = localCMTimeRange;
        if (localCMTime.smallThan(paramTAVMovieClip))
        {
          localObject = new CMTimeRange(localCMTimeRange.getStart(), localCMTime.clone());
          localTAVMovieClip2 = paramTAVMovieClip;
        }
      }
      localTAVMovieClip1 = (TAVMovieClip)paramList1.remove(0);
    }
    label373:
    paramList.addAll(localArrayList1);
  }
  
  private void fillSegments(MovieSegment paramMovieSegment, List<TAVMovieClip> paramList, @Nullable List<TAVMovieTimeEffect> paramList1, List<TAVClip> paramList2)
  {
    if ((paramMovieSegment == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList2 == null) {
      paramList2 = new ArrayList();
    }
    for (;;)
    {
      TAVMovieClip localTAVMovieClip;
      if (this.mNeedCycleFill)
      {
        localTAVMovieClip = (TAVMovieClip)paramList.remove(0);
        paramList.add(localTAVMovieClip.clone());
      }
      while ((localTAVMovieClip != null) && (localTAVMovieClip.getResource() != null))
      {
        TAVMovieResource.TAVResourceType localTAVResourceType = localTAVMovieClip.getResource().getType();
        switch (MovieTemplate.2.$SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType[localTAVResourceType.ordinal()])
        {
        default: 
          return;
        case 1: 
          fillClipsPhoto(localTAVMovieClip, paramMovieSegment, paramList2);
          return;
          localTAVMovieClip = (TAVMovieClip)paramList.remove(0);
        }
      }
      fillClipsVideo(localTAVMovieClip, paramMovieSegment, paramList2, paramList, paramList1);
      return;
    }
  }
  
  private List<TAVSegmentImageEffect> getSegmentImageEffects(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    if (paramTAVStickerLayerInfo == null) {}
    do
    {
      return null;
      paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getImageEffects();
    } while ((paramTAVStickerLayerInfo == null) || (paramTAVStickerLayerInfo.isEmpty()));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramTAVStickerLayerInfo.iterator();
    if (localIterator.hasNext())
    {
      TAVStickerLayerInfo.TAVStickerImageEffect localTAVStickerImageEffect = (TAVStickerLayerInfo.TAVStickerImageEffect)localIterator.next();
      TAVSegmentImageEffect localTAVSegmentImageEffect = new TAVSegmentImageEffect();
      if (localTAVStickerImageEffect == null)
      {
        paramTAVStickerLayerInfo = null;
        label75:
        localTAVSegmentImageEffect.setTimeRange(paramTAVStickerLayerInfo);
        if (localTAVStickerImageEffect != null) {
          break label128;
        }
        paramTAVStickerLayerInfo = null;
        label88:
        localTAVSegmentImageEffect.setEffectID(paramTAVStickerLayerInfo);
        if (localTAVStickerImageEffect != null) {
          break label137;
        }
      }
      label128:
      label137:
      for (paramTAVStickerLayerInfo = null;; paramTAVStickerLayerInfo = localTAVStickerImageEffect.getName())
      {
        localTAVSegmentImageEffect.setName(paramTAVStickerLayerInfo);
        localArrayList.add(localTAVSegmentImageEffect);
        break;
        paramTAVStickerLayerInfo = localTAVStickerImageEffect.getTimeRange();
        break label75;
        paramTAVStickerLayerInfo = localTAVStickerImageEffect.getEffectId();
        break label88;
      }
    }
    return localArrayList;
  }
  
  private List<TAVMovieTimeEffect> getSegmentTimeEffects(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    if (paramTAVStickerLayerInfo == null) {}
    Object localObject;
    do
    {
      return null;
      localObject = paramTAVStickerLayerInfo.getTimeEffects();
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject).isEmpty())
    {
      localObject = new TAVMovieTimeEffect();
      ((TAVMovieTimeEffect)localObject).setSourceTimeRange(paramTAVStickerLayerInfo.getTimeRange());
      ((TAVMovieTimeEffect)localObject).setTimeRange(paramTAVStickerLayerInfo.getTimeRange());
      ((TAVMovieTimeEffect)localObject).setLoop(1);
      ((TAVMovieTimeEffect)localObject).setSpeed(1.0F);
      localArrayList.add(localObject);
      return localArrayList;
    }
    paramTAVStickerLayerInfo = ((List)localObject).iterator();
    while (paramTAVStickerLayerInfo.hasNext())
    {
      localObject = (TAVStickerLayerInfo.TAVStickerTimeEffect)paramTAVStickerLayerInfo.next();
      if (localObject != null)
      {
        TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
        localTAVMovieTimeEffect.setSourceTimeRange(((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getSourceVideoTimeRange());
        localTAVMovieTimeEffect.setTimeRange(((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getTimeRange());
        localTAVMovieTimeEffect.setLoop(1);
        if (((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getTimeRange().getDuration().getTimeSeconds() == 0.0F) {
          localTAVMovieTimeEffect.setSpeed(1.0F);
        }
        for (;;)
        {
          localArrayList.add(localTAVMovieTimeEffect);
          break;
          localTAVMovieTimeEffect.setSpeed(((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getSourceVideoTimeRange().getDuration().getTimeSeconds() / ((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getTimeRange().getDuration().getTimeSeconds());
        }
      }
    }
    return localArrayList;
  }
  
  private void initData()
  {
    parsePackagePath();
    this.mSegments = new ArrayList();
    this.mStickers = new ArrayList();
    if (TextUtils.isEmpty(this.mFilePath)) {}
    do
    {
      return;
      this.mTemplateSticker = new TAVMovieSticker(this.mFilePath, this.mIsAsset);
      parseLayerInfos();
      this.mPagAudioPath = (this.mPackagePath + "/" + "audio" + ".pcm");
      Logger.d("MovieTemplate", "pag audio path: " + this.mPagAudioPath);
    } while (this.mTemplateSticker.getSticker() == null);
    this.renderSize = new CGSize(this.mTemplateSticker.getSticker().getWidth(), this.mTemplateSticker.getSticker().getHeight());
  }
  
  private boolean isAllPhotoClip(List<TAVMovieClip> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
        if ((localTAVMovieClip != null) && (localTAVMovieClip.getResource().getType() != TAVMovieResource.TAVResourceType.TAVResourceTypePhoto)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean isAllVideoClip(List<TAVMovieClip> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
        if ((localTAVMovieClip != null) && (localTAVMovieClip.getResource().getType() != TAVMovieResource.TAVResourceType.TAVResourceTypeVideo)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean isNeedCycleFill(List<TAVMovieClip> paramList)
  {
    return isAllPhotoClip(paramList);
  }
  
  private boolean isSamePath(TAVMovieClip paramTAVMovieClip1, TAVMovieClip paramTAVMovieClip2)
  {
    if ((paramTAVMovieClip1 == null) || (paramTAVMovieClip2 == null)) {
      return false;
    }
    paramTAVMovieClip1 = paramTAVMovieClip1.getResource();
    TAVMovieResource localTAVMovieResource = paramTAVMovieClip2.getResource();
    if (((paramTAVMovieClip1 instanceof TAVMovieImageResource)) && ((localTAVMovieResource instanceof TAVMovieImageResource))) {
      return TextUtils.equals(((TAVMovieImageResource)paramTAVMovieClip1).getFilePath(), ((TAVMovieImageResource)localTAVMovieResource).getFilePath());
    }
    if (((paramTAVMovieClip1 instanceof TAVMovieTrackResource)) && ((localTAVMovieResource instanceof TAVMovieTrackResource))) {
      return TextUtils.equals(((TAVMovieTrackResource)paramTAVMovieClip1).getFilePath(), ((TAVMovieTrackResource)paramTAVMovieClip2.getResource()).getFilePath());
    }
    return false;
  }
  
  private boolean isSampleTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null)) {}
    long l1;
    long l2;
    long l3;
    long l4;
    do
    {
      do
      {
        return false;
      } while ((paramCMTimeRange1.getStart().getTimeScale() != paramCMTimeRange2.getStart().getTimeScale()) || (paramCMTimeRange1.getDuration().getTimeScale() != paramCMTimeRange2.getDuration().getTimeScale()));
      l1 = Math.round((float)paramCMTimeRange1.getStart().value / 1000000.0F);
      l2 = Math.round((float)paramCMTimeRange2.getStart().value / 1000000.0F);
      l3 = Math.round((float)paramCMTimeRange1.getDuration().value / 1000000.0F);
      l4 = Math.round((float)paramCMTimeRange2.getDuration().value / 1000000.0F);
      Logger.i("MovieTemplate", "SV1 " + l1 + " SV2 " + l2 + " dv1 " + l3 + " dv2 " + l4);
    } while ((l1 != l2) || (l3 != l4));
    return true;
  }
  
  private boolean isSingleVideo(List<TAVMovieClip> paramList)
  {
    return (paramList != null) && (paramList.size() == 1) && (((TAVMovieClip)paramList.get(0)).getResource().getType() == TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
  }
  
  private void loadAudioData(TAVSticker paramTAVSticker)
  {
    if (FileUtils.exists(this.mPagAudioPath))
    {
      if (this.mLoadDataListeners != null)
      {
        paramTAVSticker = this.mLoadDataListeners.iterator();
        while (paramTAVSticker.hasNext())
        {
          TAVStickerResourceExporter.IStickerResourceExportListener localIStickerResourceExportListener = (TAVStickerResourceExporter.IStickerResourceExportListener)paramTAVSticker.next();
          if (localIStickerResourceExportListener != null) {
            localIStickerResourceExportListener.succeed(null);
          }
        }
      }
      this.mLoadingData = false;
      return;
    }
    TAVStickerResourceExporter.getInstance().exportAudioData(paramTAVSticker, this.mPagAudioPath, new MovieTemplate.1(this));
  }
  
  private void mergeClip(TAVMovieClip paramTAVMovieClip1, TAVMovieClip paramTAVMovieClip2)
  {
    if (!isSamePath(paramTAVMovieClip1, paramTAVMovieClip2)) {
      return;
    }
    paramTAVMovieClip1 = paramTAVMovieClip1.getResource();
    CMTimeRange localCMTimeRange = paramTAVMovieClip1.getTimeRange();
    CMTime localCMTime1 = localCMTimeRange.getStart();
    CMTime localCMTime2 = localCMTimeRange.getEnd();
    CMTime localCMTime3 = paramTAVMovieClip2.getResource().getTimeRange().getStart();
    paramTAVMovieClip2 = paramTAVMovieClip2.getResource().getTimeRange().getEnd();
    if (localCMTime1.bigThan(localCMTime3)) {
      localCMTimeRange.setStart(localCMTime3);
    }
    if (localCMTime2.smallThan(paramTAVMovieClip2)) {
      localCMTimeRange.setDuration(paramTAVMovieClip2.sub(localCMTimeRange.getStart()));
    }
    paramTAVMovieClip1.setTimeRange(localCMTimeRange);
  }
  
  private List<TAVMovieClip> mergeClips(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
      int i = 0;
      int j = -1;
      while (i < localArrayList.size())
      {
        if (isSamePath((TAVMovieClip)localArrayList.get(i), localTAVMovieClip)) {
          j = i;
        }
        i += 1;
      }
      if (j != -1) {
        mergeClip((TAVMovieClip)localArrayList.get(j), localTAVMovieClip);
      } else {
        localArrayList.add(localTAVMovieClip);
      }
    }
    return localArrayList;
  }
  
  private void parseLayerInfos()
  {
    Object localObject1 = this.mTemplateSticker.getStickerLayerInfos();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVStickerLayerInfo)((Iterator)localObject1).next();
      if (Utils.isLayerFillAble((TAVStickerLayerInfo)localObject2))
      {
        MovieSegment localMovieSegment = new MovieSegment();
        localMovieSegment.setTimeEffects(getSegmentTimeEffects((TAVStickerLayerInfo)localObject2));
        localMovieSegment.setImageEffects(getSegmentImageEffects((TAVStickerLayerInfo)localObject2));
        localMovieSegment.setUserDatas(((TAVStickerLayerInfo)localObject2).getUserDataList());
        localMovieSegment.setTimeRange(((TAVStickerLayerInfo)localObject2).getTimeRange());
        localMovieSegment.setLayerIndex(((TAVStickerLayerInfo)localObject2).getLayerIndex());
        this.mSegments.add(localMovieSegment);
      }
    }
    localObject1 = this.mSegments.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      if ((((MovieSegment)localObject2).getTimeRange() == null) || (((MovieSegment)localObject2).getTimeRange().equals(CMTimeRange.CMTimeRangeInvalid))) {
        ((Iterator)localObject1).remove();
      }
    }
    Collections.sort(this.mSegments);
  }
  
  private void parsePackagePath()
  {
    if (TextUtils.isEmpty(this.mFilePath)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.mFilePath);
    } while (!localFile.exists());
    this.mPackagePath = localFile.getParentFile().getAbsolutePath();
  }
  
  private void replaceBitmap(TAVStickerImageItem paramTAVStickerImageItem, String paramString)
  {
    if ((paramTAVStickerImageItem != null) && (FileUtils.exists(paramString)))
    {
      Logger.e("MovieTemplate", "set PAGImage url = " + paramString);
      paramTAVStickerImageItem.setBitmap(BitmapFactory.decodeFile(paramString, new BitmapFactory.Options()));
      this.mHasImageLayerSet = true;
    }
  }
  
  private List<TAVMovieClip> separateClip(TAVMovieClip paramTAVMovieClip)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mSegments.iterator();
    for (;;)
    {
      MovieSegment localMovieSegment;
      if (localIterator.hasNext())
      {
        localMovieSegment = (MovieSegment)localIterator.next();
        if (localMovieSegment == null) {
          continue;
        }
        if (!localMovieSegment.getMinOriginDuration().smallThan(paramTAVMovieClip.getResource().getTimeRange().getDuration())) {
          localArrayList.add(paramTAVMovieClip);
        }
      }
      else
      {
        return localArrayList;
      }
      TAVMovieClip localTAVMovieClip = paramTAVMovieClip.clone();
      localTAVMovieClip.getResource().setTimeRange(new CMTimeRange(localTAVMovieClip.getResource().getTimeRange().getStart(), localMovieSegment.getMinOriginDuration()));
      localArrayList.add(localTAVMovieClip);
      paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(localTAVMovieClip.getResource().getTimeRange().getEnd(), paramTAVMovieClip.getResource().getTimeRange().getDuration().sub(localTAVMovieClip.getResource().getTimeRange().getDuration())));
    }
  }
  
  private List<TAVMovieClip> separateClips(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(16);
    CMTime localCMTime = CMTime.CMTimeZero;
    Object localObject1 = this.mSegments.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      if (localObject2 == null) {
        ((Iterator)localObject1).remove();
      }
      for (;;)
      {
        break;
        localCMTime = localCMTime.add(((MovieSegment)localObject2).getTimeRange().getDuration());
      }
    }
    if ((localCMTime.equalsTo(CMTime.CMTimeZero)) || (localCMTime.smallThan(CMTime.CMTimeZero))) {
      return localArrayList;
    }
    localObject1 = CMTime.CMTimeZero;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TAVMovieClip)((Iterator)localObject2).next();
      if ((localObject3 == null) || (((TAVMovieClip)localObject3).getResource() == null) || (((TAVMovieClip)localObject3).getResource().getTimeRange() == null)) {
        ((Iterator)localObject2).remove();
      }
      for (;;)
      {
        break;
        localObject1 = ((CMTime)localObject1).add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
      }
    }
    if ((((CMTime)localObject1).equalsTo(CMTime.CMTimeZero)) || (((CMTime)localObject1).smallThan(CMTime.CMTimeZero))) {
      return localArrayList;
    }
    Object localObject4 = paramList.iterator();
    TAVMovieClip localTAVMovieClip;
    if (((Iterator)localObject4).hasNext())
    {
      localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
      localObject2 = localTAVMovieClip.getResource().getTimeRange().getDuration();
      localObject3 = ((CMTime)localObject2).multi(localCMTime).divide((CMTime)localObject1);
      if (((CMTime)localObject2).bigThan((CMTime)localObject3)) {
        break label695;
      }
    }
    for (;;)
    {
      localConcurrentHashMap.put(((TAVMovieTrackResource)localTAVMovieClip.getResource()).getFilePath(), localObject2);
      break;
      int i = 0;
      if ((i >= this.mSegments.size()) || (paramList.isEmpty())) {
        return localArrayList;
      }
      localCMTime = ((MovieSegment)this.mSegments.get(i)).getMinOriginDuration().clone();
      label420:
      label692:
      label693:
      for (;;)
      {
        label363:
        if ((localCMTime.getTimeUs() > 0L) && (!paramList.isEmpty()))
        {
          localObject2 = (TAVMovieClip)paramList.remove(0);
          localObject3 = ((TAVMovieClip)localObject2).getResource().getTimeRange().getDuration();
          localObject1 = CMTime.CMTimeZero;
          localObject4 = localArrayList.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
            if (!TextUtils.equals(((TAVMovieTrackResource)localTAVMovieClip.getResource()).getFilePath(), ((TAVMovieTrackResource)((TAVMovieClip)localObject2).getResource()).getFilePath())) {
              break label692;
            }
            localObject1 = ((CMTime)localObject1).add(localTAVMovieClip.getResource().getTimeRange().getDuration());
          }
        }
        for (;;)
        {
          break label420;
          if ((!((CMTime)localObject1).smallThan((CMTime)localConcurrentHashMap.get(((TAVMovieTrackResource)((TAVMovieClip)localObject2).getResource()).getFilePath()))) || (!((CMTime)localObject3).bigThan(CMTime.CMTimeZero))) {
            break label693;
          }
          if ((((CMTime)localObject1).equalsTo(CMTime.CMTimeZero)) || (!((CMTime)localObject3).smallThan(localCMTime)))
          {
            localObject1 = ((TAVMovieClip)localObject2).clone();
            localObject4 = ((TAVMovieClip)localObject1).getResource().getTimeRange();
            if (((CMTime)localObject3).bigThan(localCMTime))
            {
              ((CMTimeRange)localObject4).setDuration(localCMTime);
              label583:
              ((TAVMovieClip)localObject1).getResource().setTimeRange((CMTimeRange)localObject4);
              localArrayList.add(localObject1);
              localObject1 = ((CMTime)localObject3).sub(localCMTime);
              if (((CMTime)localObject1).bigThan(CMTime.CMTimeZero))
              {
                localObject4 = ((TAVMovieClip)localObject2).getResource().getTimeRange();
                ((CMTimeRange)localObject4).setStart(((CMTimeRange)localObject4).getStart().add(localCMTime));
                ((CMTimeRange)localObject4).setDuration((CMTime)localObject1);
                paramList.add(0, localObject2);
              }
              localCMTime = localCMTime.sub((CMTime)localObject3);
            }
          }
          for (;;)
          {
            break label363;
            ((CMTimeRange)localObject4).setDuration((CMTime)localObject3);
            break label583;
            i += 1;
            break;
          }
        }
      }
      label695:
      localObject2 = localObject3;
    }
  }
  
  public TAVComposition buildCompositionFromMovie(TAVMovie paramTAVMovie)
  {
    return null;
  }
  
  public List<TAVMovieSegment> convertClips(List<TAVMovieClip> paramList)
  {
    Object localObject1 = CloneUtil.cloneMovieClips(paramList);
    boolean bool = isSingleVideo((List)localObject1);
    if ((bool) && (this.mSegments.size() > 1)) {
      paramList = separateClip((TAVMovieClip)((List)localObject1).get(0));
    }
    Object localObject2;
    for (;;)
    {
      this.mNeedCycleFill = isNeedCycleFill(paramList);
      localObject1 = this.mSegments.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MovieSegment)((Iterator)localObject1).next();
        ((MovieSegment)localObject2).setTavClips(null);
        ((MovieSegment)localObject2).setTavMovieClips(null);
      }
      paramList = (List<TAVMovieClip>)localObject1;
      if (isAllVideoClip((List)localObject1))
      {
        paramList = (List<TAVMovieClip>)localObject1;
        if (((List)localObject1).size() < this.mSegments.size())
        {
          paramList = (List<TAVMovieClip>)localObject1;
          if (!bool)
          {
            paramList = (List<TAVMovieClip>)localObject1;
            if (this.mFirstFill)
            {
              paramList = separateClips((List)localObject1);
              this.mFirstFill = false;
            }
          }
        }
      }
    }
    localObject1 = this.mSegments.iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MovieSegment)((Iterator)localObject1).next();
        if ((paramList != null) && (!paramList.isEmpty())) {}
      }
      else
      {
        correctSegments();
        paramList = new ArrayList(this.mCorrectSegments);
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TAVMovieSegment)((Iterator)localObject1).next();
          Logger.d("MovieTemplate", "segment, layerIndex: " + ((TAVMovieSegment)localObject2).getLayerIndex() + ", start clip time: " + ((TAVMovieSegment)localObject2).getTimeRange().getStart().getTimeSeconds() + ", end time: " + ((TAVMovieSegment)localObject2).getTimeRange().getEnd().getTimeSeconds());
        }
      }
      ArrayList localArrayList = new ArrayList();
      List localList = ((MovieSegment)localObject2).separateSegmentByTimeEffects();
      Logger.d("MovieTemplate", "fillSegments begin");
      fillSegments((MovieSegment)localObject2, paramList, localList, localArrayList);
      Logger.d("MovieTemplate", "fillSegments end");
      if (!localArrayList.isEmpty()) {
        ((MovieSegment)localObject2).setTavClips(localArrayList);
      }
    }
    return paramList;
  }
  
  public TAVMovieClip getBackgroundMusic()
  {
    if ((!TextUtils.isEmpty(this.mPagAudioPath)) && (FileUtils.exists(this.mPagAudioPath)))
    {
      TAVMovieClip localTAVMovieClip = new TAVMovieClip();
      TAVMovieTrackResource localTAVMovieTrackResource = new TAVMovieTrackResource(this.mPagAudioPath);
      localTAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
      localTAVMovieClip.setResource(localTAVMovieTrackResource);
      return localTAVMovieClip;
    }
    return null;
  }
  
  public List<MovieSegment> getCorrectSegments()
  {
    return this.mCorrectSegments;
  }
  
  public CMTime getMinOriginDuration()
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    Iterator localIterator = this.mSegments.iterator();
    while (localIterator.hasNext())
    {
      MovieSegment localMovieSegment = (MovieSegment)localIterator.next();
      if ((localMovieSegment != null) && (localMovieSegment.getMinOriginDuration() != null)) {
        localCMTime = localCMTime.add(localMovieSegment.getMinOriginDuration());
      }
    }
    return localCMTime;
  }
  
  public List<TAVMovieClip> getMovieClips()
  {
    if (this.mOriginClips != null) {
      return this.mOriginClips;
    }
    if (this.mCorrectSegments != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mCorrectSegments.iterator();
      while (localIterator.hasNext())
      {
        TAVMovieSegment localTAVMovieSegment = (TAVMovieSegment)localIterator.next();
        if (localTAVMovieSegment != null) {
          localArrayList.addAll(localTAVMovieSegment.getTavMovieClips());
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public List<MovieSegment> getSegments()
  {
    return this.mSegments;
  }
  
  public List<TAVMovieSticker> getStickers()
  {
    return this.mStickers;
  }
  
  public TAVMovieSticker getTemplateSticker()
  {
    return this.mTemplateSticker;
  }
  
  public void loadTemplateData(TAVStickerResourceExporter.IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    if (!this.mLoadDataListeners.contains(paramIStickerResourceExportListener)) {
      this.mLoadDataListeners.add(paramIStickerResourceExportListener);
    }
    if (!this.mLoadingData)
    {
      loadAudioData(this.mTemplateSticker.getSticker());
      this.mLoadingData = true;
    }
  }
  
  public void parseToMovie(TAVMovie paramTAVMovie) {}
  
  public void release()
  {
    Iterator localIterator;
    MovieSegment localMovieSegment;
    if (this.mSegments != null)
    {
      localIterator = this.mSegments.iterator();
      while (localIterator.hasNext())
      {
        localMovieSegment = (MovieSegment)localIterator.next();
        if (localMovieSegment != null) {
          localMovieSegment.release();
        }
      }
    }
    if (this.mCorrectSegments != null)
    {
      localIterator = this.mCorrectSegments.iterator();
      while (localIterator.hasNext())
      {
        localMovieSegment = (MovieSegment)localIterator.next();
        if (localMovieSegment != null) {
          localMovieSegment.release();
        }
      }
    }
  }
  
  public void replaceSegment(MovieSegment paramMovieSegment)
  {
    if ((paramMovieSegment == null) || (this.mCorrectSegments == null)) {}
    int i;
    do
    {
      return;
      i = paramMovieSegment.getIndex();
    } while (i < 0);
    this.mCorrectSegments.remove(i);
    this.mCorrectSegments.add(i, paramMovieSegment);
  }
  
  public void setFirstFill(boolean paramBoolean)
  {
    this.mFirstFill = paramBoolean;
  }
  
  public void setOriginClips(List<TAVMovieClip> paramList)
  {
    this.mOriginClips = paramList;
  }
  
  public void unloadTemplateData(TAVStickerResourceExporter.IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    if (!this.mLoadDataListeners.contains(paramIStickerResourceExportListener)) {
      return;
    }
    this.mLoadDataListeners.remove(paramIStickerResourceExportListener);
  }
  
  public void updatePAGTextAndImage()
  {
    if (this.mHasImageLayerSet) {
      this.mTemplateSticker.updateImageData();
    }
    if (this.mHasTextLayerSet) {
      this.mTemplateSticker.updateTextData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieTemplate
 * JD-Core Version:    0.7.0.1
 */