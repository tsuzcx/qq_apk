package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp
  extends MessageMicro<CrossBidProxyOfflineFileGetListMsgRsp>
{
  public static final int RPT_MSG_RECV_OFFLINE_FILE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_SEND_OFFLINE_FILE_FIELD_NUMBER = 3;
  public static final int UINT32_RECV_FILE_TOTAL_FIELD_NUMBER = 2;
  public static final int UINT32_RECV_LIST_END_FIELD_NUMBER = 7;
  public static final int UINT32_SEND_FILE_TOTAL_FIELD_NUMBER = 4;
  public static final int UINT32_SEND_LIST_END_FIELD_NUMBER = 8;
  public static final int UINT64_TOT_LIMIT_FIELD_NUMBER = 5;
  public static final int UINT64_USED_LIMIT_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<WeiyunPB.OfflineFileInfo> rpt_msg_recv_offline_file = PBField.initRepeatMessage(WeiyunPB.OfflineFileInfo.class);
  public final PBRepeatMessageField<WeiyunPB.OfflineFileInfo> rpt_msg_send_offline_file = PBField.initRepeatMessage(WeiyunPB.OfflineFileInfo.class);
  public final PBUInt32Field uint32_recv_file_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recv_list_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_file_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_list_end = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64 }, new String[] { "rpt_msg_recv_offline_file", "uint32_recv_file_total", "rpt_msg_send_offline_file", "uint32_send_file_total", "uint64_tot_limit", "uint64_used_limit", "uint32_recv_list_end", "uint32_send_list_end" }, new Object[] { null, localInteger, null, localInteger, localLong, localLong, localInteger, localInteger }, CrossBidProxyOfflineFileGetListMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp
 * JD-Core Version:    0.7.0.1
 */