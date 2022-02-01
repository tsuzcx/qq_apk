package com.tencent.qqlive.pbexit_heart_list_room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetUserListPagedRsp
  extends ExtendableMessageNano<GetUserListPagedRsp>
{
  public UserList a;
  public boolean b;
  
  public GetUserListPagedRsp()
  {
    a();
  }
  
  public GetUserListPagedRsp a()
  {
    this.a = null;
    this.b = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetUserListPagedRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new UserList();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    UserList localUserList = this.a;
    int i = j;
    if (localUserList != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localUserList);
    }
    boolean bool = this.b;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    UserList localUserList = this.a;
    if (localUserList != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localUserList);
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.pbexit_heart_list_room.nano.GetUserListPagedRsp
 * JD-Core Version:    0.7.0.1
 */