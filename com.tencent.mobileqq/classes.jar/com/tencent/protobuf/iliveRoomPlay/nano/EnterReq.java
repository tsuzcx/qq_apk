package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnterReq
  extends MessageNano
{
  private static volatile EnterReq[] _emptyArray;
  public String machine;
  public long openLiveType;
  public String programId;
  public long roomid;
  public String source;
  
  public EnterReq()
  {
    clear();
  }
  
  public static EnterReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new EnterReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static EnterReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new EnterReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static EnterReq parseFrom(byte[] paramArrayOfByte)
  {
    return (EnterReq)MessageNano.mergeFrom(new EnterReq(), paramArrayOfByte);
  }
  
  public EnterReq clear()
  {
    this.roomid = 0L;
    this.source = "";
    this.programId = "";
    this.machine = "";
    this.openLiveType = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomid);
    }
    j = i;
    if (!this.source.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.source);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.programId);
    }
    j = i;
    if (!this.machine.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.machine);
    }
    i = j;
    if (this.openLiveType != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, this.openLiveType);
    }
    return i;
  }
  
  public EnterReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.roomid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.source = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.machine = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.openLiveType = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomid);
    }
    if (!this.source.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.source);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.programId);
    }
    if (!this.machine.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.machine);
    }
    if (this.openLiveType != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.openLiveType);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.EnterReq
 * JD-Core Version:    0.7.0.1
 */