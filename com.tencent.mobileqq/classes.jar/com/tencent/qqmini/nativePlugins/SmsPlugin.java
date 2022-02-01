package com.tencent.qqmini.nativePlugins;

import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

public class SmsPlugin
  extends BaseJsPlugin
{
  /* Error */
  @com.tencent.qqmini.sdk.annotation.JsEvent({"sendMsg"})
  public void sendMsg(com.tencent.qqmini.sdk.launcher.core.model.RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: ldc 17
    //   2: astore_2
    //   3: ldc 19
    //   5: iconst_1
    //   6: ldc 21
    //   8: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: getfield 31	com/tencent/qqmini/nativePlugins/SmsPlugin:mContext	Landroid/content/Context;
    //   15: ifnonnull +12 -> 27
    //   18: ldc 19
    //   20: iconst_1
    //   21: ldc 33
    //   23: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_1
    //   28: getfield 39	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   31: astore 5
    //   33: new 41	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: ldc 46
    //   44: invokevirtual 50	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   47: astore 4
    //   49: aload 4
    //   51: ldc 52
    //   53: ldc 17
    //   55: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: aload 4
    //   63: ldc 58
    //   65: ldc 17
    //   67: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: new 60	android/content/Intent
    //   76: dup
    //   77: ldc 62
    //   79: invokespecial 63	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: ldc 65
    //   90: invokestatic 71	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   93: invokevirtual 75	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   96: pop
    //   97: aload_2
    //   98: astore_1
    //   99: aload 4
    //   101: ldc 77
    //   103: invokevirtual 81	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   106: pop
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: ldc 83
    //   113: aload_3
    //   114: invokevirtual 87	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   117: pop
    //   118: aload_2
    //   119: astore_1
    //   120: aload 4
    //   122: ldc 89
    //   124: aload_2
    //   125: invokevirtual 87	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   128: pop
    //   129: aload_2
    //   130: astore_1
    //   131: aload_0
    //   132: getfield 31	com/tencent/qqmini/nativePlugins/SmsPlugin:mContext	Landroid/content/Context;
    //   135: aload 4
    //   137: invokevirtual 95	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   140: return
    //   141: astore 4
    //   143: goto +10 -> 153
    //   146: astore 4
    //   148: ldc 17
    //   150: astore_3
    //   151: aload_2
    //   152: astore_1
    //   153: ldc 19
    //   155: iconst_1
    //   156: iconst_4
    //   157: anewarray 97	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: ldc 99
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 4
    //   169: invokevirtual 103	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: ldc 105
    //   177: aastore
    //   178: dup
    //   179: iconst_3
    //   180: aload 5
    //   182: aastore
    //   183: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   186: new 60	android/content/Intent
    //   189: dup
    //   190: ldc 111
    //   192: invokespecial 63	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   195: astore_2
    //   196: new 113	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   203: astore 4
    //   205: aload 4
    //   207: ldc 65
    //   209: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: aload_3
    //   216: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: aload 4
    //   223: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 71	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   229: invokevirtual 75	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   232: pop
    //   233: aload_2
    //   234: ldc 89
    //   236: aload_1
    //   237: invokevirtual 87	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   240: pop
    //   241: aload_0
    //   242: getfield 31	com/tencent/qqmini/nativePlugins/SmsPlugin:mContext	Landroid/content/Context;
    //   245: aload_2
    //   246: invokevirtual 95	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   249: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	SmsPlugin
    //   0	250	1	paramRequestEvent	com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    //   2	244	2	localObject1	java.lang.Object
    //   58	158	3	str1	java.lang.String
    //   47	89	4	localObject2	java.lang.Object
    //   141	1	4	localException1	java.lang.Exception
    //   146	22	4	localException2	java.lang.Exception
    //   203	19	4	localStringBuilder	java.lang.StringBuilder
    //   31	150	5	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   61	71	141	java/lang/Exception
    //   73	84	141	java/lang/Exception
    //   86	97	141	java/lang/Exception
    //   99	107	141	java/lang/Exception
    //   109	118	141	java/lang/Exception
    //   120	129	141	java/lang/Exception
    //   131	140	141	java/lang/Exception
    //   33	59	146	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.SmsPlugin
 * JD-Core Version:    0.7.0.1
 */