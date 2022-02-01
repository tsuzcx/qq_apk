package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class SetVideoSwitchByVideoSvrResp
  extends ExtendableMessageNano<SetVideoSwitchByVideoSvrResp>
{
  public int a;
  public long b;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  public byte[] h;
  public int i;
  
  public SetVideoSwitchByVideoSvrResp()
  {
    a();
  }
  
  public SetVideoSwitchByVideoSvrResp a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetVideoSwitchByVideoSvrResp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                  if (j != 56)
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
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readInt32();
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
    int k = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeInt32Size(5, this.e) + CodedOutputByteBufferNano.computeInt32Size(6, this.f);
    int m = this.g;
    int j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    k = j;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    m = this.i;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(9, m);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeInt32(6, this.f);
    int j = this.g;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, j);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
    }
    j = this.i;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.SetVideoSwitchByVideoSvrResp
 * JD-Core Version:    0.7.0.1
 */