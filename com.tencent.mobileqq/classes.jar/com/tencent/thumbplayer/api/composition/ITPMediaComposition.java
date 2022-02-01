package com.tencent.thumbplayer.api.composition;

import java.util.List;

public abstract interface ITPMediaComposition
  extends ITPMediaAsset
{
  public abstract ITPMediaTrack addAVTrack();
  
  public abstract ITPMediaTrack addAudioTrack();
  
  public abstract ITPMediaTrack addVideoTrack();
  
  public abstract List<ITPMediaTrack> getAllAVTracks();
  
  public abstract List<ITPMediaTrack> getAllAudioTracks();
  
  public abstract List<ITPMediaTrack> getAllVideoTracks();
  
  public abstract long getDurationMs();
  
  public abstract void release();
  
  public abstract boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack);
  
  public abstract boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack);
  
  public abstract boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.ITPMediaComposition
 * JD-Core Version:    0.7.0.1
 */