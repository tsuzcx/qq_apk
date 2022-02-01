package com.tencent.open.appcommon;

import android.content.Intent;
import java.util.HashSet;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class OpensdkServlet
  extends MSFServlet
{
  private static final String[] a = { "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp", "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp" };
  private HashSet<String> b = new HashSet();
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 38	android/os/Bundle
    //   8: dup
    //   9: invokespecial 39	android/os/Bundle:<init>	()V
    //   12: astore 6
    //   14: aload_2
    //   15: invokevirtual 45	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   18: astore 9
    //   20: aload 9
    //   22: ifnull +123 -> 145
    //   25: aload 9
    //   27: arraylength
    //   28: iconst_4
    //   29: if_icmple +116 -> 145
    //   32: new 47	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload 9
    //   38: invokespecial 50	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore 7
    //   43: new 52	java/io/DataInputStream
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 55	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore 8
    //   54: aload 8
    //   56: invokevirtual 59	java/io/DataInputStream:readInt	()I
    //   59: iconst_4
    //   60: isub
    //   61: istore_3
    //   62: iload_3
    //   63: newarray byte
    //   65: astore 10
    //   67: aload 9
    //   69: iconst_4
    //   70: aload 10
    //   72: iconst_0
    //   73: iload_3
    //   74: invokestatic 65	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   77: aload 6
    //   79: ldc 67
    //   81: aload 10
    //   83: invokevirtual 71	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   86: aload 6
    //   88: ldc 73
    //   90: aload_2
    //   91: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   94: invokevirtual 80	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   97: aload 6
    //   99: ldc 82
    //   101: aload_2
    //   102: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   105: invokevirtual 90	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 7
    //   110: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   113: aload 8
    //   115: invokevirtual 94	java/io/DataInputStream:close	()V
    //   118: goto +55 -> 173
    //   121: goto +52 -> 173
    //   124: astore_1
    //   125: aload 7
    //   127: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   130: aload 8
    //   132: invokevirtual 94	java/io/DataInputStream:close	()V
    //   135: aload_1
    //   136: athrow
    //   137: aload 7
    //   139: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   142: goto -29 -> 113
    //   145: sipush 1002
    //   148: aload_2
    //   149: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   152: if_icmpne +21 -> 173
    //   155: ldc 96
    //   157: iconst_1
    //   158: ldc 98
    //   160: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload 6
    //   165: ldc 73
    //   167: sipush 1002
    //   170: invokevirtual 80	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   173: aload_2
    //   174: invokevirtual 108	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   177: ifne +17 -> 194
    //   180: aload 6
    //   182: ldc 110
    //   184: aload_2
    //   185: invokevirtual 113	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   188: invokevirtual 90	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto +12 -> 203
    //   194: aload 6
    //   196: ldc 110
    //   198: ldc 115
    //   200: invokevirtual 90	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_2
    //   204: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   207: astore 7
    //   209: getstatic 23	com/tencent/open/appcommon/OpensdkServlet:a	[Ljava/lang/String;
    //   212: astore 8
    //   214: aload 8
    //   216: arraylength
    //   217: istore 4
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: iload 4
    //   224: if_icmpge +359 -> 583
    //   227: aload 8
    //   229: iload_3
    //   230: aaload
    //   231: aload 7
    //   233: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifeq +340 -> 576
    //   239: iconst_1
    //   240: istore_3
    //   241: goto +3 -> 244
    //   244: iload_3
    //   245: ifeq +291 -> 536
    //   248: aload_1
    //   249: ldc 124
    //   251: invokevirtual 129	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   254: invokevirtual 135	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   257: checkcast 124	com/tencent/qphone/base/remote/ToServiceMsg
    //   260: astore 7
    //   262: new 137	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   269: astore 8
    //   271: aload 8
    //   273: aload_2
    //   274: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   277: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 8
    //   283: ldc 144
    //   285: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 8
    //   291: aload_2
    //   292: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   295: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 8
    //   301: ldc 144
    //   303: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 8
    //   309: aload 7
    //   311: ldc 146
    //   313: invokevirtual 150	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   316: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 8
    //   322: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore 7
    //   327: aload_0
    //   328: getfield 32	com/tencent/open/appcommon/OpensdkServlet:b	Ljava/util/HashSet;
    //   331: aload 7
    //   333: invokevirtual 159	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   336: istore 5
    //   338: iload 5
    //   340: ifeq +59 -> 399
    //   343: aload_0
    //   344: getfield 32	com/tencent/open/appcommon/OpensdkServlet:b	Ljava/util/HashSet;
    //   347: aload 7
    //   349: invokevirtual 162	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   352: pop
    //   353: aload_2
    //   354: ldc 164
    //   356: invokevirtual 165	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   359: astore 8
    //   361: aload 8
    //   363: ifnonnull +14 -> 377
    //   366: aload 6
    //   368: ldc 167
    //   370: iconst_0
    //   371: invokevirtual 171	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   374: goto +11 -> 385
    //   377: aload 6
    //   379: ldc 167
    //   381: iconst_1
    //   382: invokevirtual 171	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   385: aload_0
    //   386: aload_1
    //   387: iconst_0
    //   388: aload_2
    //   389: invokevirtual 108	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   392: aload 6
    //   394: ldc 173
    //   396: invokevirtual 177	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   399: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +159 -> 561
    //   405: new 137	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   412: astore_1
    //   413: aload_1
    //   414: ldc 182
    //   416: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: aload 7
    //   423: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: ldc 184
    //   430: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload_1
    //   435: aload_2
    //   436: invokevirtual 187	com/tencent/qphone/base/remote/FromServiceMsg:getAppId	()I
    //   439: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_1
    //   444: ldc 192
    //   446: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_1
    //   451: aload_2
    //   452: invokevirtual 195	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   455: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_1
    //   460: ldc 197
    //   462: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_1
    //   467: aload_2
    //   468: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   471: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_1
    //   476: ldc 199
    //   478: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_1
    //   483: aload_2
    //   484: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   487: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_1
    //   492: ldc 201
    //   494: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_1
    //   499: aload_2
    //   500: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   503: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload_1
    //   508: ldc 203
    //   510: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_1
    //   515: aload_2
    //   516: ldc 164
    //   518: invokevirtual 165	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   521: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc 96
    //   527: iconst_2
    //   528: aload_1
    //   529: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: return
    //   536: aload_0
    //   537: aload_1
    //   538: iconst_0
    //   539: aload_2
    //   540: invokevirtual 108	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   543: aload 6
    //   545: ldc 173
    //   547: invokevirtual 177	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   550: return
    //   551: astore_1
    //   552: ldc 96
    //   554: iconst_1
    //   555: ldc 208
    //   557: aload_1
    //   558: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   561: return
    //   562: astore 9
    //   564: goto -427 -> 137
    //   567: astore 7
    //   569: goto -448 -> 121
    //   572: astore_2
    //   573: goto -438 -> 135
    //   576: iload_3
    //   577: iconst_1
    //   578: iadd
    //   579: istore_3
    //   580: goto -359 -> 221
    //   583: iconst_0
    //   584: istore_3
    //   585: goto -341 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	OpensdkServlet
    //   0	588	1	paramIntent	Intent
    //   0	588	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   61	524	3	i	int
    //   217	8	4	j	int
    //   336	3	5	bool	boolean
    //   12	532	6	localBundle	android.os.Bundle
    //   41	381	7	localObject1	java.lang.Object
    //   567	1	7	localException1	java.lang.Exception
    //   52	310	8	localObject2	java.lang.Object
    //   18	50	9	arrayOfByte1	byte[]
    //   562	1	9	localException2	java.lang.Exception
    //   65	17	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	108	124	finally
    //   203	219	551	java/lang/Exception
    //   227	239	551	java/lang/Exception
    //   248	338	551	java/lang/Exception
    //   343	361	551	java/lang/Exception
    //   366	374	551	java/lang/Exception
    //   377	385	551	java/lang/Exception
    //   385	399	551	java/lang/Exception
    //   399	535	551	java/lang/Exception
    //   536	550	551	java/lang/Exception
    //   54	108	562	java/lang/Exception
    //   108	113	567	java/lang/Exception
    //   113	118	567	java/lang/Exception
    //   137	142	567	java/lang/Exception
    //   125	135	572	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  /* Error */
  public void service(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 218	mqq/app/MSFServlet:service	(Landroid/content/Intent;)V
    //   5: aload_1
    //   6: ldc 220
    //   8: invokevirtual 224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 8
    //   13: aload_1
    //   14: ldc 226
    //   16: invokevirtual 224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 9
    //   21: new 124	com/tencent/qphone/base/remote/ToServiceMsg
    //   24: dup
    //   25: aconst_null
    //   26: aload 9
    //   28: aload 8
    //   30: invokespecial 229	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   33: astore 7
    //   35: aload_1
    //   36: ldc 67
    //   38: invokevirtual 233	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   41: astore 12
    //   43: new 235	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: aload 12
    //   49: arraylength
    //   50: iconst_4
    //   51: iadd
    //   52: invokespecial 238	java/io/ByteArrayOutputStream:<init>	(I)V
    //   55: astore 10
    //   57: new 240	java/io/DataOutputStream
    //   60: dup
    //   61: aload 10
    //   63: invokespecial 243	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore 11
    //   68: aload 11
    //   70: aload 12
    //   72: arraylength
    //   73: iconst_4
    //   74: iadd
    //   75: invokevirtual 246	java/io/DataOutputStream:writeInt	(I)V
    //   78: aload 11
    //   80: aload 12
    //   82: invokevirtual 249	java/io/DataOutputStream:write	([B)V
    //   85: aload 7
    //   87: aload 10
    //   89: invokevirtual 252	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   92: invokevirtual 255	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   95: aload 10
    //   97: invokevirtual 256	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 11
    //   102: invokevirtual 257	java/io/DataOutputStream:close	()V
    //   105: goto +27 -> 132
    //   108: goto +24 -> 132
    //   111: astore_1
    //   112: aload 10
    //   114: invokevirtual 256	java/io/ByteArrayOutputStream:close	()V
    //   117: aload 11
    //   119: invokevirtual 257	java/io/DataOutputStream:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: aload 10
    //   126: invokevirtual 256	java/io/ByteArrayOutputStream:close	()V
    //   129: goto -29 -> 100
    //   132: aload 7
    //   134: aload_1
    //   135: ldc_w 259
    //   138: ldc2_w 260
    //   141: invokevirtual 265	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   144: invokevirtual 269	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   147: aload 7
    //   149: ldc_w 271
    //   152: ldc_w 273
    //   155: invokevirtual 277	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_1
    //   160: ldc_w 279
    //   163: iconst_m1
    //   164: invokevirtual 283	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   167: istore_3
    //   168: iconst_0
    //   169: istore_2
    //   170: aload_1
    //   171: ldc_w 285
    //   174: iconst_0
    //   175: invokevirtual 289	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   178: ifeq +9 -> 187
    //   181: aload 7
    //   183: iconst_1
    //   184: invokevirtual 293	com/tencent/qphone/base/remote/ToServiceMsg:setIsSupportRetry	(Z)V
    //   187: getstatic 23	com/tencent/open/appcommon/OpensdkServlet:a	[Ljava/lang/String;
    //   190: astore 10
    //   192: aload 10
    //   194: arraylength
    //   195: istore 4
    //   197: iload_2
    //   198: iload 4
    //   200: if_icmpge +171 -> 371
    //   203: aload 10
    //   205: iload_2
    //   206: aaload
    //   207: aload 8
    //   209: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifeq +152 -> 364
    //   215: iload_3
    //   216: iconst_m1
    //   217: if_icmpeq +8 -> 225
    //   220: iload_3
    //   221: istore_2
    //   222: goto +5 -> 227
    //   225: iconst_1
    //   226: istore_2
    //   227: aload 7
    //   229: iconst_1
    //   230: iload_2
    //   231: invokevirtual 297	com/tencent/qphone/base/remote/ToServiceMsg:setQuickSend	(ZI)V
    //   234: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   237: lstore 5
    //   239: aload 7
    //   241: ldc 146
    //   243: lload 5
    //   245: invokestatic 307	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: invokevirtual 277	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: new 137	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   259: astore 10
    //   261: aload 10
    //   263: aload 9
    //   265: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 10
    //   271: ldc 144
    //   273: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 10
    //   279: aload 8
    //   281: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 10
    //   287: ldc 144
    //   289: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 10
    //   295: lload 5
    //   297: invokevirtual 310	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 10
    //   303: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore 8
    //   308: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +40 -> 351
    //   314: new 137	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   321: astore 9
    //   323: aload 9
    //   325: ldc_w 312
    //   328: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 9
    //   334: aload 8
    //   336: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: ldc 96
    //   342: iconst_2
    //   343: aload 9
    //   345: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_0
    //   352: getfield 32	com/tencent/open/appcommon/OpensdkServlet:b	Ljava/util/HashSet;
    //   355: aload 8
    //   357: invokevirtual 315	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   360: pop
    //   361: goto +10 -> 371
    //   364: iload_2
    //   365: iconst_1
    //   366: iadd
    //   367: istore_2
    //   368: goto -171 -> 197
    //   371: aload_1
    //   372: ldc 124
    //   374: invokevirtual 129	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   377: aload 7
    //   379: invokevirtual 319	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   382: pop
    //   383: aload_0
    //   384: aload_1
    //   385: aload 7
    //   387: invokevirtual 323	com/tencent/open/appcommon/OpensdkServlet:sendToMSF	(Landroid/content/Intent;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   390: return
    //   391: astore 12
    //   393: goto -269 -> 124
    //   396: astore 10
    //   398: goto -290 -> 108
    //   401: astore 7
    //   403: goto -281 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	OpensdkServlet
    //   0	406	1	paramIntent	Intent
    //   169	199	2	i	int
    //   167	54	3	j	int
    //   195	6	4	k	int
    //   237	59	5	l	long
    //   33	353	7	localToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   401	1	7	localException1	java.lang.Exception
    //   11	345	8	str	String
    //   19	325	9	localObject1	java.lang.Object
    //   55	247	10	localObject2	java.lang.Object
    //   396	1	10	localException2	java.lang.Exception
    //   66	52	11	localDataOutputStream	java.io.DataOutputStream
    //   41	40	12	arrayOfByte	byte[]
    //   391	1	12	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   68	95	111	finally
    //   68	95	391	java/lang/Exception
    //   95	100	396	java/lang/Exception
    //   100	105	396	java/lang/Exception
    //   124	129	396	java/lang/Exception
    //   112	122	401	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.OpensdkServlet
 * JD-Core Version:    0.7.0.1
 */