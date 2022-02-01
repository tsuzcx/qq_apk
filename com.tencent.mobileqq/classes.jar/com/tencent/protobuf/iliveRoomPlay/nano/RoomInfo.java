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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.id;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.name.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.name);
    }
    int k = j;
    if (!this.logo.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.logo);
    }
    i = k;
    if (!this.programId.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.programId);
    }
    k = this.giftFlag;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    i = j;
    if (!this.goodsUrl.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.goodsUrl);
    }
    k = this.goodsNum;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(7, k);
    }
    RoomRichTitle localRoomRichTitle = this.tags;
    i = j;
    if (localRoomRichTitle != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(8, localRoomRichTitle);
    }
    j = i;
    if (!this.coverUrl169.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(9, this.coverUrl169);
    }
    k = j;
    if (!this.coverUrl34.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(10, this.coverUrl34);
    }
    i = k;
    if (!Arrays.equals(this.roomPrepareNotify, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(11, this.roomPrepareNotify);
    }
    k = this.roomGameType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(12, k);
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
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 106: 
        this.systemNotice = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.roomGameType = paramCodedInputByteBufferNano.readInt32();
        break;
      case 90: 
        this.roomPrepareNotify = paramCodedInputByteBufferNano.readBytes();
        break;
      case 82: 
        this.coverUrl34 = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.coverUrl169 = paramCodedInputByteBufferNano.readString();
        break;
      case 66: 
        if (this.tags == null) {
          this.tags = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.tags);
        break;
      case 56: 
        this.goodsNum = paramCodedInputByteBufferNano.readInt32();
        break;
      case 50: 
        this.goodsUrl = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.giftFlag = paramCodedInputByteBufferNano.readInt32();
        break;
      case 34: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.logo = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.name = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.id = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.id;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
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
    int i = this.giftFlag;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    if (!this.goodsUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.goodsUrl);
    }
    i = this.goodsNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, i);
    }
    RoomRichTitle localRoomRichTitle = this.tags;
    if (localRoomRichTitle != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, localRoomRichTitle);
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
    i = this.roomGameType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(12, i);
    }
    if (!this.systemNotice.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.systemNotice);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */