package cooperation.qzone.panorama.piece;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import bbll;
import bhhi;
import bhhp;
import bhht;
import bhhu;
import bhhw;
import bhhy;
import com.tencent.mobileqq.app.MemoryManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.IOException;

public class PanoramaPieceManager
  implements bhhi
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapRegionDecoder jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder;
  private bhhp jdField_a_of_type_Bhhp;
  private bhht jdField_a_of_type_Bhht;
  private bhhw jdField_a_of_type_Bhhw;
  private volatile PanoramaPieceManager.ProcessState jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[8];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  private int d;
  private volatile int e;
  private volatile int f;
  private int g = -1;
  private int h = -1;
  private int i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  
  public PanoramaPieceManager(bhhw parambhhw, String paramString)
  {
    this.jdField_a_of_type_Bhhw = parambhhw;
    this.jdField_a_of_type_Bhhp = parambhhw.a();
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramString, false);
      e();
      return;
    }
    catch (IOException parambhhw)
    {
      for (;;)
      {
        parambhhw.printStackTrace();
      }
    }
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    Bitmap localBitmap2 = b(paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
      localBitmap1 = a(localBitmap2, 90.0F);
    }
    if (localBitmap1 == null) {
      return null;
    }
    localBitmap1 = a(localBitmap1);
    QZLog.i("PanoramaPieceManager", 4, "pieceOperation:current time =  " + (System.currentTimeMillis() - l1));
    return localBitmap1;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
    {
      localBitmap = null;
      return localBitmap;
    }
    if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {}
    for (int n = this.jdField_b_of_type_Int;; n = this.jdField_a_of_type_Int)
    {
      localBitmap = paramBitmap;
      if (n <= this.d) {
        break;
      }
      this.jdField_a_of_type_Float = (this.d / n);
      return b(paramBitmap, this.jdField_a_of_type_Float);
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).postRotate(paramFloat);
    try
    {
      localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
      paramBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QZLog.e("PanoramaPieceManager", "rotateBitmap OutOfMemoryError");
        Object localObject2 = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhht == null) {
      return;
    }
    this.jdField_a_of_type_Bhht.remove(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bhht == null) || (this.jdField_a_of_type_Bhht.size() < 8) || (!this.jdField_a_of_type_Bhht.a())) {
      return;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i4 = arrayOfInt.length;
    int i2 = 0;
    label44:
    int i5;
    int n;
    if (i2 < i4)
    {
      i5 = arrayOfInt[i2];
      if (paramInt1 >= paramInt2) {
        break label104;
      }
      n = paramInt1;
      label65:
      if (n >= paramInt2) {
        break label169;
      }
      if (i5 != n) {
        break label97;
      }
      n = 1;
    }
    for (;;)
    {
      if (n == 0) {
        a(i5);
      }
      i2 += 1;
      break label44;
      break;
      label97:
      n += 1;
      break label65;
      label104:
      n = paramInt1;
      label106:
      if (n < this.i) {
        if (i5 != n) {}
      }
      for (int i1 = 1;; i1 = 0)
      {
        int i3 = 0;
        for (;;)
        {
          n = i1;
          if (i3 >= paramInt2) {
            break;
          }
          if (i5 == i3)
          {
            n = 1;
            break;
            n += 1;
            break label106;
          }
          i3 += 1;
        }
      }
      label169:
      n = 0;
    }
  }
  
  private void a(bhht parambhht, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, boolean paramBoolean)
  {
    QZLog.i("PanoramaPieceManager", 4, new Object[] { "index = ", Integer.valueOf(paramInt1), " x = ", Integer.valueOf(paramInt2), " perWidth = ", Integer.valueOf(paramInt3), " (orgHeight * scaleRate) = ", Float.valueOf(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float) });
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    while (parambhht.get(paramInt1) != null) {
      return;
    }
    try
    {
      bhhu localbhhu = new bhhu();
      localbhhu.a(paramInt1);
      if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
      {
        n = this.jdField_b_of_type_Int;
        localbhhu.a(Bitmap.createBitmap(paramBitmap, paramInt2, 0, paramInt3, (int)(n * this.jdField_a_of_type_Float)));
        parambhht.a(paramInt1, localbhhu, paramBoolean);
        return;
      }
    }
    catch (IllegalArgumentException parambhht)
    {
      for (;;)
      {
        parambhht.printStackTrace();
        QZLog.e("PanoramaPieceManager", "createBitmap IllegalArgumentException");
        return;
        int n = this.jdField_a_of_type_Int;
      }
    }
    catch (OutOfMemoryError parambhht)
    {
      parambhht.printStackTrace();
      QZLog.e("PanoramaPieceManager", "createBitmap OutOfMemoryError");
    }
  }
  
  private Bitmap b(int paramInt1, int paramInt2)
  {
    QZLog.e("PanoramaPieceManager", 4, new Object[] { "startIndex = ", Integer.valueOf(this.e), " endIndex = ", Integer.valueOf(this.f), " tempStart = ", Integer.valueOf(paramInt1), " tempEnd = ", Integer.valueOf(paramInt2) });
    if (this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder == null) {
      return null;
    }
    int i1;
    if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
    {
      n = this.jdField_a_of_type_Int;
      i1 = (int)(n / (this.jdField_b_of_type_Float / 10.0F));
      if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int) {
        break label183;
      }
    }
    Rect localRect;
    label183:
    for (int n = this.jdField_b_of_type_Int;; n = this.jdField_a_of_type_Int)
    {
      localObject = new Rect(paramInt1 * i1, 0, (paramInt1 + 1) * i1, n);
      localRect = new Rect(paramInt2 * i1, 0, i1 * (paramInt2 + 1), n);
      if ((localObject != null) && (localRect != null)) {
        break label191;
      }
      return null;
      n = this.jdField_b_of_type_Int;
      break;
    }
    label191:
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {}
    for (Object localObject = new Rect(((Rect)localObject).top, this.jdField_b_of_type_Int - localRect.right, localRect.bottom, this.jdField_b_of_type_Int - ((Rect)localObject).left);; localObject = new Rect(((Rect)localObject).left, ((Rect)localObject).top, localRect.right, localRect.bottom)) {
      try
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder.decodeRegion((Rect)localObject, null);
        return localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QZLog.e("PanoramaPieceManager", "decodeRegion IllegalArgumentException");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        QZLog.e("PanoramaPieceManager", "decodeRegion OutOfMemoryError");
      }
    }
    return null;
  }
  
  private Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat, paramFloat);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    paramBitmap.recycle();
    return localObject;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bhhp != null) {
      this.i = this.jdField_a_of_type_Bhhp.d();
    }
    this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
    if (this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder.getWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder.getHeight();
      QZLog.i("PanoramaPieceManager", 4, new Object[] { "orgWidth = ", Integer.valueOf(this.jdField_a_of_type_Int), " orgHeight = " + this.jdField_b_of_type_Int });
    }
    this.c = bbll.a();
    this.d = bbll.b();
    this.jdField_a_of_type_Long = (MemoryManager.a() / 8L);
    if (this.jdField_a_of_type_Bhht == null) {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_Long);
    }
    QZLog.i("PanoramaPieceManager", 4, "initManager: maxSize = " + this.jdField_a_of_type_Long);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bhht == null) {}
    for (;;)
    {
      return;
      int n = 0;
      while (n < this.jdField_a_of_type_Bhht.size())
      {
        ((bhhu)this.jdField_a_of_type_Bhht.valueAt(n)).a();
        n += 1;
      }
    }
  }
  
  private void g()
  {
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.j != -1) && (this.k != -1))
    {
      i1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / (this.k + 1 - this.j);
      n = this.j;
      while (n <= this.k)
      {
        a(this.jdField_a_of_type_Bhht, n, (n - this.j) * i1, i1, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Boolean);
        n += 1;
      }
      if (this.j != this.k) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.l != -1) && (this.m != -1))
    {
      i1 = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth() / (this.m + 1 - this.l);
      n = this.l;
      while (n <= this.m)
      {
        a(this.jdField_a_of_type_Bhht, n, (n - this.l) * i1, i1, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Boolean);
        n += 1;
      }
      if (this.l != this.m) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public bhht a()
  {
    return this.jdField_a_of_type_Bhht;
  }
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2 % 360.0F;
    int i2 = 360 / this.i;
    int n;
    int i1;
    if (this.jdField_b_of_type_Float == 360.0F) {
      if (paramFloat1 > 0.0F)
      {
        n = this.i - (int)(paramFloat1 / i2);
        i1 = n;
        if (Math.abs(paramFloat1) % i2 >= i2 / 2)
        {
          i1 = n;
          if (Math.abs(paramFloat1) % i2 < i2) {
            i1 = n + 1;
          }
        }
        if (this.jdField_b_of_type_Float != 360.0F) {
          break label198;
        }
        this.e = ((i1 - 4) % this.i);
        if (this.e < 0) {
          this.e += this.i;
        }
        this.f = ((i1 + 4) % this.i);
        if (this.e == this.i - 8) {
          this.f = this.i;
        }
      }
    }
    label198:
    do
    {
      return;
      n = -(int)(paramFloat1 / i2);
      break;
      n = (int)(this.jdField_b_of_type_Float / 10.0F) - (int)(paramFloat1 / i2);
      break;
      this.e = (i1 - 4);
      this.f = (i1 + 4);
      if (this.e < 0) {
        this.e = 0;
      }
    } while (this.f <= this.jdField_b_of_type_Float / 10.0F);
    this.f = ((int)(this.jdField_b_of_type_Float / 10.0F));
  }
  
  public void b()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_AndroidGraphicsBitmapRegionDecoder == null) {}
    int i1;
    int i3;
    do
    {
      do
      {
        return;
        i1 = this.g;
        i3 = this.h;
      } while ((i1 == -1) || (i3 == -1) || (i1 == i3));
      i2 = this.jdField_a_of_type_ArrayOfInt[0];
      int i4 = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
      this.j = -1;
      this.k = -1;
      if (i1 >= i3) {
        break;
      }
      n = 0;
      while (i1 < i3)
      {
        if (this.jdField_a_of_type_Bhht.get(i1) == null)
        {
          if (this.j == -1) {
            this.j = i1;
          }
          this.k = i1;
        }
        this.jdField_a_of_type_ArrayOfInt[n] = i1;
        i1 += 1;
        n += 1;
      }
      if (i2 >= this.j)
      {
        bool1 = bool2;
        if (i4 >= this.k) {}
      }
      else
      {
        bool1 = true;
      }
      this.jdField_a_of_type_Boolean = bool1;
    } while ((this.j == -1) || (this.k == -1));
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.j, this.k);
    return;
    int i2 = i1;
    int n = 0;
    while (i2 < this.i)
    {
      if (this.jdField_a_of_type_Bhht.get(i2) == null)
      {
        if (this.j == -1) {
          this.j = i2;
        }
        this.k = i2;
      }
      this.jdField_a_of_type_ArrayOfInt[n] = i2;
      i2 += 1;
      n += 1;
    }
    if ((this.j != -1) && (this.k != -1)) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.j, this.k);
    }
    this.l = -1;
    this.m = -1;
    i2 = 0;
    while (i2 < i3)
    {
      if (this.jdField_a_of_type_Bhht.get(i2) == null)
      {
        if (this.l == -1) {
          this.l = i2;
        }
        this.m = i2;
      }
      this.jdField_a_of_type_ArrayOfInt[n] = i2;
      i2 += 1;
      n += 1;
    }
    if ((this.l != -1) && (this.m != -1)) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.l, this.m);
    }
    if (this.i - i1 > 4) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      bool1 = false;
    }
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void c()
  {
    this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.ONRESUME;
  }
  
  public void d()
  {
    switch (bhhs.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState.ordinal()])
    {
    case 4: 
    default: 
      return;
    case 1: 
      this.g = this.e;
      this.h = this.f;
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.CHECK_SIZE;
      return;
    case 2: 
      if ((this.g != -1) && (this.h != -1) && (this.g != this.h))
      {
        a(this.g, this.h);
        this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.CLIPPING;
        return;
      }
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.END;
      return;
    case 3: 
      if ((this.g != -1) && (this.h != -1) && (this.g != this.h))
      {
        this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.WAITING;
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PanoramaPieceManager.1(this));
        return;
      }
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.END;
      return;
    case 5: 
      g();
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.NOTIFY;
      return;
    case 6: 
      f();
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.END;
      return;
    case 7: 
      if (this.jdField_a_of_type_Bhht != null)
      {
        bhhy.a(this.jdField_a_of_type_Bhht);
        this.jdField_a_of_type_Bhht.clear();
      }
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.END;
      return;
    }
    this.g = -1;
    this.h = -1;
    this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager$ProcessState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PanoramaPieceManager
 * JD-Core Version:    0.7.0.1
 */