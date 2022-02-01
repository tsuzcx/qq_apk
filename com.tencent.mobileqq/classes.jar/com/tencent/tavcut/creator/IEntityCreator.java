package com.tencent.tavcut.creator;

import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/IEntityCreator;", "", "createEntity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "name", "", "components", "", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IEntityCreator
{
  @NotNull
  public abstract Entity a(@NotNull String paramString, @NotNull List<IdentifyComponent> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.IEntityCreator
 * JD-Core Version:    0.7.0.1
 */