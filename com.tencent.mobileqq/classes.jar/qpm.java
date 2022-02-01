import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class qpm
{
  public static String a(ArticleInfo paramArticleInfo, HashMap<String, String> paramHashMap)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    String str1 = pha.d(paramArticleInfo);
    JSONObject localJSONObject = pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), (int)paramArticleInfo.mChannelID, bgnt.h(null), str1, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), 0, pha.d(), paramArticleInfo);
    str1 = localJSONObject.toString();
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo.proteusItemsData);
      if (paramArticleInfo.optJSONObject("card_report_params") != null)
      {
        paramArticleInfo = paramArticleInfo.getJSONObject("card_report_params");
        Iterator localIterator = paramArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          String str3 = paramArticleInfo.optString(str2);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            localJSONObject.put(str2, str3);
          }
        }
      }
      return a(paramArticleInfo, paramHashMap);
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("PTSRijReport", 1, "[getR5Json], e = " + paramArticleInfo);
      paramArticleInfo = str1;
    }
    for (;;)
    {
      paramArticleInfo = localJSONObject.toString();
    }
  }
  
  public static String a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject1 = new JSONObject();
    label374:
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label374;
        }
        localObject2 = new JSONObject(paramString);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException1)
      {
        Object localObject2;
        Object localObject3;
        QLog.e("PTSRijReport", 1, "[getR5Json] error, e = " + localJSONException1 + ", r5 = " + paramString);
        continue;
        paramHashMap = "";
        continue;
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equalsIgnoreCase("r5"))) {
          continue;
        }
        try
        {
          localObject3 = new JSONObject(paramHashMap);
          Iterator localIterator = ((JSONObject)localObject3).keys();
          if (!localIterator.hasNext()) {
            continue;
          }
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject3).optString(str1);
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
            continue;
          }
          ((JSONObject)localObject1).put(str1, str2);
          continue;
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("PTSRijReport", 1, "[getR5Json] error, e = " + localJSONException2 + ", value = " + paramHashMap);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PTSRijReport", 1, "[getR5Json] r5 = " + paramString);
        return ((JSONObject)localObject1).toString();
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        localObject2 = paramHashMap.entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramHashMap = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (String)paramHashMap.getKey();
          paramHashMap = (String)paramHashMap.getValue();
          if (!qpa.a.a().contains(localObject3))
          {
            try
            {
              if (TextUtils.isEmpty(paramHashMap)) {
                continue;
              }
              ((JSONObject)localObject1).put((String)localObject3, paramHashMap);
            }
            catch (JSONException paramHashMap)
            {
              QLog.e("PTSRijReport", 1, "[getR5Json] error, e = " + paramHashMap + ", key = " + (String)localObject3);
            }
            continue;
          }
        }
      }
    }
  }
  
  public static void a(skc paramskc, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramskc == null)) {}
    for (;;)
    {
      return;
      if (!qnu.a(paramBaseArticleInfo)) {
        continue;
      }
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        if (paramBaseArticleInfo.optJSONObject("card_report_params") == null) {
          continue;
        }
        paramBaseArticleInfo = paramBaseArticleInfo.getJSONObject("card_report_params");
        Iterator localIterator = paramBaseArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramBaseArticleInfo.optString(str1);
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            paramskc.a(str1, str2);
          }
        }
        return;
      }
      catch (JSONException paramskc)
      {
        QLog.e("PTSRijReport", 1, "[addPtsCardReportToR5], e = " + paramskc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpm
 * JD-Core Version:    0.7.0.1
 */