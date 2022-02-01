import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qmf
{
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData], articleInfo is null or proteusItemsData is null.");
    }
    while (!qny.a().a()) {
      return;
    }
    if (qny.a().b()) {
      d(paramArticleInfo);
    }
    qmc.a.a(paramArticleInfo);
    if (paramArticleInfo.proteusItemsData == null)
    {
      QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData] proteusItemsData is null.");
      return;
    }
    JSONObject localJSONObject;
    String str;
    try
    {
      localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
      str = localJSONObject.optString("pts_page_name");
      if (TextUtils.isEmpty(str))
      {
        QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData], pageName is empty, pageName = " + str + ", innerUniqueID = " + paramArticleInfo.innerUniqueID + ", json = " + localJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[preHandlePtsLiteData] error, e = " + paramArticleInfo);
      return;
    }
    paramArticleInfo.ptsLitePageName = str;
    c(paramArticleInfo, localJSONObject);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.proteusItemsData == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    QLog.i("PTSLiteDataParser", 1, "[updateJsonDataPtsRijArticle], key = " + paramString1 + ", value = " + paramString2 + ", title = " + paramArticleInfo.mTitle);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
      if (localJSONObject.optJSONObject("$RIJArticle") != null) {
        localJSONObject.optJSONObject("$RIJArticle").put(paramString1, paramString2);
      }
      c(paramArticleInfo, localJSONObject);
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
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      b(paramArticleInfo, localJSONObject1);
      if (paramArticleInfo.mSubArtilceList != null)
      {
        JSONArray localJSONArray = new JSONArray();
        paramArticleInfo = paramArticleInfo.mSubArtilceList.iterator();
        while (paramArticleInfo.hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)paramArticleInfo.next();
          JSONObject localJSONObject2 = new JSONObject();
          b(localArticleInfo, localJSONObject2);
          localJSONArray.put(localJSONObject2);
        }
        localJSONObject1.put("subArticles", localJSONArray);
      }
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[addRIJArticleJson] error, e = " + paramArticleInfo);
      return;
    }
    paramJSONObject.put("$RIJArticle", localJSONObject1);
  }
  
  public static void b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.proteusItemsData == null)) {
      return;
    }
    try
    {
      c(paramArticleInfo, new JSONObject(paramArticleInfo.proteusItemsData));
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[refreshArticleInfo] e = " + paramArticleInfo);
    }
  }
  
  private static void b(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("rowKey", paramArticleInfo.innerUniqueID);
      Object localObject = pay.a();
      if (localObject != null)
      {
        localObject = (pks)((QQAppInterface)localObject).getManager(163);
        if (localObject != null)
        {
          if (((pks)localObject).a().a(paramArticleInfo.mArticleID)) {}
          for (paramArticleInfo = "1";; paramArticleInfo = "0")
          {
            paramJSONObject.put("isRead", paramArticleInfo);
            return;
          }
        }
      }
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSLiteDataParser", 1, "[addRIJArticleJsonImp], e = " + paramArticleInfo);
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject = pay.a();
    if (localObject != null)
    {
      localObject = (pks)((QQAppInterface)localObject).getManager(163);
      if (localObject != null) {
        ((pks)localObject).a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    }
    a(paramArticleInfo, "isRead", "1");
  }
  
  private static void c(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramArticleInfo.innerUniqueID))
    {
      paramArticleInfo.innerUniqueID = ("pts_page_" + System.currentTimeMillis());
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], innerUniqueId is null.");
    }
    String str1 = paramArticleInfo.ptsLitePageName;
    String str2 = paramArticleInfo.innerUniqueID;
    String str3 = qoe.a().a("default_feeds", str1);
    a(paramArticleInfo, paramJSONObject);
    QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], json = " + paramJSONObject.toString());
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramJSONObject.toString())) && (!TextUtils.isEmpty(str3)))
    {
      paramArticleInfo.ptsItemData = new PTSItemData.Builder().withPageName(str1).withItemID(str2).withJsonData(paramJSONObject.toString()).withFrameTreeJson(str3).build();
      paramArticleInfo.ptsItemDataBytes = qoa.a(paramArticleInfo.ptsItemData);
      if (paramArticleInfo.ptsComposer != null) {
        paramArticleInfo.ptsComposer.setData(paramJSONObject.toString());
      }
      paramArticleInfo.proteusItemsData = paramJSONObject.toString();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PTSLiteDataParser", 2, "[updatePtsItemData], pageName = " + str1 + ", itemId = " + str2 + ", json = " + paramJSONObject.toString());
      }
      if (TextUtils.isEmpty(str3)) {
        QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], frameTreeJson is empty.");
      }
      paramJSONObject = pay.a();
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = (pks)paramJSONObject.getManager(163);
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject.a().b(paramArticleInfo);
      return;
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData] failed, something is null.");
    }
  }
  
  private static void d(ArticleInfo paramArticleInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmf
 * JD-Core Version:    0.7.0.1
 */