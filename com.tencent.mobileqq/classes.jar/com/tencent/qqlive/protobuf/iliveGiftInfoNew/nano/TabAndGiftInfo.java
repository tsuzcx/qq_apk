package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TabAndGiftInfo
  extends ExtendableMessageNano<TabAndGiftInfo>
{
  private static volatile TabAndGiftInfo[] d;
  public int a;
  public String b;
  public GiftInfoRsp[] c;
  
  public TabAndGiftInfo()
  {
    b();
  }
  
  public static TabAndGiftInfo[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new TabAndGiftInfo[0];
        }
      }
    }
    return d;
  }
  
  public TabAndGiftInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            GiftInfoRsp[] arrayOfGiftInfoRsp = this.c;
            if (arrayOfGiftInfoRsp == null) {
              i = 0;
            } else {
              i = arrayOfGiftInfoRsp.length;
            }
            arrayOfGiftInfoRsp = new GiftInfoRsp[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfGiftInfoRsp, 0, i);
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
            this.c = arrayOfGiftInfoRsp;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public TabAndGiftInfo b()
  {
    this.a = 0;
    this.b = "";
    this.c = GiftInfoRsp.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = this.a;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Object localObject = this.c;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
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
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.TabAndGiftInfo
 * JD-Core Version:    0.7.0.1
 */