package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleMsgPaelem$PAElem
  extends MessageMicro<PAElem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 82, 90, 98 }, new String[] { "pubacc_trans", "crm_trans", "login_sig", "general_system_notify", "rich_long_msg", "eim_trans", "group_svr_trans", "msg_tmp_msg_info", "msg_crm_info", "msg_comm_info" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, PAElem.class);
  public QQCircleMsgPaelem.Crm_Trans crm_trans = new QQCircleMsgPaelem.Crm_Trans();
  public QQCircleMsgPaelem.EIM_Trans eim_trans = new QQCircleMsgPaelem.EIM_Trans();
  public QQCircleMsgPaelem.GeneralSystemNotify general_system_notify = new QQCircleMsgPaelem.GeneralSystemNotify();
  public QQCircleMsgPaelem.GroupSvrTrans group_svr_trans = new QQCircleMsgPaelem.GroupSvrTrans();
  public QQCircleMsgPaelem.LoginSig login_sig = new QQCircleMsgPaelem.LoginSig();
  public QQCircleMsgPaelem.CommInfo msg_comm_info = new QQCircleMsgPaelem.CommInfo();
  public QQCircleMsgPaelem.CrmInfo msg_crm_info = new QQCircleMsgPaelem.CrmInfo();
  public QQCircleMsgPaelem.TmpMsgInfo msg_tmp_msg_info = new QQCircleMsgPaelem.TmpMsgInfo();
  public QQCircleMsgPaelem.PubAcc_Trans pubacc_trans = new QQCircleMsgPaelem.PubAcc_Trans();
  public QQCircleMsgPaelem.RichLongMsg rich_long_msg = new QQCircleMsgPaelem.RichLongMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.PAElem
 * JD-Core Version:    0.7.0.1
 */