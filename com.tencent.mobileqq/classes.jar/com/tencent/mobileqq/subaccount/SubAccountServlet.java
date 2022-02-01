package com.tencent.mobileqq.subaccount;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.SubAccountObserver;
import tencent.im.oidb.cmd0xe34.cmd0xe34.BindUinInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34.GroupMsgUnreadNumInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34.LoginSig;
import tencent.im.oidb.cmd0xe34.cmd0xe34.ReqBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34.RspBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34.UnReadInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubAccountServlet
  extends MSFServlet
{
  public static NewIntent a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null)
    {
      QLog.d("SubAccountServlet", 2, "app is null");
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchOneTroopNewMsg TIME=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SubAccountServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
    if (localObject != null) {
      localObject = ((ISubAccountService)localObject).getA2(paramString);
    } else {
      localObject = null;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      NewIntent localNewIntent = new NewIntent(paramAppInterface.getApplication(), SubAccountServlet.class);
      localNewIntent.putExtra("key_type", 1);
      localNewIntent.putExtra("key_appid", AppSetting.a());
      ArrayList localArrayList1 = new ArrayList(1);
      localArrayList1.add(paramString);
      ArrayList localArrayList2 = new ArrayList(1);
      localArrayList2.add(localObject);
      localNewIntent.putStringArrayListExtra("key_sub_account", localArrayList1);
      localNewIntent.putStringArrayListExtra("key_sub_acc_sig", localArrayList2);
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountServlet", 2, new Object[] { "fetchOneTroopNewMsg uin:", paramString });
      }
      return localNewIntent;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountServlet", 2, new Object[] { "fetchOneTroopNewMsg uin:", paramString, " no login sig" });
    }
    return null;
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    boolean bool1 = false;
    int i;
    int j;
    if (bool2)
    {
      try
      {
        Object localObject1 = WupUtil.b(paramFromServiceMsg.getWupBuffer());
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom((byte[])localObject1);
        i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        Object localObject3;
        long l1;
        Object localObject4;
        label376:
        long l2;
        if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() != null))
        {
          localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
          localObject2 = new cmd0xe34.RspBody();
          ((cmd0xe34.RspBody)localObject2).mergeFrom((byte[])localObject1);
          localObject1 = (ISubAccountControlService)getAppRuntime().getRuntimeService(ISubAccountControlService.class, "");
          ((ISubAccountControlService)localObject1).setTroopDelayTime(((cmd0xe34.RspBody)localObject2).ReqInterval.get());
          localObject2 = ((cmd0xe34.RspBody)localObject2).rpt_unread_info.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break label748;
            }
            localObject3 = (cmd0xe34.UnReadInfo)((List)localObject2).get(i);
            l1 = ((cmd0xe34.UnReadInfo)localObject3).uint64_uin.get();
            j = ((cmd0xe34.UnReadInfo)localObject3).retcode.get();
            localObject4 = (cmd0xe34.GroupMsgUnreadNumInfo)((cmd0xe34.UnReadInfo)localObject3).group_info.get();
            localBundle.putInt("key_new_msg_time", ((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).last_msg_time.get());
            if (!QLog.isColorLevel()) {
              break label727;
            }
            QLog.d("SubAccountServlet", 2, new Object[] { "subAccount:", Long.valueOf(l1), " msg_num:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).msg_num.get()), " group_num:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).group_num.get()), " last_msg_time:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).last_msg_time.get()), " fetchTroopMsgInterval:", Long.valueOf(((ISubAccountControlService)localObject1).getsTroopDelayTime()), " retCode:", Integer.valueOf(j) });
            break label727;
            localObject3 = new SubAccountMessage();
            ((SubAccountMessage)localObject3).frienduin = String.valueOf(13002L);
            if (((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).msg_num.get() <= 0) {
              break label735;
            }
            j = 1;
            label413:
            ((SubAccountMessage)localObject3).unreadNum = j;
            ((SubAccountMessage)localObject3).msgtype = -1000;
            j = ((cmd0xe34.GroupMsgUnreadNumInfo)localObject4).last_msg_time.get();
            l2 = j;
          }
        }
        try
        {
          ((SubAccountMessage)localObject3).time = l2;
          ((SubAccountMessage)localObject3).senderuin = String.valueOf(13002L);
          ((SubAccountMessage)localObject3).subUin = String.valueOf(l1);
          ((SubAccountMessage)localObject3).istroop = 1;
          ((SubAccountMessage)localObject3).sendername = "群聊消息";
          ((SubAccountMessage)localObject3).msg = "";
          localObject4 = (ISubAccountService)getAppRuntime().getRuntimeService(ISubAccountService.class, "");
          if (localObject4 != null)
          {
            ((ISubAccountService)localObject4).updateTroopMsgRedDot((SubAccountMessage)localObject3);
            ((ISubAccountService)localObject4).addNewMessage((SubAccountMessage)localObject3);
            ((ISubAccountService)localObject4).updateAnotherSubAccountUnreadMsg(((SubAccountMessage)localObject3).subUin);
          }
          localObject3 = new SubAccountBackProtocData();
          ((SubAccountBackProtocData)localObject3).b = paramFromServiceMsg.getUin();
          ((SubAccountBackProtocData)localObject3).jdField_c_of_type_JavaLangString = String.valueOf(l1);
          ((SubAccountBackProtocData)localObject3).jdField_c_of_type_Boolean = true;
          ((SubAccountBackProtocData)localObject3).d = true;
          ((SubAccountBackProtocData)localObject3).a = 0;
          if (MobileQQ.sProcessId != 1) {
            break label741;
          }
          ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).notifyUI(8003, true, localObject3);
        }
        catch (Exception paramFromServiceMsg)
        {
          break label697;
        }
        if (!QLog.isColorLevel()) {
          break label754;
        }
        QLog.d("SubAccountServlet", 2, "unReadInfos is empty");
        break label754;
        if (!QLog.isColorLevel()) {
          break label754;
        }
        bool1 = false;
        QLog.d("SubAccountServlet", 2, new Object[] { "result:", Integer.valueOf(i), " hasBody:", Boolean.valueOf(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) });
      }
      catch (Exception paramFromServiceMsg) {}
      label697:
      QLog.d("SubAccountServlet", 2, paramFromServiceMsg.toString());
      bool1 = false;
    }
    for (;;)
    {
      notifyObserver(paramIntent, 1, bool1, localBundle, SubAccountObserver.class);
      return;
      label727:
      if (j == 0) {
        break label376;
      }
      break label741;
      label735:
      j = 0;
      break label413;
      label741:
      i += 1;
      break;
      label748:
      bool1 = true;
      continue;
      label754:
      bool1 = false;
    }
  }
  
  public void a(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringArrayListExtra("key_sub_account");
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_sub_acc_sig");
    if ((localObject != null) && (((ArrayList)localObject).size() != 0) && (localArrayList != null) && (localArrayList.size() != 0))
    {
      if (localArrayList.size() != ((ArrayList)localObject).size())
      {
        QLog.e("SubAccountServlet", 2, "uin and sig size not right");
        return;
      }
      int j = paramIntent.getIntExtra("key_appid", -1);
      paramIntent = new cmd0xe34.ReqBody();
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        String str = (String)((ArrayList)localObject).get(i);
        cmd0xe34.BindUinInfo localBindUinInfo = new cmd0xe34.BindUinInfo();
        localBindUinInfo.uint32_app_id.set(1001);
        localBindUinInfo.uint32_instance_id.set(j);
        try
        {
          long l = Long.parseLong(str);
          localBindUinInfo.uint64_uin.set(l);
        }
        catch (Exception localException)
        {
          QLog.e("SubAccountServlet", 2, localException.toString());
        }
        cmd0xe34.LoginSig localLoginSig = new cmd0xe34.LoginSig();
        localLoginSig.uint32_appid.set(16);
        localLoginSig.uint32_type.set(8);
        if (!TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
          localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes((String)localArrayList.get(i))));
        }
        localBindUinInfo.msg_login_sig.set(localLoginSig);
        paramIntent.rpt_bind_uin_info.add(localBindUinInfo);
        i += 1;
      }
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3636);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramPacket.setSSOCommand("OidbSvc.0xe34_1");
      paramPacket.putSendData(WupUtil.a(((oidb_sso.OIDBSSOPkg)localObject).toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountServlet", 2, "onSendFetchTroopNewMsg");
      }
      return;
    }
    QLog.e("SubAccountServlet", 2, "subaccountuins is empty");
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent.getIntExtra("key_type", 0) != 1) {
      return;
    }
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent.getIntExtra("key_type", 0) != 1) {
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountServlet
 * JD-Core Version:    0.7.0.1
 */