import java.lang.ref.WeakReference;

public class lzy
  implements alqc
{
  private WeakReference<mac> a;
  private WeakReference<alpy> b;
  private WeakReference<lzj> c;
  
  public lzy(mac parammac, alpy paramalpy, lzj paramlzj)
  {
    this.a = new WeakReference(parammac);
    this.b = new WeakReference(paramalpy);
    this.c = new WeakReference(paramlzj);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (alpy)this.b.get();
    if (localObject != null) {
      ((alpy)localObject).d(this);
    }
    localObject = (mac)this.a.get();
    lzj locallzj = (lzj)this.c.get();
    if ((localObject != null) && (locallzj != null)) {
      ((mac)localObject).a(paramBoolean, locallzj);
    }
  }
  
  public void a(lzj paramlzj)
  {
    this.c = new WeakReference(paramlzj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lzy
 * JD-Core Version:    0.7.0.1
 */