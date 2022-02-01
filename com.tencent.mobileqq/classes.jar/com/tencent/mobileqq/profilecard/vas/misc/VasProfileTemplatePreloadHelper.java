package com.tencent.mobileqq.profilecard.vas.misc;

import android.graphics.Color;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/misc/VasProfileTemplatePreloadHelper;", "", "()V", "BACKGROUND", "", "BODY", "HEADER", "TAG", "TITLE_STYLE", "URL_PREFIX", "initDiyData", "", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileTemplatePreloadHelper
{
  @NotNull
  public static final String BACKGROUND = "bg";
  @NotNull
  public static final String BODY = "body";
  @NotNull
  public static final String HEADER = "header";
  public static final VasProfileTemplatePreloadHelper INSTANCE = new VasProfileTemplatePreloadHelper();
  @NotNull
  public static final String TAG = "VasProfileTemplatePreloadHelper";
  @NotNull
  public static final String TITLE_STYLE = "ts";
  @NotNull
  public static final String URL_PREFIX = "path";
  
  public final boolean initDiyData(@NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "cardInfo");
    paramProfileCardInfo.removeBusinessInfo(VasDiyData.class);
    Object localObject1 = paramProfileCardInfo.card.diyComplicatedInfo;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      QLog.e("VasProfileTemplatePreloadHelper", 1, " diy info is null!");
      return false;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localObject2 = ((JSONObject)localObject1).optString("path", "");
      localObject3 = ((JSONObject)localObject1).opt("bg");
      if (localObject3 != null)
      {
        localObject4 = ((JSONObject)localObject1).opt("header");
        if (localObject4 != null)
        {
          localJSONObject = ((JSONObject)localObject1).optJSONObject("body");
          if (localJSONObject == null) {}
        }
      }
    }
    catch (Exception paramProfileCardInfo)
    {
      Object localObject3;
      Object localObject4;
      JSONObject localJSONObject;
      label145:
      int j;
      QLog.e("VasProfileTemplatePreloadHelper", 1, " diy info is null!", (Throwable)paramProfileCardInfo);
      return false;
    }
    try
    {
      i = Color.parseColor(localJSONObject.optString("c"));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label145;
    }
    int i = -16777216;
    j = localJSONObject.optInt("ts", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "urlPrefix");
    paramProfileCardInfo.putBusinessInfo((IProfileBusinessInfo)new VasDiyData((String)localObject2, j, i, localObject4, localJSONObject, localObject3));
    return true;
    paramProfileCardInfo = new StringBuilder();
    paramProfileCardInfo.append("json have no body!! ");
    paramProfileCardInfo.append(localObject1);
    throw ((Throwable)new JSONException(paramProfileCardInfo.toString()));
    paramProfileCardInfo = new StringBuilder();
    paramProfileCardInfo.append("json have no header!! ");
    paramProfileCardInfo.append(localObject1);
    throw ((Throwable)new JSONException(paramProfileCardInfo.toString()));
    paramProfileCardInfo = new StringBuilder();
    paramProfileCardInfo.append("json have no background!! ");
    paramProfileCardInfo.append(localObject1);
    throw ((Throwable)new JSONException(paramProfileCardInfo.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper
 * JD-Core Version:    0.7.0.1
 */