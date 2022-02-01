package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class NotifyRemoveVideoByVideoSvrReq
  extends ExtendableMessageNano<NotifyRemoveVideoByVideoSvrReq>
{
  public long a;
  public long b;
  public int c;
  public int d;
  public int e;
  public byte[] f;
  public byte[] g;
  public int h;
  
  public NotifyRemoveVideoByVideoSvrReq()
  {
    a();
  }
  
  public NotifyRemoveVideoByVideoSvrReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyRemoveVideoByVideoSvrReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                    if (i != 64)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBytes();
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
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e);
    int j = i;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    i = j;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    }
    int k = this.h;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    }
    int i = this.h;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.NotifyRemoveVideoByVideoSvrReq
 * JD-Core Version:    0.7.0.1
 */