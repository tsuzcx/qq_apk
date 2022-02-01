package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_push_msgInfo$STPushMsgElem$STPushMsgElem0x3
  extends MessageMicro<STPushMsgElem0x3>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField actId = PBField.initString("");
  public final PBUInt32Field begTs = PBField.initUInt32(0);
  public final PBUInt32Field busId = PBField.initUInt32(0);
  public final PBUInt32Field busType = PBField.initUInt32(0);
  public final PBUInt32Field dotId = PBField.initUInt32(0);
  public final PBUInt32Field endTs = PBField.initUInt32(0);
  public final PBStringField folderIconUrl = PBField.initString("");
  public final PBUInt32Field priority = PBField.initUInt32(0);
  public final PBUInt32Field spRegion = PBField.initUInt32(0);
  public final PBStringField theme = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74, 82, 88, 98 }, new String[] { "busType", "busId", "dotId", "priority", "begTs", "endTs", "wording", "url", "theme", "actId", "spRegion", "folderIconUrl" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", "", "", "", localInteger, "" }, STPushMsgElem0x3.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3
 * JD-Core Version:    0.7.0.1
 */