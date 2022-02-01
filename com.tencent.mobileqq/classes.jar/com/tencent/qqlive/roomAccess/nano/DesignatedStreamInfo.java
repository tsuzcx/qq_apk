package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DesignatedStreamInfo
  extends ExtendableMessageNano<DesignatedStreamInfo>
{
  public Stream[] a;
  public int b;
  public int[] c;
  public int d;
  public GearInfo[] e;
  
  public DesignatedStreamInfo()
  {
    a();
  }
  
  public DesignatedStreamInfo a()
  {
    this.a = Stream.a();
    this.b = 0;
    this.c = WireFormatNano.EMPTY_INT_ARRAY;
    this.d = 0;
    this.e = GearInfo.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public DesignatedStreamInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 26)
            {
              if (i != 32)
              {
                if (i != 42)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
                  localObject = this.e;
                  if (localObject == null) {
                    i = 0;
                  } else {
                    i = localObject.length;
                  }
                  localObject = new GearInfo[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.e, 0, localObject, 0, i);
                    j = i;
                  }
                  while (j < localObject.length - 1)
                  {
                    localObject[j] = new GearInfo();
                    paramCodedInputByteBufferNano.readMessage(localObject[j]);
                    paramCodedInputByteBufferNano.readTag();
                    j += 1;
                  }
                  localObject[j] = new GearInfo();
                  paramCodedInputByteBufferNano.readMessage(localObject[j]);
                  this.e = ((GearInfo[])localObject);
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else
            {
              int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
              i = paramCodedInputByteBufferNano.getPosition();
              j = 0;
              while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
              {
                paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              paramCodedInputByteBufferNano.rewindToPosition(i);
              localObject = this.c;
              if (localObject == null) {
                i = 0;
              } else {
                i = localObject.length;
              }
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.c, 0, localObject, 0, i);
                j = i;
              }
              while (j < localObject.length)
              {
                localObject[j] = paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              this.c = ((int[])localObject);
              paramCodedInputByteBufferNano.popLimit(k);
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
            localObject = this.c;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramCodedInputByteBufferNano.readInt32();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            this.c = ((int[])localObject);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
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
        localObject = new Stream[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new Stream();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = new Stream();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.a = ((Stream[])localObject);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
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
        j = i;
      }
    }
    int k = this.b;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          localObject = this.c;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    localObject = this.e;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.e;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
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
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
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
        paramCodedOutputByteBufferNano.writeInt32(3, localObject[i]);
        i += 1;
      }
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.DesignatedStreamInfo
 * JD-Core Version:    0.7.0.1
 */