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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new EnterRoomRequest[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.roomId;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.machineCode.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.machineCode);
    }
    i = j;
    if (!Arrays.equals(this.fromSource, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.fromSource);
    }
    Object localObject = this.format;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        int k = 0;
        int n;
        for (int m = 0;; m = n)
        {
          localObject = this.format;
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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.programId = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.extData = paramCodedInputByteBufferNano.readString();
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              String[] arrayOfString = this.format;
              if (arrayOfString == null) {
                i = 0;
              } else {
                i = arrayOfString.length;
              }
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
              arrayOfString[j] = paramCodedInputByteBufferNano.readString();
              this.format = arrayOfString;
            }
          }
          else {
            this.fromSource = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.machineCode = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.machineCode.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.machineCode);
    }
    if (!Arrays.equals(this.fromSource, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.fromSource);
    }
    Object localObject = this.format;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.format;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(4, (String)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomRequest
 * JD-Core Version:    0.7.0.1
 */