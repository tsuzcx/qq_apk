import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mmn
  implements Observer
{
  private final WeakReference<mmj> a;
  
  mmn(mmj parammmj)
  {
    this.a = new WeakReference(parammmj);
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
      paramObject = (mmj)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmn
 * JD-Core Version:    0.7.0.1
 */