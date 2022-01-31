package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$NearByShopsReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "lat", "lng", "coordinate", "begin", "limit", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NearByShopsReq.class);
  public final PBUInt32Field begin = PBField.initUInt32(0);
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBUInt32Field limit = PBField.initUInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.NearByShopsReq
 * JD-Core Version:    0.7.0.1
 */