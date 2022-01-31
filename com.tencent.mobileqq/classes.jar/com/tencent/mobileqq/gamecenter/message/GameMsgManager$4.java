package com.tencent.mobileqq.gamecenter.message;

import asmu;
import asne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgManager$4
  implements Runnable
{
  public GameMsgManager$4(asmu paramasmu, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (asmu.a(this.this$0) == null) {
      QLog.w(asmu.c(), 1, "app is null");
    }
    for (;;)
    {
      return;
      asne localasne = (asne)asmu.a(this.this$0).a(175);
      if (this.jdField_a_of_type_Boolean)
      {
        localasne.a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ArrayList localArrayList = asmu.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localasne.a(localArrayList);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.4
 * JD-Core Version:    0.7.0.1
 */