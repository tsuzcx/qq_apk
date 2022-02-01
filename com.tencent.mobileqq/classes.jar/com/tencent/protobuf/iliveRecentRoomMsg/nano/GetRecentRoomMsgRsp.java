package com.tencent.protobuf.iliveRecentRoomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.protobuf.iliveWordSvr.nano.BroadCastMsg;

public final class GetRecentRoomMsgRsp
  extends ExtendableMessageNano<GetRecentRoomMsgRsp>
{
  public int a;
  public String b;
  public BroadCastMsg[] c;
  
  public GetRecentRoomMsgRsp()
  {
    a();
  }
  
  public GetRecentRoomMsgRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = BroadCastMsg.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRecentRoomMsgRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            BroadCastMsg[] arrayOfBroadCastMsg = this.c;
            if (arrayOfBroadCastMsg == null) {
              i = 0;
            } else {
              i = arrayOfBroadCastMsg.length;
            }
            arrayOfBroadCastMsg = new BroadCastMsg[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfBroadCastMsg, 0, i);
              j = i;
            }
            while (j < arrayOfBroadCastMsg.length - 1)
            {
              arrayOfBroadCastMsg[j] = new BroadCastMsg();
              paramCodedInputByteBufferNano.readMessage(arrayOfBroadCastMsg[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfBroadCastMsg[j] = new BroadCastMsg();
            paramCodedInputByteBufferNano.readMessage(arrayOfBroadCastMsg[j]);
            this.c = arrayOfBroadCastMsg;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = this.a;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Object localObject = this.c;
    k = i;
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
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRecentRoomMsg.nano.GetRecentRoomMsgRsp
 * JD-Core Version:    0.7.0.1
 */