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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GivePayGiftReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.anchorUin) + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(3, this.subRoomId) + CodedOutputByteBufferNano.computeUInt32Size(4, this.giftType) + CodedOutputByteBufferNano.computeUInt32Size(5, this.giftId) + CodedOutputByteBufferNano.computeUInt32Size(6, this.giftNum);
    int k = this.fromType;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    long l = this.fromWhere;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    k = this.comboSeq;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(9, k);
    }
    k = this.comboCount;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    i = j;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(11, this.headKey);
    }
    l = this.logoTimestamp;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(12, l);
    }
    i = j;
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(13, this.imei);
    }
    k = this.refererId;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(14, k);
    }
    l = this.playUid;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(15, l);
    }
    j = i;
    if (!this.billNo.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(16, this.billNo);
    }
    i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(17, this.programId);
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
    localObject = this.msgComTrans;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.msgComTrans;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
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
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 162: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 162);
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
      case 154: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      case 146: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
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
      case 138: 
        this.programId = paramCodedInputByteBufferNano.readString();
        break;
      case 130: 
        this.billNo = paramCodedInputByteBufferNano.readString();
        break;
      case 120: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 112: 
        this.refererId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.imei = paramCodedInputByteBufferNano.readBytes();
        break;
      case 96: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 90: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 80: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.fromWhere = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.anchorUin = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.anchorUin);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.roomId);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.subRoomId);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.giftType);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.giftId);
    paramCodedOutputByteBufferNano.writeUInt32(6, this.giftNum);
    int i = this.fromType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    long l = this.fromWhere;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    i = this.comboSeq;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i);
    }
    i = this.comboCount;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.headKey);
    }
    l = this.logoTimestamp;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l);
    }
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.imei);
    }
    i = this.refererId;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i);
    }
    l = this.playUid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, l);
    }
    if (!this.billNo.equals("")) {
      paramCodedOutputByteBufferNano.writeString(16, this.billNo);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(17, this.programId);
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
          paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(19, this.msgTransparent);
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
          paramCodedOutputByteBufferNano.writeMessage(20, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayGiftReq
 * JD-Core Version:    0.7.0.1
 */