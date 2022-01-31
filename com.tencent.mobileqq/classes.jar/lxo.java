import java.lang.ref.WeakReference;

public class lxo
  implements ajuc
{
  private WeakReference<lxs> a;
  private WeakReference<ajty> b;
  private WeakReference<lwz> c;
  
  public lxo(lxs paramlxs, ajty paramajty, lwz paramlwz)
  {
    this.a = new WeakReference(paramlxs);
    this.b = new WeakReference(paramajty);
    this.c = new WeakReference(paramlwz);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ajty)this.b.get();
    if (localObject != null) {
      ((ajty)localObject).d(this);
    }
    localObject = (lxs)this.a.get();
    lwz locallwz = (lwz)this.c.get();
    if ((localObject != null) && (locallwz != null)) {
      ((lxs)localObject).a(paramBoolean, locallwz);
    }
  }
  
  public void a(lwz paramlwz)
  {
    this.c = new WeakReference(paramlwz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxo
 * JD-Core Version:    0.7.0.1
 */