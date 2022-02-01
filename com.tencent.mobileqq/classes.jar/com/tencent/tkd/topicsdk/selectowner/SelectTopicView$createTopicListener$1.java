package com.tencent.tkd.topicsdk.selectowner;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectTopicView$createTopicListener$1
  extends Lambda
  implements Function2<Integer, TopicInfo, Unit>
{
  SelectTopicView$createTopicListener$1(SelectTopicView paramSelectTopicView)
  {
    super(2);
  }
  
  public final void invoke(int paramInt, @Nullable TopicInfo paramTopicInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create Topic result, errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", topic=");
    localStringBuilder.append(paramTopicInfo);
    TLog.a("SelectTopicView", localStringBuilder.toString());
    if ((paramInt == 0) && (paramTopicInfo != null)) {
      this.this$0.a(paramTopicInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicView.createTopicListener.1
 * JD-Core Version:    0.7.0.1
 */