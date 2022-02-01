package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class MediaInfo
  extends MessageNano
{
  private static volatile MediaInfo[] _emptyArray;
  public String rtmpUrl;
  public byte[] sig;
  public String streamParam;
  public long timeout;
  public long type;
  
  public MediaInfo()
  {
    clear();
  }
  
  public static MediaInfo[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new MediaInfo[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static MediaInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new MediaInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static MediaInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (MediaInfo)MessageNano.mergeFrom(new MediaInfo(), paramArrayOfByte);
  }
  
  public MediaInfo clear()
  {
    this.sig = WireFormatNano.EMPTY_BYTES;
    this.timeout = 0L;
    this.type = 0L;
    this.rtmpUrl = "";
    this.streamParam = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(1, this.sig);
    }
    long l = this.timeout;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    l = this.type;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(3, l);
    }
    j = i;
    if (!this.rtmpUrl.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.rtmpUrl);
    }
    i = j;
    if (!this.streamParam.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.streamParam);
    }
    return i;
  }
  
  public MediaInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              else {
                this.streamParam = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.rtmpUrl = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.type = paramCodedInputByteBufferNano.readInt64();
          }
        }
        else {
          this.timeout = paramCodedInputByteBufferNano.readInt64();
        }
      }
      else {
        this.sig = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.sig);
    }
    long l = this.timeout;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    l = this.type;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(3, l);
    }
    if (!this.rtmpUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.rtmpUrl);
    }
    if (!this.streamParam.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.streamParam);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.MediaInfo
 * JD-Core Version:    0.7.0.1
 */