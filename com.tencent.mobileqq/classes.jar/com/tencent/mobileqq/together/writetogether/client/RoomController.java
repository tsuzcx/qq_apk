package com.tencent.mobileqq.together.writetogether.client;

import beml;
import bemm;
import benn;
import beqq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyReqMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class RoomController
  implements bemm, Runnable
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private beml jdField_a_of_type_Beml;
  private benn jdField_a_of_type_Benn;
  private beqq jdField_a_of_type_Beqq;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public RoomController(QQAppInterface paramQQAppInterface, beqq parambeqq, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_Beqq = parambeqq;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString1);
      this.b = paramString2;
      this.jdField_a_of_type_Int = paramInt;
      this.c = paramString3;
      this.jdField_a_of_type_Beml = ((beml)paramQQAppInterface.getManager(377));
      this.jdField_a_of_type_Beml.a(this);
      return;
    }
    catch (NumberFormatException parambeqq)
    {
      for (;;)
      {
        QLog.e("RoomController", 1, parambeqq, new Object[0]);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beqq.a(new ClientReadyReqMsg(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.c));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(benn parambenn)
  {
    this.jdField_a_of_type_Benn = parambenn;
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    switch (benm.a[paramType.ordinal()])
    {
    default: 
    case 1: 
      do
      {
        return;
        paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
        if (QLog.isColorLevel()) {
          QLog.d("RoomController", 2, "isSuccesss: " + paramBoolean + ", ret: " + paramType.result);
        }
        if (this.jdField_a_of_type_Benn != null) {
          this.jdField_a_of_type_Benn.a(paramBoolean, paramType.result);
        }
      } while (paramType.result != 60010);
      ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
      return;
    }
    this.jdField_a_of_type_Benn.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Beml.b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.client.RoomController
 * JD-Core Version:    0.7.0.1
 */