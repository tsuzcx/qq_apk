package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ProgramInfo
  extends MessageNano
{
  private static volatile ProgramInfo[] _emptyArray;
  public String id;
  public long roomid;
  public int state;
  public long uid;
  
  public ProgramInfo()
  {
    clear();
  }
  
  public static ProgramInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new ProgramInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static ProgramInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new ProgramInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static ProgramInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (ProgramInfo)MessageNano.mergeFrom(new ProgramInfo(), paramArrayOfByte);
  }
  
  public ProgramInfo clear()
  {
    this.id = "";
    this.roomid = 0L;
    this.uid = 0L;
    this.state = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.id.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.id);
    }
    j = i;
    if (this.roomid != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomid);
    }
    i = j;
    if (this.uid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.uid);
    }
    j = i;
    if (this.state != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, this.state);
    }
    return j;
  }
  
  public ProgramInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 10: 
        this.id = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.roomid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.uid = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.state = paramCodedInputByteBufferNano.readInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.id.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.id);
    }
    if (this.roomid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.roomid);
    }
    if (this.uid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.uid);
    }
    if (this.state != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, this.state);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramInfo
 * JD-Core Version:    0.7.0.1
 */