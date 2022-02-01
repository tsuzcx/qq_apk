package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class EnterRoomReply
  extends MessageNano
{
  private static volatile EnterRoomReply[] _emptyArray;
  public UserInfo anchorInfo;
  public byte[] dispersionUrl;
  public boolean isBigRoom;
  public RoomInfo roomInfo;
  public AVInfo sdkInfo;
  public int useDispersion;
  public int userRole;
  
  public EnterRoomReply()
  {
    clear();
  }
  
  public static EnterRoomReply[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new EnterRoomReply[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static EnterRoomReply parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new EnterRoomReply().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static EnterRoomReply parseFrom(byte[] paramArrayOfByte)
  {
    return (EnterRoomReply)MessageNano.mergeFrom(new EnterRoomReply(), paramArrayOfByte);
  }
  
  public EnterRoomReply clear()
  {
    this.isBigRoom = false;
    this.useDispersion = 0;
    this.dispersionUrl = WireFormatNano.EMPTY_BYTES;
    this.roomInfo = null;
    this.anchorInfo = null;
    this.userRole = 0;
    this.sdkInfo = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    boolean bool = this.isBigRoom;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    int k = this.useDispersion;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    i = j;
    if (!Arrays.equals(this.dispersionUrl, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.dispersionUrl);
    }
    Object localObject = this.roomInfo;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.anchorInfo;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    k = this.userRole;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    localObject = this.sdkInfo;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    return i;
  }
  
  public EnterRoomReply mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else
                  {
                    if (this.sdkInfo == null) {
                      this.sdkInfo = new AVInfo();
                    }
                    paramCodedInputByteBufferNano.readMessage(this.sdkInfo);
                  }
                }
                else {
                  this.userRole = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else
              {
                if (this.anchorInfo == null) {
                  this.anchorInfo = new UserInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.anchorInfo);
              }
            }
            else
            {
              if (this.roomInfo == null) {
                this.roomInfo = new RoomInfo();
              }
              paramCodedInputByteBufferNano.readMessage(this.roomInfo);
            }
          }
          else {
            this.dispersionUrl = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.useDispersion = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.isBigRoom = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    boolean bool = this.isBigRoom;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    int i = this.useDispersion;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    if (!Arrays.equals(this.dispersionUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.dispersionUrl);
    }
    Object localObject = this.roomInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
    }
    localObject = this.anchorInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    i = this.userRole;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    localObject = this.sdkInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomReply
 * JD-Core Version:    0.7.0.1
 */