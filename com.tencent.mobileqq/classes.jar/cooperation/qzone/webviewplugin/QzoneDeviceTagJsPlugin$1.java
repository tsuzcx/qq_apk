package cooperation.qzone.webviewplugin;

final class QzoneDeviceTagJsPlugin$1
  implements Runnable
{
  QzoneDeviceTagJsPlugin$1(String[] paramArrayOfString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 21
    //   2: astore 5
    //   4: aload_0
    //   5: getfield 12	cooperation/qzone/webviewplugin/QzoneDeviceTagJsPlugin$1:val$args	[Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +114 -> 124
    //   13: aload_1
    //   14: arraylength
    //   15: ifle +109 -> 124
    //   18: aload_1
    //   19: iconst_0
    //   20: aaload
    //   21: ifnull +103 -> 124
    //   24: new 23	org/json/JSONObject
    //   27: dup
    //   28: aload_1
    //   29: iconst_0
    //   30: aaload
    //   31: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: ldc 28
    //   40: invokevirtual 32	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_2
    //   44: aload 4
    //   46: ldc 34
    //   48: invokevirtual 32	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload 4
    //   54: ldc 36
    //   56: invokevirtual 32	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload 4
    //   62: ldc 38
    //   64: invokevirtual 32	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 4
    //   69: goto +41 -> 110
    //   72: astore 4
    //   74: goto +27 -> 101
    //   77: astore 4
    //   79: ldc 21
    //   81: astore_1
    //   82: goto +19 -> 101
    //   85: astore 4
    //   87: goto +8 -> 95
    //   90: astore 4
    //   92: ldc 21
    //   94: astore_2
    //   95: ldc 21
    //   97: astore_3
    //   98: ldc 21
    //   100: astore_1
    //   101: aload 4
    //   103: invokevirtual 41	org/json/JSONException:printStackTrace	()V
    //   106: aload 5
    //   108: astore 4
    //   110: invokestatic 47	cooperation/qzone/remote/logic/RemoteHandleManager:getInstance	()Lcooperation/qzone/remote/logic/RemoteHandleManager;
    //   113: invokevirtual 51	cooperation/qzone/remote/logic/RemoteHandleManager:getSender	()Lcooperation/qzone/remote/logic/RemoteRequestSender;
    //   116: aload_2
    //   117: aload_3
    //   118: aload_1
    //   119: aload 4
    //   121: invokevirtual 57	cooperation/qzone/remote/logic/RemoteRequestSender:setUserTail	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   124: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	1
    //   8	111	1	localObject1	Object
    //   43	74	2	str1	String
    //   51	67	3	str2	String
    //   34	34	4	localObject2	Object
    //   72	1	4	localJSONException1	org.json.JSONException
    //   77	1	4	localJSONException2	org.json.JSONException
    //   85	1	4	localJSONException3	org.json.JSONException
    //   90	12	4	localJSONException4	org.json.JSONException
    //   108	12	4	str3	String
    //   2	105	5	str4	String
    // Exception table:
    //   from	to	target	type
    //   60	69	72	org/json/JSONException
    //   52	60	77	org/json/JSONException
    //   44	52	85	org/json/JSONException
    //   24	44	90	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */