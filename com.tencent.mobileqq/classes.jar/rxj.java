import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class rxj
  extends alzl<rxi>
{
  public int a()
  {
    return 447;
  }
  
  public Class<rxi> a()
  {
    return rxi.class;
  }
  
  @NonNull
  public rxi a(int paramInt)
  {
    return new rxi();
  }
  
  @Nullable
  public rxi a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      sai.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfalzs[0].a);
      rxi localrxi = new rxi();
      localrxi.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localrxi;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(rxi paramrxi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramrxi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxj
 * JD-Core Version:    0.7.0.1
 */