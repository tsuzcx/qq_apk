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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new DesignatedStreamInfo[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.streams;
    int m = 0;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.streams;
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
        j = i;
      }
    }
    int k = this.switch_;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    localObject = this.levelList;
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
          localObject = this.levelList;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    k = this.sugLevel;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    localObject = this.gearList;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.gearList;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
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
      if (i == 0) {
        break;
      }
      int j;
      Object localObject;
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 26)
            {
              if (i != 32)
              {
                if (i != 42)
                {
                  if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
                  localObject = this.gearList;
                  if (localObject == null) {
                    i = 0;
                  } else {
                    i = localObject.length;
                  }
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
                  localObject[j] = new GearInfo();
                  paramCodedInputByteBufferNano.readMessage(localObject[j]);
                  this.gearList = ((GearInfo[])localObject);
                }
              }
              else {
                this.sugLevel = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else
            {
              int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
              i = paramCodedInputByteBufferNano.getPosition();
              j = 0;
              while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
              {
                paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              paramCodedInputByteBufferNano.rewindToPosition(i);
              localObject = this.levelList;
              if (localObject == null) {
                i = 0;
              } else {
                i = localObject.length;
              }
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
              this.levelList = ((int[])localObject);
              paramCodedInputByteBufferNano.popLimit(k);
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
            localObject = this.levelList;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
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
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            this.levelList = ((int[])localObject);
          }
        }
        else {
          this.switch_ = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        localObject = this.streams;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new Stream();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.streams = ((Stream[])localObject);
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.streams;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.streams;
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
    int i = this.switch_;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    localObject = this.levelList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.levelList;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(3, localObject[i]);
        i += 1;
      }
    }
    i = this.sugLevel;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    localObject = this.gearList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.gearList;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.DesignatedStreamInfo
 * JD-Core Version:    0.7.0.1
 */