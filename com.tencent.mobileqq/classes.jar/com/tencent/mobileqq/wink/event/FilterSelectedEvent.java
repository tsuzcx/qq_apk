package com.tencent.mobileqq.wink.event;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/event/FilterSelectedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FilterSelectedEvent
  extends SimpleBaseEvent
{
  @Nullable
  private final MetaMaterial material;
  
  public FilterSelectedEvent(@Nullable MetaMaterial paramMetaMaterial)
  {
    this.material = paramMetaMaterial;
  }
  
  @Nullable
  public final MetaMaterial getMaterial()
  {
    return this.material;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.event.FilterSelectedEvent
 * JD-Core Version:    0.7.0.1
 */