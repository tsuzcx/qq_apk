package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc90$CommunityWebInfo
  extends MessageMicro<CommunityWebInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_community_info_item", "uint32_page", "uint32_end" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, CommunityWebInfo.class);
  public final PBRepeatMessageField<oidb_0xc90.CommunityConfigInfo> rpt_community_info_item = PBField.initRepeatMessage(oidb_0xc90.CommunityConfigInfo.class);
  public final PBUInt32Field uint32_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc90.CommunityWebInfo
 * JD-Core Version:    0.7.0.1
 */