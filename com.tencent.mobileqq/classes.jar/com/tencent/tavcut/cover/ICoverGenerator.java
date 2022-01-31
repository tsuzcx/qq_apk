package com.tencent.tavcut.cover;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;

public abstract interface ICoverGenerator
{
  public abstract void generateCoverByIndex(int paramInt, CMTime paramCMTime);
  
  public abstract void generateCoverByIndexRange(int paramInt1, int paramInt2);
  
  public abstract void generateCoverByTimeRange(long paramLong1, long paramLong2);
  
  public abstract void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void setCoverCache(CoverCache paramCoverCache);
  
  public abstract void setRenderContextParamas(RenderContextParams paramRenderContextParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.cover.ICoverGenerator
 * JD-Core Version:    0.7.0.1
 */