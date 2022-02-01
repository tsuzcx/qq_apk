package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.writetogether.client.RoomController;
import com.tencent.mobileqq.writetogether.client.RoomController.OnEnterRoomListener;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import okhttp3.WebSocketListener;

public class WriteTogetherWebSocketSender
  implements RoomController.OnEnterRoomListener
{
  private int jdField_a_of_type_Int = 2000;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  RoomController jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController;
  private HeartBeat jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat;
  private WriteTogetherWebSocketAlarm jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketAlarm;
  private WriteTogetherWebSocketEngine jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine;
  private WriteTogetherWebSocketSender.Worker jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender$Worker;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedBlockingDeque<BaseToWriteTogetherMsg> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque = new LinkedBlockingDeque();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  WebSocketListener jdField_a_of_type_Okhttp3WebSocketListener;
  boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  
  public WriteTogetherWebSocketSender(WriteTogetherWebSocketEngine paramWriteTogetherWebSocketEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine = paramWriteTogetherWebSocketEngine;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketAlarm = new WriteTogetherWebSocketAlarm(this);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat = new HeartBeat(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender$Worker = new WriteTogetherWebSocketSender.Worker(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender$Worker.setName("WriteTogether.WriteTogetherWebSocketSender");
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketSender$Worker.start();
  }
  
  public ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat.a(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.size() == 0) {
      a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat.a());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController.a(paramInt);
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendData, ");
      localStringBuilder.append(paramBaseToWriteTogetherMsg.toShortStr());
      QLog.d("WriteTogether.WriteTogetherWebSocketSender", 2, localStringBuilder.toString());
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      e();
    }
    try
    {
      paramBaseToWriteTogetherMsg.header.groupCode = Integer.parseInt(this.jdField_b_of_type_JavaLangString);
      paramBaseToWriteTogetherMsg.header.sig = this.jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      QLog.e("WriteTogether.WriteTogetherWebSocketSender", 1, localException, new Object[0]);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.offer(paramBaseToWriteTogetherMsg))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramBaseToWriteTogetherMsg.getSeq()), paramBaseToWriteTogetherMsg);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketAlarm.a(paramBaseToWriteTogetherMsg, paramBaseToWriteTogetherMsg.getTimeout());
      return;
    }
    QLog.d("WriteTogether.WriteTogetherWebSocketSender", 1, "sendData, but mWaitSendQueue is full");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Okhttp3WebSocketListener == null) {
      this.jdField_a_of_type_Okhttp3WebSocketListener = new WriteTogetherWebSocketSender.1(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine.a(this.jdField_a_of_type_Okhttp3WebSocketListener);
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    if (localTicketManager != null) {
      this.jdField_a_of_type_JavaLangString = localTicketManager.getA2(str);
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat.a(paramString1, str);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController = new RoomController(paramAppRuntime, this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine, paramString2, paramString1, paramInt, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine.a();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 60010) {
      return;
    }
    if ((paramBoolean) && (paramInt == 0)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat.a(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat.a() != null)
        {
          ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketHeartBeat, 30000L);
          return;
        }
        throw new IllegalStateException("heart beat not initialize");
      }
    }
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  boolean a()
  {
    return NetworkUtil.isNetworkAvailable();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new WriteTogetherWebSocketSender.MyNetInfoHandler(this, null);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.sMobileQQ, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketEngine.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController;
    if (localObject != null) {
      ((RoomController)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender
 * JD-Core Version:    0.7.0.1
 */