package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GiftNewEffect
  extends MessageNano
{
  private static volatile GiftNewEffect[] _emptyArray;
  public byte[] effectId;
  public int effectNum;
  public int effectType;
  public byte[] effectWord;
  
  public GiftNewEffect()
  {
    clear();
  }
  
  public static GiftNewEffect[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GiftNewEffect[0];
      }
      return _emptyArray;
    }
  }
  
  public static GiftNewEffect parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GiftNewEffect().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GiftNewEffect parseFrom(byte[] paramArrayOfByte)
  {
    return (GiftNewEffect)MessageNano.mergeFrom(new GiftNewEffect(), paramArrayOfByte);
  }
  
  public GiftNewEffect clear()
  {
    this.effectNum = 0;
    this.effectId = WireFormatNano.EMPTY_BYTES;
    this.effectWord = WireFormatNano.EMPTY_BYTES;
    this.effectType = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.effectNum);
    int i = j;
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(2, this.effectId);
    }
    j = i;
    if (!Arrays.equals(this.effectWord, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(3, this.effectWord);
    }
    i = j;
    if (this.effectType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, this.effectType);
    }
    return i;
  }
  
  public GiftNewEffect mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.effectNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.effectId = paramCodedInputByteBufferNano.readBytes();
        break;
      case 26: 
        this.effectWord = paramCodedInputByteBufferNano.readBytes();
        break;
      }
      this.effectType = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.effectNum);
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.effectId);
    }
    if (!Arrays.equals(this.effectWord, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.effectWord);
    }
    if (this.effectType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.effectType);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.GiftNewEffect
 * JD-Core Version:    0.7.0.1
 */