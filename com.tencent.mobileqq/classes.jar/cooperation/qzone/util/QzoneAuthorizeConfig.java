package cooperation.qzone.util;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneAuthorizeConfig
{
  public static final String DEFAULT_JSAPI_BLACK_LIST = "";
  public static final String DEFAULT_SCHEMA_BLACK_LIST = "";
  static final String TAG = "QzoneAuthorizeConfig";
  private static QzoneAuthorizeConfig instance;
  private final ConcurrentHashMap<String, Set<String>> mJsApiBlackList = new ConcurrentHashMap();
  private String mJsApiBlackString = null;
  private final ConcurrentHashMap<String, Set<String>> mSchemaBlackList = new ConcurrentHashMap();
  private String mSchemaBlackString = null;
  
  public static QzoneAuthorizeConfig getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QzoneAuthorizeConfig();
      }
      return instance;
    }
    finally {}
  }
  
  private void getNewBlackList(String paramString, ConcurrentHashMap<String, Set<String>> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int i;
      Object localObject;
      int j;
      String str;
      try
      {
        paramString = new JSONArray(paramString);
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label198;
        }
        paramConcurrentHashMap.clear();
        int m = paramString.length();
        i = 0;
        if (i >= m) {
          break label197;
        }
        localObject = paramString.optJSONObject(i);
        JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("schema");
        JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("match");
        int n = localJSONArray2.length();
        j = 0;
        if (j >= n) {
          break label225;
        }
        str = localJSONArray2.optString(j);
        Set localSet = (Set)paramConcurrentHashMap.get(str);
        localObject = localSet;
        if (localSet == null) {
          localObject = new HashSet(20);
        }
        int i1 = localJSONArray1.length();
        int k = 0;
        if (k >= i1) {
          break label207;
        }
        ((Set)localObject).add(localJSONArray1.optString(k));
        k += 1;
        continue;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QzoneAuthorizeConfig", 2, "Js Api Config JSONArray error!", paramString);
        }
        paramString = null;
        continue;
      }
      QLog.e("QzoneAuthorizeConfig", 1, "get Js Api Config From jsApiBlackString is empty!");
      label197:
      return;
      label198:
      QLog.e("QzoneAuthorizeConfig", 1, "Js Api Config JSONArray From jsApiBlackString is empty");
      return;
      label207:
      paramConcurrentHashMap.put(str, localObject);
      j += 1;
      continue;
      label225:
      i += 1;
    }
  }
  
  public static boolean isDomainMatch(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  public boolean hasJsApiRight(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = Uri.parse(paramString1);
        Object localObject1 = paramString1.getScheme();
        if ((!((String)localObject1).equals("http")) && (!((String)localObject1).equals("https"))) {
          return false;
        }
        localObject1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "jsapiblacklist", "");
        if (!((String)localObject1).equals(this.mJsApiBlackString))
        {
          getNewBlackList((String)localObject1, this.mJsApiBlackList);
          this.mJsApiBlackString = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("QzoneAuthorizeConfig", 1, this.mJsApiBlackString);
          }
        }
        if (this.mJsApiBlackList.size() == 0) {
          return true;
        }
        localObject1 = this.mJsApiBlackList.keySet();
        if (((Set)localObject1).size() == 0) {
          return true;
        }
        paramString1 = paramString1.getHost();
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramString1.toLowerCase();
          localObject1 = ((Set)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            if (isDomainMatch((String)localObject2, paramString1))
            {
              localObject2 = (Set)this.mJsApiBlackList.get(localObject2);
              if ((localObject2 != null) && (((Set)localObject2).size() != 0))
              {
                localObject2 = ((Set)localObject2).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  boolean bool = isDomainMatch((String)((Iterator)localObject2).next(), paramString2);
                  if (bool) {
                    return false;
                  }
                }
              }
            }
          }
          else
          {
            return true;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QzoneAuthorizeConfig", 1, "hasJsApiRight()", paramString1);
        return true;
      }
    }
  }
  
  public boolean hasSchemeRight(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        localObject1 = "null";
      }
      paramString1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "schemablacklist", "");
      if (!paramString1.equals(this.mSchemaBlackString))
      {
        getNewBlackList(paramString1, this.mSchemaBlackList);
        this.mSchemaBlackString = paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("QzoneAuthorizeConfig", 1, this.mSchemaBlackString);
        }
      }
      if (this.mSchemaBlackList.size() == 0) {
        return true;
      }
      Object localObject2 = this.mSchemaBlackList.keySet();
      if (((Set)localObject2).size() == 0) {
        return true;
      }
      paramString1 = ((String)localObject1).toLowerCase();
      localObject1 = ((Set)localObject2).iterator();
      boolean bool;
      do
      {
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (String)((Iterator)localObject1).next();
            } while (!isDomainMatch((String)localObject2, paramString1));
            localObject2 = (Set)this.mSchemaBlackList.get(localObject2);
          } while ((localObject2 == null) || (((Set)localObject2).size() == 0));
          localObject2 = ((Set)localObject2).iterator();
        }
        bool = isDomainMatch((String)((Iterator)localObject2).next(), paramString2);
      } while (!bool);
      return false;
    }
    catch (Exception paramString1)
    {
      QLog.e("QzoneAuthorizeConfig", 1, "hasSchemeRight()", paramString1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QzoneAuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */