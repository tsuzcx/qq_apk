package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicList$SubCmd_DynamicItem_Req
  extends MessageMicro<SubCmd_DynamicItem_Req>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uiNewVer = PBField.initUInt32(0);
  public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
  public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uiPluginID", "uiNewVer", "uiOpenFlag" }, new Object[] { localInteger, localInteger, localInteger }, SubCmd_DynamicItem_Req.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.DynamicList.DynamicList.SubCmd_DynamicItem_Req
 * JD-Core Version:    0.7.0.1
 */