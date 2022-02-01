package com.tencent.mobileqq.kandian.biz.publisher.report;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ManageTopicConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/UserActionReportListener;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/events/UserActionEvent;", "()V", "hasAtInfo", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "hasTopicInfo", "onEvent", "", "event", "setJSONInfo", "eventMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "publishTCode", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionReportListener
  implements IEventObserver<UserActionEvent>
{
  public static final UserActionReportListener.Companion a = new UserActionReportListener.Companion(null);
  
  private final void a(HashMap<String, Object> paramHashMap, UserActionEvent paramUserActionEvent, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    int n = 0;
    int m = 0;
    int k = 0;
    Object localObject1 = (Map)paramHashMap;
    Object localObject5 = TopicSDK.a.a().a().a().a();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "TopicSDK.instance().topicSDKConfig.account.userId");
    ((Map)localObject1).put("uin", localObject5);
    int i1 = -1;
    localObject1 = paramUserActionEvent.a();
    int j = i1;
    if (localObject1 != null)
    {
      localObject1 = ((PublishArticleInfo)localObject1).getScene();
      j = i1;
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() <= 0) {
          break label388;
        }
        i = 1;
        label109:
        j = i1;
        if (i != 1) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject5 = PublisherReportUtils.a;
        localObject1 = paramUserActionEvent.a();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((PublishArticleInfo)localObject1).getScene();
        j = ((PublisherReportUtils)localObject5).a(new JSONObject((String)localObject1).optInt("key_from", 0));
      }
      catch (Exception localException)
      {
        label388:
        QLog.e("UserActionReportListener", 1, localException.toString());
        j = i1;
        continue;
        if (!paramString.equals("0X800AD2D")) {
          continue;
        }
      }
      ((Map)paramHashMap).put("from", Integer.valueOf(j));
      localObject5 = new JSONObject();
      switch (paramString.hashCode())
      {
      default: 
        ((JSONObject)localObject5).put("publisher_type", 1);
        ((Map)paramHashMap).put("jsonInfo", localObject5);
        return;
        i = 0;
        break label109;
        localObject1 = null;
      }
    }
    label429:
    paramString = paramUserActionEvent.a();
    label456:
    Object localObject2;
    label491:
    boolean bool;
    if (paramString != null)
    {
      paramString = paramString.getTopicInfo();
      if (paramString != null)
      {
        paramString = paramString.getCoverUrl();
        if (paramString != null)
        {
          localObject2 = paramUserActionEvent.a();
          if (localObject2 == null) {
            break label1668;
          }
          localObject2 = ((GlobalPublisherConfig)localObject2).getTopicInfo();
          if (localObject2 == null) {
            break label1668;
          }
          localObject2 = ((TopicInfo)localObject2).getTitle();
          if (localObject2 == null) {
            break label1668;
          }
          localObject3 = paramUserActionEvent.a();
          if (localObject3 == null) {
            break label1676;
          }
          localObject3 = ((GlobalPublisherConfig)localObject3).getTopicInfo();
          if (localObject3 == null) {
            break label1676;
          }
          localObject3 = ((TopicInfo)localObject3).getIntro();
          if (localObject3 == null) {
            break label1676;
          }
          label526:
          localObject4 = paramUserActionEvent.a();
          if (localObject4 == null) {
            break label1684;
          }
          localObject4 = ((GlobalPublisherConfig)localObject4).getTopicInfo();
          if (localObject4 == null) {
            break label1684;
          }
          bool = ((TopicInfo)localObject4).getAllowSubmit();
          label556:
          localObject4 = paramUserActionEvent.a();
          if (localObject4 == null) {
            break label1690;
          }
          localObject4 = ((GlobalPublisherConfig)localObject4).getTopicConfig();
          if ((localObject4 == null) || (((ManageTopicConfig)localObject4).getVideoPermissionFlag() != true)) {
            break label1690;
          }
          i = 0;
          label591:
          ((JSONObject)localObject5).put("ugc_video_flag", i);
          paramUserActionEvent = paramUserActionEvent.a();
          if (paramUserActionEvent == null) {
            break label1696;
          }
          paramUserActionEvent = paramUserActionEvent.getTopicConfig();
          if ((paramUserActionEvent == null) || (paramUserActionEvent.getTopicPermissionFlag() != true)) {
            break label1696;
          }
          i = 0;
          label630:
          ((JSONObject)localObject5).put("ugc_column_flag", i);
          if (((CharSequence)paramString).length() != 0) {
            break label1702;
          }
          i = 1;
          label655:
          if (i == 0) {
            break label1708;
          }
          i = 0;
          label663:
          ((JSONObject)localObject5).put("cover_flag", i);
          if (((CharSequence)localObject2).length() != 0) {
            break label1714;
          }
          i = 1;
          label689:
          if (i == 0) {
            break label1720;
          }
          i = 0;
          label697:
          ((JSONObject)localObject5).put("column_name_flag", i);
          if (((CharSequence)localObject3).length() != 0) {
            break label1726;
          }
          i = 1;
          label723:
          if (i == 0) {
            break label1732;
          }
        }
      }
    }
    label816:
    label944:
    label951:
    label1596:
    label1602:
    label1732:
    for (int i = 0;; i = 1)
    {
      ((JSONObject)localObject5).put("introduction_flag", i);
      i = k;
      if (bool) {
        i = 1;
      }
      ((JSONObject)localObject5).put("collaborator_flag", i);
      break;
      if (!paramString.equals("0X800AD2E")) {
        break;
      }
      break label429;
      if (!paramString.equals("0X800AC5C")) {
        break;
      }
      paramString = paramUserActionEvent.a();
      if (paramString != null)
      {
        paramString = paramString.getTopicConfig();
        if ((paramString != null) && (paramString.getVideoPermissionFlag() == true))
        {
          i = 0;
          ((JSONObject)localObject5).put("ugc_video_flag", i);
          paramUserActionEvent = paramUserActionEvent.a();
          if (paramUserActionEvent == null) {
            break label1655;
          }
          paramUserActionEvent = paramUserActionEvent.getTopicConfig();
          if ((paramUserActionEvent == null) || (paramUserActionEvent.getTopicPermissionFlag() != true)) {
            break label1655;
          }
        }
      }
      label989:
      label1013:
      label1655:
      for (i = n;; i = 1)
      {
        ((JSONObject)localObject5).put("ugc_column_flag", i);
        break;
        if ((!paramString.equals("0X800B4CA")) || (goto 364) || (!paramString.equals("0X800AC5E"))) {
          break;
        }
        for (;;)
        {
          ((JSONObject)localObject5).put("user_type", 0);
          paramString = paramUserActionEvent.a();
          if (paramString == null) {
            break label1547;
          }
          paramString = paramString.getVideoInfo();
          if (paramString != null) {
            break label1552;
          }
          i = 0;
          ((JSONObject)localObject5).put("video_flag", i);
          paramString = paramUserActionEvent.a();
          if (paramString == null) {
            break label1558;
          }
          paramString = paramString.getImageList();
          if (paramString != null) {
            break label1563;
          }
          i = 0;
          ((JSONObject)localObject5).put("cover_flag", i);
          ((JSONObject)localObject5).put("cover_type", 0);
          paramString = paramUserActionEvent.a();
          if ((paramString == null) || (paramString.getContentLength() != 0)) {
            break label1569;
          }
          i = 0;
          ((JSONObject)localObject5).put("video_name_flag", i);
          paramString = paramUserActionEvent.a();
          if (paramString == null) {
            break label1575;
          }
          paramString = paramString.getOriginContentInfo();
          if (paramString != null) {
            break label1580;
          }
          i = 0;
          label1020:
          ((JSONObject)localObject5).put("column_flag", i);
          paramString = paramUserActionEvent.a();
          if (paramString == null) {
            break label1586;
          }
          paramString = Boolean.valueOf(paramString.getAllowReprint());
          ((JSONObject)localObject5).put("reprint_flag", paramString);
          paramString = paramUserActionEvent.a();
          if (paramString == null) {
            break label1591;
          }
          paramString = paramString.getOriginContentInfo();
          if (paramString != null) {
            break label1596;
          }
          i = 0;
          ((JSONObject)localObject5).put("secret_flag", i);
          paramString = paramUserActionEvent.a();
          if ((paramString == null) || (paramString.getTopicId() != 0L)) {
            break label1602;
          }
          i = 0;
          ((JSONObject)localObject5).put("with_column", i);
          if (!b(paramUserActionEvent.a())) {
            break label1608;
          }
          i = 1;
          ((JSONObject)localObject5).put("topic_flag", i);
          if (!a(paramUserActionEvent.a())) {
            break label1614;
          }
          i = 1;
          ((JSONObject)localObject5).put("at_flag", i);
          paramString = paramUserActionEvent.a();
          paramUserActionEvent = (UserActionEvent)localObject3;
          if (paramString != null) {
            paramUserActionEvent = paramString.getLocationInfo();
          }
          if (paramUserActionEvent != null) {
            break label1620;
          }
          i = m;
          ((JSONObject)localObject5).put("location_flag", i);
          break;
          if (!paramString.equals("0X800AC5F")) {
            break;
          }
        }
        if ((!paramString.equals("0X800B4CC")) || (goto 364) || (!paramString.equals("0X800AC60"))) {
          break;
        }
        paramString = paramUserActionEvent.a();
        if (paramString != null)
        {
          paramString = paramString.getVideoInfo();
          if (paramString != null) {
            break label1631;
          }
          i = 0;
          ((JSONObject)localObject5).put("video_flag", i);
          localObject2 = paramUserActionEvent.a();
          paramString = (String)localObject4;
          if (localObject2 != null) {
            paramString = ((PublishArticleInfo)localObject2).getImageList();
          }
          if (paramString != null) {
            break label1637;
          }
          i = 0;
          ((JSONObject)localObject5).put("cover_flag", i);
          paramUserActionEvent = paramUserActionEvent.a();
          if ((paramUserActionEvent == null) || (paramUserActionEvent.getContentLength() != 0)) {
            break label1643;
          }
        }
        for (i = 0;; i = 1)
        {
          ((JSONObject)localObject5).put("video_name_flag", i);
          ((JSONObject)localObject5).put("collaborator_flag", 0);
          ((JSONObject)localObject5).put("source", 0);
          break;
          if ((!paramString.equals("0X800B24A")) || (goto 364) || (!paramString.equals("0X800B24B")) || (goto 364) || (!paramString.equals("0X800B24C"))) {
            break;
          }
          for (;;)
          {
            ((JSONObject)localObject5).put("topic_id", CollectionsKt.listOf(Integer.valueOf(0)));
            break;
            if ((!paramString.equals("0X800B4C6")) || (goto 364) || (!paramString.equals("0X800B4D6"))) {
              break;
            }
            for (;;)
            {
              ((JSONObject)localObject5).put("type", 0);
              break;
              if ((!paramString.equals("0X800B4C8")) || (goto 364) || (!paramString.equals("0X800B4D8"))) {
                break;
              }
            }
            if (!paramString.equals("0X800B24D")) {
              break;
            }
          }
          if ((!paramString.equals("0X800B4D2")) || (goto 364) || (!paramString.equals("0X800B4D4")) || (goto 364) || (!paramString.equals("0X800AC5A"))) {
            break;
          }
          break label429;
          if (!paramString.equals("0X800AC5B")) {
            break;
          }
          break label429;
          paramString = null;
          break label913;
          i = 1;
          break label920;
          paramString = null;
          break label944;
          i = 1;
          break label951;
          i = 1;
          break label989;
          paramString = null;
          break label1013;
          i = 1;
          break label1020;
          paramString = null;
          break label1047;
          paramString = null;
          break label1071;
          i = 1;
          break label1078;
          i = 1;
          break label1110;
          i = 0;
          break label1135;
          i = 0;
          break label1160;
          i = 1;
          break label1196;
          paramString = null;
          break label1260;
          i = 1;
          break label1267;
          i = 1;
          break label1304;
        }
        i = 1;
        break label816;
      }
      label1110:
      label1135:
      label1267:
      paramString = "";
      label1260:
      break label456;
      label1608:
      label1614:
      label1620:
      label1631:
      label1637:
      label1643:
      localObject2 = "";
      break label491;
      localObject3 = "";
      break label526;
      bool = false;
      break label556;
      i = 1;
      break label591;
      i = 1;
      break label630;
      i = 0;
      break label655;
      i = 1;
      break label663;
      i = 0;
      break label689;
      i = 1;
      break label697;
      i = 0;
      break label723;
    }
  }
  
  private final boolean a(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo != null) {
      paramPublishArticleInfo = ((Iterable)paramPublishArticleInfo.getContentList()).iterator();
    }
    while (paramPublishArticleInfo.hasNext()) {
      if (((EditObject)paramPublishArticleInfo.next()).getType() == EditObject.EditObjectType.TYPE_AT)
      {
        return true;
        return false;
      }
    }
    return false;
  }
  
  private final boolean b(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo != null) {
      paramPublishArticleInfo = ((Iterable)paramPublishArticleInfo.getContentList()).iterator();
    }
    while (paramPublishArticleInfo.hasNext()) {
      if (((EditObject)paramPublishArticleInfo.next()).getType() == EditObject.EditObjectType.TYPE_TOPIC)
      {
        return true;
        return false;
      }
    }
    return false;
  }
  
  public void a(@NotNull UserActionEvent paramUserActionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramUserActionEvent, "event");
    HashMap localHashMap = new HashMap();
    String str1 = PublisherReportUtils.a.a(paramUserActionEvent.a(), paramUserActionEvent.a(), paramUserActionEvent.a());
    a(localHashMap, paramUserActionEvent, str1);
    paramUserActionEvent = paramUserActionEvent.a();
    if (paramUserActionEvent != null) {
      paramUserActionEvent.getVideoInfo();
    }
    paramUserActionEvent = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramUserActionEvent, "BaseApplicationImpl.getApplication()");
    paramUserActionEvent = paramUserActionEvent.getRuntime();
    if (paramUserActionEvent == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    Object localObject1 = (QQAppInterface)paramUserActionEvent;
    paramUserActionEvent = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    localObject1 = (AppInterface)localObject1;
    String str2 = (String)localHashMap.get("uin");
    Object localObject2 = localHashMap.get("from");
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    paramUserActionEvent.publicAccountReportClickEvent((AppInterface)localObject1, str2, str1, str1, ((Integer)localObject2).intValue(), 0, "", "", "", String.valueOf(localHashMap.get("jsonInfo")), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.UserActionReportListener
 * JD-Core Version:    0.7.0.1
 */