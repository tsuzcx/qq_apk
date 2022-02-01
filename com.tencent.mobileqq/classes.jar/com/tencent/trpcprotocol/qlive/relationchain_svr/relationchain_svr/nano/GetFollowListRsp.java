package com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetFollowListRsp
  extends ExtendableMessageNano<GetFollowListRsp>
{
  public String a;
  public boolean b;
  public GetFollowListRsp.FollowListItem[] c;
  
  public GetFollowListRsp()
  {
    a();
  }
  
  public static GetFollowListRsp a(byte[] paramArrayOfByte)
  {
    return (GetFollowListRsp)MessageNano.mergeFrom(new GetFollowListRsp(), paramArrayOfByte);
  }
  
  public GetFollowListRsp a()
  {
    this.a = "";
    this.b = false;
    this.c = GetFollowListRsp.FollowListItem.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetFollowListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            GetFollowListRsp.FollowListItem[] arrayOfFollowListItem = this.c;
            if (arrayOfFollowListItem == null) {
              i = 0;
            } else {
              i = arrayOfFollowListItem.length;
            }
            arrayOfFollowListItem = new GetFollowListRsp.FollowListItem[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfFollowListItem, 0, i);
              j = i;
            }
            while (j < arrayOfFollowListItem.length - 1)
            {
              arrayOfFollowListItem[j] = new GetFollowListRsp.FollowListItem();
              paramCodedInputByteBufferNano.readMessage(arrayOfFollowListItem[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfFollowListItem[j] = new GetFollowListRsp.FollowListItem();
            paramCodedInputByteBufferNano.readMessage(arrayOfFollowListItem[j]);
            this.c = arrayOfFollowListItem;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
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
    int i = super.computeSerializedSize();
    int j = i;
    if (!this.a.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    boolean bool = this.b;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    Object localObject = this.c;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.c;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.GetFollowListRsp
 * JD-Core Version:    0.7.0.1
 */