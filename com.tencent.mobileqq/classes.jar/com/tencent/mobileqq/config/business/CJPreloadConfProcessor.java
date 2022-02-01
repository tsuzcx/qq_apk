package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.avgame.config.data.CJPreloadConfBean;
import com.tencent.avgame.gamelogic.gameres.BaseConfProcessor;
import com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class CJPreloadConfProcessor
  extends BaseConfProcessor<CJPreloadConfBean>
{
  @NonNull
  public CJPreloadConfBean a(int paramInt)
  {
    super.migrateOldOrDefaultContent(paramInt);
    return new CJPreloadConfBean();
  }
  
  protected CJPreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.i("springHb_CJPreloadConfProcessor", 2, localStringBuilder.toString());
      }
      return CJPreloadConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(CJPreloadConfBean paramCJPreloadConfBean)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onUpdate 0 newConf.allConfigJa:");
    Object localObject1;
    if (paramCJPreloadConfBean.a != null) {
      localObject1 = paramCJPreloadConfBean.a.toString();
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("springHb_CJPreloadConfProcessor", 2, ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject1 != null)
      {
        localObject2 = (IPreloadService)((QQAppInterface)localObject1).getRuntimeService(IPreloadService.class, "");
        if ((localObject2 != null) && (paramCJPreloadConfBean.a != null))
        {
          ((IPreloadService)localObject2).replaceConfig(paramCJPreloadConfBean.a, 3);
          ((IPreloadService)localObject2).savePreloadConfig();
          ((IPreloadService)localObject2).startCheckConfig(true);
          QLog.d("springHb_CJPreloadConfProcessor", 2, "onUpdate 1");
        }
        CJPreloadMonitorReporter.a();
        if ((paramCJPreloadConfBean.a != null) && (paramCJPreloadConfBean.a.length() > 0))
        {
          CJPreloadMonitorReporter.a((AppInterface)localObject1, 1, 0, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), ((QQAppInterface)localObject1).getCurrentAccountUin()), true, CJPreloadMonitorReporter.a(type()));
          return;
        }
      }
    }
    catch (Throwable paramCJPreloadConfBean)
    {
      QLog.e("springHb_CJPreloadConfProcessor", 1, QLog.getStackTraceString(paramCJPreloadConfBean));
    }
  }
  
  @Nullable
  public CJPreloadConfBean b(QConfItem[] paramArrayOfQConfItem)
  {
    return (CJPreloadConfBean)super.onParsed(paramArrayOfQConfItem);
  }
  
  public Class<CJPreloadConfBean> clazz()
  {
    return CJPreloadConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    CJPreloadMonitorReporter.a();
  }
  
  public int type()
  {
    return 721;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.CJPreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */