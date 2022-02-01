import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class oeb
  extends arac<oea>
{
  @NonNull
  public oea a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        tyi.a((QQAppInterface)localObject, tyi.a((QQAppInterface)localObject));
        return oea.a();
      }
    }
    return new oea();
  }
  
  @Nullable
  public oea a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return oea.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(oea paramoea)
  {
    paramoea.a();
    paramoea.b();
  }
  
  public Class<oea> clazz()
  {
    return oea.class;
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
      return tyi.b((QQAppInterface)localAppRuntime);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 70;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oeb
 * JD-Core Version:    0.7.0.1
 */