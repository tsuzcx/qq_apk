import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mmt
  implements Observer
{
  private final WeakReference<mmp> a;
  
  mmt(mmp parammmp)
  {
    this.a = new WeakReference(parammmp);
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
      paramObject = (mmp)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmt
 * JD-Core Version:    0.7.0.1
 */