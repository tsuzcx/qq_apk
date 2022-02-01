package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TabAndGiftInfo
  extends MessageNano
{
  private static volatile TabAndGiftInfo[] _emptyArray;
  public GiftInfoRsp[] giftInfoList;
  public String tabName;
  public int tabType;
  
  public TabAndGiftInfo()
  {
    clear();
  }
  
  public static TabAndGiftInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new TabAndGiftInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static TabAndGiftInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new TabAndGiftInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static TabAndGiftInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (TabAndGiftInfo)MessageNano.mergeFrom(new TabAndGiftInfo(), paramArrayOfByte);
  }
  
  public TabAndGiftInfo clear()
  {
    this.tabType = 0;
    this.tabName = "";
    this.giftInfoList = GiftInfoRsp.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (this.tabType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(1, this.tabType);
    }
    i = j;
    if (!this.tabName.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.tabName);
    }
    j = i;
    if (this.giftInfoList != null)
    {
      j = i;
      if (this.giftInfoList.length > 0)
      {
        j = 0;
        while (j < this.giftInfoList.length)
        {
          GiftInfoRsp localGiftInfoRsp = this.giftInfoList[j];
          int k = i;
          if (localGiftInfoRsp != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(3, localGiftInfoRsp);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public TabAndGiftInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.tabType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.tabName = paramCodedInputByteBufferNano.readString();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
      if (this.giftInfoList == null) {}
      GiftInfoRsp[] arrayOfGiftInfoRsp;
      for (i = 0;; i = this.giftInfoList.length)
      {
        arrayOfGiftInfoRsp = new GiftInfoRsp[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.giftInfoList, 0, arrayOfGiftInfoRsp, 0, i);
          j = i;
        }
        while (j < arrayOfGiftInfoRsp.length - 1)
        {
          arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
          paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
      paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
      this.giftInfoList = arrayOfGiftInfoRsp;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.tabType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.tabType);
    }
    if (!this.tabName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.tabName);
    }
    if ((this.giftInfoList != null) && (this.giftInfoList.length > 0))
    {
      int i = 0;
      while (i < this.giftInfoList.length)
      {
        GiftInfoRsp localGiftInfoRsp = this.giftInfoList[i];
        if (localGiftInfoRsp != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, localGiftInfoRsp);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.TabAndGiftInfo
 * JD-Core Version:    0.7.0.1
 */