import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mbs
  implements Observer
{
  private final WeakReference<mbo> a;
  
  mbs(mbo parammbo)
  {
    this.a = new WeakReference(parammbo);
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
      paramObject = (mbo)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbs
 * JD-Core Version:    0.7.0.1
 */