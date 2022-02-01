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
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class HiBoomFontDrawer
{
  public int a;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  public HiBoomFont.HiBoomFontDownloader a;
  HiBoomInfo jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo;
  ArrayList<WeakReference<HiBoomTextView>> jdField_a_of_type_JavaUtilArrayList;
  Vector<String> jdField_a_of_type_JavaUtilVector = new Vector();
  public AtomicBoolean a;
  public int b;
  public AtomicBoolean b;
  public int c;
  public AtomicBoolean c;
  
  HiBoomFontDrawer(int paramInt, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = paramHiBoomFontDownloader;
    a(true);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 56	java/io/BufferedInputStream
    //   7: dup
    //   8: new 58	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokestatic 70	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 73	java/io/BufferedInputStream:close	()V
    //   33: aload_2
    //   34: areturn
    //   35: astore_1
    //   36: ldc 75
    //   38: iconst_1
    //   39: ldc 77
    //   41: aload_1
    //   42: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   66: ldc 75
    //   68: iconst_1
    //   69: ldc 77
    //   71: aload_2
    //   72: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_1
    //   76: ifnull +35 -> 111
    //   79: aload_3
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 73	java/io/BufferedInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 75
    //   94: iconst_1
    //   95: ldc 77
    //   97: aload_2
    //   98: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_1
    //   102: ifnull +9 -> 111
    //   105: aload_3
    //   106: astore_0
    //   107: aload_1
    //   108: invokevirtual 73	java/io/BufferedInputStream:close	()V
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
    //   123: invokevirtual 73	java/io/BufferedInputStream:close	()V
    //   126: goto +13 -> 139
    //   129: astore_1
    //   130: ldc 75
    //   132: iconst_1
    //   133: ldc 77
    //   135: aload_1
    //   136: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt1;
    } else {
      i = paramInt2;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    float f1 = i;
    localPaint.setTextSize(f1);
    localPaint.setColor(-16777216);
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsTypeface;
    if (localObject1 != null) {
      localPaint.setTypeface((Typeface)localObject1);
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localObject1 = paramHiBoomInfoStyleWord.jdField_b_of_type_ArrayOfInt;
    label409:
    label631:
    Object localObject2;
    if ((localObject1 != null) && (localObject1[3] != 0))
    {
      paramHiBoomInfoStyle = new StringBuilder();
      paramHiBoomInfoStyle.append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
      paramHiBoomInfoStyle.append(this.jdField_b_of_type_Int);
      paramHiBoomInfoStyle.append(File.separator);
      paramHiBoomInfoStyle.append("images/");
      paramHiBoomInfoStyle.append(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString);
      paramHiBoomInfoStyle = paramHiBoomInfoStyle.toString();
      paramHiBoomInfoStyle = (Bitmap)GlobalImageCache.a.get(paramHiBoomInfoStyle);
      if (paramHiBoomInfoStyle != null)
      {
        int k = paramHiBoomInfoStyle.getWidth();
        int j = paramHiBoomInfoStyle.getHeight();
        if (localObject1[3] == -1)
        {
          double d1 = Math.random();
          double d2 = k - paramInt1;
          Double.isNaN(d2);
          k = (int)(d2 * d1);
          d1 = Math.random();
          d2 = j - paramInt2;
          Double.isNaN(d2);
          paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, k, (int)(d1 * d2), paramInt1, paramInt2);
        }
        else
        {
          paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, localObject1[0], localObject1[1], localObject1[2], localObject1[3]);
        }
        if (paramHiBoomInfoStyle != null)
        {
          if ((paramHiBoomInfoStyle.getWidth() == i) && (paramHiBoomInfoStyle.getHeight() == i)) {
            break label409;
          }
          localObject1 = new Matrix();
          ((Matrix)localObject1).setScale(f1 / paramHiBoomInfoStyle.getWidth(), f1 / paramHiBoomInfoStyle.getHeight());
          paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, 0, 0, paramHiBoomInfoStyle.getWidth(), paramHiBoomInfoStyle.getHeight(), (Matrix)localObject1, false);
          localPaint.setShader(new BitmapShader(paramHiBoomInfoStyle, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
          localObject1 = "images/";
        }
        else
        {
          localObject1 = "images/";
        }
      }
      else
      {
        break label860;
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(paramHiBoomInfoStyle.d)) {
          if ((paramHiBoomInfoStyle.d.startsWith("#")) && (paramHiBoomInfoStyle.d.length() == 9))
          {
            localPaint.setColor(Color.parseColor(paramHiBoomInfoStyle.d));
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
            ((StringBuilder)localObject1).append(File.separator);
            ((StringBuilder)localObject1).append("images/");
            ((StringBuilder)localObject1).append(paramHiBoomInfoStyle.d);
            paramHiBoomInfoStyle = ((StringBuilder)localObject1).toString();
            break label700;
          }
        }
      }
      else
      {
        if ((!paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString.startsWith("#")) || (paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString.length() != 9)) {
          break label631;
        }
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString));
      }
      paramHiBoomInfoStyle = null;
      break label700;
      paramHiBoomInfoStyle = new StringBuilder();
      paramHiBoomInfoStyle.append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
      paramHiBoomInfoStyle.append(this.jdField_b_of_type_Int);
      paramHiBoomInfoStyle.append(File.separator);
      paramHiBoomInfoStyle.append("images/");
      paramHiBoomInfoStyle.append(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString);
      paramHiBoomInfoStyle = paramHiBoomInfoStyle.toString();
      label700:
      localObject2 = "images/";
      if (TextUtils.isEmpty(paramHiBoomInfoStyle)) {
        break label860;
      }
      localPaint.setColor(-16777216);
      Bitmap localBitmap1 = (Bitmap)GlobalImageCache.a.get(paramHiBoomInfoStyle);
      localObject1 = localObject2;
      paramHiBoomInfoStyle = localBitmap1;
      if (localBitmap1 != null)
      {
        if ((localBitmap1.getWidth() == i) && (localBitmap1.getHeight() == i))
        {
          paramHiBoomInfoStyle = localBitmap1;
        }
        else
        {
          paramHiBoomInfoStyle = new Matrix();
          paramHiBoomInfoStyle.setScale(f1 / localBitmap1.getWidth(), f1 / localBitmap1.getHeight());
          paramHiBoomInfoStyle = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), paramHiBoomInfoStyle, false);
        }
        localPaint.setShader(new BitmapShader(paramHiBoomInfoStyle, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
        localObject1 = localObject2;
        break label867;
      }
    }
    break label867;
    label860:
    localObject1 = "images/";
    paramHiBoomInfoStyle = null;
    label867:
    localCanvas.drawColor(Color.parseColor(paramHiBoomInfoStyleWord.jdField_c_of_type_JavaLangString));
    float f2 = f1 / 2.0F;
    localCanvas.drawText(paramString, 0.0F, (int)(f2 - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
    localCanvas.save();
    if (paramHiBoomInfoStyle != null) {
      paramHiBoomInfoStyle.recycle();
    }
    if ((paramHiBoomInfoStyleWord.jdField_c_of_type_Int > 0) && (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.d)))
    {
      paramHiBoomInfoStyle = null;
      localPaint.setShader(null);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeJoin(Paint.Join.ROUND);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localPaint.setStrokeWidth(paramHiBoomInfoStyleWord.jdField_c_of_type_Int * paramFloat);
      if ((paramHiBoomInfoStyleWord.d.startsWith("#")) && (paramHiBoomInfoStyleWord.d.length() == 9))
      {
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.d));
        localObject1 = null;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramHiBoomInfoStyleWord.d);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localPaint.setColor(-16777216);
        paramHiBoomInfoStyle = (Bitmap)GlobalImageCache.a.get(localObject1);
        if (paramHiBoomInfoStyle != null)
        {
          if ((paramHiBoomInfoStyle.getWidth() == i) && (paramHiBoomInfoStyle.getHeight() == i)) {
            break label1223;
          }
          localObject1 = new Matrix();
          ((Matrix)localObject1).setScale(f1 / paramHiBoomInfoStyle.getWidth(), f1 / paramHiBoomInfoStyle.getHeight());
          paramHiBoomInfoStyle = Bitmap.createBitmap(paramHiBoomInfoStyle, 0, 0, paramHiBoomInfoStyle.getWidth(), paramHiBoomInfoStyle.getHeight(), (Matrix)localObject1, false);
          label1223:
          localPaint.setShader(new BitmapShader(paramHiBoomInfoStyle, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
        }
      }
      localCanvas.drawText(paramString, 0.0F, (int)(f2 - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
      localCanvas.save();
      if (paramHiBoomInfoStyle != null) {
        paramHiBoomInfoStyle.recycle();
      }
    }
    paramString = new Matrix();
    if ((localBitmap2.getWidth() != paramInt1) || (localBitmap2.getHeight() != paramInt2)) {
      paramString.postScale(paramInt1 / localBitmap2.getWidth(), paramInt2 / localBitmap2.getHeight());
    }
    paramString.postTranslate(paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[0] * paramFloat - paramInt1 / 2, paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[1] * paramFloat - paramInt2 / 2);
    paramString.postRotate(paramHiBoomInfoStyleWord.jdField_b_of_type_Int, paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[0] * paramFloat, paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[1] * paramFloat);
    paramCanvas.drawBitmap(localBitmap2, paramString, localPaint);
    paramCanvas.save();
    localBitmap2.recycle();
  }
  
  private void a(List<String> paramList)
  {
    ThreadManager.post(new HiBoomFontDrawer.2(this, paramList), 8, null, true);
  }
  
  private boolean a(String paramString)
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
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("images/");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          if (paramString.equals(this.jdField_a_of_type_JavaUtilVector.get(i))) {
            return false;
          }
          i += 1;
        }
        bool1 = bool2;
        if (GlobalImageCache.a.get(paramString) == null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new HiBoomFontDrawer.3(this));
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
    float f5 = paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[0] * paramFloat;
    float f1 = paramHiBoomInfoStyleWord.jdField_c_of_type_ArrayOfInt[1] * paramFloat;
    localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.jdField_c_of_type_JavaLangString));
    float f2 = paramInt1 / 2;
    float f3 = f5 - f2;
    paramCanvas.drawRect(f3, f1 - f2, f5 + f2, f1 + f2, localPaint);
    paramCanvas.save();
    Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    if (TextUtils.isEmpty(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString))
    {
      if ((!TextUtils.isEmpty(paramHiBoomInfoStyle.d)) && (paramHiBoomInfoStyle.d.startsWith("#")) && (paramHiBoomInfoStyle.d.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyle.d));
      }
    }
    else if ((paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString.startsWith("#")) && (paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString.length() == 9)) {
      localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.jdField_b_of_type_JavaLangString));
    }
    f4 /= 2.0F;
    paramCanvas.drawText(paramString, f3, f4 - (localPaint.descent() + localPaint.ascent()) / 2.0F - f2 + f1, localPaint);
    paramCanvas.save();
    if ((paramHiBoomInfoStyleWord.jdField_c_of_type_Int > 0) && (!TextUtils.isEmpty(paramHiBoomInfoStyleWord.d)))
    {
      localPaint.setShader(null);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeJoin(Paint.Join.ROUND);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localPaint.setStrokeWidth(paramHiBoomInfoStyleWord.jdField_c_of_type_Int * paramFloat);
      if ((paramHiBoomInfoStyleWord.d.startsWith("#")) && (paramHiBoomInfoStyleWord.d.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramHiBoomInfoStyleWord.d));
      }
      paramCanvas.drawText(paramString, f3, f1 + (f4 - (localPaint.descent() + localPaint.ascent()) / 2.0F - f2), localPaint);
      paramCanvas.save();
    }
  }
  
  public int a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i].endsWith(".hy")) {
            return 1;
          }
          if (localObject[i].endsWith(".fz")) {
            return 2;
          }
          if (localObject[i].endsWith(".hy3")) {
            return 3;
          }
          if (localObject[i].endsWith(".fz4")) {
            return 4;
          }
          i += 1;
        }
      }
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(this.jdField_b_of_type_Int);
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    b();
  }
  
  public void a(HiBoomTextView paramHiBoomTextView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramHiBoomTextView));
  }
  
  void a(String paramString, int paramInt, Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo != null)
      {
        int i = paramString.length();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject2).next();
          if (((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_a_of_type_Int == i) {
            break label72;
          }
        }
        Object localObject1 = null;
        label72:
        if (localObject1 != null)
        {
          int j;
          if (localObject1.jdField_a_of_type_ArrayOfInt[0] >= localObject1.jdField_a_of_type_ArrayOfInt[1])
          {
            i = localObject1.jdField_a_of_type_ArrayOfInt[1] * paramInt / localObject1.jdField_a_of_type_ArrayOfInt[0];
          }
          else
          {
            j = localObject1.jdField_a_of_type_ArrayOfInt[0] * paramInt / localObject1.jdField_a_of_type_ArrayOfInt[1];
            i = paramInt;
            paramInt = j;
          }
          if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
            this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
            this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
            this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
          }
          boolean bool = TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString);
          localObject2 = "#";
          Object localObject3;
          Object localObject4;
          if (!bool) {
            if ((((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString.startsWith("#")) && (((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString.length() == 9))
            {
              paramCanvas.drawColor(Color.parseColor(((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString));
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
              ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
              ((StringBuilder)localObject3).append(File.separator);
              ((StringBuilder)localObject3).append("images/");
              ((StringBuilder)localObject3).append(((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString);
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject3 = (Bitmap)GlobalImageCache.a.get(localObject3);
              if (localObject3 != null)
              {
                localObject4 = new Matrix();
                if ((((Bitmap)localObject3).getWidth() != paramInt) || (((Bitmap)localObject3).getHeight() != i)) {
                  ((Matrix)localObject4).setScale(paramInt / ((Bitmap)localObject3).getWidth(), i / ((Bitmap)localObject3).getHeight());
                }
                paramCanvas.drawBitmap((Bitmap)localObject3, (Matrix)localObject4, this.jdField_a_of_type_AndroidGraphicsPaint);
              }
            }
          }
          float f1 = paramInt / localObject1.jdField_a_of_type_ArrayOfInt[0];
          paramInt = 0;
          while (paramInt < ((HiBoomInfo.HiBoomInfoStyle)localObject1).b.size())
          {
            localObject3 = (HiBoomInfo.HiBoomInfoStyleWord)((HiBoomInfo.HiBoomInfoStyle)localObject1).b.get(paramInt);
            i = (int)(localObject3.jdField_a_of_type_ArrayOfInt[0] * f1);
            j = (int)(localObject3.jdField_a_of_type_ArrayOfInt[1] * f1);
            if ((localObject3.jdField_a_of_type_ArrayOfInt[0] == localObject3.jdField_a_of_type_ArrayOfInt[1]) && (((TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyle)localObject1).d)) && (((HiBoomInfo.HiBoomInfoStyle)localObject1).d.startsWith((String)localObject2)) && (((HiBoomInfo.HiBoomInfoStyle)localObject1).d.length() == 9)) || ((!TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString)) && (((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString.startsWith((String)localObject2)) && (((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString.length() == 9) && ((((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_c_of_type_Int <= 0) || ((((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_c_of_type_Int > 0) && (!TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d)) && (((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d.startsWith((String)localObject2)) && (((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d.length() == 9))) && (((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_Int == 0))))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(paramString.charAt(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_a_of_type_Int));
              ((StringBuilder)localObject4).append("");
              b(paramCanvas, ((StringBuilder)localObject4).toString(), i, j, (HiBoomInfo.HiBoomInfoStyle)localObject1, (HiBoomInfo.HiBoomInfoStyleWord)localObject3, f1);
            }
            else
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(paramString.charAt(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_a_of_type_Int));
              ((StringBuilder)localObject4).append("");
              a(paramCanvas, ((StringBuilder)localObject4).toString(), i, j, (HiBoomInfo.HiBoomInfoStyle)localObject1, (HiBoomInfo.HiBoomInfoStyleWord)localObject3, f1);
            }
            paramInt += 1;
          }
          if (((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_a_of_type_JavaUtilList != null)
          {
            paramString = ((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_a_of_type_JavaUtilList.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (HiBoomInfo.HiBoomInfoStyleImage)paramString.next();
              if (!TextUtils.isEmpty(((HiBoomInfo.HiBoomInfoStyleImage)localObject1).jdField_a_of_type_JavaLangString))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
                ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
                ((StringBuilder)localObject2).append(File.separator);
                ((StringBuilder)localObject2).append("images/");
                ((StringBuilder)localObject2).append(((HiBoomInfo.HiBoomInfoStyleImage)localObject1).jdField_a_of_type_JavaLangString);
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject2 = (Bitmap)GlobalImageCache.a.get(localObject2);
                localObject3 = new Matrix();
                float f2 = localObject1.jdField_a_of_type_ArrayOfInt[0] * f1;
                float f3 = localObject1.jdField_a_of_type_ArrayOfInt[1] * f1;
                if (localObject2 != null)
                {
                  if ((((Bitmap)localObject2).getWidth() != f2) || (((Bitmap)localObject2).getHeight() != f3)) {
                    ((Matrix)localObject3).postScale(f2 / ((Bitmap)localObject2).getWidth(), f3 / ((Bitmap)localObject2).getHeight());
                  }
                  ((Matrix)localObject3).postTranslate(localObject1.jdField_b_of_type_ArrayOfInt[0] * f1 - f2 / 2.0F, localObject1.jdField_b_of_type_ArrayOfInt[1] * f1 - f3 / 2.0F);
                  ((Matrix)localObject3).postRotate(((HiBoomInfo.HiBoomInfoStyleImage)localObject1).jdField_a_of_type_Int, localObject1.jdField_b_of_type_ArrayOfInt[0] * f1, localObject1.jdField_b_of_type_ArrayOfInt[1] * f1);
                  paramCanvas.drawBitmap((Bitmap)localObject2, (Matrix)localObject3, this.jdField_a_of_type_AndroidGraphicsPaint);
                  paramCanvas.save();
                }
              }
            }
          }
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
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.getFileThreadHandler().post(new HiBoomFontDrawer.1(this, paramBoolean));
  }
  
  boolean a(int paramInt)
  {
    ArrayList localArrayList = null;
    try
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.jdField_a_of_type_JavaUtilList.iterator();
      int i;
      do
      {
        localObject1 = localArrayList;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject3).next();
        i = ((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_a_of_type_Int;
      } while (i != paramInt);
      if (localObject1 == null) {
        return false;
      }
      localArrayList = new ArrayList();
      if (a(((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("images/");
        ((StringBuilder)localObject3).append(((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_c_of_type_JavaLangString);
        localArrayList.add(((StringBuilder)localObject3).toString());
      }
      if (a(((HiBoomInfo.HiBoomInfoStyle)localObject1).d))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("images/");
        ((StringBuilder)localObject3).append(((HiBoomInfo.HiBoomInfoStyle)localObject1).d);
        localArrayList.add(((StringBuilder)localObject3).toString());
      }
      localObject3 = ((HiBoomInfo.HiBoomInfoStyle)localObject1).jdField_a_of_type_JavaUtilList.iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HiBoomInfo.HiBoomInfoStyleImage)((Iterator)localObject3).next();
        if (a(((HiBoomInfo.HiBoomInfoStyleImage)localObject4).jdField_a_of_type_JavaLangString))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          localStringBuilder.append(this.jdField_b_of_type_Int);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("images/");
          localStringBuilder.append(((HiBoomInfo.HiBoomInfoStyleImage)localObject4).jdField_a_of_type_JavaLangString);
          localArrayList.add(localStringBuilder.toString());
        }
      }
      Object localObject1 = ((HiBoomInfo.HiBoomInfoStyle)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (HiBoomInfo.HiBoomInfoStyleWord)((Iterator)localObject1).next();
        if (a(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_c_of_type_JavaLangString))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_c_of_type_JavaLangString);
          localArrayList.add(((StringBuilder)localObject4).toString());
        }
        if (a(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).jdField_b_of_type_JavaLangString);
          localArrayList.add(((StringBuilder)localObject4).toString());
        }
        if (a(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append("images/");
          ((StringBuilder)localObject4).append(((HiBoomInfo.HiBoomInfoStyleWord)localObject3).d);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer
 * JD-Core Version:    0.7.0.1
 */