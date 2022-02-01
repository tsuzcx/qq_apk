package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class RecordLiveCodeReq
  extends ExtendableMessageNano<RecordLiveCodeReq>
{
  public long a;
  public int b;
  public long c;
  
  public RecordLiveCodeReq()
  {
    a();
  }
  
  public RecordLiveCodeReq a()
  {
    this.a = 0L;
    this.b = 0;
    this.c = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RecordLiveCodeReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeInt32Size(2, this.b);
    long l = this.c;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeInt32(2, this.b);
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.RecordLiveCodeReq
 * JD-Core Version:    0.7.0.1
 */