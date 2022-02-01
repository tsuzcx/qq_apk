package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import java.io.Serializable;
import java.util.List;

public abstract class TAVMovieSegment
  implements Serializable
{
  private static final String TAG = "TAVMovieSegment";
  protected int layerIndex = -1;
  protected boolean mEditable;
  protected List<TAVSegmentImageEffect> mImageEffects;
  protected List<TAVMovieTimeEffect> mTimeEffects;
  protected CMTimeRange mTimeRange;
  protected List<TAVStickerLayerInfo.TAVStickerUserData> mUserDatas;
  protected List<TAVClip> tavClips;
  protected List<TAVMovieClip> tavMovieClips;
  
  public abstract List<TAVClip> getFullTavClips();
  
  public List<TAVSegmentImageEffect> getImageEffects()
  {
    return this.mImageEffects;
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public abstract CMTime getMinOriginDuration();
  
  public abstract CMTime getPlayDuration();
  
  public abstract CMTime getSourceDuration();
  
  public abstract List<TAVClip> getTavClips();
  
  public List<TAVMovieClip> getTavMovieClips()
  {
    return this.tavMovieClips;
  }
  
  public List<TAVMovieTimeEffect> getTimeEffects()
  {
    return this.mTimeEffects;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public abstract List<TAVClip> getUseTavClips();
  
  public List<TAVStickerLayerInfo.TAVStickerUserData> getUserDatas()
  {
    return this.mUserDatas;
  }
  
  public boolean isEditable()
  {
    return this.mEditable;
  }
  
  public abstract List<TAVMovieTimeEffect> separateSegmentByTimeEffects();
  
  public void setEditable(boolean paramBoolean)
  {
    this.mEditable = paramBoolean;
  }
  
  public void setImageEffects(List<TAVSegmentImageEffect> paramList)
  {
    this.mImageEffects = paramList;
  }
  
  public void setLayerIndex(int paramInt)
  {
    this.layerIndex = paramInt;
  }
  
  public void setTavClips(List<TAVClip> paramList)
  {
    this.tavClips = paramList;
  }
  
  public void setTavMovieClips(List<TAVMovieClip> paramList)
  {
    this.tavMovieClips = paramList;
  }
  
  public void setTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    this.mTimeEffects = paramList;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mTimeRange = paramCMTimeRange;
  }
  
  public void setUserDatas(List<TAVStickerLayerInfo.TAVStickerUserData> paramList)
  {
    this.mUserDatas = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVMovieSegment
 * JD-Core Version:    0.7.0.1
 */