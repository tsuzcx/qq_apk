package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class msg_svc$RoutingHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "c2c", "grp", "grp_tmp", "dis", "dis_tmp", "wpa_tmp", "secret_file", "public_plat", "trans_msg", "address_list", "rich_status_tmp", "trans_cmd", "accost_tmp", "pub_group_tmp", "trans_0x211", "business_wpa_tmp", "auth_tmp", "bsns_tmp", "qq_querybusiness_tmp", "nearby_dating_tmp", "nearby_assistant_tmp", "comm_tmp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RoutingHead.class);
  public msg_svc.AccostTmp accost_tmp = new msg_svc.AccostTmp();
  public msg_svc.AddressListTmp address_list = new msg_svc.AddressListTmp();
  public msg_svc.AuthTmp auth_tmp = new msg_svc.AuthTmp();
  public msg_svc.BsnsTmp bsns_tmp = new msg_svc.BsnsTmp();
  public msg_svc.BusinessWPATmp business_wpa_tmp = new msg_svc.BusinessWPATmp();
  public msg_svc.C2C c2c = new msg_svc.C2C();
  public msg_svc.CommTmp comm_tmp = new msg_svc.CommTmp();
  public msg_svc.Dis dis = new msg_svc.Dis();
  public msg_svc.DisTmp dis_tmp = new msg_svc.DisTmp();
  public msg_svc.Grp grp = new msg_svc.Grp();
  public msg_svc.GrpTmp grp_tmp = new msg_svc.GrpTmp();
  public msg_svc.NearByAssistantTmp nearby_assistant_tmp = new msg_svc.NearByAssistantTmp();
  public msg_svc.NearByDatingTmp nearby_dating_tmp = new msg_svc.NearByDatingTmp();
  public msg_svc.PubGroupTmp pub_group_tmp = new msg_svc.PubGroupTmp();
  public msg_svc.PublicPlat public_plat = new msg_svc.PublicPlat();
  public msg_svc.QQQueryBusinessTmp qq_querybusiness_tmp = new msg_svc.QQQueryBusinessTmp();
  public msg_svc.RichStatusTmp rich_status_tmp = new msg_svc.RichStatusTmp();
  public msg_svc.SecretFileHead secret_file = new msg_svc.SecretFileHead();
  public msg_svc.Trans0x211 trans_0x211 = new msg_svc.Trans0x211();
  public msg_svc.TransCmd trans_cmd = new msg_svc.TransCmd();
  public msg_svc.TransMsg trans_msg = new msg_svc.TransMsg();
  public msg_svc.WPATmp wpa_tmp = new msg_svc.WPATmp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.RoutingHead
 * JD-Core Version:    0.7.0.1
 */