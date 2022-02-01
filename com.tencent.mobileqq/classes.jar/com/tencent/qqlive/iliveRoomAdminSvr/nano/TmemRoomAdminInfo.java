package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TmemRoomAdminInfo
  extends ExtendableMessageNano<TmemRoomAdminInfo>
{
  public long a;
  public long b;
  public TmemRoomAdminDetail[] c;
  
  public TmemRoomAdminInfo()
  {
    a();
  }
  
  public TmemRoomAdminInfo a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = TmemRoomAdminDetail.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public TmemRoomAdminInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            TmemRoomAdminDetail[] arrayOfTmemRoomAdminDetail = this.c;
            if (arrayOfTmemRoomAdminDetail == null) {
              i = 0;
            } else {
              i = arrayOfTmemRoomAdminDetail.length;
            }
            arrayOfTmemRoomAdminDetail = new TmemRoomAdminDetail[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfTmemRoomAdminDetail, 0, i);
              j = i;
            }
            while (j < arrayOfTmemRoomAdminDetail.length - 1)
            {
              arrayOfTmemRoomAdminDetail[j] = new TmemRoomAdminDetail();
              paramCodedInputByteBufferNano.readMessage(arrayOfTmemRoomAdminDetail[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfTmemRoomAdminDetail[j] = new TmemRoomAdminDetail();
            paramCodedInputByteBufferNano.readMessage(arrayOfTmemRoomAdminDetail[j]);
            this.c = arrayOfTmemRoomAdminDetail;
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
    int k = i;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.TmemRoomAdminInfo
 * JD-Core Version:    0.7.0.1
 */