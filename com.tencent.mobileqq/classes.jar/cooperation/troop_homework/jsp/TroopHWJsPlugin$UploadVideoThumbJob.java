package cooperation.troop_homework.jsp;

import bkyh;
import bkyk;

public class TroopHWJsPlugin$UploadVideoThumbJob
  implements Runnable
{
  bkyh jdField_a_of_type_Bkyh;
  bkyk jdField_a_of_type_Bkyk;
  protected boolean a;
  
  public TroopHWJsPlugin$UploadVideoThumbJob(TroopHWJsPlugin paramTroopHWJsPlugin, bkyh parambkyh, bkyk parambkyk, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkyh = parambkyh;
    this.jdField_a_of_type_Bkyk = parambkyk;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 31
    //   2: iconst_2
    //   3: new 33	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   10: ldc 36
    //   12: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   19: getfield 45	bkyh:jdField_a_of_type_Int	I
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   35: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   38: ifnull +200 -> 238
    //   41: aload_0
    //   42: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   45: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   48: invokevirtual 67	android/graphics/Bitmap:isRecycled	()Z
    //   51: ifne +187 -> 238
    //   54: aload_0
    //   55: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   58: getfield 70	bkyh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   61: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   64: ifne +174 -> 238
    //   67: ldc 77
    //   69: astore_3
    //   70: aload_0
    //   71: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Boolean	Z
    //   74: ifeq +6 -> 80
    //   77: ldc 79
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 16	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:this$0	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   84: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   87: invokevirtual 90	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   90: astore 5
    //   92: aload 5
    //   94: iconst_2
    //   95: invokevirtual 96	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   98: checkcast 98	mqq/manager/TicketManager
    //   101: astore 4
    //   103: aload 5
    //   105: invokevirtual 101	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   108: astore 5
    //   110: aload 4
    //   112: aload 5
    //   114: invokeinterface 105 2 0
    //   119: astore 6
    //   121: new 107	java/io/File
    //   124: dup
    //   125: new 33	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   132: getstatic 113	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   135: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 115
    //   140: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 4
    //   151: aload_0
    //   152: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   155: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   158: aload 4
    //   160: invokestatic 123	bfvo:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   163: aload_0
    //   164: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   167: getfield 70	bkyh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   170: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   173: ifeq +66 -> 239
    //   176: ldc 31
    //   178: iconst_2
    //   179: new 33	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   186: ldc 125
    //   188: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   195: getfield 45	bkyh:jdField_a_of_type_Int	I
    //   198: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   211: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   214: ifnull +13 -> 227
    //   217: aload_0
    //   218: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   221: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   224: invokevirtual 128	android/graphics/Bitmap:recycle	()V
    //   227: aload 4
    //   229: ifnull +9 -> 238
    //   232: aload 4
    //   234: invokevirtual 131	java/io/File:delete	()Z
    //   237: pop
    //   238: return
    //   239: aload 4
    //   241: ifnull +208 -> 449
    //   244: aload 4
    //   246: invokevirtual 134	java/io/File:exists	()Z
    //   249: ifeq +200 -> 449
    //   252: ldc 31
    //   254: iconst_2
    //   255: new 33	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   262: ldc 136
    //   264: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 4
    //   269: invokevirtual 139	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   272: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 141
    //   277: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 4
    //   282: invokevirtual 145	java/io/File:length	()J
    //   285: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_3
    //   295: aload 4
    //   297: invokevirtual 139	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   300: aload 5
    //   302: aload 6
    //   304: ldc2_w 149
    //   307: invokestatic 155	bkxu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   310: astore_3
    //   311: aload_0
    //   312: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   315: getfield 70	bkyh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   318: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   321: istore_2
    //   322: iload_2
    //   323: ifeq +35 -> 358
    //   326: aload_0
    //   327: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   330: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   333: ifnull +13 -> 346
    //   336: aload_0
    //   337: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   340: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   343: invokevirtual 128	android/graphics/Bitmap:recycle	()V
    //   346: aload 4
    //   348: ifnull -110 -> 238
    //   351: aload 4
    //   353: invokevirtual 131	java/io/File:delete	()Z
    //   356: pop
    //   357: return
    //   358: aload_3
    //   359: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   362: ifne +233 -> 595
    //   365: new 163	org/json/JSONObject
    //   368: dup
    //   369: aload_3
    //   370: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   373: astore_3
    //   374: aload_3
    //   375: ifnull +220 -> 595
    //   378: aload_3
    //   379: ldc 166
    //   381: iconst_m1
    //   382: invokevirtual 170	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   385: ifne +210 -> 595
    //   388: aload_3
    //   389: ldc 172
    //   391: invokevirtual 176	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   394: astore_3
    //   395: aload_3
    //   396: ifnull +199 -> 595
    //   399: aload_3
    //   400: ldc 178
    //   402: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   405: astore_3
    //   406: aload_0
    //   407: getfield 23	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyk	Lbkyk;
    //   410: ifnull +190 -> 600
    //   413: aload_0
    //   414: getfield 23	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyk	Lbkyk;
    //   417: iconst_1
    //   418: aload_3
    //   419: invokeinterface 186 3 0
    //   424: goto +176 -> 600
    //   427: iload_1
    //   428: ifne +21 -> 449
    //   431: aload_0
    //   432: getfield 23	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyk	Lbkyk;
    //   435: ifnull +14 -> 449
    //   438: aload_0
    //   439: getfield 23	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyk	Lbkyk;
    //   442: iconst_0
    //   443: aconst_null
    //   444: invokeinterface 186 3 0
    //   449: aload_0
    //   450: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   453: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   456: ifnull +13 -> 469
    //   459: aload_0
    //   460: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   463: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   466: invokevirtual 128	android/graphics/Bitmap:recycle	()V
    //   469: aload 4
    //   471: ifnull -233 -> 238
    //   474: aload 4
    //   476: invokevirtual 131	java/io/File:delete	()Z
    //   479: pop
    //   480: return
    //   481: astore 4
    //   483: aconst_null
    //   484: astore_3
    //   485: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +13 -> 501
    //   491: ldc 31
    //   493: iconst_2
    //   494: ldc 191
    //   496: aload 4
    //   498: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: aload_0
    //   502: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   505: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   508: ifnull +13 -> 521
    //   511: aload_0
    //   512: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   515: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   518: invokevirtual 128	android/graphics/Bitmap:recycle	()V
    //   521: aload_3
    //   522: ifnull -284 -> 238
    //   525: aload_3
    //   526: invokevirtual 131	java/io/File:delete	()Z
    //   529: pop
    //   530: return
    //   531: astore_3
    //   532: aconst_null
    //   533: astore 4
    //   535: aload_0
    //   536: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   539: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   542: ifnull +13 -> 555
    //   545: aload_0
    //   546: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:jdField_a_of_type_Bkyh	Lbkyh;
    //   549: getfield 61	bkyh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   552: invokevirtual 128	android/graphics/Bitmap:recycle	()V
    //   555: aload 4
    //   557: ifnull +9 -> 566
    //   560: aload 4
    //   562: invokevirtual 131	java/io/File:delete	()Z
    //   565: pop
    //   566: aload_3
    //   567: athrow
    //   568: astore_3
    //   569: goto -34 -> 535
    //   572: astore 5
    //   574: aload_3
    //   575: astore 4
    //   577: aload 5
    //   579: astore_3
    //   580: goto -45 -> 535
    //   583: astore 5
    //   585: aload 4
    //   587: astore_3
    //   588: aload 5
    //   590: astore 4
    //   592: goto -107 -> 485
    //   595: iconst_0
    //   596: istore_1
    //   597: goto -170 -> 427
    //   600: iconst_1
    //   601: istore_1
    //   602: goto -175 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	UploadVideoThumbJob
    //   427	175	1	i	int
    //   321	2	2	bool	boolean
    //   69	457	3	localObject1	Object
    //   531	36	3	localObject2	Object
    //   568	7	3	localObject3	Object
    //   579	9	3	localObject4	Object
    //   101	374	4	localObject5	Object
    //   481	16	4	localException1	java.lang.Exception
    //   533	58	4	localObject6	Object
    //   90	211	5	localObject7	Object
    //   572	6	5	localObject8	Object
    //   583	6	5	localException2	java.lang.Exception
    //   119	184	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   121	151	481	java/lang/Exception
    //   121	151	531	finally
    //   151	207	568	finally
    //   244	322	568	finally
    //   358	374	568	finally
    //   378	395	568	finally
    //   399	424	568	finally
    //   431	449	568	finally
    //   485	501	572	finally
    //   151	207	583	java/lang/Exception
    //   244	322	583	java/lang/Exception
    //   358	374	583	java/lang/Exception
    //   378	395	583	java/lang/Exception
    //   399	424	583	java/lang/Exception
    //   431	449	583	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadVideoThumbJob
 * JD-Core Version:    0.7.0.1
 */