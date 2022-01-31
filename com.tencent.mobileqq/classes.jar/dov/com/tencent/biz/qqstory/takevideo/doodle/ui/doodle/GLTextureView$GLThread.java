package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bker;
import bkes;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GLTextureView$GLThread
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private bker jdField_a_of_type_Bker;
  private WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private boolean n;
  private boolean o = true;
  
  GLTextureView$GLThread(WeakReference<GLTextureView> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean b()
  {
    return (!this.e) && (this.f) && (!this.g) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.m) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void f()
  {
    if (this.j)
    {
      this.j = false;
      this.jdField_a_of_type_Bker.b();
    }
  }
  
  private void g()
  {
    if (this.i)
    {
      this.jdField_a_of_type_Bker.c();
      this.i = false;
      GLTextureView.a().b(this);
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 67	bker
    //   4: dup
    //   5: aload_0
    //   6: getfield 48	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 87	bker:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   25: iconst_0
    //   26: istore 10
    //   28: aconst_null
    //   29: astore 22
    //   31: iconst_0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_3
    //   35: iconst_0
    //   36: istore 5
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 7
    //   44: iconst_0
    //   45: istore 8
    //   47: iconst_0
    //   48: istore 9
    //   50: aconst_null
    //   51: astore 21
    //   53: iconst_0
    //   54: istore_2
    //   55: iconst_0
    //   56: istore 4
    //   58: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   61: astore 23
    //   63: aload 23
    //   65: monitorenter
    //   66: iload 10
    //   68: istore 11
    //   70: iload 7
    //   72: istore 10
    //   74: iload 4
    //   76: istore 14
    //   78: aload_0
    //   79: getfield 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_b_of_type_Boolean	Z
    //   82: ifeq +34 -> 116
    //   85: aload 23
    //   87: monitorexit
    //   88: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   91: astore 21
    //   93: aload 21
    //   95: monitorenter
    //   96: aload_0
    //   97: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   100: aload_0
    //   101: invokespecial 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   104: aload 21
    //   106: monitorexit
    //   107: return
    //   108: astore 22
    //   110: aload 21
    //   112: monitorexit
    //   113: aload 22
    //   115: athrow
    //   116: aload_0
    //   117: getfield 36	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: invokevirtual 96	java/util/ArrayList:isEmpty	()Z
    //   123: ifne +93 -> 216
    //   126: aload_0
    //   127: getfield 36	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: iconst_0
    //   131: invokevirtual 100	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   134: checkcast 102	java/lang/Runnable
    //   137: astore 21
    //   139: iload 10
    //   141: istore 7
    //   143: iload 6
    //   145: istore 12
    //   147: iload_1
    //   148: istore 4
    //   150: iload 11
    //   152: istore 10
    //   154: iload 7
    //   156: istore 6
    //   158: iload 12
    //   160: istore 7
    //   162: iload_2
    //   163: istore_1
    //   164: iload 14
    //   166: istore_2
    //   167: aload 23
    //   169: monitorexit
    //   170: aload 21
    //   172: ifnull +648 -> 820
    //   175: aload 21
    //   177: invokeinterface 105 1 0
    //   182: iload 6
    //   184: istore 11
    //   186: aconst_null
    //   187: astore 21
    //   189: iload_1
    //   190: istore 12
    //   192: iload_2
    //   193: istore 6
    //   195: iload 4
    //   197: istore_1
    //   198: iload 12
    //   200: istore_2
    //   201: iload 6
    //   203: istore 4
    //   205: iload 7
    //   207: istore 6
    //   209: iload 11
    //   211: istore 7
    //   213: goto -155 -> 58
    //   216: aload_0
    //   217: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:e	Z
    //   220: aload_0
    //   221: getfield 107	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   224: if_icmpeq +1055 -> 1279
    //   227: aload_0
    //   228: getfield 107	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   231: istore 19
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 107	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   238: putfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:e	Z
    //   241: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   244: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_0
    //   251: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:l	Z
    //   254: ifeq +19 -> 273
    //   257: aload_0
    //   258: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   261: aload_0
    //   262: invokespecial 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:l	Z
    //   270: iconst_1
    //   271: istore 4
    //   273: iload 10
    //   275: istore 7
    //   277: iload 10
    //   279: ifeq +14 -> 293
    //   282: aload_0
    //   283: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   286: aload_0
    //   287: invokespecial 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   290: iconst_0
    //   291: istore 7
    //   293: iload 19
    //   295: ifeq +14 -> 309
    //   298: aload_0
    //   299: getfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   309: iload 19
    //   311: ifeq +48 -> 359
    //   314: aload_0
    //   315: getfield 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   318: ifeq +41 -> 359
    //   321: aload_0
    //   322: getfield 48	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   325: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   328: checkcast 75	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   331: astore 24
    //   333: aload 24
    //   335: ifnonnull +346 -> 681
    //   338: iconst_0
    //   339: istore 20
    //   341: iload 20
    //   343: ifeq +12 -> 355
    //   346: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   349: invokevirtual 122	bkes:a	()Z
    //   352: ifeq +7 -> 359
    //   355: aload_0
    //   356: invokespecial 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   359: iload 19
    //   361: ifeq +19 -> 380
    //   364: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   367: invokevirtual 124	bkes:b	()Z
    //   370: ifeq +10 -> 380
    //   373: aload_0
    //   374: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   377: invokevirtual 73	bker:c	()V
    //   380: aload_0
    //   381: getfield 59	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	Z
    //   384: ifne +71 -> 455
    //   387: aload_0
    //   388: getfield 126	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   391: ifne +64 -> 455
    //   394: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +31 -> 428
    //   400: ldc 133
    //   402: iconst_2
    //   403: new 135	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   410: ldc 138
    //   412: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: invokevirtual 146	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
    //   419: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: getfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   432: ifeq +7 -> 439
    //   435: aload_0
    //   436: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   439: aload_0
    //   440: iconst_1
    //   441: putfield 126	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   444: aload_0
    //   445: iconst_0
    //   446: putfield 61	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   449: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   452: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   455: aload_0
    //   456: getfield 59	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	Z
    //   459: ifeq +21 -> 480
    //   462: aload_0
    //   463: getfield 126	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   466: ifeq +14 -> 480
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 126	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   474: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   477: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   480: iload 14
    //   482: istore 12
    //   484: iload 5
    //   486: istore 13
    //   488: iload 14
    //   490: ifeq +20 -> 510
    //   493: iconst_0
    //   494: istore 13
    //   496: iconst_0
    //   497: istore 12
    //   499: aload_0
    //   500: iconst_1
    //   501: putfield 158	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:n	Z
    //   504: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   507: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   510: iload 4
    //   512: istore_3
    //   513: iload 6
    //   515: istore 15
    //   517: iload 8
    //   519: istore 16
    //   521: iload 9
    //   523: istore 17
    //   525: iload 11
    //   527: istore 18
    //   529: aload_0
    //   530: invokespecial 159	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:b	()Z
    //   533: ifeq +250 -> 783
    //   536: iload 4
    //   538: istore_3
    //   539: iload 11
    //   541: istore 10
    //   543: aload_0
    //   544: getfield 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   547: ifne +14 -> 561
    //   550: iload 4
    //   552: ifeq +139 -> 691
    //   555: iconst_0
    //   556: istore_3
    //   557: iload 11
    //   559: istore 10
    //   561: aload_0
    //   562: getfield 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   565: ifeq +703 -> 1268
    //   568: aload_0
    //   569: getfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   572: ifne +696 -> 1268
    //   575: aload_0
    //   576: iconst_1
    //   577: putfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   580: iconst_1
    //   581: istore 9
    //   583: iconst_1
    //   584: istore 5
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_0
    //   590: getfield 63	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   593: ifeq +695 -> 1288
    //   596: aload_0
    //   597: getfield 38	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:o	Z
    //   600: ifeq +651 -> 1251
    //   603: iconst_1
    //   604: istore_2
    //   605: aload_0
    //   606: getfield 40	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Int	I
    //   609: istore 6
    //   611: aload_0
    //   612: getfield 42	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_b_of_type_Int	I
    //   615: istore_1
    //   616: iconst_1
    //   617: istore 8
    //   619: iconst_1
    //   620: istore 5
    //   622: aload_0
    //   623: iconst_0
    //   624: putfield 38	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:o	Z
    //   627: aload_0
    //   628: iconst_0
    //   629: putfield 44	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:m	Z
    //   632: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   635: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   638: iload 4
    //   640: istore 11
    //   642: iload 12
    //   644: istore 4
    //   646: iload 6
    //   648: istore 12
    //   650: iload 7
    //   652: istore 6
    //   654: iload_2
    //   655: istore 7
    //   657: iload 5
    //   659: istore 9
    //   661: iload 4
    //   663: istore_2
    //   664: iload_1
    //   665: istore 4
    //   667: iload 12
    //   669: istore_1
    //   670: iload 8
    //   672: istore 5
    //   674: iload 11
    //   676: istore 8
    //   678: goto -511 -> 167
    //   681: aload 24
    //   683: invokestatic 162	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Z
    //   686: istore 20
    //   688: goto -347 -> 341
    //   691: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   694: aload_0
    //   695: invokevirtual 165	bkes:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)Z
    //   698: istore 19
    //   700: iload 4
    //   702: istore_3
    //   703: iload 11
    //   705: istore 10
    //   707: iload 19
    //   709: ifeq -148 -> 561
    //   712: aload_0
    //   713: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   716: invokevirtual 167	bker:a	()V
    //   719: aload_0
    //   720: iconst_1
    //   721: putfield 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   724: iconst_1
    //   725: istore 10
    //   727: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   730: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   733: iload 4
    //   735: istore_3
    //   736: goto -175 -> 561
    //   739: astore 21
    //   741: aload 23
    //   743: monitorexit
    //   744: aload 21
    //   746: athrow
    //   747: astore 22
    //   749: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   752: astore 21
    //   754: aload 21
    //   756: monitorenter
    //   757: aload_0
    //   758: invokespecial 91	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   761: aload_0
    //   762: invokespecial 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   765: aload 21
    //   767: monitorexit
    //   768: aload 22
    //   770: athrow
    //   771: astore 21
    //   773: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   776: aload_0
    //   777: invokevirtual 83	bkes:b	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   780: aload 21
    //   782: athrow
    //   783: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   786: invokevirtual 170	java/lang/Object:wait	()V
    //   789: iload 12
    //   791: istore 14
    //   793: iload 13
    //   795: istore 5
    //   797: iload 15
    //   799: istore 6
    //   801: iload 7
    //   803: istore 10
    //   805: iload 16
    //   807: istore 8
    //   809: iload 17
    //   811: istore 9
    //   813: iload 18
    //   815: istore 11
    //   817: goto -739 -> 78
    //   820: iload 9
    //   822: ifeq +426 -> 1248
    //   825: aload_0
    //   826: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   829: invokevirtual 171	bker:a	()Z
    //   832: ifeq +325 -> 1157
    //   835: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   838: astore 23
    //   840: aload 23
    //   842: monitorenter
    //   843: aload_0
    //   844: iconst_1
    //   845: putfield 173	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:k	Z
    //   848: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   851: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   854: aload 23
    //   856: monitorexit
    //   857: iconst_0
    //   858: istore 9
    //   860: iload 8
    //   862: ifeq +383 -> 1245
    //   865: aload_0
    //   866: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   869: invokevirtual 176	bker:a	()Ljavax/microedition/khronos/opengles/GL;
    //   872: checkcast 178	javax/microedition/khronos/opengles/GL10
    //   875: astore 22
    //   877: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   880: aload 22
    //   882: invokevirtual 181	bkes:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   885: iconst_0
    //   886: istore 8
    //   888: iload 10
    //   890: istore 11
    //   892: iload 10
    //   894: ifeq +50 -> 944
    //   897: aload_0
    //   898: getfield 48	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   901: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   904: checkcast 75	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   907: astore 23
    //   909: aload 23
    //   911: ifnull +396 -> 1307
    //   914: aload 23
    //   916: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   919: ifnull +388 -> 1307
    //   922: aload 23
    //   924: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   927: aload 22
    //   929: aload_0
    //   930: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   933: getfield 187	bker:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   936: invokeinterface 193 3 0
    //   941: goto +366 -> 1307
    //   944: iload 7
    //   946: istore 10
    //   948: iload 7
    //   950: ifeq +46 -> 996
    //   953: aload_0
    //   954: getfield 48	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   957: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   960: checkcast 75	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   963: astore 23
    //   965: aload 23
    //   967: ifnull +346 -> 1313
    //   970: aload 23
    //   972: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   975: ifnull +338 -> 1313
    //   978: aload 23
    //   980: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   983: aload 22
    //   985: iload_1
    //   986: iload 4
    //   988: invokeinterface 197 4 0
    //   993: goto +320 -> 1313
    //   996: aload_0
    //   997: getfield 48	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1000: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1003: checkcast 75	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   1006: astore 23
    //   1008: aload 23
    //   1010: ifnull +28 -> 1038
    //   1013: aload 23
    //   1015: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1018: ifnull +20 -> 1038
    //   1021: aload 22
    //   1023: ifnull +15 -> 1038
    //   1026: aload 23
    //   1028: invokestatic 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1031: aload 22
    //   1033: invokeinterface 200 2 0
    //   1038: aload_0
    //   1039: getfield 65	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Bker	Lbker;
    //   1042: invokevirtual 203	bker:a	()I
    //   1045: istore 12
    //   1047: iload 6
    //   1049: istore 7
    //   1051: iload 12
    //   1053: lookupswitch	default:+266->1319, 12288:+62->1115, 12302:+170->1223
    //   1081: <illegal opcode>
    //   1082: ldc 207
    //   1084: iload 12
    //   1086: invokestatic 210	bker:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1089: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   1092: astore 23
    //   1094: aload 23
    //   1096: monitorenter
    //   1097: aload_0
    //   1098: iconst_1
    //   1099: putfield 61	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   1102: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   1105: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   1108: aload 23
    //   1110: monitorexit
    //   1111: iload 6
    //   1113: istore 7
    //   1115: iload 5
    //   1117: ifeq +168 -> 1285
    //   1120: iconst_1
    //   1121: istore_2
    //   1122: iload_1
    //   1123: istore 12
    //   1125: iload_2
    //   1126: istore 6
    //   1128: iload 4
    //   1130: istore_1
    //   1131: iload 12
    //   1133: istore_2
    //   1134: iload 6
    //   1136: istore 4
    //   1138: iload 10
    //   1140: istore 6
    //   1142: iload 11
    //   1144: istore 10
    //   1146: goto -1088 -> 58
    //   1149: astore 21
    //   1151: aload 23
    //   1153: monitorexit
    //   1154: aload 21
    //   1156: athrow
    //   1157: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   1160: astore 23
    //   1162: aload 23
    //   1164: monitorenter
    //   1165: aload_0
    //   1166: iconst_1
    //   1167: putfield 173	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:k	Z
    //   1170: aload_0
    //   1171: iconst_1
    //   1172: putfield 61	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   1175: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   1178: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   1181: aload 23
    //   1183: monitorexit
    //   1184: iload 6
    //   1186: istore 11
    //   1188: iload_1
    //   1189: istore 12
    //   1191: iload_2
    //   1192: istore 6
    //   1194: iload 4
    //   1196: istore_1
    //   1197: iload 12
    //   1199: istore_2
    //   1200: iload 6
    //   1202: istore 4
    //   1204: iload 7
    //   1206: istore 6
    //   1208: iload 11
    //   1210: istore 7
    //   1212: goto -1154 -> 58
    //   1215: astore 21
    //   1217: aload 23
    //   1219: monitorexit
    //   1220: aload 21
    //   1222: athrow
    //   1223: iconst_1
    //   1224: istore 7
    //   1226: goto -111 -> 1115
    //   1229: astore 21
    //   1231: aload 23
    //   1233: monitorexit
    //   1234: aload 21
    //   1236: athrow
    //   1237: astore 22
    //   1239: aload 21
    //   1241: monitorexit
    //   1242: aload 22
    //   1244: athrow
    //   1245: goto -357 -> 888
    //   1248: goto -388 -> 860
    //   1251: iload 13
    //   1253: istore 8
    //   1255: iload_2
    //   1256: istore 6
    //   1258: iload 5
    //   1260: istore_2
    //   1261: iload 9
    //   1263: istore 5
    //   1265: goto -638 -> 627
    //   1268: iload 6
    //   1270: istore 5
    //   1272: iload 8
    //   1274: istore 4
    //   1276: goto -687 -> 589
    //   1279: iconst_0
    //   1280: istore 19
    //   1282: goto -1035 -> 247
    //   1285: goto -163 -> 1122
    //   1288: iload 5
    //   1290: istore 15
    //   1292: iload 4
    //   1294: istore 16
    //   1296: iload 9
    //   1298: istore 17
    //   1300: iload 10
    //   1302: istore 18
    //   1304: goto -521 -> 783
    //   1307: iconst_0
    //   1308: istore 11
    //   1310: goto -366 -> 944
    //   1313: iconst_0
    //   1314: istore 10
    //   1316: goto -320 -> 996
    //   1319: goto -239 -> 1080
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1322	0	this	GLThread
    //   32	1165	1	i1	int
    //   54	1207	2	i2	int
    //   34	702	3	i3	int
    //   56	1237	4	i4	int
    //   36	1253	5	i5	int
    //   39	1230	6	i6	int
    //   42	1183	7	i7	int
    //   45	1228	8	i8	int
    //   48	1249	9	i9	int
    //   26	1289	10	i10	int
    //   68	1241	11	i11	int
    //   145	1053	12	i12	int
    //   486	766	13	i13	int
    //   76	716	14	i14	int
    //   515	776	15	i15	int
    //   519	776	16	i16	int
    //   523	776	17	i17	int
    //   527	776	18	i18	int
    //   231	1050	19	bool1	boolean
    //   339	348	20	bool2	boolean
    //   51	137	21	localObject1	Object
    //   739	6	21	localObject2	Object
    //   752	14	21	localbkes	bkes
    //   771	10	21	localRuntimeException	java.lang.RuntimeException
    //   1149	6	21	localObject3	Object
    //   1215	6	21	localObject4	Object
    //   1229	11	21	localObject5	Object
    //   29	1	22	localObject6	Object
    //   108	6	22	localObject7	Object
    //   747	22	22	localObject8	Object
    //   875	157	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1237	6	22	localObject9	Object
    //   331	351	24	localGLTextureView	GLTextureView
    // Exception table:
    //   from	to	target	type
    //   96	107	108	finally
    //   110	113	108	finally
    //   78	88	739	finally
    //   116	139	739	finally
    //   167	170	739	finally
    //   216	247	739	finally
    //   250	270	739	finally
    //   282	290	739	finally
    //   298	309	739	finally
    //   314	333	739	finally
    //   346	355	739	finally
    //   355	359	739	finally
    //   364	380	739	finally
    //   380	428	739	finally
    //   428	439	739	finally
    //   439	455	739	finally
    //   455	480	739	finally
    //   499	510	739	finally
    //   529	536	739	finally
    //   543	550	739	finally
    //   561	580	739	finally
    //   589	603	739	finally
    //   605	616	739	finally
    //   622	627	739	finally
    //   627	638	739	finally
    //   681	688	739	finally
    //   691	700	739	finally
    //   712	719	739	finally
    //   719	724	739	finally
    //   727	733	739	finally
    //   741	744	739	finally
    //   773	783	739	finally
    //   783	789	739	finally
    //   58	66	747	finally
    //   175	182	747	finally
    //   744	747	747	finally
    //   825	843	747	finally
    //   865	885	747	finally
    //   897	909	747	finally
    //   914	941	747	finally
    //   953	965	747	finally
    //   970	993	747	finally
    //   996	1008	747	finally
    //   1013	1021	747	finally
    //   1026	1038	747	finally
    //   1038	1047	747	finally
    //   1080	1097	747	finally
    //   1154	1157	747	finally
    //   1157	1165	747	finally
    //   1220	1223	747	finally
    //   1234	1237	747	finally
    //   712	719	771	java/lang/RuntimeException
    //   843	857	1149	finally
    //   1151	1154	1149	finally
    //   1165	1184	1215	finally
    //   1217	1220	1215	finally
    //   1097	1111	1229	finally
    //   1231	1234	1229	finally
    //   757	768	1237	finally
    //   1239	1242	1237	finally
  }
  
  public int a()
  {
    synchronized ()
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized ()
    {
      this.m = true;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_c_of_type_Int = paramInt;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.o = true;
      this.m = true;
      this.n = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) && (!this.e) && (!this.n))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return (this.i) && (this.j) && (b());
  }
  
  public void b()
  {
    synchronized ()
    {
      this.f = true;
      this.k = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((this.h) && (!this.k))
        {
          boolean bool = this.jdField_c_of_type_Boolean;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.f = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.h) && (!this.jdField_c_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
          {
            this.jdField_a_of_type_Boolean = true;
            QLog.d("GLTextureView", 2, "mWaitingForSurface " + this.h + " mExited " + this.jdField_c_of_type_Boolean);
          }
          try
          {
            GLTextureView.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_b_of_type_Boolean = true;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (!bool) {
          try
          {
            GLTextureView.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void e()
  {
    this.l = true;
    GLTextureView.a().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 135	java/lang/StringBuilder
    //   4: dup
    //   5: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   8: ldc 247
    //   10: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_0
    //   14: invokevirtual 146	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
    //   17: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 250	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:setName	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokespecial 252	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	()V
    //   30: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   33: aload_0
    //   34: invokevirtual 254	bkes:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   37: return
    //   38: astore_1
    //   39: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   42: aload_0
    //   43: invokevirtual 254	bkes:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   46: return
    //   47: astore_1
    //   48: invokestatic 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Lbkes;
    //   51: aload_0
    //   52: invokevirtual 254	bkes:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	GLThread
    //   38	1	1	localInterruptedException	InterruptedException
    //   47	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	30	38	java/lang/InterruptedException
    //   26	30	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView.GLThread
 * JD-Core Version:    0.7.0.1
 */