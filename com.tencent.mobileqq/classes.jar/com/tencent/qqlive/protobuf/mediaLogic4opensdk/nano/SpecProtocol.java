package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class SpecProtocol
  extends ExtendableMessageNano<SpecProtocol>
{
  public UrlItem a;
  public UrlItem b;
  public UrlItem c;
  public UrlItem d;
  public UrlItem e;
  public String f;
  public String g;
  public String h;
  public UrlItem i;
  
  public SpecProtocol()
  {
    a();
  }
  
  public SpecProtocol a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SpecProtocol a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 10)
      {
        if (j != 18)
        {
          if (j != 26)
          {
            if (j != 34)
            {
              if (j != 42)
              {
                if (j != 50)
                {
                  if (j != 58)
                  {
                    if (j != 66)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else
                      {
                        if (this.i == null) {
                          this.i = new UrlItem();
                        }
                        paramCodedInputByteBufferNano.readMessage(this.i);
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readString();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new UrlItem();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new UrlItem();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new UrlItem();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new UrlItem();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new UrlItem();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    UrlItem localUrlItem = this.a;
    int j = k;
    if (localUrlItem != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(1, localUrlItem);
    }
    localUrlItem = this.b;
    k = j;
    if (localUrlItem != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(2, localUrlItem);
    }
    localUrlItem = this.c;
    j = k;
    if (localUrlItem != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(3, localUrlItem);
    }
    localUrlItem = this.d;
    k = j;
    if (localUrlItem != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(4, localUrlItem);
    }
    localUrlItem = this.e;
    j = k;
    if (localUrlItem != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(5, localUrlItem);
    }
    k = j;
    if (!this.f.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    j = k;
    if (!this.g.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    k = j;
    if (!this.h.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    localUrlItem = this.i;
    j = k;
    if (localUrlItem != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(9, localUrlItem);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    UrlItem localUrlItem = this.a;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localUrlItem);
    }
    localUrlItem = this.b;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localUrlItem);
    }
    localUrlItem = this.c;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localUrlItem);
    }
    localUrlItem = this.d;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localUrlItem);
    }
    localUrlItem = this.e;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localUrlItem);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.h);
    }
    localUrlItem = this.i;
    if (localUrlItem != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, localUrlItem);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.SpecProtocol
 * JD-Core Version:    0.7.0.1
 */