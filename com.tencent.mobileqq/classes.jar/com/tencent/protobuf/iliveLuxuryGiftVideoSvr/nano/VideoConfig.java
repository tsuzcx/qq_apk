package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class VideoConfig
  extends MessageNano
{
  private static volatile VideoConfig[] _emptyArray;
  public int allUser;
  public int category;
  public String desc;
  public int[] grey;
  public int id;
  public String lgeId;
  public VideoUrl[] sourceUrls;
  public long[] uids;
  public int vibrate;
  public int vibrateRange;
  
  public VideoConfig()
  {
    clear();
  }
  
  public static VideoConfig[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new VideoConfig[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static VideoConfig parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new VideoConfig().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static VideoConfig parseFrom(byte[] paramArrayOfByte)
  {
    return (VideoConfig)MessageNano.mergeFrom(new VideoConfig(), paramArrayOfByte);
  }
  
  public VideoConfig clear()
  {
    this.id = 0;
    this.lgeId = "";
    this.desc = "";
    this.sourceUrls = VideoUrl.emptyArray();
    this.allUser = 0;
    this.uids = WireFormatNano.EMPTY_LONG_ARRAY;
    this.grey = WireFormatNano.EMPTY_INT_ARRAY;
    this.vibrate = 0;
    this.vibrateRange = 0;
    this.category = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.id;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!this.lgeId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.lgeId);
    }
    i = j;
    if (!this.desc.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.desc);
    }
    Object localObject = this.sourceUrls;
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.sourceUrls;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    k = this.allUser;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    localObject = this.uids;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          localObject = this.uids;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    localObject = this.grey;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        i = m;
        for (;;)
        {
          localObject = this.grey;
          if (i >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt32SizeNoTag(localObject[i]);
          i += 1;
        }
        i = j + k + localObject.length * 1;
      }
    }
    k = this.vibrate;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    k = this.vibrateRange;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(9, k);
    }
    k = this.category;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    return j;
  }
  
  public VideoConfig mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int k;
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 80: 
        this.category = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.vibrateRange = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.vibrate = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        i = paramCodedInputByteBufferNano.getPosition();
        j = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readUInt32();
          j += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(i);
        localObject = this.grey;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.grey, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt32();
          j += 1;
        }
        this.grey = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 56: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 56);
        localObject = this.grey;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.grey, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt32();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = paramCodedInputByteBufferNano.readUInt32();
        this.grey = ((int[])localObject);
        break;
      case 50: 
        k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        i = paramCodedInputByteBufferNano.getPosition();
        j = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readUInt64();
          j += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(i);
        localObject = this.uids;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new long[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.uids, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt64();
          j += 1;
        }
        this.uids = ((long[])localObject);
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 48: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
        localObject = this.uids;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new long[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.uids, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt64();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = paramCodedInputByteBufferNano.readUInt64();
        this.uids = ((long[])localObject);
        break;
      case 40: 
        this.allUser = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        localObject = this.sourceUrls;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new VideoUrl[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.sourceUrls, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new VideoUrl();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = new VideoUrl();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.sourceUrls = ((VideoUrl[])localObject);
        break;
      case 26: 
        this.desc = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.lgeId = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.id = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.id;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.lgeId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.lgeId);
    }
    if (!this.desc.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.desc);
    }
    Object localObject = this.sourceUrls;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.sourceUrls;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    i = this.allUser;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    localObject = this.uids;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.uids;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(6, localObject[i]);
        i += 1;
      }
    }
    localObject = this.grey;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.grey;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt32(7, localObject[i]);
        i += 1;
      }
    }
    i = this.vibrate;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    i = this.vibrateRange;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i);
    }
    i = this.category;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoConfig
 * JD-Core Version:    0.7.0.1
 */