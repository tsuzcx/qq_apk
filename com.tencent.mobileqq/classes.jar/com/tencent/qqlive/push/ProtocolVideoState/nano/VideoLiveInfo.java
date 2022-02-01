package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class VideoLiveInfo
  extends ExtendableMessageNano<VideoLiveInfo>
{
  private static volatile VideoLiveInfo[] m;
  public int a;
  public int b;
  public int c;
  public byte[] d;
  public int e;
  public int f;
  public VideoResInfo[] g;
  public long h;
  public int i;
  public byte[] j;
  public int k;
  public int l;
  
  public VideoLiveInfo()
  {
    b();
  }
  
  public static VideoLiveInfo[] a()
  {
    if (m == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (m == null) {
          m = new VideoLiveInfo[0];
        }
      }
    }
    return m;
  }
  
  public VideoLiveInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int n = paramCodedInputByteBufferNano.readTag();
      switch (n)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, n)) {
          return this;
        }
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readBytes();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 58: 
        int i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
        VideoResInfo[] arrayOfVideoResInfo = this.g;
        if (arrayOfVideoResInfo == null) {
          n = 0;
        } else {
          n = arrayOfVideoResInfo.length;
        }
        arrayOfVideoResInfo = new VideoResInfo[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.g, 0, arrayOfVideoResInfo, 0, n);
          i1 = n;
        }
        while (i1 < arrayOfVideoResInfo.length - 1)
        {
          arrayOfVideoResInfo[i1] = new VideoResInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfVideoResInfo[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        arrayOfVideoResInfo[i1] = new VideoResInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfVideoResInfo[i1]);
        this.g = arrayOfVideoResInfo;
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readBytes();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public VideoLiveInfo b()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = 0;
    this.f = 0;
    this.g = VideoResInfo.a();
    this.h = 0L;
    this.i = 0;
    this.j = WireFormatNano.EMPTY_BYTES;
    this.k = 0;
    this.l = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeBytesSize(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeUInt32Size(6, this.f);
    Object localObject = this.g;
    int i2 = n;
    if (localObject != null)
    {
      i2 = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.g;
          i2 = n;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
      }
    }
    int i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(8, this.h);
    i2 = this.i;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(9, i2);
    }
    i1 = n;
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      i1 = n + CodedOutputByteBufferNano.computeBytesSize(10, this.j);
    }
    i2 = this.k;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(11, i2);
    }
    i2 = this.l;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(12, i2);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeUInt32(6, this.f);
    Object localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.g;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    paramCodedOutputByteBufferNano.writeUInt64(8, this.h);
    int n = this.i;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, n);
    }
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.j);
    }
    n = this.k;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, n);
    }
    n = this.l;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, n);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoLiveInfo
 * JD-Core Version:    0.7.0.1
 */