package com.tencent.tavcut.creator;

import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/EntityCreator;", "Lcom/tencent/tavcut/creator/IEntityCreator;", "()V", "createEntity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "name", "", "components", "", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class EntityCreator
  implements IEntityCreator
{
  public static final EntityCreator a = new EntityCreator();
  
  @NotNull
  public Entity a(@NotNull String paramString, @NotNull List<IdentifyComponent> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramList, "components");
    return new Entity(0, paramString, null, paramList, false, 0, 53, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.EntityCreator
 * JD-Core Version:    0.7.0.1
 */