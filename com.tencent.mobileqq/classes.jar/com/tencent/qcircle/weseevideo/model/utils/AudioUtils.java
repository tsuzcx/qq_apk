package com.tencent.qcircle.weseevideo.model.utils;

import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioUtils
{
  public static final String AUDIO_TAG_KEY = "audio_tag_key";
  public static final String AUDIO_TYPE_KEY = "audio_type_key";
  
  private static TAVAudioConfiguration.VolumeEdge createVolumeEdge(CMTime paramCMTime, long paramLong, float paramFloat1, float paramFloat2)
  {
    TAVAudioConfiguration.VolumeEdge localVolumeEdge = new TAVAudioConfiguration.VolumeEdge();
    localVolumeEdge.setStartVolume(paramFloat1);
    localVolumeEdge.setEndVolume(paramFloat2);
    localVolumeEdge.setTimeRange(new CMTimeRange(paramCMTime, CMTime.fromMs(paramLong)));
    return localVolumeEdge;
  }
  
  public static TAVClip generateAudioClip(@NonNull String paramString, @NonNull CMTimeRange paramCMTimeRange)
  {
    paramString = VideoUtils.createAsset(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = new TAVClip(paramString);
    paramString.getResource().setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramCMTimeRange.getDuration()));
    paramString.setStartTime(paramCMTimeRange.getStart());
    paramString.setDuration(paramCMTimeRange.getDuration());
    return paramString;
  }
  
  public static List<TAVClip> getAudioBySymbol(@NonNull AudioUtils.AudioSymbol paramAudioSymbol, @NonNull List<TAVClip> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)paramList.next();
      if (TextUtils.equals(String.valueOf(localTAVClip.getExtraTrackInfo("audio_type_key")), paramAudioSymbol.name())) {
        localArrayList.add(localTAVClip);
      }
    }
    return localArrayList;
  }
  
  public static List<TAVClip> getAudioByUserTag(@NonNull String paramString, @NonNull List<TAVClip> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)paramList.next();
      Object localObject = localTAVClip.getExtraTrackInfo("audio_tag_key");
      if (((localObject instanceof String)) && (TextUtils.equals(paramString, (String)localObject))) {
        localArrayList.add(localTAVClip);
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<TAVClip> getBGMAudioClips(long paramLong, @Nullable MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMusicMaterialMetaDataBean != null) && (!TextUtils.isEmpty(paramMusicMaterialMetaDataBean.path)))
    {
      long l2 = paramMusicMaterialMetaDataBean.startTime;
      long l3 = paramMusicMaterialMetaDataBean.mTotalTimeMs;
      long l1 = paramMusicMaterialMetaDataBean.segDuration;
      if ((l1 != 0L) && (paramMusicMaterialMetaDataBean.isEdit)) {
        break label70;
      }
      l1 = l3 - l2;
      label70:
      if (l1 <= paramLong) {
        paramLong = l1;
      }
      Object localObject = VideoUtils.createAsset(paramMusicMaterialMetaDataBean.path);
      if (localObject == null) {
        return null;
      }
      localObject = new TAVClip((Asset)localObject);
      ((TAVClip)localObject).getResource().setSourceTimeRange(new CMTimeRange(CMTime.fromMs(l2), CMTime.fromMs(paramLong)));
      ((TAVClip)localObject).getAudioConfiguration().setVolume(paramFloat);
      ((TAVClip)localObject).setStartTime(CMTime.fromMs(paramMusicMaterialMetaDataBean.startPlayOffset));
      ((TAVClip)localObject).setDuration(CMTime.fromMs(paramLong));
      localArrayList.add(localObject);
    }
    markAudioSymbol(AudioUtils.AudioSymbol.BGM, localArrayList);
    return localArrayList;
  }
  
  public static int getDuration(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        paramString = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  public static boolean markAudioSymbol(AudioUtils.AudioSymbol paramAudioSymbol, @NonNull List<TAVClip> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((TAVClip)paramList.next()).putExtraTrackInfo("audio_type_key", paramAudioSymbol);
    }
    return true;
  }
  
  public static void markAudioUserTag(@NonNull String paramString1, @NonNull String paramString2, @NonNull TAVClip paramTAVClip)
  {
    paramTAVClip.putExtraTrackInfo(paramString1, paramString2);
  }
  
  public static boolean markAudiosUserTag(@NonNull String paramString, @NonNull List<TAVClip> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      markAudioUserTag("audio_tag_key", paramString, (TAVClip)paramList.next());
    }
    return true;
  }
  
  private static void parseVolumeEffectOld(TAVClip paramTAVClip, long paramLong1, long paramLong2, MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    long l1 = paramMusicMaterialMetaDataBean.startInTime;
    long l2 = paramMusicMaterialMetaDataBean.endOutTime;
    paramMusicMaterialMetaDataBean = createVolumeEdge(CMTime.fromMs(paramLong1), l1, 0.0F, 1.0F);
    TAVAudioConfiguration.VolumeEdge localVolumeEdge = createVolumeEdge(CMTime.fromMs(paramLong1 + paramLong2), l2, 1.0F, 0.0F);
    paramTAVClip.getAudioConfiguration().setStartVolumeEdge(paramMusicMaterialMetaDataBean);
    paramTAVClip.getAudioConfiguration().setEndVolumeEdge(localVolumeEdge);
  }
  
  public static void updateClipAssetPath(@NonNull TAVClip paramTAVClip, @NonNull String paramString)
  {
    if ((paramTAVClip.getResource() instanceof TAVAssetTrackResource))
    {
      TAVAssetTrackResource localTAVAssetTrackResource = (TAVAssetTrackResource)paramTAVClip.getResource();
      paramString = new TAVAssetTrackResource(paramString);
      paramString.setDuration(localTAVAssetTrackResource.getDuration().clone());
      paramString.setSourceTimeRange(localTAVAssetTrackResource.getSourceTimeRange().clone());
      paramTAVClip.setResource(paramString);
    }
  }
  
  public static void updateCompositionAudiosBySymbol(TAVComposition paramTAVComposition, List<TAVClip> paramList, AudioUtils.AudioSymbol paramAudioSymbol)
  {
    if ((paramTAVComposition == null) && (CollectionUtils.isEmpty(paramList))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramTAVComposition.getAudios();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        TAVClip localTAVClip = (TAVClip)localIterator.next();
        localObject1 = null;
        Object localObject2 = localTAVClip.getExtraTrackInfo("audio_type_key");
        if ((localObject2 instanceof AudioUtils.AudioSymbol)) {
          localObject1 = (AudioUtils.AudioSymbol)localObject2;
        }
        if ((localObject1 == null) || (((AudioUtils.AudioSymbol)localObject1).ordinal() != paramAudioSymbol.ordinal())) {
          localArrayList.add(localTAVClip);
        }
      }
    }
    localArrayList.addAll(paramList);
    paramTAVComposition.setAudios(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.AudioUtils
 * JD-Core Version:    0.7.0.1
 */