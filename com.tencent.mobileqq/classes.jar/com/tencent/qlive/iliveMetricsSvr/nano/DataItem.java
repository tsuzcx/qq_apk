package com.tencent.qlive.iliveMetricsSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class DataItem
  extends ExtendableMessageNano<DataItem>
{
  private static volatile DataItem[] e;
  public int a;
  public String b;
  public long c;
  public boolean d;
  
  public DataItem()
  {
    b();
  }
  
  public static DataItem[] a()
  {
    if (e == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (e == null) {
          e = new DataItem[0];
        }
      }
    }
    return e;
  }
  
  public DataItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBool();
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
      else
      {
        i = paramCodedInputByteBufferNano.readInt32();
        if ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4)) {
          this.a = i;
        }
      }
    }
    return this;
  }
  
  public DataItem b()
  {
    this.a = 0;
    this.b = "";
    this.c = 0L;
    this.d = false;
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
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    long l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    boolean bool = this.d;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(4, bool);
    }
    return j;
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
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    boolean bool = this.d;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(4, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qlive.iliveMetricsSvr.nano.DataItem
 * JD-Core Version:    0.7.0.1
 */