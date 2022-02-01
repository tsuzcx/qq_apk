package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GameCircleGetVideoInfoRes
  extends ExtendableMessageNano<GameCircleGetVideoInfoRes>
{
  public byte[] a;
  public GameCircleVideoLiveInfo[] b;
  public GameCircleVideoBufingInfo[] c;
  
  public GameCircleGetVideoInfoRes()
  {
    a();
  }
  
  public GameCircleGetVideoInfoRes a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = GameCircleVideoLiveInfo.a();
    this.c = GameCircleVideoBufingInfo.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GameCircleGetVideoInfoRes a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        int j;
        Object localObject;
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
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            localObject = this.c;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new GameCircleVideoBufingInfo[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new GameCircleVideoBufingInfo();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = new GameCircleVideoBufingInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            this.c = ((GameCircleVideoBufingInfo[])localObject);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          localObject = this.b;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new GameCircleVideoLiveInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new GameCircleVideoLiveInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new GameCircleVideoLiveInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((GameCircleVideoLiveInfo[])localObject);
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBytesSize(1, this.a);
    Object localObject = this.b;
    int m = 0;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = this.c;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
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
    paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    Object localObject = this.b;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GameCircleGetVideoInfoRes
 * JD-Core Version:    0.7.0.1
 */