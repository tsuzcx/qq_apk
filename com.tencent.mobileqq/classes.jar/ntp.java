import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ntp
  extends aofy<nto>
{
  public int a()
  {
    return 32;
  }
  
  public Class<nto> a()
  {
    return nto.class;
  }
  
  @NonNull
  public nto a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return nto.a(bdiv.e(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new nto();
  }
  
  @Nullable
  public nto a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return nto.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nto paramnto)
  {
    paramnto.b();
    paramnto.a();
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return bdiv.n(((QQAppInterface)localAppRuntime).getApp());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntp
 * JD-Core Version:    0.7.0.1
 */