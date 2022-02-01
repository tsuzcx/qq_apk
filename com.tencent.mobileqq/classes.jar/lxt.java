import java.lang.ref.WeakReference;

public class lxt
  implements anvi
{
  private WeakReference<lxw> a;
  private WeakReference<anve> b;
  private WeakReference<lxd> c;
  
  public lxt(lxw paramlxw, anve paramanve, lxd paramlxd)
  {
    this.a = new WeakReference(paramlxw);
    this.b = new WeakReference(paramanve);
    this.c = new WeakReference(paramlxd);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (anve)this.b.get();
    if (localObject != null) {
      ((anve)localObject).d(this);
    }
    localObject = (lxw)this.a.get();
    lxd locallxd = (lxd)this.c.get();
    if ((localObject != null) && (locallxd != null)) {
      ((lxw)localObject).a(paramBoolean, locallxd);
    }
  }
  
  public void a(lxd paramlxd)
  {
    this.c = new WeakReference(paramlxd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxt
 * JD-Core Version:    0.7.0.1
 */