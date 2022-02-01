package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;

public final class BroadCastMsg
  extends ExtendableMessageNano<BroadCastMsg>
{
  private static volatile BroadCastMsg[] e;
  public UserInfo a;
  public MsgContent b;
  public int c;
  public int d;
  
  public BroadCastMsg()
  {
    b();
  }
  
  public static BroadCastMsg a(byte[] paramArrayOfByte)
  {
    return (BroadCastMsg)MessageNano.mergeFrom(new BroadCastMsg(), paramArrayOfByte);
  }
  
  public static BroadCastMsg[] a()
  {
    if (e == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (e == null) {
          e = new BroadCastMsg[0];
        }
      }
    }
    return e;
  }
  
  public BroadCastMsg a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (i != 32)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new MsgContent();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  public BroadCastMsg b()
  {
    this.a = null;
    this.b = null;
    this.c = 0;
    this.d = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    int k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
    }
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.BroadCastMsg
 * JD-Core Version:    0.7.0.1
 */