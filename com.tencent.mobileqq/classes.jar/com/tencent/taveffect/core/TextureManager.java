package com.tencent.taveffect.core;

import com.tencent.taveffect.effects.LookupFilter;

public class TextureManager
{
  private static final String TAG = "TextureManager";
  private volatile TAVFilterGroup customVideoFilterGroup;
  private TAVFilterGroup defaultVideoFilterGroup = new TAVFilterGroup(true);
  private volatile TAVBaseFilter lookupFilter;
  private TAVFilterGroup releaseFilterGroup;
  private volatile boolean released;
  private TAVStickerRenderFilter stickerRenderFilter = new TAVStickerRenderFilter();
  private VideoFrameListener videoFrameListener = new TextureManager.1(this);
  
  public void applyFilter(TAVBaseFilter paramTAVBaseFilter)
  {
    if (paramTAVBaseFilter != null)
    {
      if ((!(paramTAVBaseFilter instanceof TAVFilterGroup)) || (!((TAVFilterGroup)paramTAVBaseFilter).hasRender())) {
        break label91;
      }
      if (this.customVideoFilterGroup == null) {}
    }
    try
    {
      if (this.releaseFilterGroup != null)
      {
        this.releaseFilterGroup.release();
        this.releaseFilterGroup = null;
      }
      this.releaseFilterGroup = this.customVideoFilterGroup;
      this.customVideoFilterGroup = ((TAVFilterGroup)paramTAVBaseFilter);
      if (this.lookupFilter != null) {
        this.customVideoFilterGroup.add(this.lookupFilter);
      }
      return;
    }
    finally {}
    label91:
    this.defaultVideoFilterGroup.add(paramTAVBaseFilter);
  }
  
  public VideoFrameListener getVideoFrameListener()
  {
    return this.videoFrameListener;
  }
  
  public void release()
  {
    this.released = true;
    if (this.lookupFilter != null) {
      this.lookupFilter.release();
    }
    if (this.defaultVideoFilterGroup != null) {
      this.defaultVideoFilterGroup.release();
    }
    if (this.customVideoFilterGroup != null) {
      this.customVideoFilterGroup.release();
    }
    if (this.stickerRenderFilter != null) {
      this.stickerRenderFilter.release();
    }
  }
  
  public void setLookupFilter(TAVBaseFilter paramTAVBaseFilter)
  {
    if (this.lookupFilter != null) {
      this.lookupFilter.release();
    }
    this.lookupFilter = paramTAVBaseFilter;
    if (this.customVideoFilterGroup == null) {
      this.customVideoFilterGroup = new TAVFilterGroup(true);
    }
    this.customVideoFilterGroup.remove(LookupFilter.class);
    if (paramTAVBaseFilter != null) {
      this.customVideoFilterGroup.add(paramTAVBaseFilter);
    }
  }
  
  public void setVideoFrameListener(VideoFrameListener paramVideoFrameListener)
  {
    this.videoFrameListener = paramVideoFrameListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TextureManager
 * JD-Core Version:    0.7.0.1
 */