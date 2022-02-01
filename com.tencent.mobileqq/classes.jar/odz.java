import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class odz
  extends arac<ody>
{
  @NonNull
  public ody a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = tvz.d((QQAppInterface)localObject);
        return ody.a(tvz.a((QQAppInterface)localObject), tvz.b((QQAppInterface)localObject), bool);
      }
    }
    return new ody();
  }
  
  @Nullable
  public ody a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return ody.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(ody paramody)
  {
    paramody.a();
  }
  
  public Class<ody> clazz()
  {
    return ody.class;
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return bhsi.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 35;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odz
 * JD-Core Version:    0.7.0.1
 */