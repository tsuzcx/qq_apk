package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class BroadcastMessage
  extends ExtendableMessageNano<BroadcastMessage>
{
  public int a;
  public int b;
  public BroadcastPersonGift c;
  public BroadcastOverGift d;
  
  public BroadcastMessage()
  {
    a();
  }
  
  public BroadcastMessage a()
  {
    this.a = 0;
    this.b = 0;
    this.c = null;
    this.d = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BroadcastMessage a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new BroadcastOverGift();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new BroadcastPersonGift();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    Object localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.BroadcastMessage
 * JD-Core Version:    0.7.0.1
 */