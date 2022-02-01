package com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetStaticConfigRsp
  extends ExtendableMessageNano<GetStaticConfigRsp>
{
  public int a;
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  public String g;
  public String h;
  
  public GetStaticConfigRsp()
  {
    a();
  }
  
  public GetStaticConfigRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = "";
    this.g = "";
    this.h = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetStaticConfigRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 50)
                {
                  if (i != 58)
                  {
                    if (i != 66)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
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
              else {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
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
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
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
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    k = j;
    if (!this.c.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    i = k;
    if (!this.d.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    i = j;
    if (!this.f.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    j = i;
    if (!this.g.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    i = j;
    if (!this.h.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.GetStaticConfigRsp
 * JD-Core Version:    0.7.0.1
 */