import java.lang.ref.WeakReference;

class nja
  implements qoc
{
  private WeakReference<niz> a;
  
  public nja(niz paramniz)
  {
    this.a = new WeakReference(paramniz);
  }
  
  public void a()
  {
    niz localniz = (niz)this.a.get();
    if ((localniz == null) || (!localniz.b())) {
      return;
    }
    niz.a(localniz).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */