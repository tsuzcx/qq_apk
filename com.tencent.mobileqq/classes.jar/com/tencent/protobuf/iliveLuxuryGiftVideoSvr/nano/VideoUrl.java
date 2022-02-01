package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class VideoUrl
  extends MessageNano
{
  private static volatile VideoUrl[] _emptyArray;
  public int clientType;
  public String hash;
  public int isGrey;
  public int level;
  public String lgeId;
  public String url;
  public int vibrate;
  public int vibrateRange;
  
  public VideoUrl()
  {
    clear();
  }
  
  public static VideoUrl[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new VideoUrl[0];
      }
      return _emptyArray;
    }
  }
  
  public static VideoUrl parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new VideoUrl().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static VideoUrl parseFrom(byte[] paramArrayOfByte)
  {
    return (VideoUrl)MessageNano.mergeFrom(new VideoUrl(), paramArrayOfByte);
  }
  
  public VideoUrl clear()
  {
    this.level = 0;
    this.url = "";
    this.hash = "";
    this.lgeId = "";
    this.isGrey = 0;
    this.vibrate = 0;
    this.vibrateRange = 0;
    this.clientType = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.level != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.level);
    }
    j = i;
    if (!this.url.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.url);
    }
    i = j;
    if (!this.hash.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.hash);
    }
    j = i;
    if (!this.lgeId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.lgeId);
    }
    i = j;
    if (this.isGrey != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.isGrey);
    }
    j = i;
    if (this.vibrate != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, this.vibrate);
    }
    i = j;
    if (this.vibrateRange != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.vibrateRange);
    }
    j = i;
    if (this.clientType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, this.clientType);
    }
    return j;
  }
  
  public VideoUrl mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.level = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.url = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.hash = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.lgeId = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.isGrey = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.vibrate = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.vibrateRange = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.clientType = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.level != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.level);
    }
    if (!this.url.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.url);
    }
    if (!this.hash.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.hash);
    }
    if (!this.lgeId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.lgeId);
    }
    if (this.isGrey != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.isGrey);
    }
    if (this.vibrate != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.vibrate);
    }
    if (this.vibrateRange != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.vibrateRange);
    }
    if (this.clientType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.clientType);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoUrl
 * JD-Core Version:    0.7.0.1
 */