package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class PrepareRsp
  extends ExtendableMessageNano<PrepareRsp>
{
  public int a;
  public String b;
  public RoomInfo c;
  public String d;
  public int e;
  
  public PrepareRsp()
  {
    a();
  }
  
  public static PrepareRsp a(byte[] paramArrayOfByte)
  {
    return (PrepareRsp)MessageNano.mergeFrom(new PrepareRsp(), paramArrayOfByte);
  }
  
  public PrepareRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = null;
    this.d = "";
    this.e = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PrepareRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new RoomInfo();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
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
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    RoomInfo localRoomInfo = this.c;
    k = j;
    if (localRoomInfo != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(3, localRoomInfo);
    }
    i = k;
    if (!this.d.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    RoomInfo localRoomInfo = this.c;
    if (localRoomInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localRoomInfo);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareRsp
 * JD-Core Version:    0.7.0.1
 */