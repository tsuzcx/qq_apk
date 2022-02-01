package com.tencent.mobileqq.richmedia.conn;

import com.tencent.av.business.handler.AudioTrans;
import com.tencent.av.business.handler.AudioTrans.PBBytes;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;

public class SubTitleProtocoDataCodec
{
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    a(arrayOfByte);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length <= 60)) {
      localObject1 = null;
    }
    try
    {
      paramArrayOfByte = AudioTrans.a(paramArrayOfByte);
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        int i = 0;
        continue;
        int j = 0;
      }
    }
    QLog.e("SubTitleProtocoDataCodec", 2, "decodeS2CData OOM!!");
    paramArrayOfByte = (byte[])localObject1;
    localObject2 = paramArrayOfByte.a;
    Object localObject1 = paramArrayOfByte.b;
    paramArrayOfByte = new AudioTransClientTransInfo.IntHead();
    try
    {
      paramArrayOfByte = (AudioTransClientTransInfo.IntHead)paramArrayOfByte.mergeFrom((byte[])localObject2);
      if (!paramArrayOfByte.uint32_error_no.has()) {
        break label411;
      }
      i = paramArrayOfByte.uint32_error_no.get();
      if (!paramArrayOfByte.enum_body_type.has()) {
        break label416;
      }
      j = paramArrayOfByte.enum_body_type.get();
      long l = 0L;
      if (paramArrayOfByte.str_session_id.has()) {
        l = Long.valueOf(paramArrayOfByte.str_session_id.get()).longValue();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive result:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" sessionid:");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(" bodyType:");
      ((StringBuilder)localObject2).append(j);
      QLog.d("SubTitleProtocoDataCodec", 2, ((StringBuilder)localObject2).toString());
      localObject1 = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom((byte[])localObject1);
      if (i == 0)
      {
        if ((j == 10) && (QLog.isColorLevel()))
        {
          QLog.d("PeakAudioTransHandler", 2, "decodeS2CData INT_C2S_HEART_BEAT_RSP heartbeat !");
          return false;
        }
      }
      else
      {
        localObject1 = (AudioTransClientTransInfo.IntC2SFailedRsp)((AudioTransClientTransInfo.IntRspBody)localObject1).msg_failed_rsp.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("create session rsp fail msg: ");
        ((StringBuilder)localObject2).append(paramArrayOfByte.uint32_error_no.get());
        ((StringBuilder)localObject2).append(" uint32_errcode = ");
        ((StringBuilder)localObject2).append(((AudioTransClientTransInfo.IntC2SFailedRsp)localObject1).uint32_errcode.get());
        ((StringBuilder)localObject2).append(" str_errmsg = ");
        ((StringBuilder)localObject2).append(((AudioTransClientTransInfo.IntC2SFailedRsp)localObject1).str_errmsg.get());
        QLog.d("SubTitleProtocoDataCodec", 2, ((StringBuilder)localObject2).toString());
        return false;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeS2CData exception = ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      QLog.e("SubTitleProtocoDataCodec", 2, ((StringBuilder)localObject1).toString(), paramArrayOfByte);
    }
    return false;
    if (QLog.isColorLevel()) {
      QLog.e("PeakAudioTransHandler", 2, "decodeS2CData data error");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.SubTitleProtocoDataCodec
 * JD-Core Version:    0.7.0.1
 */