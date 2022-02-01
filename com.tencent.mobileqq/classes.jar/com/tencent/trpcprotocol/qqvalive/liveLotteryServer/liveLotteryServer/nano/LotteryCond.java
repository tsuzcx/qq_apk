package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LotteryCond
  extends ExtendableMessageNano<LotteryCond>
{
  private static volatile LotteryCond[] d;
  public int a;
  public boolean b;
  public KV[] c;
  
  public LotteryCond()
  {
    b();
  }
  
  public static LotteryCond[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new LotteryCond[0];
        }
      }
    }
    return d;
  }
  
  public LotteryCond a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            KV[] arrayOfKV = this.c;
            if (arrayOfKV == null) {
              i = 0;
            } else {
              i = arrayOfKV.length;
            }
            arrayOfKV = new KV[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfKV, 0, i);
              j = i;
            }
            while (j < arrayOfKV.length - 1)
            {
              arrayOfKV[j] = new KV();
              paramCodedInputByteBufferNano.readMessage(arrayOfKV[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfKV[j] = new KV();
            paramCodedInputByteBufferNano.readMessage(arrayOfKV[j]);
            this.c = arrayOfKV;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else
      {
        i = paramCodedInputByteBufferNano.readInt32();
        switch (i)
        {
        default: 
          break;
        }
        this.a = i;
      }
    }
    return this;
  }
  
  public LotteryCond b()
  {
    this.a = 0;
    this.b = false;
    this.c = KV.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = this.a;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    boolean bool = this.b;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    Object localObject = this.c;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
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
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    Object localObject = this.c;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.LotteryCond
 * JD-Core Version:    0.7.0.1
 */