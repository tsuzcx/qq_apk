package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GiftInfoRsp
  extends MessageNano
{
  private static volatile GiftInfoRsp[] _emptyArray;
  public byte[] activeIcon;
  public byte[] apngUrl;
  public int beginTs;
  public int belong;
  public byte[] bigIcon;
  public GiftNewEffect[] clickEffectList;
  public byte[] comment;
  public int defaultNum;
  public String diplayWord;
  public byte[] displayConfig;
  public boolean displayGiftName;
  public boolean displayIcon;
  public int displayType;
  public byte[] effectId;
  public int effectType;
  public int endTs;
  public int friendScence;
  public String giftComment;
  public GiftEffect[] giftEffectList;
  public int giftId;
  public byte[] giftName;
  public long giftScene;
  public int giftType;
  public int giftUsage;
  public int hideGiftType;
  public int isLocked;
  public byte[] middleIcon;
  public TransMsg[] multiTransMsg;
  public GiftNewEffect[] newEffectList;
  public int nobelType;
  public int price;
  public int priceUnit;
  public int priority;
  public byte[] resourcePack;
  public byte[] smallIcon;
  public SpecialNumber[] specialNumList;
  public int speed;
  public int style;
  public int timestamp;
  public int visible;
  
  public GiftInfoRsp()
  {
    clear();
  }
  
  public static GiftInfoRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GiftInfoRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static GiftInfoRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GiftInfoRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GiftInfoRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (GiftInfoRsp)MessageNano.mergeFrom(new GiftInfoRsp(), paramArrayOfByte);
  }
  
  public GiftInfoRsp clear()
  {
    this.giftId = 0;
    this.giftName = WireFormatNano.EMPTY_BYTES;
    this.price = 0;
    this.displayType = 0;
    this.timestamp = 0;
    this.giftType = 0;
    this.defaultNum = 0;
    this.priority = 0;
    this.smallIcon = WireFormatNano.EMPTY_BYTES;
    this.bigIcon = WireFormatNano.EMPTY_BYTES;
    this.comment = WireFormatNano.EMPTY_BYTES;
    this.giftEffectList = GiftEffect.emptyArray();
    this.specialNumList = SpecialNumber.emptyArray();
    this.resourcePack = WireFormatNano.EMPTY_BYTES;
    this.style = 0;
    this.speed = 0;
    this.effectId = WireFormatNano.EMPTY_BYTES;
    this.apngUrl = WireFormatNano.EMPTY_BYTES;
    this.newEffectList = GiftNewEffect.emptyArray();
    this.activeIcon = WireFormatNano.EMPTY_BYTES;
    this.nobelType = 0;
    this.effectType = 0;
    this.giftScene = 0L;
    this.giftComment = "";
    this.displayIcon = false;
    this.displayGiftName = false;
    this.diplayWord = "";
    this.middleIcon = WireFormatNano.EMPTY_BYTES;
    this.hideGiftType = 0;
    this.belong = 0;
    this.beginTs = 0;
    this.endTs = 0;
    this.clickEffectList = GiftNewEffect.emptyArray();
    this.isLocked = 0;
    this.friendScence = 0;
    this.visible = 0;
    this.displayConfig = WireFormatNano.EMPTY_BYTES;
    this.giftUsage = 0;
    this.priceUnit = 1;
    this.multiTransMsg = TransMsg.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId) + CodedOutputByteBufferNano.computeBytesSize(2, this.giftName) + CodedOutputByteBufferNano.computeUInt32Size(3, this.price) + CodedOutputByteBufferNano.computeUInt32Size(4, this.displayType) + CodedOutputByteBufferNano.computeUInt32Size(5, this.timestamp);
    int i = j;
    if (this.giftType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(6, this.giftType);
    }
    j = i;
    if (this.defaultNum != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(7, this.defaultNum);
    }
    i = j;
    if (this.priority != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(8, this.priority);
    }
    j = i;
    if (!Arrays.equals(this.smallIcon, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(9, this.smallIcon);
    }
    int k = j;
    if (!Arrays.equals(this.bigIcon, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(10, this.bigIcon);
    }
    i = k;
    if (!Arrays.equals(this.comment, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(11, this.comment);
    }
    j = i;
    Object localObject;
    if (this.giftEffectList != null)
    {
      j = i;
      if (this.giftEffectList.length > 0)
      {
        j = 0;
        while (j < this.giftEffectList.length)
        {
          localObject = this.giftEffectList[j];
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
    if (this.specialNumList != null)
    {
      i = j;
      if (this.specialNumList.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.specialNumList.length)
        {
          localObject = this.specialNumList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (!Arrays.equals(this.resourcePack, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(14, this.resourcePack);
    }
    i = j;
    if (this.style != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(15, this.style);
    }
    j = i;
    if (this.speed != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(16, this.speed);
    }
    k = j;
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(17, this.effectId);
    }
    i = k;
    if (!Arrays.equals(this.apngUrl, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(18, this.apngUrl);
    }
    j = i;
    if (this.newEffectList != null)
    {
      j = i;
      if (this.newEffectList.length > 0)
      {
        j = 0;
        while (j < this.newEffectList.length)
        {
          localObject = this.newEffectList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(19, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!Arrays.equals(this.activeIcon, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(20, this.activeIcon);
    }
    j = i;
    if (this.nobelType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(21, this.nobelType);
    }
    i = j;
    if (this.effectType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(22, this.effectType);
    }
    j = i;
    if (this.giftScene != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(23, this.giftScene);
    }
    i = j;
    if (!this.giftComment.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(24, this.giftComment);
    }
    j = i;
    if (this.displayIcon) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(25, this.displayIcon);
    }
    i = j;
    if (this.displayGiftName) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(26, this.displayGiftName);
    }
    j = i;
    if (!this.diplayWord.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(27, this.diplayWord);
    }
    i = j;
    if (!Arrays.equals(this.middleIcon, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(28, this.middleIcon);
    }
    j = i;
    if (this.hideGiftType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(29, this.hideGiftType);
    }
    i = j;
    if (this.belong != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(30, this.belong);
    }
    j = i;
    if (this.beginTs != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(31, this.beginTs);
    }
    i = j;
    if (this.endTs != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(32, this.endTs);
    }
    j = i;
    if (this.clickEffectList != null)
    {
      j = i;
      if (this.clickEffectList.length > 0)
      {
        j = 0;
        while (j < this.clickEffectList.length)
        {
          localObject = this.clickEffectList[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(33, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.isLocked != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(34, this.isLocked);
    }
    j = i;
    if (this.friendScence != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(35, this.friendScence);
    }
    i = j;
    if (this.visible != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(36, this.visible);
    }
    j = i;
    if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(37, this.displayConfig);
    }
    k = j;
    if (this.giftUsage != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(38, this.giftUsage);
    }
    i = k;
    if (this.priceUnit != 1) {
      i = k + CodedOutputByteBufferNano.computeInt32Size(39, this.priceUnit);
    }
    k = i;
    if (this.multiTransMsg != null)
    {
      k = i;
      if (this.multiTransMsg.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.multiTransMsg.length) {
            break;
          }
          localObject = this.multiTransMsg[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(40, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public GiftInfoRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.giftName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 24: 
        this.price = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.displayType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.timestamp = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.defaultNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.priority = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.smallIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 82: 
        this.bigIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 90: 
        this.comment = paramCodedInputByteBufferNano.readBytes();
        break;
      case 98: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        if (this.giftEffectList == null) {}
        for (i = 0;; i = this.giftEffectList.length)
        {
          localObject = new GiftEffect[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.giftEffectList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new GiftEffect();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new GiftEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.giftEffectList = ((GiftEffect[])localObject);
        break;
      case 106: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
        if (this.specialNumList == null) {}
        for (i = 0;; i = this.specialNumList.length)
        {
          localObject = new SpecialNumber[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.specialNumList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new SpecialNumber();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new SpecialNumber();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.specialNumList = ((SpecialNumber[])localObject);
        break;
      case 114: 
        this.resourcePack = paramCodedInputByteBufferNano.readBytes();
        break;
      case 120: 
        this.style = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 128: 
        this.speed = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 138: 
        this.effectId = paramCodedInputByteBufferNano.readBytes();
        break;
      case 146: 
        this.apngUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 154: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
        if (this.newEffectList == null) {}
        for (i = 0;; i = this.newEffectList.length)
        {
          localObject = new GiftNewEffect[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.newEffectList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new GiftNewEffect();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.newEffectList = ((GiftNewEffect[])localObject);
        break;
      case 162: 
        this.activeIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 168: 
        this.nobelType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 176: 
        this.effectType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 184: 
        this.giftScene = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 194: 
        this.giftComment = paramCodedInputByteBufferNano.readString();
        break;
      case 200: 
        this.displayIcon = paramCodedInputByteBufferNano.readBool();
        break;
      case 208: 
        this.displayGiftName = paramCodedInputByteBufferNano.readBool();
        break;
      case 218: 
        this.diplayWord = paramCodedInputByteBufferNano.readString();
        break;
      case 226: 
        this.middleIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 232: 
        this.hideGiftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 240: 
        this.belong = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 248: 
        this.beginTs = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 256: 
        this.endTs = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 266: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 266);
        if (this.clickEffectList == null) {}
        for (i = 0;; i = this.clickEffectList.length)
        {
          localObject = new GiftNewEffect[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.clickEffectList, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new GiftNewEffect();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.clickEffectList = ((GiftNewEffect[])localObject);
        break;
      case 272: 
        this.isLocked = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 280: 
        this.friendScence = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 288: 
        this.visible = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 298: 
        this.displayConfig = paramCodedInputByteBufferNano.readBytes();
        break;
      case 304: 
        this.giftUsage = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 312: 
        i = paramCodedInputByteBufferNano.readInt32();
        switch (i)
        {
        default: 
          break;
        }
        this.priceUnit = i;
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 322);
      if (this.multiTransMsg == null) {}
      for (i = 0;; i = this.multiTransMsg.length)
      {
        localObject = new TransMsg[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.multiTransMsg, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new TransMsg();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      localObject[j] = new TransMsg();
      paramCodedInputByteBufferNano.readMessage(localObject[j]);
      this.multiTransMsg = ((TransMsg[])localObject);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftId);
    paramCodedOutputByteBufferNano.writeBytes(2, this.giftName);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.price);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.displayType);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.timestamp);
    if (this.giftType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.giftType);
    }
    if (this.defaultNum != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.defaultNum);
    }
    if (this.priority != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.priority);
    }
    if (!Arrays.equals(this.smallIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.smallIcon);
    }
    if (!Arrays.equals(this.bigIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.bigIcon);
    }
    if (!Arrays.equals(this.comment, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.comment);
    }
    int i;
    Object localObject;
    if ((this.giftEffectList != null) && (this.giftEffectList.length > 0))
    {
      i = 0;
      while (i < this.giftEffectList.length)
      {
        localObject = this.giftEffectList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if ((this.specialNumList != null) && (this.specialNumList.length > 0))
    {
      i = 0;
      while (i < this.specialNumList.length)
      {
        localObject = this.specialNumList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.resourcePack, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(14, this.resourcePack);
    }
    if (this.style != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(15, this.style);
    }
    if (this.speed != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, this.speed);
    }
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.effectId);
    }
    if (!Arrays.equals(this.apngUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(18, this.apngUrl);
    }
    if ((this.newEffectList != null) && (this.newEffectList.length > 0))
    {
      i = 0;
      while (i < this.newEffectList.length)
      {
        localObject = this.newEffectList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(19, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.activeIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.activeIcon);
    }
    if (this.nobelType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(21, this.nobelType);
    }
    if (this.effectType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(22, this.effectType);
    }
    if (this.giftScene != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(23, this.giftScene);
    }
    if (!this.giftComment.equals("")) {
      paramCodedOutputByteBufferNano.writeString(24, this.giftComment);
    }
    if (this.displayIcon) {
      paramCodedOutputByteBufferNano.writeBool(25, this.displayIcon);
    }
    if (this.displayGiftName) {
      paramCodedOutputByteBufferNano.writeBool(26, this.displayGiftName);
    }
    if (!this.diplayWord.equals("")) {
      paramCodedOutputByteBufferNano.writeString(27, this.diplayWord);
    }
    if (!Arrays.equals(this.middleIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(28, this.middleIcon);
    }
    if (this.hideGiftType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(29, this.hideGiftType);
    }
    if (this.belong != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(30, this.belong);
    }
    if (this.beginTs != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(31, this.beginTs);
    }
    if (this.endTs != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(32, this.endTs);
    }
    if ((this.clickEffectList != null) && (this.clickEffectList.length > 0))
    {
      i = 0;
      while (i < this.clickEffectList.length)
      {
        localObject = this.clickEffectList[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(33, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (this.isLocked != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(34, this.isLocked);
    }
    if (this.friendScence != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(35, this.friendScence);
    }
    if (this.visible != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(36, this.visible);
    }
    if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(37, this.displayConfig);
    }
    if (this.giftUsage != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(38, this.giftUsage);
    }
    if (this.priceUnit != 1) {
      paramCodedOutputByteBufferNano.writeInt32(39, this.priceUnit);
    }
    if ((this.multiTransMsg != null) && (this.multiTransMsg.length > 0))
    {
      i = j;
      while (i < this.multiTransMsg.length)
      {
        localObject = this.multiTransMsg[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(40, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.GiftInfoRsp
 * JD-Core Version:    0.7.0.1
 */