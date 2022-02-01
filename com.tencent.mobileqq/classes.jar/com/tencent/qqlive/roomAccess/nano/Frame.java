package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Frame
  extends ExtendableMessageNano<Frame>
{
  private static volatile Frame[] d;
  public int a;
  public Address[] b;
  public String c;
  
  public Frame()
  {
    b();
  }
  
  public static Frame[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new Frame[0];
        }
      }
    }
    return d;
  }
  
  public Frame a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          Address[] arrayOfAddress = this.b;
          if (arrayOfAddress == null) {
            i = 0;
          } else {
            i = arrayOfAddress.length;
          }
          arrayOfAddress = new Address[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfAddress, 0, i);
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
          this.b = arrayOfAddress;
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public Frame b()
  {
    this.a = 0;
    this.b = Address.a();
    this.c = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.b;
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
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.b;
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
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.Frame
 * JD-Core Version:    0.7.0.1
 */