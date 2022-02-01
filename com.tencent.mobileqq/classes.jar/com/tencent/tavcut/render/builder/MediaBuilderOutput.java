package com.tencent.tavcut.render.builder;

import .r8.java8methods.utility.Long.hashCode.IJ;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "", "renderChainManager", "Lcom/tencent/tavcut/render/IRenderChainManager;", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "durationUs", "", "(Lcom/tencent/tavcut/render/IRenderChainManager;Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/tavkit/composition/TAVComposition;J)V", "getComposition", "()Lcom/tencent/tavkit/composition/TAVComposition;", "getDurationUs", "()J", "getRenderChainManager", "()Lcom/tencent/tavcut/render/IRenderChainManager;", "getRenderModel", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MediaBuilderOutput
{
  @NotNull
  private final IRenderChainManager a;
  @NotNull
  private final RenderModel b;
  @NotNull
  private final TAVComposition c;
  private final long d;
  
  public MediaBuilderOutput(@NotNull IRenderChainManager paramIRenderChainManager, @NotNull RenderModel paramRenderModel, @NotNull TAVComposition paramTAVComposition, long paramLong)
  {
    this.a = paramIRenderChainManager;
    this.b = paramRenderModel;
    this.c = paramTAVComposition;
    this.d = paramLong;
  }
  
  @NotNull
  public final IRenderChainManager a()
  {
    return this.a;
  }
  
  @NotNull
  public final RenderModel b()
  {
    return this.b;
  }
  
  @NotNull
  public final TAVComposition c()
  {
    return this.c;
  }
  
  public final long d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaBuilderOutput))
      {
        paramObject = (MediaBuilderOutput)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.d);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaBuilderOutput(renderChainManager=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", renderModel=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", composition=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", durationUs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.MediaBuilderOutput
 * JD-Core Version:    0.7.0.1
 */