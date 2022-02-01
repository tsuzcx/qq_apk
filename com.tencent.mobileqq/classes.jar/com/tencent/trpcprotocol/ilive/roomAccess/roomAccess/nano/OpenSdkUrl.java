package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class OpenSdkUrl
  extends MessageNano
{
  private static volatile OpenSdkUrl[] _emptyArray;
  public String h265;
  public String hd;
  public String ld;
  public String raw;
  public String sd;
  public String sound;
  
  public OpenSdkUrl()
  {
    clear();
  }
  
  public static OpenSdkUrl[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new OpenSdkUrl[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static OpenSdkUrl parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new OpenSdkUrl().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static OpenSdkUrl parseFrom(byte[] paramArrayOfByte)
  {
    return (OpenSdkUrl)MessageNano.mergeFrom(new OpenSdkUrl(), paramArrayOfByte);
  }
  
  public OpenSdkUrl clear()
  {
    this.raw = "";
    this.hd = "";
    this.sd = "";
    this.ld = "";
    this.sound = "";
    this.h265 = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.raw.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.raw);
    }
    j = i;
    if (!this.hd.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.hd);
    }
    i = j;
    if (!this.sd.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.sd);
    }
    j = i;
    if (!this.ld.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.ld);
    }
    i = j;
    if (!this.sound.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.sound);
    }
    j = i;
    if (!this.h265.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.h265);
    }
    return j;
  }
  
  public OpenSdkUrl mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.h265 = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.sound = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.ld = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.sd = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.hd = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.raw = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.raw.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.raw);
    }
    if (!this.hd.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.hd);
    }
    if (!this.sd.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.sd);
    }
    if (!this.ld.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.ld);
    }
    if (!this.sound.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.sound);
    }
    if (!this.h265.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.h265);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.OpenSdkUrl
 * JD-Core Version:    0.7.0.1
 */