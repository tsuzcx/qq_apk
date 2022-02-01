package com.tencent.mobileqq.search.base.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchConfigManager
  extends SearchConfig
{
  public static String configSwitch;
  public static String curUin = "";
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 33	com/tencent/common/app/AppInterface:getCurrentUin	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +729 -> 743
    //   17: aload 5
    //   19: getstatic 41	com/tencent/mobileqq/search/base/util/SearchConfigManager:curUin	Ljava/lang/String;
    //   22: invokevirtual 47	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +718 -> 743
    //   28: new 49	java/lang/StringBuilder
    //   31: dup
    //   32: ldc 51
    //   34: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload 5
    //   40: putstatic 41	com/tencent/mobileqq/search/base/util/SearchConfigManager:curUin	Ljava/lang/String;
    //   43: iconst_1
    //   44: putstatic 58	com/tencent/mobileqq/search/base/util/SearchConfigManager:isConfigLoaded	Z
    //   47: iconst_0
    //   48: istore_1
    //   49: iconst_0
    //   50: putstatic 62	com/tencent/mobileqq/search/base/util/SearchConfigManager:voiceSearchSwitch	I
    //   53: getstatic 68	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   56: astore 6
    //   58: new 49	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   65: astore 7
    //   67: aload 7
    //   69: aload 5
    //   71: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 7
    //   77: ldc 75
    //   79: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 7
    //   85: ldc 77
    //   87: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: aload 7
    //   95: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: iconst_0
    //   99: invokevirtual 84	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   102: astore 5
    //   104: aload 5
    //   106: ldc 85
    //   108: ldc 9
    //   110: invokeinterface 91 3 0
    //   115: putstatic 93	com/tencent/mobileqq/search/base/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   118: aload_0
    //   119: ldc 95
    //   121: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_0
    //   126: getstatic 93	com/tencent/mobileqq/search/base/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   129: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 97
    //   135: getstatic 93	com/tencent/mobileqq/search/base/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   138: invokevirtual 47	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifne +23 -> 164
    //   144: invokestatic 99	com/tencent/mobileqq/search/base/util/SearchConfigManager:a	()V
    //   147: invokestatic 104	com/tencent/mobileqq/search/IContactSearchable:m	()V
    //   150: ldc 106
    //   152: iconst_1
    //   153: aload_0
    //   154: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: ldc 2
    //   162: monitorexit
    //   163: return
    //   164: aload 5
    //   166: invokeinterface 116 1 0
    //   171: astore 5
    //   173: aload 5
    //   175: ifnull +293 -> 468
    //   178: aload 5
    //   180: invokeinterface 122 1 0
    //   185: invokeinterface 128 1 0
    //   190: astore 6
    //   192: aload 6
    //   194: invokeinterface 134 1 0
    //   199: ifeq +269 -> 468
    //   202: aload 6
    //   204: invokeinterface 138 1 0
    //   209: checkcast 43	java/lang/String
    //   212: astore 7
    //   214: ldc 2
    //   216: aload 7
    //   218: invokevirtual 144	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   221: astore 9
    //   223: aload 5
    //   225: aload 7
    //   227: invokeinterface 148 2 0
    //   232: checkcast 43	java/lang/String
    //   235: astore 8
    //   237: aload 8
    //   239: ifnull -47 -> 192
    //   242: aload 9
    //   244: invokevirtual 154	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   247: ldc 43
    //   249: if_acmpne +14 -> 263
    //   252: aload 9
    //   254: aconst_null
    //   255: aload 8
    //   257: invokevirtual 158	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   260: goto -68 -> 192
    //   263: aload 9
    //   265: invokevirtual 154	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   268: getstatic 164	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   271: if_acmpne +20 -> 291
    //   274: aload 9
    //   276: aconst_null
    //   277: aload 8
    //   279: invokestatic 168	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   282: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: invokevirtual 158	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   288: goto -96 -> 192
    //   291: aload 9
    //   293: invokevirtual 154	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   296: getstatic 175	java/lang/Long:TYPE	Ljava/lang/Class;
    //   299: if_acmpne -107 -> 192
    //   302: aload 8
    //   304: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   307: lstore_3
    //   308: lload_3
    //   309: lconst_0
    //   310: lcmp
    //   311: ifle +28 -> 339
    //   314: lload_3
    //   315: ldc2_w 180
    //   318: lcmp
    //   319: ifge +20 -> 339
    //   322: aload 9
    //   324: aconst_null
    //   325: aload 8
    //   327: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   330: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   333: invokevirtual 158	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   336: goto -144 -> 192
    //   339: new 49	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   346: astore 9
    //   348: aload 9
    //   350: ldc 186
    //   352: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 9
    //   358: aload 7
    //   360: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 9
    //   366: ldc 188
    //   368: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 9
    //   374: aload 8
    //   376: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_0
    //   381: aload 9
    //   383: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: goto -198 -> 192
    //   393: astore 7
    //   395: ldc 106
    //   397: iconst_1
    //   398: ldc 190
    //   400: aload 7
    //   402: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -213 -> 192
    //   408: astore 7
    //   410: ldc 106
    //   412: iconst_1
    //   413: ldc 190
    //   415: aload 7
    //   417: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: goto -228 -> 192
    //   423: astore 7
    //   425: ldc 106
    //   427: iconst_1
    //   428: ldc 190
    //   430: aload 7
    //   432: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   435: goto -243 -> 192
    //   438: astore 7
    //   440: ldc 106
    //   442: iconst_1
    //   443: ldc 190
    //   445: aload 7
    //   447: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   450: goto -258 -> 192
    //   453: astore 7
    //   455: ldc 106
    //   457: iconst_1
    //   458: ldc 190
    //   460: aload 7
    //   462: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   465: goto -273 -> 192
    //   468: invokestatic 196	com/tencent/mobileqq/search/base/util/SearchConfigManager:b	()V
    //   471: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   474: ldc 202
    //   476: getstatic 205	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderPeople	I
    //   479: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: invokeinterface 209 3 0
    //   487: pop
    //   488: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   491: ldc 211
    //   493: getstatic 214	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderMessage	I
    //   496: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: invokeinterface 209 3 0
    //   504: pop
    //   505: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   508: ldc 216
    //   510: getstatic 214	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderMessage	I
    //   513: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: invokeinterface 209 3 0
    //   521: pop
    //   522: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   525: ldc 218
    //   527: getstatic 221	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderPublicAccount	I
    //   530: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: invokeinterface 209 3 0
    //   538: pop
    //   539: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   542: ldc 223
    //   544: getstatic 226	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderFavorite	I
    //   547: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: invokeinterface 209 3 0
    //   555: pop
    //   556: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   559: ldc 228
    //   561: getstatic 231	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderFile	I
    //   564: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: invokeinterface 209 3 0
    //   572: pop
    //   573: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   576: ldc 233
    //   578: getstatic 236	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderNetSearch	I
    //   581: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: invokeinterface 209 3 0
    //   589: pop
    //   590: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   593: ldc 238
    //   595: getstatic 241	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderFeature	I
    //   598: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   601: invokeinterface 209 3 0
    //   606: pop
    //   607: getstatic 200	com/tencent/mobileqq/search/base/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   610: ldc 243
    //   612: getstatic 246	com/tencent/mobileqq/search/base/util/SearchConfigManager:engineOrderFunction	I
    //   615: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: invokeinterface 209 3 0
    //   623: pop
    //   624: invokestatic 104	com/tencent/mobileqq/search/IContactSearchable:m	()V
    //   627: getstatic 249	com/tencent/mobileqq/search/base/util/SearchConfigManager:troopMemberUpdateConfigStr	Ljava/lang/String;
    //   630: invokestatic 252	com/tencent/mobileqq/search/base/util/SearchConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   633: putstatic 256	com/tencent/mobileqq/search/base/util/SearchConfigManager:troopMemberUpdateConfigs	Ljava/util/ArrayList;
    //   636: aload_0
    //   637: ldc_w 258
    //   640: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: ldc 2
    //   646: invokevirtual 262	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   649: astore 5
    //   651: aload 5
    //   653: arraylength
    //   654: istore_2
    //   655: iload_1
    //   656: iload_2
    //   657: if_icmpge +68 -> 725
    //   660: aload 5
    //   662: iload_1
    //   663: aaload
    //   664: astore 6
    //   666: aload_0
    //   667: aload 6
    //   669: invokevirtual 265	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   672: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_0
    //   677: ldc 188
    //   679: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_0
    //   684: aload 6
    //   686: aconst_null
    //   687: invokevirtual 266	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   690: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: goto +16 -> 710
    //   697: astore 6
    //   699: ldc 106
    //   701: iconst_1
    //   702: ldc_w 271
    //   705: aload 6
    //   707: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   710: aload_0
    //   711: ldc_w 273
    //   714: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: iload_1
    //   719: iconst_1
    //   720: iadd
    //   721: istore_1
    //   722: goto -67 -> 655
    //   725: aload_0
    //   726: ldc_w 275
    //   729: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc 106
    //   735: iconst_1
    //   736: aload_0
    //   737: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: ldc_w 277
    //   746: invokestatic 283	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   749: checkcast 277	com/tencent/mobileqq/search/api/ISearchPieceFetcher
    //   752: invokeinterface 286 1 0
    //   757: goto +30 -> 787
    //   760: astore_0
    //   761: goto +30 -> 791
    //   764: astore_0
    //   765: ldc 106
    //   767: iconst_1
    //   768: ldc 190
    //   770: aload_0
    //   771: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: goto +13 -> 787
    //   777: astore_0
    //   778: ldc 106
    //   780: iconst_1
    //   781: ldc 190
    //   783: aload_0
    //   784: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   787: ldc 2
    //   789: monitorexit
    //   790: return
    //   791: ldc 2
    //   793: monitorexit
    //   794: goto +5 -> 799
    //   797: aload_0
    //   798: athrow
    //   799: goto -2 -> 797
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   48	674	1	i	int
    //   654	4	2	j	int
    //   307	8	3	l	long
    //   7	654	5	localObject1	Object
    //   56	629	6	localObject2	Object
    //   697	9	6	localIllegalAccessException1	java.lang.IllegalAccessException
    //   65	294	7	localObject3	Object
    //   393	8	7	localError	Error
    //   408	8	7	localException	Exception
    //   423	8	7	localNumberFormatException	java.lang.NumberFormatException
    //   438	8	7	localIllegalAccessException2	java.lang.IllegalAccessException
    //   453	8	7	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   235	140	8	str	String
    //   221	161	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   214	237	393	java/lang/Error
    //   242	260	393	java/lang/Error
    //   263	288	393	java/lang/Error
    //   291	308	393	java/lang/Error
    //   322	336	393	java/lang/Error
    //   339	390	393	java/lang/Error
    //   214	237	408	java/lang/Exception
    //   242	260	408	java/lang/Exception
    //   263	288	408	java/lang/Exception
    //   291	308	408	java/lang/Exception
    //   322	336	408	java/lang/Exception
    //   339	390	408	java/lang/Exception
    //   214	237	423	java/lang/NumberFormatException
    //   242	260	423	java/lang/NumberFormatException
    //   263	288	423	java/lang/NumberFormatException
    //   291	308	423	java/lang/NumberFormatException
    //   322	336	423	java/lang/NumberFormatException
    //   339	390	423	java/lang/NumberFormatException
    //   214	237	438	java/lang/IllegalAccessException
    //   242	260	438	java/lang/IllegalAccessException
    //   263	288	438	java/lang/IllegalAccessException
    //   291	308	438	java/lang/IllegalAccessException
    //   322	336	438	java/lang/IllegalAccessException
    //   339	390	438	java/lang/IllegalAccessException
    //   214	237	453	java/lang/NoSuchFieldException
    //   242	260	453	java/lang/NoSuchFieldException
    //   263	288	453	java/lang/NoSuchFieldException
    //   291	308	453	java/lang/NoSuchFieldException
    //   322	336	453	java/lang/NoSuchFieldException
    //   339	390	453	java/lang/NoSuchFieldException
    //   683	694	697	java/lang/IllegalAccessException
    //   3	47	760	finally
    //   49	160	760	finally
    //   164	173	760	finally
    //   178	192	760	finally
    //   192	214	760	finally
    //   214	237	760	finally
    //   242	260	760	finally
    //   263	288	760	finally
    //   291	308	760	finally
    //   322	336	760	finally
    //   339	390	760	finally
    //   395	405	760	finally
    //   410	420	760	finally
    //   425	435	760	finally
    //   440	450	760	finally
    //   455	465	760	finally
    //   468	655	760	finally
    //   666	683	760	finally
    //   683	694	760	finally
    //   699	710	760	finally
    //   710	718	760	finally
    //   725	743	760	finally
    //   743	757	760	finally
    //   765	774	760	finally
    //   778	787	760	finally
    //   3	47	764	java/lang/Error
    //   49	160	764	java/lang/Error
    //   164	173	764	java/lang/Error
    //   178	192	764	java/lang/Error
    //   192	214	764	java/lang/Error
    //   395	405	764	java/lang/Error
    //   410	420	764	java/lang/Error
    //   425	435	764	java/lang/Error
    //   440	450	764	java/lang/Error
    //   455	465	764	java/lang/Error
    //   468	655	764	java/lang/Error
    //   666	683	764	java/lang/Error
    //   683	694	764	java/lang/Error
    //   699	710	764	java/lang/Error
    //   710	718	764	java/lang/Error
    //   725	743	764	java/lang/Error
    //   743	757	764	java/lang/Error
    //   3	47	777	java/lang/Exception
    //   49	160	777	java/lang/Exception
    //   164	173	777	java/lang/Exception
    //   178	192	777	java/lang/Exception
    //   192	214	777	java/lang/Exception
    //   395	405	777	java/lang/Exception
    //   410	420	777	java/lang/Exception
    //   425	435	777	java/lang/Exception
    //   440	450	777	java/lang/Exception
    //   455	465	777	java/lang/Exception
    //   468	655	777	java/lang/Exception
    //   666	683	777	java/lang/Exception
    //   683	694	777	java/lang/Exception
    //   699	710	777	java/lang/Exception
    //   710	718	777	java/lang/Exception
    //   725	743	777	java/lang/Exception
    //   743	757	777	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parseSearchConfig:");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.i("search_manager_configSearchConfigManager", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      localObject1 = MobileQQ.sMobileQQ;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append("sp_search_config");
      paramString1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
      paramString2 = new JSONObject(paramString2);
      configSwitch = paramString2.getString("configSwitch");
      if (!"on".equals(configSwitch))
      {
        paramString1.putString("configSwitch", "off");
        paramString1.commit();
        return;
      }
      if (paramString2.has("mStructMsgPicSwitch"))
      {
        int i = paramString2.getInt("mStructMsgPicSwitch");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("jsonObject.has mStructMsgPicSwitch ");
        ((StringBuilder)localObject1).append(i);
        QLog.i("search_manager_configSearchConfigManager", 1, ((StringBuilder)localObject1).toString());
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).setStructMsgPicPreDelegateSwitch(i);
      }
      localObject1 = paramString2.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        try
        {
          paramString1.putString((String)localObject2, (String)paramString2.get((String)localObject2));
        }
        catch (Error localError)
        {
          QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", localError);
        }
        catch (Exception localException)
        {
          QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", localException);
        }
        catch (JSONException localJSONException)
        {
          QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", localJSONException);
        }
      }
      paramString1.commit();
      curUin = "";
      return;
    }
    catch (Error paramString1)
    {
      QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", paramString1);
    }
  }
  
  private static void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("checkBaseBits ");
    if ((contactSearchPinyinBaseBit <= 0) || (contactSearchPinyinBaseBit >= 64))
    {
      localStringBuilder.append(",contactSearchPinyinBaseBit invalid=");
      localStringBuilder.append(contactSearchPinyinBaseBit);
      contactSearchPinyinBaseBit = 58;
    }
    if ((contactSearchRecentBaseBit <= 0) || (contactSearchRecentBaseBit >= 64))
    {
      localStringBuilder.append(",contactSearchRecentBaseBit invalid=");
      localStringBuilder.append(contactSearchRecentBaseBit);
      contactSearchRecentBaseBit = 48;
    }
    if ((contactSearchIndexBaseBit <= 0) || (contactSearchIndexBaseBit >= 64))
    {
      localStringBuilder.append(",contactSearchIndexBaseBit invalid=");
      localStringBuilder.append(contactSearchIndexBaseBit);
      contactSearchIndexBaseBit = 40;
    }
    if ((contactSearchTypeBaseBit <= 0) || (contactSearchTypeBaseBit >= 64))
    {
      localStringBuilder.append(",contactSearchTypeBaseBit invalid=");
      localStringBuilder.append(contactSearchTypeBaseBit);
      contactSearchTypeBaseBit = 32;
    }
    if ((contactSearchFieldBaseBit <= 0) || (contactSearchFieldBaseBit >= 64))
    {
      localStringBuilder.append(",contactSearchFieldBaseBit invalid=");
      localStringBuilder.append(contactSearchFieldBaseBit);
      contactSearchFieldBaseBit = 24;
    }
    Object localObject = new int[6];
    int i = contactSearchPinyinBaseBit;
    int j = 0;
    localObject[0] = i;
    localObject[1] = contactSearchRecentBaseBit;
    localObject[2] = contactSearchIndexBaseBit;
    localObject[3] = contactSearchTypeBaseBit;
    localObject[4] = contactSearchFieldBaseBit;
    localObject[5] = 64;
    Arrays.sort((int[])localObject);
    i = 1;
    while (i < localObject.length)
    {
      if (localObject[i] - localObject[(i - 1)] < 6)
      {
        i = j;
        break label270;
      }
      i += 1;
    }
    i = 1;
    label270:
    if (i == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",value is invalid : interval < 6 : contactSearchPinyinBaseBit=");
      ((StringBuilder)localObject).append(contactSearchPinyinBaseBit);
      ((StringBuilder)localObject).append(";contactSearchRecentBaseBit=");
      ((StringBuilder)localObject).append(contactSearchRecentBaseBit);
      ((StringBuilder)localObject).append(";contactSearchIndexBaseBit=");
      ((StringBuilder)localObject).append(contactSearchIndexBaseBit);
      ((StringBuilder)localObject).append(";contactSearchTypeBaseBit=");
      ((StringBuilder)localObject).append(contactSearchTypeBaseBit);
      ((StringBuilder)localObject).append(";contactSearchFieldBaseBit=");
      ((StringBuilder)localObject).append(contactSearchFieldBaseBit);
      localStringBuilder.append(((StringBuilder)localObject).toString());
      contactSearchPinyinBaseBit = 58;
      contactSearchRecentBaseBit = 48;
      contactSearchIndexBaseBit = 40;
      contactSearchTypeBaseBit = 32;
      contactSearchFieldBaseBit = 24;
    }
    QLog.i("search_manager_configSearchConfigManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.SearchConfigManager
 * JD-Core Version:    0.7.0.1
 */