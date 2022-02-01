package com.tencent.tkd.topicsdk.framework.events;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/RichEditTextEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "()V", "action", "", "getAction", "()I", "setAction", "(I)V", "extra", "Lorg/json/JSONObject;", "getExtra", "()Lorg/json/JSONObject;", "setExtra", "(Lorg/json/JSONObject;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "objectType", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "getObjectType", "()Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "setObjectType", "(Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;)V", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextEvent
  extends BaseReportEvent
{
  public static final RichEditTextEvent.Companion a = new RichEditTextEvent.Companion(null);
  private int b = -1;
  @NotNull
  private String c = "";
  @NotNull
  private EditObject.EditObjectType d = EditObject.EditObjectType.TYPE_NORMAL;
  @Nullable
  private JSONObject e;
  
  public RichEditTextEvent()
  {
    a(ReportEventElement.WIDGET_RICH_EDIT_TEXT);
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@NotNull EditObject.EditObjectType paramEditObjectType)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "<set-?>");
    this.d = paramEditObjectType;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  @NotNull
  public final String e()
  {
    return this.c;
  }
  
  @NotNull
  public final EditObject.EditObjectType f()
  {
    return this.d;
  }
  
  @Nullable
  public final JSONObject g()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent
 * JD-Core Version:    0.7.0.1
 */