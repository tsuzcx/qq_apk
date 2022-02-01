package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GivePayOverReq
  extends MessageNano
{
  private static volatile GivePayOverReq[] _emptyArray;
  public long anchorUin;
  public int comboCount;
  public int comboSeq;
  public int fromType;
  public int giftId;
  public byte[] headKey;
  public byte[] imei;
  public long logoTimestamp;
  public TransparentMsg[] msgComTrans;
  public byte[] msgTransparent;
  public long playUid;
  public long roomId;
  public long subRoomId;
  
  public GivePayOverReq()
  {
    clear();
  }
  
  public static GivePayOverReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GivePayOverReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static GivePayOverReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GivePayOverReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GivePayOverReq parseFrom(byte[] paramArrayOfByte)
  {
    return (GivePayOverReq)MessageNano.mergeFrom(new GivePayOverReq(), paramArrayOfByte);
  }
  
  public GivePayOverReq clear()
  {
    this.anchorUin = 0L;
    this.roomId = 0L;
    this.subRoomId = 0L;
    this.giftId = 0;
    this.fromType = 0;
    this.comboSeq = 0;
    this.comboCount = 0;
    this.headKey = WireFormatNano.EMPTY_BYTES;
    this.logoTimestamp = 0L;
    this.imei = WireFormatNano.EMPTY_BYTES;
    this.playUid = 0L;
    this.msgTransparent = WireFormatNano.EMPTY_BYTES;
    this.msgComTrans = TransparentMsg.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.anchorUin) + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(3, this.subRoomId) + CodedOutputByteBufferNano.computeUInt32Size(4, this.giftId);
    int i = j;
    if (this.fromType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.fromType);
    }
    j = i;
    if (this.comboSeq != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, this.comboSeq);
    }
    i = j;
    if (this.comboCount != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.comboCount);
    }
    j = i;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(8, this.headKey);
    }
    i = j;
    if (this.logoTimestamp != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(9, this.logoTimestamp);
    }
    j = i;
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(10, this.imei);
    }
    int k = j;
    if (this.playUid != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(11, this.playUid);
    }
    i = k;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(12, this.msgTransparent);
    }
    j = i;
    if (this.msgComTrans != null)
    {
      j = i;
      if (this.msgComTrans.length > 0)
      {
        j = 0;
        while (j < this.msgComTrans.length)
        {
          TransparentMsg localTransparentMsg = this.msgComTrans[j];
          k = i;
          if (localTransparentMsg != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(13, localTransparentMsg);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public GivePayOverReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.anchorUin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 66: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 72: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 82: 
        this.imei = paramCodedInputByteBufferNano.readBytes();
        break;
      case 88: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 98: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
      if (this.msgComTrans == null) {}
      TransparentMsg[] arrayOfTransparentMsg;
      for (i = 0;; i = this.msgComTrans.length)
      {
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
      }
      arrayOfTransparentMsg[j] = new TransparentMsg();
      paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[j]);
      this.msgComTrans = arrayOfTransparentMsg;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.anchorUin);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.roomId);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.subRoomId);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.giftId);
    if (this.fromType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.fromType);
    }
    if (this.comboSeq != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.comboSeq);
    }
    if (this.comboCount != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.comboCount);
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.headKey);
    }
    if (this.logoTimestamp != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(9, this.logoTimestamp);
    }
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.imei);
    }
    if (this.playUid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, this.playUid);
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(12, this.msgTransparent);
    }
    if ((this.msgComTrans != null) && (this.msgComTrans.length > 0))
    {
      int i = 0;
      while (i < this.msgComTrans.length)
      {
        TransparentMsg localTransparentMsg = this.msgComTrans[i];
        if (localTransparentMsg != null) {
          paramCodedOutputByteBufferNano.writeMessage(13, localTransparentMsg);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayOverReq
 * JD-Core Version:    0.7.0.1
 */