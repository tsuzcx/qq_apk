package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class AnchorGearChangeReq
  extends ExtendableMessageNano<AnchorGearChangeReq>
{
  public long a;
  public long b;
  public int c;
  public int d;
  
  public AnchorGearChangeReq()
  {
    a();
  }
  
  public AnchorGearChangeReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AnchorGearChangeReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt64();
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
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    int k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.AnchorGearChangeReq
 * JD-Core Version:    0.7.0.1
 */