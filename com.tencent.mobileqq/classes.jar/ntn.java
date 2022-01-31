import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ntn
  extends aokh<ntm>
{
  public int a()
  {
    return 70;
  }
  
  public Class<ntm> a()
  {
    return ntm.class;
  }
  
  @NonNull
  public ntm a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        swy.a((QQAppInterface)localObject, swy.a((QQAppInterface)localObject));
        return ntm.a();
      }
    }
    return new ntm();
  }
  
  @Nullable
  public ntm a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return ntm.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(ntm paramntm)
  {
    paramntm.a();
    paramntm.b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return swy.b((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */