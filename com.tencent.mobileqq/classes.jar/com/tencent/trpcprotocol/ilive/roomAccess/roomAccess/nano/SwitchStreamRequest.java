package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SwitchStreamRequest
  extends MessageNano
{
  private static volatile SwitchStreamRequest[] _emptyArray;
  public String format;
  public int level;
  public long roomId;
  
  public SwitchStreamRequest()
  {
    clear();
  }
  
  public static SwitchStreamRequest[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new SwitchStreamRequest[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static SwitchStreamRequest parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SwitchStreamRequest().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SwitchStreamRequest parseFrom(byte[] paramArrayOfByte)
  {
    return (SwitchStreamRequest)MessageNano.mergeFrom(new SwitchStreamRequest(), paramArrayOfByte);
  }
  
  public SwitchStreamRequest clear()
  {
    this.roomId = 0L;
    this.format = "";
    this.level = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.roomId;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    i = j;
    if (!this.format.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.format);
    }
    int k = this.level;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    return j;
  }
  
  public SwitchStreamRequest mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.level = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.format = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.format.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.format);
    }
    int i = this.level;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.SwitchStreamRequest
 * JD-Core Version:    0.7.0.1
 */