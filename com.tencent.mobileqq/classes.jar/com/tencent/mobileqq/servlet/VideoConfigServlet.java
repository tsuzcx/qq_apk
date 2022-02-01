package com.tencent.mobileqq.servlet;

import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.AVLog;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xa02.cmd0xa02.ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoConfigServlet
  extends MSFServlet
{
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private void a(VideoCallMsg paramVideoCallMsg)
  {
    if (paramVideoCallMsg == null)
    {
      AVLog.printAllUserLog("VideoConfigServlet", "handleVideoConfigMessage error videoMsg = null");
      return;
    }
    if ((paramVideoCallMsg != null) && (paramVideoCallMsg.vMsg != null))
    {
      int[] arrayOfInt = ConfigSystemImpl.a(paramVideoCallMsg.vMsg);
      if (arrayOfInt != null)
      {
        boolean bool2 = false;
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        if (arrayOfInt[2] == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        QQAudioHelper.a(0, new AudioPlayerHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[3];
        j = arrayOfInt[4];
        if (arrayOfInt[5] == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        QQAudioHelper.a(1, new AudioPlayerHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[6];
        j = arrayOfInt[7];
        if (arrayOfInt[8] == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        QQAudioHelper.a(2, new AudioPlayerHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[9];
        j = arrayOfInt[10];
        boolean bool1 = bool2;
        if (arrayOfInt[11] == 1) {
          bool1 = true;
        }
        QQAudioHelper.a(3, new AudioPlayerHelper.AudioPlayerParameter(i, j, bool1));
      }
    }
    ConfigSystemImpl.a(String.valueOf(AppSetting.a()), getAppRuntime().getApplication(), paramVideoCallMsg.vMsg);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (paramIntent != null) {
      if ("VideoCCSvc.Adaptation".equalsIgnoreCase((String)localObject))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("VideoConfigServlet, isSuccess[");
        paramIntent.append(paramFromServiceMsg.isSuccess());
        paramIntent.append("]");
        QLog.w("VideoConfigServlet", 1, paramIntent.toString());
        if (paramFromServiceMsg.isSuccess()) {
          a((VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
        }
      }
      else if ("OidbSvc.0xa02".equalsIgnoreCase((String)localObject))
      {
        if (paramFromServiceMsg.isSuccess()) {
          try
          {
            int i = paramFromServiceMsg.getWupBuffer().length - 4;
            localObject = new byte[i];
            PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramIntent = new oidb_sso.OIDBSSOPkg();
            paramIntent.mergeFrom((byte[])localObject);
            if (paramIntent.uint32_result.get() != 0)
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("cmd0xa02 onReceive uint32_result = ");
              paramFromServiceMsg.append(paramIntent.uint32_result.get());
              AVLog.printColorLog("VideoConfigServlet", paramFromServiceMsg.toString());
              return;
            }
            if (!paramIntent.bytes_bodybuffer.has()) {
              return;
            }
            paramFromServiceMsg = new cmd0xa02.RspBody();
            paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
            paramIntent = paramFromServiceMsg.rpt_tinyid2useracc_info.get();
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("cmd0xa02 onReceive list = ");
            paramFromServiceMsg.append(paramIntent.toString());
            AVLog.printColorLog("VideoConfigServlet", paramFromServiceMsg.toString());
            new ArrayList();
            paramIntent = PstnUtils.a(paramIntent);
            paramFromServiceMsg = (QQAppInterface)getAppRuntime();
            if (paramFromServiceMsg == null) {
              return;
            }
            paramFromServiceMsg.getAVNotifyCenter().b(paramIntent);
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            return;
          }
        } else {
          AVLog.printColorLog("VideoConfigServlet", "cmd0xa02 onReceive not success!");
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (QQAudioHelper.c()) {
      QQAudioHelper.a("VideoConfigServlet.onSend", (Bundle)localObject1, true);
    }
    if (localObject1 == null) {
      return;
    }
    int i = ((Bundle)localObject1).getInt("reqType", 0);
    Object localObject2;
    if (i == 8)
    {
      paramPacket.setServantName("MultiVideo");
      paramPacket.setFuncName("MultiVideoMsg");
      paramPacket.setSSOCommand("MultiVideo.c2s");
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
      paramIntent = new MultiVideoMsg();
      paramIntent.ver = ((Bundle)localObject1).getByte("ver");
      paramIntent.type = ((Bundle)localObject1).getByte("type");
      paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
      paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
      paramIntent.to_uin = ((ArrayList)localObject2);
      paramIntent.msg_time = ((Bundle)localObject1).getLong("msg_time");
      paramIntent.msg_type = ((Bundle)localObject1).getLong("msg_type");
      paramIntent.msg_seq = ((Bundle)localObject1).getLong("msg_seq");
      paramIntent.msg_uid = ((Bundle)localObject1).getLong("msg_uid");
      paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
      paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
      return;
    }
    if (i == 15)
    {
      paramIntent = new cmd0xa02.ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("tinyid_list");
      if (((ArrayList)localObject1).size() > 0)
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localObject2 = new cmd0xa02.TinyID();
          ((cmd0xa02.TinyID)localObject2).uint64_tinyid.set(((Long)((ArrayList)localObject1).get(i)).longValue());
          paramIntent.rpt_tinyid.add((MessageMicro)localObject2);
          i += 1;
        }
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2562);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
        paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
        localObject1 = new byte[paramIntent.length + 4];
        PkgTools.dWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
        PkgTools.copyData((byte[])localObject1, 4, paramIntent, paramIntent.length);
        paramPacket.setSSOCommand("OidbSvc.0xa02");
        paramPacket.putSendData((byte[])localObject1);
        AVLog.printColorLog("VideoConfigServlet", "cmd0xa02 onSend");
      }
    }
    else
    {
      paramPacket.setServantName("VideoSvc");
      paramPacket.setFuncName("SendVideoMsg");
      paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
      paramIntent = new VideoCallMsg();
      paramIntent.ver = 1;
      paramIntent.type = 1;
      paramIntent.lUin = a(getAppRuntime().getAccount());
      paramIntent.lPeerUin = 0L;
      paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
      paramIntent.cVerifyType = 0;
      paramIntent.uSeqId = 0;
      paramIntent.uSessionId = 0;
      paramIntent.vMsg = ConfigSystemImpl.a(paramIntent.lUin, String.valueOf(AppSetting.a()), getAppRuntime().getApplication());
      paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.VideoConfigServlet
 * JD-Core Version:    0.7.0.1
 */