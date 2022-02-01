package com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class KeyValueItem
  extends ExtendableMessageNano<KeyValueItem>
{
  private static volatile KeyValueItem[] h;
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public long f;
  public String g;
  
  public KeyValueItem()
  {
    b();
  }
  
  public static KeyValueItem[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new KeyValueItem[0];
        }
      }
    }
    return h;
  }
  
  public KeyValueItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
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
  
  public KeyValueItem b()
  {
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    this.e = "";
    this.f = 0L;
    this.g = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (!this.a.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    j = i;
    if (!this.e.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    long l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(6, l);
    }
    j = i;
    if (!this.g.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.g);
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
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    long l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(6, l);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.KeyValueItem
 * JD-Core Version:    0.7.0.1
 */