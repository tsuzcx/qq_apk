package com.tencent.tmassistantbase.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.util.ab;

class b
  extends PostHttpRequest
{
  b(a parama) {}
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    ab.c("BaseNetEngine", ">>onFinished enter byteRequest=" + paramArrayOfByte1 + " byteResponse=" + paramArrayOfByte2 + " errorCode =" + paramInt);
    int i;
    if (paramArrayOfByte1 != null)
    {
      localObject1 = (Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class);
      if ((localObject1 != null) && (((Request)localObject1).head != null))
      {
        i = ((Request)localObject1).head.requestId;
        if (localObject1 != null)
        {
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(((Request)localObject1).body, a.a(this.a));
          label107:
          ab.c("BaseNetEngine", ">>onFinished request=" + localObject1 + " reqId=" + i + " requestJce=" + paramArrayOfByte1);
        }
      }
    }
    for (Object localObject1 = paramArrayOfByte1;; localObject1 = null)
    {
      paramArrayOfByte1 = localObject3;
      if (paramArrayOfByte2 != null)
      {
        paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        paramArrayOfByte1 = localObject2;
        if (paramArrayOfByte2 != null) {
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte2.body, a.b(this.a));
        }
        ab.c("BaseNetEngine", ">>onFinished response=" + paramArrayOfByte2 + " responseJce=" + paramArrayOfByte1);
      }
      this.a.a(i, paramInt, (JceStruct)localObject1, paramArrayOfByte1);
      return;
      paramArrayOfByte1 = null;
      break label107;
      i = 0;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.b
 * JD-Core Version:    0.7.0.1
 */