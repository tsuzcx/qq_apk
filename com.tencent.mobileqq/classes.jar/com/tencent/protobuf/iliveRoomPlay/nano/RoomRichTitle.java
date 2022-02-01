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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new RoomRichTitle[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.elements;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.elements;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
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
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        RichTitleElement[] arrayOfRichTitleElement = this.elements;
        if (arrayOfRichTitleElement == null) {
          i = 0;
        } else {
          i = arrayOfRichTitleElement.length;
        }
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
        arrayOfRichTitleElement[j] = new RichTitleElement();
        paramCodedInputByteBufferNano.readMessage(arrayOfRichTitleElement[j]);
        this.elements = arrayOfRichTitleElement;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.elements;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.elements;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RoomRichTitle
 * JD-Core Version:    0.7.0.1
 */