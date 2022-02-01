package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LotteryInfo$PlatInfo
  extends ExtendableMessageNano<PlatInfo>
{
  public String a;
  public long[] b;
  public long c;
  public long d;
  public int e;
  public long[] f;
  public RoomLabel[] g;
  
  public LotteryInfo$PlatInfo()
  {
    a();
  }
  
  public PlatInfo a()
  {
    this.a = "";
    this.b = WireFormatNano.EMPTY_LONG_ARRAY;
    this.c = 0L;
    this.d = 0L;
    this.e = 0;
    this.f = WireFormatNano.EMPTY_LONG_ARRAY;
    this.g = RoomLabel.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PlatInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (i != 16)
        {
          int k;
          if (i != 18)
          {
            if (i != 24)
            {
              if (i != 32)
              {
                if (i != 40)
                {
                  if (i != 48)
                  {
                    if (i != 50)
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
                        localObject = new RoomLabel[j + i];
                        j = i;
                        if (i != 0)
                        {
                          System.arraycopy(this.g, 0, localObject, 0, i);
                          j = i;
                        }
                        while (j < localObject.length - 1)
                        {
                          localObject[j] = new RoomLabel();
                          paramCodedInputByteBufferNano.readMessage(localObject[j]);
                          paramCodedInputByteBufferNano.readTag();
                          j += 1;
                        }
                        localObject[j] = new RoomLabel();
                        paramCodedInputByteBufferNano.readMessage(localObject[j]);
                        this.g = ((RoomLabel[])localObject);
                      }
                    }
                    else
                    {
                      k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
                      i = paramCodedInputByteBufferNano.getPosition();
                      j = 0;
                      while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
                      {
                        paramCodedInputByteBufferNano.readUInt64();
                        j += 1;
                      }
                      paramCodedInputByteBufferNano.rewindToPosition(i);
                      localObject = this.f;
                      if (localObject == null) {
                        i = 0;
                      } else {
                        i = localObject.length;
                      }
                      localObject = new long[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.f, 0, localObject, 0, i);
                        j = i;
                      }
                      while (j < localObject.length)
                      {
                        localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                        j += 1;
                      }
                      this.f = ((long[])localObject);
                      paramCodedInputByteBufferNano.popLimit(k);
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
                    localObject = this.f;
                    if (localObject == null) {
                      i = 0;
                    } else {
                      i = localObject.length;
                    }
                    localObject = new long[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.f, 0, localObject, 0, i);
                      j = i;
                    }
                    while (j < localObject.length - 1)
                    {
                      localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                    this.f = ((long[])localObject);
                  }
                }
                else {
                  this.e = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else
          {
            k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
            i = paramCodedInputByteBufferNano.getPosition();
            j = 0;
            while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
            {
              paramCodedInputByteBufferNano.readUInt64();
              j += 1;
            }
            paramCodedInputByteBufferNano.rewindToPosition(i);
            localObject = this.b;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.b, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramCodedInputByteBufferNano.readUInt64();
              j += 1;
            }
            this.b = ((long[])localObject);
            paramCodedInputByteBufferNano.popLimit(k);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
          localObject = this.b;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramCodedInputByteBufferNano.readUInt64();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = paramCodedInputByteBufferNano.readUInt64();
          this.b = ((long[])localObject);
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    Object localObject = this.b;
    int m = 0;
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
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    long l = this.c;
    int k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.d;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    localObject = this.f;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          localObject = this.f;
          if (i >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[i]);
          i += 1;
        }
        i = j + k + localObject.length * 1;
      }
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
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
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
        paramCodedOutputByteBufferNano.writeUInt64(2, localObject[i]);
        i += 1;
      }
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    localObject = this.f;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.f;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(6, localObject[i]);
        i += 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.LotteryInfo.PlatInfo
 * JD-Core Version:    0.7.0.1
 */