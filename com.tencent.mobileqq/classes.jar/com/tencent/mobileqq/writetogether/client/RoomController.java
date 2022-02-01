package com.tencent.mobileqq.writetogether.client;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyReqMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class RoomController
  implements IWriteTogetherObserver, Runnable
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private IQQWriteTogetherService jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService;
  private RoomController.OnEnterRoomListener jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController$OnEnterRoomListener;
  private WriteTogetherWebSocketEngine jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public RoomController(AppRuntime paramAppRuntime, WriteTogetherWebSocketEngine paramWriteTogetherWebSocketEngine, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine = paramWriteTogetherWebSocketEngine;
    this.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString1);
    }
    catch (NumberFormatException paramWriteTogetherWebSocketEngine)
    {
      QLog.e("RoomController", 1, paramWriteTogetherWebSocketEngine, new Object[0]);
    }
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.addObservers(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine.a(new ClientReadyReqMsg(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.c));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RoomController.OnEnterRoomListener paramOnEnterRoomListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController$OnEnterRoomListener = paramOnEnterRoomListener;
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    int i = RoomController.1.a[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController$OnEnterRoomListener.a();
      return;
    }
    paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("isSuccesss: ");
      paramObject.append(paramBoolean);
      paramObject.append(", ret: ");
      paramObject.append(paramType.result);
      QLog.d("RoomController", 2, paramObject.toString());
    }
    paramObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController$OnEnterRoomListener;
    if (paramObject != null) {
      paramObject.a(paramBoolean, paramType.result);
    }
    if (paramType.result == 60010) {
      ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.removeObserver(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.RoomController
 * JD-Core Version:    0.7.0.1
 */