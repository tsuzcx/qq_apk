package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RichTitleElement
  extends MessageNano
{
  private static volatile RichTitleElement[] _emptyArray;
  public String text;
  public int type;
  public String url;
  
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
    this.type = 0;
    this.text = "";
    this.url = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.type != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.type);
    }
    j = i;
    if (!this.text.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.text);
    }
    i = j;
    if (!this.url.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.url);
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
        this.type = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.text = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.url = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.type != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.type);
    }
    if (!this.text.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.text);
    }
    if (!this.url.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.url);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.RichTitleElement
 * JD-Core Version:    0.7.0.1
 */