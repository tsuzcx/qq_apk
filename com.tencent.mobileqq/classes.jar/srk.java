import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class srk
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  String c;
  
  public srk(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate, String paramString1, String paramString2, String paramString3, AtomicBoolean paramAtomicBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramProfileCardTemplate);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 24	srk:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   6: ifnull +944 -> 950
    //   9: aload_0
    //   10: getfield 26	srk:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   13: ifnull +937 -> 950
    //   16: aload_0
    //   17: getfield 24	srk:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   20: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   23: checkcast 46	com/tencent/mobileqq/activity/FriendProfileCardActivity
    //   26: astore 9
    //   28: aload_0
    //   29: getfield 26	srk:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   32: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   35: checkcast 48	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   38: astore 10
    //   40: aload 9
    //   42: ifnull +908 -> 950
    //   45: aload 10
    //   47: ifnull +903 -> 950
    //   50: aload 9
    //   52: getfield 51	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   55: ldc 53
    //   57: iconst_1
    //   58: invokevirtual 58	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   61: aload 9
    //   63: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   66: invokestatic 67	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   69: istore 6
    //   71: aload 9
    //   73: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   79: aload_0
    //   80: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokestatic 76	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   86: istore 7
    //   88: aload 9
    //   90: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   93: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   96: aload_0
    //   97: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   100: invokestatic 78	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   103: istore 8
    //   105: iload 7
    //   107: ifne +1255 -> 1362
    //   110: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +41 -> 154
    //   116: ldc 86
    //   118: iconst_2
    //   119: new 88	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   126: ldc 91
    //   128: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   135: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 97
    //   140: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 7
    //   145: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   148: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: new 110	java/io/File
    //   157: dup
    //   158: aload 9
    //   160: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   163: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   166: aload_0
    //   167: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokestatic 113	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   173: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore 10
    //   178: new 118	com/tencent/mobileqq/vip/DownloadTask
    //   181: dup
    //   182: aload_0
    //   183: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   186: aload 10
    //   188: invokespecial 121	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   191: astore 10
    //   193: aload 10
    //   195: ldc 123
    //   197: putfield 126	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   200: aload 10
    //   202: ldc 128
    //   204: putfield 131	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   207: aload 10
    //   209: aload 9
    //   211: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: invokestatic 136	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   217: istore_1
    //   218: iload_1
    //   219: ifeq +40 -> 259
    //   222: ldc 86
    //   224: iconst_1
    //   225: new 88	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   232: ldc 138
    //   234: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload_1
    //   238: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: ldc 143
    //   243: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   250: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: iload_1
    //   260: ifne +1123 -> 1383
    //   263: aload 9
    //   265: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   271: aload_0
    //   272: getfield 28	srk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 76	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   278: ifeq +1105 -> 1383
    //   281: iconst_1
    //   282: istore 5
    //   284: goto +1081 -> 1365
    //   287: iload 8
    //   289: ifne +1070 -> 1359
    //   292: aload_0
    //   293: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   296: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifne +1060 -> 1359
    //   302: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +31 -> 336
    //   308: ldc 86
    //   310: iconst_2
    //   311: new 88	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   318: ldc 153
    //   320: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   327: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload 9
    //   338: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   341: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   344: aload_0
    //   345: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 113	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   351: astore 10
    //   353: new 110	java/io/File
    //   356: dup
    //   357: aload 10
    //   359: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 11
    //   364: new 118	com/tencent/mobileqq/vip/DownloadTask
    //   367: dup
    //   368: aload_0
    //   369: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   372: aload 11
    //   374: invokespecial 121	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   377: astore 11
    //   379: aload 11
    //   381: ldc 123
    //   383: putfield 126	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   386: aload 11
    //   388: ldc 128
    //   390: putfield 131	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   393: aload 11
    //   395: aload 9
    //   397: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   400: invokestatic 136	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   403: istore_1
    //   404: iload_1
    //   405: ifeq +40 -> 445
    //   408: ldc 86
    //   410: iconst_1
    //   411: new 88	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   418: ldc 155
    //   420: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: iload_1
    //   424: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: ldc 143
    //   429: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   436: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: iload_1
    //   446: ifne +913 -> 1359
    //   449: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +31 -> 483
    //   455: ldc 86
    //   457: iconst_2
    //   458: new 88	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   465: ldc 157
    //   467: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aload 10
    //   485: new 88	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   492: aload 9
    //   494: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   497: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   500: invokestatic 164	com/tencent/mobileqq/util/ProfileCardUtil:c	(Landroid/content/Context;)Ljava/lang/String;
    //   503: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc 166
    //   508: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   515: invokestatic 169	com/tencent/mobileqq/util/ProfileCardUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: iconst_0
    //   525: invokestatic 174	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   528: aload 10
    //   530: invokestatic 178	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   533: pop
    //   534: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +835 -> 1372
    //   540: ldc 86
    //   542: iconst_2
    //   543: new 88	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   550: ldc 180
    //   552: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_0
    //   556: getfield 32	srk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   559: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: ldc 182
    //   564: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: goto +799 -> 1372
    //   576: aload_0
    //   577: getfield 34	srk:c	Ljava/lang/String;
    //   580: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +771 -> 1354
    //   586: aload 9
    //   588: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   591: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   594: aload_0
    //   595: getfield 34	srk:c	Ljava/lang/String;
    //   598: invokestatic 78	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   601: ifne +753 -> 1354
    //   604: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq +31 -> 638
    //   610: ldc 86
    //   612: iconst_2
    //   613: new 88	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   620: ldc 184
    //   622: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_0
    //   626: getfield 34	srk:c	Ljava/lang/String;
    //   629: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: new 110	java/io/File
    //   641: dup
    //   642: aload 9
    //   644: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   647: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   650: aload_0
    //   651: getfield 34	srk:c	Ljava/lang/String;
    //   654: invokestatic 113	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   657: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: astore 10
    //   662: new 118	com/tencent/mobileqq/vip/DownloadTask
    //   665: dup
    //   666: aload_0
    //   667: getfield 34	srk:c	Ljava/lang/String;
    //   670: aload 10
    //   672: invokespecial 121	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   675: astore 10
    //   677: aload 10
    //   679: ldc 123
    //   681: putfield 126	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   684: aload 10
    //   686: ldc 128
    //   688: putfield 131	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   691: aload 10
    //   693: aload 9
    //   695: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   698: invokestatic 136	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   701: istore_1
    //   702: iload_1
    //   703: ifeq +675 -> 1378
    //   706: ldc 86
    //   708: iconst_1
    //   709: new 88	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   716: ldc 186
    //   718: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: iload_1
    //   722: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   725: ldc 143
    //   727: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload_0
    //   731: getfield 34	srk:c	Ljava/lang/String;
    //   734: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: goto +635 -> 1378
    //   746: aload 9
    //   748: getfield 51	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   751: ldc 188
    //   753: ldc 53
    //   755: iconst_0
    //   756: invokevirtual 189	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   759: iload 6
    //   761: istore 5
    //   763: iload 6
    //   765: ifne +99 -> 864
    //   768: aload 9
    //   770: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   773: ldc2_w 190
    //   776: invokestatic 194	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Ljava/lang/String;
    //   779: astore 10
    //   781: iload 6
    //   783: istore 5
    //   785: ldc 196
    //   787: ifnull +77 -> 864
    //   790: iload 6
    //   792: istore 5
    //   794: aload 10
    //   796: ifnull +68 -> 864
    //   799: new 110	java/io/File
    //   802: dup
    //   803: aload 10
    //   805: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   808: astore 11
    //   810: new 110	java/io/File
    //   813: dup
    //   814: new 88	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   821: aload 10
    //   823: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: getstatic 199	java/io/File:separator	Ljava/lang/String;
    //   829: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc 201
    //   834: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   843: astore 12
    //   845: aload 11
    //   847: invokevirtual 204	java/io/File:isDirectory	()Z
    //   850: ifeq +109 -> 959
    //   853: aload 12
    //   855: invokevirtual 207	java/io/File:exists	()Z
    //   858: ifeq +101 -> 959
    //   861: iconst_1
    //   862: istore 5
    //   864: aload 9
    //   866: getfield 51	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   869: ldc 209
    //   871: ldc 188
    //   873: iconst_0
    //   874: invokevirtual 189	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   877: aload 9
    //   879: getfield 212	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   882: ifnull +68 -> 950
    //   885: aload 9
    //   887: getfield 212	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   890: invokevirtual 218	com/tencent/util/WeakReferenceHandler:obtainMessage	()Landroid/os/Message;
    //   893: astore 10
    //   895: aload 10
    //   897: bipush 7
    //   899: putfield 224	android/os/Message:what	I
    //   902: iload 5
    //   904: ifeq +440 -> 1344
    //   907: iload 7
    //   909: ifeq +435 -> 1344
    //   912: iconst_1
    //   913: istore_2
    //   914: aload 10
    //   916: iload_2
    //   917: putfield 227	android/os/Message:arg1	I
    //   920: iload_3
    //   921: istore_2
    //   922: iload 8
    //   924: ifne +9 -> 933
    //   927: iload_1
    //   928: ifeq +421 -> 1349
    //   931: iload_3
    //   932: istore_2
    //   933: aload 10
    //   935: iload_2
    //   936: putfield 230	android/os/Message:arg2	I
    //   939: aload 9
    //   941: getfield 212	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   944: aload 10
    //   946: invokevirtual 234	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   949: pop
    //   950: aload_0
    //   951: getfield 30	srk:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   954: iconst_0
    //   955: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   958: return
    //   959: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +29 -> 991
    //   965: ldc 86
    //   967: iconst_2
    //   968: new 88	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   975: ldc 242
    //   977: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload 10
    //   982: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: new 110	java/io/File
    //   994: dup
    //   995: new 88	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1002: aload 10
    //   1004: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: ldc 244
    //   1009: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   1018: astore 11
    //   1020: aload 11
    //   1022: invokevirtual 207	java/io/File:exists	()Z
    //   1025: ifeq +9 -> 1034
    //   1028: aload 11
    //   1030: invokevirtual 247	java/io/File:delete	()Z
    //   1033: pop
    //   1034: new 118	com/tencent/mobileqq/vip/DownloadTask
    //   1037: dup
    //   1038: ldc 196
    //   1040: aload 11
    //   1042: invokespecial 121	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   1045: astore 12
    //   1047: aload 12
    //   1049: ldc 123
    //   1051: putfield 126	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   1054: aload 12
    //   1056: ldc 128
    //   1058: putfield 131	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   1061: aload 12
    //   1063: aload 9
    //   1065: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1068: invokestatic 136	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   1071: istore 4
    //   1073: iload 4
    //   1075: ifne +320 -> 1395
    //   1078: iconst_1
    //   1079: istore_2
    //   1080: iload_2
    //   1081: ifeq +219 -> 1300
    //   1084: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +32 -> 1119
    //   1090: ldc 86
    //   1092: iconst_2
    //   1093: new 88	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1100: ldc 249
    //   1102: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload 11
    //   1107: invokevirtual 253	java/io/File:length	()J
    //   1110: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1119: aload 11
    //   1121: invokevirtual 261	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1124: new 88	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1131: aload 10
    //   1133: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: getstatic 199	java/io/File:separator	Ljava/lang/String;
    //   1139: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: iconst_0
    //   1146: invokestatic 174	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1149: aload 9
    //   1151: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: ldc_w 263
    //   1157: ldc_w 265
    //   1160: invokestatic 268	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 9
    //   1165: getfield 62	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1168: invokestatic 67	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1171: ifeq +27 -> 1198
    //   1174: aload 11
    //   1176: invokevirtual 247	java/io/File:delete	()Z
    //   1179: pop
    //   1180: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1183: ifeq +206 -> 1389
    //   1186: ldc 86
    //   1188: iconst_2
    //   1189: ldc_w 270
    //   1192: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1195: goto +194 -> 1389
    //   1198: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1201: ifeq +12 -> 1213
    //   1204: ldc 86
    //   1206: iconst_2
    //   1207: ldc_w 272
    //   1210: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: iload 6
    //   1215: istore 5
    //   1217: goto +175 -> 1392
    //   1220: astore 10
    //   1222: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +33 -> 1258
    //   1228: ldc 86
    //   1230: iconst_2
    //   1231: new 88	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 274
    //   1241: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload 10
    //   1246: invokevirtual 277	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1249: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: aload 10
    //   1260: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   1263: iload 6
    //   1265: istore 5
    //   1267: goto -403 -> 864
    //   1270: astore 9
    //   1272: aload 9
    //   1274: invokevirtual 281	java/lang/Exception:printStackTrace	()V
    //   1277: aload_0
    //   1278: getfield 30	srk:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1281: iconst_0
    //   1282: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1285: return
    //   1286: astore 10
    //   1288: aload 10
    //   1290: invokevirtual 281	java/lang/Exception:printStackTrace	()V
    //   1293: iload 6
    //   1295: istore 5
    //   1297: goto -433 -> 864
    //   1300: ldc 86
    //   1302: iconst_1
    //   1303: new 88	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1310: ldc_w 283
    //   1313: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: iload 4
    //   1318: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1321: ldc 143
    //   1323: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: ldc 196
    //   1328: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1337: iload 6
    //   1339: istore 5
    //   1341: goto -477 -> 864
    //   1344: iconst_0
    //   1345: istore_2
    //   1346: goto -432 -> 914
    //   1349: iconst_0
    //   1350: istore_2
    //   1351: goto -418 -> 933
    //   1354: iconst_0
    //   1355: istore_1
    //   1356: goto -610 -> 746
    //   1359: goto -783 -> 576
    //   1362: goto -1075 -> 287
    //   1365: iload 5
    //   1367: istore 7
    //   1369: goto -1082 -> 287
    //   1372: iconst_1
    //   1373: istore 8
    //   1375: goto -799 -> 576
    //   1378: iconst_1
    //   1379: istore_1
    //   1380: goto -634 -> 746
    //   1383: iconst_0
    //   1384: istore 5
    //   1386: goto -21 -> 1365
    //   1389: iconst_1
    //   1390: istore 5
    //   1392: goto -528 -> 864
    //   1395: iconst_0
    //   1396: istore_2
    //   1397: goto -317 -> 1080
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1400	0	this	srk
    //   217	1163	1	i	int
    //   913	484	2	j	int
    //   1	931	3	k	int
    //   1071	246	4	m	int
    //   282	1109	5	bool1	boolean
    //   69	1269	6	bool2	boolean
    //   86	1282	7	bool3	boolean
    //   103	1271	8	bool4	boolean
    //   26	1138	9	localFriendProfileCardActivity	FriendProfileCardActivity
    //   1270	3	9	localException1	java.lang.Exception
    //   38	1094	10	localObject1	Object
    //   1220	39	10	localIOException	java.io.IOException
    //   1286	3	10	localException2	java.lang.Exception
    //   362	813	11	localObject2	Object
    //   843	219	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1119	1195	1220	java/io/IOException
    //   1198	1213	1220	java/io/IOException
    //   2	40	1270	java/lang/Exception
    //   50	105	1270	java/lang/Exception
    //   110	154	1270	java/lang/Exception
    //   154	218	1270	java/lang/Exception
    //   222	259	1270	java/lang/Exception
    //   263	281	1270	java/lang/Exception
    //   292	336	1270	java/lang/Exception
    //   336	404	1270	java/lang/Exception
    //   408	445	1270	java/lang/Exception
    //   449	483	1270	java/lang/Exception
    //   483	573	1270	java/lang/Exception
    //   576	638	1270	java/lang/Exception
    //   638	702	1270	java/lang/Exception
    //   706	743	1270	java/lang/Exception
    //   746	759	1270	java/lang/Exception
    //   768	781	1270	java/lang/Exception
    //   799	861	1270	java/lang/Exception
    //   864	902	1270	java/lang/Exception
    //   914	920	1270	java/lang/Exception
    //   933	950	1270	java/lang/Exception
    //   950	958	1270	java/lang/Exception
    //   959	991	1270	java/lang/Exception
    //   991	1034	1270	java/lang/Exception
    //   1034	1073	1270	java/lang/Exception
    //   1084	1119	1270	java/lang/Exception
    //   1222	1258	1270	java/lang/Exception
    //   1258	1263	1270	java/lang/Exception
    //   1288	1293	1270	java/lang/Exception
    //   1300	1337	1270	java/lang/Exception
    //   1119	1195	1286	java/lang/Exception
    //   1198	1213	1286	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srk
 * JD-Core Version:    0.7.0.1
 */