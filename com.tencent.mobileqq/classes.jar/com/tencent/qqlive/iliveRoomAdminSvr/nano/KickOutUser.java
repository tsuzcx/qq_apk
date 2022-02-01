package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class KickOutUser
  extends ExtendableMessageNano<KickOutUser>
{
  private static volatile KickOutUser[] c;
  public TmemRoomKickInfo a;
  public long b;
  
  public KickOutUser()
  {
    b();
  }
  
  public static KickOutUser[] a()
  {
    if (c == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (c == null) {
          c = new KickOutUser[0];
        }
      }
    }
    return c;
  }
  
  public KickOutUser a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new TmemRoomKickInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  public KickOutUser b()
  {
    this.a = null;
    this.b = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    TmemRoomKickInfo localTmemRoomKickInfo = this.a;
    int i = j;
    if (localTmemRoomKickInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localTmemRoomKickInfo);
    }
    long l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    TmemRoomKickInfo localTmemRoomKickInfo = this.a;
    if (localTmemRoomKickInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localTmemRoomKickInfo);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.KickOutUser
 * JD-Core Version:    0.7.0.1
 */