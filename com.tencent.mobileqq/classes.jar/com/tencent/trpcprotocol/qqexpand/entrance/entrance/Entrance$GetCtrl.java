package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Entrance$GetCtrl
  extends MessageMicro<GetCtrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "allow_force_fresh", "get_interval_ms" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, GetCtrl.class);
  public final PBBoolField allow_force_fresh = PBField.initBool(false);
  public final PBUInt32Field get_interval_ms = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.GetCtrl
 * JD-Core Version:    0.7.0.1
 */