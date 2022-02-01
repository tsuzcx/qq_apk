package com.tencent.mobileqq.together.writetogether.websocket;

import bdhf;
import bdjk;
import bdjn;
import bdjo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.together.writetogether.client.RoomController;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import okhttp3.WebSocketListener;

public class WriteTogetherWebSocketSender
  implements bdhf
{
  private int jdField_a_of_type_Int = 2000;
  private bdjk jdField_a_of_type_Bdjk;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  public RoomController a;
  private HeartBeat jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat;
  private WriteTogetherWebSocketAlarm jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketAlarm;
  private WriteTogetherWebSocketSender.Worker jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender$Worker;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedBlockingDeque<BaseToWriteTogetherMsg> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque = new LinkedBlockingDeque();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  WebSocketListener jdField_a_of_type_Okhttp3WebSocketListener;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  
  public WriteTogetherWebSocketSender(bdjk parambdjk)
  {
    this.jdField_a_of_type_Bdjk = parambdjk;
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketAlarm = new WriteTogetherWebSocketAlarm(this);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat = new HeartBeat(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender$Worker = new WriteTogetherWebSocketSender.Worker(this, null);
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender$Worker.setName("WriteTogether.WriteTogetherWebSocketSender");
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender$Worker.start();
  }
  
  public ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat.a(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.size() == 0) {
      a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat.a());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherClientRoomController.a(paramInt);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bdjo(this, null);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Okhttp3WebSocketListener == null) {
      this.jdField_a_of_type_Okhttp3WebSocketListener = new bdjn(this);
    }
    this.jdField_a_of_type_Bdjk.a(this.jdField_a_of_type_Okhttp3WebSocketListener);
    TicketManager localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (localTicketManager != null) {
      this.jdField_a_of_type_JavaLangString = localTicketManager.getA2(str);
    }
    a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat.a(paramString1, str);
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherClientRoomController = new RoomController(paramQQAppInterface, this.jdField_a_of_type_Bdjk, paramString2, paramString1, paramInt, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherClientRoomController.a(this);
    this.jdField_a_of_type_Bdjk.a();
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogether.WriteTogetherWebSocketSender", 2, "sendData, " + paramBaseToWriteTogetherMsg.toShortStr());
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      d();
    }
    try
    {
      paramBaseToWriteTogetherMsg.header.groupCode = Integer.parseInt(this.jdField_b_of_type_JavaLangString);
      paramBaseToWriteTogetherMsg.header.sig = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingDeque.offer(paramBaseToWriteTogetherMsg))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramBaseToWriteTogetherMsg.getSeq()), paramBaseToWriteTogetherMsg);
        this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketAlarm.a(paramBaseToWriteTogetherMsg, paramBaseToWriteTogetherMsg.getTimeout());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WriteTogether.WriteTogetherWebSocketSender", 1, localException, new Object[0]);
      }
      QLog.d("WriteTogether.WriteTogetherWebSocketSender", 1, "sendData, but mWaitSendQueue is full");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 60010) {
      return;
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      this.jdField_a_of_type_Boolean = false;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat.a() == null) {
        throw new IllegalStateException("heart beat not initialize");
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketHeartBeat, 30000L);
  }
  
  boolean a()
  {
    return NetworkUtil.isNetworkAvailable();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bdjk.b();
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherClientRoomController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherClientRoomController.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender
 * JD-Core Version:    0.7.0.1
 */