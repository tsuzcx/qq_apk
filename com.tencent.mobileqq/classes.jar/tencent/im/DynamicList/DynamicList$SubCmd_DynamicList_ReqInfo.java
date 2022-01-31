package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicList$SubCmd_DynamicList_ReqInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "SubCmd_Req", "reqEvent" }, new Object[] { null, Integer.valueOf(0) }, SubCmd_DynamicList_ReqInfo.class);
  public final PBRepeatMessageField SubCmd_Req = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Req.class);
  public final PBUInt32Field reqEvent = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicList.DynamicList.SubCmd_DynamicList_ReqInfo
 * JD-Core Version:    0.7.0.1
 */