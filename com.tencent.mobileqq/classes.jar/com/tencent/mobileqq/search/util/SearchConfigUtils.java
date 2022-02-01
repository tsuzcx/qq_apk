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
    if (!TextUtils.isEmpty(HuichuanConfigManager.a().b())) {
      localObject1 = HuichuanConfigManager.a().b();
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
      localObject1 = ((String)localObject1).replace("$FROM$", ((StringBuilder)localObject2).toString());
      paramString = (String)localObject1;
      if (SearchUtils.f((String)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(URLEncoder.encode(UniteSearchActivity.i));
        paramString = ((String)localObject1).replace("$SEARCHID$", paramString.toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(URLEncoder.encode(UniteSearchActivity.j));
        paramString = paramString.replace("$SEQNO$", ((StringBuilder)localObject1).toString());
      }
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
      ((StringBuilder)localObject).append(c(paramInt));
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
    //   0: invokestatic 48	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore 4
    //   5: new 22	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 59
    //   18: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 5
    //   24: aload 4
    //   26: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   29: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   32: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: aload 5
    //   40: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_4
    //   44: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 176	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   53: invokevirtual 182	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   56: istore_1
    //   57: new 22	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   64: astore 6
    //   66: aload 6
    //   68: ldc 184
    //   70: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: aload 4
    //   78: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   81: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   84: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: aload 6
    //   92: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: iconst_0
    //   96: invokeinterface 71 3 0
    //   101: istore_2
    //   102: new 22	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   109: astore 6
    //   111: aload 6
    //   113: ldc 186
    //   115: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: iload_1
    //   122: invokevirtual 32	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc 188
    //   130: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: iload_2
    //   137: invokevirtual 32	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 190
    //   143: iconst_1
    //   144: aload 6
    //   146: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iload_1
    //   153: iload_2
    //   154: if_icmpgt +4 -> 158
    //   157: return
    //   158: aload_0
    //   159: getfield 194	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   162: invokevirtual 199	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   165: ifle +621 -> 786
    //   168: aload_0
    //   169: getfield 194	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   172: iconst_0
    //   173: invokevirtual 202	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   176: checkcast 204	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +641 -> 822
    //   184: aload_0
    //   185: getfield 208	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: invokevirtual 211	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   191: iconst_1
    //   192: if_icmpne +61 -> 253
    //   195: aload_0
    //   196: getfield 215	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 220	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 226	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   205: invokestatic 231	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   208: astore_0
    //   209: aload_0
    //   210: ifnull +30 -> 240
    //   213: new 97	java/lang/String
    //   216: dup
    //   217: aload_0
    //   218: ldc 233
    //   220: invokespecial 236	java/lang/String:<init>	([BLjava/lang/String;)V
    //   223: astore_0
    //   224: goto +40 -> 264
    //   227: astore_0
    //   228: ldc 190
    //   230: iconst_1
    //   231: ldc 238
    //   233: aload_0
    //   234: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto +11 -> 248
    //   240: ldc 190
    //   242: iconst_1
    //   243: ldc 243
    //   245: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aconst_null
    //   249: astore_0
    //   250: goto +14 -> 264
    //   253: aload_0
    //   254: getfield 215	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   257: invokevirtual 220	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   260: invokevirtual 246	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   263: astore_0
    //   264: new 22	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   271: astore 6
    //   273: aload 6
    //   275: ldc 248
    //   277: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 6
    //   283: aload_0
    //   284: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: ldc 190
    //   290: iconst_1
    //   291: aload 6
    //   293: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_0
    //   300: ifnull +522 -> 822
    //   303: aload 5
    //   305: invokeinterface 252 1 0
    //   310: astore 5
    //   312: new 22	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   319: astore 6
    //   321: aload 6
    //   323: ldc 184
    //   325: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 6
    //   331: aload 4
    //   333: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   336: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   339: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 5
    //   345: aload 6
    //   347: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: iload_1
    //   351: invokeinterface 258 3 0
    //   356: pop
    //   357: aload 5
    //   359: invokeinterface 261 1 0
    //   364: pop
    //   365: new 263	org/json/JSONObject
    //   368: dup
    //   369: aload_0
    //   370: invokespecial 266	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   373: astore 9
    //   375: aload 9
    //   377: ldc 65
    //   379: invokevirtual 270	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   382: istore_1
    //   383: aload 9
    //   385: ldc_w 272
    //   388: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore 8
    //   393: aload 9
    //   395: ldc 73
    //   397: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: astore 7
    //   402: aload 9
    //   404: ldc_w 277
    //   407: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore 6
    //   412: aload 9
    //   414: ldc_w 279
    //   417: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore_0
    //   421: new 22	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   428: astore 10
    //   430: aload 10
    //   432: ldc_w 281
    //   435: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 4
    //   441: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   444: astore 11
    //   446: aload 10
    //   448: aload 11
    //   450: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   453: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 10
    //   459: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: astore 10
    //   464: aload 9
    //   466: ldc_w 281
    //   469: invokevirtual 270	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   472: iconst_1
    //   473: if_icmpne +350 -> 823
    //   476: iconst_1
    //   477: istore_3
    //   478: goto +3 -> 481
    //   481: aload 5
    //   483: aload 10
    //   485: iload_3
    //   486: invokeinterface 285 3 0
    //   491: pop
    //   492: new 22	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   499: astore 9
    //   501: aload 9
    //   503: ldc 65
    //   505: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 9
    //   511: aload 4
    //   513: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   516: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   519: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 5
    //   525: aload 9
    //   527: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: iload_1
    //   531: invokeinterface 258 3 0
    //   536: pop
    //   537: aload 8
    //   539: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   542: ifne +50 -> 592
    //   545: new 22	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   552: astore 9
    //   554: aload 9
    //   556: ldc_w 272
    //   559: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 9
    //   565: aload 4
    //   567: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   570: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   573: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 5
    //   579: aload 9
    //   581: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: aload 8
    //   586: invokeinterface 289 3 0
    //   591: pop
    //   592: aload 7
    //   594: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifne +49 -> 646
    //   600: new 22	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   607: astore 8
    //   609: aload 8
    //   611: ldc 73
    //   613: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 8
    //   619: aload 4
    //   621: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   624: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   627: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 5
    //   633: aload 8
    //   635: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: aload 7
    //   640: invokeinterface 289 3 0
    //   645: pop
    //   646: aload 6
    //   648: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: ifne +50 -> 701
    //   654: new 22	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   661: astore 7
    //   663: aload 7
    //   665: ldc_w 277
    //   668: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 7
    //   674: aload 4
    //   676: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   679: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   682: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 5
    //   688: aload 7
    //   690: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: aload 6
    //   695: invokeinterface 289 3 0
    //   700: pop
    //   701: aload_0
    //   702: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   705: ifne +49 -> 754
    //   708: new 22	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   715: astore 6
    //   717: aload 6
    //   719: ldc_w 279
    //   722: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 6
    //   728: aload 4
    //   730: invokevirtual 52	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   733: invokevirtual 57	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   736: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 5
    //   742: aload 6
    //   744: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: aload_0
    //   748: invokeinterface 289 3 0
    //   753: pop
    //   754: aconst_null
    //   755: putstatic 291	com/tencent/mobileqq/search/util/SearchConfigUtils:a	Ljava/lang/String;
    //   758: aload 5
    //   760: invokeinterface 261 1 0
    //   765: pop
    //   766: return
    //   767: astore_0
    //   768: goto +8 -> 776
    //   771: astore_0
    //   772: goto +4 -> 776
    //   775: astore_0
    //   776: ldc 190
    //   778: iconst_1
    //   779: ldc 238
    //   781: aload_0
    //   782: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   785: return
    //   786: new 22	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   793: astore 4
    //   795: aload 4
    //   797: ldc_w 293
    //   800: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload 4
    //   806: aload_0
    //   807: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: ldc 190
    //   813: iconst_1
    //   814: aload 4
    //   816: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: return
    //   823: iconst_0
    //   824: istore_3
    //   825: goto -344 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   56	475	1	i	int
    //   101	54	2	j	int
    //   477	348	3	bool	boolean
    //   3	812	4	localObject1	Object
    //   12	747	5	localObject2	Object
    //   64	679	6	localObject3	Object
    //   400	289	7	localObject4	Object
    //   391	243	8	localObject5	Object
    //   373	207	9	localObject6	Object
    //   428	56	10	localObject7	Object
    //   444	5	11	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   213	224	227	java/lang/Throwable
    //   446	476	767	java/lang/Exception
    //   481	592	767	java/lang/Exception
    //   592	646	767	java/lang/Exception
    //   646	701	767	java/lang/Exception
    //   701	754	767	java/lang/Exception
    //   754	766	767	java/lang/Exception
    //   421	446	771	java/lang/Exception
    //   365	421	775	java/lang/Exception
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
    Object localObject = (SearchHotWordConfBean)QConfigManager.b().b(433);
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
  
  public static int b()
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
      ((StringBuilder)localObject).append(e(paramInt));
      localObject = paramString.replace("from=native_relate_search", ((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = (SearchBusinessConfBean)QConfigManager.b().b(434);
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
    Object localObject = (VerticalSearchConfBean)QConfigManager.b().b(456);
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
    localStringBuilder.append("websearch");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.b().b(456);
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
  
  public static boolean c()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.b().b(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).c();
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
  
  public static String d(int paramInt)
  {
    String str = UniteSearchReportController.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("hotword");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.b().b(456);
    if (localObject != null) {
      localObject = ((VerticalSearchConfBean)localObject).c(paramString);
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
  
  public static boolean d()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.b().b(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).d();
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
  
  public static String e(int paramInt)
  {
    String str = UniteSearchReportController.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("moresearch");
    return localStringBuilder.toString();
  }
  
  public static String e(String paramString)
  {
    Object localObject = (VerticalSearchConfBean)QConfigManager.b().b(456);
    if (localObject != null) {
      localObject = ((VerticalSearchConfBean)localObject).d(paramString);
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
  
  public static boolean e()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.b().b(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).e();
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
  
  public static boolean f()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.b().b(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).f();
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
  
  public static boolean g()
  {
    Object localObject = (SearchRichConfBean)QConfigManager.b().b(432);
    boolean bool;
    if (localObject != null) {
      bool = ((SearchRichConfBean)localObject).g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchConfigUtils
 * JD-Core Version:    0.7.0.1
 */