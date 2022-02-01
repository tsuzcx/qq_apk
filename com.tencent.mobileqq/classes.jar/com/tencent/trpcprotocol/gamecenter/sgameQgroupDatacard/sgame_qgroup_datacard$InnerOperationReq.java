package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class sgame_qgroup_datacard$InnerOperationReq
  extends MessageMicro<InnerOperationReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "delUinList", "delGroupIdList", "queryUinList", "queryGroupIdList", "queryGroupRankList" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, InnerOperationReq.class);
  public final PBRepeatField<Long> delGroupIdList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> delUinList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> queryGroupIdList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> queryGroupRankList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> queryUinList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.InnerOperationReq
 * JD-Core Version:    0.7.0.1
 */