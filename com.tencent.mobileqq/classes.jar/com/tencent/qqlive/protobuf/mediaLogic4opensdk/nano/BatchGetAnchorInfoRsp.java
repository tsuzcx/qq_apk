package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetAnchorInfoRsp
  extends ExtendableMessageNano<BatchGetAnchorInfoRsp>
{
  public int a;
  public AnchorUrlPair[] b;
  
  public BatchGetAnchorInfoRsp()
  {
    a();
  }
  
  public BatchGetAnchorInfoRsp a()
  {
    this.a = 0;
    this.b = AnchorUrlPair.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BatchGetAnchorInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          AnchorUrlPair[] arrayOfAnchorUrlPair = this.b;
          if (arrayOfAnchorUrlPair == null) {
            i = 0;
          } else {
            i = arrayOfAnchorUrlPair.length;
          }
          arrayOfAnchorUrlPair = new AnchorUrlPair[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfAnchorUrlPair, 0, i);
            j = i;
          }
          while (j < arrayOfAnchorUrlPair.length - 1)
          {
            arrayOfAnchorUrlPair[j] = new AnchorUrlPair();
            paramCodedInputByteBufferNano.readMessage(arrayOfAnchorUrlPair[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfAnchorUrlPair[j] = new AnchorUrlPair();
          paramCodedInputByteBufferNano.readMessage(arrayOfAnchorUrlPair[j]);
          this.b = arrayOfAnchorUrlPair;
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
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a);
    Object localObject = this.b;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
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
    paramCodedOutputByteBufferNano.writeInt32(1, this.a);
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
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.BatchGetAnchorInfoRsp
 * JD-Core Version:    0.7.0.1
 */