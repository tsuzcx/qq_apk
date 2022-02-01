package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LotteryInfo
  extends ExtendableMessageNano<LotteryInfo>
{
  private static volatile LotteryInfo[] q;
  public String a;
  public int b;
  public String c;
  public long d;
  public long e;
  public long f;
  public int g;
  public LotteryCond[] h;
  public LotteryInfo.AnchorInfo i;
  public LotteryInfo.PlatInfo j;
  public long k;
  public long l;
  public String m;
  public HitUser[] n;
  public long o;
  public String p;
  
  public LotteryInfo()
  {
    b();
  }
  
  public static LotteryInfo[] a()
  {
    if (q == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (q == null) {
          q = new LotteryInfo[0];
        }
      }
    }
    return q;
  }
  
  public LotteryInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      int i2;
      Object localObject;
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 130: 
        this.p = paramCodedInputByteBufferNano.readString();
        break;
      case 120: 
        this.o = paramCodedInputByteBufferNano.readInt64();
        break;
      case 114: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 114);
        localObject = this.n;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new HitUser[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.n, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new HitUser();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new HitUser();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.n = ((HitUser[])localObject);
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 82: 
        if (this.j == null) {
          this.j = new LotteryInfo.PlatInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 74: 
        if (this.i == null) {
          this.i = new LotteryInfo.AnchorInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
        localObject = this.h;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new LotteryCond[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.h, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new LotteryCond();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new LotteryCond();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.h = ((LotteryCond[])localObject);
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readInt64();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        if ((i1 == 0) || (i1 == 1) || (i1 == 2)) {
          this.b = i1;
        }
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public LotteryInfo b()
  {
    this.a = "";
    this.b = 0;
    this.c = "";
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = LotteryCond.a();
    this.i = null;
    this.j = null;
    this.k = 0L;
    this.l = 0L;
    this.m = "";
    this.n = HitUser.a();
    this.o = 0L;
    this.p = "";
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
    int i3 = this.b;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(2, i3);
    }
    i1 = i2;
    if (!this.c.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    long l1 = this.d;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt64Size(4, l1);
    }
    l1 = this.e;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeInt64Size(5, l1);
    }
    l1 = this.f;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt64Size(6, l1);
    }
    i3 = this.g;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeInt32Size(7, i3);
    }
    Object localObject = this.h;
    int i4 = 0;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.h;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    localObject = this.i;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.j;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    l1 = this.k;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(11, l1);
    }
    l1 = this.l;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    i1 = i2;
    if (!this.m.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(13, this.m);
    }
    localObject = this.n;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.n;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(14, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    l1 = this.o;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeInt64Size(15, l1);
    }
    i2 = i1;
    if (!this.p.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(16, this.p);
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    int i1 = this.b;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i1);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    long l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(4, l1);
    }
    l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l1);
    }
    l1 = this.f;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(6, l1);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, i1);
    }
    Object localObject = this.h;
    int i2 = 0;
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
          paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    l1 = this.k;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, l1);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.m);
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
          paramCodedOutputByteBufferNano.writeMessage(14, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    l1 = this.o;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(15, l1);
    }
    if (!this.p.equals("")) {
      paramCodedOutputByteBufferNano.writeString(16, this.p);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.LotteryInfo
 * JD-Core Version:    0.7.0.1
 */