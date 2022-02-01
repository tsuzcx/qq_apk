package com.tencent.protobuf.iliveRecentRoomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.protobuf.iliveWordSvr.nano.HippoMsgChat;

public final class RecentMsg
  extends ExtendableMessageNano<RecentMsg>
{
  public HippoMsgChat[] a;
  
  public RecentMsg()
  {
    a();
  }
  
  public RecentMsg a()
  {
    this.a = HippoMsgChat.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RecentMsg a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        HippoMsgChat[] arrayOfHippoMsgChat = this.a;
        if (arrayOfHippoMsgChat == null) {
          i = 0;
        } else {
          i = arrayOfHippoMsgChat.length;
        }
        arrayOfHippoMsgChat = new HippoMsgChat[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfHippoMsgChat, 0, i);
          j = i;
        }
        while (j < arrayOfHippoMsgChat.length - 1)
        {
          arrayOfHippoMsgChat[j] = new HippoMsgChat();
          paramCodedInputByteBufferNano.readMessage(arrayOfHippoMsgChat[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfHippoMsgChat[j] = new HippoMsgChat();
        paramCodedInputByteBufferNano.readMessage(arrayOfHippoMsgChat[j]);
        this.a = arrayOfHippoMsgChat;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.a;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
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
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRecentRoomMsg.nano.RecentMsg
 * JD-Core Version:    0.7.0.1
 */