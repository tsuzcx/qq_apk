package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipProfileTemplateCreator
{
  public static ProfileTemplateBase a(Activity paramActivity, @NonNull JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo, String paramString)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramProfileCardInfo.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == ProfileCardTemplate.l) {}
    for (paramActivity = new Template1(paramActivity, paramJSONObject, paramProfileCardInfo);; paramActivity = new Template2(paramActivity, paramJSONObject, paramProfileCardInfo))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != ProfileCardTemplate.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QVipProfileTemplateCreator
 * JD-Core Version:    0.7.0.1
 */