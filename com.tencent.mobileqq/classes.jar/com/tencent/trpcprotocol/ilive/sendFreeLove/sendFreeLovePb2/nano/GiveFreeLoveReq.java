package com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLovePb2.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GiveFreeLoveReq
  extends ExtendableMessageNano<GiveFreeLoveReq>
{
  public long a;
  public long b;
  public long c;
  public FreeLovePb2[] d;
  
  public GiveFreeLoveReq()
  {
    a();
  }
  
  public GiveFreeLoveReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = FreeLovePb2.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GiveFreeLoveReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              FreeLovePb2[] arrayOfFreeLovePb2 = this.d;
              if (arrayOfFreeLovePb2 == null) {
                i = 0;
              } else {
                i = arrayOfFreeLovePb2.length;
              }
              arrayOfFreeLovePb2 = new FreeLovePb2[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, arrayOfFreeLovePb2, 0, i);
                j = i;
              }
              while (j < arrayOfFreeLovePb2.length - 1)
              {
                arrayOfFreeLovePb2[j] = new FreeLovePb2();
                paramCodedInputByteBufferNano.readMessage(arrayOfFreeLovePb2[j]);
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              arrayOfFreeLovePb2[j] = new FreeLovePb2();
              paramCodedInputByteBufferNano.readMessage(arrayOfFreeLovePb2[j]);
              this.d = arrayOfFreeLovePb2;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    Object localObject = this.d;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.d;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
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
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLovePb2.nano.GiveFreeLoveReq
 * JD-Core Version:    0.7.0.1
 */