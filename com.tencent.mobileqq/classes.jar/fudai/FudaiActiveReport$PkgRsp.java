package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FudaiActiveReport$PkgRsp
  extends MessageMicro<PkgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field batch_size = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "err_msg", "batch_size" }, new Object[] { localInteger, "", localInteger }, PkgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.FudaiActiveReport.PkgRsp
 * JD-Core Version:    0.7.0.1
 */