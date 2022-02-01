package com.tencent.mobileqq.leba.core;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommPluginHandler
  extends BusinessHandler
{
  protected boolean a = false;
  private AppInterface b;
  
  public CommPluginHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = paramAppInterface;
  }
  
  public LebaHelper a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null)
    {
      QLog.e("Leba.CommPluginHandler", 1, "getLebaHelper isEmpty appInterface = null");
      return null;
    }
    paramAppInterface = ((ILebaHelperService)paramAppInterface.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
    if (paramAppInterface == null)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getLebaHelper isEmpty method = ");
      paramAppInterface.append(paramString);
      QLog.e("Leba.CommPluginHandler", 1, paramAppInterface.toString());
      return null;
    }
    return (LebaHelper)paramAppInterface;
  }
  
  public void a()
  {
    LebaPluginLogic.a(this.b);
    Object localObject = a(this.b, "getAllPluginList");
    if (localObject == null) {
      return;
    }
    localObject = ((LebaHelper)localObject).c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    a(localArrayList);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Leba.CommPluginHandler", 2, "handleBatchGetPluginList");
    }
    LebaHelper localLebaHelper = a(this.b, "handleBatchGetPluginList");
    boolean bool2;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject = "";
    int k = -1;
    paramToServiceMsg = (ToServiceMsg)localObject;
    int i = k;
    int j;
    boolean bool1;
    boolean bool3;
    if (bool2)
    {
      paramToServiceMsg = new PluginConfig.BatchGetResourceResp();
      paramFromServiceMsg = (FromServiceMsg)localObject;
      j = k;
      try
      {
        localBatchGetResourceResp = (PluginConfig.BatchGetResourceResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (FromServiceMsg)localObject;
        j = k;
        i = k;
        if (!localBatchGetResourceResp.errcode.has()) {
          break label567;
        }
        paramFromServiceMsg = (FromServiceMsg)localObject;
        j = k;
        i = localBatchGetResourceResp.errcode.get();
      }
      catch (Exception paramToServiceMsg)
      {
        PluginConfig.BatchGetResourceResp localBatchGetResourceResp;
        paramObject = new StringBuilder();
        paramObject.append("handleBatchGetPluginList exp:");
        paramObject.append(paramToServiceMsg.toString());
        QLog.d("Leba.CommPluginHandler", 1, paramObject.toString());
        i = j;
        paramToServiceMsg = paramFromServiceMsg;
      }
      paramToServiceMsg = (ToServiceMsg)localObject;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      j = i;
      if (localBatchGetResourceResp.errmsg.has())
      {
        paramFromServiceMsg = (FromServiceMsg)localObject;
        j = i;
        paramToServiceMsg = localBatchGetResourceResp.errmsg.get();
      }
      paramObject = paramToServiceMsg;
      k = i;
      bool3 = bool1;
      if (!bool1) {
        break label454;
      }
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
      if (!localBatchGetResourceResp.resp_list.has()) {
        break label584;
      }
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
      paramObject = localBatchGetResourceResp.resp_list.get();
    }
    for (;;)
    {
      if (paramObject != null)
      {
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (!paramObject.isEmpty())
        {
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          localObject = paramObject.iterator();
          for (;;)
          {
            paramFromServiceMsg = paramToServiceMsg;
            j = i;
            paramObject = paramToServiceMsg;
            k = i;
            bool3 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramFromServiceMsg = paramToServiceMsg;
            j = i;
            paramObject = (PluginConfig.GetResourceResp)((Iterator)localObject).next();
            if (paramObject != null)
            {
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              if (paramObject.plugin_type.get() != 4034)
              {
                paramFromServiceMsg = paramToServiceMsg;
                j = i;
                if (paramObject.plugin_type.get() != 4032)
                {
                  paramFromServiceMsg = paramToServiceMsg;
                  j = i;
                  if (paramObject.plugin_type.get() != 4033) {
                    continue;
                  }
                }
              }
              if (localLebaHelper != null)
              {
                paramFromServiceMsg = paramToServiceMsg;
                j = i;
                localLebaHelper.a(true, paramObject);
              }
            }
          }
        }
      }
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
      QLog.d("Leba.CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
      bool3 = false;
      k = i;
      paramObject = paramToServiceMsg;
      label454:
      if ((bool3) && (bool2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((!bool1) && (localLebaHelper != null)) {
        localLebaHelper.a(false, null);
      }
      QLog.d("Leba.CommPluginHandler", 1, new Object[] { "handleBatchGetPluginList finalResult:", Boolean.valueOf(bool1), ",ssoSuc=", Boolean.valueOf(bool2), ",busiSuc=", Boolean.valueOf(bool3), ",busiErrCode=", Integer.valueOf(k), ",errMsg=", paramObject });
      return;
      label567:
      if (i == 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label584:
      paramObject = null;
    }
  }
  
  protected void a(List<PluginConfig.GetResourceReq> paramList)
  {
    QLog.i("Leba.CommPluginHandler", 1, "batchGetPluginList");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
      PluginConfig.BatchGetResourceReq localBatchGetResourceReq = new PluginConfig.BatchGetResourceReq();
      localBatchGetResourceReq.req_list.set(paramList);
      localToServiceMsg.putWupBuffer(localBatchGetResourceReq.toByteArray());
      localToServiceMsg.extraData.putString("uin", this.b.getCurrentAccountUin());
      sendPbReq(localToServiceMsg);
      return;
    }
    QLog.i("Leba.CommPluginHandler", 1, "batchGetPluginList return for req_list is empty");
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
      this.allowCmdSet.add("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList");
      this.allowCmdSet.add("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.a = true;
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (!msgCmdFilter(paramFromServiceMsg.getServiceCmd())))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if ("PluginConfig.dynamic_plugin".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList".equals(str))
      {
        LebaPluginLogic.a(this.b, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList".equals(str)) {
        LebaPluginLogic.b(this.b, paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.d("Leba.CommPluginHandler", 1, "req or res is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.CommPluginHandler
 * JD-Core Version:    0.7.0.1
 */