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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new UserInfo[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.id != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.id);
    }
    j = i;
    if (this.explicit != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, this.explicit);
    }
    i = j;
    if (!this.name.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.name);
    }
    j = i;
    if (!this.head.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.head);
    }
    i = j;
    if (this.initialClientType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.initialClientType);
    }
    j = i;
    if (!this.businessUid.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.businessUid);
    }
    i = j;
    if (this.tinyId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(7, this.tinyId);
    }
    return i;
  }
  
  public UserInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.id = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.explicit = paramCodedInputByteBufferNano.readInt64();
        break;
      case 26: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.head = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.initialClientType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.businessUid = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.tinyId = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.id != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.id);
    }
    if (this.explicit != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, this.explicit);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.name);
    }
    if (!this.head.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.head);
    }
    if (this.initialClientType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.initialClientType);
    }
    if (!this.businessUid.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.businessUid);
    }
    if (this.tinyId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.tinyId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */