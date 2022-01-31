package com.tencent.mobileqq.utils;

import android.media.AudioRecord;
import awug;
import awuh;
import awui;
import bdhw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class QQRecorder$RecordThread
  extends Thread
  implements awui
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  File jdField_a_of_type_JavaIoFile;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public String a;
  public volatile boolean a;
  public volatile boolean b = true;
  private boolean c;
  
  QQRecorder$RecordThread(QQRecorder paramQQRecorder)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 46
    //   8: iconst_2
    //   9: new 48	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   16: ldc 51
    //   18: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: lconst_0
    //   32: lstore 28
    //   34: lconst_0
    //   35: lstore 24
    //   37: iconst_0
    //   38: istore 14
    //   40: dconst_0
    //   41: dstore_2
    //   42: iconst_m1
    //   43: istore 18
    //   45: lconst_0
    //   46: lstore 22
    //   48: iconst_0
    //   49: istore 17
    //   51: iconst_0
    //   52: istore 19
    //   54: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   57: lstore 34
    //   59: lconst_0
    //   60: lstore 20
    //   62: iconst_0
    //   63: istore 15
    //   65: iconst_0
    //   66: istore 13
    //   68: iconst_0
    //   69: istore 12
    //   71: lconst_0
    //   72: lstore 30
    //   74: sipush 250
    //   77: istore 10
    //   79: bipush 237
    //   81: invokestatic 78	android/os/Process:setThreadPriority	(I)V
    //   84: aload_0
    //   85: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   88: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   91: iconst_1
    //   92: invokestatic 88	bdaz:a	(Landroid/content/Context;Z)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   100: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   103: ifnull +14 -> 117
    //   106: aload_0
    //   107: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   110: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   113: iconst_0
    //   114: putfield 96	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:f	I
    //   117: aload_0
    //   118: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   121: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   124: ifnull +23 -> 147
    //   127: aload_0
    //   128: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   131: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   139: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   142: invokeinterface 104 3 0
    //   147: aload_0
    //   148: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   151: invokestatic 107	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   154: newarray byte
    //   156: astore 36
    //   158: aload_0
    //   159: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   162: invokestatic 109	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   165: aload_0
    //   166: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   169: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   172: ifnull +38 -> 210
    //   175: aload_0
    //   176: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   179: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   182: invokeinterface 112 1 0
    //   187: istore 11
    //   189: iload 11
    //   191: istore 10
    //   193: iload 11
    //   195: ifgt +8 -> 203
    //   198: sipush 250
    //   201: istore 10
    //   203: iload 10
    //   205: invokestatic 115	com/tencent/mobileqq/utils/QQRecorder:a	(I)I
    //   208: istore 10
    //   210: invokestatic 118	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   213: ifeq +34 -> 247
    //   216: ldc 46
    //   218: iconst_4
    //   219: new 48	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   226: ldc 120
    //   228: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokestatic 125	android/os/SystemClock:uptimeMillis	()J
    //   234: getstatic 128	bark:jdField_a_of_type_Long	J
    //   237: lsub
    //   238: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   251: invokestatic 133	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   254: aload_0
    //   255: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   258: invokestatic 136	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lawuk;
    //   261: aload_0
    //   262: invokevirtual 141	awuk:a	(Lawui;)V
    //   265: ldc2_w 142
    //   268: invokestatic 147	java/lang/Thread:sleep	(J)V
    //   271: aload_0
    //   272: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   275: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   278: getfield 148	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   281: invokestatic 150	com/tencent/mobileqq/utils/QQRecorder:b	(I)I
    //   284: sipush 1000
    //   287: idiv
    //   288: iload 10
    //   290: imul
    //   291: istore 16
    //   293: iconst_0
    //   294: istore 10
    //   296: iload 10
    //   298: iload 16
    //   300: if_icmpge +60 -> 360
    //   303: aload_0
    //   304: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   307: invokestatic 107	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   310: istore 11
    //   312: aload_0
    //   313: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   316: invokestatic 107	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   319: iload 16
    //   321: iload 10
    //   323: isub
    //   324: if_icmple +10 -> 334
    //   327: iload 16
    //   329: iload 10
    //   331: isub
    //   332: istore 11
    //   334: aload_0
    //   335: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   338: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   341: aload 36
    //   343: iconst_0
    //   344: iload 11
    //   346: invokevirtual 159	android/media/AudioRecord:read	([BII)I
    //   349: pop
    //   350: iload 11
    //   352: iload 10
    //   354: iadd
    //   355: istore 10
    //   357: goto -61 -> 296
    //   360: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +39 -> 402
    //   366: ldc 46
    //   368: iconst_2
    //   369: new 48	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   376: ldc 161
    //   378: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: iload 10
    //   383: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: ldc 166
    //   388: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload 16
    //   393: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   406: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   409: ifnull +70 -> 479
    //   412: aload_0
    //   413: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   416: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   419: aload_0
    //   420: getfield 168	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aload_0
    //   424: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   427: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   430: invokeinterface 171 3 0
    //   435: istore 18
    //   437: iload 18
    //   439: sipush 1000
    //   442: idiv
    //   443: bipush 10
    //   445: imul
    //   446: istore 11
    //   448: iload 11
    //   450: istore 10
    //   452: iload 11
    //   454: sipush 6000
    //   457: if_icmple +8 -> 465
    //   460: sipush 6000
    //   463: istore 10
    //   465: aload_0
    //   466: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   469: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   472: iload 10
    //   474: newarray int
    //   476: putfield 174	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   479: invokestatic 118	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   482: ifeq +34 -> 516
    //   485: ldc 46
    //   487: iconst_4
    //   488: new 48	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   495: ldc 176
    //   497: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokestatic 125	android/os/SystemClock:uptimeMillis	()J
    //   503: getstatic 128	bark:jdField_a_of_type_Long	J
    //   506: lsub
    //   507: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   519: lstore 32
    //   521: iconst_0
    //   522: istore 16
    //   524: iconst_0
    //   525: istore 10
    //   527: lconst_0
    //   528: lstore 24
    //   530: lconst_0
    //   531: lstore 22
    //   533: lconst_0
    //   534: lstore 26
    //   536: dconst_0
    //   537: dstore_2
    //   538: lconst_0
    //   539: lstore 20
    //   541: iconst_0
    //   542: istore 11
    //   544: aload_0
    //   545: getfield 26	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Boolean	Z
    //   548: ifeq +1521 -> 2069
    //   551: aload_0
    //   552: getfield 178	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   555: ifne +1514 -> 2069
    //   558: iload 11
    //   560: istore 13
    //   562: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   565: lload 32
    //   567: lsub
    //   568: ldc2_w 179
    //   571: lcmp
    //   572: ifle +817 -> 1389
    //   575: iload 11
    //   577: istore 13
    //   579: iload 11
    //   581: ifne +808 -> 1389
    //   584: iconst_1
    //   585: istore 13
    //   587: lload 24
    //   589: lconst_0
    //   590: lcmp
    //   591: ifeq +8 -> 599
    //   594: iload 12
    //   596: ifne +793 -> 1389
    //   599: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +39 -> 641
    //   605: ldc 46
    //   607: iconst_2
    //   608: new 48	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   615: ldc 182
    //   617: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: lload 24
    //   622: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: ldc 184
    //   627: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload 12
    //   632: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: new 186	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
    //   644: dup
    //   645: ldc 188
    //   647: invokespecial 190	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
    //   650: athrow
    //   651: astore 36
    //   653: lload 20
    //   655: lstore 32
    //   657: lload 26
    //   659: lstore 20
    //   661: lload 22
    //   663: lstore 28
    //   665: lload 32
    //   667: lstore 26
    //   669: lload 20
    //   671: lstore 22
    //   673: lload 28
    //   675: lstore 20
    //   677: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +13 -> 693
    //   683: ldc 46
    //   685: iconst_2
    //   686: ldc 192
    //   688: aload 36
    //   690: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   693: aload_0
    //   694: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   697: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   700: ifnull +71 -> 771
    //   703: aload_0
    //   704: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   707: getfield 198	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   710: ifnull +25 -> 735
    //   713: aload_0
    //   714: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   717: invokestatic 200	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   720: iconst_m1
    //   721: if_icmpeq +14 -> 735
    //   724: aload_0
    //   725: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   728: getfield 198	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   731: iconst_0
    //   732: invokevirtual 205	android/media/AudioManager:setMode	(I)V
    //   735: aload 36
    //   737: instanceof 207
    //   740: ifne +11 -> 751
    //   743: aload 36
    //   745: instanceof 209
    //   748: ifeq +2363 -> 3111
    //   751: aload_0
    //   752: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   755: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   758: aload_1
    //   759: aload_0
    //   760: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   763: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   766: invokeinterface 211 3 0
    //   771: aload_0
    //   772: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   775: aload 36
    //   777: invokevirtual 214	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   780: aload_0
    //   781: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   784: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   787: ifnull +27 -> 814
    //   790: aload_0
    //   791: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   794: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   797: invokevirtual 217	android/media/AudioRecord:getState	()I
    //   800: iconst_1
    //   801: if_icmpne +13 -> 814
    //   804: aload_0
    //   805: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   808: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   811: invokevirtual 220	android/media/AudioRecord:stop	()V
    //   814: aload_0
    //   815: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   818: ifnull +15 -> 833
    //   821: aload_0
    //   822: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   825: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   828: aload_0
    //   829: aconst_null
    //   830: putfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   833: aload_0
    //   834: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   837: invokestatic 229	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   840: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +84 -> 927
    //   846: ldc 46
    //   848: iconst_2
    //   849: new 48	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   856: ldc 231
    //   858: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_0
    //   862: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: ldc 46
    //   873: iconst_2
    //   874: new 48	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   881: ldc 233
    //   883: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: lload 26
    //   888: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   891: ldc 235
    //   893: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: lload 24
    //   898: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   901: ldc 237
    //   903: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: lload 20
    //   908: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   911: ldc 239
    //   913: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: iload 10
    //   918: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload_0
    //   928: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   931: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   934: iconst_0
    //   935: invokestatic 88	bdaz:a	(Landroid/content/Context;Z)Z
    //   938: pop
    //   939: lload 20
    //   941: ldc2_w 240
    //   944: lcmp
    //   945: iflt +11 -> 956
    //   948: dload_2
    //   949: ldc2_w 242
    //   952: dcmpg
    //   953: ifge +3 -> 956
    //   956: new 245	java/util/HashMap
    //   959: dup
    //   960: invokespecial 246	java/util/HashMap:<init>	()V
    //   963: astore_1
    //   964: aload_1
    //   965: ldc 248
    //   967: new 48	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   974: getstatic 253	android/os/Build$VERSION:SDK_INT	I
    //   977: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   980: ldc 255
    //   982: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   991: pop
    //   992: aload_1
    //   993: ldc_w 261
    //   996: new 48	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1003: getstatic 266	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1006: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc_w 268
    //   1012: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: getstatic 271	android/os/Build:MODEL	Ljava/lang/String;
    //   1018: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1027: pop
    //   1028: aload_1
    //   1029: ldc_w 273
    //   1032: new 48	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1039: lload 24
    //   1041: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1044: ldc 255
    //   1046: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1055: pop
    //   1056: aload_1
    //   1057: ldc_w 275
    //   1060: new 48	java/lang/StringBuilder
    //   1063: dup
    //   1064: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1067: dload_2
    //   1068: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1071: ldc 255
    //   1073: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1082: pop
    //   1083: aload_1
    //   1084: ldc_w 280
    //   1087: new 48	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1094: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   1097: lload 34
    //   1099: lsub
    //   1100: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: ldc 255
    //   1105: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1114: pop
    //   1115: aload_1
    //   1116: ldc_w 282
    //   1119: new 48	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1126: iload 12
    //   1128: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1131: ldc 255
    //   1133: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1142: pop
    //   1143: aload_1
    //   1144: ldc_w 284
    //   1147: new 48	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1154: aload_0
    //   1155: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1158: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: ldc 255
    //   1163: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1172: pop
    //   1173: lload 22
    //   1175: lconst_0
    //   1176: lcmp
    //   1177: ifne +2954 -> 4131
    //   1180: ldc2_w 285
    //   1183: lstore 26
    //   1185: goto +3414 -> 4599
    //   1188: lload 22
    //   1190: l2i
    //   1191: istore 10
    //   1193: aload_1
    //   1194: ldc_w 288
    //   1197: new 48	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1204: iload 11
    //   1206: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1209: ldc 255
    //   1211: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1220: pop
    //   1221: aload_1
    //   1222: ldc_w 290
    //   1225: new 48	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1232: iload 10
    //   1234: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1237: ldc 255
    //   1239: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1245: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1248: pop
    //   1249: ldc_w 292
    //   1252: iconst_1
    //   1253: aload_1
    //   1254: invokestatic 295	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1257: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +128 -> 1388
    //   1263: new 48	java/lang/StringBuilder
    //   1266: dup
    //   1267: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1270: astore_1
    //   1271: aload_1
    //   1272: ldc_w 297
    //   1275: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: iload 12
    //   1280: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: aload_1
    //   1285: ldc_w 299
    //   1288: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: iload 11
    //   1293: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload_1
    //   1298: ldc_w 301
    //   1301: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: iload 10
    //   1306: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload_1
    //   1311: ldc_w 303
    //   1314: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: iload 10
    //   1319: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: aload_1
    //   1324: ldc_w 305
    //   1327: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: lload 24
    //   1332: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload_1
    //   1337: ldc_w 307
    //   1340: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: lload 20
    //   1345: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload_1
    //   1350: ldc_w 309
    //   1353: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: dload_2
    //   1357: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: ldc_w 311
    //   1365: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   1371: lload 34
    //   1373: lsub
    //   1374: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: ldc 46
    //   1380: iconst_2
    //   1381: aload_1
    //   1382: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: return
    //   1389: iload 16
    //   1391: istore 14
    //   1393: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   1396: lload 32
    //   1398: lsub
    //   1399: ldc2_w 179
    //   1402: lcmp
    //   1403: ifle +99 -> 1502
    //   1406: iload 16
    //   1408: istore 14
    //   1410: iload 16
    //   1412: ifne +90 -> 1502
    //   1415: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq +32 -> 1450
    //   1421: ldc 46
    //   1423: iconst_2
    //   1424: new 48	java/lang/StringBuilder
    //   1427: dup
    //   1428: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1431: ldc_w 313
    //   1434: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload_0
    //   1438: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1441: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1450: aload_0
    //   1451: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1454: ifle +102 -> 1556
    //   1457: aload_0
    //   1458: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1461: sipush 500
    //   1464: if_icmpge +92 -> 1556
    //   1467: iconst_1
    //   1468: istore 11
    //   1470: iload 11
    //   1472: istore 14
    //   1474: aload_0
    //   1475: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1478: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1481: ifnull +21 -> 1502
    //   1484: aload_0
    //   1485: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1488: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1491: iload 11
    //   1493: invokeinterface 315 2 0
    //   1498: iload 11
    //   1500: istore 14
    //   1502: lload 20
    //   1504: lconst_1
    //   1505: ladd
    //   1506: lstore 20
    //   1508: aload_0
    //   1509: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1512: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1515: aload 36
    //   1517: iconst_0
    //   1518: aload_0
    //   1519: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1522: invokestatic 107	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1525: invokevirtual 159	android/media/AudioRecord:read	([BII)I
    //   1528: istore 15
    //   1530: iload 15
    //   1532: ifgt +30 -> 1562
    //   1535: ldc2_w 316
    //   1538: invokestatic 147	java/lang/Thread:sleep	(J)V
    //   1541: iload 13
    //   1543: istore 11
    //   1545: iload 15
    //   1547: istore 10
    //   1549: iload 14
    //   1551: istore 16
    //   1553: goto -1009 -> 544
    //   1556: iconst_2
    //   1557: istore 11
    //   1559: goto -89 -> 1470
    //   1562: aload_0
    //   1563: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   1566: ifnull +15 -> 1581
    //   1569: aload_0
    //   1570: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   1573: aload 36
    //   1575: iconst_0
    //   1576: iload 15
    //   1578: invokevirtual 321	java/io/FileOutputStream:write	([BII)V
    //   1581: lconst_1
    //   1582: lload 26
    //   1584: ladd
    //   1585: lstore 26
    //   1587: lload 24
    //   1589: iload 15
    //   1591: i2l
    //   1592: ladd
    //   1593: lstore 28
    //   1595: aload_0
    //   1596: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1599: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1602: aload 36
    //   1604: iload 15
    //   1606: fconst_1
    //   1607: invokestatic 326	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1610: l2i
    //   1611: istore 16
    //   1613: iload 12
    //   1615: iload 16
    //   1617: invokestatic 332	java/lang/Math:max	(II)I
    //   1620: istore 11
    //   1622: lload 30
    //   1624: iload 16
    //   1626: i2l
    //   1627: ladd
    //   1628: lstore 24
    //   1630: dload_2
    //   1631: dstore 4
    //   1633: dload_2
    //   1634: dstore 6
    //   1636: aload_0
    //   1637: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1640: invokestatic 136	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lawuk;
    //   1643: aload 36
    //   1645: iconst_0
    //   1646: iload 15
    //   1648: invokevirtual 335	awuk:a	([BII)Lawuh;
    //   1651: astore 37
    //   1653: dload_2
    //   1654: dstore 4
    //   1656: dload_2
    //   1657: dstore 6
    //   1659: invokestatic 337	bark:b	()V
    //   1662: dload_2
    //   1663: dstore 4
    //   1665: dload_2
    //   1666: dstore 6
    //   1668: iload 15
    //   1670: i2l
    //   1671: aload_0
    //   1672: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1675: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1678: getfield 148	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   1681: invokestatic 340	com/tencent/mobileqq/utils/QQRecorder:a	(JI)D
    //   1684: dstore 8
    //   1686: dload_2
    //   1687: dload 8
    //   1689: dadd
    //   1690: dstore_2
    //   1691: dload 8
    //   1693: iload 19
    //   1695: i2d
    //   1696: dadd
    //   1697: d2i
    //   1698: istore 15
    //   1700: dload_2
    //   1701: dstore 4
    //   1703: dload_2
    //   1704: dstore 6
    //   1706: aload_0
    //   1707: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1710: invokestatic 342	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1713: iload 17
    //   1715: invokestatic 332	java/lang/Math:max	(II)I
    //   1718: istore 17
    //   1720: iload 15
    //   1722: bipush 100
    //   1724: if_icmplt +2872 -> 4596
    //   1727: dload_2
    //   1728: dstore 4
    //   1730: dload_2
    //   1731: dstore 6
    //   1733: aload_0
    //   1734: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1737: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1740: getfield 174	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1743: ifnull +2876 -> 4619
    //   1746: dload_2
    //   1747: dstore 4
    //   1749: dload_2
    //   1750: dstore 6
    //   1752: aload_0
    //   1753: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1756: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1759: getfield 174	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1762: aload_0
    //   1763: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1766: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1769: getfield 96	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:f	I
    //   1772: iload 17
    //   1774: iastore
    //   1775: dload_2
    //   1776: dstore 4
    //   1778: dload_2
    //   1779: dstore 6
    //   1781: aload_0
    //   1782: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1785: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1788: getfield 96	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:f	I
    //   1791: aload_0
    //   1792: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1795: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1798: getfield 174	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1801: arraylength
    //   1802: iconst_1
    //   1803: isub
    //   1804: if_icmpge +2815 -> 4619
    //   1807: dload_2
    //   1808: dstore 4
    //   1810: dload_2
    //   1811: dstore 6
    //   1813: aload_0
    //   1814: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1817: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1820: astore 38
    //   1822: dload_2
    //   1823: dstore 4
    //   1825: dload_2
    //   1826: dstore 6
    //   1828: aload 38
    //   1830: aload 38
    //   1832: getfield 96	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:f	I
    //   1835: iconst_1
    //   1836: iadd
    //   1837: putfield 96	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:f	I
    //   1840: goto +2779 -> 4619
    //   1843: dload_2
    //   1844: dstore 4
    //   1846: dload_2
    //   1847: dstore 6
    //   1849: aload_0
    //   1850: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1853: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1856: ifnull +52 -> 1908
    //   1859: aload 37
    //   1861: ifnull +47 -> 1908
    //   1864: dload_2
    //   1865: dstore 4
    //   1867: dload_2
    //   1868: dstore 6
    //   1870: aload_0
    //   1871: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1874: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1877: aload_1
    //   1878: aload 37
    //   1880: getfield 347	awuh:jdField_a_of_type_ArrayOfByte	[B
    //   1883: aload 37
    //   1885: getfield 348	awuh:jdField_a_of_type_Int	I
    //   1888: aload_0
    //   1889: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1892: invokestatic 342	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1895: dload_2
    //   1896: aload_0
    //   1897: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1900: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1903: invokeinterface 351 8 0
    //   1908: aload 37
    //   1910: ifnull +2683 -> 4593
    //   1913: dload_2
    //   1914: dstore 4
    //   1916: dload_2
    //   1917: dstore 6
    //   1919: aload 37
    //   1921: getfield 348	awuh:jdField_a_of_type_Int	I
    //   1924: istore 12
    //   1926: iload 12
    //   1928: i2l
    //   1929: lload 22
    //   1931: ladd
    //   1932: lstore 22
    //   1934: iload 14
    //   1936: istore 16
    //   1938: iload 14
    //   1940: iconst_1
    //   1941: if_icmpne +86 -> 2027
    //   1944: iload 14
    //   1946: istore 16
    //   1948: aload_0
    //   1949: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1952: sipush 500
    //   1955: if_icmple +72 -> 2027
    //   1958: iconst_2
    //   1959: istore 12
    //   1961: aload_0
    //   1962: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1965: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1968: ifnull +16 -> 1984
    //   1971: aload_0
    //   1972: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1975: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   1978: iconst_2
    //   1979: invokeinterface 315 2 0
    //   1984: iload 12
    //   1986: istore 16
    //   1988: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1991: ifeq +36 -> 2027
    //   1994: ldc 46
    //   1996: iconst_2
    //   1997: new 48	java/lang/StringBuilder
    //   2000: dup
    //   2001: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2004: ldc_w 353
    //   2007: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: aload_0
    //   2011: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   2014: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2017: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2020: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2023: iload 12
    //   2025: istore 16
    //   2027: iload 18
    //   2029: iconst_m1
    //   2030: if_icmpeq +16 -> 2046
    //   2033: dload_2
    //   2034: iload 18
    //   2036: i2d
    //   2037: dcmpl
    //   2038: iflt +8 -> 2046
    //   2041: aload_0
    //   2042: iconst_1
    //   2043: putfield 178	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   2046: lload 24
    //   2048: lstore 30
    //   2050: lload 28
    //   2052: lstore 24
    //   2054: iload 11
    //   2056: istore 12
    //   2058: iload 13
    //   2060: istore 11
    //   2062: iload 15
    //   2064: istore 19
    //   2066: goto -1522 -> 544
    //   2069: aload_0
    //   2070: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2073: ifnull +10 -> 2083
    //   2076: aload_0
    //   2077: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2080: invokevirtual 356	java/io/FileOutputStream:flush	()V
    //   2083: aload_0
    //   2084: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2087: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   2090: ifnull +56 -> 2146
    //   2093: aload_0
    //   2094: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2097: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   2100: aload_1
    //   2101: aload_0
    //   2102: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2105: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   2108: dload_2
    //   2109: invokeinterface 359 5 0
    //   2114: aload_0
    //   2115: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2118: getfield 198	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2121: ifnull +25 -> 2146
    //   2124: aload_0
    //   2125: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2128: invokestatic 200	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   2131: iconst_m1
    //   2132: if_icmpeq +14 -> 2146
    //   2135: aload_0
    //   2136: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2139: getfield 198	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2142: iconst_0
    //   2143: invokevirtual 205	android/media/AudioManager:setMode	(I)V
    //   2146: aload_0
    //   2147: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2150: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2153: ifnull +27 -> 2180
    //   2156: aload_0
    //   2157: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2160: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2163: invokevirtual 217	android/media/AudioRecord:getState	()I
    //   2166: iconst_1
    //   2167: if_icmpne +13 -> 2180
    //   2170: aload_0
    //   2171: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2174: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2177: invokevirtual 220	android/media/AudioRecord:stop	()V
    //   2180: aload_0
    //   2181: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2184: ifnull +15 -> 2199
    //   2187: aload_0
    //   2188: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2191: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   2194: aload_0
    //   2195: aconst_null
    //   2196: putfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2199: aload_0
    //   2200: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2203: invokestatic 229	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2206: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2209: ifeq +84 -> 2293
    //   2212: ldc 46
    //   2214: iconst_2
    //   2215: new 48	java/lang/StringBuilder
    //   2218: dup
    //   2219: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2222: ldc 231
    //   2224: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: aload_0
    //   2228: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2231: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2237: ldc 46
    //   2239: iconst_2
    //   2240: new 48	java/lang/StringBuilder
    //   2243: dup
    //   2244: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2247: ldc 233
    //   2249: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: lload 20
    //   2254: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2257: ldc 235
    //   2259: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: lload 24
    //   2264: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2267: ldc 237
    //   2269: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: lload 22
    //   2274: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2277: ldc 239
    //   2279: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: iload 10
    //   2284: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2287: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2290: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2293: aload_0
    //   2294: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2297: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   2300: iconst_0
    //   2301: invokestatic 88	bdaz:a	(Landroid/content/Context;Z)Z
    //   2304: pop
    //   2305: lload 22
    //   2307: ldc2_w 240
    //   2310: lcmp
    //   2311: iflt +11 -> 2322
    //   2314: dload_2
    //   2315: ldc2_w 242
    //   2318: dcmpg
    //   2319: ifge +291 -> 2610
    //   2322: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   2325: lload 34
    //   2327: lsub
    //   2328: ldc2_w 179
    //   2331: lcmp
    //   2332: ifle +278 -> 2610
    //   2335: new 245	java/util/HashMap
    //   2338: dup
    //   2339: invokespecial 246	java/util/HashMap:<init>	()V
    //   2342: astore_1
    //   2343: aload_1
    //   2344: ldc_w 361
    //   2347: ldc_w 363
    //   2350: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2353: pop
    //   2354: aload_1
    //   2355: ldc 248
    //   2357: new 48	java/lang/StringBuilder
    //   2360: dup
    //   2361: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2364: getstatic 253	android/os/Build$VERSION:SDK_INT	I
    //   2367: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2370: ldc 255
    //   2372: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2381: pop
    //   2382: aload_1
    //   2383: ldc_w 261
    //   2386: new 48	java/lang/StringBuilder
    //   2389: dup
    //   2390: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2393: getstatic 266	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2396: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: ldc_w 268
    //   2402: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: getstatic 271	android/os/Build:MODEL	Ljava/lang/String;
    //   2408: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2414: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2417: pop
    //   2418: aload_1
    //   2419: ldc_w 273
    //   2422: new 48	java/lang/StringBuilder
    //   2425: dup
    //   2426: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2429: lload 24
    //   2431: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2434: ldc 255
    //   2436: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2442: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2445: pop
    //   2446: aload_1
    //   2447: ldc_w 282
    //   2450: new 48	java/lang/StringBuilder
    //   2453: dup
    //   2454: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2457: iload 12
    //   2459: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2462: ldc 255
    //   2464: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2467: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2470: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2473: pop
    //   2474: aload_1
    //   2475: ldc_w 365
    //   2478: new 48	java/lang/StringBuilder
    //   2481: dup
    //   2482: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2485: dload_2
    //   2486: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2489: ldc 255
    //   2491: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2497: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2500: pop
    //   2501: aload_1
    //   2502: ldc_w 280
    //   2505: new 48	java/lang/StringBuilder
    //   2508: dup
    //   2509: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2512: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   2515: lload 34
    //   2517: lsub
    //   2518: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2521: ldc 255
    //   2523: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2529: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2532: pop
    //   2533: ldc_w 367
    //   2536: iconst_0
    //   2537: aload_1
    //   2538: invokestatic 295	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2541: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2544: ifeq +66 -> 2610
    //   2547: ldc 46
    //   2549: iconst_2
    //   2550: new 48	java/lang/StringBuilder
    //   2553: dup
    //   2554: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2557: ldc_w 369
    //   2560: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: lload 24
    //   2565: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2568: ldc_w 371
    //   2571: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: lload 22
    //   2576: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2579: ldc_w 373
    //   2582: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: dload_2
    //   2586: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2589: ldc_w 375
    //   2592: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2595: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   2598: lload 34
    //   2600: lsub
    //   2601: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2604: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2607: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2610: new 245	java/util/HashMap
    //   2613: dup
    //   2614: invokespecial 246	java/util/HashMap:<init>	()V
    //   2617: astore_1
    //   2618: aload_1
    //   2619: ldc 248
    //   2621: new 48	java/lang/StringBuilder
    //   2624: dup
    //   2625: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2628: getstatic 253	android/os/Build$VERSION:SDK_INT	I
    //   2631: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2634: ldc 255
    //   2636: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2639: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2642: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2645: pop
    //   2646: aload_1
    //   2647: ldc_w 261
    //   2650: new 48	java/lang/StringBuilder
    //   2653: dup
    //   2654: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2657: getstatic 266	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2660: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: ldc_w 268
    //   2666: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: getstatic 271	android/os/Build:MODEL	Ljava/lang/String;
    //   2672: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2675: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2678: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2681: pop
    //   2682: aload_1
    //   2683: ldc_w 273
    //   2686: new 48	java/lang/StringBuilder
    //   2689: dup
    //   2690: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2693: lload 24
    //   2695: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2698: ldc 255
    //   2700: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2703: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2706: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2709: pop
    //   2710: aload_1
    //   2711: ldc_w 275
    //   2714: new 48	java/lang/StringBuilder
    //   2717: dup
    //   2718: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2721: dload_2
    //   2722: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2725: ldc 255
    //   2727: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2733: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2736: pop
    //   2737: aload_1
    //   2738: ldc_w 280
    //   2741: new 48	java/lang/StringBuilder
    //   2744: dup
    //   2745: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2748: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   2751: lload 34
    //   2753: lsub
    //   2754: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2757: ldc 255
    //   2759: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2765: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2768: pop
    //   2769: aload_1
    //   2770: ldc_w 282
    //   2773: new 48	java/lang/StringBuilder
    //   2776: dup
    //   2777: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2780: iload 12
    //   2782: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2785: ldc 255
    //   2787: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2790: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2793: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2796: pop
    //   2797: aload_1
    //   2798: ldc_w 284
    //   2801: new 48	java/lang/StringBuilder
    //   2804: dup
    //   2805: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2808: aload_0
    //   2809: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   2812: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2815: ldc 255
    //   2817: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2826: pop
    //   2827: lload 26
    //   2829: lconst_0
    //   2830: lcmp
    //   2831: ifne +258 -> 3089
    //   2834: ldc2_w 285
    //   2837: lstore 20
    //   2839: goto +1789 -> 4628
    //   2842: lload 20
    //   2844: l2i
    //   2845: istore 10
    //   2847: aload_1
    //   2848: ldc_w 288
    //   2851: new 48	java/lang/StringBuilder
    //   2854: dup
    //   2855: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2858: iload 11
    //   2860: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2863: ldc 255
    //   2865: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2871: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2874: pop
    //   2875: aload_1
    //   2876: ldc_w 290
    //   2879: new 48	java/lang/StringBuilder
    //   2882: dup
    //   2883: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2886: iload 10
    //   2888: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2891: ldc 255
    //   2893: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2896: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2899: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2902: pop
    //   2903: ldc_w 292
    //   2906: iconst_1
    //   2907: aload_1
    //   2908: invokestatic 295	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2911: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2914: ifeq -1526 -> 1388
    //   2917: new 48	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   2924: astore_1
    //   2925: aload_1
    //   2926: ldc_w 297
    //   2929: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2932: iload 12
    //   2934: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2937: pop
    //   2938: aload_1
    //   2939: ldc_w 299
    //   2942: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2945: iload 11
    //   2947: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2950: pop
    //   2951: aload_1
    //   2952: ldc_w 301
    //   2955: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2958: iload 10
    //   2960: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2963: pop
    //   2964: aload_1
    //   2965: ldc_w 303
    //   2968: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2971: iload 10
    //   2973: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2976: pop
    //   2977: aload_1
    //   2978: ldc_w 305
    //   2981: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2984: lload 24
    //   2986: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2989: pop
    //   2990: aload_1
    //   2991: ldc_w 307
    //   2994: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: lload 22
    //   2999: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3002: pop
    //   3003: aload_1
    //   3004: ldc_w 309
    //   3007: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3010: dload_2
    //   3011: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3014: pop
    //   3015: aload_1
    //   3016: ldc_w 311
    //   3019: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3022: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3025: lload 34
    //   3027: lsub
    //   3028: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3031: pop
    //   3032: ldc 46
    //   3034: iconst_2
    //   3035: aload_1
    //   3036: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3039: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3042: return
    //   3043: astore_1
    //   3044: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3047: ifeq -1659 -> 1388
    //   3050: ldc 46
    //   3052: iconst_2
    //   3053: ldc_w 377
    //   3056: aload_1
    //   3057: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3060: return
    //   3061: astore_1
    //   3062: aload_1
    //   3063: invokevirtual 380	java/lang/Throwable:printStackTrace	()V
    //   3066: goto -860 -> 2206
    //   3069: astore_1
    //   3070: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3073: ifeq -463 -> 2610
    //   3076: ldc 46
    //   3078: iconst_2
    //   3079: ldc_w 382
    //   3082: aload_1
    //   3083: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3086: goto -476 -> 2610
    //   3089: lload 30
    //   3091: lload 26
    //   3093: ldiv
    //   3094: lstore 20
    //   3096: goto +1532 -> 4628
    //   3099: aload_0
    //   3100: getfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   3103: lload 26
    //   3105: ldiv
    //   3106: lstore 20
    //   3108: goto -266 -> 2842
    //   3111: aload 36
    //   3113: instanceof 186
    //   3116: ifeq +979 -> 4095
    //   3119: aload_0
    //   3120: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3123: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   3126: aload_1
    //   3127: aload_0
    //   3128: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3131: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   3134: invokeinterface 384 3 0
    //   3139: goto -2368 -> 771
    //   3142: astore_1
    //   3143: iconst_1
    //   3144: istore 11
    //   3146: lload 24
    //   3148: lstore 28
    //   3150: lload 26
    //   3152: lstore 24
    //   3154: lload 20
    //   3156: lstore 26
    //   3158: lload 22
    //   3160: lstore 20
    //   3162: aload_0
    //   3163: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3166: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3169: ifnull +27 -> 3196
    //   3172: aload_0
    //   3173: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3176: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3179: invokevirtual 217	android/media/AudioRecord:getState	()I
    //   3182: iconst_1
    //   3183: if_icmpne +13 -> 3196
    //   3186: aload_0
    //   3187: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3190: invokestatic 153	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3193: invokevirtual 220	android/media/AudioRecord:stop	()V
    //   3196: aload_0
    //   3197: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3200: ifnull +15 -> 3215
    //   3203: aload_0
    //   3204: getfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3207: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   3210: aload_0
    //   3211: aconst_null
    //   3212: putfield 222	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3215: aload_0
    //   3216: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3219: invokestatic 229	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   3222: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3225: ifeq +84 -> 3309
    //   3228: ldc 46
    //   3230: iconst_2
    //   3231: new 48	java/lang/StringBuilder
    //   3234: dup
    //   3235: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3238: ldc 231
    //   3240: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3243: aload_0
    //   3244: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3247: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3250: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3253: ldc 46
    //   3255: iconst_2
    //   3256: new 48	java/lang/StringBuilder
    //   3259: dup
    //   3260: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3263: ldc 233
    //   3265: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: lload 24
    //   3270: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3273: ldc 235
    //   3275: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3278: lload 28
    //   3280: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3283: ldc 237
    //   3285: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3288: lload 26
    //   3290: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3293: ldc 239
    //   3295: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: iload 10
    //   3300: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3303: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3306: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3309: aload_0
    //   3310: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3313: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   3316: iconst_0
    //   3317: invokestatic 88	bdaz:a	(Landroid/content/Context;Z)Z
    //   3320: pop
    //   3321: lload 26
    //   3323: ldc2_w 240
    //   3326: lcmp
    //   3327: iflt +11 -> 3338
    //   3330: dload_2
    //   3331: ldc2_w 242
    //   3334: dcmpg
    //   3335: ifge +305 -> 3640
    //   3338: iload 11
    //   3340: ifne +300 -> 3640
    //   3343: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3346: lload 34
    //   3348: lsub
    //   3349: ldc2_w 179
    //   3352: lcmp
    //   3353: ifle +287 -> 3640
    //   3356: new 245	java/util/HashMap
    //   3359: dup
    //   3360: invokespecial 246	java/util/HashMap:<init>	()V
    //   3363: astore 36
    //   3365: aload 36
    //   3367: ldc_w 361
    //   3370: ldc_w 363
    //   3373: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3376: pop
    //   3377: aload 36
    //   3379: ldc 248
    //   3381: new 48	java/lang/StringBuilder
    //   3384: dup
    //   3385: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3388: getstatic 253	android/os/Build$VERSION:SDK_INT	I
    //   3391: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3394: ldc 255
    //   3396: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3399: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3402: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3405: pop
    //   3406: aload 36
    //   3408: ldc_w 261
    //   3411: new 48	java/lang/StringBuilder
    //   3414: dup
    //   3415: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3418: getstatic 266	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3421: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: ldc_w 268
    //   3427: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3430: getstatic 271	android/os/Build:MODEL	Ljava/lang/String;
    //   3433: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3439: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3442: pop
    //   3443: aload 36
    //   3445: ldc_w 273
    //   3448: new 48	java/lang/StringBuilder
    //   3451: dup
    //   3452: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3455: lload 28
    //   3457: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3460: ldc 255
    //   3462: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3465: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3468: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3471: pop
    //   3472: aload 36
    //   3474: ldc_w 282
    //   3477: new 48	java/lang/StringBuilder
    //   3480: dup
    //   3481: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3484: iload 12
    //   3486: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3489: ldc 255
    //   3491: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3494: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3497: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3500: pop
    //   3501: aload 36
    //   3503: ldc_w 365
    //   3506: new 48	java/lang/StringBuilder
    //   3509: dup
    //   3510: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3513: dload_2
    //   3514: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3517: ldc 255
    //   3519: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3525: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3528: pop
    //   3529: aload 36
    //   3531: ldc_w 280
    //   3534: new 48	java/lang/StringBuilder
    //   3537: dup
    //   3538: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3541: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3544: lload 34
    //   3546: lsub
    //   3547: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3550: ldc 255
    //   3552: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3555: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3558: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3561: pop
    //   3562: ldc_w 367
    //   3565: iconst_0
    //   3566: aload 36
    //   3568: invokestatic 295	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3571: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3574: ifeq +66 -> 3640
    //   3577: ldc 46
    //   3579: iconst_2
    //   3580: new 48	java/lang/StringBuilder
    //   3583: dup
    //   3584: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3587: ldc_w 369
    //   3590: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3593: lload 28
    //   3595: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3598: ldc_w 371
    //   3601: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3604: lload 26
    //   3606: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3609: ldc_w 373
    //   3612: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: dload_2
    //   3616: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3619: ldc_w 375
    //   3622: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3628: lload 34
    //   3630: lsub
    //   3631: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3634: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3637: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3640: new 245	java/util/HashMap
    //   3643: dup
    //   3644: invokespecial 246	java/util/HashMap:<init>	()V
    //   3647: astore 36
    //   3649: aload 36
    //   3651: ldc 248
    //   3653: new 48	java/lang/StringBuilder
    //   3656: dup
    //   3657: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3660: getstatic 253	android/os/Build$VERSION:SDK_INT	I
    //   3663: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3666: ldc 255
    //   3668: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3671: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3674: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3677: pop
    //   3678: aload 36
    //   3680: ldc_w 261
    //   3683: new 48	java/lang/StringBuilder
    //   3686: dup
    //   3687: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3690: getstatic 266	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3693: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: ldc_w 268
    //   3699: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: getstatic 271	android/os/Build:MODEL	Ljava/lang/String;
    //   3705: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3708: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3711: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3714: pop
    //   3715: aload 36
    //   3717: ldc_w 273
    //   3720: new 48	java/lang/StringBuilder
    //   3723: dup
    //   3724: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3727: lload 28
    //   3729: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3732: ldc 255
    //   3734: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3737: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3740: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3743: pop
    //   3744: aload 36
    //   3746: ldc_w 275
    //   3749: new 48	java/lang/StringBuilder
    //   3752: dup
    //   3753: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3756: dload_2
    //   3757: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3760: ldc 255
    //   3762: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3765: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3771: pop
    //   3772: aload 36
    //   3774: ldc_w 280
    //   3777: new 48	java/lang/StringBuilder
    //   3780: dup
    //   3781: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3784: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3787: lload 34
    //   3789: lsub
    //   3790: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3793: ldc 255
    //   3795: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3798: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3801: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3804: pop
    //   3805: aload 36
    //   3807: ldc_w 282
    //   3810: new 48	java/lang/StringBuilder
    //   3813: dup
    //   3814: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3817: iload 12
    //   3819: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3822: ldc 255
    //   3824: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3827: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3830: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3833: pop
    //   3834: aload 36
    //   3836: ldc_w 284
    //   3839: new 48	java/lang/StringBuilder
    //   3842: dup
    //   3843: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3846: aload_0
    //   3847: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   3850: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3853: ldc 255
    //   3855: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3861: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3864: pop
    //   3865: lload 20
    //   3867: lconst_0
    //   3868: lcmp
    //   3869: ifne +334 -> 4203
    //   3872: ldc2_w 285
    //   3875: lstore 22
    //   3877: goto +771 -> 4648
    //   3880: lload 20
    //   3882: l2i
    //   3883: istore 10
    //   3885: aload 36
    //   3887: ldc_w 288
    //   3890: new 48	java/lang/StringBuilder
    //   3893: dup
    //   3894: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3897: iload 11
    //   3899: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3902: ldc 255
    //   3904: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3907: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3910: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3913: pop
    //   3914: aload 36
    //   3916: ldc_w 290
    //   3919: new 48	java/lang/StringBuilder
    //   3922: dup
    //   3923: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3926: iload 10
    //   3928: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3931: ldc 255
    //   3933: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3936: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3939: invokevirtual 259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3942: pop
    //   3943: ldc_w 292
    //   3946: iconst_1
    //   3947: aload 36
    //   3949: invokestatic 295	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3952: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3955: ifeq +138 -> 4093
    //   3958: new 48	java/lang/StringBuilder
    //   3961: dup
    //   3962: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   3965: astore 36
    //   3967: aload 36
    //   3969: ldc_w 297
    //   3972: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3975: iload 12
    //   3977: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3980: pop
    //   3981: aload 36
    //   3983: ldc_w 299
    //   3986: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3989: iload 11
    //   3991: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3994: pop
    //   3995: aload 36
    //   3997: ldc_w 301
    //   4000: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4003: iload 10
    //   4005: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4008: pop
    //   4009: aload 36
    //   4011: ldc_w 303
    //   4014: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4017: iload 10
    //   4019: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4022: pop
    //   4023: aload 36
    //   4025: ldc_w 305
    //   4028: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4031: lload 28
    //   4033: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4036: pop
    //   4037: aload 36
    //   4039: ldc_w 307
    //   4042: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: lload 26
    //   4047: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4050: pop
    //   4051: aload 36
    //   4053: ldc_w 309
    //   4056: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: dload_2
    //   4060: invokevirtual 278	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   4063: pop
    //   4064: aload 36
    //   4066: ldc_w 311
    //   4069: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4072: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   4075: lload 34
    //   4077: lsub
    //   4078: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4081: pop
    //   4082: ldc 46
    //   4084: iconst_2
    //   4085: aload 36
    //   4087: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4090: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4093: aload_1
    //   4094: athrow
    //   4095: aload_0
    //   4096: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   4099: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lbdhu;
    //   4102: aload_1
    //   4103: aload_0
    //   4104: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   4107: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   4110: aload 36
    //   4112: invokevirtual 387	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   4115: invokeinterface 390 4 0
    //   4120: goto -3349 -> 771
    //   4123: astore_1
    //   4124: aload_1
    //   4125: invokevirtual 380	java/lang/Throwable:printStackTrace	()V
    //   4128: goto -3288 -> 840
    //   4131: lload 30
    //   4133: lload 22
    //   4135: ldiv
    //   4136: lstore 26
    //   4138: goto +461 -> 4599
    //   4141: aload_0
    //   4142: getfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   4145: lload 22
    //   4147: ldiv
    //   4148: lstore 22
    //   4150: goto -2962 -> 1188
    //   4153: astore_1
    //   4154: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4157: ifeq -2769 -> 1388
    //   4160: ldc 46
    //   4162: iconst_2
    //   4163: ldc_w 377
    //   4166: aload_1
    //   4167: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4170: return
    //   4171: astore 36
    //   4173: aload 36
    //   4175: invokevirtual 380	java/lang/Throwable:printStackTrace	()V
    //   4178: goto -956 -> 3222
    //   4181: astore 36
    //   4183: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4186: ifeq -546 -> 3640
    //   4189: ldc 46
    //   4191: iconst_2
    //   4192: ldc_w 382
    //   4195: aload 36
    //   4197: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4200: goto -560 -> 3640
    //   4203: lload 30
    //   4205: lload 20
    //   4207: ldiv
    //   4208: lstore 22
    //   4210: goto +438 -> 4648
    //   4213: aload_0
    //   4214: getfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   4217: lload 20
    //   4219: ldiv
    //   4220: lstore 20
    //   4222: goto -342 -> 3880
    //   4225: astore 36
    //   4227: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4230: ifeq -137 -> 4093
    //   4233: ldc 46
    //   4235: iconst_2
    //   4236: ldc_w 377
    //   4239: aload 36
    //   4241: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4244: goto -151 -> 4093
    //   4247: astore_1
    //   4248: iconst_0
    //   4249: istore 10
    //   4251: lconst_0
    //   4252: lstore 32
    //   4254: lconst_0
    //   4255: lstore 26
    //   4257: iconst_0
    //   4258: istore 11
    //   4260: iload 13
    //   4262: istore 12
    //   4264: lload 22
    //   4266: lstore 20
    //   4268: lload 28
    //   4270: lstore 24
    //   4272: lload 32
    //   4274: lstore 28
    //   4276: goto -1114 -> 3162
    //   4279: astore_1
    //   4280: lload 24
    //   4282: lstore 28
    //   4284: lload 20
    //   4286: lstore 24
    //   4288: lload 26
    //   4290: lstore 20
    //   4292: iconst_0
    //   4293: istore 11
    //   4295: lload 22
    //   4297: lstore 26
    //   4299: goto -1137 -> 3162
    //   4302: astore_1
    //   4303: lload 24
    //   4305: lstore 28
    //   4307: lload 20
    //   4309: lstore 24
    //   4311: lload 26
    //   4313: lstore 20
    //   4315: iconst_0
    //   4316: istore 11
    //   4318: lload 22
    //   4320: lstore 26
    //   4322: goto -1160 -> 3162
    //   4325: astore_1
    //   4326: iload 15
    //   4328: istore 10
    //   4330: lload 24
    //   4332: lstore 28
    //   4334: lload 20
    //   4336: lstore 24
    //   4338: lload 26
    //   4340: lstore 20
    //   4342: iconst_0
    //   4343: istore 11
    //   4345: lload 22
    //   4347: lstore 26
    //   4349: goto -1187 -> 3162
    //   4352: astore_1
    //   4353: iconst_0
    //   4354: istore 11
    //   4356: lload 20
    //   4358: lstore 24
    //   4360: lload 26
    //   4362: lstore 20
    //   4364: lload 22
    //   4366: lstore 26
    //   4368: goto -1206 -> 3162
    //   4371: astore_1
    //   4372: lload 24
    //   4374: lstore 30
    //   4376: iconst_0
    //   4377: istore 13
    //   4379: dload 4
    //   4381: dstore_2
    //   4382: lload 20
    //   4384: lstore 24
    //   4386: iload 11
    //   4388: istore 12
    //   4390: iload 13
    //   4392: istore 11
    //   4394: lload 26
    //   4396: lstore 20
    //   4398: lload 22
    //   4400: lstore 26
    //   4402: goto -1240 -> 3162
    //   4405: astore_1
    //   4406: iconst_0
    //   4407: istore 13
    //   4409: lload 24
    //   4411: lstore 30
    //   4413: lload 20
    //   4415: lstore 24
    //   4417: iload 11
    //   4419: istore 12
    //   4421: iload 13
    //   4423: istore 11
    //   4425: lload 26
    //   4427: lstore 20
    //   4429: lload 22
    //   4431: lstore 26
    //   4433: goto -1271 -> 3162
    //   4436: astore 36
    //   4438: iload 15
    //   4440: istore 12
    //   4442: iload 14
    //   4444: istore 10
    //   4446: lload 28
    //   4448: lstore 26
    //   4450: goto -3773 -> 677
    //   4453: astore 36
    //   4455: lload 20
    //   4457: lstore 28
    //   4459: lload 22
    //   4461: lstore 20
    //   4463: lload 26
    //   4465: lstore 22
    //   4467: lload 28
    //   4469: lstore 26
    //   4471: goto -3794 -> 677
    //   4474: astore 36
    //   4476: lload 20
    //   4478: lstore 28
    //   4480: lload 22
    //   4482: lstore 20
    //   4484: iload 15
    //   4486: istore 10
    //   4488: lload 26
    //   4490: lstore 22
    //   4492: lload 28
    //   4494: lstore 26
    //   4496: goto -3819 -> 677
    //   4499: astore 36
    //   4501: lload 28
    //   4503: lstore 24
    //   4505: lload 20
    //   4507: lstore 28
    //   4509: lload 22
    //   4511: lstore 20
    //   4513: lload 26
    //   4515: lstore 22
    //   4517: lload 28
    //   4519: lstore 26
    //   4521: goto -3844 -> 677
    //   4524: astore 36
    //   4526: lload 24
    //   4528: lstore 30
    //   4530: dload 6
    //   4532: dstore_2
    //   4533: lload 28
    //   4535: lstore 24
    //   4537: lload 26
    //   4539: lstore 28
    //   4541: lload 20
    //   4543: lstore 26
    //   4545: iload 11
    //   4547: istore 12
    //   4549: lload 22
    //   4551: lstore 20
    //   4553: lload 28
    //   4555: lstore 22
    //   4557: goto -3880 -> 677
    //   4560: astore 36
    //   4562: lload 24
    //   4564: lstore 30
    //   4566: lload 26
    //   4568: lstore 24
    //   4570: lload 20
    //   4572: lstore 26
    //   4574: iload 11
    //   4576: istore 12
    //   4578: lload 22
    //   4580: lstore 20
    //   4582: lload 24
    //   4584: lstore 22
    //   4586: lload 28
    //   4588: lstore 24
    //   4590: goto -3913 -> 677
    //   4593: goto -2659 -> 1934
    //   4596: goto -2753 -> 1843
    //   4599: lload 26
    //   4601: l2i
    //   4602: istore 11
    //   4604: lload 22
    //   4606: lconst_0
    //   4607: lcmp
    //   4608: ifne -467 -> 4141
    //   4611: ldc2_w 285
    //   4614: lstore 22
    //   4616: goto -3428 -> 1188
    //   4619: iconst_0
    //   4620: istore 15
    //   4622: iconst_0
    //   4623: istore 17
    //   4625: goto -2782 -> 1843
    //   4628: lload 20
    //   4630: l2i
    //   4631: istore 11
    //   4633: lload 26
    //   4635: lconst_0
    //   4636: lcmp
    //   4637: ifne -1538 -> 3099
    //   4640: ldc2_w 285
    //   4643: lstore 20
    //   4645: goto -1803 -> 2842
    //   4648: lload 22
    //   4650: l2i
    //   4651: istore 11
    //   4653: lload 20
    //   4655: lconst_0
    //   4656: lcmp
    //   4657: ifne -444 -> 4213
    //   4660: ldc2_w 285
    //   4663: lstore 20
    //   4665: goto -785 -> 3880
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4668	0	this	RecordThread
    //   0	4668	1	paramString	String
    //   41	4492	2	d1	double
    //   1631	2749	4	d2	double
    //   1634	2897	6	d3	double
    //   1684	8	8	d4	double
    //   77	4410	10	i	int
    //   187	4465	11	j	int
    //   69	4508	12	k	int
    //   66	4356	13	m	int
    //   38	4405	14	n	int
    //   63	4558	15	i1	int
    //   291	1735	16	i2	int
    //   49	4575	17	i3	int
    //   43	1992	18	i4	int
    //   52	2013	19	i5	int
    //   60	4604	20	l1	long
    //   46	4603	22	l2	long
    //   35	4554	24	l3	long
    //   534	4100	26	l4	long
    //   32	4555	28	l5	long
    //   72	4493	30	l6	long
    //   519	3754	32	l7	long
    //   57	4019	34	l8	long
    //   156	186	36	arrayOfByte	byte[]
    //   651	2461	36	localThrowable1	java.lang.Throwable
    //   3363	748	36	localObject	java.lang.Object
    //   4171	3	36	localThrowable2	java.lang.Throwable
    //   4181	15	36	localException1	java.lang.Exception
    //   4225	15	36	localException2	java.lang.Exception
    //   4436	1	36	localThrowable3	java.lang.Throwable
    //   4453	1	36	localThrowable4	java.lang.Throwable
    //   4474	1	36	localThrowable5	java.lang.Throwable
    //   4499	1	36	localThrowable6	java.lang.Throwable
    //   4524	1	36	localThrowable7	java.lang.Throwable
    //   4560	1	36	localThrowable8	java.lang.Throwable
    //   1651	269	37	localawuh	awuh
    //   1820	11	38	localRecorderParam	QQRecorder.RecorderParam
    // Exception table:
    //   from	to	target	type
    //   544	558	651	java/lang/Throwable
    //   562	575	651	java/lang/Throwable
    //   599	641	651	java/lang/Throwable
    //   641	651	651	java/lang/Throwable
    //   1393	1406	651	java/lang/Throwable
    //   1415	1450	651	java/lang/Throwable
    //   1450	1467	651	java/lang/Throwable
    //   1474	1498	651	java/lang/Throwable
    //   2069	2083	651	java/lang/Throwable
    //   2083	2146	651	java/lang/Throwable
    //   2610	2827	3043	java/lang/Exception
    //   2847	3042	3043	java/lang/Exception
    //   3089	3096	3043	java/lang/Exception
    //   3099	3108	3043	java/lang/Exception
    //   2180	2199	3061	java/lang/Throwable
    //   2199	2206	3061	java/lang/Throwable
    //   2335	2610	3069	java/lang/Exception
    //   677	693	3142	finally
    //   693	735	3142	finally
    //   735	751	3142	finally
    //   751	771	3142	finally
    //   771	780	3142	finally
    //   3111	3139	3142	finally
    //   4095	4120	3142	finally
    //   814	833	4123	java/lang/Throwable
    //   833	840	4123	java/lang/Throwable
    //   956	1173	4153	java/lang/Exception
    //   1193	1388	4153	java/lang/Exception
    //   4131	4138	4153	java/lang/Exception
    //   4141	4150	4153	java/lang/Exception
    //   3196	3215	4171	java/lang/Throwable
    //   3215	3222	4171	java/lang/Throwable
    //   3356	3640	4181	java/lang/Exception
    //   3640	3865	4225	java/lang/Exception
    //   3885	4093	4225	java/lang/Exception
    //   4203	4210	4225	java/lang/Exception
    //   4213	4222	4225	java/lang/Exception
    //   117	147	4247	finally
    //   147	165	4247	finally
    //   165	189	4247	finally
    //   203	210	4247	finally
    //   210	247	4247	finally
    //   247	293	4247	finally
    //   303	312	4247	finally
    //   312	327	4247	finally
    //   334	350	4247	finally
    //   360	402	4247	finally
    //   402	448	4247	finally
    //   465	479	4247	finally
    //   479	516	4247	finally
    //   516	521	4247	finally
    //   544	558	4279	finally
    //   562	575	4279	finally
    //   599	641	4279	finally
    //   641	651	4279	finally
    //   1393	1406	4279	finally
    //   1415	1450	4279	finally
    //   1450	1467	4279	finally
    //   1474	1498	4279	finally
    //   2069	2083	4279	finally
    //   2083	2146	4279	finally
    //   1508	1530	4302	finally
    //   1562	1581	4302	finally
    //   1535	1541	4325	finally
    //   1595	1622	4352	finally
    //   1636	1653	4371	finally
    //   1659	1662	4371	finally
    //   1668	1686	4371	finally
    //   1706	1720	4371	finally
    //   1733	1746	4371	finally
    //   1752	1775	4371	finally
    //   1781	1807	4371	finally
    //   1813	1822	4371	finally
    //   1828	1840	4371	finally
    //   1849	1859	4371	finally
    //   1870	1908	4371	finally
    //   1919	1926	4371	finally
    //   1948	1958	4405	finally
    //   1961	1984	4405	finally
    //   1988	2023	4405	finally
    //   2041	2046	4405	finally
    //   117	147	4436	java/lang/Throwable
    //   147	165	4436	java/lang/Throwable
    //   165	189	4436	java/lang/Throwable
    //   203	210	4436	java/lang/Throwable
    //   210	247	4436	java/lang/Throwable
    //   247	293	4436	java/lang/Throwable
    //   303	312	4436	java/lang/Throwable
    //   312	327	4436	java/lang/Throwable
    //   334	350	4436	java/lang/Throwable
    //   360	402	4436	java/lang/Throwable
    //   402	448	4436	java/lang/Throwable
    //   465	479	4436	java/lang/Throwable
    //   479	516	4436	java/lang/Throwable
    //   516	521	4436	java/lang/Throwable
    //   1508	1530	4453	java/lang/Throwable
    //   1562	1581	4453	java/lang/Throwable
    //   1535	1541	4474	java/lang/Throwable
    //   1595	1622	4499	java/lang/Throwable
    //   1636	1653	4524	java/lang/Throwable
    //   1659	1662	4524	java/lang/Throwable
    //   1668	1686	4524	java/lang/Throwable
    //   1706	1720	4524	java/lang/Throwable
    //   1733	1746	4524	java/lang/Throwable
    //   1752	1775	4524	java/lang/Throwable
    //   1781	1807	4524	java/lang/Throwable
    //   1813	1822	4524	java/lang/Throwable
    //   1828	1840	4524	java/lang/Throwable
    //   1849	1859	4524	java/lang/Throwable
    //   1870	1908	4524	java/lang/Throwable
    //   1919	1926	4524	java/lang/Throwable
    //   1948	1958	4560	java/lang/Throwable
    //   1961	1984	4560	java/lang/Throwable
    //   1988	2023	4560	java/lang/Throwable
    //   2041	2046	4560	java/lang/Throwable
  }
  
  public void a()
  {
    if (QQRecorder.a(this.this$0) != null)
    {
      this.jdField_a_of_type_JavaIoFile = new File(QQRecorder.a(this.this$0));
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaIoFile.getAbsoluteFile());
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public void a(awug paramawug, awuh paramawuh)
  {
    if (((paramawug instanceof WechatNsWrapper)) && (QQRecorder.a(this.this$0) != null)) {
      QQRecorder.a(this.this$0).b(paramawug, paramawuh);
    }
  }
  
  public boolean a()
  {
    return (this.b) || (QQRecorder.a(this.this$0) != null);
  }
  
  public void b()
  {
    if (QQRecorder.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "releaseRecorder");
      }
      QQRecorder.a(this.this$0).release();
      QQRecorder.a(this.this$0, null);
    }
  }
  
  public void b(awug paramawug, awuh paramawuh)
  {
    if ((paramawug instanceof WechatNsWrapper))
    {
      QQRecorder.b(this.this$0, (int)AudioHelper.a(QQRecorder.a(this.this$0), paramawuh.jdField_a_of_type_ArrayOfByte, paramawuh.jdField_a_of_type_Int, 1.0F));
      this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, QQRecorder.c(this.this$0));
      this.jdField_a_of_type_Long += QQRecorder.c(this.this$0);
      if (QQRecorder.a(this.this$0) != null) {
        QQRecorder.a(this.this$0).a(paramawug, paramawuh);
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   4: ifeq +116 -> 120
    //   7: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 46
    //   15: iconst_2
    //   16: ldc_w 442
    //   19: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 26	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 178	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 168	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 444	com/tencent/mobileqq/utils/QQRecorder$RecordThread:a	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   44: ifeq -44 -> 0
    //   47: invokestatic 125	android/os/SystemClock:uptimeMillis	()J
    //   50: lstore_1
    //   51: aload_0
    //   52: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   55: astore_3
    //   56: aload_3
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   62: getstatic 445	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   65: i2l
    //   66: invokevirtual 450	java/lang/Object:wait	(J)V
    //   69: aload_3
    //   70: monitorexit
    //   71: invokestatic 125	android/os/SystemClock:uptimeMillis	()J
    //   74: lload_1
    //   75: lsub
    //   76: getstatic 445	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   79: i2l
    //   80: lcmp
    //   81: iflt -81 -> 0
    //   84: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: ldc 46
    //   92: iconst_2
    //   93: ldc_w 452
    //   96: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_0
    //   109: invokevirtual 453	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	()V
    //   112: goto -112 -> 0
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 454	java/lang/InterruptedException:printStackTrace	()V
    //   120: aload_0
    //   121: invokevirtual 453	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	()V
    //   124: return
    //   125: astore 4
    //   127: aload_3
    //   128: monitorexit
    //   129: aload 4
    //   131: athrow
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	RecordThread
    //   50	25	1	l	long
    //   115	13	3	localInterruptedException	java.lang.InterruptedException
    //   132	4	3	localObject1	java.lang.Object
    //   125	5	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   47	58	115	java/lang/InterruptedException
    //   71	99	115	java/lang/InterruptedException
    //   99	101	115	java/lang/InterruptedException
    //   108	112	115	java/lang/InterruptedException
    //   129	132	115	java/lang/InterruptedException
    //   135	137	115	java/lang/InterruptedException
    //   58	71	125	finally
    //   127	129	125	finally
    //   101	108	132	finally
    //   133	135	132	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */