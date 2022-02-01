package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;

public final class MsgElement
  extends ExtendableMessageNano<MsgElement>
{
  private static volatile MsgElement[] e;
  public int a;
  public TextElement b;
  public ImageElement c;
  public long d;
  
  public MsgElement()
  {
    b();
  }
  
  public static MsgElement[] a()
  {
    if (e == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (e == null) {
          e = new MsgElement[0];
        }
      }
    }
    return e;
  }
  
  public MsgElement a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new ImageElement();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new TextElement();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else
      {
        i = paramCodedInputByteBufferNano.readInt32();
        if ((i == 0) || (i == 1) || (i == 2)) {
          this.a = i;
        }
      }
    }
    return this;
  }
  
  public MsgElement b()
  {
    this.a = 0;
    this.b = null;
    this.c = null;
    this.d = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    long l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    long l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.MsgElement
 * JD-Core Version:    0.7.0.1
 */