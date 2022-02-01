package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class VideoReq
  extends MessageNano
{
  private static volatile VideoReq[] _emptyArray;
  public int level;
  public String lgeId;
  
  public VideoReq()
  {
    clear();
  }
  
  public static VideoReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new VideoReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static VideoReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new VideoReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static VideoReq parseFrom(byte[] paramArrayOfByte)
  {
    return (VideoReq)MessageNano.mergeFrom(new VideoReq(), paramArrayOfByte);
  }
  
  public VideoReq clear()
  {
    this.lgeId = "";
    this.level = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.lgeId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.lgeId);
    }
    int k = this.level;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    return j;
  }
  
  public VideoReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
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
        this.lgeId = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.lgeId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.lgeId);
    }
    int i = this.level;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoReq
 * JD-Core Version:    0.7.0.1
 */