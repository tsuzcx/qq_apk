package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GameCircleSetVideoSwitchResp
  extends ExtendableMessageNano<GameCircleSetVideoSwitchResp>
{
  public int a;
  public byte[] b;
  public byte[] c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public byte[] i;
  
  public GameCircleSetVideoSwitchResp()
  {
    a();
  }
  
  public GameCircleSetVideoSwitchResp a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GameCircleSetVideoSwitchResp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 18)
        {
          if (j != 26)
          {
            if (j != 32)
            {
              if (j != 40)
              {
                if (j != 48)
                {
                  if (j != 56)
                  {
                    if (j != 64)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readBytes();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBytes();
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
    int k = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeBytesSize(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(3, this.c) + CodedOutputByteBufferNano.computeInt32Size(4, this.d) + CodedOutputByteBufferNano.computeInt32Size(5, this.e);
    int m = this.f;
    int j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(6, m);
    }
    m = this.g;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    m = this.h;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(8, m);
    }
    k = j;
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(9, this.i);
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    paramCodedOutputByteBufferNano.writeInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeInt32(5, this.e);
    int j = this.f;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, j);
    }
    j = this.g;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, j);
    }
    j = this.h;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GameCircleSetVideoSwitchResp
 * JD-Core Version:    0.7.0.1
 */