package com.tencent.mobileqq.soload.biz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoloadService;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class SoLoadIPCModule
  extends QIPCModule
{
  public static SoLoadIPCModule a;
  
  private SoLoadIPCModule()
  {
    super("SoLoadIPCModule");
  }
  
  public static SoLoadIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new SoLoadIPCModule();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    if ("ComIPCUtils".equals(paramString)) {
      try
      {
        switch (paramBundle.getInt("oper_type", -1))
        {
        case 17: 
          boolean bool = paramBundle.getBoolean("is_sync");
          paramString = (LoadParam)paramBundle.getSerializable("load_param");
          paramBundle = (LoadParam.LoadItem)paramBundle.getSerializable("load_item");
          ISoloadService localISoloadService = (ISoloadService)QRoute.api(ISoloadService.class);
          if (localISoloadService == null) {
            return null;
          }
          if (bool)
          {
            paramString = localISoloadService.getSoLoadInfoTaskSync(paramString, paramBundle);
            paramBundle = new Bundle();
            paramBundle.putSerializable("res", paramString);
            return EIPCResult.createSuccessResult(paramBundle);
          }
          localISoloadService.getSoLoadInfoTaskAsync(paramString, paramBundle, new SoLoadIPCModule.1(this, paramInt));
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("SoLoadWidget.SoLoadIPCModule", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.SoLoadIPCModule
 * JD-Core Version:    0.7.0.1
 */