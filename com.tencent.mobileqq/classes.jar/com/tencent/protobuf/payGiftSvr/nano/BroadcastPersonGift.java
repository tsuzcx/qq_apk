package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class BroadcastPersonGift
  extends MessageNano
{
  private static volatile BroadcastPersonGift[] _emptyArray;
  public byte[] anchorQtName;
  public long charm;
  public int clientType;
  public int clientVersion;
  public int comboCount;
  public int comboSeq;
  public long dwAnchorUin;
  public long dwUserUin;
  public int fromType;
  public int giftId;
  public int giftNum;
  public int giftType;
  public byte[] headKey;
  public ILiveGiftSite[] iLiveGiftSites;
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
  
  public BroadcastPersonGift()
  {
    clear();
  }
  
  public static BroadcastPersonGift[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BroadcastPersonGift[0];
      }
      return _emptyArray;
    }
  }
  
  public static BroadcastPersonGift parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BroadcastPersonGift().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BroadcastPersonGift parseFrom(byte[] paramArrayOfByte)
  {
    return (BroadcastPersonGift)MessageNano.mergeFrom(new BroadcastPersonGift(), paramArrayOfByte);
  }
  
  public BroadcastPersonGift clear()
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
    this.iLiveGiftSites = ILiveGiftSite.emptyArray();
    this.headKey = WireFormatNano.EMPTY_BYTES;
    this.logoTimestamp = 0L;
    this.charm = 0L;
    this.msgTransparent = WireFormatNano.EMPTY_BYTES;
    this.logoFullUrl = WireFormatNano.EMPTY_BYTES;
    this.fromType = 0;
    this.playUid = 0L;
    this.playNickname = WireFormatNano.EMPTY_BYTES;
    this.msgComTrans = TransparentMsg.emptyArray();
    this.userBusinessUid = WireFormatNano.EMPTY_BYTES;
    this.clientType = 0;
    this.clientVersion = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftType) + CodedOutputByteBufferNano.computeUInt64Size(2, this.dwUserUin) + CodedOutputByteBufferNano.computeBytesSize(3, this.userQtName) + CodedOutputByteBufferNano.computeUInt64Size(4, this.dwAnchorUin) + CodedOutputByteBufferNano.computeBytesSize(5, this.anchorQtName);
    int i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, this.roomId);
    }
    j = i;
    if (this.subRoomId != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, this.subRoomId);
    }
    i = j;
    if (this.giftId != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(8, this.giftId);
    }
    j = i;
    if (this.giftNum != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(9, this.giftNum);
    }
    int k = j;
    if (this.comboSeq != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(10, this.comboSeq);
    }
    i = k;
    if (this.comboCount != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(11, this.comboCount);
    }
    j = i;
    Object localObject;
    if (this.iLiveGiftSites != null)
    {
      j = i;
      if (this.iLiveGiftSites.length > 0)
      {
        j = 0;
        while (j < this.iLiveGiftSites.length)
        {
          localObject = this.iLiveGiftSites[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(13, this.headKey);
    }
    j = i;
    if (this.logoTimestamp != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(14, this.logoTimestamp);
    }
    i = j;
    if (this.charm != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(15, this.charm);
    }
    j = i;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(16, this.msgTransparent);
    }
    i = j;
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(17, this.logoFullUrl);
    }
    j = i;
    if (this.fromType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(18, this.fromType);
    }
    k = j;
    if (this.playUid != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(19, this.playUid);
    }
    i = k;
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(20, this.playNickname);
    }
    j = i;
    if (this.msgComTrans != null)
    {
      j = i;
      if (this.msgComTrans.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.msgComTrans.length) {
            break;
          }
          localObject = this.msgComTrans[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(21, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(22, this.userBusinessUid);
    }
    j = i;
    if (this.clientType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(24, this.clientType);
    }
    i = j;
    if (this.clientVersion != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(25, this.clientVersion);
    }
    return i;
  }
  
  public BroadcastPersonGift mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.dwUserUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.userQtName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.dwAnchorUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 42: 
        this.anchorQtName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 48: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 64: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 98: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        if (this.iLiveGiftSites == null) {}
        for (i = 0;; i = this.iLiveGiftSites.length)
        {
          localObject = new ILiveGiftSite[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.iLiveGiftSites, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new ILiveGiftSite();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new ILiveGiftSite();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.iLiveGiftSites = ((ILiveGiftSite[])localObject);
        break;
      case 106: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 112: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 120: 
        this.charm = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 130: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      case 138: 
        this.logoFullUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 144: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 152: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 162: 
        this.playNickname = paramCodedInputByteBufferNano.readBytes();
        break;
      case 170: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 170);
        if (this.msgComTrans == null) {}
        for (i = 0;; i = this.msgComTrans.length)
        {
          localObject = new TransparentMsg[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.msgComTrans, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new TransparentMsg();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.msgComTrans = ((TransparentMsg[])localObject);
        break;
      case 178: 
        this.userBusinessUid = paramCodedInputByteBufferNano.readBytes();
        break;
      case 192: 
        this.clientType = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.clientVersion = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftType);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.dwUserUin);
    paramCodedOutputByteBufferNano.writeBytes(3, this.userQtName);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.dwAnchorUin);
    paramCodedOutputByteBufferNano.writeBytes(5, this.anchorQtName);
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, this.roomId);
    }
    if (this.subRoomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.subRoomId);
    }
    if (this.giftId != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.giftId);
    }
    if (this.giftNum != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, this.giftNum);
    }
    if (this.comboSeq != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.comboSeq);
    }
    if (this.comboCount != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, this.comboCount);
    }
    int i;
    Object localObject;
    if ((this.iLiveGiftSites != null) && (this.iLiveGiftSites.length > 0))
    {
      i = 0;
      while (i < this.iLiveGiftSites.length)
      {
        localObject = this.iLiveGiftSites[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.headKey);
    }
    if (this.logoTimestamp != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(14, this.logoTimestamp);
    }
    if (this.charm != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, this.charm);
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.msgTransparent);
    }
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.logoFullUrl);
    }
    if (this.fromType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(18, this.fromType);
    }
    if (this.playUid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(19, this.playUid);
    }
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.playNickname);
    }
    if ((this.msgComTrans != null) && (this.msgComTrans.length > 0))
    {
      i = j;
      while (i < this.msgComTrans.length)
      {
        localObject = this.msgComTrans[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(21, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(22, this.userBusinessUid);
    }
    if (this.clientType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(24, this.clientType);
    }
    if (this.clientVersion != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(25, this.clientVersion);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.BroadcastPersonGift
 * JD-Core Version:    0.7.0.1
 */