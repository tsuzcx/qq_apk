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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GivePayOverReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.anchorUin) + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(3, this.subRoomId) + CodedOutputByteBufferNano.computeUInt32Size(4, this.giftId);
    int k = this.fromType;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    k = this.comboSeq;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    k = this.comboCount;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    j = i;
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(8, this.headKey);
    }
    long l = this.logoTimestamp;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(9, l);
    }
    j = i;
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(10, this.imei);
    }
    l = this.playUid;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(11, l);
    }
    i = k;
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(12, this.msgTransparent);
    }
    Object localObject = this.msgComTrans;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
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
            k = i + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public GivePayOverReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
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
      case 98: 
        this.msgTransparent = paramCodedInputByteBufferNano.readBytes();
        break;
      case 88: 
        this.playUid = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 82: 
        this.imei = paramCodedInputByteBufferNano.readBytes();
        break;
      case 72: 
        this.logoTimestamp = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 66: 
        this.headKey = paramCodedInputByteBufferNano.readBytes();
        break;
      case 56: 
        this.comboCount = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.comboSeq = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.fromType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
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
    paramCodedOutputByteBufferNano.writeUInt32(4, this.giftId);
    int i = this.fromType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.comboSeq;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    i = this.comboCount;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    if (!Arrays.equals(this.headKey, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.headKey);
    }
    long l = this.logoTimestamp;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(9, l);
    }
    if (!Arrays.equals(this.imei, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.imei);
    }
    l = this.playUid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, l);
    }
    if (!Arrays.equals(this.msgTransparent, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(12, this.msgTransparent);
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
          paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayOverReq
 * JD-Core Version:    0.7.0.1
 */