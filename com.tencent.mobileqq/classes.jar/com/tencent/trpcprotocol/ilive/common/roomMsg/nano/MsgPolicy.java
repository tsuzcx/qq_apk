package com.tencent.trpcprotocol.ilive.common.roomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class MsgPolicy
  extends ExtendableMessageNano<MsgPolicy>
{
  public int[] a;
  public ClientTypeAndVersion[] b;
  
  public MsgPolicy()
  {
    a();
  }
  
  public MsgPolicy a()
  {
    this.a = WireFormatNano.EMPTY_INT_ARRAY;
    this.b = ClientTypeAndVersion.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public MsgPolicy a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      Object localObject;
      if (i != 8)
      {
        if (i != 10)
        {
          if (i != 18)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
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
            localObject = new ClientTypeAndVersion[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.b, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new ClientTypeAndVersion();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = new ClientTypeAndVersion();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            this.b = ((ClientTypeAndVersion[])localObject);
          }
        }
        else
        {
          int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readUInt32();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          localObject = this.a;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.a, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramCodedInputByteBufferNano.readUInt32();
            j += 1;
          }
          this.a = ((int[])localObject);
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        localObject = this.a;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramCodedInputByteBufferNano.readUInt32();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = paramCodedInputByteBufferNano.readUInt32();
        this.a = ((int[])localObject);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    Object localObject = this.a;
    int m = 0;
    int i = k;
    int j;
    if (localObject != null)
    {
      i = k;
      if (localObject.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt32SizeNoTag(localObject[i]);
          i += 1;
        }
        i = k + j + localObject.length * 1;
      }
    }
    localObject = this.b;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.b;
          k = i;
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
    return k;
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
        paramCodedOutputByteBufferNano.writeUInt32(1, localObject[i]);
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.common.roomMsg.nano.MsgPolicy
 * JD-Core Version:    0.7.0.1
 */