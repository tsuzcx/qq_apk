package tencent.im.storage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.RichText;

public final class wording_storage$WordingCfg
  extends MessageMicro<WordingCfg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
  public final PBUInt32Field select_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<im_msg_body.RichText> wording_list = PBField.initRepeatMessage(im_msg_body.RichText.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "auto_reply_flag", "select_id", "wording_list" }, new Object[] { localInteger, localInteger, null }, WordingCfg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.storage.wording_storage.WordingCfg
 * JD-Core Version:    0.7.0.1
 */