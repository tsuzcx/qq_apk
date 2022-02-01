package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class AppBrandUtil
{
  public static final String STATUS_BAR_HEIGHT = "status_bar_height";
  public static final String TAG = "AppBrandUtil";
  public static ArrayList<String> sConfigFilter;
  
  public static long currTime()
  {
    return System.currentTimeMillis();
  }
  
  /* Error */
  public static JSONObject getAppLaunchInfo(String paramString, com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam, MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 34	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 35	org/json/JSONObject:<init>	()V
    //   10: astore 10
    //   12: aload_1
    //   13: ifnull +347 -> 360
    //   16: aload_1
    //   17: getfield 41	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   20: istore_3
    //   21: aload_1
    //   22: getfield 44	com/tencent/mobileqq/mini/sdk/LaunchParam:shareTicket	Ljava/lang/String;
    //   25: astore 8
    //   27: aload_1
    //   28: getfield 47	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   31: astore 7
    //   33: aload_1
    //   34: getfield 51	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   37: ifnull +317 -> 354
    //   40: aload_1
    //   41: getfield 51	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   44: invokevirtual 57	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   47: astore 5
    //   49: aload_1
    //   50: getfield 60	com/tencent/mobileqq/mini/sdk/LaunchParam:privateExtraData	Ljava/lang/String;
    //   53: astore 9
    //   55: aload 5
    //   57: astore 6
    //   59: aload 9
    //   61: astore 5
    //   63: aload 10
    //   65: ldc 61
    //   67: iload_3
    //   68: invokestatic 65	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   71: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 10
    //   77: ldc 71
    //   79: aload_0
    //   80: invokestatic 75	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 10
    //   89: ldc 80
    //   91: aload_0
    //   92: invokestatic 84	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getQueryJson	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   95: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: new 34	org/json/JSONObject
    //   102: dup
    //   103: invokespecial 35	org/json/JSONObject:<init>	()V
    //   106: astore_0
    //   107: aload_0
    //   108: ldc 85
    //   110: aload 8
    //   112: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 10
    //   118: ldc 87
    //   120: aload_0
    //   121: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: new 34	org/json/JSONObject
    //   128: dup
    //   129: invokespecial 35	org/json/JSONObject:<init>	()V
    //   132: astore_0
    //   133: aload_0
    //   134: ldc 89
    //   136: aload 7
    //   138: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: iload_3
    //   143: sipush 1037
    //   146: if_icmpeq +10 -> 156
    //   149: iload_3
    //   150: sipush 1038
    //   153: if_icmpne +37 -> 190
    //   156: aload_1
    //   157: getfield 92	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   160: astore_1
    //   161: aload_1
    //   162: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +25 -> 190
    //   168: aload_1
    //   169: invokestatic 104	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   172: ifeq +115 -> 287
    //   175: aload_0
    //   176: ldc 106
    //   178: new 34	org/json/JSONObject
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   186: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   189: pop
    //   190: aload 5
    //   192: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne +27 -> 222
    //   198: aload 5
    //   200: invokestatic 104	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   203: ifeq +108 -> 311
    //   206: aload_0
    //   207: ldc 110
    //   209: new 34	org/json/JSONObject
    //   212: dup
    //   213: aload 5
    //   215: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   218: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: aload 10
    //   224: ldc 112
    //   226: aload_0
    //   227: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 10
    //   233: ldc 114
    //   235: aload 6
    //   237: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: aload_2
    //   242: ifnull +42 -> 284
    //   245: aload_2
    //   246: getfield 119	com/tencent/mobileqq/mini/apkg/MiniAppInfo:extendData	Ljava/lang/String;
    //   249: astore_0
    //   250: aload_0
    //   251: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +30 -> 284
    //   257: aload_0
    //   258: invokestatic 104	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   261: istore 4
    //   263: iload 4
    //   265: ifeq +77 -> 342
    //   268: aload 10
    //   270: ldc 120
    //   272: new 34	org/json/JSONObject
    //   275: dup
    //   276: aload_0
    //   277: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   280: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 10
    //   286: areturn
    //   287: aload_0
    //   288: ldc 106
    //   290: aload_1
    //   291: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: goto -105 -> 190
    //   298: astore_0
    //   299: ldc 11
    //   301: iconst_1
    //   302: ldc 122
    //   304: aload_0
    //   305: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 10
    //   310: areturn
    //   311: aload_0
    //   312: ldc 110
    //   314: aload 5
    //   316: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   319: pop
    //   320: goto -98 -> 222
    //   323: astore_0
    //   324: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -43 -> 284
    //   330: ldc 11
    //   332: iconst_4
    //   333: ldc 134
    //   335: aload_0
    //   336: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload 10
    //   341: areturn
    //   342: aload 10
    //   344: ldc 120
    //   346: aload_0
    //   347: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload 10
    //   353: areturn
    //   354: aconst_null
    //   355: astore 5
    //   357: goto -308 -> 49
    //   360: aconst_null
    //   361: astore 7
    //   363: aconst_null
    //   364: astore 8
    //   366: sipush 9999
    //   369: istore_3
    //   370: aconst_null
    //   371: astore 6
    //   373: goto -310 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramString	String
    //   0	376	1	paramLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   0	376	2	paramMiniAppInfo	MiniAppInfo
    //   20	350	3	i	int
    //   261	3	4	bool	boolean
    //   1	355	5	localObject1	Object
    //   57	315	6	localObject2	Object
    //   31	331	7	str1	String
    //   25	340	8	str2	String
    //   53	7	9	str3	String
    //   10	342	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	49	298	java/lang/Throwable
    //   49	55	298	java/lang/Throwable
    //   63	142	298	java/lang/Throwable
    //   156	190	298	java/lang/Throwable
    //   190	222	298	java/lang/Throwable
    //   222	241	298	java/lang/Throwable
    //   245	263	298	java/lang/Throwable
    //   268	284	298	java/lang/Throwable
    //   287	295	298	java/lang/Throwable
    //   311	320	298	java/lang/Throwable
    //   324	339	298	java/lang/Throwable
    //   342	351	298	java/lang/Throwable
    //   268	284	323	org/json/JSONException
  }
  
  public static ArrayList<String> getConfigFilter()
  {
    if (sConfigFilter == null)
    {
      sConfigFilter = new ArrayList();
      Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppOpenUrlFilter", "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|http://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (localObject2 != null) {
              sConfigFilter.add(localObject2.trim());
            }
            i += 1;
          }
        }
      }
    }
    return sConfigFilter;
  }
  
  public static JSONObject getQueryJson(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = Uri.parse("file:///" + paramString).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (str1.startsWith("$"))
          {
            localObject2 = str1.substring(1);
            localObject1 = "[\\\\?&]" + "\\$";
            String str2 = "";
            localObject2 = Pattern.compile((String)localObject1 + (String)localObject2 + "=([^&#]*)").matcher(paramString);
            localObject1 = str2;
            if (((Matcher)localObject2).find()) {
              localObject1 = ((Matcher)localObject2).group(1);
            }
            localJSONObject.put(str1, localObject1);
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("AppBrandUtil", 1, "getQueryJson err:", paramString);
      }
      Object localObject1 = "[\\\\?&]";
      Object localObject2 = str1;
    }
  }
  
  public static Map<String, Object> getQueryMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = Uri.parse("file:///" + paramString);
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = ((Uri)localObject1).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (!str1.startsWith("$")) {
            break label183;
          }
          localObject2 = str1.substring(1);
          localObject1 = "[\\\\?&]" + "\\$";
          String str2 = "";
          localObject2 = Pattern.compile((String)localObject1 + (String)localObject2 + "=([^&#]*)").matcher(paramString);
          localObject1 = str2;
          if (((Matcher)localObject2).find()) {
            localObject1 = ((Matcher)localObject2).group(1);
          }
          localHashMap.put(str1, localObject1);
        }
        localObject1 = "[\\\\?&]";
      }
      catch (Throwable paramString)
      {
        QLog.e("AppBrandUtil", 1, "getQueryMap err:", paramString);
        return localHashMap;
      }
      finally
      {
        return localHashMap;
      }
      label183:
      Object localObject2 = str1;
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getDimensionPixelSize(j);
    }
    float f3 = paramContext.getDisplayMetrics().density;
    float f2 = f3 / paramContext.getDisplayMetrics().density;
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = 1.0F;
    }
    if (i <= 0) {
      return Math.round(25.0F * f1 * f3);
    }
    return (int)Math.ceil(i * f1 + 0.5F);
  }
  
  public static String getUrlWithoutParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static int getWikiScene(int paramInt)
  {
    String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "configSceneMap", "{}");
    QLog.d("AppBrandUtil", 2, "getWikiScene " + str1 + "  scene:" + paramInt);
    try
    {
      String str2 = new JSONObject(str1).optString(String.valueOf(paramInt));
      int i = paramInt;
      if (!TextUtils.isEmpty(str2)) {
        i = Integer.parseInt(str2);
      }
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("AppBrandUtil", 2, "getWikiScene fail, " + str1 + "  scene:" + paramInt);
    }
    return paramInt;
  }
  
  public static boolean isMainThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static boolean isOpenUrlFilter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = getConfigFilter();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((str != null) && (paramString.toLowerCase().startsWith(str.toLowerCase()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static String jsonObject2HttpParameter(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.optString(str1);
        localStringBuilder.append(str1).append('=').append(str2);
      }
    }
    return URLUtil.a(localStringBuilder.toString());
  }
  
  public static boolean needUpdate(MiniAppInfo paramMiniAppInfo1, MiniAppInfo paramMiniAppInfo2)
  {
    if ((paramMiniAppInfo1 != null) && (paramMiniAppInfo2 != null))
    {
      if ((paramMiniAppInfo1.versionId != null) && (!paramMiniAppInfo1.versionId.equals(paramMiniAppInfo2.versionId)) && (paramMiniAppInfo1.versionUpdateTime > 0) && (paramMiniAppInfo2.versionUpdateTime > paramMiniAppInfo1.versionUpdateTime))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AppBrandUtil", 2, "needUpdate=true oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AppBrandUtil", 2, "needUpdate=false oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
      }
    }
    return false;
  }
  
  public static void parseToJsonMap(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        parseToJsonMap((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static String parseToLocalPath(String paramString)
  {
    String str = Uri.parse("file:///" + paramString).getPath();
    paramString = str;
    if (str != null)
    {
      paramString = str;
      if (str.startsWith("/")) {
        paramString = str.substring(1);
      }
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */