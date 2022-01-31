import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mmr
  implements Observer
{
  private final WeakReference<mmn> a;
  
  mmr(mmn parammmn)
  {
    this.a = new WeakReference(parammmn);
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
      paramObject = (mmn)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmr
 * JD-Core Version:    0.7.0.1
 */