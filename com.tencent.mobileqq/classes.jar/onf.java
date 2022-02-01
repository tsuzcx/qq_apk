import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class onf
  extends aqwt<one>
{
  @NonNull
  public one a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = uqm.d((QQAppInterface)localObject);
        return one.a(uqm.a((QQAppInterface)localObject), uqm.b((QQAppInterface)localObject), bool);
      }
    }
    return new one();
  }
  
  @Nullable
  public one a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return one.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(one paramone)
  {
    paramone.a();
  }
  
  public Class<one> clazz()
  {
    return one.class;
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
      return bhhr.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
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
 * Qualified Name:     onf
 * JD-Core Version:    0.7.0.1
 */