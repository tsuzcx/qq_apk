package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.websocket.msg.HeartBeatMsg;
import mqq.os.MqqHandler;

public class HeartBeat
  implements Runnable
{
  private WriteTogetherWebSocketSender jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender;
  private HeartBeatMsg jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgHeartBeatMsg;
  private boolean jdField_a_of_type_Boolean;
  
  HeartBeat(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender = paramWriteTogetherWebSocketSender;
  }
  
  HeartBeatMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgHeartBeatMsg;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgHeartBeatMsg = new HeartBeatMsg(paramString1, paramString2);
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgHeartBeatMsg == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgHeartBeatMsg);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.HeartBeat
 * JD-Core Version:    0.7.0.1
 */