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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Path jdField_a_of_type_AndroidGraphicsPath;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private LockPatternView.OnPatternListener jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
  private ArrayList<LockPatternView.Cell> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean[][] jdField_a_of_type_Array2dOfBoolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
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
    //   3: invokespecial 42	android/view/View:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 44	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_Boolean	Z
    //   11: aload_0
    //   12: new 46	android/graphics/Paint
    //   15: dup
    //   16: invokespecial 49	android/graphics/Paint:<init>	()V
    //   19: putfield 51	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   22: aload_0
    //   23: new 46	android/graphics/Paint
    //   26: dup
    //   27: invokespecial 49	android/graphics/Paint:<init>	()V
    //   30: putfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   33: aload_0
    //   34: new 46	android/graphics/Paint
    //   37: dup
    //   38: invokespecial 49	android/graphics/Paint:<init>	()V
    //   41: putfield 55	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   44: aload_0
    //   45: new 57	java/util/ArrayList
    //   48: dup
    //   49: bipush 9
    //   51: invokespecial 60	java/util/ArrayList:<init>	(I)V
    //   54: putfield 62	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   57: aload_0
    //   58: getstatic 68	java/lang/Boolean:TYPE	Ljava/lang/Class;
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
    //   72: invokestatic 74	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;[I)Ljava/lang/Object;
    //   75: checkcast 75	[[Z
    //   78: putfield 77	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_Array2dOfBoolean	[[Z
    //   81: aload_0
    //   82: ldc 78
    //   84: putfield 80	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_Float	F
    //   87: aload_0
    //   88: ldc 78
    //   90: putfield 82	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_Float	F
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 84	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_Int	I
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 86	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_Boolean	Z
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 88	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_Boolean	Z
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 90	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_d_of_type_Boolean	Z
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 92	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_e_of_type_Boolean	Z
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 94	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_f_of_type_Boolean	Z
    //   123: aload_0
    //   124: ldc 95
    //   126: putfield 97	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_Float	F
    //   129: aload_0
    //   130: sipush 128
    //   133: putfield 99	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_Int	I
    //   136: aload_0
    //   137: ldc 100
    //   139: putfield 102	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_d_of_type_Float	F
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 104	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_g_of_type_Boolean	Z
    //   147: aload_0
    //   148: ldc 105
    //   150: putfield 107	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_g_of_type_Float	F
    //   153: aload_0
    //   154: new 109	android/graphics/Path
    //   157: dup
    //   158: invokespecial 110	android/graphics/Path:<init>	()V
    //   161: putfield 112	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_AndroidGraphicsPath	Landroid/graphics/Path;
    //   164: aload_0
    //   165: new 114	android/graphics/Rect
    //   168: dup
    //   169: invokespecial 115	android/graphics/Rect:<init>	()V
    //   172: putfield 117	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   175: aload_0
    //   176: new 119	android/graphics/Matrix
    //   179: dup
    //   180: invokespecial 120	android/graphics/Matrix:<init>	()V
    //   183: putfield 122	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_a_of_type_AndroidGraphicsMatrix	Landroid/graphics/Matrix;
    //   186: aload_0
    //   187: new 119	android/graphics/Matrix
    //   190: dup
    //   191: invokespecial 120	android/graphics/Matrix:<init>	()V
    //   194: putfield 124	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsMatrix	Landroid/graphics/Matrix;
    //   197: aconst_null
    //   198: astore_3
    //   199: aconst_null
    //   200: astore 4
    //   202: aload_1
    //   203: aload_2
    //   204: getstatic 130	com/tencent/mobileqq/R$styleable:LockPatternView	[I
    //   207: invokevirtual 136	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   210: astore_1
    //   211: aload_1
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: iconst_0
    //   218: invokevirtual 142	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   221: astore_2
    //   222: aload_1
    //   223: astore 4
    //   225: aload_1
    //   226: astore_3
    //   227: ldc 144
    //   229: aload_2
    //   230: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +16 -> 249
    //   236: aload_1
    //   237: astore 4
    //   239: aload_1
    //   240: astore_3
    //   241: aload_0
    //   242: iconst_0
    //   243: putfield 152	com/tencent/mobileqq/gesturelock/LockPatternView:n	I
    //   246: goto +67 -> 313
    //   249: aload_1
    //   250: astore 4
    //   252: aload_1
    //   253: astore_3
    //   254: ldc 154
    //   256: aload_2
    //   257: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifeq +16 -> 276
    //   263: aload_1
    //   264: astore 4
    //   266: aload_1
    //   267: astore_3
    //   268: aload_0
    //   269: iconst_1
    //   270: putfield 152	com/tencent/mobileqq/gesturelock/LockPatternView:n	I
    //   273: goto +40 -> 313
    //   276: aload_1
    //   277: astore 4
    //   279: aload_1
    //   280: astore_3
    //   281: ldc 156
    //   283: aload_2
    //   284: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +16 -> 303
    //   290: aload_1
    //   291: astore 4
    //   293: aload_1
    //   294: astore_3
    //   295: aload_0
    //   296: iconst_2
    //   297: putfield 152	com/tencent/mobileqq/gesturelock/LockPatternView:n	I
    //   300: goto +13 -> 313
    //   303: aload_1
    //   304: astore 4
    //   306: aload_1
    //   307: astore_3
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 152	com/tencent/mobileqq/gesturelock/LockPatternView:n	I
    //   313: aload_1
    //   314: astore 4
    //   316: aload_1
    //   317: astore_3
    //   318: aload_0
    //   319: iconst_1
    //   320: invokevirtual 160	com/tencent/mobileqq/gesturelock/LockPatternView:setClickable	(Z)V
    //   323: aload_1
    //   324: astore 4
    //   326: aload_1
    //   327: astore_3
    //   328: aload_0
    //   329: aload_0
    //   330: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   333: ldc 165
    //   335: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   338: putfield 173	com/tencent/mobileqq/gesturelock/LockPatternView:o	I
    //   341: aload_1
    //   342: astore 4
    //   344: aload_1
    //   345: astore_3
    //   346: aload_0
    //   347: aload_0
    //   348: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   351: ldc 174
    //   353: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   356: putfield 176	com/tencent/mobileqq/gesturelock/LockPatternView:p	I
    //   359: aload_1
    //   360: astore 4
    //   362: aload_1
    //   363: astore_3
    //   364: aload_0
    //   365: aload_0
    //   366: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   369: ldc 177
    //   371: invokevirtual 180	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   374: putfield 182	com/tencent/mobileqq/gesturelock/LockPatternView:q	I
    //   377: aload_1
    //   378: astore 4
    //   380: aload_1
    //   381: astore_3
    //   382: aload_0
    //   383: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   386: iconst_1
    //   387: invokevirtual 185	android/graphics/Paint:setAntiAlias	(Z)V
    //   390: aload_1
    //   391: astore 4
    //   393: aload_1
    //   394: astore_3
    //   395: aload_0
    //   396: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   399: iconst_1
    //   400: invokevirtual 188	android/graphics/Paint:setDither	(Z)V
    //   403: aload_1
    //   404: astore 4
    //   406: aload_1
    //   407: astore_3
    //   408: aload_0
    //   409: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   412: aload_0
    //   413: getfield 173	com/tencent/mobileqq/gesturelock/LockPatternView:o	I
    //   416: invokevirtual 191	android/graphics/Paint:setColor	(I)V
    //   419: aload_1
    //   420: astore 4
    //   422: aload_1
    //   423: astore_3
    //   424: aload_0
    //   425: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   428: getstatic 197	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   431: invokevirtual 201	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   434: aload_1
    //   435: astore 4
    //   437: aload_1
    //   438: astore_3
    //   439: aload_0
    //   440: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   443: getstatic 207	android/graphics/Paint$Join:ROUND	Landroid/graphics/Paint$Join;
    //   446: invokevirtual 211	android/graphics/Paint:setStrokeJoin	(Landroid/graphics/Paint$Join;)V
    //   449: aload_1
    //   450: astore 4
    //   452: aload_1
    //   453: astore_3
    //   454: aload_0
    //   455: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   458: getstatic 216	android/graphics/Paint$Cap:ROUND	Landroid/graphics/Paint$Cap;
    //   461: invokevirtual 220	android/graphics/Paint:setStrokeCap	(Landroid/graphics/Paint$Cap;)V
    //   464: aload_1
    //   465: astore 4
    //   467: aload_1
    //   468: astore_3
    //   469: aload_0
    //   470: getfield 53	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   473: aload_0
    //   474: getfield 182	com/tencent/mobileqq/gesturelock/LockPatternView:q	I
    //   477: i2f
    //   478: invokevirtual 224	android/graphics/Paint:setStrokeWidth	(F)V
    //   481: aload_1
    //   482: astore 4
    //   484: aload_1
    //   485: astore_3
    //   486: aload_0
    //   487: getfield 55	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   490: iconst_1
    //   491: invokevirtual 185	android/graphics/Paint:setAntiAlias	(Z)V
    //   494: aload_1
    //   495: astore 4
    //   497: aload_1
    //   498: astore_3
    //   499: aload_0
    //   500: getfield 55	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   503: getstatic 227	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   506: invokevirtual 201	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   509: aload_1
    //   510: astore 4
    //   512: aload_1
    //   513: astore_3
    //   514: aload_0
    //   515: getfield 55	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   518: aload_0
    //   519: getfield 229	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_Int	I
    //   522: invokevirtual 191	android/graphics/Paint:setColor	(I)V
    //   525: aload_1
    //   526: astore 4
    //   528: aload_1
    //   529: astore_3
    //   530: aload_0
    //   531: aload_0
    //   532: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   535: ldc 230
    //   537: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   540: putfield 229	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_c_of_type_Int	I
    //   543: aload_1
    //   544: astore 4
    //   546: aload_1
    //   547: astore_3
    //   548: aload_0
    //   549: aload_0
    //   550: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   553: ldc 231
    //   555: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   558: putfield 233	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_d_of_type_Int	I
    //   561: aload_1
    //   562: astore 4
    //   564: aload_1
    //   565: astore_3
    //   566: aload_0
    //   567: aload_0
    //   568: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   571: ldc 234
    //   573: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   576: putfield 236	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_e_of_type_Int	I
    //   579: aload_1
    //   580: astore 4
    //   582: aload_1
    //   583: astore_3
    //   584: aload_0
    //   585: aload_0
    //   586: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   589: ldc 237
    //   591: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   594: putfield 239	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_f_of_type_Int	I
    //   597: aload_1
    //   598: astore 4
    //   600: aload_1
    //   601: astore_3
    //   602: aload_0
    //   603: aload_0
    //   604: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   607: ldc 240
    //   609: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   612: putfield 242	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_g_of_type_Int	I
    //   615: aload_1
    //   616: astore 4
    //   618: aload_1
    //   619: astore_3
    //   620: aload_0
    //   621: aload_0
    //   622: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   625: ldc 243
    //   627: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   630: putfield 245	com/tencent/mobileqq/gesturelock/LockPatternView:h	I
    //   633: aload_1
    //   634: astore 4
    //   636: aload_1
    //   637: astore_3
    //   638: aload_0
    //   639: aload_0
    //   640: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   643: ldc 246
    //   645: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   648: putfield 248	com/tencent/mobileqq/gesturelock/LockPatternView:i	I
    //   651: aload_1
    //   652: astore 4
    //   654: aload_1
    //   655: astore_3
    //   656: aload_0
    //   657: aload_0
    //   658: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   661: ldc 249
    //   663: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   666: putfield 251	com/tencent/mobileqq/gesturelock/LockPatternView:j	I
    //   669: aload_1
    //   670: astore 4
    //   672: aload_1
    //   673: astore_3
    //   674: aload_0
    //   675: aload_0
    //   676: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   679: ldc 252
    //   681: invokevirtual 171	android/content/res/Resources:getColor	(I)I
    //   684: putfield 254	com/tencent/mobileqq/gesturelock/LockPatternView:k	I
    //   687: aload_1
    //   688: astore 4
    //   690: aload_1
    //   691: astore_3
    //   692: aload_0
    //   693: aload_0
    //   694: invokevirtual 164	com/tencent/mobileqq/gesturelock/LockPatternView:getResources	()Landroid/content/res/Resources;
    //   697: ldc 255
    //   699: invokevirtual 180	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   702: i2f
    //   703: putfield 107	com/tencent/mobileqq/gesturelock/LockPatternView:jdField_g_of_type_Float	F
    //   706: aload_1
    //   707: astore 4
    //   709: aload_1
    //   710: astore_3
    //   711: aload_0
    //   712: aload_0
    //   713: invokevirtual 259	com/tencent/mobileqq/gesturelock/LockPatternView:getWidth	()I
    //   716: iconst_4
    //   717: idiv
    //   718: putfield 261	com/tencent/mobileqq/gesturelock/LockPatternView:l	I
    //   721: aload_1
    //   722: astore 4
    //   724: aload_1
    //   725: astore_3
    //   726: aload_0
    //   727: aload_0
    //   728: invokevirtual 264	com/tencent/mobileqq/gesturelock/LockPatternView:getHeight	()I
    //   731: iconst_4
    //   732: idiv
    //   733: putfield 266	com/tencent/mobileqq/gesturelock/LockPatternView:m	I
    //   736: goto +35 -> 771
    //   739: astore_1
    //   740: goto +36 -> 776
    //   743: astore_2
    //   744: aload_3
    //   745: astore 4
    //   747: aload_3
    //   748: astore_1
    //   749: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +19 -> 771
    //   755: aload_3
    //   756: astore 4
    //   758: ldc_w 273
    //   761: iconst_2
    //   762: ldc_w 275
    //   765: aload_2
    //   766: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   769: aload_3
    //   770: astore_1
    //   771: aload_1
    //   772: invokevirtual 281	android/content/res/TypedArray:recycle	()V
    //   775: return
    //   776: aload 4
    //   778: invokevirtual 281	android/content/res/TypedArray:recycle	()V
    //   781: aload_1
    //   782: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	this	LockPatternView
    //   0	783	1	paramContext	Context
    //   0	783	2	paramAttributeSet	android.util.AttributeSet
    //   198	572	3	localContext1	Context
    //   200	577	4	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   202	211	739	finally
    //   216	222	739	finally
    //   227	236	739	finally
    //   241	246	739	finally
    //   254	263	739	finally
    //   268	273	739	finally
    //   281	290	739	finally
    //   295	300	739	finally
    //   308	313	739	finally
    //   318	323	739	finally
    //   328	341	739	finally
    //   346	359	739	finally
    //   364	377	739	finally
    //   382	390	739	finally
    //   395	403	739	finally
    //   408	419	739	finally
    //   424	434	739	finally
    //   439	449	739	finally
    //   454	464	739	finally
    //   469	481	739	finally
    //   486	494	739	finally
    //   499	509	739	finally
    //   514	525	739	finally
    //   530	543	739	finally
    //   548	561	739	finally
    //   566	579	739	finally
    //   584	597	739	finally
    //   602	615	739	finally
    //   620	633	739	finally
    //   638	651	739	finally
    //   656	669	739	finally
    //   674	687	739	finally
    //   692	706	739	finally
    //   711	721	739	finally
    //   726	736	739	finally
    //   749	755	739	finally
    //   758	769	739	finally
    //   202	211	743	java/lang/Exception
    //   216	222	743	java/lang/Exception
    //   227	236	743	java/lang/Exception
    //   241	246	743	java/lang/Exception
    //   254	263	743	java/lang/Exception
    //   268	273	743	java/lang/Exception
    //   281	290	743	java/lang/Exception
    //   295	300	743	java/lang/Exception
    //   308	313	743	java/lang/Exception
    //   318	323	743	java/lang/Exception
    //   328	341	743	java/lang/Exception
    //   346	359	743	java/lang/Exception
    //   364	377	743	java/lang/Exception
    //   382	390	743	java/lang/Exception
    //   395	403	743	java/lang/Exception
    //   408	419	743	java/lang/Exception
    //   424	434	743	java/lang/Exception
    //   439	449	743	java/lang/Exception
    //   454	464	743	java/lang/Exception
    //   469	481	743	java/lang/Exception
    //   486	494	743	java/lang/Exception
    //   499	509	743	java/lang/Exception
    //   514	525	743	java/lang/Exception
    //   530	543	743	java/lang/Exception
    //   548	561	743	java/lang/Exception
    //   566	579	743	java/lang/Exception
    //   584	597	743	java/lang/Exception
    //   602	615	743	java/lang/Exception
    //   620	633	743	java/lang/Exception
    //   638	651	743	java/lang/Exception
    //   656	669	743	java/lang/Exception
    //   674	687	743	java/lang/Exception
    //   692	706	743	java/lang/Exception
    //   711	721	743	java/lang/Exception
    //   726	736	743	java/lang/Exception
  }
  
  private float a(int paramInt)
  {
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.jdField_e_of_type_Float;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private int a(float paramFloat)
  {
    float f1 = this.jdField_f_of_type_Float;
    float f2 = this.jdField_d_of_type_Float * f1;
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
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!localArrayList.isEmpty())
      {
        localCell1 = (LockPatternView.Cell)localArrayList.get(localArrayList.size() - 1);
        int i6 = localCell2.jdField_a_of_type_Int - localCell1.jdField_a_of_type_Int;
        int i5 = localCell2.jdField_b_of_type_Int - localCell1.jdField_b_of_type_Int;
        int i2 = localCell1.jdField_a_of_type_Int;
        int i4 = localCell1.jdField_b_of_type_Int;
        int i7 = Math.abs(i6);
        int i3 = -1;
        int i1 = i2;
        if (i7 == 2)
        {
          i1 = i2;
          if (Math.abs(i5) != 1)
          {
            i2 = localCell1.jdField_a_of_type_Int;
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
            i4 = localCell1.jdField_b_of_type_Int;
            i2 = i3;
            if (i5 > 0) {
              i2 = 1;
            }
            i2 = i4 + i2;
          }
        }
        localCell1 = LockPatternView.Cell.a(i1, i2);
      }
      if ((this.jdField_f_of_type_Boolean) && (localCell1 != null) && (this.jdField_a_of_type_Array2dOfBoolean[localCell1.jdField_a_of_type_Int][localCell1.jdField_b_of_type_Int] == 0)) {
        b(localCell1);
      }
      b(localCell2);
      if (this.jdField_d_of_type_Boolean) {
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
    if ((paramBoolean) && ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int == 2)))
    {
      if (this.jdField_e_of_type_Boolean)
      {
        i1 = this.jdField_g_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        i3 = this.j;
      }
      else
      {
        i1 = this.jdField_a_of_type_Int;
        if (i1 == 2)
        {
          i1 = this.h;
          i2 = this.jdField_e_of_type_Int;
          i3 = this.k;
        }
        else
        {
          if ((i1 != 0) && (i1 != 1))
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("unknown display mode ");
            paramCanvas.append(this.jdField_a_of_type_Int);
            throw new IllegalStateException(paramCanvas.toString());
          }
          i1 = this.jdField_f_of_type_Int;
          i2 = this.jdField_d_of_type_Int;
          i3 = this.j;
        }
      }
    }
    else
    {
      i1 = this.jdField_f_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      i3 = this.i;
    }
    float f2 = this.jdField_e_of_type_Float;
    float f1 = this.jdField_f_of_type_Float;
    int i4 = (int)(f2 * 3.0F / 4.0F);
    int i6 = (int)(3.0F * f1 / 4.0F);
    int i5 = (int)((f2 - i4) / 2.0F);
    i6 = (int)((f1 - i6) / 2.0F);
    float f3 = Math.min(f2 / this.l, 1.0F);
    float f4 = Math.min(this.jdField_f_of_type_Float / this.m, 1.0F);
    this.jdField_b_of_type_AndroidGraphicsMatrix.setTranslate(i5 + paramInt1, i6 + paramInt2);
    this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(this.l / 2, this.m / 2);
    this.jdField_b_of_type_AndroidGraphicsMatrix.preScale(f3, f4);
    this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(-this.l / 2, -this.m / 2);
    f2 = paramInt1 + f2 / 2.0F;
    f1 = paramInt2 + f1 / 2.0F;
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    f3 = i4 / 2;
    paramCanvas.drawCircle(f2, f1, f3, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i2);
    paramCanvas.drawCircle(f2, f1, i4 * 18 / 100, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_g_of_type_Float);
    paramCanvas.drawCircle(f2, f1, f3, this.jdField_c_of_type_AndroidGraphicsPaint);
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
      int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
      Object localObject2 = a(f4, f3);
      int i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
      if ((localObject2 != null) && (i4 == 1))
      {
        this.jdField_e_of_type_Boolean = true;
        b();
      }
      if (Math.abs(f4 - this.jdField_a_of_type_Float) + Math.abs(f3 - this.jdField_b_of_type_Float) > 0.0F)
      {
        float f6 = this.jdField_a_of_type_Float;
        float f5 = this.jdField_b_of_type_Float;
        this.jdField_a_of_type_Float = f4;
        this.jdField_b_of_type_Float = f3;
        if ((this.jdField_e_of_type_Boolean) && (i4 > 0))
        {
          ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          float f10 = this.jdField_e_of_type_Float * this.jdField_c_of_type_Float * 0.5F;
          int i5 = i4 - 1;
          localObject1 = (LockPatternView.Cell)localArrayList.get(i5);
          float f2 = a(((LockPatternView.Cell)localObject1).jdField_b_of_type_Int);
          float f1 = b(((LockPatternView.Cell)localObject1).jdField_a_of_type_Int);
          localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
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
            f1 = a(((LockPatternView.Cell)localObject2).jdField_b_of_type_Int);
            f2 = b(((LockPatternView.Cell)localObject2).jdField_a_of_type_Int);
            if (i4 >= 2)
            {
              localObject2 = (LockPatternView.Cell)localArrayList.get(i5 - (i4 - i3));
              f5 = a(((LockPatternView.Cell)localObject2).jdField_b_of_type_Int);
              f4 = b(((LockPatternView.Cell)localObject2).jdField_a_of_type_Int);
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
            f1 = this.jdField_e_of_type_Float / 1.0F;
            f6 = this.jdField_f_of_type_Float / 1.0F;
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
    LockPatternView.OnPatternListener localOnPatternListener = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternCellAdded(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if (paramCell != null)
    {
      a(String.format("%d", new Object[] { Integer.valueOf(paramCell.a() * 3 + paramCell.b() + 1) }));
      return;
    }
    a(2131693838);
  }
  
  private void a(String paramString)
  {
    setContentDescription(paramString);
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private float b(int paramInt)
  {
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.jdField_f_of_type_Float;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private int b(float paramFloat)
  {
    float f1 = this.jdField_e_of_type_Float;
    float f2 = this.jdField_d_of_type_Float * f1;
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
    if (this.jdField_a_of_type_Array2dOfBoolean[i1][i2] != 0) {
      return null;
    }
    return LockPatternView.Cell.a(i1, i2);
  }
  
  private void b()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternStart();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_e_of_type_Boolean = false;
      c();
      invalidate();
    }
  }
  
  private void b(LockPatternView.Cell paramCell)
  {
    this.jdField_a_of_type_Array2dOfBoolean[paramCell.a()][paramCell.b()] = 1;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCell);
    a(paramCell);
  }
  
  private void c()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternDetected(this.jdField_a_of_type_JavaUtilArrayList);
    }
    a(2131693840);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    e();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = a(f1, f2);
    if (paramMotionEvent != null)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      b();
    }
    else
    {
      this.jdField_e_of_type_Boolean = false;
      d();
    }
    if (paramMotionEvent != null)
    {
      float f3 = a(paramMotionEvent.jdField_b_of_type_Int);
      float f4 = b(paramMotionEvent.jdField_a_of_type_Int);
      float f5 = this.jdField_e_of_type_Float / 2.0F;
      float f6 = this.jdField_f_of_type_Float / 2.0F;
      invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
    }
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
  }
  
  private void d()
  {
    LockPatternView.OnPatternListener localOnPatternListener = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
    if (localOnPatternListener != null) {
      localOnPatternListener.onPatternCleared();
    }
    a(2131693839);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    f();
    this.jdField_a_of_type_Int = 0;
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
        this.jdField_a_of_type_Array2dOfBoolean[i1][i2] = 0;
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
    return this.m * 3;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return this.l * 3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LockPatternView", 2, "ondraw.");
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i4 = localArrayList.size();
    boolean[][] arrayOfBoolean = this.jdField_a_of_type_Array2dOfBoolean;
    int i3;
    int i1;
    float f2;
    float f4;
    float f5;
    if (this.jdField_a_of_type_Int == 1)
    {
      i2 = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) % ((i4 + 1) * 700);
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
        f2 = a(((LockPatternView.Cell)localObject).jdField_b_of_type_Int);
        f3 = b(((LockPatternView.Cell)localObject).jdField_a_of_type_Int);
        localObject = (LockPatternView.Cell)localArrayList.get(i3);
        f4 = a(((LockPatternView.Cell)localObject).jdField_b_of_type_Int);
        f5 = b(((LockPatternView.Cell)localObject).jdField_a_of_type_Int);
        this.jdField_a_of_type_Float = (f2 + (f4 - f2) * f1);
        this.jdField_b_of_type_Float = (f3 + f1 * (f5 - f3));
      }
      invalidate();
    }
    float f3 = this.jdField_e_of_type_Float;
    float f1 = this.jdField_f_of_type_Float;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    ((Path)localObject).rewind();
    int i5 = getPaddingTop();
    int i6 = getPaddingLeft();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool;
    if ((this.jdField_a_of_type_AndroidGraphicsPaint.getFlags() & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
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
      if (this.jdField_a_of_type_Int != 2) {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.o);
      } else {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.p);
      }
      i1 = 0;
      for (i2 = 0; i1 < i4; i2 = 1)
      {
        LockPatternView.Cell localCell = (LockPatternView.Cell)localArrayList.get(i1);
        if (arrayOfBoolean[localCell.jdField_a_of_type_Int][localCell.jdField_b_of_type_Int] == 0) {
          break;
        }
        f1 = a(localCell.jdField_b_of_type_Int);
        f2 = b(localCell.jdField_a_of_type_Int);
        if (i1 == 0) {
          ((Path)localObject).moveTo(f1, f2);
        } else {
          ((Path)localObject).lineTo(f1, f2);
        }
        i1 += 1;
      }
      if (((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int == 1)) && (i2 != 0)) {
        ((Path)localObject).lineTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      paramCanvas.drawPath((Path)localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(bool);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getSuggestedMinimumWidth();
    int i1 = getSuggestedMinimumHeight();
    paramInt1 = a(paramInt1, i2);
    paramInt2 = a(paramInt2, i1);
    i1 = this.n;
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
    this.jdField_e_of_type_Float = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.jdField_f_of_type_Float = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
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
            this.jdField_e_of_type_Boolean = false;
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
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        LockPatternView.Cell localCell = (LockPatternView.Cell)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_Float = a(localCell.b());
        this.jdField_b_of_type_Float = b(localCell.a());
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
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setInStealthMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setOnPatternListener(LockPatternView.OnPatternListener paramOnPatternListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener = paramOnPatternListener;
  }
  
  public void setPattern(int paramInt, List<LockPatternView.Cell> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    f();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.next();
      this.jdField_a_of_type_Array2dOfBoolean[localCell.a()][localCell.b()] = 1;
    }
    setDisplayMode(paramInt);
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView
 * JD-Core Version:    0.7.0.1
 */