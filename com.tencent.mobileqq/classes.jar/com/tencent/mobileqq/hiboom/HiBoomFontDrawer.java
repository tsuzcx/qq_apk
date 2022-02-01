package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class HiBoomFontDrawer
{
  HiBoomInfo a;
  public int b;
  public int c;
  Typeface d;
  public int e = -1;
  ArrayList<WeakReference<HiBoomTextView>> f;
  public AtomicBoolean g = new AtomicBoolean(false);
  public AtomicBoolean h = new AtomicBoolean(false);
  public AtomicBoolean i = new AtomicBoolean(false);
  Vector<String> j = new Vector();
  Paint k;
  public HiBoomFont.HiBoomFontDownloader l;
  
  HiBoomFontDrawer(int paramInt, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.c = paramInt;
    this.l = paramHiBoomFontDownloader;
    a(true);
  }
  
  @Nullable
  private Bitmap a(HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, Paint paramPaint, Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramHiBoomInfoStyleWord.c))
    {
      paramHiBoomInfoStyleWord = paramString;
      if (!TextUtils.isEmpty(paramHiBoomInfoStyle.d)) {
        if (c(paramHiBoomInfoStyle.d))
        {
          paramPaint.setColor(Color.parseColor(paramHiBoomInfoStyle.d));
          paramHiBoomInfoStyleWord = paramString;
        }
        else
        {
          paramHiBoomInfoStyleWord = new StringBuilder();
          paramHiBoomInfoStyleWord.append(this.l.a());
          paramHiBoomInfoStyleWord.append(this.c);
          paramHiBoomInfoStyleWord.append(File.separator);
          paramHiBoomInfoStyleWord.append("images/");
          paramHiBoomInfoStyleWord.append(paramHiBoomInfoStyle.d);
          paramHiBoomInfoStyleWord = paramHiBoomInfoStyleWord.toString();
        }
      }
    }
    else if (c(paramHiBoomInfoStyleWord.c))
    {
      paramPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.c));
      paramHiBoomInfoStyleWord = paramString;
    }
    else
    {
      paramHiBoomInfoStyle = new StringBuilder();
      paramHiBoomInfoStyle.append(this.l.a());
      paramHiBoomInfoStyle.append(this.c);
      paramHiBoomInfoStyle.append(File.separator);
      paramHiBoomInfoStyle.append("images/");
      paramHiBoomInfoStyle.append(paramHiBoomInfoStyleWord.c);
      paramHiBoomInfoStyleWord = paramHiBoomInfoStyle.toString();
    }
    if (!TextUtils.isEmpty(paramHiBoomInfoStyleWord))
    {
      paramPaint.setColor(-16777216);
      paramHiBoomInfoStyle = (Bitmap)GlobalImageCache.a.get(paramHiBoomInfoStyleWord);
      if (paramHiBoomInfoStyle != null)
      {
        if ((paramHiBoomInfoStyle.getWidth() == paramInt) && (paramHiBoomInfoStyle.getHeight() == paramInt)) {
          break label304;
        }
        paramHiBoomInfoStyleWord = new Matrix();
        float f1 = paramInt;
        paramHiBoomInfoStyleWord.setScale(f1 / paramHiBoomInfoStyle.getWidth(), f1 / paramHiBoomInfoStyle.getHeight());
        paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, 0, 0, paramHiBoomInfoStyle.getWidth(), paramHiBoomInfoStyle.getHeight(), paramHiBoomInfoStyleWord, false);
        label304:
        paramPaint.setShader(new BitmapShader(paramHiBoomInfoStyle, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
        return paramHiBoomInfoStyle;
      }
      paramBitmap = paramHiBoomInfoStyle;
    }
    return paramBitmap;
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 173	java/io/BufferedInputStream
    //   7: dup
    //   8: new 175	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 181	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokestatic 187	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   33: aload_2
    //   34: areturn
    //   35: astore_1
    //   36: ldc 192
    //   38: iconst_1
    //   39: ldc 194
    //   41: aload_1
    //   42: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   45: aload_0
    //   46: areturn
    //   47: astore_2
    //   48: goto +16 -> 64
    //   51: astore_2
    //   52: goto +38 -> 90
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: goto +60 -> 118
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: ldc 192
    //   68: iconst_1
    //   69: ldc 194
    //   71: aload_2
    //   72: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_1
    //   76: ifnull +35 -> 111
    //   79: aload_3
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 192
    //   94: iconst_1
    //   95: ldc 194
    //   97: aload_2
    //   98: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_1
    //   102: ifnull +9 -> 111
    //   105: aload_3
    //   106: astore_0
    //   107: aload_1
    //   108: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: ifnull +20 -> 139
    //   122: aload_1
    //   123: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   126: goto +13 -> 139
    //   129: astore_1
    //   130: ldc 192
    //   132: iconst_1
    //   133: ldc 194
    //   135: aload_1
    //   136: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   19	11	1	localBufferedInputStream	java.io.BufferedInputStream
    //   35	7	1	localIOException1	java.io.IOException
    //   57	66	1	localObject1	Object
    //   129	7	1	localIOException2	java.io.IOException
    //   1	33	2	localBitmap	Bitmap
    //   47	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   51	6	2	localException1	Exception
    //   61	11	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   87	11	2	localException2	Exception
    //   113	4	2	localObject2	Object
    //   3	103	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/io/IOException
    //   81	85	35	java/io/IOException
    //   107	111	35	java/io/IOException
    //   22	27	47	java/lang/OutOfMemoryError
    //   22	27	51	java/lang/Exception
    //   4	20	55	finally
    //   4	20	61	java/lang/OutOfMemoryError
    //   4	20	87	java/lang/Exception
    //   22	27	113	finally
    //   66	75	113	finally
    //   92	101	113	finally
    //   122	126	129	java/io/IOException
  }
  
  private void a(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, float paramFloat)
  {
    int m = Math.max(paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    a(paramInt1, paramInt2, paramHiBoomInfoStyle, paramHiBoomInfoStyleWord, localPaint, paramString, localCanvas);
    if (paramHiBoomInfoStyleWord.j > 0) {
      a(paramString, paramHiBoomInfoStyleWord, paramFloat, m, localCanvas, localPaint);
    }
    paramString = new Matrix();
    if ((localBitmap.getWidth() != paramInt1) || (localBitmap.getHeight() != paramInt2)) {
      paramString.postScale(paramInt1 / localBitmap.getWidth(), paramInt2 / localBitmap.getHeight());
    }
    paramString.postTranslate(paramHiBoomInfoStyleWord.g[0] * paramFloat - paramInt1 / 2, paramHiBoomInfoStyleWord.g[1] * paramFloat - paramInt2 / 2);
    paramString.postRotate(paramHiBoomInfoStyleWord.h, paramHiBoomInfoStyleWord.g[0] * paramFloat, paramHiBoomInfoStyleWord.g[1] * paramFloat);
    paramCanvas.drawBitmap(localBitmap, paramString, localPaint);
    paramCanvas.save();
    localBitmap.recycle();
  }
  
  private void a(List<String> paramList)
  {
    ThreadManager.post(new HiBoomFontDrawer.3(this, paramList), 8, null, true);
  }
  
  private boolean a(HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle)
  {
    int[] arrayOfInt = paramHiBoomInfoStyleWord.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt[0] == paramHiBoomInfoStyleWord.e[1]) {
      if ((!TextUtils.isEmpty(paramHiBoomInfoStyleWord.c)) || (TextUtils.isEmpty(paramHiBoomInfoStyle.d)) || (!paramHiBoomInfoStyle.d.startsWith("#")) || (paramHiBoomInfoStyle.d.length() != 9))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.c))
        {
          bool1 = bool2;
          if (paramHiBoomInfoStyleWord.c.startsWith("#"))
          {
            bool1 = bool2;
            if (paramHiBoomInfoStyleWord.c.length() != 9) {}
          }
        }
      }
      else if (paramHiBoomInfoStyleWord.j > 0)
      {
        bool1 = bool2;
        if (paramHiBoomInfoStyleWord.j > 0)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.i))
          {
            bool1 = bool2;
            if (paramHiBoomInfoStyleWord.i.startsWith("#"))
            {
              bool1 = bool2;
              if (paramHiBoomInfoStyleWord.i.length() != 9) {}
            }
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramHiBoomInfoStyleWord.h == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, float paramFloat)
  {
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    float f4 = paramInt1;
    localPaint.setTextSize(f4);
    float f5 = paramHiBoomInfoStyleWord.g[0] * paramFloat;
    float f1 = paramHiBoomInfoStyleWord.g[1] * paramFloat;
    localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.d));
    float f2 = paramInt1 / 2;
    float f3 = f5 - f2;
    paramCanvas.drawRect(f3, f1 - f2, f5 + f2, f1 + f2, localPaint);
    paramCanvas.save();
    Typeface localTypeface = this.d;
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    if (TextUtils.isEmpty(paramHiBoomInfoStyleWord.c))
    {
      if ((!TextUtils.isEmpty(paramHiBoomInfoStyle.d)) && (paramHiBoomInfoStyle.d.startsWith("#")) && (paramHiBoomInfoStyle.d.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyle.d));
      }
    }
    else if ((paramHiBoomInfoStyleWord.c.startsWith("#")) && (paramHiBoomInfoStyleWord.c.length() == 9)) {
      localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.c));
    }
    f4 /= 2.0F;
    paramCanvas.drawText(paramString, f3, f4 - (localPaint.descent() + localPaint.ascent()) / 2.0F - f2 + f1, localPaint);
    paramCanvas.save();
    if ((paramHiBoomInfoStyleWord.j > 0) && (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.i)))
    {
      localPaint.setShader(null);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeJoin(Paint.Join.ROUND);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localPaint.setStrokeWidth(paramHiBoomInfoStyleWord.j * paramFloat);
      if ((paramHiBoomInfoStyleWord.i.startsWith("#")) && (paramHiBoomInfoStyleWord.i.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.i));
      }
      paramCanvas.drawText(paramString, f3, f1 + (f4 - (localPaint.descent() + localPaint.ascent()) / 2.0F - f2), localPaint);
      paramCanvas.save();
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!paramString.startsWith("#"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.l.a());
        localStringBuilder.append(this.c);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("images/");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        int m = 0;
        while (m < this.j.size())
        {
          if (paramString.equals(this.j.get(m))) {
            return false;
          }
          m += 1;
        }
        bool1 = bool2;
        if (GlobalImageCache.a.get(paramString) == null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new HiBoomFontDrawer.4(this));
  }
  
  private boolean c(String paramString)
  {
    return (paramString.startsWith("#")) && (paramString.length() == 9);
  }
  
  protected void a()
  {
    if (!((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFZEngineInited())
    {
      HiBoomFont.a().d();
      QLog.d("HiBoomFont.FontDrawer", 2, "run: initFZEngine");
    }
    if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFZSoLoaded())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo: initFont");
      }
      ThreadManager.getUIHandler().post(new HiBoomFontDrawer.2(this));
      return;
    }
    this.h.set(false);
  }
  
  protected void a(int paramInt1, int paramInt2, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, Paint paramPaint, String paramString, Canvas paramCanvas)
  {
    int m = Math.max(paramInt1, paramInt2);
    paramPaint.setAntiAlias(true);
    paramPaint.setDither(true);
    paramPaint.setFilterBitmap(true);
    float f1 = m;
    paramPaint.setTextSize(f1);
    paramPaint.setColor(-16777216);
    Object localObject = this.d;
    if (localObject != null) {
      paramPaint.setTypeface((Typeface)localObject);
    }
    int[] arrayOfInt = paramHiBoomInfoStyleWord.f;
    localObject = null;
    if ((arrayOfInt != null) && (arrayOfInt[3] != 0))
    {
      paramHiBoomInfoStyle = new StringBuilder();
      paramHiBoomInfoStyle.append(this.l.a());
      paramHiBoomInfoStyle.append(this.c);
      paramHiBoomInfoStyle.append(File.separator);
      paramHiBoomInfoStyle.append("images/");
      paramHiBoomInfoStyle.append(paramHiBoomInfoStyleWord.c);
      paramHiBoomInfoStyle = paramHiBoomInfoStyle.toString();
      Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(paramHiBoomInfoStyle);
      paramHiBoomInfoStyle = (HiBoomInfo.HiBoomInfoStyle)localObject;
      if (localBitmap != null)
      {
        int i1 = localBitmap.getWidth();
        int n = localBitmap.getHeight();
        if (arrayOfInt[3] == -1)
        {
          double d1 = Math.random();
          double d2 = i1 - paramInt1;
          Double.isNaN(d2);
          i1 = (int)(d1 * d2);
          d1 = Math.random();
          d2 = n - paramInt2;
          Double.isNaN(d2);
          paramHiBoomInfoStyle = Bitmap.createBitmap(localBitmap, i1, (int)(d1 * d2), paramInt1, paramInt2);
        }
        else
        {
          paramHiBoomInfoStyle = Bitmap.createBitmap(localBitmap, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
        }
        if (paramHiBoomInfoStyle != null)
        {
          if ((paramHiBoomInfoStyle.getWidth() == m) && (paramHiBoomInfoStyle.getHeight() == m)) {
            break label352;
          }
          localObject = new Matrix();
          ((Matrix)localObject).setScale(f1 / paramHiBoomInfoStyle.getWidth(), f1 / paramHiBoomInfoStyle.getHeight());
          paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, 0, 0, paramHiBoomInfoStyle.getWidth(), paramHiBoomInfoStyle.getHeight(), (Matrix)localObject, false);
          label352:
          paramPaint.setShader(new BitmapShader(paramHiBoomInfoStyle, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
        }
      }
    }
    else
    {
      paramHiBoomInfoStyle = a(paramHiBoomInfoStyle, paramHiBoomInfoStyleWord, paramPaint, null, m, null);
    }
    paramCanvas.drawColor(Color.parseColor(paramHiBoomInfoStyleWord.d));
    paramCanvas.drawText(paramString, 0.0F, (int)(f1 / 2.0F - (paramPaint.descent() + paramPaint.ascent()) / 2.0F), paramPaint);
    paramCanvas.save();
    if (paramHiBoomInfoStyle != null) {
      paramHiBoomInfoStyle.recycle();
    }
  }
  
  protected void a(Canvas paramCanvas, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, float paramFloat)
  {
    if (paramHiBoomInfoStyle.g == null) {
      return;
    }
    paramHiBoomInfoStyle = paramHiBoomInfoStyle.g.iterator();
    while (paramHiBoomInfoStyle.hasNext())
    {
      HiBoomInfo.HiBoomInfoStyleImage localHiBoomInfoStyleImage = (HiBoomInfo.HiBoomInfoStyleImage)paramHiBoomInfoStyle.next();
      if (!TextUtils.isEmpty(localHiBoomInfoStyleImage.a))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.l.a());
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("images/");
        ((StringBuilder)localObject).append(localHiBoomInfoStyleImage.a);
        localObject = ((StringBuilder)localObject).toString();
        localObject = (Bitmap)GlobalImageCache.a.get(localObject);
        Matrix localMatrix = new Matrix();
        float f1 = localHiBoomInfoStyleImage.b[0] * paramFloat;
        float f2 = localHiBoomInfoStyleImage.b[1] * paramFloat;
        if (localObject != null)
        {
          if ((((Bitmap)localObject).getWidth() != f1) || (((Bitmap)localObject).getHeight() != f2)) {
            localMatrix.postScale(f1 / ((Bitmap)localObject).getWidth(), f2 / ((Bitmap)localObject).getHeight());
          }
          localMatrix.postTranslate(localHiBoomInfoStyleImage.c[0] * paramFloat - f1 / 2.0F, localHiBoomInfoStyleImage.c[1] * paramFloat - f2 / 2.0F);
          localMatrix.postRotate(localHiBoomInfoStyleImage.d, localHiBoomInfoStyleImage.c[0] * paramFloat, localHiBoomInfoStyleImage.c[1] * paramFloat);
          paramCanvas.drawBitmap((Bitmap)localObject, localMatrix, this.k);
          paramCanvas.save();
        }
      }
    }
  }
  
  protected void a(Canvas paramCanvas, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, int paramInt1, int paramInt2)
  {
    if (this.k == null)
    {
      this.k = new Paint();
      this.k.setAntiAlias(true);
      this.k.setDither(true);
      this.k.setFilterBitmap(true);
    }
    if (TextUtils.isEmpty(paramHiBoomInfoStyle.c)) {
      return;
    }
    if (c(paramHiBoomInfoStyle.c))
    {
      paramCanvas.drawColor(Color.parseColor(paramHiBoomInfoStyle.c));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.l.a());
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("images/");
    ((StringBuilder)localObject).append(paramHiBoomInfoStyle.c);
    paramHiBoomInfoStyle = ((StringBuilder)localObject).toString();
    paramHiBoomInfoStyle = (Bitmap)GlobalImageCache.a.get(paramHiBoomInfoStyle);
    if (paramHiBoomInfoStyle == null) {
      return;
    }
    localObject = new Matrix();
    if ((paramHiBoomInfoStyle.getWidth() != paramInt1) || (paramHiBoomInfoStyle.getHeight() != paramInt2)) {
      ((Matrix)localObject).setScale(paramInt1 / paramHiBoomInfoStyle.getWidth(), paramInt2 / paramHiBoomInfoStyle.getHeight());
    }
    paramCanvas.drawBitmap(paramHiBoomInfoStyle, (Matrix)localObject, this.k);
  }
  
  public void a(HiBoomTextView paramHiBoomTextView)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(new WeakReference(paramHiBoomTextView));
  }
  
  void a(String paramString, int paramInt, Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.a != null)
      {
        Object localObject2 = null;
        int m = paramString.length();
        Iterator localIterator = this.a.d.iterator();
        Object localObject1;
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (HiBoomInfo.HiBoomInfoStyle)localIterator.next();
        } while (((HiBoomInfo.HiBoomInfoStyle)localObject1).f != m);
        if (localObject1 != null)
        {
          if (localObject1.e[0] > localObject1.e[1]) {
            m = paramInt;
          } else {
            m = localObject1.e[0] * paramInt / localObject1.e[1];
          }
          int n = paramInt;
          if (localObject1.e[0] > localObject1.e[1]) {
            n = localObject1.e[1] * paramInt / localObject1.e[0];
          }
          a(paramCanvas, (HiBoomInfo.HiBoomInfoStyle)localObject1, m, n);
          float f1 = m / localObject1.e[0];
          a(paramString, paramCanvas, (HiBoomInfo.HiBoomInfoStyle)localObject1, f1);
          a(paramCanvas, (HiBoomInfo.HiBoomInfoStyle)localObject1, f1);
          return;
        }
        throw new Exception("hiboomStyle error!");
      }
      throw new Exception("please init font first!");
    }
    paramString = new Exception("text is null!");
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void a(String paramString, Canvas paramCanvas, HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, float paramFloat)
  {
    int m = 0;
    while (m < paramHiBoomInfoStyle.h.size())
    {
      HiBoomInfo.HiBoomInfoStyleWord localHiBoomInfoStyleWord = (HiBoomInfo.HiBoomInfoStyleWord)paramHiBoomInfoStyle.h.get(m);
      int n = (int)(localHiBoomInfoStyleWord.e[0] * paramFloat);
      int i1 = (int)(localHiBoomInfoStyleWord.e[1] * paramFloat);
      StringBuilder localStringBuilder;
      if (a(localHiBoomInfoStyleWord, paramHiBoomInfoStyle))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.charAt(localHiBoomInfoStyleWord.a));
        localStringBuilder.append("");
        b(paramCanvas, localStringBuilder.toString(), n, i1, paramHiBoomInfoStyle, localHiBoomInfoStyleWord, paramFloat);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.charAt(localHiBoomInfoStyleWord.a));
        localStringBuilder.append("");
        a(paramCanvas, localStringBuilder.toString(), n, i1, paramHiBoomInfoStyle, localHiBoomInfoStyleWord, paramFloat);
      }
      m += 1;
    }
  }
  
  protected void a(String paramString, HiBoomInfo.HiBoomInfoStyleWord paramHiBoomInfoStyleWord, float paramFloat, int paramInt, Canvas paramCanvas, Paint paramPaint)
  {
    if (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.i))
    {
      Object localObject2 = null;
      paramPaint.setShader(null);
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeJoin(Paint.Join.ROUND);
      paramPaint.setStrokeCap(Paint.Cap.ROUND);
      paramPaint.setStrokeWidth(paramHiBoomInfoStyleWord.j * paramFloat);
      Object localObject1;
      if (c(paramHiBoomInfoStyleWord.i))
      {
        paramPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.i));
        localObject1 = null;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.l.a());
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("images/");
        ((StringBuilder)localObject1).append(paramHiBoomInfoStyleWord.i);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramHiBoomInfoStyleWord = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramPaint.setColor(-16777216);
        localObject1 = (Bitmap)GlobalImageCache.a.get(localObject1);
        paramHiBoomInfoStyleWord = (HiBoomInfo.HiBoomInfoStyleWord)localObject1;
        if (localObject1 != null)
        {
          if (((Bitmap)localObject1).getWidth() == paramInt)
          {
            paramHiBoomInfoStyleWord = (HiBoomInfo.HiBoomInfoStyleWord)localObject1;
            if (((Bitmap)localObject1).getHeight() == paramInt) {}
          }
          else
          {
            paramHiBoomInfoStyleWord = new Matrix();
            paramFloat = paramInt;
            paramHiBoomInfoStyleWord.setScale(paramFloat / ((Bitmap)localObject1).getWidth(), paramFloat / ((Bitmap)localObject1).getHeight());
            paramHiBoomInfoStyleWord = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramHiBoomInfoStyleWord, false);
          }
          paramPaint.setShader(new BitmapShader(paramHiBoomInfoStyleWord, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
        }
      }
      paramCanvas.drawText(paramString, 0.0F, (int)(paramInt / 2.0F - (paramPaint.descent() + paramPaint.ascent()) / 2.0F), paramPaint);
      paramCanvas.save();
      if (paramHiBoomInfoStyleWord != null) {
        paramHiBoomInfoStyleWord.recycle();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h.get()) {
      return;
    }
    this.h.set(true);
    ThreadManager.getFileThreadHandler().post(new HiBoomFontDrawer.1(this, paramBoolean));
  }
  
  boolean a(int paramInt)
  {
    ArrayList localArrayList = null;
    try
    {
      Object localObject3 = this.a.d.iterator();
      int m;
      do
      {
        localObject1 = localArrayList;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject3).next();
        m = ((HiBoomInfo.HiBoomInfoStyle)localObject1).f;
      } while (m != paramInt);
      if (localObject1 == null) {
        return false;
      }
      localArrayList = new ArrayList();
      if (b(((HiBoomInfo.HiBoomInfoStyle)localObject1).c))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.l.a());
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("images/");
        ((StringBuilder)localObject3).append(((HiBoomInfo.HiBoomInfoStyle)localObject1).c);
        localArrayList.add(((StringBuilder)localObject3).toString());
      }
      if (b(((HiBoomInfo.HiBoomInfoStyle)localObject1).d))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.l.a());
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("images/");
        ((StringBuilder)localObject3).append(((HiBoomInfo.HiBoomInfoStyle)localObject1).d);
        localArrayList.add(((StringBuilder)localObject3).toString());
      }
      localObject3 = ((HiBoomInfo.HiBoomInfoStyle)localObject1).g.iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HiBoomInfo.HiBoomInfoStyleImage)((Iterator)localObject3).next();
        if (b(((HiBoomInfo.HiBoomInfoStyleImage)localObject4).a))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.l.a());
          localStringBuilder.append(this.c);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("images/");
          localStringBuilder.append(((HiBoomInfo.HiBoomInfoStyleImage)localObject4).a);
          localArrayList.add(localStringBuilder.toString());
        }
      }
      Object localObject1 = ((HiBoomInfo.HiBoomInfoStyle)localObject1).h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (HiBoomInfo.HiBoomInfoStyleWord)((Iterator)localObject1).next();
        if (b(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.l.a());
          ((StringBuilder)localObject4).append(this.c);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d);
          localArrayList.add(((StringBuilder)localObject4).toString());
        }
        if (b(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).c))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.l.a());
          ((StringBuilder)localObject4).append(this.c);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).c);
          localArrayList.add(((StringBuilder)localObject4).toString());
        }
        if (b(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).i))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.l.a());
          ((StringBuilder)localObject4).append(this.c);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).i);
          localArrayList.add(((StringBuilder)localObject4).toString());
        }
      }
      paramInt = localArrayList.size();
      if (paramInt == 0) {
        return true;
      }
      a(localArrayList);
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    this.i.set(true);
    c();
  }
  
  protected boolean b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.l.a());
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(".hb");
    localObject = new File(((StringBuilder)localObject).toString());
    String str = FileUtils.readFileToStringEx((File)localObject, -1);
    if (!TextUtils.isEmpty(str))
    {
      this.a = HiBoomInfo.a(str);
      if (this.d == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.l.a());
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(".fz");
        localObject = ((StringBuilder)localObject).toString();
        if (FileUtils.fileExists((String)localObject))
        {
          try
          {
            this.d = Typeface.createFromFile((String)localObject);
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("file error:");
            localStringBuilder2.append((String)localObject);
            QLog.e("HiBoomFont.FontDrawer", 2, localStringBuilder2.toString(), localException);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.l.a());
            ((StringBuilder)localObject).append(this.c);
            FileUtils.deleteDirectory(((StringBuilder)localObject).toString());
            return true;
          }
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("file is not exist, path=");
          localStringBuilder1.append((String)localObject);
          QLog.e("HiBoomFont.FontDrawer", 2, localStringBuilder1.toString());
        }
      }
      this.g.set(true);
      return false;
    }
    if ((!((File)localObject).exists()) && (paramBoolean))
    {
      this.i.set(false);
      this.l.a(this.c);
    }
    return false;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!HiBoomFont.a().c.get()) {
      HiBoomFont.a().c();
    }
    if (HiBoomFont.a().d.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo HYEngine Ready");
      }
      if (this.b == 1) {
        localObject = ".hy";
      } else {
        localObject = ".hy3";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l.a());
      localStringBuilder.append(this.c);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.c);
      localStringBuilder.append((String)localObject);
      Object localObject = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initHiboom: path= ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" fontId=");
        localStringBuilder.append(this.c);
        QLog.d("HiBoomFont.FontDrawer", 2, localStringBuilder.toString());
      }
      boolean bool1 = new File((String)localObject).exists();
      boolean bool3 = false;
      if (bool1)
      {
        bool1 = HiBoomFont.a().a.native_isFontLoaded(this.c);
        boolean bool2 = HiBoomFont.a().b.native_isFontLoaded(this.c);
        paramBoolean = bool1;
        if (!bool1) {
          paramBoolean = HiBoomFont.a().a.native_loadFont((String)localObject, this.c, false);
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = HiBoomFont.a().b.native_loadFont((String)localObject, this.c, false);
        }
        localObject = this.g;
        bool2 = bool3;
        if (paramBoolean)
        {
          bool2 = bool3;
          if (bool1) {
            bool2 = true;
          }
        }
        ((AtomicBoolean)localObject).set(bool2);
        return;
      }
      if (paramBoolean)
      {
        this.i.set(false);
        this.l.a(this.c);
      }
    }
  }
  
  public int d(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.l.a());
    ((StringBuilder)localObject).append(this.c);
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length > 0))
      {
        int m = 0;
        while (m < localObject.length)
        {
          if (localObject[m].endsWith(".hy")) {
            return 1;
          }
          if (localObject[m].endsWith(".fz")) {
            return 2;
          }
          if (localObject[m].endsWith(".hy3")) {
            return 3;
          }
          if (localObject[m].endsWith(".fz4")) {
            return 4;
          }
          m += 1;
        }
      }
    }
    if (paramBoolean)
    {
      this.i.set(false);
      this.l.a(this.c);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer
 * JD-Core Version:    0.7.0.1
 */