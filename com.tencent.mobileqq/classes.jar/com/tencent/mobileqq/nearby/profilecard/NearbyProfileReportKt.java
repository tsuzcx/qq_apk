package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "report", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "opername", "action", "module", "func", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ExtensionFunctionType;", "reportMomentTabClick", "activity", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;", "reportNewUserGuideShow", "times", "", "reportProfile", "card", "Lcom/tencent/mobileqq/data/NearbyPeopleCard;", "reportProfileClick", "reportProfileTabClick", "reportSendMsgButtonClick", "reportSendMsgDialogButtonClick", "content", "reportShowInterestsEditDialog", "reportShowProfileDisplayPanel", "from", "reportShowSendMsgDialog", "reportToufuClick", "tinyId", "reportToufuShow", "qqnearby_impl_release"}, k=2, mv={1, 1, 16})
public final class NearbyProfileReportKt
{
  public static final void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#discover");
      localJSONObject.put("module", "userguide_page");
      localJSONObject.put("action", "view");
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
      localJSONObject.put("d5", String.valueOf(paramInt + 1));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportNewUserGuideShow error: ");
      localStringBuilder.append(localJSONException);
      QLog.e("nearbyProfileReport", 1, localStringBuilder.toString());
    }
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "tinyId");
    a(paramQQAppInterface, "now#nearby#news_c2c", "view", "profile_column", (Function1)new NearbyProfileReportKt.reportToufuShow.1(paramString));
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Function1<? super JSONObject, Unit> paramFunction1)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", paramString1);
      localJSONObject.put("module", paramString3);
      localJSONObject.put("action", paramString2);
      localJSONObject.put("fromuin", paramQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("appid", String.valueOf(paramQQAppInterface.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
      if (paramFunction1 != null) {
        paramQQAppInterface = (Unit)paramFunction1.invoke(localJSONObject);
      }
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramString1 = new StringBuilder();
      paramString1.append("report error: ");
      paramString1.append(paramQQAppInterface);
      QLog.e("nearbyProfileReport", 1, paramString1.toString());
    }
  }
  
  private static final void a(NearbyPeopleCard paramNearbyPeopleCard, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Function1<? super JSONObject, Unit> paramFunction1)
  {
    a(paramQQAppInterface, paramString1, paramString3, paramString2, (Function1)new NearbyProfileReportKt.reportProfile.1(paramNearbyPeopleCard, paramFunction1));
  }
  
  public static final void a(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    NearbyPeopleCard localNearbyPeopleCard = paramNearbyPeopleProfileActivity.mCard;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleCard, "activity.mCard");
    paramNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramNearbyPeopleProfileActivity, "activity.app");
    a(localNearbyPeopleCard, paramNearbyPeopleProfileActivity, "now#nearby#interest", "overall_page", "view", null, 32, null);
  }
  
  public static final void a(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    NearbyPeopleCard localNearbyPeopleCard = paramNearbyPeopleProfileActivity.mCard;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleCard, "activity.mCard");
    paramNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramNearbyPeopleProfileActivity, "activity.app");
    a(localNearbyPeopleCard, paramNearbyPeopleProfileActivity, "now#nearby#datacard", "overall_page", "view", (Function1)new NearbyProfileReportKt.reportShowProfileDisplayPanel.1(paramInt));
  }
  
  public static final void a(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    NearbyPeopleCard localNearbyPeopleCard = paramNearbyPeopleProfileActivity.mCard;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleCard, "activity.mCard");
    paramNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramNearbyPeopleProfileActivity, "activity.app");
    a(localNearbyPeopleCard, paramNearbyPeopleProfileActivity, "now#nearby#datacard", "autoc2cpop_send_buttom", "click", (Function1)new NearbyProfileReportKt.reportSendMsgDialogButtonClick.1(paramString));
  }
  
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tinyId");
    try
    {
      paramString = new JSONObject();
      paramString.put("opername", "now#nearby#news_c2c");
      paramString.put("module", "profile_column");
      paramString.put("action", "click");
      paramString.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportToufuClick error: ");
      localStringBuilder.append(paramString);
      QLog.e("nearbyProfileReport", 1, localStringBuilder.toString());
    }
  }
  
  public static final void b(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    b(paramNearbyPeopleProfileActivity, "trend_tab");
  }
  
  private static final void b(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString)
  {
    NearbyPeopleCard localNearbyPeopleCard = paramNearbyPeopleProfileActivity.mCard;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleCard, "activity.mCard");
    paramNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramNearbyPeopleProfileActivity, "activity.app");
    a(localNearbyPeopleCard, paramNearbyPeopleProfileActivity, "now#nearby#datacard", paramString, "click", null, 32, null);
  }
  
  public static final void c(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    b(paramNearbyPeopleProfileActivity, "profile_tab");
  }
  
  public static final void d(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    b(paramNearbyPeopleProfileActivity, "msg_button");
  }
  
  public static final void e(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    NearbyPeopleCard localNearbyPeopleCard = paramNearbyPeopleProfileActivity.mCard;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleCard, "activity.mCard");
    paramNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramNearbyPeopleProfileActivity, "activity.app");
    a(localNearbyPeopleCard, paramNearbyPeopleProfileActivity, "now#nearby#datacard", "autoc2c_pop", "view", null, 32, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileReportKt
 * JD-Core Version:    0.7.0.1
 */