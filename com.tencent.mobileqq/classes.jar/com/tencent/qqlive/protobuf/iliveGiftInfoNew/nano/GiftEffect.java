package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GiftEffect
  extends ExtendableMessageNano<GiftEffect>
{
  private static volatile GiftEffect[] f;
  public int a;
  public int b;
  public byte[] c;
  public FlashEffect d;
  public FlashEffect e;
  
  public GiftEffect()
  {
    b();
  }
  
  public static GiftEffect[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new GiftEffect[0];
        }
      }
    }
    return f;
  }
  
  public GiftEffect a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new FlashEffect();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new FlashEffect();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBytes();
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
  
  public GiftEffect b()
  {
    this.a = 0;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = null;
    this.e = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b);
    int i = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    FlashEffect localFlashEffect = this.d;
    j = i;
    if (localFlashEffect != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, localFlashEffect);
    }
    localFlashEffect = this.e;
    i = j;
    if (localFlashEffect != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, localFlashEffect);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    FlashEffect localFlashEffect = this.d;
    if (localFlashEffect != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localFlashEffect);
    }
    localFlashEffect = this.e;
    if (localFlashEffect != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localFlashEffect);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.GiftEffect
 * JD-Core Version:    0.7.0.1
 */