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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new ProgramStartRsp[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.ret;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    j = i;
    if (!this.msg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.msg);
    }
    Object localObject = this.room;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.user;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    localObject = this.media;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    localObject = this.exts;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.exts;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
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
              if (i != 42)
              {
                if (i != 50)
                {
                  if (i != 58)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.program = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else
                {
                  int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
                  Tlv[] arrayOfTlv = this.exts;
                  if (arrayOfTlv == null) {
                    i = 0;
                  } else {
                    i = arrayOfTlv.length;
                  }
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
                  arrayOfTlv[j] = new Tlv();
                  paramCodedInputByteBufferNano.readMessage(arrayOfTlv[j]);
                  this.exts = arrayOfTlv;
                }
              }
              else
              {
                if (this.media == null) {
                  this.media = new MediaInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.media);
              }
            }
            else
            {
              if (this.user == null) {
                this.user = new UserInfo();
              }
              paramCodedInputByteBufferNano.readMessage(this.user);
            }
          }
          else
          {
            if (this.room == null) {
              this.room = new RoomInfo();
            }
            paramCodedInputByteBufferNano.readMessage(this.room);
          }
        }
        else {
          this.msg = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.ret = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.ret;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.msg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.msg);
    }
    Object localObject = this.room;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    localObject = this.user;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    localObject = this.media;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
    }
    localObject = this.exts;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.exts;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramStartRsp
 * JD-Core Version:    0.7.0.1
 */