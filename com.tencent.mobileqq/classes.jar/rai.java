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

public class rai
{
  /* Error */
  public static String a(ArticleInfo paramArticleInfo, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 16	pqw:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 22	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mAlgorithmID	J
    //   15: aload_0
    //   16: invokestatic 25	pqw:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   19: aload_0
    //   20: getfield 28	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mChannelID	J
    //   23: l2i
    //   24: aconst_null
    //   25: invokestatic 34	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 38	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:innerUniqueID	Ljava/lang/String;
    //   33: aload_0
    //   34: invokestatic 41	pqw:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   37: iconst_0
    //   38: invokestatic 46	pqf:a	()I
    //   41: aload_0
    //   42: invokestatic 49	pqf:a	(JIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lorg/json/JSONObject;
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 55	org/json/JSONObject:toString	()Ljava/lang/String;
    //   50: astore_2
    //   51: new 51	org/json/JSONObject
    //   54: dup
    //   55: aload_0
    //   56: getfield 58	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   59: invokespecial 62	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore_0
    //   63: aload_0
    //   64: ldc 64
    //   66: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   69: ifnull +145 -> 214
    //   72: aload_0
    //   73: ldc 64
    //   75: invokevirtual 71	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 75	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   83: astore 4
    //   85: aload 4
    //   87: invokeinterface 81 1 0
    //   92: ifeq +83 -> 175
    //   95: aload 4
    //   97: invokeinterface 85 1 0
    //   102: checkcast 87	java/lang/String
    //   105: astore 5
    //   107: aload_0
    //   108: aload 5
    //   110: invokevirtual 91	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 6
    //   115: aload 5
    //   117: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne -35 -> 85
    //   123: aload 6
    //   125: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne -43 -> 85
    //   131: aload_3
    //   132: aload 5
    //   134: aload 6
    //   136: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: goto -55 -> 85
    //   143: astore_0
    //   144: ldc 103
    //   146: iconst_1
    //   147: new 105	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   154: ldc 110
    //   156: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_2
    //   170: aload_1
    //   171: invokestatic 127	rai:a	(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
    //   174: areturn
    //   175: aload_3
    //   176: invokevirtual 55	org/json/JSONObject:toString	()Ljava/lang/String;
    //   179: astore_0
    //   180: aload_0
    //   181: astore_2
    //   182: goto -13 -> 169
    //   185: astore_0
    //   186: ldc 103
    //   188: iconst_1
    //   189: new 105	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   196: ldc 110
    //   198: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto -42 -> 169
    //   214: aload_2
    //   215: astore_0
    //   216: goto -36 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramArticleInfo	ArticleInfo
    //   0	219	1	paramHashMap	HashMap<String, String>
    //   10	205	2	localObject	Object
    //   45	131	3	localJSONObject	JSONObject
    //   83	13	4	localIterator	Iterator
    //   105	28	5	str1	String
    //   113	22	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	85	143	org/json/JSONException
    //   85	140	143	org/json/JSONException
    //   175	180	143	org/json/JSONException
    //   51	85	185	java/lang/Exception
    //   85	140	185	java/lang/Exception
    //   175	180	185	java/lang/Exception
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
          if (!qzu.a.a().contains(localObject3))
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
  
  public static void a(suu paramsuu, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramsuu == null)) {}
    for (;;)
    {
      return;
      if ((paramBaseArticleInfo.proteusItemsData == null) || (!qym.a(paramBaseArticleInfo))) {
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
            paramsuu.a(str1, str2);
          }
        }
        return;
      }
      catch (JSONException paramsuu)
      {
        QLog.e("PTSRijReport", 1, "[addPtsCardReportToR5], e = " + paramsuu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rai
 * JD-Core Version:    0.7.0.1
 */