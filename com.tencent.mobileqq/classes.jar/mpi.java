import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class mpi
  implements Observer
{
  private final WeakReference<mpe> a;
  
  mpi(mpe parammpe)
  {
    this.a = new WeakReference(parammpe);
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
      paramObject = (mpe)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mpi
 * JD-Core Version:    0.7.0.1
 */