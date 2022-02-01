package com.tencent.tkd.topicsdk.framework.events;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/RichEditTextEvent$Companion;", "", "()V", "ACTION_ADD_OBJECT", "", "ACTION_DELETE_OBJECT", "ACTION_INVALID", "FROM_MAIN_PAGE", "FROM_OUTER_PAGE", "FROM_POPUP", "FROM_RECENT_LAYOUT", "getExtra", "Lorg/json/JSONObject;", "from", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextEvent$Companion
{
  @NotNull
  public final JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("from", paramInt);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent.Companion
 * JD-Core Version:    0.7.0.1
 */