package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class SwitchStreamReply
  extends MessageNano
{
  private static volatile SwitchStreamReply[] _emptyArray;
  public byte[] extInfo;
  public byte[] sig;
  public DesignatedStreamInfo streamInfo;
  public int time;
  public int videoStatus;
  
  public SwitchStreamReply()
  {
    clear();
  }
  
  public static SwitchStreamReply[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new SwitchStreamReply[0];
      }
      return _emptyArray;
    }
  }
  
  public static SwitchStreamReply parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SwitchStreamReply().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SwitchStreamReply parseFrom(byte[] paramArrayOfByte)
  {
    return (SwitchStreamReply)MessageNano.mergeFrom(new SwitchStreamReply(), paramArrayOfByte);
  }
  
  public SwitchStreamReply clear()
  {
    this.videoStatus = 0;
    this.sig = WireFormatNano.EMPTY_BYTES;
    this.time = 0;
    this.extInfo = WireFormatNano.EMPTY_BYTES;
    this.streamInfo = null;
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
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.sig);
    }
    i = j;
    if (this.time != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.time);
    }
    j = i;
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.extInfo);
    }
    i = j;
    if (this.streamInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, this.streamInfo);
    }
    return i;
  }
  
  public SwitchStreamReply mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 18: 
        this.sig = paramCodedInputByteBufferNano.readBytes();
        break;
      case 24: 
        this.time = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.extInfo = paramCodedInputByteBufferNano.readBytes();
        break;
      }
      if (this.streamInfo == null) {
        this.streamInfo = new DesignatedStreamInfo();
      }
      paramCodedInputByteBufferNano.readMessage(this.streamInfo);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.videoStatus != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.videoStatus);
    }
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.sig);
    }
    if (this.time != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.time);
    }
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.extInfo);
    }
    if (this.streamInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, this.streamInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.SwitchStreamReply
 * JD-Core Version:    0.7.0.1
 */