package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class StreamInfo
  extends ExtendableMessageNano<StreamInfo>
{
  private static volatile StreamInfo[] h;
  public long a;
  public long b;
  public Stream[] c;
  public int d;
  public int[] e;
  public int f;
  public GearInfo[] g;
  
  public StreamInfo()
  {
    b();
  }
  
  public static StreamInfo[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new StreamInfo[0];
        }
      }
    }
    return h;
  }
  
  public StreamInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          int j;
          Object localObject;
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 42)
                {
                  if (i != 48)
                  {
                    if (i != 58)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
                      localObject = this.g;
                      if (localObject == null) {
                        i = 0;
                      } else {
                        i = localObject.length;
                      }
                      localObject = new GearInfo[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.g, 0, localObject, 0, i);
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
                      this.g = ((GearInfo[])localObject);
                    }
                  }
                  else {
                    this.f = paramCodedInputByteBufferNano.readInt32();
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
                  localObject = this.e;
                  if (localObject == null) {
                    i = 0;
                  } else {
                    i = localObject.length;
                  }
                  localObject = new int[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.e, 0, localObject, 0, i);
                    j = i;
                  }
                  while (j < localObject.length)
                  {
                    localObject[j] = paramCodedInputByteBufferNano.readInt32();
                    j += 1;
                  }
                  this.e = ((int[])localObject);
                  paramCodedInputByteBufferNano.popLimit(k);
                }
              }
              else
              {
                j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 40);
                localObject = this.e;
                if (localObject == null) {
                  i = 0;
                } else {
                  i = localObject.length;
                }
                localObject = new int[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.e, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramCodedInputByteBufferNano.readInt32();
                  paramCodedInputByteBufferNano.readTag();
                  j += 1;
                }
                localObject[j] = paramCodedInputByteBufferNano.readInt32();
                this.e = ((int[])localObject);
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt32();
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
            localObject = new Stream[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, localObject, 0, i);
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
            this.c = ((Stream[])localObject);
          }
        }
        else
        {
          this.b = paramCodedInputByteBufferNano.readInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  public StreamInfo b()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = Stream.a();
    this.d = 0;
    this.e = WireFormatNano.EMPTY_INT_ARRAY;
    this.f = 0;
    this.g = GearInfo.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    Object localObject = this.c;
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
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
        j = i;
      }
    }
    int k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    localObject = this.e;
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
          localObject = this.e;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(6, k);
    }
    localObject = this.g;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.g;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
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
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    Object localObject = this.c;
    int j = 0;
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
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(5, localObject[i]);
        i += 1;
      }
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, i);
    }
    localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.g;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.StreamInfo
 * JD-Core Version:    0.7.0.1
 */