import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nfi
  extends alzl<nfh>
{
  public int a()
  {
    return 32;
  }
  
  public Class<nfh> a()
  {
    return nfh.class;
  }
  
  @NonNull
  public nfh a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return nfh.a(baig.e(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new nfh();
  }
  
  @Nullable
  public nfh a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return nfh.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nfh paramnfh)
  {
    paramnfh.b();
    paramnfh.a();
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return baig.n(((QQAppInterface)localAppRuntime).getApp());
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
 * Qualified Name:     nfi
 * JD-Core Version:    0.7.0.1
 */