package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PendantInfoData
  extends ExtendableMessageNano<PendantInfoData>
{
  public PendantInfo[] a;
  public String b;
  
  public PendantInfoData()
  {
    a();
  }
  
  public PendantInfoData a()
  {
    this.a = PendantInfo.a();
    this.b = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PendantInfoData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        PendantInfo[] arrayOfPendantInfo = this.a;
        if (arrayOfPendantInfo == null) {
          i = 0;
        } else {
          i = arrayOfPendantInfo.length;
        }
        arrayOfPendantInfo = new PendantInfo[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfPendantInfo, 0, i);
          j = i;
        }
        while (j < arrayOfPendantInfo.length - 1)
        {
          arrayOfPendantInfo[j] = new PendantInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfPendantInfo[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfPendantInfo[j] = new PendantInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfPendantInfo[j]);
        this.a = arrayOfPendantInfo;
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
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
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
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PendantInfoData
 * JD-Core Version:    0.7.0.1
 */