package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLiveStreamsReq
  extends ExtendableMessageNano<GetLiveStreamsReq>
{
  public String[] a;
  public int[] b;
  public long c;
  public long d;
  public long e;
  public int f;
  public long g;
  public String h;
  
  public GetLiveStreamsReq()
  {
    a();
  }
  
  public GetLiveStreamsReq a()
  {
    this.a = WireFormatNano.EMPTY_STRING_ARRAY;
    this.b = WireFormatNano.EMPTY_INT_ARRAY;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.g = 0L;
    this.h = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetLiveStreamsReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                    if (i != 56)
                    {
                      if (i != 66)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                          return this;
                        }
                      }
                      else {
                        this.h = paramCodedInputByteBufferNano.readString();
                      }
                    }
                    else {
                      this.g = paramCodedInputByteBufferNano.readInt64();
                    }
                  }
                  else {
                    this.f = paramCodedInputByteBufferNano.readInt32();
                  }
                }
                else {
                  this.e = paramCodedInputByteBufferNano.readInt64();
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readInt64();
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readInt64();
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
            localObject = this.b;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.b, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramCodedInputByteBufferNano.readInt32();
              j += 1;
            }
            this.b = ((int[])localObject);
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
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = paramCodedInputByteBufferNano.readInt32();
          this.b = ((int[])localObject);
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
        localObject = new String[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = paramCodedInputByteBufferNano.readString();
        this.a = ((String[])localObject);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    Object localObject = this.a;
    int i1 = 0;
    int i = i2;
    if (localObject != null)
    {
      i = i2;
      if (localObject.length > 0)
      {
        i = 0;
        j = 0;
        int m;
        for (k = 0;; k = m)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i += 1;
          j = n;
        }
        i = i2 + j + k * 1;
      }
    }
    localObject = this.b;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        j = i1;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    long l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(3, l);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(4, l);
    }
    l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    int k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(6, k);
    }
    l = this.g;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(7, l);
    }
    j = i;
    if (!this.h.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    return j;
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
          paramCodedOutputByteBufferNano.writeString(1, (String)localObject);
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
        paramCodedOutputByteBufferNano.writeInt32(2, localObject[i]);
        i += 1;
      }
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(3, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l);
    }
    int i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, i);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(7, l);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.h);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsReq
 * JD-Core Version:    0.7.0.1
 */