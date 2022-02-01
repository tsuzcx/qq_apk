package com.tencent.mobileqq.wink.editor.template;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateMusicAction;", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/composition/model/component/InputSource;)V", "getEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getInputSource", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorTemplateViewModel$UpdateTemplateMusicAction
{
  @NotNull
  private final Entity a;
  @Nullable
  private final InputSource b;
  
  public WinkEditorTemplateViewModel$UpdateTemplateMusicAction(@NotNull Entity paramEntity, @Nullable InputSource paramInputSource)
  {
    this.a = paramEntity;
    this.b = paramInputSource;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  @Nullable
  public final InputSource b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpdateTemplateMusicAction))
      {
        paramObject = (UpdateTemplateMusicAction)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateTemplateMusicAction(entity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", inputSource=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateMusicAction
 * JD-Core Version:    0.7.0.1
 */