import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nqh
  extends ampb<nqg>
{
  public int a()
  {
    return 70;
  }
  
  public Class<nqg> a()
  {
    return nqg.class;
  }
  
  @NonNull
  public nqg a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        sfh.a((QQAppInterface)localObject, sfh.a((QQAppInterface)localObject));
        return nqg.a();
      }
    }
    return new nqg();
  }
  
  @Nullable
  public nqg a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return nqg.a(paramArrayOfampi);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqg paramnqg)
  {
    paramnqg.a();
    paramnqg.b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return sfh.b((QQAppInterface)localAppRuntime);
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqh
 * JD-Core Version:    0.7.0.1
 */