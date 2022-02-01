package com.tencent.qqlive.anchor.fans.server.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class FansGroupItem
  extends ExtendableMessageNano<FansGroupItem>
{
  private static volatile FansGroupItem[] f;
  public long a;
  public String b;
  public long c;
  public int d;
  public String e;
  
  public FansGroupItem()
  {
    b();
  }
  
  public static FansGroupItem[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new FansGroupItem[0];
        }
      }
    }
    return f;
  }
  
  public FansGroupItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 32)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public FansGroupItem b()
  {
    this.a = 0L;
    this.b = "";
    this.c = 0L;
    this.d = 0;
    this.e = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    int k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.anchor.fans.server.nano.FansGroupItem
 * JD-Core Version:    0.7.0.1
 */