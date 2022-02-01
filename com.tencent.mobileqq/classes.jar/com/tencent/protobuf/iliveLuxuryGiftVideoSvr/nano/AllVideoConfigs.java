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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new AllVideoConfigs[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = i;
    if (this.videoConfigs != null)
    {
      k = i;
      if (this.videoConfigs.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.videoConfigs.length) {
            break;
          }
          VideoConfig localVideoConfig = this.videoConfigs[j];
          k = i;
          if (localVideoConfig != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localVideoConfig);
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
      if (this.videoConfigs == null) {}
      VideoConfig[] arrayOfVideoConfig;
      for (i = 0;; i = this.videoConfigs.length)
      {
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
      }
      arrayOfVideoConfig[j] = new VideoConfig();
      paramCodedInputByteBufferNano.readMessage(arrayOfVideoConfig[j]);
      this.videoConfigs = arrayOfVideoConfig;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.videoConfigs != null) && (this.videoConfigs.length > 0))
    {
      int i = 0;
      while (i < this.videoConfigs.length)
      {
        VideoConfig localVideoConfig = this.videoConfigs[i];
        if (localVideoConfig != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localVideoConfig);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.AllVideoConfigs
 * JD-Core Version:    0.7.0.1
 */