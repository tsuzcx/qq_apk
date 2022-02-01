package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$HistoryDetail
  extends MessageMicro<HistoryDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBUInt32Field run = PBField.initUInt32(0);
  public final PBUInt32Field walk = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "date", "run", "walk", "duration" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, HistoryDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind.HistoryDetail
 * JD-Core Version:    0.7.0.1
 */