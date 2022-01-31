package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bhsz;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;

public class AppBrandUtil
{
  public static final String STATUS_BAR_HEIGHT = "status_bar_height";
  public static final String TAG = "AppBrandUtil";
  
  public static long currTime()
  {
    return System.currentTimeMillis();
  }
  
  /* Error */
  public static JSONObject getAppLaunchInfo(String paramString, com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam, MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 31	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 32	org/json/JSONObject:<init>	()V
    //   10: astore 11
    //   12: aload_1
    //   13: ifnull +306 -> 319
    //   16: aload_1
    //   17: getfield 38	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   20: istore 4
    //   22: aload_1
    //   23: getfield 41	com/tencent/mobileqq/mini/sdk/LaunchParam:shareTicket	Ljava/lang/String;
    //   26: astore 9
    //   28: aload_1
    //   29: getfield 44	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   32: astore 10
    //   34: aload 10
    //   36: astore 7
    //   38: aload 9
    //   40: astore 8
    //   42: iload 4
    //   44: istore_3
    //   45: aload_1
    //   46: getfield 48	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   49: ifnull +23 -> 72
    //   52: aload_1
    //   53: getfield 48	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   56: invokevirtual 54	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   59: astore 6
    //   61: iload 4
    //   63: istore_3
    //   64: aload 9
    //   66: astore 8
    //   68: aload 10
    //   70: astore 7
    //   72: aload 11
    //   74: ldc 55
    //   76: iload_3
    //   77: invokestatic 59	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   80: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 11
    //   86: ldc 65
    //   88: aload_0
    //   89: invokestatic 69	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload 11
    //   98: ldc 74
    //   100: aload_0
    //   101: invokestatic 78	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getQueryJson	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: new 31	org/json/JSONObject
    //   111: dup
    //   112: invokespecial 32	org/json/JSONObject:<init>	()V
    //   115: astore_0
    //   116: aload_0
    //   117: ldc 79
    //   119: aload 8
    //   121: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload 11
    //   127: ldc 81
    //   129: aload_0
    //   130: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: new 31	org/json/JSONObject
    //   137: dup
    //   138: invokespecial 32	org/json/JSONObject:<init>	()V
    //   141: astore_0
    //   142: aload_0
    //   143: ldc 83
    //   145: aload 7
    //   147: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: iload_3
    //   152: sipush 1037
    //   155: if_icmpeq +10 -> 165
    //   158: iload_3
    //   159: sipush 1038
    //   162: if_icmpne +37 -> 199
    //   165: aload_1
    //   166: getfield 86	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +25 -> 199
    //   177: aload_1
    //   178: invokestatic 98	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   181: ifeq +83 -> 264
    //   184: aload_0
    //   185: ldc 100
    //   187: new 31	org/json/JSONObject
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   195: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload 11
    //   201: ldc 105
    //   203: aload_0
    //   204: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 11
    //   210: ldc 107
    //   212: aload 6
    //   214: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload_2
    //   219: ifnull +42 -> 261
    //   222: aload_2
    //   223: getfield 112	com/tencent/mobileqq/mini/apkg/MiniAppInfo:extendData	Ljava/lang/String;
    //   226: astore_0
    //   227: aload_0
    //   228: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +30 -> 261
    //   234: aload_0
    //   235: invokestatic 98	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   238: istore 5
    //   240: iload 5
    //   242: ifeq +65 -> 307
    //   245: aload 11
    //   247: ldc 113
    //   249: new 31	org/json/JSONObject
    //   252: dup
    //   253: aload_0
    //   254: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   257: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   260: pop
    //   261: aload 11
    //   263: areturn
    //   264: aload_0
    //   265: ldc 100
    //   267: aload_1
    //   268: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   271: pop
    //   272: goto -73 -> 199
    //   275: astore_0
    //   276: ldc 11
    //   278: iconst_1
    //   279: ldc 115
    //   281: aload_0
    //   282: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload 11
    //   287: areturn
    //   288: astore_0
    //   289: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -31 -> 261
    //   295: ldc 11
    //   297: iconst_4
    //   298: ldc 127
    //   300: aload_0
    //   301: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload 11
    //   306: areturn
    //   307: aload 11
    //   309: ldc 113
    //   311: aload_0
    //   312: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   315: pop
    //   316: aload 11
    //   318: areturn
    //   319: aconst_null
    //   320: astore 8
    //   322: sipush 9999
    //   325: istore_3
    //   326: aconst_null
    //   327: astore 7
    //   329: goto -257 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString	String
    //   0	332	1	paramLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   0	332	2	paramMiniAppInfo	MiniAppInfo
    //   44	282	3	i	int
    //   20	42	4	j	int
    //   238	3	5	bool	boolean
    //   1	212	6	str1	String
    //   36	292	7	str2	String
    //   40	281	8	str3	String
    //   26	39	9	str4	String
    //   32	37	10	str5	String
    //   10	307	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	34	275	java/lang/Throwable
    //   45	61	275	java/lang/Throwable
    //   72	151	275	java/lang/Throwable
    //   165	199	275	java/lang/Throwable
    //   199	218	275	java/lang/Throwable
    //   222	240	275	java/lang/Throwable
    //   245	261	275	java/lang/Throwable
    //   264	272	275	java/lang/Throwable
    //   289	304	275	java/lang/Throwable
    //   307	316	275	java/lang/Throwable
    //   245	261	288	org/json/JSONException
  }
  
  /* Error */
  public static JSONObject getPageLoadInfo(String paramString1, String paramString2, com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam, MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: new 31	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 32	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 65
    //   13: aload_0
    //   14: invokestatic 69	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload 6
    //   23: ldc 74
    //   25: aload_0
    //   26: invokestatic 78	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getQueryJson	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   29: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload 6
    //   35: ldc 131
    //   37: aload_1
    //   38: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   41: pop
    //   42: ldc 133
    //   44: aload_1
    //   45: invokevirtual 139	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +146 -> 194
    //   51: aload_2
    //   52: ifnull +142 -> 194
    //   55: aload_2
    //   56: getfield 38	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   59: istore 4
    //   61: aload 6
    //   63: ldc 79
    //   65: aload_2
    //   66: getfield 41	com/tencent/mobileqq/mini/sdk/LaunchParam:shareTicket	Ljava/lang/String;
    //   69: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: new 31	org/json/JSONObject
    //   76: dup
    //   77: invokespecial 32	org/json/JSONObject:<init>	()V
    //   80: astore_0
    //   81: aload_0
    //   82: ldc 83
    //   84: aload_2
    //   85: getfield 44	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   88: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: iload 4
    //   94: sipush 1037
    //   97: if_icmpeq +11 -> 108
    //   100: iload 4
    //   102: sipush 1038
    //   105: if_icmpne +37 -> 142
    //   108: aload_2
    //   109: getfield 86	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +25 -> 142
    //   120: aload_1
    //   121: invokestatic 98	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   124: ifeq +73 -> 197
    //   127: aload_0
    //   128: ldc 100
    //   130: new 31	org/json/JSONObject
    //   133: dup
    //   134: aload_1
    //   135: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload 6
    //   144: ldc 105
    //   146: aload_0
    //   147: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_3
    //   152: ifnull +42 -> 194
    //   155: aload_3
    //   156: getfield 112	com/tencent/mobileqq/mini/apkg/MiniAppInfo:extendData	Ljava/lang/String;
    //   159: astore_0
    //   160: aload_0
    //   161: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +30 -> 194
    //   167: aload_0
    //   168: invokestatic 98	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   171: istore 5
    //   173: iload 5
    //   175: ifeq +65 -> 240
    //   178: aload 6
    //   180: ldc 113
    //   182: new 31	org/json/JSONObject
    //   185: dup
    //   186: aload_0
    //   187: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 6
    //   196: areturn
    //   197: aload_0
    //   198: ldc 100
    //   200: aload_1
    //   201: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   204: pop
    //   205: goto -63 -> 142
    //   208: astore_0
    //   209: ldc 11
    //   211: iconst_1
    //   212: ldc 141
    //   214: aload_0
    //   215: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload 6
    //   220: areturn
    //   221: astore_0
    //   222: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -31 -> 194
    //   228: ldc 11
    //   230: iconst_4
    //   231: ldc 127
    //   233: aload_0
    //   234: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: aload 6
    //   239: areturn
    //   240: aload 6
    //   242: ldc 113
    //   244: aload_0
    //   245: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   248: pop
    //   249: aload 6
    //   251: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramString1	String
    //   0	252	1	paramString2	String
    //   0	252	2	paramLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   0	252	3	paramMiniAppInfo	MiniAppInfo
    //   59	47	4	i	int
    //   171	3	5	bool	boolean
    //   7	243	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	51	208	java/lang/Throwable
    //   55	92	208	java/lang/Throwable
    //   108	142	208	java/lang/Throwable
    //   142	151	208	java/lang/Throwable
    //   155	173	208	java/lang/Throwable
    //   178	194	208	java/lang/Throwable
    //   197	205	208	java/lang/Throwable
    //   222	237	208	java/lang/Throwable
    //   240	249	208	java/lang/Throwable
    //   178	194	221	org/json/JSONException
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
            break label182;
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
      label182:
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
  
  public static String getUrlKeyVal(String paramString1, String paramString2)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        List localList = URLEncodedUtils.parse(new URI(paramString1), "UTF-8");
        localObject1 = localObject2;
        int j = localList.size();
        int i = 0;
        paramString1 = (String)localObject2;
        localObject1 = paramString1;
        if (i < j)
        {
          localObject1 = paramString1;
          localObject2 = (NameValuePair)localList.get(i);
          localObject1 = paramString1;
          if (((NameValuePair)localObject2).getName().equals(paramString2))
          {
            localObject1 = paramString1;
            paramString1 = ((NameValuePair)localObject2).getValue();
            i += 1;
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (URISyntaxException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
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
    return bhsz.a(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */