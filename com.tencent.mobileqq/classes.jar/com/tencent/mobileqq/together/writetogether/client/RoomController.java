package com.tencent.mobileqq.together.writetogether.client;

import bdgd;
import bdge;
import bdhf;
import bdjk;
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
  implements bdge, Runnable
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bdgd jdField_a_of_type_Bdgd;
  private bdhf jdField_a_of_type_Bdhf;
  private bdjk jdField_a_of_type_Bdjk;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public RoomController(QQAppInterface paramQQAppInterface, bdjk parambdjk, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_Bdjk = parambdjk;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString1);
      this.b = paramString2;
      this.jdField_a_of_type_Int = paramInt;
      this.c = paramString3;
      this.jdField_a_of_type_Bdgd = ((bdgd)paramQQAppInterface.getManager(377));
      this.jdField_a_of_type_Bdgd.a(this);
      return;
    }
    catch (NumberFormatException parambdjk)
    {
      for (;;)
      {
        QLog.e("RoomController", 1, parambdjk, new Object[0]);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdjk.a(new ClientReadyReqMsg(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.c));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bdhf parambdhf)
  {
    this.jdField_a_of_type_Bdhf = parambdhf;
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    switch (bdhe.a[paramType.ordinal()])
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
        if (this.jdField_a_of_type_Bdhf != null) {
          this.jdField_a_of_type_Bdhf.a(paramBoolean, paramType.result);
        }
      } while (paramType.result != 60010);
      ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
      return;
    }
    this.jdField_a_of_type_Bdhf.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bdgd.b(this);
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