package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class RoomInfo
  extends MessageNano
{
  private static volatile RoomInfo[] _emptyArray;
  public String coverUrl169;
  public String coverUrl34;
  public int giftFlag;
  public int goodsNum;
  public String goodsUrl;
  public long id;
  public String logo;
  public String name;
  public String programId;
  public int roomGameType;
  public byte[] roomPrepareNotify;
  public String systemNotice;
  public RoomRichTitle tags;
  
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
    this.id = 0L;
    this.name = "";
    this.logo = "";
    this.programId = "";
    this.giftFlag = 0;
    this.goodsUrl = "";
    this.goodsNum = 0;
    this.tags = null;
    this.coverUrl169 = "";
    this.coverUrl34 = "";
    this.roomPrepareNotify = WireFormatNano.EMPTY_BYTES;
    this.roomGameType = 0;
    this.systemNotice = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.id != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.id);
    }
    j = i;
    if (!this.name.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.name);
    }
    i = j;
    if (!this.logo.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.logo);
    }
    j = i;
    if (!this.programId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.programId);
    }
    i = j;
    if (this.giftFlag != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, this.giftFlag);
    }
    j = i;
    if (!this.goodsUrl.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.goodsUrl);
    }
    i = j;
    if (this.goodsNum != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(7, this.goodsNum);
    }
    j = i;
    if (this.tags != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, this.tags);
    }
    i = j;
    if (!this.coverUrl169.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.coverUrl169);
    }
    j = i;
    if (!this.coverUrl34.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(10, this.coverUrl34);
    }
    i = j;
    if (!Arrays.equals(this.roomPrepareNotify, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(11, this.roomPrepareNotify);
    }
    j = i;
    if (this.roomGameType != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(12, this.roomGameType);
    }
    i = j;
    if (!this.systemNotice.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(13, this.systemNotice);
    }
    return i;
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
        this.id = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.logo = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.giftFlag = paramCodedInputByteBufferNano.readInt32();
        break;
      case 50: 
        this.goodsUrl = paramCodedInputByteBufferNano.readString();
        break;
      case 56: 
        this.goodsNum = paramCodedInputByteBufferNano.readInt32();
        break;
      case 66: 
        if (this.tags == null) {
          this.tags = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.tags);
        break;
      case 74: 
        this.coverUrl169 = paramCodedInputByteBufferNano.readString();
        break;
      case 82: 
        this.coverUrl34 = paramCodedInputByteBufferNano.readString();
        break;
      case 90: 
        this.roomPrepareNotify = paramCodedInputByteBufferNano.readBytes();
        break;
      case 96: 
        this.roomGameType = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      this.systemNotice = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.id != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.id);
    }
    if (!this.name.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.name);
    }
    if (!this.logo.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.logo);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.programId);
    }
    if (this.giftFlag != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, this.giftFlag);
    }
    if (!this.goodsUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.goodsUrl);
    }
    if (this.goodsNum != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, this.goodsNum);
    }
    if (this.tags != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, this.tags);
    }
    if (!this.coverUrl169.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.coverUrl169);
    }
    if (!this.coverUrl34.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.coverUrl34);
    }
    if (!Arrays.equals(this.roomPrepareNotify, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.roomPrepareNotify);
    }
    if (this.roomGameType != 0) {
      paramCodedOutputByteBufferNano.writeInt32(12, this.roomGameType);
    }
    if (!this.systemNotice.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.systemNotice);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */