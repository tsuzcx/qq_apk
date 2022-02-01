package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.aio.media.open.aio_media_open.ReqOpenIdentify;
import tencent.aio.media.open.aio_media_open.ReqOpenStart;
import tencent.aio.media.open.aio_media_open.ResultInfo;
import tencent.aio.media.open.aio_media_open.RspOpenIdentify;
import tencent.aio.media.open.aio_media_open.RspOpenStart;

public class TogetherBusinessServlet
  extends MSFServlet
{
  private TogetherBusinessServlet.ResultInfo a(aio_media_open.ResultInfo paramResultInfo)
  {
    int i;
    if (!paramResultInfo.uint32_result.has()) {
      i = -1;
    } else {
      i = paramResultInfo.uint32_result.get();
    }
    boolean bool;
    if (!paramResultInfo.bool_show_err.has()) {
      bool = false;
    } else {
      bool = paramResultInfo.bool_show_err.get();
    }
    if (!paramResultInfo.bytes_errmsg.has()) {
      paramResultInfo = "";
    } else {
      paramResultInfo = paramResultInfo.bytes_errmsg.get().toStringUtf8();
    }
    return new TogetherBusinessServlet.ResultInfo(i, paramResultInfo, bool);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        aio_media_open.RspOpenIdentify localRspOpenIdentify = new aio_media_open.RspOpenIdentify();
        localRspOpenIdentify.mergeFrom(paramFromServiceMsg);
        boolean bool = localRspOpenIdentify.bytes_button_text.has();
        localObject = "";
        if (!bool) {
          paramFromServiceMsg = "";
        } else {
          paramFromServiceMsg = localRspOpenIdentify.bytes_button_text.get().toStringUtf8();
        }
        if (localRspOpenIdentify.bytes_confirm_text.has()) {
          localObject = localRspOpenIdentify.bytes_confirm_text.get().toStringUtf8();
        }
        TogetherBusinessServlet.ResultInfo localResultInfo = null;
        if (localRspOpenIdentify.msg_result.has()) {
          localResultInfo = a((aio_media_open.ResultInfo)localRspOpenIdentify.msg_result.get());
        }
        int i;
        if (!localRspOpenIdentify.uint32_business_type.has()) {
          i = 0;
        } else {
          i = localRspOpenIdentify.uint32_business_type.get();
        }
        paramFromServiceMsg = new TogetherBusinessServlet.RspOpenIdentify(localResultInfo, paramFromServiceMsg, (String)localObject, i);
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("QQAIOMediaSvc.open_identify", paramFromServiceMsg);
        if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
          QLog.d("TogetherBusinessServlet", 2, new Object[] { "handleIdentifyPackage succsss=", paramFromServiceMsg });
        }
        notifyObserver(paramIntent, 12, true, (Bundle)localObject, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 12, false, null, null);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage error=", paramFromServiceMsg);
    }
    else
    {
      notifyObserver(paramIntent, 12, false, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage not ok");
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getBundleExtra("bundle");
    paramIntent = ((Bundle)localObject2).getString("req_data", "");
    Object localObject1 = ((Bundle)localObject2).getString("req_sign", "");
    long l = ((Bundle)localObject2).getLong("uin", -1L);
    int i = ((Bundle)localObject2).getInt("session_type", -1);
    localObject2 = new aio_media_open.ReqOpenIdentify();
    ((aio_media_open.ReqOpenIdentify)localObject2).enum_aio_type.set(i);
    ((aio_media_open.ReqOpenIdentify)localObject2).uint64_id.set(l);
    ((aio_media_open.ReqOpenIdentify)localObject2).bytes_req_data.set(ByteStringMicro.copyFromUtf8(paramIntent));
    ((aio_media_open.ReqOpenIdentify)localObject2).bytes_req_sign.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    paramIntent = ((aio_media_open.ReqOpenIdentify)localObject2).toByteArray();
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.setSSOCommand("QQAIOMediaSvc.open_identify");
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), TogetherBusinessServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("bundle", paramBundle);
    localNewIntent.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        aio_media_open.RspOpenStart localRspOpenStart = new aio_media_open.RspOpenStart();
        localRspOpenStart.mergeFrom(paramFromServiceMsg);
        int i;
        if (!localRspOpenStart.enum_jump_type.has()) {
          i = -1;
        } else {
          i = localRspOpenStart.enum_jump_type.get();
        }
        if (!localRspOpenStart.bytes_jump_url.has()) {
          paramFromServiceMsg = "";
        } else {
          paramFromServiceMsg = localRspOpenStart.bytes_jump_url.get().toStringUtf8();
        }
        localObject = null;
        if (localRspOpenStart.msg_result.has()) {
          localObject = a((aio_media_open.ResultInfo)localRspOpenStart.msg_result.get());
        }
        paramFromServiceMsg = new TogetherBusinessServlet.RspOpenStart((TogetherBusinessServlet.ResultInfo)localObject, i, paramFromServiceMsg);
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("QQAIOMediaSvc.open_start", paramFromServiceMsg);
        if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
          QLog.d("TogetherBusinessServlet", 2, new Object[] { "handleStartPackage succsss=", paramFromServiceMsg });
        }
        if (paramIntent.getBundleExtra("bundle") != null) {
          ((Bundle)localObject).putBundle("bundle", paramIntent.getBundleExtra("bundle"));
        }
        notifyObserver(paramIntent, 13, true, (Bundle)localObject, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 13, false, null, null);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("TogetherBusinessServlet", 2, "handleStartPackage error=", paramFromServiceMsg);
    }
    else
    {
      notifyObserver(paramIntent, 13, false, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessServlet", 2, "handleStartPackage not ok");
      }
    }
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getBundleExtra("bundle");
    paramIntent = ((Bundle)localObject2).getString("req_data", "");
    Object localObject1 = ((Bundle)localObject2).getString("req_sign", "");
    long l = ((Bundle)localObject2).getLong("uin", -1L);
    int i = ((Bundle)localObject2).getInt("session_type", -1);
    localObject2 = new aio_media_open.ReqOpenStart();
    ((aio_media_open.ReqOpenStart)localObject2).enum_aio_type.set(i);
    ((aio_media_open.ReqOpenStart)localObject2).uint64_id.set(l);
    ((aio_media_open.ReqOpenStart)localObject2).bytes_req_data.set(ByteStringMicro.copyFromUtf8(paramIntent));
    ((aio_media_open.ReqOpenStart)localObject2).bytes_req_sign.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    paramIntent = ((aio_media_open.ReqOpenStart)localObject2).toByteArray();
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.setSSOCommand("QQAIOMediaSvc.open_start");
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
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
      QLog.d("TogetherBusinessServlet", 2, localStringBuilder.toString());
    }
    if ("QQAIOMediaSvc.open_identify".equals(str2))
    {
      a(paramIntent, paramFromServiceMsg);
      return;
    }
    if ("QQAIOMediaSvc.open_start".equals(str2)) {
      b(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("req:");
      localStringBuilder.append(str);
      QLog.d("TogetherBusinessServlet", 2, localStringBuilder.toString());
    }
    if ("QQAIOMediaSvc.open_identify".equals(str))
    {
      a(paramIntent, paramPacket);
      return;
    }
    if ("QQAIOMediaSvc.open_start".equals(str)) {
      b(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet
 * JD-Core Version:    0.7.0.1
 */