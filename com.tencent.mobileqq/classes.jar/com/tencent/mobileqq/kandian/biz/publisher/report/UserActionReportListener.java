package com.tencent.mobileqq.kandian.biz.publisher.report;

import androidx.annotation.VisibleForTesting;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/UserActionReportListener;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/events/UserActionEvent;", "()V", "getReportFrom", "", "event", "getReportJsonObject", "Lorg/json/JSONObject;", "publishTCode", "", "hasAtInfo", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "hasTopicInfo", "onEvent", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionReportListener
  implements IEventObserver<UserActionEvent>
{
  public static final UserActionReportListener.Companion a = new UserActionReportListener.Companion(null);
  
  private final JSONObject a(UserActionEvent paramUserActionEvent, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final boolean a(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo != null)
    {
      paramPublishArticleInfo = ((Iterable)paramPublishArticleInfo.getContentList()).iterator();
      while (paramPublishArticleInfo.hasNext()) {
        if (((EditObject)paramPublishArticleInfo.next()).getType() == EditObject.EditObjectType.TYPE_AT) {
          return true;
        }
      }
    }
    return false;
  }
  
  private final boolean b(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo != null)
    {
      paramPublishArticleInfo = ((Iterable)paramPublishArticleInfo.getContentList()).iterator();
      while (paramPublishArticleInfo.hasNext()) {
        if (((EditObject)paramPublishArticleInfo.next()).getType() == EditObject.EditObjectType.TYPE_TOPIC) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void a(@NotNull UserActionEvent paramUserActionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramUserActionEvent, "event");
    String str = PublisherReportUtils.a.a(paramUserActionEvent.a(), paramUserActionEvent.b(), paramUserActionEvent.c());
    int i;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      Object localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
      localObject1 = localObject2;
      if (!(localObject2 instanceof QQAppInterface)) {
        localObject1 = null;
      }
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = TopicSDK.a.a().b().f().a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "TopicSDK.instance().topicSDKConfig.account.userId");
      i = b(paramUserActionEvent);
      paramUserActionEvent = a(paramUserActionEvent, str);
      PublicAccountReportUtils.a((AppInterface)localObject1, (String)localObject2, str, str, i, 0, "", "", "", paramUserActionEvent.toString(), false);
      return;
    }
  }
  
  @VisibleForTesting
  public final int b(@NotNull UserActionEvent paramUserActionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramUserActionEvent, "event");
    Object localObject = paramUserActionEvent.e();
    if (localObject != null)
    {
      localObject = ((PublishArticleInfo)localObject).getScene();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    paramUserActionEvent = paramUserActionEvent.d();
    if (paramUserActionEvent != null)
    {
      paramUserActionEvent = paramUserActionEvent.getScene();
      if (paramUserActionEvent != null) {}
    }
    else
    {
      paramUserActionEvent = "";
    }
    int i;
    if (((CharSequence)localObject).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramUserActionEvent = (UserActionEvent)localObject;
    }
    try
    {
      i = new JSONObject(paramUserActionEvent).optInt("key_from", -1);
      i = PublisherReportUtils.a.a(i);
      return i;
    }
    catch (JSONException paramUserActionEvent)
    {
      QLog.e("UserActionReportListener", 1, "getReportFrom JsonParse Error.", (Throwable)paramUserActionEvent);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.UserActionReportListener
 * JD-Core Version:    0.7.0.1
 */