package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GameCircleVideoLiveInfo
  extends ExtendableMessageNano<GameCircleVideoLiveInfo>
{
  private static volatile GameCircleVideoLiveInfo[] f;
  public int a;
  public int b;
  public VideoResInfo[] c;
  public byte[] d;
  public long e;
  
  public GameCircleVideoLiveInfo()
  {
    b();
  }
  
  public static GameCircleVideoLiveInfo[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new GameCircleVideoLiveInfo[0];
        }
      }
    }
    return f;
  }
  
  public GameCircleVideoLiveInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            VideoResInfo[] arrayOfVideoResInfo = this.c;
            if (arrayOfVideoResInfo == null) {
              i = 0;
            } else {
              i = arrayOfVideoResInfo.length;
            }
            arrayOfVideoResInfo = new VideoResInfo[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfVideoResInfo, 0, i);
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
            this.c = arrayOfVideoResInfo;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public GameCircleVideoLiveInfo b()
  {
    this.a = 0;
    this.b = 0;
    this.c = VideoResInfo.a();
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b);
    Object localObject = this.c;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int j = k + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    long l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.c;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    long l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GameCircleVideoLiveInfo
 * JD-Core Version:    0.7.0.1
 */