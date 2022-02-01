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
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new QzoneAuthorizeConfig();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void getNewBlackList(String paramString, ConcurrentHashMap<String, Set<String>> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramString = new JSONArray(paramString);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QzoneAuthorizeConfig", 2, "Js Api Config JSONArray error!", paramString);
        }
        paramString = null;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramConcurrentHashMap.clear();
        int m = paramString.length();
        int i = 0;
        while (i < m)
        {
          Object localObject = paramString.optJSONObject(i);
          JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("schema");
          JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("match");
          int n = localJSONArray2.length();
          int j = 0;
          while (j < n)
          {
            String str = localJSONArray2.optString(j);
            Set localSet = (Set)paramConcurrentHashMap.get(str);
            localObject = localSet;
            if (localSet == null) {
              localObject = new HashSet(20);
            }
            int i1 = localJSONArray1.length();
            int k = 0;
            while (k < i1)
            {
              ((Set)localObject).add(localJSONArray1.optString(k));
              k += 1;
            }
            paramConcurrentHashMap.put(str, localObject);
            j += 1;
          }
          i += 1;
        }
        return;
      }
      QLog.e("QzoneAuthorizeConfig", 1, "Js Api Config JSONArray From jsApiBlackString is empty");
      return;
    }
    QLog.e("QzoneAuthorizeConfig", 1, "get Js Api Config From jsApiBlackString is empty!");
  }
  
  public static boolean isDomainMatch(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (!bool2)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ("*".equals(paramString1)) {
        return true;
      }
      if ("*.*".equals(paramString1))
      {
        if (paramString2.indexOf('.') != -1) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramString1.startsWith("*")) {
        return paramString2.endsWith(paramString1.substring(1));
      }
      if (paramString1.endsWith("*")) {
        return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
      }
      return paramString2.equals(paramString1);
    }
    return false;
  }
  
  public boolean hasJsApiRight(String paramString1, String paramString2)
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
      Object localObject2 = this.mJsApiBlackList.keySet();
      if (((Set)localObject2).size() == 0) {
        return true;
      }
      localObject1 = paramString1.getHost();
      paramString1 = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = ((String)localObject1).toLowerCase();
      }
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
            localObject2 = (Set)this.mJsApiBlackList.get(localObject2);
          } while ((localObject2 == null) || (((Set)localObject2).size() == 0));
          localObject2 = ((Set)localObject2).iterator();
        }
        bool = isDomainMatch((String)((Iterator)localObject2).next(), paramString2);
      } while (!bool);
      return false;
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("QzoneAuthorizeConfig", 1, "hasJsApiRight()", paramString1);
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QzoneAuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */