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
    //   8: invokestatic 50	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   11: ldc 52
    //   13: invokeinterface 58 2 0
    //   18: checkcast 52	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   21: aload_0
    //   22: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   25: invokevirtual 62	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFileType	(Ljava/lang/String;)I
    //   28: sipush 9999
    //   31: if_icmpne +78 -> 109
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
    //   55: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   62: astore_3
    //   63: aload_0
    //   64: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   67: astore 4
    //   69: new 73	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc 76
    //   82: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: aload_0
    //   89: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   92: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: aload 4
    //   99: aconst_null
    //   100: aload 5
    //   102: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   108: areturn
    //   109: aload_0
    //   110: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   113: invokestatic 90	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5400	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   116: ldc 52
    //   118: invokeinterface 58 2 0
    //   123: checkcast 52	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   126: aload_0
    //   127: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   130: invokevirtual 94	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: new 96	java/io/File
    //   137: dup
    //   138: aload_3
    //   139: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 4
    //   144: aload 4
    //   146: invokevirtual 103	java/io/File:exists	()Z
    //   149: ifne +75 -> 224
    //   152: aload_0
    //   153: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   156: aload_0
    //   157: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   160: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   168: lload_1
    //   169: aload_3
    //   170: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   173: aload_0
    //   174: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   177: astore_3
    //   178: aload_0
    //   179: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   182: astore 4
    //   184: new 73	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   191: astore 5
    //   193: aload 5
    //   195: ldc 105
    //   197: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: aload_0
    //   204: getfield 22	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   207: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: aload 4
    //   214: aconst_null
    //   215: aload 5
    //   217: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   223: areturn
    //   224: aload_0
    //   225: getfield 28	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$recursive	Z
    //   228: ifeq +182 -> 410
    //   231: aload 4
    //   233: invokevirtual 108	java/io/File:isDirectory	()Z
    //   236: ifeq +174 -> 410
    //   239: aload_3
    //   240: invokestatic 114	com/tencent/qqmini/sdk/core/utils/FileUtils:getStatsByDir	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   243: astore 5
    //   245: aload 5
    //   247: ifnull +294 -> 541
    //   250: ldc 116
    //   252: aload_0
    //   253: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   256: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   259: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +30 -> 292
    //   265: aload_0
    //   266: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   269: aload_0
    //   270: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   273: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   276: iconst_1
    //   277: aload_0
    //   278: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   281: lload_1
    //   282: aload_3
    //   283: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   286: aload 5
    //   288: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   291: areturn
    //   292: aload_0
    //   293: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   296: invokestatic 129	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5500	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Z
    //   299: ifeq +57 -> 356
    //   302: new 124	org/json/JSONObject
    //   305: dup
    //   306: invokespecial 130	org/json/JSONObject:<init>	()V
    //   309: astore 4
    //   311: aload 4
    //   313: ldc 132
    //   315: aload 5
    //   317: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload_0
    //   322: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   325: aload_0
    //   326: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   329: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   332: iconst_1
    //   333: aload_0
    //   334: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   337: lload_1
    //   338: aload_3
    //   339: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   342: aload_0
    //   343: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   346: aload_0
    //   347: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   350: aload 4
    //   352: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   355: areturn
    //   356: aload_0
    //   357: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   360: aload_0
    //   361: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   364: aload 5
    //   366: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   369: astore_3
    //   370: aload_3
    //   371: areturn
    //   372: astore_3
    //   373: new 73	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   380: astore 4
    //   382: aload 4
    //   384: ldc 142
    //   386: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 4
    //   392: aload_3
    //   393: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 147
    //   399: aload 4
    //   401: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 153	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: ldc 155
    //   409: areturn
    //   410: aload_3
    //   411: invokestatic 158	com/tencent/qqmini/sdk/core/utils/FileUtils:getStats	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   414: astore 5
    //   416: aload 5
    //   418: ifnull +123 -> 541
    //   421: ldc 116
    //   423: aload_0
    //   424: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   427: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   430: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +30 -> 463
    //   436: aload_0
    //   437: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   440: aload_0
    //   441: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   444: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   447: iconst_1
    //   448: aload_0
    //   449: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   452: lload_1
    //   453: aload_3
    //   454: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   457: aload 5
    //   459: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   462: areturn
    //   463: aload_0
    //   464: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   467: invokestatic 161	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$5600	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Z
    //   470: ifeq +57 -> 527
    //   473: new 124	org/json/JSONObject
    //   476: dup
    //   477: invokespecial 130	org/json/JSONObject:<init>	()V
    //   480: astore 4
    //   482: aload 4
    //   484: ldc 132
    //   486: aload 5
    //   488: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   491: pop
    //   492: aload_0
    //   493: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   496: aload_0
    //   497: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   500: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   503: iconst_1
    //   504: aload_0
    //   505: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   508: lload_1
    //   509: aload_3
    //   510: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   513: aload_0
    //   514: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   517: aload_0
    //   518: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   521: aload 4
    //   523: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   526: areturn
    //   527: aload_0
    //   528: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   531: aload_0
    //   532: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   535: aload 5
    //   537: invokestatic 140	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1100	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;)Ljava/lang/String;
    //   540: areturn
    //   541: aload_0
    //   542: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   545: aload_0
    //   546: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   549: getfield 67	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   552: iconst_0
    //   553: aload_0
    //   554: getfield 26	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$startMS	J
    //   557: lload_1
    //   558: aload_3
    //   559: invokestatic 71	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Ljava/lang/String;ZJJLjava/lang/String;)V
    //   562: aload_0
    //   563: getfield 20	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   566: aload_0
    //   567: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$13:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   570: aconst_null
    //   571: ldc 105
    //   573: invokestatic 87	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$1000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   576: areturn
    //   577: astore 5
    //   579: goto -258 -> 321
    //   582: astore 5
    //   584: goto -92 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	13
    //   3	555	1	l	long
    //   62	309	3	localObject1	Object
    //   372	187	3	localException	java.lang.Exception
    //   67	455	4	localObject2	Object
    //   76	460	5	localObject3	Object
    //   577	1	5	localJSONException1	org.json.JSONException
    //   582	1	5	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   239	245	372	java/lang/Exception
    //   250	292	372	java/lang/Exception
    //   292	311	372	java/lang/Exception
    //   311	321	372	java/lang/Exception
    //   321	356	372	java/lang/Exception
    //   356	370	372	java/lang/Exception
    //   311	321	577	org/json/JSONException
    //   482	492	582	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */