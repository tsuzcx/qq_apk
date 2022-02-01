package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class GearInfo
  extends ExtendableMessageNano<GearInfo>
{
  private static volatile GearInfo[] f;
  public int a;
  public int b;
  public String c;
  public int d;
  public int e;
  
  public GearInfo()
  {
    b();
  }
  
  public static GearInfo[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new GearInfo[0];
        }
      }
    }
    return f;
  }
  
  public GearInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public GearInfo b()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = 0;
    this.e = 0;
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
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    k = j;
    if (!this.c.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    j = this.d;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(4, j);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.GearInfo
 * JD-Core Version:    0.7.0.1
 */