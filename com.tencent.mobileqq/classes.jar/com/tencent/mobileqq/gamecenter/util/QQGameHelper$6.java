package com.tencent.mobileqq.gamecenter.util;

import android.os.Bundle;
import org.json.JSONArray;

final class QQGameHelper$6
  implements Runnable
{
  QQGameHelper$6(Bundle paramBundle1, String paramString, Bundle paramBundle2, JSONArray paramJSONArray) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   4: ldc 30
    //   6: iconst_1
    //   7: invokevirtual 36	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   10: getstatic 42	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   13: aload_0
    //   14: getfield 17	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: ldc 44
    //   19: aload_0
    //   20: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   23: aload_0
    //   24: getfield 19	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:b	Landroid/os/Bundle;
    //   27: invokestatic 50	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 21	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   39: ifnull +48 -> 87
    //   42: aload_1
    //   43: astore_3
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 21	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   50: invokevirtual 56	org/json/JSONArray:length	()I
    //   53: ifle +34 -> 87
    //   56: aload_1
    //   57: astore_2
    //   58: new 58	org/json/JSONObject
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: ldc 63
    //   72: aload_0
    //   73: getfield 21	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   76: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 71	org/json/JSONObject:toString	()Ljava/lang/String;
    //   86: astore_3
    //   87: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   90: invokestatic 82	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(J)J
    //   93: pop2
    //   94: aload_3
    //   95: ifnonnull +557 -> 652
    //   98: sipush -1000
    //   101: ldc 84
    //   103: invokestatic 87	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   106: astore_1
    //   107: aload_1
    //   108: invokestatic 90	com/tencent/mobileqq/gamecenter/util/QQGameHelper:d	(Ljava/lang/String;)V
    //   111: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   114: ifnull +110 -> 224
    //   117: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   120: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   123: ifnull +101 -> 224
    //   126: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   129: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   132: checkcast 101	com/tencent/mobileqq/gamecenter/util/QQGameHelper$OnPreloadFeedsListener
    //   135: aload_1
    //   136: invokeinterface 103 2 0
    //   141: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +79 -> 223
    //   147: ldc 111
    //   149: iconst_2
    //   150: new 113	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   157: ldc 116
    //   159: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 123	com/tencent/mobileqq/gamecenter/util/QQGameHelper:f	()J
    //   165: invokestatic 126	com/tencent/mobileqq/gamecenter/util/QQGameHelper:e	()J
    //   168: lsub
    //   169: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc 131
    //   174: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 17	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   181: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 133
    //   186: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   193: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: ldc 138
    //   198: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 19	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:b	Landroid/os/Bundle;
    //   205: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: ldc 140
    //   210: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: return
    //   224: ldc 111
    //   226: iconst_1
    //   227: new 113	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   234: ldc 146
    //   236: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   242: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: goto -110 -> 141
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: astore_2
    //   259: ldc 111
    //   261: iconst_1
    //   262: new 113	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   269: ldc 151
    //   271: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: getfield 17	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   278: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 153
    //   283: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   290: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aload_3
    //   297: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   303: invokestatic 82	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(J)J
    //   306: pop2
    //   307: aload_1
    //   308: ifnonnull +341 -> 649
    //   311: sipush -1000
    //   314: ldc 84
    //   316: invokestatic 87	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: invokestatic 90	com/tencent/mobileqq/gamecenter/util/QQGameHelper:d	(Ljava/lang/String;)V
    //   324: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   327: ifnull +110 -> 437
    //   330: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   333: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   336: ifnull +101 -> 437
    //   339: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   342: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   345: checkcast 101	com/tencent/mobileqq/gamecenter/util/QQGameHelper$OnPreloadFeedsListener
    //   348: aload_1
    //   349: invokeinterface 103 2 0
    //   354: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -134 -> 223
    //   360: ldc 111
    //   362: iconst_2
    //   363: new 113	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   370: ldc 116
    //   372: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 123	com/tencent/mobileqq/gamecenter/util/QQGameHelper:f	()J
    //   378: invokestatic 126	com/tencent/mobileqq/gamecenter/util/QQGameHelper:e	()J
    //   381: lsub
    //   382: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc 131
    //   387: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: getfield 17	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   394: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc 133
    //   399: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   406: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: ldc 138
    //   411: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 19	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:b	Landroid/os/Bundle;
    //   418: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   421: ldc 140
    //   423: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_1
    //   427: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: return
    //   437: ldc 111
    //   439: iconst_1
    //   440: new 113	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   447: ldc 146
    //   449: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   455: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: goto -110 -> 354
    //   467: astore_1
    //   468: aconst_null
    //   469: astore_2
    //   470: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   473: invokestatic 82	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(J)J
    //   476: pop2
    //   477: aload_2
    //   478: ifnonnull +168 -> 646
    //   481: sipush -1000
    //   484: ldc 84
    //   486: invokestatic 87	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(ILjava/lang/String;)Ljava/lang/String;
    //   489: astore_2
    //   490: aload_2
    //   491: invokestatic 90	com/tencent/mobileqq/gamecenter/util/QQGameHelper:d	(Ljava/lang/String;)V
    //   494: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   497: ifnull +111 -> 608
    //   500: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   503: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   506: ifnull +102 -> 608
    //   509: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   512: invokevirtual 99	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   515: checkcast 101	com/tencent/mobileqq/gamecenter/util/QQGameHelper$OnPreloadFeedsListener
    //   518: aload_2
    //   519: invokeinterface 103 2 0
    //   524: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +79 -> 606
    //   530: ldc 111
    //   532: iconst_2
    //   533: new 113	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   540: ldc 116
    //   542: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokestatic 123	com/tencent/mobileqq/gamecenter/util/QQGameHelper:f	()J
    //   548: invokestatic 126	com/tencent/mobileqq/gamecenter/util/QQGameHelper:e	()J
    //   551: lsub
    //   552: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: ldc 131
    //   557: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload_0
    //   561: getfield 17	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   564: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: ldc 133
    //   569: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_0
    //   573: getfield 15	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   576: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   579: ldc 138
    //   581: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload_0
    //   585: getfield 19	com/tencent/mobileqq/gamecenter/util/QQGameHelper$6:b	Landroid/os/Bundle;
    //   588: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   591: ldc 140
    //   593: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_2
    //   597: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload_1
    //   607: athrow
    //   608: ldc 111
    //   610: iconst_1
    //   611: new 113	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   618: ldc 146
    //   620: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokestatic 93	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	()Lmqq/util/WeakReference;
    //   626: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: goto -111 -> 524
    //   638: astore_1
    //   639: goto -169 -> 470
    //   642: astore_3
    //   643: goto -386 -> 257
    //   646: goto -156 -> 490
    //   649: goto -329 -> 320
    //   652: aload_3
    //   653: astore_1
    //   654: goto -547 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	6
    //   30	397	1	str1	String
    //   467	140	1	localObject1	Object
    //   638	1	1	localObject2	Object
    //   653	1	1	localObject3	Object
    //   34	563	2	str2	String
    //   32	63	3	localObject4	Object
    //   254	43	3	localException1	java.lang.Exception
    //   642	11	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	31	254	java/lang/Exception
    //   0	31	467	finally
    //   35	42	638	finally
    //   46	56	638	finally
    //   58	67	638	finally
    //   69	80	638	finally
    //   82	87	638	finally
    //   259	300	638	finally
    //   35	42	642	java/lang/Exception
    //   46	56	642	java/lang/Exception
    //   58	67	642	java/lang/Exception
    //   69	80	642	java/lang/Exception
    //   82	87	642	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.6
 * JD-Core Version:    0.7.0.1
 */