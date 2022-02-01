package com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import java.util.Map;

public final class ExtInfo
  extends ExtendableMessageNano<ExtInfo>
{
  public Map<String, byte[]> a;
  public int b;
  
  public ExtInfo()
  {
    a();
  }
  
  public ExtInfo a()
  {
    this.a = null;
    this.b = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ExtInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (i != 16)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.a, localMapFactory, 9, 12, null, 10, 18);
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
      i = j + InternalNano.computeMapFieldSize(localMap, 1, 9, 12);
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Map localMap = this.a;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 1, 9, 12);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.ExtInfo
 * JD-Core Version:    0.7.0.1
 */