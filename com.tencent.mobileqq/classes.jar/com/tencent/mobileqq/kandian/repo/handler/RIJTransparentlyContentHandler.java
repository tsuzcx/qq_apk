package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/handler/RIJTransparentlyContentHandler;", "", "()V", "TAG", "", "addLowerActiveUserExperimentFlag", "", "jsonObject", "Lorg/json/JSONObject;", "get68BRecommendTransparentlyJson", "app", "Lcom/tencent/common/app/AppInterface;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJTransparentlyContentHandler
{
  public static final RIJTransparentlyContentHandler a = new RIJTransparentlyContentHandler();
  
  private final void a(JSONObject paramJSONObject)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(220);
    if (localAladdinConfig.getIntegerFromString("is_experiment_user", -1) != -1) {
      paramJSONObject.put("is_experiment_user", localAladdinConfig.getIntegerFromString("is_experiment_user", 0));
    }
  }
  
  @NotNull
  public final String a(@Nullable AppInterface paramAppInterface)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      RIJStudyModeUtils.a(localJSONObject);
      if (paramAppInterface != null)
      {
        paramAppInterface = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramAppInterface != null) {
          localJSONObject.put("fnum", paramAppInterface.u());
        }
      }
      a(localJSONObject);
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("68b transparently json : ");
      paramAppInterface.append(localJSONObject);
      QLog.d("RIJTransparentlyContentHandler", 1, paramAppInterface.toString());
    }
    catch (JSONException paramAppInterface)
    {
      QLog.e("RIJTransparentlyContentHandler", 1, "json error", (Exception)paramAppInterface);
    }
    paramAppInterface = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "jsonObject.toString()");
    return paramAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJTransparentlyContentHandler
 * JD-Core Version:    0.7.0.1
 */