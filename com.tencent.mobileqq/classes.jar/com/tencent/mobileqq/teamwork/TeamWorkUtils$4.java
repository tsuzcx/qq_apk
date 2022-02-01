package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import java.util.ArrayList;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.NotOnlineFile;

final class TeamWorkUtils$4
  implements Runnable
{
  TeamWorkUtils$4(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, MessageForStructing paramMessageForStructing) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler(), new ArrayList(), this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg, this.jdField_a_of_type_TencentImMsgIm_msg_body$NotOnlineFile, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin, false, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.vipBubbleID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.vipBubbleDiyTextId, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.4
 * JD-Core Version:    0.7.0.1
 */