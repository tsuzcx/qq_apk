package com.tencent.sonic.sdk;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class SonicUtils
{
  public static final String DEFAULT_CHARSET = Charset.defaultCharset().name();
  private static final String SONIC_CLEAR_CACHE_TIME = "check_and_clear_cache_time";
  private static final String SONIC_TAG_DIFF_BEGIN = "<!--wnsdiff-";
  private static final String SONIC_TAG_DIFF_END = "-->";
  private static final String SONIC_TAG_KEY_BEGIN = "{";
  private static final String SONIC_TAG_KEY_END = "}";
  private static final String SONIC_TAG_PATTERN = "<!--wnsdiff-?(\\w*)-->([\\s\\S]+?)<!--wnsdiff-?(\\w*)-end-->";
  private static final String SONIC_TAG_TITLE_CLOSE = "</title>";
  private static final String SONIC_TAG_TITLE_KEY = "{title}";
  private static final String SONIC_TAG_TITLE_OPEN = "<title>";
  private static final String TAG = "SonicSdk_SonicUtils";
  private static final char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  static String addSonicUrlParam(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder;
    int j;
    int i;
    String str1;
    String str2;
    int m;
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder = new StringBuilder(paramString1);
      j = localStringBuilder.lastIndexOf("/");
      i = j;
      if (j < 0) {
        i = 0;
      }
      str1 = "&" + paramString2 + "=";
      str2 = "?" + paramString2 + "=";
      m = str1.length();
    }
    for (;;)
    {
      try
      {
        int k = localStringBuilder.indexOf(str1, i);
        j = k;
        if (-1 == k) {
          j = localStringBuilder.indexOf(str2, i);
        }
        if (j <= 0) {
          break;
        }
        k = localStringBuilder.indexOf("&", j + m);
        if (k > 0)
        {
          localStringBuilder.replace(j + 1, k + 1, "");
          continue;
          return paramString1;
        }
      }
      catch (Throwable paramString2)
      {
        log("SonicSdk_SonicUtils", 6, "addSonicUrlParam error:" + paramString2.getMessage());
      }
      localStringBuilder.replace(j, localStringBuilder.length(), "");
    }
    if (-1 != localStringBuilder.indexOf("?")) {
      localStringBuilder.append("&").append(paramString2).append("=").append(paramString3);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("?").append(paramString2).append("=").append(paramString3);
    }
  }
  
  static String addTagInfo(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localStringBuilder.append("<script> var _WebSoLocalTime=").append(paramString2).append(";</script>");
      localStringBuilder.append("<script> var _WebSoNetTime=").append(paramString3).append(";</script>");
      if (shouldLog(3)) {
        log("SonicSdk_SonicUtils", 3, "add _WebSoLocalTime=" + paramString2 + ", add _WebSoNetTime=" + paramString3);
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        log("SonicSdk_SonicUtils", 6, "addTagInfo error:" + paramString1.getMessage());
      }
    }
  }
  
  static String buildHtml(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramInt);
    localStringBuilder.append(paramString);
    paramString = paramJSONObject.keys();
    while (paramString.hasNext())
    {
      String str1 = paramString.next().toString();
      String str2 = paramJSONObject.optString(str1);
      paramInt = localStringBuilder.indexOf(str1);
      if (-1 != paramInt) {
        localStringBuilder.replace(paramInt, str1.length() + paramInt, str2);
      }
    }
    return localStringBuilder.toString();
  }
  
  static String buildHtml(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    return buildHtml(paramString1, paramJSONObject, paramString2, paramInt, false);
  }
  
  static String buildHtml(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject = new File(SonicFileUtils.getSonicTemplatePath(paramString1));
    if (((File)localObject).exists())
    {
      localObject = SonicFileUtils.readFile((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramBoolean) {}
        for (paramJSONObject = mergeLocalAndBuildHtml(paramString1, (String)localObject, paramJSONObject, paramInt); (TextUtils.isEmpty(paramString2)) || (paramString2.equalsIgnoreCase(getSHA1(paramJSONObject))); paramJSONObject = buildHtml((String)localObject, paramJSONObject, paramInt)) {
          return paramJSONObject;
        }
        SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicUtils.1(paramString1, paramJSONObject), 0L);
        log("SonicSdk_SonicUtils", 6, "buildHtml error: verify sha1 error.");
        return null;
      }
      log("SonicSdk_SonicUtils", 6, "buildHtml error: template string is empty.");
    }
    for (;;)
    {
      return null;
      log("SonicSdk_SonicUtils", 6, "buildHtml error: template file is not exists.");
    }
  }
  
  static String getCharset(String paramString)
  {
    String str2 = DEFAULT_CHARSET;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      int i = paramString.indexOf("charset");
      str1 = str2;
      if (i != -1)
      {
        paramString = paramString.substring(i).replace(" ", "");
        int j = paramString.indexOf(";");
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
        paramString = paramString.substring(8, i);
        str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = DEFAULT_CHARSET;
        }
      }
    }
    return str1;
  }
  
  static JSONObject getDiffData(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(paramString)));
      if (!TextUtils.isEmpty(paramString)) {}
      for (paramString = getDiffData(new JSONObject(paramString), paramJSONObject);; paramString = paramJSONObject)
      {
        if ((paramString != null) && (paramString.length() > 0)) {
          paramString.put("local_refresh_time", System.currentTimeMillis());
        }
        return paramString;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      log("SonicSdk_SonicUtils", 6, "getDiffData error1:" + paramString.getMessage());
    }
  }
  
  static JSONObject getDiffData(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject;
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        Iterator localIterator = paramJSONObject2.keys();
        for (;;)
        {
          localObject = localJSONObject;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next().toString();
          String str = paramJSONObject2.optString((String)localObject);
          if (!str.equals(paramJSONObject1.optString((String)localObject)))
          {
            localJSONObject.put((String)localObject, str);
            if (shouldLog(3)) {
              log("SonicSdk_SonicUtils", 3, "getDiffData:find diff data, key ->" + (String)localObject + ", length=" + str.length() + ".");
            }
          }
        }
        return null;
      }
      catch (Throwable paramJSONObject1)
      {
        log("SonicSdk_SonicUtils", 6, "getDiffData error2:" + paramJSONObject1.getMessage());
      }
    }
  }
  
  public static HashMap<String, String> getFilteredHeaders(Map<String, List<String>> paramMap)
  {
    localHashMap = new HashMap();
    if (paramMap != null) {
      try
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if ((!"Set-Cookie".equalsIgnoreCase((String)localEntry.getKey())) && (!"Cache-Control".equalsIgnoreCase((String)localEntry.getKey())) && (!"Expires".equalsIgnoreCase((String)localEntry.getKey())) && (!"Etag".equalsIgnoreCase((String)localEntry.getKey())))
          {
            List localList = (List)localEntry.getValue();
            if ((localList != null) && (1 == localList.size())) {
              localHashMap.put(localEntry.getKey(), localList.get(0));
            }
          }
        }
        return localHashMap;
      }
      catch (Throwable paramMap)
      {
        log("SonicSdk_SonicUtils", 6, "getFilteredHeaders error! " + paramMap.getMessage());
      }
    }
  }
  
  public static String getMD5(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.getBytes().length);
      paramString = toHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String getMime(String paramString)
  {
    String str1 = "text/html";
    String str2 = Uri.parse(paramString).getPath();
    if (str2.endsWith(".css")) {
      paramString = "text/css";
    }
    do
    {
      return paramString;
      if (str2.endsWith(".js")) {
        return "application/x-javascript";
      }
      if ((str2.endsWith(".jpg")) || (str2.endsWith(".gif")) || (str2.endsWith(".png")) || (str2.endsWith(".jpeg")) || (str2.endsWith(".webp"))) {
        break;
      }
      paramString = str1;
    } while (!str2.endsWith(".bmp"));
    return "image/*";
  }
  
  static String getSHA1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return getSHA1(paramString.getBytes());
  }
  
  public static String getSHA1(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = toHexString(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return "";
  }
  
  private static void handleCacheControl(Map<String, List<String>> paramMap, SonicDataHelper.SessionData paramSessionData)
  {
    Object localObject;
    if (paramMap.containsKey("Cache-Control".toLowerCase()))
    {
      localObject = (List)paramMap.get("Cache-Control".toLowerCase());
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label260;
      }
      paramMap = ((String)((List)localObject).get(0)).toLowerCase();
      if (!paramMap.contains("max-age")) {
        break label219;
      }
      paramMap = paramMap.substring(paramMap.indexOf("max-age"));
      int j = paramMap.indexOf(",");
      int i = j;
      if (j == -1) {
        i = paramMap.length();
      }
      paramMap = paramMap.substring(8, i);
    }
    label260:
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramMap) * 1000L;
        if (l != 0L) {
          paramSessionData.expiredTime = (l + System.currentTimeMillis());
        }
      }
      catch (Exception paramMap)
      {
        long l;
        log("SonicSdk_SonicUtils", 6, "handleCacheControl:sessionId(" + paramSessionData.sessionId + ") error:" + paramMap.getMessage());
        continue;
      }
      l = System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE;
      if (paramSessionData.expiredTime > l) {
        paramSessionData.expiredTime = l;
      }
      return;
      label219:
      if ((paramMap.contains("private")) || (paramMap.contains("public")))
      {
        paramSessionData.expiredTime = (System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE);
        continue;
        if (paramMap.containsKey("Expires"))
        {
          paramMap = (List)paramMap.get("Expires");
          if ((paramMap != null) && (paramMap.size() > 0))
          {
            paramMap = (String)paramMap.get(0);
            localObject = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
            ((DateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
            try
            {
              paramSessionData.expiredTime = (((DateFormat)localObject).parse(paramMap).getTime() + 28800000L);
            }
            catch (Exception paramMap)
            {
              log("SonicSdk_SonicUtils", 6, "handleCacheControl:sessionId(" + paramSessionData.sessionId + ") error:" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  private static void handleResourceExpireTime(String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    String str = Uri.parse(paramString).getQueryParameter("max-age");
    if (TextUtils.isEmpty(str)) {
      paramResourceData.expiredTime = 9223372036854775807L;
    }
    for (;;)
    {
      return;
      try
      {
        long l = Long.parseLong(str) * 1000L;
        if (l != 0L)
        {
          paramResourceData.expiredTime = (l + System.currentTimeMillis());
          return;
        }
      }
      catch (Exception paramResourceData)
      {
        log("SonicSdk_SonicUtils", 6, "handleResourceExpireTime:resourceUrl(" + paramString + ") error:" + paramResourceData.getMessage());
      }
    }
  }
  
  public static void log(String paramString1, int paramInt, String paramString2)
  {
    SonicEngine.getInstance().getRuntime().log(paramString1, paramInt, paramString2);
  }
  
  static String mergeLocalAndBuildHtml(String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramJSONObject == null)) {
      return null;
    }
    log("SonicSdk_SonicUtils", 6, "sessionId(" + paramString1 + "), mergeLocalAndBuildHtml");
    localStringBuilder = new StringBuilder(paramString2.length() + paramInt);
    paramString1 = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(paramString1)));
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = (String)localObject;
        if (((JSONObject)localObject).has("data")) {
          paramString1 = ((JSONObject)localObject).optJSONObject("data");
        }
        if (paramString1 != null)
        {
          localObject = paramString1.keys();
          while (((Iterator)localObject).hasNext())
          {
            String str = ((Iterator)localObject).next().toString();
            if (!paramJSONObject.has(str)) {
              paramJSONObject.put(str, paramString1.optString(str));
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramString1)
    {
      log("SonicSdk_SonicUtils", 6, "merge local data encounter error, " + paramString1.getMessage());
      localStringBuilder.append(paramString2);
      paramString1 = paramJSONObject.keys();
      while (paramString1.hasNext())
      {
        paramString2 = paramString1.next().toString();
        paramInt = localStringBuilder.indexOf(paramString2);
        if (-1 != paramInt)
        {
          localObject = paramJSONObject.optString(paramString2);
          localStringBuilder.replace(paramInt, paramString2.length() + paramInt, (String)localObject);
        }
      }
    }
  }
  
  static boolean needRefreshPage(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("false".equals(paramString)) || ("true".equals(paramString)));
  }
  
  static boolean needSaveData(boolean paramBoolean, String paramString, Map<String, List<String>> paramMap)
  {
    boolean bool1;
    boolean bool2;
    if ((!TextUtils.isEmpty(paramString)) && (("store".equals(paramString)) || ("true".equals(paramString))))
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramBoolean)
        {
          paramString = (List)paramMap.get("Cache-Control".toLowerCase());
          if (!paramMap.containsKey("Cache-Control")) {
            break label147;
          }
          bool2 = bool1;
          if (paramString != null)
          {
            bool2 = bool1;
            if (paramString.size() > 0)
            {
              paramString = ((String)paramString.get(0)).toLowerCase();
              if ((!paramString.contains("no-cache")) && (!paramString.contains("no-store")) && (!paramString.contains("must-revalidate"))) {
                break label164;
              }
            }
          }
        }
      }
    }
    label147:
    label164:
    for (paramBoolean = false;; paramBoolean = bool1)
    {
      bool2 = paramBoolean;
      do
      {
        return bool2;
        bool1 = false;
        break;
        bool2 = bool1;
      } while (!paramMap.containsKey("Pragma"));
      return false;
    }
  }
  
  static boolean removeAllSessionCache()
  {
    File localFile = new File(SonicFileUtils.getSonicCacheDirPath());
    if (localFile.exists())
    {
      SonicDataHelper.clear();
      SonicChunkDataHelper.clear();
      return SonicFileUtils.deleteAllChildFiles(localFile);
    }
    return false;
  }
  
  public static void removeResourceCache(String paramString)
  {
    SonicResourceDataHelper.removeResourceData(paramString);
    SonicFileUtils.deleteResourceFiles(paramString);
  }
  
  static void removeSessionCache(String paramString)
  {
    SonicDataHelper.removeSessionData(paramString);
    SonicChunkDataHelper.removeChunkData(paramString);
    SonicFileUtils.deleteSonicFiles(paramString);
  }
  
  static void saveClearCacheTime(long paramLong)
  {
    SonicEngine.getInstance().getRuntime().getSonicSharedPreferences().edit().putLong("check_and_clear_cache_time", paramLong).apply();
  }
  
  public static boolean saveResourceFiles(String paramString, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    if ((paramArrayOfByte != null) && (!SonicFileUtils.writeFile(paramArrayOfByte, SonicFileUtils.getSonicResourcePath(paramString))))
    {
      log("SonicSdk_SonicUtils", 6, "saveResourceFiles error: write resource data fail.");
      return false;
    }
    if ((paramMap != null) && (paramMap.size() > 0) && (!SonicFileUtils.writeFile(SonicFileUtils.convertHeadersToString(paramMap), SonicFileUtils.getSonicResourceHeaderPath(paramString))))
    {
      log("SonicSdk_SonicUtils", 6, "saveResourceFiles error: write header file fail.");
      return false;
    }
    return true;
  }
  
  static boolean saveSessionFiles(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, List<String>> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!SonicFileUtils.writeFile(paramString2, SonicFileUtils.getSonicHtmlPath(paramString1))))
    {
      log("SonicSdk_SonicUtils", 6, "saveSessionData error: write html file fail.");
      return false;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!SonicFileUtils.writeFile(paramString3, SonicFileUtils.getSonicTemplatePath(paramString1))))
    {
      log("SonicSdk_SonicUtils", 6, "saveSessionData error: write template file fail.");
      return false;
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!SonicFileUtils.writeFile(paramString4, SonicFileUtils.getSonicDataPath(paramString1))))
    {
      log("SonicSdk_SonicUtils", 6, "saveSessionData error: write data file fail.");
      return false;
    }
    if ((paramMap != null) && (paramMap.size() > 0) && (!SonicFileUtils.writeFile(SonicFileUtils.convertHeadersToString(paramMap), SonicFileUtils.getSonicHeaderPath(paramString1))))
    {
      log("SonicSdk_SonicUtils", 6, "saveSessionData error: write header file fail.");
      return false;
    }
    return true;
  }
  
  @TargetApi(9)
  static void saveSonicData(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, boolean paramBoolean, Map<String, List<String>> paramMap)
  {
    if (shouldLog(4)) {
      log("SonicSdk_SonicUtils", 4, "saveSonicData sessionId = " + paramString1 + ", eTag = " + paramString2 + ", templateTag = " + paramString3 + ",htmlSha1 = " + paramString4 + ", htmlSize = " + paramLong);
    }
    SonicDataHelper.SessionData localSessionData = new SonicDataHelper.SessionData();
    localSessionData.sessionId = paramString1;
    handleCacheControl(paramMap, localSessionData);
    localSessionData.eTag = paramString2;
    localSessionData.templateTag = paramString3;
    localSessionData.htmlSha1 = paramString4;
    localSessionData.htmlSize = paramLong;
    localSessionData.templateUpdateTime = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localSessionData.isRedPointPreload = i;
      SonicDataHelper.saveSessionData(paramString1, localSessionData);
      return;
    }
  }
  
  public static void saveSonicResourceData(String paramString1, String paramString2, long paramLong)
  {
    if (shouldLog(4)) {
      log("SonicSdk_SonicUtils", 4, "saveSonicResourceData resourceUrl = " + paramString1 + ", resourceSha1 = " + paramString2 + ", resourceSize = " + paramLong);
    }
    SonicResourceDataHelper.ResourceData localResourceData = new SonicResourceDataHelper.ResourceData();
    localResourceData.resourceId = getMD5(paramString1);
    localResourceData.resourceSha1 = paramString2;
    localResourceData.resourceSize = paramLong;
    handleResourceExpireTime(paramString1, localResourceData);
    localResourceData.lastUpdateTime = System.currentTimeMillis();
    SonicResourceDataHelper.saveResourceData(localResourceData.resourceId, localResourceData);
  }
  
  static boolean separateTemplateAndData(String paramString1, String paramString2, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder().append("separateTemplateAndData:sessionId(").append(paramString1).append(") start, htmlString = ");
    if (paramString2.length() > 128) {}
    for (Object localObject = paramString2.substring(0, 128);; localObject = paramString2)
    {
      log("SonicSdk_SonicUtils", 4, (String)localObject);
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      try
      {
        Matcher localMatcher = Pattern.compile("<!--wnsdiff-?(\\w*)-->([\\s\\S]+?)<!--wnsdiff-?(\\w*)-end-->", 8).matcher(paramString2);
        while (localMatcher.find())
        {
          String str = localMatcher.group();
          j = "<!--wnsdiff-".length();
          int k = str.indexOf("<!--wnsdiff-");
          int m = str.indexOf("-->");
          localStringBuilder = null;
          localObject = localStringBuilder;
          if (k != -1)
          {
            localObject = localStringBuilder;
            if (k + j < m) {
              localObject = str.substring(k + j, m);
            }
          }
          localObject = "{" + (String)localObject + "}";
          if (shouldLog(3)) {
            log("SonicSdk_SonicUtils", 3, "separateTemplateAndData:sessionId(" + paramString1 + "), key = " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
          {
            localJSONObject.put((String)localObject, str);
            paramStringBuilder1.append(paramString2.substring(i, localMatcher.start()));
            paramStringBuilder1.append((String)localObject);
            i = localMatcher.end();
          }
        }
        if ((i < paramString2.length()) && (paramStringBuilder1.length() > 0)) {
          paramStringBuilder1.append(paramString2.substring(i, paramString2.length()));
        }
        i = paramStringBuilder1.indexOf("<title>");
        int j = paramStringBuilder1.indexOf("</title>", "<title>".length() + i) + "</title>".length();
        if ((i != -1) && (i < j))
        {
          localJSONObject.put("{title}", paramStringBuilder1.substring(i, j));
          paramStringBuilder1.replace(i, j, "{title}");
        }
        paramStringBuilder2.append(localJSONObject.toString());
        log("SonicSdk_SonicUtils", 4, "separateTemplateAndData:sessionId(" + paramString1 + ") end, cost " + (System.currentTimeMillis() - l) + "ms.");
        return true;
      }
      catch (Exception paramString2)
      {
        log("SonicSdk_SonicUtils", 6, "separateTemplateAndData:sessionId(" + paramString1 + ") error:" + paramString2.getMessage());
        return false;
      }
    }
  }
  
  static boolean shouldClearCache(long paramLong)
  {
    long l = SonicEngine.getInstance().getRuntime().getSonicSharedPreferences().getLong("check_and_clear_cache_time", 0L);
    return System.currentTimeMillis() - l > paramLong;
  }
  
  public static boolean shouldLog(int paramInt)
  {
    return SonicEngine.getInstance().getRuntime().shouldLog(paramInt);
  }
  
  private static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(hexChar[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicUtils
 * JD-Core Version:    0.7.0.1
 */