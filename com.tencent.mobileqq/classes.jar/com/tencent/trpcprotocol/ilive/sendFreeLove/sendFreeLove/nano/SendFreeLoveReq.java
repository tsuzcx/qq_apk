package com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Map;

public final class SendFreeLoveReq
  extends ExtendableMessageNano<SendFreeLoveReq>
{
  public long a;
  public long b;
  public String c;
  public FreeLove[] d;
  public Map<String, String> e;
  public long f;
  
  public SendFreeLoveReq()
  {
    a();
  }
  
  public SendFreeLoveReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = FreeLove.a();
    this.e = null;
    this.f = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SendFreeLoveReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    MapFactories.MapFactory localMapFactory = MapFactories.getMapFactory();
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
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.e, localMapFactory, 9, 9, null, 10, 18);
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              FreeLove[] arrayOfFreeLove = this.d;
              if (arrayOfFreeLove == null) {
                i = 0;
              } else {
                i = arrayOfFreeLove.length;
              }
              arrayOfFreeLove = new FreeLove[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, arrayOfFreeLove, 0, i);
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
              this.d = arrayOfFreeLove;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
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
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    Object localObject = this.d;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.d;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + InternalNano.computeMapFieldSize((Map)localObject, 5, 9, 9);
    }
    l = this.f;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    return j;
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
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
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
    localObject = this.e;
    if (localObject != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, (Map)localObject, 5, 9, 9);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.SendFreeLoveReq
 * JD-Core Version:    0.7.0.1
 */