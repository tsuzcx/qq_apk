package com.tencent.mobileqq.leba.core;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.ReqGetUserDynamicPlugin;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.ReqSetUserDynamicPlugin;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.RspGetUserDynamicPlugin;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.RspSetUserDynamicPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.BatchSetSettingReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.BatchSetSettingRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CommPluginHandler
  extends BusinessHandler
{
  private AppInterface a;
  protected boolean a;
  
  public CommPluginHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public LebaHelper a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null)
    {
      QLog.e("CommPluginHandler", 1, "getLebaHelper isEmpty appInterface = null");
      return null;
    }
    paramAppInterface = ((ILebaHelperService)paramAppInterface.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
    if (paramAppInterface == null)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getLebaHelper isEmpty method = ");
      paramAppInterface.append(paramString);
      QLog.e("CommPluginHandler", 1, paramAppInterface.toString());
      return null;
    }
    return (LebaHelper)paramAppInterface;
  }
  
  public void a()
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "getAllPluginList");
    if (localObject == null) {
      return;
    }
    localObject = ((LebaHelper)localObject).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    a(localArrayList);
    b();
    boolean bool = LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAllPluginList isNeedReqHasClosedFlag");
    ((StringBuilder)localObject).append(bool);
    QLog.i("CommPluginHandler", 1, ((StringBuilder)localObject).toString());
    if (bool) {
      a(true);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleGetPluginUserSort ");
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append("|");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        bool1 = bool2;
        break label311;
      }
      paramFromServiceMsg = new UserDynamicPlugin.RspGetUserDynamicPlugin();
    }
    for (;;)
    {
      try
      {
        paramObject = (UserDynamicPlugin.RspGetUserDynamicPlugin)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramObject.ret.has()) {
          break label360;
        }
        paramFromServiceMsg = Integer.valueOf(paramObject.ret.get());
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.intValue();
          if (i == 0) {
            try
            {
              if (!paramObject.plugin_id.has()) {
                break label365;
              }
              paramFromServiceMsg = paramObject.plugin_id.get();
              if (!paramObject.last_time.has()) {
                break label370;
              }
              l = paramObject.last_time.get();
              if (!paramObject.plugin_type.has()) {
                break label376;
              }
              i = paramObject.plugin_type.get();
              a(paramFromServiceMsg, l, i, localStringBuilder);
              localStringBuilder.append(" info = ");
              localStringBuilder.append(paramFromServiceMsg);
              localStringBuilder.append(" lastTime = ");
              localStringBuilder.append(l);
              localStringBuilder.append(" pluginType = ");
              localStringBuilder.append(i);
              bool1 = true;
            }
            catch (Exception paramFromServiceMsg)
            {
              bool1 = true;
              continue;
            }
          }
        }
        localStringBuilder.append("ret = ");
        localStringBuilder.append(paramFromServiceMsg);
        bool1 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_sort", 1, "handleGetPluginUserSort", paramFromServiceMsg);
      }
      localStringBuilder.append("res == null || data == null");
      bool1 = bool2;
      label311:
      localStringBuilder.append(", isSuc=");
      localStringBuilder.append(bool1);
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      paramFromServiceMsg = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleGetPluginUserSort");
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(bool1);
      }
      return;
      label360:
      paramFromServiceMsg = null;
      continue;
      label365:
      paramFromServiceMsg = null;
      continue;
      label370:
      long l = 0L;
      continue;
      label376:
      int i = 0;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommPluginHandler", 2, "handleBatchGetPluginList");
    }
    LebaHelper localLebaHelper = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleBatchGetPluginList");
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
          break label553;
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
        QLog.d("CommPluginHandler", 1, paramObject.toString());
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
        break label435;
      }
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
      if (!localBatchGetResourceResp.resp_list.has()) {
        break label570;
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
              if (paramObject.plugin_type.get() != 4000)
              {
                paramFromServiceMsg = paramToServiceMsg;
                j = i;
                if (paramObject.plugin_type.get() != 4026) {}
              }
              else if (localLebaHelper != null)
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
      QLog.d("CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
      bool3 = false;
      k = i;
      paramObject = paramToServiceMsg;
      label435:
      if ((bool3) && (bool2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((!bool1) && (localLebaHelper != null)) {
        localLebaHelper.a(false, null);
      }
      QLog.d("CommPluginHandler", 1, new Object[] { "handleBatchGetPluginList finalResult:", Boolean.valueOf(bool1), ",ssoSuc=", Boolean.valueOf(bool2), ",busiSuc=", Boolean.valueOf(bool3), ",busiErrCode=", Integer.valueOf(k), ",errMsg=", paramObject });
      return;
      label553:
      if (i == 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label570:
      paramObject = null;
    }
  }
  
  public void a(ArrayList<BusinessInfoCheckUpdate.AppSetting> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    BusinessInfoCheckUpdate.BatchSetSettingReqBody localBatchSetSettingReqBody = new BusinessInfoCheckUpdate.BatchSetSettingReqBody();
    StringBuilder localStringBuilder = new StringBuilder("batchClosePlugin ");
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject == null)
    {
      localStringBuilder.append(",app == null");
    }
    else
    {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
      try
      {
        localBatchSetSettingReqBody.uiUin.set(Long.parseLong((String)localObject));
      }
      catch (Exception localException)
      {
        QLog.e("CommPluginHandler", 1, localException, new Object[0]);
      }
    }
    localBatchSetSettingReqBody.uiClientPlatID.set(109);
    localBatchSetSettingReqBody.sClientVer.set("8.7.0.5295");
    localBatchSetSettingReqBody.rptSetting.addAll(paramArrayList);
    paramArrayList = createToServiceMsg("RedTouchSvc.BatchSetSetting");
    paramArrayList.putWupBuffer(localBatchSetSettingReqBody.toByteArray());
    sendPbReq(paramArrayList);
    QLog.i("leba_study", 1, localStringBuilder.toString());
  }
  
  protected void a(List<PluginConfig.GetResourceReq> paramList)
  {
    QLog.i("CommPluginHandler", 1, "batchGetPluginList");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
      PluginConfig.BatchGetResourceReq localBatchGetResourceReq = new PluginConfig.BatchGetResourceReq();
      localBatchGetResourceReq.req_list.set(paramList);
      localToServiceMsg.putWupBuffer(localBatchGetResourceReq.toByteArray());
      localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      sendPbReq(localToServiceMsg);
      return;
    }
    QLog.i("CommPluginHandler", 1, "batchGetPluginList return for req_list is empty");
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt)
  {
    Object localObject2 = new StringBuilder("setPluginUserSort data= ");
    ((StringBuilder)localObject2).append(paramList);
    ((StringBuilder)localObject2).append(",time=");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(",type=");
    ((StringBuilder)localObject2).append(paramInt);
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null)
    {
      ((StringBuilder)localObject2).append(" app == null");
      localObject1 = "";
    }
    else
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
    }
    QLog.i("leba_sort", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject1, "DynamicPluginSvc.SetList");
    UserDynamicPlugin.ReqSetUserDynamicPlugin localReqSetUserDynamicPlugin = new UserDynamicPlugin.ReqSetUserDynamicPlugin();
    localReqSetUserDynamicPlugin.plugin_id.set(paramList);
    localReqSetUserDynamicPlugin.last_time.set((int)paramLong);
    localReqSetUserDynamicPlugin.plugin_type.set(paramInt);
    ((ToServiceMsg)localObject2).putWupBuffer(localReqSetUserDynamicPlugin.toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("uin", (String)localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt, StringBuilder paramStringBuilder)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject == null)
    {
      paramStringBuilder.append(" app == null");
      return;
    }
    long l = LebaUtil.a((AppRuntime)localObject, paramInt);
    paramStringBuilder.append(" localTime = ");
    paramStringBuilder.append(l);
    if (paramLong >= l)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences();
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      LebaUtil.a(localSharedPreferences, (List)localObject, Long.valueOf(paramLong), paramInt);
      paramStringBuilder.append(" saveUserSortInfo");
      return;
    }
    paramList = LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(paramList, l, paramInt);
      paramStringBuilder.append(" setPluginUserSort, localSort = ");
      paramStringBuilder.append(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleSetPluginUserSort ");
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append("|");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      }
      else
      {
        UserDynamicPlugin.RspSetUserDynamicPlugin localRspSetUserDynamicPlugin = new UserDynamicPlugin.RspSetUserDynamicPlugin();
        paramFromServiceMsg = null;
        try
        {
          paramObject = (UserDynamicPlugin.RspSetUserDynamicPlugin)localRspSetUserDynamicPlugin.mergeFrom((byte[])paramObject);
          if (paramObject.ret.has()) {
            paramFromServiceMsg = Integer.valueOf(paramObject.ret.get());
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.intValue() == 0))
          {
            bool = true;
          }
          else
          {
            localStringBuilder.append("ret = ");
            localStringBuilder.append(paramFromServiceMsg);
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.i("leba_sort", 1, "handleGetPluginUserSort", paramFromServiceMsg);
        }
      }
    }
    else {
      localStringBuilder.append("res == null || data == null");
    }
    localStringBuilder.append(", isSuc=");
    localStringBuilder.append(bool);
    QLog.i("leba_sort", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void b()
  {
    Object localObject2 = new StringBuilder("getPluginUserSort");
    Object localObject1 = (IStudyModeManager)QRoute.api(IStudyModeManager.class);
    boolean bool;
    if (localObject1 != null)
    {
      bool = ((IStudyModeManager)localObject1).getStudyModeSwitch();
    }
    else
    {
      ((StringBuilder)localObject2).append(",studyModeManager == null");
      bool = false;
    }
    int i;
    if (bool) {
      i = 4026;
    } else {
      i = 4000;
    }
    ((StringBuilder)localObject2).append(",pluginType = ");
    ((StringBuilder)localObject2).append(i);
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null)
    {
      ((StringBuilder)localObject2).append(",app == null");
      localObject1 = "";
    }
    else
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
    }
    QLog.i("leba_sort", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject1, "DynamicPluginSvc.GetList");
    UserDynamicPlugin.ReqGetUserDynamicPlugin localReqGetUserDynamicPlugin = new UserDynamicPlugin.ReqGetUserDynamicPlugin();
    localReqGetUserDynamicPlugin.platform.set(2);
    localReqGetUserDynamicPlugin.plugin_type.set(i);
    ((ToServiceMsg)localObject2).putWupBuffer(localReqGetUserDynamicPlugin.toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("uin", (String)localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public boolean b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleGetHasClosePluginFlag ");
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      localStringBuilder.append("resCode = ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(",resSso = ");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append("|res failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label512;
        }
        i = 1;
        paramObject = paramFromServiceMsg.str_error_msg.get();
        localStringBuilder.append(",ssoResult = ");
        localStringBuilder.append(paramFromServiceMsg.uint32_result.get());
        localStringBuilder.append(",resError = ");
        localStringBuilder.append(paramObject);
        if ((i != 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramObject = new oidb_0x5eb.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramObject.rpt_msg_uin_data.size() <= 0)
          {
            localStringBuilder.append(",sso failed rpt_msg_uin_data erroe");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
          {
            localStringBuilder.append(",sso failed app == null");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          i = ((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0)).uint32_has_close_leba_youth_mode_plugin.get();
          localStringBuilder.append(",sso success");
          localStringBuilder.append(",flag=");
          localStringBuilder.append(i);
          if (i != 1) {
            break label517;
          }
          bool1 = true;
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          if (!bool1) {
            break label523;
          }
          i = 2;
          LebaUtil.b(paramFromServiceMsg, i);
          boolean bool2 = LebaUtil.a(LebaUtil.d(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
          localStringBuilder.append(",hasClose=");
          localStringBuilder.append(bool1);
          localStringBuilder.append(",isStudyModel=");
          localStringBuilder.append(bool2);
          if ((!bool1) && (bool2))
          {
            paramFromServiceMsg = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleGetHasClosePluginFlag");
            if (paramFromServiceMsg != null) {
              paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
            }
          }
          QLog.i("leba_study", 1, localStringBuilder.toString());
          return true;
        }
        localStringBuilder.append(",sso failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleGetPluginUserSort", paramFromServiceMsg);
        return false;
      }
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
      label512:
      int i = 0;
      continue;
      label517:
      boolean bool1 = false;
      continue;
      label523:
      i = 1;
    }
  }
  
  public void c()
  {
    Object localObject2 = new oidb_0x5eb.ReqBody();
    StringBuilder localStringBuilder = new StringBuilder("getHasClosePluginFlag");
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null)
    {
      localStringBuilder.append(" app == null");
      localObject1 = "";
    }
    else
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
      try
      {
        long l = Long.parseLong((String)localObject1);
        ((oidb_0x5eb.ReqBody)localObject2).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        QLog.i("leba_study", 1, "getHasClosePluginFlag", localException);
      }
    }
    ((oidb_0x5eb.ReqBody)localObject2).uint32_has_close_leba_youth_mode_plugin.set(1);
    QLog.i("leba_study", 1, localStringBuilder.toString());
    localObject2 = makeOIDBPkg("OidbSvc.0x5eb_42482", 1515, 22, ((oidb_0x5eb.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject2).addAttribute("uin", localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public boolean c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleSetHasClosePluginFlag ");
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      localStringBuilder.append(",resCode = ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(",resSso = ");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",res failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label290;
        }
        i = 1;
        paramObject = paramFromServiceMsg.str_error_msg.get();
        localStringBuilder.append("ssoResult = ");
        localStringBuilder.append(paramFromServiceMsg.uint32_result.get());
        localStringBuilder.append(",resError = ");
        localStringBuilder.append(paramObject);
        if ((i != 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
          localStringBuilder.append(",sso success");
          QLog.i("leba_study", 1, localStringBuilder.toString());
          return true;
        }
        localStringBuilder.append(",sso failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleSetHasClosePluginFlag", paramFromServiceMsg);
        return false;
      }
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
      label290:
      int i = 0;
    }
  }
  
  public boolean d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleBatchClosePlugin ");
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      localStringBuilder.append(",resCode = ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",res failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
      try
      {
        paramFromServiceMsg = (BusinessInfoCheckUpdate.BatchSetSettingRspBody)new BusinessInfoCheckUpdate.BatchSetSettingRspBody().mergeFrom((byte[])paramObject);
        int i = paramFromServiceMsg.iResult.get();
        paramFromServiceMsg = paramFromServiceMsg.sErrMsg.get();
        localStringBuilder.append(",resultCode = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",resError = ");
        localStringBuilder.append(paramFromServiceMsg);
        if (i != 0)
        {
          localStringBuilder.append(",rspBody failed");
          QLog.i("leba_study", 1, localStringBuilder.toString());
          return false;
        }
        paramFromServiceMsg = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleBatchClosePlugin");
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
        localStringBuilder.append(",rspBody success");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return true;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleBatchClosePlugin", paramFromServiceMsg);
        return false;
      }
    }
    localStringBuilder.append("res == null || data == null");
    QLog.i("leba_study", 1, localStringBuilder.toString());
    return false;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
      this.allowCmdSet.add("DynamicPluginSvc.GetList");
      this.allowCmdSet.add("DynamicPluginSvc.SetList");
      this.allowCmdSet.add("OidbSvc.0x5eb_42482");
      this.allowCmdSet.add("OidbSvc.0x4ff_42482");
      this.allowCmdSet.add("RedTouchSvc.BatchSetSetting");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
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
      if ("DynamicPluginSvc.GetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("DynamicPluginSvc.SetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42482".equals(str))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42482".equals(str))
      {
        c(paramFromServiceMsg, paramObject);
        return;
      }
      if ("RedTouchSvc.BatchSetSetting".equals(str)) {
        d(paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.d("CommPluginHandler", 1, "req or res is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.CommPluginHandler
 * JD-Core Version:    0.7.0.1
 */