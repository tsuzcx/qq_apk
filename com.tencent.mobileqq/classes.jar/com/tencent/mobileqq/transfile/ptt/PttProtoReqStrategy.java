package com.tencent.mobileqq.transfile.ptt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
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
    if ((localQQAppInterface != null) && (PttOptimizeParams.d(localQQAppInterface)))
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
      QQAppInterface localQQAppInterface = getQQAppinterface();
      if (getQQAppinterface() != null)
      {
        paramProtoReq.tryTime = PttOptimizeParams.a(localQQAppInterface);
        paramProtoReq.tryCount = PttOptimizeParams.b(localQQAppInterface);
        paramProtoReq.fixScheduleCount = PttOptimizeParams.c(localQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("PttProtoReqStrategy", 2, "ptt config from dpc:" + paramProtoReq.tryTime + paramProtoReq.tryCount + paramProtoReq.fixScheduleCount);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ptt.PttProtoReqStrategy
 * JD-Core Version:    0.7.0.1
 */