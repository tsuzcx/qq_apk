package com.tencent.mobileqq.gamecenter.message;

import avds;
import avec;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgManager$4
  implements Runnable
{
  public GameMsgManager$4(avds paramavds, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (avds.a(this.this$0) == null) {
      QLog.w(avds.e(), 1, "app is null");
    }
    for (;;)
    {
      return;
      avec localavec = (avec)avds.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER);
      if (this.jdField_a_of_type_Boolean)
      {
        localavec.a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ArrayList localArrayList = avds.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localavec.a(localArrayList);
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