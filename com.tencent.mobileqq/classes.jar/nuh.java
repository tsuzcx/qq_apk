import java.lang.ref.WeakReference;

class nuh
  implements rak
{
  private WeakReference<nug> a;
  
  public nuh(nug paramnug)
  {
    this.a = new WeakReference(paramnug);
  }
  
  public void a()
  {
    nug localnug = (nug)this.a.get();
    if ((localnug == null) || (!localnug.b())) {
      return;
    }
    nug.a(localnug).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuh
 * JD-Core Version:    0.7.0.1
 */