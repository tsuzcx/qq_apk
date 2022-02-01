package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GiftInfoRsp
  extends ExtendableMessageNano<GiftInfoRsp>
{
  private static volatile GiftInfoRsp[] R;
  public String A;
  public byte[] B;
  public int C;
  public int D;
  public int E;
  public int F;
  public GiftNewEffect[] G;
  public int H;
  public int I;
  public int J;
  public byte[] K;
  public int L;
  public int M;
  public TransMsg[] N;
  public int O;
  public int P;
  public String Q;
  public int a;
  public byte[] b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public byte[] i;
  public byte[] j;
  public byte[] k;
  public GiftEffect[] l;
  public SpecialNumber[] m;
  public byte[] n;
  public int o;
  public int p;
  public byte[] q;
  public byte[] r;
  public GiftNewEffect[] s;
  public byte[] t;
  public int u;
  public int v;
  public long w;
  public String x;
  public boolean y;
  public boolean z;
  
  public GiftInfoRsp()
  {
    b();
  }
  
  public static GiftInfoRsp[] a()
  {
    if (R == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (R == null) {
          R = new GiftInfoRsp[0];
        }
      }
    }
    return R;
  }
  
  public GiftInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 346: 
        this.Q = paramCodedInputByteBufferNano.readString();
        break;
      case 336: 
        this.P = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 328: 
        this.O = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 322: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 322);
        localObject = this.N;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new TransMsg[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.N, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new TransMsg();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new TransMsg();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.N = ((TransMsg[])localObject);
        break;
      case 312: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        if ((i1 == 1) || (i1 == 2) || (i1 == 3) || (i1 == 4)) {
          this.M = i1;
        }
        break;
      case 304: 
        this.L = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 298: 
        this.K = paramCodedInputByteBufferNano.readBytes();
        break;
      case 288: 
        this.J = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 280: 
        this.I = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 272: 
        this.H = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 266: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 266);
        localObject = this.G;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new GiftNewEffect[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.G, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new GiftNewEffect();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.G = ((GiftNewEffect[])localObject);
        break;
      case 256: 
        this.F = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 248: 
        this.E = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 240: 
        this.D = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 232: 
        this.C = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 226: 
        this.B = paramCodedInputByteBufferNano.readBytes();
        break;
      case 218: 
        this.A = paramCodedInputByteBufferNano.readString();
        break;
      case 208: 
        this.z = paramCodedInputByteBufferNano.readBool();
        break;
      case 200: 
        this.y = paramCodedInputByteBufferNano.readBool();
        break;
      case 194: 
        this.x = paramCodedInputByteBufferNano.readString();
        break;
      case 184: 
        this.w = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 176: 
        this.v = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 168: 
        this.u = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 162: 
        this.t = paramCodedInputByteBufferNano.readBytes();
        break;
      case 154: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
        localObject = this.s;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new GiftNewEffect[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.s, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new GiftNewEffect();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.s = ((GiftNewEffect[])localObject);
        break;
      case 146: 
        this.r = paramCodedInputByteBufferNano.readBytes();
        break;
      case 138: 
        this.q = paramCodedInputByteBufferNano.readBytes();
        break;
      case 128: 
        this.p = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 120: 
        this.o = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 114: 
        this.n = paramCodedInputByteBufferNano.readBytes();
        break;
      case 106: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
        localObject = this.m;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new SpecialNumber[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.m, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new SpecialNumber();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new SpecialNumber();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.m = ((SpecialNumber[])localObject);
        break;
      case 98: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        localObject = this.l;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new GiftEffect[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.l, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new GiftEffect();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new GiftEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.l = ((GiftEffect[])localObject);
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readBytes();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readBytes();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readBytes();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readBytes();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public GiftInfoRsp b()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = WireFormatNano.EMPTY_BYTES;
    this.j = WireFormatNano.EMPTY_BYTES;
    this.k = WireFormatNano.EMPTY_BYTES;
    this.l = GiftEffect.a();
    this.m = SpecialNumber.a();
    this.n = WireFormatNano.EMPTY_BYTES;
    this.o = 0;
    this.p = 0;
    this.q = WireFormatNano.EMPTY_BYTES;
    this.r = WireFormatNano.EMPTY_BYTES;
    this.s = GiftNewEffect.a();
    this.t = WireFormatNano.EMPTY_BYTES;
    this.u = 0;
    this.v = 0;
    this.w = 0L;
    this.x = "";
    this.y = false;
    this.z = false;
    this.A = "";
    this.B = WireFormatNano.EMPTY_BYTES;
    this.C = 0;
    this.D = 0;
    this.E = 0;
    this.F = 0;
    this.G = GiftNewEffect.a();
    this.H = 0;
    this.I = 0;
    this.J = 0;
    this.K = WireFormatNano.EMPTY_BYTES;
    this.L = 0;
    this.M = 1;
    this.N = TransMsg.a();
    this.O = 0;
    this.P = 0;
    this.Q = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeBytesSize(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e);
    int i3 = this.f;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(6, i3);
    }
    i3 = this.g;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = this.h;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(8, i3);
    }
    i2 = i1;
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(9, this.i);
    }
    i3 = i2;
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      i3 = i2 + CodedOutputByteBufferNano.computeBytesSize(10, this.j);
    }
    i1 = i3;
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(11, this.k);
    }
    Object localObject = this.l;
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
          localObject = this.l;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    localObject = this.m;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i1 = i2;
        i2 = 0;
        for (;;)
        {
          localObject = this.m;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
      }
    }
    i2 = i1;
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(14, this.n);
    }
    i3 = this.o;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(15, i3);
    }
    i3 = this.p;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(16, i3);
    }
    i3 = i2;
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      i3 = i2 + CodedOutputByteBufferNano.computeBytesSize(17, this.q);
    }
    i1 = i3;
    if (!Arrays.equals(this.r, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(18, this.r);
    }
    localObject = this.s;
    i3 = i1;
    if (localObject != null)
    {
      i3 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.s;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(19, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i3 = i1;
      }
    }
    i2 = i3;
    if (!Arrays.equals(this.t, WireFormatNano.EMPTY_BYTES)) {
      i2 = i3 + CodedOutputByteBufferNano.computeBytesSize(20, this.t);
    }
    i3 = this.u;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(21, i3);
    }
    i3 = this.v;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(22, i3);
    }
    long l1 = this.w;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(23, l1);
    }
    i2 = i1;
    if (!this.x.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(24, this.x);
    }
    boolean bool = this.y;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(25, bool);
    }
    bool = this.z;
    i2 = i1;
    if (bool) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(26, bool);
    }
    i1 = i2;
    if (!this.A.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(27, this.A);
    }
    i2 = i1;
    if (!Arrays.equals(this.B, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(28, this.B);
    }
    i3 = this.C;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(29, i3);
    }
    i3 = this.D;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(30, i3);
    }
    i1 = this.E;
    i3 = i2;
    if (i1 != 0) {
      i3 = i2 + CodedOutputByteBufferNano.computeUInt32Size(31, i1);
    }
    i2 = this.F;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(32, i2);
    }
    localObject = this.G;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.G;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(33, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i3 = this.H;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(34, i3);
    }
    i3 = this.I;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(35, i3);
    }
    i3 = this.J;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(36, i3);
    }
    i3 = i1;
    if (!Arrays.equals(this.K, WireFormatNano.EMPTY_BYTES)) {
      i3 = i1 + CodedOutputByteBufferNano.computeBytesSize(37, this.K);
    }
    i1 = this.L;
    i2 = i3;
    if (i1 != 0) {
      i2 = i3 + CodedOutputByteBufferNano.computeUInt32Size(38, i1);
    }
    i3 = this.M;
    i1 = i2;
    if (i3 != 1) {
      i1 = i2 + CodedOutputByteBufferNano.computeInt32Size(39, i3);
    }
    localObject = this.N;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.N;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(40, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i3 = this.O;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(41, i3);
    }
    i3 = this.P;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(42, i3);
    }
    i1 = i2;
    if (!this.Q.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(43, this.Q);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    int i1 = this.f;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i1);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.i);
    }
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.j);
    }
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.k);
    }
    Object localObject = this.l;
    int i2 = 0;
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
          paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    localObject = this.m;
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
          paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(14, this.n);
    }
    i1 = this.o;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(15, i1);
    }
    i1 = this.p;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, i1);
    }
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.q);
    }
    if (!Arrays.equals(this.r, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(18, this.r);
    }
    localObject = this.s;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.s;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(19, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.t, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.t);
    }
    i1 = this.u;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(21, i1);
    }
    i1 = this.v;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(22, i1);
    }
    long l1 = this.w;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(23, l1);
    }
    if (!this.x.equals("")) {
      paramCodedOutputByteBufferNano.writeString(24, this.x);
    }
    boolean bool = this.y;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(25, bool);
    }
    bool = this.z;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(26, bool);
    }
    if (!this.A.equals("")) {
      paramCodedOutputByteBufferNano.writeString(27, this.A);
    }
    if (!Arrays.equals(this.B, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(28, this.B);
    }
    i1 = this.C;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(29, i1);
    }
    i1 = this.D;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(30, i1);
    }
    i1 = this.E;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(31, i1);
    }
    i1 = this.F;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(32, i1);
    }
    localObject = this.G;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.G;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(33, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    i1 = this.H;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(34, i1);
    }
    i1 = this.I;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(35, i1);
    }
    i1 = this.J;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(36, i1);
    }
    if (!Arrays.equals(this.K, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(37, this.K);
    }
    i1 = this.L;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(38, i1);
    }
    i1 = this.M;
    if (i1 != 1) {
      paramCodedOutputByteBufferNano.writeInt32(39, i1);
    }
    localObject = this.N;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.N;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(40, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    i1 = this.O;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(41, i1);
    }
    i1 = this.P;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(42, i1);
    }
    if (!this.Q.equals("")) {
      paramCodedOutputByteBufferNano.writeString(43, this.Q);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.GiftInfoRsp
 * JD-Core Version:    0.7.0.1
 */