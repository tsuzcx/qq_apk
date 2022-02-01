package com.tencent.tav.player;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerItem
{
  private Asset asset;
  private final AssetExtension assetExtension;
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  @Nullable
  private AudioMix audioMix;
  private boolean audioRevertModel = false;
  @Nullable
  private VideoCompositing customVideoCompositor;
  private PlayerLayer layer = null;
  private int maxCacheSize = 60;
  private PlayerThread playerThreadMain;
  private float rate = 1.0F;
  private IDecoderTrack realVDecoderTrack;
  private IDecoderTrack revertAudioDecoderTrack;
  private final PlayerItem.PlayerItemStatus status = PlayerItem.PlayerItemStatus.PlayerItemStatusUnknown;
  private final List<PlayerItemTrack> tracks = new ArrayList();
  private IDecoderTrack vDecoderTrack;
  @Nullable
  private VideoComposition videoComposition;
  private boolean videoRevertModel = false;
  
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
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    this.layer = paramPlayerLayer;
    if (this.playerThreadMain == null) {
      return;
    }
    IDecoderTrack localIDecoderTrack;
    if ((this.rate >= 0.0F) && (!this.videoRevertModel))
    {
      localIDecoderTrack = this.realVDecoderTrack;
    }
    else
    {
      localIDecoderTrack = this.realVDecoderTrack;
      boolean bool;
      if ((this.rate >= 0.0F) && (!this.videoRevertModel)) {
        bool = false;
      } else {
        bool = true;
      }
      this.vDecoderTrack = new CachedVideoDecoderTrack(localIDecoderTrack, bool);
      ((CachedVideoDecoderTrack)this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
      localIDecoderTrack = this.vDecoderTrack;
    }
    this.playerThreadMain.bindSurface(localIDecoderTrack, paramPlayerLayer);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  IDecoderTrack getAudioCompositionDecoderTrack()
  {
    if (this.audioRevertModel)
    {
      this.revertAudioDecoderTrack = new ReverseAudioDecoderTrack(this.audioCompositionDecoderTrack);
      return this.revertAudioDecoderTrack;
    }
    return this.audioCompositionDecoderTrack;
  }
  
  @Nullable
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  @Nullable
  VideoCompositing getCustomVideoCompositor()
  {
    return this.customVideoCompositor;
  }
  
  PlayerThread getPlayerThreadMain()
  {
    return this.playerThreadMain;
  }
  
  CGSize getPresentationSize()
  {
    return this.asset.getNaturalSize();
  }
  
  IDecoderTrack getRealDecoderTrack()
  {
    if ((this.rate >= 0.0F) && (!this.videoRevertModel)) {
      return this.realVDecoderTrack;
    }
    IDecoderTrack localIDecoderTrack = this.realVDecoderTrack;
    boolean bool;
    if ((this.rate >= 0.0F) && (!this.videoRevertModel)) {
      bool = false;
    } else {
      bool = true;
    }
    this.vDecoderTrack = new CachedVideoDecoderTrack(localIDecoderTrack, bool);
    ((CachedVideoDecoderTrack)this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
    return this.vDecoderTrack;
  }
  
  public PlayerItem.PlayerItemStatus getStatus()
  {
    return this.status;
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
  
  public void setAudioMix(@Nullable AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
    if (localAudioCompositionDecoderTrack != null) {
      localAudioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
  }
  
  public void setAudioRevertMode(boolean paramBoolean)
  {
    this.audioRevertModel = paramBoolean;
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
  
  public void setVideoComposition(@Nullable VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.customVideoCompositor = paramVideoComposition.getCustomVideoCompositor();
    }
  }
  
  public void setVideoRevertMode(boolean paramBoolean)
  {
    this.videoRevertModel = paramBoolean;
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
    if (this.audioRevertModel) {
      this.revertAudioDecoderTrack = new ReverseAudioDecoderTrack(this.audioCompositionDecoderTrack);
    }
    Object localObject;
    if (this.audioRevertModel) {
      localObject = this.revertAudioDecoderTrack;
    } else {
      localObject = this.audioCompositionDecoderTrack;
    }
    this.playerThreadMain = new PlayerThread(localIDecoderTrack, (IDecoderTrack)localObject, paramPlayer);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItem
 * JD-Core Version:    0.7.0.1
 */