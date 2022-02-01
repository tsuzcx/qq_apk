package com.tencent.thumbplayer.api.composition;

import java.util.List;

public abstract interface ITPMediaTrack
  extends ITPMediaAsset
{
  public abstract int addTrackClip(ITPMediaTrackClip paramITPMediaTrackClip);
  
  public abstract List<ITPMediaTrackClip> getAllTrackClips();
  
  public abstract long getTimelineDurationMs();
  
  public abstract ITPMediaTrackClip getTrackClip(int paramInt);
  
  public abstract int getTrackId();
  
  public abstract int insertTrackClip(ITPMediaTrackClip paramITPMediaTrackClip, int paramInt);
  
  public abstract void removeAllTrackClips();
  
  public abstract boolean removeTrackClip(ITPMediaTrackClip paramITPMediaTrackClip);
  
  public abstract boolean swapTrackClip(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.ITPMediaTrack
 * JD-Core Version:    0.7.0.1
 */