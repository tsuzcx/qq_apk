package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleUtils;", "", "()V", "showPublishErrorToast", "", "activity", "Landroid/app/Activity;", "errCode", "", "publishScene", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticleUtils
{
  public static final PublishArticleUtils a = new PublishArticleUtils();
  
  public final void a(@Nullable Activity paramActivity, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishScene");
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getResources();
      if (paramActivity != null)
      {
        switch (paramInt)
        {
        case 0: 
        default: 
          return;
        case 9: 
          paramActivity = paramActivity.getString(R.string.O);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pleas…lect_delivered_community)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 8: 
          paramActivity = paramActivity.getString(R.string.V);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pure_content_ask_for_video)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 7: 
          if ((Intrinsics.areEqual(paramString, "rijugc") ^ true))
          {
            paramActivity = paramActivity.getString(R.string.J);
            Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.no_content_with_video)");
            TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
            return;
          }
          paramActivity = paramActivity.getString(R.string.af);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.title_has_none_text)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 6: 
          paramActivity = paramActivity.getString(R.string.f);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.associate_topic_without_video)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 5: 
          paramActivity = paramActivity.getString(R.string.e);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.assoc…te_topic_without_content)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 4: 
          paramActivity = paramActivity.getString(R.string.M);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pleas…ciate_topic_or_community)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 3: 
          paramActivity = paramActivity.getString(R.string.N);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pleas…c_or_community_for_video)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 2: 
          if ((Intrinsics.areEqual(paramString, "rijugc") ^ true))
          {
            paramActivity = paramActivity.getString(R.string.w);
            Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.empty_content_publish_tips)");
            TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
            return;
          }
          paramActivity = paramActivity.getString(R.string.af);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.title_has_none_text)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        case 1: 
          paramActivity = paramActivity.getString(R.string.K);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.over_content_tips)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          return;
        }
        paramActivity = paramActivity.getString(R.string.I);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.net_failed)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticleUtils
 * JD-Core Version:    0.7.0.1
 */