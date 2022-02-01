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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new DefaultRoomInfo[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int n = 0;
    int j = super.computeSerializedSize();
    int i = j;
    if (this.appid != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.appid);
    }
    j = i;
    if (this.names != null)
    {
      j = i;
      if (this.names.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < this.names.length)
        {
          String str = this.names[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag(str);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.logoNum != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.logoNum);
    }
    return i;
  }
  
  public DefaultRoomInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.appid = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        if (this.names == null) {}
        String[] arrayOfString;
        for (i = 0;; i = this.names.length)
        {
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
        }
        arrayOfString[j] = paramCodedInputByteBufferNano.readString();
        this.names = arrayOfString;
        break;
      }
      this.logoNum = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.appid != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.appid);
    }
    if ((this.names != null) && (this.names.length > 0))
    {
      int i = 0;
      while (i < this.names.length)
      {
        String str = this.names[i];
        if (str != null) {
          paramCodedOutputByteBufferNano.writeString(2, str);
        }
        i += 1;
      }
    }
    if (this.logoNum != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.logoNum);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.DefaultRoomInfo
 * JD-Core Version:    0.7.0.1
 */