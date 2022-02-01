package cooperation.qzone.webviewplugin;

class QZoneGiftFullScreenJsPlugin$1
  implements Runnable
{
  QZoneGiftFullScreenJsPlugin$1(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String[] paramArrayOfString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 25
    //   2: astore 5
    //   4: aload_0
    //   5: getfield 16	cooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin$1:val$args	[Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +269 -> 279
    //   13: aload_1
    //   14: arraylength
    //   15: ifle +264 -> 279
    //   18: aload_1
    //   19: iconst_0
    //   20: aaload
    //   21: ifnull +258 -> 279
    //   24: new 27	org/json/JSONObject
    //   27: dup
    //   28: aload_1
    //   29: iconst_0
    //   30: aaload
    //   31: invokespecial 30	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc 32
    //   40: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 4
    //   45: aload 6
    //   47: ldc 38
    //   49: invokevirtual 42	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   52: astore_3
    //   53: invokestatic 48	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	()Ljava/lang/String;
    //   56: ldc 50
    //   58: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +37 -> 98
    //   64: aload_3
    //   65: ldc 58
    //   67: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_3
    //   74: ldc 60
    //   76: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: astore_1
    //   82: goto +101 -> 183
    //   85: astore_3
    //   86: ldc 25
    //   88: astore 5
    //   90: aload_1
    //   91: astore_2
    //   92: aload 5
    //   94: astore_1
    //   95: goto +131 -> 226
    //   98: invokestatic 48	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	()Ljava/lang/String;
    //   101: ldc 62
    //   103: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +24 -> 130
    //   109: aload_3
    //   110: ldc 64
    //   112: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 66
    //   121: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore_3
    //   125: aload_3
    //   126: astore_1
    //   127: goto -45 -> 82
    //   130: invokestatic 48	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	()Ljava/lang/String;
    //   133: ldc 68
    //   135: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +24 -> 162
    //   141: aload_3
    //   142: ldc 70
    //   144: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore_2
    //   148: aload_2
    //   149: astore_1
    //   150: aload_3
    //   151: ldc 72
    //   153: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_3
    //   157: aload_3
    //   158: astore_1
    //   159: goto -77 -> 82
    //   162: aload_3
    //   163: ldc 74
    //   165: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: aload_3
    //   172: ldc 76
    //   174: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_3
    //   178: aload_3
    //   179: astore_1
    //   180: goto -98 -> 82
    //   183: aload_0
    //   184: getfield 14	cooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin$1:this$0	Lcooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin;
    //   187: aload 6
    //   189: ldc 78
    //   191: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokestatic 84	cooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin:access$002	(Lcooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin;Ljava/lang/String;)Ljava/lang/String;
    //   197: pop
    //   198: goto +32 -> 230
    //   201: astore_3
    //   202: goto +24 -> 226
    //   205: astore_3
    //   206: ldc 25
    //   208: astore_1
    //   209: aload 5
    //   211: astore_2
    //   212: goto +14 -> 226
    //   215: astore_3
    //   216: ldc 25
    //   218: astore 4
    //   220: aload 4
    //   222: astore_1
    //   223: aload 5
    //   225: astore_2
    //   226: aload_3
    //   227: invokevirtual 87	org/json/JSONException:printStackTrace	()V
    //   230: aload 4
    //   232: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +44 -> 279
    //   238: aload_2
    //   239: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +37 -> 279
    //   245: aload_1
    //   246: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +30 -> 279
    //   252: aload_0
    //   253: getfield 14	cooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin$1:this$0	Lcooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin;
    //   256: invokestatic 97	cooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin:access$000	(Lcooperation/qzone/webviewplugin/QZoneGiftFullScreenJsPlugin;)Ljava/lang/String;
    //   259: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifeq +4 -> 266
    //   265: return
    //   266: invokestatic 103	cooperation/qzone/remote/logic/RemoteHandleManager:getInstance	()Lcooperation/qzone/remote/logic/RemoteHandleManager;
    //   269: invokevirtual 107	cooperation/qzone/remote/logic/RemoteHandleManager:getSender	()Lcooperation/qzone/remote/logic/RemoteRequestSender;
    //   272: aload 4
    //   274: aload_2
    //   275: aload_1
    //   276: invokevirtual 113	cooperation/qzone/remote/logic/RemoteRequestSender:downloadGift	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   279: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	1
    //   8	268	1	localObject1	Object
    //   70	205	2	localObject2	Object
    //   52	29	3	localObject3	Object
    //   85	34	3	localJSONException1	org.json.JSONException
    //   124	55	3	str1	String
    //   201	1	3	localJSONException2	org.json.JSONException
    //   205	1	3	localJSONException3	org.json.JSONException
    //   215	12	3	localJSONException4	org.json.JSONException
    //   43	230	4	str2	String
    //   2	222	5	str3	String
    //   34	154	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   73	80	85	org/json/JSONException
    //   118	125	85	org/json/JSONException
    //   150	157	85	org/json/JSONException
    //   171	178	85	org/json/JSONException
    //   183	198	201	org/json/JSONException
    //   45	71	205	org/json/JSONException
    //   98	116	205	org/json/JSONException
    //   130	148	205	org/json/JSONException
    //   162	169	205	org/json/JSONException
    //   24	45	215	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */