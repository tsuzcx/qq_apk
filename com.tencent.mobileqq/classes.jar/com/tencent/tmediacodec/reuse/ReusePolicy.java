package com.tencent.tmediacodec.reuse;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/reuse/ReusePolicy;", "", "initWidth", "", "initHeight", "(II)V", "getInitHeight", "()I", "setInitHeight", "(I)V", "getInitWidth", "setInitWidth", "reConfigByRealFormat", "", "getReConfigByRealFormat", "()Z", "setReConfigByRealFormat", "(Z)V", "toString", "", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class ReusePolicy
{
  public static final ReusePolicy.Companion Companion = new ReusePolicy.Companion(null);
  @NotNull
  private static final ReusePolicy DEFAULT = new ReusePolicy(1920, 1920);
  public static final int DEFAULT_INIT_HEIGHT = 1920;
  public static final int DEFAULT_INIT_WIDTH = 1920;
  private int initHeight;
  private int initWidth;
  private boolean reConfigByRealFormat;
  
  public ReusePolicy(int paramInt1, int paramInt2)
  {
    this.initWidth = paramInt1;
    this.initHeight = paramInt2;
    this.reConfigByRealFormat = true;
  }
  
  public final int getInitHeight()
  {
    return this.initHeight;
  }
  
  public final int getInitWidth()
  {
    return this.initWidth;
  }
  
  public final boolean getReConfigByRealFormat()
  {
    return this.reConfigByRealFormat;
  }
  
  public final void setInitHeight(int paramInt)
  {
    this.initHeight = paramInt;
  }
  
  public final void setInitWidth(int paramInt)
  {
    this.initWidth = paramInt;
  }
  
  public final void setReConfigByRealFormat(boolean paramBoolean)
  {
    this.reConfigByRealFormat = paramBoolean;
  }
  
  @NotNull
  public String toString()
  {
    return "[initWidth:" + this.initWidth + ", initHeight:" + this.initHeight + ", " + "reConfigByRealFormat:" + this.reConfigByRealFormat + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReusePolicy
 * JD-Core Version:    0.7.0.1
 */