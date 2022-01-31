import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class skf
  extends ampb<ske>
{
  public int a()
  {
    return 447;
  }
  
  public Class<ske> a()
  {
    return ske.class;
  }
  
  @NonNull
  public ske a(int paramInt)
  {
    return new ske();
  }
  
  @Nullable
  public ske a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      sne.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfampi[0].a);
      ske localske = new ske();
      localske.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfampi[0].a);
      }
      return localske;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(ske paramske)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramske);
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
 * Qualified Name:     skf
 * JD-Core Version:    0.7.0.1
 */