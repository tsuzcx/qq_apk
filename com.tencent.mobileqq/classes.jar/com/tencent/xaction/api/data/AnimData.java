package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/AnimData;", "", "()V", "eles", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/data/ViewData;", "Lkotlin/collections/ArrayList;", "getEles", "()Ljava/util/ArrayList;", "setEles", "(Ljava/util/ArrayList;)V", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "versionCode", "", "getVersionCode", "()I", "setVersionCode", "(I)V", "versionMax", "getVersionMax", "setVersionMax", "versionMin", "getVersionMin", "setVersionMin", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class AnimData
{
  @Nullable
  private ArrayList<ViewData> eles;
  @NotNull
  private String version = "1.0";
  private int versionCode = 1;
  private int versionMax = 2147483647;
  private int versionMin = 1;
  
  @Nullable
  public final ArrayList<ViewData> getEles()
  {
    return this.eles;
  }
  
  @NotNull
  public final String getVersion()
  {
    return this.version;
  }
  
  public final int getVersionCode()
  {
    return this.versionCode;
  }
  
  public final int getVersionMax()
  {
    return this.versionMax;
  }
  
  public final int getVersionMin()
  {
    return this.versionMin;
  }
  
  public final void setEles(@Nullable ArrayList<ViewData> paramArrayList)
  {
    this.eles = paramArrayList;
  }
  
  public final void setVersion(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.version = paramString;
  }
  
  public final void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public final void setVersionMax(int paramInt)
  {
    this.versionMax = paramInt;
  }
  
  public final void setVersionMin(int paramInt)
  {
    this.versionMin = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.AnimData
 * JD-Core Version:    0.7.0.1
 */