package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GetAnchorInfoRsp
  extends ExtendableMessageNano<GetAnchorInfoRsp>
{
  public int a;
  public String[] b;
  public String[] c;
  public String[] d;
  public byte[] e;
  public byte[] f;
  public String[] g;
  public String[] h;
  public String[] i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public int p;
  public UrlTrivialInfo q;
  
  public GetAnchorInfoRsp()
  {
    a();
  }
  
  public GetAnchorInfoRsp a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_STRING_ARRAY;
    this.c = WireFormatNano.EMPTY_STRING_ARRAY;
    this.d = WireFormatNano.EMPTY_STRING_ARRAY;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = WireFormatNano.EMPTY_STRING_ARRAY;
    this.h = WireFormatNano.EMPTY_STRING_ARRAY;
    this.i = WireFormatNano.EMPTY_STRING_ARRAY;
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = 0;
    this.q = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetAnchorInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 146: 
        if (this.q == null) {
          this.q = new UrlTrivialInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.q);
        break;
      case 136: 
        this.p = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 130: 
        this.o = paramCodedInputByteBufferNano.readString();
        break;
      case 122: 
        this.n = paramCodedInputByteBufferNano.readString();
        break;
      case 114: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 106: 
        this.l = paramCodedInputByteBufferNano.readString();
        break;
      case 98: 
        this.k = paramCodedInputByteBufferNano.readString();
        break;
      case 90: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 82: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 82);
        arrayOfString = this.i;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.i, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.i = arrayOfString;
        break;
      case 74: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
        arrayOfString = this.h;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.h, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.h = arrayOfString;
        break;
      case 66: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
        arrayOfString = this.g;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.g, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.g = arrayOfString;
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readBytes();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readBytes();
        break;
      case 34: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        arrayOfString = this.d;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.d, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.d = arrayOfString;
        break;
      case 26: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
        arrayOfString = this.c;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.c, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.c = arrayOfString;
        break;
      case 18: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        arrayOfString = this.b;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.b, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.b = arrayOfString;
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i6 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    Object localObject = this.b;
    int i7 = 0;
    int i1 = i6;
    int i5;
    int i4;
    if (localObject != null)
    {
      i1 = i6;
      if (localObject.length > 0)
      {
        i1 = 0;
        i2 = 0;
        for (i3 = 0;; i3 = i4)
        {
          localObject = this.b;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i5 = i2;
          i4 = i3;
          if (localObject != null)
          {
            i4 = i3 + 1;
            i5 = i2 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i1 += 1;
          i2 = i5;
        }
        i1 = i6 + i2 + i3 * 1;
      }
    }
    localObject = this.c;
    int i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i5)
        {
          localObject = this.c;
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
    localObject = this.d;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i1 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i5)
        {
          localObject = this.d;
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
        }
        i1 = i2 + i3 + i4 * 1;
      }
    }
    i2 = i1;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    i1 = i2;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    localObject = this.g;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i5)
        {
          localObject = this.g;
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
    localObject = this.h;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i1 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i5)
        {
          localObject = this.h;
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
        }
        i1 = i2 + i3 + i4 * 1;
      }
    }
    localObject = this.i;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        i4 = 0;
        i2 = i7;
        for (;;)
        {
          localObject = this.i;
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
          i4 = i5;
        }
        i2 = i1 + i3 + i4 * 1;
      }
    }
    i1 = i2;
    if (!this.j.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(11, this.j);
    }
    i2 = i1;
    if (!this.k.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(12, this.k);
    }
    i1 = i2;
    if (!this.l.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(13, this.l);
    }
    i2 = i1;
    if (!this.m.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(14, this.m);
    }
    int i3 = i2;
    if (!this.n.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(15, this.n);
    }
    i1 = i3;
    if (!this.o.equals("")) {
      i1 = i3 + CodedOutputByteBufferNano.computeStringSize(16, this.o);
    }
    i3 = this.p;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(17, i3);
    }
    localObject = this.q;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)localObject);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    Object localObject = this.b;
    int i2 = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.b;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(2, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.c;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(3, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.d;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(4, (String)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.g;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(8, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.h;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(9, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.i;
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
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(11, this.j);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.k);
    }
    if (!this.l.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.l);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(14, this.m);
    }
    if (!this.n.equals("")) {
      paramCodedOutputByteBufferNano.writeString(15, this.n);
    }
    if (!this.o.equals("")) {
      paramCodedOutputByteBufferNano.writeString(16, this.o);
    }
    int i1 = this.p;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(17, i1);
    }
    localObject = this.q;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetAnchorInfoRsp
 * JD-Core Version:    0.7.0.1
 */