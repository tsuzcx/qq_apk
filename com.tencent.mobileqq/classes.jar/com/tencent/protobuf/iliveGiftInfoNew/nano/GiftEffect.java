package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GiftEffect
  extends MessageNano
{
  private static volatile GiftEffect[] _emptyArray;
  public FlashEffect flashEffect;
  public FlashEffect fullscreenEffect;
  public byte[] gifEffect;
  public int maxNum;
  public int minNum;
  
  public GiftEffect()
  {
    clear();
  }
  
  public static GiftEffect[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GiftEffect[0];
      }
      return _emptyArray;
    }
  }
  
  public static GiftEffect parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GiftEffect().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GiftEffect parseFrom(byte[] paramArrayOfByte)
  {
    return (GiftEffect)MessageNano.mergeFrom(new GiftEffect(), paramArrayOfByte);
  }
  
  public GiftEffect clear()
  {
    this.minNum = 0;
    this.maxNum = 0;
    this.gifEffect = WireFormatNano.EMPTY_BYTES;
    this.flashEffect = null;
    this.fullscreenEffect = null;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.minNum) + CodedOutputByteBufferNano.computeUInt32Size(2, this.maxNum);
    int i = j;
    if (!Arrays.equals(this.gifEffect, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.gifEffect);
    }
    j = i;
    if (this.flashEffect != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, this.flashEffect);
    }
    i = j;
    if (this.fullscreenEffect != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, this.fullscreenEffect);
    }
    return i;
  }
  
  public GiftEffect mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8: 
        this.minNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.maxNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.gifEffect = paramCodedInputByteBufferNano.readBytes();
        break;
      case 34: 
        if (this.flashEffect == null) {
          this.flashEffect = new FlashEffect();
        }
        paramCodedInputByteBufferNano.readMessage(this.flashEffect);
        break;
      }
      if (this.fullscreenEffect == null) {
        this.fullscreenEffect = new FlashEffect();
      }
      paramCodedInputByteBufferNano.readMessage(this.fullscreenEffect);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.minNum);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.maxNum);
    if (!Arrays.equals(this.gifEffect, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.gifEffect);
    }
    if (this.flashEffect != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, this.flashEffect);
    }
    if (this.fullscreenEffect != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, this.fullscreenEffect);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.GiftEffect
 * JD-Core Version:    0.7.0.1
 */