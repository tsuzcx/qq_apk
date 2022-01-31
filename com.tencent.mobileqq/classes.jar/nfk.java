import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nfk
  extends alzl<nfj>
{
  public int a()
  {
    return 81;
  }
  
  public Class<nfj> a()
  {
    return nfj.class;
  }
  
  @NonNull
  public nfj a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        rsp.a((QQAppInterface)localAppRuntime);
        return nfj.a();
      }
    }
    return new nfj();
  }
  
  @Nullable
  public nfj a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return nfj.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nfj paramnfj)
  {
    paramnfj.b();
    paramnfj.a();
    paramnfj.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return rsp.a((QQAppInterface)localAppRuntime);
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
 * Qualified Name:     nfk
 * JD-Core Version:    0.7.0.1
 */