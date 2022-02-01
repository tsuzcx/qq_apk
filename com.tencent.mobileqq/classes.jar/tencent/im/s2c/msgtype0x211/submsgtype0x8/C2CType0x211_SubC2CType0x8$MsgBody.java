package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class C2CType0x211_SubC2CType0x8$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int MSG_CCNF_ABI_QUERY_FIELD_NUMBER = 3;
  public static final int MSG_CCNF_FILESEND_REQ_FIELD_NUMBER = 5;
  public static final int MSG_CCNF_FILESTATE_SYNC_FIELD_NUMBER = 6;
  public static final int MSG_CC_NOTIFYLIST_FIELD_NUMBER = 2;
  public static final int MSG_CC_PUSH_JUDGE_RESULT_FIELD_NUMBER = 4;
  public static final int MSG_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "msg_type", "msg_cc_notifylist", "msg_ccnf_abi_query", "msg_cc_push_judge_result", "msg_ccnf_filesend_req", "msg_ccnf_filestate_sync" }, new Object[] { Integer.valueOf(1), null, null, null, null, null }, MsgBody.class);
  public C2CType0x211_SubC2CType0x8.NotifyList msg_cc_notifylist = new C2CType0x211_SubC2CType0x8.NotifyList();
  public C2CType0x211_SubC2CType0x8.PushJudgeResult msg_cc_push_judge_result = new C2CType0x211_SubC2CType0x8.PushJudgeResult();
  public C2CType0x211_SubC2CType0x8.NearFieldAbiQuery msg_ccnf_abi_query = new C2CType0x211_SubC2CType0x8.NearFieldAbiQuery();
  public C2CType0x211_SubC2CType0x8.NearFieldFileSendReq msg_ccnf_filesend_req = new C2CType0x211_SubC2CType0x8.NearFieldFileSendReq();
  public C2CType0x211_SubC2CType0x8.NearFieldFileStateSync msg_ccnf_filestate_sync = new C2CType0x211_SubC2CType0x8.NearFieldFileStateSync();
  public final PBEnumField msg_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.MsgBody
 * JD-Core Version:    0.7.0.1
 */