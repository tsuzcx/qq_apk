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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">>onFinished enter byteRequest=");
    ((StringBuilder)localObject1).append(paramArrayOfByte1);
    ((StringBuilder)localObject1).append(" byteResponse=");
    ((StringBuilder)localObject1).append(paramArrayOfByte2);
    ((StringBuilder)localObject1).append(" errorCode =");
    ((StringBuilder)localObject1).append(paramInt);
    ab.c("BaseNetEngine", ((StringBuilder)localObject1).toString());
    Object localObject2 = null;
    StringBuilder localStringBuilder1 = null;
    int i = 0;
    int j = 0;
    if (paramArrayOfByte1 != null)
    {
      localObject1 = (Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class);
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((Request)localObject1).head != null) {
          i = ((Request)localObject1).head.requestId;
        }
      }
      if (localObject1 != null) {
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(((Request)localObject1).body, a.a(this.a));
      } else {
        paramArrayOfByte1 = null;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(">>onFinished request=");
      localStringBuilder2.append(localObject1);
      localStringBuilder2.append(" reqId=");
      localStringBuilder2.append(i);
      localStringBuilder2.append(" requestJce=");
      localStringBuilder2.append(paramArrayOfByte1);
      ab.c("BaseNetEngine", localStringBuilder2.toString());
      localObject1 = paramArrayOfByte1;
    }
    else
    {
      localObject1 = null;
    }
    paramArrayOfByte1 = localObject2;
    if (paramArrayOfByte2 != null)
    {
      paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
      paramArrayOfByte1 = localStringBuilder1;
      if (paramArrayOfByte2 != null) {
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte2.body, a.b(this.a));
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(">>onFinished response=");
      localStringBuilder1.append(paramArrayOfByte2);
      localStringBuilder1.append(" responseJce=");
      localStringBuilder1.append(paramArrayOfByte1);
      ab.c("BaseNetEngine", localStringBuilder1.toString());
    }
    this.a.a(i, paramInt, (JceStruct)localObject1, paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.b
 * JD-Core Version:    0.7.0.1
 */