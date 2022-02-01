package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AdminMenuListRsp
  extends ExtendableMessageNano<AdminMenuListRsp>
{
  public int a;
  public String b;
  public AdminMenu[] c;
  
  public AdminMenuListRsp()
  {
    a();
  }
  
  public static AdminMenuListRsp a(byte[] paramArrayOfByte)
  {
    return (AdminMenuListRsp)MessageNano.mergeFrom(new AdminMenuListRsp(), paramArrayOfByte);
  }
  
  public AdminMenuListRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = AdminMenu.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AdminMenuListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
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
            AdminMenu[] arrayOfAdminMenu = this.c;
            if (arrayOfAdminMenu == null) {
              i = 0;
            } else {
              i = arrayOfAdminMenu.length;
            }
            arrayOfAdminMenu = new AdminMenu[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfAdminMenu, 0, i);
              j = i;
            }
            while (j < arrayOfAdminMenu.length - 1)
            {
              arrayOfAdminMenu[j] = new AdminMenu();
              paramCodedInputByteBufferNano.readMessage(arrayOfAdminMenu[j]);
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfAdminMenu[j] = new AdminMenu();
            paramCodedInputByteBufferNano.readMessage(arrayOfAdminMenu[j]);
            this.c = arrayOfAdminMenu;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
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
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
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
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminMenuListRsp
 * JD-Core Version:    0.7.0.1
 */