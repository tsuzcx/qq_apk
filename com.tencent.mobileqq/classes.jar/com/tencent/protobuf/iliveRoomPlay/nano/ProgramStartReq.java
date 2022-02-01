package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ProgramStartReq
  extends MessageNano
{
  private static volatile ProgramStartReq[] _emptyArray;
  public Tlv[] attrs;
  public int closePgcCrossLimit;
  public int closeSubAccountLimit;
  public String machine;
  public String programId;
  public String source;
  
  public ProgramStartReq()
  {
    clear();
  }
  
  public static ProgramStartReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new ProgramStartReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static ProgramStartReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new ProgramStartReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static ProgramStartReq parseFrom(byte[] paramArrayOfByte)
  {
    return (ProgramStartReq)MessageNano.mergeFrom(new ProgramStartReq(), paramArrayOfByte);
  }
  
  public ProgramStartReq clear()
  {
    this.programId = "";
    this.machine = "";
    this.source = "";
    this.closePgcCrossLimit = 0;
    this.closeSubAccountLimit = 0;
    this.attrs = Tlv.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.programId);
    }
    j = i;
    if (!this.machine.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.machine);
    }
    i = j;
    if (!this.source.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.source);
    }
    j = i;
    if (this.closePgcCrossLimit != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, this.closePgcCrossLimit);
    }
    i = j;
    if (this.closeSubAccountLimit != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, this.closeSubAccountLimit);
    }
    j = i;
    if (this.attrs != null)
    {
      j = i;
      if (this.attrs.length > 0)
      {
        j = 0;
        while (j < this.attrs.length)
        {
          Tlv localTlv = this.attrs[j];
          int k = i;
          if (localTlv != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(6, localTlv);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public ProgramStartReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.machine = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.source = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      case 40: 
        this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
      if (this.attrs == null) {}
      Tlv[] arrayOfTlv;
      for (i = 0;; i = this.attrs.length)
      {
        arrayOfTlv = new Tlv[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.attrs, 0, arrayOfTlv, 0, i);
          j = i;
        }
        while (j < arrayOfTlv.length - 1)
        {
          arrayOfTlv[j] = new Tlv();
          paramCodedInputByteBufferNano.readMessage(arrayOfTlv[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfTlv[j] = new Tlv();
      paramCodedInputByteBufferNano.readMessage(arrayOfTlv[j]);
      this.attrs = arrayOfTlv;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.programId);
    }
    if (!this.machine.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.machine);
    }
    if (!this.source.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.source);
    }
    if (this.closePgcCrossLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, this.closePgcCrossLimit);
    }
    if (this.closeSubAccountLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, this.closeSubAccountLimit);
    }
    if ((this.attrs != null) && (this.attrs.length > 0))
    {
      int i = 0;
      while (i < this.attrs.length)
      {
        Tlv localTlv = this.attrs[i];
        if (localTlv != null) {
          paramCodedOutputByteBufferNano.writeMessage(6, localTlv);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramStartReq
 * JD-Core Version:    0.7.0.1
 */