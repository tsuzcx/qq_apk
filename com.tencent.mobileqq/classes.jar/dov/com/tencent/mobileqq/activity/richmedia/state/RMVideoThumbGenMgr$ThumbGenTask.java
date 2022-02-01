package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.os.AsyncTask;

class RMVideoThumbGenMgr$ThumbGenTask
  extends AsyncTask<Void, Void, Integer>
{
  RMVideoThumbGenMgr.ThumbGenItem jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr;
    //   4: invokevirtual 24	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr:a	()V
    //   7: new 26	java/io/File
    //   10: dup
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   18: getstatic 36	dov/com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 43	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 45
    //   32: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 56	java/io/File:exists	()Z
    //   46: ifne +8 -> 54
    //   49: aload_1
    //   50: invokevirtual 59	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   58: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   61: iconst_2
    //   62: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   65: pop
    //   66: aload_0
    //   67: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   70: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   73: ifeq +29 -> 102
    //   76: aload_0
    //   77: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   80: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   83: iconst_4
    //   84: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   87: pop
    //   88: aload_0
    //   89: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   92: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   95: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   98: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: areturn
    //   102: aload_0
    //   103: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   106: getfield 86	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   113: getfield 89	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Int	I
    //   116: aload_0
    //   117: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   120: getfield 92	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_Int	I
    //   123: aload_0
    //   124: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   127: getfield 95	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_Int	I
    //   130: getstatic 101	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   133: invokestatic 106	dov/com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   136: astore 4
    //   138: aload 4
    //   140: ifnonnull +40 -> 180
    //   143: aload_0
    //   144: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   147: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   150: iconst_5
    //   151: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   154: pop
    //   155: aload_0
    //   156: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   159: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   162: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   165: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: areturn
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 109	java/lang/OutOfMemoryError:printStackTrace	()V
    //   174: aconst_null
    //   175: astore 4
    //   177: goto -39 -> 138
    //   180: new 26	java/io/File
    //   183: dup
    //   184: aload 4
    //   186: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   189: astore 5
    //   191: aload 5
    //   193: invokevirtual 56	java/io/File:exists	()Z
    //   196: ifne +29 -> 225
    //   199: aload_0
    //   200: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   203: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   206: iconst_5
    //   207: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   210: pop
    //   211: aload_0
    //   212: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   215: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   218: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   221: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: areturn
    //   225: aload_0
    //   226: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   229: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   232: ifeq +35 -> 267
    //   235: aload_0
    //   236: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   239: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   242: iconst_4
    //   243: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   246: pop
    //   247: aload 4
    //   249: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   252: pop
    //   253: aload_0
    //   254: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   257: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   260: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   263: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: areturn
    //   267: new 117	java/io/FileInputStream
    //   270: dup
    //   271: aload 4
    //   273: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   276: astore_3
    //   277: aload_3
    //   278: astore_1
    //   279: aload_3
    //   280: aload 5
    //   282: invokevirtual 122	java/io/File:length	()J
    //   285: invokestatic 128	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   288: astore 5
    //   290: aload_3
    //   291: astore_1
    //   292: aload_0
    //   293: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   296: aload 5
    //   298: invokestatic 134	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   301: putfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 140	java/io/FileInputStream:close	()V
    //   312: aload_0
    //   313: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   316: aload 4
    //   318: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   321: aload_0
    //   322: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   325: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   328: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifeq +88 -> 419
    //   334: aload_0
    //   335: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   338: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   341: bipush 6
    //   343: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   346: pop
    //   347: aconst_null
    //   348: astore_1
    //   349: aload_0
    //   350: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   353: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   356: ifeq +41 -> 397
    //   359: aload_0
    //   360: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   363: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   366: iconst_4
    //   367: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   370: istore_2
    //   371: aload_0
    //   372: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   375: aconst_null
    //   376: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   383: aconst_null
    //   384: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   387: iload_2
    //   388: iconst_3
    //   389: if_icmpne +91 -> 480
    //   392: aload_1
    //   393: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   396: pop
    //   397: aload_0
    //   398: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   401: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   404: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   407: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: areturn
    //   411: astore_1
    //   412: aload_1
    //   413: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   416: goto -104 -> 312
    //   419: aload_0
    //   420: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   423: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   426: ldc 153
    //   428: invokestatic 158	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   431: astore_1
    //   432: aload 4
    //   434: aload_1
    //   435: invokestatic 161	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   438: ifeq +26 -> 464
    //   441: aload_0
    //   442: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   445: aload_1
    //   446: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   449: aload_0
    //   450: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   453: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   456: iconst_3
    //   457: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   460: pop
    //   461: goto -112 -> 349
    //   464: aload_0
    //   465: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   468: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   471: bipush 6
    //   473: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   476: pop
    //   477: goto -128 -> 349
    //   480: iload_2
    //   481: bipush 6
    //   483: if_icmpne -86 -> 397
    //   486: aload 4
    //   488: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   491: pop
    //   492: goto -95 -> 397
    //   495: astore 5
    //   497: aconst_null
    //   498: astore_3
    //   499: aload_3
    //   500: astore_1
    //   501: aload 5
    //   503: invokevirtual 162	java/io/FileNotFoundException:printStackTrace	()V
    //   506: aload_3
    //   507: ifnull +7 -> 514
    //   510: aload_3
    //   511: invokevirtual 140	java/io/FileInputStream:close	()V
    //   514: aload_0
    //   515: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   518: aload 4
    //   520: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   523: aload_0
    //   524: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   527: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   530: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   533: ifeq +77 -> 610
    //   536: aload_0
    //   537: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   540: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   543: bipush 6
    //   545: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   548: pop
    //   549: aconst_null
    //   550: astore_1
    //   551: aload_0
    //   552: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   555: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   558: ifeq -161 -> 397
    //   561: aload_0
    //   562: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   565: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   568: iconst_4
    //   569: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   572: istore_2
    //   573: aload_0
    //   574: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   577: aconst_null
    //   578: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   581: aload_0
    //   582: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   585: aconst_null
    //   586: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   589: iload_2
    //   590: iconst_3
    //   591: if_icmpne +80 -> 671
    //   594: aload_1
    //   595: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   598: pop
    //   599: goto -202 -> 397
    //   602: astore_1
    //   603: aload_1
    //   604: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   607: goto -93 -> 514
    //   610: aload_0
    //   611: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   614: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   617: ldc 153
    //   619: invokestatic 158	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   622: astore_1
    //   623: aload 4
    //   625: aload_1
    //   626: invokestatic 161	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   629: ifeq +26 -> 655
    //   632: aload_0
    //   633: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   636: aload_1
    //   637: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   640: aload_0
    //   641: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   644: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   647: iconst_3
    //   648: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   651: pop
    //   652: goto -101 -> 551
    //   655: aload_0
    //   656: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   659: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   662: bipush 6
    //   664: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   667: pop
    //   668: goto -117 -> 551
    //   671: iload_2
    //   672: bipush 6
    //   674: if_icmpne -277 -> 397
    //   677: aload 4
    //   679: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   682: pop
    //   683: goto -286 -> 397
    //   686: astore 5
    //   688: aconst_null
    //   689: astore_3
    //   690: aload_3
    //   691: astore_1
    //   692: aload 5
    //   694: invokevirtual 163	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   697: aload_3
    //   698: ifnull +7 -> 705
    //   701: aload_3
    //   702: invokevirtual 140	java/io/FileInputStream:close	()V
    //   705: aload_0
    //   706: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   709: aload 4
    //   711: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   714: aload_0
    //   715: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   718: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   721: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   724: ifeq +77 -> 801
    //   727: aload_0
    //   728: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   731: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   734: bipush 6
    //   736: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   739: pop
    //   740: aconst_null
    //   741: astore_1
    //   742: aload_0
    //   743: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   746: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   749: ifeq -352 -> 397
    //   752: aload_0
    //   753: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   756: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   759: iconst_4
    //   760: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   763: istore_2
    //   764: aload_0
    //   765: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   768: aconst_null
    //   769: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   772: aload_0
    //   773: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   776: aconst_null
    //   777: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   780: iload_2
    //   781: iconst_3
    //   782: if_icmpne +80 -> 862
    //   785: aload_1
    //   786: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   789: pop
    //   790: goto -393 -> 397
    //   793: astore_1
    //   794: aload_1
    //   795: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   798: goto -93 -> 705
    //   801: aload_0
    //   802: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   805: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   808: ldc 153
    //   810: invokestatic 158	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: astore_1
    //   814: aload 4
    //   816: aload_1
    //   817: invokestatic 161	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   820: ifeq +26 -> 846
    //   823: aload_0
    //   824: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   827: aload_1
    //   828: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   831: aload_0
    //   832: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   835: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   838: iconst_3
    //   839: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   842: pop
    //   843: goto -101 -> 742
    //   846: aload_0
    //   847: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   850: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   853: bipush 6
    //   855: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   858: pop
    //   859: goto -117 -> 742
    //   862: iload_2
    //   863: bipush 6
    //   865: if_icmpne -468 -> 397
    //   868: aload 4
    //   870: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   873: pop
    //   874: goto -477 -> 397
    //   877: astore_1
    //   878: aconst_null
    //   879: astore_3
    //   880: aload_3
    //   881: ifnull +7 -> 888
    //   884: aload_3
    //   885: invokevirtual 140	java/io/FileInputStream:close	()V
    //   888: aload_0
    //   889: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   892: aload 4
    //   894: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   897: aload_0
    //   898: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   901: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   904: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   907: ifeq +76 -> 983
    //   910: aload_0
    //   911: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   914: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   917: bipush 6
    //   919: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   922: pop
    //   923: aconst_null
    //   924: astore_3
    //   925: aload_0
    //   926: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   929: getfield 75	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   932: ifeq +41 -> 973
    //   935: aload_0
    //   936: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   939: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   942: iconst_4
    //   943: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   946: istore_2
    //   947: aload_0
    //   948: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   951: aconst_null
    //   952: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   955: aload_0
    //   956: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   959: aconst_null
    //   960: putfield 142	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   963: iload_2
    //   964: iconst_3
    //   965: if_icmpne +79 -> 1044
    //   968: aload_3
    //   969: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   972: pop
    //   973: aload_1
    //   974: athrow
    //   975: astore_3
    //   976: aload_3
    //   977: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   980: goto -92 -> 888
    //   983: aload_0
    //   984: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   987: getfield 137	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   990: ldc 153
    //   992: invokestatic 158	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   995: astore_3
    //   996: aload 4
    //   998: aload_3
    //   999: invokestatic 161	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1002: ifeq +26 -> 1028
    //   1005: aload_0
    //   1006: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   1009: aload_3
    //   1010: putfield 150	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1013: aload_0
    //   1014: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   1017: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1020: iconst_3
    //   1021: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   1024: pop
    //   1025: goto -100 -> 925
    //   1028: aload_0
    //   1029: getfield 61	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   1032: getfield 66	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1035: bipush 6
    //   1037: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   1040: pop
    //   1041: goto -116 -> 925
    //   1044: iload_2
    //   1045: bipush 6
    //   1047: if_icmpne -74 -> 973
    //   1050: aload 4
    //   1052: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1055: pop
    //   1056: goto -83 -> 973
    //   1059: astore_1
    //   1060: goto -1006 -> 54
    //   1063: astore 5
    //   1065: aload_1
    //   1066: astore_3
    //   1067: aload 5
    //   1069: astore_1
    //   1070: goto -190 -> 880
    //   1073: astore 5
    //   1075: goto -385 -> 690
    //   1078: astore 5
    //   1080: goto -581 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1083	0	this	ThumbGenTask
    //   0	1083	1	paramVarArgs	Void[]
    //   370	678	2	i	int
    //   276	693	3	localFileInputStream	java.io.FileInputStream
    //   975	2	3	localIOException	java.io.IOException
    //   995	72	3	localObject1	java.lang.Object
    //   136	915	4	str	java.lang.String
    //   189	108	5	localObject2	java.lang.Object
    //   495	7	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   686	7	5	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   1063	5	5	localObject3	java.lang.Object
    //   1073	1	5	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1078	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   102	138	169	java/lang/OutOfMemoryError
    //   308	312	411	java/io/IOException
    //   267	277	495	java/io/FileNotFoundException
    //   510	514	602	java/io/IOException
    //   267	277	686	java/lang/UnsatisfiedLinkError
    //   701	705	793	java/io/IOException
    //   267	277	877	finally
    //   884	888	975	java/io/IOException
    //   49	54	1059	java/io/IOException
    //   279	290	1063	finally
    //   292	304	1063	finally
    //   501	506	1063	finally
    //   692	697	1063	finally
    //   279	290	1073	java/lang/UnsatisfiedLinkError
    //   292	304	1073	java/lang/UnsatisfiedLinkError
    //   279	290	1078	java/io/FileNotFoundException
    //   292	304	1078	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenTask
 * JD-Core Version:    0.7.0.1
 */