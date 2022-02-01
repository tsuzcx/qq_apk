package com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.trpcprotocol.ilive.common.roomMsg.nano.MsgInfo;
import java.util.Arrays;

public final class PullMsgRsp
  extends ExtendableMessageNano<PullMsgRsp>
{
  public long a;
  public MsgInfo[] b;
  public MsgInfo[] c;
  public int d;
  public byte[] e;
  public long f;
  public long g;
  
  public PullMsgRsp()
  {
    a();
  }
  
  public static PullMsgRsp a(byte[] paramArrayOfByte)
  {
    return (PullMsgRsp)MessageNano.mergeFrom(new PullMsgRsp(), paramArrayOfByte);
  }
  
  public PullMsgRsp a()
  {
    this.a = 0L;
    this.b = MsgInfo.a();
    this.c = MsgInfo.a();
    this.d = 0;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = 0L;
    this.g = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PullMsgRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        int j;
        MsgInfo[] arrayOfMsgInfo;
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBytes();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            arrayOfMsgInfo = this.c;
            if (arrayOfMsgInfo == null) {
              i = 0;
            } else {
              i = arrayOfMsgInfo.length;
            }
            arrayOfMsgInfo = new MsgInfo[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfMsgInfo, 0, i);
              j = i;
            }
            while (j < arrayOfMsgInfo.length - 1)
            {
              arrayOfMsgInfo[j] = new MsgInfo();
              paramCodedInputByteBufferNano.readMessage(arrayOfMsgInfo[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfMsgInfo[j] = new MsgInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfMsgInfo[j]);
            this.c = arrayOfMsgInfo;
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          arrayOfMsgInfo = this.b;
          if (arrayOfMsgInfo == null) {
            i = 0;
          } else {
            i = arrayOfMsgInfo.length;
          }
          arrayOfMsgInfo = new MsgInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfMsgInfo, 0, i);
            j = i;
          }
          while (j < arrayOfMsgInfo.length - 1)
          {
            arrayOfMsgInfo[j] = new MsgInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfMsgInfo[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfMsgInfo[j] = new MsgInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfMsgInfo[j]);
          this.b = arrayOfMsgInfo;
        }
      }
      else
      {
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
    Object localObject = this.b;
    int m = 0;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
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
    int k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    j = i;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    l = this.g;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
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
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
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
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.PullMsgRsp
 * JD-Core Version:    0.7.0.1
 */