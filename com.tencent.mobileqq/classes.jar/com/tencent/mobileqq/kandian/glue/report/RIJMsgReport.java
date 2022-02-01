package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/RIJMsgReport;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgNum", "", "getMsgNum", "()I", "setMsgNum", "(I)V", "addMessageNumToR5", "r5", "", "Lorg/json/JSONObject;", "addMessageReportToR5", "addReportToR5Common", "jsonFunCall", "Lkotlin/Function1;", "recodrMsgNum", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMsgReport
{
  public static final RIJMsgReport a = new RIJMsgReport();
  @NotNull
  private static final String b = "RIJMsgReport";
  private static int c;
  
  private final String a(String paramString, Function1<? super JSONObject, Unit> paramFunction1)
  {
    Object localObject = (JSONObject)null;
    if (paramString != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.d(b, 1, localJSONException.getMessage());
      }
    } else {
      localObject = new JSONObject();
    }
    if (localObject != null)
    {
      paramFunction1.invoke(localObject);
      paramString = ((JSONObject)localObject).toString();
    }
    return paramString;
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    return a(paramString, (Function1)new RIJMsgReport.addMessageReportToR5.1(a));
  }
  
  public final void a()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (KandianMergeManager)localObject;
      if (localObject != null) {
        c = ((KandianMergeManager)localObject).R();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  public final void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    } else {
      localObject = null;
    }
    localObject = (KandianMergeManager)localObject;
    if (localObject != null)
    {
      localObject = ((KandianMergeManager)localObject).Q();
      if (localObject != null)
      {
        paramJSONObject.put("message_type", ((KandianMsgBoxRedPntInfo)localObject).mMsgType);
        paramJSONObject.put("sys_msg_from", ((KandianMsgBoxRedPntInfo)localObject).mUin);
        paramJSONObject.put("sys_msg_id", ((KandianMsgBoxRedPntInfo)localObject).sysMsgID);
      }
    }
  }
  
  @Nullable
  public final String b(@Nullable String paramString)
  {
    return a(paramString, (Function1)new RIJMsgReport.addMessageNumToR5.1(a));
  }
  
  public final void b(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    int i = c;
    if (i != 0) {
      paramJSONObject.put("tab_reddot_num", i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJMsgReport
 * JD-Core Version:    0.7.0.1
 */