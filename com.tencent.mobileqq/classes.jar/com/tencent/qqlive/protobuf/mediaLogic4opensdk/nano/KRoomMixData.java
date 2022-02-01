package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class KRoomMixData
  extends ExtendableMessageNano<KRoomMixData>
{
  public long a;
  public KRoomMixData.AnchorMsg[] b;
  
  public KRoomMixData()
  {
    a();
  }
  
  public KRoomMixData a()
  {
    this.a = 0L;
    this.b = KRoomMixData.AnchorMsg.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public KRoomMixData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          KRoomMixData.AnchorMsg[] arrayOfAnchorMsg = this.b;
          if (arrayOfAnchorMsg == null) {
            i = 0;
          } else {
            i = arrayOfAnchorMsg.length;
          }
          arrayOfAnchorMsg = new KRoomMixData.AnchorMsg[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfAnchorMsg, 0, i);
            j = i;
          }
          while (j < arrayOfAnchorMsg.length - 1)
          {
            arrayOfAnchorMsg[j] = new KRoomMixData.AnchorMsg();
            paramCodedInputByteBufferNano.readMessage(arrayOfAnchorMsg[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfAnchorMsg[j] = new KRoomMixData.AnchorMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfAnchorMsg[j]);
          this.b = arrayOfAnchorMsg;
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    Object localObject = this.b;
    int k = i;
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
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
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
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.KRoomMixData
 * JD-Core Version:    0.7.0.1
 */