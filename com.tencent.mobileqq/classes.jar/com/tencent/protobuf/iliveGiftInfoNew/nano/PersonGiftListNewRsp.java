package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PersonGiftListNewRsp
  extends MessageNano
{
  private static volatile PersonGiftListNewRsp[] _emptyArray;
  public TabAndGiftInfo[] giftInfoList;
  public GiftInfoRsp[] hideGiftInfoList;
  public int retsult;
  
  public PersonGiftListNewRsp()
  {
    clear();
  }
  
  public static PersonGiftListNewRsp[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PersonGiftListNewRsp[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static PersonGiftListNewRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PersonGiftListNewRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PersonGiftListNewRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (PersonGiftListNewRsp)MessageNano.mergeFrom(new PersonGiftListNewRsp(), paramArrayOfByte);
  }
  
  public PersonGiftListNewRsp clear()
  {
    this.retsult = 0;
    this.giftInfoList = TabAndGiftInfo.emptyArray();
    this.hideGiftInfoList = GiftInfoRsp.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.retsult;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    Object localObject = this.giftInfoList;
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
          localObject = this.giftInfoList;
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
    localObject = this.hideGiftInfoList;
    k = j;
    if (localObject != null)
    {
      k = j;
      if (localObject.length > 0)
      {
        i = m;
        for (;;)
        {
          localObject = this.hideGiftInfoList;
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
  
  public PersonGiftListNewRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            localObject = this.hideGiftInfoList;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new GiftInfoRsp[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.hideGiftInfoList, 0, localObject, 0, i);
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
            this.hideGiftInfoList = ((GiftInfoRsp[])localObject);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          localObject = this.giftInfoList;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new TabAndGiftInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.giftInfoList, 0, localObject, 0, i);
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
          this.giftInfoList = ((TabAndGiftInfo[])localObject);
        }
      }
      else
      {
        this.retsult = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.retsult;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    Object localObject = this.giftInfoList;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.giftInfoList;
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
    localObject = this.hideGiftInfoList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.hideGiftInfoList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewRsp
 * JD-Core Version:    0.7.0.1
 */