package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class QQArkMessage
  extends ExtendableMessageNano<QQArkMessage>
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public QQArkTemplateItem[] g;
  public String h;
  public int i;
  public int j;
  public String[] k;
  
  public QQArkMessage()
  {
    a();
  }
  
  public QQArkMessage a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = QQArkTemplateItem.a();
    this.h = "";
    this.i = 0;
    this.j = 0;
    this.k = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public QQArkMessage a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 90: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        localObject = this.k;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new String[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.k, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readString();
        this.k = ((String[])localObject);
        break;
      case 80: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 0) || (m == 1) || (m == 2)) {
          this.j = m;
        }
        break;
      case 72: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 0) || (m == 1)) {
          this.i = m;
        }
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readString();
        break;
      case 58: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
        localObject = this.g;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new QQArkTemplateItem[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.g, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new QQArkTemplateItem();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new QQArkTemplateItem();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.g = ((QQArkTemplateItem[])localObject);
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    int m = n;
    if (!this.a.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    n = m;
    if (!this.b.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    m = n;
    if (!this.c.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    n = m;
    if (!this.d.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    int i1 = n;
    if (!this.e.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    m = i1;
    if (!this.f.equals("")) {
      m = i1 + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    Object localObject = this.g;
    int i2 = 0;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.g;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    m = n;
    if (!this.h.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    i1 = this.i;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(9, i1);
    }
    i1 = this.j;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(10, i1);
    }
    localObject = this.k;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        i1 = 0;
        int i3 = 0;
        n = i2;
        for (i2 = i3;; i2 = i3)
        {
          localObject = this.k;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          int i4 = i1;
          i3 = i2;
          if (localObject != null)
          {
            i3 = i2 + 1;
            i4 = i1 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          n += 1;
          i1 = i4;
        }
        n = m + i1 + i2 * 1;
      }
    }
    return n;
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
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    Object localObject = this.g;
    int n = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.g;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.h);
    }
    int m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(10, m);
    }
    localObject = this.k;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = n;
      for (;;)
      {
        localObject = this.k;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(11, (String)localObject);
        }
        m += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.QQArkMessage
 * JD-Core Version:    0.7.0.1
 */