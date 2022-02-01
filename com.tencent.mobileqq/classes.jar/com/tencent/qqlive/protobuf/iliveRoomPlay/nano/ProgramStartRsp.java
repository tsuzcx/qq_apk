package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ProgramStartRsp
  extends ExtendableMessageNano<ProgramStartRsp>
{
  public int a;
  public String b;
  public RoomInfo c;
  public UserInfo d;
  public MediaInfo e;
  public Tlv[] f;
  public byte[] g;
  
  public ProgramStartRsp()
  {
    a();
  }
  
  public ProgramStartRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = Tlv.a();
    this.g = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ProgramStartRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else
                {
                  int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
                  Tlv[] arrayOfTlv = this.f;
                  if (arrayOfTlv == null) {
                    i = 0;
                  } else {
                    i = arrayOfTlv.length;
                  }
                  arrayOfTlv = new Tlv[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.f, 0, arrayOfTlv, 0, i);
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
                  this.f = arrayOfTlv;
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new MediaInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new UserInfo();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new RoomInfo();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Object localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    localObject = this.f;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.f;
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
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
    }
    localObject = this.f;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.f;
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
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.ProgramStartRsp
 * JD-Core Version:    0.7.0.1
 */