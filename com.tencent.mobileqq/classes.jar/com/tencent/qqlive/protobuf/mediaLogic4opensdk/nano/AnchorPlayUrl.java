package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class AnchorPlayUrl
  extends ExtendableMessageNano<AnchorPlayUrl>
{
  public String a;
  public String b;
  public String c;
  public long d;
  public int e;
  public String f;
  public Resolution g;
  public int h;
  public String i;
  
  public AnchorPlayUrl()
  {
    a();
  }
  
  public AnchorPlayUrl a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = 0L;
    this.e = 0;
    this.f = "";
    this.g = null;
    this.h = 0;
    this.i = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AnchorPlayUrl a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (j != 32)
            {
              if (j != 40)
              {
                if (j != 50)
                {
                  if (j != 58)
                  {
                    if (j != 64)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readString();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else
                  {
                    if (this.g == null) {
                      this.g = new Resolution();
                    }
                    paramCodedInputByteBufferNano.readMessage(this.g);
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
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
    int k = super.computeSerializedSize();
    int j = k;
    if (!this.a.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    k = j;
    if (!this.b.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int m = k;
    if (!this.c.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    long l = this.d;
    j = m;
    if (l != 0L) {
      j = m + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    m = this.e;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(5, m);
    }
    m = k;
    if (!this.f.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    Resolution localResolution = this.g;
    j = m;
    if (localResolution != null) {
      j = m + CodedOutputByteBufferNano.computeMessageSize(7, localResolution);
    }
    m = this.h;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(8, m);
    }
    j = k;
    if (!this.i.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(9, this.i);
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
    long l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    int j = this.e;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, j);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    Resolution localResolution = this.g;
    if (localResolution != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, localResolution);
    }
    j = this.h;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.AnchorPlayUrl
 * JD-Core Version:    0.7.0.1
 */