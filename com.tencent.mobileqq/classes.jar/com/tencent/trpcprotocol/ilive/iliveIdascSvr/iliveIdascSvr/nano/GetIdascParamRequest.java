package com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetIdascParamRequest
  extends ExtendableMessageNano<GetIdascParamRequest>
{
  public String a;
  public String b;
  public String c;
  public int d;
  
  public GetIdascParamRequest()
  {
    a();
  }
  
  public GetIdascParamRequest a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetIdascParamRequest a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              i = paramCodedInputByteBufferNano.readInt32();
              if ((i == 0) || (i == 1)) {
                this.d = i;
              }
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    int k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano.GetIdascParamRequest
 * JD-Core Version:    0.7.0.1
 */