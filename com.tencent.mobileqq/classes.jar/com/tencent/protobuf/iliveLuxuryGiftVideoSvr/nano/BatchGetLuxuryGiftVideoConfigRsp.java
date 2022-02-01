package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetLuxuryGiftVideoConfigRsp
  extends MessageNano
{
  private static volatile BatchGetLuxuryGiftVideoConfigRsp[] _emptyArray;
  public VideoUrl[] videoUrl;
  
  public BatchGetLuxuryGiftVideoConfigRsp()
  {
    clear();
  }
  
  public static BatchGetLuxuryGiftVideoConfigRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BatchGetLuxuryGiftVideoConfigRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static BatchGetLuxuryGiftVideoConfigRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BatchGetLuxuryGiftVideoConfigRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BatchGetLuxuryGiftVideoConfigRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (BatchGetLuxuryGiftVideoConfigRsp)MessageNano.mergeFrom(new BatchGetLuxuryGiftVideoConfigRsp(), paramArrayOfByte);
  }
  
  public BatchGetLuxuryGiftVideoConfigRsp clear()
  {
    this.videoUrl = VideoUrl.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = i;
    if (this.videoUrl != null)
    {
      k = i;
      if (this.videoUrl.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.videoUrl.length) {
            break;
          }
          VideoUrl localVideoUrl = this.videoUrl[j];
          k = i;
          if (localVideoUrl != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localVideoUrl);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public BatchGetLuxuryGiftVideoConfigRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      if (this.videoUrl == null) {}
      VideoUrl[] arrayOfVideoUrl;
      for (i = 0;; i = this.videoUrl.length)
      {
        arrayOfVideoUrl = new VideoUrl[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.videoUrl, 0, arrayOfVideoUrl, 0, i);
          j = i;
        }
        while (j < arrayOfVideoUrl.length - 1)
        {
          arrayOfVideoUrl[j] = new VideoUrl();
          paramCodedInputByteBufferNano.readMessage(arrayOfVideoUrl[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfVideoUrl[j] = new VideoUrl();
      paramCodedInputByteBufferNano.readMessage(arrayOfVideoUrl[j]);
      this.videoUrl = arrayOfVideoUrl;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.videoUrl != null) && (this.videoUrl.length > 0))
    {
      int i = 0;
      while (i < this.videoUrl.length)
      {
        VideoUrl localVideoUrl = this.videoUrl[i];
        if (localVideoUrl != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localVideoUrl);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.BatchGetLuxuryGiftVideoConfigRsp
 * JD-Core Version:    0.7.0.1
 */