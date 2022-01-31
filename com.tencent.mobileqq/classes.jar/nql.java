import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nql
  extends ampb<nqk>
{
  public int a()
  {
    return 81;
  }
  
  public Class<nqk> a()
  {
    return nqk.class;
  }
  
  @NonNull
  public nqk a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        sfh.a((QQAppInterface)localAppRuntime);
        return nqk.a();
      }
    }
    return new nqk();
  }
  
  @Nullable
  public nqk a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return nqk.a(paramArrayOfampi);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqk paramnqk)
  {
    paramnqk.b();
    paramnqk.a();
    paramnqk.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return sfh.a((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     nql
 * JD-Core Version:    0.7.0.1
 */