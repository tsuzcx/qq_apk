package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AllVideoConfigs
  extends MessageNano
{
  private static volatile AllVideoConfigs[] _emptyArray;
  public VideoConfig[] videoConfigs;
  
  public AllVideoConfigs()
  {
    clear();
  }
  
  public static AllVideoConfigs[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new AllVideoConfigs[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static AllVideoConfigs parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new AllVideoConfigs().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static AllVideoConfigs parseFrom(byte[] paramArrayOfByte)
  {
    return (AllVideoConfigs)MessageNano.mergeFrom(new AllVideoConfigs(), paramArrayOfByte);
  }
  
  public AllVideoConfigs clear()
  {
    this.videoConfigs = VideoConfig.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.videoConfigs;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.videoConfigs;
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
  
  public AllVideoConfigs mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        VideoConfig[] arrayOfVideoConfig = this.videoConfigs;
        if (arrayOfVideoConfig == null) {
          i = 0;
        } else {
          i = arrayOfVideoConfig.length;
        }
        arrayOfVideoConfig = new VideoConfig[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.videoConfigs, 0, arrayOfVideoConfig, 0, i);
          j = i;
        }
        while (j < arrayOfVideoConfig.length - 1)
        {
          arrayOfVideoConfig[j] = new VideoConfig();
          paramCodedInputByteBufferNano.readMessage(arrayOfVideoConfig[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfVideoConfig[j] = new VideoConfig();
        paramCodedInputByteBufferNano.readMessage(arrayOfVideoConfig[j]);
        this.videoConfigs = arrayOfVideoConfig;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.videoConfigs;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.videoConfigs;
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
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.AllVideoConfigs
 * JD-Core Version:    0.7.0.1
 */