package com.tencent.mobileqq.together.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.together.writetogether.websocket.msg.HeartBeatMsg;
import mqq.os.MqqHandler;

public class HeartBeat
  implements Runnable
{
  private WriteTogetherWebSocketSender jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender;
  private HeartBeatMsg jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgHeartBeatMsg;
  private boolean jdField_a_of_type_Boolean;
  
  HeartBeat(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender = paramWriteTogetherWebSocketSender;
  }
  
  public HeartBeatMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgHeartBeatMsg;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgHeartBeatMsg = new HeartBeatMsg(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgHeartBeatMsg == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgHeartBeatMsg);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.HeartBeat
 * JD-Core Version:    0.7.0.1
 */