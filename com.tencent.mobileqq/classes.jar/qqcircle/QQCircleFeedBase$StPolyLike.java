package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StPolyLike
  extends MessageMicro<StPolyLike>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "polyLikeID", "polyName", "polySource", "polyIconUrl", "count", "polyUnderPicUrl" }, new Object[] { "", "", "", "", Integer.valueOf(0), "" }, StPolyLike.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField polyIconUrl = PBField.initString("");
  public final PBStringField polyLikeID = PBField.initString("");
  public final PBStringField polyName = PBField.initString("");
  public final PBStringField polySource = PBField.initString("");
  public final PBStringField polyUnderPicUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StPolyLike
 * JD-Core Version:    0.7.0.1
 */