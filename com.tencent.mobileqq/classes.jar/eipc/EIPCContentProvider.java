package eipc;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import mqq.app.AppContentProvider;
import mqq.app.MobileQQ;

public class EIPCContentProvider
  extends AppContentProvider
{
  public static final String AUTHORITY = "com.tencent.mobileqq.eipcmobileqq";
  public static final String COL_SERVICE = "service";
  public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mobileqq.eipcmobileqq/binder");
  public static boolean sIsDexInjectFinish = false;
  
  /* Error */
  public static final IBinder queryBinder(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: getstatic 27	eipc/EIPCContentProvider:CONTENT_URI	Landroid/net/Uri;
    //   12: aconst_null
    //   13: aconst_null
    //   14: iconst_1
    //   15: anewarray 45	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 11
    //   22: aastore
    //   23: aconst_null
    //   24: invokevirtual 51	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_1
    //   31: invokeinterface 57 1 0
    //   36: astore_2
    //   37: aload_1
    //   38: astore_0
    //   39: aload_2
    //   40: ldc 59
    //   42: invokevirtual 65	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   45: invokevirtual 71	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: ldc 73
    //   53: invokevirtual 77	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   56: checkcast 59	eipc/EIPCBinderCursor$BinderParcelable
    //   59: getfield 81	eipc/EIPCBinderCursor$BinderParcelable:mBinder	Landroid/os/IBinder;
    //   62: astore_2
    //   63: aload_2
    //   64: astore_0
    //   65: aload_1
    //   66: ifnull +66 -> 132
    //   69: aload_2
    //   70: astore_0
    //   71: aload_1
    //   72: invokeinterface 84 1 0
    //   77: aload_2
    //   78: areturn
    //   79: astore_1
    //   80: ldc 86
    //   82: iconst_1
    //   83: ldc 88
    //   85: aload_1
    //   86: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: areturn
    //   91: astore_2
    //   92: goto +12 -> 104
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: goto +41 -> 139
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: ldc 86
    //   108: iconst_1
    //   109: ldc 88
    //   111: aload_2
    //   112: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_3
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull +14 -> 132
    //   121: aload 4
    //   123: astore_0
    //   124: aload_1
    //   125: invokeinterface 84 1 0
    //   130: aload_3
    //   131: astore_0
    //   132: aload_0
    //   133: areturn
    //   134: astore_2
    //   135: aload_0
    //   136: astore_1
    //   137: aload_2
    //   138: astore_0
    //   139: aload_1
    //   140: ifnull +22 -> 162
    //   143: aload_1
    //   144: invokeinterface 84 1 0
    //   149: goto +13 -> 162
    //   152: astore_1
    //   153: ldc 86
    //   155: iconst_1
    //   156: ldc 88
    //   158: aload_1
    //   159: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_0
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	android.content.Context
    //   27	45	1	localCursor	Cursor
    //   79	7	1	localException1	java.lang.Exception
    //   97	47	1	localContext	android.content.Context
    //   152	7	1	localException2	java.lang.Exception
    //   36	42	2	localObject1	java.lang.Object
    //   91	1	2	localException3	java.lang.Exception
    //   101	11	2	localException4	java.lang.Exception
    //   134	4	2	localObject2	java.lang.Object
    //   1	130	3	localObject3	java.lang.Object
    //   3	119	4	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   71	77	79	java/lang/Exception
    //   124	130	79	java/lang/Exception
    //   30	37	91	java/lang/Exception
    //   39	48	91	java/lang/Exception
    //   50	63	91	java/lang/Exception
    //   5	28	95	finally
    //   5	28	101	java/lang/Exception
    //   30	37	134	finally
    //   39	48	134	finally
    //   50	63	134	finally
    //   106	115	134	finally
    //   143	149	152	java/lang/Exception
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public String getType(Uri paramUri)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (sIsDexInjectFinish) {
      MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    paramUri = (IBinder)EIPCServer.getServer().channel;
    return new EIPCBinderCursor(new String[] { "service" }, paramUri);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     eipc.EIPCContentProvider
 * JD-Core Version:    0.7.0.1
 */