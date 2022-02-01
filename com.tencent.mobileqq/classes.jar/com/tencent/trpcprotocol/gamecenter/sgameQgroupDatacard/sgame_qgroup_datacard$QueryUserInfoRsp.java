package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class sgame_qgroup_datacard$QueryUserInfoRsp
  extends MessageMicro<QueryUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField area = PBField.initString("");
  public final PBRepeatMessageField<sgame_qgroup_datacard.UserHeroInfo> bestHeroList = PBField.initRepeatMessage(sgame_qgroup_datacard.UserHeroInfo.class);
  public final PBEnumField bestOccupation = PBField.initEnum(0);
  public final PBStringField encrptOpenId = PBField.initString("");
  public final PBInt64Field gamesTotal = PBField.initInt64(0L);
  public final PBEnumField grade = PBField.initEnum(0);
  public final PBInt64Field mvpTotal = PBField.initInt64(0L);
  public final PBStringField partition = PBField.initString("");
  public final PBStringField platid = PBField.initString("");
  public final PBDoubleField seasonWinRate = PBField.initDouble(0.0D);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 24, 32, 40, 58, 66, 74, 82, 90 }, new String[] { "grade", "seasonWinRate", "gamesTotal", "mvpTotal", "bestOccupation", "bestHeroList", "encrptOpenId", "partition", "platid", "area" }, new Object[] { localInteger, Double.valueOf(0.0D), localLong, localLong, localInteger, null, "", "", "", "" }, QueryUserInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */