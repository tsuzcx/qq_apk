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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new TabAndGiftInfo[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = this.tabType;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    i = j;
    if (!this.tabName.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.tabName);
    }
    Object localObject = this.giftInfoList;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.giftInfoList;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
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
  
  public TabAndGiftInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            GiftInfoRsp[] arrayOfGiftInfoRsp = this.giftInfoList;
            if (arrayOfGiftInfoRsp == null) {
              i = 0;
            } else {
              i = arrayOfGiftInfoRsp.length;
            }
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
            arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
            paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
            this.giftInfoList = arrayOfGiftInfoRsp;
          }
        }
        else {
          this.tabName = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.tabType = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.tabType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.tabName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.tabName);
    }
    Object localObject = this.giftInfoList;
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
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.TabAndGiftInfo
 * JD-Core Version:    0.7.0.1
 */