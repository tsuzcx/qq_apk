package com.tencent.mobileqq.transfile;

import alwy;
import bavr;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class ProtoReqManager$ProtoReqRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  bavr jdField_a_of_type_Bavr;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  
  ProtoReqManager$ProtoReqRunnable(ProtoReqManager paramProtoReqManager)
  {
    this.c = false;
  }
  
  public void run()
  {
    QLog.d("Q.richmedia.ProtoReqManager", 2, "ProtoReqRunnable.run() : resp.startTime" + this.jdField_a_of_type_Bavr.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("key_timeout", this.jdField_a_of_type_Long);
    alwy localalwy = this.jdField_a_of_type_Bavr.jdField_a_of_type_Alwy;
    localalwy.c += 1;
    this.this$0.a.put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_Bavr);
    this.this$0.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReqRunnable
 * JD-Core Version:    0.7.0.1
 */