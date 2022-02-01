package com.tencent.tavcut.session;

import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/session/ISessionListener;", "", "onRenderDataApplied", "", "onRenderDataChanged", "newData", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface ISessionListener
{
  public abstract void a();
  
  public abstract void a(@NotNull RenderModel paramRenderModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.ISessionListener
 * JD-Core Version:    0.7.0.1
 */