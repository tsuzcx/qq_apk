package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class SyncBroadcastInfo
  extends ExtendableMessageNano<SyncBroadcastInfo>
{
  public int a;
  public ChangeAnchorStatusReq b;
  public long c;
  public int d;
  public int e;
  public byte[] f;
  public StreamParamsKv[] g;
  
  public SyncBroadcastInfo()
  {
    a();
  }
  
  public SyncBroadcastInfo a()
  {
    this.a = 0;
    this.b = null;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = StreamParamsKv.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SyncBroadcastInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 50)
                {
                  if (i != 58)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else
                  {
                    int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
                    StreamParamsKv[] arrayOfStreamParamsKv = this.g;
                    if (arrayOfStreamParamsKv == null) {
                      i = 0;
                    } else {
                      i = arrayOfStreamParamsKv.length;
                    }
                    arrayOfStreamParamsKv = new StreamParamsKv[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.g, 0, arrayOfStreamParamsKv, 0, i);
                      j = i;
                    }
                    while (j < arrayOfStreamParamsKv.length - 1)
                    {
                      arrayOfStreamParamsKv[j] = new StreamParamsKv();
                      paramCodedInputByteBufferNano.readMessage(arrayOfStreamParamsKv[j]);
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfStreamParamsKv[j] = new StreamParamsKv();
                    paramCodedInputByteBufferNano.readMessage(arrayOfStreamParamsKv[j]);
                    this.g = arrayOfStreamParamsKv;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBytes();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new ChangeAnchorStatusReq();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    Object localObject = this.b;
    k = i;
    if (localObject != null) {
      k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    long l = this.c;
    j = k;
    if (l != 0L) {
      j = k + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    i = j;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    localObject = this.g;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.g;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
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
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.g;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.SyncBroadcastInfo
 * JD-Core Version:    0.7.0.1
 */