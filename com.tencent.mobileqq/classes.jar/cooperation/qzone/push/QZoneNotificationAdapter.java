package cooperation.qzone.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;

public class QZoneNotificationAdapter
{
  private static volatile QZoneNotificationAdapter a;
  
  public static QZoneNotificationAdapter a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QZoneNotificationAdapter();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public Notification a(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 11
    //   8: if_icmpge +78 -> 86
    //   11: new 29	android/app/Notification
    //   14: dup
    //   15: iload 6
    //   17: aload 5
    //   19: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   22: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   25: astore_3
    //   26: aload_3
    //   27: bipush 16
    //   29: putfield 41	android/app/Notification:flags	I
    //   32: aload_3
    //   33: aload_2
    //   34: aload 4
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   42: aload_3
    //   43: astore 7
    //   45: aload_3
    //   46: ifnonnull +37 -> 83
    //   49: new 29	android/app/Notification
    //   52: dup
    //   53: iload 6
    //   55: aload 5
    //   57: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   60: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   63: astore 7
    //   65: aload 7
    //   67: bipush 16
    //   69: putfield 41	android/app/Notification:flags	I
    //   72: aload 7
    //   74: aload_2
    //   75: aload 4
    //   77: aload 5
    //   79: aload_1
    //   80: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   83: aload 7
    //   85: areturn
    //   86: new 47	android/app/Notification$Builder
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 50	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   94: astore 8
    //   96: ldc 52
    //   98: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   101: ldc 60
    //   103: iconst_1
    //   104: anewarray 54	java/lang/Class
    //   107: dup
    //   108: iconst_0
    //   109: getstatic 66	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   112: aastore
    //   113: invokevirtual 70	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   116: astore 9
    //   118: aload 9
    //   120: ifnull +243 -> 363
    //   123: aload 9
    //   125: aload 8
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iconst_1
    //   134: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokevirtual 80	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: aload 8
    //   144: aload_1
    //   145: invokevirtual 84	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   148: iload 6
    //   150: invokevirtual 88	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   153: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   156: invokevirtual 92	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   159: iconst_1
    //   160: invokevirtual 96	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   163: aload 5
    //   165: invokevirtual 100	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   168: aload 4
    //   170: invokevirtual 103	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   173: aload 5
    //   175: invokevirtual 106	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   178: pop
    //   179: aload_3
    //   180: ifnull +10 -> 190
    //   183: aload 8
    //   185: aload_3
    //   186: invokevirtual 110	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   189: pop
    //   190: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   193: bipush 16
    //   195: if_icmplt +12 -> 207
    //   198: aload 8
    //   200: invokevirtual 114	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   203: astore_3
    //   204: goto -162 -> 42
    //   207: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   210: bipush 16
    //   212: if_icmpge +151 -> 363
    //   215: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   218: bipush 11
    //   220: if_icmplt +143 -> 363
    //   223: aload 8
    //   225: invokevirtual 117	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   228: astore_3
    //   229: goto -187 -> 42
    //   232: astore 7
    //   234: aconst_null
    //   235: astore_3
    //   236: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +15 -> 254
    //   242: ldc 125
    //   244: iconst_2
    //   245: aload 7
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload_3
    //   255: astore 7
    //   257: aload_3
    //   258: ifnonnull -175 -> 83
    //   261: new 29	android/app/Notification
    //   264: dup
    //   265: iload 6
    //   267: aload 5
    //   269: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   272: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   275: astore_3
    //   276: aload_3
    //   277: bipush 16
    //   279: putfield 41	android/app/Notification:flags	I
    //   282: aload_3
    //   283: aload_2
    //   284: aload 4
    //   286: aload 5
    //   288: aload_1
    //   289: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   292: aload_3
    //   293: areturn
    //   294: astore_3
    //   295: aload 7
    //   297: ifnonnull +37 -> 334
    //   300: new 29	android/app/Notification
    //   303: dup
    //   304: iload 6
    //   306: aload 5
    //   308: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   311: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   314: astore 7
    //   316: aload 7
    //   318: bipush 16
    //   320: putfield 41	android/app/Notification:flags	I
    //   323: aload 7
    //   325: aload_2
    //   326: aload 4
    //   328: aload 5
    //   330: aload_1
    //   331: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   334: aload_3
    //   335: athrow
    //   336: astore 8
    //   338: aload_3
    //   339: astore 7
    //   341: aload 8
    //   343: astore_3
    //   344: goto -49 -> 295
    //   347: astore 8
    //   349: aload_3
    //   350: astore 7
    //   352: aload 8
    //   354: astore_3
    //   355: goto -60 -> 295
    //   358: astore 7
    //   360: goto -124 -> 236
    //   363: aconst_null
    //   364: astore_3
    //   365: goto -323 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	QZoneNotificationAdapter
    //   0	368	1	paramPendingIntent	PendingIntent
    //   0	368	2	paramContext	Context
    //   0	368	3	paramBitmap	Bitmap
    //   0	368	4	paramString1	String
    //   0	368	5	paramString2	String
    //   0	368	6	paramInt	int
    //   1	83	7	localObject1	Object
    //   232	14	7	localThrowable1	java.lang.Throwable
    //   255	96	7	localObject2	Object
    //   358	1	7	localThrowable2	java.lang.Throwable
    //   94	130	8	localBuilder	android.app.Notification.Builder
    //   336	6	8	localObject3	Object
    //   347	6	8	localObject4	Object
    //   116	8	9	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   3	26	232	java/lang/Throwable
    //   86	118	232	java/lang/Throwable
    //   123	179	232	java/lang/Throwable
    //   183	190	232	java/lang/Throwable
    //   190	204	232	java/lang/Throwable
    //   207	229	232	java/lang/Throwable
    //   3	26	294	finally
    //   86	118	294	finally
    //   123	179	294	finally
    //   183	190	294	finally
    //   190	204	294	finally
    //   207	229	294	finally
    //   26	42	336	finally
    //   236	254	347	finally
    //   26	42	358	java/lang/Throwable
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public Notification b(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 11
    //   8: if_icmpge +78 -> 86
    //   11: new 29	android/app/Notification
    //   14: dup
    //   15: iload 6
    //   17: aload 5
    //   19: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   22: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   25: astore_3
    //   26: aload_3
    //   27: bipush 16
    //   29: putfield 41	android/app/Notification:flags	I
    //   32: aload_3
    //   33: aload_2
    //   34: aload 4
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   42: aload_3
    //   43: astore 7
    //   45: aload_3
    //   46: ifnonnull +37 -> 83
    //   49: new 29	android/app/Notification
    //   52: dup
    //   53: iload 6
    //   55: aload 5
    //   57: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   60: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   63: astore 7
    //   65: aload 7
    //   67: bipush 16
    //   69: putfield 41	android/app/Notification:flags	I
    //   72: aload 7
    //   74: aload_2
    //   75: aload 4
    //   77: aload 5
    //   79: aload_1
    //   80: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   83: aload 7
    //   85: areturn
    //   86: new 47	android/app/Notification$Builder
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 50	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   94: astore 8
    //   96: aload 8
    //   98: aload_1
    //   99: invokevirtual 84	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   102: iload 6
    //   104: invokevirtual 88	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   107: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   110: invokevirtual 92	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   113: iconst_1
    //   114: invokevirtual 96	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   117: aload 5
    //   119: invokevirtual 100	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   122: aload 4
    //   124: invokevirtual 103	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   127: aload 5
    //   129: invokevirtual 106	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   132: pop
    //   133: aload_3
    //   134: ifnull +10 -> 144
    //   137: aload 8
    //   139: aload_3
    //   140: invokevirtual 110	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   143: pop
    //   144: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   147: bipush 16
    //   149: if_icmplt +12 -> 161
    //   152: aload 8
    //   154: invokevirtual 114	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   157: astore_3
    //   158: goto -116 -> 42
    //   161: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   164: bipush 16
    //   166: if_icmpge +151 -> 317
    //   169: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   172: bipush 11
    //   174: if_icmplt +143 -> 317
    //   177: aload 8
    //   179: invokevirtual 117	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   182: astore_3
    //   183: goto -141 -> 42
    //   186: astore 7
    //   188: aconst_null
    //   189: astore_3
    //   190: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +15 -> 208
    //   196: ldc 133
    //   198: iconst_2
    //   199: aload 7
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   208: aload_3
    //   209: astore 7
    //   211: aload_3
    //   212: ifnonnull -129 -> 83
    //   215: new 29	android/app/Notification
    //   218: dup
    //   219: iload 6
    //   221: aload 5
    //   223: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   226: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   229: astore_3
    //   230: aload_3
    //   231: bipush 16
    //   233: putfield 41	android/app/Notification:flags	I
    //   236: aload_3
    //   237: aload_2
    //   238: aload 4
    //   240: aload 5
    //   242: aload_1
    //   243: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   246: aload_3
    //   247: areturn
    //   248: astore_3
    //   249: aload 7
    //   251: ifnonnull +37 -> 288
    //   254: new 29	android/app/Notification
    //   257: dup
    //   258: iload 6
    //   260: aload 5
    //   262: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   265: invokespecial 38	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   268: astore 7
    //   270: aload 7
    //   272: bipush 16
    //   274: putfield 41	android/app/Notification:flags	I
    //   277: aload 7
    //   279: aload_2
    //   280: aload 4
    //   282: aload 5
    //   284: aload_1
    //   285: invokevirtual 45	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   288: aload_3
    //   289: athrow
    //   290: astore 8
    //   292: aload_3
    //   293: astore 7
    //   295: aload 8
    //   297: astore_3
    //   298: goto -49 -> 249
    //   301: astore 8
    //   303: aload_3
    //   304: astore 7
    //   306: aload 8
    //   308: astore_3
    //   309: goto -60 -> 249
    //   312: astore 7
    //   314: goto -124 -> 190
    //   317: aconst_null
    //   318: astore_3
    //   319: goto -277 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	QZoneNotificationAdapter
    //   0	322	1	paramPendingIntent	PendingIntent
    //   0	322	2	paramContext	Context
    //   0	322	3	paramBitmap	Bitmap
    //   0	322	4	paramString1	String
    //   0	322	5	paramString2	String
    //   0	322	6	paramInt	int
    //   1	83	7	localObject1	Object
    //   186	14	7	localThrowable1	java.lang.Throwable
    //   209	96	7	localObject2	Object
    //   312	1	7	localThrowable2	java.lang.Throwable
    //   94	84	8	localBuilder	android.app.Notification.Builder
    //   290	6	8	localObject3	Object
    //   301	6	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	26	186	java/lang/Throwable
    //   86	133	186	java/lang/Throwable
    //   137	144	186	java/lang/Throwable
    //   144	158	186	java/lang/Throwable
    //   161	183	186	java/lang/Throwable
    //   3	26	248	finally
    //   86	133	248	finally
    //   137	144	248	finally
    //   144	158	248	finally
    //   161	183	248	finally
    //   26	42	290	finally
    //   190	208	301	finally
    //   26	42	312	java/lang/Throwable
  }
  
  public Notification c(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new NotificationCompat.Builder(paramContext).setSmallIcon(paramInt).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString2);
    paramContext.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent);
    if (paramBitmap != null) {
      paramContext.setLargeIcon(paramBitmap);
    }
    return paramContext.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.push.QZoneNotificationAdapter
 * JD-Core Version:    0.7.0.1
 */