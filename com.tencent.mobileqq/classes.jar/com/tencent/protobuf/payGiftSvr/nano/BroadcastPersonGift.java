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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BroadcastPersonGift[0];
        }
      }
    }
    return _emptyArray;
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
    i = this.comboSeq;
    k = j;
    if (i != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(10, i);
    }
    j = this.comboCount;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(11, j);
    }
    Object localObject = this.iLiveGiftSites;
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.iLiveGiftSites;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
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
    l = this.logoTimestamp;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(14, l);
    }
    l = this.charm;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(15, l);
    }
    j = i;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(16, this.msgTransparent);
    }
    i = j;
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(17, this.logoFullUrl);
    }
    k = this.fromType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(18, k);
    }
    l = this.playUid;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(19, l);
    }
    i = k;
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(20, this.playNickname);
    }
    localObject = this.msgComTrans;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
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
            j = i + CodedOutputByteBufferNano.computeMessageSize(21, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    k = j;
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(22, this.userBusinessUid);
    }
    j = this.clientType;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(24, j);
    }
    k = this.clientVersion;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(25, k);
    }
    return j;
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
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 200: 
        this.clientVersion = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 192: 
        this.clientType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 178: 
        this.userBusinessUid = paramCodedInputByteBufferNano.readBytes();
        break;
      case 170: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 170);
        localObject = this.msgComTrans;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.msgComTrans = ((TransparentMsg[])localObject);
        break;
      case 162: 
        this.playNickname = paramCodedInputByteBufferNano.readBytes();
        break;
      case 152: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 144: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 138: 
        this.logoFullUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 130: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      case 120: 
        this.charm = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 112: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 98: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        localObject = this.iLiveGiftSites;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new ILiveGiftSite();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.iLiveGiftSites = ((ILiveGiftSite[])localObject);
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
    Object localObject = this.iLiveGiftSites;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.iLiveGiftSites;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.headKey);
    }
    l = this.logoTimestamp;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(14, l);
    }
    l = this.charm;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, l);
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.msgTransparent);
    }
    if (!Arrays.equals(this.logoFullUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.logoFullUrl);
    }
    i = this.fromType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(18, i);
    }
    l = this.playUid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(19, l);
    }
    if (!Arrays.equals(this.playNickname, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.playNickname);
    }
    localObject = this.msgComTrans;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.msgComTrans;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(21, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.userBusinessUid, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(22, this.userBusinessUid);
    }
    i = this.clientType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(24, i);
    }
    i = this.clientVersion;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(25, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.BroadcastPersonGift
 * JD-Core Version:    0.7.0.1
 */