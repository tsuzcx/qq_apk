package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BusinessDataContent
  extends MessageNano
{
  public BusinessDataItem[] a;
  
  public BusinessDataContent()
  {
    a();
  }
  
  public BusinessDataContent a()
  {
    this.a = BusinessDataItem.a();
    this.cachedSize = -1;
    return this;
  }
  
  public BusinessDataContent a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
      if (this.a == null) {}
      BusinessDataItem[] arrayOfBusinessDataItem;
      for (i = 0;; i = this.a.length)
      {
        arrayOfBusinessDataItem = new BusinessDataItem[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfBusinessDataItem, 0, i);
          j = i;
        }
        while (j < arrayOfBusinessDataItem.length - 1)
        {
          arrayOfBusinessDataItem[j] = new BusinessDataItem();
          paramCodedInputByteBufferNano.readMessage(arrayOfBusinessDataItem[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfBusinessDataItem[j] = new BusinessDataItem();
      paramCodedInputByteBufferNano.readMessage(arrayOfBusinessDataItem[j]);
      this.a = arrayOfBusinessDataItem;
    }
  }
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = i;
    if (this.a != null)
    {
      k = i;
      if (this.a.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.a.length) {
            break;
          }
          BusinessDataItem localBusinessDataItem = this.a[j];
          k = i;
          if (localBusinessDataItem != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localBusinessDataItem);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a != null) && (this.a.length > 0))
    {
      int i = 0;
      while (i < this.a.length)
      {
        BusinessDataItem localBusinessDataItem = this.a[i];
        if (localBusinessDataItem != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localBusinessDataItem);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.BusinessDataContent
 * JD-Core Version:    0.7.0.1
 */