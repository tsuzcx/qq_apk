package cooperation.ilive.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

public class IliveManagerConfProcessor
  extends BaseQVipConfigProcessor<IliveManagerCfgBean>
{
  public static IliveManagerCfgBean a()
  {
    return (IliveManagerCfgBean)QConfigManager.a().a(689);
  }
  
  @NonNull
  public IliveManagerCfgBean a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QLog.e("IliveManagerConfProcessor", 1, "onParsed ");
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            QConfItem localQConfItem = paramArrayOfQConfItem[i];
            if (localQConfItem != null)
            {
              IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerCfgBean.a(localQConfItem.a);
              QLog.e("IliveManagerConfProcessor", 1, "onParsed content = " + localQConfItem.a);
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
        QLog.e("IliveManagerConfProcessor", 1, "onParsed Exception = " + paramArrayOfQConfItem.getMessage());
      }
    }
  }
  
  @NonNull
  public IliveManagerCfgBean b()
  {
    return new IliveManagerCfgBean();
  }
  
  @NonNull
  public IliveManagerCfgBean c()
  {
    return new IliveManagerCfgBean();
  }
  
  public Class<IliveManagerCfgBean> clazz()
  {
    return IliveManagerCfgBean.class;
  }
  
  public int type()
  {
    return 689;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.config.IliveManagerConfProcessor
 * JD-Core Version:    0.7.0.1
 */