package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AnchorGearChooseRsp
  extends ExtendableMessageNano<AnchorGearChooseRsp>
{
  public int a;
  public GearInfo[] b;
  
  public AnchorGearChooseRsp()
  {
    a();
  }
  
  public AnchorGearChooseRsp a()
  {
    this.a = 0;
    this.b = GearInfo.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AnchorGearChooseRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          GearInfo[] arrayOfGearInfo = this.b;
          if (arrayOfGearInfo == null) {
            i = 0;
          } else {
            i = arrayOfGearInfo.length;
          }
          arrayOfGearInfo = new GearInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfGearInfo, 0, i);
            j = i;
          }
          while (j < arrayOfGearInfo.length - 1)
          {
            arrayOfGearInfo[j] = new GearInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfGearInfo[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfGearInfo[j] = new GearInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfGearInfo[j]);
          this.b = arrayOfGearInfo;
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
    Object localObject = this.b;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
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
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    Object localObject = this.b;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.AnchorGearChooseRsp
 * JD-Core Version:    0.7.0.1
 */