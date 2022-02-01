package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class HwConfigPersistentPB$HwConfigPB
  extends MessageMicro<HwConfigPB>
{
  public static final int RPT_CONFIG_ITEM_LIST_FIELD_NUMBER = 1;
  public static final int RPT_CONFIG_ITEM_LIST_IP6_FIELD_NUMBER = 4;
  public static final int RPT_NET_SEG_CONF_LIST_FIELD_NUMBER = 2;
  public static final int RPT_SHORT_VIDEO_NET_CONF_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_config_item_list", "rpt_net_seg_conf_list", "rpt_short_video_net_conf", "rpt_config_item_list_ip6" }, new Object[] { null, null, null, null }, HwConfigPB.class);
  public final PBRepeatMessageField<HwConfigPersistentPB.HwConfigItemPB> rpt_config_item_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwConfigItemPB.class);
  public final PBRepeatMessageField<HwConfigPersistentPB.HwConfigItemPB> rpt_config_item_list_ip6 = PBField.initRepeatMessage(HwConfigPersistentPB.HwConfigItemPB.class);
  public final PBRepeatMessageField<HwConfigPersistentPB.HwNetSegConfPB> rpt_net_seg_conf_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwNetSegConfPB.class);
  public final PBRepeatMessageField<HwConfigPersistentPB.HwNetSegConfPB> rpt_short_video_net_conf = PBField.initRepeatMessage(HwConfigPersistentPB.HwNetSegConfPB.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
 * JD-Core Version:    0.7.0.1
 */