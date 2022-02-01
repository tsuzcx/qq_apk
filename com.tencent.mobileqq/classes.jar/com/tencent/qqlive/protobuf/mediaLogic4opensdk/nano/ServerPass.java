package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ServerPass
  extends ExtendableMessageNano<ServerPass>
{
  public int a;
  public int b;
  public int c;
  public long d;
  public String e;
  public int f;
  public long g;
  public int h;
  public KvPair[] i;
  
  public ServerPass()
  {
    a();
  }
  
  public ServerPass a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0L;
    this.e = "";
    this.f = 0;
    this.g = 0L;
    this.h = 0;
    this.i = KvPair.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ServerPass a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 16)
        {
          if (j != 24)
          {
            if (j != 32)
            {
              if (j != 42)
              {
                if (j != 48)
                {
                  if (j != 56)
                  {
                    if (j != 64)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else
                      {
                        int k = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
                        KvPair[] arrayOfKvPair = this.i;
                        if (arrayOfKvPair == null) {
                          j = 0;
                        } else {
                          j = arrayOfKvPair.length;
                        }
                        arrayOfKvPair = new KvPair[k + j];
                        k = j;
                        if (j != 0)
                        {
                          System.arraycopy(this.i, 0, arrayOfKvPair, 0, j);
                          k = j;
                        }
                        while (k < arrayOfKvPair.length - 1)
                        {
                          arrayOfKvPair[k] = new KvPair();
                          paramCodedInputByteBufferNano.readMessage(arrayOfKvPair[k]);
                          paramCodedInputByteBufferNano.readTag();
                          k += 1;
                        }
                        arrayOfKvPair[k] = new KvPair();
                        paramCodedInputByteBufferNano.readMessage(arrayOfKvPair[k]);
                        this.i = arrayOfKvPair;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    int m = this.a;
    int j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(1, m);
    }
    m = this.b;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(2, m);
    }
    m = this.c;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(3, m);
    }
    long l = this.d;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    j = k;
    if (!this.e.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    m = this.f;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(6, m);
    }
    l = this.g;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    k = this.h;
    j = m;
    if (k != 0) {
      j = m + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    Object localObject = this.i;
    m = j;
    if (localObject != null)
    {
      m = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.i;
          m = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          m = j;
          if (localObject != null) {
            m = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
          }
          k += 1;
          j = m;
        }
      }
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = this.a;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, j);
    }
    j = this.b;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, j);
    }
    j = this.c;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, j);
    }
    long l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    j = this.f;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, j);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    j = this.h;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    Object localObject = this.i;
    if ((localObject != null) && (localObject.length > 0))
    {
      j = 0;
      for (;;)
      {
        localObject = this.i;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
        }
        j += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.ServerPass
 * JD-Core Version:    0.7.0.1
 */