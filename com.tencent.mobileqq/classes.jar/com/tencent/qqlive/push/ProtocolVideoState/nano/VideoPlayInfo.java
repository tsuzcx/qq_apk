package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class VideoPlayInfo
  extends ExtendableMessageNano<VideoPlayInfo>
{
  public int a;
  public byte[] b;
  public long c;
  public int d;
  public VideoPlayInfo.VideoInfo[] e;
  public int f;
  public long g;
  public long h;
  
  public VideoPlayInfo()
  {
    a();
  }
  
  public VideoPlayInfo a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0L;
    this.d = 0;
    this.e = VideoPlayInfo.VideoInfo.a();
    this.f = 0;
    this.g = 0L;
    this.h = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public VideoPlayInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (i != 42)
              {
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (i != 64)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt64();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else
              {
                int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
                VideoPlayInfo.VideoInfo[] arrayOfVideoInfo = this.e;
                if (arrayOfVideoInfo == null) {
                  i = 0;
                } else {
                  i = arrayOfVideoInfo.length;
                }
                arrayOfVideoInfo = new VideoPlayInfo.VideoInfo[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.e, 0, arrayOfVideoInfo, 0, i);
                  j = i;
                }
                while (j < arrayOfVideoInfo.length - 1)
                {
                  arrayOfVideoInfo[j] = new VideoPlayInfo.VideoInfo();
                  paramCodedInputByteBufferNano.readMessage(arrayOfVideoInfo[j]);
                  paramCodedInputByteBufferNano.readTag();
                  j += 1;
                }
                arrayOfVideoInfo[j] = new VideoPlayInfo.VideoInfo();
                paramCodedInputByteBufferNano.readMessage(arrayOfVideoInfo[j]);
                this.e = arrayOfVideoInfo;
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
        else {
          this.b = paramCodedInputByteBufferNano.readBytes();
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
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    int i = j;
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(2, this.b);
    }
    long l = this.c;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    int k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    Object localObject = this.e;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.e;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    l = this.g;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    l = this.h;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    Object localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoPlayInfo
 * JD-Core Version:    0.7.0.1
 */