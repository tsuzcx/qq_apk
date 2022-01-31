import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nqe
  extends ampa<nqd>
{
  public int a()
  {
    return 70;
  }
  
  public Class<nqd> a()
  {
    return nqd.class;
  }
  
  @NonNull
  public nqd a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        sfe.a((QQAppInterface)localObject, sfe.a((QQAppInterface)localObject));
        return nqd.a();
      }
    }
    return new nqd();
  }
  
  @Nullable
  public nqd a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return nqd.a(paramArrayOfamph);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqd paramnqd)
  {
    paramnqd.a();
    paramnqd.b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return sfe.b((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     nqe
 * JD-Core Version:    0.7.0.1
 */