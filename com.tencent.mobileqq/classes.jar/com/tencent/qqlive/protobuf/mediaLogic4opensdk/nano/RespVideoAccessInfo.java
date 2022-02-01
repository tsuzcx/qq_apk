package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class RespVideoAccessInfo
  extends ExtendableMessageNano<RespVideoAccessInfo>
{
  public int a;
  public int b;
  public byte[] c;
  public byte[] d;
  public int e;
  public int f;
  public int g;
  public byte[] h;
  public int i;
  public int j;
  public String[] k;
  public String[] l;
  public String[] m;
  public byte[] n;
  
  public RespVideoAccessInfo()
  {
    a();
  }
  
  public RespVideoAccessInfo a()
  {
    this.a = 0;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = 0;
    this.j = 0;
    this.k = WireFormatNano.EMPTY_STRING_ARRAY;
    this.l = WireFormatNano.EMPTY_STRING_ARRAY;
    this.m = WireFormatNano.EMPTY_STRING_ARRAY;
    this.n = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RespVideoAccessInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 162: 
        this.n = paramCodedInputByteBufferNano.readBytes();
        break;
      case 154: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
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
      case 146: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
        arrayOfString = this.l;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.l, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.l = arrayOfString;
        break;
      case 138: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 138);
        arrayOfString = this.k;
        if (arrayOfString == null) {
          i1 = 0;
        } else {
          i1 = arrayOfString.length;
        }
        arrayOfString = new String[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.k, 0, arrayOfString, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfString.length - 1)
        {
          arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfString[i2] = paramCodedInputByteBufferNano.readString();
        this.k = arrayOfString;
        break;
      case 128: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 120: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.h = paramCodedInputByteBufferNano.readBytes();
        break;
      case 96: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.d = paramCodedInputByteBufferNano.readBytes();
        break;
      case 66: 
        this.c = paramCodedInputByteBufferNano.readBytes();
        break;
      case 56: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 8: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        switch (i1)
        {
        default: 
          switch (i1)
          {
          }
          break;
        }
        this.a = i1;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a);
    int i3 = this.b;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = i1;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i3 = i1 + CodedOutputByteBufferNano.computeBytesSize(8, this.c);
    }
    i2 = i3;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      i2 = i3 + CodedOutputByteBufferNano.computeBytesSize(9, this.d);
    }
    i3 = this.e;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(10, i3);
    }
    i3 = this.f;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(11, i3);
    }
    i3 = this.g;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(12, i3);
    }
    i3 = i1;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      i3 = i1 + CodedOutputByteBufferNano.computeBytesSize(13, this.h);
    }
    i1 = this.i;
    i2 = i3;
    if (i1 != 0) {
      i2 = i3 + CodedOutputByteBufferNano.computeUInt32Size(15, i1);
    }
    i3 = this.j;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(16, i3);
    }
    Object localObject = this.k;
    int i7 = 0;
    i2 = i1;
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
          localObject = this.k;
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
        i2 = i1 + i3 + i4 * 2;
      }
    }
    localObject = this.l;
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
          localObject = this.l;
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
        i1 = i2 + i3 + i4 * 2;
      }
    }
    localObject = this.m;
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
          i4 = i5;
        }
        i2 = i1 + i3 + i4 * 2;
      }
    }
    i1 = i2;
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(20, this.n);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeInt32(1, this.a);
    int i1 = this.b;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.c);
    }
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.d);
    }
    i1 = this.e;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i1);
    }
    i1 = this.f;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i1);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, i1);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.h);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(15, i1);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, i1);
    }
    Object localObject = this.k;
    int i2 = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.k;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(17, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.l;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.l;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(18, (String)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.m;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.m;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(19, (String)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.n);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.RespVideoAccessInfo
 * JD-Core Version:    0.7.0.1
 */