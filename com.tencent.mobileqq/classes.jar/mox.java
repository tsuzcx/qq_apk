import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import java.lang.ref.WeakReference;

public class mox
  extends mow
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private moy jdField_a_of_type_Moy;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  int i = 10;
  int j = 8;
  int k = 4;
  
  public mox(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat, moy parammoy)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_ArrayOfInt = new int[] { paramInt1 / 6, paramInt1 / 5 };
    this.jdField_a_of_type_Moy = parammoy;
    e();
  }
  
  /* Error */
  private Bitmap c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 103	mox:jdField_a_of_type_Lgi	Llgi;
    //   7: getfield 108	lgi:a	Ljava/lang/CharSequence;
    //   10: checkcast 110	java/lang/String
    //   13: astore 9
    //   15: aload 9
    //   17: invokevirtual 114	java/lang/String:length	()I
    //   20: istore 6
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 88	mox:jdField_a_of_type_Moy	Lmoy;
    //   27: getfield 118	moy:b	I
    //   30: iload 6
    //   32: imul
    //   33: iload 6
    //   35: iconst_1
    //   36: isub
    //   37: aload_0
    //   38: getfield 42	mox:j	I
    //   41: imul
    //   42: iadd
    //   43: aload_0
    //   44: getfield 88	mox:jdField_a_of_type_Moy	Lmoy;
    //   47: getfield 118	moy:b	I
    //   50: getstatic 124	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   53: invokestatic 130	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   56: putfield 132	mox:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   59: aload_0
    //   60: getfield 38	mox:jdField_b_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   63: aload_0
    //   64: getfield 132	mox:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   67: invokevirtual 136	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   70: aload_0
    //   71: getfield 88	mox:jdField_a_of_type_Moy	Lmoy;
    //   74: getfield 118	moy:b	I
    //   77: iconst_2
    //   78: idiv
    //   79: i2f
    //   80: fstore_2
    //   81: aload_0
    //   82: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   85: invokevirtual 140	android/graphics/Paint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   88: astore 10
    //   90: aload 10
    //   92: getfield 146	android/graphics/Paint$FontMetrics:ascent	F
    //   95: fstore_1
    //   96: aload 10
    //   98: getfield 149	android/graphics/Paint$FontMetrics:descent	F
    //   101: fload_1
    //   102: fadd
    //   103: fconst_2
    //   104: fdiv
    //   105: fstore_3
    //   106: aload_0
    //   107: getfield 44	mox:k	I
    //   110: iconst_2
    //   111: idiv
    //   112: i2f
    //   113: fstore 4
    //   115: fload_2
    //   116: fstore_1
    //   117: iload 5
    //   119: iload 6
    //   121: if_icmpge +194 -> 315
    //   124: aload_0
    //   125: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   128: iconst_0
    //   129: invokevirtual 153	android/graphics/Paint:setAntiAlias	(Z)V
    //   132: aload_0
    //   133: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   136: getstatic 159	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   139: invokevirtual 163	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   142: aload_0
    //   143: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   146: iconst_m1
    //   147: invokevirtual 167	android/graphics/Paint:setColor	(I)V
    //   150: aload_0
    //   151: getfield 38	mox:jdField_b_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   154: fload_1
    //   155: fload_2
    //   156: fload_2
    //   157: aload_0
    //   158: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   161: invokevirtual 171	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   164: aload_0
    //   165: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   168: iconst_1
    //   169: invokevirtual 153	android/graphics/Paint:setAntiAlias	(Z)V
    //   172: aload_0
    //   173: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   176: getstatic 174	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   179: invokevirtual 163	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   182: aload_0
    //   183: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   186: ldc 175
    //   188: invokevirtual 167	android/graphics/Paint:setColor	(I)V
    //   191: aload_0
    //   192: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   195: aload_0
    //   196: getfield 44	mox:k	I
    //   199: i2f
    //   200: invokevirtual 179	android/graphics/Paint:setStrokeWidth	(F)V
    //   203: aload_0
    //   204: getfield 38	mox:jdField_b_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   207: fload_1
    //   208: fload_2
    //   209: fload_2
    //   210: fload 4
    //   212: fsub
    //   213: aload_0
    //   214: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   217: invokevirtual 171	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   220: aload_0
    //   221: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   224: fconst_0
    //   225: invokevirtual 179	android/graphics/Paint:setStrokeWidth	(F)V
    //   228: aload_0
    //   229: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   232: getstatic 159	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   235: invokevirtual 163	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   238: aload_0
    //   239: getfield 38	mox:jdField_b_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   242: aload 9
    //   244: iload 5
    //   246: iload 5
    //   248: iconst_1
    //   249: iadd
    //   250: fload_1
    //   251: fload_2
    //   252: fload_3
    //   253: fsub
    //   254: aload_0
    //   255: getfield 74	mox:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   258: invokevirtual 183	android/graphics/Canvas:drawText	(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V
    //   261: aload_0
    //   262: getfield 88	mox:jdField_a_of_type_Moy	Lmoy;
    //   265: getfield 118	moy:b	I
    //   268: istore 7
    //   270: aload_0
    //   271: getfield 42	mox:j	I
    //   274: istore 8
    //   276: fload_1
    //   277: iload 7
    //   279: iload 8
    //   281: iadd
    //   282: i2f
    //   283: fadd
    //   284: fstore_1
    //   285: iload 5
    //   287: iconst_1
    //   288: iadd
    //   289: istore 5
    //   291: goto -174 -> 117
    //   294: astore 9
    //   296: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +16 -> 315
    //   302: aload_0
    //   303: getfield 192	mox:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   306: iconst_2
    //   307: aload 9
    //   309: invokevirtual 196	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   312: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_0
    //   316: getfield 132	mox:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   319: areturn
    //   320: astore 9
    //   322: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq -10 -> 315
    //   328: aload_0
    //   329: getfield 192	mox:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   332: iconst_2
    //   333: aload 9
    //   335: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -26 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	mox
    //   95	190	1	f1	float
    //   80	172	2	f2	float
    //   105	148	3	f3	float
    //   113	98	4	f4	float
    //   1	289	5	m	int
    //   20	102	6	n	int
    //   268	14	7	i1	int
    //   274	8	8	i2	int
    //   13	230	9	str	String
    //   294	14	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   320	14	9	localException	java.lang.Exception
    //   88	9	10	localFontMetrics	android.graphics.Paint.FontMetrics
    // Exception table:
    //   from	to	target	type
    //   3	115	294	java/lang/OutOfMemoryError
    //   124	276	294	java/lang/OutOfMemoryError
    //   3	115	320	java/lang/Exception
    //   124	276	320	java/lang/Exception
  }
  
  private boolean d()
  {
    return this.e < this.g / 2;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < 8) {
      return this.jdField_a_of_type_ArrayOfInt[0];
    }
    return this.jdField_a_of_type_ArrayOfInt[1];
  }
  
  protected int a(Paint paramPaint)
  {
    this.d = this.jdField_a_of_type_Moy.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRect.right = this.d;
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.d;
    return this.d;
  }
  
  protected int a(Paint paramPaint, String paramString)
  {
    if (this.jdField_a_of_type_Lgi != null) {}
    for (int m = this.jdField_a_of_type_Lgi.a.length();; m = 0)
    {
      int n = this.jdField_a_of_type_Moy.jdField_a_of_type_Int;
      int i1 = this.i;
      int i2 = this.jdField_a_of_type_Moy.b;
      return (m - 1) * this.j + (n + i1 + i2 * m);
    }
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      c();
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, c(), d());
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    paramCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.save();
    paramCanvas.clipRect(this.jdField_a_of_type_Moy.jdField_a_of_type_Int / 2, 0, paramInt1, paramInt2);
    float f2 = this.jdField_a_of_type_Moy.jdField_a_of_type_Int + this.i;
    float f1 = f2;
    if (d())
    {
      f1 = f2 - 100.0F * this.jdField_a_of_type_Float;
      f1 = (f2 - f1) * (this.e * 2) / this.g + f1;
    }
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, f1, (this.jdField_a_of_type_Moy.jdField_a_of_type_Int - this.jdField_a_of_type_Moy.b) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    Bitmap localBitmap = this.jdField_a_of_type_Moy.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[((int)((l - this.jdField_a_of_type_Long) / 200L % this.jdField_a_of_type_Moy.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length))];
    this.jdField_a_of_type_AndroidGraphicsRect.right = localBitmap.getWidth();
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = localBitmap.getHeight();
    paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(moy parammoy)
  {
    this.jdField_a_of_type_Moy = parammoy;
  }
  
  void d()
  {
    super.d();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Moy.c;
  }
  
  void e()
  {
    float f = 0.48F * this.jdField_a_of_type_Float;
    this.i = ((int)(this.i * f));
    this.j = ((int)(this.j * f));
    this.k = ((int)(f * this.k));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mox
 * JD-Core Version:    0.7.0.1
 */