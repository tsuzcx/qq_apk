import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mmo
  implements Observer
{
  private final WeakReference<mmk> a;
  
  mmo(mmk parammmk)
  {
    this.a = new WeakReference(parammmk);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    }
    do
    {
      return;
      paramObject = (mmk)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmo
 * JD-Core Version:    0.7.0.1
 */