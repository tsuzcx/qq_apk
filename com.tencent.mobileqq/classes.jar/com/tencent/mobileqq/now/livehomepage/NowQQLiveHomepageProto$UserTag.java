package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$UserTag
  extends MessageMicro<UserTag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField background_pic_url = PBField.initString("");
  public final PBStringField change_color = PBField.initString("");
  public final PBUInt32Field color = PBField.initUInt32(0);
  public final PBStringField pic_url = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50 }, new String[] { "pic_url", "wording", "color", "change_color", "type", "background_pic_url" }, new Object[] { "", "", localInteger, "", localInteger, "" }, UserTag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserTag
 * JD-Core Version:    0.7.0.1
 */