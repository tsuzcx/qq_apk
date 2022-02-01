package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnterRsp
  extends MessageNano
{
  private static volatile EnterRsp[] _emptyArray;
  public Tlv[] exts;
  public MediaInfo media;
  public String msg;
  public int ret;
  public RoomInfo room;
  public UserInfo user;
  
  public EnterRsp()
  {
    clear();
  }
  
  public static EnterRsp[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new EnterRsp[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static EnterRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new EnterRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static EnterRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (EnterRsp)MessageNano.mergeFrom(new EnterRsp(), paramArrayOfByte);
  }
  
  public EnterRsp clear()
  {
    this.ret = 0;
    this.msg = "";
    this.room = null;
    this.user = null;
    this.media = null;
    this.exts = Tlv.emptyArray();
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
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.exts;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public EnterRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                  if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.EnterRsp
 * JD-Core Version:    0.7.0.1
 */