package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RichTitleElement
  extends MessageNano
{
  private static volatile RichTitleElement[] _emptyArray;
  public String stringText;
  public String stringUrl;
  public int uint32Type;
  
  public RichTitleElement()
  {
    clear();
  }
  
  public static RichTitleElement[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new RichTitleElement[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static RichTitleElement parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new RichTitleElement().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static RichTitleElement parseFrom(byte[] paramArrayOfByte)
  {
    return (RichTitleElement)MessageNano.mergeFrom(new RichTitleElement(), paramArrayOfByte);
  }
  
  public RichTitleElement clear()
  {
    this.uint32Type = 0;
    this.stringText = "";
    this.stringUrl = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.uint32Type;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!this.stringText.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.stringText);
    }
    i = j;
    if (!this.stringUrl.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.stringUrl);
    }
    return i;
  }
  
  public RichTitleElement mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.stringUrl = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.stringText = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.uint32Type = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.uint32Type;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.stringText.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.stringText);
    }
    if (!this.stringUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.stringUrl);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RichTitleElement
 * JD-Core Version:    0.7.0.1
 */