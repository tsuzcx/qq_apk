package com.tencent.mobileqq.troop.utils;

import awgf;
import bclu;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopAppMgr$5
  implements Runnable
{
  public TroopAppMgr$5(bclu parambclu, ArrayList paramArrayList, awgf paramawgf) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      this.this$0.a(this.jdField_a_of_type_Awgf, localTroopAIOAppInfo);
    }
    this.jdField_a_of_type_Awgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.5
 * JD-Core Version:    0.7.0.1
 */