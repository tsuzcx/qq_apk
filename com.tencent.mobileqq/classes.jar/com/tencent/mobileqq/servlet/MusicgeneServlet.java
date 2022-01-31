package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.observer.MusicGeneObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MusicgeneServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = paramIntent.getAction();
    int i;
    int n;
    boolean bool;
    if (!TextUtils.isEmpty(paramIntent))
    {
      if (!paramIntent.equals("OidbSvc.0x480_124")) {
        break label452;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response. actionString=OidbSvc.0x480_124");
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
        break label439;
      }
      paramIntent = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramIntent.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        paramIntent = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int k;
          paramFromServiceMsg.printStackTrace();
          continue;
          bool = true;
        }
        if (i2 != 21006) {
          break label605;
        }
      }
      if ((paramIntent == null) || (!paramIntent.uint32_result.has())) {
        break label439;
      }
      i = paramIntent.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response. getstate ret=" + i);
      }
      if ((i != 0) || (!paramIntent.bytes_bodybuffer.has()) || (paramIntent.bytes_bodybuffer.get() == null)) {
        break label439;
      }
      paramIntent = paramIntent.bytes_bodybuffer.get().toByteArray();
      n = paramIntent.length;
      k = 0;
      i = -1;
      bool = false;
      if (4 > n) {
        break label611;
      }
    }
    label279:
    label439:
    label452:
    label605:
    label608:
    label611:
    for (long l = PkgTools.a(paramIntent, 0);; l = 0L)
    {
      if (5 <= n) {
        j = paramIntent[4];
      }
      if (7 <= n) {
        k = PkgTools.a(paramIntent, 5);
      }
      int m = 0;
      int j = 7;
      int i2;
      int i1;
      if (m < k)
      {
        if (j + 4 > n) {
          break label608;
        }
        i2 = PkgTools.a(paramIntent, j);
        i1 = j + 2;
        j = PkgTools.a(paramIntent, i1);
        i1 += 2;
        if (i2 == 27026) {
          if (j == 0)
          {
            bool = false;
            j += i1;
          }
        }
      }
      for (;;)
      {
        m += 1;
        break;
        if ((j >= 6) && (i1 + 6 <= n))
        {
          i = PkgTools.a(paramIntent[(i1 + 5)]) >> 6;
          break label279;
          if (i >= 0)
          {
            paramIntent = new Bundle();
            paramIntent.putBoolean("music_get_exist", bool);
            paramIntent.putInt("music_get_state", i);
            paramIntent.putLong("music_get_uin", l);
            notifyObserver(null, 10000, true, paramIntent, MusicGeneObserver.class);
            if (QLog.isColorLevel()) {
              QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response.getstate.exist=" + bool + ",state=" + i);
            }
          }
          do
          {
            return;
            notifyObserver(null, 10000, false, null, MusicGeneObserver.class);
            return;
          } while (!paramIntent.equals("OidbSvc.0x493_223"));
          if (QLog.isColorLevel()) {
            QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response. actionString=OidbSvc.0x493_223");
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
          {
            paramIntent = new oidb_sso.OIDBSSOPkg();
            try
            {
              paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramIntent.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
              paramIntent = paramFromServiceMsg;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              for (;;)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
            if ((paramIntent != null) && (paramIntent.uint32_result.has()))
            {
              i = paramIntent.uint32_result.get();
              if (QLog.isColorLevel()) {
                QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response. setstate ret=" + i);
              }
              if (i == 0)
              {
                notifyObserver(null, 10001, true, null, MusicGeneObserver.class);
                return;
              }
            }
          }
          notifyObserver(null, 10001, false, null, MusicGeneObserver.class);
          return;
        }
        break label279;
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("Q.settab.MusicgeneServlet", 2, "onSend. actionString=" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).equals("OidbSvc.0x480_124")) {
        break label178;
      }
      paramIntent = paramIntent.getStringExtra("uin");
      if (!TextUtils.isEmpty(paramIntent)) {
        break label71;
      }
    }
    label71:
    do
    {
      return;
      boolean bool;
      try
      {
        long l = Long.parseLong(paramIntent);
        paramIntent = new oidb_sso.OIDBSSOPkg();
        paramIntent.uint32_command.set(1152);
        paramIntent.uint32_service_type.set(124);
        localObject = new byte[11];
        PkgTools.a((byte[])localObject, 0, l);
        localObject[4] = 0;
        PkgTools.a((byte[])localObject, 5, (short)2);
        PkgTools.a((byte[])localObject, 7, (short)27026);
        PkgTools.a((byte[])localObject, 9, (short)21006);
        paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
        paramPacket.setSSOCommand("OidbSvc.0x480_124");
        paramPacket.putSendData(WupUtil.a(paramIntent.toByteArray()));
        return;
      }
      catch (Exception paramIntent) {}
    } while (!((String)localObject).equals("OidbSvc.0x493_223"));
    label178:
    bool = paramIntent.getBooleanExtra("ison", true);
    paramIntent = new oidb_sso.OIDBSSOPkg();
    paramIntent.uint32_command.set(1171);
    paramIntent.uint32_service_type.set(223);
    localObject = new byte[1];
    if (bool) {
      localObject[0] = 0;
    }
    for (;;)
    {
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      paramPacket.setSSOCommand("OidbSvc.0x493_223");
      paramPacket.putSendData(WupUtil.a(paramIntent.toByteArray()));
      return;
      localObject[0] = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.MusicgeneServlet
 * JD-Core Version:    0.7.0.1
 */