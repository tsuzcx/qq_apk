package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class IsRoomMemberReq
  extends ExtendableMessageNano<IsRoomMemberReq>
{
  public long a;
  public boolean b;
  
  public IsRoomMemberReq()
  {
    a();
  }
  
  public IsRoomMemberReq a()
  {
    this.a = 0L;
    this.b = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public IsRoomMemberReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
    boolean bool = this.b;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.IsRoomMemberReq
 * JD-Core Version:    0.7.0.1
 */