package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class UrlTrivialInfo
  extends ExtendableMessageNano<UrlTrivialInfo>
{
  public SpecChannel a;
  public SpecChannel b;
  
  public UrlTrivialInfo()
  {
    a();
  }
  
  public UrlTrivialInfo a()
  {
    this.a = null;
    this.b = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public UrlTrivialInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new SpecChannel();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new SpecChannel();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    SpecChannel localSpecChannel = this.a;
    int i = j;
    if (localSpecChannel != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localSpecChannel);
    }
    localSpecChannel = this.b;
    j = i;
    if (localSpecChannel != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localSpecChannel);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    SpecChannel localSpecChannel = this.a;
    if (localSpecChannel != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localSpecChannel);
    }
    localSpecChannel = this.b;
    if (localSpecChannel != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localSpecChannel);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.UrlTrivialInfo
 * JD-Core Version:    0.7.0.1
 */