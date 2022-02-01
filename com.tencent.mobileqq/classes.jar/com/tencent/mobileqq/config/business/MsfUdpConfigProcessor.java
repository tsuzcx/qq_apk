package com.tencent.mobileqq.config.business;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/MsfUdpConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/MsfUdpConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/MsfUdpConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MsfUdpConfigProcessor
  extends IQConfigProcessor<MsfUdpConfigBean>
{
  public MsfUdpConfigProcessor()
  {
    QLog.d("MsfUdpConfigProcessor", 1, "[MsfUdpConfigProcessor] constructor");
  }
  
  @NotNull
  public MsfUdpConfigBean a(int paramInt)
  {
    return new MsfUdpConfigBean(false, 0, 0, 7, null);
  }
  
  @Nullable
  public MsfUdpConfigBean a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = null;
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        QConfItem localQConfItem2 = (QConfItem)null;
        int j = paramArrayOfQConfItem.length;
        i = 0;
        QConfItem localQConfItem1;
        for (;;)
        {
          localQConfItem1 = localQConfItem2;
          if (i >= j) {
            break;
          }
          localQConfItem1 = paramArrayOfQConfItem[i];
          if ((localQConfItem1 != null) && (!TextUtils.isEmpty((CharSequence)localQConfItem1.b))) {
            break;
          }
          i += 1;
        }
        QLog.d("MsfUdpConfigProcessor", 1, new Object[] { "[onParsed] ", localQConfItem1 });
        paramArrayOfQConfItem = localObject;
        if (localQConfItem1 != null) {
          paramArrayOfQConfItem = MsfUdpConfigProcessorKt.a(localQConfItem1.b);
        }
        return paramArrayOfQConfItem;
      }
    }
    QLog.d("MsfUdpConfigProcessor", 1, "[onParsed] config is empty.");
    return null;
  }
  
  public void a(@Nullable MsfUdpConfigBean paramMsfUdpConfigBean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 == null)
    {
      QLog.d("MsfUdpConfigProcessor", 1, "[onUpdate] failed, app is null");
      return;
    }
    Object localObject2;
    try
    {
      localObject2 = MsfUdpConfigProcessorKt.a(paramMsfUdpConfigBean);
      QLog.d("MsfUdpConfigProcessor", 1, new Object[] { "[onUpdate] conf: ", localObject2 });
      localObject3 = new NewIntent((Context)((AppRuntime)localObject1).getApplication(), BuiltInServlet.class);
      ((NewIntent)localObject3).putExtra("action", 2214);
      ((NewIntent)localObject3).putExtra("manager_config", (String)localObject2);
      ThreadManager.getUIHandler().post((Runnable)new MsfUdpConfigProcessor.onUpdate.1((AppRuntime)localObject1, (NewIntent)localObject3));
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MsfUdpConfigProcessor", 1, "[onUpdate] err: ", localThrowable);
    }
    Object localObject3 = null;
    Boolean localBoolean;
    if (paramMsfUdpConfigBean != null) {
      localBoolean = Boolean.valueOf(paramMsfUdpConfigBean.a());
    } else {
      localBoolean = null;
    }
    if (paramMsfUdpConfigBean != null) {
      localObject2 = Integer.valueOf(paramMsfUdpConfigBean.c());
    } else {
      localObject2 = null;
    }
    if (paramMsfUdpConfigBean != null) {
      localObject3 = Integer.valueOf(paramMsfUdpConfigBean.b());
    }
    QLog.d("MsfUdpConfigProcessor", 1, new Object[] { "[onUpdate] switch: ", localBoolean, "timeout: ", localObject2, "retry: ", localObject3 });
  }
  
  @NotNull
  public Class<MsfUdpConfigBean> clazz()
  {
    return MsfUdpConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("MsfUdpConfigProcessor", 1, new Object[] { "[onReqFailed] code: ", Integer.valueOf(paramInt) });
  }
  
  public int type()
  {
    return 754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsfUdpConfigProcessor
 * JD-Core Version:    0.7.0.1
 */