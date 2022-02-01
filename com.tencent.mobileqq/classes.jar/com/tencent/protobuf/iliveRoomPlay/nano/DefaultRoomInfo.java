package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DefaultRoomInfo
  extends MessageNano
{
  private static volatile DefaultRoomInfo[] _emptyArray;
  public int appid;
  public int logoNum;
  public String[] names;
  
  public DefaultRoomInfo()
  {
    clear();
  }
  
  public static DefaultRoomInfo[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new DefaultRoomInfo[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static DefaultRoomInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new DefaultRoomInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static DefaultRoomInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (DefaultRoomInfo)MessageNano.mergeFrom(new DefaultRoomInfo(), paramArrayOfByte);
  }
  
  public DefaultRoomInfo clear()
  {
    this.appid = 0;
    this.names = WireFormatNano.EMPTY_STRING_ARRAY;
    this.logoNum = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.appid;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    Object localObject = this.names;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0;; m = n)
        {
          localObject = this.names;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    k = this.logoNum;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    return i;
  }
  
  public DefaultRoomInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.logoNum = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          String[] arrayOfString = this.names;
          if (arrayOfString == null) {
            i = 0;
          } else {
            i = arrayOfString.length;
          }
          arrayOfString = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.names, 0, arrayOfString, 0, i);
            j = i;
          }
          while (j < arrayOfString.length - 1)
          {
            arrayOfString[j] = paramCodedInputByteBufferNano.readString();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfString[j] = paramCodedInputByteBufferNano.readString();
          this.names = arrayOfString;
        }
      }
      else {
        this.appid = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.appid;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    Object localObject = this.names;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.names;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(2, (String)localObject);
        }
        i += 1;
      }
    }
    i = this.logoNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.DefaultRoomInfo
 * JD-Core Version:    0.7.0.1
 */