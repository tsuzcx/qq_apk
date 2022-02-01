package com.tencent.xaction.apng;

import androidx.annotation.Keep;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/GiftDiyDecorDrawable$GiftDiyDecorDrawableState;", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "()V", "coords", "", "getCoords", "()Ljava/lang/String;", "setCoords", "(Ljava/lang/String;)V", "fadein", "", "getFadein", "()I", "setFadein", "(I)V", "h", "getH", "setH", "interval", "getInterval", "setInterval", "last", "getLast", "setLast", "max", "getMax", "setMax", "w", "getW", "setW", "buildDrawable", "Lcom/tencent/xaction/api/IDrawable;", "XAApng_release"}, k=1, mv={1, 1, 16})
@Keep
public final class GiftDiyDecorDrawable$GiftDiyDecorDrawableState
  extends DecorDrawableState
{
  @NotNull
  private String coords = "";
  private int fadein;
  private int h;
  private int interval;
  private int last;
  private int max;
  private int w;
  
  @NotNull
  public IDrawable buildDrawable()
  {
    return buildDrawable(GiftDiyDecorDrawable.class);
  }
  
  @NotNull
  public final String getCoords()
  {
    return this.coords;
  }
  
  public final int getFadein()
  {
    return this.fadein;
  }
  
  public final int getH()
  {
    return this.h;
  }
  
  public final int getInterval()
  {
    return this.interval;
  }
  
  public final int getLast()
  {
    return this.last;
  }
  
  public final int getMax()
  {
    return this.max;
  }
  
  public final int getW()
  {
    return this.w;
  }
  
  public final void setCoords(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coords = paramString;
  }
  
  public final void setFadein(int paramInt)
  {
    this.fadein = paramInt;
  }
  
  public final void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public final void setLast(int paramInt)
  {
    this.last = paramInt;
  }
  
  public final void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public final void setW(int paramInt)
  {
    this.w = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.GiftDiyDecorDrawable.GiftDiyDecorDrawableState
 * JD-Core Version:    0.7.0.1
 */