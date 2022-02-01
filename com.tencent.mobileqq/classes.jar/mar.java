import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;

public class mar
  extends lrx
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Bitmap c;
  private int k;
  private int l;
  private int m;
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceTexture", 2, "WL_DEBUG onUpdate start");
    }
    int j;
    int i1;
    int i;
    int n;
    if ((this.l > 0) && (this.m > 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      if (this.l * this.j > this.m * this.i)
      {
        j = this.i * this.m / this.j;
        i1 = (this.l - j) / 2;
        i = this.m;
        n = 0;
        if ((this.c == null) || (this.c.isRecycled()) || (j != this.c.getWidth()) || (i != this.c.getHeight())) {
          break label278;
        }
        Rect localRect = new Rect(i1, n, i1 + j, n + i);
        RectF localRectF = new RectF(0.0F, 0.0F, j, i);
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.c);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRectF, null);
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
        label206:
        f();
        a(this.c.getWidth(), this.c.getHeight());
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceTexture", 2, "WL_DEBUG onUpdate end");
      }
      return;
      i = this.j * this.l / this.i;
      n = (this.m - i) / 2;
      j = this.l;
      i1 = 0;
      break;
      label278:
      if ((this.c != null) && (!this.c.isRecycled()) && (this.c != this.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        this.c.recycle();
        this.c = null;
      }
      this.c = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, i1, n, j, i);
      this.b = 0;
      break label206;
      if ((this.c != null) && (!this.c.isRecycled()))
      {
        this.c.recycle();
        this.c = null;
      }
    }
  }
  
  protected Bitmap a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (this.i != paramInt)
    {
      super.a(paramInt);
      e();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceTexture", 2, "WL_DEBUG setTextureId start");
    }
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    if ((this.l > 0) && (this.m > 0)) {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() == this.l) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() == this.m))
      {
        RendererUtils.saveTextureToBitmap(this.k, this.l, this.m, this.jdField_a_of_type_AndroidGraphicsBitmap);
        e();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceTexture", 2, "WL_DEBUG setTextureId end");
      }
      return;
      Bitmap localBitmap = RendererUtils.saveTexture(this.k, this.l, this.m);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != localBitmap)
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        e();
        continue;
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap) {}
  
  public void b(int paramInt)
  {
    if (this.j != paramInt)
    {
      super.b(paramInt);
      e();
    }
  }
  
  public boolean f()
  {
    return (this.k != 0) && (this.l != 0) && (this.m != 0) && (this.c != null) && (!this.c.isRecycled());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mar
 * JD-Core Version:    0.7.0.1
 */