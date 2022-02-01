package com.tencent.mobileqq.kandian.biz.publisher.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
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
    Object localObject;
    if ((paramInt == 0) && (paramTopicInfo != null))
    {
      localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject == null) {
        break label104;
      }
      localObject = ((JSONObject)localObject).optString("scene");
      if (localObject == null) {
        break label104;
      }
    }
    try
    {
      for (;;)
      {
        paramInt = new JSONObject((String)localObject).optInt("key_from");
        if ((paramInt == 1) && (RIJUgcUtils.i() == 2))
        {
          paramTopicInfo = RIJUgcUtils.a() + paramTopicInfo.getTopicId();
          ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, "", paramTopicInfo, null, false);
        }
        TopicSDK.a.a().b((Function2)this);
        return;
        label104:
        localObject = "";
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("KanDianPublisherImpl", 1, "openCreateTopicPage e: " + localJSONException);
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisherImpl.openCreateTopicPage.1
 * JD-Core Version:    0.7.0.1
 */