package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/TimeProp;", "", "()V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "fps", "getFps", "setFps", "rc", "getRc", "setRc", "rm", "getRm", "setRm", "single", "getSingle", "setSingle", "set", "", "prop", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class TimeProp
{
  private boolean autoPlay = true;
  private long delay;
  private int duration;
  private int fps = 60;
  private int rc;
  private int rm = 1;
  private boolean single;
  
  public final boolean getAutoPlay()
  {
    return this.autoPlay;
  }
  
  public final long getDelay()
  {
    return this.delay;
  }
  
  public final int getDuration()
  {
    return this.duration;
  }
  
  public final int getFps()
  {
    return this.fps;
  }
  
  public final int getRc()
  {
    return this.rc;
  }
  
  public final int getRm()
  {
    return this.rm;
  }
  
  public final boolean getSingle()
  {
    return this.single;
  }
  
  public final void set(@NotNull TimeProp paramTimeProp)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeProp, "prop");
    this.duration = paramTimeProp.duration;
    this.rc = paramTimeProp.rc;
    this.rm = paramTimeProp.rm;
    this.delay = paramTimeProp.delay;
    this.fps = paramTimeProp.fps;
    this.autoPlay = paramTimeProp.autoPlay;
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    this.autoPlay = paramBoolean;
  }
  
  public final void setDelay(long paramLong)
  {
    this.delay = paramLong;
  }
  
  public final void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public final void setFps(int paramInt)
  {
    this.fps = paramInt;
  }
  
  public final void setRc(int paramInt)
  {
    this.rc = paramInt;
  }
  
  public final void setRm(int paramInt)
  {
    this.rm = paramInt;
  }
  
  public final void setSingle(boolean paramBoolean)
  {
    this.single = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.data.TimeProp
 * JD-Core Version:    0.7.0.1
 */