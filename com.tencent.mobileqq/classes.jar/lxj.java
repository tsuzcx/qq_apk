import java.lang.ref.WeakReference;

public class lxj
  implements ajua
{
  private WeakReference<lxn> a;
  private WeakReference<ajtw> b;
  private WeakReference<lwu> c;
  
  public lxj(lxn paramlxn, ajtw paramajtw, lwu paramlwu)
  {
    this.a = new WeakReference(paramlxn);
    this.b = new WeakReference(paramajtw);
    this.c = new WeakReference(paramlwu);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ajtw)this.b.get();
    if (localObject != null) {
      ((ajtw)localObject).d(this);
    }
    localObject = (lxn)this.a.get();
    lwu locallwu = (lwu)this.c.get();
    if ((localObject != null) && (locallwu != null)) {
      ((lxn)localObject).a(paramBoolean, locallwu);
    }
  }
  
  public void a(lwu paramlwu)
  {
    this.c = new WeakReference(paramlwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxj
 * JD-Core Version:    0.7.0.1
 */