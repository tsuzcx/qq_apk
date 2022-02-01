package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class STExploreInfo$STEntryIdInfo
  extends MessageMicro<STEntryIdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "entry_id", "num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STEntryIdInfo.class);
  public final PBInt32Field entry_id = PBField.initInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo.STEntryIdInfo
 * JD-Core Version:    0.7.0.1
 */