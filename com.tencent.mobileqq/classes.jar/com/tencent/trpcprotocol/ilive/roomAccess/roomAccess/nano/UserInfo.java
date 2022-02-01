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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.uid;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int k = this.sex;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    i = j;
    if (!this.nick.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.nick);
    }
    l = this.explicitId;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    k = j;
    if (!this.headUrl.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(6, this.headUrl);
    }
    l = this.imsdkTinyid;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    k = this.initialClientType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    i = j;
    if (!this.businessUid.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.businessUid);
    }
    return i;
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
            if (i != 40)
            {
              if (i != 50)
              {
                if (i != 56)
                {
                  if (i != 64)
                  {
                    if (i != 74)
                    {
                      if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
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
                  this.imsdkTinyid = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.headUrl = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.explicitId = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.nick = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.sex = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.uid = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.uid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int i = this.sex;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!this.nick.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.nick);
    }
    l = this.explicitId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    if (!this.headUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.headUrl);
    }
    l = this.imsdkTinyid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    i = this.initialClientType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    if (!this.businessUid.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.businessUid);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */