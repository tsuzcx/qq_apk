package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class SpecChannel
  extends ExtendableMessageNano<SpecChannel>
{
  public SpecProtocol a;
  public SpecProtocol b;
  public SpecProtocol c;
  
  public SpecChannel()
  {
    a();
  }
  
  public SpecChannel a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SpecChannel a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new SpecProtocol();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new SpecProtocol();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new SpecProtocol();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    SpecProtocol localSpecProtocol = this.a;
    int i = j;
    if (localSpecProtocol != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localSpecProtocol);
    }
    localSpecProtocol = this.b;
    j = i;
    if (localSpecProtocol != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localSpecProtocol);
    }
    localSpecProtocol = this.c;
    i = j;
    if (localSpecProtocol != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localSpecProtocol);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    SpecProtocol localSpecProtocol = this.a;
    if (localSpecProtocol != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localSpecProtocol);
    }
    localSpecProtocol = this.b;
    if (localSpecProtocol != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localSpecProtocol);
    }
    localSpecProtocol = this.c;
    if (localSpecProtocol != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localSpecProtocol);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.SpecChannel
 * JD-Core Version:    0.7.0.1
 */