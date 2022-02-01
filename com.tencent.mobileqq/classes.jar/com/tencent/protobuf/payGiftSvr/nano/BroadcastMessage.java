package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BroadcastMessage
  extends MessageNano
{
  private static volatile BroadcastMessage[] _emptyArray;
  public int appid;
  public BroadcastOverGift overGift;
  public BroadcastPersonGift personGift;
  public int type;
  
  public BroadcastMessage()
  {
    clear();
  }
  
  public static BroadcastMessage[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BroadcastMessage[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static BroadcastMessage parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BroadcastMessage().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BroadcastMessage parseFrom(byte[] paramArrayOfByte)
  {
    return (BroadcastMessage)MessageNano.mergeFrom(new BroadcastMessage(), paramArrayOfByte);
  }
  
  public BroadcastMessage clear()
  {
    this.appid = 0;
    this.type = 0;
    this.personGift = null;
    this.overGift = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.appid;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.type;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    Object localObject = this.personGift;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.overGift;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    return j;
  }
  
  public BroadcastMessage mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              if (this.overGift == null) {
                this.overGift = new BroadcastOverGift();
              }
              paramCodedInputByteBufferNano.readMessage(this.overGift);
            }
          }
          else
          {
            if (this.personGift == null) {
              this.personGift = new BroadcastPersonGift();
            }
            paramCodedInputByteBufferNano.readMessage(this.personGift);
          }
        }
        else {
          this.type = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.appid = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.appid;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.type;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    Object localObject = this.personGift;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    localObject = this.overGift;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.BroadcastMessage
 * JD-Core Version:    0.7.0.1
 */