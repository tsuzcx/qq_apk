package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PersonGiftListNewRsp
  extends ExtendableMessageNano<PersonGiftListNewRsp>
{
  public int a;
  public TabAndGiftInfo[] b;
  public GiftInfoRsp[] c;
  
  public PersonGiftListNewRsp()
  {
    a();
  }
  
  public PersonGiftListNewRsp a()
  {
    this.a = 0;
    this.b = TabAndGiftInfo.a();
    this.c = GiftInfoRsp.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PersonGiftListNewRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        int j;
        Object localObject;
        if (i != 18)
        {
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            localObject = this.c;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new GiftInfoRsp[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new GiftInfoRsp();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = new GiftInfoRsp();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            this.c = ((GiftInfoRsp[])localObject);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          localObject = this.b;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new TabAndGiftInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new TabAndGiftInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new TabAndGiftInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((TabAndGiftInfo[])localObject);
        }
      }
      else
      {
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
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
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
        j = i;
      }
    }
    localObject = this.c;
    k = j;
    if (localObject != null)
    {
      k = j;
      if (localObject.length > 0)
      {
        i = m;
        for (;;)
        {
          localObject = this.c;
          k = j;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          k = j;
          if (localObject != null) {
            k = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          i += 1;
          j = k;
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
    int j = 0;
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
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.c;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewRsp
 * JD-Core Version:    0.7.0.1
 */