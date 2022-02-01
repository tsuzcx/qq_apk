import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class pnp
{
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null)) {}
    try
    {
      orr localorr = paramBaseArticleInfo.mSocialFeedInfo.a;
      b(localorr, paramBaseArticleInfo);
      a(paramContext, localorr);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJMedalUtils", 2, paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, orr paramorr)
  {
    if ((paramContext != null) && (paramorr != null) && (!TextUtils.isEmpty(paramorr.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramorr.jdField_b_of_type_Int) {
        pqx.a(paramContext, paramorr.jdField_c_of_type_JavaLangString);
      }
      olh.a(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramorr.a(), false);
    }
  }
  
  public static void a(JSONObject paramJSONObject, orr paramorr)
  {
    if ((paramJSONObject == null) || (paramorr == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramorr.jdField_b_of_type_JavaLangString))
        {
          QLog.d("RIJMedalUtils", 1, "bindMedalData : " + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("RIJMedalUtils", 2, paramJSONObject.getMessage());
        return;
      }
      if ((paramorr.jdField_c_of_type_Int > 0) && (paramorr.jdField_d_of_type_Int > 0))
      {
        paramJSONObject.put("header_medal_jump_url", paramorr.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramorr.jdField_c_of_type_Int).doubleValue() / paramorr.jdField_d_of_type_Int);
        paramJSONObject.put("header_medal_image_url", paramorr.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public static void a(orr paramorr)
  {
    if (paramorr == null) {
      return;
    }
    olh.a(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramorr.a(), false);
  }
  
  public static void a(orr paramorr, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramorr != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramorr, paramBaseArticleInfo);
      a(paramorr);
    }
  }
  
  public static void b(orr paramorr, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramorr != null) {
      for (;;)
      {
        try
        {
          paramorr.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mChannelID);
          paramorr.g = String.valueOf(paramBaseArticleInfo.mFeedId);
          paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
          paramorr.h = String.valueOf(paramBaseArticleInfo.mSubscribeID);
          if ((ppe.g(paramBaseArticleInfo)) || (ppe.a(paramBaseArticleInfo)))
          {
            paramorr.f = "5";
            paramorr.e = "2";
            return;
          }
          if (ppe.e(paramBaseArticleInfo)) {
            paramorr.f = "4";
          } else {
            paramorr.f = "0";
          }
        }
        catch (Exception paramorr)
        {
          QLog.e("RIJMedalUtils", 2, paramorr.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnp
 * JD-Core Version:    0.7.0.1
 */