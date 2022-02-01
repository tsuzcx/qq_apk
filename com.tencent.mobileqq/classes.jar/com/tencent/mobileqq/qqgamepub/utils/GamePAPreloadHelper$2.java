package com.tencent.mobileqq.qqgamepub.utils;

import android.os.Bundle;
import org.json.JSONArray;

final class GamePAPreloadHelper$2
  implements Runnable
{
  GamePAPreloadHelper$2(Bundle paramBundle1, String paramString, Bundle paramBundle2, JSONArray paramJSONArray) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:a	Landroid/os/Bundle;
    //   4: ldc 32
    //   6: iconst_1
    //   7: invokevirtual 38	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   10: getstatic 44	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   13: aload_0
    //   14: getfield 19	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:b	Ljava/lang/String;
    //   17: ldc 46
    //   19: aload_0
    //   20: getfield 17	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:a	Landroid/os/Bundle;
    //   23: aload_0
    //   24: getfield 21	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:c	Landroid/os/Bundle;
    //   27: invokestatic 52	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 23	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:d	Lorg/json/JSONArray;
    //   39: ifnull +48 -> 87
    //   42: aload_1
    //   43: astore_3
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 23	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:d	Lorg/json/JSONArray;
    //   50: invokevirtual 58	org/json/JSONArray:length	()I
    //   53: ifle +34 -> 87
    //   56: aload_1
    //   57: astore_2
    //   58: new 60	org/json/JSONObject
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 63	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: ldc 65
    //   72: aload_0
    //   73: getfield 23	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:d	Lorg/json/JSONArray;
    //   76: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 73	org/json/JSONObject:toString	()Ljava/lang/String;
    //   86: astore_3
    //   87: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   90: invokestatic 84	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:b	(J)J
    //   93: pop2
    //   94: aload_3
    //   95: astore_1
    //   96: aload_3
    //   97: ifnonnull +12 -> 109
    //   100: sipush -1000
    //   103: ldc 86
    //   105: invokestatic 89	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 91	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(Ljava/lang/String;)V
    //   113: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   116: ifnull +30 -> 146
    //   119: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   122: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   125: ifnull +21 -> 146
    //   128: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   131: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   134: checkcast 103	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$OnPreloadFeedsListener
    //   137: aload_1
    //   138: invokeinterface 104 2 0
    //   143: goto +36 -> 179
    //   146: new 106	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc 109
    //   157: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   165: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 118
    //   171: iconst_1
    //   172: aload_2
    //   173: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +297 -> 479
    //   185: new 106	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   192: astore_3
    //   193: aload_1
    //   194: astore_2
    //   195: aload_3
    //   196: astore_1
    //   197: aload_1
    //   198: ldc 131
    //   200: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: invokestatic 133	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:i	()J
    //   208: invokestatic 136	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:g	()J
    //   211: lsub
    //   212: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: ldc 141
    //   219: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: aload_0
    //   225: getfield 19	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:b	Ljava/lang/String;
    //   228: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: ldc 143
    //   235: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload_0
    //   241: getfield 17	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:a	Landroid/os/Bundle;
    //   244: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: ldc 145
    //   251: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: aload_0
    //   257: getfield 21	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:c	Landroid/os/Bundle;
    //   260: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: ldc 147
    //   267: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_1
    //   272: aload_2
    //   273: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 118
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: return
    //   288: astore_3
    //   289: goto +12 -> 301
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: goto +186 -> 481
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_1
    //   302: astore_2
    //   303: new 106	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   310: astore 4
    //   312: aload_1
    //   313: astore_2
    //   314: aload 4
    //   316: ldc 151
    //   318: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_1
    //   323: astore_2
    //   324: aload 4
    //   326: aload_0
    //   327: getfield 19	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:b	Ljava/lang/String;
    //   330: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: astore_2
    //   336: aload 4
    //   338: ldc 153
    //   340: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: astore_2
    //   346: aload 4
    //   348: aload_0
    //   349: getfield 17	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:a	Landroid/os/Bundle;
    //   352: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: astore_2
    //   358: ldc 118
    //   360: iconst_1
    //   361: aload 4
    //   363: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload_3
    //   367: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   370: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   373: invokestatic 84	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:b	(J)J
    //   376: pop2
    //   377: aload_1
    //   378: astore_2
    //   379: aload_1
    //   380: ifnonnull +12 -> 392
    //   383: sipush -1000
    //   386: ldc 86
    //   388: invokestatic 89	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   391: astore_2
    //   392: aload_2
    //   393: invokestatic 91	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(Ljava/lang/String;)V
    //   396: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   399: ifnull +30 -> 429
    //   402: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   405: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   408: ifnull +21 -> 429
    //   411: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   414: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   417: checkcast 103	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$OnPreloadFeedsListener
    //   420: aload_2
    //   421: invokeinterface 104 2 0
    //   426: goto +36 -> 462
    //   429: new 106	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   436: astore_1
    //   437: aload_1
    //   438: ldc 109
    //   440: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   448: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 118
    //   454: iconst_1
    //   455: aload_1
    //   456: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +14 -> 479
    //   468: new 106	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   475: astore_1
    //   476: goto -279 -> 197
    //   479: return
    //   480: astore_1
    //   481: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   484: invokestatic 84	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:b	(J)J
    //   487: pop2
    //   488: aload_2
    //   489: astore_3
    //   490: aload_2
    //   491: ifnonnull +12 -> 503
    //   494: sipush -1000
    //   497: ldc 86
    //   499: invokestatic 89	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   502: astore_3
    //   503: aload_3
    //   504: invokestatic 91	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:a	(Ljava/lang/String;)V
    //   507: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   510: ifnull +30 -> 540
    //   513: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   516: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   519: ifnull +21 -> 540
    //   522: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   525: invokevirtual 101	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   528: checkcast 103	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$OnPreloadFeedsListener
    //   531: aload_3
    //   532: invokeinterface 104 2 0
    //   537: goto +36 -> 573
    //   540: new 106	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   547: astore_2
    //   548: aload_2
    //   549: ldc 109
    //   551: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_2
    //   556: invokestatic 95	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:h	()Lmqq/util/WeakReference;
    //   559: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: ldc 118
    //   565: iconst_1
    //   566: aload_2
    //   567: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +101 -> 677
    //   579: new 106	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   586: astore_2
    //   587: aload_2
    //   588: ldc 131
    //   590: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload_2
    //   595: invokestatic 133	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:i	()J
    //   598: invokestatic 136	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper:g	()J
    //   601: lsub
    //   602: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload_2
    //   607: ldc 141
    //   609: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_2
    //   614: aload_0
    //   615: getfield 19	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:b	Ljava/lang/String;
    //   618: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc 143
    //   625: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: aload_0
    //   631: getfield 17	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:a	Landroid/os/Bundle;
    //   634: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload_2
    //   639: ldc 145
    //   641: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload_2
    //   646: aload_0
    //   647: getfield 21	com/tencent/mobileqq/qqgamepub/utils/GamePAPreloadHelper$2:c	Landroid/os/Bundle;
    //   650: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload_2
    //   655: ldc 147
    //   657: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_2
    //   662: aload_3
    //   663: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: ldc 118
    //   669: iconst_2
    //   670: aload_2
    //   671: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: goto +5 -> 682
    //   680: aload_1
    //   681: athrow
    //   682: goto -2 -> 680
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	2
    //   30	251	1	localObject1	Object
    //   292	1	1	localObject2	Object
    //   300	176	1	localStringBuilder1	java.lang.StringBuilder
    //   480	201	1	localObject3	Object
    //   34	637	2	localObject4	Object
    //   32	164	3	localObject5	Object
    //   288	1	3	localThrowable1	java.lang.Throwable
    //   298	69	3	localThrowable2	java.lang.Throwable
    //   489	174	3	localObject6	Object
    //   310	52	4	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	42	288	java/lang/Throwable
    //   46	56	288	java/lang/Throwable
    //   58	67	288	java/lang/Throwable
    //   69	80	288	java/lang/Throwable
    //   82	87	288	java/lang/Throwable
    //   0	31	292	finally
    //   0	31	298	java/lang/Throwable
    //   35	42	480	finally
    //   46	56	480	finally
    //   58	67	480	finally
    //   69	80	480	finally
    //   82	87	480	finally
    //   303	312	480	finally
    //   314	322	480	finally
    //   324	334	480	finally
    //   336	344	480	finally
    //   346	356	480	finally
    //   358	370	480	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.2
 * JD-Core Version:    0.7.0.1
 */