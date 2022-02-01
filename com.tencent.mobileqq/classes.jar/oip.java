import java.lang.ref.WeakReference;

class oip
  implements sej
{
  private WeakReference<oio> a;
  
  public oip(oio paramoio)
  {
    this.a = new WeakReference(paramoio);
  }
  
  public void a()
  {
    oio localoio = (oio)this.a.get();
    if ((localoio == null) || (!localoio.b())) {
      return;
    }
    oio.a(localoio).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oip
 * JD-Core Version:    0.7.0.1
 */