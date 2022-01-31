package com.tencent.mobileqq.troop.filemanager;

import ajmn;
import ayrp;
import ayrq;
import aysb;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class TroopFileProtoReqMgr$ProtoRequestRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  ayrq jdField_a_of_type_Ayrq;
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
    aysb.c("TroopFileProtoReqMgr", aysb.a, "cookie<" + this.jdField_a_of_type_Ayrq.jdField_a_of_type_Ayrp.jdField_b_of_type_Long + "> sendToMsf. scheduleIndex:" + i + " timeOut:" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("timeout", this.jdField_a_of_type_Long);
    ajmn localajmn = this.jdField_a_of_type_Ayrq.jdField_a_of_type_Ajmn;
    localajmn.c += 1;
    TroopFileProtoReqMgr.a(this.this$0).put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_Ayrq);
    this.this$0.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequestRunnable
 * JD-Core Version:    0.7.0.1
 */