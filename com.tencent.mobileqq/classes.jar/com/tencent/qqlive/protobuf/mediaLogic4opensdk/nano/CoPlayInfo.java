package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CoPlayInfo
  extends ExtendableMessageNano<CoPlayInfo>
{
  public CoPlayStruct a;
  public CoPlayStruct[] b;
  public int c;
  public String d;
  public int e;
  
  public CoPlayInfo()
  {
    a();
  }
  
  public CoPlayInfo a()
  {
    this.a = null;
    this.b = CoPlayStruct.a();
    this.c = 0;
    this.d = "";
    this.e = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public CoPlayInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          CoPlayStruct[] arrayOfCoPlayStruct = this.b;
          if (arrayOfCoPlayStruct == null) {
            i = 0;
          } else {
            i = arrayOfCoPlayStruct.length;
          }
          arrayOfCoPlayStruct = new CoPlayStruct[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfCoPlayStruct, 0, i);
            j = i;
          }
          while (j < arrayOfCoPlayStruct.length - 1)
          {
            arrayOfCoPlayStruct[j] = new CoPlayStruct();
            paramCodedInputByteBufferNano.readMessage(arrayOfCoPlayStruct[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfCoPlayStruct[j] = new CoPlayStruct();
          paramCodedInputByteBufferNano.readMessage(arrayOfCoPlayStruct[j]);
          this.b = arrayOfCoPlayStruct;
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new CoPlayStruct();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.b;
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
    int k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    j = i;
    if (!this.d.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = this.e;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
    }
    localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.b;
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
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.CoPlayInfo
 * JD-Core Version:    0.7.0.1
 */