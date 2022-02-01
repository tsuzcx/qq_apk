package com.tencent.mobileqq.servlet;

import QMF_PROTOCAL.QmfDownstream;
import QzoneCombine.ClientOnlineNotfiyRsp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.WupTool;
import cooperation.qzone.ClientOnlineRequest;
import cooperation.qzone.WNSStream;
import java.io.IOException;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneOnLineServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null)
    {
      QLog.e("NotifyQZoneServer", 1, "fromServiceMsg==null");
      return;
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      Object localObject = new WNSStream();
      paramFromServiceMsg = WupUtil.b(paramFromServiceMsg.getWupBuffer());
      try
      {
        paramFromServiceMsg = ((WNSStream)localObject).unpack(paramFromServiceMsg);
        if (paramFromServiceMsg == null) {
          return;
        }
        paramFromServiceMsg = (ClientOnlineNotfiyRsp)WupTool.a(ClientOnlineNotfiyRsp.class, paramFromServiceMsg.BusiBuff);
        if (paramFromServiceMsg == null) {
          return;
        }
        localObject = paramFromServiceMsg.AttachInfo;
        paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0).edit();
        localObject = HexUtil.bytes2HexStr((byte[])localObject);
        paramIntent = paramIntent.getStringExtra("key_uin");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_attach_info");
        localStringBuilder.append(paramIntent);
        paramFromServiceMsg.putString(localStringBuilder.toString(), (String)localObject);
        if (QLog.isDevelopLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("onReceive attachinfo:");
          paramIntent.append((String)localObject);
          QLog.d("NotifyQZoneServer", 4, paramIntent.toString());
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          paramFromServiceMsg.apply();
          return;
        }
        paramFromServiceMsg.commit();
        return;
      }
      catch (IOException paramIntent)
      {
        QLog.e("NotifyQZoneServer", 1, paramIntent, new Object[0]);
        return;
      }
    }
    else
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive fromServiceMsg.getResultCode():");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      QLog.e("NotifyQZoneServer", 1, paramIntent.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("lastPushMsgTime", 0L);
    paramIntent = paramIntent.getStringExtra("key_uin");
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_attach_info");
    ((StringBuilder)localObject2).append(paramIntent);
    paramIntent = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject1 = HexUtil.hexStr2Bytes(paramIntent);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSend lastPushMsgTime:");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(",attachinfo:");
      ((StringBuilder)localObject2).append(paramIntent);
      QLog.d("NotifyQZoneServer", 4, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new ClientOnlineRequest(l, (byte[])localObject1);
    localObject1 = ((ClientOnlineRequest)localObject2).encode();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(((ClientOnlineRequest)localObject2).uniKey());
      QLog.e("NotifyQZoneServer", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SQQzoneSvc.");
    ((StringBuilder)localObject1).append(((ClientOnlineRequest)localObject2).uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject1).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneOnLineServlet
 * JD-Core Version:    0.7.0.1
 */