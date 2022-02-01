package com.tencent.tavcut.rendermodel.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/entity/EntityId;", "", "id", "", "name", "", "enabled", "", "(ILjava/lang/String;Z)V", "getEnabled", "()Z", "getId", "()I", "getName", "()Ljava/lang/String;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class EntityId
{
  private final boolean enabled;
  private final int id;
  @NotNull
  private final String name;
  
  public EntityId(int paramInt, @NotNull String paramString, boolean paramBoolean)
  {
    this.id = paramInt;
    this.name = paramString;
    this.enabled = paramBoolean;
  }
  
  public final boolean getEnabled()
  {
    return this.enabled;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.entity.EntityId
 * JD-Core Version:    0.7.0.1
 */