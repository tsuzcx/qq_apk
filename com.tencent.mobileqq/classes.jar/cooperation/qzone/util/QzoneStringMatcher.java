package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import common.config.service.QzoneConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneStringMatcher
{
  private static final int QzoneStringMatcherLruMapSize = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneRegLruMapSize", 50);
  public static final String TAG = "QzoneStringMatcher";
  private static final long UPDATE_CONFIG_INTERVAL_MS = 180000L;
  private static long gLastReadConfigTime = 0L;
  private static LRULinkedHashMap<String, Pattern> gPatternCacheMap;
  private static String gUrlConfig = null;
  
  private static String getUrlConfig()
  {
    long l = System.currentTimeMillis();
    if (l - gLastReadConfigTime >= 180000L)
    {
      gUrlConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneUrlBanList", "[{'domains':['^.*\\.douyin\\.com/.*'],'items':['^https?://d\\.douyin\\.com/.+']},{'domains':['^.*\\.huoshan\\.com/.*'],'items':['^https?://d\\.huoshan\\.com/.+']},{'domains':['^.*\\.toutiao\\.com/.*','^.*\\.xiguaapp\\.cn/.*','^.*\\.xiguashipin\\.cn/.*','^.*\\.365yg\\.com/.*','^.*\\.snssdk\\.com/.*','^.*\\.ixigua\\.com/.*','^.*\\.toutiaocdn\\.net/.*'],'items':['^https?://d\\.toutiao\\.com/.+','^https?://d\\.ixigua\\.com/.+']},{'domains':['^http.*'],'items':['^snssdk[0-9]+://.*','^changba://.*','^orpheus://.*']}]");
      gLastReadConfigTime = l;
    }
    return gUrlConfig;
  }
  
  public static boolean isMatch(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (gPatternCacheMap == null) {
      gPatternCacheMap = new LRULinkedHashMap(QzoneStringMatcherLruMapSize);
    }
    Pattern localPattern1 = null;
    try
    {
      if (QzoneStringMatcherLruMapSize > 0) {
        localPattern1 = (Pattern)gPatternCacheMap.get(paramString2);
      }
      Pattern localPattern2 = localPattern1;
      if (localPattern1 == null)
      {
        localPattern1 = Pattern.compile(paramString2);
        localPattern2 = localPattern1;
        if (QzoneStringMatcherLruMapSize > 0)
        {
          gPatternCacheMap.put(paramString2, localPattern1);
          localPattern2 = localPattern1;
        }
      }
      boolean bool = localPattern2.matcher(paramString1).lookingAt();
      return bool;
    }
    catch (Exception paramString1)
    {
      QLog.e("QzoneStringMatcher", 1, "isMatch reg error.", paramString1);
    }
    return false;
  }
  
  public static boolean needIgoreUrl(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    String str1 = getUrlConfig();
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    for (;;)
    {
      try
      {
        localJSONArray1 = new JSONArray(str1);
        if (localJSONArray1.length() > 0) {
          continue;
        }
        return false;
      }
      catch (JSONException paramString1)
      {
        JSONArray localJSONArray1;
        Object localObject;
        JSONArray localJSONArray2;
        String str2;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
        j += 1;
        continue;
        j = 0;
        if (j != 0) {
          continue;
        }
        continue;
        j = 0;
        continue;
      }
      if (i >= localJSONArray1.length()) {
        continue;
      }
      localObject = localJSONArray1.getJSONObject(i);
      localJSONArray2 = ((JSONObject)localObject).optJSONArray("domains");
      if (localJSONArray2 != null)
      {
        if (localJSONArray2.length() != 0) {
          continue;
        }
        continue;
        if (j >= localJSONArray2.length()) {
          continue;
        }
        str2 = (String)localJSONArray2.get(j);
        if ((TextUtils.isEmpty(str2)) || (!isMatch(paramString1, str2))) {
          continue;
        }
        j = 1;
        continue;
        localJSONArray2 = ((JSONObject)localObject).optJSONArray("items");
        if (localJSONArray2 != null)
        {
          if (localJSONArray2.length() != 0) {
            continue;
          }
          continue;
          if (j < localJSONArray2.length())
          {
            localObject = (String)localJSONArray2.get(j);
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (isMatch(paramString2, (String)localObject)))
            {
              paramString1 = new StringBuilder();
              paramString1.append("match url:");
              paramString1.append(paramString2);
              paramString1.append(",item=");
              paramString1.append((String)localObject);
              QLog.d("QzoneStringMatcher", 2, paramString1.toString());
              return true;
            }
            j += 1;
            continue;
          }
        }
      }
      i += 1;
    }
    paramString1 = new StringBuilder();
    paramString1.append("config is not valid json. ");
    paramString1.append(str1);
    QLog.e("QzoneStringMatcher", 1, paramString1.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QzoneStringMatcher
 * JD-Core Version:    0.7.0.1
 */