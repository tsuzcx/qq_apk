package com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class MsgPolicy
  extends ExtendableMessageNano<MsgPolicy>
{
  public int[] a;
  public int[] b;
  public long[] c;
  
  public MsgPolicy()
  {
    a();
  }
  
  public MsgPolicy a()
  {
    this.a = WireFormatNano.EMPTY_INT_ARRAY;
    this.b = WireFormatNano.EMPTY_INT_ARRAY;
    this.c = WireFormatNano.EMPTY_LONG_ARRAY;
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
        int k;
        if (i != 10)
        {
          if (i != 16)
          {
            if (i != 18)
            {
              if (i != 24)
              {
                if (i != 26)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
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
                  localObject = this.c;
                  if (localObject == null) {
                    i = 0;
                  } else {
                    i = localObject.length;
                  }
                  localObject = new long[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.c, 0, localObject, 0, i);
                    j = i;
                  }
                  while (j < localObject.length)
                  {
                    localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                    j += 1;
                  }
                  this.c = ((long[])localObject);
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
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.c, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                  paramCodedInputByteBufferNano.readTag();
                  j += 1;
                }
                localObject[j] = paramCodedInputByteBufferNano.readUInt64();
                this.c = ((long[])localObject);
              }
            }
            else
            {
              k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
              i = paramCodedInputByteBufferNano.getPosition();
              j = 0;
              while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
              {
                paramCodedInputByteBufferNano.readUInt32();
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
                localObject[j] = paramCodedInputByteBufferNano.readUInt32();
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
              localObject[j] = paramCodedInputByteBufferNano.readUInt32();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = paramCodedInputByteBufferNano.readUInt32();
            this.b = ((int[])localObject);
          }
        }
        else
        {
          k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
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
    int j = i;
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
          k += CodedOutputByteBufferNano.computeUInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    localObject = this.c;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        i = m;
        for (;;)
        {
          localObject = this.c;
          if (i >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[i]);
          i += 1;
        }
        i = j + k + localObject.length * 1;
      }
    }
    return i;
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
      i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt32(2, localObject[i]);
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
        paramCodedOutputByteBufferNano.writeUInt64(3, localObject[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano.MsgPolicy
 * JD-Core Version:    0.7.0.1
 */