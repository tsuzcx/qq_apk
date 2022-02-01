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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new RoomInfo[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.roomId;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.ownerUid;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    int k = j;
    if (!this.logo.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.logo);
    }
    i = k;
    if (!this.name.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.name);
    }
    k = this.gameType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    RoomRichTitle localRoomRichTitle = this.roomLabels;
    k = j;
    if (localRoomRichTitle != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(6, localRoomRichTitle);
    }
    j = this.giftFlag;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(7, j);
    }
    k = this.goodsFlag;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
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
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 82: 
        this.systemNotice = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.goodsFlag = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.giftFlag = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        if (this.roomLabels == null) {
          this.roomLabels = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.roomLabels);
        break;
      case 40: 
        this.gameType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.logo = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.ownerUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.ownerUid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!this.logo.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.logo);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.name);
    }
    int i = this.gameType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    RoomRichTitle localRoomRichTitle = this.roomLabels;
    if (localRoomRichTitle != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, localRoomRichTitle);
    }
    i = this.giftFlag;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    i = this.goodsFlag;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */