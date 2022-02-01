package com.tencent.mobileqq.now.msfilivehead;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ForwardRsp
  extends MessageNano
{
  public int a;
  public String b;
  public byte[] c;
  public int d;
  public int e;
  public int f;
  public String g;
  
  public ForwardRsp()
  {
    a();
  }
  
  public static ForwardRsp a(byte[] paramArrayOfByte)
  {
    return (ForwardRsp)MessageNano.mergeFrom(new ForwardRsp(), paramArrayOfByte);
  }
  
  public ForwardRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = "";
    this.cachedSize = -1;
    return this;
  }
  
  public ForwardRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
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
            this.c = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = i;
    if (!this.b.equals("")) {
      k = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    j = k;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      j = k + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    j = i;
    if (!this.g.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardRsp
 * JD-Core Version:    0.7.0.1
 */