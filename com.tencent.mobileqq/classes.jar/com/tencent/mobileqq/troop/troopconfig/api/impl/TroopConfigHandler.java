package com.tencent.mobileqq.troop.troopconfig.api.impl;

import android.content.SharedPreferences;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.TroopConfigHandlerProcessorConfig;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.ReqBody;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopconfig.api.ITroopConfigHandler;
import com.tencent.mobileqq.troop.troopconfig.api.TroopConfigObserver;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class TroopConfigHandler
  extends TroopBaseHandler
  implements ITroopConfigHandler
{
  protected Set<String> a;
  
  public TroopConfigHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.msg_group_msg_config;
    TroopConfigHandlerProcessorConfig.a().a(this.appRuntime, paramRspBody);
  }
  
  private void b(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.robot_config;
    int i = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
    if ((paramRspBody.has()) && (i != paramRspBody.version.get()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleRobotConfig ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramRspBody.version.get());
        QLog.i("TroopConfigHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (ITroopRobotService)this.appRuntime.getRuntimeService(ITroopRobotService.class, "all");
      ((ITroopRobotService)localObject).setRobotConfig(paramRspBody);
      ((ITroopRobotService)localObject).saveRobotConfig(paramRspBody);
    }
  }
  
  private void c(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.aio_keyword_config;
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, app == null");
      }
      return;
    }
    if (paramRspBody.has())
    {
      if (paramRspBody.version.has())
      {
        int i = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getTroopAioKeyWordVersion(BaseApplication.getContext(), this.appRuntime.getCurrentAccountUin());
        if (paramRspBody.version.get() != i)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleAioKeywordConfig, version change, new_version=");
            localStringBuilder.append(paramRspBody.version.get());
            localStringBuilder.append("old_version=");
            localStringBuilder.append(i);
            QLog.i("TroopConfigHandler", 2, localStringBuilder.toString());
          }
          TroopConfigHandlerProcessorConfig.a().a(this.appRuntime, paramRspBody);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, version no change");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, do not has version");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, do not has aioKeyword");
    }
  }
  
  public void b()
  {
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopConfigHandler", 2, "getTroopConfig, app= null");
      }
      return;
    }
    oidb_0x496.ReqBody localReqBody = new oidb_0x496.ReqBody();
    localReqBody.uint64_update_time.set(0L);
    localReqBody.uint64_first_unread_manager_msg_seq.set(1L);
    int i = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
    localReqBody.uint32_version.set(i, true);
    localReqBody.uint32_aio_keyword_version.set(((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getTroopAioKeyWordVersion(BaseApplication.getContext(), this.appRuntime.getCurrentAccountUin()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopConfig, type =");
      localStringBuilder.append(3);
      QLog.i("TroopConfigHandler", 2, localStringBuilder.toString());
    }
    localReqBody.uint32_type.set(3, true);
    ProtoUtils.a(this.appRuntime, new TroopConfigHandler.1(this), localReqBody.toByteArray(), "OidbSvc.0x496", 1174, 0);
  }
  
  protected String dv_()
  {
    return "TroopConfigHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null) {
      this.a = new HashSet();
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopConfigObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopconfig.api.impl.TroopConfigHandler
 * JD-Core Version:    0.7.0.1
 */