package cooperation.plugin;

import bfeg;

public class PluginPreInstaller$2
  implements Runnable
{
  public PluginPreInstaller$2(bfeg parambfeg) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	cooperation/plugin/PluginPreInstaller$2:this$0	Lbfeg;
    //   4: invokestatic 25	bfeg:a	(Lbfeg;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 12	cooperation/plugin/PluginPreInstaller$2:this$0	Lbfeg;
    //   15: invokestatic 25	bfeg:a	(Lbfeg;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 31	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +18 -> 46
    //   31: invokestatic 43	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   34: ifeq -24 -> 10
    //   37: ldc 45
    //   39: iconst_4
    //   40: ldc 47
    //   42: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: return
    //   46: aconst_null
    //   47: astore_3
    //   48: aconst_null
    //   49: astore 5
    //   51: aload_3
    //   52: astore_2
    //   53: iconst_1
    //   54: aload_0
    //   55: getfield 12	cooperation/plugin/PluginPreInstaller$2:this$0	Lbfeg;
    //   58: invokestatic 25	bfeg:a	(Lbfeg;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokestatic 56	bflp:a	(ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 12	cooperation/plugin/PluginPreInstaller$2:this$0	Lbfeg;
    //   70: invokestatic 25	bfeg:a	(Lbfeg;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokestatic 62	cooperation/qqreader/QRBridgeUtil:getSKey	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   76: astore 6
    //   78: aload_3
    //   79: astore_2
    //   80: new 64	java/net/URL
    //   83: dup
    //   84: new 66	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   91: ldc 69
    //   93: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 6
    //   98: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 75
    //   103: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   115: checkcast 87	java/net/HttpURLConnection
    //   118: astore_3
    //   119: aload_3
    //   120: sipush 10000
    //   123: invokevirtual 91	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   126: aload_3
    //   127: sipush 10000
    //   130: invokevirtual 94	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   133: aload_3
    //   134: ldc 96
    //   136: new 66	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   143: ldc 98
    //   145: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 4
    //   150: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 100
    //   155: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 4
    //   160: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 102
    //   165: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 6
    //   170: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_3
    //   180: invokevirtual 110	java/net/HttpURLConnection:getResponseCode	()I
    //   183: sipush 200
    //   186: if_icmpne +141 -> 327
    //   189: new 112	java/io/BufferedReader
    //   192: dup
    //   193: new 114	java/io/InputStreamReader
    //   196: dup
    //   197: aload_3
    //   198: invokevirtual 118	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   201: invokespecial 121	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   204: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   207: astore_2
    //   208: new 126	java/lang/StringBuffer
    //   211: dup
    //   212: invokespecial 127	java/lang/StringBuffer:<init>	()V
    //   215: astore 4
    //   217: aload_2
    //   218: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: ifnull +32 -> 257
    //   228: aload 4
    //   230: aload 5
    //   232: invokevirtual 133	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: goto -19 -> 217
    //   239: astore 4
    //   241: aload_3
    //   242: astore_2
    //   243: aload 4
    //   245: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   248: aload_3
    //   249: ifnull -239 -> 10
    //   252: aload_3
    //   253: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   256: return
    //   257: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +32 -> 292
    //   263: ldc 45
    //   265: iconst_2
    //   266: new 66	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   273: ldc 144
    //   275: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 4
    //   280: invokevirtual 145	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   283: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: new 147	org/json/JSONObject
    //   295: dup
    //   296: aload 4
    //   298: invokevirtual 145	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   301: invokespecial 148	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   304: ldc 150
    //   306: invokevirtual 154	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   309: ldc 156
    //   311: invokevirtual 160	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   314: istore_1
    //   315: aload_0
    //   316: getfield 12	cooperation/plugin/PluginPreInstaller$2:this$0	Lbfeg;
    //   319: invokestatic 163	bfeg:a	(Lbfeg;)Landroid/content/Context;
    //   322: iload_1
    //   323: iconst_1
    //   324: invokestatic 168	bflo:a	(Landroid/content/Context;IZ)V
    //   327: aload_3
    //   328: ifnull -318 -> 10
    //   331: aload_3
    //   332: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   335: return
    //   336: astore 4
    //   338: aload_2
    //   339: astore_3
    //   340: aload 4
    //   342: astore_2
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   351: aload_2
    //   352: athrow
    //   353: astore_2
    //   354: goto -11 -> 343
    //   357: astore 4
    //   359: aload 5
    //   361: astore_3
    //   362: goto -121 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	2
    //   314	9	1	i	int
    //   52	300	2	localObject1	Object
    //   353	1	2	localObject2	Object
    //   47	315	3	localObject3	Object
    //   21	208	4	localObject4	Object
    //   239	58	4	localException1	java.lang.Exception
    //   336	5	4	localObject5	Object
    //   357	1	4	localException2	java.lang.Exception
    //   49	311	5	str1	java.lang.String
    //   76	93	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   119	217	239	java/lang/Exception
    //   217	223	239	java/lang/Exception
    //   228	236	239	java/lang/Exception
    //   257	292	239	java/lang/Exception
    //   292	327	239	java/lang/Exception
    //   53	64	336	finally
    //   66	78	336	finally
    //   80	119	336	finally
    //   243	248	336	finally
    //   119	217	353	finally
    //   217	223	353	finally
    //   228	236	353	finally
    //   257	292	353	finally
    //   292	327	353	finally
    //   53	64	357	java/lang/Exception
    //   66	78	357	java/lang/Exception
    //   80	119	357	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller.2
 * JD-Core Version:    0.7.0.1
 */