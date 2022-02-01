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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new AVInfo[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.videoStatus;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.mode;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    i = j;
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.sig);
    }
    k = this.time;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    i = j;
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.extInfo);
    }
    Object localObject = this.rtmp;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.hls;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    localObject = this.flv;
    k = i;
    if (localObject != null) {
      k = i + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.streamInfo;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    k = this.avType;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    k = this.bitrate;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(11, k);
    }
    return j;
  }
  
  public AVInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 88: 
        this.bitrate = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.avType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        if (this.streamInfo == null) {
          this.streamInfo = new DesignatedStreamInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.streamInfo);
        break;
      case 66: 
        if (this.flv == null) {
          this.flv = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.flv);
        break;
      case 58: 
        if (this.hls == null) {
          this.hls = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.hls);
        break;
      case 50: 
        if (this.rtmp == null) {
          this.rtmp = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.rtmp);
        break;
      case 42: 
        this.extInfo = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.time = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.sig = paramCodedInputByteBufferNano.readBytes();
        break;
      case 16: 
        this.mode = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 8: 
        this.videoStatus = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.videoStatus;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.mode;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.sig);
    }
    i = this.time;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.extInfo);
    }
    Object localObject = this.rtmp;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
    }
    localObject = this.hls;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    localObject = this.flv;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.streamInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    i = this.avType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    i = this.bitrate;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.AVInfo
 * JD-Core Version:    0.7.0.1
 */