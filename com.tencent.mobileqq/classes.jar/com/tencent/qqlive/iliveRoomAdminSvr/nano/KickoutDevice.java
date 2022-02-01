package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class KickoutDevice
  extends ExtendableMessageNano<KickoutDevice>
{
  private static volatile KickoutDevice[] d;
  public byte[] a;
  public TmemRoomKickInfo b;
  public long c;
  
  public KickoutDevice()
  {
    b();
  }
  
  public static KickoutDevice[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new KickoutDevice[0];
        }
      }
    }
    return d;
  }
  
  public KickoutDevice a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new TmemRoomKickInfo();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  public KickoutDevice b()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = null;
    this.c = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(1, this.a);
    }
    TmemRoomKickInfo localTmemRoomKickInfo = this.b;
    j = i;
    if (localTmemRoomKickInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localTmemRoomKickInfo);
    }
    long l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    }
    TmemRoomKickInfo localTmemRoomKickInfo = this.b;
    if (localTmemRoomKickInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localTmemRoomKickInfo);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.KickoutDevice
 * JD-Core Version:    0.7.0.1
 */