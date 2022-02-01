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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new VideoUrl[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.level;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
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
    k = this.isGrey;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    k = this.vibrate;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    k = this.vibrateRange;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    k = this.clientType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    return j;
  }
  
  public VideoUrl mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (i != 64)
                    {
                      if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.clientType = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.vibrateRange = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.vibrate = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.isGrey = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.lgeId = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.hash = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.url = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.level = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.level;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
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
    i = this.isGrey;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.vibrate;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    i = this.vibrateRange;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    i = this.clientType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoUrl
 * JD-Core Version:    0.7.0.1
 */