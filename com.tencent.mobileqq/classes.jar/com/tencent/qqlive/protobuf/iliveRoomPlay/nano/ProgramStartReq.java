package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ProgramStartReq
  extends ExtendableMessageNano<ProgramStartReq>
{
  public String a;
  public String b;
  public String c;
  public Tlv[] d;
  public int e;
  public int f;
  
  public ProgramStartReq()
  {
    a();
  }
  
  public ProgramStartReq a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = Tlv.a();
    this.e = 0;
    this.f = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ProgramStartReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else
                {
                  int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
                  Tlv[] arrayOfTlv = this.d;
                  if (arrayOfTlv == null) {
                    i = 0;
                  } else {
                    i = arrayOfTlv.length;
                  }
                  arrayOfTlv = new Tlv[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.d, 0, arrayOfTlv, 0, i);
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
                  this.d = arrayOfTlv;
                }
              }
              else {
                this.f = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.e = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    int k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    Object localObject = this.d;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.d;
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
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.ProgramStartReq
 * JD-Core Version:    0.7.0.1
 */