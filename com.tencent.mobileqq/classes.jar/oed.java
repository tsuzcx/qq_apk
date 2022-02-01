import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class oed
  extends arac<oec>
{
  @NonNull
  public oec a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return oec.a(bhsi.e(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new oec();
  }
  
  @Nullable
  public oec a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return oec.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(oec paramoec)
  {
    paramoec.b();
    paramoec.a();
  }
  
  public Class<oec> clazz()
  {
    return oec.class;
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
      return bhsi.m(((QQAppInterface)localAppRuntime).getApp());
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oed
 * JD-Core Version:    0.7.0.1
 */