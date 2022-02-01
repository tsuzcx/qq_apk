package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class EnterRoomRequest
  extends MessageNano
{
  private static volatile EnterRoomRequest[] _emptyArray;
  public String extData;
  public String[] format;
  public byte[] fromSource;
  public String machineCode;
  public String programId;
  public long roomId;
  
  public EnterRoomRequest()
  {
    clear();
  }
  
  public static EnterRoomRequest[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new EnterRoomRequest[0];
      }
      return _emptyArray;
    }
  }
  
  public static EnterRoomRequest parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new EnterRoomRequest().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static EnterRoomRequest parseFrom(byte[] paramArrayOfByte)
  {
    return (EnterRoomRequest)MessageNano.mergeFrom(new EnterRoomRequest(), paramArrayOfByte);
  }
  
  public EnterRoomRequest clear()
  {
    this.roomId = 0L;
    this.machineCode = "";
    this.fromSource = WireFormatNano.EMPTY_BYTES;
    this.format = WireFormatNano.EMPTY_STRING_ARRAY;
    this.extData = "";
    this.programId = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int n = 0;
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomId);
    }
    j = i;
    if (!this.machineCode.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.machineCode);
    }
    i = j;
    if (!Arrays.equals(this.fromSource, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.fromSource);
    }
    j = i;
    if (this.format != null)
    {
      j = i;
      if (this.format.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < this.format.length)
        {
          String str = this.format[j];
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
    if (!this.extData.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.extData);
    }
    j = i;
    if (!this.programId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.programId);
    }
    return j;
  }
  
  public EnterRoomRequest mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.machineCode = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.fromSource = paramCodedInputByteBufferNano.readBytes();
        break;
      case 34: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        if (this.format == null) {}
        String[] arrayOfString;
        for (i = 0;; i = this.format.length)
        {
          arrayOfString = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.format, 0, arrayOfString, 0, i);
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
        this.format = arrayOfString;
        break;
      case 42: 
        this.extData = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.programId = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomId);
    }
    if (!this.machineCode.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.machineCode);
    }
    if (!Arrays.equals(this.fromSource, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.fromSource);
    }
    if ((this.format != null) && (this.format.length > 0))
    {
      int i = 0;
      while (i < this.format.length)
      {
        String str = this.format[i];
        if (str != null) {
          paramCodedOutputByteBufferNano.writeString(4, str);
        }
        i += 1;
      }
    }
    if (!this.extData.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.extData);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomRequest
 * JD-Core Version:    0.7.0.1
 */