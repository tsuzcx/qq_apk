package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class PushOnVideoRes
  extends ExtendableMessageNano<PushOnVideoRes>
{
  public int a;
  public int b;
  public long c;
  public long d;
  public int e;
  
  public PushOnVideoRes()
  {
    a();
  }
  
  public PushOnVideoRes a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0L;
    this.d = 0L;
    this.e = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushOnVideoRes a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
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
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d);
    int k = this.e;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.PushOnVideoRes
 * JD-Core Version:    0.7.0.1
 */