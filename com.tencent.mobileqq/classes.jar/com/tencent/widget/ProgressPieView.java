package com.tencent.widget;

import actn;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import bfui;
import bfuj;
import bfuk;

public class ProgressPieView
  extends View
{
  static LruCache<String, Typeface> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public float a;
  public int a;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  bfui jdField_a_of_type_Bfui = new bfui(this);
  bfuj jdField_a_of_type_Bfuj = new bfuj(this);
  bfuk jdField_a_of_type_Bfuk;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public Paint b;
  RectF b;
  public String b;
  public boolean b;
  public float c;
  public int c;
  public Paint c;
  public boolean c;
  float d;
  public int d;
  public Paint d;
  public boolean d;
  float e;
  public int e;
  public Paint e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  private boolean g;
  
  public ProgressPieView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 100;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -90;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_b_of_type_Float = 4.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Float = 14.0F;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 25;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  /* Error */
  void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 97	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 103	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   11: putfield 105	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 55	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   19: aload_0
    //   20: getfield 105	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   23: getfield 110	android/util/DisplayMetrics:density	F
    //   26: fmul
    //   27: putfield 55	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   35: aload_0
    //   36: getfield 105	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   39: getfield 110	android/util/DisplayMetrics:density	F
    //   42: fmul
    //   43: putfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 63	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   51: aload_0
    //   52: getfield 105	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   55: getfield 113	android/util/DisplayMetrics:scaledDensity	F
    //   58: fmul
    //   59: putfield 63	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   62: aload_0
    //   63: ldc 114
    //   65: putfield 116	com/tencent/widget/ProgressPieView:jdField_d_of_type_Float	F
    //   68: aload_1
    //   69: aload_2
    //   70: getstatic 122	com/tencent/mobileqq/R$styleable:ProgressPieView	[I
    //   73: invokevirtual 126	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   76: astore_2
    //   77: aload_0
    //   78: invokevirtual 127	com/tencent/widget/ProgressPieView:getResources	()Landroid/content/res/Resources;
    //   81: astore_1
    //   82: aload_0
    //   83: aload_2
    //   84: bipush 7
    //   86: aload_0
    //   87: getfield 46	com/tencent/widget/ProgressPieView:jdField_a_of_type_Int	I
    //   90: invokevirtual 133	android/content/res/TypedArray:getInteger	(II)I
    //   93: putfield 46	com/tencent/widget/ProgressPieView:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: aload_2
    //   98: bipush 8
    //   100: aload_0
    //   101: getfield 48	com/tencent/widget/ProgressPieView:jdField_b_of_type_Int	I
    //   104: invokevirtual 133	android/content/res/TypedArray:getInteger	(II)I
    //   107: putfield 48	com/tencent/widget/ProgressPieView:jdField_b_of_type_Int	I
    //   110: aload_0
    //   111: aload_2
    //   112: bipush 15
    //   114: aload_0
    //   115: getfield 50	com/tencent/widget/ProgressPieView:jdField_c_of_type_Int	I
    //   118: invokevirtual 136	android/content/res/TypedArray:getInt	(II)I
    //   121: putfield 50	com/tencent/widget/ProgressPieView:jdField_c_of_type_Int	I
    //   124: aload_0
    //   125: aload_2
    //   126: bipush 6
    //   128: aload_0
    //   129: getfield 138	com/tencent/widget/ProgressPieView:jdField_a_of_type_Boolean	Z
    //   132: invokevirtual 142	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   135: putfield 138	com/tencent/widget/ProgressPieView:jdField_a_of_type_Boolean	Z
    //   138: aload_0
    //   139: aload_2
    //   140: iconst_4
    //   141: aload_0
    //   142: getfield 144	com/tencent/widget/ProgressPieView:jdField_b_of_type_Boolean	Z
    //   145: invokevirtual 142	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   148: putfield 144	com/tencent/widget/ProgressPieView:jdField_b_of_type_Boolean	Z
    //   151: aload_0
    //   152: aload_2
    //   153: bipush 17
    //   155: aload_0
    //   156: getfield 55	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   159: invokevirtual 148	android/content/res/TypedArray:getDimension	(IF)F
    //   162: putfield 55	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   165: aload_0
    //   166: aload_2
    //   167: bipush 12
    //   169: aload_0
    //   170: getfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   173: invokevirtual 148	android/content/res/TypedArray:getDimension	(IF)F
    //   176: putfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   179: aload_0
    //   180: aload_2
    //   181: bipush 18
    //   183: invokevirtual 152	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   186: putfield 154	com/tencent/widget/ProgressPieView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   189: aload_0
    //   190: aload_2
    //   191: iconst_0
    //   192: aload_0
    //   193: getfield 63	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   196: invokevirtual 148	android/content/res/TypedArray:getDimension	(IF)F
    //   199: putfield 63	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   202: aload_0
    //   203: aload_2
    //   204: iconst_2
    //   205: invokevirtual 152	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   208: putfield 156	com/tencent/widget/ProgressPieView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   211: aload_0
    //   212: aload_2
    //   213: bipush 13
    //   215: aload_0
    //   216: getfield 52	com/tencent/widget/ProgressPieView:jdField_c_of_type_Boolean	Z
    //   219: invokevirtual 142	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   222: putfield 52	com/tencent/widget/ProgressPieView:jdField_c_of_type_Boolean	Z
    //   225: aload_0
    //   226: aload_2
    //   227: bipush 14
    //   229: aload_0
    //   230: getfield 60	com/tencent/widget/ProgressPieView:jdField_d_of_type_Boolean	Z
    //   233: invokevirtual 142	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   236: putfield 60	com/tencent/widget/ProgressPieView:jdField_d_of_type_Boolean	Z
    //   239: aload_0
    //   240: aload_2
    //   241: iconst_5
    //   242: invokevirtual 160	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   245: putfield 162	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   248: aload_0
    //   249: aload_2
    //   250: bipush 10
    //   252: aload_0
    //   253: getfield 67	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   256: invokevirtual 133	android/content/res/TypedArray:getInteger	(II)I
    //   259: putfield 67	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   262: aload_1
    //   263: ldc 163
    //   265: invokevirtual 167	android/content/res/Resources:getColor	(I)I
    //   268: istore_3
    //   269: iload_3
    //   270: istore 8
    //   272: aload_2
    //   273: iconst_3
    //   274: iload_3
    //   275: invokevirtual 169	android/content/res/TypedArray:getColor	(II)I
    //   278: istore 7
    //   280: iload 7
    //   282: istore 8
    //   284: aload_1
    //   285: ldc 170
    //   287: invokevirtual 167	android/content/res/Resources:getColor	(I)I
    //   290: istore_3
    //   291: iload_3
    //   292: istore 8
    //   294: aload_2
    //   295: bipush 9
    //   297: iload_3
    //   298: invokevirtual 169	android/content/res/TypedArray:getColor	(II)I
    //   301: istore 6
    //   303: iload 6
    //   305: istore 8
    //   307: aload_1
    //   308: ldc 170
    //   310: invokevirtual 167	android/content/res/Resources:getColor	(I)I
    //   313: istore_3
    //   314: iload_3
    //   315: istore 8
    //   317: aload_2
    //   318: bipush 11
    //   320: iload_3
    //   321: invokevirtual 169	android/content/res/TypedArray:getColor	(II)I
    //   324: istore 5
    //   326: iload 5
    //   328: istore 8
    //   330: aload_1
    //   331: ldc 171
    //   333: invokevirtual 167	android/content/res/Resources:getColor	(I)I
    //   336: istore_3
    //   337: iload_3
    //   338: istore 8
    //   340: iload 8
    //   342: istore 4
    //   344: iload 9
    //   346: istore_3
    //   347: aload_2
    //   348: bipush 16
    //   350: iload 8
    //   352: invokevirtual 169	android/content/res/TypedArray:getColor	(II)I
    //   355: istore 8
    //   357: iload 8
    //   359: istore 4
    //   361: iload 9
    //   363: istore_3
    //   364: aload_1
    //   365: ldc 172
    //   367: invokevirtual 167	android/content/res/Resources:getColor	(I)I
    //   370: istore 9
    //   372: iload 8
    //   374: istore 4
    //   376: iload 9
    //   378: istore_3
    //   379: aload_2
    //   380: iconst_1
    //   381: iload 9
    //   383: invokevirtual 169	android/content/res/TypedArray:getColor	(II)I
    //   386: istore 9
    //   388: iload 9
    //   390: istore_3
    //   391: iload_3
    //   392: istore 9
    //   394: iload 8
    //   396: istore 10
    //   398: iload 5
    //   400: istore 11
    //   402: iload 6
    //   404: istore 12
    //   406: iload 7
    //   408: istore 13
    //   410: aload_2
    //   411: ifnull +26 -> 437
    //   414: aload_2
    //   415: invokevirtual 175	android/content/res/TypedArray:recycle	()V
    //   418: iload 7
    //   420: istore 13
    //   422: iload 6
    //   424: istore 12
    //   426: iload 5
    //   428: istore 11
    //   430: iload 8
    //   432: istore 10
    //   434: iload_3
    //   435: istore 9
    //   437: aload_0
    //   438: new 177	android/graphics/Paint
    //   441: dup
    //   442: iconst_1
    //   443: invokespecial 178	android/graphics/Paint:<init>	(I)V
    //   446: putfield 180	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   449: aload_0
    //   450: getfield 180	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   453: iload 13
    //   455: invokevirtual 183	android/graphics/Paint:setColor	(I)V
    //   458: aload_0
    //   459: getfield 180	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   462: getstatic 189	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   465: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   468: aload_0
    //   469: new 177	android/graphics/Paint
    //   472: dup
    //   473: iconst_1
    //   474: invokespecial 178	android/graphics/Paint:<init>	(I)V
    //   477: putfield 195	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   480: aload_0
    //   481: new 177	android/graphics/Paint
    //   484: dup
    //   485: iconst_1
    //   486: invokespecial 178	android/graphics/Paint:<init>	(I)V
    //   489: putfield 197	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   492: aload_0
    //   493: getfield 195	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   496: iload 12
    //   498: invokevirtual 183	android/graphics/Paint:setColor	(I)V
    //   501: aload_0
    //   502: getfield 197	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   505: iload 11
    //   507: invokevirtual 183	android/graphics/Paint:setColor	(I)V
    //   510: aload_0
    //   511: getfield 67	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   514: iconst_1
    //   515: if_icmpne +242 -> 757
    //   518: aload_0
    //   519: getfield 195	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   522: getstatic 200	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   525: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   528: aload_0
    //   529: getfield 195	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   532: aload_0
    //   533: getfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   536: invokevirtual 204	android/graphics/Paint:setStrokeWidth	(F)V
    //   539: aload_0
    //   540: getfield 197	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   543: getstatic 200	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   546: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   549: aload_0
    //   550: getfield 197	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   553: aload_0
    //   554: getfield 58	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   557: invokevirtual 204	android/graphics/Paint:setStrokeWidth	(F)V
    //   560: aload_0
    //   561: new 177	android/graphics/Paint
    //   564: dup
    //   565: iconst_1
    //   566: invokespecial 178	android/graphics/Paint:<init>	(I)V
    //   569: putfield 206	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   572: aload_0
    //   573: getfield 206	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   576: iload 10
    //   578: invokevirtual 183	android/graphics/Paint:setColor	(I)V
    //   581: aload_0
    //   582: getfield 206	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   585: getstatic 200	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   588: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   591: aload_0
    //   592: getfield 206	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   595: aload_0
    //   596: getfield 55	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   599: invokevirtual 204	android/graphics/Paint:setStrokeWidth	(F)V
    //   602: aload_0
    //   603: new 177	android/graphics/Paint
    //   606: dup
    //   607: iconst_1
    //   608: invokespecial 178	android/graphics/Paint:<init>	(I)V
    //   611: putfield 208	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   614: aload_0
    //   615: getfield 208	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   618: iload 9
    //   620: invokevirtual 183	android/graphics/Paint:setColor	(I)V
    //   623: aload_0
    //   624: getfield 208	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   627: aload_0
    //   628: getfield 63	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   631: invokevirtual 211	android/graphics/Paint:setTextSize	(F)V
    //   634: aload_0
    //   635: getfield 208	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   638: getstatic 217	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   641: invokevirtual 221	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   644: aload_0
    //   645: new 223	android/graphics/RectF
    //   648: dup
    //   649: invokespecial 225	android/graphics/RectF:<init>	()V
    //   652: putfield 227	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   655: aload_0
    //   656: new 229	android/graphics/Rect
    //   659: dup
    //   660: invokespecial 230	android/graphics/Rect:<init>	()V
    //   663: putfield 232	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   666: aload_0
    //   667: new 223	android/graphics/RectF
    //   670: dup
    //   671: invokespecial 225	android/graphics/RectF:<init>	()V
    //   674: putfield 234	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   677: return
    //   678: astore_1
    //   679: iconst_0
    //   680: istore 4
    //   682: iconst_0
    //   683: istore 5
    //   685: iconst_0
    //   686: istore 6
    //   688: iconst_0
    //   689: istore 7
    //   691: iconst_0
    //   692: istore_3
    //   693: aload_1
    //   694: invokevirtual 237	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   697: iload_3
    //   698: istore 9
    //   700: iload 4
    //   702: istore 10
    //   704: iload 5
    //   706: istore 11
    //   708: iload 6
    //   710: istore 12
    //   712: iload 7
    //   714: istore 13
    //   716: aload_2
    //   717: ifnull -280 -> 437
    //   720: aload_2
    //   721: invokevirtual 175	android/content/res/TypedArray:recycle	()V
    //   724: iload_3
    //   725: istore 9
    //   727: iload 4
    //   729: istore 10
    //   731: iload 5
    //   733: istore 11
    //   735: iload 6
    //   737: istore 12
    //   739: iload 7
    //   741: istore 13
    //   743: goto -306 -> 437
    //   746: astore_1
    //   747: aload_2
    //   748: ifnull +7 -> 755
    //   751: aload_2
    //   752: invokevirtual 175	android/content/res/TypedArray:recycle	()V
    //   755: aload_1
    //   756: athrow
    //   757: aload_0
    //   758: getfield 195	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   761: getstatic 189	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   764: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   767: aload_0
    //   768: getfield 197	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   771: getstatic 189	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   774: invokevirtual 193	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   777: goto -217 -> 560
    //   780: astore_1
    //   781: iconst_0
    //   782: istore 4
    //   784: iconst_0
    //   785: istore 5
    //   787: iconst_0
    //   788: istore 6
    //   790: iconst_0
    //   791: istore_3
    //   792: iload 8
    //   794: istore 7
    //   796: goto -103 -> 693
    //   799: astore_1
    //   800: iconst_0
    //   801: istore 4
    //   803: iconst_0
    //   804: istore 5
    //   806: iconst_0
    //   807: istore_3
    //   808: iload 8
    //   810: istore 6
    //   812: goto -119 -> 693
    //   815: astore_1
    //   816: iconst_0
    //   817: istore 4
    //   819: iconst_0
    //   820: istore_3
    //   821: iload 8
    //   823: istore 5
    //   825: goto -132 -> 693
    //   828: astore_1
    //   829: goto -136 -> 693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	ProgressPieView
    //   0	832	1	paramContext	Context
    //   0	832	2	paramAttributeSet	AttributeSet
    //   268	553	3	i	int
    //   342	476	4	j	int
    //   324	500	5	k	int
    //   301	510	6	m	int
    //   278	517	7	n	int
    //   270	552	8	i1	int
    //   1	725	9	i2	int
    //   396	334	10	i3	int
    //   400	334	11	i4	int
    //   404	334	12	i5	int
    //   408	334	13	i6	int
    // Exception table:
    //   from	to	target	type
    //   262	269	678	android/content/res/Resources$NotFoundException
    //   262	269	746	finally
    //   272	280	746	finally
    //   284	291	746	finally
    //   294	303	746	finally
    //   307	314	746	finally
    //   317	326	746	finally
    //   330	337	746	finally
    //   347	357	746	finally
    //   364	372	746	finally
    //   379	388	746	finally
    //   693	697	746	finally
    //   272	280	780	android/content/res/Resources$NotFoundException
    //   284	291	780	android/content/res/Resources$NotFoundException
    //   294	303	799	android/content/res/Resources$NotFoundException
    //   307	314	799	android/content/res/Resources$NotFoundException
    //   317	326	815	android/content/res/Resources$NotFoundException
    //   330	337	815	android/content/res/Resources$NotFoundException
    //   347	357	828	android/content/res/Resources$NotFoundException
    //   364	372	828	android/content/res/Resources$NotFoundException
    //   379	388	828	android/content/res/Resources$NotFoundException
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_e_of_type_Float, this.jdField_e_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset((getWidth() - this.jdField_e_of_type_Float) / 2.0F, (getHeight() - this.jdField_e_of_type_Float) / 2.0F);
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      i = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
      this.jdField_a_of_type_AndroidGraphicsRectF.inset(i, i);
    }
    float f3 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    float f2;
    float f1;
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_e_of_type_AndroidGraphicsPaint);
      switch (this.jdField_d_of_type_Int)
      {
      default: 
        throw new IllegalArgumentException("Invalid Progress Fill = " + this.jdField_d_of_type_Int);
      case 0: 
      case 1: 
        f2 = this.jdField_b_of_type_Int * 360 / this.jdField_a_of_type_Int;
        f1 = f2;
        if (this.jdField_a_of_type_Boolean) {
          f1 = f2 - 360.0F;
        }
        if (this.jdField_b_of_type_Boolean) {
          f1 = -f1;
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 0)
      {
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, f1, true, this.jdField_d_of_type_AndroidGraphicsPaint);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean))
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            Typeface localTypeface2 = (Typeface)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_b_of_type_JavaLangString);
            Typeface localTypeface1 = localTypeface2;
            if (localTypeface2 == null)
            {
              localTypeface1 = localTypeface2;
              if (getResources() != null)
              {
                AssetManager localAssetManager = getResources().getAssets();
                localTypeface1 = localTypeface2;
                if (localAssetManager != null)
                {
                  localTypeface1 = Typeface.createFromAsset(localAssetManager, this.jdField_b_of_type_JavaLangString);
                  jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_b_of_type_JavaLangString, localTypeface1);
                }
              }
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(localTypeface1);
          }
          i = (int)f3;
          int j = (int)(f4 - (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F);
          paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, i, j, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_e_of_type_Boolean))
        {
          if (!this.jdField_g_of_type_Boolean) {
            break label722;
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, getWidth(), getHeight());
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        return;
        i = (int)(this.jdField_d_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
        this.jdField_b_of_type_AndroidGraphicsRectF.inset(i, i);
        if (this.jdField_g_of_type_Int == 1)
        {
          if (this.jdField_b_of_type_Int >= 500)
          {
            i = 180000 / this.jdField_a_of_type_Int;
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, i, false, this.jdField_c_of_type_AndroidGraphicsPaint);
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int + i, f1 - i, false, this.jdField_d_of_type_AndroidGraphicsPaint);
            break;
          }
          paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, f1, false, this.jdField_c_of_type_AndroidGraphicsPaint);
          break;
        }
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, f1, false, this.jdField_d_of_type_AndroidGraphicsPaint);
        break;
        f2 = this.jdField_e_of_type_Float / 2.0F * (this.jdField_b_of_type_Int / this.jdField_a_of_type_Int);
        f1 = f2;
        if (this.jdField_c_of_type_Boolean) {
          f1 = f2 + 0.5F - this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth();
        }
        paramCanvas.drawCircle(f3, f4, f1, this.jdField_d_of_type_AndroidGraphicsPaint);
        break;
        label722:
        i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, i, i);
        this.jdField_a_of_type_AndroidGraphicsRect.offset((getWidth() - i) / 2, (getHeight() - i) / 2);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = resolveSize(actn.a(this.jdField_d_of_type_Float, getResources()), paramInt1);
    paramInt2 = resolveSize(actn.a(this.jdField_d_of_type_Float, getResources()), paramInt2);
    this.jdField_e_of_type_Float = Math.min(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setAnimationSpeed(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCounterclockwise(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setDefaultViewSize(int paramInt)
  {
    if (Float.compare(this.jdField_d_of_type_Float, paramInt) != 0)
    {
      this.jdField_d_of_type_Float = paramInt;
      invalidate();
    }
  }
  
  public void setDrawImageFillView(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt < this.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setOnProgressListener(bfuk parambfuk)
  {
    this.jdField_a_of_type_Bfuk = parambfuk;
  }
  
  public void setPregressPreColor(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt > this.jdField_a_of_type_Int) || (paramInt < 0)) {
      throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
    if (this.jdField_a_of_type_Bfuk != null)
    {
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bfuk.b();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bfuk.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgressFillType(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public void setProgressPreType(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setProgressStrokeWidth(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidGraphicsPaint.getStyle() == Paint.Style.STROKE)
    {
      this.jdField_b_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      invalidate();
    }
  }
  
  public void setShowImage(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setShowStroke(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setStartAngle(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.jdField_a_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.jdField_c_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_c_of_type_Float);
    invalidate();
  }
  
  public void setTypeface(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView
 * JD-Core Version:    0.7.0.1
 */