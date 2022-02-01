package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$Elem
  extends MessageMicro<Elem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public im_msg_body.AnonymousGroupMsg anon_group_msg = new im_msg_body.AnonymousGroupMsg();
  public im_msg_body.ApolloActMsg apollo_msg = new im_msg_body.ApolloActMsg();
  public im_msg_body.ArkAppElem ark_app = new im_msg_body.ArkAppElem();
  public final PBBytesField bankcode_ctrl_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.BitAppMsg bitapp_msg = new im_msg_body.BitAppMsg();
  public im_msg_body.BlessingMessage bless_msg = new im_msg_body.BlessingMessage();
  public im_msg_body.CommonElem common_elem = new im_msg_body.CommonElem();
  public im_msg_body.ConferenceTipsInfo conference_tips_info = new im_msg_body.ConferenceTipsInfo();
  public im_msg_body.CrmElem crm_elem = new im_msg_body.CrmElem();
  public im_msg_body.CustomElem custom_elem = new im_msg_body.CustomElem();
  public im_msg_body.CustomFace custom_face = new im_msg_body.CustomFace();
  public im_msg_body.DeliverGiftMsg deliver_gift_msg = new im_msg_body.DeliverGiftMsg();
  public im_msg_body.EIMInfo eim_info = new im_msg_body.EIMInfo();
  public im_msg_body.ElemFlags elem_flags = new im_msg_body.ElemFlags();
  public im_msg_body.ElemFlags2 elem_flags2 = new im_msg_body.ElemFlags2();
  public im_msg_body.ExtraInfo extra_info = new im_msg_body.ExtraInfo();
  public im_msg_body.Face face = new im_msg_body.Face();
  public im_msg_body.FSJMessageElem fsj_msg_elem = new im_msg_body.FSJMessageElem();
  public im_msg_body.FunFace fun_face = new im_msg_body.FunFace();
  public im_msg_body.GeneralFlags general_flags = new im_msg_body.GeneralFlags();
  public im_msg_body.GroupBusinessMsg group_business_msg = new im_msg_body.GroupBusinessMsg();
  public im_msg_body.GroupFile group_file = new im_msg_body.GroupFile();
  public im_msg_body.GroupPostElem group_post_elem = new im_msg_body.GroupPostElem();
  public im_msg_body.GroupPubAccountInfo group_pub_acc_info = new im_msg_body.GroupPubAccountInfo();
  public im_msg_body.CustomFace hc_flash_pic = new im_msg_body.CustomFace();
  public im_msg_body.LifeOnlineAccount life_online = new im_msg_body.LifeOnlineAccount();
  public im_msg_body.LightAppElem light_app = new im_msg_body.LightAppElem();
  public im_msg_body.LocationInfo location_info = new im_msg_body.LocationInfo();
  public im_msg_body.LolaMsg lola_msg = new im_msg_body.LolaMsg();
  public im_msg_body.LowVersionTips low_version_tips = new im_msg_body.LowVersionTips();
  public im_msg_body.MarketFace market_face = new im_msg_body.MarketFace();
  public im_msg_body.MarketTrans market_trans = new im_msg_body.MarketTrans();
  public im_msg_body.WorkflowNotifyMsg msg_workflow_notify = new im_msg_body.WorkflowNotifyMsg();
  public im_msg_body.NearByMessageType near_by_msg = new im_msg_body.NearByMessageType();
  public im_msg_body.NotOnlineImage not_online_image = new im_msg_body.NotOnlineImage();
  public im_msg_body.OnlineImage online_image = new im_msg_body.OnlineImage();
  public im_msg_body.OpenQQData open_qq_data = new im_msg_body.OpenQQData();
  public im_msg_body.PatsElem pat_elem = new im_msg_body.PatsElem();
  public im_msg_body.PubAccInfo pub_acc_info = new im_msg_body.PubAccInfo();
  public im_msg_body.PubAccount pub_account = new im_msg_body.PubAccount();
  public im_msg_body.PubGroup pub_group = new im_msg_body.PubGroup();
  public im_msg_body.QQLiveOld qq_live_old = new im_msg_body.QQLiveOld();
  public im_msg_body.QQWalletMsg qqwallet_msg = new im_msg_body.QQWalletMsg();
  public im_msg_body.RedBagInfo redbag_info = new im_msg_body.RedBagInfo();
  public im_msg_body.RichMsg rich_msg = new im_msg_body.RichMsg();
  public im_msg_body.SecretFileMsg secret_file = new im_msg_body.SecretFileMsg();
  public im_msg_body.ShakeWindow shake_window = new im_msg_body.ShakeWindow();
  public im_msg_body.SmallEmoji small_emoji = new im_msg_body.SmallEmoji();
  public im_msg_body.SourceMsg src_msg = new im_msg_body.SourceMsg();
  public im_msg_body.Text text = new im_msg_body.Text();
  public im_msg_body.TipsInfo tips_info = new im_msg_body.TipsInfo();
  public im_msg_body.TransElem trans_elem_info = new im_msg_body.TransElem();
  public im_msg_body.VideoFile video_file = new im_msg_body.VideoFile();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, 282, 290, 298, 306, 314, 322, 330, 338, 346, 354, 362, 370, 378, 386, 394, 402, 410, 418, 426 }, new String[] { "text", "face", "online_image", "not_online_image", "trans_elem_info", "market_face", "elem_flags", "custom_face", "elem_flags2", "fun_face", "secret_file", "rich_msg", "group_file", "pub_group", "market_trans", "extra_info", "shake_window", "pub_account", "video_file", "tips_info", "anon_group_msg", "qq_live_old", "life_online", "qqwallet_msg", "crm_elem", "conference_tips_info", "redbag_info", "low_version_tips", "bankcode_ctrl_info", "near_by_msg", "custom_elem", "location_info", "pub_acc_info", "small_emoji", "fsj_msg_elem", "ark_app", "general_flags", "hc_flash_pic", "deliver_gift_msg", "bitapp_msg", "open_qq_data", "apollo_msg", "group_pub_acc_info", "bless_msg", "src_msg", "lola_msg", "group_business_msg", "msg_workflow_notify", "pat_elem", "group_post_elem", "light_app", "eim_info", "common_elem" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, Elem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.Elem
 * JD-Core Version:    0.7.0.1
 */