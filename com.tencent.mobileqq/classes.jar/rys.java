import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;

public class rys
  implements Runnable
{
  volatile int jdField_a_of_type_Int = 0;
  public AIORichMediaInfo a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  public volatile boolean c = true;
  public volatile boolean d = false;
  volatile boolean e = false;
  
  public rys(ChatHistoryImageView paramChatHistoryImageView, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[setDownloadState] " + paramBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.e = paramBoolean;
      if (!this.e)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int) * 60000L);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	rys:jdField_a_of_type_Boolean	Z
    //   4: ifeq +353 -> 357
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 28	rys:d	Z
    //   12: aload_0
    //   13: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   16: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   19: bipush 102
    //   21: aload_0
    //   22: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 86	java/util/ArrayList:size	()I
    //   28: i2l
    //   29: ldc2_w 87
    //   32: lmul
    //   33: invokevirtual 94	com/tencent/util/WeakReferenceHandler:sendEmptyMessageDelayed	(IJ)Z
    //   36: pop
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: aload_0
    //   41: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   44: invokevirtual 86	java/util/ArrayList:size	()I
    //   47: if_icmpge +293 -> 340
    //   50: aload_0
    //   51: getfield 26	rys:c	Z
    //   54: ifne +17 -> 71
    //   57: aload_0
    //   58: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   61: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   64: bipush 101
    //   66: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   69: pop
    //   70: return
    //   71: aload_0
    //   72: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: iload_1
    //   76: invokevirtual 109	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   79: checkcast 111	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo
    //   82: astore 9
    //   84: ldc 113
    //   86: aload 9
    //   88: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   91: invokevirtual 122	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   94: ifeq +167 -> 261
    //   97: aload 9
    //   99: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   102: checkcast 113	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   105: astore 10
    //   107: aload 10
    //   109: getfield 125	com/tencent/mobileqq/activity/aio/photo/AIOImageData:b	Ljava/lang/String;
    //   112: astore 11
    //   114: ldc 127
    //   116: aload 11
    //   118: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifne +84 -> 205
    //   124: new 134	java/io/File
    //   127: dup
    //   128: aload 11
    //   130: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: invokevirtual 140	java/io/File:exists	()Z
    //   136: ifne +69 -> 205
    //   139: aload_0
    //   140: aload 9
    //   142: putfield 142	rys:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   145: aload 9
    //   147: iconst_1
    //   148: putfield 143	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   151: aload_0
    //   152: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   155: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   158: aload 10
    //   160: getfield 150	com/tencent/mobileqq/activity/aio/photo/AIOImageData:g	J
    //   163: aload 10
    //   165: getfield 153	com/tencent/mobileqq/activity/aio/photo/AIOImageData:f	I
    //   168: iconst_2
    //   169: invokevirtual 158	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(JII)V
    //   172: aload_0
    //   173: getfield 142	rys:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   176: astore 9
    //   178: aload 9
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 142	rys:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   185: getfield 143	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   188: istore 6
    //   190: iload 6
    //   192: ifeq +10 -> 202
    //   195: aload_0
    //   196: getfield 142	rys:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   199: invokevirtual 161	java/lang/Object:wait	()V
    //   202: aload 9
    //   204: monitorexit
    //   205: aload_0
    //   206: getfield 34	rys:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   209: astore 9
    //   211: aload 9
    //   213: monitorenter
    //   214: aload_0
    //   215: getfield 30	rys:e	Z
    //   218: istore 6
    //   220: iload 6
    //   222: ifeq +36 -> 258
    //   225: aload_0
    //   226: getfield 34	rys:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   229: invokevirtual 161	java/lang/Object:wait	()V
    //   232: goto -18 -> 214
    //   235: astore 10
    //   237: goto -23 -> 214
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 164	java/lang/InterruptedException:printStackTrace	()V
    //   247: goto -45 -> 202
    //   250: astore 10
    //   252: aload 9
    //   254: monitorexit
    //   255: aload 10
    //   257: athrow
    //   258: aload 9
    //   260: monitorexit
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 32	rys:jdField_a_of_type_Int	I
    //   266: iconst_1
    //   267: iadd
    //   268: putfield 32	rys:jdField_a_of_type_Int	I
    //   271: aload_0
    //   272: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   275: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   278: bipush 100
    //   280: invokevirtual 168	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   283: astore 9
    //   285: aload 9
    //   287: iconst_1
    //   288: putfield 173	android/os/Message:arg1	I
    //   291: aload 9
    //   293: iload_1
    //   294: iconst_1
    //   295: iadd
    //   296: bipush 100
    //   298: imul
    //   299: aload_0
    //   300: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   303: invokevirtual 86	java/util/ArrayList:size	()I
    //   306: idiv
    //   307: iconst_2
    //   308: idiv
    //   309: putfield 176	android/os/Message:arg2	I
    //   312: aload_0
    //   313: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   316: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   319: aload 9
    //   321: invokevirtual 180	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   324: pop
    //   325: iload_1
    //   326: iconst_1
    //   327: iadd
    //   328: istore_1
    //   329: goto -290 -> 39
    //   332: astore 10
    //   334: aload 9
    //   336: monitorexit
    //   337: aload 10
    //   339: athrow
    //   340: aload_0
    //   341: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   344: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   347: bipush 102
    //   349: invokevirtual 98	com/tencent/util/WeakReferenceHandler:removeMessages	(I)V
    //   352: aload_0
    //   353: iconst_0
    //   354: putfield 28	rys:d	Z
    //   357: aload_0
    //   358: getfield 26	rys:c	Z
    //   361: ifne +17 -> 378
    //   364: aload_0
    //   365: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   368: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   371: bipush 101
    //   373: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   376: pop
    //   377: return
    //   378: new 134	java/io/File
    //   381: dup
    //   382: getstatic 185	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   385: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   388: astore 11
    //   390: aload 11
    //   392: invokevirtual 140	java/io/File:exists	()Z
    //   395: ifne +9 -> 404
    //   398: aload 11
    //   400: invokevirtual 188	java/io/File:mkdirs	()Z
    //   403: pop
    //   404: iconst_0
    //   405: istore_1
    //   406: iconst_0
    //   407: istore_3
    //   408: iconst_0
    //   409: istore_2
    //   410: iload_2
    //   411: aload_0
    //   412: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   415: invokevirtual 86	java/util/ArrayList:size	()I
    //   418: if_icmpge +517 -> 935
    //   421: aload_0
    //   422: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   425: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   428: bipush 100
    //   430: invokevirtual 168	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   433: astore 9
    //   435: aload 9
    //   437: iconst_2
    //   438: putfield 173	android/os/Message:arg1	I
    //   441: aload_0
    //   442: getfield 43	rys:jdField_a_of_type_Boolean	Z
    //   445: ifeq +64 -> 509
    //   448: aload 9
    //   450: aload_0
    //   451: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   454: invokevirtual 86	java/util/ArrayList:size	()I
    //   457: iload_2
    //   458: iadd
    //   459: bipush 100
    //   461: imul
    //   462: aload_0
    //   463: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   466: invokevirtual 86	java/util/ArrayList:size	()I
    //   469: idiv
    //   470: iconst_2
    //   471: idiv
    //   472: putfield 176	android/os/Message:arg2	I
    //   475: aload_0
    //   476: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   479: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   482: aload 9
    //   484: invokevirtual 180	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   487: pop
    //   488: aload_0
    //   489: getfield 26	rys:c	Z
    //   492: ifne +37 -> 529
    //   495: aload_0
    //   496: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   499: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   502: bipush 101
    //   504: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   507: pop
    //   508: return
    //   509: aload 9
    //   511: iload_2
    //   512: bipush 100
    //   514: imul
    //   515: aload_0
    //   516: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: invokevirtual 86	java/util/ArrayList:size	()I
    //   522: idiv
    //   523: putfield 176	android/os/Message:arg2	I
    //   526: goto -51 -> 475
    //   529: aload_0
    //   530: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   533: iload_2
    //   534: invokevirtual 109	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   537: checkcast 111	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo
    //   540: astore 9
    //   542: ldc 113
    //   544: aload 9
    //   546: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   549: invokevirtual 122	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   552: ifeq +65 -> 617
    //   555: aload 9
    //   557: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   560: checkcast 113	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   563: iconst_2
    //   564: invokevirtual 191	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   567: astore 10
    //   569: aload 10
    //   571: astore 9
    //   573: aload 10
    //   575: ifnonnull +144 -> 719
    //   578: iload_3
    //   579: istore 4
    //   581: iload_1
    //   582: istore 5
    //   584: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +17 -> 604
    //   590: ldc 55
    //   592: iconst_2
    //   593: ldc 193
    //   595: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: iload_1
    //   599: istore 5
    //   601: iload_3
    //   602: istore 4
    //   604: iload_2
    //   605: iconst_1
    //   606: iadd
    //   607: istore_2
    //   608: iload 4
    //   610: istore_3
    //   611: iload 5
    //   613: istore_1
    //   614: goto -204 -> 410
    //   617: ldc 197
    //   619: aload 9
    //   621: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   624: invokevirtual 122	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   627: ifeq +466 -> 1093
    //   630: aload 9
    //   632: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   635: checkcast 197	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   638: astore 12
    //   640: aload 12
    //   642: bipush 20
    //   644: invokevirtual 198	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   647: astore 10
    //   649: aload 10
    //   651: astore 9
    //   653: aload 10
    //   655: ifnonnull +64 -> 719
    //   658: aload 12
    //   660: bipush 18
    //   662: invokevirtual 198	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   665: astore 10
    //   667: aload 10
    //   669: astore 9
    //   671: aload 10
    //   673: ifnonnull +46 -> 719
    //   676: aload 12
    //   678: bipush 16
    //   680: invokevirtual 198	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   683: astore 10
    //   685: aload 10
    //   687: astore 9
    //   689: aload 10
    //   691: ifnonnull +28 -> 719
    //   694: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +11 -> 708
    //   700: ldc 55
    //   702: iconst_2
    //   703: ldc 200
    //   705: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: iload_1
    //   709: iconst_1
    //   710: iadd
    //   711: istore 5
    //   713: iload_3
    //   714: istore 4
    //   716: goto -112 -> 604
    //   719: iload_3
    //   720: istore 4
    //   722: iload_1
    //   723: istore 5
    //   725: aload 9
    //   727: ifnull -123 -> 604
    //   730: invokestatic 206	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   733: invokestatic 212	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   736: lstore 7
    //   738: aload 9
    //   740: invokevirtual 216	java/io/File:length	()J
    //   743: lload 7
    //   745: lcmp
    //   746: ifle +41 -> 787
    //   749: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +11 -> 763
    //   755: ldc 55
    //   757: iconst_2
    //   758: ldc 218
    //   760: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: ldc 220
    //   765: invokestatic 224	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   768: aload_0
    //   769: iconst_0
    //   770: putfield 26	rys:c	Z
    //   773: aload_0
    //   774: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   777: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   780: bipush 101
    //   782: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   785: pop
    //   786: return
    //   787: new 134	java/io/File
    //   790: dup
    //   791: aload 11
    //   793: new 57	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   800: aload 9
    //   802: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   805: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc 229
    //   810: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokespecial 232	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   819: astore 10
    //   821: aload 9
    //   823: aload 10
    //   825: invokestatic 237	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   828: ifne +81 -> 909
    //   831: invokestatic 240	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   834: ldc 242
    //   836: invokevirtual 246	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   839: ifne +41 -> 880
    //   842: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   845: ifeq +11 -> 856
    //   848: ldc 55
    //   850: iconst_2
    //   851: ldc 248
    //   853: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: ldc 250
    //   858: invokestatic 224	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   861: aload_0
    //   862: iconst_0
    //   863: putfield 26	rys:c	Z
    //   866: aload_0
    //   867: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   870: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   873: bipush 101
    //   875: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   878: pop
    //   879: return
    //   880: iload_3
    //   881: istore 4
    //   883: iload_1
    //   884: istore 5
    //   886: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq -285 -> 604
    //   892: ldc 55
    //   894: iconst_2
    //   895: ldc 252
    //   897: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: iload_3
    //   901: istore 4
    //   903: iload_1
    //   904: istore 5
    //   906: goto -302 -> 604
    //   909: iload_3
    //   910: iconst_1
    //   911: iadd
    //   912: istore 4
    //   914: aload_0
    //   915: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   918: getfield 255	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   921: aload 10
    //   923: invokevirtual 258	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   926: invokestatic 263	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   929: iload_1
    //   930: istore 5
    //   932: goto -328 -> 604
    //   935: iload_3
    //   936: aload_0
    //   937: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   940: invokevirtual 86	java/util/ArrayList:size	()I
    //   943: iload_1
    //   944: isub
    //   945: if_icmpne +60 -> 1005
    //   948: new 57	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   955: aload_0
    //   956: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   959: getfield 255	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   962: invokevirtual 269	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   965: ldc_w 270
    //   968: invokevirtual 276	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   971: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: getstatic 185	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   977: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: invokestatic 278	com/tencent/mobileqq/filemanager/util/FMToastUtil:b	(Ljava/lang/String;)V
    //   986: aload_0
    //   987: iconst_0
    //   988: putfield 26	rys:c	Z
    //   991: aload_0
    //   992: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   995: getfield 82	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   998: bipush 101
    //   1000: invokevirtual 105	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   1003: pop
    //   1004: return
    //   1005: iload_3
    //   1006: ifle +78 -> 1084
    //   1009: new 57	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1016: getstatic 284	java/util/Locale:CHINA	Ljava/util/Locale;
    //   1019: aload_0
    //   1020: getfield 21	rys:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1023: getfield 255	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1026: invokevirtual 269	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1029: ldc_w 285
    //   1032: invokevirtual 276	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1035: iconst_2
    //   1036: anewarray 4	java/lang/Object
    //   1039: dup
    //   1040: iconst_0
    //   1041: iload_3
    //   1042: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_1
    //   1048: aload_0
    //   1049: getfield 41	rys:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1052: invokevirtual 86	java/util/ArrayList:size	()I
    //   1055: iload_1
    //   1056: isub
    //   1057: iload_3
    //   1058: isub
    //   1059: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1062: aastore
    //   1063: invokestatic 295	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1066: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: getstatic 185	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   1072: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: invokestatic 278	com/tencent/mobileqq/filemanager/util/FMToastUtil:b	(Ljava/lang/String;)V
    //   1081: goto -95 -> 986
    //   1084: ldc_w 297
    //   1087: invokestatic 224	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   1090: goto -104 -> 986
    //   1093: aconst_null
    //   1094: astore 9
    //   1096: goto -377 -> 719
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1099	0	this	rys
    //   38	1019	1	i	int
    //   409	199	2	j	int
    //   407	652	3	k	int
    //   579	334	4	m	int
    //   582	349	5	n	int
    //   188	33	6	bool	boolean
    //   736	8	7	l	long
    //   105	59	10	localAIOImageData	com.tencent.mobileqq.activity.aio.photo.AIOImageData
    //   235	1	10	localInterruptedException1	java.lang.InterruptedException
    //   240	3	10	localInterruptedException2	java.lang.InterruptedException
    //   250	6	10	localObject2	Object
    //   332	6	10	localObject3	Object
    //   567	355	10	localFile	java.io.File
    //   112	680	11	localObject4	Object
    //   638	39	12	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
    // Exception table:
    //   from	to	target	type
    //   225	232	235	java/lang/InterruptedException
    //   195	202	240	java/lang/InterruptedException
    //   181	190	250	finally
    //   195	202	250	finally
    //   202	205	250	finally
    //   242	247	250	finally
    //   252	255	250	finally
    //   214	220	332	finally
    //   225	232	332	finally
    //   258	261	332	finally
    //   334	337	332	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rys
 * JD-Core Version:    0.7.0.1
 */