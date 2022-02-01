package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockPatternView
  extends View
{
  private int A;
  private int B;
  private int C;
  private int D;
  private boolean E;
  private float F;
  private final Path G;
  private final Rect H;
  private int I;
  private int J;
  private int K;
  private final Matrix L;
  private final Matrix M;
  private int N;
  private int O;
  private int P;
  private boolean a;
  private Paint b;
  private Paint c;
  private Paint d;
  private LockPatternView.OnPatternListener e;
  private ArrayList<LockPatternView.Cell> f;
  private boolean[][] g;
  private float h;
  private float i;
  private long j;
  private int k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private float q;
  private final int r;
  private float s;
  private float t;
  private float u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public LockPatternView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public LockPatternView(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 64	android/view/View:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 66	com/tencent/mobileqq/gesturelock/LockPatternView:a	Z
    //   11: aload_0
    //   12: new 68	android/graphics/Paint
    //   15: dup
    //   16: invokespecial 71	android/graphics/Paint:<init>	()V
    //   19: putfield 73	com/tencent/mobileqq/gesturelock/LockPatternView:b	Landroid/graphics/Paint;
    //   22: aload_0
    //   23: new 68	android/graphics/Paint
    //   26: dup
    //   27: invokespecial 71	android/graphics/Paint:<init>	()V
    //   30: putfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   33: aload_0
    //   34: new 68	android/graphics/Paint
    //   37: dup
    //   38: invokespecial 71	android/graphics/Paint:<init>	()V
    //   41: putfield 77	com/tencent/mobileqq/gesturelock/LockPatternView:d	Landroid/graphics/Paint;
    //   44: aload_0
    //   45: new 79	java/util/ArrayList
    //   48: dup
    //   49: bipush 9
    //   51: invokespecial 82	java/util/ArrayList:<init>	(I)V
    //   54: putfield 84	com/tencent/mobileqq/gesturelock/LockPatternView:f	Ljava/util/ArrayList;
    //   57: aload_0
    //   58: getstatic 90	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   61: iconst_2
    //   62: newarray int
    //   64: dup
    //   65: iconst_0
    //   66: iconst_3
    //   67: iastore
    //   68: dup
    //   69: iconst_1
    //   70: iconst_3
    //   71: iastore
    //   72: invokestatic 96	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;[I)Ljava/lang/Object;
    //   75: checkcast 97	[[Z
    //   78: putfield 99	com/tencent/mobileqq/gesturelock/LockPatternView:g	[[Z
    //   81: aload_0
    //   82: ldc 100
    //   84: putfield 102	com/tencent/mobileqq/gesturelock/LockPatternView:h	F
    //   87: aload_0
    //   88: ldc 100
    //   90: putfield 104	com/tencent/mobileqq/gesturelock/LockPatternView:i	F
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 106	com/tencent/mobileqq/gesturelock/LockPatternView:k	I
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 108	com/tencent/mobileqq/gesturelock/LockPatternView:l	Z
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 110	com/tencent/mobileqq/gesturelock/LockPatternView:m	Z
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 112	com/tencent/mobileqq/gesturelock/LockPatternView:n	Z
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 114	com/tencent/mobileqq/gesturelock/LockPatternView:o	Z
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 116	com/tencent/mobileqq/gesturelock/LockPatternView:p	Z
    //   123: aload_0
    //   124: ldc 117
    //   126: putfield 119	com/tencent/mobileqq/gesturelock/LockPatternView:q	F
    //   129: aload_0
    //   130: sipush 128
    //   133: putfield 121	com/tencent/mobileqq/gesturelock/LockPatternView:r	I
    //   136: aload_0
    //   137: ldc 122
    //   139: putfield 124	com/tencent/mobileqq/gesturelock/LockPatternView:s	F
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 126	com/tencent/mobileqq/gesturelock/LockPatternView:E	Z
    //   147: aload_0
    //   148: ldc 127
    //   150: putfield 129	com/tencent/mobileqq/gesturelock/LockPatternView:F	F
    //   153: aload_0
    //   154: new 131	android/graphics/Path
    //   157: dup
    //   158: invokespecial 132	android/graphics/Path:<init>	()V
    //   161: putfield 134	com/tencent/mobileqq/gesturelock/LockPatternView:G	Landroid/graphics/Path;
    //   164: aload_0
    //   165: new 136	android/graphics/Rect
    //   168: dup
    //   169: invokespecial 137	android/graphics/Rect:<init>	()V
    //   172: putfield 139	com/tencent/mobileqq/gesturelock/LockPatternView:H	Landroid/graphics/Rect;
    //   175: aload_0
    //   176: new 141	android/graphics/Matrix
    //   179: dup
    //   180: invokespecial 142	android/graphics/Matrix:<init>	()V
    //   183: putfield 144	com/tencent/mobileqq/gesturelock/LockPatternView:L	Landroid/graphics/Matrix;
    //   186: aload_0
    //   187: new 141	android/graphics/Matrix
    //   190: dup
    //   191: invokespecial 142	android/graphics/Matrix:<init>	()V
    //   194: putfield 146	com/tencent/mobileqq/gesturelock/LockPatternView:M	Landroid/graphics/Matrix;
    //   197: aconst_null
    //   198: astore_3
    //   199: aconst_null
    //   200: astore 4
    //   202: aload_1
    //   203: aload_2
    //   204: getstatic 152	com/tencent/mobileqq/R$styleable:LockPatternView	[I
    //   207: invokevirtual 158	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   210: astore_1
    //   211: aload_1
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: iconst_0
    //   218: invokevirtual 164	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   221: astore_2
    //   222: aload_1
    //   223: astore 4
    //   225: aload_1
    //   226: astore_3
    //   227: ldc 166
    //   229: aload_2
    //   230: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +16 -> 249
    //   236: aload_1
    //   237: astore 4
    //   239: aload_1
    //   240: astore_3
    //   241: aload_0
    //   242: iconst_0
    //   243: putfield 174	com/tencent/mobileqq/gesturelock/LockPatternView:K	I
    //   246: goto +67 -> 313
    //   249: aload_1
    //   250: astore 4
    //   252: aload_1
    //   253: astore_3
    //   254: ldc 176
    //   256: aload_2
    //   257: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifeq +16 -> 276
    //   263: aload_1
    //   264: astore 4
    //   266: aload_1
    //   267: astore_3
    //   268: aload_0
    //   269: iconst_1
    //   270: putfield 174	com/tencent/mobileqq/gesturelock/LockPatternView:K	I
    //   273: goto +40 -> 313
    //   276: aload_1
    //   277: astore 4
    //   279: aload_1
    //   280: astore_3
    //   281: ldc 178
    //   283: aload_2
    //   284: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +16 -> 303
    //   290: aload_1
    //   291: astore 4
    //   293: aload_1
    //   294: astore_3
    //   295: aload_0
    //   296: iconst_2
    //   297: putfield 174	com/tencent/mobileqq/gesturelock/LockPatternView:K	I
    //   300: goto +13 -> 313
    //   303: aload_1
    //   304: astore 4
    //   306: aload_1
    //   307: astore_3
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 174	com/tencent/mobileqq/gesturelock/LockPatternView:K	I
    //   313: aload_1
    //   314: astore 4
    //   316: aload_1
    //   317: astore_3
    //   318: aload_0
    //   319: iconst_1
    //   320: invokevirtual 182	com/tencent/mobileqq/gesturelock/LockPatternView:setClickable	(Z)V
    //   323: aload_1
    //   324: astore 4
    //   326: aload_1
    //   327: astore_3
    //   328: aload_0
    //   329: aload_0
    //   330: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   333: ldc 187
    //   335: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   338: putfield 195	com/tencent/mobileqq/gesturelock/LockPatternView:N	I
    //   341: aload_1
    //   342: astore 4
    //   344: aload_1
    //   345: astore_3
    //   346: aload_0
    //   347: aload_0
    //   348: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   351: ldc 196
    //   353: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   356: putfield 198	com/tencent/mobileqq/gesturelock/LockPatternView:O	I
    //   359: aload_1
    //   360: astore 4
    //   362: aload_1
    //   363: astore_3
    //   364: aload_0
    //   365: aload_0
    //   366: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   369: ldc 199
    //   371: invokevirtual 202	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   374: putfield 204	com/tencent/mobileqq/gesturelock/LockPatternView:P	I
    //   377: aload_1
    //   378: astore 4
    //   380: aload_1
    //   381: astore_3
    //   382: aload_0
    //   383: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   386: iconst_1
    //   387: invokevirtual 207	android/graphics/Paint:setAntiAlias	(Z)V
    //   390: aload_1
    //   391: astore 4
    //   393: aload_1
    //   394: astore_3
    //   395: aload_0
    //   396: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   399: iconst_1
    //   400: invokevirtual 210	android/graphics/Paint:setDither	(Z)V
    //   403: aload_1
    //   404: astore 4
    //   406: aload_1
    //   407: astore_3
    //   408: aload_0
    //   409: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   412: aload_0
    //   413: getfield 195	com/tencent/mobileqq/gesturelock/LockPatternView:N	I
    //   416: invokevirtual 213	android/graphics/Paint:setColor	(I)V
    //   419: aload_1
    //   420: astore 4
    //   422: aload_1
    //   423: astore_3
    //   424: aload_0
    //   425: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   428: getstatic 219	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   431: invokevirtual 223	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   434: aload_1
    //   435: astore 4
    //   437: aload_1
    //   438: astore_3
    //   439: aload_0
    //   440: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   443: getstatic 229	android/graphics/Paint$Join:ROUND	Landroid/graphics/Paint$Join;
    //   446: invokevirtual 233	android/graphics/Paint:setStrokeJoin	(Landroid/graphics/Paint$Join;)V
    //   449: aload_1
    //   450: astore 4
    //   452: aload_1
    //   453: astore_3
    //   454: aload_0
    //   455: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   458: getstatic 238	android/graphics/Paint$Cap:ROUND	Landroid/graphics/Paint$Cap;
    //   461: invokevirtual 242	android/graphics/Paint:setStrokeCap	(Landroid/graphics/Paint$Cap;)V
    //   464: aload_1
    //   465: astore 4
    //   467: aload_1
    //   468: astore_3
    //   469: aload_0
    //   470: getfield 75	com/tencent/mobileqq/gesturelock/LockPatternView:c	Landroid/graphics/Paint;
    //   473: aload_0
    //   474: getfield 204	com/tencent/mobileqq/gesturelock/LockPatternView:P	I
    //   477: i2f
    //   478: invokevirtual 246	android/graphics/Paint:setStrokeWidth	(F)V
    //   481: aload_1
    //   482: astore 4
    //   484: aload_1
    //   485: astore_3
    //   486: aload_0
    //   487: getfield 77	com/tencent/mobileqq/gesturelock/LockPatternView:d	Landroid/graphics/Paint;
    //   490: iconst_1
    //   491: invokevirtual 207	android/graphics/Paint:setAntiAlias	(Z)V
    //   494: aload_1
    //   495: astore 4
    //   497: aload_1
    //   498: astore_3
    //   499: aload_0
    //   500: getfield 77	com/tencent/mobileqq/gesturelock/LockPatternView:d	Landroid/graphics/Paint;
    //   503: getstatic 249	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   506: invokevirtual 223	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   509: aload_1
    //   510: astore 4
    //   512: aload_1
    //   513: astore_3
    //   514: aload_0
    //   515: getfield 77	com/tencent/mobileqq/gesturelock/LockPatternView:d	Landroid/graphics/Paint;
    //   518: aload_0
    //   519: getfield 251	com/tencent/mobileqq/gesturelock/LockPatternView:v	I
    //   522: invokevirtual 213	android/graphics/Paint:setColor	(I)V
    //   525: aload_1
    //   526: astore 4
    //   528: aload_1
    //   529: astore_3
    //   530: aload_0
    //   531: aload_0
    //   532: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   535: ldc 252
    //   537: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   540: putfield 251	com/tencent/mobileqq/gesturelock/LockPatternView:v	I
    //   543: aload_1
    //   544: astore 4
    //   546: aload_1
    //   547: astore_3
    //   548: aload_0
    //   549: aload_0
    //   550: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   553: ldc 253
    //   555: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   558: putfield 255	com/tencent/mobileqq/gesturelock/LockPatternView:w	I
    //   561: aload_1
    //   562: astore 4
    //   564: aload_1
    //   565: astore_3
    //   566: aload_0
    //   567: aload_0
    //   568: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   571: ldc_w 256
    //   574: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   577: putfield 258	com/tencent/mobileqq/gesturelock/LockPatternView:x	I
    //   580: aload_1
    //   581: astore 4
    //   583: aload_1
    //   584: astore_3
    //   585: aload_0
    //   586: aload_0
    //   587: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   590: ldc_w 259
    //   593: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   596: putfield 261	com/tencent/mobileqq/gesturelock/LockPatternView:y	I
    //   599: aload_1
    //   600: astore 4
    //   602: aload_1
    //   603: astore_3
    //   604: aload_0
    //   605: aload_0
    //   606: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   609: ldc_w 262
    //   612: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   615: putfield 264	com/tencent/mobileqq/gesturelock/LockPatternView:z	I
    //   618: aload_1
    //   619: astore 4
    //   621: aload_1
    //   622: astore_3
    //   623: aload_0
    //   624: aload_0
    //   625: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   628: ldc_w 265
    //   631: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   634: putfield 267	com/tencent/mobileqq/gesturelock/LockPatternView:A	I
    //   637: aload_1
    //   638: astore 4
    //   640: aload_1
    //   641: astore_3
    //   642: aload_0
    //   643: aload_0
    //   644: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   647: ldc_w 268
    //   650: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   653: putfield 270	com/tencent/mobileqq/gesturelock/LockPatternView:B	I
    //   656: aload_1
    //   657: astore 4
    //   659: aload_1
    //   660: astore_3
    //   661: aload_0
    //   662: aload_0
    //   663: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   666: ldc_w 271
    //   669: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   672: putfield 273	com/tencent/mobileqq/gesturelock/LockPatternView:C	I
    //   675: aload_1
    //   676: astore 4
    //   678: aload_1
    //   679: astore_3
    //   680: aload_0
    //   681: aload_0
    //   682: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   685: ldc_w 274
    //   688: invokevirtual 193	android/content/res/Resources:getColor	(I)I
    //   691: putfield 276	com/tencent/mobileqq/gesturelock/LockPatternView:D	I
    //   694: aload_1
    //   695: astore 4
    //   697: aload_1
    //   698: astore_3
    //   699: aload_0
    //   700: aload_0
    //   701: invokevirtual 186	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   704: ldc_w 277
    //   707: invokevirtual 202	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   710: i2f
    //   711: putfield 129	com/tencent/mobileqq/gesturelock/LockPatternView:F	F
    //   714: aload_1
    //   715: astore 4
    //   717: aload_1
    //   718: astore_3
    //   719: aload_0
    //   720: aload_0
    //   721: invokevirtual 281	com/tencent/mobileqq/gesturelock/LockPatternView:getWidth	()I
    //   724: iconst_4
    //   725: idiv
    //   726: putfield 283	com/tencent/mobileqq/gesturelock/LockPatternView:I	I
    //   729: aload_1
    //   730: astore 4
    //   732: aload_1
    //   733: astore_3
    //   734: aload_0
    //   735: aload_0
    //   736: invokevirtual 286	com/tencent/mobileqq/gesturelock/LockPatternView:getHeight	()I
    //   739: iconst_4
    //   740: idiv
    //   741: putfield 288	com/tencent/mobileqq/gesturelock/LockPatternView:J	I
    //   744: goto +35 -> 779
    //   747: astore_1
    //   748: goto +36 -> 784
    //   751: astore_2
    //   752: aload_3
    //   753: astore 4
    //   755: aload_3
    //   756: astore_1
    //   757: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +19 -> 779
    //   763: aload_3
    //   764: astore 4
    //   766: ldc_w 295
    //   769: iconst_2
    //   770: ldc_w 297
    //   773: aload_2
    //   774: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   777: aload_3
    //   778: astore_1
    //   779: aload_1
    //   780: invokevirtual 303	android/content/res/TypedArray:recycle	()V
    //   783: return
    //   784: aload 4
    //   786: invokevirtual 303	android/content/res/TypedArray:recycle	()V
    //   789: aload_1
    //   790: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	this	LockPatternView
    //   0	791	1	paramContext	Context
    //   0	791	2	paramAttributeSet	android.util.AttributeSet
    //   198	580	3	localContext1	Context
    //   200	585	4	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   202	211	747	finally
    //   216	222	747	finally
    //   227	236	747	finally
    //   241	246	747	finally
    //   254	263	747	finally
    //   268	273	747	finally
    //   281	290	747	finally
    //   295	300	747	finally
    //   308	313	747	finally
    //   318	323	747	finally
    //   328	341	747	finally
    //   346	359	747	finally
    //   364	377	747	finally
    //   382	390	747	finally
    //   395	403	747	finally
    //   408	419	747	finally
    //   424	434	747	finally
    //   439	449	747	finally
    //   454	464	747	finally
    //   469	481	747	finally
    //   486	494	747	finally
    //   499	509	747	finally
    //   514	525	747	finally
    //   530	543	747	finally
    //   548	561	747	finally
    //   566	580	747	finally
    //   585	599	747	finally
    //   604	618	747	finally
    //   623	637	747	finally
    //   642	656	747	finally
    //   661	675	747	finally
    //   680	694	747	finally
    //   699	714	747	finally
    //   719	729	747	finally
    //   734	744	747	finally
    //   757	763	747	finally
    //   766	777	747	finally
    //   202	211	751	java/lang/Exception
    //   216	222	751	java/lang/Exception
    //   227	236	751	java/lang/Exception
    //   241	246	751	java/lang/Exception
    //   254	263	751	java/lang/Exception
    //   268	273	751	java/lang/Exception
    //   281	290	751	java/lang/Exception
    //   295	300	751	java/lang/Exception
    //   308	313	751	java/lang/Exception
    //   318	323	751	java/lang/Exception
    //   328	341	751	java/lang/Exception
    //   346	359	751	java/lang/Exception
    //   364	377	751	java/lang/Exception
    //   382	390	751	java/lang/Exception
    //   395	403	751	java/lang/Exception
    //   408	419	751	java/lang/Exception
    //   424	434	751	java/lang/Exception
    //   439	449	751	java/lang/Exception
    //   454	464	751	java/lang/Exception
    //   469	481	751	java/lang/Exception
    //   486	494	751	java/lang/Exception
    //   499	509	751	java/lang/Exception
    //   514	525	751	java/lang/Exception
    //   530	543	751	java/lang/Exception
    //   548	561	751	java/lang/Exception
    //   566	580	751	java/lang/Exception
    //   585	599	751	java/lang/Exception
    //   604	618	751	java/lang/Exception
    //   623	637	751	java/lang/Exception
    //   642	656	751	java/lang/Exception
    //   661	675	751	java/lang/Exception
    //   680	694	751	java/lang/Exception
    //   699	714	751	java/lang/Exception
    //   719	729	751	java/lang/Exception
    //   734	744	751	java/lang/Exception
  }
  
  private int a(float paramFloat)
  {
    float f1 = this.u;
    float f2 = this.s * f1;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f3 + f4);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    if (paramInt1 != -2147483648)
    {
      if (paramInt1 != 0) {
        return i1;
      }
    }
    else {
      paramInt2 = Math.min(i1, paramInt2);
    }
    return paramInt2;
  }
  
  private LockPatternView.Cell a(float paramFloat1, float paramFloat2)
  {
    LockPatternView.Cell localCell2 = b(paramFloat1, paramFloat2);
    LockPatternView.Cell localCell1 = null;
    if (localCell2 != null)
    {
      ArrayList localArrayList = this.f;
      if (!localArrayList.isEmpty())
      {
        localCell1 = (LockPatternView.Cell)localArrayList.get(localArrayList.size() - 1);
        int i6 = localCell2.a - localCell1.a;
        int i5 = localCell2.b - localCell1.b;
        int i2 = localCell1.a;
        int i4 = localCell1.b;
        int i7 = Math.abs(i6);
        int i3 = -1;
        int i1 = i2;
        if (i7 == 2)
        {
          i1 = i2;
          if (Math.abs(i5) != 1)
          {
            i2 = localCell1.a;
            if (i6 > 0) {
              i1 = 1;
            } else {
              i1 = -1;
            }
            i1 = i2 + i1;
          }
        }
        i2 = i4;
        if (Math.abs(i5) == 2)
        {
          i2 = i4;
          if (Math.abs(i6) != 1)
          {
            i4 = localCell1.b;
            i2 = i3;
            if (i5 > 0) {
              i2 = 1;
            }
            i2 = i4 + i2;
          }
        }
        localCell1 = LockPatternView.Cell.a(i1, i2);
      }
      if ((this.p) && (localCell1 != null) && (this.g[localCell1.a][localCell1.b] == 0)) {
        b(localCell1);
      }
      b(localCell2);
      if (this.n) {
        performHapticFeedback(1, 3);
      }
      return localCell2;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    setContentDescription(getContext().getString(paramInt));
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1;
    int i2;
    int i3;
    if ((paramBoolean) && ((!this.m) || (this.k == 2)))
    {
      if (this.o)
      {
        i1 = this.z;
        i2 = this.w;
        i3 = this.C;
      }
      else
      {
        i1 = this.k;
        if (i1 == 2)
        {
          i1 = this.A;
          i2 = this.x;
          i3 = this.D;
        }
        else
        {
          if ((i1 != 0) && (i1 != 1))
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("unknown display mode ");
            paramCanvas.append(this.k);
            throw new IllegalStateException(paramCanvas.toString());
          }
          i1 = this.y;
          i2 = this.w;
          i3 = this.C;
        }
      }
    }
    else
    {
      i1 = this.y;
      i2 = this.v;
      i3 = this.B;
    }
    float f2 = this.t;
    float f1 = this.u;
    int i4 = (int)(f2 * 3.0F / 4.0F);
    int i6 = (int)(3.0F * f1 / 4.0F);
    int i5 = (int)((f2 - i4) / 2.0F);
    i6 = (int)((f1 - i6) / 2.0F);
    float f3 = Math.min(f2 / this.I, 1.0F);
    float f4 = Math.min(this.u / this.J, 1.0F);
    this.M.setTranslate(i5 + paramInt1, i6 + paramInt2);
    this.M.preTranslate(this.I / 2, this.J / 2);
    this.M.preScale(f3, f4);
    this.M.preTranslate(-this.I / 2, -this.J / 2);
    f2 = paramInt1 + f2 / 2.0F;
    f1 = paramInt2 + f1 / 2.0F;
    this.d.setColor(i3);
    this.d.setStyle(Paint.Style.FILL);
    f3 = i4 / 2;
    paramCanvas.drawCircle(f2, f1, f3, this.d);
    this.d.setColor(i2);
    paramCanvas.drawCircle(f2, f1, i4 * 18 / 100, this.d);
    this.d.setColor(i1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeWidth(this.F);
    paramCanvas.drawCircle(f2, f1, f3, this.d);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getHistorySize();
    int i2 = 0;
    for (;;)
    {
      Object localObject1 = paramMotionEvent;
      if (i2 >= i1 + 1) {
        break;
      }
      float f4;
      if (i2 < i1) {
        f4 = ((MotionEvent)localObject1).getHistoricalX(i2);
      } else {
        f4 = paramMotionEvent.getX();
      }
      float f3;
      if (i2 < i1) {
        f3 = ((MotionEvent)localObject1).getHistoricalY(i2);
      } else {
        f3 = paramMotionEvent.getY();
      }
      int i3 = this.f.size();
      Object localObject2 = a(f4, f3);
      int i4 = this.f.size();
      if ((localObject2 != null) && (i4 == 1))
      {
        this.o = true;
        b();
      }
      if (Math.abs(f4 - this.h) + Math.abs(f3 - this.i) > 0.0F)
      {
        float f6 = this.h;
        float f5 = this.i;
        this.h = f4;
        this.i = f3;
        if ((this.o) && (i4 > 0))
        {
          ArrayList localArrayList = this.f;
          float f10 = this.t * this.q * 0.5F;
          int i5 = i4 - 1;
          localObject1 = (LockPatternView.Cell)localArrayList.get(i5);
          float f2 = b(((LockPatternView.Cell)localObject1).b);
          float f1 = c(((LockPatternView.Cell)localObject1).a);
          localObject1 = this.H;
          float f7;
          if (f2 < f4)
          {
            f7 = f4;
            f4 = f2;
          }
          else
          {
            f7 = f2;
          }
          float f8;
          float f9;
          if (f1 < f3)
          {
            f8 = f1;
            f9 = f3;
          }
          else
          {
            f9 = f1;
            f8 = f3;
          }
          ((Rect)localObject1).set((int)(f4 - f10), (int)(f8 - f10), (int)(f7 + f10), (int)(f9 + f10));
          if (f2 >= f6)
          {
            f3 = f6;
            f6 = f2;
            f2 = f3;
          }
          f4 = f5;
          f3 = f1;
          if (f1 < f5)
          {
            f3 = f5;
            f4 = f1;
          }
          ((Rect)localObject1).union((int)(f2 - f10), (int)(f4 - f10), (int)(f6 + f10), (int)(f3 + f10));
          if (localObject2 != null)
          {
            f1 = b(((LockPatternView.Cell)localObject2).b);
            f2 = c(((LockPatternView.Cell)localObject2).a);
            if (i4 >= 2)
            {
              localObject2 = (LockPatternView.Cell)localArrayList.get(i5 - (i4 - i3));
              f5 = b(((LockPatternView.Cell)localObject2).b);
              f4 = c(((LockPatternView.Cell)localObject2).a);
              if (f1 < f5)
              {
                f3 = f1;
                f1 = f5;
              }
              else
              {
                f3 = f5;
              }
              if (f2 < f4)
              {
                f5 = f3;
                f3 = f4;
                f4 = f1;
              }
              else
              {
                f6 = f2;
                f2 = f4;
                f5 = f3;
                f3 = f6;
                f4 = f1;
              }
            }
            else
            {
              f4 = f1;
              f3 = f2;
              f5 = f1;
            }
            f1 = this.t / 1.0F;
            f6 = this.u / 1.0F;
            ((Rect)localObject1).set((int)(f5 - f1), (int)(f2 - f6), (int)(f4 + f1), (int)(f3 + f6));
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("move invalidate.rect=");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("LockPatternView", 2, ((StringBuilder)localObject2).toString());
          }
          invalidate((Rect)localObject1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("LockPatternView", 2, "move invalidate.all");
          }
          invalidate();
        }
      }
      i2 += 1;
    }
  }
  
  private void a(LockPatternView.Cell paramCell)
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.e;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternCellAdded(this.f);
    }
    if (paramCell != null)
    {
      a(String.format("%d", new Object[] { Integer.valueOf(paramCell.a() * 3 + paramCell.b() + 1) }));
      return;
    }
    a(2131891414);
  }
  
  private void a(String paramString)
  {
    setContentDescription(paramString);
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private float b(int paramInt)
  {
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.t;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private int b(float paramFloat)
  {
    float f1 = this.t;
    float f2 = this.s * f1;
    float f3 = getPaddingLeft();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f3 + f4);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private LockPatternView.Cell b(float paramFloat1, float paramFloat2)
  {
    int i1 = a(paramFloat2);
    if (i1 < 0) {
      return null;
    }
    int i2 = b(paramFloat1);
    if (i2 < 0) {
      return null;
    }
    if (this.g[i1][i2] != 0) {
      return null;
    }
    return LockPatternView.Cell.a(i1, i2);
  }
  
  private void b()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.e;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternStart();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (!this.f.isEmpty())
    {
      this.o = false;
      c();
      invalidate();
    }
  }
  
  private void b(LockPatternView.Cell paramCell)
  {
    this.g[paramCell.a()][paramCell.b()] = 1;
    this.f.add(paramCell);
    a(paramCell);
  }
  
  private float c(int paramInt)
  {
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.u;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private void c()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.e;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternDetected(this.f);
    }
    a(2131891416);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    e();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = a(f1, f2);
    if (paramMotionEvent != null)
    {
      this.o = true;
      this.k = 0;
      b();
    }
    else
    {
      this.o = false;
      d();
    }
    if (paramMotionEvent != null)
    {
      float f3 = b(paramMotionEvent.b);
      float f4 = c(paramMotionEvent.a);
      float f5 = this.t / 2.0F;
      float f6 = this.u / 2.0F;
      invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
    }
    this.h = f1;
    this.i = f2;
  }
  
  private void d()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.e;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternCleared();
    }
    a(2131891415);
  }
  
  private void e()
  {
    this.f.clear();
    f();
    this.k = 0;
    invalidate();
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.g[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a()
  {
    e();
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return this.J * 3;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return this.I * 3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LockPatternView", 2, "ondraw.");
    }
    ArrayList localArrayList = this.f;
    int i4 = localArrayList.size();
    boolean[][] arrayOfBoolean = this.g;
    int i3;
    int i1;
    float f2;
    float f4;
    float f5;
    if (this.k == 1)
    {
      i2 = (int)(SystemClock.elapsedRealtime() - this.j) % ((i4 + 1) * 700);
      i3 = i2 / 700;
      f();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = (LockPatternView.Cell)localArrayList.get(i1);
        arrayOfBoolean[localObject.a()][localObject.b()] = 1;
        i1 += 1;
      }
      if ((i3 > 0) && (i3 < i4)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        f1 = i2 % 700 / 700.0F;
        localObject = (LockPatternView.Cell)localArrayList.get(i3 - 1);
        f2 = b(((LockPatternView.Cell)localObject).b);
        f3 = c(((LockPatternView.Cell)localObject).a);
        localObject = (LockPatternView.Cell)localArrayList.get(i3);
        f4 = b(((LockPatternView.Cell)localObject).b);
        f5 = c(((LockPatternView.Cell)localObject).a);
        this.h = (f2 + (f4 - f2) * f1);
        this.i = (f3 + f1 * (f5 - f3));
      }
      invalidate();
    }
    float f3 = this.t;
    float f1 = this.u;
    Object localObject = this.G;
    ((Path)localObject).rewind();
    int i5 = getPaddingTop();
    int i6 = getPaddingLeft();
    if ((this.m) && (this.k != 2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool;
    if ((this.b.getFlags() & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b.setFilterBitmap(true);
    int i2 = 0;
    for (;;)
    {
      f2 = f1;
      if (i2 >= 3) {
        break;
      }
      f4 = i5;
      f5 = i2;
      i3 = 0;
      f1 = f2;
      while (i3 < 3)
      {
        a(paramCanvas, (int)(i6 + i3 * f3), (int)(f4 + f5 * f2), arrayOfBoolean[i2][i3]);
        i3 += 1;
      }
      i2 += 1;
    }
    if (i1 != 0)
    {
      if (this.k != 2) {
        this.c.setColor(this.N);
      } else {
        this.c.setColor(this.O);
      }
      i1 = 0;
      for (i2 = 0; i1 < i4; i2 = 1)
      {
        LockPatternView.Cell localCell = (LockPatternView.Cell)localArrayList.get(i1);
        if (arrayOfBoolean[localCell.a][localCell.b] == 0) {
          break;
        }
        f1 = b(localCell.b);
        f2 = c(localCell.a);
        if (i1 == 0) {
          ((Path)localObject).moveTo(f1, f2);
        } else {
          ((Path)localObject).lineTo(f1, f2);
        }
        i1 += 1;
      }
      if (((this.o) || (this.k == 1)) && (i2 != 0)) {
        ((Path)localObject).lineTo(this.h, this.i);
      }
      paramCanvas.drawPath((Path)localObject, this.c);
    }
    this.b.setFilterBitmap(bool);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getSuggestedMinimumWidth();
    int i1 = getSuggestedMinimumHeight();
    paramInt1 = a(paramInt1, i2);
    paramInt2 = a(paramInt2, i1);
    i1 = this.K;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2) {
          paramInt1 = Math.min(paramInt1, paramInt2);
        }
      }
      else {
        paramInt2 = Math.min(paramInt1, paramInt2);
      }
    }
    else
    {
      paramInt1 = Math.min(paramInt1, paramInt2);
      paramInt2 = paramInt1;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.t = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.u = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.l)
    {
      if (!isEnabled()) {
        return false;
      }
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return false;
            }
            e();
            this.o = false;
            d();
            return true;
          }
          a(paramMotionEvent);
          return true;
        }
        b(paramMotionEvent);
        return true;
      }
      c(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return false;
  }
  
  public void setDisplayMode(int paramInt)
  {
    this.k = paramInt;
    if (paramInt == 1) {
      if (this.f.size() != 0)
      {
        this.j = SystemClock.elapsedRealtime();
        LockPatternView.Cell localCell = (LockPatternView.Cell)this.f.get(0);
        this.h = b(localCell.b());
        this.i = c(localCell.a());
        f();
      }
      else
      {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }
    }
    invalidate();
  }
  
  public void setFillInGapCell(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setInStealthMode(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setOnPatternListener(LockPatternView.OnPatternListener paramOnPatternListener)
  {
    this.e = paramOnPatternListener;
  }
  
  public void setPattern(int paramInt, List<LockPatternView.Cell> paramList)
  {
    this.f.clear();
    this.f.addAll(paramList);
    f();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.next();
      this.g[localCell.a()][localCell.b()] = 1;
    }
    setDisplayMode(paramInt);
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView
 * JD-Core Version:    0.7.0.1
 */