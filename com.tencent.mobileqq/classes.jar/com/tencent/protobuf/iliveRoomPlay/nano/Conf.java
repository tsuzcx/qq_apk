package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Conf
  extends MessageNano
{
  private static volatile Conf[] _emptyArray;
  public DefaultRoomInfo[] defaultRoomInfos;
  public long[] multiLiveUids;
  
  public Conf()
  {
    clear();
  }
  
  public static Conf[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new Conf[0];
      }
      return _emptyArray;
    }
  }
  
  public static Conf parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new Conf().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static Conf parseFrom(byte[] paramArrayOfByte)
  {
    return (Conf)MessageNano.mergeFrom(new Conf(), paramArrayOfByte);
  }
  
  public Conf clear()
  {
    this.defaultRoomInfos = DefaultRoomInfo.emptyArray();
    this.multiLiveUids = WireFormatNano.EMPTY_LONG_ARRAY;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize();
    int i = j;
    int k;
    if (this.defaultRoomInfos != null)
    {
      i = j;
      if (this.defaultRoomInfos.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.defaultRoomInfos.length)
        {
          DefaultRoomInfo localDefaultRoomInfo = this.defaultRoomInfos[j];
          k = i;
          if (localDefaultRoomInfo != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, localDefaultRoomInfo);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.multiLiveUids != null)
    {
      j = i;
      if (this.multiLiveUids.length > 0)
      {
        k = 0;
        j = m;
        while (j < this.multiLiveUids.length)
        {
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(this.multiLiveUids[j]);
          j += 1;
        }
        j = i + k + this.multiLiveUids.length * 1;
      }
    }
    return j;
  }
  
  public Conf mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      Object localObject;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        if (this.defaultRoomInfos == null) {}
        for (i = 0;; i = this.defaultRoomInfos.length)
        {
          localObject = new DefaultRoomInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.defaultRoomInfos, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new DefaultRoomInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new DefaultRoomInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.defaultRoomInfos = ((DefaultRoomInfo[])localObject);
        break;
      case 16: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
        if (this.multiLiveUids == null) {}
        for (i = 0;; i = this.multiLiveUids.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.multiLiveUids, 0, localObject, 0, i);
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
        this.multiLiveUids = ((long[])localObject);
        break;
      }
      int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
      i = paramCodedInputByteBufferNano.getPosition();
      int j = 0;
      while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
      {
        paramCodedInputByteBufferNano.readUInt64();
        j += 1;
      }
      paramCodedInputByteBufferNano.rewindToPosition(i);
      if (this.multiLiveUids == null) {}
      for (i = 0;; i = this.multiLiveUids.length)
      {
        localObject = new long[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.multiLiveUids, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt64();
          j += 1;
        }
      }
      this.multiLiveUids = ((long[])localObject);
      paramCodedInputByteBufferNano.popLimit(k);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    int i;
    if ((this.defaultRoomInfos != null) && (this.defaultRoomInfos.length > 0))
    {
      i = 0;
      while (i < this.defaultRoomInfos.length)
      {
        DefaultRoomInfo localDefaultRoomInfo = this.defaultRoomInfos[i];
        if (localDefaultRoomInfo != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localDefaultRoomInfo);
        }
        i += 1;
      }
    }
    if ((this.multiLiveUids != null) && (this.multiLiveUids.length > 0))
    {
      i = j;
      while (i < this.multiLiveUids.length)
      {
        paramCodedOutputByteBufferNano.writeUInt64(2, this.multiLiveUids[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.Conf
 * JD-Core Version:    0.7.0.1
 */