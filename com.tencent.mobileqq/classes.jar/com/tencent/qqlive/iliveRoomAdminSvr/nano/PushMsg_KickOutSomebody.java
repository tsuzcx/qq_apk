package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PushMsg_KickOutSomebody
  extends ExtendableMessageNano<PushMsg_KickOutSomebody>
{
  public byte[] a;
  
  public PushMsg_KickOutSomebody()
  {
    a();
  }
  
  public static PushMsg_KickOutSomebody a(byte[] paramArrayOfByte)
  {
    return (PushMsg_KickOutSomebody)MessageNano.mergeFrom(new PushMsg_KickOutSomebody(), paramArrayOfByte);
  }
  
  public PushMsg_KickOutSomebody a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushMsg_KickOutSomebody a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
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
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_KickOutSomebody
 * JD-Core Version:    0.7.0.1
 */