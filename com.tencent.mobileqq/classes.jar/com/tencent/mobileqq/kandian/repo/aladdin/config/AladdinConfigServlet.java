package com.tencent.mobileqq.kandian.repo.aladdin.config;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.CPU;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Camera;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Config;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigResult;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigSeq;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.DeviceInfo;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Memory;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.OS;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBody;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType1;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType2;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBody;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBodyType1;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBodyType2;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Screen;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Storage;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.QQAladdinPrefUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class AladdinConfigServlet
  extends MSFServlet
{
  private static oidb_cmd0xbf8.DeviceInfo a()
  {
    oidb_cmd0xbf8.DeviceInfo localDeviceInfo = new oidb_cmd0xbf8.DeviceInfo();
    localDeviceInfo.os.set(new oidb_cmd0xbf8.OS());
    localDeviceInfo.os.type.set(2);
    localDeviceInfo.os.version.set(DeviceInfoUtil.g());
    localDeviceInfo.os.sdk.set(String.valueOf(DeviceInfoUtil.d()));
    localDeviceInfo.os.kernel.set(System.getProperty("os.version"));
    localDeviceInfo.cpu.set(new oidb_cmd0xbf8.CPU());
    localDeviceInfo.cpu.model.set(DeviceInfoUtil.m());
    localDeviceInfo.cpu.cores.set(DeviceInfoUtil.h());
    localDeviceInfo.cpu.frequency.set((int)DeviceInfoUtil.k());
    localDeviceInfo.memory.set(new oidb_cmd0xbf8.Memory());
    localDeviceInfo.memory.total.set(DeviceInfoUtil.a());
    localDeviceInfo.storage.set(new oidb_cmd0xbf8.Storage());
    localDeviceInfo.storage.builtin.set(DeviceInfoUtil.p()[0]);
    localDeviceInfo.storage.external.set(DeviceInfoUtil.q()[0]);
    localDeviceInfo.screen.set(new oidb_cmd0xbf8.Screen());
    localDeviceInfo.screen.dpi.set(DeviceInfoUtil.J());
    localDeviceInfo.screen.width.set((int)DeviceInfoUtil.D());
    localDeviceInfo.screen.height.set((int)DeviceInfoUtil.E());
    localDeviceInfo.camera.set(new oidb_cmd0xbf8.Camera());
    return localDeviceInfo;
  }
  
  private static oidb_cmd0xbf8.ReqBody a(String paramString, List<AladdinConfigServlet.ConfigResult> paramList)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    oidb_cmd0xbf8.ReqBodyType2 localReqBodyType2 = new oidb_cmd0xbf8.ReqBodyType2();
    localReqBodyType2.cookie.set(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (AladdinConfigServlet.ConfigResult)paramString.next();
      oidb_cmd0xbf8.ConfigResult localConfigResult = new oidb_cmd0xbf8.ConfigResult();
      localConfigResult.id.set(paramList.a());
      localConfigResult.ret_code.set(paramList.c());
      localConfigResult.version.set(paramList.b());
      localReqBodyType2.rpt_ret_list.add(localConfigResult);
    }
    localReqBody.req_type.set(1);
    localReqBody.body_type_2.set(localReqBodyType2);
    paramString = new StringBuilder();
    paramString.append("[makeAckBody] ");
    paramString.append(a(localReqBody));
    QLog.d("AladdinConfigServlet", 2, paramString.toString());
    return localReqBody;
  }
  
  private static oidb_cmd0xbf8.ReqBody a(@NonNull int[] paramArrayOfInt)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    oidb_cmd0xbf8.ReqBodyType1 localReqBodyType1 = new oidb_cmd0xbf8.ReqBodyType1();
    localReqBodyType1.app_version.set("8.8.17");
    localReqBodyType1.device_info.set(a());
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      oidb_cmd0xbf8.ConfigSeq localConfigSeq = new oidb_cmd0xbf8.ConfigSeq();
      localConfigSeq.id.set(k);
      localConfigSeq.version.set(QQAladdinPrefUtils.a(k));
      localReqBodyType1.rpt_config_list.add(localConfigSeq);
      i += 1;
    }
    localReqBody.req_type.set(0);
    localReqBody.body_type_1.set(localReqBodyType1);
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("[makeReqBody] ");
    paramArrayOfInt.append(a(localReqBody));
    QLog.d("AladdinConfigServlet", 2, paramArrayOfInt.toString());
    return localReqBody;
  }
  
  public static <T extends MessageMicro> String a(T paramT)
  {
    QLog.isColorLevel();
    return "";
  }
  
  private ArrayList<AladdinConfigServlet.ConfigResult> a(oidb_cmd0xbf8.RspBodyType1 paramRspBodyType1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[handleRspBody] ");
    ((StringBuilder)localObject1).append(a(paramRspBodyType1));
    QLog.d("AladdinConfigServlet", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = paramRspBodyType1.rpt_config_list.get();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      oidb_cmd0xbf8.Config localConfig = (oidb_cmd0xbf8.Config)((Iterator)localObject2).next();
      int j = localConfig.id.get();
      int k = localConfig.version.get();
      String str = localConfig.content.get();
      int m = localConfig.wipe_flag.get();
      int i = 1;
      try
      {
        boolean bool = a(j, k, str, m);
        i = true ^ bool;
      }
      catch (Exception localException)
      {
        QLog.e("AladdinConfigServlet", 1, "[handleRspBody] ", localException);
      }
      ((ArrayList)localObject1).add(new AladdinConfigServlet.ConfigResult(j, k, i));
    }
    a(paramRspBodyType1.cookie.get(), (ArrayList)localObject1);
    return localObject1;
  }
  
  private static void a(int paramInt, List<AladdinConfigServlet.ConfigResult> paramList, Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    int i = paramIntent.getIntExtra("key_req_type", 0);
    localHashMap.put("param_OpCode", String.valueOf(i));
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    if (i == 0)
    {
      int k = paramList.size();
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext())
      {
        int j;
        if (AladdinConfigServlet.ConfigResult.a((AladdinConfigServlet.ConfigResult)paramList.next()) != 0) {
          j = 1;
        } else {
          j = 0;
        }
        i += j;
      }
      localHashMap.put("param_ConfigCount", String.valueOf(k));
      localHashMap.put("param_FailCount", String.valueOf(i));
    }
    long l = paramIntent.getLongExtra("key_packet_receive_timestamp", 0L) - paramIntent.getLongExtra("key_packet_send_timestamp", 0L);
    localHashMap.put("param_CostTime", String.valueOf(l));
    paramList = StatisticCollector.getInstance(RIJQQAppInterfaceUtil.e().getApplication());
    paramIntent = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramList.collectPerformance(paramIntent, "actKanDianAladdinResult", bool, l, 0L, localHashMap, null, false);
  }
  
  private static void a(oidb_cmd0xbf8.RspBodyType2 paramRspBodyType2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleAckRsp] ");
    localStringBuilder.append(a(paramRspBodyType2));
    QLog.d("AladdinConfigServlet", 2, localStringBuilder.toString());
    paramRspBodyType2 = paramRspBodyType2.msg.get();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleAckRsp] msg=");
    localStringBuilder.append(paramRspBodyType2);
    QLog.d("AladdinConfigServlet", 2, localStringBuilder.toString());
  }
  
  private void a(String paramString, ArrayList<AladdinConfigServlet.ConfigResult> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[ackConfigResults] for ");
    ((StringBuilder)localObject).append(paramArrayList);
    QLog.d("AladdinConfigServlet", 2, ((StringBuilder)localObject).toString());
    localObject = getAppRuntime();
    NewIntent localNewIntent = new NewIntent(((AppRuntime)localObject).getApplication(), AladdinConfigServlet.class);
    localNewIntent.putExtra("key_uin", ((AppRuntime)localObject).getAccount());
    localNewIntent.putExtra("key_cookie", paramString);
    localNewIntent.putExtra("key_req_type", 1);
    localNewIntent.putExtra("key_config_result_list", paramArrayList);
    ((AppRuntime)localObject).startServlet(localNewIntent);
  }
  
  private boolean a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleSingleConfigRsp] id = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", version = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", wipeFlag = ");
    ((StringBuilder)localObject).append(paramInt3);
    QLog.d("AladdinConfigServlet", 2, ((StringBuilder)localObject).toString());
    QQAladdinPrefUtils.a(paramInt1);
    boolean bool = true;
    try
    {
      localObject = Aladdin.getConfigHandlerById(paramInt1);
      if (paramInt3 != 0) {
        ((SimpleConfigHandler)localObject).onWipeConfig(paramInt3);
      } else {
        bool = ((SimpleConfigHandler)localObject).onReceiveConfig(paramInt1, paramInt2, paramString);
      }
      QQAladdinPrefUtils.a(paramInt1, paramInt2);
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.e("AladdinConfigServlet", 1, "[handleSingleConfigRsp] ", paramString);
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    long l = paramArrayOfByte.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, l + 4L);
    PkgTools.copyData(arrayOfByte, 4, paramArrayOfByte, i);
    return arrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceive] cmd=");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
    ((StringBuilder)localObject).append(" appSeq=");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getAppSeq());
    ((StringBuilder)localObject).append(" success=");
    ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
    ((StringBuilder)localObject).append(" resultCode=");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
    QLog.i("AladdinConfigServlet", 1, ((StringBuilder)localObject).toString());
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    oidb_cmd0xbf8.RspBody localRspBody = new oidb_cmd0xbf8.RspBody();
    localObject = new ArrayList();
    try
    {
      int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, a(paramFromServiceMsg.getWupBuffer()), localRspBody);
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[onReceive] result=");
      paramFromServiceMsg.append(i);
      QLog.i("AladdinConfigServlet", 1, paramFromServiceMsg.toString());
      paramFromServiceMsg = (FromServiceMsg)localObject;
      if (i == 0)
      {
        int j = localRspBody.rsp_type.get();
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[onReceive] rspType=");
        paramFromServiceMsg.append(j);
        QLog.i("AladdinConfigServlet", 1, paramFromServiceMsg.toString());
        if (j == 0)
        {
          paramFromServiceMsg = a((oidb_cmd0xbf8.RspBodyType1)localRspBody.body_type_1.get());
        }
        else
        {
          paramFromServiceMsg = (FromServiceMsg)localObject;
          if (j == 1)
          {
            a((oidb_cmd0xbf8.RspBodyType2)localRspBody.body_type_2.get());
            paramFromServiceMsg = (FromServiceMsg)localObject;
          }
        }
      }
      paramIntent.putExtra("key_packet_receive_timestamp", System.currentTimeMillis());
      a(i, paramFromServiceMsg, paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AladdinConfigServlet", 1, "[onReceive] ", paramIntent);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_req_type", 0);
    Object localObject1 = null;
    Object localObject2;
    if (i == 0)
    {
      localObject2 = paramIntent.getIntArrayExtra("key_config_id_list");
      if (localObject2 != null) {
        localObject1 = a((int[])localObject2);
      }
    }
    else if (i == 1)
    {
      localObject2 = paramIntent.getParcelableArrayListExtra("key_config_result_list");
      String str = paramIntent.getStringExtra("key_cookie");
      if (localObject2 != null) {
        localObject1 = a(str, (List)localObject2);
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onSend] unknown reqType = ");
      ((StringBuilder)localObject2).append(i);
      QLog.i("AladdinConfigServlet", 1, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xbf8", 3064, 0, ((oidb_cmd0xbf8.ReqBody)localObject1).toByteArray());
      paramPacket.setSSOCommand(((ToServiceMsg)localObject1).getServiceCmd());
      paramPacket.putSendData(b(((ToServiceMsg)localObject1).getWupBuffer()));
      paramPacket.setAttributes(((ToServiceMsg)localObject1).getAttributes());
      paramIntent.putExtra("key_packet_send_timestamp", System.currentTimeMillis());
    }
    paramIntent = new StringBuilder();
    paramIntent.append("[onSend] reqType=");
    paramIntent.append(i);
    QLog.i("AladdinConfigServlet", 1, paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.AladdinConfigServlet
 * JD-Core Version:    0.7.0.1
 */