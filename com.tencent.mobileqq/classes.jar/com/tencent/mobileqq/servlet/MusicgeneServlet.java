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
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i;
      if (paramIntent.equals("OidbSvc.0x480_124"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.settab.MusicgeneServlet", 2, "onReceive response. actionString=OidbSvc.0x480_124");
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
            paramFromServiceMsg.printStackTrace();
          }
          if ((paramIntent != null) && (paramIntent.uint32_result.has()))
          {
            i = paramIntent.uint32_result.get();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("onReceive response. getstate ret=");
              paramFromServiceMsg.append(i);
              QLog.i("Q.settab.MusicgeneServlet", 2, paramFromServiceMsg.toString());
            }
            if ((i == 0) && (paramIntent.bytes_bodybuffer.has()) && (paramIntent.bytes_bodybuffer.get() != null))
            {
              paramIntent = paramIntent.bytes_bodybuffer.get().toByteArray();
              int i2 = paramIntent.length;
              long l = 0L;
              if (4 <= i2) {
                l = PkgTools.getLongData(paramIntent, 0);
              }
              if (5 <= i2) {
                i = paramIntent[4];
              }
              int k;
              if (7 <= i2) {
                k = PkgTools.getShortData(paramIntent, 5);
              } else {
                k = 0;
              }
              int m = 0;
              i = -1;
              int j = 7;
              boolean bool1;
              for (boolean bool2 = false; m < k; bool2 = bool1)
              {
                int i1 = i;
                int n = j;
                bool1 = bool2;
                if (j + 4 <= i2)
                {
                  n = PkgTools.getShortData(paramIntent, j);
                  j += 2;
                  i1 = PkgTools.getShortData(paramIntent, j);
                  int i3 = j + 2;
                  if (n == 27026)
                  {
                    if (i1 == 0)
                    {
                      bool1 = false;
                      j = i;
                    }
                    else
                    {
                      bool1 = true;
                      j = i;
                    }
                  }
                  else
                  {
                    j = i;
                    bool1 = bool2;
                    if (n == 21006)
                    {
                      j = i;
                      bool1 = bool2;
                      if (i1 >= 6)
                      {
                        j = i;
                        bool1 = bool2;
                        if (i3 + 6 <= i2)
                        {
                          j = PkgTools.getUnsignedByte(paramIntent[(i3 + 5)]) >> 6;
                          bool1 = bool2;
                        }
                      }
                    }
                  }
                  n = i3 + i1;
                  i1 = j;
                }
                m += 1;
                i = i1;
                j = n;
              }
              if (i >= 0)
              {
                paramIntent = new Bundle();
                paramIntent.putBoolean("music_get_exist", bool2);
                paramIntent.putInt("music_get_state", i);
                paramIntent.putLong("music_get_uin", l);
                notifyObserver(null, 10000, true, paramIntent, MusicGeneObserver.class);
                if (QLog.isColorLevel())
                {
                  paramIntent = new StringBuilder();
                  paramIntent.append("onReceive response.getstate.exist=");
                  paramIntent.append(bool2);
                  paramIntent.append(",state=");
                  paramIntent.append(i);
                  QLog.i("Q.settab.MusicgeneServlet", 2, paramIntent.toString());
                }
                return;
              }
            }
          }
        }
        notifyObserver(null, 10000, false, null, MusicGeneObserver.class);
        return;
      }
      if (paramIntent.equals("OidbSvc.0x493_223"))
      {
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
            paramFromServiceMsg.printStackTrace();
          }
          if ((paramIntent != null) && (paramIntent.uint32_result.has()))
          {
            i = paramIntent.uint32_result.get();
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onReceive response. setstate ret=");
              paramIntent.append(i);
              QLog.i("Q.settab.MusicgeneServlet", 2, paramIntent.toString());
            }
            if (i == 0)
            {
              notifyObserver(null, 10001, true, null, MusicGeneObserver.class);
              return;
            }
          }
        }
        notifyObserver(null, 10001, false, null, MusicGeneObserver.class);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend. actionString=");
      localStringBuilder.append((String)localObject);
      QLog.i("Q.settab.MusicgeneServlet", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (((String)localObject).equals("OidbSvc.0x480_124"))
      {
        paramIntent = paramIntent.getStringExtra("uin");
        if (TextUtils.isEmpty(paramIntent)) {
          return;
        }
      }
    }
    try
    {
      long l = Long.parseLong(paramIntent);
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1152);
      paramIntent.uint32_service_type.set(124);
      localObject = new byte[11];
      PkgTools.dWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.word2Byte((byte[])localObject, 5, (short)2);
      PkgTools.word2Byte((byte[])localObject, 7, (short)27026);
      PkgTools.word2Byte((byte[])localObject, 9, (short)21006);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      paramPacket.setSSOCommand("OidbSvc.0x480_124");
      paramPacket.putSendData(WupUtil.a(paramIntent.toByteArray()));
      return;
    }
    catch (Exception paramIntent) {}
    if (((String)localObject).equals("OidbSvc.0x493_223"))
    {
      boolean bool = paramIntent.getBooleanExtra("ison", true);
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1171);
      paramIntent.uint32_service_type.set(223);
      localObject = new byte[1];
      if (bool) {
        localObject[0] = 0;
      } else {
        localObject[0] = 2;
      }
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      paramPacket.setSSOCommand("OidbSvc.0x493_223");
      paramPacket.putSendData(WupUtil.a(paramIntent.toByteArray()));
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.MusicgeneServlet
 * JD-Core Version:    0.7.0.1
 */