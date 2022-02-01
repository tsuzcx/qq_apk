package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PushMsg_RoomAdminList
  extends ExtendableMessageNano<PushMsg_RoomAdminList>
{
  public RoomAdminDetail[] a;
  public boolean b;
  
  public PushMsg_RoomAdminList()
  {
    a();
  }
  
  public PushMsg_RoomAdminList a()
  {
    this.a = RoomAdminDetail.a();
    this.b = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushMsg_RoomAdminList a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        RoomAdminDetail[] arrayOfRoomAdminDetail = this.a;
        if (arrayOfRoomAdminDetail == null) {
          i = 0;
        } else {
          i = arrayOfRoomAdminDetail.length;
        }
        arrayOfRoomAdminDetail = new RoomAdminDetail[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfRoomAdminDetail, 0, i);
          j = i;
        }
        while (j < arrayOfRoomAdminDetail.length - 1)
        {
          arrayOfRoomAdminDetail[j] = new RoomAdminDetail();
          paramCodedInputByteBufferNano.readMessage(arrayOfRoomAdminDetail[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfRoomAdminDetail[j] = new RoomAdminDetail();
        paramCodedInputByteBufferNano.readMessage(arrayOfRoomAdminDetail[j]);
        this.a = arrayOfRoomAdminDetail;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.a;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    boolean bool = this.b;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_RoomAdminList
 * JD-Core Version:    0.7.0.1
 */