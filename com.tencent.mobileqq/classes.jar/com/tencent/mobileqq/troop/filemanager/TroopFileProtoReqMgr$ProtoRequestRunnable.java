package com.tencent.mobileqq.troop.filemanager;

import alwy;
import bbuz;
import bbva;
import bbvl;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class TroopFileProtoReqMgr$ProtoRequestRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  bbva jdField_a_of_type_Bbva;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  
  TroopFileProtoReqMgr$ProtoRequestRunnable(TroopFileProtoReqMgr paramTroopFileProtoReqMgr)
  {
    this.c = false;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_MqqAppNewIntent.getIntExtra("key_runnable_index", 0);
    bbvl.c("TroopFileProtoReqMgr", bbvl.a, "cookie<" + this.jdField_a_of_type_Bbva.jdField_a_of_type_Bbuz.jdField_b_of_type_Long + "> sendToMsf. scheduleIndex:" + i + " timeOut:" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("timeout", this.jdField_a_of_type_Long);
    alwy localalwy = this.jdField_a_of_type_Bbva.jdField_a_of_type_Alwy;
    localalwy.c += 1;
    TroopFileProtoReqMgr.a(this.this$0).put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_Bbva);
    this.this$0.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequestRunnable
 * JD-Core Version:    0.7.0.1
 */