import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mnk
  implements Observer
{
  private final WeakReference<mng> a;
  
  mnk(mng parammng)
  {
    this.a = new WeakReference(parammng);
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
      paramObject = (mng)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnk
 * JD-Core Version:    0.7.0.1
 */