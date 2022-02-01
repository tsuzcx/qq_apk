package cooperation.qzone.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;

public class QZoneNotificationAdapter
{
  private static volatile QZoneNotificationAdapter notificationAdapter;
  private String channelId = "CHANNEL_ID_SHOW_BADGE";
  
  public static QZoneNotificationAdapter getInstance()
  {
    if (notificationAdapter == null) {
      try
      {
        if (notificationAdapter == null) {
          notificationAdapter = new QZoneNotificationAdapter();
        }
      }
      finally {}
    }
    return notificationAdapter;
  }
  
  public Notification buildNotification(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new NotificationCompat.Builder(paramContext).setSmallIcon(paramInt).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString2);
    paramContext.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent);
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      paramContext.setChannelId(this.channelId);
    }
    if (paramBitmap != null) {
      paramContext.setLargeIcon(paramBitmap);
    }
    return paramContext.build();
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public Notification newNotificationForMz(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 9
    //   12: aload 10
    //   14: astore 8
    //   16: aload 11
    //   18: astore 7
    //   20: new 90	android/app/Notification$Builder
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 91	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   28: astore 13
    //   30: aload 10
    //   32: astore 8
    //   34: aload 11
    //   36: astore 7
    //   38: ldc 93
    //   40: invokestatic 99	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   43: ldc 101
    //   45: iconst_1
    //   46: anewarray 95	java/lang/Class
    //   49: dup
    //   50: iconst_0
    //   51: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: invokevirtual 111	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   58: astore 14
    //   60: aload 12
    //   62: astore 7
    //   64: aload 14
    //   66: ifnull +206 -> 272
    //   69: aload 10
    //   71: astore 8
    //   73: aload 11
    //   75: astore 7
    //   77: aload 14
    //   79: aload 13
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: iconst_1
    //   88: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: invokevirtual 121	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload 10
    //   98: astore 8
    //   100: aload 11
    //   102: astore 7
    //   104: aload 13
    //   106: aload_1
    //   107: invokevirtual 124	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   110: iload 6
    //   112: invokevirtual 127	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   115: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   118: invokevirtual 130	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   121: iconst_1
    //   122: invokevirtual 133	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   125: aload 5
    //   127: invokevirtual 136	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   130: aload 4
    //   132: invokevirtual 138	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   135: aload 5
    //   137: invokevirtual 140	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   140: pop
    //   141: aload_3
    //   142: ifnull +18 -> 160
    //   145: aload 10
    //   147: astore 8
    //   149: aload 11
    //   151: astore 7
    //   153: aload 13
    //   155: aload_3
    //   156: invokevirtual 143	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   159: pop
    //   160: aload 10
    //   162: astore 8
    //   164: aload 11
    //   166: astore 7
    //   168: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   171: bipush 16
    //   173: if_icmplt +20 -> 193
    //   176: aload 10
    //   178: astore 8
    //   180: aload 11
    //   182: astore 7
    //   184: aload 13
    //   186: invokevirtual 150	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   189: astore_3
    //   190: goto +226 -> 416
    //   193: aload 9
    //   195: astore_3
    //   196: aload 10
    //   198: astore 8
    //   200: aload 11
    //   202: astore 7
    //   204: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   207: bipush 16
    //   209: if_icmpge +39 -> 248
    //   212: aload 9
    //   214: astore_3
    //   215: aload 10
    //   217: astore 8
    //   219: aload 11
    //   221: astore 7
    //   223: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   226: bipush 11
    //   228: if_icmplt +20 -> 248
    //   231: aload 10
    //   233: astore 8
    //   235: aload 11
    //   237: astore 7
    //   239: aload 13
    //   241: invokevirtual 153	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   244: astore_3
    //   245: goto +171 -> 416
    //   248: aload_3
    //   249: astore 7
    //   251: aload_3
    //   252: ifnull +20 -> 272
    //   255: aload_3
    //   256: astore 8
    //   258: aload_3
    //   259: astore 7
    //   261: aload_3
    //   262: aload_0
    //   263: getfield 16	cooperation/qzone/push/QZoneNotificationAdapter:channelId	Ljava/lang/String;
    //   266: invokestatic 159	com/tencent/commonsdk/util/notification/QQNotificationManager:addChannelIfNeed	(Landroid/app/Notification;Ljava/lang/String;)V
    //   269: aload_3
    //   270: astore 7
    //   272: aload 7
    //   274: astore_3
    //   275: aload 7
    //   277: ifnonnull +90 -> 367
    //   280: new 161	android/app/Notification
    //   283: dup
    //   284: iload 6
    //   286: aload 5
    //   288: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   291: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   294: astore_3
    //   295: goto +56 -> 351
    //   298: astore_3
    //   299: goto +70 -> 369
    //   302: astore_3
    //   303: aload 7
    //   305: astore 8
    //   307: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +18 -> 328
    //   313: aload 7
    //   315: astore 8
    //   317: ldc 171
    //   319: iconst_2
    //   320: aload_3
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   328: aload 7
    //   330: astore_3
    //   331: aload 7
    //   333: ifnonnull +34 -> 367
    //   336: new 161	android/app/Notification
    //   339: dup
    //   340: iload 6
    //   342: aload 5
    //   344: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   347: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   350: astore_3
    //   351: aload_3
    //   352: bipush 16
    //   354: putfield 178	android/app/Notification:flags	I
    //   357: aload_3
    //   358: aload_2
    //   359: aload 4
    //   361: aload 5
    //   363: aload_1
    //   364: invokevirtual 182	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   367: aload_3
    //   368: areturn
    //   369: aload 8
    //   371: ifnonnull +37 -> 408
    //   374: new 161	android/app/Notification
    //   377: dup
    //   378: iload 6
    //   380: aload 5
    //   382: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   385: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   388: astore 7
    //   390: aload 7
    //   392: bipush 16
    //   394: putfield 178	android/app/Notification:flags	I
    //   397: aload 7
    //   399: aload_2
    //   400: aload 4
    //   402: aload 5
    //   404: aload_1
    //   405: invokevirtual 182	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   408: goto +5 -> 413
    //   411: aload_3
    //   412: athrow
    //   413: goto -2 -> 411
    //   416: goto -168 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	QZoneNotificationAdapter
    //   0	419	1	paramPendingIntent	PendingIntent
    //   0	419	2	paramContext	Context
    //   0	419	3	paramBitmap	Bitmap
    //   0	419	4	paramString1	String
    //   0	419	5	paramString2	String
    //   0	419	6	paramInt	int
    //   18	380	7	localObject1	Object
    //   14	356	8	localObject2	Object
    //   10	203	9	localObject3	Object
    //   4	228	10	localObject4	Object
    //   7	229	11	localObject5	Object
    //   1	60	12	localObject6	Object
    //   28	212	13	localBuilder	android.app.Notification.Builder
    //   58	20	14	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   20	30	298	finally
    //   38	60	298	finally
    //   77	96	298	finally
    //   104	141	298	finally
    //   153	160	298	finally
    //   168	176	298	finally
    //   184	190	298	finally
    //   204	212	298	finally
    //   223	231	298	finally
    //   239	245	298	finally
    //   261	269	298	finally
    //   307	313	298	finally
    //   317	328	298	finally
    //   20	30	302	java/lang/Throwable
    //   38	60	302	java/lang/Throwable
    //   77	96	302	java/lang/Throwable
    //   104	141	302	java/lang/Throwable
    //   153	160	302	java/lang/Throwable
    //   168	176	302	java/lang/Throwable
    //   184	190	302	java/lang/Throwable
    //   204	212	302	java/lang/Throwable
    //   223	231	302	java/lang/Throwable
    //   239	245	302	java/lang/Throwable
    //   261	269	302	java/lang/Throwable
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public Notification newNotificationForOppo(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aload 10
    //   11: astore 8
    //   13: aload 11
    //   15: astore 7
    //   17: new 90	android/app/Notification$Builder
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 91	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   25: astore 12
    //   27: aload 10
    //   29: astore 8
    //   31: aload 11
    //   33: astore 7
    //   35: aload 12
    //   37: aload_1
    //   38: invokevirtual 124	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   41: iload 6
    //   43: invokevirtual 127	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   46: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   49: invokevirtual 130	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   52: iconst_1
    //   53: invokevirtual 133	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   56: aload 5
    //   58: invokevirtual 136	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   61: aload 4
    //   63: invokevirtual 138	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   66: aload 5
    //   68: invokevirtual 140	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   71: pop
    //   72: aload_3
    //   73: ifnull +18 -> 91
    //   76: aload 10
    //   78: astore 8
    //   80: aload 11
    //   82: astore 7
    //   84: aload 12
    //   86: aload_3
    //   87: invokevirtual 143	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   90: pop
    //   91: aload 10
    //   93: astore 8
    //   95: aload 11
    //   97: astore 7
    //   99: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   102: bipush 16
    //   104: if_icmplt +20 -> 124
    //   107: aload 10
    //   109: astore 8
    //   111: aload 11
    //   113: astore 7
    //   115: aload 12
    //   117: invokevirtual 150	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   120: astore_3
    //   121: goto +225 -> 346
    //   124: aload 9
    //   126: astore_3
    //   127: aload 10
    //   129: astore 8
    //   131: aload 11
    //   133: astore 7
    //   135: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   138: bipush 16
    //   140: if_icmpge +39 -> 179
    //   143: aload 9
    //   145: astore_3
    //   146: aload 10
    //   148: astore 8
    //   150: aload 11
    //   152: astore 7
    //   154: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   157: bipush 11
    //   159: if_icmplt +20 -> 179
    //   162: aload 10
    //   164: astore 8
    //   166: aload 11
    //   168: astore 7
    //   170: aload 12
    //   172: invokevirtual 153	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   175: astore_3
    //   176: goto +170 -> 346
    //   179: aload_3
    //   180: ifnull +17 -> 197
    //   183: aload_3
    //   184: astore 8
    //   186: aload_3
    //   187: astore 7
    //   189: aload_3
    //   190: aload_0
    //   191: getfield 16	cooperation/qzone/push/QZoneNotificationAdapter:channelId	Ljava/lang/String;
    //   194: invokestatic 159	com/tencent/commonsdk/util/notification/QQNotificationManager:addChannelIfNeed	(Landroid/app/Notification;Ljava/lang/String;)V
    //   197: aload_3
    //   198: astore 8
    //   200: aload_3
    //   201: ifnonnull +95 -> 296
    //   204: new 161	android/app/Notification
    //   207: dup
    //   208: iload 6
    //   210: aload 5
    //   212: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   215: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   218: astore 8
    //   220: goto +58 -> 278
    //   223: astore_3
    //   224: goto +75 -> 299
    //   227: astore_3
    //   228: aload 7
    //   230: astore 8
    //   232: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +18 -> 253
    //   238: aload 7
    //   240: astore 8
    //   242: ldc 186
    //   244: iconst_2
    //   245: aload_3
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   253: aload 7
    //   255: astore 8
    //   257: aload 7
    //   259: ifnonnull +37 -> 296
    //   262: new 161	android/app/Notification
    //   265: dup
    //   266: iload 6
    //   268: aload 5
    //   270: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   273: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   276: astore 8
    //   278: aload 8
    //   280: bipush 16
    //   282: putfield 178	android/app/Notification:flags	I
    //   285: aload 8
    //   287: aload_2
    //   288: aload 4
    //   290: aload 5
    //   292: aload_1
    //   293: invokevirtual 182	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   296: aload 8
    //   298: areturn
    //   299: aload 8
    //   301: ifnonnull +37 -> 338
    //   304: new 161	android/app/Notification
    //   307: dup
    //   308: iload 6
    //   310: aload 5
    //   312: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   315: invokespecial 164	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   318: astore 7
    //   320: aload 7
    //   322: bipush 16
    //   324: putfield 178	android/app/Notification:flags	I
    //   327: aload 7
    //   329: aload_2
    //   330: aload 4
    //   332: aload 5
    //   334: aload_1
    //   335: invokevirtual 182	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   338: goto +5 -> 343
    //   341: aload_3
    //   342: athrow
    //   343: goto -2 -> 341
    //   346: goto -167 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	QZoneNotificationAdapter
    //   0	349	1	paramPendingIntent	PendingIntent
    //   0	349	2	paramContext	Context
    //   0	349	3	paramBitmap	Bitmap
    //   0	349	4	paramString1	String
    //   0	349	5	paramString2	String
    //   0	349	6	paramInt	int
    //   15	313	7	localObject1	Object
    //   11	289	8	localObject2	Object
    //   7	137	9	localObject3	Object
    //   1	162	10	localObject4	Object
    //   4	163	11	localObject5	Object
    //   25	146	12	localBuilder	android.app.Notification.Builder
    // Exception table:
    //   from	to	target	type
    //   17	27	223	finally
    //   35	72	223	finally
    //   84	91	223	finally
    //   99	107	223	finally
    //   115	121	223	finally
    //   135	143	223	finally
    //   154	162	223	finally
    //   170	176	223	finally
    //   189	197	223	finally
    //   232	238	223	finally
    //   242	253	223	finally
    //   17	27	227	java/lang/Throwable
    //   35	72	227	java/lang/Throwable
    //   84	91	227	java/lang/Throwable
    //   99	107	227	java/lang/Throwable
    //   115	121	227	java/lang/Throwable
    //   135	143	227	java/lang/Throwable
    //   154	162	227	java/lang/Throwable
    //   170	176	227	java/lang/Throwable
    //   189	197	227	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.push.QZoneNotificationAdapter
 * JD-Core Version:    0.7.0.1
 */