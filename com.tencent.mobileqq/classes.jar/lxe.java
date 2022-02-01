import java.lang.ref.WeakReference;

public class lxe
  implements ampq
{
  private WeakReference<lxh> a;
  private WeakReference<ampm> b;
  private WeakReference<lwo> c;
  
  public lxe(lxh paramlxh, ampm paramampm, lwo paramlwo)
  {
    this.a = new WeakReference(paramlxh);
    this.b = new WeakReference(paramampm);
    this.c = new WeakReference(paramlwo);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ampm)this.b.get();
    if (localObject != null) {
      ((ampm)localObject).d(this);
    }
    localObject = (lxh)this.a.get();
    lwo locallwo = (lwo)this.c.get();
    if ((localObject != null) && (locallwo != null)) {
      ((lxh)localObject).a(paramBoolean, locallwo);
    }
  }
  
  public void a(lwo paramlwo)
  {
    this.c = new WeakReference(paramlwo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxe
 * JD-Core Version:    0.7.0.1
 */