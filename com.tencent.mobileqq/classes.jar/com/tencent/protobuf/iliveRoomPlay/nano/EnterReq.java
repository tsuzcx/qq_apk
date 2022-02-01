package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnterReq
  extends MessageNano
{
  private static volatile EnterReq[] _emptyArray;
  public String machine;
  public long openLiveType;
  public String programId;
  public long roomid;
  public String source;
  
  public EnterReq()
  {
    clear();
  }
  
  public static EnterReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new EnterReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static EnterReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new EnterReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static EnterReq parseFrom(byte[] paramArrayOfByte)
  {
    return (EnterReq)MessageNano.mergeFrom(new EnterReq(), paramArrayOfByte);
  }
  
  public EnterReq clear()
  {
    this.roomid = 0L;
    this.source = "";
    this.programId = "";
    this.machine = "";
    this.openLiveType = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.roomid;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.source.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.source);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.programId);
    }
    j = i;
    if (!this.machine.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.machine);
    }
    l = this.openLiveType;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    return i;
  }
  
  public EnterReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.openLiveType = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.machine = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.programId = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.source = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.roomid = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.roomid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.source.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.source);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.programId);
    }
    if (!this.machine.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.machine);
    }
    l = this.openLiveType;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.EnterReq
 * JD-Core Version:    0.7.0.1
 */