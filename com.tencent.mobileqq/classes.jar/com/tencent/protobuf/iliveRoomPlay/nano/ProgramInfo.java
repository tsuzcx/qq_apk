package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ProgramInfo
  extends MessageNano
{
  private static volatile ProgramInfo[] _emptyArray;
  public String id;
  public long roomid;
  public int state;
  public long uid;
  
  public ProgramInfo()
  {
    clear();
  }
  
  public static ProgramInfo[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new ProgramInfo[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static ProgramInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new ProgramInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static ProgramInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (ProgramInfo)MessageNano.mergeFrom(new ProgramInfo(), paramArrayOfByte);
  }
  
  public ProgramInfo clear()
  {
    this.id = "";
    this.roomid = 0L;
    this.uid = 0L;
    this.state = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.id.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.id);
    }
    long l = this.roomid;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.uid;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    int k = this.state;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    return j;
  }
  
  public ProgramInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 32)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.state = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.uid = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.roomid = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.id = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.id.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.id);
    }
    long l = this.roomid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.uid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    int i = this.state;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramInfo
 * JD-Core Version:    0.7.0.1
 */