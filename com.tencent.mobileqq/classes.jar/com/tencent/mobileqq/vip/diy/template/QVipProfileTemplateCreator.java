package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipProfileTemplateCreator
{
  public static ProfileTemplateBase a(Activity paramActivity, @NonNull JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo, String paramString)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null))
    {
      long l1 = paramProfileCardInfo.card.lCurrentStyleId;
      if (l1 >= 0L)
      {
        long l2 = paramJSONObject.optLong("id");
        if (l2 == l1)
        {
          if (l2 == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE)
          {
            paramActivity = new Template1(paramActivity, paramJSONObject, paramProfileCardInfo);
          }
          else
          {
            if (l2 != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE_2) {
              break label93;
            }
            paramActivity = new Template2(paramActivity, paramJSONObject, paramProfileCardInfo);
          }
          paramActivity.a(paramString);
          return paramActivity;
          label93:
          paramActivity = new StringBuilder();
          paramActivity.append("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=");
          paramActivity.append(l2);
          throw new JSONException(paramActivity.toString());
        }
        paramActivity = new StringBuilder();
        paramActivity.append("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(");
        paramActivity.append(l1);
        paramActivity.append(") and json id(");
        paramActivity.append(l2);
        paramActivity.append(") not match");
        throw new JSONException(paramActivity.toString());
      }
      paramActivity = new StringBuilder();
      paramActivity.append("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=");
      paramActivity.append(l1);
      throw new JSONException(paramActivity.toString());
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QVipProfileTemplateCreator
 * JD-Core Version:    0.7.0.1
 */