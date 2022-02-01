package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class BroadcastOverGift
  extends MessageNano
{
  private static volatile BroadcastOverGift[] _emptyArray;
  public byte[] anchorQtName;
  public int clientType;
  public int clientVersion;
  public int comboCount;
  public int comboSeq;
  public long dwAnchorUin;
  public long dwUserUin;
  public int giftId;
  public int giftNum;
  public int giftType;
  public byte[] headKey;
  public byte[] logoFullUrl;
  public long logoTimestamp;
  public TransparentMsg[] msgComTrans;
  public byte[] msgTransparent;
  public byte[] playNickname;
  public long playUid;
  public long roomId;
  public long subRoomId;
  public byte[] userBusinessUid;
  public byte[] userQtName;
  
  public BroadcastOverGift()
  {
    clear();
  }
  
  public static BroadcastOverGift[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BroadcastOverGift[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static BroadcastOverGift parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BroadcastOverGift().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BroadcastOverGift parseFrom(byte[] paramArrayOfByte)
  {
    return (BroadcastOverGift)MessageNano.mergeFrom(new BroadcastOverGift(), paramArrayOfByte);
  }
  
  public BroadcastOverGift clear()
  {
    this.giftType = 0;
    this.dwUserUin = 0L;
    this.userQtName = WireFormatNano.EMPTY_BYTES;
    this.dwAnchorUin = 0L;
    this.anchorQtName = WireFormatNano.EMPTY_BYTES;
    this.roomId = 0L;
    this.subRoomId = 0L;
    this.giftId = 0;
    this.giftNum = 0;
    this.comboSeq = 0;
    this.comboCount = 0;
    this.headKey = WireFormatNano.EMPTY_BYTES;
    this.logoTimestamp = 0L;
    this.msgTransparent = WireFormatNano.EMPTY_BYTES;
    this.logoFullUrl = WireFormatNano.EMPTY_BYTES;
    this.playUid = 0L;
    this.playNickname = WireFormatNano.EMPTY_BYTES;
    this.msgComTrans = TransparentMsg.emptyArray();
    this.userBusinessUid = WireFormatNano.EMPTY_BYTES;
    this.clientType = 0;
    this.clientVersion = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftType) + CodedOutputByteBufferNano.computeUInt64Size(2, this.dwUserUin) + CodedOutputByteBufferNano.computeBytesSize(3, this.userQtName) + CodedOutputByteBufferNano.computeUInt64Size(4, this.dwAnchorUin) + CodedOutputByteBufferNano.computeBytesSize(5, this.anchorQtName);
    long l = this.roomId;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    l = this.subRoomId;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    int k = this.giftId;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    k = this.giftNum;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(9, k);
    }
    k = this.comboSeq;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    k = this.comboCount;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(11, k);
    }
    i = j;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(12, this.headKey);
    }
    l = this.logoTimestamp;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(13, l);
    }
    i = j;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(14, this.msgTransparent);
    }
    j = i;
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(15, this.logoFullUrl);
    }
    l = this.playUid;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(16, l);
    }
    i = k;
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(17, this.playNickname);
    }
    Object localObject = this.msgComTrans;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.msgComTrans;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    k = j;
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(19, this.userBusinessUid);
    }
    j = this.clientType;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(21, j);
    }
    k = this.clientVersion;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(22, k);
    }
    return j;
  }
  
  public BroadcastOverGift mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 176: 
        this.clientVersion = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 168: 
        this.clientType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 154: 
        this.userBusinessUid = paramCodedInputByteBufferNano.readBytes();
        break;
      case 146: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
        TransparentMsg[] arrayOfTransparentMsg = this.msgComTrans;
        if (arrayOfTransparentMsg == null) {
          i = 0;
        } else {
          i = arrayOfTransparentMsg.length;
        }
        arrayOfTransparentMsg = new TransparentMsg[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.msgComTrans, 0, arrayOfTransparentMsg, 0, i);
          j = i;
        }
        while (j < arrayOfTransparentMsg.length - 1)
        {
          arrayOfTransparentMsg[j] = new TransparentMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfTransparentMsg[j] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[j]);
        this.msgComTrans = arrayOfTransparentMsg;
        break;
      case 138: 
        this.playNickname = paramCodedInputByteBufferNano.readBytes();
        break;
      case 128: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 122: 
        this.logoFullUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 114: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      case 104: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 98: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 88: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 42: 
        this.anchorQtName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.dwAnchorUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.userQtName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 16: 
        this.dwUserUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftType);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.dwUserUin);
    paramCodedOutputByteBufferNano.writeBytes(3, this.userQtName);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.dwAnchorUin);
    paramCodedOutputByteBufferNano.writeBytes(5, this.anchorQtName);
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    l = this.subRoomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    int i = this.giftId;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    i = this.giftNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i);
    }
    i = this.comboSeq;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    i = this.comboCount;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i);
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(12, this.headKey);
    }
    l = this.logoTimestamp;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(13, l);
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(14, this.msgTransparent);
    }
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(15, this.logoFullUrl);
    }
    l = this.playUid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, l);
    }
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.playNickname);
    }
    Object localObject = this.msgComTrans;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.msgComTrans;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(19, this.userBusinessUid);
    }
    i = this.clientType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(21, i);
    }
    i = this.clientVersion;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(22, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.BroadcastOverGift
 * JD-Core Version:    0.7.0.1
 */