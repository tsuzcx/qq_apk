package com.tencent.tavcut.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/RenderConfig;", "", "()V", "renderAssetDir", "", "getRenderAssetDir", "()Ljava/lang/String;", "setRenderAssetDir", "(Ljava/lang/String;)V", "renderType", "", "getRenderType", "()I", "setRenderType", "(I)V", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class RenderConfig
{
  public static final RenderConfig a = new RenderConfig();
  @NotNull
  private static String b = "";
  private static int c;
  
  @NotNull
  public final String a()
  {
    return b;
  }
  
  public final void a(int paramInt)
  {
    c = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    b = paramString;
  }
  
  public final int b()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.RenderConfig
 * JD-Core Version:    0.7.0.1
 */