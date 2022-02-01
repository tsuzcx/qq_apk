package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class EnterRoomReply
  extends ExtendableMessageNano<EnterRoomReply>
{
  public boolean a;
  public int b;
  public byte[] c;
  public RoomInfo d;
  public UserInfo e;
  public int f;
  public AVInfo g;
  public Program h;
  
  public EnterRoomReply()
  {
    a();
  }
  
  public static EnterRoomReply a(byte[] paramArrayOfByte)
  {
    return (EnterRoomReply)MessageNano.mergeFrom(new EnterRoomReply(), paramArrayOfByte);
  }
  
  public EnterRoomReply a()
  {
    this.a = false;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = null;
    this.e = null;
    this.f = 0;
    this.g = null;
    this.h = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public EnterRoomReply a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 24)
      {
        if (i != 32)
        {
          if (i != 42)
          {
            if (i != 50)
            {
              if (i != 58)
              {
                if (i != 64)
                {
                  if (i != 74)
                  {
                    if (i != 82)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else
                    {
                      if (this.h == null) {
                        this.h = new Program();
                      }
                      paramCodedInputByteBufferNano.readMessage(this.h);
                    }
                  }
                  else
                  {
                    if (this.g == null) {
                      this.g = new AVInfo();
                    }
                    paramCodedInputByteBufferNano.readMessage(this.g);
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new UserInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new RoomInfo();
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
        this.a = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    boolean bool = this.a;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    i = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.c);
    }
    Object localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    localObject = this.g;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.h;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    boolean bool = this.a;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.c);
    }
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.EnterRoomReply
 * JD-Core Version:    0.7.0.1
 */