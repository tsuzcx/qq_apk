package com.tencent.mobileqq.nearby.redtouch;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x6cd.PullRedpointReq;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6cd.ReqBody;
import tencent.im.oidb.cmd0x6cd.RspBody;
import tencent.im.oidb.cmd0x6ce.ReadRedpointReq;
import tencent.im.oidb.cmd0x6ce.ReqBody;
import tencent.im.oidb.cmd0x6ce.RspBody;
import tencent.im.oidb.cmd0x6f5.ReqBody;
import tencent.im.oidb.cmd0x6f5.RspBody;

public class RedtouchHandler
  extends BusinessHandler
{
  public RedtouchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs");
    }
    paramToServiceMsg = new cmd0x6f5.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetRedPointConfigs, errCode=");
      paramFromServiceMsg.append(i);
      QLog.i("RedtouchHandler", 2, paramFromServiceMsg.toString());
    }
    if ((i == 0) && (paramToServiceMsg.str_config_version.has()))
    {
      paramFromServiceMsg = paramToServiceMsg.str_config_version.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetRedPointConfigs, server configVersion=");
        paramObject.append(paramFromServiceMsg);
        QLog.i("RedtouchHandler", 2, paramObject.toString());
      }
      if (!TextUtils.isEmpty(paramFromServiceMsg))
      {
        paramObject = (LocalRedTouchManager)this.appRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        if (paramObject != null)
        {
          paramObject.a(paramFromServiceMsg);
          paramObject.a(paramToServiceMsg);
          paramObject.b();
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handlePullRedTouch");
    }
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      Object localObject = paramToServiceMsg.extraData;
      boolean bool2 = false;
      boolean bool3 = ((Bundle)localObject).getBoolean("is_single_task", false);
      int i;
      if (bool3) {
        i = paramToServiceMsg.extraData.getInt("task_id");
      } else {
        i = 0;
      }
      cmd0x6cd.RspBody localRspBody = new cmd0x6cd.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      if (localLocalRedTouchManager == null) {
        return;
      }
      paramObject = null;
      boolean bool1;
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RedtouchHandler", 2, "handlePullRedTouch success.");
        }
        if (localRspBody.rpt_msg_redpoint.has()) {
          paramFromServiceMsg = localRspBody.rpt_msg_redpoint.get();
        } else {
          paramFromServiceMsg = null;
        }
        if (paramFromServiceMsg != null)
        {
          localObject = new ArrayList(paramFromServiceMsg.size());
          j = 0;
          for (;;)
          {
            paramToServiceMsg = (ToServiceMsg)localObject;
            if (j >= paramFromServiceMsg.size()) {
              break;
            }
            paramToServiceMsg = RedTouchItem.getRedTouchItem((cmd0x6cd.RedpointInfo)paramFromServiceMsg.get(j));
            if ((!bool3) || (paramToServiceMsg.taskId == i)) {
              ((List)localObject).add(paramToServiceMsg);
            }
            j += 1;
          }
        }
        paramToServiceMsg = null;
        paramFromServiceMsg = paramObject;
        if (localRspBody.rpt_unfinished_redpoint.has()) {
          paramFromServiceMsg = localRspBody.rpt_unfinished_redpoint.get();
        }
        paramObject = paramToServiceMsg;
        bool1 = bool2;
        if (paramFromServiceMsg != null)
        {
          paramObject = paramToServiceMsg;
          bool1 = bool2;
          if (paramFromServiceMsg.size() > 0)
          {
            a(paramFromServiceMsg, bool3);
            bool1 = true;
            paramObject = paramToServiceMsg;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handlePullRedTouch failed:");
          paramToServiceMsg.append(j);
          QLog.i("RedtouchHandler", 2, paramToServiceMsg.toString());
        }
        paramObject = null;
        bool1 = bool2;
      }
      localLocalRedTouchManager.a(paramObject, bool1);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handleReportTouchClick");
    }
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("redPointId", 0);
      if (parseOIDBPkg(paramFromServiceMsg, paramObject, new cmd0x6ce.RspBody()) == 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleReportTouchClick success. taskId:");
          paramToServiceMsg.append(i);
          QLog.i("RedtouchHandler", 2, paramToServiceMsg.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleReportTouchClick faild. taskId:");
        paramToServiceMsg.append(i);
        QLog.i("RedtouchHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "getRedPointConfigs(), client version : 8.8.17");
    }
    cmd0x6f5.ReqBody localReqBody = new cmd0x6f5.ReqBody();
    localReqBody.uint32_qq_platform.set(1);
    localReqBody.str_qq_version.set("8.8.17");
    sendPbReq(makeOIDBPkg("OidbSvc.cmd0x6f5", 1781, 0, localReqBody.toByteArray()));
  }
  
  public void a(List<cmd0x6ce.ReadRedpointReq> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportRedTouchClick, redPointId=");
      ((StringBuilder)localObject).append(((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
      QLog.i("RedtouchHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x6ce.ReqBody();
    ((cmd0x6ce.ReqBody)localObject).rpt_msg_read_req.set(paramList);
    localObject = makeOIDBPkg("OidbSvc.cmd0x6ce", 1742, 0, ((cmd0x6ce.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("redPointId", ((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(List<cmd0x6cd.PullRedpointReq> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pullRedTouch, list size=");
      if (paramList == null) {
        localObject = "";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", isSingleTask=");
      localStringBuilder.append(paramBoolean);
      QLog.i("RedtouchHandler", 2, localStringBuilder.toString());
    }
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      localObject = new cmd0x6cd.ReqBody();
      if (paramBoolean) {
        ((cmd0x6cd.ReqBody)localObject).msg_pull_single_task.set((MessageMicro)paramList.get(0));
      } else {
        ((cmd0x6cd.ReqBody)localObject).rpt_last_pull_redpoint.set(paramList);
      }
      ((cmd0x6cd.ReqBody)localObject).uint32_ret_msg_rec.set(1);
      localObject = makeOIDBPkg("OidbSvc.cmd0x6cd", 1741, 0, ((cmd0x6cd.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("is_single_task", paramBoolean);
      if (paramBoolean) {
        ((ToServiceMsg)localObject).extraData.putInt("task_id", ((cmd0x6cd.PullRedpointReq)paramList.get(0)).uint32_taskid.get());
      }
      super.sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.cmd0x6f5");
      this.allowCmdSet.add("OidbSvc.cmd0x6cd");
      this.allowCmdSet.add("OidbSvc.cmd0x6ce");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.cmd0x6cd".equals(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.cmd0x6ce".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.cmd0x6f5".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedtouchHandler
 * JD-Core Version:    0.7.0.1
 */