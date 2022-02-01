package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Stream
  extends ExtendableMessageNano<Stream>
{
  private static volatile Stream[] d;
  public Frame[] a;
  public String b;
  public int c;
  
  public Stream()
  {
    b();
  }
  
  public static Stream[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new Stream[0];
        }
      }
    }
    return d;
  }
  
  public Stream a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        Frame[] arrayOfFrame = this.a;
        if (arrayOfFrame == null) {
          i = 0;
        } else {
          i = arrayOfFrame.length;
        }
        arrayOfFrame = new Frame[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfFrame, 0, i);
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
        this.a = arrayOfFrame;
      }
    }
    return this;
  }
  
  public Stream b()
  {
    this.a = Frame.a();
    this.b = "";
    this.c = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.a;
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
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.a;
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
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.Stream
 * JD-Core Version:    0.7.0.1
 */