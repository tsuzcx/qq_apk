package com.tencent.qlive.iliveMetricsSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class IliveInfo
  extends ExtendableMessageNano<IliveInfo>
{
  public byte[] a;
  public long b;
  public long c;
  public DataItem[] d;
  
  public IliveInfo()
  {
    a();
  }
  
  public IliveInfo a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = 0L;
    this.c = 0L;
    this.d = DataItem.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public IliveInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              DataItem[] arrayOfDataItem = this.d;
              if (arrayOfDataItem == null) {
                i = 0;
              } else {
                i = arrayOfDataItem.length;
              }
              arrayOfDataItem = new DataItem[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, arrayOfDataItem, 0, i);
                j = i;
              }
              while (j < arrayOfDataItem.length - 1)
              {
                arrayOfDataItem[j] = new DataItem();
                paramCodedInputByteBufferNano.readMessage(arrayOfDataItem[j]);
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              arrayOfDataItem[j] = new DataItem();
              paramCodedInputByteBufferNano.readMessage(arrayOfDataItem[j]);
              this.d = arrayOfDataItem;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(1, this.a);
    }
    long l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    Object localObject = this.d;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.d;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
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
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.d;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qlive.iliveMetricsSvr.nano.IliveInfo
 * JD-Core Version:    0.7.0.1
 */