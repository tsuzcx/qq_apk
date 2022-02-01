package com.tencent.mobileqq.transfile.ptt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.proto.IProtoReqStrategy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class PttProtoReqStrategy
  implements IProtoReqStrategy
{
  private static final String TAG = "PttProtoReqStrategy";
  
  private QQAppInterface getQQAppinterface()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void updateIntent(NewIntent paramNewIntent)
  {
    QQAppInterface localQQAppInterface = getQQAppinterface();
    if ((localQQAppInterface != null) && (((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).doesSupportHttpSideWay(localQQAppInterface)))
    {
      paramNewIntent.putExtra("quickSendEnable", true);
      paramNewIntent.putExtra("quickSendStrategy", 1);
      if (QLog.isColorLevel()) {
        QLog.d("http_sideway", 2, "set");
      }
    }
  }
  
  public void updateReq(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if ((paramProtoReq.ssoCmd.equals("PttStore.GroupPttUp")) || (paramProtoReq.ssoCmd.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))
    {
      Object localObject = getQQAppinterface();
      if (getQQAppinterface() != null)
      {
        paramProtoReq.tryTime = ((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getTryTime_dpc((AppRuntime)localObject);
        paramProtoReq.tryCount = ((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getTryCount_dpc((AppRuntime)localObject);
        paramProtoReq.fixScheduleCount = ((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getFixScheduleTryCount_dpc((AppRuntime)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ptt config from dpc:");
          ((StringBuilder)localObject).append(paramProtoReq.tryTime);
          ((StringBuilder)localObject).append(paramProtoReq.tryCount);
          ((StringBuilder)localObject).append(paramProtoReq.fixScheduleCount);
          QLog.d("PttProtoReqStrategy", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ptt.PttProtoReqStrategy
 * JD-Core Version:    0.7.0.1
 */