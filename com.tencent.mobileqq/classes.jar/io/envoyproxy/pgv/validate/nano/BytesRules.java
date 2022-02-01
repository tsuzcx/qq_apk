package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class BytesRules
  extends ExtendableMessageNano<BytesRules>
{
  public byte[] a;
  public long b;
  public long c;
  public long d;
  public String e;
  public byte[] f;
  public byte[] g;
  public byte[] h;
  public byte[][] i;
  public byte[][] j;
  private int k = 0;
  private Object l;
  
  public BytesRules()
  {
    b();
  }
  
  public BytesRules a()
  {
    this.k = 0;
    this.l = null;
    return this;
  }
  
  public BytesRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      int n;
      Object localObject;
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 104: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 96: 
        this.l = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.k = 12;
        break;
      case 88: 
        this.l = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.k = 11;
        break;
      case 80: 
        this.l = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.k = 10;
        break;
      case 74: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
        localObject = this.j;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new byte[n + m][];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.j, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readBytes();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readBytes();
        this.j = ((byte[][])localObject);
        break;
      case 66: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
        localObject = this.i;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new byte[n + m][];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.i, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readBytes();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readBytes();
        this.i = ((byte[][])localObject);
        break;
      case 58: 
        this.h = paramCodedInputByteBufferNano.readBytes();
        break;
      case 50: 
        this.g = paramCodedInputByteBufferNano.readBytes();
        break;
      case 42: 
        this.f = paramCodedInputByteBufferNano.readBytes();
        break;
      case 34: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  public BytesRules b()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = "";
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = WireFormatNano.EMPTY_BYTES_ARRAY;
    this.j = WireFormatNano.EMPTY_BYTES_ARRAY;
    a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    int m = n;
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      m = n + CodedOutputByteBufferNano.computeBytesSize(1, this.a);
    }
    long l1 = this.c;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    l1 = this.d;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(3, l1);
    }
    n = m;
    if (!this.e.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(4, this.e);
    }
    m = n;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      m = n + CodedOutputByteBufferNano.computeBytesSize(5, this.f);
    }
    n = m;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      n = m + CodedOutputByteBufferNano.computeBytesSize(6, this.g);
    }
    m = n;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      m = n + CodedOutputByteBufferNano.computeBytesSize(7, this.h);
    }
    Object localObject = this.i;
    int i5 = 0;
    n = m;
    int i1;
    int i2;
    int i4;
    int i3;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        i1 = 0;
        for (i2 = 0;; i2 = i3)
        {
          localObject = this.i;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i4 = i1;
          i3 = i2;
          if (localObject != null)
          {
            i3 = i2 + 1;
            i4 = i1 + CodedOutputByteBufferNano.computeBytesSizeNoTag((byte[])localObject);
          }
          n += 1;
          i1 = i4;
        }
        n = m + i1 + i2 * 1;
      }
    }
    localObject = this.j;
    m = n;
    if (localObject != null)
    {
      m = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        i2 = 0;
        m = i5;
        for (;;)
        {
          localObject = this.j;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          i4 = i1;
          i3 = i2;
          if (localObject != null)
          {
            i3 = i2 + 1;
            i4 = i1 + CodedOutputByteBufferNano.computeBytesSizeNoTag((byte[])localObject);
          }
          m += 1;
          i1 = i4;
          i2 = i3;
        }
        m = n + i1 + i2 * 1;
      }
    }
    n = m;
    if (this.k == 10) {
      n = m + CodedOutputByteBufferNano.computeBoolSize(10, ((Boolean)this.l).booleanValue());
    }
    m = n;
    if (this.k == 11) {
      m = n + CodedOutputByteBufferNano.computeBoolSize(11, ((Boolean)this.l).booleanValue());
    }
    n = m;
    if (this.k == 12) {
      n = m + CodedOutputByteBufferNano.computeBoolSize(12, ((Boolean)this.l).booleanValue());
    }
    l1 = this.b;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(13, l1);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    }
    long l1 = this.c;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l1);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.f);
    }
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.g);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.h);
    }
    Object localObject = this.i;
    int n = 0;
    int m;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.i;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeBytes(8, (byte[])localObject);
        }
        m += 1;
      }
    }
    localObject = this.j;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = n;
      for (;;)
      {
        localObject = this.j;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeBytes(9, (byte[])localObject);
        }
        m += 1;
      }
    }
    if (this.k == 10) {
      paramCodedOutputByteBufferNano.writeBool(10, ((Boolean)this.l).booleanValue());
    }
    if (this.k == 11) {
      paramCodedOutputByteBufferNano.writeBool(11, ((Boolean)this.l).booleanValue());
    }
    if (this.k == 12) {
      paramCodedOutputByteBufferNano.writeBool(12, ((Boolean)this.l).booleanValue());
    }
    l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(13, l1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.BytesRules
 * JD-Core Version:    0.7.0.1
 */