package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ProgramStartRsp
  extends MessageNano
{
  private static volatile ProgramStartRsp[] _emptyArray;
  public Tlv[] exts;
  public MediaInfo media;
  public String msg;
  public byte[] program;
  public int ret;
  public RoomInfo room;
  public UserInfo user;
  
  public ProgramStartRsp()
  {
    clear();
  }
  
  public static ProgramStartRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new ProgramStartRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static ProgramStartRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new ProgramStartRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static ProgramStartRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (ProgramStartRsp)MessageNano.mergeFrom(new ProgramStartRsp(), paramArrayOfByte);
  }
  
  public ProgramStartRsp clear()
  {
    this.ret = 0;
    this.msg = "";
    this.room = null;
    this.user = null;
    this.media = null;
    this.exts = Tlv.emptyArray();
    this.program = WireFormatNano.EMPTY_BYTES;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.ret != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.ret);
    }
    j = i;
    if (!this.msg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.msg);
    }
    i = j;
    if (this.room != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.room);
    }
    j = i;
    if (this.user != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, this.user);
    }
    i = j;
    if (this.media != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, this.media);
    }
    j = i;
    if (this.exts != null)
    {
      j = i;
      if (this.exts.length > 0)
      {
        j = 0;
        while (j < this.exts.length)
        {
          Tlv localTlv = this.exts[j];
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
    i = j;
    if (!Arrays.equals(this.program, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(7, this.program);
    }
    return i;
  }
  
  public ProgramStartRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.ret = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        this.msg = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        if (this.room == null) {
          this.room = new RoomInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.room);
        break;
      case 34: 
        if (this.user == null) {
          this.user = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.user);
        break;
      case 42: 
        if (this.media == null) {
          this.media = new MediaInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.media);
        break;
      case 50: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
        if (this.exts == null) {}
        Tlv[] arrayOfTlv;
        for (i = 0;; i = this.exts.length)
        {
          arrayOfTlv = new Tlv[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.exts, 0, arrayOfTlv, 0, i);
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
        this.exts = arrayOfTlv;
        break;
      }
      this.program = paramCodedInputByteBufferNano.readBytes();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.ret != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.ret);
    }
    if (!this.msg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.msg);
    }
    if (this.room != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.room);
    }
    if (this.user != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, this.user);
    }
    if (this.media != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, this.media);
    }
    if ((this.exts != null) && (this.exts.length > 0))
    {
      int i = 0;
      while (i < this.exts.length)
      {
        Tlv localTlv = this.exts[i];
        if (localTlv != null) {
          paramCodedOutputByteBufferNano.writeMessage(6, localTlv);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.program, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.program);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramStartRsp
 * JD-Core Version:    0.7.0.1
 */