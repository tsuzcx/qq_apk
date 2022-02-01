package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SwitchStreamRequest
  extends MessageNano
{
  private static volatile SwitchStreamRequest[] _emptyArray;
  public String format;
  public int level;
  public long roomId;
  
  public SwitchStreamRequest()
  {
    clear();
  }
  
  public static SwitchStreamRequest[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new SwitchStreamRequest[0];
      }
      return _emptyArray;
    }
  }
  
  public static SwitchStreamRequest parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SwitchStreamRequest().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SwitchStreamRequest parseFrom(byte[] paramArrayOfByte)
  {
    return (SwitchStreamRequest)MessageNano.mergeFrom(new SwitchStreamRequest(), paramArrayOfByte);
  }
  
  public SwitchStreamRequest clear()
  {
    this.roomId = 0L;
    this.format = "";
    this.level = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomId);
    }
    j = i;
    if (!this.format.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.format);
    }
    i = j;
    if (this.level != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, this.level);
    }
    return i;
  }
  
  public SwitchStreamRequest mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.format = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.level = paramCodedInputByteBufferNano.readInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomId);
    }
    if (!this.format.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.format);
    }
    if (this.level != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, this.level);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.SwitchStreamRequest
 * JD-Core Version:    0.7.0.1
 */