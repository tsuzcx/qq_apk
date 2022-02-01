import java.lang.ref.WeakReference;

public class lxr
  implements ansd
{
  private WeakReference<lxu> a;
  private WeakReference<anrz> b;
  private WeakReference<lxb> c;
  
  public lxr(lxu paramlxu, anrz paramanrz, lxb paramlxb)
  {
    this.a = new WeakReference(paramlxu);
    this.b = new WeakReference(paramanrz);
    this.c = new WeakReference(paramlxb);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (anrz)this.b.get();
    if (localObject != null) {
      ((anrz)localObject).d(this);
    }
    localObject = (lxu)this.a.get();
    lxb locallxb = (lxb)this.c.get();
    if ((localObject != null) && (locallxb != null)) {
      ((lxu)localObject).a(paramBoolean, locallxb);
    }
  }
  
  public void a(lxb paramlxb)
  {
    this.c = new WeakReference(paramlxb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxr
 * JD-Core Version:    0.7.0.1
 */