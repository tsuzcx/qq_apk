package com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class VerifyGiftRsp
  extends ExtendableMessageNano<VerifyGiftRsp>
{
  public boolean a;
  public boolean b;
  
  public VerifyGiftRsp()
  {
    a();
  }
  
  public static VerifyGiftRsp a(byte[] paramArrayOfByte)
  {
    return (VerifyGiftRsp)MessageNano.mergeFrom(new VerifyGiftRsp(), paramArrayOfByte);
  }
  
  public VerifyGiftRsp a()
  {
    this.a = false;
    this.b = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public VerifyGiftRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    boolean bool = this.a;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(1, bool);
    }
    bool = this.b;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    boolean bool = this.a;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(1, bool);
    }
    bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.VerifyGiftRsp
 * JD-Core Version:    0.7.0.1
 */