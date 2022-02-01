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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PersonGiftListNewRsp[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int m = 0;
    int i = super.computeSerializedSize();
    int j = i;
    if (this.retsult != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(1, this.retsult);
    }
    i = j;
    Object localObject;
    if (this.giftInfoList != null)
    {
      i = j;
      if (this.giftInfoList.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.giftInfoList.length)
        {
          localObject = this.giftInfoList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (this.hideGiftInfoList != null)
    {
      k = i;
      if (this.hideGiftInfoList.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.hideGiftInfoList.length) {
            break;
          }
          localObject = this.hideGiftInfoList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          j += 1;
          i = k;
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
      Object localObject;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.retsult = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        if (this.giftInfoList == null) {}
        for (i = 0;; i = this.giftInfoList.length)
        {
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
        }
        localObject[j] = new TabAndGiftInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.giftInfoList = ((TabAndGiftInfo[])localObject);
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
      if (this.hideGiftInfoList == null) {}
      for (i = 0;; i = this.hideGiftInfoList.length)
      {
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
      }
      localObject[j] = new GiftInfoRsp();
      paramCodedInputByteBufferNano.readMessage(localObject[j]);
      this.hideGiftInfoList = ((GiftInfoRsp[])localObject);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    if (this.retsult != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.retsult);
    }
    int i;
    Object localObject;
    if ((this.giftInfoList != null) && (this.giftInfoList.length > 0))
    {
      i = 0;
      while (i < this.giftInfoList.length)
      {
        localObject = this.giftInfoList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if ((this.hideGiftInfoList != null) && (this.hideGiftInfoList.length > 0))
    {
      i = j;
      while (i < this.hideGiftInfoList.length)
      {
        localObject = this.hideGiftInfoList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewRsp
 * JD-Core Version:    0.7.0.1
 */