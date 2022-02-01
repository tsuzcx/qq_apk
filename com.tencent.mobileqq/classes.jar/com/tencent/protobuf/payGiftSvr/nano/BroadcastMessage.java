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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BroadcastMessage[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.appid != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.appid);
    }
    j = i;
    if (this.type != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.type);
    }
    i = j;
    if (this.personGift != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.personGift);
    }
    j = i;
    if (this.overGift != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, this.overGift);
    }
    return j;
  }
  
  public BroadcastMessage mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.appid = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.type = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        if (this.personGift == null) {
          this.personGift = new BroadcastPersonGift();
        }
        paramCodedInputByteBufferNano.readMessage(this.personGift);
        break;
      }
      if (this.overGift == null) {
        this.overGift = new BroadcastOverGift();
      }
      paramCodedInputByteBufferNano.readMessage(this.overGift);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.appid != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.appid);
    }
    if (this.type != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.type);
    }
    if (this.personGift != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.personGift);
    }
    if (this.overGift != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, this.overGift);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.BroadcastMessage
 * JD-Core Version:    0.7.0.1
 */