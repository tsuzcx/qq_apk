package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STCheckGame$STCheckGameRsp
  extends MessageMicro<STCheckGameRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adDevUin = PBField.initUInt64(0L);
  public final PBStringField adForbitPosId = PBField.initString("");
  public final PBInt32Field adShareRate = PBField.initInt32(0);
  public final PBUInt32Field appIdSource = PBField.initUInt32(0);
  public final PBUInt32Field commFlagBits = PBField.initUInt32(0);
  public final PBUInt32Field delayMs = PBField.initUInt32(0);
  public final PBUInt32Field expTs = PBField.initUInt32(0);
  public final PBBytesField extInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public STCheckGame.STGameConfInfo gameConfInfo = new STCheckGame.STGameConfInfo();
  public final PBUInt32Field isPatch = PBField.initUInt32(0);
  public final PBUInt32Field needGCoins = PBField.initUInt32(0);
  public final PBStringField openId = PBField.initString("");
  public final PBStringField openKey = PBField.initString("");
  public final PBUInt64Field packageSize = PBField.initUInt64(0L);
  public final PBBytesField patchContent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField patchUrl = PBField.initString("");
  public final PBUInt32Field remainPlays = PBField.initUInt32(0);
  public final PBStringField rpPic = PBField.initString("");
  public final PBStringField rpUrl = PBField.initString("");
  public final PBStringField sessionOpenId = PBField.initString("");
  public final PBStringField ssoCmdRule = PBField.initString("");
  public final PBStringField st = PBField.initString("");
  public final PBStringField stKey = PBField.initString("");
  public final PBUInt32Field svrResVer = PBField.initUInt32(0);
  public final PBUInt64Field tipsSize = PBField.initUInt64(0L);
  public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field updateFlag = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
  public final PBStringField wordingV2 = PBField.initString("");
  public final PBStringField zipMd5 = PBField.initString("");
  public final PBStringField zipUrl = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 106, 114, 122, 130, 136, 144, 152, 162, 170, 176, 184, 192, 200, 210, 218, 226, 232, 242, 402 }, new String[] { "st", "stKey", "expTs", "remainPlays", "wording", "openId", "openKey", "sessionOpenId", "needGCoins", "wordingV2", "updateFlag", "isPatch", "patchContent", "patchUrl", "zipMd5", "zipUrl", "svrResVer", "packageSize", "tipsSize", "ssoCmdRule", "extInfo", "appIdSource", "commFlagBits", "adDevUin", "adShareRate", "adForbitPosId", "rpUrl", "rpPic", "delayMs", "transInfo", "gameConfInfo" }, new Object[] { "", "", localInteger, localInteger, "", "", "", "", localInteger, "", localInteger, localInteger, localByteStringMicro1, "", "", "", localInteger, localLong, localLong, "", localByteStringMicro2, localInteger, localInteger, localLong, localInteger, "", "", "", localInteger, localByteStringMicro3, null }, STCheckGameRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.STCheckGame.STCheckGameRsp
 * JD-Core Version:    0.7.0.1
 */