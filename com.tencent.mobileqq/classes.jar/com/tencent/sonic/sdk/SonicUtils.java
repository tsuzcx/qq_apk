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
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1);
      int j = localStringBuilder.lastIndexOf("/");
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("=");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("=");
      localObject2 = ((StringBuilder)localObject2).toString();
      int m = ((String)localObject1).length();
      try
      {
        for (;;)
        {
          int k = localStringBuilder.indexOf((String)localObject1, i);
          j = k;
          if (-1 == k) {
            j = localStringBuilder.indexOf((String)localObject2, i);
          }
          if (j <= 0) {
            break;
          }
          k = localStringBuilder.indexOf("&", j + m);
          if (k > 0) {
            localStringBuilder.replace(j + 1, k + 1, "");
          } else {
            localStringBuilder.replace(j, localStringBuilder.length(), "");
          }
        }
        if (-1 != localStringBuilder.indexOf("?"))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString3);
        }
        else
        {
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString3);
        }
        return localStringBuilder.toString();
      }
      catch (Throwable paramString2)
      {
        paramString3 = new StringBuilder();
        paramString3.append("addSonicUrlParam error:");
        paramString3.append(paramString2.getMessage());
        log("SonicSdk_SonicUtils", 6, paramString3.toString());
      }
    }
    return paramString1;
  }
  
  static String addTagInfo(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        localStringBuilder.append("<script> var _WebSoLocalTime=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(";</script>");
        localStringBuilder.append("<script> var _WebSoNetTime=");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(";</script>");
        if (shouldLog(3))
        {
          paramString1 = new StringBuilder();
          paramString1.append("add _WebSoLocalTime=");
          paramString1.append(paramString2);
          paramString1.append(", add _WebSoNetTime=");
          paramString1.append(paramString3);
          log("SonicSdk_SonicUtils", 3, paramString1.toString());
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("addTagInfo error:");
        paramString2.append(paramString1.getMessage());
        log("SonicSdk_SonicUtils", 6, paramString2.toString());
      }
    }
    return localStringBuilder.toString();
  }
  
  static String buildHtml(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null))
    {
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
    return null;
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
        if (paramBoolean) {
          paramJSONObject = mergeLocalAndBuildHtml(paramString1, (String)localObject, paramJSONObject, paramInt);
        } else {
          paramJSONObject = buildHtml((String)localObject, paramJSONObject, paramInt);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          if (paramString2.equalsIgnoreCase(getSHA1(paramJSONObject))) {
            return paramJSONObject;
          }
          SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicUtils.1(paramString1, paramJSONObject), 0L);
          log("SonicSdk_SonicUtils", 6, "buildHtml error: verify sha1 error.");
          return null;
        }
        return paramJSONObject;
      }
      log("SonicSdk_SonicUtils", 6, "buildHtml error: template string is empty.");
      return null;
    }
    log("SonicSdk_SonicUtils", 6, "buildHtml error: template file is not exists.");
    return null;
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
        str1 = paramString.substring(8, i);
        paramString = str1;
        if (TextUtils.isEmpty(str1)) {
          paramString = DEFAULT_CHARSET;
        }
        str1 = paramString;
      }
    }
    return str1;
  }
  
  static JSONObject getDiffData(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      localObject = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(paramString)));
      paramString = paramJSONObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = getDiffData(new JSONObject((String)localObject), paramJSONObject);
      }
      paramJSONObject = paramString;
      if (paramString != null)
      {
        paramJSONObject = paramString;
        if (paramString.length() > 0)
        {
          paramString.put("local_refresh_time", System.currentTimeMillis());
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramJSONObject = null;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDiffData error1:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
    }
    return paramJSONObject;
  }
  
  static JSONObject getDiffData(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null)
    {
      if (paramJSONObject2 == null) {
        return null;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        Iterator localIterator = paramJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str1 = localIterator.next().toString();
          String str2 = paramJSONObject2.optString(str1);
          if (!str2.equals(paramJSONObject1.optString(str1)))
          {
            localJSONObject.put(str1, str2);
            if (shouldLog(3))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getDiffData:find diff data, key ->");
              localStringBuilder.append(str1);
              localStringBuilder.append(", length=");
              localStringBuilder.append(str2.length());
              localStringBuilder.append(".");
              log("SonicSdk_SonicUtils", 3, localStringBuilder.toString());
            }
          }
        }
        return localJSONObject;
      }
      catch (Throwable paramJSONObject1)
      {
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append("getDiffData error2:");
        paramJSONObject2.append(paramJSONObject1.getMessage());
        log("SonicSdk_SonicUtils", 6, paramJSONObject2.toString());
      }
    }
    return null;
  }
  
  public static HashMap<String, String> getFilteredHeaders(Map<String, List<String>> paramMap)
  {
    localHashMap = new HashMap();
    if (paramMap != null) {
      try
      {
        paramMap = paramMap.entrySet().iterator();
        Object localObject;
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          if ((!"Set-Cookie".equalsIgnoreCase((String)((Map.Entry)localObject).getKey())) && (!"Cache-Control".equalsIgnoreCase((String)((Map.Entry)localObject).getKey())) && (!"Expires".equalsIgnoreCase((String)((Map.Entry)localObject).getKey())) && (!"Etag".equalsIgnoreCase((String)((Map.Entry)localObject).getKey())))
          {
            List localList = (List)((Map.Entry)localObject).getValue();
            if ((localList != null) && (1 == localList.size())) {
              localHashMap.put(((Map.Entry)localObject).getKey(), localList.get(0));
            }
          }
        }
        return localHashMap;
      }
      catch (Throwable paramMap)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFilteredHeaders error! ");
        ((StringBuilder)localObject).append(paramMap.getMessage());
        log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
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
    paramString = Uri.parse(paramString).getPath();
    if (paramString.endsWith(".css")) {
      return "text/css";
    }
    if (paramString.endsWith(".js")) {
      return "application/x-javascript";
    }
    if ((!paramString.endsWith(".jpg")) && (!paramString.endsWith(".gif")) && (!paramString.endsWith(".png")) && (!paramString.endsWith(".jpeg")) && (!paramString.endsWith(".webp")) && (!paramString.endsWith(".bmp"))) {
      return "text/html";
    }
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
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length <= 0) {
        return "";
      }
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
    return "";
  }
  
  private static void handleCacheControl(Map<String, List<String>> paramMap, SonicDataHelper.SessionData paramSessionData)
  {
    if (paramMap.containsKey("Cache-Control".toLowerCase()))
    {
      Object localObject = (List)paramMap.get("Cache-Control".toLowerCase());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMap = ((String)((List)localObject).get(0)).toLowerCase();
        if (paramMap.contains("max-age"))
        {
          paramMap = paramMap.substring(paramMap.indexOf("max-age"));
          int j = paramMap.indexOf(",");
          int i = j;
          if (j == -1) {
            i = paramMap.length();
          }
          paramMap = paramMap.substring(8, i);
          try
          {
            l = Long.parseLong(paramMap) * 1000L;
            if (l == 0L) {
              break label401;
            }
            paramSessionData.expiredTime = (l + System.currentTimeMillis());
          }
          catch (Exception paramMap)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleCacheControl:sessionId(");
            ((StringBuilder)localObject).append(paramSessionData.sessionId);
            ((StringBuilder)localObject).append(") error:");
            ((StringBuilder)localObject).append(paramMap.getMessage());
            log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
          }
        }
        else if ((paramMap.contains("private")) || (paramMap.contains("public")))
        {
          paramSessionData.expiredTime = (System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE);
        }
      }
      else if (paramMap.containsKey("Expires"))
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
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleCacheControl:sessionId(");
            ((StringBuilder)localObject).append(paramSessionData.sessionId);
            ((StringBuilder)localObject).append(") error:");
            ((StringBuilder)localObject).append(paramMap.getMessage());
            log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
          }
        }
      }
      label401:
      long l = System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE;
      if (paramSessionData.expiredTime > l) {
        paramSessionData.expiredTime = l;
      }
    }
  }
  
  private static void handleResourceExpireTime(String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    Object localObject = Uri.parse(paramString).getQueryParameter("max-age");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramResourceData.expiredTime = 9223372036854775807L;
      return;
    }
    try
    {
      long l = Long.parseLong((String)localObject) * 1000L;
      if (l != 0L)
      {
        paramResourceData.expiredTime = (l + System.currentTimeMillis());
        return;
      }
    }
    catch (Exception paramResourceData)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleResourceExpireTime:resourceUrl(");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(") error:");
      ((StringBuilder)localObject).append(paramResourceData.getMessage());
      log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void log(String paramString1, int paramInt, String paramString2)
  {
    SonicEngine.getInstance().getRuntime().log(paramString1, paramInt, paramString2);
  }
  
  static String mergeLocalAndBuildHtml(String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramJSONObject != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionId(");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("), mergeLocalAndBuildHtml");
      log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder(paramString2.length() + paramInt);
      paramString1 = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(paramString1)));
      try
      {
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
        return null;
      }
      catch (Throwable paramString1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("merge local data encounter error, ");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        log("SonicSdk_SonicUtils", 6, ((StringBuilder)localObject).toString());
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
        return localStringBuilder.toString();
      }
    }
  }
  
  static boolean needRefreshPage(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("false".equals(paramString)) || ("true".equals(paramString)));
  }
  
  static boolean needSaveData(boolean paramBoolean, String paramString, Map<String, List<String>> paramMap)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if ((!bool1) && (("store".equals(paramString)) || ("true".equals(paramString)))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool1) && (paramBoolean))
    {
      paramString = (List)paramMap.get("Cache-Control".toLowerCase());
      if (paramMap.containsKey("Cache-Control"))
      {
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = ((String)paramString.get(0)).toLowerCase();
          paramBoolean = bool2;
          if (paramString.contains("no-cache")) {
            return paramBoolean;
          }
          paramBoolean = bool2;
          if (paramString.contains("no-store")) {
            return paramBoolean;
          }
          if (paramString.contains("must-revalidate")) {
            return false;
          }
        }
      }
      else if (paramMap.containsKey("Pragma")) {
        return false;
      }
    }
    paramBoolean = bool1;
    return paramBoolean;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void saveSonicResourceData(String paramString1, String paramString2, long paramLong)
  {
    if (shouldLog(4))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveSonicResourceData resourceUrl = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", resourceSha1 = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", resourceSize = ");
      ((StringBuilder)localObject).append(paramLong);
      log("SonicSdk_SonicUtils", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SonicResourceDataHelper.ResourceData();
    ((SonicResourceDataHelper.ResourceData)localObject).resourceId = getMD5(paramString1);
    ((SonicResourceDataHelper.ResourceData)localObject).resourceSha1 = paramString2;
    ((SonicResourceDataHelper.ResourceData)localObject).resourceSize = paramLong;
    handleResourceExpireTime(paramString1, (SonicResourceDataHelper.ResourceData)localObject);
    ((SonicResourceDataHelper.ResourceData)localObject).lastUpdateTime = System.currentTimeMillis();
    SonicResourceDataHelper.saveResourceData(((SonicResourceDataHelper.ResourceData)localObject).resourceId, (SonicResourceDataHelper.ResourceData)localObject);
  }
  
  static boolean separateTemplateAndData(String paramString1, String paramString2, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("separateTemplateAndData:sessionId(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(") start, htmlString = ");
    Object localObject;
    if (paramString2.length() > 128) {
      localObject = paramString2.substring(0, 128);
    } else {
      localObject = paramString2;
    }
    localStringBuilder.append((String)localObject);
    log("SonicSdk_SonicUtils", 4, localStringBuilder.toString());
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int j;
      try
      {
        Matcher localMatcher = Pattern.compile("<!--wnsdiff-?(\\w*)-->([\\s\\S]+?)<!--wnsdiff-?(\\w*)-end-->", 8).matcher(paramString2);
        i = 0;
        if (localMatcher.find())
        {
          String str = localMatcher.group();
          int k = str.indexOf("<!--wnsdiff-");
          j = str.indexOf("-->");
          localStringBuilder = null;
          localObject = localStringBuilder;
          if (k != -1)
          {
            k += 12;
            localObject = localStringBuilder;
            if (k < j) {
              localObject = str.substring(k, j);
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("}");
          localObject = localStringBuilder.toString();
          if (shouldLog(3))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("separateTemplateAndData:sessionId(");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("), key = ");
            localStringBuilder.append((String)localObject);
            log("SonicSdk_SonicUtils", 3, localStringBuilder.toString());
          }
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            j = i;
            if (!TextUtils.isEmpty(str))
            {
              localJSONObject.put((String)localObject, str);
              paramStringBuilder1.append(paramString2.substring(i, localMatcher.start()));
              paramStringBuilder1.append((String)localObject);
              j = localMatcher.end();
            }
          }
        }
        else
        {
          if ((i < paramString2.length()) && (paramStringBuilder1.length() > 0)) {
            paramStringBuilder1.append(paramString2.substring(i, paramString2.length()));
          }
          i = paramStringBuilder1.indexOf("<title>");
          j = paramStringBuilder1.indexOf("</title>", i + 7) + 8;
          if ((i != -1) && (i < j))
          {
            localJSONObject.put("{title}", paramStringBuilder1.substring(i, j));
            paramStringBuilder1.replace(i, j, "{title}");
          }
          paramStringBuilder2.append(localJSONObject.toString());
          paramString2 = new StringBuilder();
          paramString2.append("separateTemplateAndData:sessionId(");
          paramString2.append(paramString1);
          paramString2.append(") end, cost ");
          paramString2.append(System.currentTimeMillis() - l);
          paramString2.append("ms.");
          log("SonicSdk_SonicUtils", 4, paramString2.toString());
          return true;
        }
      }
      catch (Exception paramString2)
      {
        paramStringBuilder1 = new StringBuilder();
        paramStringBuilder1.append("separateTemplateAndData:sessionId(");
        paramStringBuilder1.append(paramString1);
        paramStringBuilder1.append(") error:");
        paramStringBuilder1.append(paramString2.getMessage());
        log("SonicSdk_SonicUtils", 6, paramStringBuilder1.toString());
        return false;
      }
      int i = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicUtils
 * JD-Core Version:    0.7.0.1
 */