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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new ProgramStartReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
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
    int k = this.closePgcCrossLimit;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    k = this.closeSubAccountLimit;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    Object localObject = this.attrs;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.attrs;
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
  
  public ProgramStartReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 40)
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
                this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.source = paramCodedInputByteBufferNano.readString();
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
    return this;
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
    int i = this.closePgcCrossLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    i = this.closeSubAccountLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
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
          paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.ProgramStartReq
 * JD-Core Version:    0.7.0.1
 */