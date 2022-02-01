package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Config
  extends ExtendableMessageNano<Config>
{
  public RoomidRouteConfig[] a;
  public AppidRouteConfig[] b;
  public String c;
  public long d;
  
  public Config()
  {
    a();
  }
  
  public Config a()
  {
    this.a = RoomidRouteConfig.a();
    this.b = AppidRouteConfig.a();
    this.c = "";
    this.d = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public Config a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      Object localObject;
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
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
          localObject = new AppidRouteConfig[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new AppidRouteConfig();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new AppidRouteConfig();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((AppidRouteConfig[])localObject);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        localObject = this.a;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new RoomidRouteConfig[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new RoomidRouteConfig();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = new RoomidRouteConfig();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.a = ((RoomidRouteConfig[])localObject);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.a;
    int m = 0;
    int i = j;
    int k;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.a;
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
    localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
        for (;;)
        {
          localObject = this.b;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    long l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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
    localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
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
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    long l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.Config
 * JD-Core Version:    0.7.0.1
 */