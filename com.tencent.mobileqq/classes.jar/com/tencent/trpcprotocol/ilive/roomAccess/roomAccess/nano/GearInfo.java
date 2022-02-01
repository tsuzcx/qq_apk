package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GearInfo
  extends MessageNano
{
  private static volatile GearInfo[] _emptyArray;
  public int bitrate;
  public int level;
  public String name;
  
  public GearInfo()
  {
    clear();
  }
  
  public static GearInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GearInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static GearInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GearInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GearInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (GearInfo)MessageNano.mergeFrom(new GearInfo(), paramArrayOfByte);
  }
  
  public GearInfo clear()
  {
    this.level = 0;
    this.bitrate = 0;
    this.name = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.level != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.level);
    }
    j = i;
    if (this.bitrate != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, this.bitrate);
    }
    i = j;
    if (!this.name.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.name);
    }
    return i;
  }
  
  public GearInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.level = paramCodedInputByteBufferNano.readInt32();
        break;
      case 16: 
        this.bitrate = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      this.name = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.level != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.level);
    }
    if (this.bitrate != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, this.bitrate);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.name);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.GearInfo
 * JD-Core Version:    0.7.0.1
 */