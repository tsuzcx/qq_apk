package com.tencent.tavcut.rendermodel.entity;

import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/entity/Entity;", "", "id", "", "name", "", "children", "", "components", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "enable", "", "version", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;ZI)V", "getChildren", "()Ljava/util/List;", "getComponents", "getEnable", "()Z", "getId", "()I", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Entity
{
  @NotNull
  private final List<Entity> children;
  @NotNull
  private final List<IdentifyComponent> components;
  private final boolean enable;
  private final int id;
  @NotNull
  private final String name;
  private final int version;
  
  public Entity()
  {
    this(0, null, null, null, false, 0, 63, null);
  }
  
  public Entity(int paramInt1, @NotNull String paramString, @NotNull List<Entity> paramList, @NotNull List<IdentifyComponent> paramList1, boolean paramBoolean, int paramInt2)
  {
    this.id = paramInt1;
    this.name = paramString;
    this.children = paramList;
    this.components = paramList1;
    this.enable = paramBoolean;
    this.version = paramInt2;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  @NotNull
  public final String component2()
  {
    return this.name;
  }
  
  @NotNull
  public final List<Entity> component3()
  {
    return this.children;
  }
  
  @NotNull
  public final List<IdentifyComponent> component4()
  {
    return this.components;
  }
  
  public final boolean component5()
  {
    return this.enable;
  }
  
  public final int component6()
  {
    return this.version;
  }
  
  @NotNull
  public final Entity copy(int paramInt1, @NotNull String paramString, @NotNull List<Entity> paramList, @NotNull List<IdentifyComponent> paramList1, boolean paramBoolean, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramList, "children");
    Intrinsics.checkParameterIsNotNull(paramList1, "components");
    return new Entity(paramInt1, paramString, paramList, paramList1, paramBoolean, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Entity))
      {
        paramObject = (Entity)paramObject;
        if ((this.id == paramObject.id) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.children, paramObject.children)) && (Intrinsics.areEqual(this.components, paramObject.components)) && (this.enable == paramObject.enable) && (this.version == paramObject.version)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final List<Entity> getChildren()
  {
    return this.children;
  }
  
  @NotNull
  public final List<IdentifyComponent> getComponents()
  {
    return this.components;
  }
  
  public final boolean getEnable()
  {
    return this.enable;
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
  
  public final int getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entity(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", children=");
    localStringBuilder.append(this.children);
    localStringBuilder.append(", components=");
    localStringBuilder.append(this.components);
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.entity.Entity
 * JD-Core Version:    0.7.0.1
 */