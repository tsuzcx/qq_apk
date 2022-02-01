package com.tencent.pb.apollousertrace;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ApolloUserTrace$STClickInfo
  extends MessageMicro<STClickInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "posx", "posy", "rotx", "roty", "velx", "vely", "angularvel", "btnstate", "time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, STClickInfo.class);
  public final PBInt32Field angularvel = PBField.initInt32(0);
  public final PBUInt32Field btnstate = PBField.initUInt32(0);
  public final PBInt32Field posx = PBField.initInt32(0);
  public final PBInt32Field posy = PBField.initInt32(0);
  public final PBInt32Field rotx = PBField.initInt32(0);
  public final PBInt32Field roty = PBField.initInt32(0);
  public final PBUInt32Field time = PBField.initUInt32(0);
  public final PBInt32Field velx = PBField.initInt32(0);
  public final PBInt32Field vely = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo
 * JD-Core Version:    0.7.0.1
 */