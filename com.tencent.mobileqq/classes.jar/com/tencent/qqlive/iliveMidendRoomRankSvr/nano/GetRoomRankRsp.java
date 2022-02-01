package com.tencent.qqlive.iliveMidendRoomRankSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import com.google.protobuf.nano.MessageNano;
import java.util.Map;

public final class GetRoomRankRsp
  extends ExtendableMessageNano<GetRoomRankRsp>
{
  public CurRankInfo a;
  public Map<Long, LiveRankUserInfo> b;
  
  public GetRoomRankRsp()
  {
    a();
  }
  
  public GetRoomRankRsp a()
  {
    this.a = null;
    this.b = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRoomRankRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    MapFactories.MapFactory localMapFactory = MapFactories.getMapFactory();
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.b, localMapFactory, 4, 11, new LiveRankUserInfo(), 8, 18);
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new CurRankInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + InternalNano.computeMapFieldSize((Map)localObject, 2, 4, 11);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, (Map)localObject, 2, 4, 11);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveMidendRoomRankSvr.nano.GetRoomRankRsp
 * JD-Core Version:    0.7.0.1
 */