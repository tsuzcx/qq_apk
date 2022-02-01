package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GivePayGiftReq
  extends MessageNano
{
  private static volatile GivePayGiftReq[] _emptyArray;
  public long anchorUin;
  public String billNo;
  public int comboCount;
  public int comboSeq;
  public int fromType;
  public long fromWhere;
  public int giftId;
  public int giftNum;
  public int giftType;
  public byte[] headKey;
  public ILiveGiftSite[] iLiveGiftSites;
  public byte[] imei;
  public long logoTimestamp;
  public TransparentMsg[] msgComTrans;
  public byte[] msgTransparent;
  public long playUid;
  public String programId;
  public int refererId;
  public long roomId;
  public long subRoomId;
  
  public GivePayGiftReq()
  {
    clear();
  }
  
  public static GivePayGiftReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GivePayGiftReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static GivePayGiftReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GivePayGiftReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GivePayGiftReq parseFrom(byte[] paramArrayOfByte)
  {
    return (GivePayGiftReq)MessageNano.mergeFrom(new GivePayGiftReq(), paramArrayOfByte);
  }
  
  public GivePayGiftReq clear()
  {
    this.anchorUin = 0L;
    this.roomId = 0L;
    this.subRoomId = 0L;
    this.giftType = 0;
    this.giftId = 0;
    this.giftNum = 0;
    this.fromType = 0;
    this.fromWhere = 0L;
    this.comboSeq = 0;
    this.comboCount = 0;
    this.headKey = WireFormatNano.EMPTY_BYTES;
    this.logoTimestamp = 0L;
    this.imei = WireFormatNano.EMPTY_BYTES;
    this.refererId = 0;
    this.playUid = 0L;
    this.billNo = "";
    this.programId = "";
    this.iLiveGiftSites = ILiveGiftSite.emptyArray();
    this.msgTransparent = WireFormatNano.EMPTY_BYTES;
    this.msgComTrans = TransparentMsg.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.anchorUin) + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(3, this.subRoomId) + CodedOutputByteBufferNano.computeUInt32Size(4, this.giftType) + CodedOutputByteBufferNano.computeUInt32Size(5, this.giftId) + CodedOutputByteBufferNano.computeUInt32Size(6, this.giftNum);
    int i = j;
    if (this.fromType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.fromType);
    }
    j = i;
    if (this.fromWhere != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(8, this.fromWhere);
    }
    i = j;
    if (this.comboSeq != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(9, this.comboSeq);
    }
    j = i;
    if (this.comboCount != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, this.comboCount);
    }
    i = j;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(11, this.headKey);
    }
    j = i;
    if (this.logoTimestamp != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(12, this.logoTimestamp);
    }
    i = j;
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(13, this.imei);
    }
    j = i;
    if (this.refererId != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(14, this.refererId);
    }
    i = j;
    if (this.playUid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(15, this.playUid);
    }
    j = i;
    if (!this.billNo.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(16, this.billNo);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(17, this.programId);
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
            k = i + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(19, this.msgTransparent);
    }
    int k = i;
    if (this.msgComTrans != null)
    {
      k = i;
      if (this.msgComTrans.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.msgComTrans.length) {
            break;
          }
          localObject = this.msgComTrans[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(20, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public GivePayGiftReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
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
        this.anchorUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.fromWhere = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 72: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 90: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 96: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        this.imei = paramCodedInputByteBufferNano.readBytes();
        break;
      case 112: 
        this.refererId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 120: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 130: 
        this.billNo = paramCodedInputByteBufferNano.readString();
        break;
      case 138: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 146: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
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
      case 154: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 162);
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
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    paramCodedOutputByteBufferNano.writeUInt64(1, this.anchorUin);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.roomId);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.subRoomId);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.giftType);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.giftId);
    paramCodedOutputByteBufferNano.writeUInt32(6, this.giftNum);
    if (this.fromType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.fromType);
    }
    if (this.fromWhere != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, this.fromWhere);
    }
    if (this.comboSeq != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, this.comboSeq);
    }
    if (this.comboCount != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.comboCount);
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.headKey);
    }
    if (this.logoTimestamp != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, this.logoTimestamp);
    }
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.imei);
    }
    if (this.refererId != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, this.refererId);
    }
    if (this.playUid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, this.playUid);
    }
    if (!this.billNo.equals("")) {
      paramCodedOutputByteBufferNano.writeString(16, this.billNo);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(17, this.programId);
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
          paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(19, this.msgTransparent);
    }
    if ((this.msgComTrans != null) && (this.msgComTrans.length > 0))
    {
      i = j;
      while (i < this.msgComTrans.length)
      {
        localObject = this.msgComTrans[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(20, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayGiftReq
 * JD-Core Version:    0.7.0.1
 */