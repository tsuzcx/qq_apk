package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetReq
  extends MessageNano
{
  private static volatile SetReq[] _emptyArray;
  public Tlv[] attrs;
  public int closePgcCrossLimit;
  public int closeSubAccountLimit;
  public int distributeSource;
  public String machine;
  public String programId;
  public long roomid;
  public String source;
  public RoomRichTitle tags;
  
  public SetReq()
  {
    clear();
  }
  
  public static SetReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new SetReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static SetReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SetReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SetReq parseFrom(byte[] paramArrayOfByte)
  {
    return (SetReq)MessageNano.mergeFrom(new SetReq(), paramArrayOfByte);
  }
  
  public SetReq clear()
  {
    this.roomid = 0L;
    this.attrs = Tlv.emptyArray();
    this.tags = null;
    this.source = "";
    this.programId = "";
    this.machine = "";
    this.closePgcCrossLimit = 0;
    this.closeSubAccountLimit = 0;
    this.distributeSource = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomid);
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
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localTlv);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.tags != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.tags);
    }
    j = i;
    if (!this.source.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.source);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.programId);
    }
    j = i;
    if (!this.machine.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.machine);
    }
    i = j;
    if (this.closePgcCrossLimit != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(7, this.closePgcCrossLimit);
    }
    j = i;
    if (this.closeSubAccountLimit != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(8, this.closeSubAccountLimit);
    }
    i = j;
    if (this.distributeSource != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(9, this.distributeSource);
    }
    return i;
  }
  
  public SetReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8: 
        this.roomid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
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
        break;
      case 26: 
        if (this.tags == null) {
          this.tags = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.tags);
        break;
      case 34: 
        this.source = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.machine = paramCodedInputByteBufferNano.readString();
        break;
      case 56: 
        this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      case 64: 
        this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      this.distributeSource = paramCodedInputByteBufferNano.readInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomid);
    }
    if ((this.attrs != null) && (this.attrs.length > 0))
    {
      int i = 0;
      while (i < this.attrs.length)
      {
        Tlv localTlv = this.attrs[i];
        if (localTlv != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localTlv);
        }
        i += 1;
      }
    }
    if (this.tags != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.tags);
    }
    if (!this.source.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.source);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.programId);
    }
    if (!this.machine.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.machine);
    }
    if (this.closePgcCrossLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, this.closePgcCrossLimit);
    }
    if (this.closeSubAccountLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, this.closeSubAccountLimit);
    }
    if (this.distributeSource != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, this.distributeSource);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.SetReq
 * JD-Core Version:    0.7.0.1
 */