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
  public static boolean sIsDexInjectFinish;
  
  /* Error */
  public static final IBinder queryBinder(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 41	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 27	eipc/EIPCContentProvider:CONTENT_URI	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: iconst_1
    //   10: anewarray 43	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 11
    //   17: aastore
    //   18: aconst_null
    //   19: invokevirtual 49	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: invokeinterface 55 1 0
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: aload_2
    //   35: ldc 57
    //   37: invokevirtual 63	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   40: invokevirtual 69	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc 71
    //   48: invokevirtual 75	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   51: checkcast 57	eipc/EIPCBinderCursor$BinderParcelable
    //   54: getfield 79	eipc/EIPCBinderCursor$BinderParcelable:mBinder	Landroid/os/IBinder;
    //   57: astore_2
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_1
    //   63: invokeinterface 82 1 0
    //   68: aload_2
    //   69: areturn
    //   70: astore_0
    //   71: ldc 84
    //   73: iconst_1
    //   74: ldc 86
    //   76: aload_0
    //   77: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 84
    //   89: iconst_1
    //   90: ldc 86
    //   92: aload_2
    //   93: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_1
    //   97: ifnull +59 -> 156
    //   100: aload_1
    //   101: invokeinterface 82 1 0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: ldc 84
    //   111: iconst_1
    //   112: ldc 86
    //   114: aload_0
    //   115: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: ifnull +9 -> 133
    //   127: aload_0
    //   128: invokeinterface 82 1 0
    //   133: aload_1
    //   134: athrow
    //   135: astore_0
    //   136: ldc 84
    //   138: iconst_1
    //   139: ldc 86
    //   141: aload_0
    //   142: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: goto -12 -> 133
    //   148: astore_1
    //   149: goto -26 -> 123
    //   152: astore_2
    //   153: goto -68 -> 85
    //   156: aconst_null
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	android.content.Context
    //   22	79	1	localCursor	Cursor
    //   120	14	1	localObject1	java.lang.Object
    //   148	1	1	localObject2	java.lang.Object
    //   31	50	2	localObject3	java.lang.Object
    //   82	11	2	localException1	java.lang.Exception
    //   152	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   62	68	70	java/lang/Exception
    //   0	23	82	java/lang/Exception
    //   100	106	108	java/lang/Exception
    //   0	23	120	finally
    //   127	133	135	java/lang/Exception
    //   25	32	148	finally
    //   34	43	148	finally
    //   45	58	148	finally
    //   87	96	148	finally
    //   25	32	152	java/lang/Exception
    //   34	43	152	java/lang/Exception
    //   45	58	152	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCContentProvider
 * JD-Core Version:    0.7.0.1
 */