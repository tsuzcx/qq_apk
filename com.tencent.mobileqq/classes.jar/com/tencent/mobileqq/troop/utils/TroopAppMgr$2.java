package com.tencent.mobileqq.troop.utils;

import awbw;
import bchl;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAppMgr$2
  implements Runnable
{
  public TroopAppMgr$2(bchl parambchl, awbw paramawbw, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_Awbw.a(TroopAIOAppInfo.class);
      this.this$0.a(".troop.troop_appVASH", "before updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      this.this$0.a(this.jdField_a_of_type_Awbw, localTroopAIOAppInfo);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_Awbw.a(TroopAIOAppInfo.class);
      this.this$0.a(".troop.troop_appVASH", "after updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    this.jdField_a_of_type_Awbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.2
 * JD-Core Version:    0.7.0.1
 */