package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ExtData
  extends ExtendableMessageNano<ExtData>
{
  public ExtDataInfo[] a;
  public long b;
  
  public ExtData()
  {
    a();
  }
  
  public ExtData a()
  {
    this.a = ExtDataInfo.a();
    this.b = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ExtData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        ExtDataInfo[] arrayOfExtDataInfo = this.a;
        if (arrayOfExtDataInfo == null) {
          i = 0;
        } else {
          i = arrayOfExtDataInfo.length;
        }
        arrayOfExtDataInfo = new ExtDataInfo[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfExtDataInfo, 0, i);
          j = i;
        }
        while (j < arrayOfExtDataInfo.length - 1)
        {
          arrayOfExtDataInfo[j] = new ExtDataInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfExtDataInfo[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfExtDataInfo[j] = new ExtDataInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfExtDataInfo[j]);
        this.a = arrayOfExtDataInfo;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.a;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    long l = this.b;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.ExtData
 * JD-Core Version:    0.7.0.1
 */