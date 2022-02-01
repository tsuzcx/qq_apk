package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Stream
  extends MessageNano
{
  private static volatile Stream[] _emptyArray;
  public Frame[] frames;
  public String name;
  public int rawLevel;
  
  public Stream()
  {
    clear();
  }
  
  public static Stream[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new Stream[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static Stream parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new Stream().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static Stream parseFrom(byte[] paramArrayOfByte)
  {
    return (Stream)MessageNano.mergeFrom(new Stream(), paramArrayOfByte);
  }
  
  public Stream clear()
  {
    this.frames = Frame.emptyArray();
    this.name = "";
    this.rawLevel = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.frames;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.frames;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (!this.name.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.name);
    }
    int k = this.rawLevel;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    return j;
  }
  
  public Stream mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.rawLevel = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.name = paramCodedInputByteBufferNano.readString();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        Frame[] arrayOfFrame = this.frames;
        if (arrayOfFrame == null) {
          i = 0;
        } else {
          i = arrayOfFrame.length;
        }
        arrayOfFrame = new Frame[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.frames, 0, arrayOfFrame, 0, i);
          j = i;
        }
        while (j < arrayOfFrame.length - 1)
        {
          arrayOfFrame[j] = new Frame();
          paramCodedInputByteBufferNano.readMessage(arrayOfFrame[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfFrame[j] = new Frame();
        paramCodedInputByteBufferNano.readMessage(arrayOfFrame[j]);
        this.frames = arrayOfFrame;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.frames;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.frames;
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
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.name);
    }
    int i = this.rawLevel;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Stream
 * JD-Core Version:    0.7.0.1
 */