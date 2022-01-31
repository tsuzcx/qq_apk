import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;

public class pij
  implements Runnable
{
  public pij(WeizhengquanJsPlugin paramWeizhengquanJsPlugin, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 28	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 29	org/json/JSONObject:<init>	()V
    //   9: astore 5
    //   11: new 31	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: getfield 15	pij:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 6
    //   24: aload 6
    //   26: invokevirtual 38	java/io/File:exists	()Z
    //   29: ifeq +187 -> 216
    //   32: aload 6
    //   34: invokevirtual 42	java/io/File:length	()J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +177 -> 216
    //   42: new 44	java/io/FileInputStream
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore 4
    //   53: aload 4
    //   55: astore_3
    //   56: sipush 4096
    //   59: newarray byte
    //   61: astore 7
    //   63: aload 4
    //   65: astore_3
    //   66: aload 6
    //   68: invokevirtual 42	java/io/File:length	()J
    //   71: l2i
    //   72: newarray byte
    //   74: astore 8
    //   76: aload 4
    //   78: astore_3
    //   79: aload 4
    //   81: aload 7
    //   83: invokevirtual 51	java/io/FileInputStream:read	([B)I
    //   86: istore_2
    //   87: iload_2
    //   88: ifle +23 -> 111
    //   91: aload 4
    //   93: astore_3
    //   94: aload 7
    //   96: iconst_0
    //   97: aload 8
    //   99: iload_1
    //   100: iload_2
    //   101: invokestatic 57	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   104: iload_1
    //   105: iload_2
    //   106: iadd
    //   107: istore_1
    //   108: goto -32 -> 76
    //   111: aload 4
    //   113: astore_3
    //   114: aload 8
    //   116: iconst_0
    //   117: invokestatic 63	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   120: astore 7
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: ldc 65
    //   129: iconst_1
    //   130: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload 4
    //   136: astore_3
    //   137: aload 5
    //   139: ldc 71
    //   141: ldc 73
    //   143: invokevirtual 76	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: ldc 78
    //   154: aload 7
    //   156: invokevirtual 76	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload 4
    //   162: astore_3
    //   163: aload_0
    //   164: getfield 13	pij:jdField_a_of_type_ComTencentBizWebviewpluginWeizhengquanJsPlugin	Lcom/tencent/biz/webviewplugin/WeizhengquanJsPlugin;
    //   167: getfield 81	com/tencent/biz/webviewplugin/WeizhengquanJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +32 -> 205
    //   176: aload 4
    //   178: astore_3
    //   179: aload_0
    //   180: getfield 13	pij:jdField_a_of_type_ComTencentBizWebviewpluginWeizhengquanJsPlugin	Lcom/tencent/biz/webviewplugin/WeizhengquanJsPlugin;
    //   183: aload_0
    //   184: getfield 13	pij:jdField_a_of_type_ComTencentBizWebviewpluginWeizhengquanJsPlugin	Lcom/tencent/biz/webviewplugin/WeizhengquanJsPlugin;
    //   187: getfield 81	com/tencent/biz/webviewplugin/WeizhengquanJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: iconst_1
    //   191: anewarray 89	java/lang/String
    //   194: dup
    //   195: iconst_0
    //   196: aload 5
    //   198: invokevirtual 93	org/json/JSONObject:toString	()Ljava/lang/String;
    //   201: aastore
    //   202: invokevirtual 97	com/tencent/biz/webviewplugin/WeizhengquanJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   205: aload 4
    //   207: invokevirtual 100	java/io/FileInputStream:close	()V
    //   210: aload 6
    //   212: invokevirtual 103	java/io/File:delete	()Z
    //   215: pop
    //   216: return
    //   217: astore 5
    //   219: aload 4
    //   221: astore_3
    //   222: aload 5
    //   224: invokevirtual 106	org/json/JSONException:printStackTrace	()V
    //   227: goto -22 -> 205
    //   230: astore 5
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: invokevirtual 107	java/io/FileNotFoundException:printStackTrace	()V
    //   240: aload 4
    //   242: invokevirtual 100	java/io/FileInputStream:close	()V
    //   245: aload 6
    //   247: invokevirtual 103	java/io/File:delete	()Z
    //   250: pop
    //   251: return
    //   252: astore_3
    //   253: aload_3
    //   254: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   257: return
    //   258: astore_3
    //   259: aload_3
    //   260: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   263: return
    //   264: astore 5
    //   266: aconst_null
    //   267: astore 4
    //   269: aload 4
    //   271: astore_3
    //   272: aload 5
    //   274: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   277: aload 4
    //   279: invokevirtual 100	java/io/FileInputStream:close	()V
    //   282: aload 6
    //   284: invokevirtual 103	java/io/File:delete	()Z
    //   287: pop
    //   288: return
    //   289: astore_3
    //   290: aload_3
    //   291: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   294: return
    //   295: astore 4
    //   297: aconst_null
    //   298: astore_3
    //   299: aload_3
    //   300: invokevirtual 100	java/io/FileInputStream:close	()V
    //   303: aload 6
    //   305: invokevirtual 103	java/io/File:delete	()Z
    //   308: pop
    //   309: aload 4
    //   311: athrow
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   317: goto -8 -> 309
    //   320: astore 4
    //   322: goto -23 -> 299
    //   325: astore 5
    //   327: goto -58 -> 269
    //   330: astore 5
    //   332: aconst_null
    //   333: astore 4
    //   335: goto -103 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	pij
    //   1	107	1	i	int
    //   86	21	2	j	int
    //   55	180	3	localFileInputStream1	java.io.FileInputStream
    //   252	2	3	localIOException1	java.io.IOException
    //   258	2	3	localIOException2	java.io.IOException
    //   271	1	3	localFileInputStream2	java.io.FileInputStream
    //   289	2	3	localIOException3	java.io.IOException
    //   298	2	3	localObject1	Object
    //   312	2	3	localIOException4	java.io.IOException
    //   51	227	4	localFileInputStream3	java.io.FileInputStream
    //   295	15	4	localObject2	Object
    //   320	1	4	localObject3	Object
    //   333	1	4	localObject4	Object
    //   9	188	5	localJSONObject	org.json.JSONObject
    //   217	6	5	localJSONException	org.json.JSONException
    //   230	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   264	9	5	localIOException5	java.io.IOException
    //   325	1	5	localIOException6	java.io.IOException
    //   330	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   22	282	6	localFile	java.io.File
    //   61	94	7	localObject5	Object
    //   74	41	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   125	134	217	org/json/JSONException
    //   137	147	217	org/json/JSONException
    //   150	160	217	org/json/JSONException
    //   163	176	217	org/json/JSONException
    //   179	205	217	org/json/JSONException
    //   56	63	230	java/io/FileNotFoundException
    //   66	76	230	java/io/FileNotFoundException
    //   79	87	230	java/io/FileNotFoundException
    //   94	104	230	java/io/FileNotFoundException
    //   114	122	230	java/io/FileNotFoundException
    //   125	134	230	java/io/FileNotFoundException
    //   137	147	230	java/io/FileNotFoundException
    //   150	160	230	java/io/FileNotFoundException
    //   163	176	230	java/io/FileNotFoundException
    //   179	205	230	java/io/FileNotFoundException
    //   222	227	230	java/io/FileNotFoundException
    //   240	251	252	java/io/IOException
    //   205	216	258	java/io/IOException
    //   42	53	264	java/io/IOException
    //   277	288	289	java/io/IOException
    //   42	53	295	finally
    //   299	309	312	java/io/IOException
    //   56	63	320	finally
    //   66	76	320	finally
    //   79	87	320	finally
    //   94	104	320	finally
    //   114	122	320	finally
    //   125	134	320	finally
    //   137	147	320	finally
    //   150	160	320	finally
    //   163	176	320	finally
    //   179	205	320	finally
    //   222	227	320	finally
    //   235	240	320	finally
    //   272	277	320	finally
    //   56	63	325	java/io/IOException
    //   66	76	325	java/io/IOException
    //   79	87	325	java/io/IOException
    //   94	104	325	java/io/IOException
    //   114	122	325	java/io/IOException
    //   125	134	325	java/io/IOException
    //   137	147	325	java/io/IOException
    //   150	160	325	java/io/IOException
    //   163	176	325	java/io/IOException
    //   179	205	325	java/io/IOException
    //   222	227	325	java/io/IOException
    //   42	53	330	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pij
 * JD-Core Version:    0.7.0.1
 */