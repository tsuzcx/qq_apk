package com.tencent.qcircle.weseevideo.model.template.movie;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
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
    Object localObject4;
    while (i < this.mCorrectSegments.size())
    {
      localObject2 = (MovieSegment)this.mCorrectSegments.get(i);
      if (localObject2 != null)
      {
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
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("correctSegments endingTime is ");
            ((StringBuilder)localObject4).append(localObject3);
            Logger.i("MovieTemplate", ((StringBuilder)localObject4).toString());
            if (((CMTime)localObject3).bigThan(CMTime.CMTimeZero)) {
              ((MovieSegment)localObject2).setEndingTime((CMTime)localObject3);
            }
          }
          ((MovieSegment)localObject2).setTimeRange((CMTimeRange)localObject1);
        }
      }
      i += 1;
    }
    i = 0;
    while (i < this.mCorrectSegments.size())
    {
      localObject4 = (MovieSegment)this.mCorrectSegments.get(i);
      ((MovieSegment)localObject4).setIndex(i);
      if (i == this.mCorrectSegments.size() - 1) {
        break;
      }
      localObject1 = this.mCorrectSegments;
      i += 1;
      MovieSegment localMovieSegment = (MovieSegment)((List)localObject1).get(i);
      localObject1 = ((MovieSegment)localObject4).getTimeRange();
      localObject2 = ((CMTimeRange)localObject1).getEnd();
      localObject3 = localMovieSegment.getTimeRange();
      CMTime localCMTime = ((CMTimeRange)localObject3).getStart();
      localObject3 = ((CMTimeRange)localObject3).getEnd();
      if (((CMTimeRange)localObject1).containsTime(localCMTime))
      {
        localObject1 = localObject2;
        if (((CMTime)localObject2).bigThan((CMTime)localObject3)) {
          localObject1 = localObject3;
        }
        localMovieSegment.setOverlapTimeRange(new CMTimeRange(localCMTime, ((CMTime)localObject1).sub(localCMTime)));
        localObject1 = localCMTime.add(((CMTime)localObject1).sub(localCMTime).divide(2.0F));
        localMovieSegment.setCorrectStartTime((CMTime)localObject1);
        ((MovieSegment)localObject4).setCorrectEndTime((CMTime)localObject1);
      }
      else
      {
        localMovieSegment.setCorrectStartTime(localCMTime);
      }
    }
    if (this.mCorrectSegments.isEmpty()) {
      return;
    }
    Object localObject1 = (MovieSegment)this.mCorrectSegments.get(0);
    if (localObject1 == null) {
      return;
    }
    ((MovieSegment)localObject1).setCorrectStartTime(CMTime.CMTimeZero);
    localObject1 = this.mCorrectSegments.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((MovieSegment)localObject2).getTavMovieClips() != null) && (!((MovieSegment)localObject2).getTavMovieClips().isEmpty()) && (((MovieSegment)localObject2).getTavClips() != null) && (!((MovieSegment)localObject2).getTavClips().isEmpty()) && ((((MovieSegment)localObject2).getOverlapTimeRange() == null) || (!((MovieSegment)localObject2).getTimeRange().getEnd().smallThan(((MovieSegment)localObject2).getOverlapTimeRange().getEnd())))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        ((Iterator)localObject1).remove();
      }
    }
  }
  
  private void fillClipsPhoto(@NonNull TAVMovieClip paramTAVMovieClip, @NonNull MovieSegment paramMovieSegment, @NonNull List<TAVClip> paramList)
  {
    TAVMovieImageResource localTAVMovieImageResource = (TAVMovieImageResource)paramTAVMovieClip.getResource();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("begin--fillClipsPhoto photo path: ");
    ((StringBuilder)localObject).append(localTAVMovieImageResource.getFilePath());
    Logger.d("MovieTemplate", ((StringBuilder)localObject).toString());
    localObject = paramMovieSegment.getTimeRange().getDuration().clone();
    paramTAVMovieClip.getResource().setDuration((CMTime)localObject);
    paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTAVMovieClip);
    paramMovieSegment.setTavMovieClips(localArrayList);
    paramTAVMovieClip = paramTAVMovieClip.convertToClip();
    paramTAVMovieClip.getResource().setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject));
    paramTAVMovieClip.putExtraTrackInfo("pag_layer_index", String.valueOf(paramMovieSegment.getLayerIndex()));
    paramList.add(paramTAVMovieClip);
    paramTAVMovieClip = new StringBuilder();
    paramTAVMovieClip.append("end--fillClipsPhoto photo path: ");
    paramTAVMovieClip.append(localTAVMovieImageResource.getFilePath());
    Logger.d("MovieTemplate", paramTAVMovieClip.toString());
  }
  
  private void fillClipsVideo(@NonNull TAVMovieClip paramTAVMovieClip, @NonNull MovieSegment paramMovieSegment, @NonNull List<TAVClip> paramList, @NonNull List<TAVMovieClip> paramList1, List<TAVMovieTimeEffect> paramList2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = paramMovieSegment.getMinOriginDuration().clone();
    TAVMovieClip localTAVMovieClip = paramTAVMovieClip;
    while (((CMTime)localObject2).getTimeUs() > 0L)
    {
      Object localObject1 = localTAVMovieClip.getResource().getTimeRange().clone();
      paramTAVMovieClip = ((CMTimeRange)localObject1).getDuration();
      Object localObject3 = localTAVMovieClip.getResource().getType();
      int i;
      if ((localArrayList2.isEmpty()) && (localObject3 == TAVMovieResource.TAVResourceType.TAVResourceTypeVideo) && (paramTAVMovieClip.bigThan((CMTime)localObject2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject3 = paramTAVMovieClip.sub((CMTime)localObject2).divide(2.0F);
        localObject1 = new CMTimeRange(((CMTimeRange)localObject1).getStart().add((CMTime)localObject3), ((CMTime)localObject2).clone());
        localObject3 = paramTAVMovieClip;
      }
      else
      {
        if (localObject3 == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto)
        {
          paramTAVMovieClip = ((CMTime)localObject2).clone();
          localTAVMovieClip.getResource().setDuration(((CMTime)localObject2).clone());
          localObject1 = new CMTimeRange(CMTime.CMTimeZero, ((CMTime)localObject2).clone());
        }
        Object localObject4 = localObject1;
        localObject3 = paramTAVMovieClip;
        localObject1 = localObject4;
        if (((CMTime)localObject2).smallThan(paramTAVMovieClip))
        {
          localObject1 = new CMTimeRange(localObject4.getStart(), ((CMTime)localObject2).clone());
          localObject3 = paramTAVMovieClip;
        }
      }
      localTAVMovieClip.getResource().setTimeRange((CMTimeRange)localObject1);
      paramTAVMovieClip = localTAVMovieClip.convertToClip();
      paramTAVMovieClip.getResource().setSourceTimeRange((CMTimeRange)localObject1);
      paramTAVMovieClip.putExtraTrackInfo("pag_layer_index", String.valueOf(paramMovieSegment.getLayerIndex()));
      localArrayList1.add(paramTAVMovieClip);
      localArrayList2.add(localTAVMovieClip);
      paramTAVMovieClip = ((CMTime)localObject2).sub((CMTime)localObject3);
      localObject2 = paramTAVMovieClip;
      if (paramTAVMovieClip.getTimeUs() > 0L)
      {
        if (paramList1.size() == 0) {
          break;
        }
        localTAVMovieClip = (TAVMovieClip)paramList1.remove(0);
        localObject2 = paramTAVMovieClip;
      }
    }
    paramMovieSegment.setTavMovieClips(localArrayList2);
    if ((paramList2 != null) && (!localArrayList1.isEmpty()))
    {
      paramList.addAll(TAVMovieTimeEffectUtil.applyTimeEffectsNew(localArrayList1, paramList2));
      return;
    }
    paramList.addAll(localArrayList1);
  }
  
  private void fillSegments(MovieSegment paramMovieSegment, List<TAVMovieClip> paramList, @Nullable List<TAVMovieTimeEffect> paramList1, List<TAVClip> paramList2)
  {
    if ((paramMovieSegment != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = paramList2;
      if (paramList2 == null) {
        localObject = new ArrayList();
      }
      if (this.mNeedCycleFill)
      {
        paramList2 = (TAVMovieClip)paramList.remove(0);
        paramList.add(paramList2.clone());
      }
      else
      {
        paramList2 = (TAVMovieClip)paramList.remove(0);
      }
      if (paramList2 != null)
      {
        if (paramList2.getResource() == null) {
          return;
        }
        TAVMovieResource.TAVResourceType localTAVResourceType = paramList2.getResource().getType();
        int i = MovieTemplate.2.$SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType[localTAVResourceType.ordinal()];
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          fillClipsVideo(paramList2, paramMovieSegment, (List)localObject, paramList, paramList1);
          return;
        }
        fillClipsPhoto(paramList2, paramMovieSegment, (List)localObject);
      }
    }
  }
  
  private List<TAVSegmentImageEffect> getSegmentImageEffects(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    if (paramTAVStickerLayerInfo == null) {
      return null;
    }
    paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getImageEffects();
    if (paramTAVStickerLayerInfo != null)
    {
      if (paramTAVStickerLayerInfo.isEmpty()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramTAVStickerLayerInfo.iterator();
      while (localIterator.hasNext())
      {
        TAVStickerLayerInfo.TAVStickerImageEffect localTAVStickerImageEffect = (TAVStickerLayerInfo.TAVStickerImageEffect)localIterator.next();
        TAVSegmentImageEffect localTAVSegmentImageEffect = new TAVSegmentImageEffect();
        if (localTAVStickerImageEffect == null) {
          paramTAVStickerLayerInfo = null;
        } else {
          paramTAVStickerLayerInfo = localTAVStickerImageEffect.getTimeRange();
        }
        localTAVSegmentImageEffect.setTimeRange(paramTAVStickerLayerInfo);
        if (localTAVStickerImageEffect == null) {
          paramTAVStickerLayerInfo = null;
        } else {
          paramTAVStickerLayerInfo = localTAVStickerImageEffect.getEffectId();
        }
        localTAVSegmentImageEffect.setEffectID(paramTAVStickerLayerInfo);
        if (localTAVStickerImageEffect == null) {
          paramTAVStickerLayerInfo = null;
        } else {
          paramTAVStickerLayerInfo = localTAVStickerImageEffect.getName();
        }
        localTAVSegmentImageEffect.setName(paramTAVStickerLayerInfo);
        localArrayList.add(localTAVSegmentImageEffect);
      }
      return localArrayList;
    }
    return null;
  }
  
  private List<TAVMovieTimeEffect> getSegmentTimeEffects(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    if (paramTAVStickerLayerInfo == null) {
      return null;
    }
    Object localObject = paramTAVStickerLayerInfo.getTimeEffects();
    if (localObject == null) {
      return null;
    }
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
        } else {
          localTAVMovieTimeEffect.setSpeed(((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getSourceVideoTimeRange().getDuration().getTimeSeconds() / ((TAVStickerLayerInfo.TAVStickerTimeEffect)localObject).getTimeRange().getDuration().getTimeSeconds());
        }
        localArrayList.add(localTAVMovieTimeEffect);
      }
    }
    return localArrayList;
  }
  
  private void initData()
  {
    parsePackagePath();
    this.mSegments = new ArrayList();
    this.mStickers = new ArrayList();
    if (TextUtils.isEmpty(this.mFilePath)) {
      return;
    }
    this.mTemplateSticker = new TAVMovieSticker(this.mFilePath, this.mIsAsset);
    parseLayerInfos();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPackagePath);
    localStringBuilder.append("/");
    localStringBuilder.append("audio");
    localStringBuilder.append(".pcm");
    this.mPagAudioPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pag audio path: ");
    localStringBuilder.append(this.mPagAudioPath);
    Logger.d("MovieTemplate", localStringBuilder.toString());
    if (this.mTemplateSticker.getSticker() != null) {
      this.renderSize = new CGSize(this.mTemplateSticker.getSticker().getWidth(), this.mTemplateSticker.getSticker().getHeight());
    }
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
    if (paramTAVMovieClip1 != null)
    {
      if (paramTAVMovieClip2 == null) {
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
    }
    return false;
  }
  
  private boolean isSampleTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCMTimeRange1 != null)
    {
      if (paramCMTimeRange2 == null) {
        return false;
      }
      if (paramCMTimeRange1.getStart().getTimeScale() != paramCMTimeRange2.getStart().getTimeScale()) {
        return false;
      }
      if (paramCMTimeRange1.getDuration().getTimeScale() != paramCMTimeRange2.getDuration().getTimeScale()) {
        return false;
      }
      long l1 = Math.round((float)paramCMTimeRange1.getStart().value / 1000000.0F);
      long l2 = Math.round((float)paramCMTimeRange2.getStart().value / 1000000.0F);
      long l3 = Math.round((float)paramCMTimeRange1.getDuration().value / 1000000.0F);
      long l4 = Math.round((float)paramCMTimeRange2.getDuration().value / 1000000.0F);
      paramCMTimeRange1 = new StringBuilder();
      paramCMTimeRange1.append("SV1 ");
      paramCMTimeRange1.append(l1);
      paramCMTimeRange1.append(" SV2 ");
      paramCMTimeRange1.append(l2);
      paramCMTimeRange1.append(" dv1 ");
      paramCMTimeRange1.append(l3);
      paramCMTimeRange1.append(" dv2 ");
      paramCMTimeRange1.append(l4);
      Logger.i("MovieTemplate", paramCMTimeRange1.toString());
      bool1 = bool2;
      if (l1 == l2)
      {
        bool1 = bool2;
        if (l3 == l4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isSingleVideo(List<TAVMovieClip> paramList)
  {
    return (paramList != null) && (paramList.size() == 1) && (((TAVMovieClip)paramList.get(0)).getResource().getType() == TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
  }
  
  private void loadAudioData(TAVSticker paramTAVSticker)
  {
    if (FileUtils.exists(this.mPagAudioPath))
    {
      paramTAVSticker = this.mLoadDataListeners;
      if (paramTAVSticker != null)
      {
        paramTAVSticker = paramTAVSticker.iterator();
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
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
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
  }
  
  private void parsePackagePath()
  {
    if (TextUtils.isEmpty(this.mFilePath)) {
      return;
    }
    File localFile = new File(this.mFilePath);
    if (!localFile.exists()) {
      return;
    }
    this.mPackagePath = localFile.getParentFile().getAbsolutePath();
  }
  
  private void replaceBitmap(TAVStickerImageItem paramTAVStickerImageItem, String paramString)
  {
    if ((paramTAVStickerImageItem != null) && (FileUtils.exists(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set PAGImage url = ");
      localStringBuilder.append(paramString);
      Logger.e("MovieTemplate", localStringBuilder.toString());
      paramTAVStickerImageItem.setBitmap(BitmapFactory.decodeFile(paramString, new BitmapFactory.Options()));
      this.mHasImageLayerSet = true;
    }
  }
  
  private List<TAVMovieClip> separateClip(TAVMovieClip paramTAVMovieClip)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mSegments.iterator();
    while (localIterator.hasNext())
    {
      MovieSegment localMovieSegment = (MovieSegment)localIterator.next();
      if (localMovieSegment != null)
      {
        if (!localMovieSegment.getMinOriginDuration().smallThan(paramTAVMovieClip.getResource().getTimeRange().getDuration()))
        {
          localArrayList.add(paramTAVMovieClip);
          return localArrayList;
        }
        TAVMovieClip localTAVMovieClip = paramTAVMovieClip.clone();
        localTAVMovieClip.getResource().setTimeRange(new CMTimeRange(localTAVMovieClip.getResource().getTimeRange().getStart(), localMovieSegment.getMinOriginDuration()));
        localArrayList.add(localTAVMovieClip);
        paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(localTAVMovieClip.getResource().getTimeRange().getEnd(), paramTAVMovieClip.getResource().getTimeRange().getDuration().sub(localTAVMovieClip.getResource().getTimeRange().getDuration())));
      }
    }
    return localArrayList;
  }
  
  private List<TAVMovieClip> separateClips(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(16);
    CMTime localCMTime = CMTime.CMTimeZero;
    Object localObject1 = this.mSegments.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      if (localObject2 == null) {
        ((Iterator)localObject1).remove();
      } else {
        localCMTime = localCMTime.add(((MovieSegment)localObject2).getTimeRange().getDuration());
      }
    }
    if (!localCMTime.equalsTo(CMTime.CMTimeZero))
    {
      if (localCMTime.smallThan(CMTime.CMTimeZero)) {
        return localArrayList;
      }
      localObject1 = CMTime.CMTimeZero;
      localObject2 = paramList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TAVMovieClip)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((TAVMovieClip)localObject3).getResource() != null) && (((TAVMovieClip)localObject3).getResource().getTimeRange() != null)) {
          localObject1 = ((CMTime)localObject1).add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
        } else {
          ((Iterator)localObject2).remove();
        }
      }
      if (!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
      {
        if (((CMTime)localObject1).smallThan(CMTime.CMTimeZero)) {
          return localArrayList;
        }
        Object localObject4 = paramList.iterator();
        TAVMovieClip localTAVMovieClip;
        while (((Iterator)localObject4).hasNext())
        {
          localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
          localObject2 = localTAVMovieClip.getResource().getTimeRange().getDuration();
          localObject3 = ((CMTime)localObject2).multi(localCMTime).divide((CMTime)localObject1);
          if (((CMTime)localObject2).bigThan((CMTime)localObject3)) {
            localObject2 = localObject3;
          }
          localConcurrentHashMap.put(((TAVMovieTrackResource)localTAVMovieClip.getResource()).getFilePath(), localObject2);
        }
        int i = 0;
        while (i < this.mSegments.size())
        {
          if (paramList.isEmpty()) {
            return localArrayList;
          }
          for (localCMTime = ((MovieSegment)this.mSegments.get(i)).getMinOriginDuration().clone(); (localCMTime.getTimeUs() > 0L) && (!paramList.isEmpty()); localCMTime = localCMTime.sub((CMTime)localObject3))
          {
            label373:
            localObject2 = (TAVMovieClip)paramList.remove(0);
            localObject3 = ((TAVMovieClip)localObject2).getResource().getTimeRange().getDuration();
            localObject1 = CMTime.CMTimeZero;
            localObject4 = localArrayList.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
              if (TextUtils.equals(((TAVMovieTrackResource)localTAVMovieClip.getResource()).getFilePath(), ((TAVMovieTrackResource)((TAVMovieClip)localObject2).getResource()).getFilePath())) {
                localObject1 = ((CMTime)localObject1).add(localTAVMovieClip.getResource().getTimeRange().getDuration());
              }
            }
            if ((!((CMTime)localObject1).smallThan((CMTime)localConcurrentHashMap.get(((TAVMovieTrackResource)((TAVMovieClip)localObject2).getResource()).getFilePath()))) || (!((CMTime)localObject3).bigThan(CMTime.CMTimeZero)) || ((!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero)) && (((CMTime)localObject3).smallThan(localCMTime)))) {
              break label373;
            }
            localObject1 = ((TAVMovieClip)localObject2).clone();
            localObject4 = ((TAVMovieClip)localObject1).getResource().getTimeRange();
            if (((CMTime)localObject3).bigThan(localCMTime)) {
              ((CMTimeRange)localObject4).setDuration(localCMTime);
            } else {
              ((CMTimeRange)localObject4).setDuration((CMTime)localObject3);
            }
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
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public TAVComposition buildCompositionFromMovie(TAVMovie paramTAVMovie)
  {
    return null;
  }
  
  public List<TAVMovieSegment> convertClips(List<TAVMovieClip> paramList)
  {
    Object localObject1 = CloneUtil.cloneMovieClips(paramList);
    boolean bool = isSingleVideo((List)localObject1);
    if ((bool) && (this.mSegments.size() > 1))
    {
      paramList = separateClip((TAVMovieClip)((List)localObject1).get(0));
    }
    else
    {
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
    this.mNeedCycleFill = isNeedCycleFill(paramList);
    localObject1 = this.mSegments.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      ((MovieSegment)localObject2).setTavClips(null);
      ((MovieSegment)localObject2).setTavMovieClips(null);
    }
    localObject1 = this.mSegments.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MovieSegment)((Iterator)localObject1).next();
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      localObject3 = new ArrayList();
      List localList = ((MovieSegment)localObject2).separateSegmentByTimeEffects();
      Logger.d("MovieTemplate", "fillSegments begin");
      fillSegments((MovieSegment)localObject2, paramList, localList, (List)localObject3);
      Logger.d("MovieTemplate", "fillSegments end");
      if (!((List)localObject3).isEmpty()) {
        ((MovieSegment)localObject2).setTavClips((List)localObject3);
      }
    }
    correctSegments();
    paramList = new ArrayList(this.mCorrectSegments);
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVMovieSegment)((Iterator)localObject1).next();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("segment, layerIndex: ");
      ((StringBuilder)localObject3).append(((TAVMovieSegment)localObject2).getLayerIndex());
      ((StringBuilder)localObject3).append(", start clip time: ");
      ((StringBuilder)localObject3).append(((TAVMovieSegment)localObject2).getTimeRange().getStart().getTimeSeconds());
      ((StringBuilder)localObject3).append(", end time: ");
      ((StringBuilder)localObject3).append(((TAVMovieSegment)localObject2).getTimeRange().getEnd().getTimeSeconds());
      Logger.d("MovieTemplate", ((StringBuilder)localObject3).toString());
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
    Object localObject = this.mOriginClips;
    if (localObject != null) {
      return localObject;
    }
    if (this.mCorrectSegments != null)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.mCorrectSegments.iterator();
      while (localIterator.hasNext())
      {
        TAVMovieSegment localTAVMovieSegment = (TAVMovieSegment)localIterator.next();
        if (localTAVMovieSegment != null) {
          ((List)localObject).addAll(localTAVMovieSegment.getTavMovieClips());
        }
      }
      return localObject;
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
    Object localObject = this.mSegments;
    MovieSegment localMovieSegment;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMovieSegment = (MovieSegment)((Iterator)localObject).next();
        if (localMovieSegment != null) {
          localMovieSegment.release();
        }
      }
    }
    localObject = this.mCorrectSegments;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMovieSegment = (MovieSegment)((Iterator)localObject).next();
        if (localMovieSegment != null) {
          localMovieSegment.release();
        }
      }
    }
  }
  
  public void replaceSegment(MovieSegment paramMovieSegment)
  {
    if (paramMovieSegment != null)
    {
      if (this.mCorrectSegments == null) {
        return;
      }
      int i = paramMovieSegment.getIndex();
      if (i >= 0)
      {
        this.mCorrectSegments.remove(i);
        this.mCorrectSegments.add(i, paramMovieSegment);
      }
    }
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
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplate
 * JD-Core Version:    0.7.0.1
 */