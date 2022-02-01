import android.os.Handler;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class lhh
  implements Observer
{
  private WeakReference<MagicFaceDataEntity> a;
  
  public lhh(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    this.a = new WeakReference(paramMagicFaceDataEntity);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int j;
    if (this.a.get() != null)
    {
      paramObservable = ((MagicFaceDataEntity)this.a.get()).a;
      if (paramObject != null)
      {
        Object[] arrayOfObject = (Object[])paramObject;
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          j = ((Integer)arrayOfObject[0]).intValue();
          if ((j == 130) || (j == 131) || (j == 132)) {
            if ((j != 131) && (j != 132)) {
              break label152;
            }
          }
        }
      }
    }
    label152:
    for (int i = 500;; i = 0)
    {
      lbd.f("MagicFaceDataEntity", "MagicFaceDataEntity update :" + j + "|" + i);
      paramObservable.sendMessageDelayed(paramObservable.obtainMessage(1, paramObject), i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhh
 * JD-Core Version:    0.7.0.1
 */