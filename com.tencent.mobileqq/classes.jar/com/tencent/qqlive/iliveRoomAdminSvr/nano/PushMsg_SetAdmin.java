package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PushMsg_SetAdmin
  extends ExtendableMessageNano<PushMsg_SetAdmin>
{
  public byte[] a;
  public long b;
  public boolean c;
  public byte[] d;
  
  public PushMsg_SetAdmin()
  {
    a();
  }
  
  public static PushMsg_SetAdmin a(byte[] paramArrayOfByte)
  {
    return (PushMsg_SetAdmin)MessageNano.mergeFrom(new PushMsg_SetAdmin(), paramArrayOfByte);
  }
  
  public PushMsg_SetAdmin a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = 0L;
    this.c = false;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushMsg_SetAdmin a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBool();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(1, this.a);
    }
    long l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    boolean bool = this.c;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    j = i;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    boolean bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_SetAdmin
 * JD-Core Version:    0.7.0.1
 */