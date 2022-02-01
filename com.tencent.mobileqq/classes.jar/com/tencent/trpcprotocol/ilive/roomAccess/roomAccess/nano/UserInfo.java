package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

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
  public long explicitId;
  public String headUrl;
  public long imsdkTinyid;
  public int initialClientType;
  public String nick;
  public int sex;
  public long uid;
  
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
    this.uid = 0L;
    this.sex = 0;
    this.nick = "";
    this.explicitId = 0L;
    this.headUrl = "";
    this.imsdkTinyid = 0L;
    this.initialClientType = 0;
    this.businessUid = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.uid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
    }
    j = i;
    if (this.sex != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.sex);
    }
    i = j;
    if (!this.nick.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.nick);
    }
    j = i;
    if (this.explicitId != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(5, this.explicitId);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.headUrl);
    }
    j = i;
    if (this.imsdkTinyid != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, this.imsdkTinyid);
    }
    i = j;
    if (this.initialClientType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(8, this.initialClientType);
    }
    j = i;
    if (!this.businessUid.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(9, this.businessUid);
    }
    return j;
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
        this.uid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.sex = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.nick = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.explicitId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 50: 
        this.headUrl = paramCodedInputByteBufferNano.readString();
        break;
      case 56: 
        this.imsdkTinyid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 64: 
        this.initialClientType = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.businessUid = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.uid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.uid);
    }
    if (this.sex != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.sex);
    }
    if (!this.nick.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.nick);
    }
    if (this.explicitId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.explicitId);
    }
    if (!this.headUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.headUrl);
    }
    if (this.imsdkTinyid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.imsdkTinyid);
    }
    if (this.initialClientType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.initialClientType);
    }
    if (!this.businessUid.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.businessUid);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */