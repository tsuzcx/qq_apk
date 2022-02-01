package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/event/ReceiveSchemaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "attrs", "", "", "(Ljava/util/Map;)V", "getAttrs", "()Ljava/util/Map;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiveSchemaEvent
  extends SimpleBaseEvent
{
  @NotNull
  private final Map<String, String> attrs;
  
  public ReceiveSchemaEvent(@NotNull Map<String, String> paramMap)
  {
    this.attrs = paramMap;
  }
  
  @NotNull
  public final Map<String, String> getAttrs()
  {
    return this.attrs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.event.ReceiveSchemaEvent
 * JD-Core Version:    0.7.0.1
 */