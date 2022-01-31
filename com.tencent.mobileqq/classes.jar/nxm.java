import java.lang.ref.WeakReference;

class nxm
  implements rqh
{
  private WeakReference<nxl> a;
  
  public nxm(nxl paramnxl)
  {
    this.a = new WeakReference(paramnxl);
  }
  
  public void a()
  {
    nxl localnxl = (nxl)this.a.get();
    if ((localnxl == null) || (!localnxl.b())) {
      return;
    }
    nxl.a(localnxl).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxm
 * JD-Core Version:    0.7.0.1
 */