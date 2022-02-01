package com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BroadcastFreeLove
  extends ExtendableMessageNano<BroadcastFreeLove>
{
  public long a;
  public long b;
  public FreeLove[] c;
  public long d;
  public String e;
  public String f;
  
  public BroadcastFreeLove()
  {
    a();
  }
  
  public static BroadcastFreeLove a(byte[] paramArrayOfByte)
  {
    return (BroadcastFreeLove)MessageNano.mergeFrom(new BroadcastFreeLove(), paramArrayOfByte);
  }
  
  public BroadcastFreeLove a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = FreeLove.a();
    this.d = 0L;
    this.e = "";
    this.f = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BroadcastFreeLove a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
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
          else
          {
            int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            FreeLove[] arrayOfFreeLove = this.c;
            if (arrayOfFreeLove == null) {
              i = 0;
            } else {
              i = arrayOfFreeLove.length;
            }
            arrayOfFreeLove = new FreeLove[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfFreeLove, 0, i);
              j = i;
            }
            while (j < arrayOfFreeLove.length - 1)
            {
              arrayOfFreeLove[j] = new FreeLove();
              paramCodedInputByteBufferNano.readMessage(arrayOfFreeLove[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfFreeLove[j] = new FreeLove();
            paramCodedInputByteBufferNano.readMessage(arrayOfFreeLove[j]);
            this.c = arrayOfFreeLove;
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
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.c;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    l = this.d;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    j = i;
    if (!this.e.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    i = j;
    if (!this.f.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    return i;
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
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
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
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.BroadcastFreeLove
 * JD-Core Version:    0.7.0.1
 */