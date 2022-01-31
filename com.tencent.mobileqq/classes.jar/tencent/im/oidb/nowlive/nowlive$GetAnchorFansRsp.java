package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nowlive$GetAnchorFansRsp
  extends MessageMicro<GetAnchorFansRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "anchor_info" }, new Object[] { Integer.valueOf(0), "", null }, GetAnchorFansRsp.class);
  public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.GetAnchorFansRsp
 * JD-Core Version:    0.7.0.1
 */