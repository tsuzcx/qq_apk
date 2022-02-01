package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.qphone.base.util.QLog;

public class SearchEntryConfigManager
{
  public static int a;
  public static String a;
  public static boolean a;
  public static String b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "";
    b = "Hot_word";
    jdField_a_of_type_Int = 8;
  }
  
  public static int a()
  {
    return 1;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("search_net_config_version_code" + paramString + AppSetting.f(), -1);
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
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_net_search_function_title" + str, HardCodeUtil.a(2131713580));
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
      paramContext.putInt("search_net_config_version_code" + paramString + AppSetting.f(), paramInt);
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
    //   1: invokestatic 41	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: invokeinterface 104 1 0
    //   9: astore 9
    //   11: aload_2
    //   12: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +651 -> 666
    //   18: aload_2
    //   19: astore 8
    //   21: aload_1
    //   22: getfield 125	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   25: ifnull +634 -> 659
    //   28: aload_1
    //   29: getfield 125	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   32: invokevirtual 130	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   35: ifle +624 -> 659
    //   38: aload_1
    //   39: getfield 125	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   42: iconst_0
    //   43: invokevirtual 134	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   46: checkcast 136	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +608 -> 659
    //   54: aload_1
    //   55: getfield 140	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 144	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   61: iconst_1
    //   62: if_icmpne +553 -> 615
    //   65: aload_1
    //   66: getfield 148	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   69: invokevirtual 153	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   72: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   75: invokestatic 164	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +516 -> 596
    //   83: new 166	java/lang/String
    //   86: dup
    //   87: aload_1
    //   88: ldc 168
    //   90: invokespecial 171	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_1
    //   94: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +28 -> 125
    //   100: ldc 178
    //   102: iconst_2
    //   103: new 43	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   110: ldc 180
    //   112: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: ifnull +533 -> 659
    //   129: new 186	org/json/JSONObject
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 189	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload_1
    //   139: ldc 191
    //   141: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 10
    //   146: aload_1
    //   147: ldc 197
    //   149: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   152: istore_3
    //   153: aload_1
    //   154: ldc 203
    //   156: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   159: istore 4
    //   161: aload_1
    //   162: ldc 205
    //   164: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   167: istore 5
    //   169: aload_1
    //   170: ldc 207
    //   172: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   175: istore 6
    //   177: aload_1
    //   178: ldc 209
    //   180: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   183: istore 7
    //   185: aload_1
    //   186: ldc 211
    //   188: ldc 212
    //   190: invokestatic 92	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   193: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 11
    //   198: aload 9
    //   200: new 43	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   207: ldc 99
    //   209: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 8
    //   214: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload 10
    //   222: invokeinterface 218 3 0
    //   227: pop
    //   228: aload 9
    //   230: new 43	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   237: ldc 220
    //   239: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload_1
    //   251: ldc 222
    //   253: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokeinterface 218 3 0
    //   261: pop
    //   262: aload 9
    //   264: new 43	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   271: ldc 224
    //   273: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 8
    //   278: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: iload_3
    //   285: invokeinterface 110 3 0
    //   290: pop
    //   291: aload 9
    //   293: new 43	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   300: ldc 226
    //   302: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 8
    //   307: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: iload 4
    //   315: invokeinterface 110 3 0
    //   320: pop
    //   321: aload 9
    //   323: new 43	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   330: ldc 228
    //   332: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: iload 5
    //   345: invokeinterface 110 3 0
    //   350: pop
    //   351: aload 9
    //   353: new 43	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   360: ldc 230
    //   362: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 8
    //   367: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: aload_1
    //   374: ldc 232
    //   376: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   379: invokeinterface 110 3 0
    //   384: pop
    //   385: aload 9
    //   387: new 43	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   394: ldc 234
    //   396: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 8
    //   401: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: aload_1
    //   408: ldc 236
    //   410: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   413: invokeinterface 110 3 0
    //   418: pop
    //   419: aload 9
    //   421: new 43	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   428: ldc 238
    //   430: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 8
    //   435: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: aload_1
    //   442: ldc 240
    //   444: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   447: invokeinterface 110 3 0
    //   452: pop
    //   453: aload 9
    //   455: new 43	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   462: ldc 242
    //   464: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 8
    //   469: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: iload 6
    //   477: invokeinterface 110 3 0
    //   482: pop
    //   483: aload 9
    //   485: new 43	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   492: ldc 244
    //   494: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 8
    //   499: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: iload 7
    //   507: invokeinterface 110 3 0
    //   512: pop
    //   513: aload 9
    //   515: new 43	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   522: ldc 86
    //   524: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 8
    //   529: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: aload 11
    //   537: invokeinterface 218 3 0
    //   542: pop
    //   543: aload 9
    //   545: invokeinterface 114 1 0
    //   550: pop
    //   551: aconst_null
    //   552: putstatic 247	com/tencent/mobileqq/search/util/SearchConfigUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   555: return
    //   556: astore_1
    //   557: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +31 -> 591
    //   563: ldc 178
    //   565: iconst_2
    //   566: new 43	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   573: ldc 249
    //   575: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: invokevirtual 252	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   582: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aconst_null
    //   592: astore_1
    //   593: goto -499 -> 94
    //   596: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq +11 -> 610
    //   602: ldc 178
    //   604: iconst_2
    //   605: ldc 254
    //   607: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aconst_null
    //   611: astore_1
    //   612: goto -518 -> 94
    //   615: aload_1
    //   616: getfield 148	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   619: invokevirtual 153	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   622: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   625: astore_1
    //   626: goto -532 -> 94
    //   629: astore_1
    //   630: ldc 178
    //   632: iconst_2
    //   633: new 43	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 259
    //   643: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload_1
    //   647: invokevirtual 260	java/lang/Exception:toString	()Ljava/lang/String;
    //   650: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aload_0
    //   660: iconst_m1
    //   661: aload_2
    //   662: invokestatic 262	com/tencent/mobileqq/search/SearchEntryConfigManager:a	(Landroid/content/Context;ILjava/lang/String;)V
    //   665: return
    //   666: ldc 15
    //   668: astore 8
    //   670: goto -649 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	paramContext	Context
    //   0	673	1	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   0	673	2	paramString	String
    //   152	133	3	i	int
    //   159	155	4	j	int
    //   167	177	5	k	int
    //   175	301	6	m	int
    //   183	323	7	n	int
    //   19	650	8	str1	String
    //   9	535	9	localEditor	SharedPreferences.Editor
    //   144	77	10	str2	String
    //   196	340	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   83	94	556	java/lang/Throwable
    //   129	555	629	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean2)
    {
      localSharedPreferences.edit().putBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, paramBoolean1).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateNeedRefreshModelList");
      return;
    }
    localSharedPreferences.edit().putBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, paramBoolean1).commit();
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateNeedRefreshModelList");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
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
    paramArrayOfInt = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean)
    {
      paramArrayOfInt.edit().putString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, localStringBuilder.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateModelListByTab");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "setEntryListByTab, result = " + localStringBuilder.toString() + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
      }
      return;
      paramArrayOfInt.edit().putString("search_discovery_sp_prefix_unifypref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, localStringBuilder.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateModelListByTab");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    try
    {
      int i = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("pref_search_light_show_id" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      if (paramInt == 0)
      {
        paramContext.putInt("pref_search_light_show_id" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, i + 1).commit();
        return;
      }
      paramContext.putInt("pref_search_light_show_id" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, paramInt).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "updateShowSearchLightByIDError:" + paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putBoolean(paramQQAppInterface.getCurrentAccountUin() + "QQ_SEARCH_SHOW_HOTLIST", paramBoolean).commit();
    QLog.d("hotwordPreference:", 2, "sethidden:" + paramBoolean + "result:" + bool);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(paramQQAppInterface.getCurrentAccountUin() + "QQ_SEARCH_SHOW_HOTLIST", true);
    QLog.d("hotwordPreference:", 2, "hidden:" + bool);
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean)
    {
      paramBoolean = localSharedPreferences.getBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, true);
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getNeedRefreshModelList");
      return paramBoolean;
    }
    paramBoolean = localSharedPreferences.getBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, true);
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getNeedRefreshModelList");
    return paramBoolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("pref_search_light_show_id" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0) < paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    String[] arrayOfString;
    if (!paramBoolean)
    {
      arrayOfString = ((SharedPreferences)localObject1).getString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, "").split("_");
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getModelListByTab");
    }
    Object localObject2;
    for (;;)
    {
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        try
        {
          int[] arrayOfInt = new int[arrayOfString.length];
          int i = 0;
          for (;;)
          {
            localObject1 = arrayOfInt;
            if (i >= arrayOfString.length) {
              break;
            }
            arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
            i += 1;
          }
          arrayOfString = ((SharedPreferences)localObject1).getString("search_discovery_sp_prefix_unifypref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, "").split("_");
          QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getModelListByTab");
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, NumberFormatException, e = " + localNumberFormatException + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
          }
          localObject2 = null;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, result = " + localObject2 + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  public static int b()
  {
    if (SearchEntryHippyEngine.isHippyOn()) {}
    do
    {
      return 7;
      AladdinConfig localAladdinConfig = Aladdin.getConfig(313);
      if (localAladdinConfig == null) {
        break;
      }
      b = localAladdinConfig.getString("SBWord_Source", "Hot_word");
    } while (TextUtils.equals(b, "Recom_word"));
    return 1;
  }
  
  public static String b()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str2 = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str1 = HardCodeUtil.a(2131718873);
    if (TextUtils.isEmpty(SearchConfigUtils.jdField_a_of_type_JavaLangString))
    {
      if (!SearchConfigUtils.a(((QQAppInterface)localObject).getCurrentAccountUin())) {
        break label184;
      }
      localObject = BaseApplicationImpl.getContext();
      str1 = "";
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2;
      }
      str1 = PreferenceManager.getDefaultSharedPreferences((Context)localObject).getString("fts_search_bar_summary" + str1, "");
      if (!TextUtils.isEmpty(str1)) {
        SearchConfigUtils.jdField_a_of_type_JavaLangString = str1;
      }
    }
    label184:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() searchBarWording=" + str1);
      }
      return str1;
      str1 = HardCodeUtil.a(2131718873);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() cache wording is not null. " + SearchConfigUtils.jdField_a_of_type_JavaLangString);
      }
      str1 = SearchConfigUtils.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchEntryConfigManager
 * JD-Core Version:    0.7.0.1
 */