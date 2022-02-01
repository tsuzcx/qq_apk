package com.tencent.mobileqq.utils;

import android.media.AudioRecord;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class QQRecorder$RecordThread
  extends Thread
  implements IAudioProcessorListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  File jdField_a_of_type_JavaIoFile;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public String a;
  public volatile boolean a;
  public volatile boolean b = true;
  private boolean c = false;
  
  QQRecorder$RecordThread(QQRecorder paramQQRecorder)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 50
    //   8: iconst_2
    //   9: new 52	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   16: ldc 55
    //   18: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   54: invokestatic 76	java/lang/System:currentTimeMillis	()J
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
    //   81: invokestatic 82	android/os/Process:setThreadPriority	(I)V
    //   84: aload_0
    //   85: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   88: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   91: iconst_1
    //   92: invokestatic 92	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   100: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   103: ifnull +14 -> 117
    //   106: aload_0
    //   107: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   110: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   113: iconst_0
    //   114: putfield 100	com/tencent/mobileqq/utils/RecordParams$RecorderParam:f	I
    //   117: aload_0
    //   118: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   121: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   124: ifnull +23 -> 147
    //   127: aload_0
    //   128: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   131: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   139: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   142: invokeinterface 109 3 0
    //   147: aload_0
    //   148: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   151: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   154: newarray byte
    //   156: astore 36
    //   158: aload_0
    //   159: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   162: invokestatic 114	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   165: aload_0
    //   166: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   169: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   172: ifnull +38 -> 210
    //   175: aload_0
    //   176: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   179: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   182: invokeinterface 118 1 0
    //   187: istore 11
    //   189: iload 11
    //   191: istore 10
    //   193: iload 11
    //   195: ifgt +8 -> 203
    //   198: sipush 250
    //   201: istore 10
    //   203: iload 10
    //   205: invokestatic 121	com/tencent/mobileqq/utils/QQRecorder:a	(I)I
    //   208: istore 10
    //   210: invokestatic 124	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   213: ifeq +34 -> 247
    //   216: ldc 50
    //   218: iconst_4
    //   219: new 52	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   226: ldc 126
    //   228: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   234: getstatic 136	com/tencent/mobileqq/transfile/PttInfoCollector:sCostUntilPrepare	J
    //   237: lsub
    //   238: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   251: invokestatic 141	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   254: aload_0
    //   255: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   258: invokestatic 144	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   261: aload_0
    //   262: invokevirtual 149	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessorListener;)V
    //   265: ldc2_w 150
    //   268: invokestatic 155	java/lang/Thread:sleep	(J)V
    //   271: aload_0
    //   272: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   275: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   278: getfield 156	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_Int	I
    //   281: invokestatic 158	com/tencent/mobileqq/utils/QQRecorder:c	(I)I
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
    //   307: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   310: istore 11
    //   312: aload_0
    //   313: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   316: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
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
    //   338: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   341: aload 36
    //   343: iconst_0
    //   344: iload 11
    //   346: invokevirtual 167	android/media/AudioRecord:read	([BII)I
    //   349: pop
    //   350: iload 11
    //   352: iload 10
    //   354: iadd
    //   355: istore 10
    //   357: goto -61 -> 296
    //   360: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +39 -> 402
    //   366: ldc 50
    //   368: iconst_2
    //   369: new 52	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   376: ldc 169
    //   378: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: iload 10
    //   383: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: ldc 174
    //   388: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload 16
    //   393: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   406: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   409: ifnull +70 -> 479
    //   412: aload_0
    //   413: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   416: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   419: aload_0
    //   420: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aload_0
    //   424: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   427: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   430: invokeinterface 178 3 0
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
    //   469: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   472: iload 10
    //   474: newarray int
    //   476: putfield 181	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   479: invokestatic 124	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   482: ifeq +34 -> 516
    //   485: ldc 50
    //   487: iconst_4
    //   488: new 52	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   495: ldc 183
    //   497: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   503: getstatic 136	com/tencent/mobileqq/transfile/PttInfoCollector:sCostUntilPrepare	J
    //   506: lsub
    //   507: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: invokestatic 76	java/lang/System:currentTimeMillis	()J
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
    //   548: ifeq +1529 -> 2077
    //   551: aload_0
    //   552: getfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   555: ifne +1522 -> 2077
    //   558: iload 11
    //   560: istore 13
    //   562: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   565: lload 32
    //   567: lsub
    //   568: ldc2_w 184
    //   571: lcmp
    //   572: ifle +825 -> 1397
    //   575: iload 11
    //   577: istore 13
    //   579: iload 11
    //   581: ifne +816 -> 1397
    //   584: iconst_1
    //   585: istore 13
    //   587: lload 24
    //   589: lconst_0
    //   590: lcmp
    //   591: ifeq +8 -> 599
    //   594: iload 12
    //   596: ifne +801 -> 1397
    //   599: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +39 -> 641
    //   605: ldc 50
    //   607: iconst_2
    //   608: new 52	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   615: ldc 187
    //   617: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: lload 24
    //   622: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: ldc 189
    //   627: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload 12
    //   632: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: new 191	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
    //   644: dup
    //   645: ldc 193
    //   647: invokespecial 195	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
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
    //   677: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +13 -> 693
    //   683: ldc 50
    //   685: iconst_2
    //   686: ldc 197
    //   688: aload 36
    //   690: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   693: aload_0
    //   694: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   697: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   700: ifnull +71 -> 771
    //   703: aload_0
    //   704: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   707: getfield 203	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   710: ifnull +25 -> 735
    //   713: aload_0
    //   714: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   717: invokestatic 205	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   720: iconst_m1
    //   721: if_icmpeq +14 -> 735
    //   724: aload_0
    //   725: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   728: getfield 203	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   731: iconst_0
    //   732: invokevirtual 210	android/media/AudioManager:setMode	(I)V
    //   735: aload 36
    //   737: instanceof 212
    //   740: ifne +11 -> 751
    //   743: aload 36
    //   745: instanceof 214
    //   748: ifeq +2384 -> 3132
    //   751: aload_0
    //   752: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   755: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   758: aload_1
    //   759: aload_0
    //   760: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   763: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   766: invokeinterface 217 3 0
    //   771: aload_0
    //   772: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   775: aload 36
    //   777: invokevirtual 220	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   780: aload_0
    //   781: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   784: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   787: ifnull +27 -> 814
    //   790: aload_0
    //   791: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   794: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   797: invokevirtual 223	android/media/AudioRecord:getState	()I
    //   800: iconst_1
    //   801: if_icmpne +13 -> 814
    //   804: aload_0
    //   805: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   808: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   811: invokevirtual 226	android/media/AudioRecord:stop	()V
    //   814: aload_0
    //   815: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   818: ifnull +15 -> 833
    //   821: aload_0
    //   822: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   825: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   828: aload_0
    //   829: aconst_null
    //   830: putfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   833: aload_0
    //   834: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   837: invokestatic 235	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   840: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +84 -> 927
    //   846: ldc 50
    //   848: iconst_2
    //   849: new 52	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   856: ldc 237
    //   858: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_0
    //   862: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: ldc 50
    //   873: iconst_2
    //   874: new 52	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   881: ldc 239
    //   883: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: lload 26
    //   888: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   891: ldc 241
    //   893: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: lload 24
    //   898: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   901: ldc 243
    //   903: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: lload 20
    //   908: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   911: ldc 245
    //   913: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: iload 10
    //   918: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload_0
    //   928: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   931: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   934: iconst_0
    //   935: invokestatic 92	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   938: pop
    //   939: lload 20
    //   941: ldc2_w 246
    //   944: lcmp
    //   945: iflt +11 -> 956
    //   948: dload_2
    //   949: ldc2_w 248
    //   952: dcmpg
    //   953: ifge +3 -> 956
    //   956: new 251	java/util/HashMap
    //   959: dup
    //   960: invokespecial 252	java/util/HashMap:<init>	()V
    //   963: astore_1
    //   964: aload_1
    //   965: ldc 254
    //   967: new 52	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   974: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   977: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   980: ldc_w 261
    //   983: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   992: pop
    //   993: aload_1
    //   994: ldc_w 267
    //   997: new 52	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1004: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1007: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: ldc_w 274
    //   1013: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: getstatic 277	android/os/Build:MODEL	Ljava/lang/String;
    //   1019: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1028: pop
    //   1029: aload_1
    //   1030: ldc_w 279
    //   1033: new 52	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1040: lload 24
    //   1042: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: ldc_w 261
    //   1048: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: pop
    //   1058: aload_1
    //   1059: ldc_w 281
    //   1062: new 52	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1069: dload_2
    //   1070: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1073: ldc_w 261
    //   1076: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: pop
    //   1086: aload_1
    //   1087: ldc_w 286
    //   1090: new 52	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1097: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   1100: lload 34
    //   1102: lsub
    //   1103: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1106: ldc_w 261
    //   1109: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1118: pop
    //   1119: aload_1
    //   1120: ldc_w 288
    //   1123: new 52	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1130: iload 12
    //   1132: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1135: ldc_w 261
    //   1138: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1147: pop
    //   1148: aload_1
    //   1149: ldc_w 290
    //   1152: new 52	java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1159: aload_0
    //   1160: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1163: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc_w 261
    //   1169: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1178: pop
    //   1179: lload 22
    //   1181: lconst_0
    //   1182: lcmp
    //   1183: ifne +2982 -> 4165
    //   1186: ldc2_w 291
    //   1189: lstore 26
    //   1191: goto +3442 -> 4633
    //   1194: lload 22
    //   1196: l2i
    //   1197: istore 10
    //   1199: aload_1
    //   1200: ldc_w 294
    //   1203: new 52	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1210: iload 11
    //   1212: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1215: ldc_w 261
    //   1218: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1227: pop
    //   1228: aload_1
    //   1229: ldc_w 296
    //   1232: new 52	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1239: iload 10
    //   1241: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 261
    //   1247: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1256: pop
    //   1257: ldc_w 298
    //   1260: iconst_1
    //   1261: aload_1
    //   1262: invokestatic 301	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1265: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1268: ifeq +128 -> 1396
    //   1271: new 52	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1278: astore_1
    //   1279: aload_1
    //   1280: ldc_w 303
    //   1283: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: iload 12
    //   1288: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload_1
    //   1293: ldc_w 305
    //   1296: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: iload 11
    //   1301: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_1
    //   1306: ldc_w 307
    //   1309: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: iload 10
    //   1314: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload_1
    //   1319: ldc_w 309
    //   1322: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: iload 10
    //   1327: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: aload_1
    //   1332: ldc_w 311
    //   1335: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: lload 24
    //   1340: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload_1
    //   1345: ldc_w 313
    //   1348: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: lload 20
    //   1353: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload_1
    //   1358: ldc_w 315
    //   1361: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: dload_2
    //   1365: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload_1
    //   1370: ldc_w 317
    //   1373: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   1379: lload 34
    //   1381: lsub
    //   1382: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: ldc 50
    //   1388: iconst_2
    //   1389: aload_1
    //   1390: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1396: return
    //   1397: iload 16
    //   1399: istore 14
    //   1401: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   1404: lload 32
    //   1406: lsub
    //   1407: ldc2_w 184
    //   1410: lcmp
    //   1411: ifle +99 -> 1510
    //   1414: iload 16
    //   1416: istore 14
    //   1418: iload 16
    //   1420: ifne +90 -> 1510
    //   1423: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1426: ifeq +32 -> 1458
    //   1429: ldc 50
    //   1431: iconst_2
    //   1432: new 52	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1439: ldc_w 319
    //   1442: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: aload_0
    //   1446: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1449: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1458: aload_0
    //   1459: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1462: ifle +102 -> 1564
    //   1465: aload_0
    //   1466: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1469: sipush 500
    //   1472: if_icmpge +92 -> 1564
    //   1475: iconst_1
    //   1476: istore 11
    //   1478: iload 11
    //   1480: istore 14
    //   1482: aload_0
    //   1483: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1486: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1489: ifnull +21 -> 1510
    //   1492: aload_0
    //   1493: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1496: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1499: iload 11
    //   1501: invokeinterface 322 2 0
    //   1506: iload 11
    //   1508: istore 14
    //   1510: lload 20
    //   1512: lconst_1
    //   1513: ladd
    //   1514: lstore 20
    //   1516: aload_0
    //   1517: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1520: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1523: aload 36
    //   1525: iconst_0
    //   1526: aload_0
    //   1527: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1530: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1533: invokevirtual 167	android/media/AudioRecord:read	([BII)I
    //   1536: istore 15
    //   1538: iload 15
    //   1540: ifgt +30 -> 1570
    //   1543: ldc2_w 323
    //   1546: invokestatic 155	java/lang/Thread:sleep	(J)V
    //   1549: iload 13
    //   1551: istore 11
    //   1553: iload 15
    //   1555: istore 10
    //   1557: iload 14
    //   1559: istore 16
    //   1561: goto -1017 -> 544
    //   1564: iconst_2
    //   1565: istore 11
    //   1567: goto -89 -> 1478
    //   1570: aload_0
    //   1571: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   1574: ifnull +15 -> 1589
    //   1577: aload_0
    //   1578: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   1581: aload 36
    //   1583: iconst_0
    //   1584: iload 15
    //   1586: invokevirtual 328	java/io/FileOutputStream:write	([BII)V
    //   1589: lconst_1
    //   1590: lload 26
    //   1592: ladd
    //   1593: lstore 26
    //   1595: lload 24
    //   1597: iload 15
    //   1599: i2l
    //   1600: ladd
    //   1601: lstore 28
    //   1603: aload_0
    //   1604: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1607: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1610: aload 36
    //   1612: iload 15
    //   1614: fconst_1
    //   1615: invokestatic 333	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1618: l2i
    //   1619: istore 16
    //   1621: iload 12
    //   1623: iload 16
    //   1625: invokestatic 339	java/lang/Math:max	(II)I
    //   1628: istore 11
    //   1630: lload 30
    //   1632: iload 16
    //   1634: i2l
    //   1635: ladd
    //   1636: lstore 24
    //   1638: dload_2
    //   1639: dstore 4
    //   1641: dload_2
    //   1642: dstore 6
    //   1644: aload_0
    //   1645: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1648: invokestatic 144	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   1651: aload 36
    //   1653: iconst_0
    //   1654: iload 15
    //   1656: invokevirtual 342	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	([BII)Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData;
    //   1659: astore 37
    //   1661: dload_2
    //   1662: dstore 4
    //   1664: dload_2
    //   1665: dstore 6
    //   1667: invokestatic 345	com/tencent/mobileqq/transfile/PttInfoCollector:noteOneFrameProcessed	()V
    //   1670: dload_2
    //   1671: dstore 4
    //   1673: dload_2
    //   1674: dstore 6
    //   1676: iload 15
    //   1678: i2l
    //   1679: aload_0
    //   1680: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1683: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1686: getfield 156	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_Int	I
    //   1689: invokestatic 348	com/tencent/mobileqq/utils/QQRecorder:a	(JI)D
    //   1692: dstore 8
    //   1694: dload_2
    //   1695: dload 8
    //   1697: dadd
    //   1698: dstore_2
    //   1699: dload 8
    //   1701: iload 19
    //   1703: i2d
    //   1704: dadd
    //   1705: d2i
    //   1706: istore 15
    //   1708: dload_2
    //   1709: dstore 4
    //   1711: dload_2
    //   1712: dstore 6
    //   1714: aload_0
    //   1715: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1718: invokestatic 350	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1721: iload 17
    //   1723: invokestatic 339	java/lang/Math:max	(II)I
    //   1726: istore 17
    //   1728: iload 15
    //   1730: bipush 100
    //   1732: if_icmplt +2898 -> 4630
    //   1735: dload_2
    //   1736: dstore 4
    //   1738: dload_2
    //   1739: dstore 6
    //   1741: aload_0
    //   1742: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1745: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1748: getfield 181	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1751: ifnull +2902 -> 4653
    //   1754: dload_2
    //   1755: dstore 4
    //   1757: dload_2
    //   1758: dstore 6
    //   1760: aload_0
    //   1761: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1764: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1767: getfield 181	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1770: aload_0
    //   1771: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1774: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1777: getfield 100	com/tencent/mobileqq/utils/RecordParams$RecorderParam:f	I
    //   1780: iload 17
    //   1782: iastore
    //   1783: dload_2
    //   1784: dstore 4
    //   1786: dload_2
    //   1787: dstore 6
    //   1789: aload_0
    //   1790: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1793: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1796: getfield 100	com/tencent/mobileqq/utils/RecordParams$RecorderParam:f	I
    //   1799: aload_0
    //   1800: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1803: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1806: getfield 181	com/tencent/mobileqq/utils/RecordParams$RecorderParam:jdField_a_of_type_ArrayOfInt	[I
    //   1809: arraylength
    //   1810: iconst_1
    //   1811: isub
    //   1812: if_icmpge +2841 -> 4653
    //   1815: dload_2
    //   1816: dstore 4
    //   1818: dload_2
    //   1819: dstore 6
    //   1821: aload_0
    //   1822: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1825: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1828: astore 38
    //   1830: dload_2
    //   1831: dstore 4
    //   1833: dload_2
    //   1834: dstore 6
    //   1836: aload 38
    //   1838: aload 38
    //   1840: getfield 100	com/tencent/mobileqq/utils/RecordParams$RecorderParam:f	I
    //   1843: iconst_1
    //   1844: iadd
    //   1845: putfield 100	com/tencent/mobileqq/utils/RecordParams$RecorderParam:f	I
    //   1848: goto +2805 -> 4653
    //   1851: dload_2
    //   1852: dstore 4
    //   1854: dload_2
    //   1855: dstore 6
    //   1857: aload_0
    //   1858: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1861: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1864: ifnull +52 -> 1916
    //   1867: aload 37
    //   1869: ifnull +47 -> 1916
    //   1872: dload_2
    //   1873: dstore 4
    //   1875: dload_2
    //   1876: dstore 6
    //   1878: aload_0
    //   1879: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1882: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1885: aload_1
    //   1886: aload 37
    //   1888: getfield 355	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_ArrayOfByte	[B
    //   1891: aload 37
    //   1893: getfield 356	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1896: aload_0
    //   1897: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1900: invokestatic 350	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1903: dload_2
    //   1904: aload_0
    //   1905: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1908: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   1911: invokeinterface 360 8 0
    //   1916: aload 37
    //   1918: ifnull +2709 -> 4627
    //   1921: dload_2
    //   1922: dstore 4
    //   1924: dload_2
    //   1925: dstore 6
    //   1927: aload 37
    //   1929: getfield 356	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1932: istore 12
    //   1934: iload 12
    //   1936: i2l
    //   1937: lload 22
    //   1939: ladd
    //   1940: lstore 22
    //   1942: iload 14
    //   1944: istore 16
    //   1946: iload 14
    //   1948: iconst_1
    //   1949: if_icmpne +86 -> 2035
    //   1952: iload 14
    //   1954: istore 16
    //   1956: aload_0
    //   1957: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   1960: sipush 500
    //   1963: if_icmple +72 -> 2035
    //   1966: iconst_2
    //   1967: istore 12
    //   1969: aload_0
    //   1970: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1973: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1976: ifnull +16 -> 1992
    //   1979: aload_0
    //   1980: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1983: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1986: iconst_2
    //   1987: invokeinterface 322 2 0
    //   1992: iload 12
    //   1994: istore 16
    //   1996: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1999: ifeq +36 -> 2035
    //   2002: ldc 50
    //   2004: iconst_2
    //   2005: new 52	java/lang/StringBuilder
    //   2008: dup
    //   2009: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2012: ldc_w 362
    //   2015: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: aload_0
    //   2019: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   2022: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2025: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2028: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2031: iload 12
    //   2033: istore 16
    //   2035: iload 18
    //   2037: iconst_m1
    //   2038: if_icmpeq +16 -> 2054
    //   2041: dload_2
    //   2042: iload 18
    //   2044: i2d
    //   2045: dcmpl
    //   2046: iflt +8 -> 2054
    //   2049: aload_0
    //   2050: iconst_1
    //   2051: putfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   2054: lload 24
    //   2056: lstore 30
    //   2058: lload 28
    //   2060: lstore 24
    //   2062: iload 11
    //   2064: istore 12
    //   2066: iload 13
    //   2068: istore 11
    //   2070: iload 15
    //   2072: istore 19
    //   2074: goto -1530 -> 544
    //   2077: aload_0
    //   2078: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2081: ifnull +10 -> 2091
    //   2084: aload_0
    //   2085: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2088: invokevirtual 365	java/io/FileOutputStream:flush	()V
    //   2091: aload_0
    //   2092: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2095: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2098: ifnull +56 -> 2154
    //   2101: aload_0
    //   2102: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2105: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2108: aload_1
    //   2109: aload_0
    //   2110: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2113: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   2116: dload_2
    //   2117: invokeinterface 369 5 0
    //   2122: aload_0
    //   2123: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2126: getfield 203	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2129: ifnull +25 -> 2154
    //   2132: aload_0
    //   2133: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2136: invokestatic 205	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   2139: iconst_m1
    //   2140: if_icmpeq +14 -> 2154
    //   2143: aload_0
    //   2144: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2147: getfield 203	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2150: iconst_0
    //   2151: invokevirtual 210	android/media/AudioManager:setMode	(I)V
    //   2154: aload_0
    //   2155: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2158: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2161: ifnull +27 -> 2188
    //   2164: aload_0
    //   2165: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2168: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2171: invokevirtual 223	android/media/AudioRecord:getState	()I
    //   2174: iconst_1
    //   2175: if_icmpne +13 -> 2188
    //   2178: aload_0
    //   2179: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2182: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2185: invokevirtual 226	android/media/AudioRecord:stop	()V
    //   2188: aload_0
    //   2189: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2192: ifnull +15 -> 2207
    //   2195: aload_0
    //   2196: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2199: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   2202: aload_0
    //   2203: aconst_null
    //   2204: putfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   2207: aload_0
    //   2208: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2211: invokestatic 235	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2214: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2217: ifeq +84 -> 2301
    //   2220: ldc 50
    //   2222: iconst_2
    //   2223: new 52	java/lang/StringBuilder
    //   2226: dup
    //   2227: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2230: ldc 237
    //   2232: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: aload_0
    //   2236: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2239: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2245: ldc 50
    //   2247: iconst_2
    //   2248: new 52	java/lang/StringBuilder
    //   2251: dup
    //   2252: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2255: ldc 239
    //   2257: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: lload 20
    //   2262: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2265: ldc 241
    //   2267: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: lload 24
    //   2272: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2275: ldc 243
    //   2277: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: lload 22
    //   2282: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2285: ldc 245
    //   2287: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: iload 10
    //   2292: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2295: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2298: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2301: aload_0
    //   2302: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2305: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   2308: iconst_0
    //   2309: invokestatic 92	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   2312: pop
    //   2313: lload 22
    //   2315: ldc2_w 246
    //   2318: lcmp
    //   2319: iflt +11 -> 2330
    //   2322: dload_2
    //   2323: ldc2_w 248
    //   2326: dcmpg
    //   2327: ifge +296 -> 2623
    //   2330: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   2333: lload 34
    //   2335: lsub
    //   2336: ldc2_w 184
    //   2339: lcmp
    //   2340: ifle +283 -> 2623
    //   2343: new 251	java/util/HashMap
    //   2346: dup
    //   2347: invokespecial 252	java/util/HashMap:<init>	()V
    //   2350: astore_1
    //   2351: aload_1
    //   2352: ldc_w 371
    //   2355: ldc_w 373
    //   2358: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2361: pop
    //   2362: aload_1
    //   2363: ldc 254
    //   2365: new 52	java/lang/StringBuilder
    //   2368: dup
    //   2369: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2372: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   2375: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2378: ldc_w 261
    //   2381: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2387: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2390: pop
    //   2391: aload_1
    //   2392: ldc_w 267
    //   2395: new 52	java/lang/StringBuilder
    //   2398: dup
    //   2399: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2402: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2405: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2408: ldc_w 274
    //   2411: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: getstatic 277	android/os/Build:MODEL	Ljava/lang/String;
    //   2417: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2426: pop
    //   2427: aload_1
    //   2428: ldc_w 279
    //   2431: new 52	java/lang/StringBuilder
    //   2434: dup
    //   2435: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2438: lload 24
    //   2440: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2443: ldc_w 261
    //   2446: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2452: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2455: pop
    //   2456: aload_1
    //   2457: ldc_w 288
    //   2460: new 52	java/lang/StringBuilder
    //   2463: dup
    //   2464: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2467: iload 12
    //   2469: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2472: ldc_w 261
    //   2475: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2478: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2481: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2484: pop
    //   2485: aload_1
    //   2486: ldc_w 375
    //   2489: new 52	java/lang/StringBuilder
    //   2492: dup
    //   2493: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2496: dload_2
    //   2497: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2500: ldc_w 261
    //   2503: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2509: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2512: pop
    //   2513: aload_1
    //   2514: ldc_w 286
    //   2517: new 52	java/lang/StringBuilder
    //   2520: dup
    //   2521: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2524: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   2527: lload 34
    //   2529: lsub
    //   2530: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2533: ldc_w 261
    //   2536: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2542: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2545: pop
    //   2546: ldc_w 377
    //   2549: iconst_0
    //   2550: aload_1
    //   2551: invokestatic 301	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2554: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2557: ifeq +66 -> 2623
    //   2560: ldc 50
    //   2562: iconst_2
    //   2563: new 52	java/lang/StringBuilder
    //   2566: dup
    //   2567: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2570: ldc_w 379
    //   2573: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2576: lload 24
    //   2578: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2581: ldc_w 381
    //   2584: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: lload 22
    //   2589: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2592: ldc_w 383
    //   2595: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2598: dload_2
    //   2599: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2602: ldc_w 385
    //   2605: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   2611: lload 34
    //   2613: lsub
    //   2614: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2617: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2620: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2623: new 251	java/util/HashMap
    //   2626: dup
    //   2627: invokespecial 252	java/util/HashMap:<init>	()V
    //   2630: astore_1
    //   2631: aload_1
    //   2632: ldc 254
    //   2634: new 52	java/lang/StringBuilder
    //   2637: dup
    //   2638: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2641: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   2644: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2647: ldc_w 261
    //   2650: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2653: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2656: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2659: pop
    //   2660: aload_1
    //   2661: ldc_w 267
    //   2664: new 52	java/lang/StringBuilder
    //   2667: dup
    //   2668: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2671: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2674: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2677: ldc_w 274
    //   2680: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2683: getstatic 277	android/os/Build:MODEL	Ljava/lang/String;
    //   2686: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2692: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2695: pop
    //   2696: aload_1
    //   2697: ldc_w 279
    //   2700: new 52	java/lang/StringBuilder
    //   2703: dup
    //   2704: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2707: lload 24
    //   2709: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2712: ldc_w 261
    //   2715: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2721: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2724: pop
    //   2725: aload_1
    //   2726: ldc_w 281
    //   2729: new 52	java/lang/StringBuilder
    //   2732: dup
    //   2733: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2736: dload_2
    //   2737: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2740: ldc_w 261
    //   2743: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2749: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2752: pop
    //   2753: aload_1
    //   2754: ldc_w 286
    //   2757: new 52	java/lang/StringBuilder
    //   2760: dup
    //   2761: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2764: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   2767: lload 34
    //   2769: lsub
    //   2770: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2773: ldc_w 261
    //   2776: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2782: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2785: pop
    //   2786: aload_1
    //   2787: ldc_w 288
    //   2790: new 52	java/lang/StringBuilder
    //   2793: dup
    //   2794: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2797: iload 12
    //   2799: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2802: ldc_w 261
    //   2805: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2811: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2814: pop
    //   2815: aload_1
    //   2816: ldc_w 290
    //   2819: new 52	java/lang/StringBuilder
    //   2822: dup
    //   2823: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2826: aload_0
    //   2827: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   2830: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2833: ldc_w 261
    //   2836: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2842: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2845: pop
    //   2846: lload 26
    //   2848: lconst_0
    //   2849: lcmp
    //   2850: ifne +260 -> 3110
    //   2853: ldc2_w 291
    //   2856: lstore 20
    //   2858: goto +1804 -> 4662
    //   2861: lload 20
    //   2863: l2i
    //   2864: istore 10
    //   2866: aload_1
    //   2867: ldc_w 294
    //   2870: new 52	java/lang/StringBuilder
    //   2873: dup
    //   2874: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2877: iload 11
    //   2879: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2882: ldc_w 261
    //   2885: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2888: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2891: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2894: pop
    //   2895: aload_1
    //   2896: ldc_w 296
    //   2899: new 52	java/lang/StringBuilder
    //   2902: dup
    //   2903: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2906: iload 10
    //   2908: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2911: ldc_w 261
    //   2914: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2920: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2923: pop
    //   2924: ldc_w 298
    //   2927: iconst_1
    //   2928: aload_1
    //   2929: invokestatic 301	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2932: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2935: ifeq -1539 -> 1396
    //   2938: new 52	java/lang/StringBuilder
    //   2941: dup
    //   2942: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2945: astore_1
    //   2946: aload_1
    //   2947: ldc_w 303
    //   2950: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: iload 12
    //   2955: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2958: pop
    //   2959: aload_1
    //   2960: ldc_w 305
    //   2963: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2966: iload 11
    //   2968: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2971: pop
    //   2972: aload_1
    //   2973: ldc_w 307
    //   2976: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2979: iload 10
    //   2981: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2984: pop
    //   2985: aload_1
    //   2986: ldc_w 309
    //   2989: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2992: iload 10
    //   2994: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2997: pop
    //   2998: aload_1
    //   2999: ldc_w 311
    //   3002: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: lload 24
    //   3007: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3010: pop
    //   3011: aload_1
    //   3012: ldc_w 313
    //   3015: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3018: lload 22
    //   3020: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3023: pop
    //   3024: aload_1
    //   3025: ldc_w 315
    //   3028: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3031: dload_2
    //   3032: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3035: pop
    //   3036: aload_1
    //   3037: ldc_w 317
    //   3040: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3043: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   3046: lload 34
    //   3048: lsub
    //   3049: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3052: pop
    //   3053: ldc 50
    //   3055: iconst_2
    //   3056: aload_1
    //   3057: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3060: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3063: return
    //   3064: astore_1
    //   3065: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3068: ifeq -1672 -> 1396
    //   3071: ldc 50
    //   3073: iconst_2
    //   3074: ldc_w 387
    //   3077: aload_1
    //   3078: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3081: return
    //   3082: astore_1
    //   3083: aload_1
    //   3084: invokevirtual 390	java/lang/Throwable:printStackTrace	()V
    //   3087: goto -873 -> 2214
    //   3090: astore_1
    //   3091: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3094: ifeq -471 -> 2623
    //   3097: ldc 50
    //   3099: iconst_2
    //   3100: ldc_w 392
    //   3103: aload_1
    //   3104: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3107: goto -484 -> 2623
    //   3110: lload 30
    //   3112: lload 26
    //   3114: ldiv
    //   3115: lstore 20
    //   3117: goto +1545 -> 4662
    //   3120: aload_0
    //   3121: getfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   3124: lload 26
    //   3126: ldiv
    //   3127: lstore 20
    //   3129: goto -268 -> 2861
    //   3132: aload 36
    //   3134: instanceof 191
    //   3137: ifeq +992 -> 4129
    //   3140: aload_0
    //   3141: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3144: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   3147: aload_1
    //   3148: aload_0
    //   3149: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3152: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   3155: invokeinterface 395 3 0
    //   3160: goto -2389 -> 771
    //   3163: astore_1
    //   3164: iconst_1
    //   3165: istore 11
    //   3167: lload 24
    //   3169: lstore 28
    //   3171: lload 26
    //   3173: lstore 24
    //   3175: lload 20
    //   3177: lstore 26
    //   3179: lload 22
    //   3181: lstore 20
    //   3183: aload_0
    //   3184: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3187: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3190: ifnull +27 -> 3217
    //   3193: aload_0
    //   3194: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3197: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3200: invokevirtual 223	android/media/AudioRecord:getState	()I
    //   3203: iconst_1
    //   3204: if_icmpne +13 -> 3217
    //   3207: aload_0
    //   3208: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3211: invokestatic 161	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3214: invokevirtual 226	android/media/AudioRecord:stop	()V
    //   3217: aload_0
    //   3218: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3221: ifnull +15 -> 3236
    //   3224: aload_0
    //   3225: getfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3228: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   3231: aload_0
    //   3232: aconst_null
    //   3233: putfield 228	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   3236: aload_0
    //   3237: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3240: invokestatic 235	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   3243: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3246: ifeq +84 -> 3330
    //   3249: ldc 50
    //   3251: iconst_2
    //   3252: new 52	java/lang/StringBuilder
    //   3255: dup
    //   3256: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3259: ldc 237
    //   3261: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3264: aload_0
    //   3265: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3268: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3271: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3274: ldc 50
    //   3276: iconst_2
    //   3277: new 52	java/lang/StringBuilder
    //   3280: dup
    //   3281: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3284: ldc 239
    //   3286: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3289: lload 24
    //   3291: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3294: ldc 241
    //   3296: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3299: lload 28
    //   3301: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3304: ldc 243
    //   3306: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3309: lload 26
    //   3311: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3314: ldc 245
    //   3316: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: iload 10
    //   3321: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3324: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3327: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3330: aload_0
    //   3331: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3334: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   3337: iconst_0
    //   3338: invokestatic 92	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   3341: pop
    //   3342: lload 26
    //   3344: ldc2_w 246
    //   3347: lcmp
    //   3348: iflt +11 -> 3359
    //   3351: dload_2
    //   3352: ldc2_w 248
    //   3355: dcmpg
    //   3356: ifge +310 -> 3666
    //   3359: iload 11
    //   3361: ifne +305 -> 3666
    //   3364: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   3367: lload 34
    //   3369: lsub
    //   3370: ldc2_w 184
    //   3373: lcmp
    //   3374: ifle +292 -> 3666
    //   3377: new 251	java/util/HashMap
    //   3380: dup
    //   3381: invokespecial 252	java/util/HashMap:<init>	()V
    //   3384: astore 36
    //   3386: aload 36
    //   3388: ldc_w 371
    //   3391: ldc_w 373
    //   3394: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3397: pop
    //   3398: aload 36
    //   3400: ldc 254
    //   3402: new 52	java/lang/StringBuilder
    //   3405: dup
    //   3406: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3409: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   3412: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3415: ldc_w 261
    //   3418: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3424: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3427: pop
    //   3428: aload 36
    //   3430: ldc_w 267
    //   3433: new 52	java/lang/StringBuilder
    //   3436: dup
    //   3437: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3440: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3443: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: ldc_w 274
    //   3449: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3452: getstatic 277	android/os/Build:MODEL	Ljava/lang/String;
    //   3455: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3461: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3464: pop
    //   3465: aload 36
    //   3467: ldc_w 279
    //   3470: new 52	java/lang/StringBuilder
    //   3473: dup
    //   3474: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3477: lload 28
    //   3479: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3482: ldc_w 261
    //   3485: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3488: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3491: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3494: pop
    //   3495: aload 36
    //   3497: ldc_w 288
    //   3500: new 52	java/lang/StringBuilder
    //   3503: dup
    //   3504: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3507: iload 12
    //   3509: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3512: ldc_w 261
    //   3515: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3521: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3524: pop
    //   3525: aload 36
    //   3527: ldc_w 375
    //   3530: new 52	java/lang/StringBuilder
    //   3533: dup
    //   3534: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3537: dload_2
    //   3538: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3541: ldc_w 261
    //   3544: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3550: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3553: pop
    //   3554: aload 36
    //   3556: ldc_w 286
    //   3559: new 52	java/lang/StringBuilder
    //   3562: dup
    //   3563: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3566: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   3569: lload 34
    //   3571: lsub
    //   3572: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3575: ldc_w 261
    //   3578: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3584: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3587: pop
    //   3588: ldc_w 377
    //   3591: iconst_0
    //   3592: aload 36
    //   3594: invokestatic 301	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3597: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3600: ifeq +66 -> 3666
    //   3603: ldc 50
    //   3605: iconst_2
    //   3606: new 52	java/lang/StringBuilder
    //   3609: dup
    //   3610: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3613: ldc_w 379
    //   3616: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3619: lload 28
    //   3621: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3624: ldc_w 381
    //   3627: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: lload 26
    //   3632: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3635: ldc_w 383
    //   3638: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: dload_2
    //   3642: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3645: ldc_w 385
    //   3648: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3651: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   3654: lload 34
    //   3656: lsub
    //   3657: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3660: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3663: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3666: new 251	java/util/HashMap
    //   3669: dup
    //   3670: invokespecial 252	java/util/HashMap:<init>	()V
    //   3673: astore 36
    //   3675: aload 36
    //   3677: ldc 254
    //   3679: new 52	java/lang/StringBuilder
    //   3682: dup
    //   3683: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3686: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   3689: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3692: ldc_w 261
    //   3695: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3698: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3701: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3704: pop
    //   3705: aload 36
    //   3707: ldc_w 267
    //   3710: new 52	java/lang/StringBuilder
    //   3713: dup
    //   3714: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3717: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3720: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3723: ldc_w 274
    //   3726: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3729: getstatic 277	android/os/Build:MODEL	Ljava/lang/String;
    //   3732: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3738: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3741: pop
    //   3742: aload 36
    //   3744: ldc_w 279
    //   3747: new 52	java/lang/StringBuilder
    //   3750: dup
    //   3751: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3754: lload 28
    //   3756: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3759: ldc_w 261
    //   3762: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3765: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3771: pop
    //   3772: aload 36
    //   3774: ldc_w 281
    //   3777: new 52	java/lang/StringBuilder
    //   3780: dup
    //   3781: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3784: dload_2
    //   3785: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3788: ldc_w 261
    //   3791: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3794: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3797: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3800: pop
    //   3801: aload 36
    //   3803: ldc_w 286
    //   3806: new 52	java/lang/StringBuilder
    //   3809: dup
    //   3810: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3813: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   3816: lload 34
    //   3818: lsub
    //   3819: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3822: ldc_w 261
    //   3825: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3828: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3831: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3834: pop
    //   3835: aload 36
    //   3837: ldc_w 288
    //   3840: new 52	java/lang/StringBuilder
    //   3843: dup
    //   3844: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3847: iload 12
    //   3849: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3852: ldc_w 261
    //   3855: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3861: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3864: pop
    //   3865: aload 36
    //   3867: ldc_w 290
    //   3870: new 52	java/lang/StringBuilder
    //   3873: dup
    //   3874: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3877: aload_0
    //   3878: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Int	I
    //   3881: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3884: ldc_w 261
    //   3887: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3890: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3893: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3896: pop
    //   3897: lload 20
    //   3899: lconst_0
    //   3900: lcmp
    //   3901: ifne +336 -> 4237
    //   3904: ldc2_w 291
    //   3907: lstore 22
    //   3909: goto +773 -> 4682
    //   3912: lload 20
    //   3914: l2i
    //   3915: istore 10
    //   3917: aload 36
    //   3919: ldc_w 294
    //   3922: new 52	java/lang/StringBuilder
    //   3925: dup
    //   3926: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3929: iload 11
    //   3931: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3934: ldc_w 261
    //   3937: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3940: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3943: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3946: pop
    //   3947: aload 36
    //   3949: ldc_w 296
    //   3952: new 52	java/lang/StringBuilder
    //   3955: dup
    //   3956: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3959: iload 10
    //   3961: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3964: ldc_w 261
    //   3967: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3970: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3973: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3976: pop
    //   3977: ldc_w 298
    //   3980: iconst_1
    //   3981: aload 36
    //   3983: invokestatic 301	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3986: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3989: ifeq +138 -> 4127
    //   3992: new 52	java/lang/StringBuilder
    //   3995: dup
    //   3996: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3999: astore 36
    //   4001: aload 36
    //   4003: ldc_w 303
    //   4006: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: iload 12
    //   4011: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4014: pop
    //   4015: aload 36
    //   4017: ldc_w 305
    //   4020: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4023: iload 11
    //   4025: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4028: pop
    //   4029: aload 36
    //   4031: ldc_w 307
    //   4034: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4037: iload 10
    //   4039: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4042: pop
    //   4043: aload 36
    //   4045: ldc_w 309
    //   4048: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4051: iload 10
    //   4053: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4056: pop
    //   4057: aload 36
    //   4059: ldc_w 311
    //   4062: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4065: lload 28
    //   4067: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4070: pop
    //   4071: aload 36
    //   4073: ldc_w 313
    //   4076: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4079: lload 26
    //   4081: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4084: pop
    //   4085: aload 36
    //   4087: ldc_w 315
    //   4090: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4093: dload_2
    //   4094: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   4097: pop
    //   4098: aload 36
    //   4100: ldc_w 317
    //   4103: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4106: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   4109: lload 34
    //   4111: lsub
    //   4112: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4115: pop
    //   4116: ldc 50
    //   4118: iconst_2
    //   4119: aload 36
    //   4121: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4124: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4127: aload_1
    //   4128: athrow
    //   4129: aload_0
    //   4130: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   4133: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   4136: aload_1
    //   4137: aload_0
    //   4138: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   4141: getfield 95	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   4144: aload 36
    //   4146: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   4149: invokeinterface 402 4 0
    //   4154: goto -3383 -> 771
    //   4157: astore_1
    //   4158: aload_1
    //   4159: invokevirtual 390	java/lang/Throwable:printStackTrace	()V
    //   4162: goto -3322 -> 840
    //   4165: lload 30
    //   4167: lload 22
    //   4169: ldiv
    //   4170: lstore 26
    //   4172: goto +461 -> 4633
    //   4175: aload_0
    //   4176: getfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   4179: lload 22
    //   4181: ldiv
    //   4182: lstore 22
    //   4184: goto -2990 -> 1194
    //   4187: astore_1
    //   4188: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4191: ifeq -2795 -> 1396
    //   4194: ldc 50
    //   4196: iconst_2
    //   4197: ldc_w 387
    //   4200: aload_1
    //   4201: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4204: return
    //   4205: astore 36
    //   4207: aload 36
    //   4209: invokevirtual 390	java/lang/Throwable:printStackTrace	()V
    //   4212: goto -969 -> 3243
    //   4215: astore 36
    //   4217: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4220: ifeq -554 -> 3666
    //   4223: ldc 50
    //   4225: iconst_2
    //   4226: ldc_w 392
    //   4229: aload 36
    //   4231: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4234: goto -568 -> 3666
    //   4237: lload 30
    //   4239: lload 20
    //   4241: ldiv
    //   4242: lstore 22
    //   4244: goto +438 -> 4682
    //   4247: aload_0
    //   4248: getfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Long	J
    //   4251: lload 20
    //   4253: ldiv
    //   4254: lstore 20
    //   4256: goto -344 -> 3912
    //   4259: astore 36
    //   4261: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4264: ifeq -137 -> 4127
    //   4267: ldc 50
    //   4269: iconst_2
    //   4270: ldc_w 387
    //   4273: aload 36
    //   4275: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4278: goto -151 -> 4127
    //   4281: astore_1
    //   4282: iconst_0
    //   4283: istore 10
    //   4285: lconst_0
    //   4286: lstore 32
    //   4288: lconst_0
    //   4289: lstore 26
    //   4291: iconst_0
    //   4292: istore 11
    //   4294: iload 13
    //   4296: istore 12
    //   4298: lload 22
    //   4300: lstore 20
    //   4302: lload 28
    //   4304: lstore 24
    //   4306: lload 32
    //   4308: lstore 28
    //   4310: goto -1127 -> 3183
    //   4313: astore_1
    //   4314: lload 24
    //   4316: lstore 28
    //   4318: lload 20
    //   4320: lstore 24
    //   4322: lload 26
    //   4324: lstore 20
    //   4326: iconst_0
    //   4327: istore 11
    //   4329: lload 22
    //   4331: lstore 26
    //   4333: goto -1150 -> 3183
    //   4336: astore_1
    //   4337: lload 24
    //   4339: lstore 28
    //   4341: lload 20
    //   4343: lstore 24
    //   4345: lload 26
    //   4347: lstore 20
    //   4349: iconst_0
    //   4350: istore 11
    //   4352: lload 22
    //   4354: lstore 26
    //   4356: goto -1173 -> 3183
    //   4359: astore_1
    //   4360: iload 15
    //   4362: istore 10
    //   4364: lload 24
    //   4366: lstore 28
    //   4368: lload 20
    //   4370: lstore 24
    //   4372: lload 26
    //   4374: lstore 20
    //   4376: iconst_0
    //   4377: istore 11
    //   4379: lload 22
    //   4381: lstore 26
    //   4383: goto -1200 -> 3183
    //   4386: astore_1
    //   4387: iconst_0
    //   4388: istore 11
    //   4390: lload 20
    //   4392: lstore 24
    //   4394: lload 26
    //   4396: lstore 20
    //   4398: lload 22
    //   4400: lstore 26
    //   4402: goto -1219 -> 3183
    //   4405: astore_1
    //   4406: lload 24
    //   4408: lstore 30
    //   4410: iconst_0
    //   4411: istore 13
    //   4413: dload 4
    //   4415: dstore_2
    //   4416: lload 20
    //   4418: lstore 24
    //   4420: iload 11
    //   4422: istore 12
    //   4424: iload 13
    //   4426: istore 11
    //   4428: lload 26
    //   4430: lstore 20
    //   4432: lload 22
    //   4434: lstore 26
    //   4436: goto -1253 -> 3183
    //   4439: astore_1
    //   4440: iconst_0
    //   4441: istore 13
    //   4443: lload 24
    //   4445: lstore 30
    //   4447: lload 20
    //   4449: lstore 24
    //   4451: iload 11
    //   4453: istore 12
    //   4455: iload 13
    //   4457: istore 11
    //   4459: lload 26
    //   4461: lstore 20
    //   4463: lload 22
    //   4465: lstore 26
    //   4467: goto -1284 -> 3183
    //   4470: astore 36
    //   4472: iload 15
    //   4474: istore 12
    //   4476: iload 14
    //   4478: istore 10
    //   4480: lload 28
    //   4482: lstore 26
    //   4484: goto -3807 -> 677
    //   4487: astore 36
    //   4489: lload 20
    //   4491: lstore 28
    //   4493: lload 22
    //   4495: lstore 20
    //   4497: lload 26
    //   4499: lstore 22
    //   4501: lload 28
    //   4503: lstore 26
    //   4505: goto -3828 -> 677
    //   4508: astore 36
    //   4510: lload 20
    //   4512: lstore 28
    //   4514: lload 22
    //   4516: lstore 20
    //   4518: iload 15
    //   4520: istore 10
    //   4522: lload 26
    //   4524: lstore 22
    //   4526: lload 28
    //   4528: lstore 26
    //   4530: goto -3853 -> 677
    //   4533: astore 36
    //   4535: lload 28
    //   4537: lstore 24
    //   4539: lload 20
    //   4541: lstore 28
    //   4543: lload 22
    //   4545: lstore 20
    //   4547: lload 26
    //   4549: lstore 22
    //   4551: lload 28
    //   4553: lstore 26
    //   4555: goto -3878 -> 677
    //   4558: astore 36
    //   4560: lload 24
    //   4562: lstore 30
    //   4564: dload 6
    //   4566: dstore_2
    //   4567: lload 28
    //   4569: lstore 24
    //   4571: lload 26
    //   4573: lstore 28
    //   4575: lload 20
    //   4577: lstore 26
    //   4579: iload 11
    //   4581: istore 12
    //   4583: lload 22
    //   4585: lstore 20
    //   4587: lload 28
    //   4589: lstore 22
    //   4591: goto -3914 -> 677
    //   4594: astore 36
    //   4596: lload 24
    //   4598: lstore 30
    //   4600: lload 26
    //   4602: lstore 24
    //   4604: lload 20
    //   4606: lstore 26
    //   4608: iload 11
    //   4610: istore 12
    //   4612: lload 22
    //   4614: lstore 20
    //   4616: lload 24
    //   4618: lstore 22
    //   4620: lload 28
    //   4622: lstore 24
    //   4624: goto -3947 -> 677
    //   4627: goto -2685 -> 1942
    //   4630: goto -2779 -> 1851
    //   4633: lload 26
    //   4635: l2i
    //   4636: istore 11
    //   4638: lload 22
    //   4640: lconst_0
    //   4641: lcmp
    //   4642: ifne -467 -> 4175
    //   4645: ldc2_w 291
    //   4648: lstore 22
    //   4650: goto -3456 -> 1194
    //   4653: iconst_0
    //   4654: istore 15
    //   4656: iconst_0
    //   4657: istore 17
    //   4659: goto -2808 -> 1851
    //   4662: lload 20
    //   4664: l2i
    //   4665: istore 11
    //   4667: lload 26
    //   4669: lconst_0
    //   4670: lcmp
    //   4671: ifne -1551 -> 3120
    //   4674: ldc2_w 291
    //   4677: lstore 20
    //   4679: goto -1818 -> 2861
    //   4682: lload 22
    //   4684: l2i
    //   4685: istore 11
    //   4687: lload 20
    //   4689: lconst_0
    //   4690: lcmp
    //   4691: ifne -444 -> 4247
    //   4694: ldc2_w 291
    //   4697: lstore 20
    //   4699: goto -787 -> 3912
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4702	0	this	RecordThread
    //   0	4702	1	paramString	String
    //   41	4526	2	d1	double
    //   1639	2775	4	d2	double
    //   1642	2923	6	d3	double
    //   1692	8	8	d4	double
    //   77	4444	10	i	int
    //   187	4499	11	j	int
    //   69	4542	12	k	int
    //   66	4390	13	m	int
    //   38	4439	14	n	int
    //   63	4592	15	i1	int
    //   291	1743	16	i2	int
    //   49	4609	17	i3	int
    //   43	2000	18	i4	int
    //   52	2021	19	i5	int
    //   60	4638	20	l1	long
    //   46	4637	22	l2	long
    //   35	4588	24	l3	long
    //   534	4134	26	l4	long
    //   32	4589	28	l5	long
    //   72	4527	30	l6	long
    //   519	3788	32	l7	long
    //   57	4053	34	l8	long
    //   156	186	36	arrayOfByte	byte[]
    //   651	2482	36	localThrowable1	java.lang.Throwable
    //   3384	761	36	localObject	java.lang.Object
    //   4205	3	36	localThrowable2	java.lang.Throwable
    //   4215	15	36	localException1	java.lang.Exception
    //   4259	15	36	localException2	java.lang.Exception
    //   4470	1	36	localThrowable3	java.lang.Throwable
    //   4487	1	36	localThrowable4	java.lang.Throwable
    //   4508	1	36	localThrowable5	java.lang.Throwable
    //   4533	1	36	localThrowable6	java.lang.Throwable
    //   4558	1	36	localThrowable7	java.lang.Throwable
    //   4594	1	36	localThrowable8	java.lang.Throwable
    //   1659	269	37	localProcessData	IAudioProcessor.ProcessData
    //   1828	11	38	localRecorderParam	RecordParams.RecorderParam
    // Exception table:
    //   from	to	target	type
    //   544	558	651	java/lang/Throwable
    //   562	575	651	java/lang/Throwable
    //   599	641	651	java/lang/Throwable
    //   641	651	651	java/lang/Throwable
    //   1401	1414	651	java/lang/Throwable
    //   1423	1458	651	java/lang/Throwable
    //   1458	1475	651	java/lang/Throwable
    //   1482	1506	651	java/lang/Throwable
    //   2077	2091	651	java/lang/Throwable
    //   2091	2154	651	java/lang/Throwable
    //   2623	2846	3064	java/lang/Exception
    //   2866	3063	3064	java/lang/Exception
    //   3110	3117	3064	java/lang/Exception
    //   3120	3129	3064	java/lang/Exception
    //   2188	2207	3082	java/lang/Throwable
    //   2207	2214	3082	java/lang/Throwable
    //   2343	2623	3090	java/lang/Exception
    //   677	693	3163	finally
    //   693	735	3163	finally
    //   735	751	3163	finally
    //   751	771	3163	finally
    //   771	780	3163	finally
    //   3132	3160	3163	finally
    //   4129	4154	3163	finally
    //   814	833	4157	java/lang/Throwable
    //   833	840	4157	java/lang/Throwable
    //   956	1179	4187	java/lang/Exception
    //   1199	1396	4187	java/lang/Exception
    //   4165	4172	4187	java/lang/Exception
    //   4175	4184	4187	java/lang/Exception
    //   3217	3236	4205	java/lang/Throwable
    //   3236	3243	4205	java/lang/Throwable
    //   3377	3666	4215	java/lang/Exception
    //   3666	3897	4259	java/lang/Exception
    //   3917	4127	4259	java/lang/Exception
    //   4237	4244	4259	java/lang/Exception
    //   4247	4256	4259	java/lang/Exception
    //   117	147	4281	finally
    //   147	165	4281	finally
    //   165	189	4281	finally
    //   203	210	4281	finally
    //   210	247	4281	finally
    //   247	293	4281	finally
    //   303	312	4281	finally
    //   312	327	4281	finally
    //   334	350	4281	finally
    //   360	402	4281	finally
    //   402	448	4281	finally
    //   465	479	4281	finally
    //   479	516	4281	finally
    //   516	521	4281	finally
    //   544	558	4313	finally
    //   562	575	4313	finally
    //   599	641	4313	finally
    //   641	651	4313	finally
    //   1401	1414	4313	finally
    //   1423	1458	4313	finally
    //   1458	1475	4313	finally
    //   1482	1506	4313	finally
    //   2077	2091	4313	finally
    //   2091	2154	4313	finally
    //   1516	1538	4336	finally
    //   1570	1589	4336	finally
    //   1543	1549	4359	finally
    //   1603	1630	4386	finally
    //   1644	1661	4405	finally
    //   1667	1670	4405	finally
    //   1676	1694	4405	finally
    //   1714	1728	4405	finally
    //   1741	1754	4405	finally
    //   1760	1783	4405	finally
    //   1789	1815	4405	finally
    //   1821	1830	4405	finally
    //   1836	1848	4405	finally
    //   1857	1867	4405	finally
    //   1878	1916	4405	finally
    //   1927	1934	4405	finally
    //   1956	1966	4439	finally
    //   1969	1992	4439	finally
    //   1996	2031	4439	finally
    //   2049	2054	4439	finally
    //   117	147	4470	java/lang/Throwable
    //   147	165	4470	java/lang/Throwable
    //   165	189	4470	java/lang/Throwable
    //   203	210	4470	java/lang/Throwable
    //   210	247	4470	java/lang/Throwable
    //   247	293	4470	java/lang/Throwable
    //   303	312	4470	java/lang/Throwable
    //   312	327	4470	java/lang/Throwable
    //   334	350	4470	java/lang/Throwable
    //   360	402	4470	java/lang/Throwable
    //   402	448	4470	java/lang/Throwable
    //   465	479	4470	java/lang/Throwable
    //   479	516	4470	java/lang/Throwable
    //   516	521	4470	java/lang/Throwable
    //   1516	1538	4487	java/lang/Throwable
    //   1570	1589	4487	java/lang/Throwable
    //   1543	1549	4508	java/lang/Throwable
    //   1603	1630	4533	java/lang/Throwable
    //   1644	1661	4558	java/lang/Throwable
    //   1667	1670	4558	java/lang/Throwable
    //   1676	1694	4558	java/lang/Throwable
    //   1714	1728	4558	java/lang/Throwable
    //   1741	1754	4558	java/lang/Throwable
    //   1760	1783	4558	java/lang/Throwable
    //   1789	1815	4558	java/lang/Throwable
    //   1821	1830	4558	java/lang/Throwable
    //   1836	1848	4558	java/lang/Throwable
    //   1857	1867	4558	java/lang/Throwable
    //   1878	1916	4558	java/lang/Throwable
    //   1927	1934	4558	java/lang/Throwable
    //   1956	1966	4594	java/lang/Throwable
    //   1969	1992	4594	java/lang/Throwable
    //   1996	2031	4594	java/lang/Throwable
    //   2049	2054	4594	java/lang/Throwable
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
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof WechatNsWrapper)) && (QQRecorder.a(this.this$0) != null)) {
      QQRecorder.a(this.this$0).b(paramIAudioProcessor, paramProcessData);
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
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if ((paramIAudioProcessor instanceof WechatNsWrapper))
    {
      QQRecorder.b(this.this$0, (int)AudioHelper.a(QQRecorder.a(this.this$0), paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int, 1.0F));
      this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, QQRecorder.c(this.this$0));
      this.jdField_a_of_type_Long += QQRecorder.c(this.this$0);
      if (QQRecorder.a(this.this$0) != null) {
        QQRecorder.a(this.this$0).a(paramIAudioProcessor, paramProcessData);
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   4: ifeq +116 -> 120
    //   7: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 50
    //   15: iconst_2
    //   16: ldc_w 454
    //   19: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 26	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 28	com/tencent/mobileqq/utils/QQRecorder$RecordThread:c	Z
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 30	com/tencent/mobileqq/utils/QQRecorder$RecordThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 456	com/tencent/mobileqq/utils/QQRecorder$RecordThread:a	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   44: ifeq -44 -> 0
    //   47: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   50: lstore_1
    //   51: aload_0
    //   52: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   55: astore_3
    //   56: aload_3
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 21	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   62: getstatic 457	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   65: i2l
    //   66: invokevirtual 462	java/lang/Object:wait	(J)V
    //   69: aload_3
    //   70: monitorexit
    //   71: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   74: lload_1
    //   75: lsub
    //   76: getstatic 457	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   79: i2l
    //   80: lcmp
    //   81: iflt -81 -> 0
    //   84: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: ldc 50
    //   92: iconst_2
    //   93: ldc_w 464
    //   96: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 32	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	Z
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_0
    //   109: invokevirtual 466	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	()V
    //   112: goto -112 -> 0
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 467	java/lang/InterruptedException:printStackTrace	()V
    //   120: aload_0
    //   121: invokevirtual 466	com/tencent/mobileqq/utils/QQRecorder$RecordThread:b	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */