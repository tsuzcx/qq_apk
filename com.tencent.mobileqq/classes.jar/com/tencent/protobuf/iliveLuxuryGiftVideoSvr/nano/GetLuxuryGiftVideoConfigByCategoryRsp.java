package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLuxuryGiftVideoConfigByCategoryRsp
  extends MessageNano
{
  private static volatile GetLuxuryGiftVideoConfigByCategoryRsp[] _emptyArray;
  public VideoUrl[] videoUrl;
  
  public GetLuxuryGiftVideoConfigByCategoryRsp()
  {
    clear();
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryRsp[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GetLuxuryGiftVideoConfigByCategoryRsp[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GetLuxuryGiftVideoConfigByCategoryRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (GetLuxuryGiftVideoConfigByCategoryRsp)MessageNano.mergeFrom(new GetLuxuryGiftVideoConfigByCategoryRsp(), paramArrayOfByte);
  }
  
  public GetLuxuryGiftVideoConfigByCategoryRsp clear()
  {
    this.videoUrl = VideoUrl.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.videoUrl;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.videoUrl;
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
  
  public GetLuxuryGiftVideoConfigByCategoryRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        VideoUrl[] arrayOfVideoUrl = this.videoUrl;
        if (arrayOfVideoUrl == null) {
          i = 0;
        } else {
          i = arrayOfVideoUrl.length;
        }
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
        arrayOfVideoUrl[j] = new VideoUrl();
        paramCodedInputByteBufferNano.readMessage(arrayOfVideoUrl[j]);
        this.videoUrl = arrayOfVideoUrl;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.videoUrl;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.videoUrl;
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
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.GetLuxuryGiftVideoConfigByCategoryRsp
 * JD-Core Version:    0.7.0.1
 */