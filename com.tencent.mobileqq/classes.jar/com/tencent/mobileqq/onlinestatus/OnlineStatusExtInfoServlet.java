package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationTrend;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationTrend.Companion;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.Condition;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.CustomData;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.ReqBody;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class OnlineStatusExtInfoServlet
  extends MSFServlet
{
  public static NewIntent a(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OnlineStatusExtInfoServlet.class);
    localNewIntent.putExtra("param_request_type", 1);
    localNewIntent.putExtra("param_constellation", paramString);
    localNewIntent.putExtra("param_today_date", ConstellationUtilKt.b());
    localNewIntent.putExtra("param_tomorrow_date", ConstellationUtilKt.c());
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "requestConstellationTrendTwoDay: invoked. ", " constellation: ", paramString });
    }
    return localNewIntent;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str1 = "";
    String str2 = paramIntent.getStringExtra("param_constellation");
    Object localObject1 = paramIntent.getStringExtra("param_today_date");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "handleGetConstellationTrend | constellation = ", str2, " todayDate: ", localObject1 });
    }
    Bundle localBundle = new Bundle();
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get(arrayOfByte);
          ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        localObject1 = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        paramFromServiceMsg = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend parseFrom byte", localInvalidProtocolBufferMicroException2);
        localObject1 = paramFromServiceMsg;
      }
      i = ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "handleGetConstellationTrend | result = ", Integer.valueOf(i) });
      }
      if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get() != null)) {
        localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = getAppRuntime();
        Object localObject2 = new oidb_0xe84.RspBody();
        ((oidb_0xe84.RspBody)localObject2).mergeFrom((byte[])localObject1);
        i = ((oidb_0xe84.RspBody)localObject2).uint32_interval.get();
        ConstellationUtilKt.a(paramFromServiceMsg, i);
        localObject2 = ((oidb_0xe84.RspBody)localObject2).msg_custom_data.get();
        int j = ((List)localObject2).size();
        if (j == 2) {
          try
          {
            Object localObject5 = (oidb_0xe84.CustomData)((List)localObject2).get(0);
            localObject1 = ((oidb_0xe84.CustomData)localObject5).bytes_data.get().toByteArray();
            Object localObject3 = ((oidb_0xe84.CustomData)localObject5).bytes_jump_link.get().toByteArray();
            Object localObject4 = new String(((oidb_0xe84.CustomData)localObject5).bytes_png_link.get().toByteArray());
            String str3 = new String(((oidb_0xe84.CustomData)localObject5).bytes_icon_link.get().toByteArray());
            localObject5 = new String(((oidb_0xe84.CustomData)localObject5).bytes_text_color.get().toByteArray());
            localObject1 = new String((byte[])localObject1);
            String str5 = new String((byte[])localObject3);
            String str4 = new String(((oidb_0xe84.CustomData)((List)localObject2).get(1)).bytes_data.get().toByteArray());
            try
            {
              String str6 = ConstellationUtilKt.a(paramFromServiceMsg);
              if (((String)localObject1).equals(str6)) {
                break label1114;
              }
              bool1 = true;
              boolean bool2 = QLog.isColorLevel();
              if (bool2) {
                QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "handleGetConstellationTrend: invoked. ", " jsonChanged: ", Boolean.valueOf(bool1), " cacheTrendJson: ", str6, " constellationJson: ", localObject1 });
              }
              localObject2 = (IFriendDataService)paramFromServiceMsg.getRuntimeService(IFriendDataService.class, "");
              localObject3 = ((IFriendDataService)localObject2).getFriend(paramFromServiceMsg.getCurrentAccountUin(), true, true, true);
              ((Friends)localObject3).constellationIconUrl = str3;
              ((Friends)localObject3).constellationJumpUrl = str5;
              ((Friends)localObject3).constellationBgImageUrl = ((String)localObject4);
              ((Friends)localObject3).constellationDateStr = ConstellationUtilKt.b();
              ((IFriendDataService)localObject2).saveFriend((Friends)localObject3);
              ConstellationUtilKt.a(paramFromServiceMsg, i);
              ConstellationUtilKt.a(paramFromServiceMsg, (String)localObject1);
              ConstellationUtilKt.c(paramFromServiceMsg, (String)localObject5);
              localObject4 = ((Friends)localObject3).constellationTodayTrend;
              if ((bool1) || (TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str6)))
              {
                localObject4 = new ConstellationTrend().a((String)localObject1).a();
                str3 = new ConstellationTrend().a(str4).a();
                bool1 = TextUtils.isEmpty((CharSequence)localObject4);
                if (!bool1)
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append(str2);
                  ((StringBuilder)localObject5).append(" | ");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  ((Friends)localObject3).constellationTodayTrend = ((StringBuilder)localObject5).toString();
                }
                else
                {
                  ((Friends)localObject3).constellationTodayTrend = null;
                }
                if (!TextUtils.isEmpty(str3))
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append(str2);
                  ((StringBuilder)localObject4).append(" | ");
                  ((StringBuilder)localObject4).append(str3);
                  ((Friends)localObject3).constellationTomorrowTrend = ((StringBuilder)localObject4).toString();
                }
                else
                {
                  ((Friends)localObject3).constellationTomorrowTrend = null;
                }
                ((Friends)localObject3).constellationLuckyColor = new ConstellationTrend().a((String)localObject1).a(ConstellationTrend.a.a());
                ((Friends)localObject3).constellationLuckyNumber = new ConstellationTrend().a((String)localObject1).a(ConstellationTrend.a.b());
                ((IFriendDataService)localObject2).saveFriend((Friends)localObject3);
              }
              if (((IOnlineStatusService)paramFromServiceMsg.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus() == 1040L) {
                ExtensionBizInfoHelper.a.a(paramFromServiceMsg, 1040);
              }
              localObject1 = ConstellationUtilKt.b(paramFromServiceMsg, paramFromServiceMsg.getCurrentAccountUin());
              localObject2 = ((String)localObject1).split("\\|");
              paramFromServiceMsg = str1;
              if (localObject2.length == 2) {
                paramFromServiceMsg = localObject2[1].trim();
              }
              localBundle.putString("key_today_constellation_trend", paramFromServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "handleGetConstellationTrend: invoked. ", " suitableTrend: ", localObject1 });
              }
              bool1 = true;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              bool1 = true;
              continue;
            }
            if (!QLog.isColorLevel()) {
              break label1046;
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        } else {
          QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "handleGetConstellationTrend: invoked. error ", " customDatas: ", Integer.valueOf(((List)localObject2).size()) });
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool1 = false;
        QLog.e("OnlineStatusExtInfoServlet", 1, "handleGetConstellationTrend: failed. ", paramFromServiceMsg);
        break label1049;
      }
      label1046:
      boolean bool1 = false;
      label1049:
      break label1100;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleGetConstellationTrend | response.result = ");
        ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
        QLog.d("OnlineStatusExtInfoServlet", 2, ((StringBuilder)localObject1).toString());
      }
      bool1 = false;
      label1100:
      notifyObserver(paramIntent, 1, bool1, localBundle, StatusExtInfoObserver.class);
      return;
      label1114:
      bool1 = false;
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("param_constellation");
    Object localObject2 = paramIntent.getStringExtra("param_today_date");
    String str = paramIntent.getStringExtra("param_tomorrow_date");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    paramIntent = new oidb_0xe84.ReqBody();
    oidb_0xe84.Condition localCondition = new oidb_0xe84.Condition();
    localCondition.bytes_key.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localCondition.bytes_date.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new oidb_0xe84.Condition();
    ((oidb_0xe84.Condition)localObject2).bytes_key.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    ((oidb_0xe84.Condition)localObject2).bytes_date.set(ByteStringMicro.copyFromUtf8(str));
    localObject1 = new OnlineStatusExtInfoServlet.1(this, localCondition, (oidb_0xe84.Condition)localObject2);
    paramIntent.msg_condi.set((List)localObject1);
    paramIntent.uint64_appid.set(1108937847L);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3716);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe84_1");
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive:");
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
      QLog.d("OnlineStatusExtInfoServlet", 2, localStringBuilder.toString());
    }
    if (str2 != null)
    {
      if (!str2.equals("OidbSvc.0xe84_1")) {
        return;
      }
      int i = paramIntent.getIntExtra("param_request_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "onReceive reqType", Integer.valueOf(i) });
      }
      if (i == 1) {
        a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("param_request_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { " onSend reqType", Integer.valueOf(i) });
    }
    if (i == 1) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet
 * JD-Core Version:    0.7.0.1
 */