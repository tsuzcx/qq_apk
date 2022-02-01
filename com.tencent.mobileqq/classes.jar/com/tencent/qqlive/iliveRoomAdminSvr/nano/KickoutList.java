package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class KickoutList
  extends ExtendableMessageNano<KickoutList>
{
  public long a;
  public KickOutUser[] b;
  public KickoutDevice[] c;
  public long d;
  
  public KickoutList()
  {
    a();
  }
  
  public KickoutList a()
  {
    this.a = 0L;
    this.b = KickOutUser.a();
    this.c = KickoutDevice.a();
    this.d = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public KickoutList a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            localObject = this.c;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new KickoutDevice[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new KickoutDevice();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = new KickoutDevice();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            this.c = ((KickoutDevice[])localObject);
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
          localObject = new KickOutUser[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new KickOutUser();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new KickOutUser();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((KickOutUser[])localObject);
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    Object localObject = this.b;
    int m = 0;
    i = j;
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
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
        for (;;)
        {
          localObject = this.c;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    l = this.d;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
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
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.KickoutList
 * JD-Core Version:    0.7.0.1
 */