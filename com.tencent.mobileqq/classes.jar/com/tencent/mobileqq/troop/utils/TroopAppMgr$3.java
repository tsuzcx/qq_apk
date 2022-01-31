package com.tencent.mobileqq.troop.utils;

import awge;
import awgf;
import awhf;
import bclu;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAppMgr$3
  implements Runnable
{
  public TroopAppMgr$3(bclu parambclu, ArrayList paramArrayList, awgf paramawgf, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Object localObject1 = awhf.b(TroopAIOAppInfo.class);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_Awgf.a(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "before delete type:" + this.jdField_a_of_type_Int, (List)localObject2);
      }
      this.jdField_a_of_type_Awgf.a((String)localObject1, "groupType=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_Awgf.a(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "before update after delete type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        ((TroopAIOAppInfo)localObject2).setStatus(1000);
        this.this$0.a(this.jdField_a_of_type_Awgf, (awge)localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_Awgf.a(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "after update type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
    }
    this.jdField_a_of_type_Awgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.3
 * JD-Core Version:    0.7.0.1
 */