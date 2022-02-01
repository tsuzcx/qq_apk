package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Tlv
  extends MessageNano
{
  private static volatile Tlv[] _emptyArray;
  public String str;
  public int tid;
  public long value;
  
  public Tlv()
  {
    clear();
  }
  
  public static Tlv[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new Tlv[0];
      }
      return _emptyArray;
    }
  }
  
  public static Tlv parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new Tlv().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static Tlv parseFrom(byte[] paramArrayOfByte)
  {
    return (Tlv)MessageNano.mergeFrom(new Tlv(), paramArrayOfByte);
  }
  
  public Tlv clear()
  {
    this.tid = 0;
    this.value = 0L;
    this.str = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.tid != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.tid);
    }
    j = i;
    if (this.value != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, this.value);
    }
    i = j;
    if (!this.str.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.str);
    }
    return i;
  }
  
  public Tlv mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.tid = paramCodedInputByteBufferNano.readInt32();
        break;
      case 16: 
        this.value = paramCodedInputByteBufferNano.readInt64();
        break;
      }
      this.str = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.tid != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.tid);
    }
    if (this.value != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, this.value);
    }
    if (!this.str.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.str);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.Tlv
 * JD-Core Version:    0.7.0.1
 */