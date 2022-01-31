package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.text.TextUtils;
import bgyh;
import bgyi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ProtoBufRequest
{
  public static final String TAG = "ProtoBufRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProtoBufRequest", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
      }
    }
    return null;
  }
  
  public static long getNewSeq()
  {
    return atomicInteger.getAndIncrement();
  }
  
  public byte[] encode(Intent paramIntent, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("req traceId is null!");
    }
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(paramInt);
    localStQWebReq.qua.set(bgyi.a());
    localStQWebReq.deviceInfo.set(bgyh.a().c());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
    if (!TextUtils.isEmpty(paramString)) {
      localStQWebReq.traceid.set(paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra("traceid", paramString);
    }
    return localStQWebReq.toByteArray();
  }
  
  public abstract byte[] getBusiBuf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ProtoBufRequest
 * JD-Core Version:    0.7.0.1
 */