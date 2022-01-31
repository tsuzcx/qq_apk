import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class tei
  extends aokh<teh>
{
  public int a()
  {
    return 447;
  }
  
  public Class<teh> a()
  {
    return teh.class;
  }
  
  @NonNull
  public teh a(int paramInt)
  {
    return new teh();
  }
  
  @Nullable
  public teh a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      tlo.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaoko[0].a);
      teh localteh = new teh();
      localteh.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localteh;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(teh paramteh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramteh);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tei
 * JD-Core Version:    0.7.0.1
 */