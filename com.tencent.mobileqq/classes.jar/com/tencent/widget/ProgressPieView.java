package com.tencent.widget;

import alnn;
import alno;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ProgressPieView
  extends View
{
  static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public float a;
  public int a;
  alnn jdField_a_of_type_Alnn = new alnn(this);
  alno jdField_a_of_type_Alno = new alno(this);
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  ProgressPieView.OnProgressListener jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener;
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
    //   5: invokevirtual 96	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 102	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   11: putfield 104	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 54	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   19: aload_0
    //   20: getfield 104	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   23: getfield 109	android/util/DisplayMetrics:density	F
    //   26: fmul
    //   27: putfield 54	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   35: aload_0
    //   36: getfield 104	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   39: getfield 109	android/util/DisplayMetrics:density	F
    //   42: fmul
    //   43: putfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 62	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   51: aload_0
    //   52: getfield 104	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   55: getfield 112	android/util/DisplayMetrics:scaledDensity	F
    //   58: fmul
    //   59: putfield 62	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   62: aload_0
    //   63: ldc 113
    //   65: putfield 115	com/tencent/widget/ProgressPieView:jdField_d_of_type_Float	F
    //   68: aload_1
    //   69: aload_2
    //   70: getstatic 121	com/tencent/mobileqq/R$styleable:ProgressPieView	[I
    //   73: invokevirtual 125	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   76: astore_2
    //   77: aload_0
    //   78: invokevirtual 126	com/tencent/widget/ProgressPieView:getResources	()Landroid/content/res/Resources;
    //   81: astore_1
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_4
    //   85: aload_0
    //   86: getfield 45	com/tencent/widget/ProgressPieView:jdField_a_of_type_Int	I
    //   89: invokevirtual 132	android/content/res/TypedArray:getInteger	(II)I
    //   92: putfield 45	com/tencent/widget/ProgressPieView:jdField_a_of_type_Int	I
    //   95: aload_0
    //   96: aload_2
    //   97: iconst_3
    //   98: aload_0
    //   99: getfield 47	com/tencent/widget/ProgressPieView:jdField_b_of_type_Int	I
    //   102: invokevirtual 132	android/content/res/TypedArray:getInteger	(II)I
    //   105: putfield 47	com/tencent/widget/ProgressPieView:jdField_b_of_type_Int	I
    //   108: aload_0
    //   109: aload_2
    //   110: iconst_5
    //   111: aload_0
    //   112: getfield 49	com/tencent/widget/ProgressPieView:jdField_c_of_type_Int	I
    //   115: invokevirtual 135	android/content/res/TypedArray:getInt	(II)I
    //   118: putfield 49	com/tencent/widget/ProgressPieView:jdField_c_of_type_Int	I
    //   121: aload_0
    //   122: aload_2
    //   123: bipush 6
    //   125: aload_0
    //   126: getfield 137	com/tencent/widget/ProgressPieView:jdField_a_of_type_Boolean	Z
    //   129: invokevirtual 141	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   132: putfield 137	com/tencent/widget/ProgressPieView:jdField_a_of_type_Boolean	Z
    //   135: aload_0
    //   136: aload_2
    //   137: bipush 7
    //   139: aload_0
    //   140: getfield 143	com/tencent/widget/ProgressPieView:jdField_b_of_type_Boolean	Z
    //   143: invokevirtual 141	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   146: putfield 143	com/tencent/widget/ProgressPieView:jdField_b_of_type_Boolean	Z
    //   149: aload_0
    //   150: aload_2
    //   151: bipush 8
    //   153: aload_0
    //   154: getfield 54	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   157: invokevirtual 147	android/content/res/TypedArray:getDimension	(IF)F
    //   160: putfield 54	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   163: aload_0
    //   164: aload_2
    //   165: bipush 9
    //   167: aload_0
    //   168: getfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   171: invokevirtual 147	android/content/res/TypedArray:getDimension	(IF)F
    //   174: putfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   177: aload_0
    //   178: aload_2
    //   179: bipush 16
    //   181: invokevirtual 151	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   184: putfield 153	com/tencent/widget/ProgressPieView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_0
    //   188: aload_2
    //   189: iconst_0
    //   190: aload_0
    //   191: getfield 62	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   194: invokevirtual 147	android/content/res/TypedArray:getDimension	(IF)F
    //   197: putfield 62	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   200: aload_0
    //   201: aload_2
    //   202: iconst_2
    //   203: invokevirtual 151	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   206: putfield 155	com/tencent/widget/ProgressPieView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: aload_0
    //   210: aload_2
    //   211: bipush 14
    //   213: aload_0
    //   214: getfield 51	com/tencent/widget/ProgressPieView:jdField_c_of_type_Boolean	Z
    //   217: invokevirtual 141	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   220: putfield 51	com/tencent/widget/ProgressPieView:jdField_c_of_type_Boolean	Z
    //   223: aload_0
    //   224: aload_2
    //   225: bipush 15
    //   227: aload_0
    //   228: getfield 59	com/tencent/widget/ProgressPieView:jdField_d_of_type_Boolean	Z
    //   231: invokevirtual 141	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   234: putfield 59	com/tencent/widget/ProgressPieView:jdField_d_of_type_Boolean	Z
    //   237: aload_0
    //   238: aload_2
    //   239: bipush 17
    //   241: invokevirtual 159	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   244: putfield 161	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   247: aload_0
    //   248: aload_2
    //   249: bipush 18
    //   251: aload_0
    //   252: getfield 66	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   255: invokevirtual 132	android/content/res/TypedArray:getInteger	(II)I
    //   258: putfield 66	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   261: aload_1
    //   262: ldc 162
    //   264: invokevirtual 166	android/content/res/Resources:getColor	(I)I
    //   267: istore_3
    //   268: iload_3
    //   269: istore 8
    //   271: aload_2
    //   272: bipush 10
    //   274: iload_3
    //   275: invokevirtual 168	android/content/res/TypedArray:getColor	(II)I
    //   278: istore 7
    //   280: iload 7
    //   282: istore 8
    //   284: aload_1
    //   285: ldc 169
    //   287: invokevirtual 166	android/content/res/Resources:getColor	(I)I
    //   290: istore_3
    //   291: iload_3
    //   292: istore 8
    //   294: aload_2
    //   295: bipush 11
    //   297: iload_3
    //   298: invokevirtual 168	android/content/res/TypedArray:getColor	(II)I
    //   301: istore 6
    //   303: iload 6
    //   305: istore 8
    //   307: aload_1
    //   308: ldc 169
    //   310: invokevirtual 166	android/content/res/Resources:getColor	(I)I
    //   313: istore_3
    //   314: iload_3
    //   315: istore 8
    //   317: aload_2
    //   318: bipush 12
    //   320: iload_3
    //   321: invokevirtual 168	android/content/res/TypedArray:getColor	(II)I
    //   324: istore 5
    //   326: iload 5
    //   328: istore 8
    //   330: aload_1
    //   331: ldc 170
    //   333: invokevirtual 166	android/content/res/Resources:getColor	(I)I
    //   336: istore_3
    //   337: iload_3
    //   338: istore 8
    //   340: iload 8
    //   342: istore 4
    //   344: iload 9
    //   346: istore_3
    //   347: aload_2
    //   348: bipush 13
    //   350: iload 8
    //   352: invokevirtual 168	android/content/res/TypedArray:getColor	(II)I
    //   355: istore 8
    //   357: iload 8
    //   359: istore 4
    //   361: iload 9
    //   363: istore_3
    //   364: aload_1
    //   365: ldc 171
    //   367: invokevirtual 166	android/content/res/Resources:getColor	(I)I
    //   370: istore 9
    //   372: iload 8
    //   374: istore 4
    //   376: iload 9
    //   378: istore_3
    //   379: aload_2
    //   380: iconst_1
    //   381: iload 9
    //   383: invokevirtual 168	android/content/res/TypedArray:getColor	(II)I
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
    //   415: invokevirtual 174	android/content/res/TypedArray:recycle	()V
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
    //   438: new 176	android/graphics/Paint
    //   441: dup
    //   442: iconst_1
    //   443: invokespecial 177	android/graphics/Paint:<init>	(I)V
    //   446: putfield 179	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   449: aload_0
    //   450: getfield 179	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   453: iload 13
    //   455: invokevirtual 182	android/graphics/Paint:setColor	(I)V
    //   458: aload_0
    //   459: getfield 179	com/tencent/widget/ProgressPieView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   462: getstatic 188	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   465: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   468: aload_0
    //   469: new 176	android/graphics/Paint
    //   472: dup
    //   473: iconst_1
    //   474: invokespecial 177	android/graphics/Paint:<init>	(I)V
    //   477: putfield 194	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   480: aload_0
    //   481: new 176	android/graphics/Paint
    //   484: dup
    //   485: iconst_1
    //   486: invokespecial 177	android/graphics/Paint:<init>	(I)V
    //   489: putfield 196	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   492: aload_0
    //   493: getfield 194	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   496: iload 12
    //   498: invokevirtual 182	android/graphics/Paint:setColor	(I)V
    //   501: aload_0
    //   502: getfield 196	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   505: iload 11
    //   507: invokevirtual 182	android/graphics/Paint:setColor	(I)V
    //   510: aload_0
    //   511: getfield 66	com/tencent/widget/ProgressPieView:jdField_d_of_type_Int	I
    //   514: iconst_1
    //   515: if_icmpne +242 -> 757
    //   518: aload_0
    //   519: getfield 194	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   522: getstatic 199	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   525: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   528: aload_0
    //   529: getfield 194	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   532: aload_0
    //   533: getfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   536: invokevirtual 203	android/graphics/Paint:setStrokeWidth	(F)V
    //   539: aload_0
    //   540: getfield 196	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   543: getstatic 199	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   546: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   549: aload_0
    //   550: getfield 196	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   553: aload_0
    //   554: getfield 57	com/tencent/widget/ProgressPieView:jdField_b_of_type_Float	F
    //   557: invokevirtual 203	android/graphics/Paint:setStrokeWidth	(F)V
    //   560: aload_0
    //   561: new 176	android/graphics/Paint
    //   564: dup
    //   565: iconst_1
    //   566: invokespecial 177	android/graphics/Paint:<init>	(I)V
    //   569: putfield 205	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   572: aload_0
    //   573: getfield 205	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   576: iload 10
    //   578: invokevirtual 182	android/graphics/Paint:setColor	(I)V
    //   581: aload_0
    //   582: getfield 205	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   585: getstatic 199	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   588: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   591: aload_0
    //   592: getfield 205	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   595: aload_0
    //   596: getfield 54	com/tencent/widget/ProgressPieView:jdField_a_of_type_Float	F
    //   599: invokevirtual 203	android/graphics/Paint:setStrokeWidth	(F)V
    //   602: aload_0
    //   603: new 176	android/graphics/Paint
    //   606: dup
    //   607: iconst_1
    //   608: invokespecial 177	android/graphics/Paint:<init>	(I)V
    //   611: putfield 207	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   614: aload_0
    //   615: getfield 207	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   618: iload 9
    //   620: invokevirtual 182	android/graphics/Paint:setColor	(I)V
    //   623: aload_0
    //   624: getfield 207	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   627: aload_0
    //   628: getfield 62	com/tencent/widget/ProgressPieView:jdField_c_of_type_Float	F
    //   631: invokevirtual 210	android/graphics/Paint:setTextSize	(F)V
    //   634: aload_0
    //   635: getfield 207	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   638: getstatic 216	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   641: invokevirtual 220	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   644: aload_0
    //   645: new 222	android/graphics/RectF
    //   648: dup
    //   649: invokespecial 224	android/graphics/RectF:<init>	()V
    //   652: putfield 226	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   655: aload_0
    //   656: new 228	android/graphics/Rect
    //   659: dup
    //   660: invokespecial 229	android/graphics/Rect:<init>	()V
    //   663: putfield 231	com/tencent/widget/ProgressPieView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   666: aload_0
    //   667: new 222	android/graphics/RectF
    //   670: dup
    //   671: invokespecial 224	android/graphics/RectF:<init>	()V
    //   674: putfield 233	com/tencent/widget/ProgressPieView:jdField_b_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
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
    //   694: invokevirtual 236	android/content/res/Resources$NotFoundException:printStackTrace	()V
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
    //   721: invokevirtual 174	android/content/res/TypedArray:recycle	()V
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
    //   752: invokevirtual 174	android/content/res/TypedArray:recycle	()V
    //   755: aload_1
    //   756: athrow
    //   757: aload_0
    //   758: getfield 194	com/tencent/widget/ProgressPieView:jdField_d_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   761: getstatic 188	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   764: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   767: aload_0
    //   768: getfield 196	com/tencent/widget/ProgressPieView:jdField_c_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   771: getstatic 188	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   774: invokevirtual 192	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
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
    //   267	554	3	i	int
    //   342	476	4	j	int
    //   324	500	5	k	int
    //   301	510	6	m	int
    //   278	517	7	n	int
    //   269	553	8	i1	int
    //   1	725	9	i2	int
    //   396	334	10	i3	int
    //   400	334	11	i4	int
    //   404	334	12	i5	int
    //   408	334	13	i6	int
    // Exception table:
    //   from	to	target	type
    //   261	268	678	android/content/res/Resources$NotFoundException
    //   261	268	746	finally
    //   271	280	746	finally
    //   284	291	746	finally
    //   294	303	746	finally
    //   307	314	746	finally
    //   317	326	746	finally
    //   330	337	746	finally
    //   347	357	746	finally
    //   364	372	746	finally
    //   379	388	746	finally
    //   693	697	746	finally
    //   271	280	780	android/content/res/Resources$NotFoundException
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
    paramInt1 = resolveSize(AIOUtils.a(this.jdField_d_of_type_Float, getResources()), paramInt1);
    paramInt2 = resolveSize(AIOUtils.a(this.jdField_d_of_type_Float, getResources()), paramInt2);
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
  
  public void setOnProgressListener(ProgressPieView.OnProgressListener paramOnProgressListener)
  {
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener = paramOnProgressListener;
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
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener != null)
    {
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener.b();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView
 * JD-Core Version:    0.7.0.1
 */