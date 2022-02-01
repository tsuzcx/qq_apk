package com.tencent.tkd.topicsdk.framework.events;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/RichEditTextEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "()V", "action", "", "getAction", "()I", "setAction", "(I)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "objectType", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "getObjectType", "()Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "setObjectType", "(Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;)V", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextEvent
  extends BaseReportEvent
{
  public static final RichEditTextEvent.Companion a;
  private int jdField_a_of_type_Int = -1;
  @NotNull
  private EditObject.EditObjectType jdField_a_of_type_ComTencentTkdWeiboBeanEditObject$EditObjectType = EditObject.EditObjectType.TYPE_NORMAL;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventsRichEditTextEvent$Companion = new RichEditTextEvent.Companion(null);
  }
  
  public RichEditTextEvent()
  {
    a(ReportEventElement.WIDGET_RICH_EDIT_TEXT);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final EditObject.EditObjectType a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboBeanEditObject$EditObjectType;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull EditObject.EditObjectType paramEditObjectType)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdWeiboBeanEditObject$EditObjectType = paramEditObjectType;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent
 * JD-Core Version:    0.7.0.1
 */