package com.tencent.mobileqq.gamecenter.message;

import avld;
import avln;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgManager$4
  implements Runnable
{
  public GameMsgManager$4(avld paramavld, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (avld.a(this.this$0) == null) {
      QLog.w(avld.e(), 1, "app is null");
    }
    for (;;)
    {
      return;
      avln localavln = (avln)avld.a(this.this$0).a(175);
      if (this.jdField_a_of_type_Boolean)
      {
        localavln.a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ArrayList localArrayList = avld.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localavln.a(localArrayList);
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