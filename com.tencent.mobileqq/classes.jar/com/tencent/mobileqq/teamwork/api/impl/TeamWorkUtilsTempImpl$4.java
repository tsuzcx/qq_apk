package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import java.util.ArrayList;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.NotOnlineFile;

class TeamWorkUtilsTempImpl$4
  implements Runnable
{
  TeamWorkUtilsTempImpl$4(TeamWorkUtilsTempImpl paramTeamWorkUtilsTempImpl, QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, MessageForStructing paramMessageForStructing) {}
  
  public void run()
  {
    this.a.getFileTransferHandler().a(this.a.getMsgHandler(), new ArrayList(), this.b, this.c, this.d.frienduin, false, false, this.d.vipBubbleID, this.d.vipBubbleDiyTextId, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.4
 * JD-Core Version:    0.7.0.1
 */