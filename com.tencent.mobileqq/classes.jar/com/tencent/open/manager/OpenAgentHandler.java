package com.tencent.open.manager;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.GrantReq;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.ReqBody;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.RevokeReq;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.RspBody;
import tencent.im.oidb.oidb_0xc05.GetAuthAppListReq;
import tencent.im.oidb.oidb_0xc05.GetAuthAppListRsp;
import tencent.im.oidb.oidb_0xc05.ReqBody;
import tencent.im.oidb.oidb_0xc05.RspBody;
import tencent.im.oidb.oidb_0xccd.ReqBody;
import tencent.im.oidb.oidb_0xccd.Result;
import tencent.im.oidb.oidb_0xccd.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqconnect.Appinfo;

public final class OpenAgentHandler
  extends BusinessHandler
{
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private final List<qqconnect.Appinfo> jdField_a_of_type_JavaUtilList = new ArrayList(10);
  private final List<AppInfo> b = new ArrayList(10);
  
  public OpenAgentHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new oidb_0xc05.ReqBody();
    Object localObject2 = new oidb_0xc05.GetAuthAppListReq();
    ((oidb_0xc05.GetAuthAppListReq)localObject2).start.set(paramInt1);
    ((oidb_0xc05.GetAuthAppListReq)localObject2).limit.set(paramInt2);
    ((oidb_0xc05.ReqBody)localObject1).get_auth_app_list_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3077);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xc05.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xc05");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("req_index", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("req_page_size", paramInt2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = 1;
    paramFromServiceMsg = "";
    Object localObject1 = paramFromServiceMsg;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList");
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])paramObject);
      }
      catch (Exception localException)
      {
        paramObject = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed pkg failed", localException);
          paramObject = localObject1;
        }
      }
      i = -1;
      if (paramObject.uint32_result.has()) {
        i = paramObject.uint32_result.get();
      }
      localObject1 = paramFromServiceMsg;
      if (i == 0)
      {
        localObject1 = paramFromServiceMsg;
        if (paramObject.bytes_bodybuffer.has())
        {
          localObject1 = paramFromServiceMsg;
          if (paramObject.bytes_bodybuffer.get() != null)
          {
            Object localObject2 = new oidb_0xc05.RspBody();
            try
            {
              ((oidb_0xc05.RspBody)localObject2).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              i = 1;
            }
            catch (Exception paramObject)
            {
              if (QLog.isColorLevel()) {
                QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", paramObject);
              }
              i = 0;
            }
            localObject1 = paramFromServiceMsg;
            if (i != 0)
            {
              if (((oidb_0xc05.RspBody)localObject2).wording.has()) {
                paramFromServiceMsg = ((oidb_0xc05.RspBody)localObject2).wording.get();
              }
              localObject1 = paramFromServiceMsg;
              if (((oidb_0xc05.RspBody)localObject2).get_auth_app_list_rsp.has())
              {
                paramObject = ((oidb_0xc05.RspBody)localObject2).get_auth_app_list_rsp;
                localObject2 = paramObject.appinfos.get();
                localObject1 = paramFromServiceMsg;
                if (localObject2 != null)
                {
                  this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
                  int k = paramToServiceMsg.extraData.getInt("req_index");
                  int m = paramToServiceMsg.extraData.getInt("req_page_size");
                  i = paramObject.total_count.get();
                  k += m;
                  if (k <= i)
                  {
                    a(k, 10);
                    i = j;
                    break label420;
                  }
                  paramToServiceMsg = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
                  paramObject = this.jdField_a_of_type_JavaUtilList.iterator();
                  while (paramObject.hasNext()) {
                    paramToServiceMsg.add(new AppInfo((qqconnect.Appinfo)paramObject.next()));
                  }
                  this.jdField_a_of_type_JavaUtilList.clear();
                  notifyUI(0, true, paramToServiceMsg);
                  i = j;
                  break label420;
                }
              }
            }
          }
        }
      }
    }
    int i = 0;
    paramFromServiceMsg = (FromServiceMsg)localObject1;
    label420:
    if (i == 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyUI(0, false, paramFromServiceMsg);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize");
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize, parsed pkg failed", paramObject);
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
      }
      i = -1;
      if (paramFromServiceMsg.uint32_result.has()) {
        i = paramFromServiceMsg.uint32_result.get();
      }
      if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramObject = new oidb_0xccd.RspBody();
        try
        {
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = 1;
        }
        catch (Exception paramFromServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", paramFromServiceMsg);
          }
          i = 0;
        }
        if ((i != 0) && (paramObject.errcode.get() == 0))
        {
          paramFromServiceMsg = new ArrayList(this.b.size());
          paramObject = paramObject.Results.get();
          if ((paramObject != null) && (!paramObject.isEmpty()))
          {
            paramObject = paramObject.iterator();
            while (paramObject.hasNext())
            {
              localObject = (oidb_0xccd.Result)paramObject.next();
              if (((oidb_0xccd.Result)localObject).errcode.get() == 0)
              {
                i = ((oidb_0xccd.Result)localObject).uint32_appid.get();
                localObject = this.b.iterator();
                while (((Iterator)localObject).hasNext())
                {
                  AppInfo localAppInfo = (AppInfo)((Iterator)localObject).next();
                  if (localAppInfo.a() == i) {
                    paramFromServiceMsg.add(localAppInfo);
                  }
                }
              }
            }
            notifyUI(paramToServiceMsg, 1, true, paramFromServiceMsg);
            this.b.clear();
            i = 1;
            break label348;
          }
        }
      }
    }
    int i = 0;
    label348:
    if (i == 0)
    {
      this.b.clear();
      notifyUI(paramToServiceMsg, 1, false, "");
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("OpenAgentHandler", 1, new Object[] { "onHandleAuthItemF26 success=", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
    OpenAgentHandler.AuthItemResult localAuthItemResult = new OpenAgentHandler.AuthItemResult();
    Object localObject = paramToServiceMsg.getAttributes().get("auth_type");
    int i;
    if ((localObject instanceof Integer)) {
      i = ((Integer)localObject).intValue();
    } else {
      i = 0;
    }
    localAuthItemResult.jdField_a_of_type_Int = i;
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (!paramFromServiceMsg.uint32_result.has())
      {
        notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
        return;
      }
      if (paramFromServiceMsg.uint32_result.get() != 0)
      {
        localAuthItemResult.b = paramFromServiceMsg.uint32_result.get();
        localAuthItemResult.jdField_a_of_type_JavaLangString = paramFromServiceMsg.str_error_msg.get();
        notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
        return;
      }
      if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
        try
        {
          paramObject = new oidb_0xf26.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          localAuthItemResult.jdField_a_of_type_TencentImOidbCmd0xf26Oidb_0xf26$RspBody = paramObject;
          notifyUI(paramToServiceMsg, 2, true, localAuthItemResult);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.e("OpenAgentHandler", 1, "onHandleAuthItemF26, parsed pkg failed", paramFromServiceMsg);
          notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
          return;
        }
      }
      notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.e("OpenAgentHandler", 1, "onHandleAuthItemF26, parsed pkg failed", paramFromServiceMsg);
      notifyUI(paramToServiceMsg, 2, false, localAuthItemResult);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAgentHandler", 2, "getAuthorizedAppList");
    }
    a(0, 10);
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, int paramInt3, String paramString1, String paramString2, OpenAgentObserver paramOpenAgentObserver)
  {
    QLog.d("OpenAgentHandler", 1, new Object[] { "operateAuthItem appId=", Integer.valueOf(paramInt1), ", type=", Integer.valueOf(paramInt2), ", source=", Integer.valueOf(paramInt3) });
    oidb_0xf26.ReqBody localReqBody = new oidb_0xf26.ReqBody();
    localReqBody.appid.set(paramInt1);
    localReqBody.app_type.set(1);
    localReqBody.source_from.set(paramInt3);
    if (paramInt3 == 1)
    {
      localReqBody.openid.set(paramString1);
      localReqBody.openkey.set(paramString2);
    }
    if (paramInt2 == 2)
    {
      paramString1 = new oidb_0xf26.GrantReq();
      paramString1.auth_group_id.set(paramList);
      localReqBody.grant_req.set(paramString1);
    }
    else if (paramInt2 == 3)
    {
      paramString1 = new oidb_0xf26.RevokeReq();
      paramString1.auth_group_id.set(paramList);
      localReqBody.revoke_req.set(paramString1);
    }
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(3878);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(paramInt2);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString1 = createToServiceMsg("OidbSvc.0xf26", paramOpenAgentObserver);
    paramString1.putWupBuffer(paramList.toByteArray());
    paramString1.getAttributes().put("auth_type", Integer.valueOf(paramInt2));
    sendPbReq(paramString1);
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, OpenAgentObserver paramOpenAgentObserver)
  {
    a(paramInt1, paramInt2, paramList, 0, "", "", paramOpenAgentObserver);
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, String paramString1, String paramString2, OpenAgentObserver paramOpenAgentObserver)
  {
    a(paramInt1, paramInt2, paramList, 1, paramString1, paramString2, paramOpenAgentObserver);
  }
  
  public void a(List<AppInfo> paramList, OpenAgentObserver paramOpenAgentObserver)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteAppAuthorize, size=");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("OpenAgentHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList(paramList.size());
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AppInfo localAppInfo = (AppInfo)((Iterator)localObject2).next();
      if (localAppInfo.a() > 0) {
        ((List)localObject1).add(Integer.valueOf(localAppInfo.a()));
      }
    }
    localObject2 = new oidb_0xccd.ReqBody();
    ((oidb_0xccd.ReqBody)localObject2).uint32_appids.set((List)localObject1);
    ((oidb_0xccd.ReqBody)localObject2).platform.set(1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3277);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xccd.ReqBody)localObject2).toByteArray()));
    paramOpenAgentObserver = createToServiceMsg("OidbSvc.0xccd", paramOpenAgentObserver);
    paramOpenAgentObserver.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    this.b.addAll(paramList);
    sendPbReq(paramOpenAgentObserver);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xc05");
      this.allowCmdSet.add("OidbSvc.0xccd");
      this.allowCmdSet.add("OidbSvc.0xf26");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return OpenAgentObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("OpenAgentHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0xc05".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xccd".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xf26".equals(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.manager.OpenAgentHandler
 * JD-Core Version:    0.7.0.1
 */