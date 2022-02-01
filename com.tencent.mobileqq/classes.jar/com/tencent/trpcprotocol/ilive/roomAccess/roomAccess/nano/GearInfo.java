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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GearInfo[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.level;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.bitrate;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.name = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.bitrate = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.level = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.level;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.bitrate;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.name);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.GearInfo
 * JD-Core Version:    0.7.0.1
 */