import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class lue
  extends lty
{
  private static int k;
  boolean a;
  protected Bitmap b;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  protected lue()
  {
    super(null, 0);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap b()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        int i = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        int j = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        if (this.e == -1) {
          a(i, j);
        }
      }
    }
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  private void c(lsv paramlsv)
  {
    Bitmap localBitmap = b();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int m = e();
        int n = f();
        if (this.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ArrayOfInt = new int[1];
        }
        this.jdField_a_of_type_ArrayOfInt[0] = paramlsv.a().a();
        paramlsv.a(this);
        if ((i == m) && (j == n)) {
          paramlsv.a(this, localBitmap);
        }
        for (;;)
        {
          e();
          a(paramlsv);
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Boolean = true;
          return;
          i = GLUtils.getInternalFormat(localBitmap);
          j = GLUtils.getType(localBitmap);
          paramlsv.a(this, i, j);
          paramlsv.a(this, 0, 0, localBitmap, i, j);
        }
        this.jdField_b_of_type_Int = -1;
      }
      finally
      {
        e();
      }
    }
    throw new RuntimeException("Texture load fail, no bitmap");
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public static boolean e()
  {
    return k > 100;
  }
  
  public static void g()
  {
    k = 0;
  }
  
  protected abstract Bitmap a();
  
  public void a()
  {
    super.a();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      e();
    }
  }
  
  protected abstract void a(Bitmap paramBitmap);
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(lsv paramlsv)
  {
    b(paramlsv);
    return true;
  }
  
  public ltw[] a(lsv paramlsv)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    return super.a(paramlsv);
  }
  
  public void b(lsv paramlsv)
  {
    if (!c()) {
      if (this.d)
      {
        int i = k + 1;
        k = i;
        if (i <= 100) {}
      }
    }
    do
    {
      for (;;)
      {
        return;
        c(paramlsv);
        return;
        if (!this.jdField_b_of_type_Boolean)
        {
          Bitmap localBitmap = b();
          if (localBitmap != null) {
            try
            {
              if (!localBitmap.isRecycled())
              {
                paramlsv.a(this, 0, 0, localBitmap, GLUtils.getInternalFormat(localBitmap), GLUtils.getType(localBitmap));
                e();
                this.jdField_b_of_type_Boolean = true;
                return;
              }
            }
            catch (IllegalArgumentException paramlsv) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("UploadedTexture", 2, "WL_DEBUG updateContent e = " + paramlsv);
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    if (this.e == -1) {
      b();
    }
    return this.e;
  }
  
  public int d()
  {
    if (this.e == -1) {
      b();
    }
    return this.f;
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      e();
    }
    this.jdField_b_of_type_Boolean = false;
    this.e = -1;
    this.f = -1;
  }
  
  public int g()
  {
    return 3553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lue
 * JD-Core Version:    0.7.0.1
 */