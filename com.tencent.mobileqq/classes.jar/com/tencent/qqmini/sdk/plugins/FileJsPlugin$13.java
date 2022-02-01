package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString, RequestEvent paramRequestEvent, long paramLong, boolean paramBoolean) {}
  
  /* Error */
  public String run()
  {
    // Byte code:
    //   0: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   8: invokestatic 50	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5700	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   11: ldc 52
    //   13: invokeinterface 58 2 0
    //   18: checkcast 52	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   21: aload_0
    //   22: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   25: invokevirtual 62	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFileType	(Ljava/lang/String;)I
    //   28: sipush 9999
    //   31: if_icmpne +62 -> 93
    //   34: aload_0
    //   35: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   38: aload_0
    //   39: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   42: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   50: lload_1
    //   51: aload_0
    //   52: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   55: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   62: aload_0
    //   63: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   66: aconst_null
    //   67: new 73	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   74: ldc 76
    //   76: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   83: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1200	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   92: areturn
    //   93: aload_0
    //   94: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   97: invokestatic 90	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5800	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   100: ldc 52
    //   102: invokeinterface 58 2 0
    //   107: checkcast 52	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   110: aload_0
    //   111: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   114: invokevirtual 94	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_3
    //   118: new 96	java/io/File
    //   121: dup
    //   122: aload_3
    //   123: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: astore 4
    //   128: aload 4
    //   130: invokevirtual 103	java/io/File:exists	()Z
    //   133: ifne +59 -> 192
    //   136: aload_0
    //   137: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   140: aload_0
    //   141: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   144: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   147: iconst_0
    //   148: aload_0
    //   149: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   152: lload_1
    //   153: aload_3
    //   154: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   157: aload_0
    //   158: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   161: aload_0
    //   162: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   165: aconst_null
    //   166: new 73	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   173: ldc 105
    //   175: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   182: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1200	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   191: areturn
    //   192: aload_0
    //   193: getfield 28	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$recursive	Z
    //   196: ifeq +172 -> 368
    //   199: aload 4
    //   201: invokevirtual 108	java/io/File:isDirectory	()Z
    //   204: ifeq +164 -> 368
    //   207: aload_3
    //   208: invokestatic 114	com/tencent/qqmini/sdk/core/utils/FileUtils:getStatsByDir	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   211: astore 5
    //   213: aload 5
    //   215: ifnull +284 -> 499
    //   218: ldc 116
    //   220: aload_0
    //   221: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   224: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   227: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +30 -> 260
    //   233: aload_0
    //   234: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   237: aload_0
    //   238: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   241: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   244: iconst_1
    //   245: aload_0
    //   246: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   249: lload_1
    //   250: aload_3
    //   251: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   254: aload 5
    //   256: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   259: areturn
    //   260: aload_0
    //   261: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   264: invokestatic 129	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Z
    //   267: ifeq +57 -> 324
    //   270: new 124	org/json/JSONObject
    //   273: dup
    //   274: invokespecial 130	org/json/JSONObject:<init>	()V
    //   277: astore 4
    //   279: aload 4
    //   281: ldc 132
    //   283: aload 5
    //   285: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload_0
    //   290: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   293: aload_0
    //   294: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   297: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   300: iconst_1
    //   301: aload_0
    //   302: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   305: lload_1
    //   306: aload_3
    //   307: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   310: aload_0
    //   311: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   314: aload_0
    //   315: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   318: aload 4
    //   320: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   323: areturn
    //   324: aload_0
    //   325: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   328: aload_0
    //   329: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   332: aload 5
    //   334: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   337: astore_3
    //   338: aload_3
    //   339: areturn
    //   340: astore_3
    //   341: ldc 142
    //   343: new 73	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   350: ldc 144
    //   352: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 153	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: ldc 155
    //   367: areturn
    //   368: aload_3
    //   369: invokestatic 158	com/tencent/qqmini/sdk/core/utils/FileUtils:getStats	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   372: astore 5
    //   374: aload 5
    //   376: ifnull +123 -> 499
    //   379: ldc 116
    //   381: aload_0
    //   382: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   385: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   388: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +30 -> 421
    //   394: aload_0
    //   395: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   398: aload_0
    //   399: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   402: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   405: iconst_1
    //   406: aload_0
    //   407: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   410: lload_1
    //   411: aload_3
    //   412: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   415: aload 5
    //   417: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   420: areturn
    //   421: aload_0
    //   422: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   425: invokestatic 161	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$6000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Z
    //   428: ifeq +57 -> 485
    //   431: new 124	org/json/JSONObject
    //   434: dup
    //   435: invokespecial 130	org/json/JSONObject:<init>	()V
    //   438: astore 4
    //   440: aload 4
    //   442: ldc 132
    //   444: aload 5
    //   446: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   449: pop
    //   450: aload_0
    //   451: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   454: aload_0
    //   455: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   458: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   461: iconst_1
    //   462: aload_0
    //   463: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   466: lload_1
    //   467: aload_3
    //   468: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   471: aload_0
    //   472: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   475: aload_0
    //   476: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   479: aload 4
    //   481: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   484: areturn
    //   485: aload_0
    //   486: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   489: aload_0
    //   490: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   493: aload 5
    //   495: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   498: areturn
    //   499: aload_0
    //   500: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   503: aload_0
    //   504: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   507: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   510: iconst_0
    //   511: aload_0
    //   512: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   515: lload_1
    //   516: aload_3
    //   517: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   520: aload_0
    //   521: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   524: aload_0
    //   525: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   528: aconst_null
    //   529: ldc 105
    //   531: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1200	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   534: areturn
    //   535: astore 5
    //   537: goto -87 -> 450
    //   540: astore 5
    //   542: goto -253 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	13
    //   3	513	1	l	long
    //   117	222	3	str	String
    //   340	177	3	localException	java.lang.Exception
    //   126	354	4	localObject	Object
    //   211	283	5	localJSONObject	org.json.JSONObject
    //   535	1	5	localJSONException1	org.json.JSONException
    //   540	1	5	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   207	213	340	java/lang/Exception
    //   218	260	340	java/lang/Exception
    //   260	279	340	java/lang/Exception
    //   279	289	340	java/lang/Exception
    //   289	324	340	java/lang/Exception
    //   324	338	340	java/lang/Exception
    //   440	450	535	org/json/JSONException
    //   279	289	540	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */