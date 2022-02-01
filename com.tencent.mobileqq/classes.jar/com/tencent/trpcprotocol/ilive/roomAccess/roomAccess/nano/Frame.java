package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Frame
  extends MessageNano
{
  private static volatile Frame[] _emptyArray;
  public Address[] addresses;
  public int level;
  
  public Frame()
  {
    clear();
  }
  
  public static Frame[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new Frame[0];
      }
      return _emptyArray;
    }
  }
  
  public static Frame parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new Frame().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static Frame parseFrom(byte[] paramArrayOfByte)
  {
    return (Frame)MessageNano.mergeFrom(new Frame(), paramArrayOfByte);
  }
  
  public Frame clear()
  {
    this.level = 0;
    this.addresses = Address.emptyArray();
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
    if (this.addresses != null)
    {
      j = i;
      if (this.addresses.length > 0)
      {
        j = 0;
        while (j < this.addresses.length)
        {
          Address localAddress = this.addresses[j];
          int k = i;
          if (localAddress != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localAddress);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public Frame mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
      if (this.addresses == null) {}
      Address[] arrayOfAddress;
      for (i = 0;; i = this.addresses.length)
      {
        arrayOfAddress = new Address[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.addresses, 0, arrayOfAddress, 0, i);
          j = i;
        }
        while (j < arrayOfAddress.length - 1)
        {
          arrayOfAddress[j] = new Address();
          paramCodedInputByteBufferNano.readMessage(arrayOfAddress[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfAddress[j] = new Address();
      paramCodedInputByteBufferNano.readMessage(arrayOfAddress[j]);
      this.addresses = arrayOfAddress;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.level != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.level);
    }
    if ((this.addresses != null) && (this.addresses.length > 0))
    {
      int i = 0;
      while (i < this.addresses.length)
      {
        Address localAddress = this.addresses[i];
        if (localAddress != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localAddress);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Frame
 * JD-Core Version:    0.7.0.1
 */