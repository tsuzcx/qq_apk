package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetRoomVideoInfoRes
  extends ExtendableMessageNano<GetRoomVideoInfoRes>
{
  public int a;
  public VideoLiveInfo[] b;
  public VideoStageInfo[] c;
  public VideoBufingInfo[] d;
  public int e;
  public int f;
  
  public GetRoomVideoInfoRes()
  {
    a();
  }
  
  public GetRoomVideoInfoRes a()
  {
    this.a = 0;
    this.b = VideoLiveInfo.a();
    this.c = VideoStageInfo.a();
    this.d = VideoBufingInfo.a();
    this.e = 0;
    this.f = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRoomVideoInfoRes a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        int j;
        Object localObject;
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else
            {
              j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              localObject = this.d;
              if (localObject == null) {
                i = 0;
              } else {
                i = localObject.length;
              }
              localObject = new VideoBufingInfo[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, localObject, 0, i);
                j = i;
              }
              while (j < localObject.length - 1)
              {
                localObject[j] = new VideoBufingInfo();
                paramCodedInputByteBufferNano.readMessage(localObject[j]);
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              localObject[j] = new VideoBufingInfo();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              this.d = ((VideoBufingInfo[])localObject);
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
            localObject = new VideoStageInfo[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new VideoStageInfo();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = new VideoStageInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            this.c = ((VideoStageInfo[])localObject);
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
          localObject = new VideoLiveInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new VideoLiveInfo();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new VideoLiveInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((VideoLiveInfo[])localObject);
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    Object localObject = this.b;
    int m = 0;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
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
        j = i;
      }
    }
    localObject = this.c;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.c;
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
    localObject = this.d;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
        for (;;)
        {
          localObject = this.d;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    int k = this.e;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    Object localObject = this.b;
    int j = 0;
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
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.d;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GetRoomVideoInfoRes
 * JD-Core Version:    0.7.0.1
 */