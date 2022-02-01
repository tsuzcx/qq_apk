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
  public String definition;
  public int level;
  
  public Frame()
  {
    clear();
  }
  
  public static Frame[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new Frame[0];
        }
      }
    }
    return _emptyArray;
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
    this.definition = "";
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
    Object localObject = this.addresses;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.addresses;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (!this.definition.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.definition);
    }
    return i;
  }
  
  public Frame mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.definition = paramCodedInputByteBufferNano.readString();
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          Address[] arrayOfAddress = this.addresses;
          if (arrayOfAddress == null) {
            i = 0;
          } else {
            i = arrayOfAddress.length;
          }
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
          arrayOfAddress[j] = new Address();
          paramCodedInputByteBufferNano.readMessage(arrayOfAddress[j]);
          this.addresses = arrayOfAddress;
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
    Object localObject = this.addresses;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.addresses;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!this.definition.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.definition);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Frame
 * JD-Core Version:    0.7.0.1
 */