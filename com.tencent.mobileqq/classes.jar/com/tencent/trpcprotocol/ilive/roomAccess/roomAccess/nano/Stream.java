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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new Stream[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (this.frames != null)
    {
      j = i;
      if (this.frames.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.frames.length) {
            break;
          }
          Frame localFrame = this.frames[k];
          j = i;
          if (localFrame != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(1, localFrame);
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
    j = i;
    if (this.rawLevel != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(3, this.rawLevel);
    }
    return j;
  }
  
  public Stream mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 10: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        if (this.frames == null) {}
        Frame[] arrayOfFrame;
        for (i = 0;; i = this.frames.length)
        {
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
        }
        arrayOfFrame[j] = new Frame();
        paramCodedInputByteBufferNano.readMessage(arrayOfFrame[j]);
        this.frames = arrayOfFrame;
        break;
      case 18: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.rawLevel = paramCodedInputByteBufferNano.readInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.frames != null) && (this.frames.length > 0))
    {
      int i = 0;
      while (i < this.frames.length)
      {
        Frame localFrame = this.frames[i];
        if (localFrame != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localFrame);
        }
        i += 1;
      }
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.name);
    }
    if (this.rawLevel != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, this.rawLevel);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Stream
 * JD-Core Version:    0.7.0.1
 */