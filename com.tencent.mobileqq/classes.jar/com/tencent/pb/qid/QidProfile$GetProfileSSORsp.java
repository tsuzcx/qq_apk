package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QidProfile$GetProfileSSORsp
  extends MessageMicro<GetProfileSSORsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "is_set", "pag_url", "pic_url", "bg_url", "main_url", "btn_color", "is_lm_show", "qid" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "" }, GetProfileSSORsp.class);
  public final PBStringField bg_url = PBField.initString("");
  public final PBStringField btn_color = PBField.initString("");
  public final PBInt32Field is_lm_show = PBField.initInt32(0);
  public final PBInt32Field is_set = PBField.initInt32(0);
  public final PBStringField main_url = PBField.initString("");
  public final PBStringField pag_url = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField qid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.qid.QidProfile.GetProfileSSORsp
 * JD-Core Version:    0.7.0.1
 */