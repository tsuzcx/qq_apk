import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class qrw
  extends AsyncTask<Void, Void, Bitmap>
{
  int jdField_a_of_type_Int = -2147483648;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  private qry jdField_a_of_type_Qry;
  private qrz jdField_a_of_type_Qrz;
  private qsa jdField_a_of_type_Qsa;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  
  public qrw(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, qry paramqry)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_Qry = paramqry;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Qry = null;
    this.jdField_a_of_type_Qrz = null;
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
    this.jdField_a_of_type_Qsa.a(this, new qrx(this, arrayOfBitmap));
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
    if (this.jdField_a_of_type_Qrz != null) {
      this.jdField_a_of_type_Qrz.b(this);
    }
    if (this.jdField_a_of_type_Qry != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label68;
      }
      this.jdField_a_of_type_Qry.a(paramBitmap, this);
    }
    for (;;)
    {
      a();
      return;
      label68:
      this.jdField_a_of_type_Qry.a();
    }
  }
  
  public void a(qrz paramqrz)
  {
    this.jdField_a_of_type_Qrz = paramqrz;
  }
  
  public void a(qsa paramqsa)
  {
    this.jdField_a_of_type_Qsa = paramqsa;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.jdField_a_of_type_Qrz != null) {
      this.jdField_a_of_type_Qrz.a(this);
    }
  }
  
  public String toString()
  {
    return "CaptureTask{id=" + this.jdField_a_of_type_Int + ", type=" + this.b + ", path='" + this.jdField_a_of_type_JavaLangString + '\'' + ", position=" + this.c + ", width=" + this.d + ", height=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */