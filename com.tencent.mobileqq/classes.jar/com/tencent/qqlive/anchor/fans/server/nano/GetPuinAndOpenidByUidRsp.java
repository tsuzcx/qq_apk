package com.tencent.qqlive.anchor.fans.server.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class GetPuinAndOpenidByUidRsp
  extends ExtendableMessageNano<GetPuinAndOpenidByUidRsp>
{
  public long a;
  public String b;
  
  public GetPuinAndOpenidByUidRsp()
  {
    a();
  }
  
  public static GetPuinAndOpenidByUidRsp a(byte[] paramArrayOfByte)
  {
    return (GetPuinAndOpenidByUidRsp)MessageNano.mergeFrom(new GetPuinAndOpenidByUidRsp(), paramArrayOfByte);
  }
  
  public GetPuinAndOpenidByUidRsp a()
  {
    this.a = 0L;
    this.b = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetPuinAndOpenidByUidRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
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
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.anchor.fans.server.nano.GetPuinAndOpenidByUidRsp
 * JD-Core Version:    0.7.0.1
 */