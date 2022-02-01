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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new SetReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.roomid;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    Object localObject = this.attrs;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.attrs;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.tags;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
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
    int k = this.closePgcCrossLimit;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(7, k);
    }
    k = this.closeSubAccountLimit;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(8, k);
    }
    k = this.distributeSource;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(9, k);
    }
    return i;
  }
  
  public SetReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                  if (i != 56)
                  {
                    if (i != 64)
                    {
                      if (i != 72)
                      {
                        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                          return this;
                        }
                      }
                      else {
                        this.distributeSource = paramCodedInputByteBufferNano.readInt32();
                      }
                    }
                    else {
                      this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
                    }
                  }
                  else {
                    this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
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
          else
          {
            if (this.tags == null) {
              this.tags = new RoomRichTitle();
            }
            paramCodedInputByteBufferNano.readMessage(this.tags);
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          Tlv[] arrayOfTlv = this.attrs;
          if (arrayOfTlv == null) {
            i = 0;
          } else {
            i = arrayOfTlv.length;
          }
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
          arrayOfTlv[j] = new Tlv();
          paramCodedInputByteBufferNano.readMessage(arrayOfTlv[j]);
          this.attrs = arrayOfTlv;
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
    Object localObject = this.attrs;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.attrs;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.tags;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
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
    int i = this.closePgcCrossLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, i);
    }
    i = this.closeSubAccountLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, i);
    }
    i = this.distributeSource;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.SetReq
 * JD-Core Version:    0.7.0.1
 */