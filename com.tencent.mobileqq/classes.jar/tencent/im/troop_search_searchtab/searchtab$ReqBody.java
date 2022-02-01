package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class searchtab$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "user_info", "uint32_label_style" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
  public userinfo.UserInfo user_info = new userinfo.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.ReqBody
 * JD-Core Version:    0.7.0.1
 */