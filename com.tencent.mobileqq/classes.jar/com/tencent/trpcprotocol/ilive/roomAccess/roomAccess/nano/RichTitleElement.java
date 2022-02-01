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
    this.type = 0;
    this.text = "";
    this.url = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.type;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
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
            this.url = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.text = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.type = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.type;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.RichTitleElement
 * JD-Core Version:    0.7.0.1
 */