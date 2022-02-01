import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class oef
  extends arac<oee>
{
  @NonNull
  public oee a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        tyi.a((QQAppInterface)localAppRuntime);
        return oee.a();
      }
    }
    return new oee();
  }
  
  @Nullable
  public oee a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return oee.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(oee paramoee)
  {
    paramoee.b();
    paramoee.a();
    paramoee.c();
  }
  
  public Class<oee> clazz()
  {
    return oee.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return tyi.a((QQAppInterface)localAppRuntime);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 81;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oef
 * JD-Core Version:    0.7.0.1
 */