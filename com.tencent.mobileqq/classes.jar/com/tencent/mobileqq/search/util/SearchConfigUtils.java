package com.tencent.mobileqq.search.util;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.search.SearchBusinessConfBean;
import com.tencent.mobileqq.config.business.search.SearchHotWordConfBean;
import com.tencent.mobileqq.config.business.search.SearchRichConfBean;
import com.tencent.mobileqq.config.business.search.VerticalSearchConfBean;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

public class SearchConfigUtils
{
  public static String a;
  
  public static int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SearchConfigUtils_Switch");
    ((StringBuilder)localObject).append(localBaseApplicationImpl.getRuntime().getAccount());
    localObject = localBaseApplicationImpl.getSharedPreferences(((StringBuilder)localObject).toString(), 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_url_config_version");
    localStringBuilder.append(localBaseApplicationImpl.getRuntime().getAccount());
    return ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
  }
  
  public static String a(int paramInt)
  {
    String str = UniteSearchReportController.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("websearch");
    return localStringBuilder.toString();
  }
  
  @NonNull
  public static String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNetSearchJumpUrl()  source=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    String str = ((BaseApplicationImpl)localObject2).getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchConfigUtils_Switch");
    localStringBuilder.append(((BaseApplicationImpl)localObject2).getRuntime().getAccount());
    localObject2 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("kFTSEnhanceOnlyNetSearchJumpToWeb");
    localStringBuilder.append(str);
    int i = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 1);
    if (i == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb");
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject1).toString(), "");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramInt);
      localObject1 = ((String)localObject1).replace("$SOURCE$", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(URLEncoder.encode(paramString));
      paramString = ((String)localObject1).replace("$FROM$", ((StringBuilder)localObject2).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(URLEncoder.encode(UniteSearchActivity.c));
      paramString = paramString.replace("$SEARCHID$", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(URLEncoder.encode(UniteSearchActivity.d));
      paramString = paramString.replace("$SEQNO$", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = "https://so.html5.qq.com/page/real/kd_result?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&q=$KEYWORD$&from=$FROM$".replace("$SOURCE$", ((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(URLEncoder.encode(paramString));
      paramString = ((String)localObject1).replace("$FROM$", ((StringBuilder)localObject2).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSearchEnhanceEnable() uin=");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" resultUrl=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" enhanceEnableForJumpToWeb=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject1).toString());
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.a().a(456);
    if (localObject != null) {
      localObject = ((VerticalSearchConfBean)localObject).a(paramString);
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVerticalSerachSwitchOn. bizType = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("， result = ");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.contains("from=native_relate_search"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("from=");
      ((StringBuilder)localObject).append(a(paramInt));
      localObject = paramString.replace("from=native_relate_search", ((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetSearchJumpUrl()  word=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  source=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return a(paramInt, paramString2).replace("$KEYWORD$", Uri.encode(paramString1));
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetSearchJumpUrl()  word=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("  source=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.replace("$KEYWORD$", Uri.encode(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(paramInt);
      paramString1 = paramString1.replace("$SOURCE$", paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(URLEncoder.encode(paramString3));
      paramString1 = paramString1.replace("$FROM$", paramString2.toString());
    }
    else
    {
      paramString1 = "https://so.html5.qq.com/page/real/kd_result?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&q=$KEYWORD$&from=$FROM$".replace("$KEYWORD$", Uri.encode(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(paramInt);
      paramString1 = paramString1.replace("$SOURCE$", paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(URLEncoder.encode(paramString3));
      paramString1 = paramString1.replace("$FROM$", paramString2.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getNetSearchJumpUrlWithUrl ");
      paramString2.append(paramString1);
      QLog.i("Q.uniteSearch.SearchConfigUtils", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore 4
    //   5: new 21	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 24
    //   18: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 5
    //   24: aload 4
    //   26: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   29: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   32: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: aload 5
    //   40: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_4
    //   44: invokevirtual 45	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 187	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   53: invokevirtual 192	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   56: istore_1
    //   57: new 21	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   64: astore 6
    //   66: aload 6
    //   68: ldc 47
    //   70: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: aload 4
    //   78: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   81: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   84: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: aload 6
    //   92: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: iconst_0
    //   96: invokeinterface 53 3 0
    //   101: istore_2
    //   102: new 21	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   109: astore 6
    //   111: aload 6
    //   113: ldc 194
    //   115: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: iload_1
    //   122: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc 196
    //   130: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: iload_2
    //   137: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 198
    //   143: iconst_1
    //   144: aload 6
    //   146: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iload_1
    //   153: iload_2
    //   154: if_icmpgt +4 -> 158
    //   157: return
    //   158: aload_0
    //   159: getfield 202	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   162: invokevirtual 207	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   165: ifle +622 -> 787
    //   168: aload_0
    //   169: getfield 202	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   172: iconst_0
    //   173: invokevirtual 210	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   176: checkcast 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +642 -> 823
    //   184: aload_0
    //   185: getfield 216	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   191: iconst_1
    //   192: if_icmpne +61 -> 253
    //   195: aload_0
    //   196: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 228	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 234	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   205: invokestatic 239	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   208: astore_0
    //   209: aload_0
    //   210: ifnull +30 -> 240
    //   213: new 101	java/lang/String
    //   216: dup
    //   217: aload_0
    //   218: ldc 241
    //   220: invokespecial 244	java/lang/String:<init>	([BLjava/lang/String;)V
    //   223: astore_0
    //   224: goto +40 -> 264
    //   227: astore_0
    //   228: ldc 198
    //   230: iconst_1
    //   231: ldc 246
    //   233: aload_0
    //   234: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto +11 -> 248
    //   240: ldc 198
    //   242: iconst_1
    //   243: ldc 251
    //   245: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aconst_null
    //   249: astore_0
    //   250: goto +14 -> 264
    //   253: aload_0
    //   254: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   257: invokevirtual 228	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   260: invokevirtual 254	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   263: astore_0
    //   264: new 21	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   271: astore 6
    //   273: aload 6
    //   275: ldc_w 256
    //   278: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 6
    //   284: aload_0
    //   285: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: ldc 198
    //   291: iconst_1
    //   292: aload 6
    //   294: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: ifnull +522 -> 823
    //   304: aload 5
    //   306: invokeinterface 260 1 0
    //   311: astore 5
    //   313: new 21	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   320: astore 6
    //   322: aload 6
    //   324: ldc 47
    //   326: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 6
    //   332: aload 4
    //   334: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   337: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   340: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 5
    //   346: aload 6
    //   348: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: iload_1
    //   352: invokeinterface 266 3 0
    //   357: pop
    //   358: aload 5
    //   360: invokeinterface 269 1 0
    //   365: pop
    //   366: new 271	org/json/JSONObject
    //   369: dup
    //   370: aload_0
    //   371: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   374: astore 9
    //   376: aload 9
    //   378: ldc 83
    //   380: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   383: istore_1
    //   384: aload 9
    //   386: ldc_w 280
    //   389: invokevirtual 283	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore 8
    //   394: aload 9
    //   396: ldc 85
    //   398: invokevirtual 283	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 7
    //   403: aload 9
    //   405: ldc_w 285
    //   408: invokevirtual 283	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 6
    //   413: aload 9
    //   415: ldc_w 287
    //   418: invokevirtual 283	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   421: astore_0
    //   422: new 21	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   429: astore 10
    //   431: aload 10
    //   433: ldc_w 289
    //   436: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 4
    //   442: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   445: astore 11
    //   447: aload 10
    //   449: aload 11
    //   451: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   454: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 10
    //   460: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: astore 10
    //   465: aload 9
    //   467: ldc_w 289
    //   470: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   473: iconst_1
    //   474: if_icmpne +350 -> 824
    //   477: iconst_1
    //   478: istore_3
    //   479: goto +3 -> 482
    //   482: aload 5
    //   484: aload 10
    //   486: iload_3
    //   487: invokeinterface 293 3 0
    //   492: pop
    //   493: new 21	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   500: astore 9
    //   502: aload 9
    //   504: ldc 83
    //   506: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 9
    //   512: aload 4
    //   514: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   517: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   520: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 5
    //   526: aload 9
    //   528: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: iload_1
    //   532: invokeinterface 266 3 0
    //   537: pop
    //   538: aload 8
    //   540: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne +50 -> 593
    //   546: new 21	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   553: astore 9
    //   555: aload 9
    //   557: ldc_w 280
    //   560: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 9
    //   566: aload 4
    //   568: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   571: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   574: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 5
    //   580: aload 9
    //   582: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: aload 8
    //   587: invokeinterface 297 3 0
    //   592: pop
    //   593: aload 7
    //   595: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   598: ifne +49 -> 647
    //   601: new 21	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   608: astore 8
    //   610: aload 8
    //   612: ldc 85
    //   614: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 8
    //   620: aload 4
    //   622: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   625: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   628: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 5
    //   634: aload 8
    //   636: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: aload 7
    //   641: invokeinterface 297 3 0
    //   646: pop
    //   647: aload 6
    //   649: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   652: ifne +50 -> 702
    //   655: new 21	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   662: astore 7
    //   664: aload 7
    //   666: ldc_w 285
    //   669: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload 7
    //   675: aload 4
    //   677: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   680: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   683: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 5
    //   689: aload 7
    //   691: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aload 6
    //   696: invokeinterface 297 3 0
    //   701: pop
    //   702: aload_0
    //   703: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   706: ifne +49 -> 755
    //   709: new 21	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   716: astore 6
    //   718: aload 6
    //   720: ldc_w 287
    //   723: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 6
    //   729: aload 4
    //   731: invokevirtual 32	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   734: invokevirtual 38	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   737: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 5
    //   743: aload 6
    //   745: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: aload_0
    //   749: invokeinterface 297 3 0
    //   754: pop
    //   755: aconst_null
    //   756: putstatic 299	com/tencent/mobileqq/search/util/SearchConfigUtils:a	Ljava/lang/String;
    //   759: aload 5
    //   761: invokeinterface 269 1 0
    //   766: pop
    //   767: return
    //   768: astore_0
    //   769: goto +8 -> 777
    //   772: astore_0
    //   773: goto +4 -> 777
    //   776: astore_0
    //   777: ldc 198
    //   779: iconst_1
    //   780: ldc 246
    //   782: aload_0
    //   783: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   786: return
    //   787: new 21	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   794: astore 4
    //   796: aload 4
    //   798: ldc_w 301
    //   801: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 4
    //   807: aload_0
    //   808: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: ldc 198
    //   814: iconst_1
    //   815: aload 4
    //   817: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: return
    //   824: iconst_0
    //   825: istore_3
    //   826: goto -344 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   56	476	1	i	int
    //   101	54	2	j	int
    //   478	348	3	bool	boolean
    //   3	813	4	localObject1	Object
    //   12	748	5	localObject2	Object
    //   64	680	6	localObject3	Object
    //   401	289	7	localObject4	Object
    //   392	243	8	localObject5	Object
    //   374	207	9	localObject6	Object
    //   429	56	10	localObject7	Object
    //   445	5	11	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   213	224	227	java/lang/Throwable
    //   447	477	768	java/lang/Exception
    //   482	593	768	java/lang/Exception
    //   593	647	768	java/lang/Exception
    //   647	702	768	java/lang/Exception
    //   702	755	768	java/lang/Exception
    //   755	767	768	java/lang/Exception
    //   422	447	772	java/lang/Exception
    //   366	422	776	java/lang/Exception
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchConfigUtils_Switch");
    localStringBuilder.append(str);
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("kFTSDynamicTabSearchBarDontShow");
    localStringBuilder.append(str);
    return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false) ^ true;
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = (SearchHotWordConfBean)QConfigManager.a().a(433);
    if (localObject != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            bool = ((SearchHotWordConfBean)localObject).c();
            break label61;
          }
        }
        else
        {
          bool = ((SearchHotWordConfBean)localObject).b();
          break label61;
        }
      }
      else
      {
        bool = ((SearchHotWordConfBean)localObject).a();
        break label61;
      }
    }
    boolean bool = false;
    label61:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isHotWordSwitchOn. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    BaseApplicationImpl.getContext();
    Object localObject1;
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = paramString;
    } else {
      localObject1 = "";
    }
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchConfigUtils_Switch");
    localStringBuilder.append(((BaseApplicationImpl)localObject2).getRuntime().getAccount());
    localObject2 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_enhance_switch");
    localStringBuilder.append((String)localObject1);
    int i = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSearchEnhanceEnable() uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" enhanceSwitch=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject1).toString());
    }
    return i == 1;
  }
  
  public static String b(int paramInt)
  {
    String str = UniteSearchReportController.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("hotword");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.a().a(456);
    if (localObject != null) {
      localObject = ((VerticalSearchConfBean)localObject).b(paramString);
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVerticalSerachSwitchOn. bizType = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("， result = ");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.contains("from=native_relate_search"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("from=");
      ((StringBuilder)localObject).append(c(paramInt));
      localObject = paramString.replace("from=native_relate_search", ((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  public static boolean b()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.a().a(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).b();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bEnableFtsSearch. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = (SearchBusinessConfBean)QConfigManager.a().a(434);
    if (localObject != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 21)
          {
            bool = ((SearchBusinessConfBean)localObject).c();
            break label62;
          }
        }
        else
        {
          bool = ((SearchBusinessConfBean)localObject).b();
          break label62;
        }
      }
      else
      {
        bool = ((SearchBusinessConfBean)localObject).a();
        break label62;
      }
    }
    boolean bool = false;
    label62:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isBusinessSwitchOn. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.a().a(456);
    boolean bool;
    if (localObject != null) {
      bool = ((VerticalSearchConfBean)localObject).a(paramString);
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isVerticalSerachSwitchOn. bizType = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("， result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static String c(int paramInt)
  {
    String str = UniteSearchReportController.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("moresearch");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.a().a(456);
    if (localObject != null) {
      localObject = ((VerticalSearchConfBean)localObject).c(paramString);
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VerticalSearchName. bizType = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("， result = ");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static boolean c()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.a().a(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).c();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bEnableFtsTroop. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean d()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.a().a(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).d();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bEnableFtsFilter. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean e()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.a().a(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).e();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bEnableFtsMsgSearch. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean f()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.a().a(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).f();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bShowMsgSearch. ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchConfigUtils
 * JD-Core Version:    0.7.0.1
 */