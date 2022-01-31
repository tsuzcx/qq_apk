import java.lang.ref.WeakReference;

class nuk
  implements ran
{
  private WeakReference<nuj> a;
  
  public nuk(nuj paramnuj)
  {
    this.a = new WeakReference(paramnuj);
  }
  
  public void a()
  {
    nuj localnuj = (nuj)this.a.get();
    if ((localnuj == null) || (!localnuj.b())) {
      return;
    }
    nuj.a(localnuj).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuk
 * JD-Core Version:    0.7.0.1
 */