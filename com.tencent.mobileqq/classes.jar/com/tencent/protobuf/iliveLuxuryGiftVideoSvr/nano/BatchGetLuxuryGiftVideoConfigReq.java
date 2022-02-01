package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetLuxuryGiftVideoConfigReq
  extends MessageNano
{
  private static volatile BatchGetLuxuryGiftVideoConfigReq[] _emptyArray;
  public VideoReq[] videoReq;
  
  public BatchGetLuxuryGiftVideoConfigReq()
  {
    clear();
  }
  
  public static BatchGetLuxuryGiftVideoConfigReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BatchGetLuxuryGiftVideoConfigReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static BatchGetLuxuryGiftVideoConfigReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BatchGetLuxuryGiftVideoConfigReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BatchGetLuxuryGiftVideoConfigReq parseFrom(byte[] paramArrayOfByte)
  {
    return (BatchGetLuxuryGiftVideoConfigReq)MessageNano.mergeFrom(new BatchGetLuxuryGiftVideoConfigReq(), paramArrayOfByte);
  }
  
  public BatchGetLuxuryGiftVideoConfigReq clear()
  {
    this.videoReq = VideoReq.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.videoReq;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.videoReq;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public BatchGetLuxuryGiftVideoConfigReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        VideoReq[] arrayOfVideoReq = this.videoReq;
        if (arrayOfVideoReq == null) {
          i = 0;
        } else {
          i = arrayOfVideoReq.length;
        }
        arrayOfVideoReq = new VideoReq[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.videoReq, 0, arrayOfVideoReq, 0, i);
          j = i;
        }
        while (j < arrayOfVideoReq.length - 1)
        {
          arrayOfVideoReq[j] = new VideoReq();
          paramCodedInputByteBufferNano.readMessage(arrayOfVideoReq[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfVideoReq[j] = new VideoReq();
        paramCodedInputByteBufferNano.readMessage(arrayOfVideoReq[j]);
        this.videoReq = arrayOfVideoReq;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.videoReq;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.videoReq;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.BatchGetLuxuryGiftVideoConfigReq
 * JD-Core Version:    0.7.0.1
 */