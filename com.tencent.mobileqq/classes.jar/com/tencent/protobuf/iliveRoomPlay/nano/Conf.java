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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new Conf[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.defaultRoomInfos;
    int m = 0;
    int i = j;
    int k;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.defaultRoomInfos;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = this.multiLiveUids;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        j = m;
        for (;;)
        {
          localObject = this.multiLiveUids;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    return j;
  }
  
  public Conf mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      Object localObject;
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 18)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
            i = paramCodedInputByteBufferNano.getPosition();
            j = 0;
            while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
            {
              paramCodedInputByteBufferNano.readUInt64();
              j += 1;
            }
            paramCodedInputByteBufferNano.rewindToPosition(i);
            localObject = this.multiLiveUids;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
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
            this.multiLiveUids = ((long[])localObject);
            paramCodedInputByteBufferNano.popLimit(k);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
          localObject = this.multiLiveUids;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
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
          localObject[j] = paramCodedInputByteBufferNano.readUInt64();
          this.multiLiveUids = ((long[])localObject);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        localObject = this.defaultRoomInfos;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new DefaultRoomInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.defaultRoomInfos = ((DefaultRoomInfo[])localObject);
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.defaultRoomInfos;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.defaultRoomInfos;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.multiLiveUids;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.multiLiveUids;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(2, localObject[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.Conf
 * JD-Core Version:    0.7.0.1
 */