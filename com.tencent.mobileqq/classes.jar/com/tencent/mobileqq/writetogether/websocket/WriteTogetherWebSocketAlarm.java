package com.tencent.mobileqq.writetogether.websocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import java.util.concurrent.ConcurrentHashMap;

public class WriteTogetherWebSocketAlarm
{
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private WriteTogetherWebSocketSender jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender;
  private ConcurrentHashMap<Integer, WriteTogetherWebSocketAlarm.TimeoutChecker> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public WriteTogetherWebSocketAlarm(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender = paramWriteTogetherWebSocketSender;
    paramWriteTogetherWebSocketSender = new HandlerThread("WriteTogetherWebSocketAlarm", 5);
    paramWriteTogetherWebSocketSender.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramWriteTogetherWebSocketSender.getLooper());
  }
  
  public void a(@NonNull BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg, long paramLong)
  {
    WriteTogetherWebSocketAlarm.TimeoutChecker localTimeoutChecker = new WriteTogetherWebSocketAlarm.TimeoutChecker(this, paramBaseToWriteTogetherMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramBaseToWriteTogetherMsg.getSeq()), localTimeoutChecker);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localTimeoutChecker, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketAlarm
 * JD-Core Version:    0.7.0.1
 */