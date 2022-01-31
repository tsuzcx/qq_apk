import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ntr
  extends aofy<ntq>
{
  public int a()
  {
    return 81;
  }
  
  public Class<ntq> a()
  {
    return ntq.class;
  }
  
  @NonNull
  public ntq a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        swy.a((QQAppInterface)localAppRuntime);
        return ntq.a();
      }
    }
    return new ntq();
  }
  
  @Nullable
  public ntq a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return ntq.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(ntq paramntq)
  {
    paramntq.b();
    paramntq.a();
    paramntq.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return swy.a((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     ntr
 * JD-Core Version:    0.7.0.1
 */