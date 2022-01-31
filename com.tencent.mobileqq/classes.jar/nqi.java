import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nqi
  extends ampa<nqh>
{
  public int a()
  {
    return 81;
  }
  
  public Class<nqh> a()
  {
    return nqh.class;
  }
  
  @NonNull
  public nqh a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        sfe.a((QQAppInterface)localAppRuntime);
        return nqh.a();
      }
    }
    return new nqh();
  }
  
  @Nullable
  public nqh a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return nqh.a(paramArrayOfamph);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqh paramnqh)
  {
    paramnqh.b();
    paramnqh.a();
    paramnqh.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return sfe.a((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     nqi
 * JD-Core Version:    0.7.0.1
 */