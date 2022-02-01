package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class NotifyVideoSvrRemoveVideoReq
  extends ExtendableMessageNano<NotifyVideoSvrRemoveVideoReq>
{
  public long a;
  public long b;
  public int c;
  public byte[] d;
  public byte[] e;
  public int f;
  
  public NotifyVideoSvrRemoveVideoReq()
  {
    a();
  }
  
  public NotifyVideoSvrRemoveVideoReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyVideoSvrRemoveVideoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBytes();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
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
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c);
    int j = i;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    }
    i = j;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    int k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    int i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.NotifyVideoSvrRemoveVideoReq
 * JD-Core Version:    0.7.0.1
 */