package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class OnlineStatusPermissionServlet
  extends MSFServlet
{
  public static NewIntent a(AppRuntime paramAppRuntime, long paramLong, int paramInt, List<Long> paramList, ArrayList<Integer> paramArrayList, @NonNull Bundle paramBundle)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OnlineStatusPermissionServlet.class);
    localNewIntent.putExtra("param_online_status_request", 2);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    localNewIntent.putExtra("param_has_all_permission", paramInt);
    int j = 0;
    int i;
    if (paramList != null)
    {
      long[] arrayOfLong = new long[paramList.size()];
      i = 0;
      while (i < arrayOfLong.length)
      {
        arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
        i += 1;
      }
      localNewIntent.putExtra("param_part_permission_list", arrayOfLong);
    }
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        i = j;
      } else {
        i = paramList.size();
      }
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "hasAllPermission flag=", Integer.valueOf(paramInt), " partPermissionList=", Integer.valueOf(i) });
    }
    localNewIntent.putExtra("param_extra_bundle", paramBundle);
    localNewIntent.putIntegerArrayListExtra("param_smart_status_list", paramArrayList);
    paramAppRuntime.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public static NewIntent a(AppRuntime paramAppRuntime, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "requestOnlineStatusPermission | onlineStatusType = ", Long.valueOf(paramLong) });
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OnlineStatusPermissionServlet.class);
    localNewIntent.putExtra("param_online_status_request", 1);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    localNewIntent.putExtra("param_fetch_only_smart_devices", paramBoolean1);
    localNewIntent.putExtra("from_register", paramBoolean2);
    paramAppRuntime.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public static NewIntent a(AppRuntime paramAppRuntime, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    int i;
    if (paramOnlineStatusPermissionItem != null)
    {
      if (paramOnlineStatusPermissionItem.isAllHasPermission()) {
        i = 1;
      } else {
        i = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "modifySmartOnlineStatusPermission flag=", Integer.valueOf(i), " size=", Integer.valueOf(paramOnlineStatusPermissionItem.getPermissionUins().size()) });
      }
    }
    else
    {
      i = 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_need_switch_online_status", paramBoolean);
    localBundle.putInt("StatusId", 40001);
    if (paramOnlineStatusPermissionItem == null) {
      paramOnlineStatusPermissionItem = null;
    } else {
      paramOnlineStatusPermissionItem = paramOnlineStatusPermissionItem.getPermissionUins();
    }
    return a(paramAppRuntime, 40001L, i, paramOnlineStatusPermissionItem, paramArrayList, localBundle);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    Bundle localBundle = paramIntent.getBundleExtra("param_extra_bundle");
    if (paramFromServiceMsg.isSuccess())
    {
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          Object localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject2);
          ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = localObject1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = localInvalidProtocolBufferMicroException2;
        }
        localFromServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramFromServiceMsg = null;
      }
      FromServiceMsg localFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission parseFrom byte", localInvalidProtocolBufferMicroException1);
        localFromServiceMsg = paramFromServiceMsg;
      }
      int i = localFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | result = ", Integer.valueOf(i) });
      }
      if (i == 0)
      {
        a(getAppRuntime(), paramIntent);
        bool1 = localBundle.getBoolean("param_need_switch_online_status", false);
        i = localBundle.getInt("StatusId", 0);
        if (bool1) {
          ((IOnlineStatusService)getAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, i);
        }
        bool1 = true;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleModifyOnlineStatusPermission | response.result = ");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        QLog.d("OnlineStatusPermissionServlet", 2, localStringBuilder.toString());
      }
      bool1 = false;
    }
    notifyObserver(paramIntent, 2, bool1, localBundle, OnlineStatusPermissionObserver.class);
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    int i = paramIntent.getIntExtra("param_has_all_permission", 0);
    Object localObject = paramIntent.getLongArrayExtra("param_part_permission_list");
    ArrayList localArrayList1 = paramIntent.getIntegerArrayListExtra("param_smart_status_list");
    paramIntent = new cmd0xe62.ReqBody();
    if ((i == 1) || (i == 2))
    {
      paramIntent.set_type.set(i);
      if (localObject != null)
      {
        ArrayList localArrayList2 = new ArrayList(localObject.length);
        i = 0;
        while (i < localObject.length)
        {
          localArrayList2.add(Long.valueOf(localObject[i]));
          i += 1;
        }
        paramIntent.rpt_uint64_uin.set(localArrayList2);
      }
    }
    if (localArrayList1 != null)
    {
      if (localArrayList1.size() > 0) {
        bool1 = false;
      }
      paramIntent.bool_clear_smart_status.set(bool1);
      paramIntent.rpt_uint32_smart_status.set(localArrayList1);
    }
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3682);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe63_1");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    int i = 0;
    int j = paramIntent.getIntExtra("param_has_all_permission", 0);
    long[] arrayOfLong = paramIntent.getLongArrayExtra("param_part_permission_list");
    ArrayList localArrayList = paramIntent.getIntegerArrayListExtra("param_smart_status_list");
    boolean bool = true;
    if ((j == 1) || (j == 2))
    {
      if (j != 1) {
        bool = false;
      }
      paramAppRuntime = null;
      if (arrayOfLong != null)
      {
        paramIntent = new ArrayList(arrayOfLong.length);
        for (;;)
        {
          paramAppRuntime = paramIntent;
          if (i >= arrayOfLong.length) {
            break;
          }
          paramIntent.add(Long.valueOf(arrayOfLong[i]));
          i += 1;
        }
      }
      localOnlineStatusPermissionManager.a(new OnlineStatusFriendsPermissionItem(bool, paramAppRuntime));
    }
    if (localArrayList != null) {
      localOnlineStatusPermissionManager.a(localArrayList);
    }
  }
  
  private void a(oidb_cmd0xe63.RspBody paramRspBody)
  {
    boolean bool1;
    if (paramRspBody.bool_online_status_visible_to_all_frd.has())
    {
      boolean bool2 = paramRspBody.bool_online_status_visible_to_all_frd.get();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.allHasPermission = ", Boolean.valueOf(bool2) });
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = true;
    }
    Object localObject2 = null;
    Object localObject1;
    if (paramRspBody.rpt_uint64_uin_can_see_my_online_status.has())
    {
      if (paramRspBody.rpt_uint64_uin_can_see_my_online_status.get() == null) {
        localObject1 = new ArrayList(0);
      } else {
        localObject1 = paramRspBody.rpt_uint64_uin_can_see_my_online_status.get();
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.hasPermissionList.size=", Integer.valueOf(((List)localObject1).size()) });
        localObject2 = localObject1;
      }
    }
    if (paramRspBody.rpt_uint32_smart_status.has())
    {
      if (paramRspBody.rpt_uint32_smart_status.get() == null) {
        paramRspBody = new ArrayList(0);
      } else {
        paramRspBody = paramRspBody.rpt_uint32_smart_status.get();
      }
      localObject1 = paramRspBody;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.smartSelectedStatusList.size=", Integer.valueOf(paramRspBody.size()) });
        localObject1 = paramRspBody;
      }
    }
    else
    {
      localObject1 = new ArrayList(0);
    }
    if ((!bool1) && (((List)localObject1).size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, "saveReceiveData | params is error");
      }
      return;
    }
    paramRspBody = (OnlineStatusPermissionManager)((IOnlineStatusManagerService)getAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    localObject2 = new OnlineStatusFriendsPermissionItem(bool1, (List)localObject2);
    paramRspBody.a((List)localObject1);
    paramRspBody.a((OnlineStatusFriendsPermissionItem)localObject2);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    boolean bool2 = false;
    boolean bool1 = paramIntent.getBooleanExtra("from_register", false);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_register", bool1);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    Object localObject2;
    if (paramFromServiceMsg.isSuccess())
    {
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          Object localObject3 = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject3);
          ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject3);
          localObject3 = localObject1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = localInvalidProtocolBufferMicroException2;
        }
        localFromServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramFromServiceMsg = null;
      }
      FromServiceMsg localFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission parseFrom byte", localInvalidProtocolBufferMicroException1);
        localFromServiceMsg = paramFromServiceMsg;
      }
      int i = localFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | result = ", Integer.valueOf(i) });
      }
      bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (localFromServiceMsg.bytes_bodybuffer.has())
        {
          bool1 = bool2;
          if (localFromServiceMsg.bytes_bodybuffer.get() != null)
          {
            paramFromServiceMsg = localFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            try
            {
              localObject2 = new oidb_cmd0xe63.RspBody();
              ((oidb_cmd0xe63.RspBody)localObject2).mergeFrom(paramFromServiceMsg);
              a((oidb_cmd0xe63.RspBody)localObject2);
              bool1 = true;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission erro ", paramFromServiceMsg);
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleOnlineStatusPermission | response.result = ");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getResultCode());
        QLog.d("OnlineStatusPermissionServlet", 2, ((StringBuilder)localObject2).toString());
      }
      bool1 = false;
    }
    notifyObserver(paramIntent, 1, bool1, localBundle, OnlineStatusPermissionObserver.class);
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    boolean bool = paramIntent.getBooleanExtra("param_fetch_only_smart_devices", false);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l), "onlySmartDevices = ", Boolean.valueOf(bool) });
    }
    paramIntent = new oidb_cmd0xe63.ReqBody();
    paramIntent.uint32_req_type.set(1);
    paramIntent.bool_only_smart_status.set(bool);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3683);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe63_1");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnlineStatusPermissionServlet onReceive:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" is ");
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = "not";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" success");
      QLog.d("OnlineStatusPermissionServlet", 2, localStringBuilder.toString());
    }
    if (str2 != null)
    {
      if (!str2.equals("OidbSvc.0xe63_1")) {
        return;
      }
      int i = paramIntent.getIntExtra("param_online_status_request", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onReceive reqType", Integer.valueOf(i) });
      }
      if (i == 1)
      {
        b(paramIntent, paramFromServiceMsg);
        return;
      }
      if (i == 2) {
        a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("param_online_status_request", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onSend reqType", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      b(paramIntent, paramPacket);
      return;
    }
    if (i == 2) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet
 * JD-Core Version:    0.7.0.1
 */