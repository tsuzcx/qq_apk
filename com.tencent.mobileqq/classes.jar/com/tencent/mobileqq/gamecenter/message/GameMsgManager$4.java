package com.tencent.mobileqq.gamecenter.message;

import atyd;
import atyn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgManager$4
  implements Runnable
{
  public GameMsgManager$4(atyd paramatyd, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (atyd.a(this.this$0) == null) {
      QLog.w(atyd.e(), 1, "app is null");
    }
    for (;;)
    {
      return;
      atyn localatyn = (atyn)atyd.a(this.this$0).getBusinessHandler(175);
      if (this.jdField_a_of_type_Boolean)
      {
        localatyn.a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ArrayList localArrayList = atyd.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localatyn.a(localArrayList);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.4
 * JD-Core Version:    0.7.0.1
 */