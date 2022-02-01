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
  private Context a;
  private String b;
  private SQLiteDatabase c;
  private PasswdRedBagDBHelper d;
  private PasswdRedBagServiceImpl e;
  
  public PasswdRedBagDBManager(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl)
  {
    this.d = new PasswdRedBagDBHelper(paramPasswdRedBagServiceImpl.mContext, paramPasswdRedBagServiceImpl.mUin);
    this.a = paramPasswdRedBagServiceImpl.mContext;
    this.b = paramPasswdRedBagServiceImpl.mUin;
    this.e = paramPasswdRedBagServiceImpl;
  }
  
  public JSONObject a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
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
    SQLiteDatabase localSQLiteDatabase = this.c;
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
        this.c = this.d.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("redbag_id", paramPasswdRedBagInfo.a);
        localContentValues.put("redbag_index", paramPasswdRedBagInfo.b);
        localContentValues.put("uint64_creator_uin", paramPasswdRedBagInfo.c);
        localContentValues.put("expire_time", Long.valueOf(paramPasswdRedBagInfo.d));
        localContentValues.put("password", paramPasswdRedBagInfo.e);
        boolean bool = paramPasswdRedBagInfo.f;
        int j = 1;
        if (bool)
        {
          i = 1;
          localContentValues.put("is_open", Integer.valueOf(i));
          if (!paramPasswdRedBagInfo.g) {
            break label205;
          }
          i = j;
          localContentValues.put("is_finish", Integer.valueOf(i));
          localContentValues.put("redbag_type", Integer.valueOf(paramPasswdRedBagInfo.h));
          localContentValues.put("last_password", paramPasswdRedBagInfo.i);
          localContentValues.put("ext_str", paramPasswdRedBagInfo.j);
          this.c.replace("red_bags", null, localContentValues);
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
      label205:
      i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.c = this.d.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("last_password", paramString2);
      localContentValues.put("ext_str", paramString3);
      int i = this.c.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString1 });
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
      this.c = this.d.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.c.replace("red_bag_relations", null, localContentValues);
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
        this.c = this.d.getWritableDatabase();
        localObject = new ContentValues();
        if (!paramBoolean) {
          break label176;
        }
        i = 1;
        ((ContentValues)localObject).put("is_open", Integer.valueOf(i));
        i = this.c.update("red_bags", (ContentValues)localObject, "redbag_id=?", new String[] { paramString });
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
      label176:
      int i = 0;
    }
  }
  
  /* Error */
  public java.util.List<PasswdRedBagInfo> b()
  {
    // Byte code:
    //   0: new 221	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 222	java/util/ArrayList:<init>	()V
    //   7: astore 15
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 34	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:d	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   14: invokevirtual 70	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 58	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:c	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 58	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:c	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 145
    //   26: bipush 10
    //   28: anewarray 170	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 75
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 85
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 88
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 92
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 106
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 114
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 127
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 129
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 135
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 140
    //   84: aastore
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: ldc 224
    //   91: invokevirtual 228	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   94: astore 13
    //   96: aload 13
    //   98: ifnull +321 -> 419
    //   101: aload 13
    //   103: ldc 75
    //   105: invokeinterface 234 2 0
    //   110: istore_3
    //   111: aload 13
    //   113: ldc 85
    //   115: invokeinterface 234 2 0
    //   120: istore 4
    //   122: aload 13
    //   124: ldc 88
    //   126: invokeinterface 234 2 0
    //   131: istore 5
    //   133: aload 13
    //   135: ldc 92
    //   137: invokeinterface 234 2 0
    //   142: istore 6
    //   144: aload 13
    //   146: ldc 106
    //   148: invokeinterface 234 2 0
    //   153: istore 7
    //   155: aload 13
    //   157: ldc 114
    //   159: invokeinterface 234 2 0
    //   164: istore_2
    //   165: aload 13
    //   167: ldc 127
    //   169: invokeinterface 234 2 0
    //   174: istore_1
    //   175: aload 13
    //   177: ldc 129
    //   179: invokeinterface 234 2 0
    //   184: istore 8
    //   186: aload 13
    //   188: ldc 135
    //   190: invokeinterface 234 2 0
    //   195: istore 9
    //   197: aload 13
    //   199: ldc 140
    //   201: invokeinterface 234 2 0
    //   206: istore 10
    //   208: aload 13
    //   210: invokeinterface 237 1 0
    //   215: ifeq +204 -> 419
    //   218: new 77	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo
    //   221: dup
    //   222: invokespecial 238	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:<init>	()V
    //   225: astore 12
    //   227: aload 13
    //   229: iload_1
    //   230: invokeinterface 242 2 0
    //   235: iconst_1
    //   236: if_icmpne +277 -> 513
    //   239: iconst_1
    //   240: istore 11
    //   242: goto +3 -> 245
    //   245: aload 12
    //   247: iload 11
    //   249: putfield 125	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:g	Z
    //   252: aload 13
    //   254: iload_2
    //   255: invokeinterface 242 2 0
    //   260: iconst_1
    //   261: if_icmpne +258 -> 519
    //   264: iconst_1
    //   265: istore 11
    //   267: goto +3 -> 270
    //   270: aload 12
    //   272: iload 11
    //   274: putfield 112	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:f	Z
    //   277: aload 12
    //   279: aload 13
    //   281: iload 7
    //   283: invokeinterface 246 2 0
    //   288: putfield 108	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:e	Ljava/lang/String;
    //   291: aload 12
    //   293: aload 13
    //   295: iload_3
    //   296: invokeinterface 246 2 0
    //   301: putfield 79	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:a	Ljava/lang/String;
    //   304: aload 12
    //   306: aload 13
    //   308: iload 4
    //   310: invokeinterface 246 2 0
    //   315: putfield 86	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:b	Ljava/lang/String;
    //   318: aload 12
    //   320: aload 13
    //   322: iload 5
    //   324: invokeinterface 246 2 0
    //   329: putfield 90	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:c	Ljava/lang/String;
    //   332: aload 12
    //   334: aload 13
    //   336: iload 6
    //   338: invokeinterface 250 2 0
    //   343: putfield 95	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:d	J
    //   346: aload 12
    //   348: aload 13
    //   350: iload 8
    //   352: invokeinterface 242 2 0
    //   357: putfield 133	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:h	I
    //   360: aload 12
    //   362: aload 13
    //   364: iload 9
    //   366: invokeinterface 246 2 0
    //   371: putfield 138	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:i	Ljava/lang/String;
    //   374: aload 12
    //   376: aload 13
    //   378: iload 10
    //   380: invokeinterface 246 2 0
    //   385: putfield 143	com/tencent/mobileqq/qwallet/hb/aio/passwd/PasswdRedBagInfo:j	Ljava/lang/String;
    //   388: aload 15
    //   390: aload 12
    //   392: invokeinterface 256 2 0
    //   397: pop
    //   398: goto -190 -> 208
    //   401: astore 12
    //   403: goto +89 -> 492
    //   406: astore 14
    //   408: aload 13
    //   410: astore 12
    //   412: aload 14
    //   414: astore 13
    //   416: goto +31 -> 447
    //   419: aload 13
    //   421: ifnull +58 -> 479
    //   424: aload 13
    //   426: invokeinterface 257 1 0
    //   431: aload 15
    //   433: areturn
    //   434: astore 12
    //   436: aconst_null
    //   437: astore 13
    //   439: goto +53 -> 492
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +12 -> 462
    //   453: ldc 157
    //   455: iconst_2
    //   456: ldc_w 259
    //   459: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 13
    //   464: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   467: aload 12
    //   469: ifnull +10 -> 479
    //   472: aload 12
    //   474: invokeinterface 257 1 0
    //   479: aload 15
    //   481: areturn
    //   482: astore 14
    //   484: aload 12
    //   486: astore 13
    //   488: aload 14
    //   490: astore 12
    //   492: aload 13
    //   494: ifnull +10 -> 504
    //   497: aload 13
    //   499: invokeinterface 257 1 0
    //   504: goto +6 -> 510
    //   507: aload 12
    //   509: athrow
    //   510: goto -3 -> 507
    //   513: iconst_0
    //   514: istore 11
    //   516: goto -271 -> 245
    //   519: iconst_0
    //   520: istore 11
    //   522: goto -252 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	PasswdRedBagDBManager
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
    //   240	281	11	bool	boolean
    //   225	166	12	localPasswdRedBagInfo	PasswdRedBagInfo
    //   401	1	12	localObject1	Object
    //   410	1	12	localObject2	Object
    //   434	1	12	localObject3	Object
    //   445	63	12	localObject4	Object
    //   94	344	13	localObject5	Object
    //   442	21	13	localException1	Exception
    //   486	12	13	localObject6	Object
    //   406	7	14	localException2	Exception
    //   482	7	14	localObject7	Object
    //   7	473	15	localArrayList	java.util.ArrayList
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
    //   447	462	482	finally
    //   462	467	482	finally
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.c = this.d.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        if (!paramBoolean) {
          break label122;
        }
        i = 1;
        localContentValues.put("is_finish", Integer.valueOf(i));
        i = this.c.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
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
      label122:
      int i = 0;
    }
  }
  
  /* Error */
  public java.util.HashMap<String, String> c()
  {
    // Byte code:
    //   0: new 268	java/util/HashMap
    //   3: dup
    //   4: invokespecial 269	java/util/HashMap:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 34	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:d	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper;
    //   14: invokevirtual 70	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 58	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:c	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 58	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:c	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 204
    //   26: iconst_4
    //   27: anewarray 170	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 75
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 200
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 198
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 202
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 228	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +199 -> 261
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 75
    //   73: invokeinterface 234 2 0
    //   78: istore_1
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ldc 200
    //   87: invokeinterface 234 2 0
    //   92: istore_2
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: ldc 198
    //   101: invokeinterface 234 2 0
    //   106: istore_3
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ldc 202
    //   115: invokeinterface 234 2 0
    //   120: istore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload 6
    //   128: invokeinterface 237 1 0
    //   133: ifeq +128 -> 261
    //   136: aload 6
    //   138: astore 5
    //   140: new 176	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 6
    //   151: astore 5
    //   153: aload 8
    //   155: aload 6
    //   157: iload_3
    //   158: invokeinterface 246 2 0
    //   163: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 8
    //   173: ldc_w 271
    //   176: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 6
    //   182: astore 5
    //   184: aload 8
    //   186: aload 6
    //   188: iload_2
    //   189: invokeinterface 246 2 0
    //   194: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 6
    //   200: astore 5
    //   202: aload 8
    //   204: ldc_w 271
    //   207: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: astore 5
    //   215: aload 8
    //   217: aload 6
    //   219: iload_1
    //   220: invokeinterface 246 2 0
    //   225: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: astore 5
    //   233: aload 7
    //   235: aload 8
    //   237: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aload 6
    //   242: iload 4
    //   244: invokeinterface 246 2 0
    //   249: invokevirtual 274	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: goto -131 -> 122
    //   256: astore 7
    //   258: goto +35 -> 293
    //   261: aload 7
    //   263: astore 5
    //   265: aload 6
    //   267: ifnull +73 -> 340
    //   270: aload 6
    //   272: invokeinterface 257 1 0
    //   277: aload 7
    //   279: areturn
    //   280: astore 5
    //   282: aconst_null
    //   283: astore 6
    //   285: goto +68 -> 353
    //   288: astore 7
    //   290: aconst_null
    //   291: astore 6
    //   293: aload 6
    //   295: astore 5
    //   297: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +16 -> 316
    //   303: aload 6
    //   305: astore 5
    //   307: ldc 157
    //   309: iconst_2
    //   310: ldc_w 276
    //   313: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 6
    //   318: astore 5
    //   320: aload 7
    //   322: invokevirtual 277	java/lang/Throwable:printStackTrace	()V
    //   325: aload 6
    //   327: ifnull +10 -> 337
    //   330: aload 6
    //   332: invokeinterface 257 1 0
    //   337: aconst_null
    //   338: astore 5
    //   340: aload 5
    //   342: areturn
    //   343: astore 7
    //   345: aload 5
    //   347: astore 6
    //   349: aload 7
    //   351: astore 5
    //   353: aload 6
    //   355: ifnull +10 -> 365
    //   358: aload 6
    //   360: invokeinterface 257 1 0
    //   365: goto +6 -> 371
    //   368: aload 5
    //   370: athrow
    //   371: goto -3 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	PasswdRedBagDBManager
    //   78	142	1	i	int
    //   92	97	2	j	int
    //   106	52	3	k	int
    //   120	123	4	m	int
    //   67	197	5	localObject1	Object
    //   280	1	5	localObject2	Object
    //   295	74	5	localObject3	Object
    //   58	301	6	localObject4	Object
    //   7	227	7	localHashMap	java.util.HashMap
    //   256	22	7	localThrowable1	Throwable
    //   288	33	7	localThrowable2	Throwable
    //   343	7	7	localObject5	Object
    //   147	89	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	79	256	java/lang/Throwable
    //   83	93	256	java/lang/Throwable
    //   97	107	256	java/lang/Throwable
    //   111	122	256	java/lang/Throwable
    //   126	136	256	java/lang/Throwable
    //   140	149	256	java/lang/Throwable
    //   153	167	256	java/lang/Throwable
    //   171	180	256	java/lang/Throwable
    //   184	198	256	java/lang/Throwable
    //   202	211	256	java/lang/Throwable
    //   215	229	256	java/lang/Throwable
    //   233	253	256	java/lang/Throwable
    //   9	60	280	finally
    //   9	60	288	java/lang/Throwable
    //   69	79	343	finally
    //   83	93	343	finally
    //   97	107	343	finally
    //   111	122	343	finally
    //   126	136	343	finally
    //   140	149	343	finally
    //   153	167	343	finally
    //   171	180	343	finally
    //   184	198	343	finally
    //   202	211	343	finally
    //   215	229	343	finally
    //   233	253	343	finally
    //   297	303	343	finally
    //   307	316	343	finally
    //   320	325	343	finally
  }
  
  public void d()
  {
    try
    {
      this.c = this.d.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.c.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l) });
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
  
  /* Error */
  public void e()
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
    //   17: getfield 36	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:a	Landroid/content/Context;
    //   20: ldc_w 299
    //   23: invokevirtual 305	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore 22
    //   28: aload 22
    //   30: invokevirtual 310	java/io/File:exists	()Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: aload 22
    //   39: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: aconst_null
    //   43: iconst_0
    //   44: invokestatic 317	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 22
    //   49: aload 22
    //   51: ifnonnull +14 -> 65
    //   54: aload 22
    //   56: ifnull +8 -> 64
    //   59: aload 22
    //   61: invokevirtual 63	android/database/sqlite/SQLiteDatabase:close	()V
    //   64: return
    //   65: aload 27
    //   67: astore 25
    //   69: aload 22
    //   71: astore 26
    //   73: aload 22
    //   75: astore 27
    //   77: aload 22
    //   79: ldc_w 319
    //   82: iconst_1
    //   83: anewarray 170	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload 23
    //   90: getfield 38	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:b	Ljava/lang/String;
    //   93: aastore
    //   94: invokevirtual 323	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   126: ldc 75
    //   128: invokeinterface 234 2 0
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
    //   152: ldc 85
    //   154: invokeinterface 234 2 0
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
    //   178: ldc 88
    //   180: invokeinterface 234 2 0
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
    //   204: ldc 92
    //   206: invokeinterface 234 2 0
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
    //   231: ldc 106
    //   233: invokeinterface 234 2 0
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
    //   258: ldc 202
    //   260: invokeinterface 234 2 0
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
    //   285: ldc 200
    //   287: invokeinterface 234 2 0
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
    //   312: ldc 198
    //   314: invokeinterface 234 2 0
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
    //   339: ldc 114
    //   341: invokeinterface 234 2 0
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
    //   366: ldc 127
    //   368: invokeinterface 234 2 0
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
    //   393: ldc 129
    //   395: invokeinterface 234 2 0
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
    //   420: ldc 135
    //   422: invokeinterface 234 2 0
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
    //   447: ldc 140
    //   449: invokeinterface 234 2 0
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
    //   474: invokeinterface 237 1 0
    //   479: istore 16
    //   481: aload 22
    //   483: astore 24
    //   485: iload 16
    //   487: ifeq +206 -> 693
    //   490: aload_0
    //   491: getfield 40	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagDBManager:e	Lcom/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagServiceImpl;
    //   494: astore 24
    //   496: aload 23
    //   498: iload_1
    //   499: invokeinterface 246 2 0
    //   504: astore 25
    //   506: aload 23
    //   508: iload_2
    //   509: invokeinterface 246 2 0
    //   514: astore 26
    //   516: aload 23
    //   518: iload 5
    //   520: invokeinterface 246 2 0
    //   525: astore 27
    //   527: aload 23
    //   529: iload_3
    //   530: invokeinterface 250 2 0
    //   535: lstore 18
    //   537: aload 23
    //   539: iload 4
    //   541: invokeinterface 250 2 0
    //   546: lstore 20
    //   548: aload 23
    //   550: iload 8
    //   552: invokeinterface 242 2 0
    //   557: istore 14
    //   559: aload 23
    //   561: iload 7
    //   563: invokeinterface 242 2 0
    //   568: istore 15
    //   570: aload 23
    //   572: iload 6
    //   574: invokeinterface 246 2 0
    //   579: astore 28
    //   581: aload 23
    //   583: iload 9
    //   585: invokeinterface 242 2 0
    //   590: iconst_1
    //   591: if_icmpne +280 -> 871
    //   594: iconst_1
    //   595: istore 16
    //   597: goto +3 -> 600
    //   600: aload 23
    //   602: iload 10
    //   604: invokeinterface 242 2 0
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
    //   629: invokestatic 291	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   632: lload 20
    //   634: iload 14
    //   636: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   639: iload 15
    //   641: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   644: aload 28
    //   646: iload 16
    //   648: iload 17
    //   650: aload 23
    //   652: iload 11
    //   654: invokeinterface 242 2 0
    //   659: aload 23
    //   661: iload 12
    //   663: invokeinterface 246 2 0
    //   668: aload 23
    //   670: iload 13
    //   672: invokeinterface 246 2 0
    //   677: invokevirtual 329	com/tencent/mobileqq/qwallet/hb/aio/passwd/impl/PasswdRedBagServiceImpl:savePasswdRedBag	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V
    //   680: goto -224 -> 456
    //   683: astore 24
    //   685: goto +155 -> 840
    //   688: astore 24
    //   690: goto +53 -> 743
    //   693: aload 23
    //   695: ifnull +10 -> 705
    //   698: aload 23
    //   700: invokeinterface 257 1 0
    //   705: aload 24
    //   707: ifnull +114 -> 821
    //   710: aload 24
    //   712: invokevirtual 63	android/database/sqlite/SQLiteDatabase:close	()V
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
    //   779: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +12 -> 794
    //   785: ldc 157
    //   787: iconst_2
    //   788: ldc_w 331
    //   791: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aload 24
    //   796: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   799: aload 22
    //   801: ifnull +10 -> 811
    //   804: aload 22
    //   806: invokeinterface 257 1 0
    //   811: aload 23
    //   813: ifnull +8 -> 821
    //   816: aload 23
    //   818: invokevirtual 63	android/database/sqlite/SQLiteDatabase:close	()V
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
    //   847: invokeinterface 257 1 0
    //   852: aload 22
    //   854: ifnull +8 -> 862
    //   857: aload 22
    //   859: invokevirtual 63	android/database/sqlite/SQLiteDatabase:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagDBManager
 * JD-Core Version:    0.7.0.1
 */