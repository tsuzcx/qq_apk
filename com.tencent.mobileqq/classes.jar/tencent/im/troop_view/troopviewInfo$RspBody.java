package tencent.im.troop_view;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;

public final class troopviewInfo$RspBody
  extends MessageMicro<RspBody>
{
  public static final int POPRSB_FIELD_NUMBER = 1;
  public static final int SEARCHRSB_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "popRsb", "searchRsb" }, new Object[] { null, null }, RspBody.class);
  public popclassifc.RspBody popRsb = new popclassifc.RspBody();
  public searchtab.RspBody searchRsb = new searchtab.RspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.troop_view.troopviewInfo.RspBody
 * JD-Core Version:    0.7.0.1
 */