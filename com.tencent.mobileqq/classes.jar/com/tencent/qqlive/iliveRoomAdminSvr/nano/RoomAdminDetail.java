package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class RoomAdminDetail
  extends ExtendableMessageNano<RoomAdminDetail>
{
  private static volatile RoomAdminDetail[] h;
  public long a;
  public long b;
  public byte[] c;
  public byte[] d;
  public byte[] e;
  public boolean f;
  public byte[] g;
  
  public RoomAdminDetail()
  {
    b();
  }
  
  public static RoomAdminDetail[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new RoomAdminDetail[0];
        }
      }
    }
    return h;
  }
  
  public RoomAdminDetail a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBool();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBytes();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public RoomAdminDetail b()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = false;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    i = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    j = i;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    }
    i = j;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    boolean bool = this.f;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(6, bool);
    }
    i = j;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    boolean bool = this.f;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(6, bool);
    }
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.RoomAdminDetail
 * JD-Core Version:    0.7.0.1
 */