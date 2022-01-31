package com.tencent.mobileqq.richmedia.conn;

import auwp;
import auwq;
import avbn;
import avbo;

public class ConnManager$1
  implements Runnable
{
  public ConnManager$1(auwp paramauwp, avbo paramavbo, long paramLong, auwq paramauwq) {}
  
  public void run()
  {
    auwp.a(this.this$0).b(12);
    this.jdField_a_of_type_Avbo.notifyUI(1, true, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Auwq.d), Integer.valueOf(2000), this.jdField_a_of_type_Auwq });
    this.jdField_a_of_type_Avbo.a(this.jdField_a_of_type_Long, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager.1
 * JD-Core Version:    0.7.0.1
 */