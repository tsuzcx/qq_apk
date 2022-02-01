package com.tencent.trpcprotocol.ilive.common.roomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class ClientTypeAndVersion
  extends ExtendableMessageNano<ClientTypeAndVersion>
{
  private static volatile ClientTypeAndVersion[] c;
  public int a;
  public ClientVersionPolicy b;
  
  public ClientTypeAndVersion()
  {
    b();
  }
  
  public static ClientTypeAndVersion[] a()
  {
    if (c == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (c == null) {
          c = new ClientTypeAndVersion[0];
        }
      }
    }
    return c;
  }
  
  public ClientTypeAndVersion a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        else
        {
          if (this.b == null) {
            this.b = new ClientVersionPolicy();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public ClientTypeAndVersion b()
  {
    this.a = 0;
    this.b = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
    ClientVersionPolicy localClientVersionPolicy = this.b;
    j = i;
    if (localClientVersionPolicy != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localClientVersionPolicy);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    ClientVersionPolicy localClientVersionPolicy = this.b;
    if (localClientVersionPolicy != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localClientVersionPolicy);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.common.roomMsg.nano.ClientTypeAndVersion
 * JD-Core Version:    0.7.0.1
 */