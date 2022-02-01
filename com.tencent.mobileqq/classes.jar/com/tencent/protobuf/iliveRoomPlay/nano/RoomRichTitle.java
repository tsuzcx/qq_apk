package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RoomRichTitle
  extends MessageNano
{
  private static volatile RoomRichTitle[] _emptyArray;
  public RichTitleElement[] elements;
  
  public RoomRichTitle()
  {
    clear();
  }
  
  public static RoomRichTitle[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new RoomRichTitle[0];
      }
      return _emptyArray;
    }
  }
  
  public static RoomRichTitle parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new RoomRichTitle().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static RoomRichTitle parseFrom(byte[] paramArrayOfByte)
  {
    return (RoomRichTitle)MessageNano.mergeFrom(new RoomRichTitle(), paramArrayOfByte);
  }
  
  public RoomRichTitle clear()
  {
    this.elements = RichTitleElement.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = i;
    if (this.elements != null)
    {
      k = i;
      if (this.elements.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.elements.length) {
            break;
          }
          RichTitleElement localRichTitleElement = this.elements[j];
          k = i;
          if (localRichTitleElement != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localRichTitleElement);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public RoomRichTitle mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
      if (this.elements == null) {}
      RichTitleElement[] arrayOfRichTitleElement;
      for (i = 0;; i = this.elements.length)
      {
        arrayOfRichTitleElement = new RichTitleElement[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.elements, 0, arrayOfRichTitleElement, 0, i);
          j = i;
        }
        while (j < arrayOfRichTitleElement.length - 1)
        {
          arrayOfRichTitleElement[j] = new RichTitleElement();
          paramCodedInputByteBufferNano.readMessage(arrayOfRichTitleElement[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfRichTitleElement[j] = new RichTitleElement();
      paramCodedInputByteBufferNano.readMessage(arrayOfRichTitleElement[j]);
      this.elements = arrayOfRichTitleElement;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.elements != null) && (this.elements.length > 0))
    {
      int i = 0;
      while (i < this.elements.length)
      {
        RichTitleElement localRichTitleElement = this.elements[i];
        if (localRichTitleElement != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localRichTitleElement);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RoomRichTitle
 * JD-Core Version:    0.7.0.1
 */