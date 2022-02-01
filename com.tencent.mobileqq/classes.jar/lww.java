import java.lang.ref.WeakReference;

public class lww
  implements anjl
{
  private WeakReference<lxa> a;
  private WeakReference<anjh> b;
  private WeakReference<lwh> c;
  
  public lww(lxa paramlxa, anjh paramanjh, lwh paramlwh)
  {
    this.a = new WeakReference(paramlxa);
    this.b = new WeakReference(paramanjh);
    this.c = new WeakReference(paramlwh);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (anjh)this.b.get();
    if (localObject != null) {
      ((anjh)localObject).d(this);
    }
    localObject = (lxa)this.a.get();
    lwh locallwh = (lwh)this.c.get();
    if ((localObject != null) && (locallwh != null)) {
      ((lxa)localObject).a(paramBoolean, locallwh);
    }
  }
  
  public void a(lwh paramlwh)
  {
    this.c = new WeakReference(paramlwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lww
 * JD-Core Version:    0.7.0.1
 */