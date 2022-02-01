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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BatchGetLuxuryGiftVideoConfigReq[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = i;
    if (this.videoReq != null)
    {
      k = i;
      if (this.videoReq.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.videoReq.length) {
            break;
          }
          VideoReq localVideoReq = this.videoReq[j];
          k = i;
          if (localVideoReq != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localVideoReq);
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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
      if (this.videoReq == null) {}
      VideoReq[] arrayOfVideoReq;
      for (i = 0;; i = this.videoReq.length)
      {
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
      }
      arrayOfVideoReq[j] = new VideoReq();
      paramCodedInputByteBufferNano.readMessage(arrayOfVideoReq[j]);
      this.videoReq = arrayOfVideoReq;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.videoReq != null) && (this.videoReq.length > 0))
    {
      int i = 0;
      while (i < this.videoReq.length)
      {
        VideoReq localVideoReq = this.videoReq[i];
        if (localVideoReq != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localVideoReq);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.BatchGetLuxuryGiftVideoConfigReq
 * JD-Core Version:    0.7.0.1
 */