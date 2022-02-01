package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.mobileqq.cmshow.engine.script.Script;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "", "getResourceManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "getResourcePath", "", "type", "", "id", "getResourceUrl", "getScriptById", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "businessId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IResourceService
{
  @NotNull
  public abstract IApolloResManager a();
  
  @NotNull
  public abstract Script a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.IResourceService
 * JD-Core Version:    0.7.0.1
 */