package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RoomInfo
  extends MessageNano
{
  private static volatile RoomInfo[] _emptyArray;
  public int gameType;
  public int giftFlag;
  public int goodsFlag;
  public String logo;
  public String name;
  public long ownerUid;
  public String programId;
  public long roomId;
  public RoomRichTitle roomLabels;
  public String systemNotice;
  
  public RoomInfo()
  {
    clear();
  }
  
  public static RoomInfo[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new RoomInfo[0];
      }
      return _emptyArray;
    }
  }
  
  public static RoomInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new RoomInfo().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static RoomInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (RoomInfo)MessageNano.mergeFrom(new RoomInfo(), paramArrayOfByte);
  }
  
  public RoomInfo clear()
  {
    this.roomId = 0L;
    this.ownerUid = 0L;
    this.logo = "";
    this.name = "";
    this.gameType = 0;
    this.roomLabels = null;
    this.giftFlag = 0;
    this.goodsFlag = 0;
    this.programId = "";
    this.systemNotice = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomId);
    }
    j = i;
    if (this.ownerUid != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.ownerUid);
    }
    i = j;
    if (!this.logo.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.logo);
    }
    j = i;
    if (!this.name.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.name);
    }
    i = j;
    if (this.gameType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.gameType);
    }
    j = i;
    if (this.roomLabels != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, this.roomLabels);
    }
    i = j;
    if (this.giftFlag != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.giftFlag);
    }
    j = i;
    if (this.goodsFlag != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, this.goodsFlag);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.programId);
    }
    j = i;
    if (!this.systemNotice.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(10, this.systemNotice);
    }
    return j;
  }
  
  public RoomInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.ownerUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.logo = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.gameType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        if (this.roomLabels == null) {
          this.roomLabels = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.roomLabels);
        break;
      case 56: 
        this.giftFlag = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.goodsFlag = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.systemNotice = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomId);
    }
    if (this.ownerUid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.ownerUid);
    }
    if (!this.logo.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.logo);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.name);
    }
    if (this.gameType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.gameType);
    }
    if (this.roomLabels != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, this.roomLabels);
    }
    if (this.giftFlag != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.giftFlag);
    }
    if (this.goodsFlag != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.goodsFlag);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.programId);
    }
    if (!this.systemNotice.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.systemNotice);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */