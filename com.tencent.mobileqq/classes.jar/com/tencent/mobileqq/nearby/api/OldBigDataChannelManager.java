package com.tencent.mobileqq.nearby.api;

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
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   23: ifnull +40 -> 63
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   32: arraylength
    //   33: ifne +6 -> 39
    //   36: goto +27 -> 63
    //   39: aload_1
    //   40: astore_2
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   46: arraylength
    //   47: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   50: aload_1
    //   51: astore_2
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   57: invokevirtual 66	java/io/ObjectOutputStream:write	([B)V
    //   60: goto +10 -> 70
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   70: aload_1
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   76: ifnull +40 -> 116
    //   79: aload_1
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   85: arraylength
    //   86: ifne +6 -> 92
    //   89: goto +27 -> 116
    //   92: aload_1
    //   93: astore_2
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   99: arraylength
    //   100: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   103: aload_1
    //   104: astore_2
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   110: invokevirtual 66	java/io/ObjectOutputStream:write	([B)V
    //   113: goto +10 -> 123
    //   116: aload_1
    //   117: astore_2
    //   118: aload_1
    //   119: iconst_0
    //   120: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   123: aload_1
    //   124: astore_2
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 26	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   130: invokevirtual 62	java/io/ObjectOutputStream:writeInt	(I)V
    //   133: aload_1
    //   134: astore_2
    //   135: aload_1
    //   136: aload_0
    //   137: getfield 24	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   140: invokevirtual 70	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   143: aload_1
    //   144: astore_2
    //   145: aload_1
    //   146: invokevirtual 73	java/io/ObjectOutputStream:flush	()V
    //   149: aload_1
    //   150: astore_2
    //   151: aload_0
    //   152: getfield 35	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   155: invokevirtual 77	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   158: invokevirtual 83	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   161: astore 4
    //   163: aload_1
    //   164: astore_2
    //   165: new 85	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   172: astore 5
    //   174: aload_1
    //   175: astore_2
    //   176: aload 5
    //   178: aload_0
    //   179: getfield 35	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   182: invokevirtual 90	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   185: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: astore_2
    //   191: aload 5
    //   193: ldc 96
    //   195: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: astore_2
    //   201: new 98	java/io/File
    //   204: dup
    //   205: aload 4
    //   207: aload 5
    //   209: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   215: invokevirtual 107	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: aload_3
    //   219: invokevirtual 111	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: iconst_0
    //   223: invokestatic 117	com/tencent/mobileqq/utils/FileUtils:pushData2File	(Ljava/lang/String;[BZ)Z
    //   226: pop
    //   227: aload_1
    //   228: invokevirtual 120	java/io/ObjectOutputStream:close	()V
    //   231: return
    //   232: astore_3
    //   233: goto +12 -> 245
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: goto +69 -> 308
    //   242: astore_3
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: astore_2
    //   247: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +49 -> 299
    //   253: aload_1
    //   254: astore_2
    //   255: new 85	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   262: astore 4
    //   264: aload_1
    //   265: astore_2
    //   266: aload 4
    //   268: ldc 128
    //   270: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: astore_2
    //   276: aload 4
    //   278: aload_3
    //   279: invokevirtual 131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   282: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: astore_2
    //   288: ldc 133
    //   290: iconst_2
    //   291: aload 4
    //   293: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: ifnull +6 -> 306
    //   303: goto -76 -> 227
    //   306: return
    //   307: astore_1
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 120	java/io/ObjectOutputStream:close	()V
    //   316: goto +5 -> 321
    //   319: aload_1
    //   320: athrow
    //   321: goto -2 -> 319
    //   324: astore_1
    //   325: return
    //   326: astore_2
    //   327: goto -11 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	OldBigDataChannelManager
    //   16	212	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   236	1	1	localObject1	Object
    //   244	56	1	localObject2	Object
    //   307	13	1	localObject3	Object
    //   324	1	1	localException1	java.lang.Exception
    //   18	295	2	localObject4	Object
    //   326	1	2	localException2	java.lang.Exception
    //   7	212	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   232	1	3	localException3	java.lang.Exception
    //   242	37	3	localException4	java.lang.Exception
    //   161	131	4	localObject5	Object
    //   172	36	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	26	232	java/lang/Exception
    //   28	36	232	java/lang/Exception
    //   41	50	232	java/lang/Exception
    //   52	60	232	java/lang/Exception
    //   65	70	232	java/lang/Exception
    //   72	79	232	java/lang/Exception
    //   81	89	232	java/lang/Exception
    //   94	103	232	java/lang/Exception
    //   105	113	232	java/lang/Exception
    //   118	123	232	java/lang/Exception
    //   125	133	232	java/lang/Exception
    //   135	143	232	java/lang/Exception
    //   145	149	232	java/lang/Exception
    //   151	163	232	java/lang/Exception
    //   165	174	232	java/lang/Exception
    //   176	189	232	java/lang/Exception
    //   191	199	232	java/lang/Exception
    //   201	227	232	java/lang/Exception
    //   0	17	236	finally
    //   0	17	242	java/lang/Exception
    //   19	26	307	finally
    //   28	36	307	finally
    //   41	50	307	finally
    //   52	60	307	finally
    //   65	70	307	finally
    //   72	79	307	finally
    //   81	89	307	finally
    //   94	103	307	finally
    //   105	113	307	finally
    //   118	123	307	finally
    //   125	133	307	finally
    //   135	143	307	finally
    //   145	149	307	finally
    //   151	163	307	finally
    //   165	174	307	finally
    //   176	189	307	finally
    //   191	199	307	finally
    //   201	227	307	finally
    //   247	253	307	finally
    //   255	264	307	finally
    //   266	274	307	finally
    //   276	286	307	finally
    //   288	299	307	finally
    //   227	231	324	java/lang/Exception
    //   312	316	326	java/lang/Exception
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 35	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   6: invokevirtual 77	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 83	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   12: astore_2
    //   13: new 85	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_0
    //   25: getfield 35	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   28: invokevirtual 90	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   31: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: ldc 96
    //   39: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 98	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: aload 4
    //   50: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 141	java/io/File:exists	()Z
    //   61: ifeq +318 -> 379
    //   64: aload_2
    //   65: invokestatic 145	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   68: astore 6
    //   70: new 147	java/io/ByteArrayInputStream
    //   73: dup
    //   74: aload 6
    //   76: invokespecial 149	java/io/ByteArrayInputStream:<init>	([B)V
    //   79: astore_2
    //   80: new 151	java/io/ObjectInputStream
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 154	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore_3
    //   89: aload_2
    //   90: astore 4
    //   92: aload_3
    //   93: astore 5
    //   95: aload_3
    //   96: invokevirtual 158	java/io/ObjectInputStream:readInt	()I
    //   99: istore_1
    //   100: aload_2
    //   101: astore 4
    //   103: aload_3
    //   104: astore 5
    //   106: iload_1
    //   107: aload 6
    //   109: arraylength
    //   110: if_icmpgt +189 -> 299
    //   113: iload_1
    //   114: ifle +31 -> 145
    //   117: aload_2
    //   118: astore 4
    //   120: aload_3
    //   121: astore 5
    //   123: aload_0
    //   124: iload_1
    //   125: newarray byte
    //   127: putfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   130: aload_2
    //   131: astore 4
    //   133: aload_3
    //   134: astore 5
    //   136: aload_3
    //   137: aload_0
    //   138: getfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   141: invokevirtual 162	java/io/ObjectInputStream:read	([B)I
    //   144: pop
    //   145: aload_2
    //   146: astore 4
    //   148: aload_3
    //   149: astore 5
    //   151: aload_3
    //   152: invokevirtual 158	java/io/ObjectInputStream:readInt	()I
    //   155: istore_1
    //   156: aload_2
    //   157: astore 4
    //   159: aload_3
    //   160: astore 5
    //   162: iload_1
    //   163: aload 6
    //   165: arraylength
    //   166: if_icmpgt +72 -> 238
    //   169: iload_1
    //   170: ifle +31 -> 201
    //   173: aload_2
    //   174: astore 4
    //   176: aload_3
    //   177: astore 5
    //   179: aload_0
    //   180: iload_1
    //   181: newarray byte
    //   183: putfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   186: aload_2
    //   187: astore 4
    //   189: aload_3
    //   190: astore 5
    //   192: aload_3
    //   193: aload_0
    //   194: getfield 22	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:b	[B
    //   197: invokevirtual 162	java/io/ObjectInputStream:read	([B)I
    //   200: pop
    //   201: aload_2
    //   202: astore 4
    //   204: aload_3
    //   205: astore 5
    //   207: aload_0
    //   208: aload_3
    //   209: invokevirtual 158	java/io/ObjectInputStream:readInt	()I
    //   212: putfield 26	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   215: aload_2
    //   216: astore 4
    //   218: aload_3
    //   219: astore 5
    //   221: aload_0
    //   222: aload_3
    //   223: invokevirtual 166	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   226: checkcast 167	[Ljava/lang/String;
    //   229: checkcast 167	[Ljava/lang/String;
    //   232: putfield 24	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   235: goto +146 -> 381
    //   238: aload_2
    //   239: astore 4
    //   241: aload_3
    //   242: astore 5
    //   244: new 85	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   251: astore 6
    //   253: aload_2
    //   254: astore 4
    //   256: aload_3
    //   257: astore 5
    //   259: aload 6
    //   261: ldc 169
    //   263: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: astore 4
    //   270: aload_3
    //   271: astore 5
    //   273: aload 6
    //   275: iload_1
    //   276: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: astore 4
    //   283: aload_3
    //   284: astore 5
    //   286: new 174	java/lang/RuntimeException
    //   289: dup
    //   290: aload 6
    //   292: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   298: athrow
    //   299: aload_2
    //   300: astore 4
    //   302: aload_3
    //   303: astore 5
    //   305: new 85	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   312: astore 6
    //   314: aload_2
    //   315: astore 4
    //   317: aload_3
    //   318: astore 5
    //   320: aload 6
    //   322: ldc 179
    //   324: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_2
    //   329: astore 4
    //   331: aload_3
    //   332: astore 5
    //   334: aload 6
    //   336: iload_1
    //   337: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_2
    //   342: astore 4
    //   344: aload_3
    //   345: astore 5
    //   347: new 174	java/lang/RuntimeException
    //   350: dup
    //   351: aload 6
    //   353: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   359: athrow
    //   360: astore 6
    //   362: goto +59 -> 421
    //   365: astore_3
    //   366: aconst_null
    //   367: astore 5
    //   369: goto +159 -> 528
    //   372: astore 6
    //   374: aconst_null
    //   375: astore_3
    //   376: goto +45 -> 421
    //   379: aconst_null
    //   380: astore_2
    //   381: aload_3
    //   382: ifnull +10 -> 392
    //   385: aload_3
    //   386: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   389: goto +3 -> 392
    //   392: aload_2
    //   393: ifnull +85 -> 478
    //   396: aload_2
    //   397: invokevirtual 181	java/io/ByteArrayInputStream:close	()V
    //   400: goto +78 -> 478
    //   403: goto +75 -> 478
    //   406: astore_3
    //   407: aconst_null
    //   408: astore_2
    //   409: aload_2
    //   410: astore 5
    //   412: goto +116 -> 528
    //   415: astore 6
    //   417: aconst_null
    //   418: astore_2
    //   419: aload_2
    //   420: astore_3
    //   421: aload_2
    //   422: astore 4
    //   424: aload_3
    //   425: astore 5
    //   427: aload_0
    //   428: aconst_null
    //   429: putfield 20	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   432: aload_2
    //   433: astore 4
    //   435: aload_3
    //   436: astore 5
    //   438: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +19 -> 460
    //   444: aload_2
    //   445: astore 4
    //   447: aload_3
    //   448: astore 5
    //   450: ldc 133
    //   452: iconst_2
    //   453: ldc 183
    //   455: aload 6
    //   457: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: aload_3
    //   461: ifnull +10 -> 471
    //   464: aload_3
    //   465: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   468: goto +3 -> 471
    //   471: aload_2
    //   472: ifnull +6 -> 478
    //   475: goto -79 -> 396
    //   478: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +37 -> 518
    //   484: new 85	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   491: astore_2
    //   492: aload_2
    //   493: ldc 188
    //   495: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload_2
    //   500: aload_0
    //   501: getfield 26	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   504: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: ldc 133
    //   510: iconst_2
    //   511: aload_2
    //   512: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: iconst_0
    //   520: putfield 26	com/tencent/mobileqq/nearby/api/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   523: return
    //   524: astore_3
    //   525: aload 4
    //   527: astore_2
    //   528: aload 5
    //   530: ifnull +11 -> 541
    //   533: aload 5
    //   535: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   538: goto +3 -> 541
    //   541: aload_2
    //   542: ifnull +7 -> 549
    //   545: aload_2
    //   546: invokevirtual 181	java/io/ByteArrayInputStream:close	()V
    //   549: goto +5 -> 554
    //   552: aload_3
    //   553: athrow
    //   554: goto -2 -> 552
    //   557: astore_3
    //   558: goto -166 -> 392
    //   561: astore_2
    //   562: goto -159 -> 403
    //   565: astore_3
    //   566: goto -95 -> 471
    //   569: astore 4
    //   571: goto -30 -> 541
    //   574: astore_2
    //   575: goto -26 -> 549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	OldBigDataChannelManager
    //   99	238	1	i	int
    //   12	534	2	localObject1	Object
    //   561	1	2	localIOException1	java.io.IOException
    //   574	1	2	localIOException2	java.io.IOException
    //   1	344	3	localObjectInputStream	java.io.ObjectInputStream
    //   365	1	3	localObject2	Object
    //   375	11	3	localObject3	Object
    //   406	1	3	localObject4	Object
    //   420	45	3	localObject5	Object
    //   524	29	3	localObject6	Object
    //   557	1	3	localIOException3	java.io.IOException
    //   565	1	3	localIOException4	java.io.IOException
    //   20	506	4	localObject7	Object
    //   569	1	4	localIOException5	java.io.IOException
    //   93	441	5	localObject8	Object
    //   68	284	6	localObject9	Object
    //   360	1	6	localException1	java.lang.Exception
    //   372	1	6	localException2	java.lang.Exception
    //   415	41	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   95	100	360	java/lang/Exception
    //   106	113	360	java/lang/Exception
    //   123	130	360	java/lang/Exception
    //   136	145	360	java/lang/Exception
    //   151	156	360	java/lang/Exception
    //   162	169	360	java/lang/Exception
    //   179	186	360	java/lang/Exception
    //   192	201	360	java/lang/Exception
    //   207	215	360	java/lang/Exception
    //   221	235	360	java/lang/Exception
    //   244	253	360	java/lang/Exception
    //   259	267	360	java/lang/Exception
    //   273	280	360	java/lang/Exception
    //   286	299	360	java/lang/Exception
    //   305	314	360	java/lang/Exception
    //   320	328	360	java/lang/Exception
    //   334	341	360	java/lang/Exception
    //   347	360	360	java/lang/Exception
    //   80	89	365	finally
    //   80	89	372	java/lang/Exception
    //   2	80	406	finally
    //   2	80	415	java/lang/Exception
    //   95	100	524	finally
    //   106	113	524	finally
    //   123	130	524	finally
    //   136	145	524	finally
    //   151	156	524	finally
    //   162	169	524	finally
    //   179	186	524	finally
    //   192	201	524	finally
    //   207	215	524	finally
    //   221	235	524	finally
    //   244	253	524	finally
    //   259	267	524	finally
    //   273	280	524	finally
    //   286	299	524	finally
    //   305	314	524	finally
    //   320	328	524	finally
    //   334	341	524	finally
    //   347	360	524	finally
    //   427	432	524	finally
    //   438	444	524	finally
    //   450	460	524	finally
    //   385	389	557	java/io/IOException
    //   396	400	561	java/io/IOException
    //   464	468	565	java/io/IOException
    //   533	538	569	java/io/IOException
    //   545	549	574	java/io/IOException
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCircleSrvUrl | usingIndex = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" | count = ");
        localStringBuilder.append(arrayOfString.length);
        localStringBuilder.append(" | result = ");
        localStringBuilder.append(arrayOfString[this.jdField_a_of_type_Int]);
        QLog.d("OldBigDataChannelManager", 2, localStringBuilder.toString());
      }
      return arrayOfString[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResponseException | current index = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("OldBigDataChannelManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    if (paramArrayOfByte1 != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte1.length <= 0) {
          break label151;
        }
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
        bool2 = true;
        boolean bool1 = bool2;
        if (paramArrayOfByte2 != null)
        {
          bool1 = bool2;
          if (paramArrayOfByte2.length > 0)
          {
            this.b = paramArrayOfByte2;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramArrayOfString != null)
        {
          bool2 = bool1;
          if (paramArrayOfString.length > 0)
          {
            this.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
            bool2 = true;
          }
        }
        if (bool2) {
          b();
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("saveSrvParam | changed = ");
          paramArrayOfByte1.append(bool2);
          paramArrayOfByte1.append(" | usingIndex = ");
          paramArrayOfByte1.append(this.jdField_a_of_type_Int);
          QLog.d("OldBigDataChannelManager", 2, paramArrayOfByte1.toString());
        }
        return;
      }
      finally
      {
        continue;
      }
      throw paramArrayOfByte1;
      label151:
      boolean bool2 = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.OldBigDataChannelManager
 * JD-Core Version:    0.7.0.1
 */