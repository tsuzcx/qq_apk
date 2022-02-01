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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new VideoConfig[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize();
    int i = j;
    if (this.id != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.id);
    }
    j = i;
    if (!this.lgeId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.lgeId);
    }
    i = j;
    if (!this.desc.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.desc);
    }
    j = i;
    int k;
    if (this.sourceUrls != null)
    {
      j = i;
      if (this.sourceUrls.length > 0)
      {
        j = 0;
        while (j < this.sourceUrls.length)
        {
          VideoUrl localVideoUrl = this.sourceUrls[j];
          k = i;
          if (localVideoUrl != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(4, localVideoUrl);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.allUser != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.allUser);
    }
    j = i;
    if (this.uids != null)
    {
      j = i;
      if (this.uids.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.uids.length)
        {
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(this.uids[j]);
          j += 1;
        }
        j = i + k + this.uids.length * 1;
      }
    }
    i = j;
    if (this.grey != null)
    {
      i = j;
      if (this.grey.length > 0)
      {
        k = 0;
        i = m;
        while (i < this.grey.length)
        {
          k += CodedOutputByteBufferNano.computeUInt32SizeNoTag(this.grey[i]);
          i += 1;
        }
        i = j + k + this.grey.length * 1;
      }
    }
    j = i;
    if (this.vibrate != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, this.vibrate);
    }
    i = j;
    if (this.vibrateRange != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(9, this.vibrateRange);
    }
    j = i;
    if (this.category != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, this.category);
    }
    return j;
  }
  
  public VideoConfig mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int j;
      Object localObject;
      int k;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.id = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.lgeId = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.desc = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        if (this.sourceUrls == null) {}
        for (i = 0;; i = this.sourceUrls.length)
        {
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
        }
        localObject[j] = new VideoUrl();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.sourceUrls = ((VideoUrl[])localObject);
        break;
      case 40: 
        this.allUser = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
        if (this.uids == null) {}
        for (i = 0;; i = this.uids.length)
        {
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
        }
        localObject[j] = paramCodedInputByteBufferNano.readUInt64();
        this.uids = ((long[])localObject);
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
        if (this.uids == null) {}
        for (i = 0;; i = this.uids.length)
        {
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
        }
        this.uids = ((long[])localObject);
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 56: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 56);
        if (this.grey == null) {}
        for (i = 0;; i = this.grey.length)
        {
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
        }
        localObject[j] = paramCodedInputByteBufferNano.readUInt32();
        this.grey = ((int[])localObject);
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
        if (this.grey == null) {}
        for (i = 0;; i = this.grey.length)
        {
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
        }
        this.grey = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 64: 
        this.vibrate = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.vibrateRange = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.category = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    if (this.id != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.id);
    }
    if (!this.lgeId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.lgeId);
    }
    if (!this.desc.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.desc);
    }
    int i;
    if ((this.sourceUrls != null) && (this.sourceUrls.length > 0))
    {
      i = 0;
      while (i < this.sourceUrls.length)
      {
        VideoUrl localVideoUrl = this.sourceUrls[i];
        if (localVideoUrl != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, localVideoUrl);
        }
        i += 1;
      }
    }
    if (this.allUser != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.allUser);
    }
    if ((this.uids != null) && (this.uids.length > 0))
    {
      i = 0;
      while (i < this.uids.length)
      {
        paramCodedOutputByteBufferNano.writeUInt64(6, this.uids[i]);
        i += 1;
      }
    }
    if ((this.grey != null) && (this.grey.length > 0))
    {
      i = j;
      while (i < this.grey.length)
      {
        paramCodedOutputByteBufferNano.writeUInt32(7, this.grey[i]);
        i += 1;
      }
    }
    if (this.vibrate != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.vibrate);
    }
    if (this.vibrateRange != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, this.vibrateRange);
    }
    if (this.category != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.category);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoConfig
 * JD-Core Version:    0.7.0.1
 */