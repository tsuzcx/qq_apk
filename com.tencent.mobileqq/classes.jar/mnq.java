import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mnq
  implements Observer
{
  private final WeakReference<mnm> a;
  
  mnq(mnm parammnm)
  {
    this.a = new WeakReference(parammnm);
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
      paramObject = (mnm)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnq
 * JD-Core Version:    0.7.0.1
 */