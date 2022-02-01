package com.tencent.qqlive.iliveMidendRoomRankSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import java.util.Map;

public final class GetRankUserInfoRsp
  extends ExtendableMessageNano<GetRankUserInfoRsp>
{
  public Map<Long, LiveRankUserInfo> a;
  
  public GetRankUserInfoRsp()
  {
    a();
  }
  
  public GetRankUserInfoRsp a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRankUserInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else {
        this.a = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.a, localMapFactory, 4, 11, new LiveRankUserInfo(), 8, 18);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Map localMap = this.a;
    int i = j;
    if (localMap != null) {
      i = j + InternalNano.computeMapFieldSize(localMap, 1, 4, 11);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Map localMap = this.a;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 1, 4, 11);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveMidendRoomRankSvr.nano.GetRankUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */