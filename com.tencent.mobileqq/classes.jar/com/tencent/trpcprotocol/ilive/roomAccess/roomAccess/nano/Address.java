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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new Address[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.url.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.url);
    }
    int k = this.bitrate;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
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
      if (i == 0) {
        break;
      }
      if (i != 10)
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
            this.format = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.bitrate = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.url = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.url.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.url);
    }
    int i = this.bitrate;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    if (!this.format.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.format);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Address
 * JD-Core Version:    0.7.0.1
 */