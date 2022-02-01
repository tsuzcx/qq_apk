package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Address
  extends MessageNano
{
  private static volatile Address[] _emptyArray;
  public int bitrate;
  public String format;
  public String url;
  
  public Address()
  {
    clear();
  }
  
  public static Address[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new Address[0];
      }
      return _emptyArray;
    }
  }
  
  public static Address parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new Address().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static Address parseFrom(byte[] paramArrayOfByte)
  {
    return (Address)MessageNano.mergeFrom(new Address(), paramArrayOfByte);
  }
  
  public Address clear()
  {
    this.url = "";
    this.bitrate = 0;
    this.format = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.url.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.url);
    }
    j = i;
    if (this.bitrate != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, this.bitrate);
    }
    i = j;
    if (!this.format.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.format);
    }
    return i;
  }
  
  public Address mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.url = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.bitrate = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      this.format = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.url.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.url);
    }
    if (this.bitrate != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, this.bitrate);
    }
    if (!this.format.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.format);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Address
 * JD-Core Version:    0.7.0.1
 */