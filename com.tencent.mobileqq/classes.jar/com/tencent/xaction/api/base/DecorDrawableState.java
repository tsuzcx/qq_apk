package com.tencent.xaction.api.base;

import androidx.annotation.Keep;
import com.tencent.xaction.api.IDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawableState;", "", "()V", "fp", "", "getFp", "()Ljava/lang/String;", "setFp", "(Ljava/lang/String;)V", "g", "", "getG", "()I", "setG", "(I)V", "isAssets", "", "()Z", "setAssets", "(Z)V", "mirror", "getMirror", "setMirror", "path", "getPath", "setPath", "root", "getRoot", "setRoot", "type", "getType", "setType", "buildDrawable", "Lcom/tencent/xaction/api/IDrawable;", "clazz", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class DecorDrawableState
{
  @NotNull
  private String fp = "";
  private int g = -1;
  private boolean isAssets;
  private boolean mirror;
  @NotNull
  private String path = "";
  @Nullable
  private String root;
  @NotNull
  private String type = "";
  
  @NotNull
  public abstract IDrawable buildDrawable();
  
  @NotNull
  public IDrawable buildDrawable(@NotNull Class<? extends DecorDrawable> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    paramClass = (DecorDrawable)paramClass.newInstance();
    paramClass.setDecorState((DecorDrawableState)this);
    paramClass = paramClass.getDrawable();
    if (paramClass == null) {
      Intrinsics.throwNpe();
    }
    return paramClass;
  }
  
  @NotNull
  public final String getFp()
  {
    return this.fp;
  }
  
  public final int getG()
  {
    return this.g;
  }
  
  public final boolean getMirror()
  {
    return this.mirror;
  }
  
  @NotNull
  public final String getPath()
  {
    return this.path;
  }
  
  @Nullable
  public final String getRoot()
  {
    return this.root;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isAssets()
  {
    return this.isAssets;
  }
  
  public final void setAssets(boolean paramBoolean)
  {
    this.isAssets = paramBoolean;
  }
  
  public final void setFp(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fp = paramString;
  }
  
  public final void setG(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.mirror = paramBoolean;
  }
  
  public final void setPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.path = paramString;
  }
  
  public final void setRoot(@Nullable String paramString)
  {
    this.root = paramString;
  }
  
  public final void setType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawableState
 * JD-Core Version:    0.7.0.1
 */