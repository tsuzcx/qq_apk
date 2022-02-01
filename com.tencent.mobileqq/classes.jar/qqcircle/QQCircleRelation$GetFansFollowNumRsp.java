package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleRelation$GetFansFollowNumRsp
  extends MessageMicro<GetFansFollowNumRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field fansNum = PBField.initInt64(0L);
  public final PBInt64Field followNum = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "fansNum", "followNum" }, new Object[] { localLong, localLong }, GetFansFollowNumRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRelation.GetFansFollowNumRsp
 * JD-Core Version:    0.7.0.1
 */