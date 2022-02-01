package com.tencent.tav.player;

import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerItem
{
  private Asset asset;
  private AssetExtension assetExtension;
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  @Nullable
  private AudioMix audioMix;
  String audioTimePitchAlgorithm;
  @Nullable
  VideoCompositing customVideoCompositor;
  private List<IDecoderTrack> decoderTrackList;
  private CMTime duration;
  private ErrorMsg errorMsg;
  private CMTime forwardPlaybackEndTime;
  private PlayerLayer layer = null;
  private int maxCacheSize = 60;
  List<PlayerItemOutput> outputs;
  private Player player;
  private PlayerThreadAudio playerThreadAudio;
  private PlayerThread playerThreadMain;
  private CGSize presentationSize;
  private float rate = 1.0F;
  private IDecoderTrack realVDecoderTrack;
  private CMTime reversePlaybackEndTime;
  private List<CMTimeRange> seekableTimeRanges;
  private boolean seekingWaitsForVideoCompositionRendering;
  private PlayerItem.PlayerItemStatus status = PlayerItem.PlayerItemStatus.PlayerItemStatusUnknown;
  private List<MetadataItem> timedMetadata;
  private List<PlayerItemTrack> tracks = new ArrayList();
  private IDecoderTrack vDecoderTrack;
  int videoApertureMode;
  @Nullable
  private VideoComposition videoComposition;
  
  public PlayerItem(Asset paramAsset)
  {
    this(paramAsset, new AssetExtension("play"));
  }
  
  public PlayerItem(Asset paramAsset, AssetExtension paramAssetExtension)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    paramAsset = paramAsset.getTracks().iterator();
    while (paramAsset.hasNext())
    {
      paramAssetExtension = (AssetTrack)paramAsset.next();
      PlayerItemTrack localPlayerItemTrack = new PlayerItemTrack();
      localPlayerItemTrack.setAssetTrack(paramAssetExtension);
      localPlayerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
      localPlayerItemTrack.setEnabled(true);
      this.tracks.add(localPlayerItemTrack);
    }
  }
  
  public PlayerItem(String paramString)
  {
    this(new URLAsset(paramString), null);
  }
  
  private float getVideoFrameRate()
  {
    VideoComposition localVideoComposition = this.videoComposition;
    if (localVideoComposition != null) {
      return localVideoComposition.getFrameDuration().timeScale * 1.0F / (float)this.videoComposition.getFrameDuration().getValue();
    }
    return PlayerDefaultConfigs.DEFAULT_FRAME_DURATION.timeScale;
  }
  
  private void initVideoCompositionDecoderTrack()
  {
    VideoCompositionDecoderTrack localVideoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
    Object localObject = this.tracks.iterator();
    label31:
    PlayerItemTrack localPlayerItemTrack;
    for (int i = 24; ((Iterator)localObject).hasNext(); i = (int)Math.min(localPlayerItemTrack.getCurrentVideoFrameRate(), i))
    {
      localPlayerItemTrack = (PlayerItemTrack)((Iterator)localObject).next();
      if ((localPlayerItemTrack == null) || (!localPlayerItemTrack.isEnabled()) || (localPlayerItemTrack.getAssetTrack().getMediaType() != 1)) {
        break label31;
      }
      localVideoCompositionDecoderTrack.addTrack(localPlayerItemTrack.getAssetTrack());
    }
    localObject = this.videoComposition;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (((VideoComposition)localObject).getFrameDuration() != null) {
        j = (int)(this.videoComposition.getFrameDuration().timeScale / this.videoComposition.getFrameDuration().value);
      }
    }
    if (j <= 0) {
      j = 30;
    }
    localVideoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
    localObject = this.customVideoCompositor;
    if (localObject != null) {
      localVideoCompositionDecoderTrack.setVideoCompositing((VideoCompositing)localObject);
    }
    localVideoCompositionDecoderTrack.setFrameRate(j);
    localVideoCompositionDecoderTrack.setFrameDuration(new CMTime(1L, j));
    this.realVDecoderTrack = localVideoCompositionDecoderTrack;
  }
  
  public void addOutput(PlayerItemOutput paramPlayerItemOutput)
  {
    this.outputs.add(paramPlayerItemOutput);
  }
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    this.layer = paramPlayerLayer;
    if (this.playerThreadMain == null) {
      return;
    }
    float f = this.rate;
    IDecoderTrack localIDecoderTrack;
    if (f < 0.0F)
    {
      localIDecoderTrack = this.realVDecoderTrack;
      boolean bool;
      if (f < 0.0F) {
        bool = true;
      } else {
        bool = false;
      }
      this.vDecoderTrack = new CachedVideoDecoderTrack(localIDecoderTrack, bool);
      ((CachedVideoDecoderTrack)this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
      localIDecoderTrack = this.vDecoderTrack;
    }
    else
    {
      localIDecoderTrack = this.realVDecoderTrack;
    }
    this.playerThreadMain.bindSurface(localIDecoderTrack, paramPlayerLayer);
  }
  
  public void cancelPendingSeeks()
  {
    PlayerThread localPlayerThread = this.playerThreadMain;
    if (localPlayerThread != null) {
      localPlayerThread.cancelAllPendingSeeks();
    }
  }
  
  public CMTime currentTime()
  {
    return null;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  public AudioCompositionDecoderTrack getAudioCompositionDecoderTrack()
  {
    return this.audioCompositionDecoderTrack;
  }
  
  @Nullable
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public String getAudioTimePitchAlgorithm()
  {
    return this.audioTimePitchAlgorithm;
  }
  
  @Nullable
  public VideoCompositing getCustomVideoCompositor()
  {
    return this.customVideoCompositor;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public ErrorMsg getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public CMTime getForwardPlaybackEndTime()
  {
    return this.forwardPlaybackEndTime;
  }
  
  public List<PlayerItemOutput> getOutputs()
  {
    return this.outputs;
  }
  
  PlayerThreadAudio getPlayerThreadAudio()
  {
    return this.playerThreadAudio;
  }
  
  PlayerThread getPlayerThreadMain()
  {
    return this.playerThreadMain;
  }
  
  public CGSize getPresentationSize()
  {
    if (this.presentationSize == null) {
      return this.asset.getNaturalSize();
    }
    return new CGSize(16.0F, 16.0F);
  }
  
  public IDecoderTrack getRealDecoderTrack()
  {
    float f = this.rate;
    if (f < 0.0F)
    {
      IDecoderTrack localIDecoderTrack = this.realVDecoderTrack;
      boolean bool;
      if (f < 0.0F) {
        bool = true;
      } else {
        bool = false;
      }
      this.vDecoderTrack = new CachedVideoDecoderTrack(localIDecoderTrack, bool);
      ((CachedVideoDecoderTrack)this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
      return this.vDecoderTrack;
    }
    return this.realVDecoderTrack;
  }
  
  public CMTime getReversePlaybackEndTime()
  {
    return this.reversePlaybackEndTime;
  }
  
  public List<CMTimeRange> getSeekableTimeRanges()
  {
    return this.seekableTimeRanges;
  }
  
  public PlayerItem.PlayerItemStatus getStatus()
  {
    return this.status;
  }
  
  public List<MetadataItem> getTimedMetadata()
  {
    return this.timedMetadata;
  }
  
  public List<PlayerItemTrack> getTracks()
  {
    return this.tracks;
  }
  
  public int getVideoApertureMode()
  {
    return this.videoApertureMode;
  }
  
  @Nullable
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  AudioCompositionDecoderTrack initAudioCompositionDecoderTrack()
  {
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(2);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      PlayerItemTrack localPlayerItemTrack = (PlayerItemTrack)localIterator.next();
      if ((localPlayerItemTrack != null) && (localPlayerItemTrack.isEnabled()) && (localPlayerItemTrack.getAssetTrack().getMediaType() == 2)) {
        this.audioCompositionDecoderTrack.addTrack(localPlayerItemTrack.getAssetTrack());
      }
    }
    this.audioCompositionDecoderTrack.setAudioMix(this.audioMix);
    return this.audioCompositionDecoderTrack;
  }
  
  public boolean isSeekingWaitsForVideoCompositionRendering()
  {
    return this.seekingWaitsForVideoCompositionRendering;
  }
  
  void release()
  {
    Object localObject = this.layer;
    if (localObject != null) {
      ((PlayerLayer)localObject).release();
    }
    localObject = this.audioMix;
    if (localObject != null) {
      ((AudioMix)localObject).release();
    }
  }
  
  public void removeOutput(PlayerItemOutput paramPlayerItemOutput)
  {
    this.outputs.remove(paramPlayerItemOutput);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, Callback paramCallback)
  {
    paramCMTime2 = this.playerThreadMain;
    if (paramCMTime2 != null)
    {
      paramCMTime2.updatePositionRightAway(paramCMTime1);
      this.playerThreadMain.sendMessage(5, paramCMTime1, "main");
    }
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    seekToTime(paramCMTime, CMTime.CMTimeZero, CMTime.CMTimeZero, paramCallback);
  }
  
  public void setAudioMix(@Nullable AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
    if (localAudioCompositionDecoderTrack != null) {
      localAudioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
  }
  
  public void setAudioTimePitchAlgorithm(String paramString)
  {
    this.audioTimePitchAlgorithm = paramString;
  }
  
  void setCustomVideoCompositor(@Nullable VideoCompositing paramVideoCompositing)
  {
    this.customVideoCompositor = paramVideoCompositing;
  }
  
  public void setForwardPlaybackEndTime(CMTime paramCMTime)
  {
    this.forwardPlaybackEndTime = paramCMTime;
  }
  
  void setOutputs(List<PlayerItemOutput> paramList)
  {
    this.outputs = paramList;
  }
  
  public void setRate(float paramFloat)
  {
    setRate(paramFloat, this.maxCacheSize);
  }
  
  public void setRate(float paramFloat, int paramInt)
  {
    this.rate = paramFloat;
    this.maxCacheSize = paramInt;
    PlayerThread localPlayerThread = this.playerThreadMain;
    if (localPlayerThread != null) {
      localPlayerThread.setRate(paramFloat);
    }
  }
  
  public void setReversePlaybackEndTime(CMTime paramCMTime)
  {
    this.reversePlaybackEndTime = paramCMTime;
  }
  
  public void setSeekableTimeRanges(List<CMTimeRange> paramList)
  {
    this.seekableTimeRanges = paramList;
  }
  
  public void setSeekingWaitsForVideoCompositionRendering(boolean paramBoolean)
  {
    this.seekingWaitsForVideoCompositionRendering = paramBoolean;
  }
  
  public void setVideoApertureMode(int paramInt)
  {
    this.videoApertureMode = paramInt;
  }
  
  public void setVideoComposition(@Nullable VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.customVideoCompositor = paramVideoComposition.getCustomVideoCompositor();
    }
  }
  
  void start(Player paramPlayer)
  {
    initVideoCompositionDecoderTrack();
    initAudioCompositionDecoderTrack();
    IDecoderTrack localIDecoderTrack;
    if (this.layer == null) {
      localIDecoderTrack = null;
    } else {
      localIDecoderTrack = this.vDecoderTrack;
    }
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
    CGSize localCGSize = getPresentationSize();
    Object localObject = this.layer;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((PlayerLayer)localObject).getSurface();
    }
    this.playerThreadMain = new PlayerThread(localIDecoderTrack, localAudioCompositionDecoderTrack, localCGSize, (Surface)localObject, paramPlayer.mMainHandler, paramPlayer);
    this.playerThreadMain.setRate(this.rate);
    paramPlayer = this.videoComposition;
    if (paramPlayer != null) {
      this.playerThreadMain.setFrameDuration(paramPlayer.getFrameDuration());
    }
  }
  
  public void updateComposition(Asset paramAsset)
  {
    this.asset = paramAsset;
    this.tracks.clear();
    paramAsset = paramAsset.getTracks().iterator();
    while (paramAsset.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)paramAsset.next();
      PlayerItemTrack localPlayerItemTrack = new PlayerItemTrack();
      localPlayerItemTrack.setAssetTrack(localAssetTrack);
      localPlayerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
      localPlayerItemTrack.setEnabled(true);
      this.tracks.add(localPlayerItemTrack);
    }
  }
  
  void updateDecoderTrack()
  {
    initVideoCompositionDecoderTrack();
    initAudioCompositionDecoderTrack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItem
 * JD-Core Version:    0.7.0.1
 */