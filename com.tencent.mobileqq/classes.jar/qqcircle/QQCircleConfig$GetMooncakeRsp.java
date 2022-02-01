package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleConfig$GetMooncakeRsp
  extends MessageMicro<GetMooncakeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "allowLongVideo", "videoLength", "nextTimeInterval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetMooncakeRsp.class);
  public final PBInt32Field allowLongVideo = PBField.initInt32(0);
  public final PBInt32Field nextTimeInterval = PBField.initInt32(0);
  public final PBInt32Field videoLength = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetMooncakeRsp
 * JD-Core Version:    0.7.0.1
 */