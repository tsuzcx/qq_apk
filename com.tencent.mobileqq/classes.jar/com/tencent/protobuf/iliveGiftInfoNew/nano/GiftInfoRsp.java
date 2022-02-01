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
  public int minVersion;
  public TransMsg[] multiTransMsg;
  public GiftNewEffect[] newEffectList;
  public int nobelType;
  public int originalPrice;
  public int price;
  public int priceUnit;
  public int priority;
  public byte[] resourcePack;
  public byte[] smallIcon;
  public SpecialNumber[] specialNumList;
  public int speed;
  public int style;
  public String tagUrl;
  public int timestamp;
  public int visible;
  
  public GiftInfoRsp()
  {
    clear();
  }
  
  public static GiftInfoRsp[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GiftInfoRsp[0];
        }
      }
    }
    return _emptyArray;
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
    this.minVersion = 0;
    this.originalPrice = 0;
    this.tagUrl = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId) + CodedOutputByteBufferNano.computeBytesSize(2, this.giftName) + CodedOutputByteBufferNano.computeUInt32Size(3, this.price) + CodedOutputByteBufferNano.computeUInt32Size(4, this.displayType) + CodedOutputByteBufferNano.computeUInt32Size(5, this.timestamp);
    int k = this.giftType;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    k = this.defaultNum;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    k = this.priority;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    j = i;
    if (!Arrays.equals(this.smallIcon, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(9, this.smallIcon);
    }
    k = j;
    if (!Arrays.equals(this.bigIcon, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(10, this.bigIcon);
    }
    i = k;
    if (!Arrays.equals(this.comment, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(11, this.comment);
    }
    Object localObject = this.giftEffectList;
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
          localObject = this.giftEffectList;
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
    localObject = this.specialNumList;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.specialNumList;
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
    j = i;
    if (!Arrays.equals(this.resourcePack, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(14, this.resourcePack);
    }
    k = this.style;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(15, k);
    }
    k = this.speed;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(16, k);
    }
    k = j;
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(17, this.effectId);
    }
    i = k;
    if (!Arrays.equals(this.apngUrl, WireFormatNano.EMPTY_BYTES)) {
      i = k + CodedOutputByteBufferNano.computeBytesSize(18, this.apngUrl);
    }
    localObject = this.newEffectList;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.newEffectList;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(19, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    j = k;
    if (!Arrays.equals(this.activeIcon, WireFormatNano.EMPTY_BYTES)) {
      j = k + CodedOutputByteBufferNano.computeBytesSize(20, this.activeIcon);
    }
    k = this.nobelType;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(21, k);
    }
    k = this.effectType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(22, k);
    }
    long l = this.giftScene;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(23, l);
    }
    j = i;
    if (!this.giftComment.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(24, this.giftComment);
    }
    boolean bool = this.displayIcon;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(25, bool);
    }
    bool = this.displayGiftName;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(26, bool);
    }
    i = j;
    if (!this.diplayWord.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(27, this.diplayWord);
    }
    j = i;
    if (!Arrays.equals(this.middleIcon, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(28, this.middleIcon);
    }
    k = this.hideGiftType;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(29, k);
    }
    k = this.belong;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(30, k);
    }
    i = this.beginTs;
    k = j;
    if (i != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(31, i);
    }
    j = this.endTs;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(32, j);
    }
    localObject = this.clickEffectList;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.clickEffectList;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
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
    k = this.isLocked;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(34, k);
    }
    k = this.friendScence;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(35, k);
    }
    k = this.visible;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(36, k);
    }
    k = i;
    if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
      k = i + CodedOutputByteBufferNano.computeBytesSize(37, this.displayConfig);
    }
    i = this.giftUsage;
    j = k;
    if (i != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(38, i);
    }
    k = this.priceUnit;
    i = j;
    if (k != 1) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(39, k);
    }
    localObject = this.multiTransMsg;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = m;
        for (;;)
        {
          localObject = this.multiTransMsg;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(40, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    k = this.minVersion;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(41, k);
    }
    k = this.originalPrice;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(42, k);
    }
    i = j;
    if (!this.tagUrl.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(43, this.tagUrl);
    }
    return i;
  }
  
  public GiftInfoRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 346: 
        this.tagUrl = paramCodedInputByteBufferNano.readString();
        break;
      case 336: 
        this.originalPrice = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 328: 
        this.minVersion = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 322: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 322);
        localObject = this.multiTransMsg;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new TransMsg();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.multiTransMsg = ((TransMsg[])localObject);
        break;
      case 312: 
        i = paramCodedInputByteBufferNano.readInt32();
        if ((i == 1) || (i == 2) || (i == 3) || (i == 4)) {
          this.priceUnit = i;
        }
        break;
      case 304: 
        this.giftUsage = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 298: 
        this.displayConfig = paramCodedInputByteBufferNano.readBytes();
        break;
      case 288: 
        this.visible = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 280: 
        this.friendScence = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 272: 
        this.isLocked = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 266: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 266);
        localObject = this.clickEffectList;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.clickEffectList = ((GiftNewEffect[])localObject);
        break;
      case 256: 
        this.endTs = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 248: 
        this.beginTs = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 240: 
        this.belong = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 232: 
        this.hideGiftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 226: 
        this.middleIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 218: 
        this.diplayWord = paramCodedInputByteBufferNano.readString();
        break;
      case 208: 
        this.displayGiftName = paramCodedInputByteBufferNano.readBool();
        break;
      case 200: 
        this.displayIcon = paramCodedInputByteBufferNano.readBool();
        break;
      case 194: 
        this.giftComment = paramCodedInputByteBufferNano.readString();
        break;
      case 184: 
        this.giftScene = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 176: 
        this.effectType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 168: 
        this.nobelType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 162: 
        this.activeIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 154: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
        localObject = this.newEffectList;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new GiftNewEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.newEffectList = ((GiftNewEffect[])localObject);
        break;
      case 146: 
        this.apngUrl = paramCodedInputByteBufferNano.readBytes();
        break;
      case 138: 
        this.effectId = paramCodedInputByteBufferNano.readBytes();
        break;
      case 128: 
        this.speed = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 120: 
        this.style = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 114: 
        this.resourcePack = paramCodedInputByteBufferNano.readBytes();
        break;
      case 106: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
        localObject = this.specialNumList;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new SpecialNumber();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.specialNumList = ((SpecialNumber[])localObject);
        break;
      case 98: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        localObject = this.giftEffectList;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
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
        localObject[j] = new GiftEffect();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.giftEffectList = ((GiftEffect[])localObject);
        break;
      case 90: 
        this.comment = paramCodedInputByteBufferNano.readBytes();
        break;
      case 82: 
        this.bigIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 74: 
        this.smallIcon = paramCodedInputByteBufferNano.readBytes();
        break;
      case 64: 
        this.priority = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.defaultNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.giftType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.timestamp = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.displayType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.price = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.giftName = paramCodedInputByteBufferNano.readBytes();
        break;
      case 8: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftId);
    paramCodedOutputByteBufferNano.writeBytes(2, this.giftName);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.price);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.displayType);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.timestamp);
    int i = this.giftType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    i = this.defaultNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    i = this.priority;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
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
    Object localObject = this.giftEffectList;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.giftEffectList;
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
    localObject = this.specialNumList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.specialNumList;
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
    if (!Arrays.equals(this.resourcePack, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(14, this.resourcePack);
    }
    i = this.style;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(15, i);
    }
    i = this.speed;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, i);
    }
    if (!Arrays.equals(this.effectId, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.effectId);
    }
    if (!Arrays.equals(this.apngUrl, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(18, this.apngUrl);
    }
    localObject = this.newEffectList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.newEffectList;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(19, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.activeIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.activeIcon);
    }
    i = this.nobelType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(21, i);
    }
    i = this.effectType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(22, i);
    }
    long l = this.giftScene;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(23, l);
    }
    if (!this.giftComment.equals("")) {
      paramCodedOutputByteBufferNano.writeString(24, this.giftComment);
    }
    boolean bool = this.displayIcon;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(25, bool);
    }
    bool = this.displayGiftName;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(26, bool);
    }
    if (!this.diplayWord.equals("")) {
      paramCodedOutputByteBufferNano.writeString(27, this.diplayWord);
    }
    if (!Arrays.equals(this.middleIcon, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(28, this.middleIcon);
    }
    i = this.hideGiftType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(29, i);
    }
    i = this.belong;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(30, i);
    }
    i = this.beginTs;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(31, i);
    }
    i = this.endTs;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(32, i);
    }
    localObject = this.clickEffectList;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.clickEffectList;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(33, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    i = this.isLocked;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(34, i);
    }
    i = this.friendScence;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(35, i);
    }
    i = this.visible;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(36, i);
    }
    if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(37, this.displayConfig);
    }
    i = this.giftUsage;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(38, i);
    }
    i = this.priceUnit;
    if (i != 1) {
      paramCodedOutputByteBufferNano.writeInt32(39, i);
    }
    localObject = this.multiTransMsg;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.multiTransMsg;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(40, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    i = this.minVersion;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(41, i);
    }
    i = this.originalPrice;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(42, i);
    }
    if (!this.tagUrl.equals("")) {
      paramCodedOutputByteBufferNano.writeString(43, this.tagUrl);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.GiftInfoRsp
 * JD-Core Version:    0.7.0.1
 */