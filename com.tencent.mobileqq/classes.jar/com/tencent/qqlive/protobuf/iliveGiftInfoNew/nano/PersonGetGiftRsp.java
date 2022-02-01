package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class PersonGetGiftRsp
  extends ExtendableMessageNano<PersonGetGiftRsp>
{
  public int a;
  public GiftInfoRsp b;
  public int c;
  
  public PersonGetGiftRsp()
  {
    a();
  }
  
  public PersonGetGiftRsp a()
  {
    this.a = 0;
    this.b = null;
    this.c = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PersonGetGiftRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new GiftInfoRsp();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
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
    GiftInfoRsp localGiftInfoRsp = this.b;
    j = i;
    if (localGiftInfoRsp != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localGiftInfoRsp);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    GiftInfoRsp localGiftInfoRsp = this.b;
    if (localGiftInfoRsp != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localGiftInfoRsp);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.PersonGetGiftRsp
 * JD-Core Version:    0.7.0.1
 */