package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "tip", "topicId", "", "invoke"}, k=3, mv={1, 1, 16})
final class ManageTopicPresenter$editTopic$1
  extends Lambda
  implements Function4<Integer, String, String, Long, Unit>
{
  ManageTopicPresenter$editTopic$1(ManageTopicPresenter paramManageTopicPresenter, TopicInfo paramTopicInfo)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "tip");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("editTopic response errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append("errorMsg = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", tip = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", topicId = ");
    localStringBuilder.append(paramLong);
    TLog.a("ManageTopicPresenter", localStringBuilder.toString());
    if (ManageTopicPresenter.a(this.this$0) == null) {
      TLog.d("ManageTopicPresenter", "editTopic view is null!");
    }
    paramString2 = ManageTopicPresenter.a(this.this$0);
    if (paramString2 != null) {
      paramString2.k();
    }
    int i = 1;
    if (paramInt == 0)
    {
      this.$topicInfo.setTopicId(paramLong);
      paramString1 = ManageTopicPresenter.a(this.this$0);
      if (paramString1 != null) {
        paramString1.b(this.$topicInfo, true);
      }
      paramString1 = ManageTopicPresenter.a(this.this$0);
      if (paramString1 != null) {
        paramString1.a(R.string.v);
      }
      ManageTopicPresenter.a(this.this$0).a();
      return;
    }
    paramString2 = ManageTopicPresenter.a(this.this$0);
    if (paramString2 != null) {
      paramString2.b(this.$topicInfo, false);
    }
    if (((CharSequence)paramString1).length() > 0) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramString2 = ManageTopicPresenter.a(this.this$0);
      if (paramString2 != null) {
        paramString2.a(paramString1);
      }
    }
    else
    {
      paramString1 = ManageTopicPresenter.a(this.this$0);
      if (paramString1 != null) {
        paramString1.a(R.string.u);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicPresenter.editTopic.1
 * JD-Core Version:    0.7.0.1
 */