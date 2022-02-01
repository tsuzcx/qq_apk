package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class NotifyVideoSvrRemoveVideoResp
  extends ExtendableMessageNano<NotifyVideoSvrRemoveVideoResp>
{
  public int a;
  public long b;
  public long c;
  public int d;
  public byte[] e;
  public byte[] f;
  public int g;
  
  public NotifyVideoSvrRemoveVideoResp()
  {
    a();
  }
  
  public NotifyVideoSvrRemoveVideoResp a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyVideoSvrRemoveVideoResp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (i != 42)
              {
                if (i != 50)
                {
                  if (i != 56)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBytes();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBytes();
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
          this.b = paramCodedInputByteBufferNano.readUInt64();
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
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d);
    int j = i;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    i = j;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    int k = this.g;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    int i = this.g;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.NotifyVideoSvrRemoveVideoResp
 * JD-Core Version:    0.7.0.1
 */