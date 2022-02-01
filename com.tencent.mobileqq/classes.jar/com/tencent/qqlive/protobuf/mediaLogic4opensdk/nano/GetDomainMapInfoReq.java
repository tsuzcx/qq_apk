package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetDomainMapInfoReq
  extends ExtendableMessageNano<GetDomainMapInfoReq>
{
  public int a;
  public int b;
  public int c;
  
  public GetDomainMapInfoReq()
  {
    a();
  }
  
  public GetDomainMapInfoReq a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetDomainMapInfoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetDomainMapInfoReq
 * JD-Core Version:    0.7.0.1
 */