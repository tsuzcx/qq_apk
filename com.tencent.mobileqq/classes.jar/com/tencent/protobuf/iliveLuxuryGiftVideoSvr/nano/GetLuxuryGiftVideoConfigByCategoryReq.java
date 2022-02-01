package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLuxuryGiftVideoConfigByCategoryReq
  extends MessageNano
{
  private static volatile GetLuxuryGiftVideoConfigByCategoryReq[] _emptyArray;
  public int category;
  public int level;
  
  public GetLuxuryGiftVideoConfigByCategoryReq()
  {
    clear();
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GetLuxuryGiftVideoConfigByCategoryReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GetLuxuryGiftVideoConfigByCategoryReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq parseFrom(byte[] paramArrayOfByte)
  {
    return (GetLuxuryGiftVideoConfigByCategoryReq)MessageNano.mergeFrom(new GetLuxuryGiftVideoConfigByCategoryReq(), paramArrayOfByte);
  }
  
  public GetLuxuryGiftVideoConfigByCategoryReq clear()
  {
    this.category = 0;
    this.level = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.category;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.level;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    return j;
  }
  
  public GetLuxuryGiftVideoConfigByCategoryReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.level = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.category = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.category;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.level;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.GetLuxuryGiftVideoConfigByCategoryReq
 * JD-Core Version:    0.7.0.1
 */