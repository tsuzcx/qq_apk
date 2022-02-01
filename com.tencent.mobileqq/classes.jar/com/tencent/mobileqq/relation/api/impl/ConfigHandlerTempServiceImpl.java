package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.relation.api.IConfigHandlerTempService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import protocol.KQQConfig.GetResourceReqInfo;

public class ConfigHandlerTempServiceImpl
  implements IConfigHandlerTempService
{
  private static final String TAG = "ConfigHandlerTempServiceImpl";
  
  public void doConfigHandlerUpdateConfigs(AppRuntime paramAppRuntime, ArrayList<GetResourceReqInfo> paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    if (paramAppRuntime != null)
    {
      ((ConfigHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(paramArrayList, paramVarArgs);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("doConfigHandlerUpdateConfigs, listInfos:");
        paramAppRuntime.append(paramArrayList);
        paramAppRuntime.append(", infos:");
        paramAppRuntime.append(paramVarArgs);
        QLog.i("ConfigHandlerTempServiceImpl", 2, paramAppRuntime.toString());
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.ConfigHandlerTempServiceImpl
 * JD-Core Version:    0.7.0.1
 */