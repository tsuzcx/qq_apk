import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class pvp
{
  public static void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {}
    while (!pwu.a().a()) {
      return;
    }
    c(paramArticleInfo);
    JSONObject localJSONObject;
    String str;
    try
    {
      localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
      str = localJSONObject.optString("pts_page_name");
      if (TextUtils.isEmpty(str))
      {
        QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData], pageName is empty, pageName = " + str + ", innerUniqueID = " + paramArticleInfo.innerUniqueID);
        return;
      }
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[preHandlePtsLiteData] error, e = " + paramArticleInfo);
      return;
    }
    paramArticleInfo.ptsLiteAppName = str;
    b(paramArticleInfo, localJSONObject);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    QLog.i("PTSLiteDataParser", 1, "[updateJsonDataPtsRijArticle], key = " + paramString1 + ", value = " + paramString2 + ", title = " + paramArticleInfo.mTitle);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
      if (localJSONObject.optJSONObject("$RIJArticle") != null) {
        localJSONObject.optJSONObject("$RIJArticle").put(paramString1, paramString2);
      }
      b(paramArticleInfo, localJSONObject);
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[updateJsonDataPtsRijArticle] error, e = " + paramArticleInfo);
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramArticleInfo == null) || (paramJSONObject == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rowKey", paramArticleInfo.innerUniqueID);
        Object localObject = ors.a();
        if (localObject != null)
        {
          localObject = (oxd)((QQAppInterface)localObject).getManager(163);
          if (localObject != null)
          {
            if (!((oxd)localObject).a().a(paramArticleInfo.mArticleID)) {
              break label112;
            }
            paramArticleInfo = "1";
            localJSONObject.put("isRead", paramArticleInfo);
          }
        }
        paramJSONObject.put("$RIJArticle", localJSONObject);
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.e("PTSLiteDataParser", 1, "[addRIJArticleJson] error, e = " + paramArticleInfo);
        return;
      }
      label112:
      paramArticleInfo = "0";
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject = ors.a();
    if (localObject != null)
    {
      localObject = (oxd)((QQAppInterface)localObject).getManager(163);
      if (localObject != null) {
        ((oxd)localObject).a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    }
    a(paramArticleInfo, "isRead", "1");
  }
  
  private static void b(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str1 = paramArticleInfo.ptsLiteAppName;
    String str2 = paramArticleInfo.innerUniqueID;
    String str3 = pxa.a().a("default_feeds", str1);
    a(paramArticleInfo, paramJSONObject);
    QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], json = " + paramJSONObject.toString());
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramJSONObject.toString())) && (!TextUtils.isEmpty(str3)))
    {
      paramArticleInfo.ptsItemData = new PTSItemData.Builder().withAppName(str1).withItemID(str2).withJsonData(paramJSONObject.toString()).withFrameTreeJson(str3).build();
      paramArticleInfo.ptsItemDataBytes = pww.a(paramArticleInfo.ptsItemData);
    }
    for (;;)
    {
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
        QLog.i("PTSLiteDataParser", 2, "[preHandlePtsLiteData], appName = " + str1 + ", itemId = " + str2 + ", json = " + paramJSONObject.toString());
      }
      if (TextUtils.isEmpty(str3)) {
        QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData], frameTreeJson is empty.");
      }
      paramJSONObject = ors.a();
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = (oxd)paramJSONObject.getManager(163);
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject.a().b(paramArticleInfo);
      return;
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData] failed, something is null.");
    }
  }
  
  private static void c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
      if (TextUtils.equals(localJSONObject.optString("style_ID"), "ReadInjoy_daily_triple_img_cell")) {
        localJSONObject.put("pts_page_name", "daily_triple_img_card");
      }
      paramArticleInfo.proteusItemsData = localJSONObject.toString();
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[convertDailyTripleData] error, e = " + paramArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvp
 * JD-Core Version:    0.7.0.1
 */