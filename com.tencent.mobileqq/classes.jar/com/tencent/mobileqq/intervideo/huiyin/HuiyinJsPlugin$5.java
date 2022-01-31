package com.tencent.mobileqq.intervideo.huiyin;

public class HuiyinJsPlugin$5
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 22	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckReq
    //   3: dup
    //   4: invokespecial 25	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckReq:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 29	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckReq:refresh	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   12: iconst_0
    //   13: invokevirtual 35	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   16: new 37	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest
    //   19: dup
    //   20: invokespecial 38	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: getfield 42	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   28: sipush 10401
    //   31: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   34: aload_3
    //   35: getfield 51	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   38: lconst_0
    //   39: invokevirtual 56	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   42: aload_3
    //   43: getfield 60	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:openid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   46: aload_0
    //   47: getfield 62	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokevirtual 67	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   53: aload_3
    //   54: getfield 71	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:auth_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   57: aload_0
    //   58: getfield 73	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:b	Ljava/lang/String;
    //   61: invokevirtual 79	java/lang/String:getBytes	()[B
    //   64: invokestatic 85	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   67: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   70: aload_3
    //   71: getfield 94	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:auth_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   74: iconst_1
    //   75: invokevirtual 97	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   78: aload_3
    //   79: getfield 100	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:microtime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   85: invokevirtual 56	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   88: aload_3
    //   89: getfield 109	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:client_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   92: iconst_2
    //   93: invokevirtual 97	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   96: aload_3
    //   97: getfield 112	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:auth_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   100: aload_0
    //   101: getfield 114	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:c	Ljava/lang/String;
    //   104: invokestatic 120	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   107: invokevirtual 56	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   110: aload_3
    //   111: getfield 123	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:client_release	Lcom/tencent/mobileqq/pb/PBStringField;
    //   114: ldc 125
    //   116: invokevirtual 67	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   119: aload_3
    //   120: getfield 128	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:body	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: aload_2
    //   124: invokevirtual 131	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckReq:toByteArray	()[B
    //   127: invokestatic 85	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   133: new 133	java/net/URL
    //   136: dup
    //   137: new 135	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   144: ldc 138
    //   146: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 144
    //   151: ldc 146
    //   153: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   156: iconst_1
    //   157: aaload
    //   158: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 152
    //   163: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 158	java/net/URL:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: ifnonnull +14 -> 188
    //   177: return
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 161	java/net/MalformedURLException:printStackTrace	()V
    //   183: aconst_null
    //   184: astore_2
    //   185: goto -12 -> 173
    //   188: aload_2
    //   189: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull -17 -> 177
    //   197: aload_2
    //   198: instanceof 167
    //   201: ifeq -24 -> 177
    //   204: aload_2
    //   205: checkcast 167	javax/net/ssl/HttpsURLConnection
    //   208: astore_2
    //   209: aload_2
    //   210: ldc 169
    //   212: invokevirtual 172	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   215: aload_2
    //   216: iconst_1
    //   217: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   220: new 177	java/io/DataOutputStream
    //   223: dup
    //   224: aload_2
    //   225: invokevirtual 181	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   228: invokespecial 184	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   231: astore 4
    //   233: aload 4
    //   235: aload_3
    //   236: invokevirtual 185	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commRequest:toByteArray	()[B
    //   239: invokevirtual 189	java/io/DataOutputStream:write	([B)V
    //   242: aload 4
    //   244: invokevirtual 192	java/io/DataOutputStream:flush	()V
    //   247: aload 4
    //   249: invokevirtual 195	java/io/DataOutputStream:close	()V
    //   252: aload_2
    //   253: invokestatic 201	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   256: invokevirtual 205	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   259: invokevirtual 209	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   262: aload_2
    //   263: invokevirtual 213	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   266: sipush 200
    //   269: if_icmpne +105 -> 374
    //   272: new 215	java/io/BufferedInputStream
    //   275: dup
    //   276: aload_2
    //   277: invokevirtual 219	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   280: invokespecial 222	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   283: astore 4
    //   285: new 224	java/io/ByteArrayOutputStream
    //   288: dup
    //   289: sipush 1024
    //   292: invokespecial 226	java/io/ByteArrayOutputStream:<init>	(I)V
    //   295: astore 5
    //   297: aload 4
    //   299: invokevirtual 229	java/io/BufferedInputStream:read	()I
    //   302: istore_1
    //   303: iload_1
    //   304: iconst_m1
    //   305: if_icmpeq +20 -> 325
    //   308: aload 5
    //   310: iload_1
    //   311: invokevirtual 231	java/io/ByteArrayOutputStream:write	(I)V
    //   314: goto -17 -> 297
    //   317: astore_3
    //   318: aload_2
    //   319: invokevirtual 234	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   322: return
    //   323: astore_2
    //   324: return
    //   325: aload 5
    //   327: invokevirtual 235	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   330: astore_3
    //   331: aload 4
    //   333: invokevirtual 236	java/io/BufferedInputStream:close	()V
    //   336: aload 5
    //   338: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   341: new 239	org/json/JSONObject
    //   344: dup
    //   345: new 75	java/lang/String
    //   348: dup
    //   349: aload_3
    //   350: invokespecial 241	java/lang/String:<init>	([B)V
    //   353: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   356: astore 4
    //   358: aload 4
    //   360: ldc 244
    //   362: invokevirtual 248	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   365: pop
    //   366: aload 4
    //   368: ldc 250
    //   370: invokevirtual 254	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   373: pop
    //   374: aload_2
    //   375: invokevirtual 234	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   378: return
    //   379: astore 4
    //   381: new 256	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commResponse
    //   384: dup
    //   385: invokespecial 257	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commResponse:<init>	()V
    //   388: astore 4
    //   390: aload 4
    //   392: aload_3
    //   393: invokevirtual 261	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   396: pop
    //   397: new 263	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp
    //   400: dup
    //   401: invokespecial 264	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp:<init>	()V
    //   404: astore_3
    //   405: aload_3
    //   406: aload 4
    //   408: getfield 265	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$commResponse:body	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   411: invokevirtual 269	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   414: invokevirtual 270	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   417: invokevirtual 271	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   420: pop
    //   421: aload_0
    //   422: getfield 273	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:this$0	Lasxr;
    //   425: aload_3
    //   426: getfield 276	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp:uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   429: invokevirtual 278	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   432: putfield 283	asxr:jdField_a_of_type_Long	J
    //   435: aload_0
    //   436: getfield 273	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:this$0	Lasxr;
    //   439: aload_3
    //   440: getfield 286	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp:a2_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   443: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   446: putfield 289	asxr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   449: aload_0
    //   450: getfield 273	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:this$0	Lasxr;
    //   453: aload_3
    //   454: getfield 292	com/tencent/mobileqq/intervideo/huiyin/HuiyinProto$LoginCheckRsp:user_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   457: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   460: putfield 293	asxr:c	Ljava/lang/String;
    //   463: ldc_w 295
    //   466: new 135	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 297
    //   476: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: getfield 273	com/tencent/mobileqq/intervideo/huiyin/HuiyinJsPlugin$5:this$0	Lasxr;
    //   483: getfield 283	asxr:jdField_a_of_type_Long	J
    //   486: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   495: pop
    //   496: goto -122 -> 374
    //   499: astore_3
    //   500: aload_2
    //   501: invokevirtual 234	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   504: aload_3
    //   505: athrow
    //   506: astore_2
    //   507: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	5
    //   302	9	1	i	int
    //   7	167	2	localObject1	Object
    //   178	2	2	localMalformedURLException	java.net.MalformedURLException
    //   184	135	2	localObject2	Object
    //   323	178	2	localException1	java.lang.Exception
    //   506	1	2	localNumberFormatException	java.lang.NumberFormatException
    //   23	213	3	localcommRequest	HuiyinProto.commRequest
    //   317	1	3	localException2	java.lang.Exception
    //   330	124	3	localObject3	Object
    //   499	6	3	localObject4	Object
    //   231	136	4	localObject5	Object
    //   379	1	4	localException3	java.lang.Exception
    //   388	19	4	localcommResponse	HuiyinProto.commResponse
    //   295	42	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   133	173	178	java/net/MalformedURLException
    //   252	297	317	java/lang/Exception
    //   297	303	317	java/lang/Exception
    //   308	314	317	java/lang/Exception
    //   325	341	317	java/lang/Exception
    //   381	496	317	java/lang/Exception
    //   188	193	323	java/lang/Exception
    //   197	252	323	java/lang/Exception
    //   318	322	323	java/lang/Exception
    //   374	378	323	java/lang/Exception
    //   500	506	323	java/lang/Exception
    //   341	374	379	java/lang/Exception
    //   252	297	499	finally
    //   297	303	499	finally
    //   308	314	499	finally
    //   325	341	499	finally
    //   341	374	499	finally
    //   381	496	499	finally
    //   96	110	506	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */