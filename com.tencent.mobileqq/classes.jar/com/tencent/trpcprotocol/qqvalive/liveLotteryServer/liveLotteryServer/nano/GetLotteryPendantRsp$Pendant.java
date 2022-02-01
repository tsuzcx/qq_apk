package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLotteryPendantRsp$Pendant
  extends ExtendableMessageNano<Pendant>
{
  private static volatile Pendant[] i;
  public long a;
  public int b;
  public boolean c;
  public String d;
  public int e;
  public String f;
  public String g;
  public LotteryCond[] h;
  
  public GetLotteryPendantRsp$Pendant()
  {
    b();
  }
  
  public static Pendant[] a()
  {
    if (i == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (i == null) {
          i = new Pendant[0];
        }
      }
    }
    return i;
  }
  
  public Pendant a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (j != 34)
            {
              if (j != 40)
              {
                if (j != 50)
                {
                  if (j != 58)
                  {
                    if (j != 66)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                        return this;
                      }
                    }
                    else
                    {
                      int k = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
                      LotteryCond[] arrayOfLotteryCond = this.h;
                      if (arrayOfLotteryCond == null) {
                        j = 0;
                      } else {
                        j = arrayOfLotteryCond.length;
                      }
                      arrayOfLotteryCond = new LotteryCond[k + j];
                      k = j;
                      if (j != 0)
                      {
                        System.arraycopy(this.h, 0, arrayOfLotteryCond, 0, j);
                        k = j;
                      }
                      while (k < arrayOfLotteryCond.length - 1)
                      {
                        arrayOfLotteryCond[k] = new LotteryCond();
                        paramCodedInputByteBufferNano.readMessage(arrayOfLotteryCond[k]);
                        paramCodedInputByteBufferNano.readTag();
                        k += 1;
                      }
                      arrayOfLotteryCond[k] = new LotteryCond();
                      paramCodedInputByteBufferNano.readMessage(arrayOfLotteryCond[k]);
                      this.h = arrayOfLotteryCond;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else
              {
                j = paramCodedInputByteBufferNano.readInt32();
                if ((j == 0) || (j == 1)) {
                  this.e = j;
                }
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBool();
          }
        }
        else
        {
          j = paramCodedInputByteBufferNano.readInt32();
          if ((j == 0) || (j == 1) || (j == 2)) {
            this.b = j;
          }
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  public Pendant b()
  {
    this.a = 0L;
    this.b = 0;
    this.c = false;
    this.d = "";
    this.e = 0;
    this.f = "";
    this.g = "";
    this.h = LotteryCond.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    long l = this.a;
    int j = k;
    if (l != 0L) {
      j = k + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    int m = this.b;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeInt32Size(2, m);
    }
    boolean bool = this.c;
    m = k;
    if (bool) {
      m = k + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    j = m;
    if (!this.d.equals("")) {
      j = m + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    m = this.e;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeInt32Size(5, m);
    }
    m = k;
    if (!this.f.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    j = m;
    if (!this.g.equals("")) {
      j = m + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    Object localObject = this.h;
    m = j;
    if (localObject != null)
    {
      m = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.h;
          m = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          m = j;
          if (localObject != null) {
            m = j + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
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
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    int j = this.b;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, j);
    }
    boolean bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    j = this.e;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, j);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    Object localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      j = 0;
      for (;;)
      {
        localObject = this.h;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
        }
        j += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetLotteryPendantRsp.Pendant
 * JD-Core Version:    0.7.0.1
 */