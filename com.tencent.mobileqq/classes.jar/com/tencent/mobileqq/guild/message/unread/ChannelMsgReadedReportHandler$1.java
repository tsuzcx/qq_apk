package com.tencent.mobileqq.guild.message.unread;

import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler.RequestBuilder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class ChannelMsgReadedReportHandler$1
  implements BaseGuildMessageHandler.RequestBuilder
{
  ChannelMsgReadedReportHandler$1(ChannelMsgReadedReportHandler paramChannelMsgReadedReportHandler, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.b.createToServiceMsg("OidbSvcTrpcTcp.0xf6d_1");
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.ChannelMsgReadedReportHandler.1
 * JD-Core Version:    0.7.0.1
 */