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
final class ManageTopicPresenter$createTopic$1
  extends Lambda
  implements Function4<Integer, String, String, Long, Unit>
{
  ManageTopicPresenter$createTopic$1(ManageTopicPresenter paramManageTopicPresenter, TopicInfo paramTopicInfo)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "tip");
    TLog.a("ManageTopicPresenter", "createTopic response errorCode = " + paramInt + ", " + "errorMsg = " + paramString1 + ", tip = " + paramString2 + ", topicId = " + paramLong);
    if (ManageTopicPresenter.a(this.this$0) == null) {
      TLog.d("ManageTopicPresenter", "createTopic view is null!");
    }
    paramString2 = ManageTopicPresenter.a(this.this$0);
    if (paramString2 != null) {
      paramString2.k();
    }
    if (paramInt == 0)
    {
      this.$topicInfo.setTopicId(paramLong);
      paramString1 = ManageTopicPresenter.a(this.this$0);
      if (paramString1 != null) {
        paramString1.a(this.$topicInfo, true);
      }
      paramString1 = ManageTopicPresenter.a(this.this$0);
      if (paramString1 != null) {
        paramString1.a(R.string.s);
      }
      ManageTopicPresenter.a(this.this$0).a();
    }
    label240:
    do
    {
      return;
      paramString2 = ManageTopicPresenter.a(this.this$0);
      if (paramString2 != null) {
        paramString2.a(this.$topicInfo, false);
      }
      if (((CharSequence)paramString1).length() > 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label240;
        }
        paramString2 = ManageTopicPresenter.a(this.this$0);
        if (paramString2 == null) {
          break;
        }
        paramString2.a(paramString1);
        return;
      }
      paramString1 = ManageTopicPresenter.a(this.this$0);
    } while (paramString1 == null);
    paramString1.a(R.string.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicPresenter.createTopic.1
 * JD-Core Version:    0.7.0.1
 */