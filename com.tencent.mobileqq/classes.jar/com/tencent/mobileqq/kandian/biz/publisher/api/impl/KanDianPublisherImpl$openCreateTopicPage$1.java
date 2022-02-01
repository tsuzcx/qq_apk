package com.tencent.mobileqq.kandian.biz.publisher.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/api/impl/KanDianPublisherImpl$openCreateTopicPage$1", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "", "Lcom/tencent/tkd/topicsdk/managetopic/CreateTopicListener;", "invoke", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublisherImpl$openCreateTopicPage$1
  implements Function2<Integer, TopicInfo, Unit>
{
  KanDianPublisherImpl$openCreateTopicPage$1(JSONObject paramJSONObject, Context paramContext) {}
  
  public void a(int paramInt, @Nullable TopicInfo paramTopicInfo)
  {
    if ((paramInt == 0) && (paramTopicInfo != null))
    {
      Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("scene");
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      try
      {
        paramInt = new JSONObject((String)localObject).optInt("key_from");
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("openCreateTopicPage e: ");
        localStringBuilder2.append(localJSONException);
        QLog.e("KanDianPublisherImpl", 1, localStringBuilder2.toString());
        paramInt = 0;
      }
      if ((paramInt == 1) && (RIJUgcUtils.h() == 2))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(RIJUgcUtils.a());
        localStringBuilder1.append(paramTopicInfo.getTopicId());
        paramTopicInfo = localStringBuilder1.toString();
        ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, "", paramTopicInfo, null, false);
      }
    }
    TopicSDK.a.a().b((Function2)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisherImpl.openCreateTopicPage.1
 * JD-Core Version:    0.7.0.1
 */