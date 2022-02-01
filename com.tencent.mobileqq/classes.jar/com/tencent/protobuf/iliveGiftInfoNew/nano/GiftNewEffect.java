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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GiftNewEffect[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.effectNum);
    int j = i;
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.effectId);
    }
    i = j;
    if (!Arrays.equals(this.effectWord, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.effectWord);
    }
    int k = this.effectType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public GiftNewEffect mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 32)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.effectType = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.effectWord = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.effectId = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
        this.effectNum = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
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
    int i = this.effectType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.GiftNewEffect
 * JD-Core Version:    0.7.0.1
 */