package com.tencent.mobileqq.nearby.redtouch;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs");
    }
    paramToServiceMsg = new cmd0x6f5.RspBody();
    int i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs, errCode=" + i);
    }
    if ((i == 0) && (paramToServiceMsg.str_config_version.has()))
    {
      paramFromServiceMsg = paramToServiceMsg.str_config_version.get();
      if (QLog.isColorLevel()) {
        QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs, server configVersion=" + paramFromServiceMsg);
      }
      if (!TextUtils.isEmpty(paramFromServiceMsg))
      {
        paramObject = (LocalRedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if (paramObject != null)
        {
          paramObject.a(paramFromServiceMsg);
          paramObject.a(paramToServiceMsg);
          paramObject.a();
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    RedTouchItem localRedTouchItem = null;
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handlePullRedTouch");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("is_single_task", false);
    if (bool4) {}
    label164:
    label345:
    for (int i = paramToServiceMsg.extraData.getInt("task_id");; i = 0)
    {
      cmd0x6cd.RspBody localRspBody = new cmd0x6cd.RspBody();
      int j = a(paramFromServiceMsg, paramObject, localRspBody);
      paramObject = (LocalRedTouchManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159);
      if (paramObject == null) {
        break;
      }
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RedtouchHandler", 2, "handlePullRedTouch success.");
        }
        if (localRspBody.rpt_msg_redpoint.has())
        {
          paramToServiceMsg = localRspBody.rpt_msg_redpoint.get();
          if (paramToServiceMsg == null) {
            break label345;
          }
          paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
          j = 0;
          if (j >= paramToServiceMsg.size()) {
            break label232;
          }
          localRedTouchItem = RedTouchItem.getRedTouchItem((cmd0x6cd.RedpointInfo)paramToServiceMsg.get(j));
          if ((!bool4) || (localRedTouchItem.taskId == i)) {
            break label220;
          }
        }
        for (;;)
        {
          j += 1;
          break label164;
          paramToServiceMsg = null;
          break;
          label220:
          paramFromServiceMsg.add(localRedTouchItem);
        }
      }
      label232:
      for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
      {
        paramFromServiceMsg = localObject;
        if (localRspBody.rpt_unfinished_redpoint.has()) {
          paramFromServiceMsg = localRspBody.rpt_unfinished_redpoint.get();
        }
        boolean bool1 = bool2;
        if (paramFromServiceMsg != null)
        {
          bool1 = bool2;
          if (paramFromServiceMsg.size() > 0)
          {
            bool1 = true;
            a(paramFromServiceMsg, bool4);
          }
        }
        for (;;)
        {
          paramObject.a(paramToServiceMsg, bool1);
          return;
          bool1 = bool3;
          paramToServiceMsg = localRedTouchItem;
          if (QLog.isColorLevel())
          {
            QLog.i("RedtouchHandler", 2, "handlePullRedTouch failed:" + j);
            bool1 = bool3;
            paramToServiceMsg = localRedTouchItem;
          }
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "handleReportTouchClick");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramToServiceMsg.extraData.getInt("redPointId", 0);
        if (a(paramFromServiceMsg, paramObject, new cmd0x6ce.RspBody()) != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("RedtouchHandler", 2, "handleReportTouchClick success. taskId:" + i);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("RedtouchHandler", 2, "handleReportTouchClick faild. taskId:" + i);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.cmd0x6cd".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.cmd0x6ce".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.cmd0x6f5".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "reportRedTouchClick, redPointId=" + ((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
    }
    Object localObject = new cmd0x6ce.ReqBody();
    ((cmd0x6ce.ReqBody)localObject).rpt_msg_read_req.set(paramList);
    localObject = a("OidbSvc.cmd0x6ce", 1742, 0, ((cmd0x6ce.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("redPointId", ((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("pullRedTouch, list size=");
      if (paramList != null) {
        break label66;
      }
    }
    label66:
    for (Object localObject = "";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("RedtouchHandler", 2, localObject + ", isSingleTask=" + paramBoolean);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      return;
    }
    localObject = new cmd0x6cd.ReqBody();
    if (paramBoolean) {
      ((cmd0x6cd.ReqBody)localObject).msg_pull_single_task.set((MessageMicro)paramList.get(0));
    }
    for (;;)
    {
      ((cmd0x6cd.ReqBody)localObject).uint32_ret_msg_rec.set(1);
      localObject = a("OidbSvc.cmd0x6cd", 1741, 0, ((cmd0x6cd.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("is_single_task", paramBoolean);
      if (paramBoolean) {
        ((ToServiceMsg)localObject).extraData.putInt("task_id", ((cmd0x6cd.PullRedpointReq)paramList.get(0)).uint32_taskid.get());
      }
      super.b((ToServiceMsg)localObject);
      return;
      ((cmd0x6cd.ReqBody)localObject).rpt_last_pull_redpoint.set(paramList);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6f5");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6cd");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6ce");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedtouchHandler", 2, "getRedPointConfigs(), client version : 7.6.0");
    }
    cmd0x6f5.ReqBody localReqBody = new cmd0x6f5.ReqBody();
    localReqBody.uint32_qq_platform.set(1);
    localReqBody.str_qq_version.set("7.6.0");
    b(a("OidbSvc.cmd0x6f5", 1781, 0, localReqBody.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedtouchHandler
 * JD-Core Version:    0.7.0.1
 */