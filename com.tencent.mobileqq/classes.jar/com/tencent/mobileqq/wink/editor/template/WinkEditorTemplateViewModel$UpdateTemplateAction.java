package com.tencent.mobileqq.wink.editor.template;

import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.videocut.model.MediaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateAction;", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "templateMediaModel", "needUpdateVideo", "", "modifyClipsDuration", "templatePath", "", "(Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/videocut/model/MediaModel;Lcom/tencent/videocut/model/MediaModel;ZZLjava/lang/String;)V", "getMediaModel", "()Lcom/tencent/videocut/model/MediaModel;", "getModifyClipsDuration", "()Z", "getNeedUpdateVideo", "getRenderModel", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "getTemplateMediaModel", "getTemplatePath", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorTemplateViewModel$UpdateTemplateAction
{
  @NotNull
  private final RenderModel a;
  @Nullable
  private final MediaModel b;
  @NotNull
  private final MediaModel c;
  private final boolean d;
  private final boolean e;
  @Nullable
  private final String f;
  
  public WinkEditorTemplateViewModel$UpdateTemplateAction(@NotNull RenderModel paramRenderModel, @Nullable MediaModel paramMediaModel1, @NotNull MediaModel paramMediaModel2, boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString)
  {
    this.a = paramRenderModel;
    this.b = paramMediaModel1;
    this.c = paramMediaModel2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramString;
  }
  
  @NotNull
  public final RenderModel a()
  {
    return this.a;
  }
  
  @Nullable
  public final MediaModel b()
  {
    return this.b;
  }
  
  @NotNull
  public final MediaModel c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpdateTemplateAction))
      {
        paramObject = (UpdateTemplateAction)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final String f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateTemplateAction(renderModel=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mediaModel=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", templateMediaModel=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", needUpdateVideo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", modifyClipsDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", templatePath=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateAction
 * JD-Core Version:    0.7.0.1
 */