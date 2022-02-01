package com.tencent.superplayer.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.superplayer.bandwidth.AbstractPredictor;
import com.tencent.superplayer.bandwidth.IBandwidthObtainer;
import com.tencent.superplayer.bandwidth.SPBandwidthMonitor;
import com.tencent.superplayer.bandwidth.SPBandwidthPredictor;
import com.tencent.superplayer.bandwidth.SPBufferRangeController;
import com.tencent.superplayer.capture.SPlayerImageGenerator;
import com.tencent.superplayer.datatransport.SPlayerDownloaderImpl;
import com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.preload.SPlayerPreLoaderImpl;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_DRM_TYPE;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import java.util.ArrayList;
import java.util.Map;

public class SuperPlayerFactory
{
  public static ISPBandwidthMonitor createBandwidthMonitor(int paramInt)
  {
    return new SPBandwidthMonitor(paramInt);
  }
  
  public static ISPBandwidthPredictor createBandwidthPredictor(Context paramContext)
  {
    return new SPBandwidthPredictor(paramContext);
  }
  
  public static ISPBandwidthPredictor createBandwidthPredictor(Context paramContext, @Nullable ArrayList<AbstractPredictor> paramArrayList, @Nullable ArrayList<IBandwidthObtainer> paramArrayList1, @Nullable Map<String, String> paramMap)
  {
    return new SPBandwidthPredictor(paramContext, paramArrayList, paramArrayList1, paramMap);
  }
  
  public static ISPBufferRangeController createBufferRangeController(@NonNull ISPBandwidthPredictor paramISPBandwidthPredictor, @NonNull Map<String, String> paramMap)
  {
    return new SPBufferRangeController(paramISPBandwidthPredictor, paramMap);
  }
  
  public static ISPlayerDownloader createDownloader(Context paramContext, int paramInt)
  {
    return new SPlayerDownloaderImpl(paramContext, paramInt);
  }
  
  public static ISPlayerImageGenerator createImageGenerator(String paramString)
  {
    return new SPlayerImageGenerator(paramString);
  }
  
  public static ISuperPlayer createMediaPlayer(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    return new SuperPlayerMgr(paramContext, paramInt, paramISPlayerVideoView);
  }
  
  public static ISPlayerVideoView createPlayerVideoView(Context paramContext)
  {
    return new SPlayerVideoView(paramContext, true);
  }
  
  public static ISPlayerVideoView createPlayerVideoView(Context paramContext, boolean paramBoolean)
  {
    return new SPlayerVideoView(paramContext, paramBoolean);
  }
  
  public static ISPlayerPreDownloader createPreDownloader(Context paramContext, int paramInt)
  {
    return new SPlayerPreDownloaderImpl(paramContext, paramInt);
  }
  
  public static ISPlayerPreLoader createPreLoader(int paramInt1, int paramInt2)
  {
    return new SPlayerPreLoaderImpl(paramInt1, paramInt2);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForDRM(@TPCommonEnum.TP_DRM_TYPE int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setFormat(paramInt2);
    localSuperPlayerVideoInfo.setPlayUrl(paramString1);
    paramString1 = TPMediaCompositionFactory.createMediaDRMAsset(paramInt1, paramString1);
    paramString1.setDrmProperty("drm_property_provision_url", paramString2);
    paramString1.setDrmProperty("drm_property_license_url", paramString3);
    if (paramInt1 == 0) {
      paramString1.setDrmProperty("drm_property_use_l1", "1");
    }
    localSuperPlayerVideoInfo.setMediaAssert(paramString1);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(int paramInt, String paramString)
  {
    return new SuperPlayerVideoInfo(1, 1, paramInt, paramString);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(int paramInt, String paramString1, String paramString2)
  {
    return new SuperPlayerVideoInfo(1, 2, paramInt, paramString1, paramString2);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(String paramString)
  {
    return new SuperPlayerVideoInfo(1, 1, paramString);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(String paramString1, String paramString2)
  {
    return new SuperPlayerVideoInfo(1, 2, paramString1, paramString2);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String paramString1, int paramInt, String paramString2)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramString1);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString2);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramString1);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString2);
    localSuperPlayerVideoInfo.setLocalSavePath(paramString3);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] paramArrayOfString, int paramInt, long paramLong, String paramString)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramArrayOfString);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setVideoDurationMs(paramLong);
    localSuperPlayerVideoInfo.setFileId(paramString);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] paramArrayOfString, int paramInt, String paramString)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramArrayOfString);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] paramArrayOfString, int paramInt, String paramString1, String paramString2)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramArrayOfString);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString1);
    localSuperPlayerVideoInfo.setLocalSavePath(paramString2);
    return localSuperPlayerVideoInfo;
  }
  
  public static ISuperPlayer obtainMediaPlayer(String paramString)
  {
    return SuperPlayerSDKMgr.getPlayerPool().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerFactory
 * JD-Core Version:    0.7.0.1
 */