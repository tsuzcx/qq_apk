package com.tencent.tavcut.composition.dataprocessor;

import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/dataprocessor/IDataChangeListener;", "", "onComponentUpdate", "", "entityId", "", "identifyComponent", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "onEntityChanged", "onInitSource", "onSourceUpdate", "onVoiceChangerUpdate", "config", "", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IDataChangeListener
{
  public abstract void a();
  
  public abstract void a(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent);
  
  public abstract void a(@Nullable List<? extends VoiceEnum> paramList);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.dataprocessor.IDataChangeListener
 * JD-Core Version:    0.7.0.1
 */