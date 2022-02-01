package com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class UserInfo
  extends ExtendableMessageNano<UserInfo>
{
  public String a;
  public String b;
  public long c;
  public int d;
  public String e;
  
  public UserInfo()
  {
    a();
  }
  
  public UserInfo a()
  {
    this.a = "";
    this.b = "";
    this.c = 0L;
    this.d = 0;
    this.e = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public UserInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 18)
      {
        if (i != 74)
        {
          if (i != 96)
          {
            if (i != 648)
            {
              if (i != 658)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.a);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(9, this.b);
    }
    long l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(12, l);
    }
    int k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(81, k);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(82, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.b);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l);
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(81, i);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(82, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */