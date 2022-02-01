import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class rku
  extends AsyncTask<Void, Void, Bitmap>
{
  int jdField_a_of_type_Int = -2147483648;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  private rkw jdField_a_of_type_Rkw;
  private rkx jdField_a_of_type_Rkx;
  private rky jdField_a_of_type_Rky;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  
  public rku(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, rkw paramrkw)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_Rkw = paramrkw;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Rkw = null;
    this.jdField_a_of_type_Rkx = null;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null))
    {
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if (!localBitmap.isRecycled()) {
        return localBitmap;
      }
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    return null;
  }
  
  protected Bitmap a(Void... arg1)
  {
    ??? = a();
    if (??? != null) {
      return ???;
    }
    this.f += 1;
    Bitmap[] arrayOfBitmap = new Bitmap[1];
    arrayOfBitmap[0] = null;
    this.jdField_a_of_type_Rky.a(this, new rkv(this, arrayOfBitmap));
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        return arrayOfBitmap[0];
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramBitmap);
    if (this.jdField_a_of_type_Rkx != null) {
      this.jdField_a_of_type_Rkx.b(this);
    }
    if (this.jdField_a_of_type_Rkw != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label68;
      }
      this.jdField_a_of_type_Rkw.a(paramBitmap, this);
    }
    for (;;)
    {
      a();
      return;
      label68:
      this.jdField_a_of_type_Rkw.a();
    }
  }
  
  public void a(rkx paramrkx)
  {
    this.jdField_a_of_type_Rkx = paramrkx;
  }
  
  public void a(rky paramrky)
  {
    this.jdField_a_of_type_Rky = paramrky;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.jdField_a_of_type_Rkx != null) {
      this.jdField_a_of_type_Rkx.a(this);
    }
  }
  
  public String toString()
  {
    return "CaptureTask{id=" + this.jdField_a_of_type_Int + ", type=" + this.b + ", path='" + this.jdField_a_of_type_JavaLangString + '\'' + ", position=" + this.c + ", width=" + this.d + ", height=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rku
 * JD-Core Version:    0.7.0.1
 */