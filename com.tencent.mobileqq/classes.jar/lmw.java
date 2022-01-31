import java.lang.ref.WeakReference;

public class lmw
  implements ajga
{
  private WeakReference<lna> a;
  private WeakReference<ajfw> b;
  private WeakReference<lmh> c;
  
  public lmw(lna paramlna, ajfw paramajfw, lmh paramlmh)
  {
    this.a = new WeakReference(paramlna);
    this.b = new WeakReference(paramajfw);
    this.c = new WeakReference(paramlmh);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ajfw)this.b.get();
    if (localObject != null) {
      ((ajfw)localObject).d(this);
    }
    localObject = (lna)this.a.get();
    lmh locallmh = (lmh)this.c.get();
    if ((localObject != null) && (locallmh != null)) {
      ((lna)localObject).a(paramBoolean, locallmh);
    }
  }
  
  public void a(lmh paramlmh)
  {
    this.c = new WeakReference(paramlmh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */