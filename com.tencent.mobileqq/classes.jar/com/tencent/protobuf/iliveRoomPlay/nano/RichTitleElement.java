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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new RichTitleElement[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.uint32Type != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.uint32Type);
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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.uint32Type = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.stringText = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.stringUrl = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.uint32Type != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.uint32Type);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RichTitleElement
 * JD-Core Version:    0.7.0.1
 */