package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PullViewInfoCgiRsp
  extends ExtendableMessageNano<PullViewInfoCgiRsp>
{
  public ViewInfo[] a;
  public long b;
  public int c;
  public String d;
  
  public PullViewInfoCgiRsp()
  {
    a();
  }
  
  public PullViewInfoCgiRsp a()
  {
    this.a = ViewInfo.a();
    this.b = 0L;
    this.c = 0;
    this.d = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PullViewInfoCgiRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        ViewInfo[] arrayOfViewInfo = this.a;
        if (arrayOfViewInfo == null) {
          i = 0;
        } else {
          i = arrayOfViewInfo.length;
        }
        arrayOfViewInfo = new ViewInfo[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfViewInfo, 0, i);
          j = i;
        }
        while (j < arrayOfViewInfo.length - 1)
        {
          arrayOfViewInfo[j] = new ViewInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfViewInfo[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfViewInfo[j] = new ViewInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfViewInfo[j]);
        this.a = arrayOfViewInfo;
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
        k = 0;
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
    int k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PullViewInfoCgiRsp
 * JD-Core Version:    0.7.0.1
 */