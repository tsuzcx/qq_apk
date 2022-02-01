package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bkgj;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    //   1: astore 6
    //   3: new 34	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 35	org/json/JSONObject:<init>	()V
    //   10: astore 11
    //   12: aload_1
    //   13: ifnull +356 -> 369
    //   16: aload_1
    //   17: getfield 41	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   20: istore 4
    //   22: aload_1
    //   23: getfield 44	com/tencent/mobileqq/mini/sdk/LaunchParam:shareTicket	Ljava/lang/String;
    //   26: astore 9
    //   28: aload_1
    //   29: getfield 47	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   32: astore 10
    //   34: aload 10
    //   36: astore 7
    //   38: aload 9
    //   40: astore 8
    //   42: iload 4
    //   44: istore_3
    //   45: aload_1
    //   46: getfield 51	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   49: ifnull +23 -> 72
    //   52: aload_1
    //   53: getfield 51	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   56: invokevirtual 57	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   59: astore 6
    //   61: iload 4
    //   63: istore_3
    //   64: aload 9
    //   66: astore 8
    //   68: aload 10
    //   70: astore 7
    //   72: aload 11
    //   74: ldc 58
    //   76: iload_3
    //   77: invokestatic 62	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   80: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 11
    //   86: ldc 68
    //   88: aload_0
    //   89: invokestatic 72	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload 11
    //   98: ldc 77
    //   100: aload_0
    //   101: invokestatic 81	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getQueryJson	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: new 34	org/json/JSONObject
    //   111: dup
    //   112: invokespecial 35	org/json/JSONObject:<init>	()V
    //   115: astore_0
    //   116: aload_0
    //   117: ldc 82
    //   119: aload 8
    //   121: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload 11
    //   127: ldc 84
    //   129: aload_0
    //   130: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: new 34	org/json/JSONObject
    //   137: dup
    //   138: invokespecial 35	org/json/JSONObject:<init>	()V
    //   141: astore_0
    //   142: aload_0
    //   143: ldc 86
    //   145: aload 7
    //   147: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: iload_3
    //   152: sipush 1037
    //   155: if_icmpeq +10 -> 165
    //   158: iload_3
    //   159: sipush 1038
    //   162: if_icmpne +41 -> 203
    //   165: aload_1
    //   166: getfield 89	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   169: astore 7
    //   171: aload 7
    //   173: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +27 -> 203
    //   179: aload 7
    //   181: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   184: ifeq +118 -> 302
    //   187: aload_0
    //   188: ldc 103
    //   190: new 34	org/json/JSONObject
    //   193: dup
    //   194: aload 7
    //   196: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   199: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload_1
    //   204: getfield 109	com/tencent/mobileqq/mini/sdk/LaunchParam:privateExtraData	Ljava/lang/String;
    //   207: astore_1
    //   208: aload_1
    //   209: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifne +25 -> 237
    //   215: aload_1
    //   216: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   219: ifeq +108 -> 327
    //   222: aload_0
    //   223: ldc 110
    //   225: new 34	org/json/JSONObject
    //   228: dup
    //   229: aload_1
    //   230: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   233: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   236: pop
    //   237: aload 11
    //   239: ldc 112
    //   241: aload_0
    //   242: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 11
    //   248: ldc 114
    //   250: aload 6
    //   252: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_2
    //   257: ifnull +42 -> 299
    //   260: aload_2
    //   261: getfield 119	com/tencent/mobileqq/mini/apkg/MiniAppInfo:extendData	Ljava/lang/String;
    //   264: astore_0
    //   265: aload_0
    //   266: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifne +30 -> 299
    //   272: aload_0
    //   273: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   276: istore 5
    //   278: iload 5
    //   280: ifeq +77 -> 357
    //   283: aload 11
    //   285: ldc 120
    //   287: new 34	org/json/JSONObject
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   295: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   298: pop
    //   299: aload 11
    //   301: areturn
    //   302: aload_0
    //   303: ldc 103
    //   305: aload 7
    //   307: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: goto -108 -> 203
    //   314: astore_0
    //   315: ldc 11
    //   317: iconst_1
    //   318: ldc 122
    //   320: aload_0
    //   321: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload 11
    //   326: areturn
    //   327: aload_0
    //   328: ldc 110
    //   330: aload_1
    //   331: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   334: pop
    //   335: goto -98 -> 237
    //   338: astore_0
    //   339: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq -43 -> 299
    //   345: ldc 11
    //   347: iconst_4
    //   348: ldc 134
    //   350: aload_0
    //   351: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: aload 11
    //   356: areturn
    //   357: aload 11
    //   359: ldc 120
    //   361: aload_0
    //   362: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: aload 11
    //   368: areturn
    //   369: aconst_null
    //   370: astore 8
    //   372: sipush 9999
    //   375: istore_3
    //   376: aconst_null
    //   377: astore 7
    //   379: goto -307 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramString	String
    //   0	382	1	paramLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   0	382	2	paramMiniAppInfo	MiniAppInfo
    //   44	332	3	i	int
    //   20	42	4	j	int
    //   276	3	5	bool	boolean
    //   1	250	6	str1	String
    //   36	342	7	str2	String
    //   40	331	8	str3	String
    //   26	39	9	str4	String
    //   32	37	10	str5	String
    //   10	357	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	34	314	java/lang/Throwable
    //   45	61	314	java/lang/Throwable
    //   72	151	314	java/lang/Throwable
    //   165	203	314	java/lang/Throwable
    //   203	237	314	java/lang/Throwable
    //   237	256	314	java/lang/Throwable
    //   260	278	314	java/lang/Throwable
    //   283	299	314	java/lang/Throwable
    //   302	311	314	java/lang/Throwable
    //   327	335	314	java/lang/Throwable
    //   339	354	314	java/lang/Throwable
    //   357	366	314	java/lang/Throwable
    //   283	299	338	org/json/JSONException
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
  
  /* Error */
  public static JSONObject getPageLoadInfo(String paramString1, String paramString2, com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam, MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: new 34	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 35	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 68
    //   13: aload_0
    //   14: invokestatic 72	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload 6
    //   23: ldc 77
    //   25: aload_0
    //   26: invokestatic 81	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getQueryJson	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   29: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload 6
    //   35: ldc 178
    //   37: aload_1
    //   38: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   41: pop
    //   42: ldc 180
    //   44: aload_1
    //   45: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +180 -> 228
    //   51: aload_2
    //   52: ifnull +176 -> 228
    //   55: aload_2
    //   56: getfield 41	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   59: istore 4
    //   61: aload 6
    //   63: ldc 82
    //   65: aload_2
    //   66: getfield 44	com/tencent/mobileqq/mini/sdk/LaunchParam:shareTicket	Ljava/lang/String;
    //   69: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: new 34	org/json/JSONObject
    //   76: dup
    //   77: invokespecial 35	org/json/JSONObject:<init>	()V
    //   80: astore_0
    //   81: aload_0
    //   82: ldc 86
    //   84: aload_2
    //   85: getfield 47	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   88: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: iload 4
    //   94: sipush 1037
    //   97: if_icmpeq +11 -> 108
    //   100: iload 4
    //   102: sipush 1038
    //   105: if_icmpne +37 -> 142
    //   108: aload_2
    //   109: getfield 89	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +25 -> 142
    //   120: aload_1
    //   121: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   124: ifeq +107 -> 231
    //   127: aload_0
    //   128: ldc 103
    //   130: new 34	org/json/JSONObject
    //   133: dup
    //   134: aload_1
    //   135: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload 6
    //   144: ldc 112
    //   146: aload_0
    //   147: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_2
    //   152: getfield 109	com/tencent/mobileqq/mini/sdk/LaunchParam:privateExtraData	Ljava/lang/String;
    //   155: astore_1
    //   156: aload_1
    //   157: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne +25 -> 185
    //   163: aload_1
    //   164: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   167: ifeq +88 -> 255
    //   170: aload_0
    //   171: ldc 110
    //   173: new 34	org/json/JSONObject
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   181: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   184: pop
    //   185: aload_3
    //   186: ifnull +42 -> 228
    //   189: aload_3
    //   190: getfield 119	com/tencent/mobileqq/mini/apkg/MiniAppInfo:extendData	Ljava/lang/String;
    //   193: astore_0
    //   194: aload_0
    //   195: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +30 -> 228
    //   201: aload_0
    //   202: invokestatic 101	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   205: istore 5
    //   207: iload 5
    //   209: ifeq +76 -> 285
    //   212: aload 6
    //   214: ldc 120
    //   216: new 34	org/json/JSONObject
    //   219: dup
    //   220: aload_0
    //   221: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   224: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 6
    //   230: areturn
    //   231: aload_0
    //   232: ldc 103
    //   234: aload_1
    //   235: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: goto -97 -> 142
    //   242: astore_0
    //   243: ldc 11
    //   245: iconst_1
    //   246: ldc 185
    //   248: aload_0
    //   249: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload 6
    //   254: areturn
    //   255: aload_0
    //   256: ldc 110
    //   258: aload_1
    //   259: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: goto -78 -> 185
    //   266: astore_0
    //   267: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -42 -> 228
    //   273: ldc 11
    //   275: iconst_4
    //   276: ldc 134
    //   278: aload_0
    //   279: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 6
    //   284: areturn
    //   285: aload 6
    //   287: ldc 120
    //   289: aload_0
    //   290: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   293: pop
    //   294: aload 6
    //   296: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramString1	String
    //   0	297	1	paramString2	String
    //   0	297	2	paramLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   0	297	3	paramMiniAppInfo	MiniAppInfo
    //   59	47	4	i	int
    //   205	3	5	bool	boolean
    //   7	288	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	51	242	java/lang/Throwable
    //   55	92	242	java/lang/Throwable
    //   108	142	242	java/lang/Throwable
    //   142	185	242	java/lang/Throwable
    //   189	207	242	java/lang/Throwable
    //   212	228	242	java/lang/Throwable
    //   231	239	242	java/lang/Throwable
    //   255	263	242	java/lang/Throwable
    //   267	282	242	java/lang/Throwable
    //   285	294	242	java/lang/Throwable
    //   212	228	266	org/json/JSONException
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
    return bkgj.a(localStringBuilder.toString());
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