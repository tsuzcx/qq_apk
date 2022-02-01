package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class UserInfo
  extends MessageNano
{
  private static volatile UserInfo[] _emptyArray;
  public String businessUid;
  public long explicit;
  public String head;
  public long id;
  public int initialClientType;
  public String name;
  public long tinyId;
  
  public UserInfo()
  {
    clear();
  }
  
  public static UserInfo[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new UserInfo[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static UserInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new UserInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static UserInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (UserInfo)MessageNano.mergeFrom(new UserInfo(), paramArrayOfByte);
  }
  
  public UserInfo clear()
  {
    this.id = 0L;
    this.explicit = 0L;
    this.name = "";
    this.head = "";
    this.initialClientType = 0;
    this.businessUid = "";
    this.tinyId = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.id;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.explicit;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    int k = j;
    if (!this.name.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.name);
    }
    i = k;
    if (!this.head.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.head);
    }
    k = this.initialClientType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    i = j;
    if (!this.businessUid.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.businessUid);
    }
    l = this.tinyId;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    return j;
  }
  
  public UserInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 50)
                {
                  if (i != 56)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.tinyId = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.businessUid = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.initialClientType = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.head = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.name = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.explicit = paramCodedInputByteBufferNano.readInt64();
        }
      }
      else {
        this.id = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.id;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.explicit;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.name);
    }
    if (!this.head.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.head);
    }
    int i = this.initialClientType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    if (!this.businessUid.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.businessUid);
    }
    l = this.tinyId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */