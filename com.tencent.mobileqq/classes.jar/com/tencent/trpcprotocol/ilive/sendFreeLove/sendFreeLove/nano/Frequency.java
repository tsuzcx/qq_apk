package com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class Frequency
  extends ExtendableMessageNano<Frequency>
{
  public long a;
  public long b;
  
  public Frequency()
  {
    a();
  }
  
  public Frequency a()
  {
    this.a = 0L;
    this.b = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public Frequency a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.Frequency
 * JD-Core Version:    0.7.0.1
 */