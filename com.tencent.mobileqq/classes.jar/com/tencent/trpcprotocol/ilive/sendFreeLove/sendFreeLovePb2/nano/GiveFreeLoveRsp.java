package com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLovePb2.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GiveFreeLoveRsp
  extends ExtendableMessageNano<GiveFreeLoveRsp>
{
  public int a;
  
  public GiveFreeLoveRsp()
  {
    a();
  }
  
  public GiveFreeLoveRsp a()
  {
    this.a = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GiveFreeLoveRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLovePb2.nano.GiveFreeLoveRsp
 * JD-Core Version:    0.7.0.1
 */