package com.tencent.widget;

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
import com.tencent.mobileqq.util.Utils;

public class ProgressPieView
  extends View
{
  static final int DEFAULT_MAX = 100;
  static final int DEFAULT_PROGRESS = 0;
  public static final float DEFAULT_PROGRESS_STROKE_WIDTH = 4.0F;
  static final int DEFAULT_START_ANGLE = -90;
  static final float DEFAULT_STROKE_WIDTH = 1.5F;
  static final float DEFAULT_TEXT_SIZE = 14.0F;
  static final float DEFAULT_VIEW_SIZE = 40.0F;
  public static final int FAST_ANIMATION_SPEED = 1;
  public static final int FILL_TYPE_CENTER = 2;
  public static final int FILL_TYPE_RADIAL = 0;
  public static final int FILL_TYPE_RADIAL_STROKE = 1;
  public static final int MEDIUM_ANIMATION_SPEED = 25;
  public static final int PREPROGRESS_TYPE_BLESS = 1;
  public static final int PREPROGRESS_TYPE_NORMAL = 0;
  public static final int SLOW_ANIMATION_SPEED = 50;
  static LruCache<String, Typeface> sTypefaceCache = new LruCache(8);
  ProgressPieView.AnimationHandler mAnimationHandler = new ProgressPieView.AnimationHandler(this);
  public int mAnimationSpeed = 25;
  public int mAnimationSpeedLevel = 1;
  public Paint mBackgroundPaint;
  public boolean mCounterclockwise = false;
  float mDefaultViewSize;
  DisplayMetrics mDisplayMetrics;
  private boolean mDrawImageFillView = false;
  public Drawable mImage;
  Rect mImageRect;
  RectF mInnerProgressRectF;
  RectF mInnerRectF;
  public boolean mInverted = false;
  ProgressPieView.OnProgressListener mListener;
  public int mMax = 100;
  public int mProgress = 0;
  public int mProgressFillType = 1;
  public Paint mProgressPaint;
  public Paint mProgressPrePaint;
  public int mProgressPreType = 0;
  public float mProgressStrokeWidth = 4.0F;
  public boolean mShowArc = true;
  public boolean mShowColorMask = false;
  public boolean mShowImage = true;
  public boolean mShowStroke = true;
  public boolean mShowText = true;
  public int mStartAngle = -90;
  public Paint mStrokePaint;
  public float mStrokeWidth = 1.5F;
  public String mText;
  public Paint mTextPaint;
  public float mTextSize = 14.0F;
  ProgressPieView.BlessAnimationHandler mTimeAnimationHandler = new ProgressPieView.BlessAnimationHandler(this);
  public String mTypeface;
  float mViewSize;
  
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
    init(paramContext, paramAttributeSet);
  }
  
  public void animateProgressFill()
  {
    this.mAnimationHandler.removeMessages(0);
    this.mAnimationHandler.setAnimateTo(this.mMax);
    this.mAnimationHandler.sendEmptyMessage(0);
    invalidate();
  }
  
  public void animateProgressFill(int paramInt)
  {
    this.mAnimationHandler.removeMessages(0);
    if ((paramInt <= this.mMax) && (paramInt >= 0))
    {
      this.mAnimationHandler.setAnimateTo(paramInt);
      this.mAnimationHandler.sendEmptyMessage(0);
      invalidate();
      return;
    }
    throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mMax) }));
  }
  
  public void animateProgressFillAndHide(int paramInt)
  {
    animateProgressFill(paramInt);
    this.mAnimationHandler.mHide = true;
  }
  
  public Drawable getImageDrawable()
  {
    return this.mImage;
  }
  
  public int getMaxTime()
  {
    return this.mMax;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  /* Error */
  void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 206	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   5: invokevirtual 212	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   8: putfield 214	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 113	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   16: aload_0
    //   17: getfield 214	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   20: getfield 219	android/util/DisplayMetrics:density	F
    //   23: fmul
    //   24: putfield 113	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   32: aload_0
    //   33: getfield 214	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   36: getfield 219	android/util/DisplayMetrics:density	F
    //   39: fmul
    //   40: putfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 119	com/tencent/widget/ProgressPieView:mTextSize	F
    //   48: aload_0
    //   49: getfield 214	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   52: getfield 222	android/util/DisplayMetrics:scaledDensity	F
    //   55: fmul
    //   56: putfield 119	com/tencent/widget/ProgressPieView:mTextSize	F
    //   59: aload_0
    //   60: ldc 20
    //   62: putfield 224	com/tencent/widget/ProgressPieView:mDefaultViewSize	F
    //   65: aload_1
    //   66: aload_2
    //   67: getstatic 230	com/tencent/mobileqq/qqui/R$styleable:aD	[I
    //   70: invokevirtual 234	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 235	com/tencent/widget/ProgressPieView:getResources	()Landroid/content/res/Resources;
    //   78: astore_1
    //   79: aload_0
    //   80: aload_2
    //   81: getstatic 238	com/tencent/mobileqq/qqui/R$styleable:aM	I
    //   84: aload_0
    //   85: getfield 101	com/tencent/widget/ProgressPieView:mMax	I
    //   88: invokevirtual 244	android/content/res/TypedArray:getInteger	(II)I
    //   91: putfield 101	com/tencent/widget/ProgressPieView:mMax	I
    //   94: aload_0
    //   95: aload_2
    //   96: getstatic 247	com/tencent/mobileqq/qqui/R$styleable:aN	I
    //   99: aload_0
    //   100: getfield 103	com/tencent/widget/ProgressPieView:mProgress	I
    //   103: invokevirtual 244	android/content/res/TypedArray:getInteger	(II)I
    //   106: putfield 103	com/tencent/widget/ProgressPieView:mProgress	I
    //   109: aload_0
    //   110: aload_2
    //   111: getstatic 250	com/tencent/mobileqq/qqui/R$styleable:aU	I
    //   114: aload_0
    //   115: getfield 105	com/tencent/widget/ProgressPieView:mStartAngle	I
    //   118: invokevirtual 253	android/content/res/TypedArray:getInt	(II)I
    //   121: putfield 105	com/tencent/widget/ProgressPieView:mStartAngle	I
    //   124: aload_0
    //   125: aload_2
    //   126: getstatic 256	com/tencent/mobileqq/qqui/R$styleable:aL	I
    //   129: aload_0
    //   130: getfield 107	com/tencent/widget/ProgressPieView:mInverted	Z
    //   133: invokevirtual 260	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   136: putfield 107	com/tencent/widget/ProgressPieView:mInverted	Z
    //   139: aload_0
    //   140: aload_2
    //   141: getstatic 263	com/tencent/mobileqq/qqui/R$styleable:aJ	I
    //   144: aload_0
    //   145: getfield 109	com/tencent/widget/ProgressPieView:mCounterclockwise	Z
    //   148: invokevirtual 260	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   151: putfield 109	com/tencent/widget/ProgressPieView:mCounterclockwise	Z
    //   154: aload_0
    //   155: aload_2
    //   156: getstatic 266	com/tencent/mobileqq/qqui/R$styleable:aW	I
    //   159: aload_0
    //   160: getfield 113	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   163: invokevirtual 270	android/content/res/TypedArray:getDimension	(IF)F
    //   166: putfield 113	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   169: aload_0
    //   170: aload_2
    //   171: getstatic 273	com/tencent/mobileqq/qqui/R$styleable:aR	I
    //   174: aload_0
    //   175: getfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   178: invokevirtual 270	android/content/res/TypedArray:getDimension	(IF)F
    //   181: putfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   184: aload_0
    //   185: aload_2
    //   186: getstatic 276	com/tencent/mobileqq/qqui/R$styleable:aX	I
    //   189: invokevirtual 280	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   192: putfield 282	com/tencent/widget/ProgressPieView:mTypeface	Ljava/lang/String;
    //   195: aload_0
    //   196: aload_2
    //   197: getstatic 285	com/tencent/mobileqq/qqui/R$styleable:aF	I
    //   200: aload_0
    //   201: getfield 119	com/tencent/widget/ProgressPieView:mTextSize	F
    //   204: invokevirtual 270	android/content/res/TypedArray:getDimension	(IF)F
    //   207: putfield 119	com/tencent/widget/ProgressPieView:mTextSize	F
    //   210: aload_0
    //   211: aload_2
    //   212: getstatic 288	com/tencent/mobileqq/qqui/R$styleable:aH	I
    //   215: invokevirtual 280	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   218: putfield 290	com/tencent/widget/ProgressPieView:mText	Ljava/lang/String;
    //   221: aload_0
    //   222: aload_2
    //   223: getstatic 293	com/tencent/mobileqq/qqui/R$styleable:aS	I
    //   226: aload_0
    //   227: getfield 111	com/tencent/widget/ProgressPieView:mShowStroke	Z
    //   230: invokevirtual 260	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   233: putfield 111	com/tencent/widget/ProgressPieView:mShowStroke	Z
    //   236: aload_0
    //   237: aload_2
    //   238: getstatic 296	com/tencent/mobileqq/qqui/R$styleable:aT	I
    //   241: aload_0
    //   242: getfield 117	com/tencent/widget/ProgressPieView:mShowText	Z
    //   245: invokevirtual 260	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   248: putfield 117	com/tencent/widget/ProgressPieView:mShowText	Z
    //   251: aload_0
    //   252: aload_2
    //   253: getstatic 299	com/tencent/mobileqq/qqui/R$styleable:aK	I
    //   256: invokevirtual 303	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   259: putfield 195	com/tencent/widget/ProgressPieView:mImage	Landroid/graphics/drawable/Drawable;
    //   262: aload_0
    //   263: aload_2
    //   264: getstatic 306	com/tencent/mobileqq/qqui/R$styleable:aP	I
    //   267: aload_0
    //   268: getfield 123	com/tencent/widget/ProgressPieView:mProgressFillType	I
    //   271: invokevirtual 244	android/content/res/TypedArray:getInteger	(II)I
    //   274: putfield 123	com/tencent/widget/ProgressPieView:mProgressFillType	I
    //   277: iconst_0
    //   278: istore 8
    //   280: iconst_0
    //   281: istore 9
    //   283: aload_1
    //   284: ldc_w 307
    //   287: invokevirtual 311	android/content/res/Resources:getColor	(I)I
    //   290: istore 4
    //   292: iload 4
    //   294: istore_3
    //   295: aload_2
    //   296: getstatic 314	com/tencent/mobileqq/qqui/R$styleable:aI	I
    //   299: iload 4
    //   301: invokevirtual 316	android/content/res/TypedArray:getColor	(II)I
    //   304: istore 4
    //   306: iload 4
    //   308: istore_3
    //   309: aload_1
    //   310: ldc_w 317
    //   313: invokevirtual 311	android/content/res/Resources:getColor	(I)I
    //   316: istore 5
    //   318: iload 5
    //   320: istore 6
    //   322: aload_2
    //   323: getstatic 320	com/tencent/mobileqq/qqui/R$styleable:aO	I
    //   326: iload 5
    //   328: invokevirtual 316	android/content/res/TypedArray:getColor	(II)I
    //   331: istore_3
    //   332: iload_3
    //   333: istore 6
    //   335: aload_1
    //   336: ldc_w 317
    //   339: invokevirtual 311	android/content/res/Resources:getColor	(I)I
    //   342: istore 5
    //   344: iload 5
    //   346: istore 6
    //   348: aload_2
    //   349: getstatic 323	com/tencent/mobileqq/qqui/R$styleable:aQ	I
    //   352: iload 5
    //   354: invokevirtual 316	android/content/res/TypedArray:getColor	(II)I
    //   357: istore 5
    //   359: iload 5
    //   361: istore 6
    //   363: aload_1
    //   364: ldc_w 324
    //   367: invokevirtual 311	android/content/res/Resources:getColor	(I)I
    //   370: istore 10
    //   372: iload 9
    //   374: istore 7
    //   376: iload 10
    //   378: istore 6
    //   380: aload_2
    //   381: getstatic 327	com/tencent/mobileqq/qqui/R$styleable:aV	I
    //   384: iload 10
    //   386: invokevirtual 316	android/content/res/TypedArray:getColor	(II)I
    //   389: istore 8
    //   391: iload 9
    //   393: istore 7
    //   395: iload 8
    //   397: istore 6
    //   399: aload_1
    //   400: ldc_w 328
    //   403: invokevirtual 311	android/content/res/Resources:getColor	(I)I
    //   406: istore 9
    //   408: iload 9
    //   410: istore 7
    //   412: iload 8
    //   414: istore 6
    //   416: aload_2
    //   417: getstatic 331	com/tencent/mobileqq/qqui/R$styleable:aG	I
    //   420: iload 9
    //   422: invokevirtual 316	android/content/res/TypedArray:getColor	(II)I
    //   425: istore 12
    //   427: iload 4
    //   429: istore 11
    //   431: iload 5
    //   433: istore 7
    //   435: iload_3
    //   436: istore 10
    //   438: iload 8
    //   440: istore 6
    //   442: iload 12
    //   444: istore 9
    //   446: aload_2
    //   447: ifnull +123 -> 570
    //   450: aload_2
    //   451: invokevirtual 334	android/content/res/TypedArray:recycle	()V
    //   454: iload 4
    //   456: istore 11
    //   458: iload 5
    //   460: istore 7
    //   462: iload_3
    //   463: istore 10
    //   465: iload 8
    //   467: istore 6
    //   469: iload 12
    //   471: istore 9
    //   473: goto +97 -> 570
    //   476: astore_1
    //   477: iload 7
    //   479: istore 8
    //   481: iload 5
    //   483: istore 7
    //   485: goto +62 -> 547
    //   488: astore_1
    //   489: iload 4
    //   491: istore 5
    //   493: iload 6
    //   495: istore 4
    //   497: goto +39 -> 536
    //   500: astore_1
    //   501: iconst_0
    //   502: istore_3
    //   503: iload 4
    //   505: istore 5
    //   507: iload_3
    //   508: istore 4
    //   510: iload 6
    //   512: istore_3
    //   513: goto +23 -> 536
    //   516: astore_1
    //   517: iload_3
    //   518: istore 5
    //   520: goto +11 -> 531
    //   523: astore_1
    //   524: goto +310 -> 834
    //   527: astore_1
    //   528: iconst_0
    //   529: istore 5
    //   531: iconst_0
    //   532: istore 4
    //   534: iconst_0
    //   535: istore_3
    //   536: iconst_0
    //   537: istore 6
    //   539: iload 4
    //   541: istore 7
    //   543: iload 5
    //   545: istore 4
    //   547: aload_1
    //   548: invokevirtual 337	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   551: aload_2
    //   552: ifnull +7 -> 559
    //   555: aload_2
    //   556: invokevirtual 334	android/content/res/TypedArray:recycle	()V
    //   559: iload 8
    //   561: istore 9
    //   563: iload_3
    //   564: istore 10
    //   566: iload 4
    //   568: istore 11
    //   570: aload_0
    //   571: new 339	android/graphics/Paint
    //   574: dup
    //   575: iconst_1
    //   576: invokespecial 340	android/graphics/Paint:<init>	(I)V
    //   579: putfield 342	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   582: aload_0
    //   583: getfield 342	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   586: iload 11
    //   588: invokevirtual 345	android/graphics/Paint:setColor	(I)V
    //   591: aload_0
    //   592: getfield 342	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   595: getstatic 351	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   598: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   601: aload_0
    //   602: new 339	android/graphics/Paint
    //   605: dup
    //   606: iconst_1
    //   607: invokespecial 340	android/graphics/Paint:<init>	(I)V
    //   610: putfield 357	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   613: aload_0
    //   614: new 339	android/graphics/Paint
    //   617: dup
    //   618: iconst_1
    //   619: invokespecial 340	android/graphics/Paint:<init>	(I)V
    //   622: putfield 359	com/tencent/widget/ProgressPieView:mProgressPrePaint	Landroid/graphics/Paint;
    //   625: aload_0
    //   626: getfield 357	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   629: iload 10
    //   631: invokevirtual 345	android/graphics/Paint:setColor	(I)V
    //   634: aload_0
    //   635: getfield 359	com/tencent/widget/ProgressPieView:mProgressPrePaint	Landroid/graphics/Paint;
    //   638: iload 7
    //   640: invokevirtual 345	android/graphics/Paint:setColor	(I)V
    //   643: aload_0
    //   644: getfield 123	com/tencent/widget/ProgressPieView:mProgressFillType	I
    //   647: iconst_1
    //   648: if_icmpne +48 -> 696
    //   651: aload_0
    //   652: getfield 357	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   655: getstatic 362	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   658: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   661: aload_0
    //   662: getfield 357	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   665: aload_0
    //   666: getfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   669: invokevirtual 366	android/graphics/Paint:setStrokeWidth	(F)V
    //   672: aload_0
    //   673: getfield 359	com/tencent/widget/ProgressPieView:mProgressPrePaint	Landroid/graphics/Paint;
    //   676: getstatic 362	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   679: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   682: aload_0
    //   683: getfield 359	com/tencent/widget/ProgressPieView:mProgressPrePaint	Landroid/graphics/Paint;
    //   686: aload_0
    //   687: getfield 115	com/tencent/widget/ProgressPieView:mProgressStrokeWidth	F
    //   690: invokevirtual 366	android/graphics/Paint:setStrokeWidth	(F)V
    //   693: goto +23 -> 716
    //   696: aload_0
    //   697: getfield 357	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   700: getstatic 351	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   703: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   706: aload_0
    //   707: getfield 359	com/tencent/widget/ProgressPieView:mProgressPrePaint	Landroid/graphics/Paint;
    //   710: getstatic 351	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   713: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   716: aload_0
    //   717: new 339	android/graphics/Paint
    //   720: dup
    //   721: iconst_1
    //   722: invokespecial 340	android/graphics/Paint:<init>	(I)V
    //   725: putfield 368	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   728: aload_0
    //   729: getfield 368	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   732: iload 6
    //   734: invokevirtual 345	android/graphics/Paint:setColor	(I)V
    //   737: aload_0
    //   738: getfield 368	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   741: getstatic 362	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   744: invokevirtual 355	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   747: aload_0
    //   748: getfield 368	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   751: aload_0
    //   752: getfield 113	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   755: invokevirtual 366	android/graphics/Paint:setStrokeWidth	(F)V
    //   758: aload_0
    //   759: new 339	android/graphics/Paint
    //   762: dup
    //   763: iconst_1
    //   764: invokespecial 340	android/graphics/Paint:<init>	(I)V
    //   767: putfield 370	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   770: aload_0
    //   771: getfield 370	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   774: iload 9
    //   776: invokevirtual 345	android/graphics/Paint:setColor	(I)V
    //   779: aload_0
    //   780: getfield 370	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   783: aload_0
    //   784: getfield 119	com/tencent/widget/ProgressPieView:mTextSize	F
    //   787: invokevirtual 373	android/graphics/Paint:setTextSize	(F)V
    //   790: aload_0
    //   791: getfield 370	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   794: getstatic 379	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   797: invokevirtual 383	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   800: aload_0
    //   801: new 385	android/graphics/RectF
    //   804: dup
    //   805: invokespecial 387	android/graphics/RectF:<init>	()V
    //   808: putfield 389	com/tencent/widget/ProgressPieView:mInnerRectF	Landroid/graphics/RectF;
    //   811: aload_0
    //   812: new 391	android/graphics/Rect
    //   815: dup
    //   816: invokespecial 392	android/graphics/Rect:<init>	()V
    //   819: putfield 394	com/tencent/widget/ProgressPieView:mImageRect	Landroid/graphics/Rect;
    //   822: aload_0
    //   823: new 385	android/graphics/RectF
    //   826: dup
    //   827: invokespecial 387	android/graphics/RectF:<init>	()V
    //   830: putfield 396	com/tencent/widget/ProgressPieView:mInnerProgressRectF	Landroid/graphics/RectF;
    //   833: return
    //   834: aload_2
    //   835: ifnull +7 -> 842
    //   838: aload_2
    //   839: invokevirtual 334	android/content/res/TypedArray:recycle	()V
    //   842: aload_1
    //   843: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	this	ProgressPieView
    //   0	844	1	paramContext	Context
    //   0	844	2	paramAttributeSet	AttributeSet
    //   294	270	3	i	int
    //   290	277	4	j	int
    //   316	228	5	k	int
    //   320	413	6	m	int
    //   374	265	7	n	int
    //   278	282	8	i1	int
    //   281	494	9	i2	int
    //   370	260	10	i3	int
    //   429	158	11	i4	int
    //   425	45	12	i5	int
    // Exception table:
    //   from	to	target	type
    //   380	391	476	android/content/res/Resources$NotFoundException
    //   399	408	476	android/content/res/Resources$NotFoundException
    //   416	427	476	android/content/res/Resources$NotFoundException
    //   348	359	488	android/content/res/Resources$NotFoundException
    //   363	372	488	android/content/res/Resources$NotFoundException
    //   322	332	500	android/content/res/Resources$NotFoundException
    //   335	344	500	android/content/res/Resources$NotFoundException
    //   295	306	516	android/content/res/Resources$NotFoundException
    //   309	318	516	android/content/res/Resources$NotFoundException
    //   283	292	523	finally
    //   295	306	523	finally
    //   309	318	523	finally
    //   322	332	523	finally
    //   335	344	523	finally
    //   348	359	523	finally
    //   363	372	523	finally
    //   380	391	523	finally
    //   399	408	523	finally
    //   416	427	523	finally
    //   547	551	523	finally
    //   283	292	527	android/content/res/Resources$NotFoundException
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.mInnerRectF;
    float f1 = this.mViewSize;
    ((RectF)localObject).set(0.0F, 0.0F, f1, f1);
    this.mInnerRectF.offset((getWidth() - this.mViewSize) / 2.0F, (getHeight() - this.mViewSize) / 2.0F);
    int i;
    if (this.mShowStroke)
    {
      i = (int)(this.mStrokePaint.getStrokeWidth() / 2.0F + 0.5F);
      localObject = this.mInnerRectF;
      f1 = i;
      ((RectF)localObject).inset(f1, f1);
    }
    float f3 = this.mInnerRectF.centerX();
    float f4 = this.mInnerRectF.centerY();
    if (this.mShowArc)
    {
      this.mInnerProgressRectF.set(this.mInnerRectF);
      paramCanvas.drawArc(this.mInnerProgressRectF, 0.0F, 360.0F, true, this.mBackgroundPaint);
      i = this.mProgressFillType;
      float f2;
      if ((i != 0) && (i != 1))
      {
        if (i == 2)
        {
          f2 = this.mViewSize / 2.0F * (this.mProgress / this.mMax);
          f1 = f2;
          if (this.mShowStroke) {
            f1 = f2 + 0.5F - this.mStrokePaint.getStrokeWidth();
          }
          paramCanvas.drawCircle(f3, f4, f1, this.mProgressPaint);
        }
        else
        {
          paramCanvas = new StringBuilder();
          paramCanvas.append("Invalid Progress Fill = ");
          paramCanvas.append(this.mProgressFillType);
          throw new IllegalArgumentException(paramCanvas.toString());
        }
      }
      else
      {
        f2 = this.mProgress * 360 / this.mMax;
        f1 = f2;
        if (this.mInverted) {
          f1 = f2 - 360.0F;
        }
        f2 = f1;
        if (this.mCounterclockwise) {
          f2 = -f1;
        }
        if (this.mProgressFillType == 0)
        {
          paramCanvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f2, true, this.mProgressPaint);
        }
        else
        {
          i = (int)(this.mProgressPaint.getStrokeWidth() / 2.0F + 0.5F);
          localObject = this.mInnerProgressRectF;
          f1 = i;
          ((RectF)localObject).inset(f1, f1);
          if (this.mProgressPreType == 1)
          {
            if (this.mProgress >= 500)
            {
              i = 180000 / this.mMax;
              localObject = this.mInnerProgressRectF;
              f1 = this.mStartAngle;
              float f5 = i;
              paramCanvas.drawArc((RectF)localObject, f1, f5, false, this.mProgressPrePaint);
              paramCanvas.drawArc(this.mInnerProgressRectF, this.mStartAngle + i, f2 - f5, false, this.mProgressPaint);
            }
            else
            {
              paramCanvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f2, false, this.mProgressPrePaint);
            }
          }
          else {
            paramCanvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f2, false, this.mProgressPaint);
          }
        }
      }
    }
    if ((!TextUtils.isEmpty(this.mText)) && (this.mShowText))
    {
      if (!TextUtils.isEmpty(this.mTypeface))
      {
        Typeface localTypeface = (Typeface)sTypefaceCache.get(this.mTypeface);
        localObject = localTypeface;
        if (localTypeface == null)
        {
          localObject = localTypeface;
          if (getResources() != null)
          {
            AssetManager localAssetManager = getResources().getAssets();
            localObject = localTypeface;
            if (localAssetManager != null)
            {
              localObject = Typeface.createFromAsset(localAssetManager, this.mTypeface);
              sTypefaceCache.put(this.mTypeface, localObject);
            }
          }
        }
        this.mTextPaint.setTypeface((Typeface)localObject);
      }
      i = (int)f3;
      int j = (int)(f4 - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F);
      paramCanvas.drawText(this.mText, i, j, this.mTextPaint);
    }
    localObject = this.mImage;
    if ((localObject != null) && (this.mShowImage))
    {
      if (this.mDrawImageFillView)
      {
        this.mImageRect.set(0, 0, getWidth(), getHeight());
      }
      else
      {
        i = ((Drawable)localObject).getIntrinsicWidth();
        this.mImageRect.set(0, 0, i, i);
        this.mImageRect.offset((getWidth() - i) / 2, (getHeight() - i) / 2);
      }
      this.mImage.setBounds(this.mImageRect);
      this.mImage.draw(paramCanvas);
    }
    if ((this.mShowStroke) && (this.mShowArc)) {
      paramCanvas.drawOval(this.mInnerRectF, this.mStrokePaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = resolveSize(Utils.a(this.mDefaultViewSize, getResources()), paramInt1);
    paramInt2 = resolveSize(Utils.a(this.mDefaultViewSize, getResources()), paramInt2);
    this.mViewSize = Math.min(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setAnimationSpeed(int paramInt)
  {
    this.mAnimationSpeed = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCounterclockwise(boolean paramBoolean)
  {
    this.mCounterclockwise = paramBoolean;
  }
  
  public void setDefaultViewSize(int paramInt)
  {
    float f1 = this.mDefaultViewSize;
    float f2 = paramInt;
    if (Float.compare(f1, f2) != 0)
    {
      this.mDefaultViewSize = f2;
      invalidate();
    }
  }
  
  public void setDrawImageFillView(boolean paramBoolean)
  {
    this.mDrawImageFillView = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mImage = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.mImage = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.mInverted = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    if ((paramInt > 0) && (paramInt >= this.mProgress))
    {
      this.mMax = paramInt;
      invalidate();
      return;
    }
    throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mProgress) }));
  }
  
  public void setOnProgressListener(ProgressPieView.OnProgressListener paramOnProgressListener)
  {
    this.mListener = paramOnProgressListener;
  }
  
  public void setPregressPreColor(int paramInt)
  {
    this.mProgressPrePaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt <= this.mMax) && (paramInt >= 0))
    {
      this.mProgress = paramInt;
      invalidate();
      ProgressPieView.OnProgressListener localOnProgressListener = this.mListener;
      if (localOnProgressListener != null)
      {
        paramInt = this.mProgress;
        int i = this.mMax;
        if (paramInt == i)
        {
          localOnProgressListener.onProgressCompleted();
          return;
        }
        localOnProgressListener.onProgressChanged(paramInt, i);
      }
      return;
    }
    throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.mMax) }));
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgressFillType(int paramInt)
  {
    this.mProgressFillType = paramInt;
    if (paramInt == 1)
    {
      this.mProgressPaint.setStyle(Paint.Style.STROKE);
      this.mProgressPaint.setStrokeWidth(this.mProgressStrokeWidth);
      return;
    }
    this.mProgressPaint.setStyle(Paint.Style.FILL);
  }
  
  public void setProgressPreType(int paramInt)
  {
    this.mProgressPreType = paramInt;
  }
  
  public void setProgressStrokeWidth(int paramInt)
  {
    if (this.mProgressPaint.getStyle() == Paint.Style.STROKE)
    {
      this.mProgressStrokeWidth = (paramInt * this.mDisplayMetrics.density);
      this.mProgressPaint.setStrokeWidth(this.mProgressStrokeWidth);
      invalidate();
    }
  }
  
  public void setShowImage(boolean paramBoolean)
  {
    this.mShowImage = paramBoolean;
    invalidate();
  }
  
  public void setShowStroke(boolean paramBoolean)
  {
    this.mShowStroke = paramBoolean;
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.mShowText = paramBoolean;
    invalidate();
  }
  
  public void setStartAngle(int paramInt)
  {
    this.mStartAngle = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.mStrokePaint.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = (paramInt * this.mDisplayMetrics.density);
    this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.mTextSize = (paramInt * this.mDisplayMetrics.scaledDensity);
    this.mTextPaint.setTextSize(this.mTextSize);
    invalidate();
  }
  
  public void setTypeface(String paramString)
  {
    this.mTypeface = paramString;
    invalidate();
  }
  
  public void startTimeAnimation()
  {
    this.mTimeAnimationHandler.reset();
    this.mTimeAnimationHandler.sendEmptyMessageDelayed(0, 1L);
  }
  
  public void stopAnimating()
  {
    this.mAnimationHandler.removeMessages(0);
    this.mAnimationHandler.setAnimateTo(this.mProgress);
    this.mTimeAnimationHandler.removeMessages(0);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView
 * JD-Core Version:    0.7.0.1
 */