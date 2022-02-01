import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateReq;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class odw
  extends MSFServlet
{
  private String a = "com.tencent.biz.pubaccount.PublicAccountServlet";
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("need_handler", true);
  }
  
  protected byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null)
    {
      localObject1 = localObject2;
      if (paramFromServiceMsg.isSuccess()) {
        localObject1 = bgau.b(paramFromServiceMsg.getWupBuffer());
      }
    }
    return localObject1;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onReceive");
    }
    byte[] arrayOfByte = a(paramFromServiceMsg);
    udz.a(paramFromServiceMsg);
    Object localObject = new Bundle();
    ((Bundle)localObject).putByteArray("data", arrayOfByte);
    ((Bundle)localObject).putInt("respones_code", paramFromServiceMsg.getBusinessFailCode());
    ((Bundle)localObject).putInt("type", paramIntent.getIntExtra("type", 0));
    if (paramIntent.getBooleanExtra("need_handler", false))
    {
      localObject = (PublicAccountHandler)((QQAppInterface)super.getAppRuntime()).getBusinessHandler(11);
      if (localObject != null) {
        ((PublicAccountHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onReceive exit");
      }
      return;
      super.notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    Object localObject = paramIntent.getStringExtra("cmd");
    udz.a(arrayOfByte, (String)localObject);
    if (((String)localObject).equals("get_business_recommend"))
    {
      paramPacket.setSSOCommand("PubAccBusiRecSvc." + (String)localObject);
      paramIntent = arrayOfByte;
    }
    for (;;)
    {
      if (paramIntent != null) {
        paramPacket.putSendData(bgau.a(paramIntent));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onSend exit");
      }
      return;
      if (((String)localObject).equals("post_punchcard_info"))
      {
        paramPacket.setSSOCommand("PubAccountSSOProxySvc." + (String)localObject);
        paramIntent = arrayOfByte;
      }
      else if ((((String)localObject).equals("PubAccountFollowSvc.follow")) || (((String)localObject).equals("PubAccountFollowSvc.subscribe")))
      {
        paramPacket.setTimeout(10000L);
        paramPacket.setSSOCommand((String)localObject);
        paramIntent = arrayOfByte;
      }
      else if (((String)localObject).equals("PubAccountAdSvc.recent_list_report"))
      {
        paramPacket.setSSOCommand((String)localObject);
        paramIntent = arrayOfByte;
      }
      else if ((((String)localObject).equals("PubAccountArticleCenter.GetUrlByVid")) || (((String)localObject).equals("PubAccountArticleCenter.GetVidByUrl")) || (((String)localObject).equals("SQQShopAdSvr.GetUrlByVid")))
      {
        paramPacket.setTimeout(15000L);
        paramPacket.setSSOCommand((String)localObject);
        paramIntent = arrayOfByte;
      }
      else if (((String)localObject).equals("PubAccountAdSvc."))
      {
        paramPacket.setSSOCommand("PubAccountAdSvc.ad_report");
        paramIntent = arrayOfByte;
      }
      else if ((((String)localObject).equals("PubAccountSvc.net_connect_info")) || (((String)localObject).equals("PubAccountArticleCenter.GetRecommendPubAccount")) || (((String)localObject).equals("KdAdReportSsoSvr.kandian_ad")) || (((String)localObject).equals("KdAdReportSsoSvr.kandian_ad_report")) || (((String)localObject).equals("KdAdReportSsoSvr.kandian_ad_native")) || (((String)localObject).equals("KdAdReportSsoSvr.kandian_ad_report_new")) || (((String)localObject).equals("KdAdReportSsoSvr.kandian_ad_report_test")) || (((String)localObject).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_fetch")) || (((String)localObject).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create")) || (((String)localObject).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete")) || (((String)localObject).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like")) || (((String)localObject).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_report")) || (((String)localObject).equals("MQUpdateSvc_com_qq_kandian.web.firstCommentRead.getNewestList")) || (((String)localObject).equals("FeedsContentCenter.QualityReport")))
      {
        paramPacket.setTimeout(15000L);
        paramPacket.setSSOCommand((String)localObject);
        paramIntent = arrayOfByte;
      }
      else if (((String)localObject).equals("getGuideFriends"))
      {
        paramPacket.setSSOCommand("KandianSvc_biu_guide." + (String)localObject);
        paramIntent = arrayOfByte;
      }
      else if (((String)localObject).equals("ConfigSvc.getRecvMsgState"))
      {
        try
        {
          localObject = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getName());
          paramIntent = ((ToServiceMsg)localObject).getServiceCmd();
          localObject = (GetRecvMsgStateReq)((ToServiceMsg)localObject).getAttribute("GetRecvMsgStateReq");
          paramPacket.setServantName("QQMP.ConfigServer.ConfigObj");
          paramPacket.setFuncName("getRecvMsgState");
          paramPacket.addRequestPacket("req", (JceStruct)localObject);
          paramPacket.setSSOCommand(paramIntent);
          paramPacket.setTimeout(15000L);
          paramIntent = arrayOfByte;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.a, 2, "onSend exception");
          }
          paramIntent = arrayOfByte;
        }
      }
      else
      {
        if (!((String)localObject).equals("ConfigSvc.setRecvMsgState")) {
          break;
        }
        try
        {
          localObject = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getName());
          paramIntent = ((ToServiceMsg)localObject).getServiceCmd();
          localObject = (SetRecvMsgStateReq)((ToServiceMsg)localObject).getAttribute("SetRecvMsgStateReq");
          paramPacket.setServantName("QQMP.ConfigServer.ConfigObj");
          paramPacket.setFuncName("setRecvMsgState");
          paramPacket.addRequestPacket("req", (JceStruct)localObject);
          paramPacket.setSSOCommand(paramIntent);
          paramPacket.setTimeout(15000L);
          paramIntent = arrayOfByte;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.a, 2, "onSend exception");
          }
          paramIntent = arrayOfByte;
        }
      }
    }
    if ("CertifiedAccountSvc.certified_account_read.GetFollowList".equals(localObject))
    {
      paramPacket.setSSOCommand((String)localObject);
      paramPacket.setTimeout(30000L);
      paramPacket.autoResend = true;
      label719:
      if (!((String)localObject).equals("get_detail_info")) {
        break label1083;
      }
      localObject = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    }
    label1083:
    label1089:
    for (;;)
    {
      try
      {
        ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).mergeFrom(arrayOfByte);
        oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest();
        long l = ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).uin.get();
        if (l >= 0L) {
          break label1089;
        }
        l = -(-2147483648L - l) + 2147483647L + 1L;
        if ((paramIntent.getBooleanExtra("useNewProtocol", false)) || (((super.getAppRuntime() instanceof QQAppInterface)) && (ugf.a((QQAppInterface)super.getAppRuntime(), l + "") != -4)))
        {
          paramIntent.putExtra("type", 1);
          localGetPublicAccountDetailInfoRequest.luin.set(l);
          localGetPublicAccountDetailInfoRequest.seqno.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.get());
          localGetPublicAccountDetailInfoRequest.version.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).version.get());
          localGetPublicAccountDetailInfoRequest.versionInfo.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).versionInfo.get());
          paramIntent = new oidb_sso.OIDBSSOPkg();
          paramIntent.uint32_command.set(3320);
          paramIntent.uint32_result.set(0);
          paramIntent.uint32_service_type.set(1);
          paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localGetPublicAccountDetailInfoRequest.toByteArray()));
          paramIntent = paramIntent.toByteArray();
          paramPacket.setSSOCommand("OidbSvc.0xcf8");
          break;
          if ("get_follow_list".equals(localObject))
          {
            paramPacket.autoResend = true;
            paramPacket.setSSOCommand("PubAccountSvc." + (String)localObject);
            break label719;
          }
          if (("CertifiedAccountSvc.certified_account_read.GetAccountMenu".equals(localObject)) || ("CertifiedAccountSvc.certified_account_write.SendMenuEvent".equals(localObject)))
          {
            paramPacket.setSSOCommand((String)localObject);
            break label719;
          }
          paramPacket.setSSOCommand("PubAccountSvc." + (String)localObject);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
      }
      paramIntent = arrayOfByte;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odw
 * JD-Core Version:    0.7.0.1
 */