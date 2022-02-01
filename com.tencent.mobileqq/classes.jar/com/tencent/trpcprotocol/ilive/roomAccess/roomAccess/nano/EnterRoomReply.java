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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new EnterRoomReply[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.isBigRoom) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, this.isBigRoom);
    }
    j = i;
    if (this.useDispersion != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.useDispersion);
    }
    i = j;
    if (!Arrays.equals(this.dispersionUrl, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.dispersionUrl);
    }
    j = i;
    if (this.roomInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, this.roomInfo);
    }
    i = j;
    if (this.anchorInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, this.anchorInfo);
    }
    j = i;
    if (this.userRole != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, this.userRole);
    }
    i = j;
    if (this.sdkInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, this.sdkInfo);
    }
    return i;
  }
  
  public EnterRoomReply mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 24: 
        this.isBigRoom = paramCodedInputByteBufferNano.readBool();
        break;
      case 32: 
        this.useDispersion = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.dispersionUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 50: 
        if (this.roomInfo == null) {
          this.roomInfo = new RoomInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.roomInfo);
        break;
      case 58: 
        if (this.anchorInfo == null) {
          this.anchorInfo = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.anchorInfo);
        break;
      case 64: 
        this.userRole = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      if (this.sdkInfo == null) {
        this.sdkInfo = new AVInfo();
      }
      paramCodedInputByteBufferNano.readMessage(this.sdkInfo);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.isBigRoom) {
      paramCodedOutputByteBufferNano.writeBool(3, this.isBigRoom);
    }
    if (this.useDispersion != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.useDispersion);
    }
    if (!Arrays.equals(this.dispersionUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.dispersionUrl);
    }
    if (this.roomInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, this.roomInfo);
    }
    if (this.anchorInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, this.anchorInfo);
    }
    if (this.userRole != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.userRole);
    }
    if (this.sdkInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, this.sdkInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomReply
 * JD-Core Version:    0.7.0.1
 */