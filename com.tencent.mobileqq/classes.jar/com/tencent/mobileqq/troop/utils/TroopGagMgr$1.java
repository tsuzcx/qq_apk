package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import java.util.ArrayList;

class TroopGagMgr$1
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = this.this$0.a(this.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopGagMgr.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr.1
 * JD-Core Version:    0.7.0.1
 */