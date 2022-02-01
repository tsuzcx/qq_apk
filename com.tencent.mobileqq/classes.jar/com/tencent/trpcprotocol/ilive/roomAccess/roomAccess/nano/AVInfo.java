package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class AVInfo
  extends MessageNano
{
  private static volatile AVInfo[] _emptyArray;
  public int avType;
  public int bitrate;
  public byte[] extInfo;
  public OpenSdkUrl flv;
  public OpenSdkUrl hls;
  public int mode;
  public OpenSdkUrl rtmp;
  public byte[] sig;
  public DesignatedStreamInfo streamInfo;
  public int time;
  public int videoStatus;
  
  public AVInfo()
  {
    clear();
  }
  
  public static AVInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new AVInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static AVInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new AVInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static AVInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (AVInfo)MessageNano.mergeFrom(new AVInfo(), paramArrayOfByte);
  }
  
  public AVInfo clear()
  {
    this.videoStatus = 0;
    this.mode = 0;
    this.sig = WireFormatNano.EMPTY_BYTES;
    this.time = 0;
    this.extInfo = WireFormatNano.EMPTY_BYTES;
    this.rtmp = null;
    this.hls = null;
    this.flv = null;
    this.streamInfo = null;
    this.avType = 0;
    this.bitrate = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.videoStatus != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.videoStatus);
    }
    j = i;
    if (this.mode != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.mode);
    }
    i = j;
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.sig);
    }
    j = i;
    if (this.time != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.time);
    }
    i = j;
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.extInfo);
    }
    j = i;
    if (this.rtmp != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, this.rtmp);
    }
    i = j;
    if (this.hls != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, this.hls);
    }
    j = i;
    if (this.flv != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, this.flv);
    }
    i = j;
    if (this.streamInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, this.streamInfo);
    }
    j = i;
    if (this.avType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, this.avType);
    }
    i = j;
    if (this.bitrate != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(11, this.bitrate);
    }
    return i;
  }
  
  public AVInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.videoStatus = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.mode = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.sig = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.time = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.extInfo = paramCodedInputByteBufferNano.readBytes();
        break;
      case 50: 
        if (this.rtmp == null) {
          this.rtmp = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.rtmp);
        break;
      case 58: 
        if (this.hls == null) {
          this.hls = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.hls);
        break;
      case 66: 
        if (this.flv == null) {
          this.flv = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.flv);
        break;
      case 74: 
        if (this.streamInfo == null) {
          this.streamInfo = new DesignatedStreamInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.streamInfo);
        break;
      case 80: 
        this.avType = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.bitrate = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.videoStatus != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.videoStatus);
    }
    if (this.mode != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.mode);
    }
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.sig);
    }
    if (this.time != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.time);
    }
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.extInfo);
    }
    if (this.rtmp != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, this.rtmp);
    }
    if (this.hls != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, this.hls);
    }
    if (this.flv != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, this.flv);
    }
    if (this.streamInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, this.streamInfo);
    }
    if (this.avType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.avType);
    }
    if (this.bitrate != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, this.bitrate);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.AVInfo
 * JD-Core Version:    0.7.0.1
 */