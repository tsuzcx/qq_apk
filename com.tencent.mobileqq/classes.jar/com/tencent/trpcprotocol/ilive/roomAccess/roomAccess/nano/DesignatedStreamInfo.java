package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DesignatedStreamInfo
  extends MessageNano
{
  private static volatile DesignatedStreamInfo[] _emptyArray;
  public GearInfo[] gearList;
  public int[] levelList;
  public Stream[] streams;
  public int sugLevel;
  public int switch_;
  
  public DesignatedStreamInfo()
  {
    clear();
  }
  
  public static DesignatedStreamInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new DesignatedStreamInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static DesignatedStreamInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new DesignatedStreamInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static DesignatedStreamInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (DesignatedStreamInfo)MessageNano.mergeFrom(new DesignatedStreamInfo(), paramArrayOfByte);
  }
  
  public DesignatedStreamInfo clear()
  {
    this.streams = Stream.emptyArray();
    this.switch_ = 0;
    this.levelList = WireFormatNano.EMPTY_INT_ARRAY;
    this.sugLevel = 0;
    this.gearList = GearInfo.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int i = super.computeSerializedSize();
    int j = i;
    Object localObject;
    if (this.streams != null)
    {
      j = i;
      if (this.streams.length > 0)
      {
        j = 0;
        while (j < this.streams.length)
        {
          localObject = this.streams[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.switch_ != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(2, this.switch_);
    }
    j = i;
    if (this.levelList != null)
    {
      j = i;
      if (this.levelList.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.levelList.length)
        {
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(this.levelList[j]);
          j += 1;
        }
        j = i + k + this.levelList.length * 1;
      }
    }
    i = j;
    if (this.sugLevel != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(4, this.sugLevel);
    }
    int k = i;
    if (this.gearList != null)
    {
      k = i;
      if (this.gearList.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.gearList.length) {
            break;
          }
          localObject = this.gearList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public DesignatedStreamInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (this.streams == null) {}
        for (i = 0;; i = this.streams.length)
        {
          localObject = new Stream[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.streams, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new Stream();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new Stream();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.streams = ((Stream[])localObject);
        break;
      case 16: 
        this.switch_ = paramCodedInputByteBufferNano.readInt32();
        break;
      case 24: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
        if (this.levelList == null) {}
        for (i = 0;; i = this.levelList.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.levelList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = paramCodedInputByteBufferNano.readInt32();
        this.levelList = ((int[])localObject);
        break;
      case 26: 
        int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        i = paramCodedInputByteBufferNano.getPosition();
        j = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readInt32();
          j += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(i);
        if (this.levelList == null) {}
        for (i = 0;; i = this.levelList.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.levelList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            j += 1;
          }
        }
        this.levelList = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 32: 
        this.sugLevel = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
      if (this.gearList == null) {}
      for (i = 0;; i = this.gearList.length)
      {
        localObject = new GearInfo[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.gearList, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new GearInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      localObject[j] = new GearInfo();
      paramCodedInputByteBufferNano.readMessage(localObject[j]);
      this.gearList = ((GearInfo[])localObject);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.streams != null) && (this.streams.length > 0))
    {
      i = 0;
      while (i < this.streams.length)
      {
        localObject = this.streams[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (this.switch_ != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, this.switch_);
    }
    if ((this.levelList != null) && (this.levelList.length > 0))
    {
      i = 0;
      while (i < this.levelList.length)
      {
        paramCodedOutputByteBufferNano.writeInt32(3, this.levelList[i]);
        i += 1;
      }
    }
    if (this.sugLevel != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, this.sugLevel);
    }
    if ((this.gearList != null) && (this.gearList.length > 0))
    {
      i = j;
      while (i < this.gearList.length)
      {
        localObject = this.gearList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.DesignatedStreamInfo
 * JD-Core Version:    0.7.0.1
 */