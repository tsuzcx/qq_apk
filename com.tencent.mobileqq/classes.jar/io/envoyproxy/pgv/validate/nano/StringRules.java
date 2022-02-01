package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class StringRules
  extends ExtendableMessageNano<StringRules>
{
  public String a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String[] m;
  public String[] n;
  public boolean o;
  private int p = 0;
  private Object q;
  
  public StringRules()
  {
    b();
  }
  
  public StringRules a()
  {
    this.p = 0;
    this.q = null;
    return this;
  }
  
  public StringRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      int i2;
      String[] arrayOfString;
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 232: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 29;
        break;
      case 224: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 28;
        break;
      case 216: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 27;
        break;
      case 208: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 26;
        break;
      case 200: 
        this.o = paramCodedInputByteBufferNano.readBool();
        break;
      case 192: 
        this.q = Integer.valueOf(paramCodedInputByteBufferNano.readEnum());
        this.p = 24;
        break;
      case 186: 
        this.l = paramCodedInputByteBufferNano.readString();
        break;
      case 176: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 22;
        break;
      case 168: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 21;
        break;
      case 160: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 152: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 144: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 18;
        break;
      case 136: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 17;
        break;
      case 128: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 16;
        break;
      case 120: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 15;
        break;
      case 112: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 14;
        break;
      case 104: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 13;
        break;
      case 96: 
        this.q = Boolean.valueOf(paramCodedInputByteBufferNano.readBool());
        this.p = 12;
        break;
      case 90: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        arrayOfString = this.n;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.n, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.n = arrayOfString;
        break;
      case 82: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 82);
        arrayOfString = this.m;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.m, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.m = arrayOfString;
        break;
      case 74: 
        this.k = paramCodedInputByteBufferNano.readString();
        break;
      case 66: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 58: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.h = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public StringRules b()
  {
    this.a = "";
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = WireFormatNano.EMPTY_STRING_ARRAY;
    this.n = WireFormatNano.EMPTY_STRING_ARRAY;
    this.o = true;
    a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    int i1 = i2;
    if (!this.a.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    long l1 = this.c;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    l1 = this.d;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(3, l1);
    }
    l1 = this.f;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(4, l1);
    }
    l1 = this.g;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(5, l1);
    }
    i2 = i1;
    if (!this.h.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(6, this.h);
    }
    i1 = i2;
    if (!this.i.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(7, this.i);
    }
    i2 = i1;
    if (!this.j.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(8, this.j);
    }
    i1 = i2;
    if (!this.k.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(9, this.k);
    }
    Object localObject = this.m;
    int i7 = 0;
    i2 = i1;
    int i3;
    int i4;
    int i6;
    int i5;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i5)
        {
          localObject = this.m;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i2 += 1;
          i3 = i6;
        }
        i2 = i1 + i3 + i4 * 1;
      }
    }
    localObject = this.n;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i3 = 0;
        i4 = 0;
        i1 = i7;
        for (;;)
        {
          localObject = this.n;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i1 += 1;
          i3 = i6;
          i4 = i5;
        }
        i1 = i2 + i3 + i4 * 1;
      }
    }
    i2 = i1;
    if (this.p == 12) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(12, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (this.p == 13) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(13, ((Boolean)this.q).booleanValue());
    }
    i2 = i1;
    if (this.p == 14) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(14, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (this.p == 15) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(15, ((Boolean)this.q).booleanValue());
    }
    i2 = i1;
    if (this.p == 16) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(16, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (this.p == 17) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(17, ((Boolean)this.q).booleanValue());
    }
    i2 = i1;
    if (this.p == 18) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(18, ((Boolean)this.q).booleanValue());
    }
    l1 = this.b;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(19, l1);
    }
    l1 = this.e;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(20, l1);
    }
    i1 = i2;
    if (this.p == 21) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(21, ((Boolean)this.q).booleanValue());
    }
    i2 = i1;
    if (this.p == 22) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(22, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (!this.l.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(23, this.l);
    }
    i2 = i1;
    if (this.p == 24) {
      i2 = i1 + CodedOutputByteBufferNano.computeEnumSize(24, ((Integer)this.q).intValue());
    }
    boolean bool = this.o;
    i1 = i2;
    if (bool != true) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(25, bool);
    }
    i2 = i1;
    if (this.p == 26) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(26, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (this.p == 27) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(27, ((Boolean)this.q).booleanValue());
    }
    i2 = i1;
    if (this.p == 28) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(28, ((Boolean)this.q).booleanValue());
    }
    i1 = i2;
    if (this.p == 29) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(29, ((Boolean)this.q).booleanValue());
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    long l1 = this.c;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l1);
    }
    l1 = this.f;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l1);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l1);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.h);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.j);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.k);
    }
    Object localObject = this.m;
    int i2 = 0;
    int i1;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.m;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(10, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.n;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.n;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(11, (String)localObject);
        }
        i1 += 1;
      }
    }
    if (this.p == 12) {
      paramCodedOutputByteBufferNano.writeBool(12, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 13) {
      paramCodedOutputByteBufferNano.writeBool(13, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 14) {
      paramCodedOutputByteBufferNano.writeBool(14, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 15) {
      paramCodedOutputByteBufferNano.writeBool(15, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 16) {
      paramCodedOutputByteBufferNano.writeBool(16, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 17) {
      paramCodedOutputByteBufferNano.writeBool(17, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 18) {
      paramCodedOutputByteBufferNano.writeBool(18, ((Boolean)this.q).booleanValue());
    }
    l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(19, l1);
    }
    l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(20, l1);
    }
    if (this.p == 21) {
      paramCodedOutputByteBufferNano.writeBool(21, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 22) {
      paramCodedOutputByteBufferNano.writeBool(22, ((Boolean)this.q).booleanValue());
    }
    if (!this.l.equals("")) {
      paramCodedOutputByteBufferNano.writeString(23, this.l);
    }
    if (this.p == 24) {
      paramCodedOutputByteBufferNano.writeEnum(24, ((Integer)this.q).intValue());
    }
    boolean bool = this.o;
    if (bool != true) {
      paramCodedOutputByteBufferNano.writeBool(25, bool);
    }
    if (this.p == 26) {
      paramCodedOutputByteBufferNano.writeBool(26, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 27) {
      paramCodedOutputByteBufferNano.writeBool(27, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 28) {
      paramCodedOutputByteBufferNano.writeBool(28, ((Boolean)this.q).booleanValue());
    }
    if (this.p == 29) {
      paramCodedOutputByteBufferNano.writeBool(29, ((Boolean)this.q).booleanValue());
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.StringRules
 * JD-Core Version:    0.7.0.1
 */