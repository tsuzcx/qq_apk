package cooperation.ilive.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

public class IliveManagerConfProcessor
  extends BaseQVipConfigProcessor<IliveManagerCfgBean>
{
  public static IliveManagerCfgBean a()
  {
    return (IliveManagerCfgBean)QConfigManager.b().b(689);
  }
  
  @NonNull
  public IliveManagerCfgBean a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QLog.e("IliveManagerConfProcessor", 1, "onParsed ");
    if (paramArrayOfQConfItem != null) {
      try
      {
        Object localObject;
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            localObject = paramArrayOfQConfItem[i];
            if (localObject != null)
            {
              IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerCfgBean.a(((QConfItem)localObject).b);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed content = ");
              localStringBuilder.append(((QConfItem)localObject).b);
              QLog.e("IliveManagerConfProcessor", 1, localStringBuilder.toString());
              if (localIliveManagerCfgBean != null) {
                return localIliveManagerCfgBean;
              }
            }
            i += 1;
          }
        }
        return new IliveManagerCfgBean();
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed Exception = ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem.getMessage());
        QLog.e("IliveManagerConfProcessor", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @NonNull
  public IliveManagerCfgBean b()
  {
    return new IliveManagerCfgBean();
  }
  
  public Class<IliveManagerCfgBean> clazz()
  {
    return IliveManagerCfgBean.class;
  }
  
  @NonNull
  public IliveManagerCfgBean e()
  {
    return new IliveManagerCfgBean();
  }
  
  public int type()
  {
    return 689;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.config.IliveManagerConfProcessor
 * JD-Core Version:    0.7.0.1
 */