import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nfg
  extends alzl<nff>
{
  public int a()
  {
    return 70;
  }
  
  public Class<nff> a()
  {
    return nff.class;
  }
  
  @NonNull
  public nff a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        rsp.a((QQAppInterface)localObject, rsp.a((QQAppInterface)localObject));
        return nff.a();
      }
    }
    return new nff();
  }
  
  @Nullable
  public nff a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return nff.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nff paramnff)
  {
    paramnff.a();
    paramnff.b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return rsp.b((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     nfg
 * JD-Core Version:    0.7.0.1
 */