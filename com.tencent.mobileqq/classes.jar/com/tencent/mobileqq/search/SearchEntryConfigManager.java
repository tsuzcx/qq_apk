package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class SearchEntryConfigManager
{
  public static String a = "";
  public static boolean a;
  
  public static int a()
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("dynamic_need_search_native" + str, 0);
  }
  
  public static int a(int paramInt)
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return localSharedPreferences.getInt("fts_should_show_netsearch_persongroup_tab1" + str, 1);
    case 2: 
      return localSharedPreferences.getInt("fts_should_show_netsearch_persongroup_tab2" + str, 1);
    }
    return localSharedPreferences.getInt("fts_should_show_netsearch_persongroup_tab3" + str, 1);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("search_net_config_version_code" + paramString + AppSetting.c(), -1);
      paramString = "";
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    int i = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString + str, paramInt);
    if (i == 0) {
      return paramInt;
    }
    return i;
  }
  
  public static String a()
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_net_search_function_title" + str, "功能");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("net_search_cell_summary" + paramString, "");
      paramString = "";
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putInt("search_net_config_version_code" + paramString + AppSetting.c(), paramInt);
      paramContext.commit();
      return;
      paramString = "";
    }
  }
  
  /* Error */
  public static void a(Context paramContext, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 44	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: invokeinterface 99 1 0
    //   9: astore 9
    //   11: aload_2
    //   12: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +647 -> 662
    //   18: aload_2
    //   19: astore 8
    //   21: aload_1
    //   22: getfield 120	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   25: ifnull +630 -> 655
    //   28: aload_1
    //   29: getfield 120	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   32: invokevirtual 125	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   35: ifle +620 -> 655
    //   38: aload_1
    //   39: getfield 120	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   42: iconst_0
    //   43: invokevirtual 129	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   46: checkcast 131	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +604 -> 655
    //   54: aload_1
    //   55: getfield 135	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 139	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   61: iconst_1
    //   62: if_icmpne +550 -> 612
    //   65: aload_1
    //   66: getfield 143	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   69: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   72: invokevirtual 154	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   75: invokestatic 159	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +513 -> 593
    //   83: new 161	java/lang/String
    //   86: dup
    //   87: aload_1
    //   88: ldc 163
    //   90: invokespecial 166	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_1
    //   94: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +28 -> 125
    //   100: ldc 173
    //   102: iconst_2
    //   103: new 46	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   110: ldc 175
    //   112: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: ifnull +529 -> 655
    //   129: new 181	org/json/JSONObject
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload_1
    //   139: ldc 186
    //   141: invokevirtual 190	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 10
    //   146: aload_1
    //   147: ldc 192
    //   149: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   152: istore_3
    //   153: aload_1
    //   154: ldc 198
    //   156: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   159: istore 4
    //   161: aload_1
    //   162: ldc 200
    //   164: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   167: istore 5
    //   169: aload_1
    //   170: ldc 202
    //   172: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   175: istore 6
    //   177: aload_1
    //   178: ldc 204
    //   180: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   183: istore 7
    //   185: aload_1
    //   186: ldc 206
    //   188: ldc 87
    //   190: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 11
    //   195: aload 9
    //   197: new 46	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   204: ldc 94
    //   206: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 8
    //   211: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 10
    //   219: invokeinterface 212 3 0
    //   224: pop
    //   225: aload 9
    //   227: new 46	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   234: ldc 214
    //   236: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 8
    //   241: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: aload_1
    //   248: ldc 216
    //   250: invokevirtual 190	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokeinterface 212 3 0
    //   258: pop
    //   259: aload 9
    //   261: new 46	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   268: ldc 218
    //   270: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 8
    //   275: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: iload_3
    //   282: invokeinterface 105 3 0
    //   287: pop
    //   288: aload 9
    //   290: new 46	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   297: ldc 220
    //   299: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 8
    //   304: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: iload 4
    //   312: invokeinterface 105 3 0
    //   317: pop
    //   318: aload 9
    //   320: new 46	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   327: ldc 222
    //   329: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 8
    //   334: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: iload 5
    //   342: invokeinterface 105 3 0
    //   347: pop
    //   348: aload 9
    //   350: new 46	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   357: ldc 65
    //   359: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 8
    //   364: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: aload_1
    //   371: ldc 224
    //   373: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   376: invokeinterface 105 3 0
    //   381: pop
    //   382: aload 9
    //   384: new 46	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   391: ldc 67
    //   393: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 8
    //   398: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: aload_1
    //   405: ldc 226
    //   407: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   410: invokeinterface 105 3 0
    //   415: pop
    //   416: aload 9
    //   418: new 46	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   425: ldc 69
    //   427: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 8
    //   432: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: aload_1
    //   439: ldc 228
    //   441: invokevirtual 196	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   444: invokeinterface 105 3 0
    //   449: pop
    //   450: aload 9
    //   452: new 46	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   459: ldc 49
    //   461: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 8
    //   466: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: iload 6
    //   474: invokeinterface 105 3 0
    //   479: pop
    //   480: aload 9
    //   482: new 46	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   489: ldc 230
    //   491: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 8
    //   496: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: iload 7
    //   504: invokeinterface 105 3 0
    //   509: pop
    //   510: aload 9
    //   512: new 46	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   519: ldc 85
    //   521: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload 8
    //   526: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: aload 11
    //   534: invokeinterface 212 3 0
    //   539: pop
    //   540: aload 9
    //   542: invokeinterface 109 1 0
    //   547: pop
    //   548: aconst_null
    //   549: putstatic 233	com/tencent/mobileqq/search/util/SearchConfigUtils:a	Ljava/lang/String;
    //   552: return
    //   553: astore_1
    //   554: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +31 -> 588
    //   560: ldc 173
    //   562: iconst_2
    //   563: new 46	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   570: ldc 235
    //   572: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: invokevirtual 238	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   579: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aconst_null
    //   589: astore_1
    //   590: goto -496 -> 94
    //   593: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq +11 -> 607
    //   599: ldc 173
    //   601: iconst_2
    //   602: ldc 240
    //   604: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aconst_null
    //   608: astore_1
    //   609: goto -515 -> 94
    //   612: aload_1
    //   613: getfield 143	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   616: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   619: invokevirtual 243	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   622: astore_1
    //   623: goto -529 -> 94
    //   626: astore_1
    //   627: ldc 173
    //   629: iconst_2
    //   630: new 46	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   637: ldc 245
    //   639: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_1
    //   643: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   646: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload_0
    //   656: iconst_m1
    //   657: aload_2
    //   658: invokestatic 248	com/tencent/mobileqq/search/SearchEntryConfigManager:a	(Landroid/content/Context;ILjava/lang/String;)V
    //   661: return
    //   662: ldc 11
    //   664: astore 8
    //   666: goto -645 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	paramContext	Context
    //   0	669	1	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   0	669	2	paramString	String
    //   152	130	3	i	int
    //   159	152	4	j	int
    //   167	174	5	k	int
    //   175	298	6	m	int
    //   183	320	7	n	int
    //   19	646	8	str1	String
    //   9	532	9	localEditor	SharedPreferences.Editor
    //   144	74	10	str2	String
    //   193	340	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   83	94	553	java/lang/Throwable
    //   129	552	626	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, paramBoolean).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length - 1)
      {
        localStringBuilder.append(paramArrayOfInt[i]).append("_");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfInt[(paramArrayOfInt.length - 1)]);
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, localStringBuilder.toString()).commit();
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "setEntryListByTab, result = " + localStringBuilder.toString() + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, true);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String[] arrayOfString = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, "").split("_");
    Object localObject;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      try
      {
        int[] arrayOfInt2 = new int[arrayOfString.length];
        int i = 0;
        for (;;)
        {
          int[] arrayOfInt1 = arrayOfInt2;
          if (i >= arrayOfString.length) {
            break;
          }
          arrayOfInt2[i] = Integer.valueOf(arrayOfString[i]).intValue();
          i += 1;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, NumberFormatException, e = " + localNumberFormatException + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
        }
        localObject = null;
      }
    }
    for (;;)
    {
      QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, result = " + localObject + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
      return localObject;
      localObject = null;
    }
  }
  
  public static String b()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    if (TextUtils.isEmpty(SearchConfigUtils.a))
    {
      if (!SearchConfigUtils.a(((QQAppInterface)localObject).getCurrentAccountUin())) {
        break label174;
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localObject = "";
      if (!TextUtils.isEmpty(str)) {
        localObject = str;
      }
      localObject = PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getString("fts_search_bar_summary" + (String)localObject, "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        SearchConfigUtils.a = (String)localObject;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() searchBarWording=" + (String)localObject);
      }
      return localObject;
      localObject = "搜索";
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() cache wording is not null. " + SearchConfigUtils.a);
      }
      localObject = SearchConfigUtils.a;
      continue;
      label174:
      localObject = "搜索";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchEntryConfigManager
 * JD-Core Version:    0.7.0.1
 */