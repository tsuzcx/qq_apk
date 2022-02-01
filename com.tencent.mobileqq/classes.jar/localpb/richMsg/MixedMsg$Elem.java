package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MixedMsg$Elem
  extends MessageMicro<Elem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "textMsg", "picMsg", "markfaceMsg", "sourceMsgInfo" }, new Object[] { "", null, null, "" }, Elem.class);
  public MarketFaceMsg.MarketFaceRec markfaceMsg = new MarketFaceMsg.MarketFaceRec();
  public RichMsg.PicRec picMsg = new RichMsg.PicRec();
  public final PBStringField sourceMsgInfo = PBField.initString("");
  public final PBStringField textMsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     localpb.richMsg.MixedMsg.Elem
 * JD-Core Version:    0.7.0.1
 */