import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

@TargetApi(18)
public class oed
{
  /* Error */
  public static android.graphics.drawable.BitmapDrawable a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 17	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: getstatic 23	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 29	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +254 -> 276
    //   25: aload 4
    //   27: astore 5
    //   29: aload 4
    //   31: invokeinterface 35 1 0
    //   36: istore_2
    //   37: iload_2
    //   38: ifeq +238 -> 276
    //   41: aconst_null
    //   42: astore 7
    //   44: aload 4
    //   46: astore 5
    //   48: aload 7
    //   50: astore 6
    //   52: aload 4
    //   54: aload 4
    //   56: ldc 37
    //   58: invokeinterface 41 2 0
    //   63: invokeinterface 45 2 0
    //   68: istore_1
    //   69: aload 4
    //   71: astore 5
    //   73: aload 7
    //   75: astore 6
    //   77: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +36 -> 116
    //   83: aload 4
    //   85: astore 5
    //   87: aload 7
    //   89: astore 6
    //   91: ldc 52
    //   93: iconst_2
    //   94: new 54	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   101: ldc 60
    //   103: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_1
    //   107: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 4
    //   118: astore 5
    //   120: aload 7
    //   122: astore 6
    //   124: aload 8
    //   126: iload_1
    //   127: i2l
    //   128: iconst_3
    //   129: aconst_null
    //   130: invokestatic 81	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +40 -> 175
    //   138: aload_3
    //   139: astore 5
    //   141: aload 4
    //   143: ifnull +13 -> 156
    //   146: aload 4
    //   148: invokeinterface 84 1 0
    //   153: aload_3
    //   154: astore 5
    //   156: aload 5
    //   158: ifnull +97 -> 255
    //   161: new 86	android/graphics/drawable/BitmapDrawable
    //   164: dup
    //   165: aload_0
    //   166: invokevirtual 90	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   169: aload 5
    //   171: invokespecial 93	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   174: areturn
    //   175: aload 4
    //   177: astore 5
    //   179: aload_3
    //   180: astore 6
    //   182: aload 4
    //   184: invokeinterface 96 1 0
    //   189: istore_2
    //   190: aload_3
    //   191: astore 7
    //   193: iload_2
    //   194: ifne -150 -> 44
    //   197: goto -59 -> 138
    //   200: astore 7
    //   202: aconst_null
    //   203: astore_3
    //   204: aconst_null
    //   205: astore 4
    //   207: aload 4
    //   209: astore 5
    //   211: aload 7
    //   213: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   216: aload_3
    //   217: astore 5
    //   219: aload 4
    //   221: ifnull -65 -> 156
    //   224: aload 4
    //   226: invokeinterface 84 1 0
    //   231: aload_3
    //   232: astore 5
    //   234: goto -78 -> 156
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 5
    //   241: aload 5
    //   243: ifnull +10 -> 253
    //   246: aload 5
    //   248: invokeinterface 84 1 0
    //   253: aload_0
    //   254: athrow
    //   255: aconst_null
    //   256: areturn
    //   257: astore_0
    //   258: goto -17 -> 241
    //   261: astore 7
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -58 -> 207
    //   268: astore 7
    //   270: aload 6
    //   272: astore_3
    //   273: goto -66 -> 207
    //   276: aconst_null
    //   277: astore_3
    //   278: goto -140 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramContext	Context
    //   68	59	1	i	int
    //   36	158	2	bool	boolean
    //   133	145	3	localObject1	Object
    //   18	207	4	localCursor	android.database.Cursor
    //   27	220	5	localObject2	Object
    //   50	221	6	localObject3	Object
    //   42	150	7	localObject4	Object
    //   200	12	7	localException1	java.lang.Exception
    //   261	1	7	localException2	java.lang.Exception
    //   268	1	7	localException3	java.lang.Exception
    //   4	121	8	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   6	20	200	java/lang/Exception
    //   6	20	237	finally
    //   29	37	257	finally
    //   52	69	257	finally
    //   77	83	257	finally
    //   91	116	257	finally
    //   124	134	257	finally
    //   182	190	257	finally
    //   211	216	257	finally
    //   29	37	261	java/lang/Exception
    //   52	69	268	java/lang/Exception
    //   77	83	268	java/lang/Exception
    //   91	116	268	java/lang/Exception
    //   124	134	268	java/lang/Exception
    //   182	190	268	java/lang/Exception
  }
  
  private static boolean a(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(paramAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = axle.a(paramQQAppInterface, BaseApplicationImpl.getContext());
    return (a(paramQQAppInterface)) && ((bool) || (axle.a(paramContext) == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oed
 * JD-Core Version:    0.7.0.1
 */