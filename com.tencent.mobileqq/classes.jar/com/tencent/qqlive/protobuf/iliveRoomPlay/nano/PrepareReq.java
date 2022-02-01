package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class PrepareReq
  extends ExtendableMessageNano<PrepareReq>
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public PrepareReq()
  {
    a();
  }
  
  public PrepareReq a()
  {
    this.a = 0;
    this.b = "";
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PrepareReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (i != 42)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readInt32();
                }
              }
              else {
                this.b = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.e = paramCodedInputByteBufferNano.readInt32();
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
        this.a = paramCodedInputByteBufferNano.readInt32();
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
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.b);
    }
    k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(6, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.b);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareReq
 * JD-Core Version:    0.7.0.1
 */