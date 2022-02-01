package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GameCircleVideoNotifyInfo
  extends ExtendableMessageNano<GameCircleVideoNotifyInfo>
{
  public byte[] a;
  public byte[] b;
  public int c;
  public VideoResInfo[] d;
  public int e;
  public long f;
  
  public GameCircleVideoNotifyInfo()
  {
    a();
  }
  
  public GameCircleVideoNotifyInfo a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0;
    this.d = VideoResInfo.a();
    this.e = 0;
    this.f = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GameCircleVideoNotifyInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              VideoResInfo[] arrayOfVideoResInfo = this.d;
              if (arrayOfVideoResInfo == null) {
                i = 0;
              } else {
                i = arrayOfVideoResInfo.length;
              }
              arrayOfVideoResInfo = new VideoResInfo[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, arrayOfVideoResInfo, 0, i);
                j = i;
              }
              while (j < arrayOfVideoResInfo.length - 1)
              {
                arrayOfVideoResInfo[j] = new VideoResInfo();
                paramCodedInputByteBufferNano.readMessage(arrayOfVideoResInfo[j]);
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              arrayOfVideoResInfo[j] = new VideoResInfo();
              paramCodedInputByteBufferNano.readMessage(arrayOfVideoResInfo[j]);
              this.d = arrayOfVideoResInfo;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBytes();
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
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBytesSize(1, this.a) + CodedOutputByteBufferNano.computeBytesSize(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c);
    Object localObject = this.d;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.d;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    int k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    long l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    long l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GameCircleVideoNotifyInfo
 * JD-Core Version:    0.7.0.1
 */