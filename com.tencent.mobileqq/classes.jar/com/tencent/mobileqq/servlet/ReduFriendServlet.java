package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReduFriendServlet
  extends MSFServlet
{
  private byte[] a()
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1231);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ReduFriendServlet onReceive() is called, isSuccess is:");
      ((StringBuilder)localObject1).append(bool2);
      QLog.d("ReduFriendServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Bundle localBundle = new Bundle();
    boolean bool1 = bool2;
    int i;
    int k;
    if (bool2)
    {
      Object localObject2 = new ArrayList();
      for (;;)
      {
        try
        {
          i = paramFromServiceMsg.getResultCode();
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          j = paramFromServiceMsg.getInt();
          localObject1 = new byte[j - 4];
          paramFromServiceMsg.get((byte[])localObject1);
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject1);
          k = paramFromServiceMsg.uint32_result.get();
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          int m = paramFromServiceMsg.get();
          if (!QLog.isColorLevel()) {
            break label790;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ReduFriendServlet onReceive,result is:");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(",response.lenth is:");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(",sso.RespResult is:");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",cCount is:");
          ((StringBuilder)localObject1).append(m);
          QLog.d("ReduFriendServlet", 2, ((StringBuilder)localObject1).toString());
        }
        catch (Exception paramFromServiceMsg)
        {
          int j;
          long l;
          SharedPreferences.Editor localEditor;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ReduFriendServlet onReceive occurs exception,error msg is:");
          ((StringBuilder)localObject1).append(paramFromServiceMsg.getMessage());
          QLog.d("ReduFriendServlet", 2, ((StringBuilder)localObject1).toString(), paramFromServiceMsg);
          bool1 = false;
          break label758;
        }
        if (paramFromServiceMsg.position() < paramFromServiceMsg.capacity())
        {
          localObject1 = new byte[4];
          paramFromServiceMsg.get((byte[])localObject1, 0, localObject1.length);
          l = PkgTools.getLongData((byte[])localObject1, 0);
          i = paramFromServiceMsg.getShort();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ReduFriendServlet onReceive,uin is:");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(",redu is:");
            ((StringBuilder)localObject1).append(i);
            QLog.d("ReduFriendServlet", 2, ((StringBuilder)localObject1).toString());
          }
          ((ArrayList)localObject2).add(String.valueOf(l));
        }
        else
        {
          localBundle.putStringArrayList("redu_list", (ArrayList)localObject2);
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("ReduFriendServlet onReceive,reduList is:");
            paramFromServiceMsg.append(localObject2);
            QLog.d("ReduFriendServlet", 2, paramFromServiceMsg.toString());
          }
          localObject1 = null;
          if (paramIntent != null)
          {
            paramFromServiceMsg = paramIntent.getStringExtra("k_uin");
          }
          else
          {
            paramFromServiceMsg = (FromServiceMsg)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,qq has exception,request is null");
              paramFromServiceMsg = (FromServiceMsg)localObject1;
            }
          }
          if (paramFromServiceMsg != null)
          {
            l = MessageCache.c();
            localEditor = BaseApplication.getContext().getSharedPreferences("free_call", 0).edit();
            localEditor.putString(FriendHotTipsBar.b(paramFromServiceMsg), String.valueOf(l));
            j = ((ArrayList)localObject2).size();
            localObject1 = new StringBuilder();
            k = Math.min(j, 100);
            i = 0;
            while (i < k)
            {
              ((StringBuilder)localObject1).append((String)((ArrayList)localObject2).get(i));
              ((StringBuilder)localObject1).append("|");
              i += 1;
            }
            localObject2 = ((StringBuilder)localObject1).toString();
            localObject1 = localObject2;
            if (j > 0) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localEditor.putString(FriendHotTipsBar.c(paramFromServiceMsg), (String)localObject1);
            localEditor.commit();
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("reduSize is:");
              paramFromServiceMsg.append(j);
              paramFromServiceMsg.append(",curTime is:");
              paramFromServiceMsg.append(l);
              paramFromServiceMsg.append(",allReduFriend is:");
              paramFromServiceMsg.append((String)localObject1);
              QLog.d("ReduFriendServlet", 2, paramFromServiceMsg.toString());
              bool1 = bool2;
            }
          }
          else
          {
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,please pass uin,uin is empty");
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label758:
      if (paramIntent != null) {
        i = paramIntent.getIntExtra("action", 0);
      } else {
        i = 0;
      }
      notifyObserver(paramIntent, i, bool1, localBundle, ReduFriendObserver.class);
      return;
      label790:
      if (k == 0) {
        break;
      }
      bool1 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onSend() is called");
    }
    paramPacket.putSendData(a());
    paramPacket.setSSOCommand("OidbSvc.0x4cf_1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.ReduFriendServlet
 * JD-Core Version:    0.7.0.1
 */