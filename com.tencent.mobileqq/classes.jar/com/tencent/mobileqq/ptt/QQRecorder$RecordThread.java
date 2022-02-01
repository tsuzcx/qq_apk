package com.tencent.mobileqq.ptt;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessorListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class QQRecorder$RecordThread
  extends Thread
  implements IAudioProcessorListener
{
  public volatile boolean a = true;
  public String b = null;
  public volatile boolean c = true;
  int d = 0;
  long e = 0L;
  File f;
  FileOutputStream g;
  private boolean h = false;
  
  protected QQRecorder$RecordThread(QQRecorder paramQQRecorder) {}
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 49
    //   3: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: new 53	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   16: astore 48
    //   18: aload 48
    //   20: ldc 56
    //   22: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 48
    //   28: aload 49
    //   30: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 65
    //   36: iconst_2
    //   37: aload 48
    //   39: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: dconst_0
    //   46: dstore_2
    //   47: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   50: lstore 40
    //   52: bipush 237
    //   54: invokestatic 84	android/os/Process:setThreadPriority	(I)V
    //   57: aload 49
    //   59: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   62: invokestatic 89	com/tencent/mobileqq/ptt/QQRecorder:a	(Lcom/tencent/mobileqq/ptt/QQRecorder;)Landroid/content/Context;
    //   65: iconst_1
    //   66: invokestatic 94	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   69: pop
    //   70: aload 49
    //   72: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   75: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   78: ifnull +15 -> 93
    //   81: aload 49
    //   83: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   86: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   89: iconst_0
    //   90: putfield 102	com/tencent/mobileqq/utils/RecordParams$RecorderParam:g	I
    //   93: lconst_0
    //   94: lstore 28
    //   96: aload 49
    //   98: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   101: getfield 103	com/tencent/mobileqq/ptt/QQRecorder:d	I
    //   104: newarray byte
    //   106: astore 48
    //   108: aload 49
    //   110: aload_1
    //   111: iconst_m1
    //   112: sipush 250
    //   115: aload 48
    //   117: invokevirtual 106	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(Ljava/lang/String;II[B)I
    //   120: istore 10
    //   122: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   125: lstore 42
    //   127: lconst_0
    //   128: lstore 20
    //   130: lload 20
    //   132: lstore 24
    //   134: lload 24
    //   136: lstore 22
    //   138: lload 22
    //   140: lstore 18
    //   142: iconst_0
    //   143: istore 15
    //   145: iconst_0
    //   146: istore 11
    //   148: iconst_0
    //   149: istore 8
    //   151: iconst_0
    //   152: istore 16
    //   154: iconst_0
    //   155: istore 46
    //   157: iconst_0
    //   158: istore 9
    //   160: lload 28
    //   162: lstore 26
    //   164: aload 49
    //   166: getfield 31	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	Z
    //   169: istore 47
    //   171: iload 47
    //   173: ifeq +1220 -> 1393
    //   176: aload 49
    //   178: getfield 33	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:h	Z
    //   181: ifne +1212 -> 1393
    //   184: aload 49
    //   186: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   189: lload 22
    //   191: iload 8
    //   193: lload 42
    //   195: iload 46
    //   197: invokestatic 109	com/tencent/mobileqq/ptt/QQRecorder:a	(Lcom/tencent/mobileqq/ptt/QQRecorder;JIJZ)Z
    //   200: istore 46
    //   202: aload 49
    //   204: lload 42
    //   206: iload 11
    //   208: invokevirtual 112	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(JI)I
    //   211: istore 14
    //   213: lload 26
    //   215: lconst_1
    //   216: ladd
    //   217: lstore 26
    //   219: iload 8
    //   221: istore 12
    //   223: lload 20
    //   225: lstore 36
    //   227: lload 22
    //   229: lstore 32
    //   231: lload 18
    //   233: lstore 28
    //   235: iload 8
    //   237: istore 13
    //   239: lload 20
    //   241: lstore 38
    //   243: lload 22
    //   245: lstore 34
    //   247: lload 18
    //   249: lstore 30
    //   251: aload 49
    //   253: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   256: getfield 115	com/tencent/mobileqq/ptt/QQRecorder:a	Landroid/media/AudioRecord;
    //   259: aload 48
    //   261: iconst_0
    //   262: aload 49
    //   264: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   267: getfield 103	com/tencent/mobileqq/ptt/QQRecorder:d	I
    //   270: invokevirtual 121	android/media/AudioRecord:read	([BII)I
    //   273: istore 11
    //   275: iload 11
    //   277: ifgt +77 -> 354
    //   280: ldc2_w 122
    //   283: invokestatic 127	java/lang/Thread:sleep	(J)V
    //   286: iload 11
    //   288: istore 9
    //   290: iload 14
    //   292: istore 11
    //   294: goto -130 -> 164
    //   297: astore_1
    //   298: iload 8
    //   300: istore 9
    //   302: lload 20
    //   304: lstore 28
    //   306: lload 26
    //   308: lstore 20
    //   310: iload 11
    //   312: istore 8
    //   314: lload 28
    //   316: lstore 26
    //   318: lload 18
    //   320: lstore 28
    //   322: goto +991 -> 1313
    //   325: astore 48
    //   327: iload 8
    //   329: istore 9
    //   331: lload 26
    //   333: lstore 28
    //   335: iload 11
    //   337: istore 8
    //   339: lload 20
    //   341: lstore 26
    //   343: lload 22
    //   345: lstore 34
    //   347: lload 18
    //   349: lstore 22
    //   351: goto +1019 -> 1370
    //   354: iload 8
    //   356: istore 12
    //   358: lload 20
    //   360: lstore 36
    //   362: lload 22
    //   364: lstore 32
    //   366: lload 18
    //   368: lstore 28
    //   370: iload 8
    //   372: istore 13
    //   374: lload 20
    //   376: lstore 38
    //   378: lload 22
    //   380: lstore 34
    //   382: lload 18
    //   384: lstore 30
    //   386: aload 49
    //   388: getfield 129	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:g	Ljava/io/FileOutputStream;
    //   391: ifnull +48 -> 439
    //   394: iload 8
    //   396: istore 12
    //   398: lload 20
    //   400: lstore 36
    //   402: lload 22
    //   404: lstore 32
    //   406: lload 18
    //   408: lstore 28
    //   410: iload 8
    //   412: istore 13
    //   414: lload 20
    //   416: lstore 38
    //   418: lload 22
    //   420: lstore 34
    //   422: lload 18
    //   424: lstore 30
    //   426: aload 49
    //   428: getfield 129	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:g	Ljava/io/FileOutputStream;
    //   431: aload 48
    //   433: iconst_0
    //   434: iload 11
    //   436: invokevirtual 135	java/io/FileOutputStream:write	([BII)V
    //   439: lload 20
    //   441: lconst_1
    //   442: ladd
    //   443: lstore 20
    //   445: iload 11
    //   447: i2l
    //   448: lstore 44
    //   450: lload 22
    //   452: lload 44
    //   454: ladd
    //   455: lstore 22
    //   457: iload 8
    //   459: istore 12
    //   461: lload 20
    //   463: lstore 36
    //   465: lload 22
    //   467: lstore 32
    //   469: lload 18
    //   471: lstore 28
    //   473: iload 8
    //   475: istore 13
    //   477: lload 20
    //   479: lstore 38
    //   481: lload 22
    //   483: lstore 34
    //   485: lload 18
    //   487: lstore 30
    //   489: ldc 137
    //   491: invokestatic 143	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   494: checkcast 137	com/tencent/mobileqq/ptt/temp/api/IQQRecorderTempApi
    //   497: aload 49
    //   499: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   502: invokestatic 89	com/tencent/mobileqq/ptt/QQRecorder:a	(Lcom/tencent/mobileqq/ptt/QQRecorder;)Landroid/content/Context;
    //   505: aload 48
    //   507: iload 11
    //   509: fconst_1
    //   510: invokeinterface 147 5 0
    //   515: l2i
    //   516: istore 17
    //   518: iload 8
    //   520: istore 12
    //   522: lload 20
    //   524: lstore 36
    //   526: lload 22
    //   528: lstore 32
    //   530: lload 18
    //   532: lstore 28
    //   534: iload 8
    //   536: istore 13
    //   538: lload 20
    //   540: lstore 38
    //   542: lload 22
    //   544: lstore 34
    //   546: lload 18
    //   548: lstore 30
    //   550: iload 8
    //   552: iload 17
    //   554: invokestatic 153	java/lang/Math:max	(II)I
    //   557: istore 8
    //   559: lload 18
    //   561: iload 17
    //   563: i2l
    //   564: ladd
    //   565: lstore 18
    //   567: iload 8
    //   569: istore 12
    //   571: lload 20
    //   573: lstore 36
    //   575: lload 22
    //   577: lstore 32
    //   579: lload 18
    //   581: lstore 28
    //   583: iload 8
    //   585: istore 13
    //   587: lload 20
    //   589: lstore 38
    //   591: lload 22
    //   593: lstore 34
    //   595: lload 18
    //   597: lstore 30
    //   599: aload 49
    //   601: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   604: getfield 156	com/tencent/mobileqq/ptt/QQRecorder:e	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   607: aload 48
    //   609: iconst_0
    //   610: iload 11
    //   612: invokevirtual 161	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	([BII)Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData;
    //   615: astore 50
    //   617: iload 8
    //   619: istore 12
    //   621: lload 20
    //   623: lstore 36
    //   625: lload 22
    //   627: lstore 32
    //   629: lload 18
    //   631: lstore 28
    //   633: iload 8
    //   635: istore 13
    //   637: lload 20
    //   639: lstore 38
    //   641: lload 22
    //   643: lstore 34
    //   645: lload 18
    //   647: lstore 30
    //   649: ldc 163
    //   651: invokestatic 143	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   654: checkcast 163	com/tencent/mobileqq/ptt/api/IPttInfoCollector
    //   657: invokeinterface 166 1 0
    //   662: iload 8
    //   664: istore 12
    //   666: lload 20
    //   668: lstore 36
    //   670: lload 22
    //   672: lstore 32
    //   674: lload 18
    //   676: lstore 28
    //   678: iload 8
    //   680: istore 13
    //   682: lload 20
    //   684: lstore 38
    //   686: lload 22
    //   688: lstore 34
    //   690: lload 18
    //   692: lstore 30
    //   694: ldc 168
    //   696: invokestatic 143	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   699: checkcast 168	com/tencent/mobileqq/ptt/IQQRecorderUtils
    //   702: aload 49
    //   704: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   707: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   710: getfield 170	com/tencent/mobileqq/utils/RecordParams$RecorderParam:a	I
    //   713: iconst_2
    //   714: iconst_2
    //   715: lload 44
    //   717: invokeinterface 174 6 0
    //   722: dstore 4
    //   724: dload_2
    //   725: dload 4
    //   727: dadd
    //   728: dstore_2
    //   729: iload 16
    //   731: i2d
    //   732: dstore 6
    //   734: dload 6
    //   736: invokestatic 180	java/lang/Double:isNaN	(D)Z
    //   739: pop
    //   740: dload 6
    //   742: dload 4
    //   744: dadd
    //   745: d2i
    //   746: istore 12
    //   748: lload 24
    //   750: lstore 30
    //   752: lload 24
    //   754: lstore 32
    //   756: aload 49
    //   758: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   761: getfield 182	com/tencent/mobileqq/ptt/QQRecorder:f	I
    //   764: iload 15
    //   766: invokestatic 153	java/lang/Math:max	(II)I
    //   769: istore 11
    //   771: iload 12
    //   773: bipush 100
    //   775: if_icmplt +937 -> 1712
    //   778: lload 24
    //   780: lstore 30
    //   782: lload 24
    //   784: lstore 32
    //   786: aload 49
    //   788: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   791: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   794: getfield 185	com/tencent/mobileqq/utils/RecordParams$RecorderParam:h	[I
    //   797: ifnull +906 -> 1703
    //   800: lload 24
    //   802: lstore 30
    //   804: lload 24
    //   806: lstore 32
    //   808: aload 49
    //   810: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   813: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   816: getfield 185	com/tencent/mobileqq/utils/RecordParams$RecorderParam:h	[I
    //   819: aload 49
    //   821: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   824: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   827: getfield 102	com/tencent/mobileqq/utils/RecordParams$RecorderParam:g	I
    //   830: iload 11
    //   832: iastore
    //   833: lload 24
    //   835: lstore 30
    //   837: lload 24
    //   839: lstore 32
    //   841: aload 49
    //   843: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   846: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   849: getfield 102	com/tencent/mobileqq/utils/RecordParams$RecorderParam:g	I
    //   852: aload 49
    //   854: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   857: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   860: getfield 185	com/tencent/mobileqq/utils/RecordParams$RecorderParam:h	[I
    //   863: arraylength
    //   864: iconst_1
    //   865: isub
    //   866: if_icmpge +837 -> 1703
    //   869: lload 24
    //   871: lstore 30
    //   873: lload 24
    //   875: lstore 32
    //   877: aload 49
    //   879: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   882: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   885: astore 51
    //   887: lload 24
    //   889: lstore 30
    //   891: lload 24
    //   893: lstore 32
    //   895: aload 51
    //   897: aload 51
    //   899: getfield 102	com/tencent/mobileqq/utils/RecordParams$RecorderParam:g	I
    //   902: iconst_1
    //   903: iadd
    //   904: putfield 102	com/tencent/mobileqq/utils/RecordParams$RecorderParam:g	I
    //   907: goto +796 -> 1703
    //   910: lload 24
    //   912: lstore 30
    //   914: lload 24
    //   916: lstore 32
    //   918: aload 49
    //   920: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   923: getfield 189	com/tencent/mobileqq/ptt/QQRecorder:p	Lcom/tencent/mobileqq/ptt/IQQRecorder$OnQQRecorderListener;
    //   926: ifnull +789 -> 1715
    //   929: aload 50
    //   931: ifnull +784 -> 1715
    //   934: lload 24
    //   936: lstore 30
    //   938: lload 24
    //   940: lstore 32
    //   942: aload 49
    //   944: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   947: getfield 189	com/tencent/mobileqq/ptt/QQRecorder:p	Lcom/tencent/mobileqq/ptt/IQQRecorder$OnQQRecorderListener;
    //   950: aload_1
    //   951: aload 50
    //   953: getfield 194	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:c	[B
    //   956: aload 50
    //   958: getfield 195	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:a	I
    //   961: aload 49
    //   963: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   966: getfield 182	com/tencent/mobileqq/ptt/QQRecorder:f	I
    //   969: dload_2
    //   970: aload 49
    //   972: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   975: getfield 98	com/tencent/mobileqq/ptt/QQRecorder:i	Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;
    //   978: invokeinterface 201 8 0
    //   983: goto +3 -> 986
    //   986: lload 24
    //   988: lstore 28
    //   990: aload 50
    //   992: ifnull +22 -> 1014
    //   995: lload 24
    //   997: lstore 30
    //   999: lload 24
    //   1001: lstore 32
    //   1003: lload 24
    //   1005: aload 50
    //   1007: getfield 195	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:a	I
    //   1010: i2l
    //   1011: ladd
    //   1012: lstore 28
    //   1014: iload 14
    //   1016: iconst_1
    //   1017: if_icmpne +707 -> 1724
    //   1020: lload 28
    //   1022: lstore 30
    //   1024: lload 28
    //   1026: lstore 32
    //   1028: aload 49
    //   1030: getfield 39	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:d	I
    //   1033: sipush 500
    //   1036: if_icmple +688 -> 1724
    //   1039: lload 28
    //   1041: lstore 30
    //   1043: lload 28
    //   1045: lstore 32
    //   1047: aload 49
    //   1049: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   1052: getfield 189	com/tencent/mobileqq/ptt/QQRecorder:p	Lcom/tencent/mobileqq/ptt/IQQRecorder$OnQQRecorderListener;
    //   1055: ifnull +25 -> 1080
    //   1058: lload 28
    //   1060: lstore 30
    //   1062: lload 28
    //   1064: lstore 32
    //   1066: aload 49
    //   1068: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   1071: getfield 189	com/tencent/mobileqq/ptt/QQRecorder:p	Lcom/tencent/mobileqq/ptt/IQQRecorder$OnQQRecorderListener;
    //   1074: iconst_2
    //   1075: invokeinterface 204 2 0
    //   1080: lload 28
    //   1082: lstore 30
    //   1084: lload 28
    //   1086: lstore 32
    //   1088: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1091: ifeq +627 -> 1718
    //   1094: lload 28
    //   1096: lstore 30
    //   1098: lload 28
    //   1100: lstore 32
    //   1102: new 53	java/lang/StringBuilder
    //   1105: dup
    //   1106: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1109: astore 50
    //   1111: lload 28
    //   1113: lstore 30
    //   1115: lload 28
    //   1117: lstore 32
    //   1119: aload 50
    //   1121: ldc 206
    //   1123: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: lload 28
    //   1129: lstore 30
    //   1131: lload 28
    //   1133: lstore 32
    //   1135: aload 50
    //   1137: aload 49
    //   1139: getfield 39	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:d	I
    //   1142: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1145: pop
    //   1146: lload 28
    //   1148: lstore 30
    //   1150: lload 28
    //   1152: lstore 32
    //   1154: ldc 65
    //   1156: iconst_2
    //   1157: aload 50
    //   1159: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: goto +553 -> 1718
    //   1168: iload 10
    //   1170: iconst_m1
    //   1171: if_icmpeq +28 -> 1199
    //   1174: dload_2
    //   1175: iload 10
    //   1177: i2d
    //   1178: dcmpl
    //   1179: iflt +20 -> 1199
    //   1182: lload 28
    //   1184: lstore 30
    //   1186: lload 28
    //   1188: lstore 32
    //   1190: aload 49
    //   1192: iconst_1
    //   1193: putfield 33	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:h	Z
    //   1196: goto +3 -> 1199
    //   1199: iload 11
    //   1201: istore 15
    //   1203: iload 13
    //   1205: istore 11
    //   1207: iload 12
    //   1209: istore 16
    //   1211: lload 28
    //   1213: lstore 24
    //   1215: goto -1051 -> 164
    //   1218: astore_1
    //   1219: lload 26
    //   1221: lstore 24
    //   1223: iload 8
    //   1225: istore 10
    //   1227: goto +204 -> 1431
    //   1230: astore 48
    //   1232: lload 26
    //   1234: lstore 24
    //   1236: iload 8
    //   1238: istore 10
    //   1240: lload 20
    //   1242: lstore 26
    //   1244: goto +248 -> 1492
    //   1247: astore_1
    //   1248: iload 12
    //   1250: istore 8
    //   1252: lload 26
    //   1254: lstore 18
    //   1256: lload 36
    //   1258: lstore 20
    //   1260: lload 32
    //   1262: lstore 22
    //   1264: goto +29 -> 1293
    //   1267: astore 48
    //   1269: iload 13
    //   1271: istore 8
    //   1273: lload 26
    //   1275: lstore 18
    //   1277: lload 38
    //   1279: lstore 20
    //   1281: goto +65 -> 1346
    //   1284: astore_1
    //   1285: lload 18
    //   1287: lstore 28
    //   1289: lload 26
    //   1291: lstore 18
    //   1293: iload 9
    //   1295: istore 10
    //   1297: iload 8
    //   1299: istore 9
    //   1301: lload 20
    //   1303: lstore 26
    //   1305: iload 10
    //   1307: istore 8
    //   1309: lload 18
    //   1311: lstore 20
    //   1313: lload 20
    //   1315: lstore 18
    //   1317: lload 22
    //   1319: lstore 20
    //   1321: lload 26
    //   1323: lstore 22
    //   1325: lload 28
    //   1327: lstore 26
    //   1329: goto +344 -> 1673
    //   1332: astore 48
    //   1334: lload 18
    //   1336: lstore 30
    //   1338: lload 22
    //   1340: lstore 34
    //   1342: lload 26
    //   1344: lstore 18
    //   1346: iload 9
    //   1348: istore 10
    //   1350: lload 30
    //   1352: lstore 22
    //   1354: lload 20
    //   1356: lstore 26
    //   1358: iload 8
    //   1360: istore 9
    //   1362: iload 10
    //   1364: istore 8
    //   1366: lload 18
    //   1368: lstore 28
    //   1370: lload 34
    //   1372: lstore 20
    //   1374: lload 22
    //   1376: lstore 30
    //   1378: lload 28
    //   1380: lstore 18
    //   1382: lload 24
    //   1384: lstore 22
    //   1386: lload 30
    //   1388: lstore 24
    //   1390: goto +202 -> 1592
    //   1393: aload 49
    //   1395: aload_1
    //   1396: dload_2
    //   1397: invokevirtual 212	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(Ljava/lang/String;D)V
    //   1400: iconst_0
    //   1401: istore 46
    //   1403: lload 20
    //   1405: lstore 28
    //   1407: iload 8
    //   1409: istore 10
    //   1411: lload 18
    //   1413: lstore 30
    //   1415: goto +217 -> 1632
    //   1418: astore_1
    //   1419: lload 24
    //   1421: lstore 30
    //   1423: iload 8
    //   1425: istore 10
    //   1427: lload 26
    //   1429: lstore 24
    //   1431: lload 20
    //   1433: lstore 26
    //   1435: iload 9
    //   1437: istore 8
    //   1439: lload 22
    //   1441: lstore 20
    //   1443: lload 18
    //   1445: lstore 28
    //   1447: lload 24
    //   1449: lstore 18
    //   1451: lload 26
    //   1453: lstore 22
    //   1455: lload 30
    //   1457: lstore 24
    //   1459: iload 10
    //   1461: istore 9
    //   1463: lload 28
    //   1465: lstore 26
    //   1467: goto +206 -> 1673
    //   1470: astore 48
    //   1472: lload 26
    //   1474: lstore 28
    //   1476: lload 24
    //   1478: lstore 32
    //   1480: lload 20
    //   1482: lstore 26
    //   1484: iload 8
    //   1486: istore 10
    //   1488: lload 28
    //   1490: lstore 24
    //   1492: iload 9
    //   1494: istore 8
    //   1496: lload 22
    //   1498: lstore 20
    //   1500: lload 18
    //   1502: lstore 28
    //   1504: lload 24
    //   1506: lstore 18
    //   1508: lload 32
    //   1510: lstore 22
    //   1512: iload 10
    //   1514: istore 9
    //   1516: lload 28
    //   1518: lstore 24
    //   1520: goto +72 -> 1592
    //   1523: astore_1
    //   1524: goto +9 -> 1533
    //   1527: astore 48
    //   1529: goto +36 -> 1565
    //   1532: astore_1
    //   1533: dconst_0
    //   1534: dstore_2
    //   1535: lconst_0
    //   1536: lstore 18
    //   1538: lload 18
    //   1540: lstore 22
    //   1542: lload 22
    //   1544: lstore 24
    //   1546: lload 24
    //   1548: lstore 26
    //   1550: iconst_0
    //   1551: istore 8
    //   1553: iconst_0
    //   1554: istore 9
    //   1556: lload 28
    //   1558: lstore 20
    //   1560: goto +113 -> 1673
    //   1563: astore 48
    //   1565: iconst_0
    //   1566: istore 8
    //   1568: iconst_0
    //   1569: istore 9
    //   1571: dconst_0
    //   1572: dstore_2
    //   1573: lconst_0
    //   1574: lstore 18
    //   1576: lload 18
    //   1578: lstore 22
    //   1580: lload 22
    //   1582: lstore 24
    //   1584: lload 24
    //   1586: lstore 26
    //   1588: lload 28
    //   1590: lstore 20
    //   1592: aload_0
    //   1593: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   1596: aload_1
    //   1597: aload 48
    //   1599: invokestatic 215	com/tencent/mobileqq/ptt/QQRecorder:a	(Lcom/tencent/mobileqq/ptt/QQRecorder;Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1602: istore 46
    //   1604: lload 24
    //   1606: lstore 30
    //   1608: iload 9
    //   1610: istore 10
    //   1612: lload 22
    //   1614: lstore 24
    //   1616: lload 26
    //   1618: lstore 28
    //   1620: iload 8
    //   1622: istore 9
    //   1624: lload 20
    //   1626: lstore 22
    //   1628: lload 18
    //   1630: lstore 26
    //   1632: aload_0
    //   1633: lload 26
    //   1635: lload 22
    //   1637: iload 9
    //   1639: dload_2
    //   1640: lload 28
    //   1642: lload 40
    //   1644: lload 24
    //   1646: iload 46
    //   1648: iload 10
    //   1650: lload 30
    //   1652: invokevirtual 218	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(JJIDJJJZIJ)V
    //   1655: return
    //   1656: astore_1
    //   1657: lload 26
    //   1659: lstore 28
    //   1661: lload 24
    //   1663: lstore 26
    //   1665: lload 22
    //   1667: lstore 24
    //   1669: lload 28
    //   1671: lstore 22
    //   1673: aload_0
    //   1674: lload 18
    //   1676: lload 20
    //   1678: iload 8
    //   1680: dload_2
    //   1681: lload 22
    //   1683: lload 40
    //   1685: lload 24
    //   1687: iconst_0
    //   1688: iload 9
    //   1690: lload 26
    //   1692: invokevirtual 218	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(JJIDJJJZIJ)V
    //   1695: goto +5 -> 1700
    //   1698: aload_1
    //   1699: athrow
    //   1700: goto -2 -> 1698
    //   1703: iconst_0
    //   1704: istore 11
    //   1706: iconst_0
    //   1707: istore 12
    //   1709: goto -799 -> 910
    //   1712: goto -802 -> 910
    //   1715: goto -729 -> 986
    //   1718: iconst_2
    //   1719: istore 13
    //   1721: goto -553 -> 1168
    //   1724: iload 14
    //   1726: istore 13
    //   1728: goto -560 -> 1168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1731	0	this	RecordThread
    //   0	1731	1	paramString	String
    //   46	1635	2	d1	double
    //   722	21	4	d2	double
    //   732	9	6	d3	double
    //   149	1530	8	i	int
    //   158	1531	9	j	int
    //   120	1529	10	k	int
    //   146	1559	11	m	int
    //   221	1487	12	n	int
    //   237	1490	13	i1	int
    //   211	1514	14	i2	int
    //   143	1059	15	i3	int
    //   152	1058	16	i4	int
    //   516	46	17	i5	int
    //   140	1535	18	l1	long
    //   128	1549	20	l2	long
    //   136	1546	22	l3	long
    //   132	1554	24	l4	long
    //   162	1529	26	l5	long
    //   94	1576	28	l6	long
    //   249	1402	30	l7	long
    //   229	1280	32	l8	long
    //   245	1126	34	l9	long
    //   225	1032	36	l10	long
    //   241	1037	38	l11	long
    //   50	1634	40	l12	long
    //   125	80	42	l13	long
    //   448	268	44	l14	long
    //   155	1492	46	bool1	boolean
    //   169	3	47	bool2	boolean
    //   16	244	48	localObject1	Object
    //   325	283	48	localThrowable1	java.lang.Throwable
    //   1230	1	48	localThrowable2	java.lang.Throwable
    //   1267	1	48	localThrowable3	java.lang.Throwable
    //   1332	1	48	localThrowable4	java.lang.Throwable
    //   1470	1	48	localThrowable5	java.lang.Throwable
    //   1527	1	48	localThrowable6	java.lang.Throwable
    //   1563	35	48	localThrowable7	java.lang.Throwable
    //   1	1393	49	localRecordThread	RecordThread
    //   615	543	50	localObject2	Object
    //   885	13	51	localRecorderParam	RecordParams.RecorderParam
    // Exception table:
    //   from	to	target	type
    //   280	286	297	finally
    //   280	286	325	java/lang/Throwable
    //   756	771	1218	finally
    //   786	800	1218	finally
    //   808	833	1218	finally
    //   841	869	1218	finally
    //   877	887	1218	finally
    //   895	907	1218	finally
    //   918	929	1218	finally
    //   942	983	1218	finally
    //   1003	1014	1218	finally
    //   1028	1039	1218	finally
    //   1047	1058	1218	finally
    //   1066	1080	1218	finally
    //   1088	1094	1218	finally
    //   1102	1111	1218	finally
    //   1119	1127	1218	finally
    //   1135	1146	1218	finally
    //   1154	1165	1218	finally
    //   1190	1196	1218	finally
    //   756	771	1230	java/lang/Throwable
    //   786	800	1230	java/lang/Throwable
    //   808	833	1230	java/lang/Throwable
    //   841	869	1230	java/lang/Throwable
    //   877	887	1230	java/lang/Throwable
    //   895	907	1230	java/lang/Throwable
    //   918	929	1230	java/lang/Throwable
    //   942	983	1230	java/lang/Throwable
    //   1003	1014	1230	java/lang/Throwable
    //   1028	1039	1230	java/lang/Throwable
    //   1047	1058	1230	java/lang/Throwable
    //   1066	1080	1230	java/lang/Throwable
    //   1088	1094	1230	java/lang/Throwable
    //   1102	1111	1230	java/lang/Throwable
    //   1119	1127	1230	java/lang/Throwable
    //   1135	1146	1230	java/lang/Throwable
    //   1154	1165	1230	java/lang/Throwable
    //   1190	1196	1230	java/lang/Throwable
    //   251	275	1247	finally
    //   386	394	1247	finally
    //   426	439	1247	finally
    //   489	518	1247	finally
    //   550	559	1247	finally
    //   599	617	1247	finally
    //   649	662	1247	finally
    //   694	724	1247	finally
    //   251	275	1267	java/lang/Throwable
    //   386	394	1267	java/lang/Throwable
    //   426	439	1267	java/lang/Throwable
    //   489	518	1267	java/lang/Throwable
    //   550	559	1267	java/lang/Throwable
    //   599	617	1267	java/lang/Throwable
    //   649	662	1267	java/lang/Throwable
    //   694	724	1267	java/lang/Throwable
    //   176	213	1284	finally
    //   176	213	1332	java/lang/Throwable
    //   164	171	1418	finally
    //   1393	1400	1418	finally
    //   164	171	1470	java/lang/Throwable
    //   1393	1400	1470	java/lang/Throwable
    //   122	127	1523	finally
    //   122	127	1527	java/lang/Throwable
    //   96	122	1532	finally
    //   96	122	1563	java/lang/Throwable
    //   1592	1604	1656	finally
  }
  
  protected int a(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (System.currentTimeMillis() - paramLong > 1000L)
    {
      i = paramInt;
      if (paramInt == 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("check 1000ms max volume, volume: ");
          localStringBuilder.append(this.d);
          QLog.d("QQRecorder", 2, localStringBuilder.toString());
        }
        paramInt = this.d;
        if ((paramInt > 0) && (paramInt < 500)) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        i = paramInt;
        if (this.this$0.p != null)
        {
          this.this$0.p.onRecorderVolumeStateChanged(paramInt);
          i = paramInt;
        }
      }
    }
    return i;
  }
  
  protected int a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.this$0.p != null) {
      this.this$0.p.onRecorderPrepare(paramString, this.this$0.i);
    }
    this.this$0.f();
    int i;
    if (this.this$0.p != null)
    {
      i = this.this$0.p.onRecorderStart();
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = 250;
      }
      paramInt2 = QQRecorder.a(paramInt2);
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("PTT onRecordReady cost : ");
      paramString.append(SystemClock.uptimeMillis() - ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).getsCostUntilPrepare());
      QLog.d("QQRecorder", 4, paramString.toString());
    }
    this.this$0.g();
    this.this$0.e.a(this);
    Thread.sleep(200L);
    int k = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).bytesInSecond(this.this$0.i.a) / 1000 * paramInt2;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      i = this.this$0.d;
      int m = this.this$0.d;
      int j = k - paramInt2;
      if (m > j) {
        i = j;
      }
      this.this$0.a.read(paramArrayOfByte, 0, i);
      paramInt2 += i;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("MyThread abandonBuf,  abandonSize:");
      paramString.append(paramInt2);
      paramString.append(" abandonBufLen:");
      paramString.append(k);
      QLog.d("QQRecorder", 2, paramString.toString());
    }
    if (this.this$0.p != null)
    {
      paramInt2 = this.this$0.p.onBeginReceiveData(this.b, this.this$0.i);
      i = paramInt2 / 1000 * 10;
      paramInt1 = i;
      if (i > 6000) {
        paramInt1 = 6000;
      }
      this.this$0.i.h = new int[paramInt1];
      paramInt1 = paramInt2;
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("PTT onBeginReceiveData cost : ");
      paramString.append(SystemClock.uptimeMillis() - ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).getsCostUntilPrepare());
      QLog.d("QQRecorder", 4, paramString.toString());
    }
    return paramInt1;
  }
  
  public void a()
  {
    if (this.this$0.l != null)
    {
      this.f = new File(this.this$0.l);
      if (this.f.exists()) {
        this.f.delete();
      }
      try
      {
        this.g = new FileOutputStream(this.f.getAbsoluteFile());
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  /* Error */
  protected void a(long paramLong1, long paramLong2, int paramInt1, double paramDouble, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean, int paramInt2, long paramLong6)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   4: getfield 115	com/tencent/mobileqq/ptt/QQRecorder:a	Landroid/media/AudioRecord;
    //   7: ifnull +27 -> 34
    //   10: aload_0
    //   11: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   14: getfield 115	com/tencent/mobileqq/ptt/QQRecorder:a	Landroid/media/AudioRecord;
    //   17: invokevirtual 303	android/media/AudioRecord:getState	()I
    //   20: iconst_1
    //   21: if_icmpne +13 -> 34
    //   24: aload_0
    //   25: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   28: getfield 115	com/tencent/mobileqq/ptt/QQRecorder:a	Landroid/media/AudioRecord;
    //   31: invokevirtual 306	android/media/AudioRecord:stop	()V
    //   34: aload_0
    //   35: getfield 129	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:g	Ljava/io/FileOutputStream;
    //   38: ifnull +15 -> 53
    //   41: aload_0
    //   42: getfield 129	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:g	Ljava/io/FileOutputStream;
    //   45: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 129	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:g	Ljava/io/FileOutputStream;
    //   53: aload_0
    //   54: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   57: invokevirtual 311	com/tencent/mobileqq/ptt/QQRecorder:h	()V
    //   60: goto +10 -> 70
    //   63: astore 19
    //   65: aload 19
    //   67: invokevirtual 312	java/lang/Throwable:printStackTrace	()V
    //   70: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +125 -> 198
    //   76: new 53	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   83: astore 19
    //   85: aload 19
    //   87: ldc_w 314
    //   90: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 19
    //   96: aload_0
    //   97: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 65
    //   103: iconst_2
    //   104: aload 19
    //   106: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: new 53	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   119: astore 19
    //   121: aload 19
    //   123: ldc_w 316
    //   126: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 19
    //   132: lload_1
    //   133: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 19
    //   139: ldc_w 318
    //   142: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 19
    //   148: lload_3
    //   149: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 19
    //   155: ldc_w 320
    //   158: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 19
    //   164: lload 12
    //   166: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 19
    //   172: ldc_w 322
    //   175: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 19
    //   181: iload 5
    //   183: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 65
    //   189: iconst_2
    //   190: aload 19
    //   192: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 26	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/ptt/QQRecorder;
    //   202: invokestatic 89	com/tencent/mobileqq/ptt/QQRecorder:a	(Lcom/tencent/mobileqq/ptt/QQRecorder;)Landroid/content/Context;
    //   205: iconst_0
    //   206: invokestatic 94	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   209: pop
    //   210: aload_0
    //   211: dload 6
    //   213: lload 10
    //   215: lload 12
    //   217: iload 14
    //   219: invokevirtual 325	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(DJJZ)Z
    //   222: ifeq +431 -> 653
    //   225: aload_0
    //   226: invokevirtual 328	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:b	()Ljava/util/HashMap;
    //   229: astore 19
    //   231: aload 19
    //   233: ldc_w 330
    //   236: ldc_w 332
    //   239: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   242: pop
    //   243: new 53	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   250: astore 20
    //   252: aload 20
    //   254: getstatic 343	android/os/Build$VERSION:SDK_INT	I
    //   257: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 20
    //   263: ldc_w 345
    //   266: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 19
    //   272: ldc_w 347
    //   275: aload 20
    //   277: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: new 53	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   291: astore 20
    //   293: aload 20
    //   295: getstatic 352	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   298: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 20
    //   304: ldc_w 354
    //   307: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 20
    //   313: getstatic 357	android/os/Build:MODEL	Ljava/lang/String;
    //   316: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 19
    //   322: ldc_w 359
    //   325: aload 20
    //   327: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: new 53	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   341: astore 20
    //   343: aload 20
    //   345: lload_3
    //   346: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 20
    //   352: ldc_w 345
    //   355: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 19
    //   361: ldc_w 361
    //   364: aload 20
    //   366: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: new 53	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   380: astore 20
    //   382: aload 20
    //   384: iload 15
    //   386: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 20
    //   392: ldc_w 345
    //   395: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 19
    //   401: ldc_w 363
    //   404: aload 20
    //   406: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: pop
    //   413: new 53	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   420: astore 20
    //   422: aload 20
    //   424: dload 6
    //   426: invokevirtual 366	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 20
    //   432: ldc_w 345
    //   435: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 19
    //   441: ldc_w 368
    //   444: aload 20
    //   446: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: new 53	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   460: astore 20
    //   462: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   465: lstore_1
    //   466: aload 20
    //   468: lload_1
    //   469: lload 10
    //   471: lsub
    //   472: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 20
    //   478: ldc_w 345
    //   481: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 19
    //   487: ldc_w 370
    //   490: aload 20
    //   492: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: pop
    //   499: aload_0
    //   500: ldc_w 372
    //   503: iconst_0
    //   504: aload 19
    //   506: invokevirtual 375	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   509: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +111 -> 623
    //   515: new 53	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   522: astore 19
    //   524: aload 19
    //   526: ldc_w 377
    //   529: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 19
    //   535: lload_3
    //   536: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 19
    //   542: ldc_w 379
    //   545: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 19
    //   551: lload 12
    //   553: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 19
    //   559: ldc_w 381
    //   562: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 19
    //   568: dload 6
    //   570: invokevirtual 366	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 19
    //   576: ldc_w 383
    //   579: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 19
    //   585: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   588: lload 10
    //   590: lsub
    //   591: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 19
    //   597: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: astore 19
    //   602: ldc 65
    //   604: iconst_2
    //   605: aload 19
    //   607: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: goto +43 -> 653
    //   613: astore 19
    //   615: goto +18 -> 633
    //   618: astore 19
    //   620: goto +13 -> 633
    //   623: goto +30 -> 653
    //   626: astore 19
    //   628: goto +5 -> 633
    //   631: astore 19
    //   633: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +17 -> 653
    //   639: ldc 65
    //   641: iconst_2
    //   642: ldc_w 385
    //   645: aload 19
    //   647: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   650: goto +3 -> 653
    //   653: aload_0
    //   654: invokevirtual 328	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:b	()Ljava/util/HashMap;
    //   657: astore 19
    //   659: new 53	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   666: astore 20
    //   668: aload 20
    //   670: getstatic 343	android/os/Build$VERSION:SDK_INT	I
    //   673: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 20
    //   679: ldc_w 345
    //   682: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 19
    //   688: ldc_w 347
    //   691: aload 20
    //   693: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   699: pop
    //   700: new 53	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   707: astore 20
    //   709: aload 20
    //   711: getstatic 352	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   714: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 20
    //   720: ldc_w 354
    //   723: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 20
    //   729: getstatic 357	android/os/Build:MODEL	Ljava/lang/String;
    //   732: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 19
    //   738: ldc_w 359
    //   741: aload 20
    //   743: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   749: pop
    //   750: new 53	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   757: astore 20
    //   759: aload 20
    //   761: lload_3
    //   762: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 20
    //   768: ldc_w 345
    //   771: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload 19
    //   777: ldc_w 361
    //   780: aload 20
    //   782: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   788: pop
    //   789: new 53	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   796: astore 20
    //   798: aload 20
    //   800: dload 6
    //   802: invokevirtual 366	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload 20
    //   808: ldc_w 345
    //   811: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 19
    //   817: ldc_w 390
    //   820: aload 20
    //   822: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   828: pop
    //   829: new 53	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   836: astore 20
    //   838: aload 20
    //   840: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   843: lload 10
    //   845: lsub
    //   846: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload 20
    //   852: ldc_w 345
    //   855: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 19
    //   861: ldc_w 370
    //   864: aload 20
    //   866: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   872: pop
    //   873: new 53	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   880: astore 20
    //   882: aload 20
    //   884: iload 15
    //   886: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 20
    //   892: ldc_w 345
    //   895: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 19
    //   901: ldc_w 363
    //   904: aload 20
    //   906: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   912: pop
    //   913: new 53	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   920: astore 20
    //   922: aload 20
    //   924: aload_0
    //   925: getfield 39	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:d	I
    //   928: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload 20
    //   934: ldc_w 345
    //   937: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload 19
    //   943: ldc_w 392
    //   946: aload 20
    //   948: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   954: pop
    //   955: lload 8
    //   957: lconst_0
    //   958: lcmp
    //   959: ifne +10 -> 969
    //   962: ldc2_w 393
    //   965: lstore_1
    //   966: goto +305 -> 1271
    //   969: lload 16
    //   971: lload 8
    //   973: ldiv
    //   974: lstore_1
    //   975: goto +296 -> 1271
    //   978: aload_0
    //   979: getfield 41	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:e	J
    //   982: lload 8
    //   984: ldiv
    //   985: lstore_1
    //   986: lload_1
    //   987: l2i
    //   988: istore 5
    //   990: new 53	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   997: astore 20
    //   999: aload 20
    //   1001: iload 18
    //   1003: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload 20
    //   1009: ldc_w 345
    //   1012: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload 19
    //   1018: ldc_w 396
    //   1021: aload 20
    //   1023: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1029: pop
    //   1030: new 53	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1037: astore 20
    //   1039: aload 20
    //   1041: iload 5
    //   1043: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 20
    //   1049: ldc_w 345
    //   1052: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 19
    //   1058: ldc_w 398
    //   1061: aload 20
    //   1063: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: pop
    //   1070: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1073: ifeq +162 -> 1235
    //   1076: new 53	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1083: astore 20
    //   1085: aload 20
    //   1087: ldc_w 400
    //   1090: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: pop
    //   1094: aload 20
    //   1096: iload 15
    //   1098: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 20
    //   1104: ldc_w 402
    //   1107: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 20
    //   1113: iload 18
    //   1115: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload 20
    //   1121: ldc_w 404
    //   1124: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 20
    //   1130: iload 5
    //   1132: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 20
    //   1138: ldc_w 406
    //   1141: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload 20
    //   1147: iload 5
    //   1149: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 20
    //   1155: ldc_w 408
    //   1158: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 20
    //   1164: lload_3
    //   1165: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 20
    //   1171: ldc_w 410
    //   1174: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 20
    //   1180: lload 12
    //   1182: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 20
    //   1188: ldc_w 412
    //   1191: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload 20
    //   1197: dload 6
    //   1199: invokevirtual 366	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1202: pop
    //   1203: aload 20
    //   1205: ldc_w 414
    //   1208: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload 20
    //   1214: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1217: lload 10
    //   1219: lsub
    //   1220: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: ldc 65
    //   1226: iconst_2
    //   1227: aload 20
    //   1229: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1235: aload_0
    //   1236: ldc_w 416
    //   1239: iconst_1
    //   1240: aload 19
    //   1242: invokevirtual 375	com/tencent/mobileqq/ptt/QQRecorder$RecordThread:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1245: return
    //   1246: astore 19
    //   1248: goto +5 -> 1253
    //   1251: astore 19
    //   1253: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1256: ifeq +14 -> 1270
    //   1259: ldc 65
    //   1261: iconst_2
    //   1262: ldc_w 418
    //   1265: aload 19
    //   1267: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1270: return
    //   1271: lload_1
    //   1272: l2i
    //   1273: istore 18
    //   1275: lload 8
    //   1277: lconst_0
    //   1278: lcmp
    //   1279: ifne -301 -> 978
    //   1282: ldc2_w 393
    //   1285: lstore_1
    //   1286: goto -300 -> 986
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1289	0	this	RecordThread
    //   0	1289	1	paramLong1	long
    //   0	1289	3	paramLong2	long
    //   0	1289	5	paramInt1	int
    //   0	1289	6	paramDouble	double
    //   0	1289	8	paramLong3	long
    //   0	1289	10	paramLong4	long
    //   0	1289	12	paramLong5	long
    //   0	1289	14	paramBoolean	boolean
    //   0	1289	15	paramInt2	int
    //   0	1289	16	paramLong6	long
    //   1001	273	18	i	int
    //   63	3	19	localThrowable	java.lang.Throwable
    //   83	523	19	localObject	Object
    //   613	1	19	localException1	java.lang.Exception
    //   618	1	19	localException2	java.lang.Exception
    //   626	1	19	localException3	java.lang.Exception
    //   631	15	19	localException4	java.lang.Exception
    //   657	584	19	localHashMap	HashMap
    //   1246	1	19	localException5	java.lang.Exception
    //   1251	15	19	localException6	java.lang.Exception
    //   250	978	20	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	53	63	java/lang/Throwable
    //   53	60	63	java/lang/Throwable
    //   602	610	613	java/lang/Exception
    //   549	602	618	java/lang/Exception
    //   466	549	626	java/lang/Exception
    //   225	466	631	java/lang/Exception
    //   922	955	1246	java/lang/Exception
    //   969	975	1246	java/lang/Exception
    //   978	986	1246	java/lang/Exception
    //   990	1235	1246	java/lang/Exception
    //   1235	1245	1246	java/lang/Exception
    //   653	922	1251	java/lang/Exception
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof WechatNsWrapper)) && (this.this$0.k != null)) {
      this.this$0.k.beforeProcess(paramIAudioProcessor, paramProcessData);
    }
  }
  
  protected void a(String paramString, double paramDouble)
  {
    FileOutputStream localFileOutputStream = this.g;
    if (localFileOutputStream != null) {
      localFileOutputStream.flush();
    }
    if (this.this$0.p != null)
    {
      this.this$0.p.onRecorderEnd(paramString, this.this$0.i, paramDouble);
      if ((this.this$0.b != null) && (this.this$0.g != -1)) {
        this.this$0.b.setMode(0);
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    QQRecorder.a(paramString, paramBoolean, paramHashMap);
  }
  
  protected boolean a(double paramDouble, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return ((paramLong2 < 512L) || (paramDouble < 1000.0D)) && (!paramBoolean) && (System.currentTimeMillis() - paramLong1 > 1000L);
  }
  
  @NotNull
  protected HashMap<String, String> b()
  {
    return new HashMap();
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if ((paramIAudioProcessor instanceof WechatNsWrapper))
    {
      this.this$0.f = ((int)((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).AudioHelper_enlargeVolumWrapper(QQRecorder.a(this.this$0), paramProcessData.c, paramProcessData.a, 1.0F));
      this.d = Math.max(this.d, this.this$0.f);
      this.e += this.this$0.f;
      if (this.this$0.k != null) {
        this.this$0.k.afterProcess(paramIAudioProcessor, paramProcessData);
      }
    }
  }
  
  public boolean c()
  {
    return (this.c) || (this.this$0.a != null);
  }
  
  public void d()
  {
    if (this.this$0.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "releaseRecorder");
      }
      this.this$0.a.release();
      this.this$0.a = null;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "RecordThread : begin run");
        }
        this.a = true;
        this.h = false;
        a(this.b);
        if (!this.c) {
          continue;
        }
        try
        {
          long l = SystemClock.uptimeMillis();
          synchronized (this.this$0)
          {
            this.this$0.wait(QQRecorder.j);
            if (SystemClock.uptimeMillis() - l < QQRecorder.j) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQRecorder", 2, "RecordThread more than maxtime release");
            }
            try
            {
              this.c = false;
              d();
              continue;
            }
            finally {}
          }
          d();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.QQRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */