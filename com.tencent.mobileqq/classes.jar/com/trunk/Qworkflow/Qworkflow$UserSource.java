package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$UserSource
  extends MessageMicro<UserSource>
{
  public static final int FROM_FRIEND = 3;
  public static final int FROM_GROUP = 1;
  public static final int FROM_GTALK = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_source_type", "uint64_source_code", "uint64_root_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, UserSource.class);
  public final PBEnumField enum_source_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_root_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.UserSource
 * JD-Core Version:    0.7.0.1
 */