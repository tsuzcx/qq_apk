package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;

public class OldBigDataChannelManager
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new OldBigDataChannelManager.1(this);
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private byte[] b = null;
  
  public OldBigDataChannelManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    c();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: new 52	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 53	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 55	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 58	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   32: arraylength
    //   33: ifne +127 -> 160
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   49: ifnull +13 -> 62
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   58: arraylength
    //   59: ifne +175 -> 234
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: iconst_0
    //   66: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 26	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   76: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 24	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   86: invokevirtual 66	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 69	java/io/ObjectOutputStream:flush	()V
    //   95: aload_2
    //   96: astore_1
    //   97: new 71	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 35	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   105: invokevirtual 75	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   108: invokevirtual 81	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   111: new 83	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   118: aload_0
    //   119: getfield 35	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   122: invokevirtual 88	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   125: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 94
    //   130: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   139: invokevirtual 103	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: aload_3
    //   143: invokevirtual 107	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   146: iconst_0
    //   147: invokestatic 112	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   150: pop
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   159: return
    //   160: aload_2
    //   161: astore_1
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   167: arraylength
    //   168: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   178: invokevirtual 119	java/io/ObjectOutputStream:write	([B)V
    //   181: goto -138 -> 43
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +33 -> 223
    //   193: aload_2
    //   194: astore_1
    //   195: ldc 127
    //   197: iconst_2
    //   198: new 83	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   205: ldc 129
    //   207: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_3
    //   211: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_2
    //   224: ifnull -65 -> 159
    //   227: aload_2
    //   228: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   231: return
    //   232: astore_1
    //   233: return
    //   234: aload_2
    //   235: astore_1
    //   236: aload_2
    //   237: aload_0
    //   238: getfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   241: arraylength
    //   242: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   245: aload_2
    //   246: astore_1
    //   247: aload_2
    //   248: aload_0
    //   249: getfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   252: invokevirtual 119	java/io/ObjectOutputStream:write	([B)V
    //   255: goto -186 -> 69
    //   258: astore_3
    //   259: aload_1
    //   260: astore_2
    //   261: aload_3
    //   262: astore_1
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: return
    //   275: astore_2
    //   276: goto -5 -> 271
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -19 -> 263
    //   285: astore_3
    //   286: aconst_null
    //   287: astore_2
    //   288: goto -103 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	OldBigDataChannelManager
    //   18	177	1	localObject1	Object
    //   232	1	1	localException1	java.lang.Exception
    //   235	37	1	localObject2	Object
    //   273	1	1	localException2	java.lang.Exception
    //   279	1	1	localObject3	Object
    //   16	252	2	localObject4	Object
    //   275	1	2	localException3	java.lang.Exception
    //   281	7	2	localObject5	Object
    //   7	136	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   184	27	3	localException4	java.lang.Exception
    //   258	4	3	localObject6	Object
    //   285	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   19	26	184	java/lang/Exception
    //   28	36	184	java/lang/Exception
    //   38	43	184	java/lang/Exception
    //   45	52	184	java/lang/Exception
    //   54	62	184	java/lang/Exception
    //   64	69	184	java/lang/Exception
    //   71	79	184	java/lang/Exception
    //   81	89	184	java/lang/Exception
    //   91	95	184	java/lang/Exception
    //   97	151	184	java/lang/Exception
    //   162	171	184	java/lang/Exception
    //   173	181	184	java/lang/Exception
    //   236	245	184	java/lang/Exception
    //   247	255	184	java/lang/Exception
    //   227	231	232	java/lang/Exception
    //   19	26	258	finally
    //   28	36	258	finally
    //   38	43	258	finally
    //   45	52	258	finally
    //   54	62	258	finally
    //   64	69	258	finally
    //   71	79	258	finally
    //   81	89	258	finally
    //   91	95	258	finally
    //   97	151	258	finally
    //   162	171	258	finally
    //   173	181	258	finally
    //   187	193	258	finally
    //   195	223	258	finally
    //   236	245	258	finally
    //   247	255	258	finally
    //   155	159	273	java/lang/Exception
    //   267	271	275	java/lang/Exception
    //   0	17	279	finally
    //   0	17	285	java/lang/Exception
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: new 71	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 35	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   13: invokevirtual 75	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: invokevirtual 81	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   19: new 83	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 35	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 88	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 94
    //   38: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +355 -> 404
    //   52: aload_3
    //   53: invokevirtual 140	java/io/File:exists	()Z
    //   56: ifeq +348 -> 404
    //   59: aload_3
    //   60: invokestatic 143	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   63: astore_2
    //   64: new 145	java/io/ByteArrayInputStream
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 147	java/io/ByteArrayInputStream:<init>	([B)V
    //   72: astore 4
    //   74: new 149	java/io/ObjectInputStream
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 152	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore_3
    //   84: aload_3
    //   85: invokevirtual 156	java/io/ObjectInputStream:readInt	()I
    //   88: istore_1
    //   89: iload_1
    //   90: aload_2
    //   91: arraylength
    //   92: if_icmple +109 -> 201
    //   95: new 158	java/lang/RuntimeException
    //   98: dup
    //   99: new 83	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   106: ldc 160
    //   108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload_1
    //   112: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   128: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +12 -> 143
    //   134: ldc 127
    //   136: iconst_2
    //   137: ldc 168
    //   139: aload_2
    //   140: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 172	java/io/ObjectInputStream:close	()V
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   161: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +31 -> 195
    //   167: ldc 127
    //   169: iconst_2
    //   170: new 83	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   177: ldc 175
    //   179: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 26	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   186: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_0
    //   196: iconst_0
    //   197: putfield 26	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   200: return
    //   201: iload_1
    //   202: ifle +19 -> 221
    //   205: aload_0
    //   206: iload_1
    //   207: newarray byte
    //   209: putfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   212: aload_3
    //   213: aload_0
    //   214: getfield 20	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   217: invokevirtual 179	java/io/ObjectInputStream:read	([B)I
    //   220: pop
    //   221: aload_3
    //   222: invokevirtual 156	java/io/ObjectInputStream:readInt	()I
    //   225: istore_1
    //   226: iload_1
    //   227: aload_2
    //   228: arraylength
    //   229: if_icmple +51 -> 280
    //   232: new 158	java/lang/RuntimeException
    //   235: dup
    //   236: new 83	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   243: ldc 181
    //   245: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload_1
    //   249: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   258: athrow
    //   259: astore_2
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 172	java/io/ObjectInputStream:close	()V
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   278: aload_2
    //   279: athrow
    //   280: iload_1
    //   281: ifle +19 -> 300
    //   284: aload_0
    //   285: iload_1
    //   286: newarray byte
    //   288: putfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   291: aload_3
    //   292: aload_0
    //   293: getfield 22	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   296: invokevirtual 179	java/io/ObjectInputStream:read	([B)I
    //   299: pop
    //   300: aload_0
    //   301: aload_3
    //   302: invokevirtual 156	java/io/ObjectInputStream:readInt	()I
    //   305: putfield 26	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   308: aload_0
    //   309: aload_3
    //   310: invokevirtual 185	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   313: checkcast 186	[Ljava/lang/String;
    //   316: checkcast 186	[Ljava/lang/String;
    //   319: putfield 24	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   322: aload 4
    //   324: astore_2
    //   325: aload_3
    //   326: ifnull +7 -> 333
    //   329: aload_3
    //   330: invokevirtual 172	java/io/ObjectInputStream:close	()V
    //   333: aload_2
    //   334: ifnull -173 -> 161
    //   337: aload_2
    //   338: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   341: goto -180 -> 161
    //   344: astore_2
    //   345: goto -184 -> 161
    //   348: astore_3
    //   349: goto -16 -> 333
    //   352: astore_2
    //   353: goto -202 -> 151
    //   356: astore_2
    //   357: goto -196 -> 161
    //   360: astore_3
    //   361: goto -93 -> 268
    //   364: astore_3
    //   365: goto -87 -> 278
    //   368: astore_2
    //   369: aconst_null
    //   370: astore 4
    //   372: aconst_null
    //   373: astore_3
    //   374: goto -114 -> 260
    //   377: astore_2
    //   378: aconst_null
    //   379: astore_3
    //   380: goto -120 -> 260
    //   383: astore_2
    //   384: goto -124 -> 260
    //   387: astore_2
    //   388: aconst_null
    //   389: astore 4
    //   391: aload 5
    //   393: astore_3
    //   394: goto -271 -> 123
    //   397: astore_2
    //   398: aload 5
    //   400: astore_3
    //   401: goto -278 -> 123
    //   404: aconst_null
    //   405: astore_3
    //   406: goto -81 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	OldBigDataChannelManager
    //   88	198	1	i	int
    //   1	90	2	arrayOfByte	byte[]
    //   122	106	2	localException1	java.lang.Exception
    //   259	20	2	localObject1	Object
    //   324	14	2	localObject2	Object
    //   344	1	2	localIOException1	java.io.IOException
    //   352	1	2	localIOException2	java.io.IOException
    //   356	1	2	localIOException3	java.io.IOException
    //   368	1	2	localObject3	Object
    //   377	1	2	localObject4	Object
    //   383	1	2	localObject5	Object
    //   387	1	2	localException2	java.lang.Exception
    //   397	1	2	localException3	java.lang.Exception
    //   47	283	3	localObject6	Object
    //   348	1	3	localIOException4	java.io.IOException
    //   360	1	3	localIOException5	java.io.IOException
    //   364	1	3	localIOException6	java.io.IOException
    //   373	33	3	localObject7	Object
    //   72	318	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   3	396	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   84	122	122	java/lang/Exception
    //   205	221	122	java/lang/Exception
    //   221	259	122	java/lang/Exception
    //   284	300	122	java/lang/Exception
    //   300	322	122	java/lang/Exception
    //   84	122	259	finally
    //   205	221	259	finally
    //   221	259	259	finally
    //   284	300	259	finally
    //   300	322	259	finally
    //   337	341	344	java/io/IOException
    //   329	333	348	java/io/IOException
    //   147	151	352	java/io/IOException
    //   156	161	356	java/io/IOException
    //   264	268	360	java/io/IOException
    //   273	278	364	java/io/IOException
    //   5	48	368	finally
    //   52	74	368	finally
    //   74	84	377	finally
    //   123	143	383	finally
    //   5	48	387	java/lang/Exception
    //   52	74	387	java/lang/Exception
    //   74	84	397	java/lang/Exception
  }
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.b = null;
  }
  
  public String a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      this.jdField_a_of_type_Int %= arrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("OldBigDataChannelManager", 2, "getCircleSrvUrl | usingIndex = " + this.jdField_a_of_type_Int + " | count = " + arrayOfString.length + " | result = " + arrayOfString[this.jdField_a_of_type_Int]);
      }
      return arrayOfString[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OldBigDataChannelManager", 2, "onResponseException | current index = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (paramArrayOfByte1 != null) {}
    for (bool1 = bool2;; bool1 = bool2) {
      try
      {
        if (paramArrayOfByte1.length > 0)
        {
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramArrayOfByte2 != null)
        {
          bool2 = bool1;
          if (paramArrayOfByte2.length > 0)
          {
            this.b = paramArrayOfByte2;
            bool2 = true;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
          bool1 = bool3;
          if (bool1) {
            b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("OldBigDataChannelManager", 2, "saveSrvParam | changed = " + bool1 + " | usingIndex = " + this.jdField_a_of_type_Int);
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.OldBigDataChannelManager
 * JD-Core Version:    0.7.0.1
 */