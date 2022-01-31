package com.tencent.qqmini.sdk.core.plugins;

import beka;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString, beka parambeka, boolean paramBoolean) {}
  
  /* Error */
  public String run()
  {
    // Byte code:
    //   0: invokestatic 40	beiu:a	()Lbeiu;
    //   3: aload_0
    //   4: getfield 20	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   7: invokevirtual 43	beiu:a	(Ljava/lang/String;)I
    //   10: sipush 9999
    //   13: if_icmpne +38 -> 51
    //   16: aload_0
    //   17: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   20: aload_0
    //   21: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   24: aconst_null
    //   25: new 45	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   32: ldc 48
    //   34: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 20	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   41: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 61	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$100	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   50: areturn
    //   51: invokestatic 40	beiu:a	()Lbeiu;
    //   54: aload_0
    //   55: getfield 20	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   58: invokevirtual 64	beiu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_1
    //   62: new 66	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 73	java/io/File:exists	()Z
    //   75: ifne +38 -> 113
    //   78: aload_0
    //   79: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   82: aload_0
    //   83: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   86: aconst_null
    //   87: new 45	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   94: ldc 75
    //   96: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 20	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$path	Ljava/lang/String;
    //   103: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 61	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$100	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   112: areturn
    //   113: aload_0
    //   114: getfield 24	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$recursive	Z
    //   117: ifeq +121 -> 238
    //   120: aload_2
    //   121: invokevirtual 78	java/io/File:isDirectory	()Z
    //   124: ifeq +114 -> 238
    //   127: aload_1
    //   128: invokestatic 84	bekq:b	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +186 -> 319
    //   136: ldc 86
    //   138: aload_0
    //   139: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   142: getfield 90	beka:a	Ljava/lang/String;
    //   145: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifeq +8 -> 156
    //   151: aload_2
    //   152: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   155: areturn
    //   156: aload_0
    //   157: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   160: getfield 102	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:mIsMiniGame	Z
    //   163: ifeq +32 -> 195
    //   166: new 98	org/json/JSONObject
    //   169: dup
    //   170: invokespecial 103	org/json/JSONObject:<init>	()V
    //   173: astore_1
    //   174: aload_1
    //   175: ldc 105
    //   177: aload_2
    //   178: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload_0
    //   183: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   186: aload_0
    //   187: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   190: aload_1
    //   191: invokestatic 113	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$200	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;)Ljava/lang/String;
    //   194: areturn
    //   195: aload_0
    //   196: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   199: aload_0
    //   200: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   203: aload_2
    //   204: invokestatic 113	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$200	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;)Ljava/lang/String;
    //   207: astore_1
    //   208: aload_1
    //   209: areturn
    //   210: astore_1
    //   211: ldc 115
    //   213: new 45	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   220: ldc 117
    //   222: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 126	besl:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: ldc 128
    //   237: areturn
    //   238: aload_1
    //   239: invokestatic 130	bekq:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +75 -> 319
    //   247: ldc 86
    //   249: aload_0
    //   250: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   253: getfield 90	beka:a	Ljava/lang/String;
    //   256: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifeq +8 -> 267
    //   262: aload_2
    //   263: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   266: areturn
    //   267: aload_0
    //   268: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   271: getfield 102	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:mIsMiniGame	Z
    //   274: ifeq +32 -> 306
    //   277: new 98	org/json/JSONObject
    //   280: dup
    //   281: invokespecial 103	org/json/JSONObject:<init>	()V
    //   284: astore_1
    //   285: aload_1
    //   286: ldc 105
    //   288: aload_2
    //   289: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload_0
    //   294: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   297: aload_0
    //   298: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   301: aload_1
    //   302: invokestatic 113	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$200	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;)Ljava/lang/String;
    //   305: areturn
    //   306: aload_0
    //   307: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   310: aload_0
    //   311: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   314: aload_2
    //   315: invokestatic 113	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$200	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;)Ljava/lang/String;
    //   318: areturn
    //   319: aload_0
    //   320: getfield 18	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:this$0	Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;
    //   323: aload_0
    //   324: getfield 22	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin$13:val$req	Lbeka;
    //   327: aconst_null
    //   328: ldc 75
    //   330: invokestatic 61	com/tencent/qqmini/sdk/core/plugins/FileJsPlugin:access$100	(Lcom/tencent/qqmini/sdk/core/plugins/FileJsPlugin;Lbeka;Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   333: areturn
    //   334: astore_2
    //   335: goto -42 -> 293
    //   338: astore_2
    //   339: goto -157 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	13
    //   61	148	1	localObject1	Object
    //   210	29	1	localException	java.lang.Exception
    //   284	18	1	localJSONObject	org.json.JSONObject
    //   70	245	2	localObject2	Object
    //   334	1	2	localJSONException1	org.json.JSONException
    //   338	1	2	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   127	132	210	java/lang/Exception
    //   136	156	210	java/lang/Exception
    //   156	174	210	java/lang/Exception
    //   174	182	210	java/lang/Exception
    //   182	195	210	java/lang/Exception
    //   195	208	210	java/lang/Exception
    //   285	293	334	org/json/JSONException
    //   174	182	338	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */