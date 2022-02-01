package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class VideoInfoClearUp
  extends ExtendableMessageNano<VideoInfoClearUp>
{
  public int a;
  public byte[] b;
  public long c;
  public int d;
  public int e;
  public long f;
  public long g;
  public VideoPlayInfo.VideoInfo[] h;
  
  public VideoInfoClearUp()
  {
    a();
  }
  
  public VideoInfoClearUp a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0L;
    this.g = 0L;
    this.h = VideoPlayInfo.VideoInfo.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public VideoInfoClearUp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (i != 66)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else
                    {
                      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
                      VideoPlayInfo.VideoInfo[] arrayOfVideoInfo = this.h;
                      if (arrayOfVideoInfo == null) {
                        i = 0;
                      } else {
                        i = arrayOfVideoInfo.length;
                      }
                      arrayOfVideoInfo = new VideoPlayInfo.VideoInfo[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.h, 0, arrayOfVideoInfo, 0, i);
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
                      this.h = arrayOfVideoInfo;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt64();
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
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    l = this.f;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    l = this.g;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    Object localObject = this.h;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.h;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
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
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    Object localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.h;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoInfoClearUp
 * JD-Core Version:    0.7.0.1
 */