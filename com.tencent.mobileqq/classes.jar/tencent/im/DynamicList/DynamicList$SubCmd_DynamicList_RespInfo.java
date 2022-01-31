package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicList$SubCmd_DynamicList_RespInfo
  extends MessageMicro<SubCmd_DynamicList_RespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uiReturnCode", "SubCmd_Resp_Add", "SubCmd_Resp_Modify", "SubCmd_Resp_Delete" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, SubCmd_DynamicList_RespInfo.class);
  public final PBRepeatMessageField<DynamicList.SubCmd_DynamicItem_Resp> SubCmd_Resp_Add = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Resp.class);
  public final PBRepeatField<Integer> SubCmd_Resp_Delete = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<DynamicList.SubCmd_DynamicItem_Resp> SubCmd_Resp_Modify = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Resp.class);
  public final PBUInt32Field uiReturnCode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.DynamicList.DynamicList.SubCmd_DynamicList_RespInfo
 * JD-Core Version:    0.7.0.1
 */