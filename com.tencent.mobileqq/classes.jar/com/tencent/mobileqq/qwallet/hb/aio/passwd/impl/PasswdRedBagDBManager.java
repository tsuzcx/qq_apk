package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PasswdRedBagDBManager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private PasswdRedBagDBHelper jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper;
  private PasswdRedBagServiceImpl jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl;
  private String jdField_a_of_type_JavaLangString;
  
  public PasswdRedBagDBManager(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper = new PasswdRedBagDBHelper(paramPasswdRedBagServiceImpl.mContext, paramPasswdRedBagServiceImpl.mUin);
    this.jdField_a_of_type_AndroidContentContext = paramPasswdRedBagServiceImpl.mContext;
    this.jdField_a_of_type_JavaLangString = paramPasswdRedBagServiceImpl.mUin;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl = paramPasswdRedBagServiceImpl;
  }
  
  /* Error */
  public java.util.HashMap<String, String> a()
  {
    // Byte code:
    //   0: new 42	java/util/HashMap
    //   3: dup
    //   4: invokespecial 43	java/util/HashMap:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 30	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   14: invokevirtual 47	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 51
    //   26: iconst_4
    //   27: anewarray 53	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 55
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 57
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 59
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 61
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +197 -> 259
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 55
    //   73: invokeinterface 73 2 0
    //   78: istore_1
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ldc 57
    //   87: invokeinterface 73 2 0
    //   92: istore_2
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: ldc 59
    //   101: invokeinterface 73 2 0
    //   106: istore_3
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ldc 61
    //   115: invokeinterface 73 2 0
    //   120: istore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload 6
    //   128: invokeinterface 77 1 0
    //   133: ifeq +126 -> 259
    //   136: aload 6
    //   138: astore 5
    //   140: new 79	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 6
    //   151: astore 5
    //   153: aload 8
    //   155: aload 6
    //   157: iload_3
    //   158: invokeinterface 84 2 0
    //   163: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 8
    //   173: ldc 90
    //   175: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore 5
    //   183: aload 8
    //   185: aload 6
    //   187: iload_2
    //   188: invokeinterface 84 2 0
    //   193: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 8
    //   203: ldc 90
    //   205: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: astore 5
    //   213: aload 8
    //   215: aload 6
    //   217: iload_1
    //   218: invokeinterface 84 2 0
    //   223: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 6
    //   229: astore 5
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: iload 4
    //   242: invokeinterface 84 2 0
    //   247: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -129 -> 122
    //   254: astore 7
    //   256: goto +35 -> 291
    //   259: aload 7
    //   261: astore 5
    //   263: aload 6
    //   265: ifnull +72 -> 337
    //   268: aload 6
    //   270: invokeinterface 101 1 0
    //   275: aload 7
    //   277: areturn
    //   278: astore 5
    //   280: aconst_null
    //   281: astore 6
    //   283: goto +67 -> 350
    //   286: astore 7
    //   288: aconst_null
    //   289: astore 6
    //   291: aload 6
    //   293: astore 5
    //   295: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +15 -> 313
    //   301: aload 6
    //   303: astore 5
    //   305: ldc 108
    //   307: iconst_2
    //   308: ldc 110
    //   310: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 6
    //   315: astore 5
    //   317: aload 7
    //   319: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   322: aload 6
    //   324: ifnull +10 -> 334
    //   327: aload 6
    //   329: invokeinterface 101 1 0
    //   334: aconst_null
    //   335: astore 5
    //   337: aload 5
    //   339: areturn
    //   340: astore 7
    //   342: aload 5
    //   344: astore 6
    //   346: aload 7
    //   348: astore 5
    //   350: aload 6
    //   352: ifnull +10 -> 362
    //   355: aload 6
    //   357: invokeinterface 101 1 0
    //   362: goto +6 -> 368
    //   365: aload 5
    //   367: athrow
    //   368: goto -3 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	PasswdRedBagDBManager
    //   78	140	1	i	int
    //   92	96	2	j	int
    //   106	52	3	k	int
    //   120	121	4	m	int
    //   67	195	5	localObject1	Object
    //   278	1	5	localObject2	Object
    //   293	73	5	localObject3	Object
    //   58	298	6	localObject4	Object
    //   7	225	7	localHashMap	java.util.HashMap
    //   254	22	7	localThrowable1	Throwable
    //   286	32	7	localThrowable2	Throwable
    //   340	7	7	localObject5	Object
    //   147	87	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	79	254	java/lang/Throwable
    //   83	93	254	java/lang/Throwable
    //   97	107	254	java/lang/Throwable
    //   111	122	254	java/lang/Throwable
    //   126	136	254	java/lang/Throwable
    //   140	149	254	java/lang/Throwable
    //   153	167	254	java/lang/Throwable
    //   171	179	254	java/lang/Throwable
    //   183	197	254	java/lang/Throwable
    //   201	209	254	java/lang/Throwable
    //   213	227	254	java/lang/Throwable
    //   231	251	254	java/lang/Throwable
    //   9	60	278	finally
    //   9	60	286	java/lang/Throwable
    //   69	79	340	finally
    //   83	93	340	finally
    //   97	107	340	finally
    //   111	122	340	finally
    //   126	136	340	finally
    //   140	149	340	finally
    //   153	167	340	finally
    //   171	179	340	finally
    //   183	197	340	finally
    //   201	209	340	finally
    //   213	227	340	finally
    //   231	251	340	finally
    //   295	301	340	finally
    //   305	313	340	finally
    //   317	322	340	finally
  }
  
  /* Error */
  public java.util.List<PasswdRedBagInfo> a()
  {
    // Byte code:
    //   0: new 124	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 125	java/util/ArrayList:<init>	()V
    //   7: astore 15
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 30	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   14: invokevirtual 47	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 127
    //   26: bipush 10
    //   28: anewarray 53	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 55
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 129
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 131
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 133
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 135
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 137
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 139
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 141
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 143
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 145
    //   84: aastore
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: ldc 147
    //   91: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   94: astore 13
    //   96: aload 13
    //   98: ifnull +321 -> 419
    //   101: aload 13
    //   103: ldc 55
    //   105: invokeinterface 73 2 0
    //   110: istore_3
    //   111: aload 13
    //   113: ldc 129
    //   115: invokeinterface 73 2 0
    //   120: istore 4
    //   122: aload 13
    //   124: ldc 131
    //   126: invokeinterface 73 2 0
    //   131: istore 5
    //   133: aload 13
    //   135: ldc 133
    //   137: invokeinterface 73 2 0
    //   142: istore 6
    //   144: aload 13
    //   146: ldc 135
    //   148: invokeinterface 73 2 0
    //   153: istore 7
    //   155: aload 13
    //   157: ldc 137
    //   159: invokeinterface 73 2 0
    //   164: istore_2
    //   165: aload 13
    //   167: ldc 139
    //   169: invokeinterface 73 2 0
    //   174: istore_1
    //   175: aload 13
    //   177: ldc 141
    //   179: invokeinterface 73 2 0
    //   184: istore 8
    //   186: aload 13
    //   188: ldc 143
    //   190: invokeinterface 73 2 0
    //   195: istore 9
    //   197: aload 13
    //   199: ldc 145
    //   201: invokeinterface 73 2 0
    //   206: istore 10
    //   208: aload 13
    //   210: invokeinterface 77 1 0
    //   215: ifeq +204 -> 419
    //   218: new 149	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo
    //   221: dup
    //   222: invokespecial 150	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:<init>	()V
    //   225: astore 12
    //   227: aload 13
    //   229: iload_1
    //   230: invokeinterface 154 2 0
    //   235: iconst_1
    //   236: if_icmpne +276 -> 512
    //   239: iconst_1
    //   240: istore 11
    //   242: goto +3 -> 245
    //   245: aload 12
    //   247: iload 11
    //   249: putfield 158	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_b_of_type_Boolean	Z
    //   252: aload 13
    //   254: iload_2
    //   255: invokeinterface 154 2 0
    //   260: iconst_1
    //   261: if_icmpne +257 -> 518
    //   264: iconst_1
    //   265: istore 11
    //   267: goto +3 -> 270
    //   270: aload 12
    //   272: iload 11
    //   274: putfield 160	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_a_of_type_Boolean	Z
    //   277: aload 12
    //   279: aload 13
    //   281: iload 7
    //   283: invokeinterface 84 2 0
    //   288: putfield 162	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:d	Ljava/lang/String;
    //   291: aload 12
    //   293: aload 13
    //   295: iload_3
    //   296: invokeinterface 84 2 0
    //   301: putfield 163	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: aload 12
    //   306: aload 13
    //   308: iload 4
    //   310: invokeinterface 84 2 0
    //   315: putfield 165	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   318: aload 12
    //   320: aload 13
    //   322: iload 5
    //   324: invokeinterface 84 2 0
    //   329: putfield 168	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:c	Ljava/lang/String;
    //   332: aload 12
    //   334: aload 13
    //   336: iload 6
    //   338: invokeinterface 172 2 0
    //   343: putfield 175	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_a_of_type_Long	J
    //   346: aload 12
    //   348: aload 13
    //   350: iload 8
    //   352: invokeinterface 154 2 0
    //   357: putfield 178	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:jdField_a_of_type_Int	I
    //   360: aload 12
    //   362: aload 13
    //   364: iload 9
    //   366: invokeinterface 84 2 0
    //   371: putfield 181	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:e	Ljava/lang/String;
    //   374: aload 12
    //   376: aload 13
    //   378: iload 10
    //   380: invokeinterface 84 2 0
    //   385: putfield 184	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:f	Ljava/lang/String;
    //   388: aload 15
    //   390: aload 12
    //   392: invokeinterface 190 2 0
    //   397: pop
    //   398: goto -190 -> 208
    //   401: astore 12
    //   403: goto +88 -> 491
    //   406: astore 14
    //   408: aload 13
    //   410: astore 12
    //   412: aload 14
    //   414: astore 13
    //   416: goto +31 -> 447
    //   419: aload 13
    //   421: ifnull +57 -> 478
    //   424: aload 13
    //   426: invokeinterface 101 1 0
    //   431: aload 15
    //   433: areturn
    //   434: astore 12
    //   436: aconst_null
    //   437: astore 13
    //   439: goto +52 -> 491
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +11 -> 461
    //   453: ldc 108
    //   455: iconst_2
    //   456: ldc 192
    //   458: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: aload 13
    //   463: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   466: aload 12
    //   468: ifnull +10 -> 478
    //   471: aload 12
    //   473: invokeinterface 101 1 0
    //   478: aload 15
    //   480: areturn
    //   481: astore 14
    //   483: aload 12
    //   485: astore 13
    //   487: aload 14
    //   489: astore 12
    //   491: aload 13
    //   493: ifnull +10 -> 503
    //   496: aload 13
    //   498: invokeinterface 101 1 0
    //   503: goto +6 -> 509
    //   506: aload 12
    //   508: athrow
    //   509: goto -3 -> 506
    //   512: iconst_0
    //   513: istore 11
    //   515: goto -270 -> 245
    //   518: iconst_0
    //   519: istore 11
    //   521: goto -251 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	PasswdRedBagDBManager
    //   174	56	1	i	int
    //   164	91	2	j	int
    //   110	186	3	k	int
    //   120	189	4	m	int
    //   131	192	5	n	int
    //   142	195	6	i1	int
    //   153	129	7	i2	int
    //   184	167	8	i3	int
    //   195	170	9	i4	int
    //   206	173	10	i5	int
    //   240	280	11	bool	boolean
    //   225	166	12	localPasswdRedBagInfo	PasswdRedBagInfo
    //   401	1	12	localObject1	Object
    //   410	1	12	localObject2	Object
    //   434	1	12	localObject3	Object
    //   445	62	12	localObject4	Object
    //   94	344	13	localObject5	Object
    //   442	20	13	localException1	Exception
    //   485	12	13	localObject6	Object
    //   406	7	14	localException2	Exception
    //   481	7	14	localObject7	Object
    //   7	472	15	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   101	208	401	finally
    //   208	239	401	finally
    //   245	264	401	finally
    //   270	398	401	finally
    //   101	208	406	java/lang/Exception
    //   208	239	406	java/lang/Exception
    //   245	264	406	java/lang/Exception
    //   270	398	406	java/lang/Exception
    //   9	96	434	finally
    //   9	96	442	java/lang/Exception
    //   447	461	481	finally
    //   461	466	481	finally
  }
  
  /* Error */
  public java.util.List<PasswdRedBagUpdateInfo> a(int paramInt)
  {
    // Byte code:
    //   0: new 124	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 125	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: aload 7
    //   21: astore 4
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 30	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   28: invokevirtual 47	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: putfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   34: aload 6
    //   36: astore 5
    //   38: aload 7
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 9
    //   48: aload 6
    //   50: astore 5
    //   52: aload 7
    //   54: astore 4
    //   56: new 79	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   63: astore 10
    //   65: aload 6
    //   67: astore 5
    //   69: aload 7
    //   71: astore 4
    //   73: aload 10
    //   75: iload_1
    //   76: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 6
    //   82: astore 5
    //   84: aload 7
    //   86: astore 4
    //   88: aload 10
    //   90: ldc 200
    //   92: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: astore 5
    //   100: aload 7
    //   102: astore 4
    //   104: aload 10
    //   106: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 10
    //   111: aload 6
    //   113: astore 5
    //   115: aload 7
    //   117: astore 4
    //   119: aload 9
    //   121: ldc 202
    //   123: iconst_2
    //   124: anewarray 53	java/lang/String
    //   127: dup
    //   128: iconst_0
    //   129: ldc 57
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: ldc 204
    //   136: aastore
    //   137: ldc 206
    //   139: iconst_1
    //   140: anewarray 53	java/lang/String
    //   143: dup
    //   144: iconst_0
    //   145: aload 10
    //   147: aastore
    //   148: aconst_null
    //   149: aconst_null
    //   150: aconst_null
    //   151: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +151 -> 309
    //   161: aload 6
    //   163: astore 5
    //   165: aload 6
    //   167: astore 4
    //   169: aload 6
    //   171: ldc 57
    //   173: invokeinterface 73 2 0
    //   178: istore_2
    //   179: aload 6
    //   181: astore 5
    //   183: aload 6
    //   185: astore 4
    //   187: aload 6
    //   189: ldc 204
    //   191: invokeinterface 73 2 0
    //   196: istore_3
    //   197: aload 6
    //   199: astore 5
    //   201: aload 6
    //   203: astore 4
    //   205: aload 6
    //   207: invokeinterface 77 1 0
    //   212: ifeq +97 -> 309
    //   215: aload 6
    //   217: astore 5
    //   219: aload 6
    //   221: astore 4
    //   223: new 208	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo
    //   226: dup
    //   227: invokespecial 209	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:<init>	()V
    //   230: astore 7
    //   232: aload 6
    //   234: astore 5
    //   236: aload 6
    //   238: astore 4
    //   240: aload 7
    //   242: iload_1
    //   243: putfield 210	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   246: aload 6
    //   248: astore 5
    //   250: aload 6
    //   252: astore 4
    //   254: aload 7
    //   256: aload 6
    //   258: iload_2
    //   259: invokeinterface 172 2 0
    //   264: putfield 211	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   267: aload 6
    //   269: astore 5
    //   271: aload 6
    //   273: astore 4
    //   275: aload 7
    //   277: aload 6
    //   279: iload_3
    //   280: invokeinterface 172 2 0
    //   285: putfield 213	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:b	J
    //   288: aload 6
    //   290: astore 5
    //   292: aload 6
    //   294: astore 4
    //   296: aload 8
    //   298: aload 7
    //   300: invokeinterface 190 2 0
    //   305: pop
    //   306: goto -109 -> 197
    //   309: aload 6
    //   311: ifnull +60 -> 371
    //   314: aload 6
    //   316: astore 4
    //   318: goto +46 -> 364
    //   321: astore 4
    //   323: goto +51 -> 374
    //   326: astore 6
    //   328: aload 4
    //   330: astore 5
    //   332: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +15 -> 350
    //   338: aload 4
    //   340: astore 5
    //   342: ldc 108
    //   344: iconst_2
    //   345: ldc 215
    //   347: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload 4
    //   352: astore 5
    //   354: aload 6
    //   356: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   359: aload 4
    //   361: ifnull +10 -> 371
    //   364: aload 4
    //   366: invokeinterface 101 1 0
    //   371: aload 8
    //   373: areturn
    //   374: aload 5
    //   376: ifnull +10 -> 386
    //   379: aload 5
    //   381: invokeinterface 101 1 0
    //   386: goto +6 -> 392
    //   389: aload 4
    //   391: athrow
    //   392: goto -3 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	PasswdRedBagDBManager
    //   0	395	1	paramInt	int
    //   178	81	2	i	int
    //   196	84	3	j	int
    //   21	296	4	localObject1	Object
    //   321	69	4	localObject2	Object
    //   17	363	5	localObject3	Object
    //   13	302	6	localCursor	android.database.Cursor
    //   326	29	6	localException	Exception
    //   10	289	7	localPasswdRedBagUpdateInfo	PasswdRedBagUpdateInfo
    //   7	365	8	localArrayList	java.util.ArrayList
    //   46	74	9	localSQLiteDatabase	SQLiteDatabase
    //   63	83	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	34	321	finally
    //   42	48	321	finally
    //   56	65	321	finally
    //   73	80	321	finally
    //   88	96	321	finally
    //   104	111	321	finally
    //   119	156	321	finally
    //   169	179	321	finally
    //   187	197	321	finally
    //   205	215	321	finally
    //   223	232	321	finally
    //   240	246	321	finally
    //   254	267	321	finally
    //   275	288	321	finally
    //   296	306	321	finally
    //   332	338	321	finally
    //   342	350	321	finally
    //   354	359	321	finally
    //   23	34	326	java/lang/Exception
    //   42	48	326	java/lang/Exception
    //   56	65	326	java/lang/Exception
    //   73	80	326	java/lang/Exception
    //   88	96	326	java/lang/Exception
    //   104	111	326	java/lang/Exception
    //   119	156	326	java/lang/Exception
    //   169	179	326	java/lang/Exception
    //   187	197	326	java/lang/Exception
    //   205	215	326	java/lang/Exception
    //   223	232	326	java/lang/Exception
    //   240	246	326	java/lang/Exception
    //   254	267	326	java/lang/Exception
    //   275	288	326	java/lang/Exception
    //   296	306	326	java/lang/Exception
  }
  
  public JSONObject a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return new JSONObject();
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label26:
      break label26;
    }
    return new JSONObject();
  }
  
  public void a()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    if (localSQLiteDatabase != null) {
      localSQLiteDatabase.close();
    }
  }
  
  public void a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("redbag_id", paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
        localContentValues.put("redbag_index", paramPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
        localContentValues.put("uint64_creator_uin", paramPasswdRedBagInfo.c);
        localContentValues.put("expire_time", Long.valueOf(paramPasswdRedBagInfo.jdField_a_of_type_Long));
        localContentValues.put("password", paramPasswdRedBagInfo.d);
        boolean bool = paramPasswdRedBagInfo.jdField_a_of_type_Boolean;
        int j = 1;
        if (bool)
        {
          i = 1;
          localContentValues.put("is_open", Integer.valueOf(i));
          if (!paramPasswdRedBagInfo.jdField_b_of_type_Boolean) {
            break label206;
          }
          i = j;
          localContentValues.put("is_finish", Integer.valueOf(i));
          localContentValues.put("redbag_type", Integer.valueOf(paramPasswdRedBagInfo.jdField_a_of_type_Int));
          localContentValues.put("last_password", paramPasswdRedBagInfo.e);
          localContentValues.put("ext_str", paramPasswdRedBagInfo.f);
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bags", null, localContentValues);
          return;
        }
      }
      catch (Exception paramPasswdRedBagInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "insertPasswdRedBag failed ");
        }
        paramPasswdRedBagInfo.printStackTrace();
        return;
      }
      int i = 0;
      continue;
      label206:
      i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("last_password", paramString2);
      localContentValues.put("ext_str", paramString3);
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString1 });
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("setLastPasswd success result ");
        paramString1.append(i);
        QLog.d("PasswdRedBagSgervice", 2, paramString1.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("setLastPasswd failed ");
        paramString2.append(paramString1);
        QLog.d("PasswdRedBagSgervice", 2, paramString2.toString());
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bag_relations", null, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "insertPasswdRedBagRelation failed ");
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOpen|id: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isOpen: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
        localObject = new ContentValues();
        if (!paramBoolean) {
          break label181;
        }
        i = 1;
        ((ContentValues)localObject).put("is_open", Integer.valueOf(i));
        i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", (ContentValues)localObject, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setOpen result ");
          paramString.append(i);
          QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "setOpen failed ");
        }
        paramString.printStackTrace();
      }
      return;
      label181:
      int i = 0;
    }
  }
  
  /* Error */
  public void a(java.util.List<PasswdRedBagUpdateInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 30	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   7: invokevirtual 47	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: putfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_0
    //   14: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokevirtual 292	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: new 232	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 233	android/content/ContentValues:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 296 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 301 1 0
    //   41: ifeq +71 -> 112
    //   44: aload_1
    //   45: invokeinterface 305 1 0
    //   50: checkcast 208	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 308	android/content/ContentValues:clear	()V
    //   58: aload_2
    //   59: ldc 57
    //   61: aload_3
    //   62: getfield 211	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   65: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   71: aload_2
    //   72: ldc 59
    //   74: aload_3
    //   75: getfield 210	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   78: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   84: aload_2
    //   85: ldc 204
    //   87: aload_3
    //   88: getfield 213	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagUpdateInfo:b	J
    //   91: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload_0
    //   98: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   101: ldc 202
    //   103: aconst_null
    //   104: aload_2
    //   105: invokevirtual 257	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   108: pop2
    //   109: goto -74 -> 35
    //   112: aload_0
    //   113: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   116: invokevirtual 311	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   119: aload_0
    //   120: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   123: ifnull +75 -> 198
    //   126: aload_0
    //   127: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   130: invokevirtual 314	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   133: ifeq +65 -> 198
    //   136: aload_0
    //   137: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   140: invokevirtual 317	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   143: goto +55 -> 198
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   151: goto +47 -> 198
    //   154: astore_1
    //   155: goto +46 -> 201
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   163: aload_0
    //   164: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   167: ifnull +31 -> 198
    //   170: aload_0
    //   171: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   174: invokevirtual 314	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   177: ifeq +21 -> 198
    //   180: aload_0
    //   181: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   184: invokevirtual 317	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   187: goto +11 -> 198
    //   190: astore_1
    //   191: goto +44 -> 235
    //   194: astore_1
    //   195: goto -48 -> 147
    //   198: aload_0
    //   199: monitorexit
    //   200: return
    //   201: aload_0
    //   202: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   205: ifnull +28 -> 233
    //   208: aload_0
    //   209: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   212: invokevirtual 314	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   215: ifeq +18 -> 233
    //   218: aload_0
    //   219: getfield 49	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   222: invokevirtual 317	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   225: goto +8 -> 233
    //   228: astore_2
    //   229: aload_2
    //   230: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   233: aload_1
    //   234: athrow
    //   235: aload_0
    //   236: monitorexit
    //   237: goto +5 -> 242
    //   240: aload_1
    //   241: athrow
    //   242: goto -2 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	PasswdRedBagDBManager
    //   0	245	1	paramList	java.util.List<PasswdRedBagUpdateInfo>
    //   27	78	2	localContentValues	ContentValues
    //   228	2	2	localThrowable	Throwable
    //   53	35	3	localPasswdRedBagUpdateInfo	PasswdRedBagUpdateInfo
    // Exception table:
    //   from	to	target	type
    //   119	143	146	java/lang/Throwable
    //   2	35	154	finally
    //   35	109	154	finally
    //   112	119	154	finally
    //   159	163	154	finally
    //   2	35	158	java/lang/Throwable
    //   35	109	158	java/lang/Throwable
    //   112	119	158	java/lang/Throwable
    //   119	143	190	finally
    //   147	151	190	finally
    //   163	187	190	finally
    //   201	225	190	finally
    //   229	233	190	finally
    //   233	235	190	finally
    //   163	187	194	java/lang/Throwable
    //   201	225	228	java/lang/Throwable
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "clearExpirePasswdRedBag failed ");
      }
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagDBHelper.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        if (!paramBoolean) {
          break label123;
        }
        i = 1;
        localContentValues.put("is_finish", Integer.valueOf(i));
        i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setFinish result ");
          paramString.append(i);
          QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "setFinish failed ");
        }
        paramString.printStackTrace();
      }
      return;
      label123:
      int i = 0;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 23
    //   3: aconst_null
    //   4: astore 24
    //   6: aconst_null
    //   7: astore 26
    //   9: aconst_null
    //   10: astore 25
    //   12: aconst_null
    //   13: astore 27
    //   15: aload 23
    //   17: getfield 32	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   20: ldc_w 343
    //   23: invokevirtual 349	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore 22
    //   28: aload 22
    //   30: invokevirtual 354	java/io/File:exists	()Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: aload 22
    //   39: invokevirtual 357	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: aconst_null
    //   43: iconst_0
    //   44: invokestatic 361	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 22
    //   49: aload 22
    //   51: ifnonnull +14 -> 65
    //   54: aload 22
    //   56: ifnull +8 -> 64
    //   59: aload 22
    //   61: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   64: return
    //   65: aload 27
    //   67: astore 25
    //   69: aload 22
    //   71: astore 26
    //   73: aload 22
    //   75: astore 27
    //   77: aload 22
    //   79: ldc_w 363
    //   82: iconst_1
    //   83: anewarray 53	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload 23
    //   90: getfield 34	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: aastore
    //   94: invokevirtual 367	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore 23
    //   99: aload 22
    //   101: astore 24
    //   103: aload 23
    //   105: ifnull +588 -> 693
    //   108: aload 23
    //   110: astore 25
    //   112: aload 22
    //   114: astore 26
    //   116: aload 23
    //   118: astore 24
    //   120: aload 22
    //   122: astore 27
    //   124: aload 23
    //   126: ldc 55
    //   128: invokeinterface 73 2 0
    //   133: istore_1
    //   134: aload 23
    //   136: astore 25
    //   138: aload 22
    //   140: astore 26
    //   142: aload 23
    //   144: astore 24
    //   146: aload 22
    //   148: astore 27
    //   150: aload 23
    //   152: ldc 129
    //   154: invokeinterface 73 2 0
    //   159: istore_2
    //   160: aload 23
    //   162: astore 25
    //   164: aload 22
    //   166: astore 26
    //   168: aload 23
    //   170: astore 24
    //   172: aload 22
    //   174: astore 27
    //   176: aload 23
    //   178: ldc 131
    //   180: invokeinterface 73 2 0
    //   185: istore_3
    //   186: aload 23
    //   188: astore 25
    //   190: aload 22
    //   192: astore 26
    //   194: aload 23
    //   196: astore 24
    //   198: aload 22
    //   200: astore 27
    //   202: aload 23
    //   204: ldc 133
    //   206: invokeinterface 73 2 0
    //   211: istore 4
    //   213: aload 23
    //   215: astore 25
    //   217: aload 22
    //   219: astore 26
    //   221: aload 23
    //   223: astore 24
    //   225: aload 22
    //   227: astore 27
    //   229: aload 23
    //   231: ldc 135
    //   233: invokeinterface 73 2 0
    //   238: istore 5
    //   240: aload 23
    //   242: astore 25
    //   244: aload 22
    //   246: astore 26
    //   248: aload 23
    //   250: astore 24
    //   252: aload 22
    //   254: astore 27
    //   256: aload 23
    //   258: ldc 61
    //   260: invokeinterface 73 2 0
    //   265: istore 6
    //   267: aload 23
    //   269: astore 25
    //   271: aload 22
    //   273: astore 26
    //   275: aload 23
    //   277: astore 24
    //   279: aload 22
    //   281: astore 27
    //   283: aload 23
    //   285: ldc 57
    //   287: invokeinterface 73 2 0
    //   292: istore 7
    //   294: aload 23
    //   296: astore 25
    //   298: aload 22
    //   300: astore 26
    //   302: aload 23
    //   304: astore 24
    //   306: aload 22
    //   308: astore 27
    //   310: aload 23
    //   312: ldc 59
    //   314: invokeinterface 73 2 0
    //   319: istore 8
    //   321: aload 23
    //   323: astore 25
    //   325: aload 22
    //   327: astore 26
    //   329: aload 23
    //   331: astore 24
    //   333: aload 22
    //   335: astore 27
    //   337: aload 23
    //   339: ldc 137
    //   341: invokeinterface 73 2 0
    //   346: istore 9
    //   348: aload 23
    //   350: astore 25
    //   352: aload 22
    //   354: astore 26
    //   356: aload 23
    //   358: astore 24
    //   360: aload 22
    //   362: astore 27
    //   364: aload 23
    //   366: ldc 139
    //   368: invokeinterface 73 2 0
    //   373: istore 10
    //   375: aload 23
    //   377: astore 25
    //   379: aload 22
    //   381: astore 26
    //   383: aload 23
    //   385: astore 24
    //   387: aload 22
    //   389: astore 27
    //   391: aload 23
    //   393: ldc 141
    //   395: invokeinterface 73 2 0
    //   400: istore 11
    //   402: aload 23
    //   404: astore 25
    //   406: aload 22
    //   408: astore 26
    //   410: aload 23
    //   412: astore 24
    //   414: aload 22
    //   416: astore 27
    //   418: aload 23
    //   420: ldc 143
    //   422: invokeinterface 73 2 0
    //   427: istore 12
    //   429: aload 23
    //   431: astore 25
    //   433: aload 22
    //   435: astore 26
    //   437: aload 23
    //   439: astore 24
    //   441: aload 22
    //   443: astore 27
    //   445: aload 23
    //   447: ldc 145
    //   449: invokeinterface 73 2 0
    //   454: istore 13
    //   456: aload 23
    //   458: astore 25
    //   460: aload 22
    //   462: astore 26
    //   464: aload 23
    //   466: astore 24
    //   468: aload 22
    //   470: astore 27
    //   472: aload 23
    //   474: invokeinterface 77 1 0
    //   479: istore 16
    //   481: aload 22
    //   483: astore 24
    //   485: iload 16
    //   487: ifeq +206 -> 693
    //   490: aload_0
    //   491: getfield 36	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagServiceImpl;
    //   494: astore 24
    //   496: aload 23
    //   498: iload_1
    //   499: invokeinterface 84 2 0
    //   504: astore 25
    //   506: aload 23
    //   508: iload_2
    //   509: invokeinterface 84 2 0
    //   514: astore 26
    //   516: aload 23
    //   518: iload 5
    //   520: invokeinterface 84 2 0
    //   525: astore 27
    //   527: aload 23
    //   529: iload_3
    //   530: invokeinterface 172 2 0
    //   535: lstore 18
    //   537: aload 23
    //   539: iload 4
    //   541: invokeinterface 172 2 0
    //   546: lstore 20
    //   548: aload 23
    //   550: iload 8
    //   552: invokeinterface 154 2 0
    //   557: istore 14
    //   559: aload 23
    //   561: iload 7
    //   563: invokeinterface 154 2 0
    //   568: istore 15
    //   570: aload 23
    //   572: iload 6
    //   574: invokeinterface 84 2 0
    //   579: astore 28
    //   581: aload 23
    //   583: iload 9
    //   585: invokeinterface 154 2 0
    //   590: iconst_1
    //   591: if_icmpne +280 -> 871
    //   594: iconst_1
    //   595: istore 16
    //   597: goto +3 -> 600
    //   600: aload 23
    //   602: iload 10
    //   604: invokeinterface 154 2 0
    //   609: iconst_1
    //   610: if_icmpne +267 -> 877
    //   613: iconst_1
    //   614: istore 17
    //   616: goto +3 -> 619
    //   619: aload 24
    //   621: aload 25
    //   623: aload 26
    //   625: aload 27
    //   627: lload 18
    //   629: invokestatic 331	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   632: lload 20
    //   634: iload 14
    //   636: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   639: iload 15
    //   641: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   644: aload 28
    //   646: iload 16
    //   648: iload 17
    //   650: aload 23
    //   652: iload 11
    //   654: invokeinterface 154 2 0
    //   659: aload 23
    //   661: iload 12
    //   663: invokeinterface 84 2 0
    //   668: aload 23
    //   670: iload 13
    //   672: invokeinterface 84 2 0
    //   677: invokevirtual 373	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagServiceImpl:savePasswdRedBag	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V
    //   680: goto -224 -> 456
    //   683: astore 24
    //   685: goto +155 -> 840
    //   688: astore 24
    //   690: goto +53 -> 743
    //   693: aload 23
    //   695: ifnull +10 -> 705
    //   698: aload 23
    //   700: invokeinterface 101 1 0
    //   705: aload 24
    //   707: ifnull +114 -> 821
    //   710: aload 24
    //   712: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   715: return
    //   716: astore 24
    //   718: aload 26
    //   720: astore 22
    //   722: aload 25
    //   724: astore 23
    //   726: goto +114 -> 840
    //   729: astore 25
    //   731: aload 27
    //   733: astore 22
    //   735: aload 24
    //   737: astore 23
    //   739: aload 25
    //   741: astore 24
    //   743: aload 22
    //   745: astore 25
    //   747: aload 23
    //   749: astore 22
    //   751: aload 25
    //   753: astore 23
    //   755: goto +24 -> 779
    //   758: astore 24
    //   760: aconst_null
    //   761: astore 22
    //   763: aload 25
    //   765: astore 23
    //   767: goto +73 -> 840
    //   770: astore 24
    //   772: aconst_null
    //   773: astore 22
    //   775: aload 26
    //   777: astore 23
    //   779: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +12 -> 794
    //   785: ldc 108
    //   787: iconst_2
    //   788: ldc_w 375
    //   791: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aload 24
    //   796: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   799: aload 22
    //   801: ifnull +10 -> 811
    //   804: aload 22
    //   806: invokeinterface 101 1 0
    //   811: aload 23
    //   813: ifnull +8 -> 821
    //   816: aload 23
    //   818: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   821: return
    //   822: astore 25
    //   824: aload 22
    //   826: astore 24
    //   828: aload 23
    //   830: astore 22
    //   832: aload 24
    //   834: astore 23
    //   836: aload 25
    //   838: astore 24
    //   840: aload 23
    //   842: ifnull +10 -> 852
    //   845: aload 23
    //   847: invokeinterface 101 1 0
    //   852: aload 22
    //   854: ifnull +8 -> 862
    //   857: aload 22
    //   859: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   862: goto +6 -> 868
    //   865: aload 24
    //   867: athrow
    //   868: goto -3 -> 865
    //   871: iconst_0
    //   872: istore 16
    //   874: goto -274 -> 600
    //   877: iconst_0
    //   878: istore 17
    //   880: goto -261 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	883	0	this	PasswdRedBagDBManager
    //   133	366	1	i	int
    //   159	350	2	j	int
    //   185	345	3	k	int
    //   211	329	4	m	int
    //   238	281	5	n	int
    //   265	308	6	i1	int
    //   292	270	7	i2	int
    //   319	232	8	i3	int
    //   346	238	9	i4	int
    //   373	230	10	i5	int
    //   400	253	11	i6	int
    //   427	235	12	i7	int
    //   454	217	13	i8	int
    //   557	78	14	i9	int
    //   568	72	15	i10	int
    //   479	394	16	bool1	boolean
    //   614	265	17	bool2	boolean
    //   535	93	18	l1	long
    //   546	87	20	l2	long
    //   26	832	22	localObject1	Object
    //   1	845	23	localObject2	Object
    //   4	616	24	localObject3	Object
    //   683	1	24	localObject4	Object
    //   688	23	24	localException1	Exception
    //   716	20	24	localObject5	Object
    //   741	1	24	localObject6	Object
    //   758	1	24	localObject7	Object
    //   770	25	24	localException2	Exception
    //   826	40	24	localObject8	Object
    //   10	713	25	localObject9	Object
    //   729	11	25	localException3	Exception
    //   745	19	25	localObject10	Object
    //   822	15	25	localObject11	Object
    //   7	769	26	localObject12	Object
    //   13	719	27	localObject13	Object
    //   579	66	28	str	String
    // Exception table:
    //   from	to	target	type
    //   490	594	683	finally
    //   600	613	683	finally
    //   619	680	683	finally
    //   490	594	688	java/lang/Exception
    //   600	613	688	java/lang/Exception
    //   619	680	688	java/lang/Exception
    //   77	99	716	finally
    //   124	134	716	finally
    //   150	160	716	finally
    //   176	186	716	finally
    //   202	213	716	finally
    //   229	240	716	finally
    //   256	267	716	finally
    //   283	294	716	finally
    //   310	321	716	finally
    //   337	348	716	finally
    //   364	375	716	finally
    //   391	402	716	finally
    //   418	429	716	finally
    //   445	456	716	finally
    //   472	481	716	finally
    //   77	99	729	java/lang/Exception
    //   124	134	729	java/lang/Exception
    //   150	160	729	java/lang/Exception
    //   176	186	729	java/lang/Exception
    //   202	213	729	java/lang/Exception
    //   229	240	729	java/lang/Exception
    //   256	267	729	java/lang/Exception
    //   283	294	729	java/lang/Exception
    //   310	321	729	java/lang/Exception
    //   337	348	729	java/lang/Exception
    //   364	375	729	java/lang/Exception
    //   391	402	729	java/lang/Exception
    //   418	429	729	java/lang/Exception
    //   445	456	729	java/lang/Exception
    //   472	481	729	java/lang/Exception
    //   15	36	758	finally
    //   37	49	758	finally
    //   15	36	770	java/lang/Exception
    //   37	49	770	java/lang/Exception
    //   779	794	822	finally
    //   794	799	822	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagDBManager
 * JD-Core Version:    0.7.0.1
 */