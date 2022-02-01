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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new SwitchStreamReply[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.videoStatus;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.sig);
    }
    k = this.time;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    j = i;
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.extInfo);
    }
    DesignatedStreamInfo localDesignatedStreamInfo = this.streamInfo;
    i = j;
    if (localDesignatedStreamInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, localDesignatedStreamInfo);
    }
    return i;
  }
  
  public SwitchStreamReply mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else
              {
                if (this.streamInfo == null) {
                  this.streamInfo = new DesignatedStreamInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.streamInfo);
              }
            }
            else {
              this.extInfo = paramCodedInputByteBufferNano.readBytes();
            }
          }
          else {
            this.time = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.sig = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
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
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.sig);
    }
    i = this.time;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    if (!Arrays.equals(this.extInfo, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.extInfo);
    }
    DesignatedStreamInfo localDesignatedStreamInfo = this.streamInfo;
    if (localDesignatedStreamInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localDesignatedStreamInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.SwitchStreamReply
 * JD-Core Version:    0.7.0.1
 */