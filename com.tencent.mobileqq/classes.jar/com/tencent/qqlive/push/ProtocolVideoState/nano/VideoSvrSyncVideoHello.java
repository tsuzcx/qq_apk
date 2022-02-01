package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class VideoSvrSyncVideoHello
  extends ExtendableMessageNano<VideoSvrSyncVideoHello>
{
  public long a;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public byte[] g;
  public byte[] h;
  public int i;
  
  public VideoSvrSyncVideoHello()
  {
    a();
  }
  
  public VideoSvrSyncVideoHello a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public VideoSvrSyncVideoHello a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 16)
        {
          if (j != 24)
          {
            if (j != 32)
            {
              if (j != 40)
              {
                if (j != 48)
                {
                  if (j != 58)
                  {
                    if (j != 66)
                    {
                      if (j != 72)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readUInt32();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readBytes();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else
                {
                  j = paramCodedInputByteBufferNano.readInt32();
                  if ((j == -4) || (j == -3) || (j == -2) || (j == -1) || (j == 0) || (j == 4) || (j == 5) || (j == 6)) {
                    this.f = j;
                  }
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
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeInt32Size(6, this.f);
    int k = j;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    }
    j = k;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      j = k + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    int m = this.i;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(9, m);
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeInt32(6, this.f);
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
    }
    int j = this.i;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoSvrSyncVideoHello
 * JD-Core Version:    0.7.0.1
 */