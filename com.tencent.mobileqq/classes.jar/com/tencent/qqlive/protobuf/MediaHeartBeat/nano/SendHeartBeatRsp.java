package com.tencent.qqlive.protobuf.MediaHeartBeat.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class SendHeartBeatRsp
  extends ExtendableMessageNano<SendHeartBeatRsp>
{
  public int a;
  public int b;
  
  public SendHeartBeatRsp()
  {
    a();
  }
  
  public static SendHeartBeatRsp a(byte[] paramArrayOfByte)
  {
    return (SendHeartBeatRsp)MessageNano.mergeFrom(new SendHeartBeatRsp(), paramArrayOfByte);
  }
  
  public SendHeartBeatRsp a()
  {
    this.a = 0;
    this.b = 1;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SendHeartBeatRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
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
    int k = this.b;
    int i = j;
    if (k != 1) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    int i = this.b;
    if (i != 1) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.MediaHeartBeat.nano.SendHeartBeatRsp
 * JD-Core Version:    0.7.0.1
 */