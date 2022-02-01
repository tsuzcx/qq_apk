package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleDitto$StCircleDittoDataNew
  extends MessageMicro<StCircleDittoDataNew>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "itemContainter", "singlePicBanner", "dividingLine", "multiItemContainter", "flipCard", "picTextBanner" }, new Object[] { null, null, null, null, null, null }, StCircleDittoDataNew.class);
  public QQCircleDitto.StDividingLine dividingLine = new QQCircleDitto.StDividingLine();
  public QQCircleDitto.StFlipCard flipCard = new QQCircleDitto.StFlipCard();
  public QQCircleDitto.StItemContainer itemContainter = new QQCircleDitto.StItemContainer();
  public final PBRepeatMessageField<QQCircleDitto.StItemContainer> multiItemContainter = PBField.initRepeatMessage(QQCircleDitto.StItemContainer.class);
  public QQCircleDitto.StPicTextBanner picTextBanner = new QQCircleDitto.StPicTextBanner();
  public QQCircleDitto.StSinglePicBanner singlePicBanner = new QQCircleDitto.StSinglePicBanner();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StCircleDittoDataNew
 * JD-Core Version:    0.7.0.1
 */