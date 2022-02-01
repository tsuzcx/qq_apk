package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class sgame_qgroup_datacard$QueryGroupInfoRsp
  extends MessageMicro<QueryGroupInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field fightScore = PBField.initInt64(0L);
  public final PBDoubleField fightScoreRank = PBField.initDouble(0.0D);
  public final PBRepeatMessageField<sgame_qgroup_datacard.GradeDistributed> gradeDistributedList = PBField.initRepeatMessage(sgame_qgroup_datacard.GradeDistributed.class);
  public final PBInt64Field weekPlayGameCount = PBField.initInt64(0L);
  public final PBInt64Field weekPlayUserCount = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 41, 48, 56 }, new String[] { "gradeDistributedList", "fightScore", "fightScoreRank", "weekPlayGameCount", "weekPlayUserCount" }, new Object[] { null, localLong, Double.valueOf(0.0D), localLong, localLong }, QueryGroupInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupInfoRsp
 * JD-Core Version:    0.7.0.1
 */