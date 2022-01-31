package com.tencent.open.appcommon;

import android.content.Intent;
import java.util.HashSet;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class OpensdkServlet
  extends MSFServlet
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp", "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp" };
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 36	android/os/Bundle
    //   11: dup
    //   12: invokespecial 37	android/os/Bundle:<init>	()V
    //   15: astore 6
    //   17: aload_2
    //   18: invokevirtual 43	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   21: astore 9
    //   23: aload 9
    //   25: ifnull +96 -> 121
    //   28: aload 9
    //   30: arraylength
    //   31: iconst_4
    //   32: if_icmple +89 -> 121
    //   35: new 45	java/io/ByteArrayInputStream
    //   38: dup
    //   39: aload 9
    //   41: invokespecial 48	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore 7
    //   46: new 50	java/io/DataInputStream
    //   49: dup
    //   50: aload 7
    //   52: invokespecial 53	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore 8
    //   57: aload 8
    //   59: invokevirtual 57	java/io/DataInputStream:readInt	()I
    //   62: iconst_4
    //   63: isub
    //   64: istore_3
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 10
    //   70: aload 9
    //   72: iconst_4
    //   73: aload 10
    //   75: iconst_0
    //   76: iload_3
    //   77: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: aload 6
    //   82: ldc 65
    //   84: aload 10
    //   86: invokevirtual 69	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   89: aload 6
    //   91: ldc 71
    //   93: aload_2
    //   94: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   97: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   100: aload 6
    //   102: ldc 80
    //   104: aload_2
    //   105: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   108: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 7
    //   113: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   116: aload 8
    //   118: invokevirtual 92	java/io/DataInputStream:close	()V
    //   121: aload_2
    //   122: invokevirtual 95	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   125: astore 7
    //   127: getstatic 21	com/tencent/open/appcommon/OpensdkServlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   130: astore 8
    //   132: aload 8
    //   134: arraylength
    //   135: istore 5
    //   137: iconst_0
    //   138: istore_3
    //   139: iload_3
    //   140: iload 5
    //   142: if_icmpge +329 -> 471
    //   145: aload 8
    //   147: iload_3
    //   148: aaload
    //   149: aload 7
    //   151: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +275 -> 429
    //   157: iload 4
    //   159: istore_3
    //   160: iload_3
    //   161: ifeq +286 -> 447
    //   164: aload_1
    //   165: ldc 101
    //   167: invokevirtual 106	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   170: invokevirtual 112	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   173: checkcast 101	com/tencent/qphone/base/remote/ToServiceMsg
    //   176: astore 7
    //   178: new 114	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   185: aload_2
    //   186: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   189: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 121
    //   194: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 95	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   201: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 121
    //   206: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 7
    //   211: ldc 123
    //   213: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   216: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 7
    //   224: aload_0
    //   225: getfield 30	com/tencent/open/appcommon/OpensdkServlet:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   228: aload 7
    //   230: invokevirtual 136	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   233: ifeq +44 -> 277
    //   236: aload_0
    //   237: getfield 30	com/tencent/open/appcommon/OpensdkServlet:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   240: aload 7
    //   242: invokevirtual 139	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   245: pop
    //   246: aload_2
    //   247: ldc 141
    //   249: invokevirtual 142	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   252: ifnonnull +184 -> 436
    //   255: aload 6
    //   257: ldc 144
    //   259: iconst_0
    //   260: invokevirtual 148	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   263: aload_0
    //   264: aload_1
    //   265: iconst_0
    //   266: aload_2
    //   267: invokevirtual 152	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   270: aload 6
    //   272: ldc 154
    //   274: invokevirtual 158	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   277: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -273 -> 7
    //   283: ldc 165
    //   285: iconst_2
    //   286: new 114	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   293: ldc 167
    //   295: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 7
    //   300: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc 169
    //   305: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_2
    //   309: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getAppId	()I
    //   312: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc 177
    //   317: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   324: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc 182
    //   329: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   336: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: ldc 184
    //   341: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_2
    //   345: invokevirtual 95	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   348: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 186
    //   353: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_2
    //   357: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   360: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc 188
    //   365: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_2
    //   369: ldc 141
    //   371: invokevirtual 142	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   374: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: return
    //   384: astore_1
    //   385: ldc 165
    //   387: iconst_2
    //   388: aload_1
    //   389: invokevirtual 193	java/lang/Exception:toString	()Ljava/lang/String;
    //   392: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: return
    //   396: astore 9
    //   398: aload 7
    //   400: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   403: aload 8
    //   405: invokevirtual 92	java/io/DataInputStream:close	()V
    //   408: goto -287 -> 121
    //   411: astore 7
    //   413: goto -292 -> 121
    //   416: astore_1
    //   417: aload 7
    //   419: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   422: aload 8
    //   424: invokevirtual 92	java/io/DataInputStream:close	()V
    //   427: aload_1
    //   428: athrow
    //   429: iload_3
    //   430: iconst_1
    //   431: iadd
    //   432: istore_3
    //   433: goto -294 -> 139
    //   436: aload 6
    //   438: ldc 144
    //   440: iconst_1
    //   441: invokevirtual 148	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   444: goto -181 -> 263
    //   447: aload_0
    //   448: aload_1
    //   449: iconst_0
    //   450: aload_2
    //   451: invokevirtual 152	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   454: aload 6
    //   456: ldc 154
    //   458: invokevirtual 158	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   461: return
    //   462: astore_2
    //   463: goto -36 -> 427
    //   466: astore 7
    //   468: goto -347 -> 121
    //   471: iconst_0
    //   472: istore_3
    //   473: goto -313 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	OpensdkServlet
    //   0	476	1	paramIntent	Intent
    //   0	476	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   64	409	3	i	int
    //   1	157	4	j	int
    //   135	8	5	k	int
    //   15	440	6	localBundle	android.os.Bundle
    //   44	355	7	localObject1	java.lang.Object
    //   411	7	7	localException1	java.lang.Exception
    //   466	1	7	localException2	java.lang.Exception
    //   55	368	8	localObject2	java.lang.Object
    //   21	50	9	arrayOfByte1	byte[]
    //   396	1	9	localException3	java.lang.Exception
    //   68	17	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	137	384	java/lang/Exception
    //   145	157	384	java/lang/Exception
    //   164	263	384	java/lang/Exception
    //   263	277	384	java/lang/Exception
    //   277	383	384	java/lang/Exception
    //   436	444	384	java/lang/Exception
    //   447	461	384	java/lang/Exception
    //   57	111	396	java/lang/Exception
    //   398	408	411	java/lang/Exception
    //   57	111	416	finally
    //   417	427	462	java/lang/Exception
    //   111	121	466	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  /* Error */
  public void service(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 202	mqq/app/MSFServlet:service	(Landroid/content/Intent;)V
    //   5: aload_1
    //   6: ldc 204
    //   8: invokevirtual 208	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 7
    //   13: aload_1
    //   14: ldc 210
    //   16: invokevirtual 208	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 8
    //   21: new 101	com/tencent/qphone/base/remote/ToServiceMsg
    //   24: dup
    //   25: aconst_null
    //   26: aload 8
    //   28: aload 7
    //   30: invokespecial 213	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   33: astore 6
    //   35: aload_1
    //   36: ldc 65
    //   38: invokevirtual 217	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   41: astore 11
    //   43: new 219	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: aload 11
    //   49: arraylength
    //   50: iconst_4
    //   51: iadd
    //   52: invokespecial 222	java/io/ByteArrayOutputStream:<init>	(I)V
    //   55: astore 9
    //   57: new 224	java/io/DataOutputStream
    //   60: dup
    //   61: aload 9
    //   63: invokespecial 227	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore 10
    //   68: aload 10
    //   70: aload 11
    //   72: arraylength
    //   73: iconst_4
    //   74: iadd
    //   75: invokevirtual 230	java/io/DataOutputStream:writeInt	(I)V
    //   78: aload 10
    //   80: aload 11
    //   82: invokevirtual 233	java/io/DataOutputStream:write	([B)V
    //   85: aload 6
    //   87: aload 9
    //   89: invokevirtual 236	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   92: invokevirtual 239	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   95: aload 9
    //   97: invokevirtual 240	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 10
    //   102: invokevirtual 241	java/io/DataOutputStream:close	()V
    //   105: aload 6
    //   107: aload_1
    //   108: ldc 243
    //   110: ldc2_w 244
    //   113: invokevirtual 249	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   116: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   119: aload 6
    //   121: ldc 255
    //   123: ldc_w 257
    //   126: invokevirtual 261	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: getstatic 21	com/tencent/open/appcommon/OpensdkServlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   133: astore 9
    //   135: aload 9
    //   137: arraylength
    //   138: istore_3
    //   139: iconst_0
    //   140: istore_2
    //   141: iload_2
    //   142: iload_3
    //   143: if_icmpge +120 -> 263
    //   146: aload 9
    //   148: iload_2
    //   149: aaload
    //   150: aload 7
    //   152: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +161 -> 316
    //   158: aload 6
    //   160: iconst_1
    //   161: iconst_1
    //   162: invokevirtual 265	com/tencent/qphone/base/remote/ToServiceMsg:setQuickSend	(ZI)V
    //   165: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   168: lstore 4
    //   170: aload 6
    //   172: ldc 123
    //   174: lload 4
    //   176: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: invokevirtual 261	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: new 114	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   190: aload 8
    //   192: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 121
    //   197: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 7
    //   202: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 121
    //   207: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload 4
    //   212: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore 7
    //   220: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +30 -> 253
    //   226: ldc 165
    //   228: iconst_2
    //   229: new 114	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 280
    //   239: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 7
    //   244: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: getfield 30	com/tencent/open/appcommon/OpensdkServlet:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   257: aload 7
    //   259: invokevirtual 283	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: aload_1
    //   264: ldc 101
    //   266: invokevirtual 106	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   269: aload 6
    //   271: invokevirtual 287	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   274: pop
    //   275: aload_0
    //   276: aload_1
    //   277: aload 6
    //   279: invokevirtual 291	com/tencent/open/appcommon/OpensdkServlet:sendToMSF	(Landroid/content/Intent;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   282: return
    //   283: astore 11
    //   285: aload 9
    //   287: invokevirtual 240	java/io/ByteArrayOutputStream:close	()V
    //   290: aload 10
    //   292: invokevirtual 241	java/io/DataOutputStream:close	()V
    //   295: goto -190 -> 105
    //   298: astore 9
    //   300: goto -195 -> 105
    //   303: astore_1
    //   304: aload 9
    //   306: invokevirtual 240	java/io/ByteArrayOutputStream:close	()V
    //   309: aload 10
    //   311: invokevirtual 241	java/io/DataOutputStream:close	()V
    //   314: aload_1
    //   315: athrow
    //   316: iload_2
    //   317: iconst_1
    //   318: iadd
    //   319: istore_2
    //   320: goto -179 -> 141
    //   323: astore 6
    //   325: goto -11 -> 314
    //   328: astore 9
    //   330: goto -225 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	OpensdkServlet
    //   0	333	1	paramIntent	Intent
    //   140	180	2	i	int
    //   138	6	3	j	int
    //   168	43	4	l	long
    //   33	245	6	localToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   323	1	6	localException1	java.lang.Exception
    //   11	247	7	str1	String
    //   19	172	8	str2	String
    //   55	231	9	localObject	java.lang.Object
    //   298	7	9	localException2	java.lang.Exception
    //   328	1	9	localException3	java.lang.Exception
    //   66	244	10	localDataOutputStream	java.io.DataOutputStream
    //   41	40	11	arrayOfByte	byte[]
    //   283	1	11	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   68	95	283	java/lang/Exception
    //   285	295	298	java/lang/Exception
    //   68	95	303	finally
    //   304	314	323	java/lang/Exception
    //   95	105	328	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.OpensdkServlet
 * JD-Core Version:    0.7.0.1
 */