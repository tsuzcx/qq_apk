package com.tencent.tkd.topicsdk.managetopic;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/EditTopicPage$Companion;", "", "()V", "open", "", "context", "Landroid/content/Context;", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EditTopicPage$Companion
{
  public final void a(@NotNull Context paramContext, @NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("topic_info", (Parcelable)paramTopicInfo);
    TopicSDKHelperKt.a(paramContext, EditTopicPage.class, localBundle, null, null, 24, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage.Companion
 * JD-Core Version:    0.7.0.1
 */