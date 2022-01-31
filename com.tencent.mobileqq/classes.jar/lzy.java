import java.lang.ref.WeakReference;

public class lzy
  implements alln
{
  private WeakReference<mac> a;
  private WeakReference<allj> b;
  private WeakReference<lzj> c;
  
  public lzy(mac parammac, allj paramallj, lzj paramlzj)
  {
    this.a = new WeakReference(parammac);
    this.b = new WeakReference(paramallj);
    this.c = new WeakReference(paramlzj);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (allj)this.b.get();
    if (localObject != null) {
      ((allj)localObject).d(this);
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