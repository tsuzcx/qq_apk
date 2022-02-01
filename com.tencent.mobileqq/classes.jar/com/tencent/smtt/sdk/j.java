package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.ArrayList;

public class j
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/data/data/");
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("app_webview");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("Cookies");
      b = new File(localStringBuilder.toString());
    }
    return b;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(paramString);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(((StringBuilder)localObject).toString(), null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("raws:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(",columns:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("\n");
    paramString.append(((StringBuilder)localObject).toString());
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst())) {
      label164:
      do
      {
        paramString.append("\n");
        i = 0;
        while (i < j)
        {
          try
          {
            localObject = paramSQLiteDatabase.getString(i);
            paramString.append((String)localObject);
            paramString.append(",");
          }
          catch (Exception localException)
          {
            break label164;
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    } else {
      return paramString.toString();
    }
  }
  
  public static ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramSQLiteDatabase == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      try
      {
        Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            String str = localCursor.getString(1);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localCursor.getString(4);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localArrayList.add(str);
            localObject1 = localCursor;
            localObject2 = localCursor;
            a(paramSQLiteDatabase, str);
            localObject1 = localCursor;
            localObject2 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
        if (localCursor != null) {
          localCursor.close();
        }
        if ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.isOpen())) {
          break label199;
        }
      }
      finally
      {
        if (localObject1 != null) {
          localObject1.close();
        }
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
          paramSQLiteDatabase.close();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label174:
      break label174;
    }
    if (localObject3 != null) {
      localObject3.close();
    }
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
      paramSQLiteDatabase.close();
    }
    label199:
    return localArrayList;
  }
  
  /* Error */
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getstatic 133	com/tencent/smtt/sdk/CookieManager$a:b	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   9: if_acmpne +11 -> 20
    //   12: aload_2
    //   13: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_2
    //   21: ldc 101
    //   23: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 13
    //   28: aload 13
    //   30: ifnull +686 -> 716
    //   33: aload 13
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmpge +4 -> 41
    //   40: return
    //   41: aload_0
    //   42: invokestatic 149	com/tencent/smtt/sdk/j:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore 11
    //   47: aload 11
    //   49: ifnonnull +4 -> 53
    //   52: return
    //   53: new 151	java/util/HashMap
    //   56: dup
    //   57: invokespecial 152	java/util/HashMap:<init>	()V
    //   60: astore 12
    //   62: aconst_null
    //   63: astore 9
    //   65: aconst_null
    //   66: astore_2
    //   67: aload 11
    //   69: ldc 154
    //   71: aconst_null
    //   72: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 10
    //   77: aload 10
    //   79: astore_2
    //   80: aload 10
    //   82: astore 9
    //   84: aload 10
    //   86: invokeinterface 79 1 0
    //   91: ifle +332 -> 423
    //   94: aload 10
    //   96: astore_2
    //   97: aload 10
    //   99: astore 9
    //   101: aload 10
    //   103: invokeinterface 95 1 0
    //   108: ifeq +315 -> 423
    //   111: aload 10
    //   113: astore_2
    //   114: aload 10
    //   116: astore 9
    //   118: aload 10
    //   120: aload 10
    //   122: ldc 156
    //   124: invokeinterface 160 2 0
    //   129: invokeinterface 99 2 0
    //   134: astore 14
    //   136: aload 10
    //   138: astore_2
    //   139: aload 10
    //   141: astore 9
    //   143: aload_1
    //   144: getstatic 133	com/tencent/smtt/sdk/CookieManager$a:b	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   147: if_acmpne +58 -> 205
    //   150: aload 10
    //   152: astore_2
    //   153: aload 10
    //   155: astore 9
    //   157: aload 13
    //   159: arraylength
    //   160: istore 8
    //   162: iconst_0
    //   163: istore 7
    //   165: iconst_0
    //   166: istore 5
    //   168: iload 7
    //   170: istore 6
    //   172: iload 5
    //   174: iload 8
    //   176: if_icmpge +550 -> 726
    //   179: aload 10
    //   181: astore_2
    //   182: aload 10
    //   184: astore 9
    //   186: aload 14
    //   188: aload 13
    //   190: iload 5
    //   192: aaload
    //   193: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +521 -> 717
    //   199: iconst_1
    //   200: istore 6
    //   202: goto +524 -> 726
    //   205: aload 10
    //   207: astore_2
    //   208: aload 10
    //   210: astore 9
    //   212: new 39	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   219: astore 15
    //   221: aload 10
    //   223: astore_2
    //   224: aload 10
    //   226: astore 9
    //   228: aload 15
    //   230: aload 10
    //   232: aload 10
    //   234: ldc 165
    //   236: invokeinterface 160 2 0
    //   241: invokeinterface 99 2 0
    //   246: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 10
    //   252: astore_2
    //   253: aload 10
    //   255: astore 9
    //   257: aload 15
    //   259: ldc 167
    //   261: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 10
    //   267: astore_2
    //   268: aload 10
    //   270: astore 9
    //   272: aload 15
    //   274: aload 10
    //   276: aload 10
    //   278: ldc 169
    //   280: invokeinterface 160 2 0
    //   285: invokeinterface 99 2 0
    //   290: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 10
    //   296: astore_2
    //   297: aload 10
    //   299: astore 9
    //   301: aload 15
    //   303: ldc 167
    //   305: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 10
    //   311: astore_2
    //   312: aload 10
    //   314: astore 9
    //   316: aload 15
    //   318: aload 10
    //   320: aload 10
    //   322: ldc 171
    //   324: invokeinterface 160 2 0
    //   329: invokeinterface 175 2 0
    //   334: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 10
    //   340: astore_2
    //   341: aload 10
    //   343: astore 9
    //   345: aload 15
    //   347: ldc 167
    //   349: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 10
    //   355: astore_2
    //   356: aload 10
    //   358: astore 9
    //   360: aload 15
    //   362: aload 10
    //   364: aload 10
    //   366: ldc 177
    //   368: invokeinterface 160 2 0
    //   373: invokeinterface 175 2 0
    //   378: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 10
    //   384: astore_2
    //   385: aload 10
    //   387: astore 9
    //   389: aload 12
    //   391: aload 14
    //   393: aload 15
    //   395: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokevirtual 181	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: pop
    //   402: aload 10
    //   404: astore_2
    //   405: aload 10
    //   407: astore 9
    //   409: aload 10
    //   411: invokeinterface 104 1 0
    //   416: istore 4
    //   418: iload 4
    //   420: ifne -309 -> 111
    //   423: aload 10
    //   425: ifnull +10 -> 435
    //   428: aload 10
    //   430: invokeinterface 121 1 0
    //   435: aload 11
    //   437: ifnull +110 -> 547
    //   440: aload 11
    //   442: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   445: ifeq +102 -> 547
    //   448: aload 11
    //   450: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   453: goto +94 -> 547
    //   456: astore_0
    //   457: goto +229 -> 686
    //   460: astore_1
    //   461: aload 9
    //   463: astore_2
    //   464: getstatic 17	com/tencent/smtt/sdk/j:a	Ljava/lang/String;
    //   467: astore 10
    //   469: aload 9
    //   471: astore_2
    //   472: new 39	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   479: astore 13
    //   481: aload 9
    //   483: astore_2
    //   484: aload 13
    //   486: ldc 183
    //   488: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 9
    //   494: astore_2
    //   495: aload 13
    //   497: aload_1
    //   498: invokevirtual 184	java/lang/Throwable:toString	()Ljava/lang/String;
    //   501: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 9
    //   507: astore_2
    //   508: aload 10
    //   510: aload 13
    //   512: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   518: pop
    //   519: aload 9
    //   521: ifnull +10 -> 531
    //   524: aload 9
    //   526: invokeinterface 121 1 0
    //   531: aload 11
    //   533: ifnull +14 -> 547
    //   536: aload 11
    //   538: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   541: ifeq +6 -> 547
    //   544: goto -96 -> 448
    //   547: aload 12
    //   549: invokevirtual 192	java/util/HashMap:isEmpty	()Z
    //   552: ifeq +4 -> 556
    //   555: return
    //   556: aload_0
    //   557: invokestatic 195	com/tencent/smtt/sdk/j:b	(Landroid/content/Context;)Z
    //   560: pop
    //   561: aload 12
    //   563: invokevirtual 199	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   566: invokeinterface 205 1 0
    //   571: astore_1
    //   572: aload_1
    //   573: invokeinterface 210 1 0
    //   578: ifeq +50 -> 628
    //   581: aload_1
    //   582: invokeinterface 214 1 0
    //   587: checkcast 216	java/util/Map$Entry
    //   590: astore 9
    //   592: aload 9
    //   594: invokeinterface 219 1 0
    //   599: checkcast 141	java/lang/String
    //   602: astore_2
    //   603: aload 9
    //   605: invokeinterface 222 1 0
    //   610: checkcast 141	java/lang/String
    //   613: astore 9
    //   615: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   618: aload_2
    //   619: aload 9
    //   621: iconst_1
    //   622: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   625: goto -53 -> 572
    //   628: getstatic 236	android/os/Build$VERSION:SDK_INT	I
    //   631: bipush 21
    //   633: if_icmplt +12 -> 645
    //   636: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   639: invokevirtual 239	com/tencent/smtt/sdk/CookieManager:flush	()V
    //   642: goto +9 -> 651
    //   645: invokestatic 244	com/tencent/smtt/sdk/CookieSyncManager:getInstance	()Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   648: invokevirtual 247	com/tencent/smtt/sdk/CookieSyncManager:sync	()V
    //   651: iload_3
    //   652: ifeq +33 -> 685
    //   655: aload_0
    //   656: invokestatic 149	com/tencent/smtt/sdk/j:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   659: invokestatic 249	com/tencent/smtt/sdk/j:a	(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/ArrayList;
    //   662: pop
    //   663: aload_0
    //   664: invokestatic 253	com/tencent/smtt/sdk/j:d	(Landroid/content/Context;)I
    //   667: istore 5
    //   669: iload 5
    //   671: iconst_m1
    //   672: if_icmpeq +13 -> 685
    //   675: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   678: pop
    //   679: aload_0
    //   680: iload 5
    //   682: invokestatic 257	com/tencent/smtt/sdk/CookieManager:setROMCookieDBVersion	(Landroid/content/Context;I)V
    //   685: return
    //   686: aload_2
    //   687: ifnull +9 -> 696
    //   690: aload_2
    //   691: invokeinterface 121 1 0
    //   696: aload 11
    //   698: ifnull +16 -> 714
    //   701: aload 11
    //   703: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   706: ifeq +8 -> 714
    //   709: aload 11
    //   711: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   714: aload_0
    //   715: athrow
    //   716: return
    //   717: iload 5
    //   719: iconst_1
    //   720: iadd
    //   721: istore 5
    //   723: goto -555 -> 168
    //   726: iload 6
    //   728: ifne -523 -> 205
    //   731: goto -329 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	734	0	paramContext	Context
    //   0	734	1	parama	CookieManager.a
    //   0	734	2	paramString	String
    //   0	734	3	paramBoolean1	boolean
    //   0	734	4	paramBoolean2	boolean
    //   166	556	5	i	int
    //   170	557	6	j	int
    //   163	6	7	k	int
    //   160	17	8	m	int
    //   63	557	9	localObject1	Object
    //   75	434	10	localObject2	Object
    //   45	665	11	localSQLiteDatabase	SQLiteDatabase
    //   60	502	12	localHashMap	java.util.HashMap
    //   26	485	13	localObject3	Object
    //   134	258	14	str	String
    //   219	175	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	77	456	finally
    //   84	94	456	finally
    //   101	111	456	finally
    //   118	136	456	finally
    //   143	150	456	finally
    //   157	162	456	finally
    //   186	199	456	finally
    //   212	221	456	finally
    //   228	250	456	finally
    //   257	265	456	finally
    //   272	294	456	finally
    //   301	309	456	finally
    //   316	338	456	finally
    //   345	353	456	finally
    //   360	382	456	finally
    //   389	402	456	finally
    //   409	418	456	finally
    //   464	469	456	finally
    //   472	481	456	finally
    //   484	492	456	finally
    //   495	505	456	finally
    //   508	519	456	finally
    //   67	77	460	java/lang/Throwable
    //   84	94	460	java/lang/Throwable
    //   101	111	460	java/lang/Throwable
    //   118	136	460	java/lang/Throwable
    //   143	150	460	java/lang/Throwable
    //   157	162	460	java/lang/Throwable
    //   186	199	460	java/lang/Throwable
    //   212	221	460	java/lang/Throwable
    //   228	250	460	java/lang/Throwable
    //   257	265	460	java/lang/Throwable
    //   272	294	460	java/lang/Throwable
    //   301	309	460	java/lang/Throwable
    //   316	338	460	java/lang/Throwable
    //   345	353	460	java/lang/Throwable
    //   360	382	460	java/lang/Throwable
    //   389	402	460	java/lang/Throwable
    //   409	418	460	java/lang/Throwable
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    FileUtil.a(a(paramContext), false);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
      if (paramContext == null) {
        TbsLog.i(a, "dbPath is not exist!");
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  /* Error */
  public static int d(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: iconst_0
    //   5: istore_3
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore 9
    //   20: aconst_null
    //   21: astore 10
    //   23: aload_0
    //   24: invokestatic 149	com/tencent/smtt/sdk/j:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_0
    //   28: aload_0
    //   29: ifnonnull +20 -> 49
    //   32: aload_0
    //   33: ifnull +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   40: ifeq +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   47: iconst_m1
    //   48: ireturn
    //   49: aload 10
    //   51: astore 7
    //   53: aload 9
    //   55: astore 8
    //   57: aload_0
    //   58: ldc_w 287
    //   61: aconst_null
    //   62: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 9
    //   67: aload 9
    //   69: astore 7
    //   71: aload 9
    //   73: astore 8
    //   75: aload 9
    //   77: invokeinterface 79 1 0
    //   82: istore 5
    //   84: aload 9
    //   86: astore 7
    //   88: aload 9
    //   90: astore 8
    //   92: aload 9
    //   94: invokeinterface 82 1 0
    //   99: pop
    //   100: iload_2
    //   101: istore_1
    //   102: iload 5
    //   104: ifle +95 -> 199
    //   107: iload_2
    //   108: istore_1
    //   109: aload 9
    //   111: astore 7
    //   113: aload 9
    //   115: astore 8
    //   117: aload 9
    //   119: invokeinterface 95 1 0
    //   124: ifeq +75 -> 199
    //   127: aload 9
    //   129: astore 7
    //   131: aload 9
    //   133: astore 8
    //   135: aload 9
    //   137: iconst_0
    //   138: invokeinterface 99 2 0
    //   143: ldc_w 289
    //   146: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +26 -> 175
    //   152: aload 9
    //   154: astore 7
    //   156: aload 9
    //   158: astore 8
    //   160: aload 9
    //   162: iconst_1
    //   163: invokeinterface 99 2 0
    //   168: invokestatic 294	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   171: istore_1
    //   172: goto +27 -> 199
    //   175: aload 9
    //   177: astore 7
    //   179: aload 9
    //   181: astore 8
    //   183: aload 9
    //   185: invokeinterface 104 1 0
    //   190: istore 6
    //   192: iload 6
    //   194: ifne -67 -> 127
    //   197: iload_2
    //   198: istore_1
    //   199: aload 9
    //   201: ifnull +10 -> 211
    //   204: aload 9
    //   206: invokeinterface 121 1 0
    //   211: iload_1
    //   212: istore_2
    //   213: aload_0
    //   214: ifnull +96 -> 310
    //   217: iload_1
    //   218: istore_2
    //   219: aload_0
    //   220: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   223: ifeq +87 -> 310
    //   226: aload_0
    //   227: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   230: iload_1
    //   231: ireturn
    //   232: astore 8
    //   234: goto +10 -> 244
    //   237: goto +39 -> 276
    //   240: astore 8
    //   242: aconst_null
    //   243: astore_0
    //   244: aload 7
    //   246: ifnull +10 -> 256
    //   249: aload 7
    //   251: invokeinterface 121 1 0
    //   256: aload_0
    //   257: ifnull +14 -> 271
    //   260: aload_0
    //   261: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   264: ifeq +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   271: aload 8
    //   273: athrow
    //   274: aconst_null
    //   275: astore_0
    //   276: aload 8
    //   278: ifnull +10 -> 288
    //   281: aload 8
    //   283: invokeinterface 121 1 0
    //   288: iload 4
    //   290: istore_2
    //   291: aload_0
    //   292: ifnull +18 -> 310
    //   295: iload 4
    //   297: istore_2
    //   298: aload_0
    //   299: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   302: ifeq +8 -> 310
    //   305: iload_3
    //   306: istore_1
    //   307: goto -81 -> 226
    //   310: iload_2
    //   311: ireturn
    //   312: astore_0
    //   313: goto -39 -> 274
    //   316: astore 7
    //   318: goto -81 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   101	206	1	i	int
    //   10	301	2	j	int
    //   5	301	3	k	int
    //   7	289	4	m	int
    //   82	21	5	n	int
    //   190	3	6	bool	boolean
    //   12	238	7	localObject1	Object
    //   316	1	7	localThrowable	Throwable
    //   15	167	8	localObject2	Object
    //   232	1	8	localObject3	Object
    //   240	42	8	localObject4	Object
    //   18	187	9	localCursor	Cursor
    //   21	29	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	67	232	finally
    //   75	84	232	finally
    //   92	100	232	finally
    //   117	127	232	finally
    //   135	152	232	finally
    //   160	172	232	finally
    //   183	192	232	finally
    //   23	28	240	finally
    //   23	28	312	java/lang/Throwable
    //   57	67	316	java/lang/Throwable
    //   75	84	316	java/lang/Throwable
    //   92	100	316	java/lang/Throwable
    //   117	127	316	java/lang/Throwable
    //   135	152	316	java/lang/Throwable
    //   160	172	316	java/lang/Throwable
    //   183	192	316	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */